package com.baidu.mobstat;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class w implements a {

    /* renamed from: a  reason: collision with root package name */
    public z f8835a = z.f8850a;

    /* renamed from: b  reason: collision with root package name */
    public Object f8836b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f8837c;

    public w(Object obj) {
        if (obj != null) {
            if ("com.baidu.bottom.remote.BPStretegyController2".equals(obj.getClass().getName())) {
                this.f8836b = obj;
                this.f8837c = obj.getClass();
                return;
            }
            throw new IllegalArgumentException("class isn't com.baidu.bottom.remote.BPStretegyController2");
        }
        throw new IllegalArgumentException("proxy is null.");
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, JSONObject jSONObject) {
        try {
            a(new Object[]{context, jSONObject}, "startDataAnynalyze", new Class[]{Context.class, JSONObject.class});
        } catch (Exception e2) {
            bb.c().b(e2);
            this.f8835a.a(context, jSONObject);
        }
    }

    @Override // com.baidu.mobstat.a
    public void b(Context context, String str) {
        try {
            a(new Object[]{context, str}, "saveRemoteSign", new Class[]{Context.class, String.class});
        } catch (Exception e2) {
            bb.c().b(e2);
            this.f8835a.b(context, str);
        }
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, String str) {
        try {
            a(new Object[]{context, str}, "saveRemoteConfig2", new Class[]{Context.class, String.class});
        } catch (Exception e2) {
            bb.c().b(e2);
            this.f8835a.a(context, str);
        }
    }

    @Override // com.baidu.mobstat.a
    public boolean b(Context context) {
        try {
            return ((Boolean) a(new Object[]{context}, "canStartService", new Class[]{Context.class})).booleanValue();
        } catch (Exception e2) {
            bb.c().b(e2);
            return this.f8835a.b(context);
        }
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, long j) {
        try {
            a(new Object[]{context, Long.valueOf(j)}, "setLastUpdateTime", new Class[]{Context.class, Long.TYPE});
        } catch (Exception e2) {
            bb.c().b(e2);
            this.f8835a.a(context, j);
        }
    }

    @Override // com.baidu.mobstat.a
    public boolean a(Context context) {
        try {
            return ((Boolean) a(new Object[]{context}, "needUpdate", new Class[]{Context.class})).booleanValue();
        } catch (Exception e2) {
            bb.c().b(e2);
            return this.f8835a.a(context);
        }
    }

    private <T> T a(Object[] objArr, String str, Class<?>[] clsArr) throws Exception {
        return (T) this.f8837c.getMethod(str, clsArr).invoke(this.f8836b, objArr);
    }
}
