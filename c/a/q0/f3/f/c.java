package c.a.q0.f3.f;

import c.a.e.l.e.n;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f18139a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f18140b;

    /* renamed from: c  reason: collision with root package name */
    public Page f18141c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18142d;

    /* renamed from: e  reason: collision with root package name */
    public int f18143e;

    /* renamed from: f  reason: collision with root package name */
    public int f18144f;

    /* renamed from: g  reason: collision with root package name */
    public int f18145g;

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
        this.f18139a = new ArrayList();
        this.f18142d = true;
        this.f18143e = 0;
        this.f18144f = 0;
        this.f18145g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18139a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f18149d;
            this.f18141c = dVar.f18148c;
            List<RecommendForumInfo> list = dVar.f18146a;
            this.f18140b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f18140b) {
                    b bVar = new b();
                    bVar.t(recommendForumInfo);
                    this.f18139a.add(bVar);
                }
            }
            Page page = this.f18141c;
            if (page != null) {
                this.f18142d = page.has_more.intValue() == 1;
                this.f18143e = this.f18141c.current_page.intValue();
            }
        }
    }
}
