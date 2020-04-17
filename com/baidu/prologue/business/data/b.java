package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.j;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private final e bsh;

    public b(e eVar) {
        this.bsh = eVar;
    }

    public void LM() {
        LN();
        LO();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        LP();
    }

    public void LN() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.fZ(this.bsh.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.fZ(this.bsh.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.gc(str);
        }
        Als.a(aVar);
    }

    public void i(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.fZ(this.bsh.ext);
        aVar.gb(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.brQ.get().Lt()) {
            aVar.ga("1");
        } else {
            aVar.ga("0");
        }
        aVar.gc(str);
        Als.a(aVar);
    }

    public void as(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.fZ(this.bsh.ext);
        aVar.ga("10");
        aVar.gb(str);
        aVar.gc(str2);
        Als.a(aVar);
    }

    public void LO() {
        String[] strArr;
        for (String str : this.bsh.bsv) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.gd(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void LP() {
        String[] strArr;
        for (String str : this.bsh.bsw) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.gd(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void LQ() {
        String string = j.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.fZ(string);
            Als.a(aVar);
        }
    }
}
