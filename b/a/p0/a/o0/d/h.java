package b.a.p0.a.o0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final String f7120c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7121d;

    public h(@Nullable String str, @Nullable String str2) {
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
        this.f7120c = str;
        this.f7121d = str2;
        this.f7099a = "firstMeaningfulPainted";
    }

    @Override // b.a.p0.a.o0.d.a
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(b.a.p0.a.o0.a.c(str, PrefetchEvent.EVENT_DATA_WEBVIEW_ID, TextUtils.isEmpty(this.f7120c) ? "" : this.f7120c));
            sb.append(b.a.p0.a.o0.a.c(str, "pageUrl", TextUtils.isEmpty(this.f7121d) ? "" : this.f7121d));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
