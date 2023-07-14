package com.baidu.swan.apps.scheme.actions.forbidden;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tieba.on3;
import com.baidu.tieba.sw2;
/* loaded from: classes4.dex */
public class ForbiddenInfo implements Parcelable {
    public static final Parcelable.Creator<ForbiddenInfo> CREATOR = new a();
    public static final int ENABLE_SLIDING_DEFAULT_FLAG = 0;
    public String appId;
    public String appKey;
    public String appTitle;
    public int enableSlidingFlag;
    public on3 errCode;
    public String forbiddenDetail;
    public String forbiddenInformation;
    public String forbiddenReason;
    public String launchPath;
    public String launchSource;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ForbiddenInfo() {
        this.enableSlidingFlag = 0;
    }

    public boolean enableSliding() {
        if (this.enableSlidingFlag == 0) {
            return true;
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<ForbiddenInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ForbiddenInfo createFromParcel(Parcel parcel) {
            return new ForbiddenInfo(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ForbiddenInfo[] newArray(int i) {
            return new ForbiddenInfo[i];
        }
    }

    public ForbiddenInfo(Parcel parcel) {
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

    public /* synthetic */ ForbiddenInfo(Parcel parcel, a aVar) {
        this(parcel);
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

    public ForbiddenInfo(sw2 sw2Var, String str, String str2) {
        this.enableSlidingFlag = 0;
        convertToForbiddenModel(sw2Var);
        this.forbiddenReason = str;
        this.forbiddenDetail = str2;
    }

    private void convertToForbiddenModel(sw2 sw2Var) {
        if (sw2Var == null) {
            return;
        }
        this.appId = sw2Var.H();
        this.appKey = sw2Var.I();
        this.appTitle = sw2Var.K();
        this.launchPath = sw2Var.e0();
        this.launchSource = sw2Var.T();
    }

    public String toString() {
        return "ForbiddenInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', forbiddenReason='" + this.forbiddenReason + "', forbiddenDetail='" + this.forbiddenDetail + "', appTitle='" + this.appTitle + "', launchPath='" + this.launchPath + "', launchSource='" + this.launchSource + "', enableSlidingFlag='" + enableSliding() + "'}";
    }
}
