package com.baidu.searchbox.player.plugin;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class PluginManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BDVideoPlayer mPlayer;
    public ArrayList<AbsPlugin> mPlugins;

    public PluginManager(@NonNull BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDVideoPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlugins = new ArrayList<>();
        this.mPlayer = bDVideoPlayer;
    }

    @PublicMethod
    public void addPlugin(AbsPlugin absPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, absPlugin) == null) {
            absPlugin.attachManager(this);
            this.mPlugins.add(absPlugin);
        }
    }

    @NonNull
    @PublicMethod
    public BDVideoPlayer getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPlayer : (BDVideoPlayer) invokeV.objValue;
    }

    @PublicMethod
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<AbsPlugin> it = this.mPlugins.iterator();
            while (it.hasNext()) {
                AbsPlugin next = it.next();
                next.detachManager();
                next.detachMessenger();
                next.onPluginRelease();
            }
            this.mPlugins.clear();
        }
    }

    @PublicMethod
    public void removePlugin(AbsPlugin absPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, absPlugin) == null) {
            absPlugin.detachManager();
            this.mPlugins.remove(absPlugin);
        }
    }
}
