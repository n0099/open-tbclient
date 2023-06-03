package com.baidu.searchbox.schemedispatch.monitor.bean;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u0001\u001a\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"NO_ALERT", "", "SHOW_ALERT", "defaultNoAlertSchemeInfo", "Lcom/baidu/searchbox/schemedispatch/monitor/bean/SchemeCheckInfo;", "scheme", "defaultSchemeCheckInfo", "toSchemeCheckInfo", "toSchemeCheckInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "lib-security-openapp_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SchemeCheckInfoKt {
    public static final String NO_ALERT = "1";
    public static final String SHOW_ALERT = "0";

    public static final SchemeCheckInfo defaultNoAlertSchemeInfo(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return new SchemeCheckInfo(scheme, "1", null);
    }

    public static final SchemeCheckInfo defaultSchemeCheckInfo(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return new SchemeCheckInfo(scheme, "0", null);
    }

    public static final ArrayList<SchemeCheckInfo> toSchemeCheckInfoList(List<String> list) {
        SchemeCheckInfo schemeCheckInfo;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList<SchemeCheckInfo> arrayList = new ArrayList<>();
        for (String str : list) {
            if (str != null && (schemeCheckInfo = toSchemeCheckInfo(str)) != null) {
                arrayList.add(schemeCheckInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SchemeCheckInfo toSchemeCheckInfo(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String scheme = jSONObject.optString("scheme");
            String noAlert = jSONObject.optString("noAlert", "0");
            String optString = jSONObject.optString("title");
            boolean z2 = false;
            if (scheme != null && scheme.length() != 0) {
                z = false;
                if (!z) {
                    if (!((noAlert == null || noAlert.length() == 0) ? true : true)) {
                        Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
                        Intrinsics.checkNotNullExpressionValue(noAlert, "noAlert");
                        return new SchemeCheckInfo(scheme, noAlert, optString);
                    }
                }
                return null;
            }
            z = true;
            if (!z) {
            }
            return null;
        } catch (JSONException unused) {
            if (AppConfig.isDebug()) {
                Log.d("SchemeCheckInfo", String.valueOf(str));
            }
            return null;
        }
    }
}
