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
    protected String dKn;
    protected String dKo;
    protected boolean dKp;
    private View.OnClickListener dKq;
    private boolean dKr;

    public CommonLikeButton(Context context) {
        super(context);
        this.dKn = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKo = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKp = false;
        this.dKr = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKn = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKo = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKp = false;
        this.dKr = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dKn = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKo = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKp = false;
        this.dKr = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void gT(boolean z) {
        setVisibility(0);
        this.dKp = z;
        if (z) {
            setClickable(false);
            setText(this.dKn);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dKo);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void bb(View view) {
        if (this.dKq != null) {
            this.dKq.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dKp) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dKr) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dKq = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dKr = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
