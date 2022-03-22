package c.a.p0.a4.r0.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public String f12345b;

    /* renamed from: c  reason: collision with root package name */
    public String f12346c;

    /* renamed from: d  reason: collision with root package name */
    public String f12347d;

    /* renamed from: e  reason: collision with root package name */
    public int f12348e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.a = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        this.a.add(Integer.valueOf(optJSONArray.getInt(i)));
                    }
                }
                this.f12345b = optJSONObject.optString("upload_id");
                this.f12346c = optJSONObject.optString("video_url");
            }
        } catch (JSONException unused) {
        }
    }
}
