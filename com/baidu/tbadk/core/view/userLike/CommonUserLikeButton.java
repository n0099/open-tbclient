package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String agY;
    protected String agZ;
    protected boolean aha;
    private a ahb;
    private View.OnClickListener ahc;
    private boolean ahd;

    /* loaded from: classes.dex */
    public interface a {
        void ds(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.agY = TbadkCoreApplication.m9getInst().getString(r.l.relate_forum_is_followed);
        this.agZ = TbadkCoreApplication.m9getInst().getString(r.l.attention);
        this.aha = false;
        this.ahd = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agY = TbadkCoreApplication.m9getInst().getString(r.l.relate_forum_is_followed);
        this.agZ = TbadkCoreApplication.m9getInst().getString(r.l.attention);
        this.aha = false;
        this.ahd = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agY = TbadkCoreApplication.m9getInst().getString(r.l.relate_forum_is_followed);
        this.agZ = TbadkCoreApplication.m9getInst().getString(r.l.attention);
        this.aha = false;
        this.ahd = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, k.e(getContext(), r.f.ds28));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aP(boolean z) {
        this.aha = z;
        if (z) {
            setClickable(false);
            setText(this.agY);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.agZ);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dr(int i) {
        if (this.ahb != null) {
            this.ahb.ds(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void E(View view) {
        if (this.ahc != null) {
            this.ahc.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.aha) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.i((View) this, r.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.i((View) this, r.e.btn_forum_focus_color);
        if (this.ahd) {
            ap.j((View) this, r.g.btn_transparent_focus_border_bg);
        } else {
            ap.j((View) this, r.g.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.ahb = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.ahc = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.ahd = z;
        ap.j((View) this, r.g.btn_transparent_focus_border_bg);
    }
}
