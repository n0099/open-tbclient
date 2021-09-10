package c.a.r0.w0;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<d2> f26410a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26411b;

    /* renamed from: c  reason: collision with root package name */
    public String f26412c;

    /* renamed from: d  reason: collision with root package name */
    public int f26413d;

    /* renamed from: e  reason: collision with root package name */
    public List<FrsTabInfo> f26414e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f26415f;

    /* renamed from: g  reason: collision with root package name */
    public w0 f26416g;

    /* renamed from: c.a.r0.w0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1242a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f26417a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1546337849, "Lc/a/r0/w0/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1546337849, "Lc/a/r0/w0/a$b;");
                    return;
                }
            }
            f26417a = new a(null);
        }
    }

    public /* synthetic */ a(C1242a c1242a) {
        this();
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f26417a : (a) invokeV.objValue;
    }

    public boolean a(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null) {
                return false;
            }
            if (this.f26410a.size() > 29) {
                w0 w0Var = this.f26416g;
                if (w0Var != null) {
                    w0Var.b(2);
                }
                return false;
            }
            this.f26410a.add(d2Var);
            w0 w0Var2 = this.f26416g;
            if (w0Var2 != null) {
                w0Var2.c(this.f26410a.size(), 2);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (d2 d2Var : this.f26410a) {
                if (d2Var != null) {
                    d2Var.h4(false);
                }
            }
            this.f26410a.clear();
            w0 w0Var = this.f26416g;
            if (w0Var != null) {
                w0Var.c(0, 2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26412c = null;
            this.f26413d = -1;
            List<FrsTabInfo> list = this.f26414e;
            if (list != null) {
                list.clear();
            }
            SparseArray<FrsTabInfo> sparseArray = this.f26415f;
            if (sparseArray != null) {
                sparseArray.clear();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || ListUtils.isEmpty(this.f26410a)) {
            return;
        }
        this.f26410a.clear();
        w0 w0Var = this.f26416g;
        if (w0Var != null) {
            w0Var.c(this.f26410a.size(), 2);
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26413d : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26412c : (String) invokeV.objValue;
    }

    public List<FrsTabInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26414e : (List) invokeV.objValue;
    }

    public List<d2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26410a : (List) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26411b : invokeV.booleanValue;
    }

    public boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? this.f26415f.get(i2) != null && this.f26415f.get(i2).is_general_tab.intValue() == 1 : invokeI.booleanValue;
    }

    public void l(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) {
            this.f26410a.remove(d2Var);
            w0 w0Var = this.f26416g;
            if (w0Var != null) {
                w0Var.c(this.f26410a.size(), 2);
            }
        }
    }

    public void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            try {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
                JSONArray jSONArray = new JSONArray();
                for (d2 d2Var : h().i()) {
                    if (d2Var != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("thread_id", d2Var.f0());
                        jSONObject.put("from_tab_id", d2Var.h1());
                        jSONObject.put("to_tab_id", i3);
                        jSONArray.put(jSONObject);
                    }
                }
                httpMessage.addParam("threads", jSONArray.toString());
                httpMessage.addParam("forum_id", h().f());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p(false, false);
            b();
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f26413d = i2;
        }
    }

    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f26411b = z;
            w0 w0Var = this.f26416g;
            if (w0Var != null) {
                w0Var.a(z, z2, 2);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f26412c = str;
        }
    }

    public void r(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.f26414e = new ArrayList(list);
            this.f26415f = new SparseArray<>();
            for (FrsTabInfo frsTabInfo : this.f26414e) {
                if (frsTabInfo != null) {
                    this.f26415f.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
                }
            }
        }
    }

    public void s(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, w0Var) == null) {
            this.f26416g = w0Var;
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
                return;
            }
        }
        this.f26413d = -1;
        this.f26410a = new ArrayList();
    }
}
