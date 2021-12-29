package c.a.v0;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27297b;

    /* renamed from: c  reason: collision with root package name */
    public int f27298c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27299d;

    /* renamed from: e  reason: collision with root package name */
    public int f27300e;

    /* renamed from: f  reason: collision with root package name */
    public String f27301f;

    public m() {
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
        this.a = true;
        this.f27297b = false;
        this.f27298c = 60;
        this.f27299d = true;
        this.f27300e = 0;
        this.f27301f = "99999";
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? TextUtils.equals(str, "99999") : invokeL.booleanValue;
    }

    public m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
        this.f27297b = false;
        this.f27298c = 60;
        this.f27299d = true;
        this.f27300e = 0;
        this.f27301f = "99999";
        if (!TextUtils.isEmpty(str)) {
            this.f27301f = str;
            return;
        }
        throw new IllegalArgumentException("eventId is empty");
    }
}
