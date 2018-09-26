package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class d extends cn.jiguang.api.c {
    @Override // cn.jiguang.api.c
    public Object beforLogin(Context context, int i, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if ("platformtype".equals(str)) {
            if (i >= 16) {
                return Byte.valueOf(cn.jpush.android.c.d.a().d(context));
            }
            return null;
        } else if ("platformregid".equals(str)) {
            return cn.jpush.android.c.d.a().e(context);
        } else {
            return null;
        }
    }

    @Override // cn.jiguang.api.c
    public Object onSendData(Context context, long j, long j2, int i, int i2) {
        if (cn.jpush.android.a.a(context)) {
            switch (i) {
                case 10:
                case 28:
                case 29:
                    f.a(context).a(j2, i2);
                    break;
                case 26:
                    g.a().a(context, j2, i2);
                    break;
            }
        }
        return null;
    }
}
