package c.a.r0.j3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f20779a;

    /* renamed from: b  reason: collision with root package name */
    public String f20780b;

    /* renamed from: c  reason: collision with root package name */
    public String f20781c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f20782d;

    public c0() {
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
        this.f20779a = smartApp.name;
        this.f20780b = smartApp.id;
        this.f20781c = smartApp.link;
        this.f20782d = smartApp.is_game;
    }
}
