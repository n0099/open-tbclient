package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes25.dex */
public class d implements c {
    private static volatile d atV = null;
    private c atW;

    public static d zj() {
        if (atV == null) {
            synchronized (d.class) {
                if (atV == null) {
                    atV = new d();
                }
            }
        }
        return atV;
    }

    public void b(c cVar) {
        this.atW = cVar;
    }

    @Override // com.baidu.g.a.b.c
    public View B(Context context, String str) {
        if (this.atW == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atW.B(context, str);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, TbPageContext<?> tbPageContext) {
        if (this.atW == null || view == null || aVar == null) {
            return false;
        }
        return this.atW.a(str, view, aVar, tbPageContext);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.atW == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.atW.a(str, view, str2, str3);
    }
}
