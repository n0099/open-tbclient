package com.baidu.live.sdk.goods.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.bo;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public static void J(Context context, String str) {
        Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan1 scheme=" + str);
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && boVar.aQQ != null) {
            int i = boVar.aQQ.aTv;
            Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan1 preDownload=" + i);
            if (isDebug()) {
                Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan1 debug");
                i = 1;
            }
            if (i != 1) {
                return;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            BrowserHelper.startInternalWebActivity(context, str);
            Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan1 end");
        }
    }

    public static void e(Context context, ArrayList<String> arrayList) {
        Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan2 appkeys=" + arrayList);
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && boVar.aQQ != null) {
            int i = boVar.aQQ.aTv;
            Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan2 preDownload=" + i);
            if (isDebug()) {
                Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan2 debug");
                i = 1;
            }
            if (i != 1) {
                return;
            }
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < arrayList.size()) {
                    Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan2 " + i3 + PerfFrameTrackUIUtil.SEPERATOR_ARROR + arrayList.get(i3));
                    i2 = i3 + 1;
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put(ExtraParamsManager.KEY_PRE_DOWANLOAD_SWAN, arrayList);
                    ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                    Log.i("PreDowanloadSwanHelper", "@@ preDowanloadSwan doPreDowanloadSwan2 end");
                    return;
                }
            }
        }
    }

    public static boolean isDebug() {
        HashMap hashMap = new HashMap();
        hashMap.put("test_preDowanloadSwan", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process.containsKey("test_preDowanloadSwan")) {
            return ((Boolean) process.get("test_preDowanloadSwan")).booleanValue();
        }
        return false;
    }
}
