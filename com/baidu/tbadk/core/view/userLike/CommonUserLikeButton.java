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
    private boolean aoA;
    protected String aov;
    protected String aow;
    protected boolean aox;
    private a aoy;
    private View.OnClickListener aoz;

    /* loaded from: classes.dex */
    public interface a {
        void dG(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aov = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aow = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aox = false;
        this.aoA = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aov = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aow = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aox = false;
        this.aoA = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aov = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aow = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aox = false;
        this.aoA = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.f(getContext(), d.f.ds28));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aO(boolean z) {
        this.aox = z;
        if (z) {
            setClickable(false);
            setText(this.aov);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aow);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dF(int i) {
        if (this.aoy != null) {
            this.aoy.dG(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
        if (this.aoz != null) {
            this.aoz.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aox) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.e.btn_forum_focus_color);
        if (this.aoA) {
            aj.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            aj.j(this, d.g.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(boolean z, boolean z2) {
        aO(z);
    }

    public void setFanNumCallBack(a aVar) {
        this.aoy = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aoz = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aoA = z;
        aj.j(this, d.g.btn_transparent_focus_border_bg);
    }
}
