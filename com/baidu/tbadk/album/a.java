package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String Sf = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String Sg = String.valueOf(2147483646);
    private MediaFileInfo Sh;
    private List<MediaFileInfo> Si;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void cf(String str) {
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

    public void cg(String str) {
        this.count = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public void os() {
        this.count++;
    }

    public ImageFileInfo ot() {
        if (this.Sh instanceof ImageFileInfo) {
            return (ImageFileInfo) this.Sh;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.Sh = mediaFileInfo;
    }

    public MediaFileInfo ou() {
        return this.Sh;
    }

    public List<MediaFileInfo> ov() {
        return this.Si;
    }

    public void m(List<MediaFileInfo> list) {
        this.Si = list;
    }
}
