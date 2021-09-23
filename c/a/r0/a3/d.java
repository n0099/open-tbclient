package c.a.r0.a3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15842a;

    /* renamed from: b  reason: collision with root package name */
    public String f15843b;

    /* renamed from: c  reason: collision with root package name */
    public String f15844c;

    /* renamed from: d  reason: collision with root package name */
    public String f15845d;

    /* renamed from: e  reason: collision with root package name */
    public String f15846e;

    /* renamed from: f  reason: collision with root package name */
    public String f15847f;

    /* renamed from: g  reason: collision with root package name */
    public int f15848g;

    /* renamed from: h  reason: collision with root package name */
    public int f15849h;

    /* renamed from: i  reason: collision with root package name */
    public int f15850i;

    /* renamed from: j  reason: collision with root package name */
    public String f15851j;
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
            dVar.f15850i = 0;
            dVar.f15848g = 4;
            dVar.f15849h = 4;
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
        this.f15845d = msgContent.title;
        this.q = msgContent.url;
        this.f15847f = msgContent.src;
        this.f15846e = msgContent.text;
        a(this);
    }
}
