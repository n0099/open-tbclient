package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class SaveDraftDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13136e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13137f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13138g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13139h;
    public TextView i;
    public TextView j;
    public GradientDrawable k;

    public SaveDraftDialogView(Context context) {
        super(context);
        b(context);
    }

    public final void a() {
        SkinManager.setViewTextColor(this.f13137f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f13138g, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f13139h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
        if (this.k == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.k = gradientDrawable;
            gradientDrawable.setCornerRadii(new float[]{l.g(getContext(), R.dimen.tbds31), l.g(getContext(), R.dimen.tbds31), l.g(getContext(), R.dimen.tbds31), l.g(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.k.setColor(SkinManager.getColor(R.color.CAM_X0211));
        setBackground(this.k);
    }

    public final void b(Context context) {
        setOrientation(1);
        setPadding(0, 0, 0, l.g(context, R.dimen.tbds21));
        LinearLayout linearLayout = new LinearLayout(context);
        this.f13136e = linearLayout;
        linearLayout.setOrientation(1);
        this.f13136e.setGravity(17);
        addView(this.f13136e, -1, l.g(context, R.dimen.tbds182));
        int g2 = l.g(context, R.dimen.tbds44);
        TextView textView = new TextView(context);
        this.f13137f = textView;
        float f2 = g2;
        textView.setTextSize(0, f2);
        this.f13137f.setGravity(17);
        this.f13136e.addView(this.f13137f, -1, -2);
        TextView textView2 = new TextView(context);
        this.f13138g = textView2;
        textView2.setTextSize(0, l.g(context, R.dimen.tbds34));
        this.f13138g.setGravity(17);
        this.f13138g.setPadding(0, l.g(context, R.dimen.tbds10), 0, 0);
        this.f13136e.addView(this.f13138g, -1, -2);
        TextView textView3 = new TextView(context);
        this.f13139h = textView3;
        textView3.setId(R.id.save_draft_dialog_not_save);
        this.f13139h.setTextSize(0, f2);
        this.f13139h.setGravity(17);
        this.f13139h.setText(R.string.not_save);
        addView(this.f13139h, -1, l.g(context, R.dimen.tbds136));
        TextView textView4 = new TextView(context);
        this.i = textView4;
        textView4.setId(R.id.save_draft_dialog_save);
        this.i.setTextSize(0, f2);
        this.i.setGravity(17);
        addView(this.i, -1, l.g(context, R.dimen.tbds136));
        TextView textView5 = new TextView(context);
        this.j = textView5;
        textView5.setId(R.id.save_draft_dialog_cancle);
        this.j.setTextSize(0, f2);
        this.j.setGravity(17);
        this.j.setText(R.string.cancel);
        addView(this.j, -1, l.g(context, R.dimen.tbds136));
        a();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f13139h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.f13137f.setText(str);
        this.i.setText(str3);
        if (!k.isEmpty(str2)) {
            this.f13138g.setText(str2);
            this.f13138g.setVisibility(0);
            return;
        }
        this.f13138g.setVisibility(8);
    }

    public SaveDraftDialogView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public SaveDraftDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
    }
}
