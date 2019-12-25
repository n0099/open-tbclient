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
    private boolean dfA;
    private a dfK;
    protected String dfw;
    protected String dfx;
    protected boolean dfy;
    private View.OnClickListener dfz;

    /* loaded from: classes.dex */
    public interface a {
        void lh(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.dfw = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfx = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfy = false;
        this.dfA = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfw = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfx = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfy = false;
        this.dfA = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfw = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfx = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.dfy = false;
        this.dfA = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void fI(boolean z) {
        this.dfy = z;
        if (z) {
            setClickable(false);
            setText(this.dfw);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.dfx);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void k(boolean z, int i) {
        fI(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lg(int i) {
        if (this.dfK != null) {
            this.dfK.lh(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aW(View view) {
        if (this.dfz != null) {
            this.dfz.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.dfy) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        if (this.dfA) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        k(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.dfK = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.dfz = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.dfA = z;
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
