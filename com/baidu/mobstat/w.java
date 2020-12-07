package com.baidu.mobstat;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class w implements a {

    /* renamed from: a  reason: collision with root package name */
    private z f2634a = z.f2638a;
    private Object b;
    private Class<?> c;

    public w(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("proxy is null.");
        }
        if (!"com.baidu.bottom.remote.BPStretegyController2".equals(obj.getClass().getName())) {
            throw new IllegalArgumentException("class isn't com.baidu.bottom.remote.BPStretegyController2");
        }
        this.b = obj;
        this.c = obj.getClass();
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, JSONObject jSONObject) {
        try {
            a(new Object[]{context, jSONObject}, "startDataAnynalyze", new Class[]{Context.class, JSONObject.class});
        } catch (Exception e) {
            bb.c().b(e);
            this.f2634a.a(context, jSONObject);
        }
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, String str) {
        try {
            a(new Object[]{context, str}, "saveRemoteConfig2", new Class[]{Context.class, String.class});
        } catch (Exception e) {
            bb.c().b(e);
            this.f2634a.a(context, str);
        }
    }

    @Override // com.baidu.mobstat.a
    public void b(Context context, String str) {
        try {
            a(new Object[]{context, str}, "saveRemoteSign", new Class[]{Context.class, String.class});
        } catch (Exception e) {
            bb.c().b(e);
            this.f2634a.b(context, str);
        }
    }

    @Override // com.baidu.mobstat.a
    public void a(Context context, long j) {
        try {
            a(new Object[]{context, Long.valueOf(j)}, "setLastUpdateTime", new Class[]{Context.class, Long.TYPE});
        } catch (Exception e) {
            bb.c().b(e);
            this.f2634a.a(context, j);
        }
    }

    @Override // com.baidu.mobstat.a
    public boolean a(Context context) {
        try {
            return ((Boolean) a(new Object[]{context}, "needUpdate", new Class[]{Context.class})).booleanValue();
        } catch (Exception e) {
            bb.c().b(e);
            return this.f2634a.a(context);
        }
    }

    @Override // com.baidu.mobstat.a
    public boolean b(Context context) {
        try {
            return ((Boolean) a(new Object[]{context}, "canStartService", new Class[]{Context.class})).booleanValue();
        } catch (Exception e) {
            bb.c().b(e);
            return this.f2634a.b(context);
        }
    }

    private <T> T a(Object[] objArr, String str, Class<?>[] clsArr) throws Exception {
        return (T) this.c.getMethod(str, clsArr).invoke(this.b, objArr);
    }
}
