package b.a.r0.l1.x;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import b.a.e.a.d;
import b.a.e.a.f;
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
/* loaded from: classes5.dex */
public class c extends d<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f21967a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f21968b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f21969c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f21970d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.l1.x.a f21971e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f21972f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f21973g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21974e;

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
            this.f21974e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21974e.f21969c.finish();
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
        this.f21969c = validateActivity;
        f();
        b.a.r0.l1.x.a aVar = new b.a.r0.l1.x.a(this.f21969c);
        this.f21971e = aVar;
        this.f21970d.setAdapter((ListAdapter) aVar);
        this.f21970d.setOnSrollToBottomListener(this.f21969c);
    }

    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21968b : (ImageView) invokeV.objValue;
    }

    @Override // b.a.e.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.destroy();
            b.a.r0.l1.x.a aVar = this.f21971e;
            if (aVar != null) {
                aVar.a();
                this.f21971e = null;
            }
            this.f21969c = null;
        }
    }

    public b.a.r0.l1.x.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21971e : (b.a.r0.l1.x.a) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.f21969c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
            this.f21967a = inflate;
            this.f21969c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f21969c.findViewById(R.id.view_navigation_bar);
            this.f21973g = navigationBar;
            navigationBar.setTitleText(this.f21969c.getPageContext().getString(R.string.validate));
            this.f21973g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f21970d = (BdListView) this.f21967a.findViewById(R.id.validate_list);
            this.f21972f = (ProgressBar) this.f21967a.findViewById(R.id.pro_load);
            h(false);
        }
    }

    public void g(List<ValidateItemData> list) {
        b.a.r0.l1.x.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (aVar = this.f21971e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f21972f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f21969c.getLayoutMode().k(i2 == 1);
            this.f21969c.getLayoutMode().j(this.f21967a);
            this.f21973g.onChangeSkinType(this.f21969c.getPageContext(), i2);
            if (i2 != 1 && i2 != 4) {
                this.f21970d.setDivider(new ColorDrawable(this.f21969c.getResources().getColor(R.color.common_color_10241)));
                this.f21970d.setDividerHeight(this.f21969c.getResources().getDimensionPixelSize(R.dimen.ds2));
                return;
            }
            this.f21970d.setDivider(new ColorDrawable(this.f21969c.getResources().getColor(R.color.common_color_10179)));
            this.f21970d.setDividerHeight(this.f21969c.getResources().getDimensionPixelSize(R.dimen.ds2));
        }
    }
}
