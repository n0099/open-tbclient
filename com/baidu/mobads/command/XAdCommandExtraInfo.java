package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.vo.XAdInstanceInfo;
/* loaded from: classes7.dex */
public abstract class XAdCommandExtraInfo implements Parcelable {
    public String adid;
    public String appsec;
    public String appsid;
    public Boolean autoOpen;
    public Boolean canCancel;
    public String canDelete;
    public String iconfrom;
    protected XAdInstanceInfo mAdInstanceInfo;
    public int mIntTesting4LM;
    public String mProdType;
    public String mStringTesting4LM;
    public String packageName;
    public String packageNameOfPubliser;
    public Boolean popNotif;
    public String qk;
    public String sn;
    public String url;
    public String v;

    public XAdCommandExtraInfo(String str, IXAdInstanceInfo iXAdInstanceInfo) {
        this.appsec = "";
        this.appsid = "";
        this.packageNameOfPubliser = "";
        this.adid = "-1";
        this.packageName = "";
        this.qk = "";
        this.autoOpen = true;
        this.v = "";
        this.sn = "";
        this.iconfrom = "";
        this.canCancel = true;
        this.canDelete = "";
        this.popNotif = true;
        this.mIntTesting4LM = 999;
        this.mStringTesting4LM = "this is the test string";
        this.mProdType = str;
        this.mAdInstanceInfo = (XAdInstanceInfo) iXAdInstanceInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public XAdCommandExtraInfo(Parcel parcel) {
        this.appsec = "";
        this.appsid = "";
        this.packageNameOfPubliser = "";
        this.adid = "-1";
        this.packageName = "";
        this.qk = "";
        this.autoOpen = true;
        this.v = "";
        this.sn = "";
        this.iconfrom = "";
        this.canCancel = true;
        this.canDelete = "";
        this.popNotif = true;
        this.mAdInstanceInfo = (XAdInstanceInfo) parcel.readParcelable(XAdInstanceInfo.class.getClassLoader());
        this.mProdType = parcel.readString();
        this.mIntTesting4LM = parcel.readInt();
        this.mStringTesting4LM = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAdInstanceInfo, i);
        parcel.writeString(this.mProdType);
        parcel.writeInt(this.mIntTesting4LM);
        parcel.writeString(this.mStringTesting4LM);
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.mAdInstanceInfo;
    }

    public Boolean isValid() {
        return Boolean.valueOf("-1".equalsIgnoreCase(this.adid));
    }
}
