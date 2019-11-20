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
    private SwanCoreVersion aNK;
    private ExtensionCore aNL;

    public SwanAppCores() {
    }

    private SwanAppCores(Parcel parcel) {
        this.aNK = (SwanCoreVersion) parcel.readParcelable(SwanCoreVersion.class.getClassLoader());
        this.aNL = (ExtensionCore) parcel.readParcelable(ExtensionCore.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.aNK, i);
        parcel.writeParcelable(this.aNL, i);
    }

    public String toString() {
        return "SwanAppCores{mSwanCoreVersion=" + this.aNK + ", mExtensionCore=" + this.aNL + '}';
    }

    public SwanCoreVersion Hh() {
        return this.aNK;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.aNK = swanCoreVersion;
    }

    public ExtensionCore Hi() {
        return this.aNL;
    }

    public void a(ExtensionCore extensionCore) {
        this.aNL = extensionCore;
    }
}
