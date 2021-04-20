package com.baidu.swan.bdprivate.extensions.quicklogin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class QuickLoginInfo extends SwanAppIPCData {
    public String agreeText;
    public String encryptPhoneNum;
    public boolean hasHistory;
    public int loginMode;
    public String serviceAgreement;
    public boolean supportQuickLogin;
    public static final boolean DEBUG = k.f45443a;
    public static final Parcelable.Creator<QuickLoginInfo> CREATOR = new a();

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<QuickLoginInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public QuickLoginInfo createFromParcel(Parcel parcel) {
            return new QuickLoginInfo(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public QuickLoginInfo[] newArray(int i) {
            return new QuickLoginInfo[i];
        }
    }

    public /* synthetic */ QuickLoginInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Nullable
    public static QuickLoginInfo a(d.b.g0.b.m.g.a aVar) {
        if (aVar == null) {
            return null;
        }
        QuickLoginInfo quickLoginInfo = new QuickLoginInfo();
        quickLoginInfo.supportQuickLogin = aVar.f();
        quickLoginInfo.encryptPhoneNum = aVar.c();
        quickLoginInfo.serviceAgreement = aVar.b();
        quickLoginInfo.hasHistory = aVar.d();
        quickLoginInfo.loginMode = aVar.e();
        quickLoginInfo.agreeText = aVar.a();
        return quickLoginInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "QuickLoginInfo{supportQuickLogin=" + this.supportQuickLogin + ", encryptPhoneNum='" + this.encryptPhoneNum + "', serviceAgreement='" + this.serviceAgreement + "', hasHistory=" + this.hasHistory + ", loginMode=" + this.loginMode + ", agreeText=" + this.agreeText + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.supportQuickLogin ? (byte) 1 : (byte) 0);
        parcel.writeString(this.encryptPhoneNum);
        parcel.writeString(this.serviceAgreement);
        parcel.writeByte(this.hasHistory ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.loginMode);
        parcel.writeString(this.agreeText);
    }

    public QuickLoginInfo() {
    }

    public QuickLoginInfo(Parcel parcel) {
        this.supportQuickLogin = parcel.readByte() != 0;
        this.encryptPhoneNum = parcel.readString();
        this.serviceAgreement = parcel.readString();
        this.hasHistory = parcel.readByte() != 0;
        this.loginMode = parcel.readInt();
        this.agreeText = parcel.readString();
    }
}
