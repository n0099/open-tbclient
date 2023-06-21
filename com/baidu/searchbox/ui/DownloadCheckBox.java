package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class DownloadCheckBox extends BdBaseImageView {
    public boolean mIsChecked;
    public Drawable mSelectDrawable;
    public Drawable mUnSelectDrawable;

    public DownloadCheckBox(Context context) {
        super(context);
        init();
    }

    public void setChecked(boolean z) {
        this.mIsChecked = z;
        if (z) {
            Drawable drawable = this.mSelectDrawable;
            if (drawable != null) {
                setImageDrawable(drawable);
                return;
            } else {
                setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0805b9));
                return;
            }
        }
        Drawable drawable2 = this.mUnSelectDrawable;
        if (drawable2 != null) {
            setImageDrawable(drawable2);
        } else {
            setImageDrawable(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f0805ba));
        }
    }

    public void setSelectDrawable(Drawable drawable) {
        this.mSelectDrawable = drawable;
    }

    public void setUnSelectDrawable(Drawable drawable) {
        this.mUnSelectDrawable = drawable;
    }

    public DownloadCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DownloadCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setChecked(this.mIsChecked);
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }
}
