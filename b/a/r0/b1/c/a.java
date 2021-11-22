package b.a.r0.b1.c;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.k0;
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
    public long f16420a;

    /* renamed from: b  reason: collision with root package name */
    public long f16421b;

    /* renamed from: c  reason: collision with root package name */
    public b f16422c;

    /* renamed from: d  reason: collision with root package name */
    public c f16423d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C0818a> f16424e;

    /* renamed from: f  reason: collision with root package name */
    public long f16425f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f16426g;

    /* renamed from: h  reason: collision with root package name */
    public int f16427h;

    /* renamed from: b.a.r0.b1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0818a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f16428a;

        /* renamed from: b  reason: collision with root package name */
        public String f16429b;

        /* renamed from: c  reason: collision with root package name */
        public String f16430c;

        /* renamed from: d  reason: collision with root package name */
        public String f16431d;

        /* renamed from: e  reason: collision with root package name */
        public long f16432e;

        /* renamed from: f  reason: collision with root package name */
        public long f16433f;

        /* renamed from: g  reason: collision with root package name */
        public long f16434g;

        /* renamed from: h  reason: collision with root package name */
        public int f16435h;

        /* renamed from: i  reason: collision with root package name */
        public String f16436i;
        public int j;
        public String k;

        public C0818a() {
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
        public int f16437a;

        /* renamed from: b  reason: collision with root package name */
        public int f16438b;

        /* renamed from: c  reason: collision with root package name */
        public int f16439c;

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
        public String f16440a;

        /* renamed from: b  reason: collision with root package name */
        public String f16441b;

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

    public ArrayList<C0818a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16424e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16420a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16422c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16423d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16421b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f16420a = dataRes.total_num.intValue();
        this.f16421b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f16425f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f16426g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f14160a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f16426g.f14161b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f16422c = bVar;
            bVar.f16437a = dataRes.page.cur_page.intValue();
            this.f16422c.f16438b = dataRes.page.has_more.intValue();
            this.f16422c.f16439c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f16423d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f16440a = presentmoneytxt.txt;
            cVar.f16441b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f16424e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C0818a c0818a = new C0818a();
                    c0818a.j = i2 + 1;
                    c0818a.f16428a = presentMyList.pay_userid.longValue();
                    c0818a.f16429b = presentMyList.pay_username;
                    c0818a.f16430c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c0818a.f16431d = presentMyList.thumbnail_url;
                    c0818a.f16432e = presentMyList.create_time.intValue();
                    c0818a.f16433f = presentMyList.num.intValue();
                    c0818a.f16435h = presentMyList.currency_unit.intValue();
                    c0818a.f16436i = presentMyList.currency_type;
                    c0818a.f16434g = presentMyList.present_scores.longValue();
                    c0818a.k = presentMyList.name_show;
                    this.f16424e.add(c0818a);
                }
            }
        }
        this.f16427h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C0818a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f16424e = arrayList;
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f16420a = j;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f16422c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f16423d = cVar;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f16421b = j;
        }
    }
}
