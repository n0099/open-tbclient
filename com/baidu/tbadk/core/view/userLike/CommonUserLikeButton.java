package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.f0.q.b;
/* loaded from: classes3.dex */
public class CommonUserLikeButton extends TextView implements b {

    /* renamed from: e  reason: collision with root package name */
    public String f13298e;

    /* renamed from: f  reason: collision with root package name */
    public String f13299f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13300g;

    /* renamed from: h  reason: collision with root package name */
    public a f13301h;
    public View.OnClickListener i;
    public boolean j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.f13298e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f13299f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f13300g = false;
        this.j = false;
        f();
    }

    public void a(boolean z, int i) {
        h(z);
    }

    @Override // d.b.h0.r.f0.q.b
    public void b(View view) {
        View.OnClickListener onClickListener = this.i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // d.b.h0.r.f0.q.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.b.h0.r.f0.q.b
    public void d(boolean z, int i, boolean z2) {
        a(z, i);
    }

    @Override // d.b.h0.r.f0.q.b
    public void e(int i) {
        a aVar = this.f13301h;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void f() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void g(int i) {
        if (this.f13300g) {
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
        this.f13300g = z;
        if (z) {
            setClickable(false);
            setText(this.f13298e);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.f13299f);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.j = z;
        SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }

    public void setFanNumCallBack(a aVar) {
        this.f13301h = aVar;
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13298e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f13299f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f13300g = false;
        this.j = false;
        f();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13298e = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.f13299f = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.f13300g = false;
        this.j = false;
        f();
    }
}
