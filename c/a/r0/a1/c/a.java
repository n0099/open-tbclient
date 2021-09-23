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
    public long f15752a;

    /* renamed from: b  reason: collision with root package name */
    public long f15753b;

    /* renamed from: c  reason: collision with root package name */
    public b f15754c;

    /* renamed from: d  reason: collision with root package name */
    public c f15755d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C0751a> f15756e;

    /* renamed from: f  reason: collision with root package name */
    public long f15757f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f15758g;

    /* renamed from: h  reason: collision with root package name */
    public int f15759h;

    /* renamed from: c.a.r0.a1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0751a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15760a;

        /* renamed from: b  reason: collision with root package name */
        public String f15761b;

        /* renamed from: c  reason: collision with root package name */
        public String f15762c;

        /* renamed from: d  reason: collision with root package name */
        public String f15763d;

        /* renamed from: e  reason: collision with root package name */
        public long f15764e;

        /* renamed from: f  reason: collision with root package name */
        public long f15765f;

        /* renamed from: g  reason: collision with root package name */
        public long f15766g;

        /* renamed from: h  reason: collision with root package name */
        public int f15767h;

        /* renamed from: i  reason: collision with root package name */
        public String f15768i;

        /* renamed from: j  reason: collision with root package name */
        public int f15769j;
        public String k;

        public C0751a() {
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
        public int f15770a;

        /* renamed from: b  reason: collision with root package name */
        public int f15771b;

        /* renamed from: c  reason: collision with root package name */
        public int f15772c;

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
        public String f15773a;

        /* renamed from: b  reason: collision with root package name */
        public String f15774b;

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

    public ArrayList<C0751a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15756e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15752a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15754c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15755d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15753b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f15752a = dataRes.total_num.intValue();
        this.f15753b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f15757f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f15758g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f14244a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f15758g.f14245b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f15754c = bVar;
            bVar.f15770a = dataRes.page.cur_page.intValue();
            this.f15754c.f15771b = dataRes.page.has_more.intValue();
            this.f15754c.f15772c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f15755d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f15773a = presentmoneytxt.txt;
            cVar.f15774b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f15756e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C0751a c0751a = new C0751a();
                    c0751a.f15769j = i2 + 1;
                    c0751a.f15760a = presentMyList.pay_userid.longValue();
                    c0751a.f15761b = presentMyList.pay_username;
                    c0751a.f15762c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c0751a.f15763d = presentMyList.thumbnail_url;
                    c0751a.f15764e = presentMyList.create_time.intValue();
                    c0751a.f15765f = presentMyList.num.intValue();
                    c0751a.f15767h = presentMyList.currency_unit.intValue();
                    c0751a.f15768i = presentMyList.currency_type;
                    c0751a.f15766g = presentMyList.present_scores.longValue();
                    c0751a.k = presentMyList.name_show;
                    this.f15756e.add(c0751a);
                }
            }
        }
        this.f15759h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C0751a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f15756e = arrayList;
        }
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f15752a = j2;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f15754c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f15755d = cVar;
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.f15753b = j2;
        }
    }
}
