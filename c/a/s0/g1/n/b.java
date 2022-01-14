package c.a.s0.g1.n;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
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
    public int f12647b;

    /* renamed from: c  reason: collision with root package name */
    public int f12648c;

    /* renamed from: d  reason: collision with root package name */
    public int f12649d;

    /* renamed from: e  reason: collision with root package name */
    public int f12650e;

    /* renamed from: f  reason: collision with root package name */
    public int f12651f;

    /* renamed from: g  reason: collision with root package name */
    public int f12652g;

    /* renamed from: h  reason: collision with root package name */
    public int f12653h;

    /* renamed from: i  reason: collision with root package name */
    public int f12654i;

    /* renamed from: j  reason: collision with root package name */
    public String f12655j;

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
        this.a = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f12647b = R.color.CAM_X0305;
        this.f12648c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.f12649d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        this.f12650e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        this.f12651f = 0;
        this.f12652g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f12653h = 0;
        this.f12654i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        this.f12655j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12655j : (String) invokeV.objValue;
    }
}
