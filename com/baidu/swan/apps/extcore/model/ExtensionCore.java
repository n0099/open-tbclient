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
        /* renamed from: o */
        public ExtensionCore createFromParcel(Parcel parcel) {
            return new ExtensionCore(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ds */
        public ExtensionCore[] newArray(int i) {
            return new ExtensionCore[i];
        }
    };
    public int aQl;
    public long aQm;
    public String aQn;
    public String aQo;

    public ExtensionCore() {
    }

    private ExtensionCore(Parcel parcel) {
        this.aQl = parcel.readInt();
        this.aQm = parcel.readLong();
        this.aQn = parcel.readString();
        this.aQo = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aQl);
        parcel.writeLong(this.aQm);
        parcel.writeString(this.aQn);
        parcel.writeString(this.aQo);
    }

    public String toString() {
        return "ExtensionCore{extensionCoreType=" + this.aQl + ", extensionCoreVersionCode=" + this.aQm + ", extensionCoreVersionName=" + this.aQn + ", extensionCorePath='" + this.aQo + "', isAvailable='" + isAvailable() + "'}";
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.aQo) && new File(this.aQo).exists();
    }
}
