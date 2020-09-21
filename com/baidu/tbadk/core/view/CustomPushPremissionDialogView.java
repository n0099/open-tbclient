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
    private TextView erE;
    private TBLottieAnimationView erF;
    private View erG;
    private View erH;
    private TBSpecificationBtn erI;
    private TBSpecificationBtn erJ;

    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dK(context);
    }

    private void dK(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_push_premission_dialog_view, this);
        this.erF = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.erF.loop(true);
        this.erF.setFrame(0);
        ap.a(this.erF, R.raw.lottie_push_permission_dialog_animation);
        this.erF.playAnimation();
        this.erE = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.erE.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.erG = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.erH = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.e.a.bkK().oz(1).oB(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).oA(273).a(R.color.cp_shadow_a, 0.16f, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bb(this.erH);
            ViewGroup.LayoutParams layoutParams2 = this.erG.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.erG.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).b("TOP_BOTTOM", ap.oe(R.color.common_color_10262), ap.oe(R.color.cp_bg_line_e)).bb(this.erG);
        } else {
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).V(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ap.oe(R.color.cp_bg_line_e), ap.oe(R.color.cp_bg_line_e), ap.oe(R.color.cp_bg_line_e), ap.oe(R.color.cp_bg_line_e), ap.oe(R.color.cp_bg_line_k)).bb(this.erG);
        }
        this.erI = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.erI.setTextSize(R.dimen.tbds34);
        this.erI.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pr(R.color.cp_cont_b);
        this.erI.setConfig(cVar);
        this.erI.blA();
        this.erJ = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.erJ.setTextSize(R.dimen.tbds34);
        this.erJ.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pp(R.color.cp_link_tip_a);
        this.erJ.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.erI;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.erJ;
    }
}
