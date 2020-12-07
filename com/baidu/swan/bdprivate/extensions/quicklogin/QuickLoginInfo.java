package com.baidu.swan.bdprivate.extensions.quicklogin;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppIPCData;
/* loaded from: classes25.dex */
public class QuickLoginInfo extends SwanAppIPCData {
    public String agreeText;
    public String encryptPhoneNum;
    public boolean hasHistory;
    public int loginMode;
    public String serviceAgreement;
    public boolean supportQuickLogin;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final Parcelable.Creator<QuickLoginInfo> CREATOR = new Parcelable.Creator<QuickLoginInfo>() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: z */
        public QuickLoginInfo createFromParcel(Parcel parcel) {
            return new QuickLoginInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: lZ */
        public QuickLoginInfo[] newArray(int i) {
            return new QuickLoginInfo[i];
        }
    };

    public QuickLoginInfo() {
    }

    private QuickLoginInfo(Parcel parcel) {
        this.supportQuickLogin = parcel.readByte() != 0;
        this.encryptPhoneNum = parcel.readString();
        this.serviceAgreement = parcel.readString();
        this.hasHistory = parcel.readByte() != 0;
        this.loginMode = parcel.readInt();
        this.agreeText = parcel.readString();
    }

    @Nullable
    public static QuickLoginInfo a(a aVar) {
        if (aVar == null) {
            return null;
        }
        QuickLoginInfo quickLoginInfo = new QuickLoginInfo();
        quickLoginInfo.supportQuickLogin = aVar.aQW();
        quickLoginInfo.encryptPhoneNum = aVar.aQX();
        quickLoginInfo.serviceAgreement = aVar.aQZ();
        quickLoginInfo.hasHistory = aVar.aQY();
        quickLoginInfo.loginMode = aVar.aQV();
        quickLoginInfo.agreeText = aVar.aRa();
        return quickLoginInfo;
    }

    public String toString() {
        return "QuickLoginInfo{supportQuickLogin=" + this.supportQuickLogin + ", encryptPhoneNum='" + this.encryptPhoneNum + "', serviceAgreement='" + this.serviceAgreement + "', hasHistory=" + this.hasHistory + ", loginMode=" + this.loginMode + ", agreeText=" + this.agreeText + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.supportQuickLogin ? 1 : 0));
        parcel.writeString(this.encryptPhoneNum);
        parcel.writeString(this.serviceAgreement);
        parcel.writeByte((byte) (this.hasHistory ? 1 : 0));
        parcel.writeInt(this.loginMode);
        parcel.writeString(this.agreeText);
    }
}
