package c.a.r0.f1.n;

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
    public int f12467b;

    /* renamed from: c  reason: collision with root package name */
    public int f12468c;

    /* renamed from: d  reason: collision with root package name */
    public int f12469d;

    /* renamed from: e  reason: collision with root package name */
    public int f12470e;

    /* renamed from: f  reason: collision with root package name */
    public int f12471f;

    /* renamed from: g  reason: collision with root package name */
    public int f12472g;

    /* renamed from: h  reason: collision with root package name */
    public int f12473h;

    /* renamed from: i  reason: collision with root package name */
    public int f12474i;

    /* renamed from: j  reason: collision with root package name */
    public String f12475j;

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
        this.f12467b = R.color.CAM_X0305;
        this.f12468c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.f12469d = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        this.f12470e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        this.f12471f = 0;
        this.f12472g = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f12473h = 0;
        this.f12474i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        this.f12475j = str;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12475j : (String) invokeV.objValue;
    }
}
