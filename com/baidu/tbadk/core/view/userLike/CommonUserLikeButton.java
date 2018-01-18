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
    protected String bdt;
    protected String bdu;
    protected boolean bdv;
    private a bdw;
    private View.OnClickListener bdx;
    private boolean bdy;

    /* loaded from: classes.dex */
    public interface a {
        void gC(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bdt = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdu = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdv = false;
        this.bdy = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdt = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdu = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdv = false;
        this.bdy = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdt = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdu = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdv = false;
        this.bdy = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.s(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void bt(boolean z) {
        this.bdv = z;
        if (z) {
            setClickable(false);
            setText(this.bdt);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bdu);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        bt(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void gB(int i) {
        if (this.bdw != null) {
            this.bdw.gC(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.bdx != null) {
            this.bdx.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bdv) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this, d.C0107d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this, d.C0107d.btn_forum_focus_color);
        if (this.bdy) {
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
        this.bdw = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bdx = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bdy = z;
        aj.s(this, d.f.btn_transparent_focus_border_bg);
    }
}
