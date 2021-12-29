package c.a.s0.r0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f13292b;

    /* renamed from: c  reason: collision with root package name */
    public String f13293c;

    /* renamed from: d  reason: collision with root package name */
    public Long f13294d;

    /* renamed from: e  reason: collision with root package name */
    public c f13295e;

    /* renamed from: f  reason: collision with root package name */
    public int f13296f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13297g;

    public g(Context context, int i2, String str, Long l, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, l, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13297g = false;
        this.a = context;
        this.f13292b = i2;
        this.f13293c = str;
        this.f13294d = l;
        this.f13295e = cVar;
    }
}
