package com.baidu.tbadk.album;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class MediaFileInfo extends OrmObject implements Serializable {
    public static final int TYPE_ADD = 2;
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_VIDEO = 1;
    public static final int TYPE_VIEW_COUNT = 3;
    private int sortTime;

    public abstract int getType();

    public int getSortTime() {
        return this.sortTime;
    }

    public void setSortTime(int i) {
        this.sortTime = i;
    }
}
