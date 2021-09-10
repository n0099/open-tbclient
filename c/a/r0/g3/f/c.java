package c.a.r0.g3.f;

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
    public List<n> f18673a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f18674b;

    /* renamed from: c  reason: collision with root package name */
    public Page f18675c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18676d;

    /* renamed from: e  reason: collision with root package name */
    public int f18677e;

    /* renamed from: f  reason: collision with root package name */
    public int f18678f;

    /* renamed from: g  reason: collision with root package name */
    public int f18679g;

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
        this.f18673a = new ArrayList();
        this.f18676d = true;
        this.f18677e = 0;
        this.f18678f = 0;
        this.f18679g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18673a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f18683d;
            this.f18675c = dVar.f18682c;
            List<RecommendForumInfo> list = dVar.f18680a;
            this.f18674b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f18674b) {
                    b bVar = new b();
                    bVar.t(recommendForumInfo);
                    this.f18673a.add(bVar);
                }
            }
            Page page = this.f18675c;
            if (page != null) {
                this.f18676d = page.has_more.intValue() == 1;
                this.f18677e = this.f18675c.current_page.intValue();
            }
        }
    }
}
