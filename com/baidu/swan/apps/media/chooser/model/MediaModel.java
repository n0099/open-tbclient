package com.baidu.swan.apps.media.chooser.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public class MediaModel implements Parcelable, Comparable<Object> {
    public static final Parcelable.Creator<MediaModel> CREATOR = new Parcelable.Creator<MediaModel>() { // from class: com.baidu.swan.apps.media.chooser.model.MediaModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: u */
        public MediaModel createFromParcel(Parcel parcel) {
            return new MediaModel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: iW */
        public MediaModel[] newArray(int i) {
            return new MediaModel[i];
        }
    };
    private long addDate;
    private String path;
    private long size;
    private String tempPath;
    private String type;

    public MediaModel(String str) {
        this.path = str;
    }

    public MediaModel(Parcel parcel) {
        this.path = parcel.readString();
        this.tempPath = parcel.readString();
        this.addDate = parcel.readLong();
        this.type = parcel.readString();
        this.size = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.path);
        parcel.writeString(this.tempPath);
        parcel.writeLong(this.addDate);
        parcel.writeString(this.type);
        parcel.writeLong(this.size);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MediaModel) {
            return TextUtils.equals(this.path, ((MediaModel) obj).path);
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((MediaModel) obj).awF()).compareTo(Long.valueOf(this.addDate));
    }

    public String getPath() {
        return this.path;
    }

    public long awF() {
        return this.addDate;
    }

    public void bs(long j) {
        this.addDate = j;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String awG() {
        return this.tempPath;
    }

    public void py(String str) {
        this.tempPath = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
