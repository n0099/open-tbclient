package com.baidu.live.tbadk.core.util;

import java.util.ArrayList;
@Deprecated
/* loaded from: classes7.dex */
public interface ImageProvider {
    ArrayList<String> getForumPhotoUrl();

    ArrayList<String> getImageUrl();

    ArrayList<ImageInfo> getImagesWithEmotions();

    ArrayList<String> getPhotoUrl();

    boolean isSupportImageSize();
}
