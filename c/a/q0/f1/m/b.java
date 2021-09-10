package c.a.q0.f1.m;

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
    public int f13234a;

    /* renamed from: b  reason: collision with root package name */
    public int f13235b;

    /* renamed from: c  reason: collision with root package name */
    public int f13236c;

    /* renamed from: d  reason: collision with root package name */
    public int f13237d;

    /* renamed from: e  reason: collision with root package name */
    public int f13238e;

    /* renamed from: f  reason: collision with root package name */
    public int f13239f;

    /* renamed from: g  reason: collision with root package name */
    public int f13240g;

    /* renamed from: h  reason: collision with root package name */
    public int f13241h;

    /* renamed from: i  reason: collision with root package name */
    public int f13242i;

    /* renamed from: j  reason: collision with root package name */
    public String f13243j;

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
        this.f13234a = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f13235b = R.color.CAM_X0305;
        this.f13236c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.f13237d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        this.f13238e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        this.f13239f = 0;
        this.f13240g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f13241h = 0;
        this.f13242i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        this.f13243j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13243j : (String) invokeV.objValue;
    }
}
