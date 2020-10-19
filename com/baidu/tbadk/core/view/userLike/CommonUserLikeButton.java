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
    protected String eLk;
    protected String eLl;
    protected boolean eLm;
    private View.OnClickListener eLn;
    private boolean eLo;
    private a eMo;

    /* loaded from: classes.dex */
    public interface a {
        void pX(int i);
    }

    public CommonUserLikeButton(Context context) {
        super(context);
        this.eLk = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eLl = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.eLm = false;
        this.eLo = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLk = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eLl = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.eLm = false;
        this.eLo = false;
        init();
    }

    public CommonUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eLk = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eLl = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.eLm = false;
        this.eLo = false;
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
        this.eLm = z;
        if (z) {
            setClickable(false);
            setText(this.eLk);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.eLl);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(boolean z, int i) {
        aN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void pW(int i) {
        if (this.eMo != null) {
            this.eMo.pX(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bq(View view) {
        if (this.eLn != null) {
            this.eLn.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.eLm) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.eLo) {
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
        this.eMo = aVar;
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.eLn = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.eLo = z;
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
