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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/list/MixLiveTranslucentActivity;", "Lcom/baidu/searchbox/live/list/MixLiveActivity;", "", "finish", "()V", "", "getCaptureBgColor", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "overrideEnterAnim", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixLiveTranslucentActivity extends MixLiveActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap _$_findViewCache;

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

    @Override // com.baidu.searchbox.live.list.MixLiveActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finish();
            ServiceLocator.Companion.unregisterGlobalService(MixNotifyBackgroundService.class);
        }
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public int getCaptureBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity, com.baidu.searchbox.live.shell.LiveBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rootView = this.this$0.getRootView()) == null) {
                        return;
                    }
                    rootView.setBackgroundColor(this.this$0.getCaptureBgColor());
                }

                @Override // com.baidu.searchbox.live.service.MixNotifyBackgroundService
                public void showActivityBackground() {
                    View rootView;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (rootView = this.this$0.getRootView()) == null) {
                        return;
                    }
                    rootView.setBackgroundColor(-16777216);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.live.list.MixLiveActivity
    public void overrideEnterAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            overridePendingTransition(0, 0);
        }
    }
}
