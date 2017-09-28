package com.baidu.tbadk.b;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private String QM;
    private ImageFileInfo QN;
    private String albumId;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void bW(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String nA() {
        return this.QM;
    }

    public void bX(String str) {
        this.QM = str;
    }

    public ImageFileInfo nB() {
        return this.QN;
    }

    public void a(ImageFileInfo imageFileInfo) {
        this.QN = imageFileInfo;
    }
}
