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
    private TextView eDP;
    private TBLottieAnimationView eDQ;
    private View eDR;
    private View eDS;
    private TBSpecificationBtn eDT;
    private TBSpecificationBtn eDU;

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
        this.eDQ = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.eDQ.loop(true);
        this.eDQ.setFrame(0);
        ap.a(this.eDQ, R.raw.lottie_push_permission_dialog_animation);
        this.eDQ.playAnimation();
        this.eDP = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.eDP.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.eDR = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.eDS = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.e.a.bnu().oX(1).oZ(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).oY(273).a(R.color.cp_shadow_a, 0.16f, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bf(this.eDS);
            ViewGroup.LayoutParams layoutParams2 = this.eDR.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.eDR.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).b("TOP_BOTTOM", ap.oB(R.color.common_color_10262), ap.oB(R.color.cp_bg_line_e)).bf(this.eDR);
        } else {
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).X(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ap.oB(R.color.cp_bg_line_e), ap.oB(R.color.cp_bg_line_e), ap.oB(R.color.cp_bg_line_e), ap.oB(R.color.cp_bg_line_e), ap.oB(R.color.cp_bg_line_k)).bf(this.eDR);
        }
        this.eDT = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.eDT.setTextSize(R.dimen.tbds34);
        this.eDT.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pP(R.color.cp_cont_b);
        this.eDT.setConfig(cVar);
        this.eDT.bok();
        this.eDU = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.eDU.setTextSize(R.dimen.tbds34);
        this.eDU.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pN(R.color.cp_link_tip_a);
        this.eDU.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.eDT;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.eDU;
    }
}
