package c.a.t0.f1.n;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13016b;

    /* renamed from: c  reason: collision with root package name */
    public int f13017c;

    /* renamed from: d  reason: collision with root package name */
    public int f13018d;

    /* renamed from: e  reason: collision with root package name */
    public int f13019e;

    /* renamed from: f  reason: collision with root package name */
    public int f13020f;

    /* renamed from: g  reason: collision with root package name */
    public int f13021g;

    /* renamed from: h  reason: collision with root package name */
    public int f13022h;

    /* renamed from: i  reason: collision with root package name */
    public int f13023i;

    /* renamed from: j  reason: collision with root package name */
    public String f13024j;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbadkCoreApplication.getInst().getResources().getColor(c.a.u0.a4.d.white_alpha100);
        this.f13016b = c.a.u0.a4.d.CAM_X0305;
        this.f13017c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds5);
        this.f13018d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds44);
        this.f13019e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds11);
        this.f13020f = 0;
        this.f13021g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds12);
        this.f13022h = 0;
        this.f13023i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds26);
        this.f13024j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13024j : (String) invokeV.objValue;
    }
}
