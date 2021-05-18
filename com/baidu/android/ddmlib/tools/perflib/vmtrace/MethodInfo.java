package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.NonNull;
import java.util.Locale;
/* loaded from: classes.dex */
public class MethodInfo {
    public final String className;
    public final long id;
    public String mFullName;
    public MethodProfileData mProfileData;
    public String mShortName;
    public final String methodName;
    public final String signature;
    public final int srcLineNumber;
    public final String srcPath;

    public MethodInfo(long j, String str, String str2, String str3, String str4, int i2) {
        this.id = j;
        this.className = str;
        this.methodName = str2;
        this.signature = str3;
        this.srcPath = str4;
        this.srcLineNumber = i2;
    }

    private String getUnqualifiedClassName() {
        String str = this.className;
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf > 0 ? str.substring(lastIndexOf + 1) : str;
    }

    public String getFullName() {
        if (this.mFullName == null) {
            this.mFullName = String.format(Locale.US, "%s.%s: %s", this.className, this.methodName, this.signature);
        }
        return this.mFullName;
    }

    @NonNull
    public MethodProfileData getProfileData() {
        return this.mProfileData;
    }

    public String getShortName() {
        if (this.mShortName == null) {
            this.mShortName = String.format(Locale.US, "%s.%s", getUnqualifiedClassName(), this.methodName);
        }
        return this.mShortName;
    }

    public void setProfileData(@NonNull MethodProfileData methodProfileData) {
        this.mProfileData = methodProfileData;
    }

    @NonNull
    public String toString() {
        return this.className + "." + this.methodName + this.signature;
    }
}
