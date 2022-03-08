package com.baidu.nadcore.business.inserting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.d.e.b;
import c.a.b0.h0.s;
import c.a.b0.s.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NadImageInsertingView extends NadInsertingBaseView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HALF_HEIGHT = 1794;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f35562e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35563f;
    public View.OnClickListener mClickListener;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadImageInsertingView f35564e;

        public a(NadImageInsertingView nadImageInsertingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadImageInsertingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35564e = nadImageInsertingView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f35564e.getTag() instanceof AdBaseModel)) {
                AdBaseModel adBaseModel = (AdBaseModel) this.f35564e.getTag();
                this.f35564e.insertingClickClog(adBaseModel, ClogBuilder.Area.IMAGE);
                c.a.b0.f.c.b(adBaseModel.f35661f.f1922c);
                this.f35564e.mNadCallback.c();
                this.f35564e.c(2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.b0.r.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.c f35565b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f35566c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NadImageInsertingView f35567d;

        public b(NadImageInsertingView nadImageInsertingView, d dVar, b.c cVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadImageInsertingView, dVar, cVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35567d = nadImageInsertingView;
            this.a = dVar;
            this.f35565b = cVar;
            this.f35566c = adBaseModel;
        }

        @Override // c.a.b0.r.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35567d.insertingCheckClog(this.f35566c, "16", "16003");
                this.f35565b.onFail();
            }
        }

        @Override // c.a.b0.r.b
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                int i2 = this.a.f1909b;
                if (i2 > 1794) {
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), (int) ((1.0f - (((i2 - 1794) * 1.0f) / i2)) * bitmap.getHeight()));
                }
                if (bitmap != null) {
                    this.f35567d.f35562e.setImageBitmap(bitmap);
                    this.f35565b.onSuccess();
                    return;
                }
                this.f35567d.insertingCheckClog(this.f35566c, "16", "16002");
                this.f35565b.onFail();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends s.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadImageInsertingView;
        }

        @Override // c.a.b0.h0.s.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.b();
                this.a.c(1);
            }
        }

        @Override // c.a.b0.h0.s.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.a.mNadCallback.b();
            }
        }

        @Override // c.a.b0.h0.s.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.a.mNadCallback.a();
            }
        }

        @Override // c.a.b0.h0.s.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.e();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadImageInsertingView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull c.a.b0.d.e.a aVar) {
        super(context, viewGroup, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ViewGroup) objArr2[1], (c.a.b0.d.e.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClickListener = new a(this);
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            setVisibility(8);
            try {
                removeAllViews();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
            long currentTimeMillis = (System.currentTimeMillis() - this.mStartShowTime) / 1000;
            if (i2 == 1) {
                insertingCloseClog(adBaseModel, ClogBuilder.Area.AUTO_HIDE, currentTimeMillis);
            } else if (i2 == 0) {
                insertingCloseClog(adBaseModel, ClogBuilder.Area.CLOSE_BTN, currentTimeMillis);
            }
            this.mNadCallback.d();
            c.a.b0.q.a.g(this.mLifecycleCallback);
            this.mCountDownTimer.a();
        }
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void closeAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c(0);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            s sVar = new s(5000L, 1000L);
            sVar.d(new c(this));
            this.mCountDownTimer = sVar;
        }
    }

    public final void e(@NonNull AdBaseModel adBaseModel, @NonNull b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adBaseModel, cVar) == null) {
            d dVar = (d) c.a.b0.x.a.d(adBaseModel.f35661f.k, 0);
            if (dVar == null) {
                setVisibility(8);
                insertingCheckClog(adBaseModel, "16", "16001");
                cVar.onFail();
                return;
            }
            c.a.b0.l0.a.a().d(dVar.a, new b(this, dVar, cVar, adBaseModel));
        }
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.nad_inserting_image_layout, this);
            this.f35562e = (AdImageView) findViewById(R.id.nad_inserting_image);
            this.f35563f = (TextView) findViewById(R.id.nad_inserting_tag);
        }
    }

    public void onAdShow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (getTag() instanceof AdBaseModel) && this.mNadCallback != null) {
            insertingShowClog((AdBaseModel) getTag());
            this.mStartShowTime = System.currentTimeMillis();
            this.mNadCallback.onShow();
            this.mCountDownTimer.e();
            c.a.b0.q.a.f(this.mLifecycleCallback);
            this.f35562e.setVisibility(0);
            this.f35563f.setVisibility(0);
        }
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void setData(@NonNull AdBaseModel adBaseModel, @NonNull b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, adBaseModel, cVar) == null) {
            setTag(adBaseModel);
            setOnClickListener(this.mClickListener);
            d();
            e(adBaseModel, cVar);
        }
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void showAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            onAdShow();
        }
    }
}
