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
    private final List<Mask> Co;
    private final String EL;
    private final long EM;
    private final LayerType EN;
    private final long EO;
    @Nullable
    private final String EP;
    private final int ER;
    private final int ES;
    private final int ET;
    private final float EU;
    private final int EV;
    private final int EW;
    @Nullable
    private final j EX;
    @Nullable
    private final k EY;
    @Nullable
    private final com.airbnb.lottie.model.a.b EZ;
    private final l Ec;
    private final List<com.airbnb.lottie.e.a<Float>> Fa;
    private final MatteType Fb;
    private final com.airbnb.lottie.e composition;
    private final List<com.airbnb.lottie.model.content.b> shapes;
    private final float zN;

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
        this.EL = str;
        this.EM = j;
        this.EN = layerType;
        this.EO = j2;
        this.EP = str2;
        this.Co = list2;
        this.Ec = lVar;
        this.ER = i;
        this.ES = i2;
        this.ET = i3;
        this.EU = f;
        this.zN = f2;
        this.EV = i4;
        this.EW = i5;
        this.EX = jVar;
        this.EY = kVar;
        this.Fa = list3;
        this.Fb = matteType;
        this.EZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iH() {
        return this.EU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iI() {
        return this.zN / this.composition.gL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> iJ() {
        return this.Fa;
    }

    public long getId() {
        return this.EM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.EL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.EP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int iK() {
        return this.EV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int iL() {
        return this.EW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> hu() {
        return this.Co;
    }

    public LayerType iM() {
        return this.EN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType iN() {
        return this.Fb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long iO() {
        return this.EO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> hG() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l iv() {
        return this.Ec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.ET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int iP() {
        return this.ES;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int iQ() {
        return this.ER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j iR() {
        return this.EX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k iS() {
        return this.EY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b iT() {
        return this.EZ;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer D = this.composition.D(iO());
        if (D != null) {
            sb.append("\t\tParents: ").append(D.getName());
            Layer D2 = this.composition.D(D.iO());
            while (D2 != null) {
                sb.append("->").append(D2.getName());
                D2 = this.composition.D(D2.iO());
            }
            sb.append(str).append("\n");
        }
        if (!hu().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(hu().size()).append("\n");
        }
        if (iQ() != 0 && iP() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(iQ()), Integer.valueOf(iP()), Integer.valueOf(getSolidColor())));
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
