package com.baidu.ala.dumixar;

import com.baidu.minivideo.arface.bean.Sticker;
/* loaded from: classes5.dex */
public class ArCache {
    private static Sticker sDuSticker;

    public static void setDuSticker(Sticker sticker) {
        sDuSticker = sticker;
    }

    public static Sticker getDuSticker() {
        return sDuSticker;
    }
}
