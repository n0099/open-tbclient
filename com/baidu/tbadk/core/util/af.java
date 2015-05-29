package com.baidu.tbadk.core.util;

import android.content.IntentFilter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private static final String[] Vf = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> Vg = new LinkedList();
    private static af Vh;
    private static ag Vi;

    private af() {
        Vi = new ag(this, null);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkCoreApplication.m411getInst().getApp().registerReceiver(Vi, intentFilter);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private static synchronized void tg() {
        synchronized (af.class) {
            if (Vh == null) {
                Vh = new af();
            }
        }
    }

    public static af th() {
        if (Vh == null) {
            tg();
        }
        return Vh;
    }

    public static int cU(String str) {
        if (bb.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < Vf.length; i++) {
            if (str.contains(Vf[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void m(int i, int i2) {
        List<ah> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String string = com.baidu.tbadk.core.sharedPref.b.sl().getString("network_error_record", "");
            if (bb.isEmpty(string)) {
                list = new LinkedList<>();
                ah ahVar = new ah(this, null);
                ahVar.port = i;
                ahVar.action = i2;
                ahVar.count = 1;
                list.add(ahVar);
            } else {
                List<ah> cW = cW(string);
                int i4 = -1;
                int i5 = 0;
                while (i5 < cW.size()) {
                    if (cW.get(i5).port == i && cW.get(i5).action == i2) {
                        cW.get(i5).count++;
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                    i5++;
                    i4 = i3;
                }
                if (i4 < 0) {
                    ah ahVar2 = new ah(this, null);
                    ahVar2.port = i;
                    ahVar2.action = i2;
                    ahVar2.count = 1;
                    cW.add(ahVar2);
                }
                list = cW;
            }
            String l = l(list);
            if (!bb.isEmpty(l)) {
                com.baidu.tbadk.core.sharedPref.b.sl().putString("network_error_record", l);
            }
        }
    }

    public synchronized void ti() {
        for (Integer num : Vg) {
            m(num.intValue(), 2);
        }
    }

    public synchronized void bZ(int i) {
        if (i > 0) {
            Vg.add(Integer.valueOf(i));
        }
    }

    public synchronized void ca(int i) {
        if (i > 0) {
            Vg.remove(Integer.valueOf(i));
        }
    }

    public synchronized void tj() {
        com.baidu.tbadk.core.sharedPref.b.sl().remove("network_error_record");
    }

    public static void cV(String str) {
        try {
            int cU = cU(str);
            if (cU > 0) {
                th().ca(cU);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public synchronized String tk() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getString("network_error_record", "");
    }

    private String l(List<ah> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (ah ahVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("port", ahVar.port);
                jSONObject.put("action", ahVar.action);
                jSONObject.put(ImageViewerConfig.COUNT, ahVar.count);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    private List<ah> cW(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                ah ahVar = new ah(this, null);
                ahVar.port = optJSONObject.getInt("port");
                ahVar.action = optJSONObject.getInt("action");
                ahVar.count = optJSONObject.getInt(ImageViewerConfig.COUNT);
                linkedList.add(ahVar);
            }
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
        return linkedList;
    }
}
