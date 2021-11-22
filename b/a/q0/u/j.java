package b.a.q0.u;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14908a;

    /* renamed from: b  reason: collision with root package name */
    public String f14909b;

    /* renamed from: c  reason: collision with root package name */
    public String f14910c;

    /* renamed from: d  reason: collision with root package name */
    public int f14911d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14912e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14913f;

    /* renamed from: g  reason: collision with root package name */
    public String f14914g;

    /* renamed from: h  reason: collision with root package name */
    public List<FrsTabItemData> f14915h;

    /* renamed from: i  reason: collision with root package name */
    public PostPrefixData f14916i;
    public boolean j;

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
