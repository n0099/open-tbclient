package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.spswitch.R;
import com.baidu.spswitch.utils.UIUtils;
/* loaded from: classes2.dex */
public class PopupEmotionView extends FrameLayout {
    public static final int HEIGHT_DP = 85;
    public static final int WIDTH_DP = 75;
    public Context mCtx;
    public ImageView mIcon;
    public TextView mText;

    public PopupEmotionView(Context context) {
        super(context);
        init(context);
    }

    private String filter(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.indexOf("[") == 0) {
            str = str.substring(1);
        }
        return str.indexOf("]") == str.length() - 1 ? str.substring(0, str.length() - 1) : str;
    }

    private void init(Context context) {
        this.mCtx = context;
        setLayoutParams(new ViewGroup.LayoutParams((int) UIUtils.dp2px(this.mCtx, 75.0f), (int) UIUtils.dp2px(this.mCtx, 85.0f)));
        setBackground(this.mCtx.getResources().getDrawable(R.drawable.emotion_vertical_long_pressed_bg));
        setPadding(0, 0, 0, 0);
        LayoutInflater.from(this.mCtx).inflate(R.layout.emotion_vertical_long_pressed_layout, (ViewGroup) this, true);
        this.mIcon = (ImageView) findViewById(R.id.icon);
        this.mText = (TextView) findViewById(R.id.text);
    }

    public void configView(String str, Bitmap bitmap) {
        TextView textView;
        if (this.mIcon == null || (textView = this.mText) == null) {
            return;
        }
        textView.setText(filter(str));
        this.mText.setTextColor(this.mCtx.getResources().getColor(R.color.GC4));
        this.mIcon.setImageBitmap(bitmap);
    }

    public PopupEmotionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PopupEmotionView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }
}
