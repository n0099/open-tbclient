package c.a.p0.u;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15024a;

    /* renamed from: b  reason: collision with root package name */
    public String f15025b;

    /* renamed from: c  reason: collision with root package name */
    public String f15026c;

    /* renamed from: d  reason: collision with root package name */
    public int f15027d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15028e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15029f;

    /* renamed from: g  reason: collision with root package name */
    public String f15030g;

    /* renamed from: h  reason: collision with root package name */
    public List<FrsTabItemData> f15031h;

    /* renamed from: i  reason: collision with root package name */
    public PostPrefixData f15032i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15033j;

    public i() {
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
}
