package com.baidu.tbadk.b;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String QP;
    private ImageFileInfo QR;
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

    public String nv() {
        return this.QP;
    }

    public void cb(String str) {
        this.QP = str;
    }

    public ImageFileInfo nw() {
        return this.QR;
    }

    public void a(ImageFileInfo imageFileInfo) {
        this.QR = imageFileInfo;
    }
}
