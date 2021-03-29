package com.baidu.swan.apps.scheme.actions.forbidden;

import android.os.Parcel;
import android.os.Parcelable;
import d.b.g0.a.y0.e.b;
/* loaded from: classes2.dex */
public class ForbiddenInfo implements Parcelable {
    public static final Parcelable.Creator<ForbiddenInfo> CREATOR = new a();
    public static final int ENABLE_SLIDING_DEFAULT_FLAG = 0;
    public String appId;
    public String appKey;
    public String appTitle;
    public int enableSlidingFlag;
    public String forbiddenDetail;
    public String forbiddenReason;
    public String launchPath;
    public String launchSource;

    /* loaded from: classes2.dex */
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

    public /* synthetic */ ForbiddenInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.appId = bVar.G();
        this.appKey = bVar.H();
        this.appTitle = bVar.J();
        this.launchPath = bVar.b0();
        this.launchSource = bVar.S();
    }

    public boolean b() {
        return this.enableSlidingFlag == 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ForbiddenInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', forbiddenReason='" + this.forbiddenReason + "', forbiddenDetail='" + this.forbiddenDetail + "', appTitle='" + this.appTitle + "', launchPath='" + this.launchPath + "', launchSource='" + this.launchSource + "', enableSlidingFlag='" + b() + "'}";
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

    public ForbiddenInfo() {
        this.enableSlidingFlag = 0;
    }

    public ForbiddenInfo(b bVar, String str, String str2) {
        this.enableSlidingFlag = 0;
        a(bVar);
        this.forbiddenReason = str;
        this.forbiddenDetail = str2;
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
}
