package com.baidu.tbadk.core.util;

import android.content.IntentFilter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private static final String[] ED = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> EE = new LinkedList();
    private static ak EF;
    private static al EG;

    private ak() {
        EG = new al(this, null);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkApplication.m251getInst().getApp().registerReceiver(EG, intentFilter);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private static synchronized void mq() {
        synchronized (ak.class) {
            if (EF == null) {
                EF = new ak();
            }
        }
    }

    public static ak mr() {
        if (EF == null) {
            mq();
        }
        return EF;
    }

    public static int bJ(String str) {
        if (az.aA(str)) {
            return -1;
        }
        for (int i = 0; i < ED.length; i++) {
            if (str.contains(ED[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void l(int i, int i2) {
        List<am> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String string = com.baidu.tbadk.core.sharedPref.b.lk().getString("network_error_record", "");
            if (az.aA(string)) {
                list = new LinkedList<>();
                am amVar = new am(this, null);
                amVar.port = i;
                amVar.action = i2;
                amVar.count = 1;
                list.add(amVar);
            } else {
                List<am> bL = bL(string);
                int i4 = -1;
                int i5 = 0;
                while (i5 < bL.size()) {
                    if (bL.get(i5).port == i && bL.get(i5).action == i2) {
                        bL.get(i5).count++;
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                    i5++;
                    i4 = i3;
                }
                if (i4 < 0) {
                    am amVar2 = new am(this, null);
                    amVar2.port = i;
                    amVar2.action = i2;
                    amVar2.count = 1;
                    bL.add(amVar2);
                }
                list = bL;
            }
            String f = f(list);
            if (!az.aA(f)) {
                com.baidu.tbadk.core.sharedPref.b.lk().putString("network_error_record", f);
            }
        }
    }

    public synchronized void ms() {
        for (Integer num : EE) {
            l(num.intValue(), 2);
        }
    }

    public synchronized void bt(int i) {
        if (i > 0) {
            EE.add(Integer.valueOf(i));
        }
    }

    public synchronized void bu(int i) {
        if (i > 0) {
            EE.remove(Integer.valueOf(i));
        }
    }

    public synchronized void mt() {
        com.baidu.tbadk.core.sharedPref.b.lk().remove("network_error_record");
    }

    public static void bK(String str) {
        try {
            int bJ = bJ(str);
            if (bJ > 0) {
                mr().bu(bJ);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public synchronized String mu() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getString("network_error_record", "");
    }

    private String f(List<am> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (am amVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("port", amVar.port);
                jSONObject.put("action", amVar.action);
                jSONObject.put(ImageViewerConfig.COUNT, amVar.count);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    private List<am> bL(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                am amVar = new am(this, null);
                amVar.port = optJSONObject.getInt("port");
                amVar.action = optJSONObject.getInt("action");
                amVar.count = optJSONObject.getInt(ImageViewerConfig.COUNT);
                linkedList.add(amVar);
            }
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
        return linkedList;
    }
}
