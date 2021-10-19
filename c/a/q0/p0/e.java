package c.a.q0.p0;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f13662a;

    /* renamed from: b  reason: collision with root package name */
    public int f13663b;

    /* renamed from: c  reason: collision with root package name */
    public String f13664c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f13665d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f13666e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f13667f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13668g;

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
