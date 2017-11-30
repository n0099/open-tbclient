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
    protected String api;
    protected String apj;
    protected boolean apk;
    private a apl;
    private View.OnClickListener apm;
    private boolean apn;

    /* loaded from: classes.dex */
    public interface a {
        void dH(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.api = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.apj = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.apk = false;
        this.apn = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.api = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.apj = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.apk = false;
        this.apn = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.api = TbadkCoreApplication.getInst().getString(d.j.relate_forum_is_followed);
        this.apj = TbadkCoreApplication.getInst().getString(d.j.attention);
        this.apk = false;
        this.apn = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.f(getContext(), d.e.ds28));
        setGravity(17);
    }

    public void aM(boolean z) {
        this.apk = z;
        if (z) {
            setClickable(false);
            setText(this.api);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.apj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dG(int i) {
        if (this.apl != null) {
            this.apl.dH(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
        if (this.apm != null) {
            this.apm.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.apk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.C0082d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.C0082d.btn_forum_focus_color);
        if (this.apn) {
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
        this.apl = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.apm = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.apn = z;
        aj.j(this, d.f.btn_transparent_focus_border_bg);
    }
}
