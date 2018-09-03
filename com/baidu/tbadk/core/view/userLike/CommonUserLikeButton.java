package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String azi;
    protected String azj;
    protected boolean azk;
    private View.OnClickListener azl;
    private boolean azm;
    private a azu;

    /* loaded from: classes.dex */
    public interface a {
        void dI(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.azi = TbadkCoreApplication.getInst().getString(f.j.relate_forum_is_followed);
        this.azj = TbadkCoreApplication.getInst().getString(f.j.attention);
        this.azk = false;
        this.azm = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azi = TbadkCoreApplication.getInst().getString(f.j.relate_forum_is_followed);
        this.azj = TbadkCoreApplication.getInst().getString(f.j.attention);
        this.azk = false;
        this.azm = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azi = TbadkCoreApplication.getInst().getString(f.j.relate_forum_is_followed);
        this.azj = TbadkCoreApplication.getInst().getString(f.j.attention);
        this.azk = false;
        this.azm = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.f(getContext(), f.e.ds28));
        setGravity(17);
    }

    public void aW(boolean z) {
        this.azk = z;
        if (z) {
            setClickable(false);
            setText(this.azi);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.azj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        aW(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dH(int i) {
        if (this.azu != null) {
            this.azu.dI(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void L(View view) {
        if (this.azl != null) {
            this.azl.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.azk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, f.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this, f.d.btn_forum_focus_color);
        if (this.azm) {
            am.i(this, f.C0146f.btn_transparent_focus_border_bg);
        } else {
            am.i(this, f.C0146f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.azu = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.azl = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.azm = z;
        am.i(this, f.C0146f.btn_transparent_focus_border_bg);
    }
}
