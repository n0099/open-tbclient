package c.a.t.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f21286b;

    /* renamed from: c  reason: collision with root package name */
    public Socket f21287c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f21288d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f21289e;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Boolean bool = Boolean.FALSE;
        this.a = bool;
        this.f21286b = bool;
        this.f21287c = null;
        this.f21288d = null;
        this.f21289e = null;
    }
}
