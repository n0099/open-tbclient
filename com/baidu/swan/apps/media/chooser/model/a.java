package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a implements Comparable<Object> {
    private String BU;
    private String ddE;
    public ArrayList<MediaModel> ddF;
    private long lastModified;

    public String iN() {
        return this.BU;
    }

    public void qd(String str) {
        this.BU = str;
    }

    public String aAX() {
        return this.ddE;
    }

    public void qe(String str) {
        this.ddE = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void bP(long j) {
        this.lastModified = j;
    }

    public int aAY() {
        return this.ddF.size();
    }

    public ArrayList<MediaModel> aAS() {
        return this.ddF;
    }

    public void h(MediaModel mediaModel) {
        if (this.ddF == null) {
            this.ddF = new ArrayList<>();
        }
        this.ddF.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.BU + ", imageCount=" + aAY() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.BU.equals(((a) obj).BU);
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
