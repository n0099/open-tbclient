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
    private SwanCoreVersion aun;
    private ExtensionCore auo;

    public SwanAppCores() {
    }

    private SwanAppCores(Parcel parcel) {
        this.aun = (SwanCoreVersion) parcel.readParcelable(SwanCoreVersion.class.getClassLoader());
        this.auo = (ExtensionCore) parcel.readParcelable(ExtensionCore.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.aun, i);
        parcel.writeParcelable(this.auo, i);
    }

    public String toString() {
        return "SwanAppCores{mSwanCoreVersion=" + this.aun + ", mExtensionCore=" + this.auo + '}';
    }

    public SwanCoreVersion Ci() {
        return this.aun;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.aun = swanCoreVersion;
    }

    public ExtensionCore Cj() {
        return this.auo;
    }

    public void a(ExtensionCore extensionCore) {
        this.auo = extensionCore;
    }
}
