package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes20.dex */
public class a {
    public static final String ALBUM_ID_ALL = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String ALBUM_ID_VIDEO = String.valueOf(2147483646);
    private String albumId;
    private int count;
    private MediaFileInfo esD;
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
        this.count = com.baidu.adp.lib.f.b.toInt(str, 0);
    }

    public void addCount() {
        this.count++;
    }

    public ImageFileInfo bhH() {
        if (this.esD instanceof ImageFileInfo) {
            return (ImageFileInfo) this.esD;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.esD = mediaFileInfo;
    }

    public MediaFileInfo bhI() {
        return this.esD;
    }

    public List<MediaFileInfo> getFileList() {
        return this.fileList;
    }

    public void setFileList(List<MediaFileInfo> list) {
        this.fileList = list;
    }
}
