package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class e {
    private static e rc = null;
    private HashMap<String, HashSet<String>> rd;

    public static e fX() {
        if (rc == null) {
            synchronized (e.class) {
                if (rc == null) {
                    rc = new e();
                }
            }
        }
        return rc;
    }

    private e() {
        this.rd = null;
        this.rd = new HashMap<>();
    }

    public void l(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String host = new URL(str).getHost();
                String str3 = host.contains("hiphotos.baidu.com") ? "hiphotos.baidu.com" : host;
                HashSet<String> hashSet = this.rd.get(str3);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.rd.put(str3, hashSet);
                }
                hashSet.add(str2);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String b(ArrayList<String> arrayList, String str) {
        if (arrayList != null && !arrayList.isEmpty()) {
            String str2 = arrayList.get(0);
            if (this.rd.containsKey(str)) {
                HashSet<String> hashSet = this.rd.get(str);
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!hashSet.contains(arrayList.get(i))) {
                        return arrayList.get(i);
                    }
                }
            }
            this.rd.remove(str);
            return str2;
        }
        return null;
    }
}
