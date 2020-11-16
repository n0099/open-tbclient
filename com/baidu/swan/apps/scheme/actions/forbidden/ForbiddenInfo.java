package com.baidu.swan.apps.scheme.actions.forbidden;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes7.dex */
public class ForbiddenInfo implements Parcelable {
    public static final Parcelable.Creator<ForbiddenInfo> CREATOR = new Parcelable.Creator<ForbiddenInfo>() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: x */
        public ForbiddenInfo createFromParcel(Parcel parcel) {
            return new ForbiddenInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ko */
        public ForbiddenInfo[] newArray(int i) {
            return new ForbiddenInfo[i];
        }
    };
    public static final int ENABLE_SLIDING_DEFAULT_FLAG = 0;
    public String appId;
    public String appKey;
    public String appTitle;
    public int enableSlidingFlag;
    public String forbiddenDetail;
    public String forbiddenReason;
    public String launchPath;
    public String launchSource;

    public ForbiddenInfo() {
        this.enableSlidingFlag = 0;
    }

    public ForbiddenInfo(b bVar, String str, String str2) {
        this.enableSlidingFlag = 0;
        l(bVar);
        this.forbiddenReason = str;
        this.forbiddenDetail = str2;
    }

    private ForbiddenInfo(Parcel parcel) {
        this.enableSlidingFlag = 0;
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.forbiddenReason = parcel.readString();
        this.forbiddenDetail = parcel.readString();
        this.appTitle = parcel.readString();
        this.launchPath = parcel.readString();
        this.launchSource = parcel.readString();
        this.enableSlidingFlag = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeString(this.forbiddenReason);
        parcel.writeString(this.forbiddenDetail);
        parcel.writeString(this.appTitle);
        parcel.writeString(this.launchPath);
        parcel.writeString(this.launchSource);
        parcel.writeInt(this.enableSlidingFlag);
    }

    private void l(b bVar) {
        if (bVar != null) {
            this.appId = bVar.getAppId();
            this.appKey = bVar.getAppKey();
            this.appTitle = bVar.arW();
            this.launchPath = bVar.getPage();
            this.launchSource = bVar.axV();
        }
    }

    public boolean anW() {
        return this.enableSlidingFlag == 0;
    }

    public String toString() {
        return "ForbiddenInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', forbiddenReason='" + this.forbiddenReason + "', forbiddenDetail='" + this.forbiddenDetail + "', appTitle='" + this.appTitle + "', launchPath='" + this.launchPath + "', launchSource='" + this.launchSource + "', enableSlidingFlag='" + anW() + "'}";
    }
}
