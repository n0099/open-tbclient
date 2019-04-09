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
        /* renamed from: cs */
        public SwanAppCores[] newArray(int i) {
            return new SwanAppCores[i];
        }
    };
    private SwanCoreVersion atv;
    private ExtensionCore atw;

    public SwanAppCores() {
    }

    private SwanAppCores(Parcel parcel) {
        this.atv = (SwanCoreVersion) parcel.readParcelable(SwanCoreVersion.class.getClassLoader());
        this.atw = (ExtensionCore) parcel.readParcelable(ExtensionCore.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.atv, i);
        parcel.writeParcelable(this.atw, i);
    }

    public String toString() {
        return "SwanAppCores{mSwanCoreVersion=" + this.atv + ", mExtensionCore=" + this.atw + '}';
    }

    public SwanCoreVersion Ar() {
        return this.atv;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.atv = swanCoreVersion;
    }

    public ExtensionCore As() {
        return this.atw;
    }

    public void a(ExtensionCore extensionCore) {
        this.atw = extensionCore;
    }
}
