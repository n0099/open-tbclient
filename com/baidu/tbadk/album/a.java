package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static final String alN = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String alO = String.valueOf(2147483646);
    private MediaFileInfo alP;
    private List<MediaFileInfo> alQ;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void dC(String str) {
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

    public void dD(String str) {
        this.count = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public void wb() {
        this.count++;
    }

    public ImageFileInfo wc() {
        if (this.alP instanceof ImageFileInfo) {
            return (ImageFileInfo) this.alP;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.alP = mediaFileInfo;
    }

    public MediaFileInfo wd() {
        return this.alP;
    }

    public List<MediaFileInfo> we() {
        return this.alQ;
    }

    public void x(List<MediaFileInfo> list) {
        this.alQ = list;
    }
}
