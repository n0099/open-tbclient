package c.a.u0.u2.u.f.c1;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.t0.s.r.e2;
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
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.u0.u2.u.c.b f23498b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.u0.r0.a f23499c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnTouchListener f23500d;

    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f23501e;

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
            this.f23501e = jVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f23501e.f23499c != null) {
                    this.f23501e.f23499c.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends c.a.t0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.u0.g0.d0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2, String str, c.a.u0.g0.d0.b bVar) {
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

        @Override // c.a.t0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                c.a.u0.g0.d0.b bVar = this.l;
                if (bVar instanceof c.a.u0.g0.d0.k) {
                    statisticItem = ((c.a.u0.g0.d0.k) bVar).T();
                } else if (bVar instanceof c.a.u0.g0.d0.l) {
                    statisticItem = ((c.a.u0.g0.d0.l) bVar).R(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public j(BdTypeRecyclerView bdTypeRecyclerView, c.a.u0.u2.u.c.b bVar) {
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
        this.f23500d = aVar;
        this.a = bdTypeRecyclerView;
        this.f23498b = bVar;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.f23499c = new c.a.u0.r0.a();
    }

    public final void b(List<ThreadInfo> list, List<n> list2, String str) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                ThreadInfo threadInfo = list.get(i3);
                if (threadInfo != null) {
                    e2 e2Var2 = new e2();
                    e2Var2.L2 = i3 + 1;
                    e2Var2.d3(threadInfo);
                    if (e2Var2.Z() != null) {
                        e2Var2.Z().f13751j = str;
                    }
                    if ((c.a.u0.g0.d0.k.X(e2Var2) || c.a.u0.g0.d0.l.S(e2Var2)) && e2Var2.getType() != e2.M3) {
                        c.a.u0.g0.d0.k d2 = d(e2Var2);
                        if (d2 != null && (e2Var = d2.f17886e) != null && e2Var.Z() != null && !StringUtils.isNull(e2Var.Z().f13743b)) {
                            d2.k = e2Var2.w1();
                            d2.position = i2;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] i0 = e2Var2.i0();
                        c.a.u0.g0.d0.b c2 = c(e2Var2);
                        if (c2 != null) {
                            c2.k = e2Var2.w1();
                            c2.position = i2;
                            if (c2 instanceof c.a.u0.g0.d0.k) {
                                if (e2Var2.i3() == 1) {
                                    h(c2);
                                    c2.n = i0[0];
                                    c2.o = i0[1];
                                } else if (e2Var2.i3() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof c.a.u0.g0.d0.l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.f17886e.K1();
                            if (!e2Var2.H2() && e2Var2.J() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(c.a.u0.u2.l.at_username), e2Var2.J().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, e2Var2.J().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.f17886e.L1(spannableString);
                            }
                            list2.add(c2);
                        }
                        c.a.u0.g0.d0.k d3 = d(e2Var2);
                        if (d3 != null) {
                            d3.k = e2Var2.w1();
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

    public final c.a.u0.g0.d0.b c(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var)) == null) {
            if (e2Var == null) {
                return null;
            }
            if (c.a.u0.g0.d0.k.X(e2Var)) {
                c.a.u0.g0.d0.k kVar = new c.a.u0.g0.d0.k();
                e2Var.i2();
                e2Var.A2();
                if (!e2Var.i2() && !e2Var.A2()) {
                    e2Var.d2();
                }
                kVar.f17886e = e2Var;
                return kVar;
            } else if (c.a.u0.g0.d0.l.S(e2Var)) {
                return new c.a.u0.g0.d0.l(e2Var);
            } else {
                return null;
            }
        }
        return (c.a.u0.g0.d0.b) invokeL.objValue;
    }

    public final c.a.u0.g0.d0.k d(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var)) == null) {
            c.a.u0.g0.d0.k kVar = new c.a.u0.g0.d0.k();
            kVar.f17886e = e2Var;
            e2Var.i2();
            if (!e2Var.i2()) {
                e2Var.d2();
            }
            return kVar;
        }
        return (c.a.u0.g0.d0.k) invokeL.objValue;
    }

    public final void e(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar instanceof c.a.u0.g0.d0.k) {
                ((c.a.u0.g0.d0.k) bVar).E = true;
            } else if (bVar instanceof c.a.u0.g0.d0.l) {
                ((c.a.u0.g0.d0.l) bVar).E = true;
            } else if (bVar instanceof c.a.u0.g0.d0.j) {
                ((c.a.u0.g0.d0.j) bVar).E = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public final void f(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            bVar.r = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ((c.a.u0.g0.d0.k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            ((c.a.u0.g0.d0.k) bVar).t = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            ((c.a.u0.g0.d0.k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(c.a.u0.g0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            ((c.a.u0.g0.d0.l) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public void k(c.a.u0.u2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        String first_class = fVar.l() != null ? fVar.l().getFirst_class() : "";
        List<ThreadInfo> I = fVar.I();
        LinkedList linkedList = new LinkedList();
        b(I, linkedList, first_class);
        this.f23498b.h(linkedList);
    }
}
