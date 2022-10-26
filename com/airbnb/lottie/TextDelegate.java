package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TextDelegate {
    public final LottieAnimationView animationView;
    public boolean cacheText;
    public final LottieDrawable drawable;
    public final Map stringMap;

    private String getText(String str) {
        return str;
    }

    public TextDelegate() {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.animationView = null;
        this.drawable = null;
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

    public void invalidateAllText() {
        this.stringMap.clear();
        invalidate();
    }

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.animationView = lottieAnimationView;
        this.drawable = null;
    }

    public final String getTextInternal(String str) {
        if (this.cacheText && this.stringMap.containsKey(str)) {
            return (String) this.stringMap.get(str);
        }
        String text = getText(str);
        if (this.cacheText) {
            this.stringMap.put(str, text);
        }
        return text;
    }

    public void invalidateText(String str) {
        this.stringMap.remove(str);
        invalidate();
    }

    public void setCacheText(boolean z) {
        this.cacheText = z;
    }

    public TextDelegate(LottieDrawable lottieDrawable) {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.drawable = lottieDrawable;
        this.animationView = null;
    }

    public void setText(String str, String str2) {
        this.stringMap.put(str, str2);
        invalidate();
    }
}
