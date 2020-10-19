package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String eLk;
    protected String eLl;
    protected boolean eLm;
    private View.OnClickListener eLn;
    private boolean eLo;

    public CommonLikeButton(Context context) {
        super(context);
        this.eLk = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eLl = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.eLm = false;
        this.eLo = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLk = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eLl = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.eLm = false;
        this.eLo = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eLk = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eLl = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.eLm = false;
        this.eLo = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aN(boolean z) {
        setVisibility(0);
        this.eLm = z;
        if (z) {
            setClickable(false);
            setText(this.eLk);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.eLl);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void bq(View view) {
        if (this.eLn != null) {
            this.eLn.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.eLm) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.eLo) {
            ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ap.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.eLn = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.eLo = z;
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
