package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class Layer {
    private final com.airbnb.lottie.d BJ;
    private final float BT;
    private final List<Mask> Ey;
    private final String GN;
    private final long GO;
    private final LayerType GP;
    private final long GQ;
    @Nullable
    private final String GR;
    private final int GU;
    private final int GV;
    private final int GW;
    private final float GX;
    private final int GY;
    private final int GZ;
    private final l Gf;
    @Nullable
    private final j Ha;
    @Nullable
    private final k Hb;
    @Nullable
    private final com.airbnb.lottie.model.a.b Hc;
    private final List<com.airbnb.lottie.e.a<Float>> Hd;
    private final MatteType He;
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

    public Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.BJ = dVar;
        this.GN = str;
        this.GO = j;
        this.GP = layerType;
        this.GQ = j2;
        this.GR = str2;
        this.Ey = list2;
        this.Gf = lVar;
        this.GU = i;
        this.GV = i2;
        this.GW = i3;
        this.GX = f;
        this.BT = f2;
        this.GY = i4;
        this.GZ = i5;
        this.Ha = jVar;
        this.Hb = kVar;
        this.Hd = list3;
        this.He = matteType;
        this.Hc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.d getComposition() {
        return this.BJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jW() {
        return this.GX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jX() {
        return this.BT / this.BJ.hZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> jY() {
        return this.Hd;
    }

    public long getId() {
        return this.GO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.GN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.GR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int jZ() {
        return this.GY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ka() {
        return this.GZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> iL() {
        return this.Ey;
    }

    public LayerType kb() {
        return this.GP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType kc() {
        return this.He;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kd() {
        return this.GQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> iX() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l jK() {
        return this.Gf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.GW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ke() {
        return this.GV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kf() {
        return this.GU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j kg() {
        return this.Ha;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k kh() {
        return this.Hb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b ki() {
        return this.Hc;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer B = this.BJ.B(kd());
        if (B != null) {
            sb.append("\t\tParents: ").append(B.getName());
            Layer B2 = this.BJ.B(B.kd());
            while (B2 != null) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR).append(B2.getName());
                B2 = this.BJ.B(B2.kd());
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
