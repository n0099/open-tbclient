package com.baidu.swan.apps.extcore.cores;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes10.dex */
public class SwanAppCores extends SwanAppIPCData {
    public static final Parcelable.Creator<SwanAppCores> CREATOR = new Parcelable.Creator<SwanAppCores>() { // from class: com.baidu.swan.apps.extcore.cores.SwanAppCores.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: r */
        public SwanAppCores createFromParcel(Parcel parcel) {
            return new SwanAppCores(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: iA */
        public SwanAppCores[] newArray(int i) {
            return new SwanAppCores[i];
        }
    };
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;

    public SwanAppCores() {
    }

    private SwanAppCores(Parcel parcel) {
        this.mSwanCoreVersion = (SwanCoreVersion) parcel.readParcelable(SwanCoreVersion.class.getClassLoader());
        this.mExtensionCore = (ExtensionCore) parcel.readParcelable(ExtensionCore.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSwanCoreVersion, i);
        parcel.writeParcelable(this.mExtensionCore, i);
    }

    public String toString() {
        return "SwanAppCores{mSwanCoreVersion=" + this.mSwanCoreVersion + ", mExtensionCore=" + this.mExtensionCore + '}';
    }

    public SwanCoreVersion asd() {
        return this.mSwanCoreVersion;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.mSwanCoreVersion = swanCoreVersion;
    }

    public ExtensionCore ase() {
        return this.mExtensionCore;
    }

    public void a(ExtensionCore extensionCore) {
        this.mExtensionCore = extensionCore;
    }
}
