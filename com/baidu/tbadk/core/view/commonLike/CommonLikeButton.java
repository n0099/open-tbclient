package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String crJ;
    protected String crK;
    protected boolean crL;
    private View.OnClickListener crM;
    private boolean crN;

    public CommonLikeButton(Context context) {
        super(context);
        this.crJ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.crK = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.crL = false;
        this.crN = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crJ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.crK = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.crL = false;
        this.crN = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crJ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.crK = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.crL = false;
        this.crN = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void ew(boolean z) {
        setVisibility(0);
        this.crL = z;
        if (z) {
            setClickable(false);
            setText(this.crJ);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.crK);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aZ(View view) {
        if (this.crM != null) {
            this.crM.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void f(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.crL) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.crN) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.crM = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.crN = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
