package b.a.r0.w.f.h.d;

import android.graphics.drawable.Drawable;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.i.a;
import b.a.e.m.e.n;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26440a;

    /* renamed from: b  reason: collision with root package name */
    public int f26441b;

    /* renamed from: c  reason: collision with root package name */
    public f f26442c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f26443d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f26444e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f26445f;

    /* renamed from: g  reason: collision with root package name */
    public View f26446g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f26447h;

    /* renamed from: i  reason: collision with root package name */
    public g f26448i;
    public NavigationBar j;
    public LinearLayout k;
    public b.a.q0.g0.g l;
    public PbListView m;
    public h n;
    public final List<b.a.e.m.e.a> o;
    public b.a.r0.w.f.h.a.a p;
    public b.a.r0.w.f.h.a.b q;
    public b r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26449e;

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
            this.f26449e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26449e.f26440a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f26450e;

        /* renamed from: f  reason: collision with root package name */
        public View f26451f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26452g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f26453h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f26454i;
        public List<String> j;
        public boolean k;
        public String l;
        public a.c m;
        public final /* synthetic */ c n;

        /* loaded from: classes5.dex */
        public class a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f26455a;

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
                this.f26455a = bVar;
            }

            @Override // b.a.e.f.i.a.c
            public void onLocationGeted(int i2, String str, Address address) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                    if (address != null) {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();
                        if (latitude == 0.0d || longitude == 0.0d) {
                            return;
                        }
                        b.a.r0.w.f.h.b.c cVar = new b.a.r0.w.f.h.b.c();
                        cVar.f26411a = this.f26455a.l;
                        cVar.f26412b = String.valueOf(latitude);
                        cVar.f26413c = String.valueOf(longitude);
                        cVar.f26414d = true;
                        this.f26455a.n.f26442c.b(cVar);
                        this.f26455a.f26453h.setText(this.f26455a.l);
                    } else if (StringUtils.isNull(str)) {
                    } else {
                        this.f26455a.n.f26440a.showToast(str);
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
            this.f26451f = view;
            this.f26452g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f26451f.findViewById(R.id.live_sort);
            this.f26453h = textView;
            textView.setVisibility(8);
            this.f26453h.setOnClickListener(this);
            f();
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.j = list;
                if (ListUtils.isEmpty(list) || this.k) {
                    return;
                }
                this.k = true;
                String str = this.j.get(0);
                if (!StringUtils.isNull(str)) {
                    this.f26453h.setText(str);
                    this.f26453h.setVisibility(0);
                }
                this.f26454i = new LinearLayout(this.n.f26440a.getPageActivity());
                this.f26454i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                SkinManager.setBackgroundResource(this.f26454i, R.drawable.bg_ala_sub_list_sort_panel);
                this.f26454i.setClipChildren(true);
                this.f26454i.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.f26440a.getResources().getDimensionPixelOffset(R.dimen.ds176), this.n.f26440a.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    this.f26454i.addView(e(this.j.get(i2)), layoutParams);
                    if (i2 != this.j.size() - 1) {
                        View view = new View(this.n.f26440a.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.n.f26440a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                        this.f26454i.addView(view);
                    }
                }
                if (this.f26450e == null) {
                    PopupWindow popupWindow = new PopupWindow(this.n.f26440a.getPageActivity());
                    this.f26450e = popupWindow;
                    popupWindow.setContentView(this.f26454i);
                    this.f26450e.setWidth(-2);
                    this.f26450e.setHeight(-2);
                    this.f26450e.setAnimationStyle(16973826);
                    this.f26450e.setBackgroundDrawable(this.n.f26440a.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.f26450e.setOutsideTouchable(true);
                    this.f26450e.setFocusable(true);
                    this.f26450e.setTouchable(true);
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.isSystemLocationProviderEnabled(this.n.f26440a.getPageActivity()) : invokeV.booleanValue;
        }

        public final TextView e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TextView textView = new TextView(this.n.f26440a.getPageActivity());
                textView.setTextSize(0, this.n.f26440a.getResources().getDimension(R.dimen.ds28));
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
                SkinManager.setViewTextColor(this.f26452g, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f26453h, R.color.CAM_X0109);
                this.f26453h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f26451f.setVisibility(i2);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f26450e == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f26453h.getLocationOnScreen(iArr);
            int height = ((View) this.f26453h.getParent()).getHeight() - this.f26453h.getHeight();
            if (iArr[1] - this.f26450e.getHeight() <= 50) {
                b.a.e.f.m.g.d(this.f26450e, this.n.f26440a.getPageActivity());
                return;
            }
            b.a.e.f.m.g.m(this.f26450e, this.n.f26444e, 0, (iArr[0] - (this.f26453h.getWidth() / 2)) - this.n.f26440a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f26453h.getHeight() + height);
            PopupWindow popupWindow = this.f26450e;
            if (popupWindow != null) {
                popupWindow.update();
            }
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f26452g == null) {
                return;
            }
            this.f26452g.setText(this.n.f26440a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i2)));
            this.f26451f.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
                if (view == this.f26453h) {
                    h();
                } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
                } else {
                    PopupWindow popupWindow = this.f26450e;
                    if (popupWindow != null) {
                        b.a.e.f.m.g.d(popupWindow, this.n.f26440a.getPageActivity());
                    }
                    if (this.n.f26442c != null) {
                        String str = (String) view.getTag();
                        this.l = str;
                        if (str.contains("距离")) {
                            if (!d()) {
                                this.n.f26440a.showToast(R.string.square_sub_list_no_shared_location);
                                return;
                            } else {
                                b.a.e.f.i.a.n().k(false, this.m);
                                return;
                            }
                        }
                        b.a.r0.w.f.h.b.c cVar = new b.a.r0.w.f.h.b.c();
                        cVar.f26411a = this.l;
                        cVar.f26414d = false;
                        this.n.f26442c.b(cVar);
                        this.f26453h.setText(this.l);
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
        this.f26441b = -1;
        this.f26443d = BdUniqueId.gen();
        this.o = new ArrayList();
        this.f26440a = tbPageContext;
        this.f26444e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.f26440a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f26445f = (LinearLayout) this.f26444e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f26444e.findViewById(R.id.sub_list_top_info);
        this.f26446g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f26447h = (BdTypeListView) this.f26444e.findViewById(R.id.listView);
        g gVar = new g(this.f26440a);
        this.f26448i = gVar;
        gVar.U(this.f26443d);
        this.f26447h.setPullRefresh(this.f26448i);
        PbListView pbListView = new PbListView(this.f26440a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        b.a.r0.w.f.h.a.a aVar = new b.a.r0.w.f.h.a.a(this.f26440a);
        this.p = aVar;
        aVar.j0(2);
        b.a.r0.w.f.h.a.b bVar2 = new b.a.r0.w.f.h.a.b(this.f26440a);
        this.q = bVar2;
        bVar2.j0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f26447h.addAdapters(this.o);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26447h.completePullRefresh();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26447h : (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26444e : (View) invokeV.objValue;
    }

    public void g() {
        b.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this.f26444e);
        this.l = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this.f26444e);
        this.n = null;
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.m) == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f26447h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            if (this.f26441b != i2) {
                this.f26441b = i2;
            }
            b bVar = this.r;
            if (bVar != null) {
                bVar.f();
            }
            b.a.q0.g0.g gVar = this.l;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            NavigationBar navigationBar = this.j;
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
            SkinManager.setBackgroundResource(this.f26444e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.q0.g0.g gVar = this.l;
            if (gVar != null) {
                if (gVar.i() != null) {
                    this.l.dettachView(this.f26444e);
                }
                this.l.m();
                this.l = null;
            }
            g gVar2 = this.f26448i;
            if (gVar2 != null) {
                gVar2.a(null);
                this.f26448i.b(null);
                this.f26448i.h(null);
                this.f26448i.S();
                this.f26448i = null;
            }
            BdTypeListView bdTypeListView = this.f26447h;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f26447h.setOnScrollListener(null);
                this.f26447h.setRecyclerListener(null);
                this.f26447h = null;
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
            this.f26442c = fVar;
            b.a.r0.w.f.h.a.a aVar = this.p;
            if (aVar != null) {
                aVar.l0(fVar);
            }
            b.a.r0.w.f.h.a.b bVar = this.q;
            if (bVar != null) {
                bVar.l0(this.f26442c);
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f26445f.setVisibility(i2);
        }
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f26447h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f26448i.a(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f26447h.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), list, str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                NavigationBar navigationBar = new NavigationBar(this.f26440a.getPageActivity());
                this.j = navigationBar;
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
                if (!StringUtils.isNull(str2)) {
                    this.j.setCenterTextTitle(str2);
                } else if (!StringUtils.isNull(str)) {
                    this.j.setCenterTextTitle(str);
                }
                this.f26444e.addView(this.j, 0, new LinearLayout.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.j.getBottomLine(), R.color.CAM_X0204);
            }
            if (!ListUtils.isEmpty(list)) {
                this.r.c(list);
            }
            this.p.m0(z3);
            this.q.m0(z3);
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f26440a) == null || this.f26444e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new b.a.q0.g0.g(tbPageContext.getPageActivity(), this.f26440a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        b.a.q0.g0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f26444e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new h(this.f26440a.getPageActivity(), onClickListener);
            }
            this.n.j(this.f26440a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
            this.n.l(str);
            this.n.attachView(this.f26444e, false);
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
            this.f26447h.setNextPage(this.m);
        }
        this.m.C(this.f26440a.getResources().getString(R.string.live_sub_tab_no_more_data));
        this.m.f();
    }
}
