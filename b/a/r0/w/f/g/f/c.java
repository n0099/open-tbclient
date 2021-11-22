package b.a.r0.w.f.g.f;

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
/* loaded from: classes5.dex */
public class c extends b.a.r0.w.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f26385f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f26386g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26387e;

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
            this.f26387e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f26387e.f26381d.f26333b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = this.f26387e;
            urlManager.dealOneLink(cVar.f26380c, new String[]{cVar.f26381d.f26333b}, true);
            b.a.r0.w.f.e.a.c().f("c12909", this.f26387e.f26381d.f26336e, 3, "-1", 0L, null, null);
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

    @Override // b.a.r0.w.f.g.f.a
    public void b(b.a.r0.w.f.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            this.f26386g.startLoad(aVar.f26332a, 10, false);
            b.a.r0.w.f.e.a.c().f("c12908", this.f26381d.f26336e, 3, "-1", 0L, null, null);
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26385f : (View) invokeV.objValue;
    }

    @Override // b.a.r0.w.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26385f = new FrameLayout(this.f26380c.getPageActivity());
            this.f26386g = new TbImageView(this.f26380c.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f26378a, this.f26379b);
            this.f26386g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f26386g.setLayoutParams(layoutParams);
            this.f26385f.addView(this.f26386g);
            this.f26382e.setVisibility(8);
            this.f26385f.addView(this.f26382e);
            this.f26386g.setOnClickListener(new a(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public boolean f(b.a.r0.w.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 3 != aVar.f26335d || TextUtils.isEmpty(aVar.f26332a)) ? false : true : invokeL.booleanValue;
    }

    @Override // b.a.r0.w.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            TbImageView tbImageView = this.f26386g;
            if (tbImageView != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
                layoutParams.width = this.f26378a;
                layoutParams.height = this.f26379b;
                this.f26386g.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (1 == i2) {
                this.f26382e.setVisibility(0);
            } else {
                this.f26382e.setVisibility(8);
            }
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26386g = null;
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
