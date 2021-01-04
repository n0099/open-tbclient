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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CustomPushPremissionDialogView extends LinearLayout {
    private TextView fhW;
    private TBLottieAnimationView fhX;
    private View fhY;
    private View fhZ;
    private TBSpecificationBtn fia;
    private TBSpecificationBtn fib;

    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        eO(context);
    }

    private void eO(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ao.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_push_premission_dialog_view, this);
        this.fhX = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.fhX.loop(true);
        this.fhX.setFrame(0);
        ao.a(this.fhX, R.raw.lottie_push_permission_dialog_animation);
        this.fhX.playAnimation();
        this.fhW = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.fhW.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.fhY = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.fhZ = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.f.a.bwT().qB(1).qD(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).qC(273).x(R.color.CAM_X0804, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bz(this.fhZ);
            ViewGroup.LayoutParams layoutParams2 = this.fhY.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.fhY.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).b("TOP_BOTTOM", ao.qc(R.color.common_color_10262), ao.qc(R.color.CAM_X0205)).bz(this.fhY);
        } else {
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).ae(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ao.qc(R.color.CAM_X0205), ao.qc(R.color.CAM_X0205), ao.qc(R.color.CAM_X0205), ao.qc(R.color.CAM_X0205), ao.qc(R.color.CAM_X0211)).bz(this.fhY);
        }
        this.fia = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.fia.setTextSize(R.dimen.tbds34);
        this.fia.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.ru(R.color.CAM_X0105);
        this.fia.setConfig(cVar);
        this.fia.bxO();
        this.fib = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.fib.setTextSize(R.dimen.tbds34);
        this.fib.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rs(R.color.CAM_X0302);
        this.fib.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.fia;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.fib;
    }
}
