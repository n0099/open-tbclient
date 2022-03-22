package c.a.p0.q1.i.m;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.e1.n.e;
import c.a.p0.q1.i.g;
import c.a.p0.z3.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.q1.i.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1311a implements ThirdStatisticHelper.TiePlusStatisCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1311a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.TiePlusStatisCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || a.a == null) {
                return;
            }
            a.a.put(str, "3");
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.TiePlusStatisCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || a.a == null) {
                return;
            }
            a.a.put(str, "2");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-288007512, "Lc/a/p0/q1/i/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-288007512, "Lc/a/p0/q1/i/m/a;");
                return;
            }
        }
        a = new ArrayMap<>();
    }

    @Deprecated
    public static void b(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, threadData, str, i) == null) {
            c(threadData, str, i, 1);
        }
    }

    public static void c(ThreadData threadData, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, threadData, str, i, i2) == null) || threadData == null) {
            return;
        }
        if (!TextUtils.isEmpty(threadData.tiePlusCostUrl)) {
            ThirdStatisticHelper.sendTiePlusReq(threadData.tiePlusCostUrl, threadData.tid, 2, null);
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", 1);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i2);
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            c.a.o0.c.a.a(c.a.o0.c.a.f9870e, c.a.o0.c.a.a, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
        if (str == null || !str.startsWith("manual")) {
            return;
        }
        c.a.o0.c.a.a(c.a.o0.c.a.l, c.a.o0.c.a.a, str, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
    }

    public static void d(ThreadData threadData, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, bdUniqueId, i, i2) == null) || threadData == null) {
            return;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i3 = 20;
        } else {
            str = null;
            z = false;
            i3 = 0;
        }
        StatisticItem e2 = c.a.p0.z3.a.e(threadData, "a002", "common_click", i2, i, z, str, null, i3);
        if (e2 == null) {
            return;
        }
        if (threadData.isGoods()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e2.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                e2.getParams().remove(i4);
                e2.getParams().add(i4, 16);
            } else {
                e2.param("obj_locate", 16);
            }
        } else if (e.t(threadData)) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            e2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (threadData.isSCard) {
            e2.delete("thread_type");
            e2.param("thread_type", threadData.getThreadType());
        }
        c.g().c(bdUniqueId, e2);
        e(threadData, i2);
    }

    public static void e(ThreadData threadData, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, threadData, i) == null) {
            if (i != 2) {
                n = i != 9 ? null : c.a.p0.z3.a.n("c13693", threadData, 1);
            } else {
                n = c.a.p0.z3.a.n("c13692", threadData, 1);
            }
            TiebaStatic.log(n);
        }
    }

    public static void f(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, threadData) == null) || threadData == null || TextUtils.isEmpty(threadData.tiePlusShowUrl)) {
            return;
        }
        if (a == null) {
            a = new ArrayMap<>();
        }
        String str = a.get(threadData.tiePlusShowUrl);
        if ("1".equals(str) || "2".equals(str)) {
            return;
        }
        ThirdStatisticHelper.sendTiePlusReq(threadData.tiePlusShowUrl, threadData.tid, 1, new C1311a());
        a.put(threadData.tiePlusShowUrl, "1");
    }

    public static void g(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65543, null, threadData, str, i) == null) || threadData == null) {
            return;
        }
        f(threadData);
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", 1);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            c.a.o0.c.a.a(c.a.o0.c.a.f9869d, c.a.o0.c.a.a, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
        if (str == null || !str.startsWith("manual")) {
            return;
        }
        c.a.o0.c.a.a(c.a.o0.c.a.k, c.a.o0.c.a.a, str, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
    }

    public static void h(ThreadData threadData, BdUniqueId bdUniqueId, int i) {
        String str;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65544, null, threadData, bdUniqueId, i) == null) || threadData == null) {
            return;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i2 = 20;
        } else {
            str = null;
            z = false;
            i2 = 0;
        }
        String c2 = c.a.p0.z3.a.c(threadData.getTid(), str, "", threadData.getBaijiahaoData());
        StatisticItem g2 = c.a.p0.z3.a.g(threadData, "a002", "common_exp", i, z, str, null, i2);
        if (g2 == null) {
            return;
        }
        if (threadData.isSCard) {
            g2.delete("thread_type");
            g2.param("thread_type", threadData.getThreadType());
        }
        if (threadData.isGoods()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (e.t(threadData)) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        c.g().d(bdUniqueId, c2, g2);
        if (g.d()) {
            g.c(c2);
            if (g.b() >= 10) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                g.e(false);
            }
        }
    }
}
