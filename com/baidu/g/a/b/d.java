package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes26.dex */
public class d implements c {
    private static volatile d auE = null;
    private c auF;

    public static d zr() {
        if (auE == null) {
            synchronized (d.class) {
                if (auE == null) {
                    auE = new d();
                }
            }
        }
        return auE;
    }

    public void b(c cVar) {
        this.auF = cVar;
    }

    @Override // com.baidu.g.a.b.c
    public View D(Context context, String str) {
        if (this.auF == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.auF.D(context, str);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, TbPageContext<?> tbPageContext) {
        if (this.auF == null || view == null || aVar == null) {
            return false;
        }
        return this.auF.a(str, view, aVar, tbPageContext);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.auF == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.auF.a(str, view, str2, str3);
    }
}
