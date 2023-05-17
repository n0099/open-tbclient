package com.baidu.searchbox.download.center.clearcache;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManagerCommandListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "Landroid/content/Context;", "context", "", "module", "action", "Lcom/baidu/searchbox/net/update/CommandPostData;", "postData", "", "addPostData", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/net/update/CommandPostData;)V", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "value", "", "executeCommand", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/net/update/v2/ActionData;)Z", "getLocalVersion", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "Companion", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@UpdateAction(action = DiskManagerCommandListener.DISK_MONITOR_ACTION, module = "clearCache")
/* loaded from: classes3.dex */
public final class DiskManagerCommandListener extends JSONObjectCommandListener {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_VERSION = "0";
    public static final String DISK_MONITOR_ACTION = "diskmonitor";
    public static final String DISK_MONITOR_VERSION = "disk_monitor_version";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManagerCommandListener$Companion;", "", "DEFAULT_VERSION", "Ljava/lang/String;", "DISK_MONITOR_ACTION", "DISK_MONITOR_VERSION", "<init>", "()V", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) {
        JSONObject version;
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && (version = commandPostData.getVersion()) != null) {
            version.put(DISK_MONITOR_ACTION, localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        String str3;
        JSONObject jSONObject;
        String localVersion = getLocalVersion(context, str, str2);
        if (actionData != null) {
            str3 = actionData.version;
        } else {
            str3 = null;
        }
        if (TextUtils.equals(str3, localVersion) || actionData == null || (jSONObject = actionData.data) == null) {
            return false;
        }
        DiskLevelUpdateDataUtils.INSTANCE.saveData(jSONObject);
        PreferenceUtils.setString("disk_monitor_version", actionData.version);
        return true;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        String string = PreferenceUtils.getString("disk_monitor_version", "0");
        Intrinsics.checkNotNullExpressionValue(string, "PreferenceUtils.getStrin…VERSION, DEFAULT_VERSION)");
        return string;
    }
}
