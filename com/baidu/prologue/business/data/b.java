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
    private final e ctw;

    public b(e eVar) {
        this.ctw = eVar;
    }

    public void agJ() {
        agK();
        agL();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        agM();
    }

    public void agK() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.ki(this.ctw.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.ki(this.ctw.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.kl(str);
        }
        Als.a(aVar);
    }

    public void i(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.ki(this.ctw.ext);
        aVar.kk(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.ctd.get().agq()) {
            aVar.kj("1");
        } else {
            aVar.kj("0");
        }
        aVar.kl(str);
        Als.a(aVar);
    }

    public void be(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.ki(this.ctw.ext);
        aVar.kj(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        aVar.kk(str);
        aVar.kl(str2);
        Als.a(aVar);
    }

    public void agL() {
        String[] strArr;
        for (String str : this.ctw.ctL) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.km(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void agM() {
        String[] strArr;
        for (String str : this.ctw.ctM) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.km(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void agN() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.ki(string);
            Als.a(aVar);
        }
    }
}
