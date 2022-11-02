package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.remote.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.cyberplayer.sdk.remote.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0094a implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder a;

            public C0094a(IBinder iBinder) {
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

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public int a() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(float f) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeFloat(f);
                        this.a.transact(22, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(float f, float f2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeFloat(f);
                        obtain.writeFloat(f2);
                        this.a.transact(21, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeInt(i);
                        this.a.transact(8, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(int i, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        this.a.transact(35, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(int i, int i2, long j, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeLong(j);
                        obtain.writeString(str);
                        this.a.transact(25, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(long j, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeLong(j);
                        obtain.writeInt(i);
                        this.a.transact(13, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(Surface surface) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048583, this, surface) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        if (surface != null) {
                            obtain.writeInt(1);
                            surface.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(d dVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                        this.a.transact(30, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(e eVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        if (eVar != null) {
                            obtain.writeInt(1);
                            eVar.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeString(str);
                        this.a.transact(33, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(String str, String str2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        this.a.transact(24, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(String str, boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeString(str);
                        obtain.writeInt(z ? 1 : 0);
                        this.a.transact(23, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void a(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeInt(z ? 1 : 0);
                        this.a.transact(9, obtain, obtain2, 0);
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a : (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void b() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void b(int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeInt(i);
                        this.a.transact(32, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void b(d dVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                        this.a.transact(31, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void b(String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeString(str);
                        this.a.transact(34, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void b(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeInt(z ? 1 : 0);
                        this.a.transact(19, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void c() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void c(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeInt(z ? 1 : 0);
                        this.a.transact(26, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void d() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(6, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void d(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        obtain.writeInt(z ? 1 : 0);
                        this.a.transact(29, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void e() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(7, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public int f() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(10, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public int g() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(11, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public boolean h() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(12, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public int i() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(14, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public int j() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(15, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public int k() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(16, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void l() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(17, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public void m() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(18, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public boolean n() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(20, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public long o() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(27, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readLong();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.longValue;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.b
            public long p() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        this.a.transact(28, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readLong();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.longValue;
            }
        }

        public a() {
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
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
        }

        public static b a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0094a(iBinder) : (b) queryLocalInterface;
            }
            return (b) invokeL.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i == 1598968902) {
                    parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    return true;
                }
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int a = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt() != 0 ? e.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        d();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        e();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int f = f();
                        parcel2.writeNoException();
                        parcel2.writeInt(f);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int g = g();
                        parcel2.writeNoException();
                        parcel2.writeInt(g);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        boolean h = h();
                        parcel2.writeNoException();
                        parcel2.writeInt(h ? 1 : 0);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int i3 = i();
                        parcel2.writeNoException();
                        parcel2.writeInt(i3);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int j = j();
                        parcel2.writeNoException();
                        parcel2.writeInt(j);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int k = k();
                        parcel2.writeNoException();
                        parcel2.writeInt(k);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        l();
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        m();
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        boolean n = n();
                        parcel2.writeNoException();
                        parcel2.writeInt(n ? 1 : 0);
                        return true;
                    case 21:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readFloat(), parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readString(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        c(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        long o = o();
                        parcel2.writeNoException();
                        parcel2.writeLong(o);
                        return true;
                    case 28:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        long p = p();
                        parcel2.writeNoException();
                        parcel2.writeLong(p);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        d(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 30:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(d.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b(d.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    int a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(float f, float f2) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(int i, int i2, long j, String str) throws RemoteException;

    void a(long j, int i) throws RemoteException;

    void a(Surface surface) throws RemoteException;

    void a(d dVar) throws RemoteException;

    void a(e eVar) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(d dVar) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(boolean z) throws RemoteException;

    void c() throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d() throws RemoteException;

    void d(boolean z) throws RemoteException;

    void e() throws RemoteException;

    int f() throws RemoteException;

    int g() throws RemoteException;

    boolean h() throws RemoteException;

    int i() throws RemoteException;

    int j() throws RemoteException;

    int k() throws RemoteException;

    void l() throws RemoteException;

    void m() throws RemoteException;

    boolean n() throws RemoteException;

    long o() throws RemoteException;

    long p() throws RemoteException;
}
