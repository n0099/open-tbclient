package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
/* loaded from: classes4.dex */
public class MergePaths implements b {

    /* renamed from: io  reason: collision with root package name */
    private final MergePathsMode f965io;
    private final String name;

    /* loaded from: classes4.dex */
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
        this.f965io = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode cL() {
        return this.f965io;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        if (gVar.bp()) {
            return new com.airbnb.lottie.a.a.k(this);
        }
        com.airbnb.lottie.d.warn("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f965io + '}';
    }
}
