package c.a.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.l.w0.a;
import c.a.s0.s.q.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l0<T extends c.a.s0.s.q.a> implements q, c.a.t0.t.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f4255e;

    /* renamed from: f  reason: collision with root package name */
    public p<T> f4256f;

    /* renamed from: g  reason: collision with root package name */
    public Context f4257g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f4258h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCardView f4259i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f4260j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f4261k;
    public c.a.l.a<T> l;
    public c.a.l.a<T> m;
    public List<h> n;
    public c.a.l.a<T> o;
    public ArrayList<c> p;
    public q q;
    public m0 r;
    public T s;
    public c.a.l.w0.a t;
    public int u;
    public a.C0186a v;

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l0 f4262e;

        public a(l0 l0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4262e = l0Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                        }
                    }
                    this.f4262e.v.d(Boolean.FALSE);
                    l0 l0Var = this.f4262e;
                    l0Var.o(l0Var.v);
                    return false;
                }
                this.f4262e.v.d(Boolean.TRUE);
                l0 l0Var2 = this.f4262e;
                l0Var2.o(l0Var2.v);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public /* synthetic */ l0(b bVar, a aVar) {
        this(bVar);
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.a() == null) {
            return;
        }
        n(cVar);
        cVar.a().setVisibility(0);
        if (cVar.c() == null) {
            this.f4260j.addView(cVar.a(), cVar.b());
        } else {
            this.f4260j.addView(cVar.a(), cVar.b(), cVar.c());
        }
        cVar.i(this);
        cVar.d();
        this.p.add(cVar);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c cVar = new c();
            cVar.f(new TbImageView(this.f4257g));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(this.f4257g, R.dimen.ds180), c.a.d.f.p.n.f(this.f4257g, R.dimen.ds50));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.r.f4278g;
            cVar.h(layoutParams);
            cVar.g(-1);
            this.p.add(cVar);
        }
    }

    @Override // c.a.t0.t.e
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public final void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                z = 8 != viewGroup.getChildAt(i2).getVisibility();
                if (z) {
                    break;
                }
            }
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public c.a.l.a<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : (c.a.l.a) invokeV.objValue;
    }

    public c.a.l.a<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : (c.a.l.a) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f4257g : (Context) invokeV.objValue;
    }

    public List<h> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.u : invokeV.intValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrameLayout frameLayout = this.f4258h;
            return frameLayout != null ? frameLayout : this.f4259i;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.r == null) {
            return;
        }
        if (this.f4261k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            m0 m0Var = this.r;
            ((ViewGroup.MarginLayoutParams) this.f4261k.getLayoutParams()).setMargins(m0Var.f4277f, m0Var.f4275d, m0Var.f4278g, m0Var.f4276e);
            this.f4261k.postInvalidate();
        }
        if (this.r.a) {
            c();
        }
        c.a.l.a<T> aVar = this.l;
        if (aVar != null) {
            aVar.i(this);
            this.f4261k.addView(this.l.f());
            this.l.g();
        }
        c.a.l.a<T> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.i(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.r.f4273b;
            if (this.m.e().booleanValue()) {
                m0 m0Var2 = this.r;
                layoutParams.leftMargin = -m0Var2.f4277f;
                layoutParams.rightMargin = -m0Var2.f4278g;
            }
            this.f4261k.addView(this.m.f(), layoutParams);
            this.m.g();
        }
        if (this.n != null) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                h hVar = this.n.get(i2);
                if (hVar != null) {
                    hVar.i(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = hVar.o();
                    layoutParams2.bottomMargin = hVar.n();
                    if (hVar.e().booleanValue()) {
                        m0 m0Var3 = this.r;
                        layoutParams2.leftMargin = -m0Var3.f4277f;
                        layoutParams2.rightMargin = -m0Var3.f4278g;
                    }
                    this.f4261k.addView(hVar.f(), layoutParams2);
                    hVar.g();
                }
            }
        }
        if (this.o != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.r.f4274c;
            this.o.i(this);
            this.f4261k.addView(this.o.f(), layoutParams3);
            this.o.g();
        }
        if (ListUtils.isEmpty(this.p)) {
            return;
        }
        Iterator<c> it = this.p.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.a() != null) {
                if (next.c() == null) {
                    this.f4260j.addView(next.a(), next.b());
                } else {
                    this.f4260j.addView(next.a(), next.b(), next.c());
                }
                next.i(this);
                next.d();
            }
        }
    }

    public void l(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            this.s = t;
            c.a.l.a<T> aVar = this.l;
            if (aVar != null) {
                aVar.onBindDataToView(t);
            }
            c.a.l.a<T> aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.onBindDataToView(t);
            }
            if (!ListUtils.isEmpty(this.n)) {
                int size = this.n.size();
                for (int i2 = 0; i2 < size; i2++) {
                    h hVar = this.n.get(i2);
                    hVar.onBindDataToView(t);
                    if (i2 == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(hVar.f(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().h3() < 1 && t.getThreadData().t1() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            c.a.l.a<T> aVar3 = this.o;
            if (aVar3 != null) {
                aVar3.onBindDataToView(t);
            }
            p<T> pVar = this.f4256f;
            if (pVar != null) {
                pVar.onBindDataToView(t);
            }
            e(this.f4261k);
            e(this.f4260j);
        }
    }

    public void m(int i2, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, bVar) == null) {
            this.t.a(i2, bVar);
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || cVar == null || cVar.a() == null) {
            return;
        }
        this.p.remove(cVar);
        if (cVar.a().getParent() != null) {
            ((ViewGroup) cVar.a().getParent()).removeView(cVar.a());
            cVar.e();
            cVar.i(null);
        }
    }

    public boolean o(a.C0186a c0186a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, c0186a)) == null) ? this.t.b(c0186a) : invokeL.booleanValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i2) == null) || i2 == this.f4255e) {
            return;
        }
        this.f4255e = i2;
        T t3 = this.s;
        if (t3 != null && !t3.isSupportNone()) {
            SkinManager.setBackgroundResource(this.f4259i, this.r.f4279h);
        }
        c.a.l.a<T> aVar = this.l;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i2);
            if (this.o == null && ((t2 = this.s) == null || !t2.isSupportContent())) {
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f4259i);
                d2.m(1);
                d2.n(R.string.J_X06);
                d2.f(this.r.f4279h);
            }
        }
        c.a.l.a<T> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.onChangeSkinType(tbPageContext, i2);
            if (TbSingleton.mIsAbNightModeColor && this.s != null) {
                c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.f4259i);
                d3.m(0);
                d3.n(R.string.J_X02);
                d3.f(this.r.f4279h);
            }
        }
        for (h hVar : this.n) {
            if (hVar != null) {
                hVar.onChangeSkinType(tbPageContext, i2);
            }
        }
        c.a.l.a<T> aVar3 = this.o;
        if (aVar3 != null) {
            aVar3.onChangeSkinType(tbPageContext, i2);
            if (this.l == null && ((t = this.s) == null || !t.isSupportContent())) {
                c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(this.f4259i);
                d4.m(2);
                d4.n(R.string.J_X06);
                d4.f(this.r.f4279h);
            }
        }
        if (this.l != null && this.o != null) {
            c.a.s0.s.u.c d5 = c.a.s0.s.u.c.d(this.f4259i);
            d5.n(R.string.J_X06);
            d5.i(this.r.f4279h, R.color.CAM_X0206);
        }
        FrameLayout frameLayout = this.f4258h;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
        }
        if (!ListUtils.isEmpty(this.p)) {
            Iterator<c> it = this.p.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && (next instanceof q)) {
                    ((q) next).onChangeSkinType(tbPageContext, i2);
                }
            }
        }
        q qVar = this.q;
        if (qVar != null) {
            qVar.onChangeSkinType(tbPageContext, i2);
        }
    }

    public void p(c.a.t0.g0.d0<T> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d0Var) == null) {
            c.a.l.a<T> aVar = this.l;
            if (aVar != null) {
                aVar.k(d0Var);
            }
            c.a.l.a<T> aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.k(d0Var);
            }
            for (h hVar : this.n) {
                if (hVar != null) {
                    hVar.k(d0Var);
                }
            }
            c.a.l.a<T> aVar3 = this.o;
            if (aVar3 != null) {
                aVar3.k(d0Var);
            }
        }
    }

    public void q(int i2) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (threadCardView = this.f4259i) == null) {
            return;
        }
        threadCardView.setPosition(i2);
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.u = i2;
        }
    }

    public /* synthetic */ l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, c.a.d.n.e.s sVar, a aVar) {
        this(bVar, supportType, viewGroup, sVar);
    }

    public /* synthetic */ l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l0(b bVar) {
        this(bVar, BaseCardInfo.SupportType.FULL);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l0(b bVar, BaseCardInfo.SupportType supportType) {
        this(bVar, supportType, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (c.a.d.n.e.s) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (c.a.d.n.e.s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, c.a.d.n.e.s sVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, sVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f4255e = 3;
        this.f4256f = null;
        this.q = null;
        this.t = new c.a.l.w0.a();
        this.u = 0;
        this.v = new a.C0186a(7);
        this.f4257g = bVar.f4267f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.f4257g).inflate(R.layout.thread_card_layout, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.f4257g);
            this.f4258h = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.f4257g).inflate(R.layout.thread_card_layout, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.f4259i = threadCardView;
        this.f4260j = (RelativeLayout) threadCardView.findViewById(R.id.card_decor_layer);
        LinearLayout linearLayout = (LinearLayout) this.f4259i.findViewById(R.id.body_root);
        this.f4261k = linearLayout;
        linearLayout.setClipToPadding(false);
        this.l = bVar.a;
        this.m = bVar.f4263b;
        this.n = bVar.f4264c;
        this.o = bVar.f4265d;
        this.p = bVar.f4266e;
        this.r = bVar.f4268g;
        this.f4259i.setParent(viewGroup);
        this.f4259i.setITypeListView(sVar);
        k();
        int f2 = this.r.a() ? c.a.d.f.p.n.f(this.f4257g, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.f4259i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4259i.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + f2, marginLayoutParams.topMargin + this.r.f4280i, marginLayoutParams.rightMargin + f2, marginLayoutParams.bottomMargin);
                this.f4259i.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.f4259i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f4259i.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + f2, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin + f2, marginLayoutParams2.bottomMargin);
                this.f4259i.postInvalidate();
            }
        } else if (f2 != 0 && (this.f4259i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f4259i.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + f2, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + f2, marginLayoutParams3.bottomMargin);
            this.f4259i.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.l.a f4263b;

        /* renamed from: c  reason: collision with root package name */
        public List<h> f4264c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.l.a f4265d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f4266e;

        /* renamed from: f  reason: collision with root package name */
        public Context f4267f;

        /* renamed from: g  reason: collision with root package name */
        public m0 f4268g;

        public b(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f4263b = null;
            this.f4265d = null;
            this.f4267f = context;
            this.f4266e = new ArrayList<>();
            m0 m0Var = new m0();
            this.f4268g = m0Var;
            if (!z) {
                m0Var.h(0);
            }
            this.f4264c = new ArrayList();
        }

        public b h(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
                this.f4264c.add(hVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public l0 i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new l0(this, (a) null) : (l0) invokeV.objValue;
        }

        public l0 j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) ? new l0(this, supportType, viewGroup, (a) null) : (l0) invokeLL.objValue;
        }

        public l0 k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, c.a.d.n.e.s sVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, sVar)) == null) ? new l0(this, supportType, viewGroup, sVar, null) : (l0) invokeLLL.objValue;
        }

        public m0 l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f4268g : (m0) invokeV.objValue;
        }

        public b m(c.a.l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
                this.f4265d = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(c.a.l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
                this.f4263b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(c.a.l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
                this.a = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            this(context, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }
}
