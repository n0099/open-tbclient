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
    private boolean dfA;
    protected String dfw;
    protected String dfx;
    protected boolean dfy;
    private View.OnClickListener dfz;

    public CommonLikeButton(Context context) {
        super(context);
        this.dfw = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfx = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfy = false;
        this.dfA = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfw = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfx = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfy = false;
        this.dfA = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfw = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfx = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfy = false;
        this.dfA = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void fI(boolean z) {
        setVisibility(0);
        this.dfy = z;
        if (z) {
            setClickable(false);
            setText(this.dfw);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dfx);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aW(View view) {
        if (this.dfz != null) {
            this.dfz.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dfy) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dfA) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dfz = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dfA = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
