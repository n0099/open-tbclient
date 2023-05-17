package com.baidu.spswitch.emotion.resource;

import java.io.File;
/* loaded from: classes4.dex */
public interface IResourceProvider {
    String getEmotionConfigContent();

    String getEmotionEffectBasePath();

    String getEmotionEffectInfoContent();

    File getEmotionIconResFile(String str);

    File getEmotionSoundFile();

    void loadResource();

    void releaseResource();
}
