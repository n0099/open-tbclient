package com.baidu.searchbox.afx.proxy;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes9.dex */
public abstract class PlayerProxy implements IPlayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnReportListener mOnReportListener;
    public OnVideoEndedListener mOnVideoEndedListener;
    public OnVideoErrorListener mOnVideoErrorListener;
    public OnVideoStartedListener mOnVideoStartedListener;
    public PlayerState mPlayerState;
    public String mSourcePath;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class PlayerState {
        public static final /* synthetic */ PlayerState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlayerState DESTROYED;
        public static final PlayerState NOT_PREPARED;
        public static final PlayerState PAUSED;
        public static final PlayerState PLAYING;
        public static final PlayerState PREPARED;
        public static final PlayerState PREPARING;
        public static final PlayerState STOPPED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(596162841, "Lcom/baidu/searchbox/afx/proxy/PlayerProxy$PlayerState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(596162841, "Lcom/baidu/searchbox/afx/proxy/PlayerProxy$PlayerState;");
                    return;
                }
            }
            NOT_PREPARED = new PlayerState("NOT_PREPARED", 0);
            PREPARING = new PlayerState("PREPARING", 1);
            PREPARED = new PlayerState("PREPARED", 2);
            PLAYING = new PlayerState("PLAYING", 3);
            PAUSED = new PlayerState("PAUSED", 4);
            STOPPED = new PlayerState("STOPPED", 5);
            PlayerState playerState = new PlayerState("DESTROYED", 6);
            DESTROYED = playerState;
            $VALUES = new PlayerState[]{NOT_PREPARED, PREPARING, PREPARED, PLAYING, PAUSED, STOPPED, playerState};
        }

        public PlayerState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PlayerState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlayerState) Enum.valueOf(PlayerState.class, str) : (PlayerState) invokeL.objValue;
        }

        public static PlayerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlayerState[]) $VALUES.clone() : (PlayerState[]) invokeV.objValue;
        }
    }

    public PlayerProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlayerState = PlayerState.NOT_PREPARED;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mPlayerState = PlayerState.DESTROYED;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public String getSourcePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSourcePath : (String) invokeV.objValue;
    }

    public PlayerState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPlayerState : (PlayerState) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPlayerState == PlayerState.DESTROYED : invokeV.booleanValue;
    }

    public final boolean isNotPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPlayerState == PlayerState.NOT_PREPARED : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPlayerState == PlayerState.PAUSED : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPlayerState == PlayerState.PLAYING : invokeV.booleanValue;
    }

    public final boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPlayerState == PlayerState.PREPARED : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final boolean isStopped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPlayerState == PlayerState.STOPPED : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mPlayerState = PlayerState.PAUSED;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mPlayerState = PlayerState.PLAYING;
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mPlayerState = PlayerState.NOT_PREPARED;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setLoopSection(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnReportListener(OnReportListener onReportListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onReportListener) == null) {
            this.mOnReportListener = onReportListener;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnVideoEndedListener(OnVideoEndedListener onVideoEndedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onVideoEndedListener) == null) {
            this.mOnVideoEndedListener = onVideoEndedListener;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onVideoErrorListener) == null) {
            this.mOnVideoErrorListener = onVideoErrorListener;
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public final void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onVideoStartedListener) == null) {
            this.mOnVideoStartedListener = onVideoStartedListener;
        }
    }

    public void setSourceAfd(AssetFileDescriptor assetFileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, assetFileDescriptor) == null) {
            if (assetFileDescriptor.getDeclaredLength() < 0) {
                setSourceFD(assetFileDescriptor.getFileDescriptor());
            } else {
                setSourceFD(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourceAssets(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, str) == null) {
            this.mSourcePath = str;
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                OnReportListener onReportListener = this.mOnReportListener;
                if (onReportListener != null) {
                    onReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf));
                }
                OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
                if (onVideoErrorListener != null) {
                    onVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf));
                    return;
                }
                return;
            }
            try {
                setSourceAfd(context.getAssets().openFd(str));
            } catch (IOException e2) {
                e2.printStackTrace();
                String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
                String str2 = ErrorInfo.PARAMETER_ERROR_ASSETS_ERRORMSG + str;
                OnReportListener onReportListener2 = this.mOnReportListener;
                if (onReportListener2 != null) {
                    onReportListener2.onError(new ErrorInfo(1, str2, e2, "-1", null, getSourcePath(), valueOf2));
                }
                OnVideoErrorListener onVideoErrorListener2 = this.mOnVideoErrorListener;
                if (onVideoErrorListener2 != null) {
                    onVideoErrorListener2.onError(new ErrorInfo(1, str2, e2, "-1", null, getSourcePath(), valueOf2));
                }
            }
        }
    }

    public void setSourceFD(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fileDescriptor) == null) {
        }
    }

    public void setSourceFD(FileDescriptor fileDescriptor, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{fileDescriptor, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSourceFile(File file) {
        FileInputStream fileInputStream;
        IOException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, file) == null) {
            if (file != null) {
                this.mSourcePath = file.getPath();
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            try {
                                setSourceFD(fileInputStream.getFD());
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e2 = e3;
                                e2.printStackTrace();
                                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                                String str = ErrorInfo.PARAMETER_ERROR_SRCFILE_ERRORMSG + file;
                                if (this.mOnReportListener != null) {
                                    this.mOnReportListener.onError(new ErrorInfo(1, str, e2, "-1", null, getSourcePath(), valueOf));
                                }
                                if (this.mOnVideoErrorListener != null) {
                                    this.mOnVideoErrorListener.onError(new ErrorInfo(1, str, e2, "-1", null, getSourcePath(), valueOf));
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return;
                    }
                } catch (IOException e6) {
                    fileInputStream = null;
                    e2 = e6;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream2 != null) {
                    }
                    throw th;
                }
                return;
            }
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            OnReportListener onReportListener = this.mOnReportListener;
            if (onReportListener != null) {
                onReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf2));
            }
            OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
            if (onVideoErrorListener != null) {
                onVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, getSourcePath(), valueOf2));
            }
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void setSourcePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.mSourcePath = str;
            if (TextUtils.isEmpty(str)) {
                String sourcePath = getSourcePath();
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                OnReportListener onReportListener = this.mOnReportListener;
                if (onReportListener != null) {
                    onReportListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, sourcePath, valueOf));
                }
                OnVideoErrorListener onVideoErrorListener = this.mOnVideoErrorListener;
                if (onVideoErrorListener != null) {
                    onVideoErrorListener.onError(new ErrorInfo(4, ErrorInfo.PARAMETER_ERROR_ERRORMSG, null, "-1", null, sourcePath, valueOf));
                    return;
                }
                return;
            }
            setSourceFile(new File(str));
        }
    }

    @Override // com.baidu.searchbox.afx.proxy.IPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mPlayerState = PlayerState.STOPPED;
            OnVideoEndedListener onVideoEndedListener = this.mOnVideoEndedListener;
            if (onVideoEndedListener != null) {
                onVideoEndedListener.onVideoEnded();
            }
        }
    }
}
