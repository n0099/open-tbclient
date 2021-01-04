package com.baidu.live.tbadk.album;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes11.dex */
public class AlbumData {
    public static final String ALBUM_ID_ALL = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String ALBUM_ID_VIDEO = String.valueOf(2147483646);
    private String albumId;
    private int count;
    private List<MediaFileInfo> fileList;
    private MediaFileInfo lastImageInfo;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = JavaTypesHelper.toInt(str, 0);
    }

    public void addCount() {
        this.count++;
    }

    public ImageFileInfo getLastFileInfo() {
        if (this.lastImageInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) this.lastImageInfo;
        }
        return null;
    }

    public void setLastFileInfo(MediaFileInfo mediaFileInfo) {
        this.lastImageInfo = mediaFileInfo;
    }

    public MediaFileInfo getMediaFileInfo() {
        return this.lastImageInfo;
    }

    public List<MediaFileInfo> getFileList() {
        return this.fileList;
    }

    public void setFileList(List<MediaFileInfo> list) {
        this.fileList = list;
    }
}
