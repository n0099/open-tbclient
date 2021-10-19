package c.a.r0.z2.i0.b;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29687a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f29688b;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f29689a;

        /* renamed from: b  reason: collision with root package name */
        public long f29690b;

        /* renamed from: c  reason: collision with root package name */
        public long f29691c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                this.f29689a = jSONObject.optInt("style");
                long optLong = jSONObject.optLong(DelayTB.DELAY);
                this.f29690b = optLong;
                if (optLong < 0) {
                    this.f29690b = 0L;
                }
                this.f29691c = jSONObject.optLong("duration");
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static c a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            c cVar = new c();
            cVar.f29687a = jSONObject.optString("backgroundColor");
            JSONArray optJSONArray = jSONObject.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
            cVar.f29688b = new ArrayList();
            for (int i2 = 0; optJSONArray != null && i2 < optJSONArray.length(); i2++) {
                List<a> list = cVar.f29688b;
                a aVar = new a();
                aVar.a(optJSONArray.optJSONObject(i2));
                list.add(aVar);
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
