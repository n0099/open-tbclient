package c.a.t0.s3.f;

import c.a.d.n.e.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f23468b;

    /* renamed from: c  reason: collision with root package name */
    public Page f23469c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23470d;

    /* renamed from: e  reason: collision with root package name */
    public int f23471e;

    /* renamed from: f  reason: collision with root package name */
    public int f23472f;

    /* renamed from: g  reason: collision with root package name */
    public int f23473g;

    public c() {
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
        this.a = new ArrayList();
        this.f23470d = true;
        this.f23471e = 0;
        this.f23472f = 0;
        this.f23473g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f23476d;
            this.f23469c = dVar.f23475c;
            List<RecommendForumInfo> list = dVar.a;
            this.f23468b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f23468b) {
                    b bVar = new b();
                    bVar.t(recommendForumInfo);
                    this.a.add(bVar);
                }
            }
            Page page = this.f23469c;
            if (page != null) {
                this.f23470d = page.has_more.intValue() == 1;
                this.f23471e = this.f23469c.current_page.intValue();
            }
        }
    }
}
