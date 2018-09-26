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
    protected String aCk;
    protected String aCl;
    protected boolean aCm;
    private View.OnClickListener aCn;
    private boolean aCo;
    private a aCw;

    /* loaded from: classes.dex */
    public interface a {
        void dT(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aCk = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aCl = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aCm = false;
        this.aCo = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCk = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aCl = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aCm = false;
        this.aCo = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCk = TbadkCoreApplication.getInst().getString(e.j.relate_forum_is_followed);
        this.aCl = TbadkCoreApplication.getInst().getString(e.j.attention);
        this.aCm = false;
        this.aCo = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.h(getContext(), e.C0141e.ds28));
        setGravity(17);
    }

    public void bi(boolean z) {
        this.aCm = z;
        if (z) {
            setClickable(false);
            setText(this.aCk);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aCl);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d(boolean z, int i) {
        bi(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dS(int i) {
        if (this.aCw != null) {
            this.aCw.dT(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        if (this.aCn != null) {
            this.aCn.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aCm) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, e.d.btn_forum_focus_color);
        if (this.aCo) {
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
        this.aCw = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aCn = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aCo = z;
        al.i(this, e.f.btn_transparent_focus_border_bg);
    }
}
