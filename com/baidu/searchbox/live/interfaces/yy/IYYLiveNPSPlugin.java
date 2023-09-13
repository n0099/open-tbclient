package com.baidu.searchbox.live.interfaces.yy;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.live.host2live.video.ILiveActInterface;
import com.baidu.searchbox.live.host2live.video.ILiveToListInvokeAbility;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveLoadStatusCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveYYMixEntry;
import com.baidu.searchbox.live.interfaces.payment.IPaymentLogDelegate;
import com.baidu.searchbox.live.interfaces.payment.IPaymentStateCallback;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IYYLiveNPSPlugin {
    public static final String YY_ENV_CREATE_LIVE = "create_live";
    public static final String YY_ENV_ENTRANCE_PRE_INSTALL = "entrance_pre_install";
    public static final String YY_ENV_MINILIB_INIT = "minilib_init";
    public static final String YY_ENV_MINILIB_PRE_INIT = "minilib_pre_init";

    /* loaded from: classes4.dex */
    public static class Empty implements IYYLiveNPSPlugin {
        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void cancelLoad() {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void cancelStartYYLiveActivity() {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void clearLiveResourceSize(Context context) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void dispatchHostEvent(Context context, String str, Map<String, Object> map) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void dispatchYYLiveRouter(Context context, String str) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void dispatchYYRawLiveRouter(Context context, String str) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public ILiveActInterface getLiveActInterface(@NonNull Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility) {
            return null;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void getLiveResourceSize(Context context, ILiveFileSizeCallback iLiveFileSizeCallback) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public ILiveYYMixEntry getLiveYYMixEntry() {
            return null;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public boolean isAvailable() {
            return false;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public boolean isEnvReady(String str) {
            return false;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public boolean isLoaded() {
            return false;
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void loadPlugin(@NonNull Context context, LiveLoadStatusCallback liveLoadStatusCallback) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void prepareYYEnv(String str, YYEnvResultCallback yYEnvResultCallback) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void releasePayment(Map<String, Object> map) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void reportNotify(String str, JSONObject jSONObject) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map<String, String> map, Map<String, Object> map2) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startYYActivity(@NonNull Context context) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startYYCustomerServiceActivity(Context context, String str) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startYYFeedbackActivity(Context context, String str) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void startYYLiveActivity(Context context, String str) {
        }

        @Override // com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin
        public void updateStatInfo(YYStatInfo yYStatInfo) {
        }
    }

    void cancelLoad();

    void cancelStartYYLiveActivity();

    @Deprecated
    void clearLiveResourceSize(Context context);

    void dispatchHostEvent(Context context, String str, Map<String, Object> map);

    void dispatchYYLiveRouter(Context context, String str);

    void dispatchYYRawLiveRouter(Context context, String str);

    ILiveActInterface getLiveActInterface(@NonNull Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility);

    @Deprecated
    void getLiveResourceSize(Context context, ILiveFileSizeCallback iLiveFileSizeCallback);

    ILiveYYMixEntry getLiveYYMixEntry();

    boolean isAvailable();

    boolean isEnvReady(String str);

    boolean isLoaded();

    void loadPlugin(@NonNull Context context, LiveLoadStatusCallback liveLoadStatusCallback);

    void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback);

    void prepareYYEnv(String str, YYEnvResultCallback yYEnvResultCallback);

    void releasePayment(Map<String, Object> map);

    void reportNotify(@NonNull String str, @NonNull JSONObject jSONObject);

    void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map<String, String> map, Map<String, Object> map2);

    void startYYActivity(@NonNull Context context);

    void startYYCustomerServiceActivity(Context context, String str);

    void startYYFeedbackActivity(Context context, String str);

    void startYYLiveActivity(Context context, String str);

    void updateStatInfo(YYStatInfo yYStatInfo);
}
