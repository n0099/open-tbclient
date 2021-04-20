package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.b.h0.r.f0.m.c;
/* loaded from: classes3.dex */
public class YoungsterFrsDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f13258e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13259f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f13260g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13261h;
    public TextView i;
    public TBSpecificationBtn j;
    public TBSpecificationBtn k;
    public NoTipAgainView l;

    public YoungsterFrsDialogView(Context context) {
        this(context, null);
    }

    public final void a() {
        LinearLayout.inflate(getContext(), R.layout.youngster_frs_dialog_view, this);
        this.f13258e = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.f13260g = (ImageView) findViewById(R.id.img_youngster_top);
        this.f13261h = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.i = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.f13259f = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.j = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        c cVar = new c();
        cVar.q(R.color.CAM_X0105);
        this.j.setConfig(cVar);
        this.k = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        c cVar2 = new c();
        cVar2.o(R.color.CAM_X0302);
        this.k.setConfig(cVar2);
        this.l = (NoTipAgainView) findViewById(R.id.no_tip_again);
        c();
    }

    public boolean b() {
        NoTipAgainView noTipAgainView = this.l;
        if (noTipAgainView == null) {
            return false;
        }
        return noTipAgainView.b();
    }

    public void c() {
        SkinManager.setBackgroundResource(this, R.drawable.transparent_bg);
        this.f13260g.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.f13261h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        this.l.c();
        SkinManager.setBackgroundResource(this.f13258e, R.drawable.dialog_background);
        this.j.k();
        this.k.k();
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn = this.j;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setText(getContext().getString(i));
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.l.setVisibility(z ? 0 : 8);
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn = this.k;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setText(getContext().getString(i));
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.i.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.f13261h.setText(getContext().getString(i));
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13259f.getLayoutParams();
        layoutParams.topMargin = i;
        this.f13259f.setLayoutParams(layoutParams);
    }

    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
