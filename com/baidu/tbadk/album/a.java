package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static final String bsO = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String bsP = String.valueOf(2147483646);
    private String albumId;
    private MediaFileInfo bsQ;
    private List<MediaFileInfo> bsR;
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
        if (this.bsQ instanceof ImageFileInfo) {
            return (ImageFileInfo) this.bsQ;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.bsQ = mediaFileInfo;
    }

    public MediaFileInfo UO() {
        return this.bsQ;
    }

    public List<MediaFileInfo> UP() {
        return this.bsR;
    }

    public void H(List<MediaFileInfo> list) {
        this.bsR = list;
    }
}
