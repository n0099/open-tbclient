package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.data.AlaFeedDiversionData;
import com.baidu.live.data.AlaFrequencyData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    private static int startEveryLive = 0;
    private static int everyDayUser = 0;
    private static int everyDayDevice = 0;
    private static int deviceNotClick = 0;
    private static boolean bxu = false;
    private static HashMap<Long, Integer> bxv = new HashMap<>();

    private static void init() {
        if (com.baidu.live.x.a.OS().blo.aLG != null) {
            AlaFeedDiversionData alaFeedDiversionData = com.baidu.live.x.a.OS().blo.aLG;
            if (alaFeedDiversionData.frequencyData != null) {
                AlaFrequencyData alaFrequencyData = alaFeedDiversionData.frequencyData;
                startEveryLive = alaFrequencyData.startEveryLive;
                everyDayUser = alaFrequencyData.everyDayUser;
                everyDayDevice = alaFrequencyData.everyDayDevice;
                deviceNotClick = alaFrequencyData.deviceNotClick;
            }
        }
    }

    private static boolean ax(long j) {
        if (startEveryLive <= 0) {
            init();
        }
        if (startEveryLive <= 0) {
            return false;
        }
        if (bxv.containsKey(Long.valueOf(j)) && bxv.get(Long.valueOf(j)).intValue() >= startEveryLive) {
            return false;
        }
        return true;
    }

    private static boolean QT() {
        if (everyDayUser <= 0 || everyDayDevice <= 0) {
            init();
        }
        JSONObject optJSONObject = QV().optJSONObject(k.b(new Date()));
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        return ((currentAccountId > 0L ? 1 : (currentAccountId == 0L ? 0 : -1)) > 0 ? optJSONObject.optInt(new StringBuilder().append("uid_").append(currentAccountId).toString()) : 0) < everyDayUser && optJSONObject.optInt("dev") < everyDayDevice;
    }

    private static boolean QU() {
        if (deviceNotClick <= 0) {
            init();
        }
        return com.baidu.live.c.AZ().getInt("feed_diversion_noclick_frequency", 0) < deviceNotClick;
    }

    public static void ay(long j) {
        Integer num = 0;
        if (bxv.containsKey(Long.valueOf(j))) {
            num = bxv.get(Long.valueOf(j));
        }
        bxv.put(Long.valueOf(j), Integer.valueOf(num.intValue() + 1));
        JSONObject QV = QV();
        String b = k.b(new Date());
        JSONObject optJSONObject = QV.optJSONObject(b);
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
        com.baidu.live.c.AZ().putString("feed_diversion_show_frequency", jSONObject.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static JSONObject QV() {
        JSONObject jSONObject;
        String string = com.baidu.live.c.AZ().getString("feed_diversion_show_frequency", "");
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

    public static void cJ(boolean z) {
        com.baidu.live.c.AZ().putInt("feed_diversion_noclick_frequency", z ? 0 : com.baidu.live.c.AZ().getInt("feed_diversion_noclick_frequency", 0) + 1);
    }

    public static boolean az(long j) {
        boolean ax;
        if (!bxu && (ax = ax(j))) {
            bxu = (QT() && QU()) ? false : true;
            return ax & (bxu ? false : true);
        }
        return false;
    }
}
