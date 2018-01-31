package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String bdB;
    protected String bdC;
    protected boolean bdD;
    private a bdE;
    private View.OnClickListener bdF;
    private boolean bdG;

    /* loaded from: classes.dex */
    public interface a {
        void gC(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bdB = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdC = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdD = false;
        this.bdG = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdB = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdC = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdD = false;
        this.bdG = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdB = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdC = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdD = false;
        this.bdG = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.s(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void bu(boolean z) {
        this.bdD = z;
        if (z) {
            setClickable(false);
            setText(this.bdB);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bdC);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        bu(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void gB(int i) {
        if (this.bdE != null) {
            this.bdE.gC(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.bdF != null) {
            this.bdF.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bdD) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this, d.C0108d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this, d.C0108d.btn_forum_focus_color);
        if (this.bdG) {
            aj.s(this, d.f.btn_transparent_focus_border_bg);
        } else {
            aj.s(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        f(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.bdE = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bdF = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bdG = z;
        aj.s(this, d.f.btn_transparent_focus_border_bg);
    }
}
