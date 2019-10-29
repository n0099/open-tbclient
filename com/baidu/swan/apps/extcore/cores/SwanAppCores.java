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
        /* renamed from: n */
        public SwanAppCores createFromParcel(Parcel parcel) {
            return new SwanAppCores(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: dq */
        public SwanAppCores[] newArray(int i) {
            return new SwanAppCores[i];
        }
    };
    private SwanCoreVersion aOc;
    private ExtensionCore aOd;

    public SwanAppCores() {
    }

    private SwanAppCores(Parcel parcel) {
        this.aOc = (SwanCoreVersion) parcel.readParcelable(SwanCoreVersion.class.getClassLoader());
        this.aOd = (ExtensionCore) parcel.readParcelable(ExtensionCore.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.aOc, i);
        parcel.writeParcelable(this.aOd, i);
    }

    public String toString() {
        return "SwanAppCores{mSwanCoreVersion=" + this.aOc + ", mExtensionCore=" + this.aOd + '}';
    }

    public SwanCoreVersion Hg() {
        return this.aOc;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.aOc = swanCoreVersion;
    }

    public ExtensionCore Hh() {
        return this.aOd;
    }

    public void a(ExtensionCore extensionCore) {
        this.aOd = extensionCore;
    }
}
