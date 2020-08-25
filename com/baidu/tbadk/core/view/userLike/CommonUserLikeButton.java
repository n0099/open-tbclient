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
/* loaded from: classes2.dex */
public class CommonUserLikeButton extends TextView implements b {
    protected String ewS;
    protected String ewT;
    protected boolean ewU;
    private View.OnClickListener ewV;
    private boolean ewW;
    private a exX;

    /* loaded from: classes2.dex */
    public interface a {
        void pl(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.ewS = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ewT = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ewU = false;
        this.ewW = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewS = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ewT = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ewU = false;
        this.ewW = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewS = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ewT = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.ewU = false;
        this.ewW = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.ds28));
        setGravity(17);
    }

    public void aN(boolean z) {
        this.ewU = z;
        if (z) {
            setClickable(false);
            setText(this.ewS);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.ewT);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void r(boolean z, int i) {
        aN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void pk(int i) {
        if (this.exX != null) {
            this.exX.pl(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bk(View view) {
        if (this.ewV != null) {
            this.ewV.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.ewU) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.ewW) {
            ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ap.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    public void setFanNumCallBack(a aVar) {
        this.exX = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.ewV = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.ewW = z;
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
