package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static final String aas = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String aat = String.valueOf(2147483646);
    private MediaFileInfo aau;
    private List<MediaFileInfo> aav;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void cI(String str) {
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

    public void cJ(String str) {
        this.count = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public void rN() {
        this.count++;
    }

    public ImageFileInfo rO() {
        if (this.aau instanceof ImageFileInfo) {
            return (ImageFileInfo) this.aau;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.aau = mediaFileInfo;
    }

    public MediaFileInfo rP() {
        return this.aau;
    }

    public List<MediaFileInfo> rQ() {
        return this.aav;
    }

    public void p(List<MediaFileInfo> list) {
        this.aav = list;
    }
}
