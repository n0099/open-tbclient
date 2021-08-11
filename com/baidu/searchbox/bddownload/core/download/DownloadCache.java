package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.exception.FileBusyAfterRunException;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.exception.PreAllocateException;
import com.baidu.searchbox.bddownload.core.exception.ResumeFailedException;
import com.baidu.searchbox.bddownload.core.exception.ServerCanceledException;
import com.baidu.searchbox.bddownload.core.file.MultiPointOutputStream;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.SocketException;
/* loaded from: classes5.dex */
public class DownloadCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean fileBusyAfterRun;
    public final MultiPointOutputStream outputStream;
    public volatile boolean preAllocateFailed;
    public volatile boolean preconditionFailed;
    public volatile IOException realCause;
    public String redirectLocation;
    public volatile boolean serverCanceled;
    public volatile boolean unknownError;
    public volatile boolean userCanceled;

    /* loaded from: classes5.dex */
    public static class PreError extends DownloadCache {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreError(IOException iOException) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iOException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((MultiPointOutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setUnknownError(iOException);
        }
    }

    public DownloadCache(@NonNull MultiPointOutputStream multiPointOutputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {multiPointOutputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.outputStream = multiPointOutputStream;
    }

    public void catchException(IOException iOException) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iOException) == null) || isUserCanceled()) {
            return;
        }
        if (iOException instanceof ResumeFailedException) {
            setPreconditionFailed(iOException);
        } else if (iOException instanceof ServerCanceledException) {
            setServerCanceled(iOException);
        } else if (iOException == FileBusyAfterRunException.SIGNAL) {
            setFileBusyAfterRun();
        } else if (iOException instanceof PreAllocateException) {
            setPreAllocateFailed(iOException);
        } else if (iOException != InterruptException.SIGNAL) {
            setUnknownError(iOException);
            if (iOException instanceof SocketException) {
                return;
            }
            Util.d("DownloadCache", "catch unknown error " + iOException);
        }
    }

    @NonNull
    public MultiPointOutputStream getOutputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MultiPointOutputStream multiPointOutputStream = this.outputStream;
            if (multiPointOutputStream != null) {
                return multiPointOutputStream;
            }
            throw new IllegalArgumentException();
        }
        return (MultiPointOutputStream) invokeV.objValue;
    }

    public IOException getRealCause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.realCause : (IOException) invokeV.objValue;
    }

    public String getRedirectLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.redirectLocation : (String) invokeV.objValue;
    }

    public ResumeFailedCause getResumeFailedCause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ((ResumeFailedException) this.realCause).getResumeFailedCause() : (ResumeFailedCause) invokeV.objValue;
    }

    public boolean isFileBusyAfterRun() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.fileBusyAfterRun : invokeV.booleanValue;
    }

    public boolean isInterrupt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.preconditionFailed || this.userCanceled || this.serverCanceled || this.unknownError || this.fileBusyAfterRun || this.preAllocateFailed : invokeV.booleanValue;
    }

    public boolean isPreAllocateFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.preAllocateFailed : invokeV.booleanValue;
    }

    public boolean isPreconditionFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.preconditionFailed : invokeV.booleanValue;
    }

    public boolean isServerCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.serverCanceled : invokeV.booleanValue;
    }

    public boolean isUnknownError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.unknownError : invokeV.booleanValue;
    }

    public boolean isUserCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.userCanceled : invokeV.booleanValue;
    }

    public void setFileBusyAfterRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.fileBusyAfterRun = true;
        }
    }

    public void setPreAllocateFailed(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iOException) == null) {
            this.preAllocateFailed = true;
            this.realCause = iOException;
        }
    }

    public void setPreconditionFailed(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iOException) == null) {
            this.preconditionFailed = true;
            this.realCause = iOException;
        }
    }

    public void setRedirectLocation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.redirectLocation = str;
        }
    }

    public void setServerCanceled(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iOException) == null) {
            this.serverCanceled = true;
            this.realCause = iOException;
        }
    }

    public void setUnknownError(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iOException) == null) {
            this.unknownError = true;
            this.realCause = iOException;
        }
    }

    public void setUserCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.userCanceled = true;
        }
    }

    public DownloadCache() {
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
        this.outputStream = null;
    }
}
