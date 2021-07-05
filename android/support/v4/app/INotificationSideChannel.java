package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements INotificationSideChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Default() {
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String str, int i2, String str2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String str, int i2, String str2, Notification notification) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, str, i2, str2, notification) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements INotificationSideChannel {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        public static final int TRANSACTION_cancel = 2;
        public static final int TRANSACTION_cancelAll = 3;
        public static final int TRANSACTION_notify = 1;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class Proxy implements INotificationSideChannel {
            public static /* synthetic */ Interceptable $ic;
            public static INotificationSideChannel sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRemote : (IBinder) invokeV.objValue;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancel(String str, int i2, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeInt(i2);
                        obtain.writeString(str2);
                        if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().cancel(str, i2, str2);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancelAll(String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().cancelAll(str);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void notify(String str, int i2, String str2, Notification notification) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(1048580, this, str, i2, str2, notification) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeInt(i2);
                        obtain.writeString(str2);
                        if (notification != null) {
                            obtain.writeInt(1);
                            notification.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().notify(str, i2, str2, notification);
                    } finally {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, DESCRIPTOR);
        }

        public static INotificationSideChannel asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof INotificationSideChannel)) {
                    return (INotificationSideChannel) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (INotificationSideChannel) invokeL.objValue;
        }

        public static INotificationSideChannel getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Proxy.sDefaultImpl : (INotificationSideChannel) invokeV.objValue;
        }

        public static boolean setDefaultImpl(INotificationSideChannel iNotificationSideChannel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iNotificationSideChannel)) == null) {
                if (Proxy.sDefaultImpl != null || iNotificationSideChannel == null) {
                    return false;
                }
                Proxy.sDefaultImpl = iNotificationSideChannel;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 1) {
                    parcel.enforceInterface(DESCRIPTOR);
                    notify(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface(DESCRIPTOR);
                    cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                    return true;
                } else if (i2 == 3) {
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelAll(parcel.readString());
                    return true;
                } else if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                } else {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void cancel(String str, int i2, String str2) throws RemoteException;

    void cancelAll(String str) throws RemoteException;

    void notify(String str, int i2, String str2, Notification notification) throws RemoteException;
}
