package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String aGQ;
    protected String aGR;
    protected boolean aGS;
    private View.OnClickListener aGT;
    private boolean aGU;
    private a aHc;

    /* loaded from: classes.dex */
    public interface a {
        void ed(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aGQ = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aGR = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aGS = false;
        this.aGU = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGQ = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aGR = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aGS = false;
        this.aGU = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGQ = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aGR = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aGS = false;
        this.aGU = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.h(getContext(), e.C0175e.ds28));
        setGravity(17);
    }

    public void bs(boolean z) {
        this.aGS = z;
        if (z) {
            setClickable(false);
            setText(this.aGQ);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aGR);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        bs(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ec(int i) {
        if (this.aHc != null) {
            this.aHc.ed(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        if (this.aGT != null) {
            this.aGT.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aGS) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, e.d.btn_forum_focus_color);
        if (this.aGU) {
            al.i(this, e.f.btn_transparent_focus_border_bg);
        } else {
            al.i(this, e.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.aHc = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aGT = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aGU = z;
        al.i(this, e.f.btn_transparent_focus_border_bg);
    }
}
