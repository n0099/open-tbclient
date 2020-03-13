package com.baidu.live.im;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {
    public static List<a> a(com.baidu.g.a.b.a.c cVar) {
        switch (JavaTypesHelper.toInt(cVar.type, 0)) {
            case 0:
                return c(cVar);
            case 1:
            case 2:
            case 3:
            case 100:
            case 103:
            case 104:
            case 105:
            case 106:
            case 1001:
            default:
                return null;
            case 101:
                return d(cVar);
            case 102:
                return e(cVar);
            case 107:
                return b(cVar);
            case 108:
                return b(cVar);
        }
    }

    private static final List<a> b(com.baidu.g.a.b.a.c cVar) {
        int i = cVar.aHW.aIj;
        String str = cVar.aHW.aIk;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("msg_info_list");
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    a aVar = new a();
                    if (aVar.t(optJSONObject)) {
                        arrayList.add(aVar);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static final List<a> c(com.baidu.g.a.b.a.c cVar) {
        String str = cVar.aHX;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("msg_info_list");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    a aVar = new a();
                    if (aVar.t(optJSONObject)) {
                        arrayList.add(aVar);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static final List<a> d(com.baidu.g.a.b.a.c cVar) {
        int i = cVar.aHW.feedback;
        ArrayList arrayList = new ArrayList();
        if (i > 0) {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("zan_count", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aVar.setContent(jSONObject.toString());
            aVar.setMsgType(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
            aVar.setUserId(JavaTypesHelper.toLong(cVar.uid, 0L));
            aVar.setBornTime(cVar.time);
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private static final List<a> e(com.baidu.g.a.b.a.c cVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar != null && cVar.aHW != null) {
            String str = cVar.aHW.aIl;
            if (!TextUtils.isEmpty(str)) {
                a aVar = new a();
                aVar.setContent(str);
                try {
                    aVar.setObjContent(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar.setMsgType(13);
                aVar.setUserId(JavaTypesHelper.toLong(cVar.uid, 0L));
                aVar.setBornTime(cVar.time);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
