package com.baidu.android.common.others;

import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.TextView;
@Deprecated
/* loaded from: classes.dex */
public class UIUtils {
    public static final int NO_ALPHA_STANDARD = 7;
    public static final int WITH_ALPHA_STANDARD = 9;

    public static int getTextViewHeight(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (TextUtils.isEmpty(textView.getText())) {
            return 0;
        }
        return (int) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 2.0d);
    }

    public static int getTextViewWidth(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        if (TextUtils.isEmpty(textView.getText())) {
            return 0;
        }
        return (int) paint.measureText(textView.getText().toString());
    }

    public static boolean isColorValid(Object obj) {
        if (!(obj instanceof String)) {
            return obj instanceof Integer;
        }
        String valueOf = String.valueOf(obj);
        return !TextUtils.isEmpty(valueOf) && valueOf.startsWith("#") && (valueOf.length() == 7 || valueOf.length() == 9);
    }
}
