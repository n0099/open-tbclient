package com.airbnb.lottie.model.a;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.b;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    @Nullable
    public final com.airbnb.lottie.model.a.a nw;
    @Nullable
    public final com.airbnb.lottie.model.a.a nx;
    @Nullable
    public final b ny;
    @Nullable
    public final b nz;

    k(@Nullable com.airbnb.lottie.model.a.a aVar, @Nullable com.airbnb.lottie.model.a.a aVar2, @Nullable b bVar, @Nullable b bVar2) {
        this.nw = aVar;
        this.nx = aVar2;
        this.ny = bVar;
        this.nz = bVar2;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static k m(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            if (jSONObject == null || !jSONObject.has("a")) {
                return new k(null, null, null, null);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("a");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("fc");
            com.airbnb.lottie.model.a.a d = optJSONObject2 != null ? a.C0007a.d(optJSONObject2, eVar) : null;
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("sc");
            com.airbnb.lottie.model.a.a d2 = optJSONObject3 != null ? a.C0007a.d(optJSONObject3, eVar) : null;
            JSONObject optJSONObject4 = optJSONObject.optJSONObject(TbConfig.SW_APID);
            b e = optJSONObject4 != null ? b.a.e(optJSONObject4, eVar) : null;
            JSONObject optJSONObject5 = optJSONObject.optJSONObject(Info.kBaiduTimeKey);
            return new k(d, d2, e, optJSONObject5 != null ? b.a.e(optJSONObject5, eVar) : null);
        }
    }
}
