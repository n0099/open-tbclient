package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes25.dex */
public class a implements Comparable<Object> {
    private String CL;
    private String diV;
    public ArrayList<MediaModel> diW;
    private long lastModified;

    public String iN() {
        return this.CL;
    }

    public void qE(String str) {
        this.CL = str;
    }

    public String aDy() {
        return this.diV;
    }

    public void qF(String str) {
        this.diV = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void co(long j) {
        this.lastModified = j;
    }

    public int aDz() {
        return this.diW.size();
    }

    public ArrayList<MediaModel> aDt() {
        return this.diW;
    }

    public void h(MediaModel mediaModel) {
        if (this.diW == null) {
            this.diW = new ArrayList<>();
        }
        this.diW.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.CL + ", imageCount=" + aDz() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.CL.equals(((a) obj).CL);
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).getLastModified()).compareTo(Long.valueOf(this.lastModified));
    }
}
