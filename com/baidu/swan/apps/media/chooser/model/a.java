package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a implements Comparable<Object> {
    private String bDe;
    public ArrayList<MediaModel> bDf;
    private String eM;
    private long lastModified;

    public String bx() {
        return this.eM;
    }

    public void jj(String str) {
        this.eM = str;
    }

    public String getDir() {
        return this.bDe;
    }

    public void jk(String str) {
        this.bDe = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public int getImageCount() {
        return this.bDf.size();
    }

    public ArrayList<MediaModel> XG() {
        return this.bDf;
    }

    public void h(MediaModel mediaModel) {
        if (this.bDf == null) {
            this.bDf = new ArrayList<>();
        }
        this.bDf.add(mediaModel);
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
