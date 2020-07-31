package com.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes20.dex */
public class Layer {
    private final float Aq;
    private final List<Mask> CW;
    private final l EG;
    @Nullable
    private final j FA;
    @Nullable
    private final k FB;
    @Nullable
    private final com.airbnb.lottie.model.a.b FC;
    private final List<com.airbnb.lottie.e.a<Float>> FD;
    private final MatteType FE;
    private final String Fp;
    private final long Fq;
    private final LayerType Fr;
    private final long Fs;
    @Nullable
    private final String Ft;
    private final int Fu;
    private final int Fv;
    private final int Fw;
    private final float Fx;
    private final int Fy;
    private final int Fz;
    private final com.airbnb.lottie.e composition;
    private final List<com.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes20.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes20.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.Fp = str;
        this.Fq = j;
        this.Fr = layerType;
        this.Fs = j2;
        this.Ft = str2;
        this.CW = list2;
        this.EG = lVar;
        this.Fu = i;
        this.Fv = i2;
        this.Fw = i3;
        this.Fx = f;
        this.Aq = f2;
        this.Fy = i4;
        this.Fz = i5;
        this.FA = jVar;
        this.FB = kVar;
        this.FD = list3;
        this.FE = matteType;
        this.FC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iX() {
        return this.Fx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iY() {
        return this.Aq / this.composition.hb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> iZ() {
        return this.FD;
    }

    public long getId() {
        return this.Fq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.Fp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.Ft;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ja() {
        return this.Fy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int jb() {
        return this.Fz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> hK() {
        return this.CW;
    }

    public LayerType jc() {
        return this.Fr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType jd() {
        return this.FE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long je() {
        return this.Fs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> hW() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l iL() {
        return this.EG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.Fw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int jf() {
        return this.Fv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int jg() {
        return this.Fu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j jh() {
        return this.FA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k ji() {
        return this.FB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b jj() {
        return this.FC;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer D = this.composition.D(je());
        if (D != null) {
            sb.append("\t\tParents: ").append(D.getName());
            Layer D2 = this.composition.D(D.je());
            while (D2 != null) {
                sb.append("->").append(D2.getName());
                D2 = this.composition.D(D2.je());
            }
            sb.append(str).append("\n");
        }
        if (!hK().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(hK().size()).append("\n");
        }
        if (jg() != 0 && jf() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(jg()), Integer.valueOf(jf()), Integer.valueOf(getSolidColor())));
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
