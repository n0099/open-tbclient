package c.a.p0.w0.e;

import c.a.o0.r.r.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f19349d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f19350e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1153181073, "Lc/a/p0/w0/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1153181073, "Lc/a/p0/w0/e/c;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        g(13);
        this.f19350e = new ArrayList();
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19349d : (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0905), R.drawable.obfuscated_res_0x7f0807cc));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08fb), R.drawable.obfuscated_res_0x7f0807c8));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0915), R.drawable.obfuscated_res_0x7f0807d4));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08fd), R.drawable.obfuscated_res_0x7f0807c9));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08ff), R.drawable.obfuscated_res_0x7f0807d5));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090f), R.drawable.obfuscated_res_0x7f0807cf));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08f9), R.drawable.obfuscated_res_0x7f0807ca));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090d), R.drawable.obfuscated_res_0x7f0807cb));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090b), R.drawable.obfuscated_res_0x7f0807d1));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0912), R.drawable.obfuscated_res_0x7f0807d0));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0906), R.drawable.obfuscated_res_0x7f0807cd));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0911), R.drawable.obfuscated_res_0x7f0807ce));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0907), R.drawable.obfuscated_res_0x7f0807d3));
            this.f19350e.add(new b(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0910), R.drawable.obfuscated_res_0x7f0807d2));
        }
    }

    public List<b> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19350e : (List) invokeV.objValue;
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f19349d = str;
        }
    }
}
