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
import c.a.o0.r.r.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
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
public class l0<T extends c.a.o0.r.r.a> implements q, c.a.p0.v.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public p<T> f3441b;

    /* renamed from: c  reason: collision with root package name */
    public Context f3442c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f3443d;

    /* renamed from: e  reason: collision with root package name */
    public ThreadCardView f3444e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f3445f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f3446g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.l.a<T> f3447h;
    public c.a.l.a<T> i;
    public List<h> j;
    public c.a.l.a<T> k;
    public ArrayList<c> l;
    public q m;
    public m0 n;
    public T o;
    public c.a.l.w0.a p;
    public int q;
    public a.C0196a r;

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0 a;

        public a(l0 l0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l0Var;
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
                    this.a.r.d(Boolean.FALSE);
                    l0 l0Var = this.a;
                    l0Var.o(l0Var.r);
                    return false;
                }
                this.a.r.d(Boolean.TRUE);
                l0 l0Var2 = this.a;
                l0Var2.o(l0Var2.r);
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.b() == null) {
            return;
        }
        n(cVar);
        cVar.b().setVisibility(0);
        if (cVar.d() == null) {
            this.f3445f.addView(cVar.b(), cVar.c());
        } else {
            this.f3445f.addView(cVar.b(), cVar.c(), cVar.d());
        }
        cVar.j(this);
        cVar.e();
        this.l.add(cVar);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c cVar = new c();
            cVar.g(new TbImageView(this.f3442c));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(this.f3442c, R.dimen.obfuscated_res_0x7f070259), c.a.d.f.p.n.f(this.f3442c, R.dimen.obfuscated_res_0x7f0702cb));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.n.f3461g;
            cVar.i(layoutParams);
            cVar.h(-1);
            this.l.add(cVar);
        }
    }

    public final void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                z = 8 != viewGroup.getChildAt(i).getVisibility();
                if (z) {
                    break;
                }
            }
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    @Override // c.a.p0.v.e
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public c.a.l.a<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (c.a.l.a) invokeV.objValue;
    }

    public c.a.l.a<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (c.a.l.a) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3442c : (Context) invokeV.objValue;
    }

    public List<h> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : invokeV.intValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrameLayout frameLayout = this.f3443d;
            return frameLayout != null ? frameLayout : this.f3444e;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.n == null) {
            return;
        }
        if (this.f3446g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            m0 m0Var = this.n;
            ((ViewGroup.MarginLayoutParams) this.f3446g.getLayoutParams()).setMargins(m0Var.f3460f, m0Var.f3458d, m0Var.f3461g, m0Var.f3459e);
            this.f3446g.postInvalidate();
        }
        if (this.n.a) {
            c();
        }
        c.a.l.a<T> aVar = this.f3447h;
        if (aVar != null) {
            aVar.j(this);
            this.f3446g.addView(this.f3447h.g());
            this.f3447h.h();
        }
        c.a.l.a<T> aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.j(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.n.f3456b;
            if (this.i.f().booleanValue()) {
                m0 m0Var2 = this.n;
                layoutParams.leftMargin = -m0Var2.f3460f;
                layoutParams.rightMargin = -m0Var2.f3461g;
            }
            this.f3446g.addView(this.i.g(), layoutParams);
            this.i.h();
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                h hVar = this.j.get(i);
                if (hVar != null) {
                    hVar.j(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = hVar.p();
                    layoutParams2.bottomMargin = hVar.o();
                    if (hVar.f().booleanValue()) {
                        m0 m0Var3 = this.n;
                        layoutParams2.leftMargin = -m0Var3.f3460f;
                        layoutParams2.rightMargin = -m0Var3.f3461g;
                    }
                    this.f3446g.addView(hVar.g(), layoutParams2);
                    hVar.h();
                }
            }
        }
        if (this.k != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.n.f3457c;
            this.k.j(this);
            this.f3446g.addView(this.k.g(), layoutParams3);
            this.k.h();
        }
        if (ListUtils.isEmpty(this.l)) {
            return;
        }
        Iterator<c> it = this.l.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.b() != null) {
                if (next.d() == null) {
                    this.f3445f.addView(next.b(), next.c());
                } else {
                    this.f3445f.addView(next.b(), next.c(), next.d());
                }
                next.j(this);
                next.e();
            }
        }
    }

    public void l(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            this.o = t;
            c.a.l.a<T> aVar = this.f3447h;
            if (aVar != null) {
                aVar.a(t);
            }
            c.a.l.a<T> aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a(t);
            }
            if (!ListUtils.isEmpty(this.j)) {
                int size = this.j.size();
                for (int i = 0; i < size; i++) {
                    h hVar = this.j.get(i);
                    hVar.a(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(hVar.g(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            c.a.l.a<T> aVar3 = this.k;
            if (aVar3 != null) {
                aVar3.a(t);
            }
            p<T> pVar = this.f3441b;
            if (pVar != null) {
                pVar.a(t);
            }
            d(this.f3446g);
            d(this.f3445f);
        }
    }

    public void m(int i, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bVar) == null) {
            this.p.a(i, bVar);
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || cVar == null || cVar.b() == null) {
            return;
        }
        this.l.remove(cVar);
        if (cVar.b().getParent() != null) {
            ((ViewGroup) cVar.b().getParent()).removeView(cVar.b());
            cVar.f();
            cVar.j(null);
        }
    }

    public boolean o(a.C0196a c0196a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, c0196a)) == null) ? this.p.b(c0196a) : invokeL.booleanValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i) == null) || i == this.a) {
            return;
        }
        this.a = i;
        T t3 = this.o;
        if (t3 != null && !t3.isSupportNone()) {
            SkinManager.setBackgroundResource(this.f3444e, this.n.f3462h);
        }
        c.a.l.a<T> aVar = this.f3447h;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i);
            if (this.k == null && ((t2 = this.o) == null || !t2.isSupportContent())) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f3444e);
                d2.m(1);
                d2.n(R.string.J_X06);
                d2.f(this.n.f3462h);
            }
        }
        c.a.l.a<T> aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.onChangeSkinType(tbPageContext, i);
        }
        for (h hVar : this.j) {
            if (hVar != null) {
                hVar.onChangeSkinType(tbPageContext, i);
            }
        }
        c.a.l.a<T> aVar3 = this.k;
        if (aVar3 != null) {
            aVar3.onChangeSkinType(tbPageContext, i);
            if (this.f3447h == null && ((t = this.o) == null || !t.isSupportContent())) {
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.f3444e);
                d3.m(2);
                d3.n(R.string.J_X06);
                d3.f(this.n.f3462h);
            }
        }
        if (this.f3447h != null && this.k != null) {
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.f3444e);
            d4.n(R.string.J_X06);
            d4.i(this.n.f3462h, R.color.CAM_X0206);
        }
        FrameLayout frameLayout = this.f3443d;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
        }
        if (!ListUtils.isEmpty(this.l)) {
            Iterator<c> it = this.l.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && (next instanceof q)) {
                    ((q) next).onChangeSkinType(tbPageContext, i);
                }
            }
        }
        q qVar = this.m;
        if (qVar != null) {
            qVar.onChangeSkinType(tbPageContext, i);
        }
    }

    public void p(c.a.p0.h0.b0<T> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, b0Var) == null) {
            c.a.l.a<T> aVar = this.f3447h;
            if (aVar != null) {
                aVar.l(b0Var);
            }
            c.a.l.a<T> aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.l(b0Var);
            }
            for (h hVar : this.j) {
                if (hVar != null) {
                    hVar.l(b0Var);
                }
            }
            c.a.l.a<T> aVar3 = this.k;
            if (aVar3 != null) {
                aVar3.l(b0Var);
            }
        }
    }

    public void q(int i) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (threadCardView = this.f3444e) == null) {
            return;
        }
        threadCardView.setPosition(i);
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.q = i;
        }
    }

    public /* synthetic */ l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, c.a.d.o.e.s sVar, a aVar) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this(bVar, supportType, viewGroup, (c.a.d.o.e.s) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (c.a.d.o.e.s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, c.a.d.o.e.s sVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, sVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f3441b = null;
        this.m = null;
        this.p = new c.a.l.w0.a();
        this.q = 0;
        this.r = new a.C0196a(7);
        this.f3442c = bVar.f3452f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.f3442c).inflate(R.layout.obfuscated_res_0x7f0d082e, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.f3442c);
            this.f3443d = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.f3442c).inflate(R.layout.obfuscated_res_0x7f0d082e, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.obfuscated_res_0x7f091f9a);
        this.f3444e = threadCardView;
        this.f3445f = (RelativeLayout) threadCardView.findViewById(R.id.obfuscated_res_0x7f0904f2);
        LinearLayout linearLayout = (LinearLayout) this.f3444e.findViewById(R.id.obfuscated_res_0x7f090391);
        this.f3446g = linearLayout;
        linearLayout.setClipToPadding(false);
        this.f3447h = bVar.a;
        this.i = bVar.f3448b;
        this.j = bVar.f3449c;
        this.k = bVar.f3450d;
        this.l = bVar.f3451e;
        this.n = bVar.f3453g;
        this.f3444e.setParent(viewGroup);
        this.f3444e.setITypeListView(sVar);
        k();
        int f2 = this.n.a() ? c.a.d.f.p.n.f(this.f3442c, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.f3444e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3444e.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + f2, marginLayoutParams.topMargin + this.n.i, marginLayoutParams.rightMargin + f2, marginLayoutParams.bottomMargin);
                this.f3444e.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.f3444e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f3444e.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + f2, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin + f2, marginLayoutParams2.bottomMargin);
                this.f3444e.postInvalidate();
            }
        } else if (f2 != 0 && (this.f3444e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f3444e.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + f2, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + f2, marginLayoutParams3.bottomMargin);
            this.f3444e.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.l.a f3448b;

        /* renamed from: c  reason: collision with root package name */
        public List<h> f3449c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.l.a f3450d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f3451e;

        /* renamed from: f  reason: collision with root package name */
        public Context f3452f;

        /* renamed from: g  reason: collision with root package name */
        public m0 f3453g;

        public b(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f3448b = null;
            this.f3450d = null;
            this.f3452f = context;
            this.f3451e = new ArrayList<>();
            m0 m0Var = new m0();
            this.f3453g = m0Var;
            if (!z) {
                m0Var.i(0);
            }
            this.f3449c = new ArrayList();
        }

        public b h(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
                this.f3449c.add(hVar);
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

        public l0 k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, c.a.d.o.e.s sVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, sVar)) == null) ? new l0(this, supportType, viewGroup, sVar, null) : (l0) invokeLLL.objValue;
        }

        public m0 l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3453g : (m0) invokeV.objValue;
        }

        public b m(c.a.l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
                this.f3450d = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(c.a.l.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
                this.f3448b = aVar;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
