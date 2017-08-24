package com.baidu.tbadk.c;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private ImageFileInfo RA;
    private String Rz;
    private String albumId;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void cg(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String nG() {
        return this.Rz;
    }

    public void ch(String str) {
        this.Rz = str;
    }

    public ImageFileInfo nH() {
        return this.RA;
    }

    public void a(ImageFileInfo imageFileInfo) {
        this.RA = imageFileInfo;
    }
}
