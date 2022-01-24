package c.a.r0.a.o0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final String f8187c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8188d;

    public i(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8187c = str;
        this.f8188d = str2;
        this.a = "firstMeaningfulPainted";
    }

    @Override // c.a.r0.a.o0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            map.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, TextUtils.isEmpty(this.f8187c) ? "" : this.f8187c);
            map.put("pageUrl", TextUtils.isEmpty(this.f8188d) ? "" : this.f8188d);
        }
    }
}
