package com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.alipay.android.app.IRemoteServiceCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public interface IAlixPay extends IInterface {
    String Pay(String str) throws RemoteException;

    void deployFastConnect() throws RemoteException;

    int getVersion() throws RemoteException;

    boolean manager(String str) throws RemoteException;

    String pay02(String str, Map map) throws RemoteException;

    String prePay(String str) throws RemoteException;

    void r03(String str, String str2, Map map) throws RemoteException;

    void registerCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException;

    void registerCallback03(IRemoteServiceCallback iRemoteServiceCallback, String str, Map map) throws RemoteException;

    String test() throws RemoteException;

    void unregisterCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IAlixPay {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
        public static final int TRANSACTION_Pay = 1;
        public static final int TRANSACTION_deployFastConnect = 6;
        public static final int TRANSACTION_getVersion = 8;
        public static final int TRANSACTION_manager = 7;
        public static final int TRANSACTION_pay02 = 9;
        public static final int TRANSACTION_prePay = 5;
        public static final int TRANSACTION_r03 = 10;
        public static final int TRANSACTION_registerCallback = 3;
        public static final int TRANSACTION_registerCallback03 = 11;
        public static final int TRANSACTION_test = 2;
        public static final int TRANSACTION_unregisterCallback = 4;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        /* loaded from: classes.dex */
        public static class a implements IAlixPay {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder a;

            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            public a(IBinder iBinder) {
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
                this.a = iBinder;
            }

            @Override // com.alipay.android.app.IAlixPay
            public String Pay(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        this.a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.alipay.android.app.IAlixPay
            public boolean manager(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        boolean z = false;
                        this.a.transact(7, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        return z;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeL.booleanValue;
            }

            @Override // com.alipay.android.app.IAlixPay
            public String prePay(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        this.a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void registerCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
                IBinder iBinder;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048585, this, iRemoteServiceCallback) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (iRemoteServiceCallback != null) {
                            iBinder = iRemoteServiceCallback.asBinder();
                        } else {
                            iBinder = null;
                        }
                        obtain.writeStrongBinder(iBinder);
                        this.a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public void unregisterCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
                IBinder iBinder;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048588, this, iRemoteServiceCallback) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (iRemoteServiceCallback != null) {
                            iBinder = iRemoteServiceCallback.asBinder();
                        } else {
                            iBinder = null;
                        }
                        obtain.writeStrongBinder(iBinder);
                        this.a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.a;
                }
                return (IBinder) invokeV.objValue;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void deployFastConnect() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.a.transact(6, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public int getVersion() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.a.transact(8, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // com.alipay.android.app.IAlixPay
            public String test() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.alipay.android.app.IAlixPay
            public String pay02(String str, Map map) throws RemoteException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, map)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeMap(map);
                        this.a.transact(9, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeLL.objValue;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void r03(String str, String str2, Map map) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, map) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeMap(map);
                        this.a.transact(10, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public void registerCallback03(IRemoteServiceCallback iRemoteServiceCallback, String str, Map map) throws RemoteException {
                IBinder iBinder;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048586, this, iRemoteServiceCallback, str, map) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (iRemoteServiceCallback != null) {
                            iBinder = iRemoteServiceCallback.asBinder();
                        } else {
                            iBinder = null;
                        }
                        obtain.writeStrongBinder(iBinder);
                        obtain.writeString(str);
                        obtain.writeMap(map);
                        this.a.transact(11, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
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

        public static IAlixPay asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IAlixPay)) {
                    return (IAlixPay) queryLocalInterface;
                }
                return new a(iBinder);
            }
            return (IAlixPay) invokeL.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i != 1598968902) {
                    switch (i) {
                        case 1:
                            parcel.enforceInterface(DESCRIPTOR);
                            String Pay = Pay(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeString(Pay);
                            return true;
                        case 2:
                            parcel.enforceInterface(DESCRIPTOR);
                            String test = test();
                            parcel2.writeNoException();
                            parcel2.writeString(test);
                            return true;
                        case 3:
                            parcel.enforceInterface(DESCRIPTOR);
                            registerCallback(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface(DESCRIPTOR);
                            unregisterCallback(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 5:
                            parcel.enforceInterface(DESCRIPTOR);
                            String prePay = prePay(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeString(prePay);
                            return true;
                        case 6:
                            parcel.enforceInterface(DESCRIPTOR);
                            deployFastConnect();
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            parcel.enforceInterface(DESCRIPTOR);
                            boolean manager = manager(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeInt(manager ? 1 : 0);
                            return true;
                        case 8:
                            parcel.enforceInterface(DESCRIPTOR);
                            int version = getVersion();
                            parcel2.writeNoException();
                            parcel2.writeInt(version);
                            return true;
                        case 9:
                            parcel.enforceInterface(DESCRIPTOR);
                            String pay02 = pay02(parcel.readString(), parcel.readHashMap(Stub.class.getClassLoader()));
                            parcel2.writeNoException();
                            parcel2.writeString(pay02);
                            return true;
                        case 10:
                            parcel.enforceInterface(DESCRIPTOR);
                            r03(parcel.readString(), parcel.readString(), parcel.readHashMap(Stub.class.getClassLoader()));
                            return true;
                        case 11:
                            parcel.enforceInterface(DESCRIPTOR);
                            registerCallback03(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readHashMap(Stub.class.getClassLoader()));
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
}
