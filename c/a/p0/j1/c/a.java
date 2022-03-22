package c.a.p0.j1.c;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.k0;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f15593b;

    /* renamed from: c  reason: collision with root package name */
    public b f15594c;

    /* renamed from: d  reason: collision with root package name */
    public c f15595d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1174a> f15596e;

    /* renamed from: f  reason: collision with root package name */
    public long f15597f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f15598g;

    /* renamed from: h  reason: collision with root package name */
    public int f15599h;

    /* renamed from: c.a.p0.j1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1174a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f15600b;

        /* renamed from: c  reason: collision with root package name */
        public String f15601c;

        /* renamed from: d  reason: collision with root package name */
        public String f15602d;

        /* renamed from: e  reason: collision with root package name */
        public long f15603e;

        /* renamed from: f  reason: collision with root package name */
        public long f15604f;

        /* renamed from: g  reason: collision with root package name */
        public long f15605g;

        /* renamed from: h  reason: collision with root package name */
        public int f15606h;
        public String i;

        public C1174a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f15607b;

        /* renamed from: c  reason: collision with root package name */
        public int f15608c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f15609b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ArrayList<C1174a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15596e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15594c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15595d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15593b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = dataRes.total_num.intValue();
        this.f15593b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f15597f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f15598g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f15598g.f10900b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f15594c = bVar;
            bVar.a = dataRes.page.cur_page.intValue();
            this.f15594c.f15607b = dataRes.page.has_more.intValue();
            this.f15594c.f15608c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f15595d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.a = presentmoneytxt.txt;
            cVar.f15609b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f15596e = new ArrayList<>();
            for (int i = 0; i < dataRes.gift_list.size(); i++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i);
                if (presentMyList != null) {
                    C1174a c1174a = new C1174a();
                    c1174a.f15606h = i + 1;
                    c1174a.a = presentMyList.pay_userid.longValue();
                    c1174a.f15600b = presentMyList.pay_username;
                    c1174a.f15601c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1174a.f15602d = presentMyList.thumbnail_url;
                    c1174a.f15603e = presentMyList.create_time.intValue();
                    c1174a.f15604f = presentMyList.num.intValue();
                    presentMyList.currency_unit.intValue();
                    String str5 = presentMyList.currency_type;
                    c1174a.f15605g = presentMyList.present_scores.longValue();
                    c1174a.i = presentMyList.name_show;
                    this.f15596e.add(c1174a);
                }
            }
        }
        this.f15599h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1174a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f15596e = arrayList;
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.a = j;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f15594c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f15595d = cVar;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f15593b = j;
        }
    }
}
