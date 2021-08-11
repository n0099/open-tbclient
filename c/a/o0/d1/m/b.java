package c.a.o0.d1.m;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12920a;

    /* renamed from: b  reason: collision with root package name */
    public int f12921b;

    /* renamed from: c  reason: collision with root package name */
    public int f12922c;

    /* renamed from: d  reason: collision with root package name */
    public int f12923d;

    /* renamed from: e  reason: collision with root package name */
    public int f12924e;

    /* renamed from: f  reason: collision with root package name */
    public int f12925f;

    /* renamed from: g  reason: collision with root package name */
    public int f12926g;

    /* renamed from: h  reason: collision with root package name */
    public int f12927h;

    /* renamed from: i  reason: collision with root package name */
    public int f12928i;

    /* renamed from: j  reason: collision with root package name */
    public String f12929j;

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
        this.f12920a = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f12921b = R.color.CAM_X0305;
        this.f12922c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.f12923d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        this.f12924e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        this.f12925f = 0;
        this.f12926g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f12927h = 0;
        this.f12928i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        this.f12929j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12929j : (String) invokeV.objValue;
    }
}
