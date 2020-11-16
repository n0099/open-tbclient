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
    private TextView eRc;
    private TBLottieAnimationView eRd;
    private View eRe;
    private View eRf;
    private TBSpecificationBtn eRg;
    private TBSpecificationBtn eRh;

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
        gradientDrawable.setColor(ap.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_push_premission_dialog_view, this);
        this.eRd = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.eRd.loop(true);
        this.eRd.setFrame(0);
        ap.a(this.eRd, R.raw.lottie_push_permission_dialog_animation);
        this.eRd.playAnimation();
        this.eRc = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.eRc.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eRe = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.eRf = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.e.a.brb().pQ(1).pS(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).pR(273).s(R.color.CAM_X0804, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bn(this.eRf);
            ViewGroup.LayoutParams layoutParams2 = this.eRe.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.eRe.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).b("TOP_BOTTOM", ap.ps(R.color.common_color_10262), ap.ps(R.color.CAM_X0205)).bn(this.eRe);
        } else {
            com.baidu.tbadk.core.util.e.a.brc().pF(0).ac(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ap.ps(R.color.CAM_X0205), ap.ps(R.color.CAM_X0205), ap.ps(R.color.CAM_X0205), ap.ps(R.color.CAM_X0205), ap.ps(R.color.CAM_X0211)).bn(this.eRe);
        }
        this.eRg = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.eRg.setTextSize(R.dimen.tbds34);
        this.eRg.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qI(R.color.CAM_X0105);
        this.eRg.setConfig(cVar);
        this.eRg.brT();
        this.eRh = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.eRh.setTextSize(R.dimen.tbds34);
        this.eRh.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.qG(R.color.CAM_X0302);
        this.eRh.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.eRg;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.eRh;
    }
}
