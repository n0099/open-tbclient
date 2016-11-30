package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String aij;
    protected String aik;
    protected boolean ail;
    private a aim;
    private View.OnClickListener ain;
    private boolean aio;

    /* loaded from: classes.dex */
    public interface a {
        void dp(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aij = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
        this.aik = TbadkCoreApplication.m9getInst().getString(r.j.forum_list_attention_tv);
        this.ail = false;
        this.aio = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aij = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
        this.aik = TbadkCoreApplication.m9getInst().getString(r.j.forum_list_attention_tv);
        this.ail = false;
        this.aio = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aij = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
        this.aik = TbadkCoreApplication.m9getInst().getString(r.j.forum_list_attention_tv);
        this.ail = false;
        this.aio = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, k.e(getContext(), r.e.ds28));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aO(boolean z) {
        this.ail = z;
        if (z) {
            setClickable(false);
            setText(this.aij);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aik);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    /* renamed from: do  reason: not valid java name */
    public void mo12do(int i) {
        if (this.aim != null) {
            this.aim.dp(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void G(View view) {
        if (this.ain != null) {
            this.ain.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ail) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            at.j((View) this, r.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        at.j((View) this, r.d.btn_forum_focus_color);
        if (this.aio) {
            at.k(this, r.f.btn_transparent_focus_border_bg);
        } else {
            at.k(this, r.f.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.aim = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aio = z;
        at.k(this, r.f.btn_transparent_focus_border_bg);
    }
}
