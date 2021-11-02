package b.a.r0.b3;

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
    public String f15012a;

    /* renamed from: b  reason: collision with root package name */
    public String f15013b;

    /* renamed from: c  reason: collision with root package name */
    public String f15014c;

    /* renamed from: d  reason: collision with root package name */
    public String f15015d;

    /* renamed from: e  reason: collision with root package name */
    public String f15016e;

    /* renamed from: f  reason: collision with root package name */
    public String f15017f;

    /* renamed from: g  reason: collision with root package name */
    public int f15018g;

    /* renamed from: h  reason: collision with root package name */
    public int f15019h;

    /* renamed from: i  reason: collision with root package name */
    public int f15020i;
    public String j;
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
            dVar.f15020i = 0;
            dVar.f15018g = 4;
            dVar.f15019h = 4;
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
        this.f15015d = msgContent.title;
        this.q = msgContent.url;
        this.f15017f = msgContent.src;
        this.f15016e = msgContent.text;
        a(this);
    }
}
