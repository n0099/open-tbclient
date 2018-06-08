package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static final String aap = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String aaq = String.valueOf(2147483646);
    private MediaFileInfo aar;
    private List<MediaFileInfo> aas;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void cG(String str) {
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

    public void cH(String str) {
        this.count = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public void rN() {
        this.count++;
    }

    public ImageFileInfo rO() {
        if (this.aar instanceof ImageFileInfo) {
            return (ImageFileInfo) this.aar;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.aar = mediaFileInfo;
    }

    public MediaFileInfo rP() {
        return this.aar;
    }

    public List<MediaFileInfo> rQ() {
        return this.aas;
    }

    public void p(List<MediaFileInfo> list) {
        this.aas = list;
    }
}
