package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.r.f0.n.b;
/* loaded from: classes3.dex */
public class CommonLikeButton extends AppCompatTextView implements b {

    /* renamed from: e  reason: collision with root package name */
    public String f13613e;

    /* renamed from: f  reason: collision with root package name */
    public String f13614f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13615g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f13616h;
    public boolean i;

    public CommonLikeButton(Context context) {
        super(context);
        this.f13613e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f13614f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f13615g = false;
        this.i = false;
        f();
    }

    @Override // d.b.h0.r.f0.n.b
    public void b(View view) {
        View.OnClickListener onClickListener = this.f13616h;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // d.b.h0.r.f0.n.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.b.h0.r.f0.n.b
    public void e(boolean z) {
        setVisibility(0);
        this.f13615g = z;
        if (z) {
            setClickable(false);
            setText(this.f13613e);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.f13614f);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    public void g(int i) {
        if (this.f13615g) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.i) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            SkinManager.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.f13616h = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.i = z;
        SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13613e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f13614f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f13615g = false;
        this.i = false;
        f();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13613e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f13614f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f13615g = false;
        this.i = false;
        f();
    }
}
