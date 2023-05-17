package com.baidu.swan.apps.media.chooser.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class VideoModel extends MediaModel {
    public static final Parcelable.Creator<MediaModel> CREATOR = new a();
    public long duration;
    public int height;
    public int rotation;
    public Bitmap thumbnailBitmap;
    public String uri;
    public int width;

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public int getRotation() {
        return this.rotation;
    }

    public Bitmap getThumbnailBitmap() {
        return this.thumbnailBitmap;
    }

    public String getUri() {
        return this.uri;
    }

    public int getWidth() {
        return this.width;
    }

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<MediaModel> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaModel createFromParcel(Parcel parcel) {
            return new VideoModel(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaModel[] newArray(int i) {
            return new MediaModel[i];
        }
    }

    public VideoModel(Parcel parcel) {
        super(parcel);
        this.uri = parcel.readString();
        this.duration = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.rotation = parcel.readInt();
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    public void setThumbnailBitmap(Bitmap bitmap) {
        this.thumbnailBitmap = bitmap;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public /* synthetic */ VideoModel(Parcel parcel, a aVar) {
        this(parcel);
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

    public VideoModel(String str) {
        super(str);
        setType("video");
    }
}
