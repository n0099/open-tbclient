package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String aqA;
    protected String aqB;
    protected boolean aqC;
    private a aqD;
    private View.OnClickListener aqE;
    private boolean aqF;

    /* loaded from: classes.dex */
    public interface a {
        void dC(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aqA = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.aqB = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.aqC = false;
        this.aqF = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqA = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.aqB = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.aqC = false;
        this.aqF = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqA = TbadkCoreApplication.getInst().getString(d.k.relate_forum_is_followed);
        this.aqB = TbadkCoreApplication.getInst().getString(d.k.attention);
        this.aqC = false;
        this.aqF = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.e(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void aQ(boolean z) {
        this.aqC = z;
        if (z) {
            setClickable(false);
            setText(this.aqA);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aqB);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        aQ(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dB(int i) {
        if (this.aqD != null) {
            this.aqD.dC(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void K(View view2) {
        if (this.aqE != null) {
            this.aqE.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aqC) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this, d.C0126d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.h(this, d.C0126d.btn_forum_focus_color);
        if (this.aqF) {
            ak.i(this, d.f.btn_transparent_focus_border_bg);
        } else {
            ak.i(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.aqD = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aqE = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aqF = z;
        ak.i(this, d.f.btn_transparent_focus_border_bg);
    }
}
