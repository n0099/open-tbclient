package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String Sj = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String Sk = String.valueOf(2147483646);
    private MediaFileInfo Sl;
    private List<MediaFileInfo> Sm;
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

    public void ot() {
        this.count++;
    }

    public ImageFileInfo ou() {
        if (this.Sl instanceof ImageFileInfo) {
            return (ImageFileInfo) this.Sl;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.Sl = mediaFileInfo;
    }

    public MediaFileInfo ov() {
        return this.Sl;
    }

    public List<MediaFileInfo> ow() {
        return this.Sm;
    }

    public void m(List<MediaFileInfo> list) {
        this.Sm = list;
    }
}
