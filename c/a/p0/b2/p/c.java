package c.a.p0.b2.p;

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
/* loaded from: classes2.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e a;

    /* renamed from: b  reason: collision with root package name */
    public List<ICardInfo> f12557b;

    /* renamed from: c  reason: collision with root package name */
    public String f12558c;

    /* renamed from: d  reason: collision with root package name */
    public String f12559d;

    /* renamed from: e  reason: collision with root package name */
    public String f12560e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f12561f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12562g;

    /* renamed from: h  reason: collision with root package name */
    public int f12563h;
    public String i;
    public int j;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12557b = new ArrayList();
        this.f12563h = 1;
        this.k = false;
        this.l = false;
        this.m = false;
        this.a = eVar;
    }

    @Override // c.a.p0.b2.p.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<ICardInfo> list = this.f12557b;
            return list != null && list.size() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.b2.p.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12563h : invokeV.intValue;
    }

    @Override // c.a.p0.b2.p.a
    public void c(boolean z, Message message, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            if (z) {
                this.l = true;
            } else {
                this.k = true;
            }
            DataRes dataRes = (DataRes) message;
            if (dataRes == null) {
                return;
            }
            this.f12562g = dataRes.has_more.intValue() == 1;
            if (!TextUtils.isEmpty(dataRes.page_info)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.page_info);
                    JSONObject optJSONObject = jSONObject.optJSONObject("title");
                    if (optJSONObject != null) {
                        this.f12558c = optJSONObject.optString("name");
                        this.f12559d = optJSONObject.optString("url");
                        this.f12560e = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.f12561f == null) {
                            this.f12561f = new ArrayList();
                        } else {
                            this.f12561f.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.b(optJSONObject2);
                                if (dVar.a()) {
                                    this.f12561f.add(dVar);
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
                for (int i3 = 0; i3 < dataRes.cards.size(); i3++) {
                    ICardInfo i4 = c.a.p0.b2.o.b.i(dataRes.cards.get(i3));
                    if (i4 != null && i4.isValid()) {
                        arrayList.add(i4);
                    }
                    if (i3 == dataRes.cards.size() - 1 && i4 != null) {
                        o(i4.getFlipId());
                    }
                }
            }
            if (z2) {
                this.f12557b.addAll(arrayList);
                this.f12563h = i;
                return;
            }
            this.f12563h = 1;
            this.f12557b = arrayList;
        }
    }

    @Override // c.a.p0.b2.p.a
    public List<ICardInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12557b : (List) invokeV.objValue;
    }

    public List<d> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12561f : (List) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.intValue;
    }

    public e h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (e) invokeV.objValue;
    }

    @Override // c.a.p0.b2.p.a
    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12562g : invokeV.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f12558c : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f12559d : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12560e : (String) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.i = str;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.j = i;
        }
    }

    public void q(String str) {
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
                        this.f12558c = optJSONObject.optString("name");
                        this.f12559d = optJSONObject.optString("url");
                        this.f12560e = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.f12561f == null) {
                            this.f12561f = new ArrayList();
                        } else {
                            this.f12561f.clear();
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.b(optJSONObject2);
                                if (dVar.a()) {
                                    this.f12561f.add(dVar);
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ICardInfo i3 = c.a.p0.b2.o.b.i(optJSONArray2.getString(i2));
                        if (i3 != null && i3.isValid()) {
                            arrayList.add(i3);
                        }
                        if (i2 == optJSONArray2.length() - 1 && i3 != null) {
                            o(i3.getFlipId());
                        }
                    }
                }
                this.f12557b = arrayList;
                if (a()) {
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
