package com.baidu.searchbox.ng.ai.apps.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.process.binder.BinderStatusHelper;
import com.baidu.searchbox.ng.ai.apps.swancore.model.SwanCoreVersion;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class AiAppsMessengerClient {
    private static final boolean DEBUG = false;
    public static final String MSG_BUNDLE_APP_ID_KEY = "ai_apps_id";
    public static final String MSG_BUNDLE_DATA_KEY = "ai_apps_data";
    private static final String TAG = "AiAppsMessengerClient";
    private AiAppsServiceBindInfo mBindInfo;
    private Context mContext;
    private boolean mIsBound;
    private Messenger mService;
    private OnServiceStatusCallback mServiceCallback;
    private AiAppsClientHandler mClientHandler = new AiAppsClientHandler();
    private Messenger mMessenger = new Messenger(this.mClientHandler);
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AiAppsMessengerClient.this.mService = new Messenger(iBinder);
            AiAppsMessengerClient.this.registServiceBinderCallback(iBinder);
            AiAppsMessengerClient.this.sendMessage(1, AiAppsMessengerClient.this.mBindInfo.swanCoreVersion);
            if (AiAppsMessengerClient.this.mServiceCallback != null) {
                AiAppsMessengerClient.this.mServiceCallback.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AiAppsMessengerClient.this.mService = null;
            AiAppsMessengerClient.this.sendMessage(2);
            if (AiAppsMessengerClient.this.mServiceCallback != null) {
                AiAppsMessengerClient.this.mServiceCallback.onServiceDisconnected(componentName);
            }
        }
    };

    /* loaded from: classes2.dex */
    public static class AiAppsServiceBindInfo {
        public String appId;
        public int processId;
        public SwanCoreVersion swanCoreVersion;
    }

    /* loaded from: classes2.dex */
    public interface OnHandleMessageCallback {
        boolean onHandleMessage(Message message);
    }

    /* loaded from: classes2.dex */
    public interface OnServiceStatusCallback {
        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);
    }

    public void bindService(Context context, AiAppsServiceBindInfo aiAppsServiceBindInfo, OnServiceStatusCallback onServiceStatusCallback, OnHandleMessageCallback onHandleMessageCallback) {
        this.mContext = context;
        this.mBindInfo = aiAppsServiceBindInfo;
        this.mServiceCallback = onServiceStatusCallback;
        this.mClientHandler.setMessageCallback(onHandleMessageCallback);
        doBindService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doBindService() {
        this.mIsBound = true;
        this.mContext.bindService(new Intent(this.mContext, AiAppsMessengerService.class), this.mConnection, 1);
    }

    public void unbindService(Context context) {
        if (this.mIsBound) {
            sendMessage(2);
            context.unbindService(this.mConnection);
            this.mIsBound = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registServiceBinderCallback(IBinder iBinder) {
        if (iBinder != null) {
            BinderStatusHelper.listenBinderStatus(iBinder, new BinderStatusHelper.BinderStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient.1
                @Override // com.baidu.searchbox.ng.ai.apps.process.binder.BinderStatusHelper.BinderStatusCallback
                public void onBinderGone() {
                    AiAppsMessengerClient.this.doBindService();
                }
            });
        }
    }

    public void sendMessage(int i) {
        sendMessage(i, "");
    }

    public void sendMessage(int i, String str) {
        if (this.mService != null && this.mMessenger != null) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.replyTo = this.mMessenger;
            obtain.arg1 = this.mBindInfo.processId;
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("ai_apps_data", str);
            }
            bundle.putString(MSG_BUNDLE_APP_ID_KEY, this.mBindInfo.appId);
            obtain.obj = bundle;
            try {
                this.mService.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    public void sendMessage(int i, AiAppsIPCData aiAppsIPCData) {
        if (this.mService != null && this.mMessenger != null) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.replyTo = this.mMessenger;
            obtain.arg1 = this.mBindInfo.processId;
            Bundle bundle = new Bundle();
            if (aiAppsIPCData != null) {
                bundle.putParcelable("ai_apps_data", aiAppsIPCData);
            }
            bundle.putString(MSG_BUNDLE_APP_ID_KEY, this.mBindInfo.appId);
            obtain.obj = bundle;
            try {
                this.mService.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    public String getAppId() {
        return this.mBindInfo == null ? "" : this.mBindInfo.appId;
    }

    /* loaded from: classes2.dex */
    private static class AiAppsClientHandler extends Handler {
        private WeakReference<OnHandleMessageCallback> mCallbackRef;

        private AiAppsClientHandler() {
        }

        public void setMessageCallback(OnHandleMessageCallback onHandleMessageCallback) {
            this.mCallbackRef = new WeakReference<>(onHandleMessageCallback);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OnHandleMessageCallback onHandleMessageCallback = this.mCallbackRef != null ? this.mCallbackRef.get() : null;
            if (onHandleMessageCallback == null || !onHandleMessageCallback.onHandleMessage(message)) {
                super.handleMessage(message);
            }
        }
    }
}
