package b.a.r0.j3.f;

import b.a.e.m.e.n;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f19975a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f19976b;

    /* renamed from: c  reason: collision with root package name */
    public Page f19977c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19978d;

    /* renamed from: e  reason: collision with root package name */
    public int f19979e;

    /* renamed from: f  reason: collision with root package name */
    public int f19980f;

    /* renamed from: g  reason: collision with root package name */
    public int f19981g;

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
        this.f19975a = new ArrayList();
        this.f19978d = true;
        this.f19979e = 0;
        this.f19980f = 0;
        this.f19981g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19975a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f19985d;
            this.f19977c = dVar.f19984c;
            List<RecommendForumInfo> list = dVar.f19982a;
            this.f19976b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f19976b) {
                    b bVar = new b();
                    bVar.t(recommendForumInfo);
                    this.f19975a.add(bVar);
                }
            }
            Page page = this.f19977c;
            if (page != null) {
                this.f19978d = page.has_more.intValue() == 1;
                this.f19979e = this.f19977c.current_page.intValue();
            }
        }
    }
}
