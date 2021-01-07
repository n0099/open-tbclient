package com.baidu.fsg.base.activity.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes6.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private View f1923a;

    /* renamed from: b  reason: collision with root package name */
    private RotateAnimation f1924b;

    public a(Context context) {
        super(context, ResUtils.style(context, "RimThemeLoadingDialog"));
    }

    public a(Context context, int i) {
        super(context, i);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getContext(), "rim_base_dialog_common_loading_layout"));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f1923a = findViewById(ResUtils.id(getContext(), "rim_base_dialog_common_loading_view"));
        this.f1924b = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f1924b.setRepeatCount(-1);
        this.f1924b.setDuration(1000L);
        this.f1924b.setInterpolator(new LinearInterpolator());
        this.f1923a.startAnimation(this.f1924b);
    }
}
