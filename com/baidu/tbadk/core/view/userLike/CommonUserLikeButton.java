package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String cdm;
    protected String cdn;
    protected boolean cdo;
    private View.OnClickListener cdp;
    private boolean cdq;
    private a cdy;

    /* loaded from: classes.dex */
    public interface a {
        void jf(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.cdm = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cdn = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cdo = false;
        this.cdq = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdm = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cdn = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cdo = false;
        this.cdq = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdm = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cdn = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.cdo = false;
        this.cdq = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void ev(boolean z) {
        this.cdo = z;
        if (z) {
            setClickable(false);
            setText(this.cdm);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.cdn);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        ev(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void je(int i) {
        if (this.cdy != null) {
            this.cdy.jf(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        if (this.cdp != null) {
            this.cdp.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.cdo) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.j(this, R.color.btn_forum_focus_color);
        if (this.cdq) {
            am.k(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.k(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i, boolean z2) {
        f(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.cdy = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.cdp = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.cdq = z;
        am.k(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
