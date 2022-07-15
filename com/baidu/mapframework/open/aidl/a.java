package com.baidu.mapframework.open.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapframework.open.aidl.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.mapframework.open.aidl.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0106a extends Binder implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.mapframework.open.aidl.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0107a implements a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder a;

            public C0107a(IBinder iBinder) {
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

            @Override // com.baidu.mapframework.open.aidl.a
            public void a(b bVar) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.baidu.mapframework.open.aidl.IMapOpenService");
                        obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                        this.a.transact(1, obtain, obtain2, 0);
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (IBinder) invokeV.objValue;
            }
        }

        public static a a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.mapframework.open.aidl.IMapOpenService");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0107a(iBinder) : (a) queryLocalInterface;
            }
            return (a) invokeL.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i != 1) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.baidu.mapframework.open.aidl.IMapOpenService");
                    return true;
                }
                parcel.enforceInterface("com.baidu.mapframework.open.aidl.IMapOpenService");
                a(b.a.b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    void a(b bVar) throws RemoteException;
}
