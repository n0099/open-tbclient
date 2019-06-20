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
    protected String ccj;
    protected String cck;
    protected boolean ccl;
    private View.OnClickListener ccm;
    private boolean ccn;
    private a ccw;

    /* loaded from: classes.dex */
    public interface a {
        void iZ(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cck = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ccl = false;
        this.ccn = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cck = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ccl = false;
        this.ccn = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccj = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cck = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ccl = false;
        this.ccn = false;
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
        this.ccl = z;
        if (z) {
            setClickable(false);
            setText(this.ccj);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.cck);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        er(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void iY(int i) {
        if (this.ccw != null) {
            this.ccw.iZ(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aX(View view) {
        if (this.ccm != null) {
            this.ccm.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ccl) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(this, R.color.btn_forum_focus_color);
        if (this.ccn) {
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
        this.ccw = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.ccm = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.ccn = z;
        al.k(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
