package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private MediaFileInfo acB;
    private List<MediaFileInfo> acC;
    private String albumId;
    private int count;
    private String name;
    public static final String acz = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String acA = String.valueOf(2147483646);

    public String getAlbumId() {
        return this.albumId;
    }

    public void cW(String str) {
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

    public void cX(String str) {
        this.count = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public void sC() {
        this.count++;
    }

    public ImageFileInfo sD() {
        if (this.acB instanceof ImageFileInfo) {
            return (ImageFileInfo) this.acB;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.acB = mediaFileInfo;
    }

    public MediaFileInfo sE() {
        return this.acB;
    }

    public List<MediaFileInfo> sF() {
        return this.acC;
    }

    public void o(List<MediaFileInfo> list) {
        this.acC = list;
    }
}
