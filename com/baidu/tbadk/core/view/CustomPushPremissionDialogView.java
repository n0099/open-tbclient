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
    private TextView ffD;
    private TBLottieAnimationView ffE;
    private View ffF;
    private View ffG;
    private TBSpecificationBtn ffH;
    private TBSpecificationBtn ffI;

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
        this.ffE = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.ffE.loop(true);
        this.ffE.setFrame(0);
        ap.a(this.ffE, R.raw.lottie_push_permission_dialog_animation);
        this.ffE.playAnimation();
        this.ffD = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.ffD.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.ffF = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.ffG = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.f.a.btu().oZ(1).pb(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).pa(273).x(R.color.CAM_X0804, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bv(this.ffG);
            ViewGroup.LayoutParams layoutParams2 = this.ffF.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.ffF.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).b("TOP_BOTTOM", ap.oA(R.color.common_color_10262), ap.oA(R.color.CAM_X0205)).bv(this.ffF);
        } else {
            com.baidu.tbadk.core.util.f.a.btv().oO(0).af(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ap.oA(R.color.CAM_X0205), ap.oA(R.color.CAM_X0205), ap.oA(R.color.CAM_X0205), ap.oA(R.color.CAM_X0205), ap.oA(R.color.CAM_X0211)).bv(this.ffF);
        }
        this.ffH = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.ffH.setTextSize(R.dimen.tbds34);
        this.ffH.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pT(R.color.CAM_X0105);
        this.ffH.setConfig(cVar);
        this.ffH.bup();
        this.ffI = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.ffI.setTextSize(R.dimen.tbds34);
        this.ffI.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pR(R.color.CAM_X0302);
        this.ffI.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.ffH;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.ffI;
    }
}
