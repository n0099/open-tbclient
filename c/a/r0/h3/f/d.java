package c.a.r0.h3.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f18860a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f18861b;

    /* renamed from: c  reason: collision with root package name */
    public Page f18862c;

    /* renamed from: d  reason: collision with root package name */
    public String f18863d;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f18863d = dataRes.class_name;
        this.f18862c = dataRes.page;
        this.f18861b = dataRes.page_structure;
        this.f18860a = dataRes.forum_info;
    }
}
