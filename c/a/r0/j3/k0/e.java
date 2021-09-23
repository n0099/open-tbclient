package c.a.r0.j3.k0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20941a;

    /* renamed from: b  reason: collision with root package name */
    public String f20942b;

    /* renamed from: c  reason: collision with root package name */
    public String f20943c;

    /* renamed from: d  reason: collision with root package name */
    public d f20944d;

    /* renamed from: e  reason: collision with root package name */
    public d f20945e;

    /* renamed from: f  reason: collision with root package name */
    public d f20946f;

    public e(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20941a = false;
        this.f20942b = null;
        this.f20943c = null;
        this.f20944d = new d();
        this.f20945e = new d();
        this.f20946f = new d();
        this.f20943c = str;
        this.f20942b = str2;
        this.f20941a = z;
    }
}
