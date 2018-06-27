package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.p;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShapeStroke implements b {
    private final com.airbnb.lottie.model.a.a nF;
    private final com.airbnb.lottie.model.a.d nN;
    private final String name;
    private final com.airbnb.lottie.model.a.b od;
    private final LineCapType oe;
    private final LineJoinType of;
    private final List<com.airbnb.lottie.model.a.b> og;
    @Nullable
    private final com.airbnb.lottie.model.a.b ov;

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
        this.ov = bVar;
        this.og = list;
        this.nF = aVar;
        this.nN = dVar;
        this.od = bVar2;
        this.oe = lineCapType;
        this.of = lineJoinType;
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
            com.airbnb.lottie.model.a.a d = a.C0007a.d(jSONObject.optJSONObject("c"), eVar);
            com.airbnb.lottie.model.a.b e = b.a.e(jSONObject.optJSONObject("w"), eVar);
            com.airbnb.lottie.model.a.d g = d.a.g(jSONObject.optJSONObject("o"), eVar);
            LineCapType lineCapType = LineCapType.values()[jSONObject.optInt(com.baidu.fsg.base.statistics.j.g) - 1];
            LineJoinType lineJoinType = LineJoinType.values()[jSONObject.optInt("lj") - 1];
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                com.airbnb.lottie.model.a.b bVar2 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject.optString("n");
                    if (optString2.equals("o")) {
                        bVar2 = b.a.e(optJSONObject.optJSONObject(NotifyType.VIBRATE), eVar);
                    } else if (optString2.equals("d") || optString2.equals("g")) {
                        arrayList.add(b.a.e(optJSONObject.optJSONObject(NotifyType.VIBRATE), eVar));
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

    public com.airbnb.lottie.model.a.a dg() {
        return this.nF;
    }

    public com.airbnb.lottie.model.a.d cz() {
        return this.nN;
    }

    public com.airbnb.lottie.model.a.b cM() {
        return this.od;
    }

    public List<com.airbnb.lottie.model.a.b> cP() {
        return this.og;
    }

    public com.airbnb.lottie.model.a.b cQ() {
        return this.ov;
    }

    public LineCapType cN() {
        return this.oe;
    }

    public LineJoinType cO() {
        return this.of;
    }
}
