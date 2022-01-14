package c.a.t0.a0.f.h.d;

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
import c.a.d.n.e.n;
import c.a.s0.g0.h;
import c.a.s0.s.j0.f;
import c.a.s0.s.j0.g;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public int f14693b;

    /* renamed from: c  reason: collision with root package name */
    public f f14694c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f14695d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14696e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14697f;

    /* renamed from: g  reason: collision with root package name */
    public View f14698g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f14699h;

    /* renamed from: i  reason: collision with root package name */
    public g f14700i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f14701j;
    public LinearLayout k;
    public c.a.s0.g0.g l;
    public PbListView m;
    public h n;
    public final List<c.a.d.n.e.a> o;
    public c.a.t0.a0.f.h.a.a p;
    public c.a.t0.a0.f.h.a.b q;
    public b r;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f14702e;

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
            this.f14702e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14702e.a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f14703e;

        /* renamed from: f  reason: collision with root package name */
        public View f14704f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14705g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14706h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f14707i;

        /* renamed from: j  reason: collision with root package name */
        public List<String> f14708j;
        public boolean k;
        public String l;
        public a.c m;
        public final /* synthetic */ c n;

        /* loaded from: classes6.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.d.f.i.a.c
            public void onLocationGeted(int i2, String str, Address address) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                    if (address != null) {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();
                        if (latitude == 0.0d || longitude == 0.0d) {
                            return;
                        }
                        c.a.t0.a0.f.h.b.c cVar = new c.a.t0.a0.f.h.b.c();
                        cVar.a = this.a.l;
                        cVar.f14668b = String.valueOf(latitude);
                        cVar.f14669c = String.valueOf(longitude);
                        cVar.f14670d = true;
                        this.a.n.f14694c.b(cVar);
                        this.a.f14706h.setText(this.a.l);
                    } else if (StringUtils.isNull(str)) {
                    } else {
                        this.a.n.a.showToast(str);
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
            this.f14704f = view;
            this.f14705g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f14704f.findViewById(R.id.live_sort);
            this.f14706h = textView;
            textView.setVisibility(8);
            this.f14706h.setOnClickListener(this);
            f();
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f14708j = list;
                if (ListUtils.isEmpty(list) || this.k) {
                    return;
                }
                this.k = true;
                String str = this.f14708j.get(0);
                if (!StringUtils.isNull(str)) {
                    this.f14706h.setText(str);
                    this.f14706h.setVisibility(0);
                }
                this.f14707i = new LinearLayout(this.n.a.getPageActivity());
                this.f14707i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                SkinManager.setBackgroundResource(this.f14707i, R.drawable.bg_ala_sub_list_sort_panel);
                this.f14707i.setClipChildren(true);
                this.f14707i.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.a.getResources().getDimensionPixelOffset(R.dimen.ds176), this.n.a.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i2 = 0; i2 < this.f14708j.size(); i2++) {
                    this.f14707i.addView(e(this.f14708j.get(i2)), layoutParams);
                    if (i2 != this.f14708j.size() - 1) {
                        View view = new View(this.n.a.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.n.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                        this.f14707i.addView(view);
                    }
                }
                if (this.f14703e == null) {
                    PopupWindow popupWindow = new PopupWindow(this.n.a.getPageActivity());
                    this.f14703e = popupWindow;
                    popupWindow.setContentView(this.f14707i);
                    this.f14703e.setWidth(-2);
                    this.f14703e.setHeight(-2);
                    this.f14703e.setAnimationStyle(16973826);
                    this.f14703e.setBackgroundDrawable(this.n.a.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.f14703e.setOutsideTouchable(true);
                    this.f14703e.setFocusable(true);
                    this.f14703e.setTouchable(true);
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.isSystemLocationProviderEnabled(this.n.a.getPageActivity()) : invokeV.booleanValue;
        }

        public final TextView e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TextView textView = new TextView(this.n.a.getPageActivity());
                textView.setTextSize(0, this.n.a.getResources().getDimension(R.dimen.ds28));
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
                SkinManager.setViewTextColor(this.f14705g, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f14706h, R.color.CAM_X0109);
                this.f14706h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f14704f.setVisibility(i2);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f14703e == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f14706h.getLocationOnScreen(iArr);
            int height = ((View) this.f14706h.getParent()).getHeight() - this.f14706h.getHeight();
            if (iArr[1] - this.f14703e.getHeight() <= 50) {
                c.a.d.f.m.g.d(this.f14703e, this.n.a.getPageActivity());
                return;
            }
            c.a.d.f.m.g.m(this.f14703e, this.n.f14696e, 0, (iArr[0] - (this.f14706h.getWidth() / 2)) - this.n.a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f14706h.getHeight() + height);
            PopupWindow popupWindow = this.f14703e;
            if (popupWindow != null) {
                popupWindow.update();
            }
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f14705g == null) {
                return;
            }
            this.f14705g.setText(this.n.a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i2)));
            this.f14704f.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
                if (view == this.f14706h) {
                    h();
                } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
                } else {
                    PopupWindow popupWindow = this.f14703e;
                    if (popupWindow != null) {
                        c.a.d.f.m.g.d(popupWindow, this.n.a.getPageActivity());
                    }
                    if (this.n.f14694c != null) {
                        String str = (String) view.getTag();
                        this.l = str;
                        if (str.contains("距离")) {
                            if (!d()) {
                                this.n.a.showToast(R.string.square_sub_list_no_shared_location);
                                return;
                            } else {
                                c.a.d.f.i.a.n().k(false, this.m);
                                return;
                            }
                        }
                        c.a.t0.a0.f.h.b.c cVar = new c.a.t0.a0.f.h.b.c();
                        cVar.a = this.l;
                        cVar.f14670d = false;
                        this.n.f14694c.b(cVar);
                        this.f14706h.setText(this.l);
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
        this.f14693b = -1;
        this.f14695d = BdUniqueId.gen();
        this.o = new ArrayList();
        this.a = tbPageContext;
        this.f14696e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f14697f = (LinearLayout) this.f14696e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f14696e.findViewById(R.id.sub_list_top_info);
        this.f14698g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f14699h = (BdTypeListView) this.f14696e.findViewById(R.id.listView);
        g gVar = new g(this.a);
        this.f14700i = gVar;
        gVar.V(this.f14695d);
        this.f14699h.setPullRefresh(this.f14700i);
        PbListView pbListView = new PbListView(this.a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        c.a.t0.a0.f.h.a.a aVar = new c.a.t0.a0.f.h.a.a(this.a);
        this.p = aVar;
        aVar.c0(2);
        c.a.t0.a0.f.h.a.b bVar2 = new c.a.t0.a0.f.h.a.b(this.a);
        this.q = bVar2;
        bVar2.c0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f14699h.addAdapters(this.o);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14699h.completePullRefresh();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14699h : (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14696e : (View) invokeV.objValue;
    }

    public void g() {
        c.a.s0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this.f14696e);
        this.l = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this.f14696e);
        this.n = null;
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.m) == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f14699h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            if (this.f14693b != i2) {
                this.f14693b = i2;
            }
            b bVar = this.r;
            if (bVar != null) {
                bVar.f();
            }
            c.a.s0.g0.g gVar = this.l;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            NavigationBar navigationBar = this.f14701j;
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
            SkinManager.setBackgroundResource(this.f14696e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.s0.g0.g gVar = this.l;
            if (gVar != null) {
                if (gVar.i() != null) {
                    this.l.dettachView(this.f14696e);
                }
                this.l.m();
                this.l = null;
            }
            g gVar2 = this.f14700i;
            if (gVar2 != null) {
                gVar2.a(null);
                this.f14700i.b(null);
                this.f14700i.h(null);
                this.f14700i.T();
                this.f14700i = null;
            }
            BdTypeListView bdTypeListView = this.f14699h;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f14699h.setOnScrollListener(null);
                this.f14699h.setRecyclerListener(null);
                this.f14699h = null;
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
            this.f14694c = fVar;
            c.a.t0.a0.f.h.a.a aVar = this.p;
            if (aVar != null) {
                aVar.e0(fVar);
            }
            c.a.t0.a0.f.h.a.b bVar = this.q;
            if (bVar != null) {
                bVar.e0(this.f14694c);
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f14697f.setVisibility(i2);
        }
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f14699h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f14700i.a(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f14699h.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), list, str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                NavigationBar navigationBar = new NavigationBar(this.a.getPageActivity());
                this.f14701j = navigationBar;
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
                if (!StringUtils.isNull(str2)) {
                    this.f14701j.setCenterTextTitle(str2);
                } else if (!StringUtils.isNull(str)) {
                    this.f14701j.setCenterTextTitle(str);
                }
                this.f14696e.addView(this.f14701j, 0, new LinearLayout.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f14701j.getBottomLine(), R.color.CAM_X0204);
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.a) == null || this.f14696e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new c.a.s0.g0.g(tbPageContext.getPageActivity(), this.a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        c.a.s0.g0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f14696e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new h(this.a.getPageActivity(), onClickListener);
            }
            this.n.k(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
            this.n.m(str);
            this.n.attachView(this.f14696e, false);
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
            this.f14699h.setNextPage(this.m);
        }
        this.m.D(this.a.getResources().getString(R.string.live_sub_tab_no_more_data));
        this.m.f();
    }
}
