package c.a.t0.o1.d.g;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.t.c.a0;
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
    public String f20251b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a0> f20252c;

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
        this.f20251b = "https://boxnovel.baidu.com/boxnovel/haokan";
        this.f20252c = new ArrayList();
        h();
    }

    public a0 a(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            a0 a0Var = new a0();
            a0Var.a = i2;
            a0Var.f13787b = str;
            a0Var.f13788c = str2;
            a0Var.f13789d = str3;
            return a0Var;
        }
        return (a0) invokeCommon.objValue;
    }

    public a0 b(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2)) == null) {
            a0 a0Var = new a0();
            a0Var.a = i2;
            a0Var.f13787b = str;
            a0Var.f13788c = str2;
            return a0Var;
        }
        return (a0) invokeILL.objValue;
    }

    public final List<a0> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, e(R.string.tab_name_topic_rank), ""));
            arrayList.add(b(6, e(R.string.tab_name_live), ""));
            arrayList.add(b(201, e(R.string.tab_name_game), "game"));
            arrayList.add(b(201, e(R.string.tab_name_digital), "digital"));
            arrayList.add(b(201, e(R.string.tab_name_entertainment), "entertainment"));
            arrayList.add(b(201, e(R.string.tab_name_films), "films"));
            arrayList.add(b(201, e(R.string.tab_name_campus), "campus"));
            arrayList.add(b(201, e(R.string.tab_name_animes), "animes"));
            arrayList.add(b(201, e(R.string.tab_name_sports), "sports"));
            arrayList.add(a(202, e(R.string.tab_name_novel), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.f20251b));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public final String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public List<a0> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20252c : (List) invokeV.objValue;
    }

    public final List<a0> g() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONArray(c.a.s0.s.h0.b.k().q("key_index_tab_info_list", "[]"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONArray.length() == 0) {
                return c();
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                a0 a0Var = new a0();
                a0Var.e(jSONArray.getJSONObject(i2));
                if (!a0Var.c()) {
                    arrayList.add(a0Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            List<a0> g2 = g();
            if (ListUtils.isEmpty(g2)) {
                return;
            }
            this.f20252c.addAll(g2);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            List<a0> list = this.f20252c;
            if (list != null) {
                list.clear();
            }
            h();
        }
    }
}
