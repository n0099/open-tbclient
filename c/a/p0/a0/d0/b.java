package c.a.p0.a0.d0;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class b extends c.a.o0.s.q.a implements PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId H;
    public static final BdUniqueId I;
    public static final BdUniqueId J;
    public static final BdUniqueId K;
    public static final BdUniqueId L;
    public static final BdUniqueId M;
    public static final BdUniqueId N;
    public static final BdUniqueId O;
    public static final BdUniqueId P;
    public static final BdUniqueId Q;
    public static final ArrayList<BdUniqueId> R;
    public static final ArrayList<BdUniqueId> S;
    public static BdUniqueId[][] T;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;

    /* renamed from: e  reason: collision with root package name */
    public c2 f14959e;

    /* renamed from: f  reason: collision with root package name */
    public String f14960f;

    /* renamed from: g  reason: collision with root package name */
    public String f14961g;

    /* renamed from: h  reason: collision with root package name */
    public int f14962h;

    /* renamed from: i  reason: collision with root package name */
    public String f14963i;

    /* renamed from: j  reason: collision with root package name */
    public String f14964j;
    public int k;
    public String l;
    public String m;
    public Integer n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1076939035, "Lc/a/p0/a0/d0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1076939035, "Lc/a/p0/a0/d0/b;");
                return;
            }
        }
        H = BdUniqueId.gen();
        I = BdUniqueId.gen();
        J = BdUniqueId.gen();
        K = BdUniqueId.gen();
        L = BdUniqueId.gen();
        M = BdUniqueId.gen();
        N = BdUniqueId.gen();
        O = BdUniqueId.gen();
        P = BdUniqueId.gen();
        Q = BdUniqueId.gen();
        R = new ArrayList<>();
        S = new ArrayList<>();
        R.add(H);
        R.add(I);
        S.add(M);
        S.add(J);
        S.add(L);
        S.add(K);
        T = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, R.size(), S.size());
        for (int i2 = 0; i2 < R.size(); i2++) {
            for (int i3 = 0; i3 < S.size(); i3++) {
                T[i2][i3] = BdUniqueId.gen();
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 1;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = 0;
    }

    public StatisticItem A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14964j : (String) invokeV.objValue;
    }

    public StatisticItem D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14960f : (String) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q == 1 : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f14963i = str;
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.m = str;
        }
    }

    public void J(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, num) == null) {
            this.n = num;
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f14962h = i2;
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f14961g = str;
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.q = i2;
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f14964j = str;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f14960f = str;
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f14963i : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c2 threadData = getThreadData();
            if (threadData != null) {
                return threadData.getImages();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (getThreadData() == null || (sparseArray = this.feedBackReasonMap) == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            x0Var.p(getThreadData().q1());
            x0Var.l(getThreadData().T());
            x0Var.o(getThreadData().D0());
            x0Var.k(this.feedBackReasonMap);
            x0Var.k = this.f14960f;
            x0Var.l = this.f14961g;
            x0Var.m = this.m;
            x0Var.n = getThreadData().a0;
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public String getPbInputLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.f14961g + "#" + this.f14962h + "#" + this.f14963i;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public c2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return null;
        }
        return (c2) invokeV.objValue;
    }

    public StatisticItem i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            return null;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public StatisticItem o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public Integer p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.n : (Integer) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f14962h : invokeV.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f14961g : (String) invokeV.objValue;
    }

    public StatisticItem w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? y(str, false) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem x(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            c2 threadData = getThreadData();
            if (threadData == null) {
                return null;
            }
            StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(threadData.T())).param("tid", String.valueOf(threadData.q1())).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_param1", E()).param("obj_source", t()).param("obj_locate", q()).param("obj_name", g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, c.a.p0.a0.m.e());
            if (i2 == 0) {
                param.param("obj_type", z());
            } else {
                param.param("obj_type", i2);
            }
            param.param("obj_id", k());
            return param;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem y(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048605, this, str, z)) == null) {
            c2 threadData = getThreadData();
            if (threadData == null || str.length() == 0) {
                return null;
            }
            StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(threadData.T())).param("fname", threadData.Z()).param("tid", String.valueOf(threadData.q1())).param("nid", threadData.D0()).param("obj_id", k()).param("obj_param1", E()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_source", t()).param("obj_locate", q()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, c.a.p0.a0.m.e()).param("ab_tag", g()).param(TiebaStatic.Params.IS_ZP, threadData.E2() ? 1 : 0);
            if (!z) {
                param.param("obj_type", z());
            } else {
                if (threadData.t1 > 0) {
                    param.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
                } else {
                    param.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
                }
                param.param(TiebaStatic.Params.IS_VERTICAL, p().intValue());
            }
            if (threadData.t1() != null && threadData.t1().K() != null && threadData.t1().K().y() != null && threadData.t1().K().y().size() > 0) {
                param.param(TiebaStatic.Params.OBJ_TO, threadData.t1().N ? 2 : 1);
            }
            return param;
        }
        return (StatisticItem) invokeLZ.objValue;
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            c2 threadData = getThreadData();
            int i2 = 0;
            if (threadData == null) {
                return 0;
            }
            ArrayList<MediaData> C0 = threadData.C0();
            if (C0 != null) {
                Iterator<MediaData> it = C0.iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }
}
