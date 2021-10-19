package c.a.r0.h1.d.f;

import c.a.q0.t.c.z;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f18120a;

    /* renamed from: b  reason: collision with root package name */
    public String f18121b;

    /* renamed from: c  reason: collision with root package name */
    public final List<z> f18122c;

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
        this.f18120a = 1;
        this.f18121b = "https://boxnovel.baidu.com/boxnovel/haokan";
        this.f18122c = new ArrayList();
        List<z> g2 = g();
        if (ListUtils.isEmpty(g2)) {
            return;
        }
        this.f18122c.addAll(g2);
    }

    public z a(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            z zVar = new z();
            zVar.f14794a = i2;
            zVar.f14795b = str;
            zVar.f14796c = str2;
            zVar.f14797d = str3;
            return zVar;
        }
        return (z) invokeCommon.objValue;
    }

    public z b(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2)) == null) {
            z zVar = new z();
            zVar.f14794a = i2;
            zVar.f14795b = str;
            zVar.f14796c = str2;
            return zVar;
        }
        return (z) invokeILL.objValue;
    }

    public final List<z> c() {
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
            arrayList.add(a(202, e(R.string.tab_name_novel), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.f18121b));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18120a : invokeV.intValue;
    }

    public final String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public List<z> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18122c : (List) invokeV.objValue;
    }

    public final List<z> g() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONArray(c.a.q0.s.d0.b.j().p("key_index_tab_info_list", "[]"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONArray.length() == 0) {
                return c();
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                z zVar = new z();
                zVar.b(jSONArray.getJSONObject(i2));
                if (!zVar.a()) {
                    arrayList.add(zVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
