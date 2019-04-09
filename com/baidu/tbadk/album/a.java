package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static final String bsS = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String bsT = String.valueOf(2147483646);
    private String albumId;
    private MediaFileInfo bsU;
    private List<MediaFileInfo> bsV;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void kn(String str) {
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

    public void ko(String str) {
        this.count = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public void UJ() {
        this.count++;
    }

    public ImageFileInfo UK() {
        if (this.bsU instanceof ImageFileInfo) {
            return (ImageFileInfo) this.bsU;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.bsU = mediaFileInfo;
    }

    public MediaFileInfo UL() {
        return this.bsU;
    }

    public List<MediaFileInfo> UM() {
        return this.bsV;
    }

    public void H(List<MediaFileInfo> list) {
        this.bsV = list;
    }
}
