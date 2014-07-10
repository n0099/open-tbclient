package com.baidu.tbadk.core.util;

import java.util.LinkedList;
/* loaded from: classes.dex */
public interface ai {
    LinkedList<String> getForumPhotoUrl();

    LinkedList<String> getImageUrl();

    LinkedList<ad> getImagesWithEmotions();

    LinkedList<String> getPhotoUrl();

    boolean isSupportImageSize();
}
