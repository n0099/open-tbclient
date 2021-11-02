package b.a.r0.q1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.d1.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f22569a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ICardInfo> f22570b;

    /* renamed from: c  reason: collision with root package name */
    public int f22571c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22572d;

    /* renamed from: e  reason: collision with root package name */
    public String f22573e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22574f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22575g;

    /* renamed from: h  reason: collision with root package name */
    public final BdListView f22576h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a.r0.q1.n.a f22577i;
    public long j;
    public String k;

    /* loaded from: classes5.dex */
    public class a extends i0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e.e.d.l f22578a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f22579b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22580c;

        public a(h hVar, b.a.e.e.d.l lVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, lVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22578a = lVar;
            this.f22579b = j;
            this.f22580c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.e.e.d.l lVar = this.f22578a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f22579b);
                sb.append("_");
                sb.append(TextUtils.isEmpty(this.f22580c) ? "" : this.f22580c);
                byte[] bArr = (byte[]) lVar.get(sb.toString());
                if (bArr != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e2) {
                        BdLog.e(e2);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f22581a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22581a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f22581a.h(dataRes);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(List<b.a.r0.q1.p.d> list);

        void b(long j, String str);

        void c(int i2, String str);

        void d(String str, String str2, String str3, List<b.a.r0.q1.p.e> list);

        void onError(int i2, String str);

        void onSuccess();
    }

    public h(BdListView bdListView, b.a.r0.q1.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdListView, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22569a = null;
        this.f22570b = new LinkedList();
        this.f22571c = 1;
        this.f22573e = "";
        this.f22574f = false;
        this.f22575g = false;
        this.f22576h = bdListView;
        this.f22577i = aVar;
    }

    public List<ICardInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22570b : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22572d : invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22574f : invokeV.booleanValue;
    }

    public final void e(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j, str) == null) {
            b.a.q0.s.r.a.f();
            l0.b(new a(this, b.a.q0.s.r.a.d("tb.lego_update"), j, str), new b(this));
        }
    }

    public final void f(long j, String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048580, this, j, str) == null) || (cVar = this.f22569a) == null) {
            return;
        }
        cVar.b(j, str);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d() || this.f22569a == null) {
            return;
        }
        this.f22571c++;
        k(true);
        this.f22569a.c(this.f22571c, this.f22573e);
    }

    public final void h(DataRes dataRes) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dataRes) == null) {
            this.f22575g = true;
            if (dataRes != null) {
                if (j(true, dataRes) && (cVar = this.f22569a) != null) {
                    cVar.onSuccess();
                }
                f(this.j, this.k);
                return;
            }
            f(this.j, this.k);
        }
    }

    public void i(boolean z, DataRes dataRes, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), dataRes, Integer.valueOf(i2), str}) == null) {
            k(false);
            if (z) {
                this.f22576h.completePullRefresh();
            }
            if (i2 == 0 && dataRes != null && j(z, dataRes)) {
                c cVar = this.f22569a;
                if (cVar != null) {
                    cVar.onSuccess();
                }
                if (z) {
                    m(dataRes);
                }
            } else if (this.f22570b.size() > 0) {
                c cVar2 = this.f22569a;
                if (cVar2 != null) {
                    cVar2.onError(1, str);
                }
            } else {
                c cVar3 = this.f22569a;
                if (cVar3 != null) {
                    cVar3.onError(2, str);
                }
            }
        }
    }

    public final boolean j(boolean z, DataRes dataRes) {
        InterceptResult invokeZL;
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, dataRes)) == null) {
            if (dataRes == null) {
                return false;
            }
            if (z) {
                this.f22570b.clear();
            }
            this.f22572d = dataRes.has_more.intValue() == 1;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject3 = new JSONObject(dataRes.page_info);
                JSONArray optJSONArray = jSONObject3.optJSONArray("tab");
                JSONObject optJSONObject = jSONObject3.optJSONObject("title");
                if (optJSONObject != null) {
                    str2 = optJSONObject.optString("name");
                    str3 = optJSONObject.optString("url");
                    str = optJSONObject.optString("urlNight");
                } else {
                    str = "";
                    str2 = str;
                    str3 = str2;
                }
                if (optJSONArray != null) {
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            b.a.r0.q1.p.e eVar = new b.a.r0.q1.p.e();
                            eVar.f22740c = optJSONObject2.optString("title");
                            jSONObject2 = jSONObject3;
                            eVar.f22738a = optJSONObject2.optLong("page_id");
                            optJSONObject2.optInt("page_type");
                            eVar.f22741d = optJSONObject2.optInt("rn");
                            eVar.f22739b = optJSONObject2.optString("item_id");
                            eVar.f22742e = optJSONObject2.optString("params");
                            eVar.b();
                            arrayList.add(eVar);
                        } else {
                            jSONObject2 = jSONObject3;
                        }
                        i2++;
                        jSONObject3 = jSONObject2;
                    }
                    jSONObject = jSONObject3;
                    this.f22569a.d(str2, str3, str, arrayList);
                } else {
                    jSONObject = jSONObject3;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            b.a.r0.q1.p.d dVar = new b.a.r0.q1.p.d();
                            dVar.b(optJSONObject3);
                            if (dVar.a()) {
                                arrayList2.add(dVar);
                            }
                        }
                    }
                    this.f22569a.a(arrayList2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (dataRes.cards != null) {
                for (int i4 = 0; i4 < dataRes.cards.size(); i4++) {
                    ICardInfo i5 = b.a.r0.q1.o.b.i(dataRes.cards.get(i4));
                    if (i5 != null && i5.isValid()) {
                        this.f22570b.add(i5);
                    }
                }
            }
            if (this.f22570b.size() == 0) {
                return false;
            }
            try {
                this.f22573e = this.f22570b.get(this.f22570b.size() - 1).getFlipId();
            } catch (Exception unused) {
                this.f22573e = "";
            }
            this.f22577i.A(this.f22570b);
            return true;
        }
        return invokeZL.booleanValue;
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f22574f = z;
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f22569a = cVar;
        }
    }

    public final void m(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, dataRes) == null) || dataRes == null) {
            return;
        }
        b.a.q0.s.r.a.f();
        b.a.e.e.d.l<byte[]> d2 = b.a.q0.s.r.a.d("tb.lego_update");
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.k) ? "" : this.k);
        d2.a(sb.toString(), dataRes.toByteArray());
    }

    public void update(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) {
            this.f22571c = 1;
            this.j = j;
            this.k = str;
            if (this.f22570b.size() == 0 && !this.f22575g) {
                e(j, str);
            } else {
                f(j, str);
            }
        }
    }
}
