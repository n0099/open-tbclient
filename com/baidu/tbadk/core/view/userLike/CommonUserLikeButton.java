package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String apA;
    protected boolean apB;
    private a apC;
    private View.OnClickListener apD;
    private boolean apE;
    protected String apz;

    /* loaded from: classes.dex */
    public interface a {
        void dx(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.apz = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.apA = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.apB = false;
        this.apE = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apz = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.apA = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.apB = false;
        this.apE = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apz = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.apA = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.apB = false;
        this.apE = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, k.g(getContext(), d.f.ds28));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aQ(boolean z) {
        this.apB = z;
        if (z) {
            setClickable(false);
            setText(this.apz);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.apA);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dw(int i) {
        if (this.apC != null) {
            this.apC.dx(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void H(View view) {
        if (this.apD != null) {
            this.apD.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.apB) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.e.btn_forum_focus_color);
        if (this.apE) {
            aj.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            aj.j(this, d.g.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.apC = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.apD = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.apE = z;
        aj.j(this, d.g.btn_transparent_focus_border_bg);
    }
}
