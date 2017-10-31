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
    protected String aoR;
    protected String aoS;
    protected boolean aoT;
    private a aoU;
    private View.OnClickListener aoV;
    private boolean aoW;

    /* loaded from: classes.dex */
    public interface a {
        void dH(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aoR = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.aoS = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.aoT = false;
        this.aoW = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoR = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.aoS = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.aoT = false;
        this.aoW = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoR = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.aoS = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.aoT = false;
        this.aoW = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.f(getContext(), d.e.ds28));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aM(boolean z) {
        this.aoT = z;
        if (z) {
            setClickable(false);
            setText(this.aoR);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aoS);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dG(int i) {
        if (this.aoU != null) {
            this.aoU.dH(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
        if (this.aoV != null) {
            this.aoV.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aoT) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.C0080d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.C0080d.btn_forum_focus_color);
        if (this.aoW) {
            aj.j(this, d.f.btn_transparent_focus_border_bg);
        } else {
            aj.j(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(boolean z, boolean z2) {
        aM(z);
    }

    public void setFanNumCallBack(a aVar) {
        this.aoU = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aoV = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aoW = z;
        aj.j(this, d.f.btn_transparent_focus_border_bg);
    }
}
