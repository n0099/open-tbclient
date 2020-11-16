package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.k;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {
    private final e cfK;

    public b(e eVar) {
        this.cfK = eVar;
    }

    public void abF() {
        abG();
        abH();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        abI();
    }

    public void abG() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jH(this.cfK.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jH(this.cfK.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.jK(str);
        }
        Als.a(aVar);
    }

    public void i(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jH(this.cfK.ext);
        aVar.jJ(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.cft.get().abm()) {
            aVar.jI("1");
        } else {
            aVar.jI("0");
        }
        aVar.jK(str);
        Als.a(aVar);
    }

    public void aY(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jH(this.cfK.ext);
        aVar.jI("10");
        aVar.jJ(str);
        aVar.jK(str2);
        Als.a(aVar);
    }

    public void abH() {
        String[] strArr;
        for (String str : this.cfK.cfY) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jL(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void abI() {
        String[] strArr;
        for (String str : this.cfK.cfZ) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jL(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void abJ() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.jH(string);
            Als.a(aVar);
        }
    }
}
