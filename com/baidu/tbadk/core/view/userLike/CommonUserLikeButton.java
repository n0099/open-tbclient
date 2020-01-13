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
    protected String dfI;
    protected String dfJ;
    protected boolean dfK;
    private View.OnClickListener dfL;
    private boolean dfM;
    private a dfW;

    /* loaded from: classes.dex */
    public interface a {
        void lh(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.dfI = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfJ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfK = false;
        this.dfM = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfI = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfJ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfK = false;
        this.dfM = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfI = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfJ = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfK = false;
        this.dfM = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void fN(boolean z) {
        this.dfK = z;
        if (z) {
            setClickable(false);
            setText(this.dfI);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dfJ);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(boolean z, int i) {
        fN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lg(int i) {
        if (this.dfW != null) {
            this.dfW.lh(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ba(View view) {
        if (this.dfL != null) {
            this.dfL.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dfK) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dfM) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        l(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.dfW = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dfL = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dfM = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
