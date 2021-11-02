package com.baidu.spswitch.emotion.resource;

import java.io.File;
/* loaded from: classes8.dex */
public interface IResourceProvider {
    String getEmotionConfigContent();

    File getEmotionIconResFile(String str);

    File getEmotionSoundFile();

    void loadResource();

    void releaseResource();
}
