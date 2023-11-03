package com.baidu.searchbox.schemedispatch.monitor;

import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppDeepLinkCheck;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfoKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J \u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/schemedispatch/monitor/OpenAppDeepLinkCheck;", "Lcom/baidu/searchbox/schemedispatch/monitor/OpenAppBaseCheck;", "Lcom/baidu/searchbox/schemedispatch/monitor/IDeepLinkCheck;", "()V", "deepLinkWhiteList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/schemedispatch/monitor/bean/SchemeCheckInfo;", "Lkotlin/collections/ArrayList;", "checkSchemeInDeepLinkWhiteList", "originScheme", "", GetUserAttrInfoResult.KEY_DATA_FIELDS, "Lcom/baidu/searchbox/schemedispatch/SchemeStatisticField;", "jsonArray2List", "deepLinkWListJson", "Lorg/json/JSONArray;", "loadDeepLinkWhiteList", "", "loadWhiteListAsync", "saveWhiteListDispatch", "", "data", "Lorg/json/JSONObject;", "updateWhiteList", "deepLinkWList", "", "lib-security-openapp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OpenAppDeepLinkCheck extends OpenAppBaseCheck implements IDeepLinkCheck {
    public final ArrayList<SchemeCheckInfo> deepLinkWhiteList = new ArrayList<>();

    private final void loadDeepLinkWhiteList() {
        if (OpenAppBaseCheck.DEBUG) {
            Log.v(OpenAppDeepLinkCheckKt.TAG, "loadDeepLinkWhiteList");
        }
        updateWhiteList(OpenAppBaseCheck.readCache(OpenAppDeepLinkCheckKt.SCHEME_DEEP_LINK_WHITE_LIST_FILENAME));
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.tieba.dj1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    OpenAppDeepLinkCheck.m106loadWhiteListAsync$lambda0(OpenAppDeepLinkCheck.this);
                }
            }
        }, "SchemeDeepLinkWhiteListLoad", 2);
    }

    private final ArrayList<String> jsonArray2List(JSONArray jSONArray) {
        boolean z;
        ArrayList<String> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String optString = jSONArray.optString(i);
            if (optString != null && optString.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    /* renamed from: loadWhiteListAsync$lambda-0  reason: not valid java name */
    public static final void m106loadWhiteListAsync$lambda0(OpenAppDeepLinkCheck this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadDeepLinkWhiteList();
        FileUtils.deleteCache(AppRuntime.getAppContext(), "scheme_deep_link_white_list");
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public boolean saveWhiteListDispatch(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray(OpenAppDeepLinkCheckKt.JSON_KEY_DEEP_LINK_WHITE_LIST);
        } else {
            jSONArray = null;
        }
        if (jSONArray == null) {
            if (OpenAppBaseCheck.DEBUG) {
                Log.v(OpenAppDeepLinkCheckKt.TAG, "warning!!! deepLink write list is empty");
                return false;
            }
            return false;
        }
        ArrayList<String> jsonArray2List = jsonArray2List(jSONArray);
        boolean writeCache = OpenAppBaseCheck.writeCache(jsonArray2List, OpenAppDeepLinkCheckKt.SCHEME_DEEP_LINK_WHITE_LIST_FILENAME);
        if (writeCache) {
            updateWhiteList(jsonArray2List);
        }
        return writeCache;
    }

    private final synchronized void updateWhiteList(List<String> list) {
        int i;
        if (OpenAppBaseCheck.DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateWhiteList deepLinkWList.size = ");
            if (list != null) {
                i = list.size();
            } else {
                i = -1;
            }
            sb.append(i);
            Log.v(OpenAppDeepLinkCheckKt.TAG, sb.toString());
        }
        this.deepLinkWhiteList.clear();
        if (list == null) {
            return;
        }
        this.deepLinkWhiteList.addAll(SchemeCheckInfoKt.toSchemeCheckInfoList(list));
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.IDeepLinkCheck
    public synchronized SchemeCheckInfo checkSchemeInDeepLinkWhiteList(String str, SchemeStatisticField schemeStatisticField) {
        SchemeCheckInfo infoInList;
        String str2;
        infoInList = OpenAppBaseCheck.getInfoInList(str, this.deepLinkWhiteList);
        if (OpenAppBaseCheck.DEBUG) {
            Log.v(OpenAppDeepLinkCheckKt.TAG, "checkSchemeInDeepLinkWhiteList isInWhitList = " + infoInList);
        }
        if (schemeStatisticField != null) {
            SchemeStatisticField addField = schemeStatisticField.addField("scheme", str).addField("enable", "1").addField("type", "clk_deeplink");
            if (OpenAppBaseCheck.canInvoke(infoInList)) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            addField.addField("invokable", str2);
            SchemeForbidStatisticUtils.onEvent(schemeStatisticField);
        }
        return infoInList;
    }
}
