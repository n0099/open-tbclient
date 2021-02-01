package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a implements Comparable<Object> {
    private String Cx;
    private String dlq;
    public ArrayList<MediaModel> dlr;
    private long lastModified;

    public String ik() {
        return this.Cx;
    }

    public void pF(String str) {
        this.Cx = str;
    }

    public String aBw() {
        return this.dlq;
    }

    public void pG(String str) {
        this.dlq = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void cv(long j) {
        this.lastModified = j;
    }

    public int getImageCount() {
        return this.dlr.size();
    }

    public ArrayList<MediaModel> aBq() {
        return this.dlr;
    }

    public void h(MediaModel mediaModel) {
        if (this.dlr == null) {
            this.dlr = new ArrayList<>();
        }
        this.dlr.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.Cx + ", imageCount=" + getImageCount() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.Cx.equals(((a) obj).Cx);
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
