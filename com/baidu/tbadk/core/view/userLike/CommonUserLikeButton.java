package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String bUl;
    protected String bUm;
    protected boolean bUn;
    private View.OnClickListener bUo;
    private boolean bUp;
    private a bUx;

    /* loaded from: classes.dex */
    public interface a {
        void im(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bUl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUn = false;
        this.bUp = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUn = false;
        this.bUp = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUn = false;
        this.bUp = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.h(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void dU(boolean z) {
        this.bUn = z;
        if (z) {
            setClickable(false);
            setText(this.bUl);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bUm);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        dU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void il(int i) {
        if (this.bUx != null) {
            this.bUx.im(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aR(View view) {
        if (this.bUo != null) {
            this.bUo.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bUn) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this, d.C0277d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(this, d.C0277d.btn_forum_focus_color);
        if (this.bUp) {
            al.k(this, d.f.btn_transparent_focus_border_bg);
        } else {
            al.k(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        f(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.bUx = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bUo = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bUp = z;
        al.k(this, d.f.btn_transparent_focus_border_bg);
    }
}
