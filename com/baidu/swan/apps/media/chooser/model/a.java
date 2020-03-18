package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a implements Comparable<Object> {
    private String bDq;
    public ArrayList<MediaModel> bDr;
    private String eL;
    private long lastModified;

    public String bx() {
        return this.eL;
    }

    public void ji(String str) {
        this.eL = str;
    }

    public String getDir() {
        return this.bDq;
    }

    public void jj(String str) {
        this.bDq = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public int getImageCount() {
        return this.bDr.size();
    }

    public ArrayList<MediaModel> XJ() {
        return this.bDr;
    }

    public void h(MediaModel mediaModel) {
        if (this.bDr == null) {
            this.bDr = new ArrayList<>();
        }
        this.bDr.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.eL + ", imageCount=" + getImageCount() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.eL.equals(((a) obj).eL);
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
