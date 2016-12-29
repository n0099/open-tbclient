package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String ahK;
    protected String ahL;
    protected boolean ahM;
    private a ahN;
    private View.OnClickListener ahO;
    private boolean ahP;

    /* loaded from: classes.dex */
    public interface a {
        void dr(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.ahK = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
        this.ahL = TbadkCoreApplication.m9getInst().getString(r.j.attention);
        this.ahM = false;
        this.ahP = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahK = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
        this.ahL = TbadkCoreApplication.m9getInst().getString(r.j.attention);
        this.ahM = false;
        this.ahP = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahK = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
        this.ahL = TbadkCoreApplication.m9getInst().getString(r.j.attention);
        this.ahM = false;
        this.ahP = false;
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
    public void aP(boolean z) {
        this.ahM = z;
        if (z) {
            setClickable(false);
            setText(this.ahK);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.ahL);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dq(int i) {
        if (this.ahN != null) {
            this.ahN.dr(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void G(View view) {
        if (this.ahO != null) {
            this.ahO.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ahM) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ar.j((View) this, r.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ar.j((View) this, r.d.btn_forum_focus_color);
        if (this.ahP) {
            ar.k(this, r.f.btn_transparent_focus_border_bg);
        } else {
            ar.k(this, r.f.btn_focus_border_bg);
        }
    }

    public void setFanNumCallBack(a aVar) {
        this.ahN = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.ahO = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.ahP = z;
        ar.k(this, r.f.btn_transparent_focus_border_bg);
    }
}
