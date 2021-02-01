package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.data.AlaFeedDiversionData;
import com.baidu.live.data.AlaFrequencyData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class o {
    private static int startEveryLive = 0;
    private static int everyDayUser = 0;
    private static int everyDayDevice = 0;
    private static int deviceNotClick = 0;
    private static boolean bNQ = false;
    private static HashMap<Long, Integer> bNR = new HashMap<>();

    private static void init() {
        if (com.baidu.live.ae.a.Qj().buX.aNb != null) {
            AlaFeedDiversionData alaFeedDiversionData = com.baidu.live.ae.a.Qj().buX.aNb;
            if (alaFeedDiversionData.frequencyData != null) {
                AlaFrequencyData alaFrequencyData = alaFeedDiversionData.frequencyData;
                startEveryLive = alaFrequencyData.startEveryLive;
                everyDayUser = alaFrequencyData.everyDayUser;
                everyDayDevice = alaFrequencyData.everyDayDevice;
                deviceNotClick = alaFrequencyData.deviceNotClick;
            }
        }
    }

    private static boolean bx(long j) {
        if (startEveryLive <= 0) {
            init();
        }
        if (startEveryLive <= 0) {
            return false;
        }
        if (bNR.containsKey(Long.valueOf(j)) && bNR.get(Long.valueOf(j)).intValue() >= startEveryLive) {
            return false;
        }
        return true;
    }

    private static boolean Vr() {
        if (everyDayUser <= 0 || everyDayDevice <= 0) {
            init();
        }
        JSONObject optJSONObject = Vt().optJSONObject(k.b(new Date()));
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        return ((currentAccountId > 0L ? 1 : (currentAccountId == 0L ? 0 : -1)) > 0 ? optJSONObject.optInt(new StringBuilder().append("uid_").append(currentAccountId).toString()) : 0) < everyDayUser && optJSONObject.optInt("dev") < everyDayDevice;
    }

    private static boolean Vs() {
        if (deviceNotClick <= 0) {
            init();
        }
        return com.baidu.live.d.xc().getInt("feed_diversion_noclick_frequency", 0) < deviceNotClick;
    }

    public static void by(long j) {
        Integer num = 0;
        if (bNR.containsKey(Long.valueOf(j))) {
            num = bNR.get(Long.valueOf(j));
        }
        bNR.put(Long.valueOf(j), Integer.valueOf(num.intValue() + 1));
        JSONObject Vt = Vt();
        String b2 = k.b(new Date());
        JSONObject optJSONObject = Vt.optJSONObject(b2);
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
            jSONObject.put(b2, optJSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.baidu.live.d.xc().putString("feed_diversion_show_frequency", jSONObject.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static JSONObject Vt() {
        JSONObject jSONObject;
        String string = com.baidu.live.d.xc().getString("feed_diversion_show_frequency", "");
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

    public static void dt(boolean z) {
        com.baidu.live.d.xc().putInt("feed_diversion_noclick_frequency", z ? 0 : com.baidu.live.d.xc().getInt("feed_diversion_noclick_frequency", 0) + 1);
    }

    public static boolean bz(long j) {
        boolean bx;
        if (!bNQ && (bx = bx(j))) {
            bNQ = (Vr() && Vs()) ? false : true;
            return bx & (bNQ ? false : true);
        }
        return false;
    }
}
