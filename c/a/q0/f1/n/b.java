package c.a.q0.f1.n;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f12140b;

    /* renamed from: c  reason: collision with root package name */
    public int f12141c;

    /* renamed from: d  reason: collision with root package name */
    public int f12142d;

    /* renamed from: e  reason: collision with root package name */
    public int f12143e;

    /* renamed from: f  reason: collision with root package name */
    public int f12144f;

    /* renamed from: g  reason: collision with root package name */
    public int f12145g;

    /* renamed from: h  reason: collision with root package name */
    public int f12146h;

    /* renamed from: i  reason: collision with root package name */
    public int f12147i;

    /* renamed from: j  reason: collision with root package name */
    public String f12148j;

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
        this.f12140b = R.color.CAM_X0305;
        this.f12141c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.f12142d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        this.f12143e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        this.f12144f = 0;
        this.f12145g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f12146h = 0;
        this.f12147i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        this.f12148j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12148j : (String) invokeV.objValue;
    }
}
