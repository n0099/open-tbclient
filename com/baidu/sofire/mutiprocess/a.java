package com.baidu.sofire.mutiprocess;

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
    Bundle a(Bundle bundle) throws RemoteException;

    Bundle a(String str) throws RemoteException;

    Bundle b(Bundle bundle) throws RemoteException;

    /* renamed from: com.baidu.sofire.mutiprocess.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0166a extends Binder implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AbstractBinderC0166a() {
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
            attachInterface(this, "com.baidu.sofire.mutiprocess.IMutiProcessHandler");
        }

        public static a a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                    return (a) queryLocalInterface;
                }
                return new C0167a(iBinder);
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
                    parcel.enforceInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    Bundle a2 = a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a2 != null) {
                        parcel2.writeInt(1);
                        a2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    Bundle b2 = b(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (b2 != null) {
                        parcel2.writeInt(1);
                        b2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                } else if (i2 != 3) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    return true;
                } else {
                    parcel.enforceInterface("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                    Bundle a3 = a(parcel.readString());
                    parcel2.writeNoException();
                    if (a3 != null) {
                        parcel2.writeInt(1);
                        a3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0167a.f10462a : (a) invokeV.objValue;
        }

        /* renamed from: com.baidu.sofire.mutiprocess.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0167a implements a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f10462a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f10463b;

            public C0167a(IBinder iBinder) {
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
                this.f10463b = iBinder;
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle a(Bundle bundle) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f10463b.transact(1, obtain, obtain2, 0) && AbstractBinderC0166a.a() != null) {
                            return AbstractBinderC0166a.a().a(bundle);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (Bundle) invokeL.objValue;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10463b : (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle b(Bundle bundle) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.f10463b.transact(2, obtain, obtain2, 0) && AbstractBinderC0166a.a() != null) {
                            return AbstractBinderC0166a.a().b(bundle);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (Bundle) invokeL.objValue;
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle a(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.sofire.mutiprocess.IMutiProcessHandler");
                        obtain.writeString(str);
                        if (!this.f10463b.transact(3, obtain, obtain2, 0) && AbstractBinderC0166a.a() != null) {
                            return AbstractBinderC0166a.a().a(str);
                        }
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (Bundle) invokeL.objValue;
            }
        }
    }
}
