package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String ayH;
    protected String ayI;
    protected boolean ayJ;
    private a ayK;
    private View.OnClickListener ayL;
    private boolean ayM;

    /* loaded from: classes.dex */
    public interface a {
        void dF(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.ayH = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.ayI = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.ayJ = false;
        this.ayM = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayH = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.ayI = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.ayJ = false;
        this.ayM = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayH = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.ayI = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.ayJ = false;
        this.ayM = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.e(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void aU(boolean z) {
        this.ayJ = z;
        if (z) {
            setClickable(false);
            setText(this.ayH);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.ayI);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        aU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dE(int i) {
        if (this.ayK != null) {
            this.ayK.dF(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void K(View view) {
        if (this.ayL != null) {
            this.ayL.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ayJ) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, d.C0141d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, d.C0141d.btn_forum_focus_color);
        if (this.ayM) {
            al.i(this, d.f.btn_transparent_focus_border_bg);
        } else {
            al.i(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.ayK = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.ayL = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.ayM = z;
        al.i(this, d.f.btn_transparent_focus_border_bg);
    }
}
