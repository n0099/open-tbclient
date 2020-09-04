package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a implements Comparable<Object> {
    private String BD;
    private String cBh;
    public ArrayList<MediaModel> cBi;
    private long lastModified;

    public String iL() {
        return this.BD;
    }

    public void or(String str) {
        this.BD = str;
    }

    public String atj() {
        return this.cBh;
    }

    public void os(String str) {
        this.cBh = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void bi(long j) {
        this.lastModified = j;
    }

    public int atk() {
        return this.cBi.size();
    }

    public ArrayList<MediaModel> ate() {
        return this.cBi;
    }

    public void h(MediaModel mediaModel) {
        if (this.cBi == null) {
            this.cBi = new ArrayList<>();
        }
        this.cBi.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.BD + ", imageCount=" + atk() + "]";
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
