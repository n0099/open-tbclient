package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes20.dex */
public class d implements c {
    private static volatile d att = null;
    private c atu;

    public static d yV() {
        if (att == null) {
            synchronized (d.class) {
                if (att == null) {
                    att = new d();
                }
            }
        }
        return att;
    }

    public void b(c cVar) {
        this.atu = cVar;
    }

    @Override // com.baidu.g.a.b.c
    public View B(Context context, String str) {
        if (this.atu == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atu.B(context, str);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, TbPageContext<?> tbPageContext) {
        if (this.atu == null || view == null || aVar == null) {
            return false;
        }
        return this.atu.a(str, view, aVar, tbPageContext);
    }

    @Override // com.baidu.g.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.atu == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.atu.a(str, view, str2, str3);
    }
}
