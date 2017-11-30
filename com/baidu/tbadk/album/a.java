package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String Ri = String.valueOf(Integer.MAX_VALUE);
    public static final String Rj = String.valueOf(2147483646);
    private String Rk;
    private MediaFileInfo Rl;
    private List<MediaFileInfo> Rm;
    private String albumId;
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

    public String nz() {
        return this.Rk;
    }

    public void cb(String str) {
        this.Rk = str;
    }

    public ImageFileInfo nA() {
        if (this.Rl instanceof ImageFileInfo) {
            return (ImageFileInfo) this.Rl;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.Rl = mediaFileInfo;
    }

    public MediaFileInfo nB() {
        return this.Rl;
    }

    public List<MediaFileInfo> nC() {
        return this.Rm;
    }

    public void l(List<MediaFileInfo> list) {
        this.Rm = list;
    }
}
