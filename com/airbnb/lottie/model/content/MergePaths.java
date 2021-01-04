package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class MergePaths implements b {
    private final MergePathsMode FY;
    private final String name;

    /* loaded from: classes3.dex */
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
        this.FY = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode jB() {
        return this.FY;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        if (fVar.ie()) {
            return new com.airbnb.lottie.a.a.k(this);
        }
        com.airbnb.lottie.c.warn("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.FY + '}';
    }
}
