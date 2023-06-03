package com.baidu.searchbox.download.apkcheck;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/download/apkcheck/ApkCheckTimeoutCommandListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "Companion", "lib-download_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UpdateAction(action = ApkCheckTimeoutCommandListener.ACTION, module = "download")
/* loaded from: classes3.dex */
public final class ApkCheckTimeoutCommandListener extends JSONObjectCommandListener {
    public static final String ACTION = "apk_check_timeout";
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_VERSION = "0";
    public static final String PARAM_INTERVAL = "apk_check_timeout_ms";
    public static final String VERSION = "apk_check_timeout_v";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/download/apkcheck/ApkCheckTimeoutCommandListener$Companion;", "", "()V", "ACTION", "", "DEFAULT_VERSION", "PARAM_INTERVAL", "VERSION", "lib-download_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) {
        JSONObject version;
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && (version = commandPostData.getVersion()) != null) {
            version.put(ACTION, localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        JSONObject jSONObject;
        if (actionData != null) {
            jSONObject = actionData.data;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null && TextUtils.equals(str2, ACTION)) {
            String localVersion = getLocalVersion(context, str, str2);
            if (!TextUtils.isEmpty(actionData.version) && !TextUtils.equals(actionData.version, localVersion)) {
                int optInt = jSONObject.optInt(PARAM_INTERVAL);
                if (optInt > 0) {
                    DownloadSharedPrefsUtils.getInstance().putInt(DownloadCenterUtils.SHOW_APK_CHECK_REQUEST_INTERVAL, optInt);
                } else {
                    DownloadSharedPrefsUtils.getInstance().remove(DownloadCenterUtils.SHOW_APK_CHECK_REQUEST_INTERVAL);
                }
                DownloadSharedPrefsUtils.getInstance().putString(VERSION, actionData.version);
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        String string = DownloadSharedPrefsUtils.getInstance().getString(VERSION, "0");
        if (string == null) {
            return "0";
        }
        return string;
    }
}
