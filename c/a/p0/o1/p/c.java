package c.a.p0.o1.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f22722a;

    /* renamed from: b  reason: collision with root package name */
    public List<ICardInfo> f22723b;

    /* renamed from: c  reason: collision with root package name */
    public String f22724c;

    /* renamed from: d  reason: collision with root package name */
    public String f22725d;

    /* renamed from: e  reason: collision with root package name */
    public String f22726e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f22727f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22728g;

    /* renamed from: h  reason: collision with root package name */
    public int f22729h;

    /* renamed from: i  reason: collision with root package name */
    public String f22730i;

    /* renamed from: j  reason: collision with root package name */
    public int f22731j;
    public boolean k;
    public boolean l;
    public boolean m;

    public c(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22723b = new ArrayList();
        this.f22729h = 1;
        this.k = false;
        this.l = false;
        this.m = false;
        this.f22722a = eVar;
    }

    @Override // c.a.p0.o1.p.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22728g : invokeV.booleanValue;
    }

    @Override // c.a.p0.o1.p.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22729h : invokeV.intValue;
    }

    @Override // c.a.p0.o1.p.a
    public void c(boolean z, Message message, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            if (z) {
                this.l = true;
            } else {
                this.k = true;
            }
            DataRes dataRes = (DataRes) message;
            if (dataRes == null) {
                return;
            }
            this.f22728g = dataRes.has_more.intValue() == 1;
            if (!TextUtils.isEmpty(dataRes.page_info)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.page_info);
                    JSONObject optJSONObject = jSONObject.optJSONObject("title");
                    if (optJSONObject != null) {
                        this.f22724c = optJSONObject.optString("name");
                        this.f22725d = optJSONObject.optString("url");
                        this.f22726e = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.f22727f == null) {
                            this.f22727f = new ArrayList();
                        } else {
                            this.f22727f.clear();
                        }
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.b(optJSONObject2);
                                if (dVar.a()) {
                                    this.f22727f.add(dVar);
                                }
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (dataRes.cards != null) {
                for (int i4 = 0; i4 < dataRes.cards.size(); i4++) {
                    ICardInfo i5 = c.a.p0.o1.o.b.i(dataRes.cards.get(i4));
                    if (i5 != null && i5.isValid()) {
                        arrayList.add(i5);
                    }
                    if (i4 == dataRes.cards.size() - 1 && i5 != null) {
                        p(i5.getFlipId());
                    }
                }
            }
            if (z2) {
                this.f22723b.addAll(arrayList);
                this.f22729h = i2;
                return;
            }
            this.f22729h = 1;
            this.f22723b = arrayList;
        }
    }

    @Override // c.a.p0.o1.p.a
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ICardInfo> list = this.f22723b;
            return list != null && list.size() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.o1.p.a
    public List<ICardInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22723b : (List) invokeV.objValue;
    }

    public List<d> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22727f : (List) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22730i : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22731j : invokeV.intValue;
    }

    public e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22722a : (e) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22724c : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22725d : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22726e : (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f22730i = str;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f22731j = i2;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("page_info");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, optString));
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                    if (optJSONObject != null) {
                        this.f22724c = optJSONObject.optString("name");
                        this.f22725d = optJSONObject.optString("url");
                        this.f22726e = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.f22727f == null) {
                            this.f22727f = new ArrayList();
                        } else {
                            this.f22727f.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.b(optJSONObject2);
                                if (dVar.a()) {
                                    this.f22727f.add(dVar);
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        ICardInfo i4 = c.a.p0.o1.o.b.i(optJSONArray2.getString(i3));
                        if (i4 != null && i4.isValid()) {
                            arrayList.add(i4);
                        }
                        if (i3 == optJSONArray2.length() - 1 && i4 != null) {
                            p(i4.getFlipId());
                        }
                    }
                }
                this.f22723b = arrayList;
                if (d()) {
                    this.m = true;
                } else {
                    this.m = false;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
