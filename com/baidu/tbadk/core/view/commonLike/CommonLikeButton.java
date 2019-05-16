package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String cci;
    protected String ccj;
    protected boolean cck;
    private View.OnClickListener ccl;
    private boolean ccm;

    public CommonLikeButton(Context context) {
        super(context);
        this.cci = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cck = false;
        this.ccm = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cci = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cck = false;
        this.ccm = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cci = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cck = false;
        this.ccm = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void er(boolean z) {
        setVisibility(0);
        this.cck = z;
        if (z) {
            setClickable(false);
            setText(this.cci);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.ccj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aX(View view) {
        if (this.ccl != null) {
            this.ccl.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.cck) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(this, R.color.btn_forum_focus_color);
        if (this.ccm) {
            al.k(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            al.k(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.ccl = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.ccm = z;
        al.k(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
