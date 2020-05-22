package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a implements Comparable<Object> {
    private String Au;
    private String cmy;
    public ArrayList<MediaModel> cmz;
    private long lastModified;

    public String gU() {
        return this.Au;
    }

    public void lI(String str) {
        this.Au = str;
    }

    public String aiZ() {
        return this.cmy;
    }

    public void lJ(String str) {
        this.cmy = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void aZ(long j) {
        this.lastModified = j;
    }

    public int aja() {
        return this.cmz.size();
    }

    public ArrayList<MediaModel> aiU() {
        return this.cmz;
    }

    public void h(MediaModel mediaModel) {
        if (this.cmz == null) {
            this.cmz = new ArrayList<>();
        }
        this.cmz.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.Au + ", imageCount=" + aja() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.Au.equals(((a) obj).Au);
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
