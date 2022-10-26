package com.baidu.swan.ubc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface IRemoteUBCService extends IInterface {
    void flowAddEvent(Flow flow, String str, String str2) throws RemoteException;

    void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException;

    void flowCancel(Flow flow) throws RemoteException;

    void flowEnd(Flow flow) throws RemoteException;

    void flowEndSlot(Flow flow, String str) throws RemoteException;

    void flowSetValue(Flow flow, String str) throws RemoteException;

    void flowSetValueWithDuration(Flow flow, String str) throws RemoteException;

    void flowStartSlot(Flow flow, String str, String str2) throws RemoteException;

    Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException;

    void ubcOnEvent(String str, String str2, int i) throws RemoteException;

    /* loaded from: classes3.dex */
    public abstract class Stub extends Binder implements IRemoteUBCService {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.baidu.swan.ubc.IRemoteUBCService";
        public static final int TRANSACTION_flowAddEvent = 3;
        public static final int TRANSACTION_flowAddEventWithTime = 4;
        public static final int TRANSACTION_flowCancel = 9;
        public static final int TRANSACTION_flowEnd = 10;
        public static final int TRANSACTION_flowEndSlot = 8;
        public static final int TRANSACTION_flowSetValue = 5;
        public static final int TRANSACTION_flowSetValueWithDuration = 6;
        public static final int TRANSACTION_flowStartSlot = 7;
        public static final int TRANSACTION_ubcBeginFlow = 2;
        public static final int TRANSACTION_ubcOnEvent = 1;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class Proxy implements IRemoteUBCService {
            public static /* synthetic */ Interceptable $ic;
            public static IRemoteUBCService sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            public Proxy(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.mRemote;
                }
                return (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flow, str, str2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (flow != null) {
                            obtain.writeInt(1);
                            flow.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().flowAddEvent(flow, str, str2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, flow, str, str2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (flow != null) {
                            obtain.writeInt(1);
                            flow.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().flowStartSlot(flow, str, str2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void ubcOnEvent(String str, String str2, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048587, this, str, str2, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeInt(i);
                        if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().ubcOnEvent(str, str2, i);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{flow, str, str2, Long.valueOf(j)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (flow != null) {
                            obtain.writeInt(1);
                            flow.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeLong(j);
                        if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().flowAddEventWithTime(flow, str, str2, j);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowCancel(Flow flow) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, flow) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (flow != null) {
                            obtain.writeInt(1);
                            flow.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().flowCancel(flow);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowEnd(Flow flow) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, flow) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (flow != null) {
                            obtain.writeInt(1);
                            flow.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().flowEnd(flow);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowEndSlot(Flow flow, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048581, this, flow, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (flow != null) {
                            obtain.writeInt(1);
                            flow.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeString(str);
                        if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().flowEndSlot(flow, str);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowSetValue(Flow flow, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048582, this, flow, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (flow != null) {
                            obtain.writeInt(1);
                            flow.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeString(str);
                        if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().flowSetValue(flow, str);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048583, this, flow, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (flow != null) {
                            obtain.writeInt(1);
                            flow.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeString(str);
                        if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().flowSetValueWithDuration(flow, str);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.swan.ubc.IRemoteUBCService
            public Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException {
                InterceptResult invokeLLI;
                Flow flow;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, str, str2, i)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeInt(i);
                        if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().ubcBeginFlow(str, str2, i);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            flow = (Flow) Flow.CREATOR.createFromParcel(obtain2);
                        } else {
                            flow = null;
                        }
                        return flow;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (Flow) invokeLLI.objValue;
            }
        }

        public Stub() {
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteUBCService getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return Proxy.sDefaultImpl;
            }
            return (IRemoteUBCService) invokeV.objValue;
        }

        public static IRemoteUBCService asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteUBCService)) {
                    return (IRemoteUBCService) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IRemoteUBCService) invokeL.objValue;
        }

        public static boolean setDefaultImpl(IRemoteUBCService iRemoteUBCService) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iRemoteUBCService)) == null) {
                if (Proxy.sDefaultImpl == null && iRemoteUBCService != null) {
                    Proxy.sDefaultImpl = iRemoteUBCService;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i != 1598968902) {
                    Flow flow = null;
                    switch (i) {
                        case 1:
                            parcel.enforceInterface(DESCRIPTOR);
                            ubcOnEvent(parcel.readString(), parcel.readString(), parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 2:
                            parcel.enforceInterface(DESCRIPTOR);
                            Flow ubcBeginFlow = ubcBeginFlow(parcel.readString(), parcel.readString(), parcel.readInt());
                            parcel2.writeNoException();
                            if (ubcBeginFlow != null) {
                                parcel2.writeInt(1);
                                ubcBeginFlow.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 3:
                            parcel.enforceInterface(DESCRIPTOR);
                            if (parcel.readInt() != 0) {
                                flow = (Flow) Flow.CREATOR.createFromParcel(parcel);
                            }
                            flowAddEvent(flow, parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface(DESCRIPTOR);
                            if (parcel.readInt() != 0) {
                                flow = (Flow) Flow.CREATOR.createFromParcel(parcel);
                            }
                            flowAddEventWithTime(flow, parcel.readString(), parcel.readString(), parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 5:
                            parcel.enforceInterface(DESCRIPTOR);
                            if (parcel.readInt() != 0) {
                                flow = (Flow) Flow.CREATOR.createFromParcel(parcel);
                            }
                            flowSetValue(flow, parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 6:
                            parcel.enforceInterface(DESCRIPTOR);
                            if (parcel.readInt() != 0) {
                                flow = (Flow) Flow.CREATOR.createFromParcel(parcel);
                            }
                            flowSetValueWithDuration(flow, parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            parcel.enforceInterface(DESCRIPTOR);
                            if (parcel.readInt() != 0) {
                                flow = (Flow) Flow.CREATOR.createFromParcel(parcel);
                            }
                            flowStartSlot(flow, parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            parcel.enforceInterface(DESCRIPTOR);
                            if (parcel.readInt() != 0) {
                                flow = (Flow) Flow.CREATOR.createFromParcel(parcel);
                            }
                            flowEndSlot(flow, parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 9:
                            parcel.enforceInterface(DESCRIPTOR);
                            if (parcel.readInt() != 0) {
                                flow = (Flow) Flow.CREATOR.createFromParcel(parcel);
                            }
                            flowCancel(flow);
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            parcel.enforceInterface(DESCRIPTOR);
                            if (parcel.readInt() != 0) {
                                flow = (Flow) Flow.CREATOR.createFromParcel(parcel);
                            }
                            flowEnd(flow);
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class Default implements IRemoteUBCService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flow, str, str2) == null) {
            }
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void flowAddEventWithTime(Flow flow, String str, String str2, long j) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{flow, str, str2, Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void flowCancel(Flow flow) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, flow) == null) {
            }
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void flowEnd(Flow flow) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, flow) == null) {
            }
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void flowEndSlot(Flow flow, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, flow, str) == null) {
            }
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void flowSetValue(Flow flow, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, flow, str) == null) {
            }
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, flow, str) == null) {
            }
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, flow, str, str2) == null) {
            }
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, str, str2, i)) == null) {
                return null;
            }
            return (Flow) invokeLLI.objValue;
        }

        @Override // com.baidu.swan.ubc.IRemoteUBCService
        public void ubcOnEvent(String str, String str2, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048586, this, str, str2, i) == null) {
            }
        }

        public Default() {
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
    }
}
