package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static final String bzV = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String bzW = String.valueOf(2147483646);
    private String albumId;
    private MediaFileInfo bzX;
    private List<MediaFileInfo> bzY;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void lq(String str) {
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

    public void lr(String str) {
        this.count = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public void Zn() {
        this.count++;
    }

    public ImageFileInfo Zo() {
        if (this.bzX instanceof ImageFileInfo) {
            return (ImageFileInfo) this.bzX;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.bzX = mediaFileInfo;
    }

    public MediaFileInfo Zp() {
        return this.bzX;
    }

    public List<MediaFileInfo> Zq() {
        return this.bzY;
    }

    public void O(List<MediaFileInfo> list) {
        this.bzY = list;
    }
}
