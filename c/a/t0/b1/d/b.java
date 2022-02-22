package c.a.t0.b1.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Page;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12585b;

    /* renamed from: c  reason: collision with root package name */
    public Object f12586c;

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
        this.f12585b = true;
    }

    public void a(Page page) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, page) == null) || page == null) {
            return;
        }
        this.f12585b = page.has_more.intValue() == 1;
        page.has_prev.intValue();
        this.a = page.current_page.intValue();
        page.page_size.intValue();
        page.total_page.intValue();
        page.offset.intValue();
        page.total_count.intValue();
        c.a.t0.b1.h.a.b("parserProto--->currentPage=" + this.a + ",hasMore=" + this.f12585b);
    }
}
