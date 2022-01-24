package com.baidu.sofire.m;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.IOpenID;
/* loaded from: classes11.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.sofire.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC1873a extends Binder implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.sofire.m.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C1874a implements a {
            public static /* synthetic */ Interceptable $ic;
            public static a a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f38510b;

            public C1874a(IBinder iBinder) {
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
                this.f38510b = iBinder;
            }

            @Override // com.baidu.sofire.m.a
            public final String a(String str, String str2, String str3) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        if (this.f38510b.transact(1, obtain, obtain2, 0) || AbstractBinderC1873a.a() == null) {
                            obtain2.readException();
                            return obtain2.readString();
                        }
                        return AbstractBinderC1873a.a().a(str, str2, str3);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeLLL.objValue;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38510b : (IBinder) invokeV.objValue;
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? C1874a.a : (a) invokeV.objValue;
        }

        public static a a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(IOpenID.Stub.DESCRIPTOR);
                return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C1874a(iBinder) : (a) queryLocalInterface;
            }
            return (a) invokeL.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 != 1) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString(IOpenID.Stub.DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(IOpenID.Stub.DESCRIPTOR);
                String a = a(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    String a(String str, String str2, String str3);
}
