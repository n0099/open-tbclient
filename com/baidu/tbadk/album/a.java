package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String aFQ = String.valueOf(Integer.MAX_VALUE);
    public static final String aFR = String.valueOf(2147483646);
    private MediaFileInfo aFS;
    private List<MediaFileInfo> aFT;
    private String albumId;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void ch(String str) {
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

    public void ci(String str) {
        this.count = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public void va() {
        this.count++;
    }

    public ImageFileInfo vb() {
        if (this.aFS instanceof ImageFileInfo) {
            return (ImageFileInfo) this.aFS;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.aFS = mediaFileInfo;
    }

    public MediaFileInfo vc() {
        return this.aFS;
    }

    public List<MediaFileInfo> vd() {
        return this.aFT;
    }

    public void v(List<MediaFileInfo> list) {
        this.aFT = list;
    }
}
