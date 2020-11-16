package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a implements Comparable<Object> {
    private String BU;
    private String dbU;
    public ArrayList<MediaModel> dbV;
    private long lastModified;

    public String iN() {
        return this.BU;
    }

    public void pX(String str) {
        this.BU = str;
    }

    public String aAp() {
        return this.dbU;
    }

    public void pY(String str) {
        this.dbU = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void bP(long j) {
        this.lastModified = j;
    }

    public int aAq() {
        return this.dbV.size();
    }

    public ArrayList<MediaModel> aAk() {
        return this.dbV;
    }

    public void h(MediaModel mediaModel) {
        if (this.dbV == null) {
            this.dbV = new ArrayList<>();
        }
        this.dbV.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.BU + ", imageCount=" + aAq() + "]";
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
