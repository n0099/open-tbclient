package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String fpJ;
    protected String fpK;
    protected boolean fpL;
    private View.OnClickListener fpM;
    private boolean fpN;
    private a fqO;

    /* loaded from: classes.dex */
    public interface a {
        void rD(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.fpJ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fpK = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fpL = false;
        this.fpN = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpJ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fpK = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fpL = false;
        this.fpN = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpJ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fpK = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.fpL = false;
        this.fpN = false;
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
        this.fpL = z;
        if (z) {
            setClickable(false);
            setText(this.fpJ);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.fpK);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void rC(int i) {
        if (this.fqO != null) {
            this.fqO.rD(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bK(View view) {
        if (this.fpM != null) {
            this.fpM.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.fpL) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        ao.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.fpN) {
            ao.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ao.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(boolean z, int i, boolean z2) {
        r(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.fqO = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.fpM = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.fpN = z;
        ao.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
