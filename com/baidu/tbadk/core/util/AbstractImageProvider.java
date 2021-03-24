package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class AbstractImageProvider extends OrmObject implements ImageProvider {
    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getForumPhotoUrl() {
        return null;
    }

    public ArrayList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<ImageInfo> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public boolean isSupportImageSize() {
        return false;
    }
}
