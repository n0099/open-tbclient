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
/* loaded from: classes.dex */
public class CustomPushPremissionDialogView extends LinearLayout {
    private TextView eSa;
    private TBLottieAnimationView eSb;
    private View eSc;
    private View eSd;
    private TBSpecificationBtn eSe;
    private TBSpecificationBtn eSf;

    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dQ(context);
    }

    private void dQ(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_push_premission_dialog_view, this);
        this.eSb = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.eSb.loop(true);
        this.eSb.setFrame(0);
        ap.a(this.eSb, R.raw.lottie_push_permission_dialog_animation);
        this.eSb.playAnimation();
        this.eSa = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.eSa.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.eSc = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.eSd = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.e.a.brN().pt(1).pv(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).pu(273).a(R.color.cp_shadow_a, 0.16f, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bk(this.eSd);
            ViewGroup.LayoutParams layoutParams2 = this.eSc.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.eSc.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).b("TOP_BOTTOM", ap.oW(R.color.common_color_10262), ap.oW(R.color.cp_bg_line_e)).bk(this.eSc);
        } else {
            com.baidu.tbadk.core.util.e.a.brO().pj(0).ab(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ap.oW(R.color.cp_bg_line_e), ap.oW(R.color.cp_bg_line_e), ap.oW(R.color.cp_bg_line_e), ap.oW(R.color.cp_bg_line_e), ap.oW(R.color.cp_bg_line_k)).bk(this.eSc);
        }
        this.eSe = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.eSe.setTextSize(R.dimen.tbds34);
        this.eSe.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qk(R.color.cp_cont_b);
        this.eSe.setConfig(cVar);
        this.eSe.bsD();
        this.eSf = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.eSf.setTextSize(R.dimen.tbds34);
        this.eSf.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.qi(R.color.cp_link_tip_a);
        this.eSf.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.eSe;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.eSf;
    }
}
