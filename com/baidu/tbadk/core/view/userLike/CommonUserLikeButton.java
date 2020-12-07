package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String fga;
    protected String fgb;
    protected boolean fgc;
    private View.OnClickListener fgd;
    private boolean fge;
    private a fhe;

    /* loaded from: classes.dex */
    public interface a {
        void rr(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.fga = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fgb = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fgc = false;
        this.fge = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fga = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fgb = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fgc = false;
        this.fge = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fga = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fgb = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fgc = false;
        this.fge = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void aP(boolean z) {
        this.fgc = z;
        if (z) {
            setClickable(false);
            setText(this.fga);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.fgb);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(boolean z, int i) {
        aP(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void rq(int i) {
        if (this.fhe != null) {
            this.fhe.rr(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bB(View view) {
        if (this.fgd != null) {
            this.fgd.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.fgc) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.fge) {
            ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ap.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        s(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.fhe = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.fgd = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.fge = z;
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
