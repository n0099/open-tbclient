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
    protected String foR;
    protected String foS;
    protected boolean foT;
    private View.OnClickListener foU;
    private boolean foV;
    private a fpX;

    /* loaded from: classes.dex */
    public interface a {
        void qd(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.foR = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.foS = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.foT = false;
        this.foV = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foR = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.foS = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.foT = false;
        this.foV = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foR = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.foS = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.foT = false;
        this.foV = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void aM(boolean z) {
        this.foT = z;
        if (z) {
            setClickable(false);
            setText(this.foR);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.foS);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qc(int i) {
        if (this.fpX != null) {
            this.fpX.qd(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bG(View view) {
        if (this.foU != null) {
            this.foU.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.foT) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.foV) {
            ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ap.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        r(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.fpX = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.foU = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.foV = z;
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
