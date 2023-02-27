package com.baidu.swan.apps.media.chooser.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class MediaModel implements Parcelable, Comparable<Object> {
    public static final Parcelable.Creator<MediaModel> CREATOR = new a();
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_VIDEO = "video";
    public long addDate;
    public String path;
    public long size;
    public String tempPath;
    public String type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAddDate() {
        return this.addDate;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public String getTempPath() {
        return this.tempPath;
    }

    public String getType() {
        return this.type;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<MediaModel> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaModel createFromParcel(Parcel parcel) {
            return new MediaModel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaModel[] newArray(int i) {
            return new MediaModel[i];
        }
    }

    public MediaModel(Parcel parcel) {
        this.path = parcel.readString();
        this.tempPath = parcel.readString();
        this.addDate = parcel.readLong();
        this.type = parcel.readString();
        this.size = parcel.readLong();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((MediaModel) obj).getAddDate()).compareTo(Long.valueOf(this.addDate));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MediaModel) {
            return TextUtils.equals(this.path, ((MediaModel) obj).path);
        }
        return false;
    }

    public void setAddDate(long j) {
        this.addDate = j;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setTempPath(String str) {
        this.tempPath = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public MediaModel(String str) {
        this.path = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.path);
        parcel.writeString(this.tempPath);
        parcel.writeLong(this.addDate);
        parcel.writeString(this.type);
        parcel.writeLong(this.size);
    }
}
