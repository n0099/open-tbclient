package c.a.r0.q3.f;

import c.a.d.m.e.n;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f22624b;

    /* renamed from: c  reason: collision with root package name */
    public Page f22625c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22626d;

    /* renamed from: e  reason: collision with root package name */
    public int f22627e;

    /* renamed from: f  reason: collision with root package name */
    public int f22628f;

    /* renamed from: g  reason: collision with root package name */
    public int f22629g;

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
        this.f22626d = true;
        this.f22627e = 0;
        this.f22628f = 0;
        this.f22629g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f22632d;
            this.f22625c = dVar.f22631c;
            List<RecommendForumInfo> list = dVar.a;
            this.f22624b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f22624b) {
                    b bVar = new b();
                    bVar.t(recommendForumInfo);
                    this.a.add(bVar);
                }
            }
            Page page = this.f22625c;
            if (page != null) {
                this.f22626d = page.has_more.intValue() == 1;
                this.f22627e = this.f22625c.current_page.intValue();
            }
        }
    }
}
