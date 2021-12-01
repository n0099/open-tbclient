package c.a.r0.c2;

import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.SearchMajorActivity;
import com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchMajorActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15064b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15065c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f15066d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f15067e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15068f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15069g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f15070h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f15071i;

    /* renamed from: j  reason: collision with root package name */
    public SearchMajorResultItemAdapter f15072j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f15073k;

    /* renamed from: c.a.r0.c2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnTouchListenerC0913a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15074e;

        public View$OnTouchListenerC0913a(a aVar) {
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
            this.f15074e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f15074e.f15066d.setFocusable(true);
                    this.f15074e.f15066d.setFocusableInTouchMode(true);
                    if (this.f15074e.f15067e.hasFocus()) {
                        l.w(this.f15074e.a, this.f15074e.f15067e);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15075e;

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
            this.f15075e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15075e.f15067e.setText("");
            }
        }
    }

    public a(View view, SearchMajorActivity searchMajorActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, searchMajorActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15064b = view;
        this.a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15073k : (LinearLayout) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f15064b.findViewById(R.id.navigation_bar);
            this.f15065c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15065c.setCenterTextTitle(this.a.getResources().getString(R.string.search_major));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f15064b.findViewById(R.id.search_container);
            this.f15066d = relativeLayout;
            relativeLayout.setOnTouchListener(new View$OnTouchListenerC0913a(this));
            this.f15069g = (ImageView) this.f15064b.findViewById(R.id.search_icon);
            this.f15067e = (EditText) this.f15064b.findViewById(R.id.search_box);
            ImageView imageView = (ImageView) this.f15064b.findViewById(R.id.search_del);
            this.f15068f = imageView;
            imageView.setOnClickListener(new b(this));
            k(false);
            this.f15067e.setText("");
            this.f15067e.requestFocus();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15073k = (LinearLayout) this.f15064b.findViewById(R.id.layout_container);
            this.f15070h = (RecyclerView) this.f15064b.findViewById(R.id.rv_major_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
            this.f15071i = linearLayoutManager;
            this.f15070h.setLayoutManager(linearLayoutManager);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.a);
            this.f15072j = searchMajorResultItemAdapter;
            this.f15070h.setAdapter(searchMajorResultItemAdapter);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
            f();
            g();
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.f15072j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.notifyDataSetChanged();
            }
            this.f15065c.onChangeSkinType(this.a.getPageContext(), i2);
            this.f15067e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.f15067e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15069g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.f15066d, R.drawable.search_major_bg);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15068f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || StringUtils.isNull(this.f15067e.getText().toString())) {
            return;
        }
        this.f15066d.setFocusable(true);
        this.f15066d.setFocusableInTouchMode(true);
        this.f15066d.requestFocus();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f15068f.setVisibility(z ? 0 : 8);
        }
    }

    public void l(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) {
            this.f15070h.setVisibility(0);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.f15072j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.setKeyWord(str);
                this.f15072j.setData(list);
                this.f15070h.setAdapter(this.f15072j);
            }
        }
    }

    public void m(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, errorData) == null) {
            this.f15070h.setVisibility(8);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.f15072j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.setNoData();
            }
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f15072j.setOnItemClickListener(bVar);
        }
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.f15070h.addOnScrollListener(onScrollListener);
        }
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onEditorActionListener) == null) {
            this.f15067e.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onFocusChangeListener) == null) {
            this.f15067e.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void r(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textWatcher) == null) {
            this.f15067e.addTextChangedListener(textWatcher);
        }
    }
}
