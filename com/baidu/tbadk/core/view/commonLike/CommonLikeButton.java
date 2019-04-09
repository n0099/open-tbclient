package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String bUo;
    protected String bUp;
    protected boolean bUq;
    private View.OnClickListener bUr;
    private boolean bUs;

    public CommonLikeButton(Context context) {
        super(context);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUp = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUq = false;
        this.bUs = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUp = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUq = false;
        this.bUs = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUo = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bUp = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bUq = false;
        this.bUs = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.h(getContext(), d.e.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void dU(boolean z) {
        setVisibility(0);
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

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aR(View view) {
        if (this.bUr != null) {
            this.bUr.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
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

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bUr = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bUs = z;
        al.k(this, d.f.btn_transparent_focus_border_bg);
    }
}
