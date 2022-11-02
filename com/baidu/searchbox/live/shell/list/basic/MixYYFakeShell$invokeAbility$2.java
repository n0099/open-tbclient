package com.baidu.searchbox.live.shell.list.basic;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.live.mix.interfaces.InvokeAbility;
import com.baidu.live.mix.interfaces.MixPagerInfoService;
import com.baidu.live.mix.interfaces.MixShellServiceCenter;
import com.baidu.searchbox.live.service.MixListOperatorInterface;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$invokeAbility$2$1", "invoke", "()Lcom/baidu/searchbox/live/shell/list/basic/MixYYFakeShell$invokeAbility$2$1;"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixYYFakeShell$invokeAbility$2 extends Lambda implements Function0<AnonymousClass1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ MixYYFakeShell this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MixYYFakeShell$invokeAbility$2(MixYYFakeShell mixYYFakeShell) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mixYYFakeShell};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = mixYYFakeShell;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$invokeAbility$2$1] */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new InvokeAbility(this) { // from class: com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell$invokeAbility$2.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MixYYFakeShell$invokeAbility$2 this$0;

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public MixShellServiceCenter getMixShellServiceCenter() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return null;
                    }
                    return (MixShellServiceCenter) invokeV2.objValue;
                }

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public MixPagerInfoService getPagerInfoService() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return null;
                    }
                    return (MixPagerInfoService) invokeV2.objValue;
                }

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

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public void eventDispatcher(String str, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, str, jSONObject) == null) && Intrinsics.areEqual("resume_live_background", str)) {
                        this.this$0.this$0.showActivityBackground();
                    }
                }

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public void insertRoom(int i, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, jSONObject) == null) {
                        MixYYFakeShell mixYYFakeShell = this.this$0.this$0;
                        mixYYFakeShell.log("MixLiveShell invokeAbility insertRoom " + i + " " + jSONObject);
                    }
                }

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public void loadFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048580, this) != null) {
                        return;
                    }
                    this.this$0.this$0.log("MixLiveShell invokeAbility loadFinish ");
                }

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public void scrollToNextLiveRoom() {
                    MixListOperatorInterface mixListOperatorInterface;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048582, this) == null) && (mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class)) != null) {
                        mixListOperatorInterface.scrollToNextLiveRoom();
                    }
                }

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public void scrollToPreLiveRoom() {
                    MixListOperatorInterface mixListOperatorInterface;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048583, this) == null) && (mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class)) != null) {
                        mixListOperatorInterface.scrollToPreLiveRoom();
                    }
                }

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public void removeRoom(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, jSONObject) == null) {
                        MixYYFakeShell mixYYFakeShell = this.this$0.this$0;
                        mixYYFakeShell.log("MixLiveShell invokeAbility removeRoom ：" + jSONObject);
                        MixListOperatorInterface mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class);
                        if (mixListOperatorInterface != null) {
                            mixListOperatorInterface.removeRoom(jSONObject);
                        }
                    }
                }

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public void switchLiveListScrollable(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                        MixYYFakeShell mixYYFakeShell = this.this$0.this$0;
                        mixYYFakeShell.log("MixLiveShell invokeAbility switchLiveListScrollable switch：" + z);
                        MixListOperatorInterface mixListOperatorInterface = (MixListOperatorInterface) ServiceLocator.Companion.getGlobalService(MixListOperatorInterface.class);
                        if (mixListOperatorInterface != null) {
                            mixListOperatorInterface.switchLiveListScrollable(z, false);
                        }
                    }
                }

                @Override // com.baidu.live.mix.interfaces.InvokeAbility
                public void switchScreenAutoRotate(boolean z) {
                    MixYYFakeShell.OrientationChangeCallBack orientationChangeCallBack;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048585, this, z) == null) {
                        MixYYFakeShell mixYYFakeShell = this.this$0.this$0;
                        mixYYFakeShell.log("MixLiveShell invokeAbility switchScreenAutoRotate switch：" + z);
                        orientationChangeCallBack = this.this$0.this$0.getOrientationChangeCallBack();
                        orientationChangeCallBack.setCanChangeOrientation(z);
                    }
                }
            };
        }
        return (AnonymousClass1) invokeV.objValue;
    }
}
