package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class TextDelegate {
    @Nullable
    public final LottieAnimationView animationView;
    public boolean cacheText;
    @Nullable
    public final LottieDrawable drawable;
    public final Map<String, String> stringMap;

    @VisibleForTesting
    public TextDelegate() {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.animationView = null;
        this.drawable = null;
    }

    private String getText(String str) {
        return str;
    }

    private void invalidate() {
        LottieAnimationView lottieAnimationView = this.animationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        LottieDrawable lottieDrawable = this.drawable;
        if (lottieDrawable != null) {
            lottieDrawable.invalidateSelf();
        }
    }

    public final String getTextInternal(String str) {
        if (this.cacheText && this.stringMap.containsKey(str)) {
            return this.stringMap.get(str);
        }
        String text = getText(str);
        if (this.cacheText) {
            this.stringMap.put(str, text);
        }
        return text;
    }

    public void invalidateAllText() {
        this.stringMap.clear();
        invalidate();
    }

    public void invalidateText(String str) {
        this.stringMap.remove(str);
        invalidate();
    }

    public void setCacheText(boolean z) {
        this.cacheText = z;
    }

    public void setText(String str, String str2) {
        this.stringMap.put(str, str2);
        invalidate();
    }

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.animationView = lottieAnimationView;
        this.drawable = null;
    }

    public TextDelegate(LottieDrawable lottieDrawable) {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.drawable = lottieDrawable;
        this.animationView = null;
    }
}
