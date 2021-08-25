package c.a.q0.f1.f.a.e;

import androidx.annotation.NonNull;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
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
    public int f17579e;

    /* renamed from: f  reason: collision with root package name */
    public String f17580f;

    /* renamed from: g  reason: collision with root package name */
    public int f17581g;

    /* renamed from: h  reason: collision with root package name */
    public String f17582h;

    /* renamed from: i  reason: collision with root package name */
    public int f17583i;

    /* renamed from: j  reason: collision with root package name */
    public c2 f17584j;

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
        this.f17579e = i2 + 1;
        this.f17580f = threadInfo.title;
        this.f17581g = threadInfo.hot_num.intValue();
        if (!ListUtils.isEmpty(threadInfo.media)) {
            this.f17582h = threadInfo.media.get(0).src_pic;
            this.f17583i = threadInfo.media.get(0).during_time.intValue();
        }
        c2 c2Var = new c2();
        this.f17584j = c2Var;
        c2Var.d2 = true;
        c2Var.S2(threadInfo);
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f17570b : (BdUniqueId) invokeV.objValue;
    }
}
