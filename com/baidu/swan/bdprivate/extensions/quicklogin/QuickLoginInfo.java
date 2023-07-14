package com.baidu.swan.bdprivate.extensions.quicklogin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.tieba.fs1;
import com.baidu.tieba.zt3;
/* loaded from: classes4.dex */
public class QuickLoginInfo extends SwanAppIPCData {
    public String agreeText;
    public String encryptPhoneNum;
    public boolean hasHistory;
    public int loginMode;
    public String serviceAgreement;
    public boolean supportQuickLogin;
    public static final boolean DEBUG = fs1.a;
    public static final Parcelable.Creator<QuickLoginInfo> CREATOR = new a();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public QuickLoginInfo() {
    }

    /* loaded from: classes4.dex */
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

    public QuickLoginInfo(Parcel parcel) {
        boolean z;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.supportQuickLogin = z;
        this.encryptPhoneNum = parcel.readString();
        this.serviceAgreement = parcel.readString();
        this.hasHistory = parcel.readByte() != 0;
        this.loginMode = parcel.readInt();
        this.agreeText = parcel.readString();
    }

    public /* synthetic */ QuickLoginInfo(Parcel parcel, a aVar) {
        this(parcel);
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

    @Nullable
    public static QuickLoginInfo parseQuickLoginInfo(zt3 zt3Var) {
        if (zt3Var == null) {
            return null;
        }
        QuickLoginInfo quickLoginInfo = new QuickLoginInfo();
        quickLoginInfo.supportQuickLogin = zt3Var.f();
        quickLoginInfo.encryptPhoneNum = zt3Var.c();
        quickLoginInfo.serviceAgreement = zt3Var.b();
        quickLoginInfo.hasHistory = zt3Var.d();
        quickLoginInfo.loginMode = zt3Var.e();
        quickLoginInfo.agreeText = zt3Var.a();
        return quickLoginInfo;
    }

    public String toString() {
        return "QuickLoginInfo{supportQuickLogin=" + this.supportQuickLogin + ", encryptPhoneNum='" + this.encryptPhoneNum + "', serviceAgreement='" + this.serviceAgreement + "', hasHistory=" + this.hasHistory + ", loginMode=" + this.loginMode + ", agreeText=" + this.agreeText + '}';
    }
}
