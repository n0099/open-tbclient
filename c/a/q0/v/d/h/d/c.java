package c.a.q0.v.d.h.d;

import android.graphics.drawable.Drawable;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.i.a;
import c.a.e.l.e.n;
import c.a.p0.f0.h;
import c.a.p0.s.f0.f;
import c.a.p0.s.f0.g;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25415a;

    /* renamed from: b  reason: collision with root package name */
    public int f25416b;

    /* renamed from: c  reason: collision with root package name */
    public f f25417c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f25418d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f25419e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f25420f;

    /* renamed from: g  reason: collision with root package name */
    public View f25421g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f25422h;

    /* renamed from: i  reason: collision with root package name */
    public g f25423i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f25424j;
    public LinearLayout k;
    public c.a.p0.f0.g l;
    public PbListView m;
    public h n;
    public final List<c.a.e.l.e.a> o;
    public c.a.q0.v.d.h.a.a p;
    public c.a.q0.v.d.h.a.b q;
    public b r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25425e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25425e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25425e.f25415a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f25426e;

        /* renamed from: f  reason: collision with root package name */
        public View f25427f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25428g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25429h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f25430i;

        /* renamed from: j  reason: collision with root package name */
        public List<String> f25431j;
        public boolean k;
        public String l;
        public a.c m;
        public final /* synthetic */ c n;

        /* loaded from: classes3.dex */
        public class a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f25432a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25432a = bVar;
            }

            @Override // c.a.e.e.i.a.c
            public void onLocationGeted(int i2, String str, Address address) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                    if (address != null) {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();
                        if (latitude == 0.0d || longitude == 0.0d) {
                            return;
                        }
                        c.a.q0.v.d.h.b.c cVar = new c.a.q0.v.d.h.b.c();
                        cVar.f25385a = this.f25432a.l;
                        cVar.f25386b = String.valueOf(latitude);
                        cVar.f25387c = String.valueOf(longitude);
                        cVar.f25388d = true;
                        this.f25432a.n.f25417c.b(cVar);
                        this.f25432a.f25429h.setText(this.f25432a.l);
                    } else if (StringUtils.isNull(str)) {
                    } else {
                        this.f25432a.n.f25415a.showToast(str);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = cVar;
            this.k = false;
            this.m = new a(this);
            this.f25427f = view;
            this.f25428g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f25427f.findViewById(R.id.live_sort);
            this.f25429h = textView;
            textView.setVisibility(8);
            this.f25429h.setOnClickListener(this);
            f();
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f25431j = list;
                if (ListUtils.isEmpty(list) || this.k) {
                    return;
                }
                this.k = true;
                String str = this.f25431j.get(0);
                if (!StringUtils.isNull(str)) {
                    this.f25429h.setText(str);
                    this.f25429h.setVisibility(0);
                }
                this.f25430i = new LinearLayout(this.n.f25415a.getPageActivity());
                this.f25430i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                SkinManager.setBackgroundResource(this.f25430i, R.drawable.bg_ala_sub_list_sort_panel);
                this.f25430i.setClipChildren(true);
                this.f25430i.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.f25415a.getResources().getDimensionPixelOffset(R.dimen.ds176), this.n.f25415a.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i2 = 0; i2 < this.f25431j.size(); i2++) {
                    this.f25430i.addView(e(this.f25431j.get(i2)), layoutParams);
                    if (i2 != this.f25431j.size() - 1) {
                        View view = new View(this.n.f25415a.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.n.f25415a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                        this.f25430i.addView(view);
                    }
                }
                if (this.f25426e == null) {
                    PopupWindow popupWindow = new PopupWindow(this.n.f25415a.getPageActivity());
                    this.f25426e = popupWindow;
                    popupWindow.setContentView(this.f25430i);
                    this.f25426e.setWidth(-2);
                    this.f25426e.setHeight(-2);
                    this.f25426e.setAnimationStyle(16973826);
                    this.f25426e.setBackgroundDrawable(this.n.f25415a.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.f25426e.setOutsideTouchable(true);
                    this.f25426e.setFocusable(true);
                    this.f25426e.setTouchable(true);
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.isSystemLocationProviderEnabled(this.n.f25415a.getPageActivity()) : invokeV.booleanValue;
        }

        public final TextView e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TextView textView = new TextView(this.n.f25415a.getPageActivity());
                textView.setTextSize(0, this.n.f25415a.getResources().getDimension(R.dimen.ds28));
                textView.setText(str);
                textView.setTag(str);
                textView.setGravity(17);
                SkinManager.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                textView.setOnClickListener(this);
                return textView;
            }
            return (TextView) invokeL.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.f25428g, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f25429h, R.color.CAM_X0109);
                this.f25429h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f25427f.setVisibility(i2);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f25426e == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f25429h.getLocationOnScreen(iArr);
            int height = ((View) this.f25429h.getParent()).getHeight() - this.f25429h.getHeight();
            if (iArr[1] - this.f25426e.getHeight() <= 50) {
                c.a.e.e.m.g.d(this.f25426e, this.n.f25415a.getPageActivity());
                return;
            }
            c.a.e.e.m.g.m(this.f25426e, this.n.f25419e, 0, (iArr[0] - (this.f25429h.getWidth() / 2)) - this.n.f25415a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f25429h.getHeight() + height);
            PopupWindow popupWindow = this.f25426e;
            if (popupWindow != null) {
                popupWindow.update();
            }
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f25428g == null) {
                return;
            }
            this.f25428g.setText(this.n.f25415a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i2)));
            this.f25427f.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
                if (view == this.f25429h) {
                    h();
                } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
                } else {
                    PopupWindow popupWindow = this.f25426e;
                    if (popupWindow != null) {
                        c.a.e.e.m.g.d(popupWindow, this.n.f25415a.getPageActivity());
                    }
                    if (this.n.f25417c != null) {
                        String str = (String) view.getTag();
                        this.l = str;
                        if (str.contains("距离")) {
                            if (!d()) {
                                this.n.f25415a.showToast(R.string.square_sub_list_no_shared_location);
                                return;
                            } else {
                                c.a.e.e.i.a.l().i(false, this.m);
                                return;
                            }
                        }
                        c.a.q0.v.d.h.b.c cVar = new c.a.q0.v.d.h.b.c();
                        cVar.f25385a = this.l;
                        cVar.f25388d = false;
                        this.n.f25417c.b(cVar);
                        this.f25429h.setText(this.l);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25416b = -1;
        this.f25418d = BdUniqueId.gen();
        this.o = new ArrayList();
        this.f25415a = tbPageContext;
        this.f25419e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.f25415a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f25420f = (LinearLayout) this.f25419e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f25419e.findViewById(R.id.sub_list_top_info);
        this.f25421g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f25422h = (BdTypeListView) this.f25419e.findViewById(R.id.listView);
        g gVar = new g(this.f25415a);
        this.f25423i = gVar;
        gVar.V(this.f25418d);
        this.f25422h.setPullRefresh(this.f25423i);
        PbListView pbListView = new PbListView(this.f25415a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        c.a.q0.v.d.h.a.a aVar = new c.a.q0.v.d.h.a.a(this.f25415a);
        this.p = aVar;
        aVar.k0(2);
        c.a.q0.v.d.h.a.b bVar2 = new c.a.q0.v.d.h.a.b(this.f25415a);
        this.q = bVar2;
        bVar2.k0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f25422h.addAdapters(this.o);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25422h.completePullRefresh();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25422h : (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25419e : (View) invokeV.objValue;
    }

    public void g() {
        c.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this.f25419e);
        this.l = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this.f25419e);
        this.n = null;
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.m) == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f25422h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            if (this.f25416b != i2) {
                this.f25416b = i2;
            }
            b bVar = this.r;
            if (bVar != null) {
                bVar.f();
            }
            c.a.p0.f0.g gVar = this.l;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            NavigationBar navigationBar = this.f25424j;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i2);
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.d(i2);
            }
            h hVar = this.n;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f25419e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.f0.g gVar = this.l;
            if (gVar != null) {
                if (gVar.i() != null) {
                    this.l.dettachView(this.f25419e);
                }
                this.l.m();
                this.l = null;
            }
            g gVar2 = this.f25423i;
            if (gVar2 != null) {
                gVar2.a(null);
                this.f25423i.b(null);
                this.f25423i.h(null);
                this.f25423i.T();
                this.f25423i = null;
            }
            BdTypeListView bdTypeListView = this.f25422h;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f25422h.setOnScrollListener(null);
                this.f25422h.setRecyclerListener(null);
                this.f25422h = null;
            }
        }
    }

    public void l(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (bVar = this.r) == null) {
            return;
        }
        bVar.i(i2);
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
            this.f25417c = fVar;
            c.a.q0.v.d.h.a.a aVar = this.p;
            if (aVar != null) {
                aVar.m0(fVar);
            }
            c.a.q0.v.d.h.a.b bVar = this.q;
            if (bVar != null) {
                bVar.m0(this.f25417c);
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f25420f.setVisibility(i2);
        }
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f25422h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f25423i.a(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f25422h.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), list, str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                NavigationBar navigationBar = new NavigationBar(this.f25415a.getPageActivity());
                this.f25424j = navigationBar;
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
                if (!StringUtils.isNull(str2)) {
                    this.f25424j.setCenterTextTitle(str2);
                } else if (!StringUtils.isNull(str)) {
                    this.f25424j.setCenterTextTitle(str);
                }
                this.f25419e.addView(this.f25424j, 0, new LinearLayout.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f25424j.getBottomLine(), R.color.CAM_X0204);
            }
            if (!ListUtils.isEmpty(list)) {
                this.r.c(list);
            }
            this.p.n0(z3);
            this.q.n0(z3);
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f25415a) == null || this.f25419e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new c.a.p0.f0.g(tbPageContext.getPageActivity(), this.f25415a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        c.a.p0.f0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f25419e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new h(this.f25415a.getPageActivity(), onClickListener);
            }
            this.n.j(this.f25415a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
            this.n.l(str);
            this.n.attachView(this.f25419e, false);
            if (z) {
                this.n.o();
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
            this.f25422h.setNextPage(this.m);
        }
        this.m.A(this.f25415a.getResources().getString(R.string.live_sub_tab_no_more_data));
        this.m.f();
    }
}
