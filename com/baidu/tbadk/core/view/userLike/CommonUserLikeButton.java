package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.r.f0.q.b;
/* loaded from: classes3.dex */
public class CommonUserLikeButton extends TextView implements b {

    /* renamed from: e  reason: collision with root package name */
    public String f12605e;

    /* renamed from: f  reason: collision with root package name */
    public String f12606f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12607g;

    /* renamed from: h  reason: collision with root package name */
    public a f12608h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f12609i;
    public boolean j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.f12605e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f12606f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f12607g = false;
        this.j = false;
        f();
    }

    @Override // d.a.j0.r.f0.q.b
    public void a(boolean z, int i2, boolean z2) {
        e(z, i2);
    }

    @Override // d.a.j0.r.f0.q.b
    public void b(View view) {
        View.OnClickListener onClickListener = this.f12609i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // d.a.j0.r.f0.q.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.a.j0.r.f0.q.b
    public void d(int i2) {
        a aVar = this.f12608h;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void e(boolean z, int i2) {
        h(z);
    }

    public void f() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void g(int i2) {
        if (this.f12607g) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.j) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            SkinManager.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void h(boolean z) {
        this.f12607g = z;
        if (z) {
            setClickable(false);
            setText(this.f12605e);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.f12606f);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.f12609i = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.j = z;
        SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }

    public void setFanNumCallBack(a aVar) {
        this.f12608h = aVar;
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12605e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f12606f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f12607g = false;
        this.j = false;
        f();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12605e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f12606f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f12607g = false;
        this.j = false;
        f();
    }
}
