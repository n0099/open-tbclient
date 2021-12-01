package c.a.l;

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
    public int f3691b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3692c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3693d;

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
        this.f3691b = 0;
        this.f3692c = false;
        this.f3693d = false;
    }
}
