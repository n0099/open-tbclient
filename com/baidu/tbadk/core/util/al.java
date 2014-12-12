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
    private static final String[] IO = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> IP = new LinkedList();
    private static al IQ;
    private static am IR;

    private al() {
        IR = new am(this, null);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkCoreApplication.m255getInst().getApp().registerReceiver(IR, intentFilter);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private static synchronized void pk() {
        synchronized (al.class) {
            if (IQ == null) {
                IQ = new al();
            }
        }
    }

    public static al pl() {
        if (IQ == null) {
            pk();
        }
        return IQ;
    }

    public static int cC(String str) {
        if (ba.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < IO.length; i++) {
            if (str.contains(IO[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void o(int i, int i2) {
        List<an> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String string = com.baidu.tbadk.core.sharedPref.b.og().getString("network_error_record", "");
            if (ba.isEmpty(string)) {
                list = new LinkedList<>();
                an anVar = new an(this, null);
                anVar.port = i;
                anVar.action = i2;
                anVar.count = 1;
                list.add(anVar);
            } else {
                List<an> cE = cE(string);
                int i4 = -1;
                int i5 = 0;
                while (i5 < cE.size()) {
                    if (cE.get(i5).port == i && cE.get(i5).action == i2) {
                        cE.get(i5).count++;
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
                    cE.add(anVar2);
                }
                list = cE;
            }
            String j = j(list);
            if (!ba.isEmpty(j)) {
                com.baidu.tbadk.core.sharedPref.b.og().putString("network_error_record", j);
            }
        }
    }

    public synchronized void pm() {
        for (Integer num : IP) {
            o(num.intValue(), 2);
        }
    }

    public synchronized void bQ(int i) {
        if (i > 0) {
            IP.add(Integer.valueOf(i));
        }
    }

    public synchronized void bR(int i) {
        if (i > 0) {
            IP.remove(Integer.valueOf(i));
        }
    }

    public synchronized void pn() {
        com.baidu.tbadk.core.sharedPref.b.og().remove("network_error_record");
    }

    public static void cD(String str) {
        try {
            int cC = cC(str);
            if (cC > 0) {
                pl().bR(cC);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public synchronized String po() {
        return com.baidu.tbadk.core.sharedPref.b.og().getString("network_error_record", "");
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

    private List<an> cE(String str) {
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
