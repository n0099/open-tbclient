package c.a.r0.a1.c;

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
    public long f15742a;

    /* renamed from: b  reason: collision with root package name */
    public long f15743b;

    /* renamed from: c  reason: collision with root package name */
    public b f15744c;

    /* renamed from: d  reason: collision with root package name */
    public c f15745d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C0753a> f15746e;

    /* renamed from: f  reason: collision with root package name */
    public long f15747f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f15748g;

    /* renamed from: h  reason: collision with root package name */
    public int f15749h;

    /* renamed from: c.a.r0.a1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0753a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15750a;

        /* renamed from: b  reason: collision with root package name */
        public String f15751b;

        /* renamed from: c  reason: collision with root package name */
        public String f15752c;

        /* renamed from: d  reason: collision with root package name */
        public String f15753d;

        /* renamed from: e  reason: collision with root package name */
        public long f15754e;

        /* renamed from: f  reason: collision with root package name */
        public long f15755f;

        /* renamed from: g  reason: collision with root package name */
        public long f15756g;

        /* renamed from: h  reason: collision with root package name */
        public int f15757h;

        /* renamed from: i  reason: collision with root package name */
        public String f15758i;

        /* renamed from: j  reason: collision with root package name */
        public int f15759j;
        public String k;

        public C0753a() {
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
        public int f15760a;

        /* renamed from: b  reason: collision with root package name */
        public int f15761b;

        /* renamed from: c  reason: collision with root package name */
        public int f15762c;

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
        public String f15763a;

        /* renamed from: b  reason: collision with root package name */
        public String f15764b;

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

    public ArrayList<C0753a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15746e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15742a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15744c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15745d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15743b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f15742a = dataRes.total_num.intValue();
        this.f15743b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f15747f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f15748g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f14244a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f15748g.f14245b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f15744c = bVar;
            bVar.f15760a = dataRes.page.cur_page.intValue();
            this.f15744c.f15761b = dataRes.page.has_more.intValue();
            this.f15744c.f15762c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f15745d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f15763a = presentmoneytxt.txt;
            cVar.f15764b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f15746e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C0753a c0753a = new C0753a();
                    c0753a.f15759j = i2 + 1;
                    c0753a.f15750a = presentMyList.pay_userid.longValue();
                    c0753a.f15751b = presentMyList.pay_username;
                    c0753a.f15752c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c0753a.f15753d = presentMyList.thumbnail_url;
                    c0753a.f15754e = presentMyList.create_time.intValue();
                    c0753a.f15755f = presentMyList.num.intValue();
                    c0753a.f15757h = presentMyList.currency_unit.intValue();
                    c0753a.f15758i = presentMyList.currency_type;
                    c0753a.f15756g = presentMyList.present_scores.longValue();
                    c0753a.k = presentMyList.name_show;
                    this.f15746e.add(c0753a);
                }
            }
        }
        this.f15749h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C0753a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f15746e = arrayList;
        }
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f15742a = j2;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f15744c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f15745d = cVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f15743b = j2;
        }
    }
}
