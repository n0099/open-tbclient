package com.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class Layer {
    private final com.airbnb.lottie.e composition;
    private final float ed;
    private final List<Mask> gN;
    private final l iH;
    private final int jA;
    @Nullable
    private final j jB;
    @Nullable
    private final k jC;
    @Nullable
    private final com.airbnb.lottie.model.a.b jD;
    private final List<com.airbnb.lottie.e.a<Float>> jE;
    private final MatteType jF;
    private final String jq;
    private final long jr;
    private final LayerType js;
    private final long jt;
    @Nullable
    private final String ju;
    private final int jv;
    private final int jw;
    private final int jx;
    private final float jy;
    private final int jz;
    private final List<com.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes6.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes6.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.jq = str;
        this.jr = j;
        this.js = layerType;
        this.jt = j2;
        this.ju = str2;
        this.gN = list2;
        this.iH = lVar;
        this.jv = i;
        this.jw = i2;
        this.jx = i3;
        this.jy = f;
        this.ed = f2;
        this.jz = i4;
        this.jA = i5;
        this.jB = jVar;
        this.jC = kVar;
        this.jE = list3;
        this.jF = matteType;
        this.jD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float di() {
        return this.jy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dj() {
        return this.ed / this.composition.bo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> dk() {
        return this.jE;
    }

    public long getId() {
        return this.jr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.jq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.ju;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dl() {
        return this.jz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dm() {
        return this.jA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bX() {
        return this.gN;
    }

    public LayerType dn() {
        return this.js;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public MatteType m7do() {
        return this.jF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dp() {
        return this.jt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> cj() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l cW() {
        return this.iH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.jx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dq() {
        return this.jw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dr() {
        return this.jv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j ds() {
        return this.jB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dt() {
        return this.jC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b du() {
        return this.jD;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer f = this.composition.f(dp());
        if (f != null) {
            sb.append("\t\tParents: ").append(f.getName());
            Layer f2 = this.composition.f(f.dp());
            while (f2 != null) {
                sb.append("->").append(f2.getName());
                f2 = this.composition.f(f2.dp());
            }
            sb.append(str).append("\n");
        }
        if (!bX().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(bX().size()).append("\n");
        }
        if (dr() != 0 && dq() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dr()), Integer.valueOf(dq()), Integer.valueOf(getSolidColor())));
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
