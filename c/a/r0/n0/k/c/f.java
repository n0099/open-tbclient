package c.a.r0.n0.k.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f22677a;

    /* renamed from: b  reason: collision with root package name */
    public String f22678b;

    /* renamed from: c  reason: collision with root package name */
    public String f22679c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22680d;

    /* renamed from: e  reason: collision with root package name */
    public String f22681e;

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
        this.f22677a = testInfo.test_id.longValue();
        String str = testInfo.title;
        if (str == null) {
            str = "";
        }
        this.f22678b = str;
        this.f22679c = testInfo.image_url;
        testInfo.create_time.intValue();
        this.f22680d = testInfo.answered.intValue() == 1;
        this.f22681e = testInfo.result_img;
    }
}
