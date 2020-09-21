package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.k;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private final e bMD;

    public b(e eVar) {
        this.bMD = eVar;
    }

    public void VY() {
        VZ();
        Wa();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        Wb();
    }

    public void VZ() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.iF(this.bMD.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.iF(this.bMD.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.iI(str);
        }
        Als.a(aVar);
    }

    public void g(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.iF(this.bMD.ext);
        aVar.iH(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.bMm.get().VF()) {
            aVar.iG("1");
        } else {
            aVar.iG("0");
        }
        aVar.iI(str);
        Als.a(aVar);
    }

    public void aN(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.iF(this.bMD.ext);
        aVar.iG("10");
        aVar.iH(str);
        aVar.iI(str2);
        Als.a(aVar);
    }

    public void Wa() {
        String[] strArr;
        for (String str : this.bMD.bMR) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.iJ(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void Wb() {
        String[] strArr;
        for (String str : this.bMD.bMS) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.iJ(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void Wc() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.iF(string);
            Als.a(aVar);
        }
    }
}
