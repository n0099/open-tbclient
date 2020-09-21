package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements Comparable<Object> {
    private String BD;
    private String cDh;
    public ArrayList<MediaModel> cDi;
    private long lastModified;

    public String iM() {
        return this.BD;
    }

    public void oK(String str) {
        this.BD = str;
    }

    public String atS() {
        return this.cDh;
    }

    public void oL(String str) {
        this.cDh = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void bj(long j) {
        this.lastModified = j;
    }

    public int atT() {
        return this.cDi.size();
    }

    public ArrayList<MediaModel> atN() {
        return this.cDi;
    }

    public void h(MediaModel mediaModel) {
        if (this.cDi == null) {
            this.cDi = new ArrayList<>();
        }
        this.cDi.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.BD + ", imageCount=" + atT() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.BD.equals(((a) obj).BD);
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
