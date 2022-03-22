package c.a.m;

import android.content.pm.ApplicationInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ApplicationInfo a;

    /* renamed from: b  reason: collision with root package name */
    public int f3717b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3718c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3719d;

    public b() {
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
        this.f3717b = 0;
        this.f3718c = false;
        this.f3719d = false;
    }
}
