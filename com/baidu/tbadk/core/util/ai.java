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
public class ai {
    private static final String[] UB = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> UC = new LinkedList();
    private static ai UD;
    private static aj UE;

    private ai() {
        UE = new aj(this, null);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkCoreApplication.m411getInst().getApp().registerReceiver(UE, intentFilter);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private static synchronized void sD() {
        synchronized (ai.class) {
            if (UD == null) {
                UD = new ai();
            }
        }
    }

    public static ai sE() {
        if (UD == null) {
            sD();
        }
        return UD;
    }

    public static int cG(String str) {
        if (bd.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < UB.length; i++) {
            if (str.contains(UB[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void m(int i, int i2) {
        List<ak> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String string = com.baidu.tbadk.core.sharedPref.b.rB().getString("network_error_record", "");
            if (bd.isEmpty(string)) {
                list = new LinkedList<>();
                ak akVar = new ak(this, null);
                akVar.port = i;
                akVar.action = i2;
                akVar.count = 1;
                list.add(akVar);
            } else {
                List<ak> cI = cI(string);
                int i4 = -1;
                int i5 = 0;
                while (i5 < cI.size()) {
                    if (cI.get(i5).port == i && cI.get(i5).action == i2) {
                        cI.get(i5).count++;
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                    i5++;
                    i4 = i3;
                }
                if (i4 < 0) {
                    ak akVar2 = new ak(this, null);
                    akVar2.port = i;
                    akVar2.action = i2;
                    akVar2.count = 1;
                    cI.add(akVar2);
                }
                list = cI;
            }
            String k = k(list);
            if (!bd.isEmpty(k)) {
                com.baidu.tbadk.core.sharedPref.b.rB().putString("network_error_record", k);
            }
        }
    }

    public synchronized void sF() {
        for (Integer num : UC) {
            m(num.intValue(), 2);
        }
    }

    public synchronized void bW(int i) {
        if (i > 0) {
            UC.add(Integer.valueOf(i));
        }
    }

    public synchronized void bX(int i) {
        if (i > 0) {
            UC.remove(Integer.valueOf(i));
        }
    }

    public synchronized void sG() {
        com.baidu.tbadk.core.sharedPref.b.rB().remove("network_error_record");
    }

    public static void cH(String str) {
        try {
            int cG = cG(str);
            if (cG > 0) {
                sE().bX(cG);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public synchronized String sH() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getString("network_error_record", "");
    }

    private String k(List<ak> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (ak akVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("port", akVar.port);
                jSONObject.put("action", akVar.action);
                jSONObject.put(ImageViewerConfig.COUNT, akVar.count);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    private List<ak> cI(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                ak akVar = new ak(this, null);
                akVar.port = optJSONObject.getInt("port");
                akVar.action = optJSONObject.getInt("action");
                akVar.count = optJSONObject.getInt(ImageViewerConfig.COUNT);
                linkedList.add(akVar);
            }
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
        return linkedList;
    }
}
