package b.a.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.l.w0.a;
import b.a.q0.s.q.a;
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
public class l0<T extends b.a.q0.s.q.a> implements q, b.a.r0.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f3334e;

    /* renamed from: f  reason: collision with root package name */
    public p<T> f3335f;

    /* renamed from: g  reason: collision with root package name */
    public Context f3336g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f3337h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCardView f3338i;
    public RelativeLayout j;
    public LinearLayout k;
    public b.a.l.a<T> l;
    public b.a.l.a<T> m;
    public List<h> n;
    public b.a.l.a<T> o;
    public ArrayList<c> p;
    public q q;
    public m0 r;
    public T s;
    public b.a.l.w0.a t;
    public int u;
    public a.C0092a v;

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l0 f3339e;

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
            this.f3339e = l0Var;
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
                    this.f3339e.v.d(Boolean.FALSE);
                    l0 l0Var = this.f3339e;
                    l0Var.n(l0Var.v);
                    return false;
                }
                this.f3339e.v.d(Boolean.TRUE);
                l0 l0Var2 = this.f3339e;
                l0Var2.n(l0Var2.v);
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
        m(cVar);
        cVar.a().setVisibility(0);
        if (cVar.c() == null) {
            this.j.addView(cVar.a(), cVar.b());
        } else {
            this.j.addView(cVar.a(), cVar.b(), cVar.c());
        }
        cVar.i(this);
        cVar.d();
        this.p.add(cVar);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c cVar = new c();
            cVar.f(new TbImageView(this.f3336g));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b.a.e.f.p.l.g(this.f3336g, R.dimen.ds180), b.a.e.f.p.l.g(this.f3336g, R.dimen.ds50));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.r.f3354g;
            cVar.h(layoutParams);
            cVar.g(-1);
            this.p.add(cVar);
        }
    }

    public final void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
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

    public b.a.l.a<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : (b.a.l.a) invokeV.objValue;
    }

    public b.a.l.a<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (b.a.l.a) invokeV.objValue;
    }

    public List<h> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3336g : (Context) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.u : invokeV.intValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FrameLayout frameLayout = this.f3337h;
            return frameLayout != null ? frameLayout : this.f3338i;
        }
        return (View) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.r == null) {
            return;
        }
        if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            m0 m0Var = this.r;
            ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).setMargins(m0Var.f3353f, m0Var.f3351d, m0Var.f3354g, m0Var.f3352e);
            this.k.postInvalidate();
        }
        if (this.r.f3348a) {
            c();
        }
        b.a.l.a<T> aVar = this.l;
        if (aVar != null) {
            aVar.i(this);
            this.k.addView(this.l.f());
            this.l.g();
        }
        b.a.l.a<T> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.i(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.r.f3349b;
            if (this.m.e().booleanValue()) {
                m0 m0Var2 = this.r;
                layoutParams.leftMargin = -m0Var2.f3353f;
                layoutParams.rightMargin = -m0Var2.f3354g;
            }
            this.k.addView(this.m.f(), layoutParams);
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
                        layoutParams2.leftMargin = -m0Var3.f3353f;
                        layoutParams2.rightMargin = -m0Var3.f3354g;
                    }
                    this.k.addView(hVar.f(), layoutParams2);
                    hVar.g();
                }
            }
        }
        if (this.o != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.r.f3350c;
            this.o.i(this);
            this.k.addView(this.o.f(), layoutParams3);
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
                    this.j.addView(next.a(), next.b());
                } else {
                    this.j.addView(next.a(), next.b(), next.c());
                }
                next.i(this);
                next.d();
            }
        }
    }

    public void k(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, t) == null) {
            this.s = t;
            b.a.l.a<T> aVar = this.l;
            if (aVar != null) {
                aVar.onBindDataToView(t);
            }
            b.a.l.a<T> aVar2 = this.m;
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
                        ThreadCardUtils.dealMainViewTopMargin(hVar.f(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().f3() < 1 && t.getThreadData().r1() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            b.a.l.a<T> aVar3 = this.o;
            if (aVar3 != null) {
                aVar3.onBindDataToView(t);
            }
            p<T> pVar = this.f3335f;
            if (pVar != null) {
                pVar.onBindDataToView(t);
            }
            d(this.k);
            d(this.j);
        }
    }

    public void l(int i2, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, bVar) == null) {
            this.t.a(i2, bVar);
        }
    }

    public void m(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) || cVar == null || cVar.a() == null) {
            return;
        }
        this.p.remove(cVar);
        if (cVar.a().getParent() != null) {
            ((ViewGroup) cVar.a().getParent()).removeView(cVar.a());
            cVar.e();
            cVar.i(null);
        }
    }

    public boolean n(a.C0092a c0092a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, c0092a)) == null) ? this.t.b(c0092a) : invokeL.booleanValue;
    }

    public void o(b.a.r0.b0.d0<T> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, d0Var) == null) {
            b.a.l.a<T> aVar = this.l;
            if (aVar != null) {
                aVar.k(d0Var);
            }
            b.a.l.a<T> aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.k(d0Var);
            }
            for (h hVar : this.n) {
                if (hVar != null) {
                    hVar.k(d0Var);
                }
            }
            b.a.l.a<T> aVar3 = this.o;
            if (aVar3 != null) {
                aVar3.k(d0Var);
            }
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i2) == null) || i2 == this.f3334e) {
            return;
        }
        this.f3334e = i2;
        T t3 = this.s;
        if (t3 != null && !t3.isSupportNone()) {
            SkinManager.setBackgroundResource(this.f3338i, this.r.f3355h);
        }
        b.a.l.a<T> aVar = this.l;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i2);
            if (this.o == null && ((t2 = this.s) == null || !t2.isSupportContent())) {
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f3338i);
                d2.m(1);
                d2.n(R.string.J_X06);
                d2.f(this.r.f3355h);
            }
        }
        b.a.l.a<T> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.onChangeSkinType(tbPageContext, i2);
            if (TbSingleton.mIsAbNightModeColor && this.s != null) {
                b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.f3338i);
                d3.m(0);
                d3.n(R.string.J_X02);
                d3.f(this.r.f3355h);
            }
        }
        for (h hVar : this.n) {
            if (hVar != null) {
                hVar.onChangeSkinType(tbPageContext, i2);
            }
        }
        b.a.l.a<T> aVar3 = this.o;
        if (aVar3 != null) {
            aVar3.onChangeSkinType(tbPageContext, i2);
            if (this.l == null && ((t = this.s) == null || !t.isSupportContent())) {
                b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.f3338i);
                d4.m(2);
                d4.n(R.string.J_X06);
                d4.f(this.r.f3355h);
            }
        }
        if (this.l != null && this.o != null) {
            b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(this.f3338i);
            d5.n(R.string.J_X06);
            d5.i(this.r.f3355h, R.color.CAM_X0206);
        }
        FrameLayout frameLayout = this.f3337h;
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

    public void p(int i2) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (threadCardView = this.f3338i) == null) {
            return;
        }
        threadCardView.setPosition(i2);
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.u = i2;
        }
    }

    @Override // b.a.r0.p.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }

    public /* synthetic */ l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, b.a.e.m.e.s sVar, a aVar) {
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
        this(bVar, supportType, viewGroup, (b.a.e.m.e.s) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (b.a.e.m.e.s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, b.a.e.m.e.s sVar) {
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
        this.f3334e = 3;
        this.f3335f = null;
        this.q = null;
        this.t = new b.a.l.w0.a();
        this.u = 0;
        this.v = new a.C0092a(7);
        this.f3336g = bVar.f3345f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.f3336g).inflate(R.layout.thread_card_layout, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.f3336g);
            this.f3337h = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.f3336g).inflate(R.layout.thread_card_layout, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.f3338i = threadCardView;
        this.j = (RelativeLayout) threadCardView.findViewById(R.id.card_decor_layer);
        LinearLayout linearLayout = (LinearLayout) this.f3338i.findViewById(R.id.body_root);
        this.k = linearLayout;
        linearLayout.setClipToPadding(false);
        this.l = bVar.f3340a;
        this.m = bVar.f3341b;
        this.n = bVar.f3342c;
        this.o = bVar.f3343d;
        this.p = bVar.f3344e;
        this.r = bVar.f3346g;
        this.f3338i.setParent(viewGroup);
        this.f3338i.setITypeListView(sVar);
        j();
        int g2 = this.r.a() ? b.a.e.f.p.l.g(this.f3336g, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.f3338i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3338i.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + g2, marginLayoutParams.topMargin + this.r.f3356i, marginLayoutParams.rightMargin + g2, marginLayoutParams.bottomMargin);
                this.f3338i.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.f3338i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f3338i.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + g2, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin + g2, marginLayoutParams2.bottomMargin);
                this.f3338i.postInvalidate();
            }
        } else if (g2 != 0 && (this.f3338i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f3338i.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + g2, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + g2, marginLayoutParams3.bottomMargin);
            this.f3338i.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.l.a f3340a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.l.a f3341b;

        /* renamed from: c  reason: collision with root package name */
        public List<h> f3342c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.l.a f3343d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f3344e;

        /* renamed from: f  reason: collision with root package name */
        public Context f3345f;

        /* renamed from: g  reason: collision with root package name */
        public m0 f3346g;

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
            this.f3340a = null;
            this.f3341b = null;
            this.f3343d = null;
            this.f3345f = context;
            this.f3344e = new ArrayList<>();
            m0 m0Var = new m0();
            this.f3346g = m0Var;
            if (!z) {
                m0Var.h(0);
            }
            this.f3342c = new ArrayList();
        }

        public b h(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
                this.f3342c.add(hVar);
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

        public l0 k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, b.a.e.m.e.s sVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, sVar)) == null) ? new l0(this, supportType, viewGroup, sVar, null) : (l0) invokeLLL.objValue;
        }

        public m0 l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3346g : (m0) invokeV.objValue;
        }

        public b m(b.a.l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
                this.f3343d = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(b.a.l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
                this.f3341b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(b.a.l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
                this.f3340a = aVar;
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
