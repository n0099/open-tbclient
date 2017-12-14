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
    protected String apl;
    protected String apm;
    protected boolean apn;
    private a apo;
    private View.OnClickListener apq;
    private boolean apr;

    /* loaded from: classes.dex */
    public interface a {
        void dH(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.apl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.apm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.apn = false;
        this.apr = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.apm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.apn = false;
        this.apr = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apl = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.apm = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.apn = false;
        this.apr = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.f(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void aN(boolean z) {
        this.apn = z;
        if (z) {
            setClickable(false);
            setText(this.apl);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.apm);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dG(int i) {
        if (this.apo != null) {
            this.apo.dH(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void J(View view) {
        if (this.apq != null) {
            this.apq.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.apn) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.C0096d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.C0096d.btn_forum_focus_color);
        if (this.apr) {
            aj.j(this, d.f.btn_transparent_focus_border_bg);
        } else {
            aj.j(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(boolean z, boolean z2) {
        aN(z);
    }

    public void setFanNumCallBack(a aVar) {
        this.apo = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.apq = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.apr = z;
        aj.j(this, d.f.btn_transparent_focus_border_bg);
    }
}
