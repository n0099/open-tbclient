package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String aFO = String.valueOf(Integer.MAX_VALUE);
    public static final String aFP = String.valueOf(2147483646);
    private MediaFileInfo aFQ;
    private List<MediaFileInfo> aFR;
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

    public void uZ() {
        this.count++;
    }

    public ImageFileInfo va() {
        if (this.aFQ instanceof ImageFileInfo) {
            return (ImageFileInfo) this.aFQ;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.aFQ = mediaFileInfo;
    }

    public MediaFileInfo vb() {
        return this.aFQ;
    }

    public List<MediaFileInfo> vc() {
        return this.aFR;
    }

    public void v(List<MediaFileInfo> list) {
        this.aFR = list;
    }
}
