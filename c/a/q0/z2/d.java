package c.a.q0.z2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29343a;

    /* renamed from: b  reason: collision with root package name */
    public String f29344b;

    /* renamed from: c  reason: collision with root package name */
    public String f29345c;

    /* renamed from: d  reason: collision with root package name */
    public String f29346d;

    /* renamed from: e  reason: collision with root package name */
    public String f29347e;

    /* renamed from: f  reason: collision with root package name */
    public String f29348f;

    /* renamed from: g  reason: collision with root package name */
    public int f29349g;

    /* renamed from: h  reason: collision with root package name */
    public int f29350h;

    /* renamed from: i  reason: collision with root package name */
    public int f29351i;

    /* renamed from: j  reason: collision with root package name */
    public String f29352j;
    public String k;
    public long l;
    public long m;
    public boolean n;
    public boolean o;
    public int p;
    public String q;
    public String r;
    public long s;
    public long t;

    public d() {
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
        this.k = "";
    }

    public static void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            dVar.f29351i = 0;
            dVar.f29349g = 4;
            dVar.f29350h = 4;
            dVar.l = System.currentTimeMillis();
            dVar.n = true;
        }
    }

    public d(MsgContent msgContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgContent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = "";
        this.f29346d = msgContent.title;
        this.q = msgContent.url;
        this.f29348f = msgContent.src;
        this.f29347e = msgContent.text;
        a(this);
    }
}
