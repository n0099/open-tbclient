package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static final String ALBUM_ID_ALL = String.valueOf(Integer.MAX_VALUE);
    public static final String ALBUM_ID_VIDEO = String.valueOf(2147483646);
    private String albumId;
    private MediaFileInfo bTh;
    private int count;
    private List<MediaFileInfo> fileList;
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
        this.count = com.baidu.adp.lib.g.b.toInt(str, 0);
    }

    public void addCount() {
        this.count++;
    }

    public ImageFileInfo afc() {
        if (this.bTh instanceof ImageFileInfo) {
            return (ImageFileInfo) this.bTh;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.bTh = mediaFileInfo;
    }

    public MediaFileInfo afd() {
        return this.bTh;
    }

    public List<MediaFileInfo> getFileList() {
        return this.fileList;
    }

    public void setFileList(List<MediaFileInfo> list) {
        this.fileList = list;
    }
}
