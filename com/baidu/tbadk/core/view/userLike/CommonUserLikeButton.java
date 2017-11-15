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
    protected String aoQ;
    protected String aoR;
    protected boolean aoS;
    private a aoT;
    private View.OnClickListener aoU;
    private boolean aoV;

    /* loaded from: classes.dex */
    public interface a {
        void dG(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aoQ = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.aoR = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.aoS = false;
        this.aoV = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoQ = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.aoR = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.aoS = false;
        this.aoV = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoQ = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.aoR = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.aoS = false;
        this.aoV = false;
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
        this.aoS = z;
        if (z) {
            setClickable(false);
            setText(this.aoQ);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aoR);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dF(int i) {
        if (this.aoT != null) {
            this.aoT.dG(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
        if (this.aoU != null) {
            this.aoU.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aoS) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.C0080d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.C0080d.btn_forum_focus_color);
        if (this.aoV) {
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
        this.aoT = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aoU = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aoV = z;
        aj.j(this, d.f.btn_transparent_focus_border_bg);
    }
}
