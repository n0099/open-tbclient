package com.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class Layer {
    private final com.airbnb.lottie.e composition;
    private final float ed;
    private final List<Mask> gJ;
    private final l iE;
    @Nullable
    private final com.airbnb.lottie.model.a.b jA;
    private final List<com.airbnb.lottie.e.a<Float>> jB;
    private final MatteType jC;
    private final String jn;
    private final long jo;
    private final LayerType jp;
    private final long jq;
    @Nullable
    private final String jr;
    private final int js;
    private final int jt;
    private final int ju;
    private final float jv;
    private final int jw;
    private final int jx;
    @Nullable
    private final j jy;
    @Nullable
    private final k jz;
    private final List<com.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes4.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes4.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.jn = str;
        this.jo = j;
        this.jp = layerType;
        this.jq = j2;
        this.jr = str2;
        this.gJ = list2;
        this.iE = lVar;
        this.js = i;
        this.jt = i2;
        this.ju = i3;
        this.jv = f;
        this.ed = f2;
        this.jw = i4;
        this.jx = i5;
        this.jy = jVar;
        this.jz = kVar;
        this.jB = list3;
        this.jC = matteType;
        this.jA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dh() {
        return this.jv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float di() {
        return this.ed / this.composition.bn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> dj() {
        return this.jB;
    }

    public long getId() {
        return this.jo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.jn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.jr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dk() {
        return this.jw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dl() {
        return this.jx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bW() {
        return this.gJ;
    }

    public LayerType dm() {
        return this.jp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dn() {
        return this.jC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public long m6do() {
        return this.jq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> ci() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l cV() {
        return this.iE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.ju;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dp() {
        return this.jt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dq() {
        return this.js;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dr() {
        return this.jy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k ds() {
        return this.jz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b dt() {
        return this.jA;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer f = this.composition.f(m6do());
        if (f != null) {
            sb.append("\t\tParents: ").append(f.getName());
            Layer f2 = this.composition.f(f.m6do());
            while (f2 != null) {
                sb.append("->").append(f2.getName());
                f2 = this.composition.f(f2.m6do());
            }
            sb.append(str).append("\n");
        }
        if (!bW().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(bW().size()).append("\n");
        }
        if (dq() != 0 && dp() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dq()), Integer.valueOf(dp()), Integer.valueOf(getSolidColor())));
        }
        if (!this.shapes.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.shapes) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }
}
