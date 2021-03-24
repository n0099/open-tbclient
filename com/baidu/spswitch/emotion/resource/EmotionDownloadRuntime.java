package com.baidu.spswitch.emotion.resource;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes3.dex */
public class EmotionDownloadRuntime {
    @Inject(force = false)
    public static IEmotionDownload getDownloadImpl() {
        return IEmotionDownload.EMPTY;
    }
}
