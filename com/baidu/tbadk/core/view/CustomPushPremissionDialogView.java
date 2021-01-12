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
    private TextView fdo;
    private TBLottieAnimationView fdp;
    private View fdq;
    private View fdr;
    private TBSpecificationBtn fds;
    private TBSpecificationBtn fdt;

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
        gradientDrawable.setColor(ao.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_push_premission_dialog_view, this);
        this.fdp = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.fdp.loop(true);
        this.fdp.setFrame(0);
        ao.a(this.fdp, R.raw.lottie_push_permission_dialog_animation);
        this.fdp.playAnimation();
        this.fdo = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.fdo.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.fdq = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.fdr = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.f.a.bta().oU(1).oW(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).oV(273).x(R.color.CAM_X0804, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bz(this.fdr);
            ViewGroup.LayoutParams layoutParams2 = this.fdq.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.fdq.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).b("TOP_BOTTOM", ao.ov(R.color.common_color_10262), ao.ov(R.color.CAM_X0205)).bz(this.fdq);
        } else {
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).ae(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ao.ov(R.color.CAM_X0205), ao.ov(R.color.CAM_X0205), ao.ov(R.color.CAM_X0205), ao.ov(R.color.CAM_X0205), ao.ov(R.color.CAM_X0211)).bz(this.fdq);
        }
        this.fds = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.fds.setTextSize(R.dimen.tbds34);
        this.fds.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pO(R.color.CAM_X0105);
        this.fds.setConfig(cVar);
        this.fds.btV();
        this.fdt = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.fdt.setTextSize(R.dimen.tbds34);
        this.fdt.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pM(R.color.CAM_X0302);
        this.fdt.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.fds;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.fdt;
    }
}
