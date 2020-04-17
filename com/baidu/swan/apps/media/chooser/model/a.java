package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a implements Comparable<Object> {
    private String Au;
    private String cbO;
    public ArrayList<MediaModel> cbP;
    private long lastModified;

    public String gU() {
        return this.Au;
    }

    public void kv(String str) {
        this.Au = str;
    }

    public String afL() {
        return this.cbO;
    }

    public void kw(String str) {
        this.cbO = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void aS(long j) {
        this.lastModified = j;
    }

    public int afM() {
        return this.cbP.size();
    }

    public ArrayList<MediaModel> afG() {
        return this.cbP;
    }

    public void h(MediaModel mediaModel) {
        if (this.cbP == null) {
            this.cbP = new ArrayList<>();
        }
        this.cbP.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.Au + ", imageCount=" + afM() + "]";
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
