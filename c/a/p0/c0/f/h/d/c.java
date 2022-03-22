package c.a.p0.c0.f.h.d;

import android.graphics.drawable.Drawable;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.i.a;
import c.a.d.o.e.n;
import c.a.o0.f0.h;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public int f13134b;

    /* renamed from: c  reason: collision with root package name */
    public f f13135c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f13136d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13137e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13138f;

    /* renamed from: g  reason: collision with root package name */
    public View f13139g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f13140h;
    public g i;
    public NavigationBar j;
    public LinearLayout k;
    public c.a.o0.f0.g l;
    public PbListView m;
    public h n;
    public final List<c.a.d.o.e.a> o;
    public c.a.p0.c0.f.h.a.a p;
    public c.a.p0.c0.f.h.a.b q;
    public b r;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PopupWindow a;

        /* renamed from: b  reason: collision with root package name */
        public View f13141b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13142c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13143d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f13144e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f13145f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f13146g;

        /* renamed from: h  reason: collision with root package name */
        public String f13147h;
        public a.c i;
        public final /* synthetic */ c j;

        /* loaded from: classes2.dex */
        public class a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.d.f.i.a.c
            public void a(int i, String str, Address address) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) {
                    if (address != null) {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();
                        if (latitude == 0.0d || longitude == 0.0d) {
                            return;
                        }
                        c.a.p0.c0.f.h.b.c cVar = new c.a.p0.c0.f.h.b.c();
                        cVar.a = this.a.f13147h;
                        cVar.f13117b = String.valueOf(latitude);
                        cVar.f13118c = String.valueOf(longitude);
                        cVar.f13119d = true;
                        this.a.j.f13135c.b(cVar);
                        this.a.f13143d.setText(this.a.f13147h);
                    } else if (StringUtils.isNull(str)) {
                    } else {
                        this.a.j.a.showToast(str);
                    }
                }
            }
        }

        public b(c cVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = cVar;
            this.f13146g = false;
            this.i = new a(this);
            this.f13141b = view;
            this.f13142c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0912bb);
            TextView textView = (TextView) this.f13141b.findViewById(R.id.obfuscated_res_0x7f0912c4);
            this.f13143d = textView;
            textView.setVisibility(8);
            this.f13143d.setOnClickListener(this);
            f();
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f13145f = list;
                if (ListUtils.isEmpty(list) || this.f13146g) {
                    return;
                }
                this.f13146g = true;
                String str = this.f13145f.get(0);
                if (!StringUtils.isNull(str)) {
                    this.f13143d.setText(str);
                    this.f13143d.setVisibility(0);
                }
                this.f13144e = new LinearLayout(this.j.a.getPageActivity());
                this.f13144e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                SkinManager.setBackgroundResource(this.f13144e, R.drawable.bg_ala_sub_list_sort_panel);
                this.f13144e.setClipChildren(true);
                this.f13144e.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.j.a.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070255), this.j.a.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0702ff));
                for (int i = 0; i < this.f13145f.size(); i++) {
                    this.f13144e.addView(e(this.f13145f.get(i)), layoutParams);
                    if (i != this.f13145f.size() - 1) {
                        View view = new View(this.j.a.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.j.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198)));
                        SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                        this.f13144e.addView(view);
                    }
                }
                if (this.a == null) {
                    PopupWindow popupWindow = new PopupWindow(this.j.a.getPageActivity());
                    this.a = popupWindow;
                    popupWindow.setContentView(this.f13144e);
                    this.a.setWidth(-2);
                    this.a.setHeight(-2);
                    this.a.setAnimationStyle(16973826);
                    this.a.setBackgroundDrawable(this.j.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f88));
                    this.a.setOutsideTouchable(true);
                    this.a.setFocusable(true);
                    this.a.setTouchable(true);
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.isSystemLocationProviderEnabled(this.j.a.getPageActivity()) : invokeV.booleanValue;
        }

        public final TextView e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TextView textView = new TextView(this.j.a.getPageActivity());
                textView.setTextSize(0, this.j.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9));
                textView.setText(str);
                textView.setTag(str);
                textView.setGravity(17);
                SkinManager.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
                textView.setOnClickListener(this);
                return textView;
            }
            return (TextView) invokeL.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.f13142c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f13143d, (int) R.color.CAM_X0109);
                this.f13143d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.f13141b.setVisibility(i);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f13143d.getLocationOnScreen(iArr);
            int height = ((View) this.f13143d.getParent()).getHeight() - this.f13143d.getHeight();
            if (iArr[1] - this.a.getHeight() <= 50) {
                c.a.d.f.m.g.d(this.a, this.j.a.getPageActivity());
                return;
            }
            c.a.d.f.m.g.m(this.a, this.j.f13137e, 0, (iArr[0] - (this.f13143d.getWidth() / 2)) - this.j.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), iArr[1] + this.f13143d.getHeight() + height);
            PopupWindow popupWindow = this.a;
            if (popupWindow != null) {
                popupWindow.update();
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.f13142c == null) {
                return;
            }
            this.f13142c.setText(this.j.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11b5, StringHelper.numberUniformFormatExtra(i)));
            this.f13141b.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
                if (view == this.f13143d) {
                    h();
                } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
                } else {
                    PopupWindow popupWindow = this.a;
                    if (popupWindow != null) {
                        c.a.d.f.m.g.d(popupWindow, this.j.a.getPageActivity());
                    }
                    if (this.j.f13135c != null) {
                        String str = (String) view.getTag();
                        this.f13147h = str;
                        if (str.contains("距离")) {
                            if (!d()) {
                                this.j.a.showToast(R.string.obfuscated_res_0x7f0f11b2);
                                return;
                            } else {
                                c.a.d.f.i.a.n().k(false, this.i);
                                return;
                            }
                        }
                        c.a.p0.c0.f.h.b.c cVar = new c.a.p0.c0.f.h.b.c();
                        cVar.a = this.f13147h;
                        cVar.f13119d = false;
                        this.j.f13135c.b(cVar);
                        this.f13143d.setText(this.f13147h);
                    }
                }
            }
        }
    }

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13134b = -1;
        this.f13136d = BdUniqueId.gen();
        this.o = new ArrayList();
        this.a = tbPageContext;
        this.f13137e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0602, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0111, (ViewGroup) null);
        this.f13138f = (LinearLayout) this.f13137e.findViewById(R.id.obfuscated_res_0x7f09128f);
        View findViewById = this.f13137e.findViewById(R.id.obfuscated_res_0x7f091dc1);
        this.f13139g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f13140h = (BdTypeListView) this.f13137e.findViewById(R.id.obfuscated_res_0x7f091279);
        g gVar = new g(this.a);
        this.i = gVar;
        gVar.a0(this.f13136d);
        this.f13140h.setPullRefresh(this.i);
        PbListView pbListView = new PbListView(this.a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        c.a.p0.c0.f.h.a.a aVar = new c.a.p0.c0.f.h.a.a(this.a);
        this.p = aVar;
        aVar.c0(2);
        c.a.p0.c0.f.h.a.b bVar2 = new c.a.p0.c0.f.h.a.b(this.a);
        this.q = bVar2;
        bVar2.c0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f13140h.a(this.o);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13140h.z();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13140h : (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13137e : (View) invokeV.objValue;
    }

    public void g() {
        c.a.o0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this.f13137e);
        this.l = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this.f13137e);
        this.n = null;
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.m) == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f13140h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            if (this.f13134b != i) {
                this.f13134b = i;
            }
            b bVar = this.r;
            if (bVar != null) {
                bVar.f();
            }
            c.a.o0.f0.g gVar = this.l;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            NavigationBar navigationBar = this.j;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i);
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.d(i);
            }
            h hVar = this.n;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f13137e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.f0.g gVar = this.l;
            if (gVar != null) {
                if (gVar.j() != null) {
                    this.l.dettachView(this.f13137e);
                }
                this.l.n();
                this.l = null;
            }
            g gVar2 = this.i;
            if (gVar2 != null) {
                gVar2.f(null);
                this.i.g(null);
                this.i.m(null);
                this.i.Y();
                this.i = null;
            }
            BdTypeListView bdTypeListView = this.f13140h;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f13140h.setOnScrollListener(null);
                this.f13140h.setRecyclerListener(null);
                this.f13140h = null;
            }
        }
    }

    public void l(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (bVar = this.r) == null) {
            return;
        }
        bVar.i(i);
    }

    public void m(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.r.c(list);
    }

    public void n(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f13135c = fVar;
            c.a.p0.c0.f.h.a.a aVar = this.p;
            if (aVar != null) {
                aVar.e0(fVar);
            }
            c.a.p0.c0.f.h.a.b bVar = this.q;
            if (bVar != null) {
                bVar.e0(this.f13135c);
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f13138f.setVisibility(i);
        }
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f13140h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.i.f(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f13140h.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), list, str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                NavigationBar navigationBar = new NavigationBar(this.a.getPageActivity());
                this.j = navigationBar;
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
                if (!StringUtils.isNull(str2)) {
                    this.j.setCenterTextTitle(str2);
                } else if (!StringUtils.isNull(str)) {
                    this.j.setCenterTextTitle(str);
                }
                this.f13137e.addView(this.j, 0, new LinearLayout.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.j.getBottomLine(), R.color.CAM_X0204);
            }
            if (!ListUtils.isEmpty(list)) {
                this.r.c(list);
            }
            this.p.f0(z3);
            this.q.f0(z3);
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.a) == null || this.f13137e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new c.a.o0.f0.g(tbPageContext.getPageActivity(), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a3));
        }
        c.a.o0.f0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f13137e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new h(this.a.getPageActivity(), onClickListener);
            }
            this.n.k(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070259));
            this.n.m(str);
            this.n.attachView(this.f13137e, false);
            if (z) {
                this.n.p();
            } else {
                this.n.e();
            }
        }
    }

    public void v() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.m) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f13140h.setNextPage(this.m);
        }
        this.m.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a0b));
        this.m.f();
    }
}
