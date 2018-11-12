package com.baidu.searchbox.ng.ai.apps.process;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.channel.im.AiAppImClientManager;
import com.baidu.searchbox.ng.ai.apps.core.aps.subpackage.GetSubPackageHelper;
import com.baidu.searchbox.ng.ai.apps.env.AiAppEnv;
import com.baidu.searchbox.ng.ai.apps.env.Purger;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.pay.AiAppsWxPayLaunchMsg;
import com.baidu.searchbox.ng.ai.apps.process.binder.BinderStatusHelper;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.swancore.model.SwanCoreVersion;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public final class AiAppsMessengerService extends Service {
    private static final boolean DEBUG = false;
    public static final int MSG_TYPE_CS_DELETE_AIAPP = 8;
    public static final int MSG_TYPE_CS_GET_DATA = 3;
    public static final int MSG_TYPE_CS_GET_SUB_PACKAGE = 6;
    public static final int MSG_TYPE_CS_IM_PULL_MSG = 204;
    public static final int MSG_TYPE_CS_IM_REGISTER = 201;
    public static final int MSG_TYPE_CS_IM_SEND_MSG = 203;
    public static final int MSG_TYPE_CS_IM_UNREGISTER = 202;
    public static final int MSG_TYPE_CS_NIGHT_MODE_CHANGED = 5;
    public static final int MSG_TYPE_CS_ON_APP_FOREGROUND = 9;
    public static final int MSG_TYPE_CS_REGISTER = 1;
    public static final int MSG_TYPE_CS_RESPONSE = 4;
    public static final int MSG_TYPE_CS_UNREGISTER = 2;
    public static final int MSG_TYPE_CS_WX_PAY_APPID = 7;
    public static final int MSG_TYPE_SC_ACCOUNT_LOGIN = 103;
    public static final int MSG_TYPE_SC_ACCOUNT_LOGOUT = 100;
    public static final int MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED = 104;
    public static final int MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS = 105;
    public static final int MSG_TYPE_SC_IM_PULL_MSG_CALLBACK = 213;
    public static final int MSG_TYPE_SC_IM_REGISTER_CALLBACK = 211;
    public static final int MSG_TYPE_SC_IM_SEND_MSG_CALLBACK = 212;
    public static final int MSG_TYPE_SC_NIGHT_MODE_CHANGED = 102;
    public static final int MSG_TYPE_SC_RESET = 106;
    public static final int MSG_TYPE_SC_RETURN_DATA = 101;
    private static final String TAG = "AiAppsMessengerService";
    private static AiAppsMessengerService sServiceObject;
    private AiAppsServiceHandler mHandler = new AiAppsServiceHandler(this);
    private final Messenger mMessenger = new Messenger(this.mHandler);
    private LinkedHashMap<Integer, AiAppsClientObject> mClientsMap = new LinkedHashMap<>();

    /* loaded from: classes2.dex */
    public static class AiAppsClientObject {
        public String mAppId;
        public Messenger mMessenger;
        public int mProcessId;
        public SwanCoreVersion mSwanCoreVersion;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        sServiceObject = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        sServiceObject = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    public static AiAppsMessengerService getServiceObject() {
        return sServiceObject;
    }

    public LinkedHashMap<Integer, AiAppsClientObject> getAllClientObjects() {
        return (LinkedHashMap) this.mClientsMap.clone();
    }

    public void lruResortClient(int i) {
        AiAppsClientObject remove = this.mClientsMap.remove(Integer.valueOf(i));
        if (remove != null) {
            this.mClientsMap.put(Integer.valueOf(i), remove);
        }
    }

    /* loaded from: classes2.dex */
    private static class AiAppsServiceHandler extends Handler {
        private WeakReference<AiAppsMessengerService> mServiceRef;

        public AiAppsServiceHandler(AiAppsMessengerService aiAppsMessengerService) {
            this.mServiceRef = null;
            this.mServiceRef = new WeakReference<>(aiAppsMessengerService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Purger purger;
            AiAppsMessengerService aiAppsMessengerService = this.mServiceRef != null ? this.mServiceRef.get() : null;
            if (aiAppsMessengerService != null) {
                switch (message.what) {
                    case 1:
                        Bundle bundle = (Bundle) message.obj;
                        if (bundle != null) {
                            AiAppsClientObject aiAppsClientObject = new AiAppsClientObject();
                            bundle.setClassLoader(getClass().getClassLoader());
                            aiAppsClientObject.mProcessId = message.arg1;
                            aiAppsClientObject.mAppId = bundle.getString(AiAppsMessengerClient.MSG_BUNDLE_APP_ID_KEY);
                            aiAppsClientObject.mSwanCoreVersion = (SwanCoreVersion) bundle.getParcelable("ai_apps_data");
                            aiAppsClientObject.mMessenger = message.replyTo;
                            try {
                                aiAppsMessengerService.mClientsMap.put(Integer.valueOf(message.arg1), aiAppsClientObject);
                                aiAppsMessengerService.registClientBinderCallback(aiAppsClientObject);
                                return;
                            } catch (NullPointerException e) {
                                return;
                            }
                        }
                        return;
                    case 2:
                        Bundle bundle2 = (Bundle) message.obj;
                        if (bundle2 != null && AiAppImClientManager.getIns().clearAllCallbackDispatcher(bundle2.getString(AiAppsMessengerClient.MSG_BUNDLE_APP_ID_KEY))) {
                            AiAppsRuntime.getIMRuntime().unregister(null);
                        }
                        aiAppsMessengerService.mClientsMap.remove(Integer.valueOf(message.arg1));
                        return;
                    case 3:
                        aiAppsMessengerService.sendMessageToClient(message.arg1, 101);
                        return;
                    case 4:
                        return;
                    case 5:
                        AiAppNightModeHelper.forceSyncNightModeState(AiAppNightModeHelper.getNightModeSwitcherState());
                        aiAppsMessengerService.sendMessageToAllClients(102, message.arg1);
                        return;
                    case 6:
                        Bundle bundle3 = (Bundle) message.obj;
                        bundle3.setClassLoader(getClass().getClassLoader());
                        GetSubPackageHelper.processGetSubPackageMessage((SubPackageAPSInfo) bundle3.getParcelable("ai_apps_data"), message.arg1);
                        return;
                    case 7:
                        Bundle bundle4 = (Bundle) message.obj;
                        if (bundle4 != null) {
                            AiAppsWxPayLaunchMsg.wx_appid = bundle4.getString(AiAppsMessengerClient.MSG_BUNDLE_APP_ID_KEY);
                            return;
                        }
                        return;
                    case 8:
                        Bundle bundle5 = (Bundle) message.obj;
                        if (bundle5 != null) {
                            String string = bundle5.getString("ai_apps_data", "");
                            if (!TextUtils.isEmpty(string) && (purger = AiAppEnv.get().getPurger()) != null) {
                                purger.deleteAiApp(string);
                                return;
                            }
                            return;
                        }
                        return;
                    case 9:
                        aiAppsMessengerService.lruResortClient(message.arg1);
                        return;
                    case 201:
                        AiAppsRuntime.getIMRuntime().register(message.obj);
                        return;
                    case 202:
                        AiAppsRuntime.getIMRuntime().unregister(message.obj);
                        return;
                    case 203:
                        AiAppsRuntime.getIMRuntime().sendMsg(message.obj);
                        return;
                    case 204:
                        AiAppsRuntime.getIMRuntime().pullMsg(message.obj);
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registClientBinderCallback(final AiAppsClientObject aiAppsClientObject) {
        if (aiAppsClientObject != null && aiAppsClientObject.mMessenger != null) {
            BinderStatusHelper.listenBinderStatus(aiAppsClientObject.mMessenger.getBinder(), new BinderStatusHelper.BinderStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerService.1
                @Override // com.baidu.searchbox.ng.ai.apps.process.binder.BinderStatusHelper.BinderStatusCallback
                public void onBinderGone() {
                    AiAppsMessengerService.this.mClientsMap.remove(Integer.valueOf(aiAppsClientObject.mProcessId));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendMessageToClient(int i, int i2) {
        Messenger messenger;
        AiAppsClientObject aiAppsClientObject = this.mClientsMap.get(Integer.valueOf(i));
        if (aiAppsClientObject != null && (messenger = aiAppsClientObject.mMessenger) != null) {
            try {
                messenger.send(Message.obtain(null, i2, generateMessageData(i2)));
                return true;
            } catch (RemoteException e) {
                this.mClientsMap.remove(Integer.valueOf(i));
                return false;
            }
        }
        return false;
    }

    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        Messenger messenger;
        AiAppsClientObject aiAppsClientObject = this.mClientsMap.get(Integer.valueOf(i));
        if (aiAppsClientObject != null && (messenger = aiAppsClientObject.mMessenger) != null) {
            try {
                messenger.send(Message.obtain(null, i2, bundle));
                return true;
            } catch (RemoteException e) {
                this.mClientsMap.remove(Integer.valueOf(i));
                return false;
            }
        }
        return false;
    }

    public boolean sendMessageWithDataToAllClient(int i, String str) {
        Messenger messenger;
        for (Integer num : this.mClientsMap.keySet()) {
            int intValue = num.intValue();
            AiAppsClientObject aiAppsClientObject = this.mClientsMap.get(Integer.valueOf(intValue));
            if (aiAppsClientObject != null && (messenger = aiAppsClientObject.mMessenger) != null) {
                Bundle generateMessageData = generateMessageData(i);
                generateMessageData.putString("ai_apps_data", str);
                try {
                    messenger.send(Message.obtain(null, i, generateMessageData));
                } catch (RemoteException e) {
                    this.mClientsMap.remove(Integer.valueOf(intValue));
                    return false;
                }
            }
        }
        return true;
    }

    public boolean sendMessageToAllClients(int i) {
        return sendMessageToAllClients(i, null);
    }

    public boolean sendMessageToAllClients(int i, int... iArr) {
        boolean z = true;
        for (Integer num : this.mClientsMap.keySet()) {
            int intValue = num.intValue();
            if (!isIgnoredClient(intValue, iArr)) {
                z = !sendMessageToClient(intValue, i) ? false : z;
            }
        }
        return z;
    }

    private boolean isIgnoredClient(int i, int... iArr) {
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private Bundle generateMessageData(int i) {
        Bundle bundle = new Bundle();
        switch (i) {
            case 100:
            case 101:
            case 102:
            default:
                return bundle;
        }
    }
}
