package b.a.r0.o0.k.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f21747a;

    /* renamed from: b  reason: collision with root package name */
    public String f21748b;

    /* renamed from: c  reason: collision with root package name */
    public String f21749c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21750d;

    /* renamed from: e  reason: collision with root package name */
    public String f21751e;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TestInfo testInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, testInfo) == null) || testInfo == null) {
            return;
        }
        this.f21747a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f21748b = str;
        this.f21749c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f21750d = testInfo.answered.intValue() == 1;
        this.f21751e = testInfo.result_img;
    }
}
