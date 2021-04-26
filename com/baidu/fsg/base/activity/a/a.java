package com.baidu.fsg.base.activity.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f5310a;

    /* renamed from: b  reason: collision with root package name */
    public RotateAnimation f5311b;

    public a(Context context) {
        super(context, ResUtils.style(context, "RimThemeLoadingDialog"));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getContext(), "rim_base_dialog_common_loading_layout"));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f5310a = findViewById(ResUtils.id(getContext(), "rim_base_dialog_common_loading_view"));
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f5311b = rotateAnimation;
        rotateAnimation.setRepeatCount(-1);
        this.f5311b.setDuration(1000L);
        this.f5311b.setInterpolator(new LinearInterpolator());
        this.f5310a.startAnimation(this.f5311b);
    }

    public a(Context context, int i2) {
        super(context, i2);
    }
}
