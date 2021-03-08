package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a implements Comparable<Object> {
    private String DZ;
    private String dmR;
    public ArrayList<MediaModel> dmS;
    private long lastModified;

    public String ik() {
        return this.DZ;
    }

    public void pM(String str) {
        this.DZ = str;
    }

    public String aBz() {
        return this.dmR;
    }

    public void pN(String str) {
        this.dmR = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void cv(long j) {
        this.lastModified = j;
    }

    public int getImageCount() {
        return this.dmS.size();
    }

    public ArrayList<MediaModel> aBt() {
        return this.dmS;
    }

    public void h(MediaModel mediaModel) {
        if (this.dmS == null) {
            this.dmS = new ArrayList<>();
        }
        this.dmS.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.DZ + ", imageCount=" + getImageCount() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.DZ.equals(((a) obj).DZ);
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
