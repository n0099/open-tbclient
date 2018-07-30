package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String azl;
    protected String azm;
    protected boolean azn;
    private View.OnClickListener azo;
    private boolean azp;
    private a azx;

    /* loaded from: classes.dex */
    public interface a {
        void dJ(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.azl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.azm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.azn = false;
        this.azp = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.azm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.azn = false;
        this.azp = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.azm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.azn = false;
        this.azp = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.f(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void aV(boolean z) {
        this.azn = z;
        if (z) {
            setClickable(false);
            setText(this.azl);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.azm);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        aV(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dI(int i) {
        if (this.azx != null) {
            this.azx.dJ(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void L(View view) {
        if (this.azo != null) {
            this.azo.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.azn) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, d.C0140d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this, d.C0140d.btn_forum_focus_color);
        if (this.azp) {
            am.i(this, d.f.btn_transparent_focus_border_bg);
        } else {
            am.i(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.azx = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.azo = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.azp = z;
        am.i(this, d.f.btn_transparent_focus_border_bg);
    }
}
