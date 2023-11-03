package com.baidu.android.pushservice.v;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.ach.d.e;
import com.baidu.android.pushservice.ach.receiver.PushScreenReceiver;
import com.baidu.android.pushservice.util.Utility;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements com.baidu.android.pushservice.v.b {
    public com.baidu.android.pushservice.v.b a;

    /* loaded from: classes.dex */
    public static final class b {
        public static final c a = new c();
    }

    public c() {
        this.a = null;
        this.a = new com.baidu.android.pushservice.ach.b();
    }

    public static c a() {
        return b.a;
    }

    @Override // com.baidu.android.pushservice.v.b
    public int a(Context context) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return 2;
        }
        try {
            return bVar.a(context);
        } catch (Throwable unused) {
            h(context);
            return 2;
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, int i, e eVar, long j, com.baidu.android.pushservice.ach.d.b bVar) {
        com.baidu.android.pushservice.v.b bVar2 = this.a;
        if (bVar2 == null) {
            return;
        }
        try {
            bVar2.a(context, i, eVar, j, bVar);
        } catch (Throwable unused) {
            h(context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, PushScreenReceiver.a aVar) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(context, aVar);
        } catch (Throwable unused) {
            h(context);
        }
    }

    public void a(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.a == null && i == 1) {
            return;
        }
        Utility.b(context, str, i);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void a(Context context, JSONObject jSONObject) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(context, jSONObject);
        } catch (Throwable unused) {
            h(context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public boolean a(Context context, int i) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return false;
        }
        try {
            return bVar.a(context, i);
        } catch (Throwable unused) {
            h(context);
            return false;
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public int b(Context context) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return 2;
        }
        try {
            return bVar.b(context);
        } catch (Throwable unused) {
            h(context);
            return 2;
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public boolean b(Context context, int i) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return false;
        }
        try {
            return bVar.b(context, i);
        } catch (Throwable unused) {
            h(context);
            return false;
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void c(Context context) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.c(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    public void c(Context context, int i) {
        if (this.a == null && i == 1) {
            return;
        }
        Utility.a(context, "com.baidu.android.pushservice.ach.PushAchProvider", i);
    }

    @Override // com.baidu.android.pushservice.v.b
    public void d(Context context) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.d(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    public void d(Context context, int i) {
        if (this.a == null && i == 1) {
            return;
        }
        Utility.b(context, "com.baidu.android.pushservice.ach.PushAchService", i);
        Utility.b(context, "com.baidu.android.pushservice.ach.power.PushAchHpkitService", i);
        Utility.a(context, "com.baidu.android.pushservice.ach.PushAchProvider", i);
        for (String str : com.baidu.android.pushservice.ach.a.a) {
            Utility.b(context, str, i);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void e(Context context) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.e(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void f(Context context) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.f(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    @Override // com.baidu.android.pushservice.v.b
    public void g(Context context) {
        com.baidu.android.pushservice.v.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.g(context);
        } catch (Throwable unused) {
            h(context);
        }
    }

    public final void h(Context context) {
        this.a = null;
        d(context, 2);
    }
}
