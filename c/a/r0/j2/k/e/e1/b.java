package c.a.r0.j2.k.e.e1;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.f1.m.e;
import c.a.q0.s.q.d2;
import c.a.r0.a0.d0.j;
import c.a.r0.a0.d0.k;
import c.a.r0.a0.d0.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a0.d0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, String str, c.a.r0.a0.d0.b bVar) {
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

        @Override // c.a.q0.f1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                c.a.r0.a0.d0.b bVar = this.l;
                if (bVar instanceof k) {
                    statisticItem = ((k) bVar).U();
                } else if (bVar instanceof l) {
                    statisticItem = ((l) bVar).S(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void a(List<ThreadInfo> list, List<n> list2, String str, int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, list, list2, str, i2) == null) {
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ThreadInfo threadInfo = list.get(i4);
                if (threadInfo != null) {
                    d2 d2Var2 = new d2();
                    d2Var2.I2 = i4 + 1;
                    d2Var2.Y2(threadInfo);
                    if (d2Var2.Y() != null && !TextUtils.isEmpty(str)) {
                        d2Var2.Y().f14382j = str;
                    }
                    if ((k.Y(d2Var2) || l.T(d2Var2)) && d2Var2.getType() != d2.B3) {
                        k d2 = d(d2Var2, i2);
                        if (d2 != null && (d2Var = d2.f15562e) != null && d2Var.Y() != null && !StringUtils.isNull(d2Var.Y().f14374b)) {
                            d2.l = d2Var2.s1();
                            d2.position = i3;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] g0 = d2Var2.g0();
                        c.a.r0.a0.d0.b c2 = c(d2Var2, i2);
                        if (c2 != null) {
                            c2.l = d2Var2.s1();
                            c2.position = i3;
                            if (c2 instanceof k) {
                                if (d2Var2.d3() == 1) {
                                    h(c2);
                                    c2.o = g0[0];
                                    c2.p = g0[1];
                                } else if (d2Var2.d3() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.f15562e.G1();
                            if (!d2Var2.D2() && d2Var2.J() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), d2Var2.J().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new a(16, d2Var2.J().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.f15562e.H1(spannableString);
                            }
                            list2.add(c2);
                        }
                        k d3 = d(d2Var2, i2);
                        if (d3 != null) {
                            d3.l = d2Var2.s1();
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

    public static c.a.r0.a0.d0.b c(d2 d2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, d2Var, i2)) == null) {
            if (d2Var == null) {
                return null;
            }
            if (k.Y(d2Var)) {
                k kVar = new k();
                d2Var.e2();
                d2Var.w2();
                if (!d2Var.e2() && !d2Var.w2()) {
                    d2Var.Z1();
                }
                kVar.f15562e = d2Var;
                kVar.G = i2;
                return kVar;
            } else if (l.T(d2Var)) {
                l lVar = new l(d2Var);
                lVar.G = i2;
                return lVar;
            } else {
                return null;
            }
        }
        return (c.a.r0.a0.d0.b) invokeLI.objValue;
    }

    public static k d(d2 d2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, d2Var, i2)) == null) {
            k kVar = new k();
            kVar.f15562e = d2Var;
            d2Var.e2();
            if (!d2Var.e2()) {
                d2Var.Z1();
            }
            kVar.G = i2;
            return kVar;
        }
        return (k) invokeLI.objValue;
    }

    public static void e(c.a.r0.a0.d0.b bVar) {
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

    public static void f(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            bVar.s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void g(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) {
            ((k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void h(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            ((k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void i(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            ((k) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void j(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            ((l) bVar).x = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}
