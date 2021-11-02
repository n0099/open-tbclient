package b.a.r0.x1.p;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.live.interfaces.service.ILivePlayerService;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class i implements ILivePlayerService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final LivePlayer a(BuildParams buildParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, buildParams)) == null) ? new b.a.r0.x1.p.j.b(buildParams) : (LivePlayer) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public LivePlayer createBackPlayer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new e(str) : (LivePlayer) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public LivePlayer createPlayer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? new f(str) : (LivePlayer) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public void initPlayerEvn(CyberPlayerManager.InstallListener installListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, installListener, i2) == null) {
            BDPlayerConfig.setAppContext(TbadkCoreApplication.getInst());
            BDPlayerConfig.initEnv(false);
            g.e().h(installListener, i2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public LivePlayer createPlayer(BuildParams buildParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, buildParams)) == null) {
            int playerType = buildParams.getPlayerType();
            if (playerType != 1) {
                if (playerType != 2) {
                    return createPlayer(buildParams.getRoomId());
                }
                return a(buildParams);
            }
            return createBackPlayer(buildParams.getRoomId());
        }
        return (LivePlayer) invokeL.objValue;
    }
}
