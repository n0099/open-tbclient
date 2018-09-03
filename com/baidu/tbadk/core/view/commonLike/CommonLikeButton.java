package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String azi;
    protected String azj;
    protected boolean azk;
    private View.OnClickListener azl;
    private boolean azm;

    public CommonLikeButton(Context context) {
        super(context);
        this.azi = TbadkCoreApplication.getInst().getString(f.j.relate_forum_is_followed);
        this.azj = TbadkCoreApplication.getInst().getString(f.j.attention);
        this.azk = false;
        this.azm = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azi = TbadkCoreApplication.getInst().getString(f.j.relate_forum_is_followed);
        this.azj = TbadkCoreApplication.getInst().getString(f.j.attention);
        this.azk = false;
        this.azm = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azi = TbadkCoreApplication.getInst().getString(f.j.relate_forum_is_followed);
        this.azj = TbadkCoreApplication.getInst().getString(f.j.attention);
        this.azk = false;
        this.azm = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.f(getContext(), f.e.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aW(boolean z) {
        setVisibility(0);
        this.azk = z;
        if (z) {
            setClickable(false);
            setText(this.azi);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.azj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void L(View view) {
        if (this.azl != null) {
            this.azl.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.azk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, f.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this, f.d.btn_forum_focus_color);
        if (this.azm) {
            am.i(this, f.C0146f.btn_transparent_focus_border_bg);
        } else {
            am.i(this, f.C0146f.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.azl = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.azm = z;
        am.i(this, f.C0146f.btn_transparent_focus_border_bg);
    }
}
