package com.baidu.spswitch.emotion.resource;

import java.io.File;
/* loaded from: classes11.dex */
public interface IResourceProvider {
    String getEmotionConfigContent();

    File getEmotionIconResFile(String str);

    File getEmotionSoundFile();

    void loadResource();

    void releaseResource();
}
