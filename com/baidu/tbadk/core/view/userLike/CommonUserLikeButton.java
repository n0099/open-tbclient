package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String bfi;
    protected String bfj;
    protected boolean bfk;
    private a bfl;
    private View.OnClickListener bfm;
    private boolean bfn;

    /* loaded from: classes.dex */
    public interface a {
        void gE(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bfi = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bfj = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bfk = false;
        this.bfn = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfi = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bfj = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bfk = false;
        this.bfn = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfi = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bfj = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bfk = false;
        this.bfn = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.t(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void bz(boolean z) {
        this.bfk = z;
        if (z) {
            setClickable(false);
            setText(this.bfi);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bfj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        bz(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void gD(int i) {
        if (this.bfl != null) {
            this.bfl.gE(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.bfm != null) {
            this.bfm.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bfk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this, d.C0141d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this, d.C0141d.btn_forum_focus_color);
        if (this.bfn) {
            aj.s(this, d.f.btn_transparent_focus_border_bg);
        } else {
            aj.s(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        f(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.bfl = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bfm = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bfn = z;
        aj.s(this, d.f.btn_transparent_focus_border_bg);
    }
}
