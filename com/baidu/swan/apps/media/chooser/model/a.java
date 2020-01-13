package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a implements Comparable<Object> {
    private String byW;
    public ArrayList<MediaModel> byX;
    private String eJ;
    private long lastModified;

    public String bw() {
        return this.eJ;
    }

    public void iU(String str) {
        this.eJ = str;
    }

    public String getDir() {
        return this.byW;
    }

    public void iV(String str) {
        this.byW = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public int getImageCount() {
        return this.byX.size();
    }

    public ArrayList<MediaModel> Vq() {
        return this.byX;
    }

    public void h(MediaModel mediaModel) {
        if (this.byX == null) {
            this.byX = new ArrayList<>();
        }
        this.byX.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.eJ + ", imageCount=" + getImageCount() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.eJ.equals(((a) obj).eJ);
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
