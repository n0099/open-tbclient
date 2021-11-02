package b.a.r0.c4.l.c.d;

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
    public boolean f15524a;

    /* renamed from: b  reason: collision with root package name */
    public l f15525b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.c4.l.c.d.b f15526c;

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
        public String f15527a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15528b;

        /* renamed from: c  reason: collision with root package name */
        public int f15529c;

        /* renamed from: d  reason: collision with root package name */
        public l f15530d;

        /* renamed from: e  reason: collision with root package name */
        public b.a.r0.c4.l.c.d.b f15531e;

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
            this.f15527a = "";
            this.f15528b = true;
            this.f15529c = 0;
            this.f15530d = null;
            this.f15531e = null;
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
                if (TextUtils.isEmpty(this.f15527a)) {
                    this.f15527a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f15529c <= 0) {
                    this.f15529c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f15530d == null) {
                    this.f15530d = new l(this.f15529c);
                }
                if (this.f15531e == null) {
                    this.f15531e = new b.a.r0.c4.l.c.d.b(this.f15527a);
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
        String unused = bVar.f15527a;
        this.f15524a = bVar.f15528b;
        int unused2 = bVar.f15529c;
        this.f15525b = bVar.f15530d;
        this.f15526c = bVar.f15531e;
    }
}
