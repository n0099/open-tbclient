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
    protected String dkp;
    protected String dkq;
    protected boolean dkr;
    private View.OnClickListener dks;
    private boolean dkt;

    public CommonLikeButton(Context context) {
        super(context);
        this.dkp = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dkq = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dkr = false;
        this.dkt = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkp = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dkq = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dkr = false;
        this.dkt = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkp = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dkq = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dkr = false;
        this.dkt = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void fV(boolean z) {
        setVisibility(0);
        this.dkr = z;
        if (z) {
            setClickable(false);
            setText(this.dkp);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dkq);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void ba(View view) {
        if (this.dks != null) {
            this.dks.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dkr) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dkt) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dks = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dkt = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
