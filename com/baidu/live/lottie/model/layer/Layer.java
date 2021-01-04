package com.baidu.live.lottie.model.layer;

import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.a.j;
import com.baidu.live.lottie.model.a.k;
import com.baidu.live.lottie.model.a.l;
import com.baidu.live.lottie.model.content.Mask;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public class Layer {
    private final float BU;
    private final List<Mask> EA;
    private final String GP;
    private final long GQ;
    private final long GU;
    @Nullable
    private final String GV;
    private final int GW;
    private final int GX;
    private final int GY;
    private final float GZ;
    private final int Ha;
    private final int Hb;
    private final List<com.baidu.live.lottie.e.a<Float>> Hf;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bvA;
    private final MatteType bvB;
    private final l bvk;
    private final LayerType bvx;
    @Nullable
    private final j bvy;
    @Nullable
    private final k bvz;
    private final com.baidu.live.lottie.e composition;
    private final List<com.baidu.live.lottie.model.content.b> shapes;

    /* loaded from: classes10.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes10.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.baidu.live.lottie.model.content.b> list, com.baidu.live.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.baidu.live.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.baidu.live.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.GP = str;
        this.GQ = j;
        this.bvx = layerType;
        this.GU = j2;
        this.GV = str2;
        this.EA = list2;
        this.bvk = lVar;
        this.GW = i;
        this.GX = i2;
        this.GY = i3;
        this.GZ = f;
        this.BU = f2;
        this.Ha = i4;
        this.Hb = i5;
        this.bvy = jVar;
        this.bvz = kVar;
        this.Hf = list3;
        this.bvB = matteType;
        this.bvA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.live.lottie.e getComposition() {
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
    public List<com.baidu.live.lottie.e.a<Float>> jZ() {
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

    public LayerType QA() {
        return this.bvx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType QB() {
        return this.bvB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ke() {
        return this.GU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.baidu.live.lottie.model.content.b> iY() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l Qu() {
        return this.bvk;
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
    public j QC() {
        return this.bvy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k QD() {
        return this.bvz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.baidu.live.lottie.model.a.b QE() {
        return this.bvA;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer aY = this.composition.aY(ke());
        if (aY != null) {
            sb.append("\t\tParents: ").append(aY.getName());
            Layer aY2 = this.composition.aY(aY.ke());
            while (aY2 != null) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR).append(aY2.getName());
                aY2 = this.composition.aY(aY2.ke());
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
            for (com.baidu.live.lottie.model.content.b bVar : this.shapes) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }
}
