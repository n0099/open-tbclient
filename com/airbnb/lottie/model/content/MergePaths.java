package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
/* loaded from: classes10.dex */
public class MergePaths implements b {
    private final MergePathsMode Ft;
    private final String name;

    /* loaded from: classes10.dex */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            switch (i) {
                case 1:
                    return Merge;
                case 2:
                    return Add;
                case 3:
                    return Subtract;
                case 4:
                    return Intersect;
                case 5:
                    return ExcludeIntersections;
                default:
                    return Merge;
            }
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.name = str;
        this.Ft = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode kc() {
        return this.Ft;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        if (gVar.iG()) {
            return new com.airbnb.lottie.a.a.k(this);
        }
        com.airbnb.lottie.d.warn("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.Ft + '}';
    }
}
