package c.a.c0.s.y.b;

import c.a.c0.s.y.a.b;
import c.a.c0.s.y.a.c;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
@JvmName(name = "AuthParser")
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str != null) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("hosts");
                    if (optJSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                String host = optJSONObject.optString("host");
                                String optString = optJSONObject.optString("auth");
                                Intrinsics.checkNotNullExpressionValue(host, "host");
                                arrayList.add(new c.a.c0.s.y.a.a(host, b(optString)));
                            }
                        }
                        return new b(arrayList);
                    }
                    return null;
                } catch (Exception e2) {
                    c.a.c0.f.a.a("AuthParser", e2.getMessage());
                }
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static final c b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
                if (split$default.size() < 4) {
                    return null;
                }
                return new c(BdVideoSeries.parseIntSafe((String) split$default.get(0), 0), BdVideoSeries.parseIntSafe((String) split$default.get(1), 0), BdVideoSeries.parseIntSafe((String) split$default.get(2), 0), BdVideoSeries.parseIntSafe((String) split$default.get(3), 0));
            }
            return null;
        }
        return (c) invokeL.objValue;
    }
}
