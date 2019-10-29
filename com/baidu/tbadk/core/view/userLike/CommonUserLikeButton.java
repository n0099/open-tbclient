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
    protected String csA;
    protected String csB;
    protected boolean csC;
    private View.OnClickListener csD;
    private boolean csE;
    private a csM;

    /* loaded from: classes.dex */
    public interface a {
        void iV(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.csA = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.csB = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.csC = false;
        this.csE = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csA = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.csB = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.csC = false;
        this.csE = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csA = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.csB = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.csC = false;
        this.csE = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void ew(boolean z) {
        this.csC = z;
        if (z) {
            setClickable(false);
            setText(this.csA);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.csB);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void g(boolean z, int i) {
        ew(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void iU(int i) {
        if (this.csM != null) {
            this.csM.iV(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        if (this.csD != null) {
            this.csD.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void f(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.csC) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.csE) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        g(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.csM = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.csD = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.csE = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
