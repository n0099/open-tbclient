package com.baidu.prologue.business.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.prologue.a.c.k;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    private final e coG;

    public b(e eVar) {
        this.coG = eVar;
    }

    public void acQ() {
        acR();
        acS();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        acT();
    }

    public void acR() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.iX(this.coG.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.iX(this.coG.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.ja(str);
        }
        Als.a(aVar);
    }

    public void i(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.iX(this.coG.ext);
        aVar.iZ(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.cop.get().acx()) {
            aVar.iY("1");
        } else {
            aVar.iY("0");
        }
        aVar.ja(str);
        Als.a(aVar);
    }

    public void bd(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.iX(this.coG.ext);
        aVar.iY(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        aVar.iZ(str);
        aVar.ja(str2);
        Als.a(aVar);
    }

    public void acS() {
        String[] strArr;
        for (String str : this.coG.coU) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jb(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void acT() {
        String[] strArr;
        for (String str : this.coG.coV) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jb(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void acU() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.iX(string);
            Als.a(aVar);
        }
    }
}
