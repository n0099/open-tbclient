package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class CustomPushPremissionDialogView extends LinearLayout {
    private TBSpecificationBtn epA;
    private TextView epv;
    private TBLottieAnimationView epw;
    private View epx;
    private View epy;
    private TBSpecificationBtn epz;

    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dL(context);
    }

    private void dL(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_push_premission_dialog_view, this);
        this.epw = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.epw.loop(true);
        this.epw.setFrame(0);
        ap.a(this.epw, R.raw.lottie_push_permission_dialog_animation);
        this.epw.playAnimation();
        this.epv = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.epv.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.epx = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.epy = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.e.a.bjP().on(1).op(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).oo(273).a(R.color.cp_shadow_a, 0.16f, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).aZ(this.epy);
            ViewGroup.LayoutParams layoutParams2 = this.epx.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.epx.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).b("TOP_BOTTOM", ap.nS(R.color.common_color_10262), ap.nS(R.color.cp_bg_line_e)).aZ(this.epx);
        } else {
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).V(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ap.nS(R.color.cp_bg_line_e), ap.nS(R.color.cp_bg_line_e), ap.nS(R.color.cp_bg_line_e), ap.nS(R.color.cp_bg_line_e), ap.nS(R.color.cp_bg_line_k)).aZ(this.epx);
        }
        this.epz = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.epz.setTextSize(R.dimen.tbds34);
        this.epz.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pd(R.color.cp_cont_b);
        this.epz.setConfig(cVar);
        this.epz.bkF();
        this.epA = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.epA.setTextSize(R.dimen.tbds34);
        this.epA.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pb(R.color.cp_link_tip_a);
        this.epA.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.epz;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.epA;
    }
}
