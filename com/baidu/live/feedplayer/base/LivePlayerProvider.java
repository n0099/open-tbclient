package com.baidu.live.feedplayer.base;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.live.interfaces.service.ILivePlayerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\rR%\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/live/feedplayer/base/LivePlayerProvider;", "", ILiveNPSPlugin.PARAMS_ROOM_ID, "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "createPlayer", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "", "initPlayerEvn", "()V", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$InstallListener;", "listener", "", "installType", "(Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$InstallListener;I)V", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "kotlin.jvm.PlatformType", "playerService$delegate", "Lkotlin/Lazy;", "getPlayerService", "()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "playerService", "<init>", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class LivePlayerProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final Lazy a;

    /* renamed from: b  reason: collision with root package name */
    public static final LivePlayerProvider f33480b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(378811162, "Lcom/baidu/live/feedplayer/base/LivePlayerProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(378811162, "Lcom/baidu/live/feedplayer/base/LivePlayerProvider;");
                return;
            }
        }
        f33480b = new LivePlayerProvider();
        a = LazyKt__LazyJVMKt.lazy(LivePlayerProvider$playerService$2.INSTANCE);
    }

    public LivePlayerProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final LivePlayer a(String roomId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, roomId)) == null) {
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            return b().createPlayer(new BuildParams(roomId));
        }
        return (LivePlayer) invokeL.objValue;
    }

    public final ILivePlayerService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (ILivePlayerService) a.getValue() : (ILivePlayerService) invokeV.objValue;
    }
}
