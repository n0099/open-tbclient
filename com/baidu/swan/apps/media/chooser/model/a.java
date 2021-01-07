package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a implements Comparable<Object> {
    private String Cz;
    private String dnS;
    public ArrayList<MediaModel> dnT;
    private long lastModified;

    public String il() {
        return this.Cz;
    }

    public void qy(String str) {
        this.Cz = str;
    }

    public String aES() {
        return this.dnS;
    }

    public void qz(String str) {
        this.dnS = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void cp(long j) {
        this.lastModified = j;
    }

    public int aET() {
        return this.dnT.size();
    }

    public ArrayList<MediaModel> aEM() {
        return this.dnT;
    }

    public void h(MediaModel mediaModel) {
        if (this.dnT == null) {
            this.dnT = new ArrayList<>();
        }
        this.dnT.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.Cz + ", imageCount=" + aET() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.Cz.equals(((a) obj).Cz);
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
