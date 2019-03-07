package com.baidu.swan.apps.extcore.cores;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public class SwanAppCores extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppCores> CREATOR = new Parcelable.Creator<SwanAppCores>() { // from class: com.baidu.swan.apps.extcore.cores.SwanAppCores.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: f */
        public SwanAppCores createFromParcel(Parcel parcel) {
            return new SwanAppCores(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ct */
        public SwanAppCores[] newArray(int i) {
            return new SwanAppCores[i];
        }
    };
    private SwanCoreVersion atp;
    private ExtensionCore atq;

    public SwanAppCores() {
    }

    private SwanAppCores(Parcel parcel) {
        this.atp = (SwanCoreVersion) parcel.readParcelable(SwanCoreVersion.class.getClassLoader());
        this.atq = (ExtensionCore) parcel.readParcelable(ExtensionCore.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.atp, i);
        parcel.writeParcelable(this.atq, i);
    }

    public String toString() {
        return "SwanAppCores{mSwanCoreVersion=" + this.atp + ", mExtensionCore=" + this.atq + '}';
    }

    public SwanCoreVersion As() {
        return this.atp;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.atp = swanCoreVersion;
    }

    public ExtensionCore At() {
        return this.atq;
    }

    public void a(ExtensionCore extensionCore) {
        this.atq = extensionCore;
    }
}
