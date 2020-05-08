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
    private final e bsl;

    public b(e eVar) {
        this.bsl = eVar;
    }

    public void LL() {
        LM();
        LN();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        LO();
    }

    public void LM() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.fZ(this.bsl.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.fZ(this.bsl.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.gc(str);
        }
        Als.a(aVar);
    }

    public void i(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.fZ(this.bsl.ext);
        aVar.gb(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.brU.get().Ls()) {
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
        aVar.fZ(this.bsl.ext);
        aVar.ga("10");
        aVar.gb(str);
        aVar.gc(str2);
        Als.a(aVar);
    }

    public void LN() {
        String[] strArr;
        for (String str : this.bsl.bsz) {
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

    public void LO() {
        String[] strArr;
        for (String str : this.bsl.bsA) {
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

    public static void LP() {
        String string = j.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.fZ(string);
            Als.a(aVar);
        }
    }
}
