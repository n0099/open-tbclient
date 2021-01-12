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
    protected String fkZ;
    protected String fla;
    protected boolean flb;
    private View.OnClickListener flc;
    private boolean fld;
    private a fme;

    /* loaded from: classes.dex */
    public interface a {
        void pX(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.fkZ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fla = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.flb = false;
        this.fld = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkZ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fla = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.flb = false;
        this.fld = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkZ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fla = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.flb = false;
        this.fld = false;
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
        this.flb = z;
        if (z) {
            setClickable(false);
            setText(this.fkZ);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.fla);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void pW(int i) {
        if (this.fme != null) {
            this.fme.pX(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bK(View view) {
        if (this.flc != null) {
            this.flc.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.flb) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        ao.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.fld) {
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
        this.fme = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.flc = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.fld = z;
        ao.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
