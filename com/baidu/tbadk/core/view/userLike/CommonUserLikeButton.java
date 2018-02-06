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
    protected String bfu;
    protected String bfv;
    protected boolean bfw;
    private a bfx;
    private View.OnClickListener bfy;
    private boolean bfz;

    /* loaded from: classes.dex */
    public interface a {
        void gE(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.bfu = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bfv = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bfw = false;
        this.bfz = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfu = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bfv = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bfw = false;
        this.bfz = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfu = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.bfv = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.bfw = false;
        this.bfz = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.t(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void bz(boolean z) {
        this.bfw = z;
        if (z) {
            setClickable(false);
            setText(this.bfu);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.bfv);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        bz(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void gD(int i) {
        if (this.bfx != null) {
            this.bfx.gE(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.bfy != null) {
            this.bfy.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.bfw) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this, d.C0140d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this, d.C0140d.btn_forum_focus_color);
        if (this.bfz) {
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
        this.bfx = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.bfy = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.bfz = z;
        aj.s(this, d.f.btn_transparent_focus_border_bg);
    }
}
