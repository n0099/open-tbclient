package b.a.r0.d4.l.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f17156a;

    /* renamed from: b  reason: collision with root package name */
    public l f17157b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.d4.l.c.d.b f17158c;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f17159a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f17160b;

        /* renamed from: c  reason: collision with root package name */
        public int f17161c;

        /* renamed from: d  reason: collision with root package name */
        public l f17162d;

        /* renamed from: e  reason: collision with root package name */
        public b.a.r0.d4.l.c.d.b f17163e;

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
            this.f17159a = "";
            this.f17160b = true;
            this.f17161c = 0;
            this.f17162d = null;
            this.f17163e = null;
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
                if (TextUtils.isEmpty(this.f17159a)) {
                    this.f17159a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f17161c <= 0) {
                    this.f17161c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f17162d == null) {
                    this.f17162d = new l(this.f17161c);
                }
                if (this.f17163e == null) {
                    this.f17163e = new b.a.r0.d4.l.c.d.b(this.f17159a);
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
        String unused = bVar.f17159a;
        this.f17156a = bVar.f17160b;
        int unused2 = bVar.f17161c;
        this.f17157b = bVar.f17162d;
        this.f17158c = bVar.f17163e;
    }
}
