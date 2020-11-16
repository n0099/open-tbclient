package com.baidu.live.im;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public static List<a> a(com.baidu.h.a.b.a.c cVar) {
        return a(cVar, false);
    }

    public static List<a> a(com.baidu.h.a.b.a.c cVar, boolean z) {
        int i = JavaTypesHelper.toInt(cVar.type, 0);
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ IM消息 接收: 消息类型：  " + i);
        }
        switch (i) {
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

    private static final List<a> b(com.baidu.h.a.b.a.c cVar) {
        int i = cVar.bTq.bTD;
        String str = cVar.bTq.bTE;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("msg_info_list");
                if (optJSONArray == null) {
                    return null;
                }
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    a aVar = new a();
                    if (aVar.H(optJSONObject)) {
                        if (aVar.getUserId() == 0) {
                            aVar.setUserId(JavaTypesHelper.toLong(cVar.uid, 0L));
                        }
                        if (TextUtils.isEmpty(aVar.LF().userId) || "0".equals(aVar.LF().userId)) {
                            aVar.LF().userId = String.valueOf(aVar.getUserId());
                        }
                        arrayList.add(aVar);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static final List<a> c(com.baidu.h.a.b.a.c cVar) {
        String str = cVar.bTr;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("msg_info_list");
                if (optJSONArray == null) {
                    return null;
                }
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    a aVar = new a();
                    if (aVar.H(optJSONObject)) {
                        if (aVar.getUserId() == 0) {
                            aVar.setUserId(JavaTypesHelper.toLong(cVar.uid, 0L));
                        }
                        if (TextUtils.isEmpty(aVar.LF().userId) || "0".equals(aVar.LF().userId)) {
                            aVar.LF().userId = String.valueOf(aVar.getUserId());
                        }
                        arrayList.add(aVar);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } else if (TextUtils.isEmpty(cVar.content) || TextUtils.isEmpty(cVar.name) || TextUtils.isEmpty(cVar.uid)) {
            return null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            a aVar2 = new a();
            aVar2.setMsgType(1);
            aVar2.setContent(cVar.content);
            aVar2.setUserId(JavaTypesHelper.toLong(cVar.uid, 0L));
            com.baidu.live.data.a aVar3 = new com.baidu.live.data.a();
            aVar3.userId = cVar.uid;
            aVar3.name_show = cVar.name;
            aVar3.portrait = cVar.portrait;
            aVar2.e(aVar3);
            arrayList2.add(aVar2);
            return arrayList2;
        }
    }

    private static final List<a> d(com.baidu.h.a.b.a.c cVar) {
        int i = cVar.bTq.feedback;
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

    private static final List<a> e(com.baidu.h.a.b.a.c cVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar != null && cVar.bTq != null) {
            String str = cVar.bTq.bTF;
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
