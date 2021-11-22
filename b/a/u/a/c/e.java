package b.a.u.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f29860a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f29861b;

    /* renamed from: c  reason: collision with root package name */
    public Socket f29862c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f29863d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f29864e;

    public e() {
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
        Boolean bool = Boolean.FALSE;
        this.f29860a = bool;
        this.f29861b = bool;
        this.f29862c = null;
        this.f29863d = null;
        this.f29864e = null;
    }
}
