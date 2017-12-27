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
    protected String bdn;
    protected String bdo;
    protected boolean bdp;
    private a bdq;
    private View.OnClickListener bdr;
    private boolean bds;

    /* loaded from: classes.dex */
    public interface a {
        void gF(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bdn = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdo = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdp = false;
        this.bds = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdn = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdo = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdp = false;
        this.bds = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdn = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bdo = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bdp = false;
        this.bds = false;
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
        this.bdp = z;
        if (z) {
            setClickable(false);
            setText(this.bdn);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bdo);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        bt(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void gE(int i) {
        if (this.bdq != null) {
            this.bdq.gF(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.bdr != null) {
            this.bdr.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bdp) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this, d.C0108d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this, d.C0108d.btn_forum_focus_color);
        if (this.bds) {
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
        this.bdq = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bdr = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bds = z;
        aj.s(this, d.f.btn_transparent_focus_border_bg);
    }
}
