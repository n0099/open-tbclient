package com.baidu.searchbox.player.kernel;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.interfaces.IDnsProcessListener;
import com.baidu.searchbox.player.model.MPDUrlModel;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseDumediaVideoKernel extends AbsVideoKernel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DumediaInfoConverter mConverter;

    /* loaded from: classes2.dex */
    public static final class CyberPlayerHttpDNS implements CyberPlayerManager.HttpDNS {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final IDnsProcessListener dns;

        public CyberPlayerHttpDNS(@NonNull IDnsProcessListener iDnsProcessListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iDnsProcessListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dns = iDnsProcessListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.HttpDNS
        public List<String> getIpList(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.dns.getIpList(str, false) : (List) invokeL.objValue;
        }
    }

    public BaseDumediaVideoKernel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConverter = new DumediaInfoConverter(this);
    }

    @Nullable
    public Uri getVideoUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoUrlModel videoUrlModel = this.mUrlModel;
            if (videoUrlModel instanceof MPDUrlModel) {
                String str = ((MPDUrlModel) videoUrlModel).mpdUrl;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return Uri.parse(str);
            } else if (videoUrlModel == null || TextUtils.isEmpty(videoUrlModel.videoUrl)) {
                return null;
            } else {
                return Uri.parse(this.mUrlModel.videoUrl);
            }
        }
        return (Uri) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iKernelPlayer) == null) {
            this.mConverter.setPlayerCallback(iKernelPlayer);
            setVideoViewCallBack(this.mConverter);
        }
    }

    public abstract void setVideoViewCallBack(DumediaInfoConverter dumediaInfoConverter);
}
