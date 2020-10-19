package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a implements Comparable<Object> {
    private String BU;
    private String cPm;
    public ArrayList<MediaModel> cPn;
    private long lastModified;

    public String iN() {
        return this.BU;
    }

    public void pw(String str) {
        this.BU = str;
    }

    public String awD() {
        return this.cPm;
    }

    public void px(String str) {
        this.cPm = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void br(long j) {
        this.lastModified = j;
    }

    public int awE() {
        return this.cPn.size();
    }

    public ArrayList<MediaModel> awy() {
        return this.cPn;
    }

    public void h(MediaModel mediaModel) {
        if (this.cPn == null) {
            this.cPn = new ArrayList<>();
        }
        this.cPn.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.BU + ", imageCount=" + awE() + "]";
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
