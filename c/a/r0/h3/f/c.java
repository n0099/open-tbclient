package c.a.r0.h3.f;

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
    public List<n> f18853a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f18854b;

    /* renamed from: c  reason: collision with root package name */
    public Page f18855c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18856d;

    /* renamed from: e  reason: collision with root package name */
    public int f18857e;

    /* renamed from: f  reason: collision with root package name */
    public int f18858f;

    /* renamed from: g  reason: collision with root package name */
    public int f18859g;

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
        this.f18853a = new ArrayList();
        this.f18856d = true;
        this.f18857e = 0;
        this.f18858f = 0;
        this.f18859g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18853a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f18863d;
            this.f18855c = dVar.f18862c;
            List<RecommendForumInfo> list = dVar.f18860a;
            this.f18854b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f18854b) {
                    b bVar = new b();
                    bVar.t(recommendForumInfo);
                    this.f18853a.add(bVar);
                }
            }
            Page page = this.f18855c;
            if (page != null) {
                this.f18856d = page.has_more.intValue() == 1;
                this.f18857e = this.f18855c.current_page.intValue();
            }
        }
    }
}
