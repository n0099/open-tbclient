package c.a.p0.c0.f.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId i;
    public transient /* synthetic */ FieldHolder $fh;
    public SdkLiveInfoData a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12856b;

    /* renamed from: c  reason: collision with root package name */
    public String f12857c;

    /* renamed from: d  reason: collision with root package name */
    public String f12858d;

    /* renamed from: e  reason: collision with root package name */
    public int f12859e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12860f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12861g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12862h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1712463210, "Lc/a/p0/c0/f/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1712463210, "Lc/a/p0/c0/f/a/a;");
                return;
            }
        }
        i = BdUniqueId.gen();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12856b = false;
        this.f12860f = false;
        this.f12861g = false;
        this.f12862h = false;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? i : (BdUniqueId) invokeV.objValue;
    }
}
