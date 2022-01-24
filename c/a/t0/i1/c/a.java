package c.a.t0.i1.c;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.k0;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f18348b;

    /* renamed from: c  reason: collision with root package name */
    public b f18349c;

    /* renamed from: d  reason: collision with root package name */
    public c f18350d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1143a> f18351e;

    /* renamed from: f  reason: collision with root package name */
    public long f18352f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f18353g;

    /* renamed from: h  reason: collision with root package name */
    public int f18354h;

    /* renamed from: c.a.t0.i1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1143a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f18355b;

        /* renamed from: c  reason: collision with root package name */
        public String f18356c;

        /* renamed from: d  reason: collision with root package name */
        public String f18357d;

        /* renamed from: e  reason: collision with root package name */
        public long f18358e;

        /* renamed from: f  reason: collision with root package name */
        public long f18359f;

        /* renamed from: g  reason: collision with root package name */
        public long f18360g;

        /* renamed from: h  reason: collision with root package name */
        public int f18361h;

        /* renamed from: i  reason: collision with root package name */
        public String f18362i;

        public C1143a() {
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

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f18363b;

        /* renamed from: c  reason: collision with root package name */
        public int f18364c;

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

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f18365b;

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

    public ArrayList<C1143a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18351e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18349c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18350d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18348b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = dataRes.total_num.intValue();
        this.f18348b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f18352f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f18353g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f18353g.f13629b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f18349c = bVar;
            bVar.a = dataRes.page.cur_page.intValue();
            this.f18349c.f18363b = dataRes.page.has_more.intValue();
            this.f18349c.f18364c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f18350d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.a = presentmoneytxt.txt;
            cVar.f18365b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f18351e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1143a c1143a = new C1143a();
                    c1143a.f18361h = i2 + 1;
                    c1143a.a = presentMyList.pay_userid.longValue();
                    c1143a.f18355b = presentMyList.pay_username;
                    c1143a.f18356c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1143a.f18357d = presentMyList.thumbnail_url;
                    c1143a.f18358e = presentMyList.create_time.intValue();
                    c1143a.f18359f = presentMyList.num.intValue();
                    presentMyList.currency_unit.intValue();
                    String str5 = presentMyList.currency_type;
                    c1143a.f18360g = presentMyList.present_scores.longValue();
                    c1143a.f18362i = presentMyList.name_show;
                    this.f18351e.add(c1143a);
                }
            }
        }
        this.f18354h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1143a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f18351e = arrayList;
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
            this.f18349c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f18350d = cVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f18348b = j2;
        }
    }
}
