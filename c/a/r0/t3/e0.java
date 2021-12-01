package c.a.r0.t3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f23767b;

    /* renamed from: c  reason: collision with root package name */
    public String f23768c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f23769d;

    public e0() {
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

    public void a(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) || smartApp == null) {
            return;
        }
        String str = smartApp.avatar;
        this.a = smartApp.name;
        this.f23767b = smartApp.id;
        this.f23768c = smartApp.link;
        this.f23769d = smartApp.is_game;
    }
}
