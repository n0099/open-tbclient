package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.k;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b {
    private final e cbJ;

    public b(e eVar) {
        this.cbJ = eVar;
    }

    public void ZP() {
        ZQ();
        ZR();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        ZS();
    }

    public void ZQ() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jA(this.cbJ.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jA(this.cbJ.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.jD(str);
        }
        Als.a(aVar);
    }

    public void i(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jA(this.cbJ.ext);
        aVar.jC(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.cbs.get().Zw()) {
            aVar.jB("1");
        } else {
            aVar.jB("0");
        }
        aVar.jD(str);
        Als.a(aVar);
    }

    public void aZ(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jA(this.cbJ.ext);
        aVar.jB("10");
        aVar.jC(str);
        aVar.jD(str2);
        Als.a(aVar);
    }

    public void ZR() {
        String[] strArr;
        for (String str : this.cbJ.cbX) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jE(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void ZS() {
        String[] strArr;
        for (String str : this.cbJ.cbY) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jE(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void ZT() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.jA(string);
            Als.a(aVar);
        }
    }
}
