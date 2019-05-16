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
        /* renamed from: cw */
        public ExtensionCore[] newArray(int i) {
            return new ExtensionCore[i];
        }
    };
    public int awl;
    public long awm;
    public String awn;
    public String awo;

    public ExtensionCore() {
    }

    private ExtensionCore(Parcel parcel) {
        this.awl = parcel.readInt();
        this.awm = parcel.readLong();
        this.awn = parcel.readString();
        this.awo = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.awl);
        parcel.writeLong(this.awm);
        parcel.writeString(this.awn);
        parcel.writeString(this.awo);
    }

    public String toString() {
        return "ExtensionCore{extensionCoreType=" + this.awl + ", extensionCoreVersionCode=" + this.awm + ", extensionCoreVersionName=" + this.awn + ", extensionCorePath='" + this.awo + "', isAvailable='" + isAvailable() + "'}";
    }

    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.awo) && new File(this.awo).exists();
    }
}
