package com.baidu.live.lottie.model.content;

import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class MergePaths implements b {
    private final MergePathsMode bqn;
    private final String name;

    /* loaded from: classes9.dex */
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
        this.bqn = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode Mp() {
        return this.bqn;
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        if (hVar.ie()) {
            return new com.baidu.live.lottie.a.a.k(this);
        }
        com.baidu.live.lottie.d.warn("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.bqn + '}';
    }
}
