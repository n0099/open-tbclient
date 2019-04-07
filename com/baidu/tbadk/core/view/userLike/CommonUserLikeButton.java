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
    protected String bUn;
    protected String bUo;
    protected boolean bUp;
    private View.OnClickListener bUq;
    private boolean bUr;
    private a bUz;

    /* loaded from: classes.dex */
    public interface a {
        void il(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bUn = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUp = false;
        this.bUr = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUn = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUp = false;
        this.bUr = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUn = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUp = false;
        this.bUr = false;
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
        this.bUp = z;
        if (z) {
            setClickable(false);
            setText(this.bUn);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bUo);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        dU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ik(int i) {
        if (this.bUz != null) {
            this.bUz.il(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aR(View view) {
        if (this.bUq != null) {
            this.bUq.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bUp) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this, d.C0277d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(this, d.C0277d.btn_forum_focus_color);
        if (this.bUr) {
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
        this.bUz = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bUq = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bUr = z;
        al.k(this, d.f.btn_transparent_focus_border_bg);
    }
}
