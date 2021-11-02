package b.a.q0.p0;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f12796a;

    /* renamed from: b  reason: collision with root package name */
    public int f12797b;

    /* renamed from: c  reason: collision with root package name */
    public String f12798c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f12799d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f12800e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f12801f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12802g;

    public e() {
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
