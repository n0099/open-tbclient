package com.baidu.prologue.a.b;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes19.dex */
public interface a {
    public static final AtomicReference<a> cbs = new AtomicReference<>();

    String ZA();

    String ZB();

    @IdRes
    int ZC();

    @IdRes
    int ZD();

    @IdRes
    int ZE();

    String ZF();

    int ZG();

    String ZH();

    @NonNull
    Context Zk();

    @NonNull
    String Zl();

    @NonNull
    String Zm();

    @NonNull
    String Zn();

    @NonNull
    String Zo();

    @NonNull
    String Zp();

    @NonNull
    String Zq();

    @NonNull
    String Zr();

    @NonNull
    String Zs();

    @NonNull
    String Zt();

    boolean Zu();

    @NonNull
    String Zv();

    boolean Zw();

    String Zx();

    String Zy();

    String[] Zz();

    boolean a(String str, com.baidu.prologue.c.b bVar);

    @NonNull
    String androidId();

    @NonNull
    String ry();

    @NonNull
    String userAgent();
}
