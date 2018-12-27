package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String aLi;
    protected String aLj;
    protected boolean aLk;
    private View.OnClickListener aLl;
    private boolean aLm;
    private a aLu;

    /* loaded from: classes.dex */
    public interface a {
        void eG(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aLi = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLj = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLk = false;
        this.aLm = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLi = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLj = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLk = false;
        this.aLm = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLi = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLj = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLk = false;
        this.aLm = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.h(getContext(), e.C0210e.ds28));
        setGravity(17);
    }

    public void bK(boolean z) {
        this.aLk = z;
        if (z) {
            setClickable(false);
            setText(this.aLi);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aLj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        bK(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void eF(int i) {
        if (this.aLu != null) {
            this.aLu.eG(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        if (this.aLl != null) {
            this.aLl.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aLk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, e.d.btn_forum_focus_color);
        if (this.aLm) {
            al.i(this, e.f.btn_transparent_focus_border_bg);
        } else {
            al.i(this, e.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.aLu = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aLm = z;
        al.i(this, e.f.btn_transparent_focus_border_bg);
    }
}
