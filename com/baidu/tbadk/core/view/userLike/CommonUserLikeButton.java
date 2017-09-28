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
    protected String aoH;
    protected String aoI;
    protected boolean aoJ;
    private a aoK;
    private View.OnClickListener aoL;
    private boolean aoM;

    /* loaded from: classes.dex */
    public interface a {
        void dH(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aoH = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aoI = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aoJ = false;
        this.aoM = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoH = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aoI = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aoJ = false;
        this.aoM = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoH = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aoI = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aoJ = false;
        this.aoM = false;
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
    public void aP(boolean z) {
        this.aoJ = z;
        if (z) {
            setClickable(false);
            setText(this.aoH);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aoI);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dG(int i) {
        if (this.aoK != null) {
            this.aoK.dH(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
        if (this.aoL != null) {
            this.aoL.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aoJ) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.e.btn_forum_focus_color);
        if (this.aoM) {
            aj.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            aj.j(this, d.g.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(boolean z, boolean z2) {
        aP(z);
    }

    public void setFanNumCallBack(a aVar) {
        this.aoK = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aoL = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aoM = z;
        aj.j(this, d.g.btn_transparent_focus_border_bg);
    }
}
