package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class Layer {
    private final float BU;
    private final List<Mask> EA;
    private final String GP;
    private final long GQ;
    private final LayerType GR;
    private final long GU;
    @Nullable
    private final String GV;
    private final int GW;
    private final int GX;
    private final int GY;
    private final float GZ;
    private final l Gh;
    private final int Ha;
    private final int Hb;
    @Nullable
    private final j Hc;
    @Nullable
    private final k Hd;
    @Nullable
    private final com.airbnb.lottie.model.a.b He;
    private final List<com.airbnb.lottie.e.a<Float>> Hf;
    private final MatteType Hg;
    private final com.airbnb.lottie.d composition;
    private final List<com.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes3.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes3.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = dVar;
        this.GP = str;
        this.GQ = j;
        this.GR = layerType;
        this.GU = j2;
        this.GV = str2;
        this.EA = list2;
        this.Gh = lVar;
        this.GW = i;
        this.GX = i2;
        this.GY = i3;
        this.GZ = f;
        this.BU = f2;
        this.Ha = i4;
        this.Hb = i5;
        this.Hc = jVar;
        this.Hd = kVar;
        this.Hf = list3;
        this.Hg = matteType;
        this.He = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.d getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jX() {
        return this.GZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jY() {
        return this.BU / this.composition.ia();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.e.a<Float>> jZ() {
        return this.Hf;
    }

    public long getId() {
        return this.GQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.GP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.GV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ka() {
        return this.Ha;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kb() {
        return this.Hb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> iM() {
        return this.EA;
    }

    public LayerType kc() {
        return this.GR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType kd() {
        return this.Hg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ke() {
        return this.GU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> iY() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l jL() {
        return this.Gh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.GY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kf() {
        return this.GX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kg() {
        return this.GW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j kh() {
        return this.Hc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k ki() {
        return this.Hd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b kj() {
        return this.He;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer B = this.composition.B(ke());
        if (B != null) {
            sb.append("\t\tParents: ").append(B.getName());
            Layer B2 = this.composition.B(B.ke());
            while (B2 != null) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR).append(B2.getName());
                B2 = this.composition.B(B2.ke());
            }
            sb.append(str).append("\n");
        }
        if (!iM().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(iM().size()).append("\n");
        }
        if (kg() != 0 && kf() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(kg()), Integer.valueOf(kf()), Integer.valueOf(getSolidColor())));
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
