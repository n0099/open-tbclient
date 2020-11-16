package com.baidu.android.imsdk;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
public class CmdQueueMsg implements Parcelable {
    public static final Parcelable.Creator<CmdQueueMsg> CREATOR = new Parcelable.Creator<CmdQueueMsg>() { // from class: com.baidu.android.imsdk.CmdQueueMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CmdQueueMsg createFromParcel(Parcel parcel) {
            return CmdQueueMsg.readFromParcel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CmdQueueMsg[] newArray(int i) {
            return new CmdQueueMsg[i];
        }
    };
    private String body;
    private String extra;
    private int methodId;
    private String uuid;

    public int getMethodId() {
        return this.methodId;
    }

    public void setMethodId(int i) {
        this.methodId = i;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uuid);
        parcel.writeString(this.body);
        parcel.writeInt(this.methodId);
        parcel.writeString(this.extra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CmdQueueMsg readFromParcel(Parcel parcel) {
        CmdQueueMsg cmdQueueMsg = new CmdQueueMsg();
        cmdQueueMsg.setUuid(parcel.readString());
        cmdQueueMsg.setBody(parcel.readString());
        cmdQueueMsg.setMethodId(parcel.readInt());
        cmdQueueMsg.setExtra(parcel.readString());
        return cmdQueueMsg;
    }
}
