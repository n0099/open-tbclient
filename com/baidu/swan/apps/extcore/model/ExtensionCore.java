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
        /* renamed from: cx */
        public ExtensionCore[] newArray(int i) {
            return new ExtensionCore[i];
        }
    };
    public int axo;
    public long axp;
    public String axq;
    public String axr;

    public ExtensionCore() {
    }

    private ExtensionCore(Parcel parcel) {
        this.axo = parcel.readInt();
        this.axp = parcel.readLong();
        this.axq = parcel.readString();
        this.axr = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.axo);
        parcel.writeLong(this.axp);
        parcel.writeString(this.axq);
        parcel.writeString(this.axr);
    }

    public String toString() {
        return "ExtensionCore{extensionCoreType=" + this.axo + ", extensionCoreVersionCode=" + this.axp + ", extensionCoreVersionName=" + this.axq + ", extensionCorePath='" + this.axr + "', isAvailable='" + isAvailable() + "'}";
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.axr) && new File(this.axr).exists();
    }
}
