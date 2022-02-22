package c.a.u0.p1.e.g;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.t.c.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f20458b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b0> f20459c;

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
                return;
            }
        }
        this.a = 1;
        this.f20458b = "https://boxnovel.baidu.com/boxnovel/haokan";
        this.f20459c = new ArrayList();
        i();
    }

    public b0 a(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            b0 b0Var = new b0();
            b0Var.a = i2;
            b0Var.f14211b = str;
            b0Var.f14212c = str2;
            b0Var.f14213d = str3;
            return b0Var;
        }
        return (b0) invokeCommon.objValue;
    }

    public b0 b(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2)) == null) {
            b0 b0Var = new b0();
            b0Var.a = i2;
            b0Var.f14211b = str;
            b0Var.f14212c = str2;
            return b0Var;
        }
        return (b0) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<b0> h2 = h();
            int size = h2.size();
            if (size != this.f20459c.size()) {
                return true;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (h2.get(i2) != null && !h2.get(i2).equals(this.f20459c.get(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<b0> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, f(R.string.tab_name_topic_rank), ""));
            arrayList.add(b(6, f(R.string.tab_name_live), ""));
            arrayList.add(b(201, f(R.string.tab_name_game), "game"));
            arrayList.add(b(201, f(R.string.tab_name_digital), "digital"));
            arrayList.add(b(201, f(R.string.tab_name_entertainment), "entertainment"));
            arrayList.add(b(201, f(R.string.tab_name_films), "films"));
            arrayList.add(b(201, f(R.string.tab_name_campus), "campus"));
            arrayList.add(b(201, f(R.string.tab_name_animes), "animes"));
            arrayList.add(b(201, f(R.string.tab_name_sports), "sports"));
            arrayList.add(a(202, f(R.string.tab_name_novel), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.f20458b));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    public final String f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public List<b0> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20459c : (List) invokeV.objValue;
    }

    public final List<b0> h() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONArray(c.a.t0.s.j0.b.k().q("key_index_tab_info_list", "[]"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONArray.length() == 0) {
                return d();
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                b0 b0Var = new b0();
                b0Var.e(jSONArray.getJSONObject(i2));
                if (!b0Var.c()) {
                    arrayList.add(b0Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            List<b0> h2 = h();
            if (ListUtils.isEmpty(h2)) {
                return;
            }
            this.f20459c.addAll(h2);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<b0> list = this.f20459c;
            if (list != null) {
                list.clear();
            }
            i();
        }
    }
}
