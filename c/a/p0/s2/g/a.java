package c.a.p0.s2.g;

import android.content.Context;
import c.a.p0.s2.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f18248b;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18248b = new ArrayList();
        this.a = context;
        a();
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case 1:
                    return R.drawable.obfuscated_res_0x7f0807ed;
                case 2:
                    return R.drawable.obfuscated_res_0x7f0807f0;
                case 3:
                    return R.drawable.obfuscated_res_0x7f0807e6;
                case 4:
                    return R.drawable.obfuscated_res_0x7f0807f1;
                case 5:
                    return R.drawable.obfuscated_res_0x7f0807f6;
                case 6:
                    return R.drawable.obfuscated_res_0x7f0807ef;
                case 7:
                    return R.drawable.obfuscated_res_0x7f0807f8;
                case 8:
                    return R.drawable.obfuscated_res_0x7f0807f3;
                case 9:
                    return R.drawable.obfuscated_res_0x7f0807f7;
                case 10:
                case 15:
                case 17:
                case 18:
                case 21:
                default:
                    return -1;
                case 11:
                    return R.drawable.obfuscated_res_0x7f0807f4;
                case 12:
                    return R.drawable.obfuscated_res_0x7f0807e9;
                case 13:
                    return R.drawable.obfuscated_res_0x7f0807fa;
                case 14:
                    return R.drawable.obfuscated_res_0x7f0807e4;
                case 16:
                    return R.drawable.obfuscated_res_0x7f0807eb;
                case 19:
                    return R.drawable.obfuscated_res_0x7f0807ec;
                case 20:
                    return R.drawable.obfuscated_res_0x7f0807e5;
                case 22:
                    return R.drawable.obfuscated_res_0x7f0807e8;
                case 23:
                    return R.drawable.obfuscated_res_0x7f0807ea;
                case 24:
                    return R.drawable.obfuscated_res_0x7f0807f5;
                case 25:
                    return R.drawable.obfuscated_res_0x7f0807e7;
                case 26:
                    return R.drawable.obfuscated_res_0x7f0807ee;
                case 27:
                    return R.drawable.obfuscated_res_0x7f0807f2;
                case 28:
                    return R.drawable.obfuscated_res_0x7f0807f9;
            }
        }
        return invokeI.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18248b.add(new b(1, this.a.getString(R.string.obfuscated_res_0x7f0f0905), R.drawable.obfuscated_res_0x7f0807ed, false));
            this.f18248b.add(new b(3, this.a.getString(R.string.obfuscated_res_0x7f0f08fb), R.drawable.obfuscated_res_0x7f0807e6, false));
            this.f18248b.add(new b(11, this.a.getString(R.string.obfuscated_res_0x7f0f090e), R.drawable.obfuscated_res_0x7f0807f4, false));
            this.f18248b.add(new b(4, this.a.getString(R.string.obfuscated_res_0x7f0f090a), R.drawable.obfuscated_res_0x7f0807f1, false));
            this.f18248b.add(new b(22, this.a.getString(R.string.obfuscated_res_0x7f0f08fd), R.drawable.obfuscated_res_0x7f0807e8, false));
            this.f18248b.add(new b(5, this.a.getString(R.string.obfuscated_res_0x7f0f0912), R.drawable.obfuscated_res_0x7f0807f6, false));
            this.f18248b.add(new b(19, this.a.getString(R.string.obfuscated_res_0x7f0f0904), R.drawable.obfuscated_res_0x7f0807ec, false));
            this.f18248b.add(new b(8, this.a.getString(R.string.obfuscated_res_0x7f0f090d), R.drawable.obfuscated_res_0x7f0807f3, false));
            this.f18248b.add(new b(2, this.a.getString(R.string.obfuscated_res_0x7f0f0909), R.drawable.obfuscated_res_0x7f0807f0, false));
            this.f18248b.add(new b(16, this.a.getString(R.string.obfuscated_res_0x7f0f0902), R.drawable.obfuscated_res_0x7f0807eb, false));
            this.f18248b.add(new b(13, this.a.getString(R.string.obfuscated_res_0x7f0f0918), R.drawable.obfuscated_res_0x7f0807fa, false));
            this.f18248b.add(new b(12, this.a.getString(R.string.obfuscated_res_0x7f0f08fe), R.drawable.obfuscated_res_0x7f0807e9, false));
            this.f18248b.add(new b(23, this.a.getString(R.string.obfuscated_res_0x7f0f0900), R.drawable.obfuscated_res_0x7f0807ea, false));
            this.f18248b.add(new b(14, this.a.getString(R.string.obfuscated_res_0x7f0f08f8), R.drawable.obfuscated_res_0x7f0807e4, false));
            this.f18248b.add(new b(20, this.a.getString(R.string.obfuscated_res_0x7f0f08fa), R.drawable.obfuscated_res_0x7f0807e5, false));
            this.f18248b.add(new b(7, this.a.getString(R.string.obfuscated_res_0x7f0f0916), R.drawable.obfuscated_res_0x7f0807f8, false));
            this.f18248b.add(new b(9, this.a.getString(R.string.obfuscated_res_0x7f0f0915), R.drawable.obfuscated_res_0x7f0807f7, false));
            this.f18248b.add(new b(6, this.a.getString(R.string.obfuscated_res_0x7f0f0908), R.drawable.obfuscated_res_0x7f0807ef, false));
            this.f18248b.add(new b(24, this.a.getString(R.string.obfuscated_res_0x7f0f0910), R.drawable.obfuscated_res_0x7f0807f5, false));
            this.f18248b.add(new b(25, this.a.getString(R.string.obfuscated_res_0x7f0f08fc), R.drawable.obfuscated_res_0x7f0807e7, false));
            this.f18248b.add(new b(26, this.a.getString(R.string.obfuscated_res_0x7f0f0906), R.drawable.obfuscated_res_0x7f0807ee, false));
            this.f18248b.add(new b(27, this.a.getString(R.string.obfuscated_res_0x7f0f090c), R.drawable.obfuscated_res_0x7f0807f2, false));
            this.f18248b.add(new b(28, this.a.getString(R.string.obfuscated_res_0x7f0f0917), R.drawable.obfuscated_res_0x7f0807f9, false));
        }
    }

    public List<b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18248b : (List) invokeV.objValue;
    }
}
