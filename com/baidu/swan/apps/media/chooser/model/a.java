package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a implements Comparable<Object> {
    private String bDd;
    public ArrayList<MediaModel> bDe;
    private String eM;
    private long lastModified;

    public String bx() {
        return this.eM;
    }

    public void jj(String str) {
        this.eM = str;
    }

    public String getDir() {
        return this.bDd;
    }

    public void jk(String str) {
        this.bDd = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public int getImageCount() {
        return this.bDe.size();
    }

    public ArrayList<MediaModel> XE() {
        return this.bDe;
    }

    public void h(MediaModel mediaModel) {
        if (this.bDe == null) {
            this.bDe = new ArrayList<>();
        }
        this.bDe.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.eM + ", imageCount=" + getImageCount() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.eM.equals(((a) obj).eM);
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
