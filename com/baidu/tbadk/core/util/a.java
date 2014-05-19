package com.baidu.tbadk.core.util;

import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class a implements ad {
    @Override // com.baidu.tbadk.core.util.ad
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public LinkedList<ab> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
