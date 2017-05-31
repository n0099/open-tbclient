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
    protected String amJ;
    protected String amK;
    protected boolean amL;
    private a amM;
    private View.OnClickListener amN;
    private boolean amO;

    /* loaded from: classes.dex */
    public interface a {
        void dq(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.amJ = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amK = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amL = false;
        this.amO = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amJ = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amK = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amL = false;
        this.amO = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amJ = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amK = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amL = false;
        this.amO = false;
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
    public void aO(boolean z) {
        this.amL = z;
        if (z) {
            setClickable(false);
            setText(this.amJ);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.amK);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dp(int i) {
        if (this.amM != null) {
            this.amM.dq(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void B(View view) {
        if (this.amN != null) {
            this.amN.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.amL) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this, w.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aq.i(this, w.e.btn_forum_focus_color);
        if (this.amO) {
            aq.j(this, w.g.btn_transparent_focus_border_bg);
        } else {
            aq.j(this, w.g.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.amM = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.amN = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.amO = z;
        aq.j(this, w.g.btn_transparent_focus_border_bg);
    }
}
