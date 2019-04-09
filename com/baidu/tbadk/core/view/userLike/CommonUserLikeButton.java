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
    private a bUA;
    protected String bUo;
    protected String bUp;
    protected boolean bUq;
    private View.OnClickListener bUr;
    private boolean bUs;

    /* loaded from: classes.dex */
    public interface a {
        void il(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUp = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUq = false;
        this.bUs = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUp = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUq = false;
        this.bUs = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUp = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUq = false;
        this.bUs = false;
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
        this.bUq = z;
        if (z) {
            setClickable(false);
            setText(this.bUo);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bUp);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        dU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ik(int i) {
        if (this.bUA != null) {
            this.bUA.il(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aR(View view) {
        if (this.bUr != null) {
            this.bUr.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bUq) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this, d.C0277d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(this, d.C0277d.btn_forum_focus_color);
        if (this.bUs) {
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
        this.bUA = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bUr = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bUs = z;
        al.k(this, d.f.btn_transparent_focus_border_bg);
    }
}
