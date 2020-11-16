package com.baidu.searchbox.ugc.draft;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class DraftData implements Parcelable {
    public static final Parcelable.Creator<DraftData> CREATOR = new Parcelable.Creator<DraftData>() { // from class: com.baidu.searchbox.ugc.draft.DraftData.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DraftData createFromParcel(Parcel parcel) {
            return new DraftData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DraftData[] newArray(int i) {
            return new DraftData[i];
        }
    };
    public String content;
    public List<String> images;
    public String mediaId;
    public String sourceKey;
    public String target;
    public long timestamp;
    public String title;
    public String video;
    public String videoCover;
    public String videoInfo;
    public String videoProductionType;

    public DraftData() {
        this.images = new ArrayList();
    }

    private DraftData(Parcel parcel) {
        this.images = new ArrayList();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.images = parcel.createStringArrayList();
        this.mediaId = parcel.readString();
        this.video = parcel.readString();
        this.videoCover = parcel.readString();
        this.videoInfo = parcel.readString();
        this.target = parcel.readString();
        this.timestamp = parcel.readLong();
        this.videoProductionType = parcel.readString();
        this.sourceKey = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeStringList(this.images);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.video);
        parcel.writeString(this.videoCover);
        parcel.writeString(this.videoInfo);
        parcel.writeString(this.target);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.videoProductionType);
        parcel.writeString(this.sourceKey);
    }
}
