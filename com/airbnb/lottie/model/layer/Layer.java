package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class Layer {
    private final com.airbnb.lottie.d Dh;
    private final float Dr;
    private final List<Mask> FR;
    private final l HB;
    private final String Ij;
    private final long Ik;
    private final LayerType Il;
    private final long Im;
    @Nullable
    private final String In;
    private final int Io;
    private final int Ip;
    private final int Iq;
    private final float Ir;
    private final int Is;
    private final int It;
    @Nullable
    private final j Iu;
    @Nullable
    private final k Iv;
    @Nullable
    private final com.airbnb.lottie.model.a.b Iw;
    private final List<com.airbnb.lottie.e.a<Float>> Ix;
    private final MatteType Iy;
    private final List<com.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes5.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes5.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.Dh = dVar;
        this.Ij = str;
        this.Ik = j;
        this.Il = layerType;
        this.Im = j2;
        this.In = str2;
        this.FR = list2;
        this.HB = lVar;
        this.Io = i;
        this.Ip = i2;
        this.Iq = i3;
        this.Ir = f;
        this.Dr = f2;
        this.Is = i4;
        this.It = i5;
        this.Iu = jVar;
        this.Iv = kVar;
        this.Ix = list3;
        this.Iy = matteType;
        this.Iw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.d getComposition() {
        return this.Dh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jW() {
        return this.Ir;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jX() {
        return this.Dr / this.Dh.hZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> jY() {
        return this.Ix;
    }

    public long getId() {
        return this.Ik;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.Ij;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.In;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int jZ() {
        return this.Is;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ka() {
        return this.It;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> iL() {
        return this.FR;
    }

    public LayerType kb() {
        return this.Il;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType kc() {
        return this.Iy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kd() {
        return this.Im;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> iX() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l jK() {
        return this.HB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.Iq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ke() {
        return this.Ip;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kf() {
        return this.Io;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j kg() {
        return this.Iu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k kh() {
        return this.Iv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b ki() {
        return this.Iw;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer B = this.Dh.B(kd());
        if (B != null) {
            sb.append("\t\tParents: ").append(B.getName());
            Layer B2 = this.Dh.B(B.kd());
            while (B2 != null) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR).append(B2.getName());
                B2 = this.Dh.B(B2.kd());
            }
            sb.append(str).append("\n");
        }
        if (!iL().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(iL().size()).append("\n");
        }
        if (kf() != 0 && ke() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(kf()), Integer.valueOf(ke()), Integer.valueOf(getSolidColor())));
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
