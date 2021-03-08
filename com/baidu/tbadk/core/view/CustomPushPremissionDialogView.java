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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CustomPushPremissionDialogView extends LinearLayout {
    private TextView fhc;
    private TBLottieAnimationView fhd;
    private View fhe;
    private View fhf;
    private TBSpecificationBtn fhg;
    private TBSpecificationBtn fhh;

    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_push_premission_dialog_view, this);
        this.fhd = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.fhd.loop(true);
        this.fhd.setFrame(0);
        ap.a(this.fhd, R.raw.lottie_push_permission_dialog_animation);
        this.fhd.playAnimation();
        this.fhc = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.fhc.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.fhe = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.fhf = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.f.a.btx().pa(1).pc(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).pb(273).x(R.color.CAM_X0804, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bv(this.fhf);
            ViewGroup.LayoutParams layoutParams2 = this.fhe.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.fhe.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).b("TOP_BOTTOM", ap.oB(R.color.common_color_10262), ap.oB(R.color.CAM_X0205)).bv(this.fhe);
        } else {
            com.baidu.tbadk.core.util.f.a.bty().oP(0).aj(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ap.oB(R.color.CAM_X0205), ap.oB(R.color.CAM_X0205), ap.oB(R.color.CAM_X0205), ap.oB(R.color.CAM_X0205), ap.oB(R.color.CAM_X0211)).bv(this.fhe);
        }
        this.fhg = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.fhg.setTextSize(R.dimen.tbds34);
        this.fhg.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pU(R.color.CAM_X0105);
        this.fhg.setConfig(cVar);
        this.fhg.bus();
        this.fhh = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.fhh.setTextSize(R.dimen.tbds34);
        this.fhh.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pS(R.color.CAM_X0302);
        this.fhh.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.fhg;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.fhh;
    }
}
