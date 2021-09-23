package c.a.q0.u;

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
    public String f15036a;

    /* renamed from: b  reason: collision with root package name */
    public String f15037b;

    /* renamed from: c  reason: collision with root package name */
    public String f15038c;

    /* renamed from: d  reason: collision with root package name */
    public int f15039d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15040e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15041f;

    /* renamed from: g  reason: collision with root package name */
    public String f15042g;

    /* renamed from: h  reason: collision with root package name */
    public List<FrsTabItemData> f15043h;

    /* renamed from: i  reason: collision with root package name */
    public PostPrefixData f15044i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15045j;

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
