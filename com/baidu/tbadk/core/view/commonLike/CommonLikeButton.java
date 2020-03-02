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
    protected String djP;
    protected String djQ;
    protected boolean djR;
    private View.OnClickListener djS;
    private boolean djT;

    public CommonLikeButton(Context context) {
        super(context);
        this.djP = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.djQ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.djR = false;
        this.djT = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djP = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.djQ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.djR = false;
        this.djT = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.djP = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.djQ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.djR = false;
        this.djT = false;
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
        this.djR = z;
        if (z) {
            setClickable(false);
            setText(this.djP);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.djQ);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void ba(View view) {
        if (this.djS != null) {
            this.djS.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.djR) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.djT) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.djS = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.djT = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
