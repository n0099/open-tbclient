package c.a.q0.j1.x;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import c.a.e.a.d;
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class c extends d<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f21101a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f21102b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f21103c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f21104d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.j1.x.a f21105e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f21106f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f21107g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21108e;

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
            this.f21108e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21108e.f21103c.finish();
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
        this.f21103c = validateActivity;
        f();
        c.a.q0.j1.x.a aVar = new c.a.q0.j1.x.a(this.f21103c);
        this.f21105e = aVar;
        this.f21104d.setAdapter((ListAdapter) aVar);
        this.f21104d.setOnSrollToBottomListener(this.f21103c);
    }

    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21102b : (ImageView) invokeV.objValue;
    }

    @Override // c.a.e.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.destroy();
            c.a.q0.j1.x.a aVar = this.f21105e;
            if (aVar != null) {
                aVar.a();
                this.f21105e = null;
            }
            this.f21103c = null;
        }
    }

    public c.a.q0.j1.x.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21105e : (c.a.q0.j1.x.a) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.f21103c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
            this.f21101a = inflate;
            this.f21103c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f21103c.findViewById(R.id.view_navigation_bar);
            this.f21107g = navigationBar;
            navigationBar.setTitleText(this.f21103c.getPageContext().getString(R.string.validate));
            this.f21107g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f21104d = (BdListView) this.f21101a.findViewById(R.id.validate_list);
            this.f21106f = (ProgressBar) this.f21101a.findViewById(R.id.pro_load);
            h(false);
        }
    }

    public void g(List<ValidateItemData> list) {
        c.a.q0.j1.x.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (aVar = this.f21105e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f21106f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f21103c.getLayoutMode().k(i2 == 1);
            this.f21103c.getLayoutMode().j(this.f21101a);
            this.f21107g.onChangeSkinType(this.f21103c.getPageContext(), i2);
            if (i2 != 1 && i2 != 4) {
                this.f21104d.setDivider(new ColorDrawable(this.f21103c.getResources().getColor(R.color.common_color_10241)));
                this.f21104d.setDividerHeight(this.f21103c.getResources().getDimensionPixelSize(R.dimen.ds2));
                return;
            }
            this.f21104d.setDivider(new ColorDrawable(this.f21103c.getResources().getColor(R.color.common_color_10179)));
            this.f21104d.setDividerHeight(this.f21103c.getResources().getDimensionPixelSize(R.dimen.ds2));
        }
    }
}
