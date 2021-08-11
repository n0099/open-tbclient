package c.a.p0.z0.c;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.k0;
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
    public long f28912a;

    /* renamed from: b  reason: collision with root package name */
    public long f28913b;

    /* renamed from: c  reason: collision with root package name */
    public b f28914c;

    /* renamed from: d  reason: collision with root package name */
    public c f28915d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1350a> f28916e;

    /* renamed from: f  reason: collision with root package name */
    public long f28917f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f28918g;

    /* renamed from: h  reason: collision with root package name */
    public int f28919h;

    /* renamed from: c.a.p0.z0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1350a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f28920a;

        /* renamed from: b  reason: collision with root package name */
        public String f28921b;

        /* renamed from: c  reason: collision with root package name */
        public String f28922c;

        /* renamed from: d  reason: collision with root package name */
        public String f28923d;

        /* renamed from: e  reason: collision with root package name */
        public long f28924e;

        /* renamed from: f  reason: collision with root package name */
        public long f28925f;

        /* renamed from: g  reason: collision with root package name */
        public long f28926g;

        /* renamed from: h  reason: collision with root package name */
        public int f28927h;

        /* renamed from: i  reason: collision with root package name */
        public String f28928i;

        /* renamed from: j  reason: collision with root package name */
        public int f28929j;
        public String k;

        public C1350a() {
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
        public int f28930a;

        /* renamed from: b  reason: collision with root package name */
        public int f28931b;

        /* renamed from: c  reason: collision with root package name */
        public int f28932c;

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
        public String f28933a;

        /* renamed from: b  reason: collision with root package name */
        public String f28934b;

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

    public ArrayList<C1350a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28916e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28912a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28914c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28915d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28913b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f28912a = dataRes.total_num.intValue();
        this.f28913b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f28917f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f28918g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f13976a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f28918g.f13977b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f28914c = bVar;
            bVar.f28930a = dataRes.page.cur_page.intValue();
            this.f28914c.f28931b = dataRes.page.has_more.intValue();
            this.f28914c.f28932c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f28915d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f28933a = presentmoneytxt.txt;
            cVar.f28934b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f28916e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1350a c1350a = new C1350a();
                    c1350a.f28929j = i2 + 1;
                    c1350a.f28920a = presentMyList.pay_userid.longValue();
                    c1350a.f28921b = presentMyList.pay_username;
                    c1350a.f28922c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1350a.f28923d = presentMyList.thumbnail_url;
                    c1350a.f28924e = presentMyList.create_time.intValue();
                    c1350a.f28925f = presentMyList.num.intValue();
                    c1350a.f28927h = presentMyList.currency_unit.intValue();
                    c1350a.f28928i = presentMyList.currency_type;
                    c1350a.f28926g = presentMyList.present_scores.longValue();
                    c1350a.k = presentMyList.name_show;
                    this.f28916e.add(c1350a);
                }
            }
        }
        this.f28919h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1350a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f28916e = arrayList;
        }
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f28912a = j2;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f28914c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f28915d = cVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f28913b = j2;
        }
    }
}
