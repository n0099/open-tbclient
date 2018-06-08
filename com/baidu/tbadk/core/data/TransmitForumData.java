package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class TransmitForumData implements Parcelable, com.baidu.adp.widget.ListView.h {
    public boolean akk;
    public String avatar;
    public boolean checked;
    public long forumId;
    public String forumName;
    public int type;
    public static final BdUniqueId akj = BdUniqueId.gen();
    public static final Parcelable.Creator<TransmitForumData> CREATOR = new Parcelable.Creator<TransmitForumData>() { // from class: com.baidu.tbadk.core.data.TransmitForumData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: g */
        public TransmitForumData createFromParcel(Parcel parcel) {
            return new TransmitForumData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ca */
        public TransmitForumData[] newArray(int i) {
            return new TransmitForumData[i];
        }
    };

    public TransmitForumData(long j, String str, boolean z, int i) {
        this(j, str, z, i, "");
    }

    public TransmitForumData(long j, String str, boolean z, int i, String str2) {
        this.akk = false;
        this.forumName = str;
        this.checked = z;
        this.forumId = j;
        this.type = i;
        this.avatar = str2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return akj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.forumName);
        parcel.writeLong(this.forumId);
        parcel.writeByte(this.checked ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type);
        parcel.writeString(this.avatar);
        parcel.writeByte(this.akk ? (byte) 1 : (byte) 0);
    }

    protected TransmitForumData(Parcel parcel) {
        this.akk = false;
        this.forumName = parcel.readString();
        this.forumId = parcel.readLong();
        this.checked = parcel.readByte() != 0;
        this.type = parcel.readInt();
        this.avatar = parcel.readString();
        this.akk = parcel.readByte() != 0;
    }
}
