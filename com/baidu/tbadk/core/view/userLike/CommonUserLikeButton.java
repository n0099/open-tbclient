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
    protected String bUk;
    protected String bUl;
    protected boolean bUm;
    private View.OnClickListener bUn;
    private boolean bUo;
    private a bUw;

    /* loaded from: classes.dex */
    public interface a {
        void im(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bUk = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUl = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUm = false;
        this.bUo = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUk = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUl = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUm = false;
        this.bUo = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUk = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUl = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUm = false;
        this.bUo = false;
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
        this.bUm = z;
        if (z) {
            setClickable(false);
            setText(this.bUk);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bUl);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        dU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void il(int i) {
        if (this.bUw != null) {
            this.bUw.im(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aR(View view) {
        if (this.bUn != null) {
            this.bUn.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bUm) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this, d.C0236d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(this, d.C0236d.btn_forum_focus_color);
        if (this.bUo) {
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
        this.bUw = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bUn = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bUo = z;
        al.k(this, d.f.btn_transparent_focus_border_bg);
    }
}
