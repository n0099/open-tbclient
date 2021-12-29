package c.a.t0.n4.m.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public l f20538b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.n4.m.c.d.b f20539c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20540b;

        /* renamed from: c  reason: collision with root package name */
        public int f20541c;

        /* renamed from: d  reason: collision with root package name */
        public l f20542d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.t0.n4.m.c.d.b f20543e;

        public b() {
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
            this.a = "";
            this.f20540b = true;
            this.f20541c = 0;
            this.f20542d = null;
            this.f20543e = null;
        }

        public g d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                e();
                return new g(this, null);
            }
            return (g) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (TextUtils.isEmpty(this.a)) {
                    this.a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f20541c <= 0) {
                    this.f20541c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f20542d == null) {
                    this.f20542d = new l(this.f20541c);
                }
                if (this.f20543e == null) {
                    this.f20543e = new c.a.t0.n4.m.c.d.b(this.a);
                }
            }
        }
    }

    public /* synthetic */ g(b bVar, a aVar) {
        this(bVar);
    }

    public g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String unused = bVar.a;
        this.a = bVar.f20540b;
        int unused2 = bVar.f20541c;
        this.f20538b = bVar.f20542d;
        this.f20539c = bVar.f20543e;
    }
}
