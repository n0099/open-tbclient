package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String Rg = String.valueOf(Integer.MAX_VALUE);
    public static final String Rh = String.valueOf(2147483646);
    private MediaFileInfo Ri;
    private List<MediaFileInfo> Rj;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void ca(String str) {
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

    public void cb(String str) {
        this.count = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public void nw() {
        this.count++;
    }

    public ImageFileInfo nx() {
        if (this.Ri instanceof ImageFileInfo) {
            return (ImageFileInfo) this.Ri;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.Ri = mediaFileInfo;
    }

    public MediaFileInfo ny() {
        return this.Ri;
    }

    public List<MediaFileInfo> nz() {
        return this.Rj;
    }

    public void l(List<MediaFileInfo> list) {
        this.Rj = list;
    }
}
