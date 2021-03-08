package com.baidu.live.lottie.model.layer;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.a.j;
import com.baidu.live.lottie.model.a.k;
import com.baidu.live.lottie.model.a.l;
import com.baidu.live.lottie.model.content.Mask;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class Layer {
    private final float Dr;
    private final List<Mask> FR;
    private final String Ij;
    private final long Ik;
    private final long Im;
    @Nullable
    private final String In;
    private final int Io;
    private final int Ip;
    private final int Iq;
    private final float Ir;
    private final int Is;
    private final int It;
    private final List<com.baidu.live.lottie.e.a<Float>> Ix;
    private final LayerType bvM;
    @Nullable
    private final j bvN;
    @Nullable
    private final k bvO;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bvP;
    private final MatteType bvQ;
    private final l bvz;
    private final com.baidu.live.lottie.e composition;
    private final List<com.baidu.live.lottie.model.content.b> shapes;

    /* loaded from: classes9.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes9.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.baidu.live.lottie.model.content.b> list, com.baidu.live.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.baidu.live.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.baidu.live.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.Ij = str;
        this.Ik = j;
        this.bvM = layerType;
        this.Im = j2;
        this.In = str2;
        this.FR = list2;
        this.bvz = lVar;
        this.Io = i;
        this.Ip = i2;
        this.Iq = i3;
        this.Ir = f;
        this.Dr = f2;
        this.Is = i4;
        this.It = i5;
        this.bvN = jVar;
        this.bvO = kVar;
        this.Ix = list3;
        this.bvQ = matteType;
        this.bvP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.live.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jW() {
        return this.Ir;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jX() {
        return this.Dr / this.composition.hZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.baidu.live.lottie.e.a<Float>> jY() {
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

    public LayerType Og() {
        return this.bvM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType Oh() {
        return this.bvQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kd() {
        return this.Im;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.baidu.live.lottie.model.content.b> iX() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l Oa() {
        return this.bvz;
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
    public j Oi() {
        return this.bvN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k Oj() {
        return this.bvO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.baidu.live.lottie.model.a.b Ok() {
        return this.bvP;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer bc = this.composition.bc(kd());
        if (bc != null) {
            sb.append("\t\tParents: ").append(bc.getName());
            Layer bc2 = this.composition.bc(bc.kd());
            while (bc2 != null) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR).append(bc2.getName());
                bc2 = this.composition.bc(bc2.kd());
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
            for (com.baidu.live.lottie.model.content.b bVar : this.shapes) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }
}
