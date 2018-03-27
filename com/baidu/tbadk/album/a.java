package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String aGZ = String.valueOf(Integer.MAX_VALUE);
    public static final String aHa = String.valueOf(2147483646);
    private MediaFileInfo aHb;
    private List<MediaFileInfo> aHc;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void co(String str) {
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

    public void cp(String str) {
        this.count = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public void vM() {
        this.count++;
    }

    public ImageFileInfo vN() {
        if (this.aHb instanceof ImageFileInfo) {
            return (ImageFileInfo) this.aHb;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.aHb = mediaFileInfo;
    }

    public MediaFileInfo vO() {
        return this.aHb;
    }

    public List<MediaFileInfo> vP() {
        return this.aHc;
    }

    public void v(List<MediaFileInfo> list) {
        this.aHc = list;
    }
}
