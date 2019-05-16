package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String cci;
    protected String ccj;
    protected boolean cck;
    private View.OnClickListener ccl;
    private boolean ccm;
    private a ccv;

    /* loaded from: classes.dex */
    public interface a {
        void iZ(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.cci = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cck = false;
        this.ccm = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cci = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cck = false;
        this.ccm = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cci = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cck = false;
        this.ccm = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void er(boolean z) {
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

    public void f(boolean z, int i) {
        er(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void iY(int i) {
        if (this.ccv != null) {
            this.ccv.iZ(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aX(View view) {
        if (this.ccl != null) {
            this.ccl.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
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

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        f(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.ccv = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.ccl = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.ccm = z;
        al.k(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
