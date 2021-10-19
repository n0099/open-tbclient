package c.a.r0.c4.l.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f16513a;

    /* renamed from: b  reason: collision with root package name */
    public l f16514b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.c4.l.c.d.b f16515c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f16516a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f16517b;

        /* renamed from: c  reason: collision with root package name */
        public int f16518c;

        /* renamed from: d  reason: collision with root package name */
        public l f16519d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.c4.l.c.d.b f16520e;

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
            this.f16516a = "";
            this.f16517b = true;
            this.f16518c = 0;
            this.f16519d = null;
            this.f16520e = null;
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
                if (TextUtils.isEmpty(this.f16516a)) {
                    this.f16516a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f16518c <= 0) {
                    this.f16518c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f16519d == null) {
                    this.f16519d = new l(this.f16518c);
                }
                if (this.f16520e == null) {
                    this.f16520e = new c.a.r0.c4.l.c.d.b(this.f16516a);
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
        String unused = bVar.f16516a;
        this.f16513a = bVar.f16517b;
        int unused2 = bVar.f16518c;
        this.f16514b = bVar.f16519d;
        this.f16515c = bVar.f16520e;
    }
}
