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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cl0;
import com.repackage.jf0;
import com.repackage.kf0;
import com.repackage.r01;
import com.repackage.vx0;
import com.repackage.wx0;
/* loaded from: classes2.dex */
public abstract class NadInsertingBaseView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jf0 a;
    public long b;
    public r01 c;
    public cl0 d;

    /* loaded from: classes2.dex */
    public class a implements cl0 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadInsertingBaseView;
        }

        @Override // com.repackage.cl0
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // com.repackage.cl0
        public void onActivityDestroyed(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // com.repackage.cl0
        public void onActivityPaused(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                this.a.c.b();
            }
        }

        @Override // com.repackage.cl0
        public void onActivityResumed(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                this.a.c.c();
            }
        }

        @Override // com.repackage.cl0
        public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // com.repackage.cl0
        public void onActivityStarted(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            }
        }

        @Override // com.repackage.cl0
        public void onActivityStopped(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            }
        }

        @Override // com.repackage.cl0
        public void onBackgroundToForeground(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
                this.a.c.c();
            }
        }

        @Override // com.repackage.cl0
        public void onForegroundToBackground(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
                this.a.c.b();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadInsertingBaseView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull jf0 jf0Var) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, jf0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setContainer(viewGroup);
        this.a = jf0Var;
    }

    public abstract void a();

    public abstract void b(Context context);

    public void c(@NonNull AdBaseModel adBaseModel, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel, str, str2) == null) || TextUtils.isEmpty(adBaseModel.f.d)) {
            return;
        }
        vx0.c(new ClogBuilder().w(ClogBuilder.LogType.CHECK).n(adBaseModel.f.d).i(str).j(str2));
    }

    public void d(@NonNull AdBaseModel adBaseModel, @NonNull ClogBuilder.Area area) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adBaseModel, area) == null) {
            vx0.c(new ClogBuilder().w(ClogBuilder.LogType.CLICK).n(adBaseModel.f.d).g(area));
            for (MonitorUrl monitorUrl : adBaseModel.e) {
                if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.clickUrl)) {
                    wx0.b(monitorUrl.clickUrl);
                }
            }
        }
    }

    public void e(@NonNull AdBaseModel adBaseModel, @NonNull ClogBuilder.Area area, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adBaseModel, area, Long.valueOf(j)}) == null) || TextUtils.isEmpty(adBaseModel.f.d)) {
            return;
        }
        vx0.c(new ClogBuilder().w(ClogBuilder.LogType.CLOSE).n(adBaseModel.f.d).i(String.valueOf(j)).g(area));
    }

    public void f(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) || adBaseModel.a) {
            return;
        }
        vx0.c(new ClogBuilder().w(ClogBuilder.LogType.SHOW).n(adBaseModel.f.d));
        for (MonitorUrl monitorUrl : adBaseModel.e) {
            if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.showUrl)) {
                wx0.b(monitorUrl.showUrl);
            }
        }
        adBaseModel.a = true;
    }

    public abstract void g();

    @Nullable
    public String getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (getTag() instanceof AdBaseModel) {
                return ((AdBaseModel) getTag()).f.a.value;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public abstract View getRealView();

    public void setContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewGroup) == null) {
            View view2 = (View) getParent();
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).removeView(this);
            }
            viewGroup.addView(this);
        }
    }

    public abstract void setData(@NonNull AdBaseModel adBaseModel, @NonNull kf0.c cVar);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadInsertingBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        b(context);
    }
}
