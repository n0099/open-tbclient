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
    protected String cem;
    protected String cen;
    protected boolean ceo;
    private View.OnClickListener cep;
    private boolean ceq;
    private a cey;

    /* loaded from: classes.dex */
    public interface a {
        void jj(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.cem = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cen = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ceo = false;
        this.ceq = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cem = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cen = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ceo = false;
        this.ceq = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cem = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.cen = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ceo = false;
        this.ceq = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.g(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void ey(boolean z) {
        this.ceo = z;
        if (z) {
            setClickable(false);
            setText(this.cem);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.cen);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z, int i) {
        ey(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void ji(int i) {
        if (this.cey != null) {
            this.cey.jj(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        if (this.cep != null) {
            this.cep.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void e(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ceo) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.j(this, R.color.btn_forum_focus_color);
        if (this.ceq) {
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
        this.cey = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.cep = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.ceq = z;
        am.k(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
