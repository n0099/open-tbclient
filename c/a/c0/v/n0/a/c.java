package c.a.c0.v.n0.a;

import c.a.c0.v.n0.b.e;
import c.a.c0.v.n0.b.f;
import c.a.c0.v.n0.b.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(e mpdModel, JSONArray clarityUrlList) {
        ArrayList<c.a.c0.v.n0.b.a> a;
        c.a.c0.v.n0.b.a aVar;
        ArrayList<Object> d2;
        ArrayList<c.a.c0.v.n0.b.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, mpdModel, clarityUrlList) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(clarityUrlList, "clarityUrlList");
            f b2 = mpdModel.b();
            if (b2 == null || (a = b2.a()) == null) {
                return;
            }
            f b3 = mpdModel.b();
            if (!(((b3 == null || (a2 = b3.a()) == null) ? 0 : a2.size()) > 0)) {
                a = null;
            }
            if (a == null || (aVar = a.get(0)) == null || (d2 = aVar.d()) == null) {
                return;
            }
            int size = d2.size();
            for (int i2 = 0; i2 < size; i2++) {
                JSONObject jSONObject = new JSONObject();
                Object obj = d2.get(i2);
                if (!(obj instanceof g)) {
                    obj = null;
                }
                g gVar = (g) obj;
                if (gVar != null) {
                    jSONObject.put("key", gVar.g());
                    jSONObject.put("rank", gVar.j());
                    jSONObject.put("title", gVar.k());
                    jSONObject.put("url", gVar.l());
                    jSONObject.put("width", gVar.m());
                    jSONObject.put("height", gVar.f());
                    jSONObject.put("download_url", gVar.d());
                    jSONObject.put("airPlay_url", c.a.c0.v.v0.e.a(new String[]{gVar.a(), gVar.d(), gVar.l()}));
                    jSONObject.put("videoBps", gVar.b());
                    jSONObject.put("vodMoovSize", gVar.h());
                    jSONObject.put("video_clarity_score", gVar.c());
                    jSONObject.put("prefetch_size", gVar.i());
                    Boolean b4 = aVar.b();
                    jSONObject.put("gopAlign", b4 != null ? b4.booleanValue() : gVar.e());
                    clarityUrlList.put(jSONObject);
                }
            }
        }
    }

    public static final void b(e mpdModel, JSONObject mpdJson) {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        int i2;
        JSONArray optJSONArray2;
        JSONArray jSONArray2;
        int i3;
        JSONArray jSONArray3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, mpdModel, mpdJson) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(mpdJson, "mpdJson");
            JSONObject optJSONObject = mpdJson.optJSONObject("video");
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("adaptation_set")) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            int i5 = 0;
            while (i5 < length) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                if (optJSONObject2 == null || (optJSONArray2 = optJSONObject2.optJSONArray("representation_list")) == null) {
                    jSONArray = optJSONArray;
                    i2 = length;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = optJSONArray2.length();
                    int i6 = 0;
                    while (i6 < length2) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i6);
                        if (optJSONObject3 != null) {
                            jSONArray2 = optJSONArray;
                            jSONArray3 = optJSONArray2;
                            i4 = length2;
                            i3 = length;
                            arrayList2.add(new g(optJSONObject3.optString("key"), optJSONObject3.optInt("rank"), optJSONObject3.optString("title"), optJSONObject3.optString("url"), optJSONObject3.optString("download_url"), optJSONObject3.optString("airPlay_url"), optJSONObject3.optInt("bps"), optJSONObject3.optInt("width"), optJSONObject3.optInt("height"), optJSONObject3.optDouble("size"), optJSONObject3.optInt("moov_size"), optJSONObject3.optDouble("clarity_score", -1.0d), optJSONObject3.optInt("prefetch_size", 0), optJSONObject3.optBoolean("frm_align")));
                        } else {
                            jSONArray2 = optJSONArray;
                            i3 = length;
                            jSONArray3 = optJSONArray2;
                            i4 = length2;
                        }
                        i6++;
                        optJSONArray2 = jSONArray3;
                        optJSONArray = jSONArray2;
                        length2 = i4;
                        length = i3;
                    }
                    jSONArray = optJSONArray;
                    i2 = length;
                    arrayList.add(new c.a.c0.v.n0.b.a(arrayList2, optJSONObject2.optString("type"), optJSONObject2.has("frm_align") ? Boolean.valueOf(optJSONObject2.optBoolean("frm_align")) : null, optJSONObject2.optString("pre"), optJSONObject2.optString("suf"), optJSONObject2.optString("codecs")));
                }
                i5++;
                optJSONArray = jSONArray;
                length = i2;
            }
            mpdModel.f(new f(arrayList, null, null, null, null, 30, null));
        }
    }
}
