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
    private a apA;
    private View.OnClickListener apB;
    private boolean apC;
    protected String apx;
    protected String apy;
    protected boolean apz;

    /* loaded from: classes.dex */
    public interface a {
        void dx(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.apx = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.apy = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.apz = false;
        this.apC = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apx = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.apy = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.apz = false;
        this.apC = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apx = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.apy = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.apz = false;
        this.apC = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, k.f(getContext(), d.f.ds28));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aQ(boolean z) {
        this.apz = z;
        if (z) {
            setClickable(false);
            setText(this.apx);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.apy);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dw(int i) {
        if (this.apA != null) {
            this.apA.dx(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void H(View view) {
        if (this.apB != null) {
            this.apB.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.apz) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.e.btn_forum_focus_color);
        if (this.apC) {
            aj.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            aj.j(this, d.g.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.apA = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.apB = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.apC = z;
        aj.j(this, d.g.btn_transparent_focus_border_bg);
    }
}
