package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MergePaths implements b {
    private final String name;
    private final MergePathsMode oO;

    /* loaded from: classes2.dex */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        /* JADX INFO: Access modifiers changed from: private */
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

    private MergePaths(String str, MergePathsMode mergePathsMode) {
        this.name = str;
        this.oO = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode di() {
        return this.oO;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        if (fVar.bF()) {
            return new com.airbnb.lottie.a.a.j(this);
        }
        Log.w("LOTTIE", "Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.oO + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static MergePaths g(JSONObject jSONObject) {
            return new MergePaths(jSONObject.optString("nm"), MergePathsMode.forId(jSONObject.optInt("mm", 1)));
        }
    }
}
