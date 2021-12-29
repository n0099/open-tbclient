package c.a.t0.s1.x;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import c.a.d.a.d;
import c.a.d.a.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f22918b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f22919c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f22920d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.s1.x.a f22921e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f22922f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f22923g;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22924e;

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
            this.f22924e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22924e.f22919c.finish();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22919c = validateActivity;
        f();
        c.a.t0.s1.x.a aVar = new c.a.t0.s1.x.a(this.f22919c);
        this.f22921e = aVar;
        this.f22920d.setAdapter((ListAdapter) aVar);
        this.f22920d.setOnSrollToBottomListener(this.f22919c);
    }

    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22918b : (ImageView) invokeV.objValue;
    }

    @Override // c.a.d.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.destroy();
            c.a.t0.s1.x.a aVar = this.f22921e;
            if (aVar != null) {
                aVar.a();
                this.f22921e = null;
            }
            this.f22919c = null;
        }
    }

    public c.a.t0.s1.x.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22921e : (c.a.t0.s1.x.a) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.f22919c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
            this.a = inflate;
            this.f22919c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f22919c.findViewById(R.id.view_navigation_bar);
            this.f22923g = navigationBar;
            navigationBar.setTitleText(this.f22919c.getPageContext().getString(R.string.validate));
            this.f22923g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f22920d = (BdListView) this.a.findViewById(R.id.validate_list);
            this.f22922f = (ProgressBar) this.a.findViewById(R.id.pro_load);
            h(false);
        }
    }

    public void g(List<ValidateItemData> list) {
        c.a.t0.s1.x.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (aVar = this.f22921e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f22922f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f22919c.getLayoutMode().k(i2 == 1);
            this.f22919c.getLayoutMode().j(this.a);
            this.f22923g.onChangeSkinType(this.f22919c.getPageContext(), i2);
            if (i2 != 1 && i2 != 4) {
                this.f22920d.setDivider(new ColorDrawable(this.f22919c.getResources().getColor(R.color.common_color_10241)));
                this.f22920d.setDividerHeight(this.f22919c.getResources().getDimensionPixelSize(R.dimen.ds2));
                return;
            }
            this.f22920d.setDivider(new ColorDrawable(this.f22919c.getResources().getColor(R.color.common_color_10179)));
            this.f22920d.setDividerHeight(this.f22919c.getResources().getDimensionPixelSize(R.dimen.ds2));
        }
    }
}
