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
    protected String dYD;
    protected String dYE;
    protected boolean dYF;
    private View.OnClickListener dYG;
    private boolean dYH;
    private a dYS;

    /* loaded from: classes.dex */
    public interface a {
        void mp(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.dYD = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dYE = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dYF = false;
        this.dYH = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYD = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dYE = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dYF = false;
        this.dYH = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYD = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dYE = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dYF = false;
        this.dYH = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void hr(boolean z) {
        this.dYF = z;
        if (z) {
            setClickable(false);
            setText(this.dYD);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dYE);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void r(boolean z, int i) {
        hr(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void mo(int i) {
        if (this.dYS != null) {
            this.dYS.mp(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.dYG != null) {
            this.dYG.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dYF) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dYH) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.dYS = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dYG = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dYH = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
