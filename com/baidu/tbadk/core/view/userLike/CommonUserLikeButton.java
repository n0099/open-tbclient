package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String fnr;
    protected String fns;
    protected boolean fnt;
    private View.OnClickListener fnu;
    private boolean fnv;
    private a fox;

    /* loaded from: classes.dex */
    public interface a {
        void qc(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.fnr = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fns = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fnt = false;
        this.fnv = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnr = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fns = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fnt = false;
        this.fnv = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnr = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fns = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fnt = false;
        this.fnv = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void aM(boolean z) {
        this.fnt = z;
        if (z) {
            setClickable(false);
            setText(this.fnr);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.fns);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qb(int i) {
        if (this.fox != null) {
            this.fox.qc(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bG(View view) {
        if (this.fnu != null) {
            this.fnu.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.fnt) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.fnv) {
            ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ap.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(boolean z, int i, boolean z2) {
        r(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.fox = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.fnu = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.fnv = z;
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
