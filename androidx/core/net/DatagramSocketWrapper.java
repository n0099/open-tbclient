package androidx.core.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
/* loaded from: classes.dex */
public class DatagramSocketWrapper extends Socket {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class DatagramSocketImplWrapper extends SocketImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DatagramSocketImplWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {datagramSocket, fileDescriptor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ((SocketImpl) this).localport = datagramSocket.getLocalPort();
            ((SocketImpl) this).fd = fileDescriptor;
        }

        @Override // java.net.SocketImpl
        public void accept(SocketImpl socketImpl) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, socketImpl) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketImpl
        public void create(boolean z) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketOptions
        public Object getOption(int i) throws SocketException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeI.objValue;
        }

        @Override // java.net.SocketImpl
        public void listen(int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketImpl
        public void sendUrgentData(int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketImpl
        public int available() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeV.intValue;
        }

        @Override // java.net.SocketImpl
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketImpl
        public InputStream getInputStream() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (InputStream) invokeV.objValue;
        }

        @Override // java.net.SocketImpl
        public OutputStream getOutputStream() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (OutputStream) invokeV.objValue;
        }

        @Override // java.net.SocketImpl
        public void bind(InetAddress inetAddress, int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, inetAddress, i) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketImpl
        public void connect(String str, int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, str, i) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketOptions
        public void setOption(int i, Object obj) throws SocketException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048589, this, i, obj) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketImpl
        public void connect(InetAddress inetAddress, int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, inetAddress, i) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.net.SocketImpl
        public void connect(SocketAddress socketAddress, int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, socketAddress, i) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatagramSocketWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) throws SocketException {
        super(new DatagramSocketImplWrapper(datagramSocket, fileDescriptor));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {datagramSocket, fileDescriptor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((SocketImpl) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
