package com.baidu.live.tbadk.core.util;

import java.util.ArrayList;
@Deprecated
/* loaded from: classes11.dex */
public abstract class AbstractImageProvider implements ImageProvider {
    @Override // com.baidu.live.tbadk.core.util.ImageProvider
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.live.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.util.ImageProvider
    public ArrayList<ImageInfo> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.live.tbadk.core.util.ImageProvider
    public ArrayList<String> getForumPhotoUrl() {
        return null;
    }
}
