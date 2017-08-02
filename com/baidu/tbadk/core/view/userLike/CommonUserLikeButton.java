package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String aoA;
    protected boolean aoB;
    private a aoC;
    private View.OnClickListener aoD;
    private boolean aoE;
    protected String aoz;

    /* loaded from: classes.dex */
    public interface a {
        void du(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.aoz = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aoA = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aoB = false;
        this.aoE = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoz = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aoA = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aoB = false;
        this.aoE = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoz = TbadkCoreApplication.getInst().getString(d.l.relate_forum_is_followed);
        this.aoA = TbadkCoreApplication.getInst().getString(d.l.attention);
        this.aoB = false;
        this.aoE = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, k.g(getContext(), d.f.ds28));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aQ(boolean z) {
        this.aoB = z;
        if (z) {
            setClickable(false);
            setText(this.aoz);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aoA);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dt(int i) {
        if (this.aoC != null) {
            this.aoC.du(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void C(View view) {
        if (this.aoD != null) {
            this.aoD.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aoB) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this, d.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.i(this, d.e.btn_forum_focus_color);
        if (this.aoE) {
            ai.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            ai.j(this, d.g.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.aoC = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.aoD = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.aoE = z;
        ai.j(this, d.g.btn_transparent_focus_border_bg);
    }
}
