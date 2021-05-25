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
import d.a.m0.r.f0.m.c;
/* loaded from: classes3.dex */
public class YoungsterFrsDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f12468e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f12469f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f12470g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12471h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12472i;
    public TBSpecificationBtn j;
    public TBSpecificationBtn k;
    public NoTipAgainView l;

    public YoungsterFrsDialogView(Context context) {
        this(context, null);
    }

    public final void a() {
        LinearLayout.inflate(getContext(), R.layout.youngster_frs_dialog_view, this);
        this.f12468e = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.f12470g = (ImageView) findViewById(R.id.img_youngster_top);
        this.f12471h = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.f12472i = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.f12469f = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.j = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        c cVar = new c();
        cVar.q(R.color.CAM_X0105);
        this.j.setConfig(cVar);
        this.k = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        c cVar2 = new c();
        cVar2.o(R.color.CAM_X0304);
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
        this.f12470g.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.pic_mask_qingshaonian_time, WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.f12471h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f12472i, R.color.CAM_X0107);
        this.l.c();
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f12468e);
        d2.m(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
        this.j.k();
        this.k.k();
    }

    public void setLeftOnClickListener(int i2, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn = this.j;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setText(getContext().getString(i2));
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.l.setVisibility(z ? 0 : 8);
    }

    public void setRightOnClickListener(int i2, View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn = this.k;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setText(getContext().getString(i2));
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void setTxtYoungsterDialogContentText(int i2) {
        this.f12472i.setText(getContext().getString(i2));
    }

    public void setTxtYoungsterDialogTitleText(int i2) {
        this.f12471h.setText(getContext().getString(i2));
    }

    public void setYoungsterDialogGroupMarginTop(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12469f.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f12469f.setLayoutParams(layoutParams);
    }

    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
