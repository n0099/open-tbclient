package c.a.b0.v.n0.a;

import c.a.b0.v.n0.b.d;
import c.a.b0.v.n0.b.e;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(e mpdModel, JSONArray clarityUrlList) {
        ArrayList<c.a.b0.v.n0.b.a> a;
        c.a.b0.v.n0.b.a aVar;
        ArrayList<Object> d2;
        ArrayList<c.a.b0.v.n0.b.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, mpdModel, clarityUrlList) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(clarityUrlList, "clarityUrlList");
            c.a.b0.v.n0.b.c a3 = mpdModel.a();
            if (a3 == null || (a = a3.a()) == null) {
                return;
            }
            c.a.b0.v.n0.b.c a4 = mpdModel.a();
            if (!(((a4 == null || (a2 = a4.a()) == null) ? 0 : a2.size()) > 0)) {
                a = null;
            }
            if (a == null || (aVar = a.get(0)) == null || (d2 = aVar.d()) == null) {
                return;
            }
            int length = clarityUrlList.length();
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = clarityUrlList.get(i2);
                if (!(obj instanceof JSONObject)) {
                    obj = null;
                }
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    Object obj2 = d2.get(0);
                    if (!(obj2 instanceof d)) {
                        obj2 = null;
                    }
                    d dVar = (d) obj2;
                    if (dVar != null) {
                        jSONObject.put("interact_url", dVar.a());
                    }
                }
            }
        }
    }

    public static final void b(e mpdModel, JSONObject mpdJson) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, mpdModel, mpdJson) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(mpdJson, "mpdJson");
            JSONObject optJSONObject = mpdJson.optJSONObject(BdVideoSeries.RESOURCE_TYPE_INTERACT);
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("adaptation_set")) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null && (optJSONArray2 = optJSONObject2.optJSONArray("representation_list")) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = optJSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            arrayList2.add(new d(optJSONObject3.optString("url")));
                        }
                    }
                    arrayList.add(new c.a.b0.v.n0.b.a(arrayList2, optJSONObject2.optString("type"), null, null, null, null, 60, null));
                }
            }
            mpdModel.c(new c.a.b0.v.n0.b.c(arrayList));
        }
    }
}
