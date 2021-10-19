package c.a.r0.w0.c;

import c.a.e.l.e.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f26502a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f26503b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f26504c;

    /* renamed from: d  reason: collision with root package name */
    public String f26505d;

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26505d = str;
    }

    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26504c : (ArrayList) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f26502a = dataRes.exact_match;
        this.f26503b = dataRes.fuzzy_match;
        this.f26504c = new ArrayList<>();
        b bVar = new b(this.f26505d);
        SearchForum searchForum = this.f26502a;
        if (searchForum != null) {
            bVar.w(searchForum);
            this.f26504c.add(bVar);
        }
        List<SearchForum> list = this.f26503b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f26505d);
                bVar2.w(searchForum2);
                this.f26504c.add(bVar2);
            }
        }
    }
}
