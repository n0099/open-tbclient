package c.a.p0.q1.e.g;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.c.z;
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
    public String f17239b;

    /* renamed from: c  reason: collision with root package name */
    public final List<z> f17240c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17241d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f17239b = "https://boxnovel.baidu.com/boxnovel/haokan";
        this.f17240c = new ArrayList();
        i();
    }

    public z a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            z zVar = new z();
            zVar.a = i;
            zVar.f11280b = str;
            zVar.f11281c = str2;
            zVar.f11282d = str3;
            return zVar;
        }
        return (z) invokeCommon.objValue;
    }

    public z b(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            z zVar = new z();
            zVar.a = i;
            zVar.f11280b = str;
            zVar.f11281c = str2;
            return zVar;
        }
        return (z) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f17241d) {
                return false;
            }
            List<z> h2 = h();
            int size = h2.size();
            if (size != this.f17240c.size()) {
                return true;
            }
            for (int i = 0; i < size; i++) {
                if (h2.get(i) != null && !h2.get(i).equals(this.f17240c.get(i))) {
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
            arrayList.add(b(5, f(R.string.obfuscated_res_0x7f0f1325), ""));
            arrayList.add(b(6, f(R.string.obfuscated_res_0x7f0f1321), ""));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f1320), "game"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f131d), "digital"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f131e), "entertainment"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f131f), "films"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f131b), "campus"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f131a), "animes"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f1324), "sports"));
            arrayList.add(a(202, f(R.string.obfuscated_res_0x7f0f1322), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.f17239b));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public List<z> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f17240c : (List) invokeV.objValue;
    }

    public final List<z> h() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONArray(c.a.o0.r.j0.b.k().q("key_index_tab_info_list", "[]"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONArray.length() == 0) {
                this.f17241d = true;
                return d();
            }
            this.f17241d = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                z zVar = new z();
                zVar.e(jSONArray.getJSONObject(i));
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
            this.f17240c.addAll(h2);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<z> list = this.f17240c;
            if (list != null) {
                list.clear();
            }
            i();
        }
    }
}
