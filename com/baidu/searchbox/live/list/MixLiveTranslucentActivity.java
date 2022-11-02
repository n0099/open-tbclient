package com.baidu.searchbox.live.list;

import android.os.Bundle;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.searchbox.live.service.MixNotifyBackgroundService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/live/list/MixLiveTranslucentActivity;", "Lcom/baidu/searchbox/live/list/MixLiveActivity;", "", "finish", "()V", "finishByNotifyWithNoAnim", "", "getCaptureBgColor", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "overrideEnterAnim", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixLiveTranslucentActivity extends MixLiveActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap _$_findViewCache;

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this._$_findViewCache) == null) {
            return;
        }
        hashMap.clear();
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this._$_findViewCache == null) {
                this._$_findViewCache = new HashMap();
            }
            View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                this._$_findViewCache.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public MixLiveTranslucentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finish();
            ServiceLocator.Companion.unregisterGlobalService(MixNotifyBackgroundService.class);
        }
    }

    public final void finishByNotifyWithNoAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.finish();
            overridePendingTransition(0, 0);
            ServiceLocator.Companion.unregisterGlobalService(MixNotifyBackgroundService.class);
        }
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public int getCaptureBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!getIntent().getBooleanExtra("enterWithAnimation", false)) {
                return 0;
            }
            return -16777216;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public void overrideEnterAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (getIntent().getBooleanExtra("enterWithAnimation", false)) {
                super.overrideEnterAnim();
            } else {
                overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity, com.baidu.searchbox.live.shell.LiveBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            ServiceLocator.Companion.registerGlobalServices(MixNotifyBackgroundService.class, new MixNotifyBackgroundService(this) { // from class: com.baidu.searchbox.live.list.MixLiveTranslucentActivity$onCreate$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MixLiveTranslucentActivity this$0;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.live.service.MixNotifyBackgroundService
                public void hideActivityBackground() {
                    View rootView;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (rootView = this.this$0.getRootView()) != null) {
                        rootView.setBackgroundColor(0);
                    }
                }

                @Override // com.baidu.searchbox.live.service.MixNotifyBackgroundService
                public void notifyActivityFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.finishByNotifyWithNoAnim();
                    }
                }

                @Override // com.baidu.searchbox.live.service.MixNotifyBackgroundService
                public void showActivityBackground() {
                    View rootView;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (rootView = this.this$0.getRootView()) != null) {
                        rootView.setBackgroundColor(-16777216);
                    }
                }
            });
        }
    }
}
