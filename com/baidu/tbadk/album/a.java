package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static final String bAS = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String bAT = String.valueOf(2147483646);
    private String albumId;
    private MediaFileInfo bAU;
    private List<MediaFileInfo> bAV;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void lx(String str) {
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

    public void ly(String str) {
        this.count = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public void aam() {
        this.count++;
    }

    public ImageFileInfo aan() {
        if (this.bAU instanceof ImageFileInfo) {
            return (ImageFileInfo) this.bAU;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.bAU = mediaFileInfo;
    }

    public MediaFileInfo aao() {
        return this.bAU;
    }

    public List<MediaFileInfo> aap() {
        return this.bAV;
    }

    public void O(List<MediaFileInfo> list) {
        this.bAV = list;
    }
}
