package com.baidu.swan.apps.performance.d;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.apps.an.g;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    public static List<Pair<String, Pair<String, String>>> aGR;

    static {
        if (DEBUG) {
            aGR = new ArrayList();
            aGR.add(new Pair<>("总时长", new Pair("na_pms_start_req", "na_end_update_db")));
            aGR.add(new Pair<>("PMS信息获取时长", new Pair("na_pms_start_req", "na_pms_end_req")));
            aGR.add(new Pair<>("包下载时长", new Pair("na_pms_start_download", "na_pms_end_download")));
            aGR.add(new Pair<>("Icon下载时长", new Pair("na_pms_start_icon", "na_pms_end_icon")));
            aGR.add(new Pair<>("签名校验时长", new Pair("na_pms_start_check_sign", "na_pms_end_check_sign")));
            aGR.add(new Pair<>("包解压时长", new Pair("na_package_start_unzip", "na_package_end_unzip")));
            aGR.add(new Pair<>("包解密时长", new Pair("na_package_start_decrypt", "na_package_end_decrypt")));
            aGR.add(new Pair<>("更新数据库时长", new Pair("na_start_update_db", "na_end_update_db")));
        }
    }

    public static void a(String str, String str2, List<UbcFlowEvent> list, String str3) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            Flow kZ = s.kZ("770");
            for (UbcFlowEvent ubcFlowEvent : list) {
                if (ubcFlowEvent != null) {
                    kZ.addEvent(ubcFlowEvent.id, ubcFlowEvent.value(), ubcFlowEvent.IM());
                }
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("type", str2);
                jSONObject2.put("appid", str);
                jSONObject2.put("mobile", g.Pm());
                jSONObject2.put("net", SwanAppNetworkUtils.HR().type);
                if (TextUtils.isEmpty(str3)) {
                    str3 = "0";
                }
                jSONObject2.put(FaceBaseDTO.KEY_BUSINESS_SCENE, str3);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            kZ.setValueWithDuration(jSONObject.toString());
            kZ.end();
            a(str, list, aGR);
        }
    }

    private static void a(String str, List<UbcFlowEvent> list, List<Pair<String, Pair<String, String>>> list2) {
        if (DEBUG && list != null && list2 != null) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("小程序PMS下载耗时Log：");
            sb.append("\n").append("小程序ID：").append(str);
            sb.append("\n").append("小程序ID：").append(str);
            for (UbcFlowEvent ubcFlowEvent : list) {
                if (ubcFlowEvent != null) {
                    sb.append("\n").append(ubcFlowEvent.IM()).append(" : ").append(ubcFlowEvent.id);
                    hashMap.put(ubcFlowEvent.id, Long.valueOf(ubcFlowEvent.IM()));
                }
            }
            sb.append("\n").append("耗时计算开始：>>>>>>>>>>>>");
            for (Pair<String, Pair<String, String>> pair : list2) {
                if (pair != null) {
                    String str2 = (String) pair.first;
                    String str3 = (String) ((Pair) pair.second).first;
                    String str4 = (String) ((Pair) pair.second).second;
                    if (hashMap.get(str3) != null && hashMap.get(str4) != null) {
                        long longValue = ((Long) hashMap.get(str3)).longValue();
                        sb.append("\n").append("耗时：").append(String.format(Locale.CHINA, "%-13d", Long.valueOf(((Long) hashMap.get(str4)).longValue() - longValue))).append(" >>> ").append(str2);
                        sb.append("，计算方式：").append(str4).append(" - ").append(str3);
                    }
                }
            }
            Log.i("SwanAppPMS", sb.toString());
        }
    }
}
