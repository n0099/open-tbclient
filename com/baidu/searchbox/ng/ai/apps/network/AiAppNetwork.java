package com.baidu.searchbox.ng.ai.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.ng.ai.apps.network.interceptor.AiAppUserAgentInterceptor;
import com.baidu.searchbox.ng.ai.apps.runtime.Ability;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.AiAppComponent;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public class AiAppNetwork extends AiAppComponent implements Ability {
    protected static final boolean DEBUG = false;
    private OkHttpClient mHttpClient;
    private MobilePhoneStateListener mMobilePhoneListener;
    private NetworkBroadcastReceiver mNetworkStateReceiver;
    private TelephonyManager mTelMgr;

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean available() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean enable() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public void disable() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean enabled() {
        return true;
    }

    public AiAppNetwork(AiApp aiApp) {
        super(aiApp);
    }

    public void call(Request request, Callback callback) {
        getHttpClient().newCall(request).enqueue(callback);
    }

    public void call(Request request, Interceptor interceptor, Callback callback) {
        getHttpClient().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient.Builder getBuilder() {
        return getHttpClient().newBuilder();
    }

    public OkHttpClient getHttpClient() {
        AiAppsConfigData config = requireAiApp().getConfig();
        if (this.mHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (config != null && config.mNetworkConfig != null) {
                builder.connectTimeout(config.mNetworkConfig.mConnectSocketMs, TimeUnit.MILLISECONDS);
                builder.readTimeout(config.mNetworkConfig.mRequestMs, TimeUnit.MILLISECONDS);
                builder.writeTimeout(config.mNetworkConfig.mRequestMs, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new AiAppUserAgentInterceptor());
            }
            this.mHttpClient = builder.build();
        }
        this.mHttpClient.dispatcher().setMaxRequests(10);
        return this.mHttpClient;
    }

    public void registerNetworkBroadcast(CallbackHandler callbackHandler, String str) {
        if (this.mNetworkStateReceiver == null) {
            this.mNetworkStateReceiver = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.mNetworkStateReceiver, intentFilter);
        } else if (this.mNetworkStateReceiver != null) {
            this.mNetworkStateReceiver.updateCallback(callbackHandler, str);
        }
        regDataConnChangeListener(callbackHandler, str);
    }

    public void regDataConnChangeListener(CallbackHandler callbackHandler, String str) {
        if (this.mTelMgr == null) {
            this.mTelMgr = (TelephonyManager) getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.mMobilePhoneListener = new MobilePhoneStateListener(callbackHandler, str);
            this.mTelMgr.listen(this.mMobilePhoneListener, 64);
        } else if (this.mMobilePhoneListener != null) {
            this.mMobilePhoneListener.updateCallback(callbackHandler, str);
        }
    }

    public void unRegDataConnChangeListener() {
        if (this.mTelMgr != null && this.mMobilePhoneListener != null) {
            this.mTelMgr.listen(this.mMobilePhoneListener, 0);
        }
    }

    public void unRegisterNetworkBroadcast() {
        if (this.mNetworkStateReceiver != null) {
            unregisterReceiver(this.mNetworkStateReceiver);
        }
        unRegDataConnChangeListener();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class MobilePhoneStateListener extends PhoneStateListener {
        private WeakReference<CallbackHandler> mHandlerWeakRef;
        private String mNetworkCallback;
        private String oldType = "";

        public MobilePhoneStateListener(CallbackHandler callbackHandler, String str) {
            this.mHandlerWeakRef = new WeakReference<>(callbackHandler);
            this.mNetworkCallback = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.mHandlerWeakRef = new WeakReference<>(callbackHandler);
            this.mNetworkCallback = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (2 == i) {
                String mobileNetworkType = AiAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.oldType)) {
                    this.oldType = mobileNetworkType;
                    AiAppNetworkUtils.notifyNetworkStatus(AiAppNetwork.this, this.mHandlerWeakRef.get(), this.mNetworkCallback);
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.AiAppComponent
    public void onDestory() {
        super.onDestory();
        unRegisterNetworkBroadcast();
    }
}
