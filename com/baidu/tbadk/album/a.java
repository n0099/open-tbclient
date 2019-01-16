package com.baidu.tbadk.album;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static final String amh = String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    public static final String ami = String.valueOf(2147483646);
    private String albumId;
    private MediaFileInfo amj;
    private List<MediaFileInfo> amk;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void dE(String str) {
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

    public void dF(String str) {
        this.count = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public void wi() {
        this.count++;
    }

    public ImageFileInfo wj() {
        if (this.amj instanceof ImageFileInfo) {
            return (ImageFileInfo) this.amj;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.amj = mediaFileInfo;
    }

    public MediaFileInfo wk() {
        return this.amj;
    }

    public List<MediaFileInfo> wl() {
        return this.amk;
    }

    public void x(List<MediaFileInfo> list) {
        this.amk = list;
    }
}
