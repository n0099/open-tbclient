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
    protected String aLL;
    protected String aLM;
    protected boolean aLN;
    private View.OnClickListener aLO;
    private boolean aLP;
    private a aLX;

    /* loaded from: classes.dex */
    public interface a {
        void eG(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aLL = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLM = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLN = false;
        this.aLP = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLL = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLM = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLN = false;
        this.aLP = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLL = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aLM = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aLN = false;
        this.aLP = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.h(getContext(), e.C0210e.ds28));
        setGravity(17);
    }

    public void bL(boolean z) {
        this.aLN = z;
        if (z) {
            setClickable(false);
            setText(this.aLL);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aLM);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        bL(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void eF(int i) {
        if (this.aLX != null) {
            this.aLX.eG(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        if (this.aLO != null) {
            this.aLO.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aLN) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, e.d.btn_forum_focus_color);
        if (this.aLP) {
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
        this.aLX = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aLO = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aLP = z;
        al.i(this, e.f.btn_transparent_focus_border_bg);
    }
}
