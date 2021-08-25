package c.a.p0.d1.m;

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
    public int f13201a;

    /* renamed from: b  reason: collision with root package name */
    public int f13202b;

    /* renamed from: c  reason: collision with root package name */
    public int f13203c;

    /* renamed from: d  reason: collision with root package name */
    public int f13204d;

    /* renamed from: e  reason: collision with root package name */
    public int f13205e;

    /* renamed from: f  reason: collision with root package name */
    public int f13206f;

    /* renamed from: g  reason: collision with root package name */
    public int f13207g;

    /* renamed from: h  reason: collision with root package name */
    public int f13208h;

    /* renamed from: i  reason: collision with root package name */
    public int f13209i;

    /* renamed from: j  reason: collision with root package name */
    public String f13210j;

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
        this.f13201a = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f13202b = R.color.CAM_X0305;
        this.f13203c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.f13204d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        this.f13205e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        this.f13206f = 0;
        this.f13207g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f13208h = 0;
        this.f13209i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        this.f13210j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13210j : (String) invokeV.objValue;
    }
}
