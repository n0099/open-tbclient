package c.a.r0.k1.x;

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
    public View f21671a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f21672b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f21673c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f21674d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.k1.x.a f21675e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f21676f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f21677g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21678e;

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
            this.f21678e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21678e.f21673c.finish();
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
        this.f21673c = validateActivity;
        f();
        c.a.r0.k1.x.a aVar = new c.a.r0.k1.x.a(this.f21673c);
        this.f21675e = aVar;
        this.f21674d.setAdapter((ListAdapter) aVar);
        this.f21674d.setOnSrollToBottomListener(this.f21673c);
    }

    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21672b : (ImageView) invokeV.objValue;
    }

    @Override // c.a.e.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.destroy();
            c.a.r0.k1.x.a aVar = this.f21675e;
            if (aVar != null) {
                aVar.a();
                this.f21675e = null;
            }
            this.f21673c = null;
        }
    }

    public c.a.r0.k1.x.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21675e : (c.a.r0.k1.x.a) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.f21673c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
            this.f21671a = inflate;
            this.f21673c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f21673c.findViewById(R.id.view_navigation_bar);
            this.f21677g = navigationBar;
            navigationBar.setTitleText(this.f21673c.getPageContext().getString(R.string.validate));
            this.f21677g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f21674d = (BdListView) this.f21671a.findViewById(R.id.validate_list);
            this.f21676f = (ProgressBar) this.f21671a.findViewById(R.id.pro_load);
            h(false);
        }
    }

    public void g(List<ValidateItemData> list) {
        c.a.r0.k1.x.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (aVar = this.f21675e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f21676f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f21673c.getLayoutMode().k(i2 == 1);
            this.f21673c.getLayoutMode().j(this.f21671a);
            this.f21677g.onChangeSkinType(this.f21673c.getPageContext(), i2);
            if (i2 != 1 && i2 != 4) {
                this.f21674d.setDivider(new ColorDrawable(this.f21673c.getResources().getColor(R.color.common_color_10241)));
                this.f21674d.setDividerHeight(this.f21673c.getResources().getDimensionPixelSize(R.dimen.ds2));
                return;
            }
            this.f21674d.setDivider(new ColorDrawable(this.f21673c.getResources().getColor(R.color.common_color_10179)));
            this.f21674d.setDividerHeight(this.f21673c.getResources().getDimensionPixelSize(R.dimen.ds2));
        }
    }
}
