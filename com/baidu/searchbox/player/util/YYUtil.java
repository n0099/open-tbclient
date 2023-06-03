package com.baidu.searchbox.player.util;

import com.baidu.searchbox.player.model.BasicVideoSeries;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0006\u001a\f\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0001\u001a\u0014\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"FLV_SUFFIX", "", "KEY_BUFFER_SIZE", "LIVE", "getYYBufferSize", "", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "isLiveUrl", "", "setYYBufferSize", "", "size", "yykernel-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "YYUtil")
/* loaded from: classes4.dex */
public final class YYUtil {
    public static final String FLV_SUFFIX = ".flv";
    public static final String KEY_BUFFER_SIZE = "yy_live_buffer_size";
    public static final String LIVE = "live";

    public static final int getYYBufferSize(BasicVideoSeries basicVideoSeries) {
        if (basicVideoSeries == null) {
            return 8192;
        }
        Number number = 8192;
        Object obj = basicVideoSeries.getExtMap().get(KEY_BUFFER_SIZE);
        if (obj instanceof Integer) {
            number = obj;
        }
        return number.intValue();
    }

    public static final boolean isLiveUrl(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) FLV_SUFFIX, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "live", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    public static final void setYYBufferSize(BasicVideoSeries basicVideoSeries, int i) {
        if (basicVideoSeries != null) {
            basicVideoSeries.set(KEY_BUFFER_SIZE, Integer.valueOf(i));
        }
    }
}
