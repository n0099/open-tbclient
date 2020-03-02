package com.baidu.searchbox.ugc.utils;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.a;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class UgcRichTextProcessor {
    public static void handleEmotionDispaly(TextView textView) {
        CharSequence text = textView.getText();
        if (!TextUtils.isEmpty(text) && Pattern.compile("\\[([一-龥\\w])+\\]").matcher(text).find()) {
            textView.setText(a.Gj().a(EmotionType.EMOTION_CLASSIC_TYPE, AppRuntime.getAppContext(), text, textView));
        }
    }
}
