package com.baidu.nadcore.business.inserting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.e41;
import com.baidu.tieba.hh0;
import com.baidu.tieba.ih0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.in0;
import com.baidu.tieba.lp0;
import com.baidu.tieba.o01;
import com.baidu.tieba.qn0;
import com.baidu.tieba.y61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NadImageInsertingView extends NadInsertingBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView e;
    public TextView f;
    public View.OnClickListener g;

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadImageInsertingView a;

        public a(NadImageInsertingView nadImageInsertingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadImageInsertingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadImageInsertingView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(this.a.getTag() instanceof AdBaseModel)) {
                return;
            }
            AdBaseModel adBaseModel = (AdBaseModel) this.a.getTag();
            this.a.d(adBaseModel, ClogBuilder.Area.IMAGE);
            ii0.b(adBaseModel.f.c);
            this.a.a.c();
            this.a.j(2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements qn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lp0 a;
        public final /* synthetic */ ih0.c b;
        public final /* synthetic */ AdBaseModel c;
        public final /* synthetic */ NadImageInsertingView d;

        public b(NadImageInsertingView nadImageInsertingView, lp0 lp0Var, ih0.c cVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadImageInsertingView, lp0Var, cVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nadImageInsertingView;
            this.a = lp0Var;
            this.b = cVar;
            this.c = adBaseModel;
        }

        @Override // com.baidu.tieba.qn0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.c(this.c, "16", "16003");
                this.b.onFail();
            }
        }

        @Override // com.baidu.tieba.qn0
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                int i = this.a.b;
                if (i > 1794) {
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), (int) ((1.0f - (((i - 1794) * 1.0f) / i)) * bitmap.getHeight()));
                }
                if (bitmap != null) {
                    this.d.e.setImageBitmap(bitmap);
                    this.b.onSuccess();
                    return;
                }
                this.d.c(this.c, "16", "16002");
                this.b.onFail();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends e41.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadImageInsertingView a;

        public c(NadImageInsertingView nadImageInsertingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadImageInsertingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadImageInsertingView;
        }

        @Override // com.baidu.tieba.e41.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.b();
                this.a.j(1);
            }
        }

        @Override // com.baidu.tieba.e41.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.a.a.b();
            }
        }

        @Override // com.baidu.tieba.e41.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.a.a.a();
            }
        }

        @Override // com.baidu.tieba.e41.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.e();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadImageInsertingView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull hh0 hh0Var) {
        super(context, viewGroup, hh0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, hh0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ViewGroup) objArr2[1], (hh0) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void setData(@NonNull AdBaseModel adBaseModel, @NonNull ih0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel, cVar) == null) {
            setTag(adBaseModel);
            setOnClickListener(this.g);
            l();
            m(adBaseModel, cVar);
        }
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.nad_inserting_image_layout, this);
            this.e = (AdImageView) findViewById(R.id.nad_inserting_image);
            this.f = (TextView) findViewById(R.id.nad_inserting_tag);
        }
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j(0);
        }
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e41 e41Var = new e41(5000L, 1000L);
            e41Var.d(new c(this));
            this.c = e41Var;
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        setVisibility(8);
        try {
            removeAllViews();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        long currentTimeMillis = (System.currentTimeMillis() - this.b) / 1000;
        if (i == 1) {
            e(adBaseModel, ClogBuilder.Area.AUTO_HIDE, currentTimeMillis);
        } else if (i == 0) {
            e(adBaseModel, ClogBuilder.Area.CLOSE_BTN, currentTimeMillis);
        }
        this.a.d();
        in0.g(this.d);
        this.c.a();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (getTag() instanceof AdBaseModel) && this.a != null) {
            f((AdBaseModel) getTag());
            this.b = System.currentTimeMillis();
            this.a.onShow();
            this.c.e();
            in0.f(this.d);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
        }
    }

    public final void m(@NonNull AdBaseModel adBaseModel, @NonNull ih0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, adBaseModel, cVar) == null) {
            lp0 lp0Var = (lp0) o01.d(adBaseModel.f.k, 0);
            if (lp0Var == null) {
                setVisibility(8);
                c(adBaseModel, "16", "16001");
                cVar.onFail();
                return;
            }
            y61.a().e(lp0Var.a, new b(this, lp0Var, cVar, adBaseModel));
        }
    }
}
