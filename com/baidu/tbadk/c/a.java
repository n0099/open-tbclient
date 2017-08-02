package com.baidu.tbadk.c;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
public class a {
    private ImageFileInfo PZ;
    private String albumId;
    private String count;
    private String name;

    public String getAlbumId() {
        return this.albumId;
    }

    public void bX(String str) {
        this.albumId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String nv() {
        return this.count;
    }

    public void bY(String str) {
        this.count = str;
    }

    public ImageFileInfo nw() {
        return this.PZ;
    }

    public void a(ImageFileInfo imageFileInfo) {
        this.PZ = imageFileInfo;
    }
}
