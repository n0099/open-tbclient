package c.a.p0.d1.f;

import c.a.d.o.e.n;
import c.a.p0.w0.e.l;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f13643b;

    /* renamed from: c  reason: collision with root package name */
    public Page f13644c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13645d;

    /* renamed from: e  reason: collision with root package name */
    public int f13646e;

    /* renamed from: f  reason: collision with root package name */
    public int f13647f;

    /* renamed from: g  reason: collision with root package name */
    public int f13648g;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f13645d = true;
        this.f13646e = 0;
        this.f13647f = 0;
        this.f13648g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void b(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            String str = lVar.f19378d;
            this.f13644c = lVar.f19377c;
            List<RecommendForumInfo> list = lVar.a;
            this.f13643b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f13643b) {
                    a aVar = new a();
                    aVar.r(recommendForumInfo);
                    this.a.add(aVar);
                }
            }
            Page page = this.f13644c;
            if (page != null) {
                this.f13645d = page.has_more.intValue() == 1;
                this.f13646e = this.f13644c.current_page.intValue();
            }
        }
    }
}
