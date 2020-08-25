package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes20.dex */
public class d implements c {
    private static volatile d atr = null;
    private c ats;

    public static d yV() {
        if (atr == null) {
            synchronized (d.class) {
                if (atr == null) {
                    atr = new d();
                }
            }
        }
        return atr;
    }

    public void b(c cVar) {
        this.ats = cVar;
    }

    @Override // com.baidu.g.a.b.c
    public View B(Context context, String str) {
        if (this.ats == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ats.B(context, str);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, TbPageContext<?> tbPageContext) {
        if (this.ats == null || view == null || aVar == null) {
            return false;
        }
        return this.ats.a(str, view, aVar, tbPageContext);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.ats == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.ats.a(str, view, str2, str3);
    }
}
