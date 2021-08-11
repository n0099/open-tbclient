package c.a.p0.f1.f.a.e;

import androidx.annotation.NonNull;
import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class e implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f17234e;

    /* renamed from: f  reason: collision with root package name */
    public String f17235f;

    /* renamed from: g  reason: collision with root package name */
    public int f17236g;

    /* renamed from: h  reason: collision with root package name */
    public String f17237h;

    /* renamed from: i  reason: collision with root package name */
    public int f17238i;

    /* renamed from: j  reason: collision with root package name */
    public c2 f17239j;

    public e(@NonNull ThreadInfo threadInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadInfo, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17234e = i2 + 1;
        this.f17235f = threadInfo.title;
        this.f17236g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f17237h = threadInfo.media.get(0).src_pic;
            this.f17238i = threadInfo.media.get(0).during_time.intValue();
        }
        c2 c2Var = new c2();
        this.f17239j = c2Var;
        c2Var.d2 = true;
        c2Var.S2(threadInfo);
    }

    @Override // c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f17225b : (BdUniqueId) invokeV.objValue;
    }
}
