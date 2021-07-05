package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.Bundle;
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
/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.cyberplayer.sdk.remote.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0091a extends Binder implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.cyberplayer.sdk.remote.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0092a implements a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f4966a;

            public C0092a(IBinder iBinder) {
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
                this.f4966a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public Bundle a() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                        this.f4966a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (Bundle) invokeV.objValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(int i2, String str, long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                        obtain.writeInt(i2);
                        obtain.writeString(str);
                        obtain.writeLong(j);
                        this.f4966a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(e eVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                        if (eVar != null) {
                            obtain.writeInt(1);
                            eVar.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.f4966a.transact(1, obtain, obtain2, 0);
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f4966a : (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void b() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                        this.f4966a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }
        }

        public AbstractBinderC0091a() {
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
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
        }

        public static a a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0092a(iBinder) : (a) queryLocalInterface;
            }
            return (a) invokeL.objValue;
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
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    a(parcel.readInt() != 0 ? e.CREATOR.createFromParcel(parcel) : null);
                } else if (i2 == 2) {
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    a(parcel.readInt(), parcel.readString(), parcel.readLong());
                } else if (i2 == 3) {
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    Bundle a2 = a();
                    parcel2.writeNoException();
                    if (a2 != null) {
                        parcel2.writeInt(1);
                        a2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                } else if (i2 != 4) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    return true;
                } else {
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    b();
                }
                parcel2.writeNoException();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    Bundle a() throws RemoteException;

    void a(int i2, String str, long j) throws RemoteException;

    void a(e eVar) throws RemoteException;

    void b() throws RemoteException;
}
