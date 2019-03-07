package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.p;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShapeStroke implements b {
    private final String name;
    private final com.airbnb.lottie.model.a.a qH;
    private final com.airbnb.lottie.model.a.d qP;
    private final com.airbnb.lottie.model.a.b rf;
    private final LineCapType rg;
    private final LineJoinType rh;
    private final List<com.airbnb.lottie.model.a.b> ri;
    @Nullable
    private final com.airbnb.lottie.model.a.b rv;

    /* loaded from: classes2.dex */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            switch (this) {
                case Butt:
                    return Paint.Cap.BUTT;
                case Round:
                    return Paint.Cap.ROUND;
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            switch (this) {
                case Bevel:
                    return Paint.Join.BEVEL;
                case Miter:
                    return Paint.Join.MITER;
                case Round:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    private ShapeStroke(String str, @Nullable com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.a aVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType) {
        this.name = str;
        this.rv = bVar;
        this.ri = list;
        this.qH = aVar;
        this.qP = dVar;
        this.rf = bVar2;
        this.rg = lineCapType;
        this.rh = lineJoinType;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ShapeStroke A(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            com.airbnb.lottie.model.a.a d = a.C0008a.d(jSONObject.optJSONObject("c"), eVar);
            com.airbnb.lottie.model.a.b e = b.a.e(jSONObject.optJSONObject("w"), eVar);
            com.airbnb.lottie.model.a.d g = d.a.g(jSONObject.optJSONObject("o"), eVar);
            LineCapType lineCapType = LineCapType.values()[jSONObject.optInt("lc") - 1];
            LineJoinType lineJoinType = LineJoinType.values()[jSONObject.optInt("lj") - 1];
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                com.airbnb.lottie.model.a.b bVar2 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject.optString("n");
                    if (optString2.equals("o")) {
                        bVar2 = b.a.e(optJSONObject.optJSONObject("v"), eVar);
                    } else if (optString2.equals("d") || optString2.equals("g")) {
                        arrayList.add(b.a.e(optJSONObject.optJSONObject("v"), eVar));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                bVar = bVar2;
            }
            return new ShapeStroke(optString, bVar, arrayList, d, g, e, lineCapType, lineJoinType);
        }
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.a eB() {
        return this.qH;
    }

    public com.airbnb.lottie.model.a.d dU() {
        return this.qP;
    }

    public com.airbnb.lottie.model.a.b eh() {
        return this.rf;
    }

    public List<com.airbnb.lottie.model.a.b> ek() {
        return this.ri;
    }

    public com.airbnb.lottie.model.a.b el() {
        return this.rv;
    }

    public LineCapType ei() {
        return this.rg;
    }

    public LineJoinType ej() {
        return this.rh;
    }
}
