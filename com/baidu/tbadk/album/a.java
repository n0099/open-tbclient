package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String Rh = String.valueOf(Integer.MAX_VALUE);
    public static final String Ri = String.valueOf(2147483646);
    private MediaFileInfo Rj;
    private List<MediaFileInfo> Rk;
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
        if (this.Rj instanceof ImageFileInfo) {
            return (ImageFileInfo) this.Rj;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.Rj = mediaFileInfo;
    }

    public MediaFileInfo ny() {
        return this.Rj;
    }

    public List<MediaFileInfo> nz() {
        return this.Rk;
    }

    public void l(List<MediaFileInfo> list) {
        this.Rk = list;
    }
}
