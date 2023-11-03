package com.baidu.android.pushservice.ach;

import android.content.Context;
import com.baidu.android.pushservice.ach.d.e;
import com.baidu.android.pushservice.ach.receiver.PushScreenReceiver;
import com.baidu.android.pushservice.z.c;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements com.baidu.android.pushservice.v.b {
    public PushScreenReceiver a;

    /* loaded from: classes.dex */
    public class a extends c {
        public final /* synthetic */ Context c;

        public a(b bVar, Context context) {
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15927, this, null);
        }
    }

    /* renamed from: com.baidu.android.pushservice.ach.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0023b extends c {
        public final /* synthetic */ Context c;

        public C0023b(b bVar, Context context) {
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15922, this, null);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public int a(Context context) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15921, this, context);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, int i, e eVar, long j, com.baidu.android.pushservice.ach.d.b bVar) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15924, this, context, Integer.valueOf(i), eVar, Long.valueOf(j), bVar);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, PushScreenReceiver.a aVar) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15923, this, context, aVar);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, JSONObject jSONObject) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15886, this, context, jSONObject);
    }

    @Override // com.baidu.android.pushservice.v.b
    public boolean a(Context context, int i) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15885, this, context, Integer.valueOf(i));
    }

    @Override // com.baidu.android.pushservice.v.b
    public int b(Context context) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15888, this, context);
    }

    @Override // com.baidu.android.pushservice.v.b
    public boolean b(Context context, int i) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15887, this, context, Integer.valueOf(i));
    }

    @Override // com.baidu.android.pushservice.v.b
    public void c(Context context) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15882, this, context);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void d(Context context) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15881, this, context);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void e(Context context) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15884, this, context);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void f(Context context) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15883, this, context);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void g(Context context) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15878, this, context);
    }
}
