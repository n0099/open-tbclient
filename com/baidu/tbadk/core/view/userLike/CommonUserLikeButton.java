package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String amI;
    protected String amJ;
    protected boolean amK;
    private a amL;
    private View.OnClickListener amM;
    private boolean amN;

    /* loaded from: classes.dex */
    public interface a {
        void dr(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.amI = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amJ = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amK = false;
        this.amN = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amI = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amJ = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amK = false;
        this.amN = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amI = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amJ = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amK = false;
        this.amN = false;
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
    public void aQ(boolean z) {
        this.amK = z;
        if (z) {
            setClickable(false);
            setText(this.amI);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.amJ);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dq(int i) {
        if (this.amL != null) {
            this.amL.dr(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void C(View view) {
        if (this.amM != null) {
            this.amM.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.amK) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this, w.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aq.i(this, w.e.btn_forum_focus_color);
        if (this.amN) {
            aq.j(this, w.g.btn_transparent_focus_border_bg);
        } else {
            aq.j(this, w.g.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.amL = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.amM = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.amN = z;
        aq.j(this, w.g.btn_transparent_focus_border_bg);
    }
}
