package com.baidu.sofire.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.sofire.ac.FaceProcessCallback;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f10205c;

    /* renamed from: d  reason: collision with root package name */
    public static b f10206d;

    /* renamed from: a  reason: collision with root package name */
    public Context f10207a;

    /* renamed from: b  reason: collision with root package name */
    public a f10208b;

    public b(Context context) {
        this.f10207a = context;
    }

    public static synchronized b a(Context context) {
        synchronized (b.class) {
            if (context == null) {
                return f10206d;
            }
            if (f10206d == null) {
                f10206d = new b(context);
            }
            return f10206d;
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            bVar = f10206d;
        }
        return bVar;
    }

    public final void a(Activity activity, final FaceProcessCallback faceProcessCallback, final int i2) {
        if (activity == null || faceProcessCallback == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                faceProcessCallback.onEnd(i2, null);
            }
        });
    }
}
