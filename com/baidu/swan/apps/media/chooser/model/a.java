package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a implements Comparable<Object> {
    private String byj;
    public ArrayList<MediaModel> byk;
    private String eK;
    private long lastModified;

    public String bw() {
        return this.eK;
    }

    public void iR(String str) {
        this.eK = str;
    }

    public String getDir() {
        return this.byj;
    }

    public void iS(String str) {
        this.byj = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public int getImageCount() {
        return this.byk.size();
    }

    public ArrayList<MediaModel> UT() {
        return this.byk;
    }

    public void h(MediaModel mediaModel) {
        if (this.byk == null) {
            this.byk = new ArrayList<>();
        }
        this.byk.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.eK + ", imageCount=" + getImageCount() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.eK.equals(((a) obj).eK);
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
