package b.a.r0.w1;

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
import b.a.e.e.p.l;
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

    /* renamed from: a  reason: collision with root package name */
    public SearchMajorActivity f25341a;

    /* renamed from: b  reason: collision with root package name */
    public View f25342b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f25343c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f25344d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f25345e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f25346f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f25347g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f25348h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f25349i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: b.a.r0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnTouchListenerC1242a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25350e;

        public View$OnTouchListenerC1242a(a aVar) {
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
            this.f25350e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f25350e.f25344d.setFocusable(true);
                    this.f25350e.f25344d.setFocusableInTouchMode(true);
                    if (this.f25350e.f25345e.hasFocus()) {
                        l.x(this.f25350e.f25341a, this.f25350e.f25345e);
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
        public final /* synthetic */ a f25351e;

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
            this.f25351e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25351e.f25345e.setText("");
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
        this.f25342b = view;
        this.f25341a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (LinearLayout) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f25342b.findViewById(R.id.navigation_bar);
            this.f25343c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f25343c.setCenterTextTitle(this.f25341a.getResources().getString(R.string.search_major));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f25342b.findViewById(R.id.search_container);
            this.f25344d = relativeLayout;
            relativeLayout.setOnTouchListener(new View$OnTouchListenerC1242a(this));
            this.f25347g = (ImageView) this.f25342b.findViewById(R.id.search_icon);
            this.f25345e = (EditText) this.f25342b.findViewById(R.id.search_box);
            ImageView imageView = (ImageView) this.f25342b.findViewById(R.id.search_del);
            this.f25346f = imageView;
            imageView.setOnClickListener(new b(this));
            k(false);
            this.f25345e.setText("");
            this.f25345e.requestFocus();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = (LinearLayout) this.f25342b.findViewById(R.id.layout_container);
            this.f25348h = (RecyclerView) this.f25342b.findViewById(R.id.rv_major_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f25341a);
            this.f25349i = linearLayoutManager;
            this.f25348h.setLayoutManager(linearLayoutManager);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f25341a);
            this.j = searchMajorResultItemAdapter;
            this.f25348h.setAdapter(searchMajorResultItemAdapter);
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
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.notifyDataSetChanged();
            }
            this.f25343c.onChangeSkinType(this.f25341a.getPageContext(), i2);
            this.f25345e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.f25345e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f25347g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.f25344d, R.drawable.search_major_bg);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f25346f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || StringUtils.isNull(this.f25345e.getText().toString())) {
            return;
        }
        this.f25344d.setFocusable(true);
        this.f25344d.setFocusableInTouchMode(true);
        this.f25344d.requestFocus();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f25346f.setVisibility(z ? 0 : 8);
        }
    }

    public void l(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) {
            this.f25348h.setVisibility(0);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.setKeyWord(str);
                this.j.setData(list);
                this.f25348h.setAdapter(this.j);
            }
        }
    }

    public void m(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, errorData) == null) {
            this.f25348h.setVisibility(8);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.setNoData();
            }
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.j.setOnItemClickListener(bVar);
        }
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.f25348h.addOnScrollListener(onScrollListener);
        }
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onEditorActionListener) == null) {
            this.f25345e.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onFocusChangeListener) == null) {
            this.f25345e.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void r(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textWatcher) == null) {
            this.f25345e.addTextChangedListener(textWatcher);
        }
    }
}
