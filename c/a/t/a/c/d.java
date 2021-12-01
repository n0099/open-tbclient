package c.a.t.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f26208b;

    /* renamed from: c  reason: collision with root package name */
    public Socket f26209c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f26210d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f26211e;

    public d() {
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
        this.a = bool;
        this.f26208b = bool;
        this.f26209c = null;
        this.f26210d = null;
        this.f26211e = null;
    }
}
