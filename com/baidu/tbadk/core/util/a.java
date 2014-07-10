package com.baidu.tbadk.core.util;

import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class a implements ai {
    @Override // com.baidu.tbadk.core.util.ai
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public LinkedList<ad> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
