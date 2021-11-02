package b.a.r0.z2;

import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static String a(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            String str = "";
            if (list == null) {
                return "";
            }
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(goodsInfo.lego_card).optJSONObject("ad_common");
                        if (optJSONObject != null) {
                            str = optJSONObject.optString("id");
                        }
                        return str;
                    } catch (JSONException unused) {
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static int b(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            if (list == null) {
                return -1;
            }
            Iterator<GoodsInfo> it = list.iterator();
            while (it.hasNext()) {
                GoodsInfo next = it.next();
                if (next != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(next.lego_card).optJSONObject("ad_common");
                        if (optJSONObject != null) {
                            return b.a.e.e.m.b.e(optJSONObject.optString(IAdRequestParam.POS), -1);
                        }
                        return -1;
                    } catch (JSONException unused) {
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void c(@NonNull App.Builder builder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, builder, i2) == null) || builder.goods_info == null) {
            return;
        }
        for (int i3 = 0; i3 < builder.goods_info.size(); i3++) {
            GoodsInfo goodsInfo = (GoodsInfo) b.a.r0.q1.o.k.a.d(builder.goods_info, i3);
            if (goodsInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject(goodsInfo.lego_card);
                    JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
                    if (optJSONObject != null) {
                        optJSONObject.put(IAdRequestParam.POS, String.valueOf(b.a.e.e.m.b.e(optJSONObject.optString(IAdRequestParam.POS), 0) + i2));
                        GoodsInfo.Builder builder2 = new GoodsInfo.Builder(goodsInfo);
                        builder2.lego_card = jSONObject.toString();
                        builder.goods_info.set(i3, builder2.build(false));
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }
}
