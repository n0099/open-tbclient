package com.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class Layer {
    private final float Ce;
    private final List<Mask> EL;
    private final l Gu;
    private final String Hg;
    private final long Hh;
    private final LayerType Hi;
    private final long Hj;
    @Nullable
    private final String Hk;
    private final int Hl;
    private final int Hm;
    private final int Hn;
    private final float Ho;
    private final int Hp;
    private final int Hq;
    @Nullable
    private final j Hr;
    @Nullable
    private final k Hs;
    @Nullable
    private final com.airbnb.lottie.model.a.b Ht;
    private final List<com.airbnb.lottie.e.a<Float>> Hu;
    private final MatteType Hv;
    private final com.airbnb.lottie.e composition;
    private final List<com.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes7.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes7.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.Hg = str;
        this.Hh = j;
        this.Hi = layerType;
        this.Hj = j2;
        this.Hk = str2;
        this.EL = list2;
        this.Gu = lVar;
        this.Hl = i;
        this.Hm = i2;
        this.Hn = i3;
        this.Ho = f;
        this.Ce = f2;
        this.Hp = i4;
        this.Hq = i5;
        this.Hr = jVar;
        this.Hs = kVar;
        this.Hu = list3;
        this.Hv = matteType;
        this.Ht = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float ky() {
        return this.Ho;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float kz() {
        return this.Ce / this.composition.iD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> kA() {
        return this.Hu;
    }

    public long getId() {
        return this.Hh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.Hg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.Hk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kB() {
        return this.Hp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kC() {
        return this.Hq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> jn() {
        return this.EL;
    }

    public LayerType kD() {
        return this.Hi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType kE() {
        return this.Hv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kF() {
        return this.Hj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> jz() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l km() {
        return this.Gu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.Hn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kG() {
        return this.Hm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kH() {
        return this.Hl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j kI() {
        return this.Hr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k kJ() {
        return this.Hs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b kK() {
        return this.Ht;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer B = this.composition.B(kF());
        if (B != null) {
            sb.append("\t\tParents: ").append(B.getName());
            Layer B2 = this.composition.B(B.kF());
            while (B2 != null) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR).append(B2.getName());
                B2 = this.composition.B(B2.kF());
            }
            sb.append(str).append("\n");
        }
        if (!jn().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(jn().size()).append("\n");
        }
        if (kH() != 0 && kG() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(kH()), Integer.valueOf(kG()), Integer.valueOf(getSolidColor())));
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
