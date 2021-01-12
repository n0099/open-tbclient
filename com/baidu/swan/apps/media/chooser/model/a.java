package com.baidu.swan.apps.media.chooser.model;

import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a implements Comparable<Object> {
    private String Cx;
    private String djf;
    public ArrayList<MediaModel> djg;
    private long lastModified;

    public String il() {
        return this.Cx;
    }

    public void pn(String str) {
        this.Cx = str;
    }

    public String aAY() {
        return this.djf;
    }

    public void po(String str) {
        this.djf = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void cp(long j) {
        this.lastModified = j;
    }

    public int aAZ() {
        return this.djg.size();
    }

    public ArrayList<MediaModel> aAS() {
        return this.djg;
    }

    public void h(MediaModel mediaModel) {
        if (this.djg == null) {
            this.djg = new ArrayList<>();
        }
        this.djg.add(mediaModel);
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.Cx + ", imageCount=" + aAZ() + "]";
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
