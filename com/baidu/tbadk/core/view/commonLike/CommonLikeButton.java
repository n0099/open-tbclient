package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String emO;
    protected String emP;
    protected boolean emQ;
    private View.OnClickListener emR;
    private boolean emS;

    public CommonLikeButton(Context context) {
        super(context);
        this.emO = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.emP = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.emQ = false;
        this.emS = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emO = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.emP = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.emQ = false;
        this.emS = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emO = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.emP = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.emQ = false;
        this.emS = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aM(boolean z) {
        setVisibility(0);
        this.emQ = z;
        if (z) {
            setClickable(false);
            setText(this.emO);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.emP);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void bi(View view) {
        if (this.emR != null) {
            this.emR.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.emQ) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.emS) {
            ao.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ao.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.emR = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.emS = z;
        ao.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
