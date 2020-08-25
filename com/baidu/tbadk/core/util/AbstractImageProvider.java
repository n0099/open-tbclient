package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class AbstractImageProvider extends OrmObject implements w {
    public boolean isSupportImageSize() {
        return false;
    }

    public ArrayList<String> getImageUrl() {
        return null;
    }

    public ArrayList<ImageInfo> getImagesWithEmotions() {
        return null;
    }

    public ArrayList<String> getPhotoUrl() {
        return null;
    }

    public ArrayList<String> getForumPhotoUrl() {
        return null;
    }
}
