package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String azA;
    protected boolean azB;
    private a azC;
    private View.OnClickListener azD;
    private boolean azE;
    protected String azz;

    /* loaded from: classes.dex */
    public interface a {
        void dG(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.azz = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.azA = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.azB = false;
        this.azE = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azz = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.azA = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.azB = false;
        this.azE = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azz = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.azA = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.azB = false;
        this.azE = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.e(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void aX(boolean z) {
        this.azB = z;
        if (z) {
            setClickable(false);
            setText(this.azz);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.azA);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        aX(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dF(int i) {
        if (this.azC != null) {
            this.azC.dG(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void L(View view) {
        if (this.azD != null) {
            this.azD.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.azB) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, d.C0142d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this, d.C0142d.btn_forum_focus_color);
        if (this.azE) {
            am.i(this, d.f.btn_transparent_focus_border_bg);
        } else {
            am.i(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.azC = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.azD = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.azE = z;
        am.i(this, d.f.btn_transparent_focus_border_bg);
    }
}
