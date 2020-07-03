package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String egF;
    protected String egG;
    protected boolean egH;
    private View.OnClickListener egI;
    private boolean egJ;

    public CommonLikeButton(Context context) {
        super(context);
        this.egF = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.egG = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.egH = false;
        this.egJ = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egF = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.egG = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.egH = false;
        this.egJ = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egF = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.egG = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.egH = false;
        this.egJ = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void hA(boolean z) {
        setVisibility(0);
        this.egH = z;
        if (z) {
            setClickable(false);
            setText(this.egF);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.egG);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void bc(View view) {
        if (this.egI != null) {
            this.egI.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.egH) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            an.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        an.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.egJ) {
            an.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            an.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.egI = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.egJ = z;
        an.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
