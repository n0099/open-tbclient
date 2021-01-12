package com.baidu.tbadk.core.view.commonLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CommonLikeButton extends AppCompatTextView implements b {
    protected String fkZ;
    protected String fla;
    protected boolean flb;
    private View.OnClickListener flc;
    private boolean fld;

    public CommonLikeButton(Context context) {
        super(context);
        this.fkZ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fla = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.flb = false;
        this.fld = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkZ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fla = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.flb = false;
        this.fld = false;
        init();
    }

    public CommonLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkZ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fla = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.flb = false;
        this.fld = false;
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
        this.flb = z;
        if (z) {
            setClickable(false);
            setText(this.fkZ);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.fla);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
    public void bK(View view) {
        if (this.flc != null) {
            this.flc.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.commonLike.b
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
        setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setViewTextColor(this, R.color.btn_forum_focus_color);
        if (this.fld) {
            ao.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            ao.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    public void setAfterOnClickListener(View.OnClickListener onClickListener) {
        this.flc = onClickListener;
    }

    public void setBackGroundIsTransMode(boolean z) {
        this.fld = z;
        ao.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
