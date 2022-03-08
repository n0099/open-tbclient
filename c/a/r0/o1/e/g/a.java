package c.a.r0.o1.e.g;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.c.z;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f19797b;

    /* renamed from: c  reason: collision with root package name */
    public final List<z> f19798c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19799d;

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
        this.f19797b = "https://boxnovel.baidu.com/boxnovel/haokan";
        this.f19798c = new ArrayList();
        i();
    }

    public z a(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            z zVar = new z();
            zVar.a = i2;
            zVar.f13729b = str;
            zVar.f13730c = str2;
            zVar.f13731d = str3;
            return zVar;
        }
        return (z) invokeCommon.objValue;
    }

    public z b(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2)) == null) {
            z zVar = new z();
            zVar.a = i2;
            zVar.f13729b = str;
            zVar.f13730c = str2;
            return zVar;
        }
        return (z) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f19799d) {
                return false;
            }
            List<z> h2 = h();
            int size = h2.size();
            if (size != this.f19798c.size()) {
                return true;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (h2.get(i2) != null && !h2.get(i2).equals(this.f19798c.get(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<z> d() {
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
            arrayList.add(a(202, f(R.string.tab_name_novel), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.f19797b));
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

    public List<z> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19798c : (List) invokeV.objValue;
    }

    public final List<z> h() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONArray(c.a.q0.r.j0.b.k().q("key_index_tab_info_list", "[]"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONArray.length() == 0) {
                this.f19799d = true;
                return d();
            }
            this.f19799d = false;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                z zVar = new z();
                zVar.e(jSONArray.getJSONObject(i2));
                if (!zVar.c()) {
                    arrayList.add(zVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            List<z> h2 = h();
            if (ListUtils.isEmpty(h2)) {
                return;
            }
            this.f19798c.addAll(h2);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<z> list = this.f19798c;
            if (list != null) {
                list.clear();
            }
            i();
        }
    }
}
