package c.a.r0.j2.k.e.a1;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f19845a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.j2.k.c.b f19846b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.j0.a f19847c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnTouchListener f19848d;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f19849e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19849e = jVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f19849e.f19847c != null) {
                    this.f19849e.f19847c.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.q0.f1.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a0.d0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2, String str, c.a.r0.a0.d0.b bVar) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2), str, bVar};
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
                if (bVar instanceof c.a.r0.a0.d0.k) {
                    statisticItem = ((c.a.r0.a0.d0.k) bVar).U();
                } else if (bVar instanceof c.a.r0.a0.d0.l) {
                    statisticItem = ((c.a.r0.a0.d0.l) bVar).S(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public j(BdTypeRecyclerView bdTypeRecyclerView, c.a.r0.j2.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.f19848d = aVar;
        this.f19845a = bdTypeRecyclerView;
        this.f19846b = bVar;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.f19847c = new c.a.r0.j0.a();
    }

    public final void b(List<ThreadInfo> list, List<n> list2, String str) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                ThreadInfo threadInfo = list.get(i3);
                if (threadInfo != null) {
                    d2 d2Var2 = new d2();
                    d2Var2.I2 = i3 + 1;
                    d2Var2.Y2(threadInfo);
                    if (d2Var2.Y() != null) {
                        d2Var2.Y().f14382j = str;
                    }
                    if ((c.a.r0.a0.d0.k.Y(d2Var2) || c.a.r0.a0.d0.l.T(d2Var2)) && d2Var2.getType() != d2.B3) {
                        c.a.r0.a0.d0.k d2 = d(d2Var2);
                        if (d2 != null && (d2Var = d2.f15562e) != null && d2Var.Y() != null && !StringUtils.isNull(d2Var.Y().f14374b)) {
                            d2.l = d2Var2.s1();
                            d2.position = i2;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] g0 = d2Var2.g0();
                        c.a.r0.a0.d0.b c2 = c(d2Var2);
                        if (c2 != null) {
                            c2.l = d2Var2.s1();
                            c2.position = i2;
                            if (c2 instanceof c.a.r0.a0.d0.k) {
                                if (d2Var2.d3() == 1) {
                                    h(c2);
                                    c2.o = g0[0];
                                    c2.p = g0[1];
                                } else if (d2Var2.d3() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof c.a.r0.a0.d0.l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.f15562e.G1();
                            if (!d2Var2.D2() && d2Var2.J() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), d2Var2.J().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, d2Var2.J().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.f15562e.H1(spannableString);
                            }
                            list2.add(c2);
                        }
                        c.a.r0.a0.d0.k d3 = d(d2Var2);
                        if (d3 != null) {
                            d3.l = d2Var2.s1();
                            d3.position = i2;
                            e(d3);
                        }
                        if (d3 != null && d3.isValid()) {
                            list2.add(d3);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    public final c.a.r0.a0.d0.b c(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            if (c.a.r0.a0.d0.k.Y(d2Var)) {
                c.a.r0.a0.d0.k kVar = new c.a.r0.a0.d0.k();
                d2Var.e2();
                d2Var.w2();
                if (!d2Var.e2() && !d2Var.w2()) {
                    d2Var.Z1();
                }
                kVar.f15562e = d2Var;
                return kVar;
            } else if (c.a.r0.a0.d0.l.T(d2Var)) {
                return new c.a.r0.a0.d0.l(d2Var);
            } else {
                return null;
            }
        }
        return (c.a.r0.a0.d0.b) invokeL.objValue;
    }

    public final c.a.r0.a0.d0.k d(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            c.a.r0.a0.d0.k kVar = new c.a.r0.a0.d0.k();
            kVar.f15562e = d2Var;
            d2Var.e2();
            if (!d2Var.e2()) {
                d2Var.Z1();
            }
            return kVar;
        }
        return (c.a.r0.a0.d0.k) invokeL.objValue;
    }

    public final void e(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar instanceof c.a.r0.a0.d0.k) {
                ((c.a.r0.a0.d0.k) bVar).E = true;
            } else if (bVar instanceof c.a.r0.a0.d0.l) {
                ((c.a.r0.a0.d0.l) bVar).E = true;
            } else if (bVar instanceof c.a.r0.a0.d0.j) {
                ((c.a.r0.a0.d0.j) bVar).E = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public final void f(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            bVar.s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ((c.a.r0.a0.d0.k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            ((c.a.r0.a0.d0.k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            ((c.a.r0.a0.d0.k) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(c.a.r0.a0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            ((c.a.r0.a0.d0.l) bVar).x = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public void k(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        String first_class = eVar.m() != null ? eVar.m().getFirst_class() : "";
        List<ThreadInfo> I = eVar.I();
        LinkedList linkedList = new LinkedList();
        b(I, linkedList, first_class);
        this.f19846b.h(linkedList);
    }
}
