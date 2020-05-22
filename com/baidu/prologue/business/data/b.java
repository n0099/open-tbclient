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
    private final e bzO;

    public b(e eVar) {
        this.bzO = eVar;
    }

    public void NY() {
        NZ();
        Oa();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        Ob();
    }

    public void NZ() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gL(this.bzO.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gL(this.bzO.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.gO(str);
        }
        Als.a(aVar);
    }

    public void h(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gL(this.bzO.ext);
        aVar.gN(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.bzx.get().NF()) {
            aVar.gM("1");
        } else {
            aVar.gM("0");
        }
        aVar.gO(str);
        Als.a(aVar);
    }

    public void aH(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gL(this.bzO.ext);
        aVar.gM("10");
        aVar.gN(str);
        aVar.gO(str2);
        Als.a(aVar);
    }

    public void Oa() {
        String[] strArr;
        for (String str : this.bzO.bAc) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.gP(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void Ob() {
        String[] strArr;
        for (String str : this.bzO.bAd) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.gP(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void Oc() {
        String string = j.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.gL(string);
            Als.a(aVar);
        }
    }
}
