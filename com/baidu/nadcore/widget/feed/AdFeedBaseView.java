package com.baidu.nadcore.widget.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.d.h;
import c.a.d0.h0.f;
import c.a.d0.j.f.j;
import c.a.d0.l0.g;
import c.a.d0.s.b;
import c.a.d0.s.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uitemplate.DislikeBottomDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f37571g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f37572e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37573f;
    public DislikeBottomDialog mBottomDialog;
    public c.a.d0.l0.x.b mFeedListener;
    public c.a.d0.l0.x.a mNadDownloadListener;
    public c.a.d0.j.f.d mNativeDownloadPresenter;
    public c.a.d0.l0.x.c mVideoMediaListener;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37574e;

        public a(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37574e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f37574e.onDislikeBtnClicked();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements DislikeBottomDialog.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdFeedBaseView a;

        public b(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adFeedBaseView;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.DislikeBottomDialog.d
        public void a(List<b.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Toast.makeText(this.a.getContext(), h.nad_dislike_reduce_recommend, 0).show();
                this.a.setVisibility(8);
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.mFeedListener == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.a.mFeedListener.a((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37575e;

        public c(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37575e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.d0.j.f.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (dVar = this.f37575e.mNativeDownloadPresenter) == null) {
                return;
            }
            dVar.o();
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37576e;

        public d(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37576e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f37576e.getTag() instanceof AdBaseModel)) {
                AdBaseModel adBaseModel = (AdBaseModel) this.f37576e.getTag();
                String str = adBaseModel.f37258f.f3092c;
                AdOperator adOperator = adBaseModel.f37260h;
                if (adOperator != null && !TextUtils.isEmpty(adOperator.f37265d)) {
                    str = adBaseModel.f37260h.f37265d;
                }
                c.a.d0.f.d.c(str, this.f37576e.getContext());
                c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).g(ClogBuilder.Area.BUTTON).n(adBaseModel.f37258f.f3093d));
                c.a.d0.l0.x.b bVar = this.f37576e.mFeedListener;
                if (bVar != null) {
                    bVar.b(adBaseModel);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37577b;

        public e(AdFeedBaseView adFeedBaseView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37577b = adFeedBaseView;
            this.a = adBaseModel;
        }

        @Override // c.a.d0.j.f.j
        public void a(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37577b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37577b.mNadDownloadListener.e(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void b(c.a.d0.j.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                AdFeedBaseView adFeedBaseView = this.f37577b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37577b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void c(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37577b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37577b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void d(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37577b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37577b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void e(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37577b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37577b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void f(c.a.d0.j.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                AdFeedBaseView adFeedBaseView = this.f37577b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37577b.mNadDownloadListener.g(this.a, f2);
            }
        }

        @Override // c.a.d0.j.f.j
        public void g(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37577b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37577b.mNadDownloadListener.b(this.a);
            }
        }

        @Override // c.a.d0.j.f.j
        public void h(c.a.d0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37577b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37577b.mNadDownloadListener.f(this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37578e;

        public f(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37578e = adFeedBaseView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f37578e.f37573f = true;
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f37578e.f37573f = false;
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f37578e.f37573f = false;
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ f(AdFeedBaseView adFeedBaseView, a aVar) {
            this(adFeedBaseView);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1776047025, "Lcom/baidu/nadcore/widget/feed/AdFeedBaseView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1776047025, "Lcom/baidu/nadcore/widget/feed/AdFeedBaseView;");
                return;
            }
        }
        f37571g = f.c.a(c.a.d0.h.a.b(), 15.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37573f = true;
    }

    public void bindDownloadView(@NonNull View view, @NonNull c.a.d0.l0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) {
            view.setOnClickListener(new c(this));
            setViewDownloadListener(aVar);
        }
    }

    public void bindOperateBtnView(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.setOnClickListener(new d(this));
        }
    }

    public final void c() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (findViewById = findViewById(c.a.d0.d.e.nad_base_delete_id)) == null) {
            return;
        }
        g.a(this, findViewById, f37571g);
        findViewById.setOnClickListener(new a(this));
    }

    public final boolean d(c.a.d0.j.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.d0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.l) == null || !TextUtils.equals(aVar.f2802g, cVar.f3076c) || !TextUtils.equals(aVar.d(), cVar.f3077d)) ? false : true : invokeLL.booleanValue;
    }

    public void destroy() {
        c.a.d0.j.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (dVar = this.mNativeDownloadPresenter) == null) {
            return;
        }
        dVar.m();
        this.mNativeDownloadPresenter = null;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (adBaseModel.a) {
                return;
            }
            c.a.d0.l0.x.b bVar = this.mFeedListener;
            if (bVar != null) {
                bVar.c(adBaseModel);
            }
            c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.SHOW).n(adBaseModel.f37258f.f3093d));
            adBaseModel.a = true;
        }
    }

    public final void f(@NonNull AdBaseModel adBaseModel) {
        c.a.d0.s.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) && (cVar = adBaseModel.l) != null && cVar.f3078e) {
            this.mNativeDownloadPresenter = new c.a.d0.j.f.d(c.a.d0.j.d.a.b(adBaseModel));
            c.a.d0.l0.x.a aVar = this.mNadDownloadListener;
            if (aVar != null) {
                aVar.d(adBaseModel);
            }
            this.mNativeDownloadPresenter.q(new e(this, adBaseModel));
        }
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void notifyDislikeClicked(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            c.a.d0.a0.a.b(new c.a.d0.a0.c.b().d(str).f(adBaseModel.f37258f.f3093d).e(c.a.d0.h.a.a().b()));
            setVisibility(8);
            c.a.d0.l0.x.b bVar = this.mFeedListener;
            if (bVar != null) {
                bVar.a(adBaseModel);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            e();
        }
    }

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view) == null) && this.f37573f && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (TextUtils.isEmpty(adBaseModel.f37258f.f3092c)) {
                return;
            }
            c.a.d0.g0.a.e(adBaseModel);
            c.a.d0.f.d.c(c.a.d0.g0.a.b(adBaseModel, adBaseModel.f37258f.f3092c), getContext());
            c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).g(ClogBuilder.Area.HOTAREA).n(adBaseModel.f37258f.f3093d));
            c.a.d0.l0.x.b bVar = this.mFeedListener;
            if (bVar != null) {
                bVar.b(adBaseModel);
            }
            adBaseModel.f37254b = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            destroy();
        }
    }

    public void onDislikeBtnClicked() {
        AdBaseModel adBaseModel;
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if ((getTag() instanceof AdBaseModel) && (sVar = (adBaseModel = (AdBaseModel) getTag()).q) != null && !sVar.m) {
                c.a.d0.l0.x.b bVar = this.mFeedListener;
                if (bVar != null) {
                    bVar.a(adBaseModel);
                }
                c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLOSE).n(adBaseModel.f37258f.f3093d));
                return;
            }
            if (this.mBottomDialog == null) {
                if (!(getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.mBottomDialog = new DislikeBottomDialog(getContext(), (AdBaseModel) getTag());
            }
            this.mBottomDialog.setDislikeListener(new b(this));
            c.a.d0.h0.a.b(this.mBottomDialog);
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            this.f37572e.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            super.onViewAdded(view);
            if (view.getVisibility() == 0) {
                e();
                c();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
            if (i2 == 0) {
                e();
            }
        }
    }

    public void setVideoMediaListener(c.a.d0.l0.x.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.mVideoMediaListener = cVar;
        }
    }

    public void setViewDownloadListener(c.a.d0.l0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.mNadDownloadListener = aVar;
        }
    }

    public void setViewStatChangeListener(c.a.d0.l0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.mFeedListener = bVar;
        }
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, adBaseModel) == null) {
            setTag(adBaseModel);
            this.mBottomDialog = new DislikeBottomDialog(getContext(), adBaseModel);
            f(adBaseModel);
            if (getVisibility() != 0) {
                setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i2, s sVar) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), sVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f37573f = true;
        setOnClickListener(this);
        this.f37572e = new GestureDetector(getContext(), new f(this, null));
    }
}
