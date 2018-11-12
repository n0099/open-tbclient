package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String aHG;
    protected String aHH;
    protected boolean aHI;
    private View.OnClickListener aHJ;
    private boolean aHK;
    private a aHS;

    /* loaded from: classes.dex */
    public interface a {
        void er(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aHG = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aHH = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aHI = false;
        this.aHK = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHG = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aHH = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aHI = false;
        this.aHK = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHG = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aHH = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aHI = false;
        this.aHK = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.h(getContext(), e.C0200e.ds28));
        setGravity(17);
    }

    public void bJ(boolean z) {
        this.aHI = z;
        if (z) {
            setClickable(false);
            setText(this.aHG);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aHH);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        bJ(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void eq(int i) {
        if (this.aHS != null) {
            this.aHS.er(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        if (this.aHJ != null) {
            this.aHJ.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aHI) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, e.d.btn_forum_focus_color);
        if (this.aHK) {
            al.i(this, e.f.btn_transparent_focus_border_bg);
        } else {
            al.i(this, e.f.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        d(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.aHS = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aHJ = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aHK = z;
        al.i(this, e.f.btn_transparent_focus_border_bg);
    }
}
