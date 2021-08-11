package c.a.p0.f3.f;

import c.a.e.k.e.n;
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
    public List<n> f17806a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f17807b;

    /* renamed from: c  reason: collision with root package name */
    public Page f17808c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17809d;

    /* renamed from: e  reason: collision with root package name */
    public int f17810e;

    /* renamed from: f  reason: collision with root package name */
    public int f17811f;

    /* renamed from: g  reason: collision with root package name */
    public int f17812g;

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
        this.f17806a = new ArrayList();
        this.f17809d = true;
        this.f17810e = 0;
        this.f17811f = 0;
        this.f17812g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17806a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f17816d;
            this.f17808c = dVar.f17815c;
            List<RecommendForumInfo> list = dVar.f17813a;
            this.f17807b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f17807b) {
                    b bVar = new b();
                    bVar.t(recommendForumInfo);
                    this.f17806a.add(bVar);
                }
            }
            Page page = this.f17808c;
            if (page != null) {
                this.f17809d = page.has_more.intValue() == 1;
                this.f17810e = this.f17808c.current_page.intValue();
            }
        }
    }
}
