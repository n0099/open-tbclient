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
    protected String dKj;
    protected String dKk;
    protected boolean dKl;
    private View.OnClickListener dKm;
    private boolean dKn;
    private a dKx;

    /* loaded from: classes.dex */
    public interface a {
        void lM(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.dKj = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKk = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKl = false;
        this.dKn = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKj = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKk = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKl = false;
        this.dKn = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dKj = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKk = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKl = false;
        this.dKn = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void gT(boolean z) {
        this.dKl = z;
        if (z) {
            setClickable(false);
            setText(this.dKj);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dKk);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void n(boolean z, int i) {
        gT(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lL(int i) {
        if (this.dKx != null) {
            this.dKx.lM(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bb(View view) {
        if (this.dKm != null) {
            this.dKm.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dKl) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dKn) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        n(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.dKx = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dKm = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dKn = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
