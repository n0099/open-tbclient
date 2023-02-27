package com.baidu.android.pushservice.v;

import android.content.Context;
import com.baidu.android.pushservice.ach.d.e;
import com.baidu.android.pushservice.ach.receiver.PushScreenReceiver;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface b {
    int a(Context context);

    void a(Context context, int i, e eVar, long j, com.baidu.android.pushservice.ach.d.b bVar);

    void a(Context context, PushScreenReceiver.a aVar);

    void a(Context context, JSONObject jSONObject);

    boolean a(Context context, int i);

    int b(Context context);

    boolean b(Context context, int i);

    void c(Context context);

    void d(Context context);

    void e(Context context);

    void f(Context context);

    void g(Context context);
}
