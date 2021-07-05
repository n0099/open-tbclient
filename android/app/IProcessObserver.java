package android.app;

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
public interface IProcessObserver extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IProcessObserver {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "android.app.IProcessObserver";
        public static final int TRANSACTION_onForegroundActivitiesChanged = 1;
        public static final int TRANSACTION_onImportanceChanged = 2;
        public static final int TRANSACTION_onProcessDied = 3;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class Proxy implements IProcessObserver {
            public static /* synthetic */ Interceptable $ic;
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

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // android.app.IProcessObserver
            public void onForegroundActivitiesChanged(int i2, int i3, boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(z ? 1 : 0);
                        this.mRemote.transact(1, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.app.IProcessObserver
            public void onImportanceChanged(int i2, int i3, int i4) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        this.mRemote.transact(2, obtain, null, 1);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.app.IProcessObserver
            public void onProcessDied(int i2, int i3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        this.mRemote.transact(3, obtain, null, 1);
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

        public static IProcessObserver asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IProcessObserver)) {
                    return (IProcessObserver) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IProcessObserver) invokeL.objValue;
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
                    onForegroundActivitiesChanged(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface(DESCRIPTOR);
                    onImportanceChanged(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                } else if (i2 == 3) {
                    parcel.enforceInterface(DESCRIPTOR);
                    onProcessDied(parcel.readInt(), parcel.readInt());
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

    void onForegroundActivitiesChanged(int i2, int i3, boolean z) throws RemoteException;

    void onImportanceChanged(int i2, int i3, int i4) throws RemoteException;

    void onProcessDied(int i2, int i3) throws RemoteException;
}
