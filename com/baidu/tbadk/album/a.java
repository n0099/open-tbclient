package com.baidu.tbadk.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static final String bBq = String.valueOf(Integer.MAX_VALUE);
    public static final String bBr = String.valueOf(2147483646);
    private String albumId;
    private MediaFileInfo bBs;
    private List<MediaFileInfo> bBt;
    private int count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void lz(String str) {
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

    public void lA(String str) {
        this.count = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public void aaq() {
        this.count++;
    }

    public ImageFileInfo aar() {
        if (this.bBs instanceof ImageFileInfo) {
            return (ImageFileInfo) this.bBs;
        }
        return null;
    }

    public void a(MediaFileInfo mediaFileInfo) {
        this.bBs = mediaFileInfo;
    }

    public MediaFileInfo aas() {
        return this.bBs;
    }

    public List<MediaFileInfo> aat() {
        return this.bBt;
    }

    public void O(List<MediaFileInfo> list) {
        this.bBt = list;
    }
}
