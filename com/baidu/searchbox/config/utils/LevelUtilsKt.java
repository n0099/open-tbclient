package com.baidu.searchbox.config.utils;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\b¨\u0006\u0004"}, d2 = {"checkFontSizeValid", "", TtmlNode.ATTR_TTS_FONT_SIZE, "", "lib-fontsize_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LevelUtilsKt {
    public static final boolean checkFontSizeValid(int i) {
        return i >= 0 && i < 5;
    }
}
