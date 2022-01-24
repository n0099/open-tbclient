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
    public boolean f26510b;

    /* renamed from: c  reason: collision with root package name */
    public int f26511c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26512d;

    /* renamed from: e  reason: collision with root package name */
    public int f26513e;

    /* renamed from: f  reason: collision with root package name */
    public String f26514f;

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
        this.f26510b = false;
        this.f26511c = 60;
        this.f26512d = true;
        this.f26513e = 0;
        this.f26514f = "99999";
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
        this.f26510b = false;
        this.f26511c = 60;
        this.f26512d = true;
        this.f26513e = 0;
        this.f26514f = "99999";
        if (!TextUtils.isEmpty(str)) {
            this.f26514f = str;
            return;
        }
        throw new IllegalArgumentException("eventId is empty");
    }
}
