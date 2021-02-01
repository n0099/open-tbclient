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
    private final float BT;
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
    private final l btY;
    private final LayerType bum;
    @Nullable
    private final j bun;
    @Nullable
    private final k buo;
    @Nullable
    private final com.baidu.live.lottie.model.a.b bup;
    private final MatteType buq;
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
        this.GN = str;
        this.GO = j;
        this.bum = layerType;
        this.GQ = j2;
        this.GR = str2;
        this.Ey = list2;
        this.btY = lVar;
        this.GU = i;
        this.GV = i2;
        this.GW = i3;
        this.GX = f;
        this.BT = f2;
        this.GY = i4;
        this.GZ = i5;
        this.bun = jVar;
        this.buo = kVar;
        this.Hd = list3;
        this.buq = matteType;
        this.bup = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.live.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jW() {
        return this.GX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jX() {
        return this.BT / this.composition.hZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.baidu.live.lottie.e.a<Float>> jY() {
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

    public LayerType Od() {
        return this.bum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType Oe() {
        return this.buq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kd() {
        return this.GQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.baidu.live.lottie.model.content.b> iX() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l NX() {
        return this.btY;
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
    public j Of() {
        return this.bun;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k Og() {
        return this.buo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.baidu.live.lottie.model.a.b Oh() {
        return this.bup;
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
