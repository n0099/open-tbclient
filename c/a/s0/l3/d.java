package c.a.s0.l3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f19169b;

    /* renamed from: c  reason: collision with root package name */
    public String f19170c;

    /* renamed from: d  reason: collision with root package name */
    public String f19171d;

    /* renamed from: e  reason: collision with root package name */
    public String f19172e;

    /* renamed from: f  reason: collision with root package name */
    public String f19173f;

    /* renamed from: g  reason: collision with root package name */
    public int f19174g;

    /* renamed from: h  reason: collision with root package name */
    public int f19175h;

    /* renamed from: i  reason: collision with root package name */
    public int f19176i;

    /* renamed from: j  reason: collision with root package name */
    public String f19177j;

    /* renamed from: k  reason: collision with root package name */
    public String f19178k;
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
        this.f19178k = "";
    }

    public static void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            dVar.f19176i = 0;
            dVar.f19174g = 4;
            dVar.f19175h = 4;
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
        this.f19178k = "";
        this.f19171d = msgContent.title;
        this.q = msgContent.url;
        this.f19173f = msgContent.src;
        this.f19172e = msgContent.text;
        a(this);
    }
}
