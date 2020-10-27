package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a implements Comparable<Object> {
    private String BU;
    private String cXI;
    public ArrayList<MediaModel> cXJ;
    private long lastModified;

    public String iN() {
        return this.BU;
    }

    public void pP(String str) {
        this.BU = str;
    }

    public String ayx() {
        return this.cXI;
    }

    public void pQ(String str) {
        this.cXI = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void bt(long j) {
        this.lastModified = j;
    }

    public int ayy() {
        return this.cXJ.size();
    }

    public ArrayList<MediaModel> ays() {
        return this.cXJ;
    }

    public void h(MediaModel mediaModel) {
        if (this.cXJ == null) {
            this.cXJ = new ArrayList<>();
        }
        this.cXJ.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.BU + ", imageCount=" + ayy() + "]";
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
