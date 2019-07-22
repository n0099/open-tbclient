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
    protected String cdm;
    protected String cdn;
    protected boolean cdo;
    private View.OnClickListener cdp;
    private boolean cdq;

    public CommonLikeButton(Context context) {
        super(context);
        this.cdm = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cdn = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cdo = false;
        this.cdq = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdm = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cdn = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cdo = false;
        this.cdq = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdm = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cdn = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cdo = false;
        this.cdq = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void ev(boolean z) {
        setVisibility(0);
        this.cdo = z;
        if (z) {
            setClickable(false);
            setText(this.cdm);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.cdn);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aZ(View view) {
        if (this.cdp != null) {
            this.cdp.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.cdo) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.j(this, R.color.btn_forum_focus_color);
        if (this.cdq) {
            am.k(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.k(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.cdp = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.cdq = z;
        am.k(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
