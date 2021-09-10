package c.a.r0.v.d.h.d;

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
import c.a.q0.g0.h;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25893a;

    /* renamed from: b  reason: collision with root package name */
    public int f25894b;

    /* renamed from: c  reason: collision with root package name */
    public f f25895c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f25896d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f25897e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f25898f;

    /* renamed from: g  reason: collision with root package name */
    public View f25899g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f25900h;

    /* renamed from: i  reason: collision with root package name */
    public g f25901i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f25902j;
    public LinearLayout k;
    public c.a.q0.g0.g l;
    public PbListView m;
    public h n;
    public final List<c.a.e.l.e.a> o;
    public c.a.r0.v.d.h.a.a p;
    public c.a.r0.v.d.h.a.b q;
    public b r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25903e;

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
            this.f25903e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25903e.f25893a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f25904e;

        /* renamed from: f  reason: collision with root package name */
        public View f25905f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25906g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25907h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f25908i;

        /* renamed from: j  reason: collision with root package name */
        public List<String> f25909j;
        public boolean k;
        public String l;
        public a.c m;
        public final /* synthetic */ c n;

        /* loaded from: classes4.dex */
        public class a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f25910a;

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
                this.f25910a = bVar;
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
                        c.a.r0.v.d.h.b.c cVar = new c.a.r0.v.d.h.b.c();
                        cVar.f25863a = this.f25910a.l;
                        cVar.f25864b = String.valueOf(latitude);
                        cVar.f25865c = String.valueOf(longitude);
                        cVar.f25866d = true;
                        this.f25910a.n.f25895c.b(cVar);
                        this.f25910a.f25907h.setText(this.f25910a.l);
                    } else if (StringUtils.isNull(str)) {
                    } else {
                        this.f25910a.n.f25893a.showToast(str);
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
            this.f25905f = view;
            this.f25906g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f25905f.findViewById(R.id.live_sort);
            this.f25907h = textView;
            textView.setVisibility(8);
            this.f25907h.setOnClickListener(this);
            f();
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f25909j = list;
                if (ListUtils.isEmpty(list) || this.k) {
                    return;
                }
                this.k = true;
                String str = this.f25909j.get(0);
                if (!StringUtils.isNull(str)) {
                    this.f25907h.setText(str);
                    this.f25907h.setVisibility(0);
                }
                this.f25908i = new LinearLayout(this.n.f25893a.getPageActivity());
                this.f25908i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                SkinManager.setBackgroundResource(this.f25908i, R.drawable.bg_ala_sub_list_sort_panel);
                this.f25908i.setClipChildren(true);
                this.f25908i.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.n.f25893a.getResources().getDimensionPixelOffset(R.dimen.ds176), this.n.f25893a.getResources().getDimensionPixelOffset(R.dimen.ds88));
                for (int i2 = 0; i2 < this.f25909j.size(); i2++) {
                    this.f25908i.addView(e(this.f25909j.get(i2)), layoutParams);
                    if (i2 != this.f25909j.size() - 1) {
                        View view = new View(this.n.f25893a.getPageActivity());
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.n.f25893a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                        SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                        this.f25908i.addView(view);
                    }
                }
                if (this.f25904e == null) {
                    PopupWindow popupWindow = new PopupWindow(this.n.f25893a.getPageActivity());
                    this.f25904e = popupWindow;
                    popupWindow.setContentView(this.f25908i);
                    this.f25904e.setWidth(-2);
                    this.f25904e.setHeight(-2);
                    this.f25904e.setAnimationStyle(16973826);
                    this.f25904e.setBackgroundDrawable(this.n.f25893a.getResources().getDrawable(R.drawable.popup_window_transparent));
                    this.f25904e.setOutsideTouchable(true);
                    this.f25904e.setFocusable(true);
                    this.f25904e.setTouchable(true);
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.isSystemLocationProviderEnabled(this.n.f25893a.getPageActivity()) : invokeV.booleanValue;
        }

        public final TextView e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TextView textView = new TextView(this.n.f25893a.getPageActivity());
                textView.setTextSize(0, this.n.f25893a.getResources().getDimension(R.dimen.ds28));
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
                SkinManager.setViewTextColor(this.f25906g, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f25907h, R.color.CAM_X0109);
                this.f25907h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f25905f.setVisibility(i2);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f25904e == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f25907h.getLocationOnScreen(iArr);
            int height = ((View) this.f25907h.getParent()).getHeight() - this.f25907h.getHeight();
            if (iArr[1] - this.f25904e.getHeight() <= 50) {
                c.a.e.e.m.g.d(this.f25904e, this.n.f25893a.getPageActivity());
                return;
            }
            c.a.e.e.m.g.m(this.f25904e, this.n.f25897e, 0, (iArr[0] - (this.f25907h.getWidth() / 2)) - this.n.f25893a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f25907h.getHeight() + height);
            PopupWindow popupWindow = this.f25904e;
            if (popupWindow != null) {
                popupWindow.update();
            }
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f25906g == null) {
                return;
            }
            this.f25906g.setText(this.n.f25893a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i2)));
            this.f25905f.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
                if (view == this.f25907h) {
                    h();
                } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
                } else {
                    PopupWindow popupWindow = this.f25904e;
                    if (popupWindow != null) {
                        c.a.e.e.m.g.d(popupWindow, this.n.f25893a.getPageActivity());
                    }
                    if (this.n.f25895c != null) {
                        String str = (String) view.getTag();
                        this.l = str;
                        if (str.contains("距离")) {
                            if (!d()) {
                                this.n.f25893a.showToast(R.string.square_sub_list_no_shared_location);
                                return;
                            } else {
                                c.a.e.e.i.a.l().i(false, this.m);
                                return;
                            }
                        }
                        c.a.r0.v.d.h.b.c cVar = new c.a.r0.v.d.h.b.c();
                        cVar.f25863a = this.l;
                        cVar.f25866d = false;
                        this.n.f25895c.b(cVar);
                        this.f25907h.setText(this.l);
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
        this.f25894b = -1;
        this.f25896d = BdUniqueId.gen();
        this.o = new ArrayList();
        this.f25893a = tbPageContext;
        this.f25897e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.f25893a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f25898f = (LinearLayout) this.f25897e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f25897e.findViewById(R.id.sub_list_top_info);
        this.f25899g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f25900h = (BdTypeListView) this.f25897e.findViewById(R.id.listView);
        g gVar = new g(this.f25893a);
        this.f25901i = gVar;
        gVar.V(this.f25896d);
        this.f25900h.setPullRefresh(this.f25901i);
        PbListView pbListView = new PbListView(this.f25893a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        c.a.r0.v.d.h.a.a aVar = new c.a.r0.v.d.h.a.a(this.f25893a);
        this.p = aVar;
        aVar.k0(2);
        c.a.r0.v.d.h.a.b bVar2 = new c.a.r0.v.d.h.a.b(this.f25893a);
        this.q = bVar2;
        bVar2.k0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f25900h.addAdapters(this.o);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25900h.completePullRefresh();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25900h : (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25897e : (View) invokeV.objValue;
    }

    public void g() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this.f25897e);
        this.l = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this.f25897e);
        this.n = null;
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.m) == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f25900h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            if (this.f25894b != i2) {
                this.f25894b = i2;
            }
            b bVar = this.r;
            if (bVar != null) {
                bVar.f();
            }
            c.a.q0.g0.g gVar = this.l;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            NavigationBar navigationBar = this.f25902j;
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
            SkinManager.setBackgroundResource(this.f25897e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.g0.g gVar = this.l;
            if (gVar != null) {
                if (gVar.i() != null) {
                    this.l.dettachView(this.f25897e);
                }
                this.l.m();
                this.l = null;
            }
            g gVar2 = this.f25901i;
            if (gVar2 != null) {
                gVar2.a(null);
                this.f25901i.b(null);
                this.f25901i.h(null);
                this.f25901i.T();
                this.f25901i = null;
            }
            BdTypeListView bdTypeListView = this.f25900h;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f25900h.setOnScrollListener(null);
                this.f25900h.setRecyclerListener(null);
                this.f25900h = null;
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
            this.f25895c = fVar;
            c.a.r0.v.d.h.a.a aVar = this.p;
            if (aVar != null) {
                aVar.m0(fVar);
            }
            c.a.r0.v.d.h.a.b bVar = this.q;
            if (bVar != null) {
                bVar.m0(this.f25895c);
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f25898f.setVisibility(i2);
        }
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f25900h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f25901i.a(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.f25900h.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), list, str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                NavigationBar navigationBar = new NavigationBar(this.f25893a.getPageActivity());
                this.f25902j = navigationBar;
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
                if (!StringUtils.isNull(str2)) {
                    this.f25902j.setCenterTextTitle(str2);
                } else if (!StringUtils.isNull(str)) {
                    this.f25902j.setCenterTextTitle(str);
                }
                this.f25897e.addView(this.f25902j, 0, new LinearLayout.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f25902j.getBottomLine(), R.color.CAM_X0204);
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.f25893a) == null || this.f25897e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new c.a.q0.g0.g(tbPageContext.getPageActivity(), this.f25893a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        c.a.q0.g0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f25897e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new h(this.f25893a.getPageActivity(), onClickListener);
            }
            this.n.j(this.f25893a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
            this.n.l(str);
            this.n.attachView(this.f25897e, false);
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
            this.f25900h.setNextPage(this.m);
        }
        this.m.A(this.f25893a.getResources().getString(R.string.live_sub_tab_no_more_data));
        this.m.f();
    }
}
