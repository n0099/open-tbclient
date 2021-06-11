package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.r.f0.n.b;
/* loaded from: classes3.dex */
public class CommonLikeButton extends AppCompatTextView implements b {

    /* renamed from: e  reason: collision with root package name */
    public String f12550e;

    /* renamed from: f  reason: collision with root package name */
    public String f12551f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12552g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f12553h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12554i;

    public CommonLikeButton(Context context) {
        super(context);
        this.f12550e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f12551f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f12552g = false;
        this.f12554i = false;
        d();
    }

    @Override // d.a.m0.r.f0.n.b
    public void a(View view) {
        View.OnClickListener onClickListener = this.f12553h;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // d.a.m0.r.f0.n.b
    public void b(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.a.m0.r.f0.n.b
    public void c(boolean z) {
        setVisibility(0);
        this.f12552g = z;
        if (z) {
            setClickable(false);
            setText(this.f12550e);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.f12551f);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    public void e(int i2) {
        if (this.f12552g) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.f12554i) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            SkinManager.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.f12553h = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.f12554i = z;
        SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12550e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f12551f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f12552g = false;
        this.f12554i = false;
        d();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12550e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f12551f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f12552g = false;
        this.f12554i = false;
        d();
    }
}
