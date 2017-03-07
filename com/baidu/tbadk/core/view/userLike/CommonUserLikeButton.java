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
    protected String amu;
    protected String amv;
    protected boolean amw;
    private a amx;
    private View.OnClickListener amy;
    private boolean amz;

    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: do  reason: not valid java name */
        void mo12do(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.amu = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amv = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amw = false;
        this.amz = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amu = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amv = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amw = false;
        this.amz = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amu = TbadkCoreApplication.m9getInst().getString(w.l.relate_forum_is_followed);
        this.amv = TbadkCoreApplication.m9getInst().getString(w.l.attention);
        this.amw = false;
        this.amz = false;
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
        this.amw = z;
        if (z) {
            setClickable(false);
            setText(this.amu);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.amv);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dn(int i) {
        if (this.amx != null) {
            this.amx.mo12do(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void C(View view) {
        if (this.amy != null) {
            this.amy.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.amw) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i((View) this, w.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aq.i((View) this, w.e.btn_forum_focus_color);
        if (this.amz) {
            aq.j(this, w.g.btn_transparent_focus_border_bg);
        } else {
            aq.j(this, w.g.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.amx = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.amy = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.amz = z;
        aq.j(this, w.g.btn_transparent_focus_border_bg);
    }
}
