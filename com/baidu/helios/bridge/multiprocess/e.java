package com.baidu.helios.bridge.multiprocess;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public interface e extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class a extends Binder implements e {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final String f40552a = "com.baidu.helios.bridge.multiprocess.IMultiProcessBridge";

        /* renamed from: b  reason: collision with root package name */
        public static final int f40553b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f40554c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f40555d = 3;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.helios.bridge.multiprocess.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C1660a implements e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f40556a;

            public C1660a(IBinder iBinder) {
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
                this.f40556a = iBinder;
            }

            @Override // com.baidu.helios.bridge.multiprocess.e
            public Bundle a(String str, Bundle bundle) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bundle)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(a.f40552a);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.f40556a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (Bundle) invokeLL.objValue;
            }

            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a.f40552a : (String) invokeV.objValue;
            }

            @Override // com.baidu.helios.bridge.multiprocess.e
            public void a(String str, Bundle bundle, f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle, fVar) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(a.f40552a);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                        this.f40556a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // com.baidu.helios.bridge.multiprocess.e
            public boolean a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(a.f40552a);
                        obtain.writeString(str);
                        this.f40556a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeL.booleanValue;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40556a : (IBinder) invokeV.objValue;
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
            attachInterface(this, f40552a);
        }

        public static e a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(f40552a);
                return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C1660a(iBinder) : (e) queryLocalInterface;
            }
            return (e) invokeL.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 1) {
                    parcel.enforceInterface(f40552a);
                    Bundle a2 = a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a2 != null) {
                        parcel2.writeInt(1);
                        a2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                } else if (i2 == 2) {
                    parcel.enforceInterface(f40552a);
                    a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, f.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                } else if (i2 != 3) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString(f40552a);
                    return true;
                } else {
                    parcel.enforceInterface(f40552a);
                    boolean a3 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    Bundle a(String str, Bundle bundle);

    void a(String str, Bundle bundle, f fVar);

    boolean a(String str);
}
