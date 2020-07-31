package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TransmitForumData implements Parcelable, com.baidu.adp.widget.ListView.q {
    public static final int TYPE_RECOMMEND = 1;
    public static final int TYPE_SELF_SELECT = 0;
    public String avatar;
    public boolean checked;
    public long forumId;
    public String forumName;
    public boolean isCurForum;
    public ArrayList<FrsTabItemData> tabItemDatas;
    public int type;
    public static final BdUniqueId ID_TRANSMIT_SELECT_DATA = BdUniqueId.gen();
    public static final Parcelable.Creator<TransmitForumData> CREATOR = new Parcelable.Creator<TransmitForumData>() { // from class: com.baidu.tbadk.core.data.TransmitForumData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: M */
        public TransmitForumData createFromParcel(Parcel parcel) {
            return new TransmitForumData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ll */
        public TransmitForumData[] newArray(int i) {
            return new TransmitForumData[i];
        }
    };

    public TransmitForumData(long j, String str, boolean z, int i) {
        this(j, str, z, i, "");
    }

    public TransmitForumData(long j, String str, boolean z, int i, String str2) {
        this.isCurForum = false;
        this.forumName = str;
        this.checked = z;
        this.forumId = j;
        this.type = i;
        this.avatar = str2;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ID_TRANSMIT_SELECT_DATA;
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
        parcel.writeByte(this.isCurForum ? (byte) 1 : (byte) 0);
        parcel.writeArray(this.tabItemDatas.toArray());
    }

    protected TransmitForumData(Parcel parcel) {
        this.isCurForum = false;
        this.forumName = parcel.readString();
        this.forumId = parcel.readLong();
        this.checked = parcel.readByte() != 0;
        this.type = parcel.readInt();
        this.avatar = parcel.readString();
        this.isCurForum = parcel.readByte() != 0;
        this.tabItemDatas = parcel.readArrayList(FrsTabItemData.class.getClassLoader());
    }
}
