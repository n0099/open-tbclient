package c.a.r0.b1.c;

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
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f15908a;

    /* renamed from: b  reason: collision with root package name */
    public long f15909b;

    /* renamed from: c  reason: collision with root package name */
    public b f15910c;

    /* renamed from: d  reason: collision with root package name */
    public c f15911d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C0759a> f15912e;

    /* renamed from: f  reason: collision with root package name */
    public long f15913f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f15914g;

    /* renamed from: h  reason: collision with root package name */
    public int f15915h;

    /* renamed from: c.a.r0.b1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0759a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15916a;

        /* renamed from: b  reason: collision with root package name */
        public String f15917b;

        /* renamed from: c  reason: collision with root package name */
        public String f15918c;

        /* renamed from: d  reason: collision with root package name */
        public String f15919d;

        /* renamed from: e  reason: collision with root package name */
        public long f15920e;

        /* renamed from: f  reason: collision with root package name */
        public long f15921f;

        /* renamed from: g  reason: collision with root package name */
        public long f15922g;

        /* renamed from: h  reason: collision with root package name */
        public int f15923h;

        /* renamed from: i  reason: collision with root package name */
        public String f15924i;

        /* renamed from: j  reason: collision with root package name */
        public int f15925j;
        public String k;

        public C0759a() {
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

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f15926a;

        /* renamed from: b  reason: collision with root package name */
        public int f15927b;

        /* renamed from: c  reason: collision with root package name */
        public int f15928c;

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

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f15929a;

        /* renamed from: b  reason: collision with root package name */
        public String f15930b;

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

    public ArrayList<C0759a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15912e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15908a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15910c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15911d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15909b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f15908a = dataRes.total_num.intValue();
        this.f15909b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f15913f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f15914g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f14267a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f15914g.f14268b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f15910c = bVar;
            bVar.f15926a = dataRes.page.cur_page.intValue();
            this.f15910c.f15927b = dataRes.page.has_more.intValue();
            this.f15910c.f15928c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f15911d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f15929a = presentmoneytxt.txt;
            cVar.f15930b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f15912e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C0759a c0759a = new C0759a();
                    c0759a.f15925j = i2 + 1;
                    c0759a.f15916a = presentMyList.pay_userid.longValue();
                    c0759a.f15917b = presentMyList.pay_username;
                    c0759a.f15918c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c0759a.f15919d = presentMyList.thumbnail_url;
                    c0759a.f15920e = presentMyList.create_time.intValue();
                    c0759a.f15921f = presentMyList.num.intValue();
                    c0759a.f15923h = presentMyList.currency_unit.intValue();
                    c0759a.f15924i = presentMyList.currency_type;
                    c0759a.f15922g = presentMyList.present_scores.longValue();
                    c0759a.k = presentMyList.name_show;
                    this.f15912e.add(c0759a);
                }
            }
        }
        this.f15915h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C0759a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f15912e = arrayList;
        }
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f15908a = j2;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f15910c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f15911d = cVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f15909b = j2;
        }
    }
}
