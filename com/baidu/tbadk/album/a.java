package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static final String bsN = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String bsO = String.valueOf(2147483646);
    private String albumId;
    private MediaFileInfo bsP;
    private List<MediaFileInfo> bsQ;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void km(String str) {
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

    public void kn(String str) {
        this.count = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public void UM() {
        this.count++;
    }

    public ImageFileInfo UN() {
        if (this.bsP instanceof ImageFileInfo) {
            return (ImageFileInfo) this.bsP;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.bsP = mediaFileInfo;
    }

    public MediaFileInfo UO() {
        return this.bsP;
    }

    public List<MediaFileInfo> UP() {
        return this.bsQ;
    }

    public void H(List<MediaFileInfo> list) {
        this.bsQ = list;
    }
}
