package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.data.AlaFeedDiversionData;
import com.baidu.live.data.AlaFrequencyData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    private static int startEveryLive = 0;
    private static int everyDayUser = 0;
    private static int everyDayDevice = 0;
    private static int deviceNotClick = 0;
    private static boolean aDM = false;
    private static HashMap<Long, Integer> aDN = new HashMap<>();

    private static void init() {
        if (com.baidu.live.v.a.zl().awC.aaU != null) {
            AlaFeedDiversionData alaFeedDiversionData = com.baidu.live.v.a.zl().awC.aaU;
            if (alaFeedDiversionData.frequencyData != null) {
                AlaFrequencyData alaFrequencyData = alaFeedDiversionData.frequencyData;
                startEveryLive = alaFrequencyData.startEveryLive;
                everyDayUser = alaFrequencyData.everyDayUser;
                everyDayDevice = alaFrequencyData.everyDayDevice;
                deviceNotClick = alaFrequencyData.deviceNotClick;
            }
        }
    }

    private static boolean O(long j) {
        if (startEveryLive <= 0) {
            init();
        }
        if (startEveryLive <= 0) {
            return false;
        }
        if (aDN.containsKey(Long.valueOf(j)) && aDN.get(Long.valueOf(j)).intValue() >= startEveryLive) {
            return false;
        }
        return true;
    }

    private static boolean Bd() {
        if (everyDayUser <= 0 || everyDayDevice <= 0) {
            init();
        }
        JSONObject optJSONObject = Bf().optJSONObject(j.b(new Date()));
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        return ((currentAccountId > 0L ? 1 : (currentAccountId == 0L ? 0 : -1)) > 0 ? optJSONObject.optInt(new StringBuilder().append("uid_").append(currentAccountId).toString()) : 0) < everyDayUser && optJSONObject.optInt("dev") < everyDayDevice;
    }

    private static boolean Be() {
        if (deviceNotClick <= 0) {
            init();
        }
        return com.baidu.live.c.pr().getInt("feed_diversion_noclick_frequency", 0) < deviceNotClick;
    }

    public static void P(long j) {
        Integer num = 0;
        if (aDN.containsKey(Long.valueOf(j))) {
            num = aDN.get(Long.valueOf(j));
        }
        aDN.put(Long.valueOf(j), Integer.valueOf(num.intValue() + 1));
        JSONObject Bf = Bf();
        String b = j.b(new Date());
        JSONObject optJSONObject = Bf.optJSONObject(b);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId > 0) {
            try {
                String str = "uid_" + currentAccountId;
                optJSONObject.put(str, optJSONObject.optInt(str) + 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            optJSONObject.put("dev", optJSONObject.optInt("dev") + 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b, optJSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.baidu.live.c.pr().putString("feed_diversion_show_frequency", jSONObject.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static JSONObject Bf() {
        JSONObject jSONObject;
        String string = com.baidu.live.c.pr().getString("feed_diversion_show_frequency", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null) {
                return new JSONObject();
            }
            return jSONObject;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
    }

    public static void bx(boolean z) {
        com.baidu.live.c.pr().putInt("feed_diversion_noclick_frequency", z ? 0 : com.baidu.live.c.pr().getInt("feed_diversion_noclick_frequency", 0) + 1);
    }

    public static boolean Q(long j) {
        boolean O;
        if (!aDM && (O = O(j))) {
            aDM = (Bd() && Be()) ? false : true;
            return O & (aDM ? false : true);
        }
        return false;
    }
}
