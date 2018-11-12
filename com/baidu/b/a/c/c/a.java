package com.baidu.b.a.c.c;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.b.a.f.a.a aVar, List<com.baidu.b.a.b.c.a> list) {
        JSONObject rH = aVar.rH();
        JSONObject rI = aVar.rI();
        for (com.baidu.b.a.b.c.a aVar2 : list) {
            if (!TextUtils.isEmpty(aVar2.getChannelName())) {
                JSONArray optJSONArray = rH.optJSONArray(aVar2.getChannelName());
                JSONArray optJSONArray2 = rI.optJSONArray(aVar2.getChannelName());
                if (optJSONArray != null) {
                    aVar2.onReceiveItems(optJSONArray, optJSONArray2);
                }
            }
        }
    }
}
