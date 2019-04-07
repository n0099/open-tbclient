package com.baidu.swan.apps.extcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.swan.apps.process.SwanAppIPCData;
import java.io.File;
/* loaded from: classes2.dex */
public class ExtensionCore extends SwanAppIPCData {
    public static final Parcelable.Creator<ExtensionCore> CREATOR = new Parcelable.Creator<ExtensionCore>() { // from class: com.baidu.swan.apps.extcore.model.ExtensionCore.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: g */
        public ExtensionCore createFromParcel(Parcel parcel) {
            return new ExtensionCore(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cv */
        public ExtensionCore[] newArray(int i) {
            return new ExtensionCore[i];
        }
    };
    public int avN;
    public long avO;
    public String avP;
    public String avQ;

    public ExtensionCore() {
    }

    private ExtensionCore(Parcel parcel) {
        this.avN = parcel.readInt();
        this.avO = parcel.readLong();
        this.avP = parcel.readString();
        this.avQ = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.avN);
        parcel.writeLong(this.avO);
        parcel.writeString(this.avP);
        parcel.writeString(this.avQ);
    }

    public String toString() {
        return "ExtensionCore{extensionCoreType=" + this.avN + ", extensionCoreVersionCode=" + this.avO + ", extensionCoreVersionName=" + this.avP + ", extensionCorePath='" + this.avQ + "', isAvailable='" + isAvailable() + "'}";
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.avQ) && new File(this.avQ).exists();
    }
}
