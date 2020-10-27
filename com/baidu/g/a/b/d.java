package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes26.dex */
public class d implements c {
    private static volatile d auF = null;
    private c auG;

    public static d zr() {
        if (auF == null) {
            synchronized (d.class) {
                if (auF == null) {
                    auF = new d();
                }
            }
        }
        return auF;
    }

    public void b(c cVar) {
        this.auG = cVar;
    }

    @Override // com.baidu.g.a.b.c
    public View D(Context context, String str) {
        if (this.auG == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.auG.D(context, str);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, TbPageContext<?> tbPageContext) {
        if (this.auG == null || view == null || aVar == null) {
            return false;
        }
        return this.auG.a(str, view, aVar, tbPageContext);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.auG == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.auG.a(str, view, str2, str3);
    }
}
