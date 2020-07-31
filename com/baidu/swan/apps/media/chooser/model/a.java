package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a implements Comparable<Object> {
    private String AZ;
    private String ctp;
    public ArrayList<MediaModel> ctq;
    private long lastModified;

    public String hk() {
        return this.AZ;
    }

    public void mr(String str) {
        this.AZ = str;
    }

    public String alv() {
        return this.ctp;
    }

    public void ms(String str) {
        this.ctp = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void bd(long j) {
        this.lastModified = j;
    }

    public int alw() {
        return this.ctq.size();
    }

    public ArrayList<MediaModel> alq() {
        return this.ctq;
    }

    public void h(MediaModel mediaModel) {
        if (this.ctq == null) {
            this.ctq = new ArrayList<>();
        }
        this.ctq.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.AZ + ", imageCount=" + alw() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.AZ.equals(((a) obj).AZ);
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
