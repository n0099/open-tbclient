package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static final String aFN = String.valueOf(Integer.MAX_VALUE);
    public static final String aFO = String.valueOf(2147483646);
    private MediaFileInfo aFP;
    private List<MediaFileInfo> aFQ;
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
        if (this.aFP instanceof ImageFileInfo) {
            return (ImageFileInfo) this.aFP;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.aFP = mediaFileInfo;
    }

    public MediaFileInfo vb() {
        return this.aFP;
    }

    public List<MediaFileInfo> vc() {
        return this.aFQ;
    }

    public void v(List<MediaFileInfo> list) {
        this.aFQ = list;
    }
}
