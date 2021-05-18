package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.r.f0.m.c;
/* loaded from: classes3.dex */
public class CustomPushPremissionDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12290e;

    /* renamed from: f  reason: collision with root package name */
    public TBLottieAnimationView f12291f;

    /* renamed from: g  reason: collision with root package name */
    public View f12292g;

    /* renamed from: h  reason: collision with root package name */
    public View f12293h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f12294i;
    public TBSpecificationBtn j;

    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        LinearLayout.inflate(context, R.layout.custom_push_premission_dialog_view, this);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.f12291f = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        this.f12291f.setFrame(0);
        SkinManager.setLottieAnimation(this.f12291f, R.raw.lottie_push_permission_dialog_animation);
        this.f12291f.playAnimation();
        TextView textView = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.f12290e = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f12292g = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.f12293h = findViewById(R.id.animation_layout);
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(l.g(context, R.dimen.tbds26)).setShadowSide(273).setShadowLayer(R.color.CAM_X0804, 0, 0, l.g(getContext(), R.dimen.tbds22)).into(this.f12293h);
            ViewGroup.LayoutParams layoutParams2 = this.f12292g.getLayoutParams();
            layoutParams2.width = l.g(context, R.dimen.tbds774);
            this.f12292g.setLayoutParams(layoutParams2);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(R.color.common_color_10262), SkinManager.getResourceId(R.color.CAM_X0205)).into(this.f12292g);
        } else {
            TBSelector.makeDrawableSelector().setShape(0).radius(l.g(context, R.dimen.tbds26)).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0211)).into(this.f12292g);
        }
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.f12294i = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        this.f12294i.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        c cVar = new c();
        cVar.q(R.color.CAM_X0105);
        this.f12294i.setConfig(cVar);
        this.f12294i.k();
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.j = tBSpecificationBtn2;
        tBSpecificationBtn2.setTextSize(R.dimen.tbds34);
        this.j.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        c cVar2 = new c();
        cVar2.o(R.color.CAM_X0302);
        this.j.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.f12294i;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.j;
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
