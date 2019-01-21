package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String aLL;
    protected String aLM;
    protected boolean aLN;
    private View.OnClickListener aLO;
    private boolean aLP;

    public CommonLikeButton(Context context) {
        super(context);
        this.aLL = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLM = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLN = false;
        this.aLP = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLL = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLM = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLN = false;
        this.aLP = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLL = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLM = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLN = false;
        this.aLP = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.h(getContext(), e.C0210e.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void bL(boolean z) {
        setVisibility(0);
        this.aLN = z;
        if (z) {
            setClickable(false);
            setText(this.aLL);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aLM);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void X(View view) {
        if (this.aLO != null) {
            this.aLO.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void d(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aLN) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, e.d.btn_forum_focus_color);
        if (this.aLP) {
            al.i(this, e.f.btn_transparent_focus_border_bg);
        } else {
            al.i(this, e.f.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aLO = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aLP = z;
        al.i(this, e.f.btn_transparent_focus_border_bg);
    }
}
