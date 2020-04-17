package com.baidu.prologue.a.b;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public interface a {
    public static final AtomicReference<a> brQ = new AtomicReference<>();

    @IdRes
    int LA();

    @IdRes
    int LB();

    String LC();

    int LD();

    String LE();

    @NonNull
    Context Lh();

    @NonNull
    String Li();

    @NonNull
    String Lj();

    @NonNull
    String Lk();

    @NonNull
    String Ll();

    @NonNull
    String Lm();

    @NonNull
    String Ln();

    @NonNull
    String Lo();

    @NonNull
    String Lp();

    @NonNull
    String Lq();

    boolean Lr();

    @NonNull
    String Ls();

    boolean Lt();

    String Lu();

    String Lv();

    String[] Lw();

    String Lx();

    String Ly();

    @IdRes
    int Lz();

    boolean a(String str, com.baidu.prologue.c.b bVar);

    @NonNull
    String androidId();

    @NonNull
    String pw();

    @NonNull
    String userAgent();
}
