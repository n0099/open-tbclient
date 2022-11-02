package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
/* loaded from: classes.dex */
public final class TrafficStatsCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TrafficStatsCompat() {
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

    @Deprecated
    public static void clearThreadStatsTag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            TrafficStats.clearThreadStatsTag();
        }
    }

    @Deprecated
    public static int getThreadStatsTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return TrafficStats.getThreadStatsTag();
        }
        return invokeV.intValue;
    }

    @Deprecated
    public static void incrementOperationCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            TrafficStats.incrementOperationCount(i);
        }
    }

    @Deprecated
    public static void setThreadStatsTag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            TrafficStats.setThreadStatsTag(i);
        }
    }

    public static void tagDatagramSocket(@NonNull DatagramSocket datagramSocket) throws SocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, datagramSocket) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                TrafficStats.tagDatagramSocket(datagramSocket);
                return;
            }
            ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
            TrafficStats.tagSocket(new DatagramSocketWrapper(datagramSocket, fromDatagramSocket.getFileDescriptor()));
            fromDatagramSocket.detachFd();
        }
    }

    @Deprecated
    public static void tagSocket(Socket socket) throws SocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, socket) == null) {
            TrafficStats.tagSocket(socket);
        }
    }

    public static void untagDatagramSocket(@NonNull DatagramSocket datagramSocket) throws SocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, datagramSocket) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                TrafficStats.untagDatagramSocket(datagramSocket);
                return;
            }
            ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
            TrafficStats.untagSocket(new DatagramSocketWrapper(datagramSocket, fromDatagramSocket.getFileDescriptor()));
            fromDatagramSocket.detachFd();
        }
    }

    @Deprecated
    public static void untagSocket(Socket socket) throws SocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, socket) == null) {
            TrafficStats.untagSocket(socket);
        }
    }

    @Deprecated
    public static void incrementOperationCount(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2) == null) {
            TrafficStats.incrementOperationCount(i, i2);
        }
    }
}
