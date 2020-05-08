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
    private a dKB;
    protected String dKn;
    protected String dKo;
    protected boolean dKp;
    private View.OnClickListener dKq;
    private boolean dKr;

    /* loaded from: classes.dex */
    public interface a {
        void lM(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.dKn = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKo = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKp = false;
        this.dKr = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKn = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKo = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKp = false;
        this.dKr = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dKn = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKo = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dKp = false;
        this.dKr = false;
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
        this.dKp = z;
        if (z) {
            setClickable(false);
            setText(this.dKn);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dKo);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void n(boolean z, int i) {
        gT(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lL(int i) {
        if (this.dKB != null) {
            this.dKB.lM(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bb(View view) {
        if (this.dKq != null) {
            this.dKq.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dKp) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dKr) {
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
        this.dKB = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dKq = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dKr = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
