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
    private TBSpecificationBtn eYA;
    private TextView eYv;
    private TBLottieAnimationView eYw;
    private View eYx;
    private View eYy;
    private TBSpecificationBtn eYz;

    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ev(context);
    }

    private void ev(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_push_premission_dialog_view, this);
        this.eYw = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
        this.eYw.loop(true);
        this.eYw.setFrame(0);
        ap.a(this.eYw, R.raw.lottie_push_permission_dialog_animation);
        this.eYw.playAnimation();
        this.eYv = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
        this.eYv.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eYx = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
        if (TbadkCoreApplication.getInst().getSkinType() == 0) {
            this.eYy = findViewById(R.id.animation_layout);
            com.baidu.tbadk.core.util.e.a.buy().qq(1).qs(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).qr(273).w(R.color.CAM_X0804, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22)).bq(this.eYy);
            ViewGroup.LayoutParams layoutParams2 = this.eYx.getLayoutParams();
            layoutParams2.width = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds774);
            this.eYx.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).b("TOP_BOTTOM", ap.pS(R.color.common_color_10262), ap.pS(R.color.CAM_X0205)).bq(this.eYx);
        } else {
            com.baidu.tbadk.core.util.e.a.buz().qf(0).ac(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26)).b("TOP_BOTTOM", ap.pS(R.color.CAM_X0205), ap.pS(R.color.CAM_X0205), ap.pS(R.color.CAM_X0205), ap.pS(R.color.CAM_X0205), ap.pS(R.color.CAM_X0211)).bq(this.eYx);
        }
        this.eYz = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
        this.eYz.setTextSize(R.dimen.tbds34);
        this.eYz.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rj(R.color.CAM_X0105);
        this.eYz.setConfig(cVar);
        this.eYz.bvt();
        this.eYA = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
        this.eYA.setTextSize(R.dimen.tbds34);
        this.eYA.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rh(R.color.CAM_X0302);
        this.eYA.setConfig(cVar2);
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        return this.eYz;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        return this.eYA;
    }
}
