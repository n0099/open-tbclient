package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.k;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private final e bEZ;

    public b(e eVar) {
        this.bEZ = eVar;
    }

    public void Pt() {
        Pu();
        Pv();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        Pw();
    }

    public void Pu() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gR(this.bEZ.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gR(this.bEZ.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.gU(str);
        }
        Als.a(aVar);
    }

    public void h(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gR(this.bEZ.ext);
        aVar.gT(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.bEI.get().Pa()) {
            aVar.gS("1");
        } else {
            aVar.gS("0");
        }
        aVar.gU(str);
        Als.a(aVar);
    }

    public void aJ(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gR(this.bEZ.ext);
        aVar.gS("10");
        aVar.gT(str);
        aVar.gU(str2);
        Als.a(aVar);
    }

    public void Pv() {
        String[] strArr;
        for (String str : this.bEZ.bFn) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.gV(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void Pw() {
        String[] strArr;
        for (String str : this.bEZ.bFo) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.gV(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void Px() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.gR(string);
            Als.a(aVar);
        }
    }
}
