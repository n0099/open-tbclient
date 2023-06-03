package com.baidu.cyberplayer.sdk.ab;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.context.ICyberMediaAbTest;
import com.baidu.cyberplayer.sdk.q;
import com.baidu.cyberplayer.sdk.utils.c;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    public String a;
    public String b;
    public Map<String, String> c;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = q.c(str2);
    }

    public int a(String str, int i) {
        return c.a(a(str, i + ""), i);
    }

    public static a a(String str) {
        ICyberMediaAbTest abTestInterface;
        if (CyberPlayerManager.getCyberMediaContext() == null || (abTestInterface = CyberPlayerManager.getCyberMediaContext().getAbTestInterface()) == null) {
            return null;
        }
        return new a(str, abTestInterface.getSwitch(str, ""));
    }

    public String a() {
        return this.b;
    }

    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        if (this.c.size() > 0) {
            hashMap.putAll(this.c);
        }
        return hashMap;
    }

    public String a(String str, String str2) {
        Map<String, String> map = this.c;
        if (map != null && !TextUtils.isEmpty(map.get(str))) {
            return this.c.get(str);
        }
        return str2;
    }
}
