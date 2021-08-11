package c.a.p0.z2;

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
    public String f29002a;

    /* renamed from: b  reason: collision with root package name */
    public String f29003b;

    /* renamed from: c  reason: collision with root package name */
    public String f29004c;

    /* renamed from: d  reason: collision with root package name */
    public String f29005d;

    /* renamed from: e  reason: collision with root package name */
    public String f29006e;

    /* renamed from: f  reason: collision with root package name */
    public String f29007f;

    /* renamed from: g  reason: collision with root package name */
    public int f29008g;

    /* renamed from: h  reason: collision with root package name */
    public int f29009h;

    /* renamed from: i  reason: collision with root package name */
    public int f29010i;

    /* renamed from: j  reason: collision with root package name */
    public String f29011j;
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
            dVar.f29010i = 0;
            dVar.f29008g = 4;
            dVar.f29009h = 4;
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
        this.f29005d = msgContent.title;
        this.q = msgContent.url;
        this.f29007f = msgContent.src;
        this.f29006e = msgContent.text;
        a(this);
    }
}
