package com.baidu.nadcore.business.inserting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.d.e;
import c.a.d0.d.g;
import c.a.d0.d.n.b;
import c.a.d0.f.d;
import c.a.d0.h0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class NadImageInsertingView extends NadInsertingBaseView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HALF_HEIGHT = 1794;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f37159e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37160f;
    public View.OnClickListener mClickListener;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadImageInsertingView f37161e;

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
            this.f37161e = nadImageInsertingView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f37161e.getTag() instanceof AdBaseModel)) {
                AdBaseModel adBaseModel = (AdBaseModel) this.f37161e.getTag();
                this.f37161e.insertingClickClog(adBaseModel, ClogBuilder.Area.IMAGE);
                d.b(adBaseModel.f37258f.f3092c);
                this.f37161e.mNadCallback.c();
                this.f37161e.c(2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements c.a.d0.r.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.d0.s.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.c f37162b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f37163c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NadImageInsertingView f37164d;

        public b(NadImageInsertingView nadImageInsertingView, c.a.d0.s.d dVar, b.c cVar, AdBaseModel adBaseModel) {
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
            this.f37164d = nadImageInsertingView;
            this.a = dVar;
            this.f37162b = cVar;
            this.f37163c = adBaseModel;
        }

        @Override // c.a.d0.r.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f37164d.insertingCheckClog(this.f37163c, "16", "16003");
                this.f37162b.onFail();
            }
        }

        @Override // c.a.d0.r.b
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                int i2 = this.a.f3079b;
                if (i2 > 1794) {
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), (int) ((1.0f - (((i2 - 1794) * 1.0f) / i2)) * bitmap.getHeight()));
                }
                if (bitmap != null) {
                    this.f37164d.f37159e.setImageBitmap(bitmap);
                    this.f37162b.onSuccess();
                    return;
                }
                this.f37164d.insertingCheckClog(this.f37163c, "16", "16002");
                this.f37162b.onFail();
            }
        }
    }

    /* loaded from: classes10.dex */
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

        @Override // c.a.d0.h0.s.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.b();
                this.a.c(1);
            }
        }

        @Override // c.a.d0.h0.s.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.c();
                this.a.mNadCallback.b();
            }
        }

        @Override // c.a.d0.h0.s.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.d();
                this.a.mNadCallback.a();
            }
        }

        @Override // c.a.d0.h0.s.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.e();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadImageInsertingView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull c.a.d0.d.n.a aVar) {
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
                super((Context) objArr2[0], (ViewGroup) objArr2[1], (c.a.d0.d.n.a) objArr2[2]);
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
            c.a.d0.q.a.g(this.mLifecycleCallback);
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
            c.a.d0.s.d dVar = (c.a.d0.s.d) c.a.d0.x.a.d(adBaseModel.f37258f.k, 0);
            if (dVar == null) {
                setVisibility(8);
                insertingCheckClog(adBaseModel, "16", "16001");
                cVar.onFail();
                return;
            }
            c.a.d0.l0.a.a().d(dVar.a, new b(this, dVar, cVar, adBaseModel));
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
            LayoutInflater.from(context).inflate(g.nad_inserting_image_layout, this);
            this.f37159e = (AdImageView) findViewById(e.nad_inserting_image);
            this.f37160f = (TextView) findViewById(e.nad_inserting_tag);
        }
    }

    public void onAdShow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (getTag() instanceof AdBaseModel) && this.mNadCallback != null) {
            insertingShowClog((AdBaseModel) getTag());
            this.mStartShowTime = System.currentTimeMillis();
            this.mNadCallback.onShow();
            this.mCountDownTimer.e();
            c.a.d0.q.a.f(this.mLifecycleCallback);
            this.f37159e.setVisibility(0);
            this.f37160f.setVisibility(0);
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
