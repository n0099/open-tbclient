package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String anJ;
    protected String anK;
    protected boolean anL;
    private a anM;
    private View.OnClickListener anN;
    private boolean anO;

    /* loaded from: classes.dex */
    public interface a {
        void ds(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.anJ = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.anK = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.anL = false;
        this.anO = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anJ = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.anK = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.anL = false;
        this.anO = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anJ = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.anK = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.anL = false;
        this.anO = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, k.g(getContext(), w.f.ds28));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aP(boolean z) {
        this.anL = z;
        if (z) {
            setClickable(false);
            setText(this.anJ);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.anK);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dr(int i) {
        if (this.anM != null) {
            this.anM.ds(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void C(View view) {
        if (this.anN != null) {
            this.anN.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.anL) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            as.i(this, w.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        as.i(this, w.e.btn_forum_focus_color);
        if (this.anO) {
            as.j(this, w.g.btn_transparent_focus_border_bg);
        } else {
            as.j(this, w.g.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.anM = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.anN = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.anO = z;
        as.j(this, w.g.btn_transparent_focus_border_bg);
    }
}
