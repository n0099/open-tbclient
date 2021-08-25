package c.a.q0.a4.l.c.d;

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
    public boolean f15808a;

    /* renamed from: b  reason: collision with root package name */
    public l f15809b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.a4.l.c.d.b f15810c;

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
        public String f15811a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15812b;

        /* renamed from: c  reason: collision with root package name */
        public int f15813c;

        /* renamed from: d  reason: collision with root package name */
        public l f15814d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.q0.a4.l.c.d.b f15815e;

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
            this.f15811a = "";
            this.f15812b = true;
            this.f15813c = 0;
            this.f15814d = null;
            this.f15815e = null;
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
                if (TextUtils.isEmpty(this.f15811a)) {
                    this.f15811a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f15813c <= 0) {
                    this.f15813c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f15814d == null) {
                    this.f15814d = new l(this.f15813c);
                }
                if (this.f15815e == null) {
                    this.f15815e = new c.a.q0.a4.l.c.d.b(this.f15811a);
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
        String unused = bVar.f15811a;
        this.f15808a = bVar.f15812b;
        int unused2 = bVar.f15813c;
        this.f15809b = bVar.f15814d;
        this.f15810c = bVar.f15815e;
    }
}
