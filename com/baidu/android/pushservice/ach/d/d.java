package com.baidu.android.pushservice.ach.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
/* loaded from: classes.dex */
public class d extends a {
    public Context a;
    public View b;
    public WindowManager.LayoutParams c;

    public d(Context context) {
        this.a = context;
        this.b = LayoutInflater.from(context).inflate(com.baidu.android.pushservice.v.a.a(c(context)), (ViewGroup) null);
    }

    @Override // com.baidu.android.pushservice.ach.d.c
    public View a() {
        return (View) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-16000, this, null);
    }

    @Override // com.baidu.android.pushservice.ach.d.c
    public void a(e eVar) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15999, this, eVar);
    }

    @Override // com.baidu.android.pushservice.ach.d.c
    public WindowManager.LayoutParams b() {
        return (WindowManager.LayoutParams) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15994, this, null);
    }
}
