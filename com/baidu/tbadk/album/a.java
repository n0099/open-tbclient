package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static final String ZX = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String ZY = String.valueOf(2147483646);
    private MediaFileInfo ZZ;
    private List<MediaFileInfo> aaa;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void cF(String str) {
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

    public void cG(String str) {
        this.count = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public void rw() {
        this.count++;
    }

    public ImageFileInfo rx() {
        if (this.ZZ instanceof ImageFileInfo) {
            return (ImageFileInfo) this.ZZ;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.ZZ = mediaFileInfo;
    }

    public MediaFileInfo ry() {
        return this.ZZ;
    }

    public List<MediaFileInfo> rz() {
        return this.aaa;
    }

    public void o(List<MediaFileInfo> list) {
        this.aaa = list;
    }
}
