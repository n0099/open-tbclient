package b.a.r0.k2.u.f.b1;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.q0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f20625a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.u.c.b f20626b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.k0.a f20627c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnTouchListener f20628d;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f20629e;

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
            this.f20629e = jVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f20629e.f20627c != null) {
                    this.f20629e.f20627c.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.q0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a.r0.b0.f0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2, String str, b.a.r0.b0.f0.b bVar) {
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

        @Override // b.a.q0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                b.a.r0.b0.f0.b bVar = this.l;
                if (bVar instanceof b.a.r0.b0.f0.k) {
                    statisticItem = ((b.a.r0.b0.f0.k) bVar).U();
                } else if (bVar instanceof b.a.r0.b0.f0.l) {
                    statisticItem = ((b.a.r0.b0.f0.l) bVar).S(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public j(BdTypeRecyclerView bdTypeRecyclerView, b.a.r0.k2.u.c.b bVar) {
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
        this.f20628d = aVar;
        this.f20625a = bdTypeRecyclerView;
        this.f20626b = bVar;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.f20627c = new b.a.r0.k0.a();
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
                    d2Var2.J2 = i3 + 1;
                    d2Var2.a3(threadInfo);
                    if (d2Var2.Y() != null) {
                        d2Var2.Y().j = str;
                    }
                    if ((b.a.r0.b0.f0.k.Y(d2Var2) || b.a.r0.b0.f0.l.T(d2Var2)) && d2Var2.getType() != d2.E3) {
                        b.a.r0.b0.f0.k d2 = d(d2Var2);
                        if (d2 != null && (d2Var = d2.f16235e) != null && d2Var.Y() != null && !StringUtils.isNull(d2Var.Y().f14288b)) {
                            d2.l = d2Var2.t1();
                            d2.position = i2;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] g0 = d2Var2.g0();
                        b.a.r0.b0.f0.b c2 = c(d2Var2);
                        if (c2 != null) {
                            c2.l = d2Var2.t1();
                            c2.position = i2;
                            if (c2 instanceof b.a.r0.b0.f0.k) {
                                if (d2Var2.f3() == 1) {
                                    h(c2);
                                    c2.o = g0[0];
                                    c2.p = g0[1];
                                } else if (d2Var2.f3() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof b.a.r0.b0.f0.l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.f16235e.I1();
                            if (!d2Var2.F2() && d2Var2.J() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.at_username), d2Var2.J().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, d2Var2.J().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.f16235e.J1(spannableString);
                            }
                            list2.add(c2);
                        }
                        b.a.r0.b0.f0.k d3 = d(d2Var2);
                        if (d3 != null) {
                            d3.l = d2Var2.t1();
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

    public final b.a.r0.b0.f0.b c(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            if (b.a.r0.b0.f0.k.Y(d2Var)) {
                b.a.r0.b0.f0.k kVar = new b.a.r0.b0.f0.k();
                d2Var.g2();
                d2Var.y2();
                if (!d2Var.g2() && !d2Var.y2()) {
                    d2Var.b2();
                }
                kVar.f16235e = d2Var;
                return kVar;
            } else if (b.a.r0.b0.f0.l.T(d2Var)) {
                return new b.a.r0.b0.f0.l(d2Var);
            } else {
                return null;
            }
        }
        return (b.a.r0.b0.f0.b) invokeL.objValue;
    }

    public final b.a.r0.b0.f0.k d(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            b.a.r0.b0.f0.k kVar = new b.a.r0.b0.f0.k();
            kVar.f16235e = d2Var;
            d2Var.g2();
            if (!d2Var.g2()) {
                d2Var.b2();
            }
            return kVar;
        }
        return (b.a.r0.b0.f0.k) invokeL.objValue;
    }

    public final void e(b.a.r0.b0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar instanceof b.a.r0.b0.f0.k) {
                ((b.a.r0.b0.f0.k) bVar).F = true;
            } else if (bVar instanceof b.a.r0.b0.f0.l) {
                ((b.a.r0.b0.f0.l) bVar).F = true;
            } else if (bVar instanceof b.a.r0.b0.f0.j) {
                ((b.a.r0.b0.f0.j) bVar).F = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public final void f(b.a.r0.b0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            bVar.s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(b.a.r0.b0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ((b.a.r0.b0.f0.k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(b.a.r0.b0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            ((b.a.r0.b0.f0.k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(b.a.r0.b0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            ((b.a.r0.b0.f0.k) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(b.a.r0.b0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            ((b.a.r0.b0.f0.l) bVar).x = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public void k(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        String first_class = fVar.l() != null ? fVar.l().getFirst_class() : "";
        List<ThreadInfo> I = fVar.I();
        LinkedList linkedList = new LinkedList();
        b(I, linkedList, first_class);
        this.f20626b.h(linkedList);
    }
}
