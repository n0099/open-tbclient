package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import d.a.a.c;
import d.a.a.f;
import d.a.a.q.a.k;
import d.a.a.s.j.b;
import d.a.a.s.k.a;
/* loaded from: classes.dex */
public class MergePaths implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1591a;

    /* renamed from: b  reason: collision with root package name */
    public final MergePathsMode f1592b;

    /* loaded from: classes.dex */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return Merge;
                            }
                            return ExcludeIntersections;
                        }
                        return Intersect;
                    }
                    return Subtract;
                }
                return Add;
            }
            return Merge;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.f1591a = str;
        this.f1592b = mergePathsMode;
    }

    @Override // d.a.a.s.j.b
    @Nullable
    public d.a.a.q.a.b a(f fVar, a aVar) {
        if (!fVar.j()) {
            c.d("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new k(this);
    }

    public MergePathsMode b() {
        return this.f1592b;
    }

    public String c() {
        return this.f1591a;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f1592b + '}';
    }
}
