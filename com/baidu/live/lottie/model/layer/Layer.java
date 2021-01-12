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
    private final float BS;
    private final List<Mask> Ey;
    private final String GN;
    private final long GO;
    private final long GQ;
    @Nullable
    private final String GR;
    private final int GU;
    private final int GV;
    private final int GW;
    private final float GX;
    private final int GY;
    private final int GZ;
    private final List<com.baidu.live.lottie.e.a<Float>> Hd;
    private final LayerType bqJ;
    @Nullable
    private final j bqK;
    @Nullable
    private final k bqL;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bqM;
    private final MatteType bqN;
    private final l bqw;
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
        this.GN = str;
        this.GO = j;
        this.bqJ = layerType;
        this.GQ = j2;
        this.GR = str2;
        this.Ey = list2;
        this.bqw = lVar;
        this.GU = i;
        this.GV = i2;
        this.GW = i3;
        this.GX = f;
        this.BS = f2;
        this.GY = i4;
        this.GZ = i5;
        this.bqK = jVar;
        this.bqL = kVar;
        this.Hd = list3;
        this.bqN = matteType;
        this.bqM = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.live.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jX() {
        return this.GX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jY() {
        return this.BS / this.composition.ia();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.baidu.live.lottie.e.a<Float>> jZ() {
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
    public int ka() {
        return this.GY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kb() {
        return this.GZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> iM() {
        return this.Ey;
    }

    public LayerType MF() {
        return this.bqJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType MG() {
        return this.bqN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ke() {
        return this.GQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.baidu.live.lottie.model.content.b> iY() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l Mz() {
        return this.bqw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.GW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kf() {
        return this.GV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kg() {
        return this.GU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j MH() {
        return this.bqK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k MI() {
        return this.bqL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.baidu.live.lottie.model.a.b MJ() {
        return this.bqM;
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
