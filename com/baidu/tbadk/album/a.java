package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static final String ZW = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String ZX = String.valueOf(2147483646);
    private MediaFileInfo ZY;
    private List<MediaFileInfo> ZZ;
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

    public void ry() {
        this.count++;
    }

    public ImageFileInfo rz() {
        if (this.ZY instanceof ImageFileInfo) {
            return (ImageFileInfo) this.ZY;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.ZY = mediaFileInfo;
    }

    public MediaFileInfo rA() {
        return this.ZY;
    }

    public List<MediaFileInfo> rB() {
        return this.ZZ;
    }

    public void o(List<MediaFileInfo> list) {
        this.ZZ = list;
    }
}
