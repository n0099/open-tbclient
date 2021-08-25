package c.a.q0.z0.c;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.k0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f29253a;

    /* renamed from: b  reason: collision with root package name */
    public long f29254b;

    /* renamed from: c  reason: collision with root package name */
    public b f29255c;

    /* renamed from: d  reason: collision with root package name */
    public c f29256d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1360a> f29257e;

    /* renamed from: f  reason: collision with root package name */
    public long f29258f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f29259g;

    /* renamed from: h  reason: collision with root package name */
    public int f29260h;

    /* renamed from: c.a.q0.z0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1360a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f29261a;

        /* renamed from: b  reason: collision with root package name */
        public String f29262b;

        /* renamed from: c  reason: collision with root package name */
        public String f29263c;

        /* renamed from: d  reason: collision with root package name */
        public String f29264d;

        /* renamed from: e  reason: collision with root package name */
        public long f29265e;

        /* renamed from: f  reason: collision with root package name */
        public long f29266f;

        /* renamed from: g  reason: collision with root package name */
        public long f29267g;

        /* renamed from: h  reason: collision with root package name */
        public int f29268h;

        /* renamed from: i  reason: collision with root package name */
        public String f29269i;

        /* renamed from: j  reason: collision with root package name */
        public int f29270j;
        public String k;

        public C1360a() {
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

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f29271a;

        /* renamed from: b  reason: collision with root package name */
        public int f29272b;

        /* renamed from: c  reason: collision with root package name */
        public int f29273c;

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
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f29274a;

        /* renamed from: b  reason: collision with root package name */
        public String f29275b;

        public c() {
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

    public a() {
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

    public ArrayList<C1360a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29257e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29253a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29255c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29256d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29254b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f29253a = dataRes.total_num.intValue();
        this.f29254b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f29258f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f29259g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f14282a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f29259g.f14283b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f29255c = bVar;
            bVar.f29271a = dataRes.page.cur_page.intValue();
            this.f29255c.f29272b = dataRes.page.has_more.intValue();
            this.f29255c.f29273c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f29256d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f29274a = presentmoneytxt.txt;
            cVar.f29275b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f29257e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1360a c1360a = new C1360a();
                    c1360a.f29270j = i2 + 1;
                    c1360a.f29261a = presentMyList.pay_userid.longValue();
                    c1360a.f29262b = presentMyList.pay_username;
                    c1360a.f29263c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1360a.f29264d = presentMyList.thumbnail_url;
                    c1360a.f29265e = presentMyList.create_time.intValue();
                    c1360a.f29266f = presentMyList.num.intValue();
                    c1360a.f29268h = presentMyList.currency_unit.intValue();
                    c1360a.f29269i = presentMyList.currency_type;
                    c1360a.f29267g = presentMyList.present_scores.longValue();
                    c1360a.k = presentMyList.name_show;
                    this.f29257e.add(c1360a);
                }
            }
        }
        this.f29260h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1360a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f29257e = arrayList;
        }
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f29253a = j2;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f29255c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f29256d = cVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f29254b = j2;
        }
    }
}
