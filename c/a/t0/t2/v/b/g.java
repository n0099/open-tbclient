package c.a.t0.t2.v.b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes8.dex */
public class g implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f23478e;

    /* renamed from: f  reason: collision with root package name */
    public int f23479f;

    /* renamed from: g  reason: collision with root package name */
    public String f23480g;

    /* renamed from: h  reason: collision with root package name */
    public int f23481h;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23479f = 0;
        this.f23481h = -1;
        this.f23478e = new SpannableStringBuilder();
    }

    @Override // c.a.t0.t2.v.b.c
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f23479f;
            return (i2 > 0 && i2 < 3) || !StringUtils.isNull(this.f23480g);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.t2.v.b.c
    public CharSequence b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23478e : (CharSequence) invokeV.objValue;
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) || charSequence == null) {
            return;
        }
        this.f23478e.append(charSequence);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23479f : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23480g : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23481h : invokeV.intValue;
    }

    @Override // c.a.t0.t2.v.b.d
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public g(Context context, ExcContent excContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, excContent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23479f = 0;
        this.f23481h = -1;
        if (excContent == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.f23478e = spannableStringBuilder;
        if (excContent != null) {
            spannableStringBuilder.append((CharSequence) excContent.text);
        }
        Integer num = excContent.align;
        if (num != null) {
            this.f23479f = num.intValue();
        }
        if (!StringUtils.isNull(excContent.color)) {
            this.f23480g = excContent.color;
        }
        Integer num2 = excContent.size;
        if (num2 == null || num2.intValue() <= 0 || context == null || context.getResources() == null) {
            return;
        }
        int identifier = context.getResources().getIdentifier("fontsize" + excContent.size, "dimen", context.getPackageName());
        if (identifier <= 0) {
            return;
        }
        this.f23481h = context.getResources().getDimensionPixelSize(identifier);
    }
}
