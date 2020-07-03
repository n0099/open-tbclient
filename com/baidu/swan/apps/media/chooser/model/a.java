package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a implements Comparable<Object> {
    private String AX;
    private String crm;
    public ArrayList<MediaModel> crn;
    private long lastModified;

    public String hk() {
        return this.AX;
    }

    public void lQ(String str) {
        this.AX = str;
    }

    public String akf() {
        return this.crm;
    }

    public void lR(String str) {
        this.crm = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void aZ(long j) {
        this.lastModified = j;
    }

    public int akg() {
        return this.crn.size();
    }

    public ArrayList<MediaModel> aka() {
        return this.crn;
    }

    public void h(MediaModel mediaModel) {
        if (this.crn == null) {
            this.crn = new ArrayList<>();
        }
        this.crn.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.AX + ", imageCount=" + akg() + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.AX.equals(((a) obj).AX);
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
