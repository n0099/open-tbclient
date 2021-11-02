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
    public long f14928a;

    /* renamed from: b  reason: collision with root package name */
    public long f14929b;

    /* renamed from: c  reason: collision with root package name */
    public b f14930c;

    /* renamed from: d  reason: collision with root package name */
    public c f14931d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C0753a> f14932e;

    /* renamed from: f  reason: collision with root package name */
    public long f14933f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f14934g;

    /* renamed from: h  reason: collision with root package name */
    public int f14935h;

    /* renamed from: b.a.r0.b1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0753a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f14936a;

        /* renamed from: b  reason: collision with root package name */
        public String f14937b;

        /* renamed from: c  reason: collision with root package name */
        public String f14938c;

        /* renamed from: d  reason: collision with root package name */
        public String f14939d;

        /* renamed from: e  reason: collision with root package name */
        public long f14940e;

        /* renamed from: f  reason: collision with root package name */
        public long f14941f;

        /* renamed from: g  reason: collision with root package name */
        public long f14942g;

        /* renamed from: h  reason: collision with root package name */
        public int f14943h;

        /* renamed from: i  reason: collision with root package name */
        public String f14944i;
        public int j;
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

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f14945a;

        /* renamed from: b  reason: collision with root package name */
        public int f14946b;

        /* renamed from: c  reason: collision with root package name */
        public int f14947c;

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
        public String f14948a;

        /* renamed from: b  reason: collision with root package name */
        public String f14949b;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14932e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14928a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14930c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14931d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14929b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f14928a = dataRes.total_num.intValue();
        this.f14929b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f14933f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f14934g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f13380a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f14934g.f13381b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f14930c = bVar;
            bVar.f14945a = dataRes.page.cur_page.intValue();
            this.f14930c.f14946b = dataRes.page.has_more.intValue();
            this.f14930c.f14947c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f14931d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f14948a = presentmoneytxt.txt;
            cVar.f14949b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f14932e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C0753a c0753a = new C0753a();
                    c0753a.j = i2 + 1;
                    c0753a.f14936a = presentMyList.pay_userid.longValue();
                    c0753a.f14937b = presentMyList.pay_username;
                    c0753a.f14938c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c0753a.f14939d = presentMyList.thumbnail_url;
                    c0753a.f14940e = presentMyList.create_time.intValue();
                    c0753a.f14941f = presentMyList.num.intValue();
                    c0753a.f14943h = presentMyList.currency_unit.intValue();
                    c0753a.f14944i = presentMyList.currency_type;
                    c0753a.f14942g = presentMyList.present_scores.longValue();
                    c0753a.k = presentMyList.name_show;
                    this.f14932e.add(c0753a);
                }
            }
        }
        this.f14935h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C0753a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f14932e = arrayList;
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f14928a = j;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f14930c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f14931d = cVar;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f14929b = j;
        }
    }
}
