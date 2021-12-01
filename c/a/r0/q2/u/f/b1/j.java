package c.a.r0.q2.u.f.b1;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.q2.u.c.b f21827b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.q0.a f21828c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnTouchListener f21829d;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21830e;

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
            this.f21830e = jVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f21830e.f21828c != null) {
                    this.f21830e.f21828c.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.q0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.g0.f0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2, String str, c.a.r0.g0.f0.b bVar) {
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

        @Override // c.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                c.a.r0.g0.f0.b bVar = this.l;
                if (bVar instanceof c.a.r0.g0.f0.k) {
                    statisticItem = ((c.a.r0.g0.f0.k) bVar).U();
                } else if (bVar instanceof c.a.r0.g0.f0.l) {
                    statisticItem = ((c.a.r0.g0.f0.l) bVar).S(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public j(BdTypeRecyclerView bdTypeRecyclerView, c.a.r0.q2.u.c.b bVar) {
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
        this.f21829d = aVar;
        this.a = bdTypeRecyclerView;
        this.f21827b = bVar;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.f21828c = new c.a.r0.q0.a();
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
                    d2Var2.M2 = i3 + 1;
                    d2Var2.c3(threadInfo);
                    if (d2Var2.Z() != null) {
                        d2Var2.Z().f13116j = str;
                    }
                    if ((c.a.r0.g0.f0.k.Y(d2Var2) || c.a.r0.g0.f0.l.T(d2Var2)) && d2Var2.getType() != d2.I3) {
                        c.a.r0.g0.f0.k d2 = d(d2Var2);
                        if (d2 != null && (d2Var = d2.f17245e) != null && d2Var.Z() != null && !StringUtils.isNull(d2Var.Z().f13108b)) {
                            d2.l = d2Var2.v1();
                            d2.position = i2;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] h0 = d2Var2.h0();
                        c.a.r0.g0.f0.b c2 = c(d2Var2);
                        if (c2 != null) {
                            c2.l = d2Var2.v1();
                            c2.position = i2;
                            if (c2 instanceof c.a.r0.g0.f0.k) {
                                if (d2Var2.h3() == 1) {
                                    h(c2);
                                    c2.o = h0[0];
                                    c2.p = h0[1];
                                } else if (d2Var2.h3() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof c.a.r0.g0.f0.l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.f17245e.J1();
                            if (!d2Var2.G2() && d2Var2.J() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.at_username), d2Var2.J().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, d2Var2.J().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.f17245e.K1(spannableString);
                            }
                            list2.add(c2);
                        }
                        c.a.r0.g0.f0.k d3 = d(d2Var2);
                        if (d3 != null) {
                            d3.l = d2Var2.v1();
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

    public final c.a.r0.g0.f0.b c(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            if (c.a.r0.g0.f0.k.Y(d2Var)) {
                c.a.r0.g0.f0.k kVar = new c.a.r0.g0.f0.k();
                d2Var.h2();
                d2Var.z2();
                if (!d2Var.h2() && !d2Var.z2()) {
                    d2Var.c2();
                }
                kVar.f17245e = d2Var;
                return kVar;
            } else if (c.a.r0.g0.f0.l.T(d2Var)) {
                return new c.a.r0.g0.f0.l(d2Var);
            } else {
                return null;
            }
        }
        return (c.a.r0.g0.f0.b) invokeL.objValue;
    }

    public final c.a.r0.g0.f0.k d(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            c.a.r0.g0.f0.k kVar = new c.a.r0.g0.f0.k();
            kVar.f17245e = d2Var;
            d2Var.h2();
            if (!d2Var.h2()) {
                d2Var.c2();
            }
            return kVar;
        }
        return (c.a.r0.g0.f0.k) invokeL.objValue;
    }

    public final void e(c.a.r0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar instanceof c.a.r0.g0.f0.k) {
                ((c.a.r0.g0.f0.k) bVar).F = true;
            } else if (bVar instanceof c.a.r0.g0.f0.l) {
                ((c.a.r0.g0.f0.l) bVar).F = true;
            } else if (bVar instanceof c.a.r0.g0.f0.j) {
                ((c.a.r0.g0.f0.j) bVar).F = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public final void f(c.a.r0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            bVar.s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(c.a.r0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ((c.a.r0.g0.f0.k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(c.a.r0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            ((c.a.r0.g0.f0.k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(c.a.r0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            ((c.a.r0.g0.f0.k) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(c.a.r0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            ((c.a.r0.g0.f0.l) bVar).x = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public void k(c.a.r0.q2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        String first_class = fVar.l() != null ? fVar.l().getFirst_class() : "";
        List<ThreadInfo> I = fVar.I();
        LinkedList linkedList = new LinkedList();
        b(I, linkedList, first_class);
        this.f21827b.h(linkedList);
    }
}
