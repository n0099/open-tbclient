package c.a.n0.m.j.g;

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
import c.a.n0.a.w0.f;
import c.a.n0.a.x.g.d;
import c.a.n0.a.x.g.g;
import c.a.n0.m.j.c;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends d implements c.a.n0.m.j.b, OnGetPoiSearchResultListener, View.OnKeyListener, View.OnFocusChangeListener, TextWatcher, View.OnTouchListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText F0;
    public View G0;
    public TextView H0;
    public RecyclerView I0;
    public LocationDetailAdapter J0;
    public LinearLayoutManager K0;
    public List<c> L0;
    public PoiSearch M0;
    public InputMethodManager N0;
    public int O0;
    public int P0;
    public String Q0;
    public boolean R0;
    public boolean S0;
    public String T0;

    /* renamed from: c.a.n0.m.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0750a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0750a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int X2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (X2 = this.a.X2()) >= 0 && X2 + 1 == this.a.J0.getItemCount()) {
                    this.a.Y2();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.a;
                aVar.e3(aVar.F0, true);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.M0 = null;
        this.O0 = 0;
        this.P0 = 0;
        this.T0 = Address.Builder.BEI_JING;
    }

    public static a a3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            a aVar = new a();
            if (bundle != null) {
                aVar.h1(bundle);
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void S1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
        }
    }

    public final void V2() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (activity = this.i0) == null) {
            return;
        }
        activity.onBackPressed();
    }

    public final View W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int X2 = X2();
            if (X2 == -1) {
                return null;
            }
            return this.K0.findViewByPosition(X2);
        }
        return (View) invokeV.objValue;
    }

    public final int X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinearLayoutManager linearLayoutManager = this.K0;
            if (linearLayoutManager != null) {
                return linearLayoutManager.findLastVisibleItemPosition();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void Y2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.R0) {
            return;
        }
        if (this.O0 < this.P0) {
            h3(this.Q0);
            this.R0 = true;
            return;
        }
        b3();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void Z2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.L0 = new ArrayList(11);
            if (p() != null) {
                String string = p().getString("city");
                if (TextUtils.isEmpty(string)) {
                    string = Address.Builder.BEI_JING;
                }
                this.T0 = string;
            }
            this.F0 = (EditText) view.findViewById(R.id.obfuscated_res_0x7f091c4b);
            this.I0 = (RecyclerView) view.findViewById(R.id.obfuscated_res_0x7f09132b);
            this.G0 = view.findViewById(R.id.obfuscated_res_0x7f0915a2);
            this.H0 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090496);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(f.U().getActivity());
            this.K0 = linearLayoutManager;
            this.I0.setLayoutManager(linearLayoutManager);
            LocationDetailAdapter locationDetailAdapter = new LocationDetailAdapter(f.U().getActivity(), this.I0, this);
            this.J0 = locationDetailAdapter;
            this.I0.setAdapter(locationDetailAdapter);
            this.I0.addItemDecoration(new LocationItemDecoration(f.U().getActivity()));
            this.I0.setOnTouchListener(this);
            this.H0.setOnClickListener(this);
            PoiSearch newInstance = PoiSearch.newInstance();
            this.M0 = newInstance;
            newInstance.setOnGetPoiSearchResultListener(this);
            this.F0.addTextChangedListener(this);
            this.F0.setOnFocusChangeListener(this);
            this.F0.setOnKeyListener(this);
            this.F0.requestFocus();
            this.I0.addOnScrollListener(new C0750a(this));
            this.F0.postDelayed(new b(this), 100L);
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editable) == null) {
            if (editable != null && editable.length() > 0) {
                this.S0 = false;
                this.O0 = 0;
                this.P0 = 0;
                String obj = editable.toString();
                this.Q0 = obj;
                h3(obj);
                return;
            }
            this.L0.clear();
            this.J0.setData(this.L0);
            this.Q0 = "";
            this.O0 = 0;
            this.P0 = 0;
            this.S0 = true;
        }
    }

    public final void b3() {
        View W2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (W2 = W2()) == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = this.I0.getChildViewHolder(W2);
        if (childViewHolder instanceof LocationFooterViewHolder) {
            ((LocationFooterViewHolder) childViewHolder).b(false);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048586, this, charSequence, i, i2, i3) == null) {
        }
    }

    @Override // c.a.n0.m.j.b
    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            Intent intent = new Intent();
            PoiInfo poiInfo = cVar.a;
            if (poiInfo != null && poiInfo.location != null) {
                intent.putExtra(SelectedLocationInfo.LOCATION_KEY, new SelectedLocationInfo(poiInfo.name, poiInfo.address, poiInfo.location));
            }
            d3(intent);
            V2();
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || TextUtils.isEmpty(this.Q0)) {
            return;
        }
        this.O0 = 0;
        h3(this.Q0);
        e3(this.F0, false);
    }

    public final void d3(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || I() == null) {
            return;
        }
        I().q0(J(), 0, intent);
    }

    public void e3(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, view, z) == null) {
            if (this.N0 == null) {
                this.N0 = (InputMethodManager) f.U().getActivity().getApplicationContext().getSystemService("input_method");
            }
            InputMethodManager inputMethodManager = this.N0;
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

    public void f3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.G0.setVisibility(z ? 0 : 8);
        }
    }

    public void g3() {
        g V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (V = f.U().V()) == null) {
            return;
        }
        g.b i = V.i("navigateTo");
        i.n(g.f7048g, g.i);
        i.j(this);
        i.b();
    }

    @Override // c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void h3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.M0.searchInCity(new PoiCitySearchOption().cityLimit(false).scope(2).city(this.T0).keyword(str).pageCapacity(13).pageNum(this.O0));
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.searchbox.widget.SlideInterceptor
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
        if ((interceptable == null || interceptable.invokeL(1048597, this, view) == null) && view.getId() == R.id.obfuscated_res_0x7f090496) {
            V2();
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, view, z) == null) {
            e3(this.F0, z);
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, poiDetailResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, poiDetailSearchResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, poiIndoorResult) == null) {
        }
    }

    @Override // com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener
    public void onGetPoiResult(PoiResult poiResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, poiResult) == null) {
            boolean z = false;
            this.R0 = false;
            if (this.S0) {
                return;
            }
            if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                this.P0 = poiResult.getTotalPageNum();
                if (this.O0 == 0) {
                    this.L0.clear();
                }
                this.L0.addAll(c.a(poiResult.getAllPoi()));
                this.J0.g(this.L0, this.Q0);
                this.O0++;
            } else {
                if (this.O0 == 0) {
                    this.P0 = 0;
                    this.L0.clear();
                    this.J0.setData(this.L0);
                }
                b3();
            }
            if (this.O0 == 0 && this.L0.size() == 0) {
                z = true;
            }
            f3(z);
            if (this.L0.size() <= 0) {
                b3();
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048603, this, view, i, keyEvent)) == null) {
            if (i == 66) {
                c3();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048604, this, charSequence, i, i2, i3) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, view, motionEvent)) == null) {
            e3(this.F0, false);
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.n0.m.a.a();
            SDKInitializer.setCoordType(CoordType.GCJ02);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008b, viewGroup, false);
            Z2(inflate);
            if (R1()) {
                inflate = U1(inflate);
                u1(-1);
            }
            return B1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.y0();
            this.M0.destroy();
        }
    }
}
