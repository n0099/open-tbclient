package c.a.p0.m0.i.c;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f21722a;

    /* renamed from: b  reason: collision with root package name */
    public String f21723b;

    /* renamed from: c  reason: collision with root package name */
    public String f21724c;

    /* renamed from: d  reason: collision with root package name */
    public String f21725d;

    /* renamed from: e  reason: collision with root package name */
    public String f21726e;

    /* renamed from: f  reason: collision with root package name */
    public MetaData f21727f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21728g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21729h;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21728g = false;
        this.f21729h = false;
    }
}
