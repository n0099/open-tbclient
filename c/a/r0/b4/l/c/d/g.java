package c.a.r0.b4.l.c.d;

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
    public boolean f16341a;

    /* renamed from: b  reason: collision with root package name */
    public l f16342b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.b4.l.c.d.b f16343c;

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
        public String f16344a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f16345b;

        /* renamed from: c  reason: collision with root package name */
        public int f16346c;

        /* renamed from: d  reason: collision with root package name */
        public l f16347d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.b4.l.c.d.b f16348e;

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
            this.f16344a = "";
            this.f16345b = true;
            this.f16346c = 0;
            this.f16347d = null;
            this.f16348e = null;
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
                if (TextUtils.isEmpty(this.f16344a)) {
                    this.f16344a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f16346c <= 0) {
                    this.f16346c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f16347d == null) {
                    this.f16347d = new l(this.f16346c);
                }
                if (this.f16348e == null) {
                    this.f16348e = new c.a.r0.b4.l.c.d.b(this.f16344a);
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
        String unused = bVar.f16344a;
        this.f16341a = bVar.f16345b;
        int unused2 = bVar.f16346c;
        this.f16342b = bVar.f16347d;
        this.f16343c = bVar.f16348e;
    }
}
