package c.a.r0.h1.c;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.k0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.presentMoneyTxt;
import tbclient.PresentMyList;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f17532b;

    /* renamed from: c  reason: collision with root package name */
    public b f17533c;

    /* renamed from: d  reason: collision with root package name */
    public c f17534d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1041a> f17535e;

    /* renamed from: f  reason: collision with root package name */
    public long f17536f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f17537g;

    /* renamed from: h  reason: collision with root package name */
    public int f17538h;

    /* renamed from: c.a.r0.h1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1041a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f17539b;

        /* renamed from: c  reason: collision with root package name */
        public String f17540c;

        /* renamed from: d  reason: collision with root package name */
        public String f17541d;

        /* renamed from: e  reason: collision with root package name */
        public long f17542e;

        /* renamed from: f  reason: collision with root package name */
        public long f17543f;

        /* renamed from: g  reason: collision with root package name */
        public long f17544g;

        /* renamed from: h  reason: collision with root package name */
        public int f17545h;

        /* renamed from: i  reason: collision with root package name */
        public String f17546i;

        /* renamed from: j  reason: collision with root package name */
        public int f17547j;

        /* renamed from: k  reason: collision with root package name */
        public String f17548k;

        public C1041a() {
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

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f17549b;

        /* renamed from: c  reason: collision with root package name */
        public int f17550c;

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

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f17551b;

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

    public ArrayList<C1041a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17535e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17533c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17534d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17532b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = dataRes.total_num.intValue();
        this.f17532b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f17536f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f17537g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f17537g.f13001b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f17533c = bVar;
            bVar.a = dataRes.page.cur_page.intValue();
            this.f17533c.f17549b = dataRes.page.has_more.intValue();
            this.f17533c.f17550c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f17534d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.a = presentmoneytxt.txt;
            cVar.f17551b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f17535e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1041a c1041a = new C1041a();
                    c1041a.f17547j = i2 + 1;
                    c1041a.a = presentMyList.pay_userid.longValue();
                    c1041a.f17539b = presentMyList.pay_username;
                    c1041a.f17540c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1041a.f17541d = presentMyList.thumbnail_url;
                    c1041a.f17542e = presentMyList.create_time.intValue();
                    c1041a.f17543f = presentMyList.num.intValue();
                    c1041a.f17545h = presentMyList.currency_unit.intValue();
                    c1041a.f17546i = presentMyList.currency_type;
                    c1041a.f17544g = presentMyList.present_scores.longValue();
                    c1041a.f17548k = presentMyList.name_show;
                    this.f17535e.add(c1041a);
                }
            }
        }
        this.f17538h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1041a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f17535e = arrayList;
        }
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.a = j2;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f17533c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f17534d = cVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f17532b = j2;
        }
    }
}
