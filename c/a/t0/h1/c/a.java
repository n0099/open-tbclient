package c.a.t0.h1.c;

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
    public long f18489b;

    /* renamed from: c  reason: collision with root package name */
    public b f18490c;

    /* renamed from: d  reason: collision with root package name */
    public c f18491d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1113a> f18492e;

    /* renamed from: f  reason: collision with root package name */
    public long f18493f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f18494g;

    /* renamed from: h  reason: collision with root package name */
    public int f18495h;

    /* renamed from: c.a.t0.h1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1113a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f18496b;

        /* renamed from: c  reason: collision with root package name */
        public String f18497c;

        /* renamed from: d  reason: collision with root package name */
        public String f18498d;

        /* renamed from: e  reason: collision with root package name */
        public long f18499e;

        /* renamed from: f  reason: collision with root package name */
        public long f18500f;

        /* renamed from: g  reason: collision with root package name */
        public long f18501g;

        /* renamed from: h  reason: collision with root package name */
        public int f18502h;

        /* renamed from: i  reason: collision with root package name */
        public String f18503i;

        /* renamed from: j  reason: collision with root package name */
        public int f18504j;

        /* renamed from: k  reason: collision with root package name */
        public String f18505k;

        public C1113a() {
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
        public int f18506b;

        /* renamed from: c  reason: collision with root package name */
        public int f18507c;

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
        public String f18508b;

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

    public ArrayList<C1113a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18492e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18490c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18491d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18489b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = dataRes.total_num.intValue();
        this.f18489b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f18493f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f18494g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f18494g.f13757b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f18490c = bVar;
            bVar.a = dataRes.page.cur_page.intValue();
            this.f18490c.f18506b = dataRes.page.has_more.intValue();
            this.f18490c.f18507c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f18491d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.a = presentmoneytxt.txt;
            cVar.f18508b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f18492e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1113a c1113a = new C1113a();
                    c1113a.f18504j = i2 + 1;
                    c1113a.a = presentMyList.pay_userid.longValue();
                    c1113a.f18496b = presentMyList.pay_username;
                    c1113a.f18497c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1113a.f18498d = presentMyList.thumbnail_url;
                    c1113a.f18499e = presentMyList.create_time.intValue();
                    c1113a.f18500f = presentMyList.num.intValue();
                    c1113a.f18502h = presentMyList.currency_unit.intValue();
                    c1113a.f18503i = presentMyList.currency_type;
                    c1113a.f18501g = presentMyList.present_scores.longValue();
                    c1113a.f18505k = presentMyList.name_show;
                    this.f18492e.add(c1113a);
                }
            }
        }
        this.f18495h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1113a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f18492e = arrayList;
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
            this.f18490c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f18491d = cVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f18489b = j2;
        }
    }
}
