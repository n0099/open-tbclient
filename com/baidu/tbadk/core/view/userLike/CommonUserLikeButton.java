package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String djP;
    protected String djQ;
    protected boolean djR;
    private View.OnClickListener djS;
    private boolean djT;
    private a dkd;

    /* loaded from: classes.dex */
    public interface a {
        void ly(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.djP = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.djQ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.djR = false;
        this.djT = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djP = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.djQ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.djR = false;
        this.djT = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.djP = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.djQ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.djR = false;
        this.djT = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void fU(boolean z) {
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

    public void m(boolean z, int i) {
        fU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lx(int i) {
        if (this.dkd != null) {
            this.dkd.ly(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ba(View view) {
        if (this.djS != null) {
            this.djS.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
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

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        m(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.dkd = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.djS = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.djT = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
