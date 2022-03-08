package com.baidu.tbadk.core.util;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public interface ImageProvider {
    ArrayList<String> getForumPhotoUrl();

    ArrayList<String> getImageUrl();

    ArrayList<ImageInfo> getImagesWithEmotions();

    ArrayList<String> getPhotoUrl();

    boolean isSupportImageSize();
}
