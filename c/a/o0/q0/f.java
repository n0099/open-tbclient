package c.a.o0.q0;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public int f10472b;

    /* renamed from: c  reason: collision with root package name */
    public String f10473c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f10474d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f10475e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f10476f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10477g;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
