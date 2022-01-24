package c.a.s0.r0;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public int f13110b;

    /* renamed from: c  reason: collision with root package name */
    public String f13111c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f13112d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f13113e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f13114f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13115g;

    public f() {
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
