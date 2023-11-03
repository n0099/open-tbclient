package com.baidu.mapframework.open.aidl;

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
public interface IComOpenClient extends IInterface {
    String a(String str) throws RemoteException;

    boolean a(String str, String str2, Bundle bundle) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements IComOpenClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.mapframework.open.aidl.IComOpenClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0103a implements IComOpenClient {
            public static /* synthetic */ Interceptable $ic;
            public static IComOpenClient a;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder b;

            public C0103a(IBinder iBinder) {
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
                this.b = iBinder;
            }

            @Override // com.baidu.mapframework.open.aidl.IComOpenClient
            public String a(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
                        obtain.writeString(str);
                        if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().a(str);
                        }
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.baidu.mapframework.open.aidl.IComOpenClient
            public boolean a(String str, String str2, Bundle bundle) throws RemoteException {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, bundle)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IComOpenClient");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        boolean z = true;
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                            return a.a().a(str, str2, bundle);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        return z;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeLLL.booleanValue;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.b;
                }
                return (IBinder) invokeV.objValue;
            }
        }

        public static IComOpenClient a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return C0103a.a;
            }
            return (IComOpenClient) invokeV.objValue;
        }

        public static IComOpenClient a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
                if (queryLocalInterface != null && (queryLocalInterface instanceof IComOpenClient)) {
                    return (IComOpenClient) queryLocalInterface;
                }
                return new C0103a(iBinder);
            }
            return (IComOpenClient) invokeL.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 1598968902) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        parcel2.writeString("com.baidu.mapframework.open.aidl.IComOpenClient");
                        return true;
                    }
                    parcel.enforceInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    boolean a = a(readString, readString2, bundle);
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                }
                parcel.enforceInterface("com.baidu.mapframework.open.aidl.IComOpenClient");
                String a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }
}
