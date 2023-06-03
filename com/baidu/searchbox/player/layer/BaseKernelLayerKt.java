package com.baidu.searchbox.player.layer;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"OPTION_OFF", "", "OPTION_ON", "SEEK_TO_DELTA", "", "toOption", "", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BaseKernelLayerKt {
    public static final String OPTION_OFF = "0";
    public static final String OPTION_ON = "1";
    public static final int SEEK_TO_DELTA = 1;

    public static final String toOption(boolean z) {
        return z ? "1" : "0";
    }
}
