package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String foR;
    protected String foS;
    protected boolean foT;
    private View.OnClickListener foU;
    private boolean foV;

    public CommonLikeButton(Context context) {
        super(context);
        this.foR = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.foS = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.foT = false;
        this.foV = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foR = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.foS = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.foT = false;
        this.foV = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foR = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.foS = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.foT = false;
        this.foV = false;
        init();
    }

    protected void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(17);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void aM(boolean z) {
        setVisibility(0);
        this.foT = z;
        if (z) {
            setClickable(false);
            setText(this.foR);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.foS);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void bG(View view) {
        if (this.foU != null) {
            this.foU.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
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
        setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.foV) {
            ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ap.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.foU = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.foV = z;
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
