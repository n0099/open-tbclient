package com.baidu.mobads.container.landingpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobads.container.XAdInstanceInfoExt;
/* loaded from: classes2.dex */
public class XAdRemoteLandingPageExtraInfo extends XAdRemoteCommandExtraInfo {
    public static final Parcelable.Creator<XAdRemoteLandingPageExtraInfo> CREATOR = new Parcelable.Creator<XAdRemoteLandingPageExtraInfo>() { // from class: com.baidu.mobads.container.landingpage.XAdRemoteLandingPageExtraInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XAdRemoteLandingPageExtraInfo createFromParcel(Parcel parcel) {
            return new XAdRemoteLandingPageExtraInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XAdRemoteLandingPageExtraInfo[] newArray(int i2) {
            return new XAdRemoteLandingPageExtraInfo[i2];
        }
    };
    public int e75;
    public int from;
    public boolean isFullScreen;
    public String lpMurl;
    public String lpStyle;
    public String mLpMultiProcess;
    public int orientation;
    public int os;
    public String prodType;
    public String sn;
    public String title;
    public String v;

    public String getCompositeV() {
        return "android_9.041_4.0.0";
    }

    @Override // com.baidu.mobads.container.landingpage.XAdRemoteCommandExtraInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.url);
        parcel.writeByte(this.isFullScreen ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.e75);
        parcel.writeInt(this.from);
        parcel.writeString(this.adid);
        parcel.writeString(this.qk);
        parcel.writeString(this.packageNameOfPubliser);
        parcel.writeString(this.appsid);
        parcel.writeString(this.appsec);
        parcel.writeInt(1);
        parcel.writeString(this.mProdType);
        parcel.writeString(getCompositeV());
        String str = TextUtils.isEmpty(this.title) ? "" : this.title;
        this.title = str;
        parcel.writeString(str);
        parcel.writeString(this.lpStyle);
        parcel.writeString(this.lpMurl);
        parcel.writeString(this.mLpMultiProcess);
    }

    public XAdRemoteLandingPageExtraInfo(String str, XAdInstanceInfoExt xAdInstanceInfoExt) {
        super(str, xAdInstanceInfoExt);
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.os = 1;
        this.lpStyle = "";
        this.lpMurl = "";
    }

    public XAdRemoteLandingPageExtraInfo(Parcel parcel) {
        super(parcel);
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.os = 1;
        this.lpStyle = "";
        this.lpMurl = "";
        this.url = parcel.readString();
        this.isFullScreen = parcel.readByte() != 0;
        this.orientation = parcel.readInt();
        this.e75 = parcel.readInt();
        this.from = parcel.readInt();
        this.adid = parcel.readString();
        this.qk = parcel.readString();
        this.packageNameOfPubliser = parcel.readString();
        this.appsid = parcel.readString();
        this.appsec = parcel.readString();
        this.os = parcel.readInt();
        this.prodType = parcel.readString();
        this.v = parcel.readString();
        this.title = parcel.readString();
        this.lpStyle = parcel.readString();
        this.lpMurl = parcel.readString();
        this.mLpMultiProcess = parcel.readString();
    }
}
