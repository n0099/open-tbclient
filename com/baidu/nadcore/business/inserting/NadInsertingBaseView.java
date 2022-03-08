package com.baidu.nadcore.business.inserting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.d.e.b;
import c.a.b0.h0.s;
import c.a.b0.q.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class NadInsertingBaseView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s mCountDownTimer;
    public e mLifecycleCallback;
    public c.a.b0.d.e.a mNadCallback;
    public long mStartShowTime;

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadInsertingBaseView a;

        public a(NadInsertingBaseView nadInsertingBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadInsertingBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadInsertingBaseView;
        }

        @Override // c.a.b0.q.e
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // c.a.b0.q.e
        public void onActivityDestroyed(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // c.a.b0.q.e
        public void onActivityPaused(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                this.a.mCountDownTimer.b();
            }
        }

        @Override // c.a.b0.q.e
        public void onActivityResumed(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                this.a.mCountDownTimer.c();
            }
        }

        @Override // c.a.b0.q.e
        public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // c.a.b0.q.e
        public void onActivityStarted(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            }
        }

        @Override // c.a.b0.q.e
        public void onActivityStopped(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            }
        }

        @Override // c.a.b0.q.e
        public void onBackgroundToForeground(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
                this.a.mCountDownTimer.c();
            }
        }

        @Override // c.a.b0.q.e
        public void onForegroundToBackground(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
                this.a.mCountDownTimer.b();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadInsertingBaseView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull c.a.b0.d.e.a aVar) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setContainer(viewGroup);
        this.mNadCallback = aVar;
    }

    public abstract void closeAd();

    @Nullable
    public String getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getTag() instanceof AdBaseModel) {
                return ((AdBaseModel) getTag()).f35661f.a.value;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public abstract View getRealView();

    public abstract void init(Context context);

    public void insertingCheckClog(@NonNull AdBaseModel adBaseModel, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, adBaseModel, str, str2) == null) || TextUtils.isEmpty(adBaseModel.f35661f.f1923d)) {
            return;
        }
        c.a.b0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CHECK).n(adBaseModel.f35661f.f1923d).i(str).j(str2));
    }

    public void insertingClickClog(@NonNull AdBaseModel adBaseModel, @NonNull ClogBuilder.Area area) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, adBaseModel, area) == null) {
            c.a.b0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLICK).n(adBaseModel.f35661f.f1923d).g(area));
            for (MonitorUrl monitorUrl : adBaseModel.f35660e) {
                if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.clickUrl)) {
                    c.a.b0.a0.b.a.b(monitorUrl.clickUrl);
                }
            }
        }
    }

    public void insertingCloseClog(@NonNull AdBaseModel adBaseModel, @NonNull ClogBuilder.Area area, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{adBaseModel, area, Long.valueOf(j2)}) == null) || TextUtils.isEmpty(adBaseModel.f35661f.f1923d)) {
            return;
        }
        c.a.b0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLOSE).n(adBaseModel.f35661f.f1923d).i(String.valueOf(j2)).g(area));
    }

    public void insertingShowClog(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) || adBaseModel.a) {
            return;
        }
        c.a.b0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.SHOW).n(adBaseModel.f35661f.f1923d));
        for (MonitorUrl monitorUrl : adBaseModel.f35660e) {
            if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.showUrl)) {
                c.a.b0.a0.b.a.b(monitorUrl.showUrl);
            }
        }
        adBaseModel.a = true;
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            View view = (View) getParent();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    public abstract void setData(@NonNull AdBaseModel adBaseModel, @NonNull b.c cVar);

    public abstract void showAd();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadInsertingBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLifecycleCallback = new a(this);
        init(context);
    }
}
