package c.a.r0.d4.l;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<MetaData> f16971a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f16972b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16971a = new ArrayList<>();
        this.f16972b = null;
    }

    public ArrayList<MetaData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16971a : (ArrayList) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                c(new JSONObject(str), true);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void c(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, z) == null) || jSONObject == null) {
            return;
        }
        if (z) {
            try {
                if (this.f16972b == null) {
                    this.f16972b = new HashMap<>();
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return;
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                MetaData metaData = new MetaData();
                metaData.parserJson(optJSONArray.getJSONObject(i2));
                if (!TextUtils.isEmpty(metaData.getName_show())) {
                    this.f16971a.add(metaData);
                    if (z) {
                        this.f16972b.put(metaData.getName_show(), metaData.getPortrait());
                    }
                }
            }
        }
    }
}
