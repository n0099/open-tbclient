package c.a.q0.x.x;

import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15209a;

    /* renamed from: b  reason: collision with root package name */
    public String f15210b;

    /* renamed from: c  reason: collision with root package name */
    public SpanGroupManager f15211c;

    /* renamed from: d  reason: collision with root package name */
    public String f15212d;

    /* renamed from: e  reason: collision with root package name */
    public String f15213e;

    public j() {
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
