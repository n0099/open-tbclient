package c.a.u0.u2.u.f.g1;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.t0.f1.n.f;
import c.a.t0.s.r.e2;
import c.a.u0.g0.d0.j;
import c.a.u0.g0.d0.k;
import c.a.u0.g0.d0.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.u0.g0.d0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, String str, c.a.u0.g0.d0.b bVar) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar;
        }

        @Override // c.a.t0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                c.a.u0.g0.d0.b bVar = this.l;
                if (bVar instanceof k) {
                    statisticItem = ((k) bVar).T();
                } else if (bVar instanceof l) {
                    statisticItem = ((l) bVar).R(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void a(List<ThreadInfo> list, List<n> list2, String str, int i2) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, list, list2, str, i2) == null) {
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ThreadInfo threadInfo = list.get(i4);
                if (threadInfo != null) {
                    e2 e2Var2 = new e2();
                    e2Var2.L2 = i4 + 1;
                    e2Var2.d3(threadInfo);
                    if (e2Var2.Z() != null && !TextUtils.isEmpty(str)) {
                        e2Var2.Z().f13751j = str;
                    }
                    if ((k.X(e2Var2) || l.S(e2Var2)) && e2Var2.getType() != e2.M3) {
                        k d2 = d(e2Var2, i2);
                        if (d2 != null && (e2Var = d2.f17886e) != null && e2Var.Z() != null && !StringUtils.isNull(e2Var.Z().f13743b)) {
                            d2.k = e2Var2.w1();
                            d2.position = i3;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] i0 = e2Var2.i0();
                        c.a.u0.g0.d0.b c2 = c(e2Var2, i2);
                        if (c2 != null) {
                            c2.k = e2Var2.w1();
                            c2.position = i3;
                            if (c2 instanceof k) {
                                if (e2Var2.i3() == 1) {
                                    h(c2);
                                    c2.n = i0[0];
                                    c2.o = i0[1];
                                } else if (e2Var2.i3() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.f17886e.K1();
                            if (!e2Var2.H2() && e2Var2.J() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(c.a.u0.u2.l.at_username), e2Var2.J().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new a(16, e2Var2.J().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.f17886e.L1(spannableString);
                            }
                            list2.add(c2);
                        }
                        k d3 = d(e2Var2, i2);
                        if (d3 != null) {
                            d3.k = e2Var2.w1();
                            d3.position = i3;
                            e(d3);
                        }
                        if (d3 != null && d3.isValid()) {
                            list2.add(d3);
                        }
                    }
                    i3++;
                }
            }
        }
    }

    public static List<n> b(List<ThreadInfo> list, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, list, str, i2)) == null) {
            LinkedList linkedList = new LinkedList();
            a(list, linkedList, str, i2);
            return linkedList;
        }
        return (List) invokeLLI.objValue;
    }

    public static c.a.u0.g0.d0.b c(e2 e2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, e2Var, i2)) == null) {
            if (e2Var == null) {
                return null;
            }
            if (k.X(e2Var)) {
                k kVar = new k();
                e2Var.i2();
                e2Var.A2();
                if (!e2Var.i2() && !e2Var.A2()) {
                    e2Var.d2();
                }
                kVar.f17886e = e2Var;
                kVar.G = i2;
                return kVar;
            } else if (l.S(e2Var)) {
                l lVar = new l(e2Var);
                lVar.G = i2;
                return lVar;
            } else {
                return null;
            }
        }
        return (c.a.u0.g0.d0.b) invokeLI.objValue;
    }

    public static k d(e2 e2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, e2Var, i2)) == null) {
            k kVar = new k();
            kVar.f17886e = e2Var;
            e2Var.i2();
            if (!e2Var.i2()) {
                e2Var.d2();
            }
            kVar.G = i2;
            return kVar;
        }
        return (k) invokeLI.objValue;
    }

    public static void e(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).E = true;
            } else if (bVar instanceof l) {
                ((l) bVar).E = true;
            } else if (bVar instanceof j) {
                ((j) bVar).E = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void f(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bVar) == null) {
            bVar.r = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void g(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bVar) == null) {
            ((k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void h(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            ((k) bVar).t = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void i(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            ((k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void j(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            ((l) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}
