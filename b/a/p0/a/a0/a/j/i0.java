package b.a.p0.a.a0.a.j;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.baidu.adp.widget.VerticalTranslateLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class i0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f3921a;

    public i0() {
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
        this.f3921a = 0;
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            bVar.o = this.f3921a;
        }
    }

    @Override // b.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    String optString = jSONArray.optString(0);
                    if (TextUtils.equals(optString, VerticalTranslateLayout.TOP)) {
                        this.f3921a = 1;
                    } else if (TextUtils.equals(optString, "middle")) {
                        this.f3921a = 2;
                    } else if (TextUtils.equals(optString, "bottom")) {
                        this.f3921a = 3;
                    } else {
                        this.f3921a = 0;
                    }
                }
            } catch (Exception e2) {
                if (b.a.p0.a.k.f6863a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
