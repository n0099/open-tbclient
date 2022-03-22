package c.a.n0.a.q.a.j;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class i0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public i0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    @Override // c.a.n0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            bVar.k = this.a;
        }
    }

    @Override // c.a.n0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    String optString = jSONArray.optString(0);
                    if (TextUtils.equals(optString, AnimationProperty.TOP)) {
                        this.a = 1;
                    } else if (TextUtils.equals(optString, "middle")) {
                        this.a = 2;
                    } else if (TextUtils.equals(optString, TipsConfigItem.TipConfigData.BOTTOM)) {
                        this.a = 3;
                    } else {
                        this.a = 0;
                    }
                }
            } catch (Exception e2) {
                if (c.a.n0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
