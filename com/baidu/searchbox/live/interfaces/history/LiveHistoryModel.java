package com.baidu.searchbox.live.interfaces.history;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000B\u0007¢\u0006\u0004\b+\u0010,R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u0007R$\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u0005\"\u0004\b\u001e\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u0005\"\u0004\b!\u0010\u0007R$\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010\u0007R$\u0010%\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\u0005\"\u0004\b'\u0010\u0007R$\u0010(\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\u0005\"\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryModel;", "", "cmd", "Ljava/lang/String;", "getCmd", "()Ljava/lang/String;", "setCmd", "(Ljava/lang/String;)V", "", "createTime", "J", "getCreateTime", "()J", "setCreateTime", "(J)V", "extra", "getExtra", "setExtra", "Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryFeature;", "feature", "Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryFeature;", "getFeature", "()Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryFeature;", "setFeature", "(Lcom/baidu/searchbox/live/interfaces/history/LiveHistoryFeature;)V", "img", "getImg", "setImg", "title", "getTitle", "setTitle", "tplId", "getTplId", "setTplId", "tts", "getTts", "setTts", "ukey", "getUkey", "setUkey", "url", "getUrl", "setUrl", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class LiveHistoryModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String cmd;
    public long createTime;
    public String extra;
    public LiveHistoryFeature feature;
    public String img;
    public String title;
    public String tplId;
    public String tts;
    public String ukey;
    public String url;

    public LiveHistoryModel() {
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

    public final String getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cmd : (String) invokeV.objValue;
    }

    public final long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.createTime : invokeV.longValue;
    }

    public final String getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.extra : (String) invokeV.objValue;
    }

    public final LiveHistoryFeature getFeature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.feature : (LiveHistoryFeature) invokeV.objValue;
    }

    public final String getImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.img : (String) invokeV.objValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public final String getTplId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.tplId : (String) invokeV.objValue;
    }

    public final String getTts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.tts : (String) invokeV.objValue;
    }

    public final String getUkey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.ukey : (String) invokeV.objValue;
    }

    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public final void setCmd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.cmd = str;
        }
    }

    public final void setCreateTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.createTime = j2;
        }
    }

    public final void setExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.extra = str;
        }
    }

    public final void setFeature(LiveHistoryFeature liveHistoryFeature) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, liveHistoryFeature) == null) {
            this.feature = liveHistoryFeature;
        }
    }

    public final void setImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.img = str;
        }
    }

    public final void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.title = str;
        }
    }

    public final void setTplId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.tplId = str;
        }
    }

    public final void setTts(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.tts = str;
        }
    }

    public final void setUkey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.ukey = str;
        }
    }

    public final void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.url = str;
        }
    }
}
