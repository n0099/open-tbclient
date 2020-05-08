package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a implements Comparable<Object> {
    private String Au;
    private String cbU;
    public ArrayList<MediaModel> cbV;
    private long lastModified;

    public String gU() {
        return this.Au;
    }

    public void kv(String str) {
        this.Au = str;
    }

    public String afK() {
        return this.cbU;
    }

    public void kw(String str) {
        this.cbU = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void aS(long j) {
        this.lastModified = j;
    }

    public int afL() {
        return this.cbV.size();
    }

    public ArrayList<MediaModel> afF() {
        return this.cbV;
    }

    public void h(MediaModel mediaModel) {
        if (this.cbV == null) {
            this.cbV = new ArrayList<>();
        }
        this.cbV.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.Au + ", imageCount=" + afL() + "]";
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
