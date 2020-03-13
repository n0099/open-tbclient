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
    protected String dkc;
    protected String dkd;
    protected boolean dke;
    private View.OnClickListener dkf;
    private boolean dkg;

    public CommonLikeButton(Context context) {
        super(context);
        this.dkc = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dkd = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dke = false;
        this.dkg = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkc = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dkd = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dke = false;
        this.dkg = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkc = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dkd = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dke = false;
        this.dkg = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void fU(boolean z) {
        setVisibility(0);
        this.dke = z;
        if (z) {
            setClickable(false);
            setText(this.dkc);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dkd);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void ba(View view) {
        if (this.dkf != null) {
            this.dkf.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dke) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dkg) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dkf = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dkg = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
