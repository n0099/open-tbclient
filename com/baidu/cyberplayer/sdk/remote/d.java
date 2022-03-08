package com.baidu.cyberplayer.sdk.remote;

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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public interface d extends IInterface {

    /* loaded from: classes4.dex */
    public static abstract class a extends Binder implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.cyberplayer.sdk.remote.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1792a implements d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder a;

            public C1792a(IBinder iBinder) {
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
                this.a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        this.a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        obtain.writeInt(i2);
                        this.a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(int i2, int i3, int i4, int i5) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        obtain.writeInt(i5);
                        this.a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(String str, List<String> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        obtain.writeString(str);
                        obtain.writeStringList(list);
                        this.a.transact(8, obtain, obtain2, 0);
                        obtain2.readException();
                        obtain2.readStringList(list);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public boolean a(int i2, int i3, String str) throws RemoteException {
                InterceptResult invokeIIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i2, i3, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeString(str);
                        this.a.transact(6, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeIIL.booleanValue;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void b() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        this.a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public boolean b(int i2, int i3, String str) throws RemoteException {
                InterceptResult invokeIIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048583, this, i2, i3, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeString(str);
                        this.a.transact(7, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void c() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        this.a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public boolean c(int i2, int i3, String str) throws RemoteException {
                InterceptResult invokeIIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeString(str);
                        this.a.transact(9, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeIIL.booleanValue;
            }
        }

        public a() {
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
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
        }

        public static d a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C1792a(iBinder) : (d) queryLocalInterface;
            }
            return (d) invokeL.objValue;
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
                if (i2 == 1598968902) {
                    parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    return true;
                }
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        boolean a = a(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(a ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        boolean b2 = b(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(b2 ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        String readString = parcel.readString();
                        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                        a(readString, createStringArrayList);
                        parcel2.writeNoException();
                        parcel2.writeStringList(createStringArrayList);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                        boolean c2 = c(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(c2 ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void a() throws RemoteException;

    void a(int i2) throws RemoteException;

    void a(int i2, int i3, int i4, int i5) throws RemoteException;

    void a(String str, List<String> list) throws RemoteException;

    boolean a(int i2, int i3, String str) throws RemoteException;

    void b() throws RemoteException;

    boolean b(int i2, int i3, String str) throws RemoteException;

    void c() throws RemoteException;

    boolean c(int i2, int i3, String str) throws RemoteException;
}
