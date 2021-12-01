package c.a.r0.j3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18384b;

    /* renamed from: c  reason: collision with root package name */
    public String f18385c;

    /* renamed from: d  reason: collision with root package name */
    public String f18386d;

    /* renamed from: e  reason: collision with root package name */
    public String f18387e;

    /* renamed from: f  reason: collision with root package name */
    public String f18388f;

    /* renamed from: g  reason: collision with root package name */
    public int f18389g;

    /* renamed from: h  reason: collision with root package name */
    public int f18390h;

    /* renamed from: i  reason: collision with root package name */
    public int f18391i;

    /* renamed from: j  reason: collision with root package name */
    public String f18392j;

    /* renamed from: k  reason: collision with root package name */
    public String f18393k;
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
        this.f18393k = "";
    }

    public static void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            dVar.f18391i = 0;
            dVar.f18389g = 4;
            dVar.f18390h = 4;
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
        this.f18393k = "";
        this.f18386d = msgContent.title;
        this.q = msgContent.url;
        this.f18388f = msgContent.src;
        this.f18387e = msgContent.text;
        a(this);
    }
}
