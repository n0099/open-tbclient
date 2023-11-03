package com.baidu.android.pushservice.pull;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ClientEventInfo implements Parcelable {
    public static final Parcelable.Creator<ClientEventInfo> CREATOR = new a();
    public String mAction;
    public String mComponentName;
    public int mHasConfirmDialog;
    public String mIId;
    public int mSource;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<ClientEventInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ClientEventInfo createFromParcel(Parcel parcel) {
            return new ClientEventInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ClientEventInfo[] newArray(int i) {
            return new ClientEventInfo[i];
        }
    }

    public ClientEventInfo() {
        this.mSource = 0;
        this.mComponentName = "";
        this.mAction = "";
        this.mHasConfirmDialog = 0;
        this.mIId = "";
        this.mSource = 0;
    }

    public ClientEventInfo(int i) {
        this.mSource = 0;
        this.mComponentName = "";
        this.mAction = "";
        this.mHasConfirmDialog = 0;
        this.mIId = "";
        this.mSource = i;
    }

    public ClientEventInfo(int i, String str, String str2) {
        this.mSource = 0;
        this.mComponentName = "";
        this.mAction = "";
        this.mHasConfirmDialog = 0;
        this.mIId = "";
        this.mSource = i;
        this.mComponentName = str;
        this.mAction = str2;
    }

    public ClientEventInfo(Parcel parcel) {
        this.mSource = 0;
        this.mComponentName = "";
        this.mAction = "";
        this.mHasConfirmDialog = 0;
        this.mIId = "";
        this.mSource = parcel.readInt();
        this.mComponentName = parcel.readString();
        this.mAction = parcel.readString();
        this.mHasConfirmDialog = parcel.readInt();
        this.mIId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getComponentName() {
        return this.mComponentName;
    }

    public int getHasConfirmDialog() {
        return this.mHasConfirmDialog;
    }

    public String getIId() {
        return this.mIId;
    }

    public int getSource() {
        return this.mSource;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public void setComponentName(String str) {
        this.mComponentName = str;
    }

    public void setHasConfirmDialog(int i) {
        this.mHasConfirmDialog = i;
    }

    public void setIId(String str) {
        this.mIId = str;
    }

    public void setSource(int i) {
        this.mSource = i;
    }

    public String toString() {
        return "ClientEventInfo{mSource=" + this.mSource + ", mComponentName='" + this.mComponentName + "', mAction='" + this.mAction + "', mHasConfirmDialog=" + this.mHasConfirmDialog + ", mIId='" + this.mIId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSource);
        parcel.writeString(this.mComponentName);
        parcel.writeString(this.mAction);
        parcel.writeInt(this.mHasConfirmDialog);
        parcel.writeString(this.mIId);
    }
}
