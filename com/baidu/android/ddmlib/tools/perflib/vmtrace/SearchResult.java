package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.NonNull;
import java.util.Set;
/* loaded from: classes.dex */
public class SearchResult {
    public final Set<Call> mInstances;
    public final Set<MethodInfo> mMethods;

    public SearchResult(@NonNull Set<MethodInfo> set, @NonNull Set<Call> set2) {
        this.mMethods = set;
        this.mInstances = set2;
    }

    @NonNull
    public Set<Call> getInstances() {
        return this.mInstances;
    }

    @NonNull
    public Set<MethodInfo> getMethods() {
        return this.mMethods;
    }
}
