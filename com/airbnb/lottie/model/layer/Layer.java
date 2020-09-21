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
    private final float AX;
    private final List<Mask> DA;
    private final String FU;
    private final long FV;
    private final LayerType FW;
    private final long FX;
    @Nullable
    private final String FY;
    private final int FZ;
    private final l Fl;
    private final int Ga;
    private final int Gb;
    private final float Gc;
    private final int Gd;
    private final int Ge;
    @Nullable
    private final j Gf;
    @Nullable
    private final k Gg;
    @Nullable
    private final com.airbnb.lottie.model.a.b Gh;
    private final List<com.airbnb.lottie.e.a<Float>> Gi;
    private final MatteType Gj;
    private final com.airbnb.lottie.e composition;
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
        this.FU = str;
        this.FV = j;
        this.FW = layerType;
        this.FX = j2;
        this.FY = str2;
        this.DA = list2;
        this.Fl = lVar;
        this.FZ = i;
        this.Ga = i2;
        this.Gb = i3;
        this.Gc = f;
        this.AX = f2;
        this.Gd = i4;
        this.Ge = i5;
        this.Gf = jVar;
        this.Gg = kVar;
        this.Gi = list3;
        this.Gj = matteType;
        this.Gh = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float kx() {
        return this.Gc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float ky() {
        return this.AX / this.composition.iC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> kz() {
        return this.Gi;
    }

    public long getId() {
        return this.FV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.FU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.FY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kA() {
        return this.Gd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kB() {
        return this.Ge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> jm() {
        return this.DA;
    }

    public LayerType kC() {
        return this.FW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType kD() {
        return this.Gj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kE() {
        return this.FX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> jy() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l kl() {
        return this.Fl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.Gb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kF() {
        return this.Ga;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kG() {
        return this.FZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j kH() {
        return this.Gf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k kI() {
        return this.Gg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b kJ() {
        return this.Gh;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer D = this.composition.D(kE());
        if (D != null) {
            sb.append("\t\tParents: ").append(D.getName());
            Layer D2 = this.composition.D(D.kE());
            while (D2 != null) {
                sb.append("->").append(D2.getName());
                D2 = this.composition.D(D2.kE());
            }
            sb.append(str).append("\n");
        }
        if (!jm().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(jm().size()).append("\n");
        }
        if (kG() != 0 && kF() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(kG()), Integer.valueOf(kF()), Integer.valueOf(getSolidColor())));
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
