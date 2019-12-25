package com.baidu.android.ext.widget.iconfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.android.common.ui.R;
/* loaded from: classes11.dex */
public class IconFontImageView extends ImageView {
    private static final int DEFAULT_ICON_FONT_COLOR = -16777216;
    private Context mContext;
    private IconFontDrawable mDrawable;
    private String mIconFont;
    private int mIconFontColor;
    private String mPressedIconFont;
    private int mPressedIconFontColor;

    public IconFontImageView(Context context) {
        this(context, null);
    }

    public IconFontImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconFontImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIconFontColor = -16777216;
        this.mPressedIconFontColor = 0;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mContext = context;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IconFontImageView, i, 0);
            String string = obtainStyledAttributes.getString(R.styleable.IconFontImageView_fontPath);
            this.mIconFont = obtainStyledAttributes.getString(R.styleable.IconFontImageView_iconFont);
            this.mPressedIconFont = obtainStyledAttributes.getString(R.styleable.IconFontImageView_pressedIconFont);
            this.mIconFontColor = obtainStyledAttributes.getColor(R.styleable.IconFontImageView_iconFontColor, -16777216);
            this.mPressedIconFontColor = obtainStyledAttributes.getColor(R.styleable.IconFontImageView_pressedIconFontColor, 0);
            if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(this.mIconFont)) {
                initIconFontDrawable(context);
                this.mDrawable.setFontPath(string);
                this.mDrawable.setIconFont(this.mIconFont);
                this.mDrawable.setIconFontColor(this.mIconFontColor);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void setIconFont(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mIconFont = str;
            initIconFontDrawable(this.mContext);
            this.mDrawable.setIconFont(this.mIconFont);
        }
    }

    public void setIconFont(@StringRes int i) {
        if (i >= 0) {
            setIconFont(getContext().getResources().getString(i));
        }
    }

    private void setPressedIconFont(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPressedIconFont = str;
        }
    }

    public void setPressedIconFont(@StringRes int i) {
        if (i >= 0) {
            setPressedIconFont(getContext().getResources().getString(i));
        }
    }

    public void setIconFontColor(@ColorInt int i) {
        if (i != 0) {
            this.mIconFontColor = i;
            initIconFontDrawable(this.mContext);
            this.mDrawable.setIconFontColor(this.mIconFontColor);
        }
    }

    public void setIconFontColorId(@ColorRes int i) {
        if (i >= 0) {
            setIconFontColor(getContext().getResources().getColor(i));
        }
    }

    public void setPressedIconFontColor(@ColorInt int i) {
        if (i != 0) {
            this.mPressedIconFontColor = i;
        }
    }

    public void setPressedIconFontColorId(@ColorRes int i) {
        if (i >= 0) {
            setPressedIconFontColor(getContext().getResources().getColor(i));
        }
    }

    public void setFontPath(String str) {
        initIconFontDrawable(this.mContext);
        this.mDrawable.setFontPath(str);
    }

    public void setFontPath(@StringRes int i) {
        if (i >= 0) {
            setFontPath(getContext().getResources().getString(i));
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (isPressed()) {
            updateDrawableState(this.mPressedIconFont, this.mPressedIconFontColor);
        } else {
            updateDrawableState(this.mIconFont, this.mIconFontColor);
        }
    }

    private void updateDrawableState(String str, int i) {
        if (this.mDrawable != null) {
            this.mDrawable.setIconFont(str);
            this.mDrawable.setIconFontColor(i);
        }
    }

    private void initIconFontDrawable(Context context) {
        if (this.mDrawable == null) {
            this.mDrawable = new IconFontDrawable(context);
            setScaleType(ImageView.ScaleType.CENTER);
            setImageDrawable(this.mDrawable);
        }
    }
}
