package c.a.r0.v.f.g.f;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c extends c.a.r0.v.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f25858f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f25859g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25860e;

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
            this.f25860e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f25860e.f25854d.f25805b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = this.f25860e;
            urlManager.dealOneLink(cVar.f25853c, new String[]{cVar.f25854d.f25805b}, true);
            c.a.r0.v.f.e.a.c().f("c12909", this.f25860e.f25854d.f25808e, 3, "-1", 0L, null, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
    }

    @Override // c.a.r0.v.f.g.f.a
    public void b(c.a.r0.v.f.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            this.f25859g.startLoad(aVar.f25804a, 10, false);
            c.a.r0.v.f.e.a.c().f("c12908", this.f25854d.f25808e, 3, "-1", 0L, null, null);
        }
    }

    @Override // c.a.r0.v.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25858f : (View) invokeV.objValue;
    }

    @Override // c.a.r0.v.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25858f = new FrameLayout(this.f25853c.getPageActivity());
            this.f25859g = new TbImageView(this.f25853c.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f25851a, this.f25852b);
            this.f25859g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f25859g.setLayoutParams(layoutParams);
            this.f25858f.addView(this.f25859g);
            this.f25855e.setVisibility(8);
            this.f25858f.addView(this.f25855e);
            this.f25859g.setOnClickListener(new a(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.r0.v.f.g.f.a
    public boolean f(c.a.r0.v.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 3 != aVar.f25807d || TextUtils.isEmpty(aVar.f25804a)) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.r0.v.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // c.a.r0.v.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            TbImageView tbImageView = this.f25859g;
            if (tbImageView != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
                layoutParams.width = this.f25851a;
                layoutParams.height = this.f25852b;
                this.f25859g.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // c.a.r0.v.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (1 == i2) {
                this.f25855e.setVisibility(0);
            } else {
                this.f25855e.setVisibility(8);
            }
        }
    }

    @Override // c.a.r0.v.f.g.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25859g = null;
        }
    }

    @Override // c.a.r0.v.f.g.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // c.a.r0.v.f.g.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
