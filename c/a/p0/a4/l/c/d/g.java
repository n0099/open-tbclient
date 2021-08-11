package c.a.p0.a4.l.c.d;

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
    public boolean f15522a;

    /* renamed from: b  reason: collision with root package name */
    public l f15523b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a4.l.c.d.b f15524c;

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
        public String f15525a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15526b;

        /* renamed from: c  reason: collision with root package name */
        public int f15527c;

        /* renamed from: d  reason: collision with root package name */
        public l f15528d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.p0.a4.l.c.d.b f15529e;

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
            this.f15525a = "";
            this.f15526b = true;
            this.f15527c = 0;
            this.f15528d = null;
            this.f15529e = null;
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
                if (TextUtils.isEmpty(this.f15525a)) {
                    this.f15525a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f15527c <= 0) {
                    this.f15527c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f15528d == null) {
                    this.f15528d = new l(this.f15527c);
                }
                if (this.f15529e == null) {
                    this.f15529e = new c.a.p0.a4.l.c.d.b(this.f15525a);
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
        String unused = bVar.f15525a;
        this.f15522a = bVar.f15526b;
        int unused2 = bVar.f15527c;
        this.f15523b = bVar.f15528d;
        this.f15524c = bVar.f15529e;
    }
}
