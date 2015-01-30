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
public class al {
    private static final String[] IY = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> IZ = new LinkedList();
    private static al Ja;
    private static am Jb;

    private al() {
        Jb = new am(this, null);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkCoreApplication.m255getInst().getApp().registerReceiver(Jb, intentFilter);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private static synchronized void pn() {
        synchronized (al.class) {
            if (Ja == null) {
                Ja = new al();
            }
        }
    }

    public static al po() {
        if (Ja == null) {
            pn();
        }
        return Ja;
    }

    public static int cA(String str) {
        if (bf.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < IY.length; i++) {
            if (str.contains(IY[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void o(int i, int i2) {
        List<an> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String string = com.baidu.tbadk.core.sharedPref.b.oj().getString("network_error_record", "");
            if (bf.isEmpty(string)) {
                list = new LinkedList<>();
                an anVar = new an(this, null);
                anVar.port = i;
                anVar.action = i2;
                anVar.count = 1;
                list.add(anVar);
            } else {
                List<an> cC = cC(string);
                int i4 = -1;
                int i5 = 0;
                while (i5 < cC.size()) {
                    if (cC.get(i5).port == i && cC.get(i5).action == i2) {
                        cC.get(i5).count++;
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                    i5++;
                    i4 = i3;
                }
                if (i4 < 0) {
                    an anVar2 = new an(this, null);
                    anVar2.port = i;
                    anVar2.action = i2;
                    anVar2.count = 1;
                    cC.add(anVar2);
                }
                list = cC;
            }
            String j = j(list);
            if (!bf.isEmpty(j)) {
                com.baidu.tbadk.core.sharedPref.b.oj().putString("network_error_record", j);
            }
        }
    }

    public synchronized void pp() {
        for (Integer num : IZ) {
            o(num.intValue(), 2);
        }
    }

    public synchronized void bV(int i) {
        if (i > 0) {
            IZ.add(Integer.valueOf(i));
        }
    }

    public synchronized void bW(int i) {
        if (i > 0) {
            IZ.remove(Integer.valueOf(i));
        }
    }

    public synchronized void pq() {
        com.baidu.tbadk.core.sharedPref.b.oj().remove("network_error_record");
    }

    public static void cB(String str) {
        try {
            int cA = cA(str);
            if (cA > 0) {
                po().bW(cA);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public synchronized String pr() {
        return com.baidu.tbadk.core.sharedPref.b.oj().getString("network_error_record", "");
    }

    private String j(List<an> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (an anVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("port", anVar.port);
                jSONObject.put("action", anVar.action);
                jSONObject.put(ImageViewerConfig.COUNT, anVar.count);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    private List<an> cC(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                an anVar = new an(this, null);
                anVar.port = optJSONObject.getInt("port");
                anVar.action = optJSONObject.getInt("action");
                anVar.count = optJSONObject.getInt(ImageViewerConfig.COUNT);
                linkedList.add(anVar);
            }
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
        return linkedList;
    }
}
