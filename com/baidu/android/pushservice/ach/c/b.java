package com.baidu.android.pushservice.ach.c;

import android.content.Context;
import android.graphics.Region;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.pushservice.ach.c.c;
import com.baidu.android.pushservice.ach.c.d;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
/* loaded from: classes.dex */
public class b {
    public Region e;
    public d h;
    public final com.baidu.android.pushservice.ach.c.d a = new com.baidu.android.pushservice.ach.c.d();
    public boolean b = false;
    public int c = 0;
    public final com.baidu.android.pushservice.ach.c.c d = new com.baidu.android.pushservice.ach.c.c();
    public final Handler f = new Handler(Looper.getMainLooper());
    public final Runnable g = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15874, this, null);
        }
    }

    /* renamed from: com.baidu.android.pushservice.ach.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0024b implements d.b {
        public C0024b() {
        }

        @Override // com.baidu.android.pushservice.ach.c.d.b
        public void a(boolean z, int i) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15873, this, Boolean.valueOf(z), Integer.valueOf(i));
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.b {
        public c() {
        }

        @Override // com.baidu.android.pushservice.ach.c.c.b
        public void a(int i, Region region) {
            Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15876, this, Integer.valueOf(i), region);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i);

        void a(boolean z, int i);
    }

    public static /* synthetic */ Region a(b bVar) {
        return (Region) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15902, null, bVar);
    }

    public static /* synthetic */ Region a(b bVar, Region region) {
        return (Region) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15901, null, bVar, region);
    }

    public static /* synthetic */ d b(b bVar) {
        return (d) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15903, null, bVar);
    }

    public static /* synthetic */ Runnable e(b bVar) {
        return (Runnable) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15900, null, bVar);
    }

    public static /* synthetic */ Handler f(b bVar) {
        return (Handler) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15899, null, bVar);
    }

    public void a(Context context, d dVar) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15894, this, context, dVar);
    }

    public final void a(Context context, String str, boolean z) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15893, this, context, str, Boolean.valueOf(z));
    }
}
