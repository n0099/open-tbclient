package c.a.p0.u1.x;

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
/* loaded from: classes2.dex */
public class c extends d<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f18943b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f18944c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f18945d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.u1.x.a f18946e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f18947f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f18948g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f18944c.finish();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18944c = validateActivity;
        h();
        c.a.p0.u1.x.a aVar = new c.a.p0.u1.x.a(this.f18944c);
        this.f18946e = aVar;
        this.f18945d.setAdapter((ListAdapter) aVar);
        this.f18945d.setOnSrollToBottomListener(this.f18944c);
    }

    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18943b : (ImageView) invokeV.objValue;
    }

    @Override // c.a.d.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.destroy();
            c.a.p0.u1.x.a aVar = this.f18946e;
            if (aVar != null) {
                aVar.a();
                this.f18946e = null;
            }
            this.f18944c = null;
        }
    }

    public c.a.p0.u1.x.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18946e : (c.a.p0.u1.x.a) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.f18944c.getPageContext().getPageActivity(), R.layout.obfuscated_res_0x7f0d086a, null);
            this.a = inflate;
            this.f18944c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f18944c.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f18948g = navigationBar;
            navigationBar.setTitleText(this.f18944c.getPageContext().getString(R.string.obfuscated_res_0x7f0f14b0));
            this.f18948g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f18945d = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f0922eb);
            this.f18947f = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091914);
            j(false);
        }
    }

    public void i(List<ValidateItemData> list) {
        c.a.p0.u1.x.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (aVar = this.f18946e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f18947f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f18944c.getLayoutMode().k(i == 1);
            this.f18944c.getLayoutMode().j(this.a);
            this.f18948g.onChangeSkinType(this.f18944c.getPageContext(), i);
            if (i != 1 && i != 4) {
                this.f18945d.setDivider(new ColorDrawable(this.f18944c.getResources().getColor(R.color.common_color_10241)));
                this.f18945d.setDividerHeight(this.f18944c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
                return;
            }
            this.f18945d.setDivider(new ColorDrawable(this.f18944c.getResources().getColor(R.color.common_color_10179)));
            this.f18945d.setDividerHeight(this.f18944c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
        }
    }
}
