package com.baidu.swan.apps.media.chooser.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VideoModel extends MediaModel {
    public static final Parcelable.Creator<MediaModel> CREATOR = new a();
    public long duration;
    public int height;
    public int rotation;
    public Bitmap thumbnailBitmap;
    public String uri;
    public int width;

    /* loaded from: classes2.dex */
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

    public /* synthetic */ VideoModel(Parcel parcel, a aVar) {
        this(parcel);
    }

    public long j() {
        return this.duration;
    }

    public int k() {
        return this.height;
    }

    public int l() {
        return this.width;
    }

    public void m(long j) {
        this.duration = j;
    }

    public void n(int i) {
        this.height = i;
    }

    public void o(int i) {
        this.width = i;
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
        i("video");
    }

    public VideoModel(Parcel parcel) {
        super(parcel);
        this.uri = parcel.readString();
        this.duration = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.rotation = parcel.readInt();
    }
}
