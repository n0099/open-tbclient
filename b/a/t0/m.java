package b.a.t0;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28839a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28840b;

    /* renamed from: c  reason: collision with root package name */
    public int f28841c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28842d;

    /* renamed from: e  reason: collision with root package name */
    public int f28843e;

    /* renamed from: f  reason: collision with root package name */
    public String f28844f;

    public m() {
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
        this.f28839a = true;
        this.f28840b = false;
        this.f28841c = 60;
        this.f28842d = true;
        this.f28843e = 0;
        this.f28844f = "99999";
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.equals(str, "99999") : invokeL.booleanValue;
    }
}
