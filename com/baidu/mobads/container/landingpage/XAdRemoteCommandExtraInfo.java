package com.baidu.mobads.container.landingpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
/* loaded from: classes2.dex */
public abstract class XAdRemoteCommandExtraInfo implements Parcelable {
    public Boolean autoOpen;
    public Boolean canCancel;
    public String canDelete;
    public String iconfrom;
    public XAdInstanceInfoExt mAdInstanceInfo;
    public int mIntTesting4LM;
    public String mProdType;
    public String mStringTesting4LM;
    public Boolean popNotif;
    public String sn;
    public String url;
    public String v;
    public String appsec = "";
    public String appsid = "";
    public String packageNameOfPubliser = "";
    public boolean noticeDLNonWifi = false;
    public boolean autoPlayNonWifi = true;
    public String adid = "-1";
    public String packageName = "";
    public String qk = "";

    public XAdRemoteCommandExtraInfo(String str, XAdInstanceInfoExt xAdInstanceInfoExt) {
        Boolean bool = Boolean.TRUE;
        this.autoOpen = bool;
        this.v = "";
        this.sn = "";
        this.iconfrom = "";
        this.canCancel = bool;
        this.canDelete = "";
        this.popNotif = bool;
        this.mIntTesting4LM = 999;
        this.mStringTesting4LM = "this is the test string";
        this.mProdType = str;
        this.mAdInstanceInfo = xAdInstanceInfoExt;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.mAdInstanceInfo;
    }

    public Boolean isValid() {
        return Boolean.valueOf("-1".equalsIgnoreCase(this.adid));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAdInstanceInfo, i);
        parcel.writeString(this.mProdType);
        parcel.writeInt(this.mIntTesting4LM);
        parcel.writeString(this.mStringTesting4LM);
    }

    public XAdRemoteCommandExtraInfo(Parcel parcel) {
        Boolean bool = Boolean.TRUE;
        this.autoOpen = bool;
        this.v = "";
        this.sn = "";
        this.iconfrom = "";
        this.canCancel = bool;
        this.canDelete = "";
        this.popNotif = bool;
        this.mAdInstanceInfo = (XAdInstanceInfoExt) parcel.readParcelable(XAdInstanceInfoExt.class.getClassLoader());
        this.mProdType = parcel.readString();
        this.mIntTesting4LM = parcel.readInt();
        this.mStringTesting4LM = parcel.readString();
    }
}
