package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import d.a.a.f;
import d.a.a.s.b.c;
import d.a.a.s.b.l;
import d.a.a.u.j.b;
import d.a.a.u.k.a;
import d.a.a.x.d;
/* loaded from: classes.dex */
public class MergePaths implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1591a;

    /* renamed from: b  reason: collision with root package name */
    public final MergePathsMode f1592b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1593c;

    /* loaded from: classes.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return MERGE;
                            }
                            return EXCLUDE_INTERSECTIONS;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.f1591a = str;
        this.f1592b = mergePathsMode;
        this.f1593c = z;
    }

    @Override // d.a.a.u.j.b
    @Nullable
    public c a(f fVar, a aVar) {
        if (!fVar.n()) {
            d.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new l(this);
    }

    public MergePathsMode b() {
        return this.f1592b;
    }

    public String c() {
        return this.f1591a;
    }

    public boolean d() {
        return this.f1593c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f1592b + '}';
    }
}
