package com.baidu.swan.apps.media.chooser.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes11.dex */
public class VideoModel extends MediaModel {
    public static final Parcelable.Creator<MediaModel> CREATOR = new Parcelable.Creator<MediaModel>() { // from class: com.baidu.swan.apps.media.chooser.model.VideoModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: s */
        public MediaModel createFromParcel(Parcel parcel) {
            return new VideoModel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fA */
        public MediaModel[] newArray(int i) {
            return new MediaModel[i];
        }
    };
    private long duration;
    private int height;
    private int rotation;
    private Bitmap thumbnailBitmap;
    private String uri;
    private int width;

    public VideoModel(String str) {
        super(str);
        setType("video");
    }

    private VideoModel(Parcel parcel) {
        super(parcel);
        this.uri = parcel.readString();
        this.duration = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.rotation = parcel.readInt();
    }

    @Override // com.baidu.swan.apps.media.chooser.model.MediaModel, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.uri);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.rotation);
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }
}
