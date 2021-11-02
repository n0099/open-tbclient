package b.a.p0.j.o.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.d;
import b.a.p0.a.h0.g.g;
import b.a.p0.j.e;
import b.a.p0.j.o.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Address;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.swan.map.location.LocationDetailAdapter;
import com.baidu.swan.map.location.LocationFooterViewHolder;
import com.baidu.swan.map.location.LocationItemDecoration;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d implements b.a.p0.j.o.b, OnGetPoiSearchResultListener, View.OnKeyListener, View.OnFocusChangeListener, TextWatcher, View.OnTouchListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText C0;
    public View D0;
    public TextView E0;
    public RecyclerView F0;
    public LocationDetailAdapter G0;
    public LinearLayoutManager H0;
    public List<c> I0;
    public PoiSearch J0;
    public InputMethodManager K0;
    public int L0;
    public int M0;
    public String N0;
    public boolean O0;
    public boolean P0;
    public String Q0;

    /* renamed from: b.a.p0.j.o.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0612a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10985a;

        public C0612a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10985a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int G2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && (G2 = this.f10985a.G2()) >= 0 && G2 + 1 == this.f10985a.G0.getItemCount()) {
                    this.f10985a.H2();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10986e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10986e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f10986e;
                aVar.N2(aVar.C0, true);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.J0 = null;
        this.L0 = 0;
        this.M0 = 0;
        this.Q0 = Address.Builder.BEI_JING;
    }

    public static a J2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.d1(bundle);
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final void E2() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = this.k0) == null) {
            return;
        }
        activity.onBackPressed();
    }

    public final View F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int G2 = G2();
            if (G2 == -1) {
                return null;
            }
            return this.H0.findViewByPosition(G2);
        }
        return (View) invokeV.objValue;
    }

    public final int G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinearLayoutManager linearLayoutManager = this.H0;
            if (linearLayoutManager != null) {
                return linearLayoutManager.findLastVisibleItemPosition();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void H2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.O0) {
            return;
        }
        if (this.L0 < this.M0) {
            Q2(this.N0);
            this.O0 = true;
            return;
        }
        K2();
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void I2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.I0 = new ArrayList(11);
            if (n() != null) {
                String string = n().getString("city");
                if (TextUtils.isEmpty(string)) {
                    string = Address.Builder.BEI_JING;
                }
                this.Q0 = string;
            }
            this.C0 = (EditText) view.findViewById(e.search_text);
            this.F0 = (RecyclerView) view.findViewById(e.location_list);
            this.D0 = view.findViewById(e.no_result_tip);
            this.E0 = (TextView) view.findViewById(e.cancel_search);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(f.T().getActivity());
            this.H0 = linearLayoutManager;
            this.F0.setLayoutManager(linearLayoutManager);
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(f.T().getActivity(), this.F0, this);
            this.G0 = locationDetailAdapter;
            this.F0.setAdapter(locationDetailAdapter);
            this.F0.addItemDecoration(new LocationItemDecoration(f.T().getActivity()));
            this.F0.setOnTouchListener(this);
            this.E0.setOnClickListener(this);
            PoiSearch newInstance = PoiSearch.newInstance();
            this.J0 = newInstance;
            newInstance.setOnGetPoiSearchResultListener(this);
            this.C0.addTextChangedListener(this);
            this.C0.setOnFocusChangeListener(this);
            this.C0.setOnKeyListener(this);
            this.C0.requestFocus();
            this.F0.addOnScrollListener(new C0612a(this));
            this.C0.postDelayed(new b(this), 100L);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void K1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
        }
    }

    public final void K2() {
        View F2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (F2 = F2()) == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = this.F0.getChildViewHolder(F2);
        if (childViewHolder instanceof LocationFooterViewHolder) {
            ((LocationFooterViewHolder) childViewHolder).setVisibility(false);
        }
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || TextUtils.isEmpty(this.N0)) {
            return;
        }
        this.L0 = 0;
        Q2(this.N0);
        N2(this.C0, false);
    }

    public final void M2(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, intent) == null) || T() == null) {
            return;
        }
        T().q0(U(), 0, intent);
    }

    public void N2(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, view, z) == null) {
            if (this.K0 == null) {
                this.K0 = (InputMethodManager) f.T().getActivity().getApplicationContext().getSystemService("input_method");
            }
            InputMethodManager inputMethodManager = this.K0;
            if (inputMethodManager == null) {
                return;
            }
            if (z) {
                inputMethodManager.showSoftInput(view, 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public void O2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.D0.setVisibility(z ? 0 : 8);
        }
    }

    public void P2() {
        g U;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (U = f.T().U()) == null) {
            return;
        }
        g.b i2 = U.i("navigateTo");
        i2.n(g.f5280g, g.f5282i);
        i2.j(this);
        i2.b();
    }

    public final void Q2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.J0.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.Q0).keyword(str).pageCapacity(13).pageNum(this.L0));
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editable) == null) {
            if (editable != null && editable.length() > 0) {
                this.P0 = false;
                this.L0 = 0;
                this.M0 = 0;
                String obj = editable.toString();
                this.N0 = obj;
                Q2(obj);
                return;
            }
            this.I0.clear();
            this.G0.setData(this.I0);
            this.N0 = "";
            this.L0 = 0;
            this.M0 = 0;
            this.P0 = true;
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048594, this, charSequence, i2, i3, i4) == null) {
        }
    }

    @Override // b.a.p0.j.o.b
    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            Intent intent = new Intent();
            PoiInfo poiInfo = cVar.f10959a;
            if (poiInfo != null && poiInfo.location != null) {
                intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
            }
            M2(intent);
            E2();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view) == null) && view.getId() == e.cancel_search) {
            E2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            this.J0.destroy();
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, view, z) == null) {
            N2(this.C0, z);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, poiDetailResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, poiDetailSearchResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, poiIndoorResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, poiResult) == null) {
            boolean z = false;
            this.O0 = false;
            if (this.P0) {
                return;
            }
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.M0 = poiResult.getTotalPageNum();
                if (this.L0 == 0) {
                    this.I0.clear();
                }
                this.I0.addAll(c.a(poiResult.getAllPoi()));
                this.G0.setData(this.I0, this.N0);
                this.L0++;
            } else {
                if (this.L0 == 0) {
                    this.M0 = 0;
                    this.I0.clear();
                    this.G0.setData(this.I0);
                }
                K2();
            }
            if (this.L0 == 0 && this.I0.size() == 0) {
                z = true;
            }
            O2(z);
            if (this.I0.size() <= 0) {
                K2();
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048604, this, view, i2, keyEvent)) == null) {
            if (i2 == 66) {
                L2();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048605, this, charSequence, i2, i3, i4) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, view, motionEvent)) == null) {
            N2(this.C0, false);
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.p0.j.a.a();
            SDKInitializer.setCoordType(CoordType.GCJ02);
            View inflate = layoutInflater.inflate(b.a.p0.j.f.ai_apps_location_search, viewGroup, false);
            I2(inflate);
            if (J1()) {
                inflate = M1(inflate);
                o1(-1);
            }
            return u1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
