package com.baidu.searchbox.common.security;

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
/* loaded from: classes2.dex */
public interface IDeviceInfoService extends IInterface {
    DeviceIdBag getAndroidId(String str, String str2) throws RemoteException;

    DeviceIdBagMap getDeviceInfos(String str, String str2, int i, boolean z) throws RemoteException;

    DeviceIdBag getHarmonyVersion(String str, String str2) throws RemoteException;

    DeviceIdBag getIMEI(String str, String str2, boolean z) throws RemoteException;

    DeviceIdBag getMacAddress(String str, String str2) throws RemoteException;

    DeviceIdBag getManufacturer(String str, String str2) throws RemoteException;

    DeviceIdBag getModel(String str, String str2) throws RemoteException;

    DeviceIdBag getOAID(String str, String str2) throws RemoteException;

    DeviceIdBag getOperator(String str, String str2, boolean z) throws RemoteException;

    DeviceIdBag getOsVersion(String str, String str2) throws RemoteException;

    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements IDeviceInfoService {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.baidu.searchbox.common.security.IDeviceInfoService";
        public static final int TRANSACTION_getAndroidId = 4;
        public static final int TRANSACTION_getDeviceInfos = 1;
        public static final int TRANSACTION_getHarmonyVersion = 9;
        public static final int TRANSACTION_getIMEI = 3;
        public static final int TRANSACTION_getMacAddress = 2;
        public static final int TRANSACTION_getManufacturer = 10;
        public static final int TRANSACTION_getModel = 6;
        public static final int TRANSACTION_getOAID = 5;
        public static final int TRANSACTION_getOperator = 8;
        public static final int TRANSACTION_getOsVersion = 7;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        /* loaded from: classes2.dex */
        public class Proxy implements IDeviceInfoService {
            public static /* synthetic */ Interceptable $ic;
            public static IDeviceInfoService sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            public Proxy(IBinder iBinder) {
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
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.mRemote;
                }
                return (IBinder) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getAndroidId(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getAndroidId(str, str2);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLL.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getHarmonyVersion(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getHarmonyVersion(str, str2);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLL.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getMacAddress(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getMacAddress(str, str2);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLL.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getManufacturer(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getManufacturer(str, str2);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLL.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getModel(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getModel(str, str2);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLL.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getOAID(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getOAID(str, str2);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLL.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getOsVersion(String str, String str2) throws RemoteException {
                InterceptResult invokeLL;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getOsVersion(str, str2);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLL.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBagMap getDeviceInfos(String str, String str2, int i, boolean z) throws RemoteException {
                InterceptResult invokeCommon;
                int i2;
                DeviceIdBagMap deviceIdBagMap;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeInt(i);
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        obtain.writeInt(i2);
                        if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getDeviceInfos(str, str2, i, z);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBagMap = DeviceIdBagMap.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBagMap = null;
                        }
                        return deviceIdBagMap;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBagMap) invokeCommon.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getIMEI(String str, String str2, boolean z) throws RemoteException {
                InterceptResult invokeLLZ;
                int i;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, str2, z)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (z) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        obtain.writeInt(i);
                        if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getIMEI(str, str2, z);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLLZ.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoService
            public DeviceIdBag getOperator(String str, String str2, boolean z) throws RemoteException {
                InterceptResult invokeLLZ;
                int i;
                DeviceIdBag deviceIdBag;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, str, str2, z)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        if (z) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        obtain.writeInt(i);
                        if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            return Stub.getDefaultImpl().getOperator(str, str2, z);
                        }
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            deviceIdBag = (DeviceIdBag) DeviceIdBag.CREATOR.createFromParcel(obtain2);
                        } else {
                            deviceIdBag = null;
                        }
                        return deviceIdBag;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (DeviceIdBag) invokeLLZ.objValue;
            }
        }

        public Stub() {
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IDeviceInfoService getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return Proxy.sDefaultImpl;
            }
            return (IDeviceInfoService) invokeV.objValue;
        }

        public static IDeviceInfoService asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceInfoService)) {
                    return (IDeviceInfoService) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IDeviceInfoService) invokeL.objValue;
        }

        public static boolean setDefaultImpl(IDeviceInfoService iDeviceInfoService) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iDeviceInfoService)) == null) {
                if (Proxy.sDefaultImpl == null && iDeviceInfoService != null) {
                    Proxy.sDefaultImpl = iDeviceInfoService;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i != 1598968902) {
                    switch (i) {
                        case 1:
                            parcel.enforceInterface(DESCRIPTOR);
                            String readString = parcel.readString();
                            String readString2 = parcel.readString();
                            int readInt = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            DeviceIdBagMap deviceInfos = getDeviceInfos(readString, readString2, readInt, z);
                            parcel2.writeNoException();
                            if (deviceInfos != null) {
                                parcel2.writeInt(1);
                                deviceInfos.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 2:
                            parcel.enforceInterface(DESCRIPTOR);
                            DeviceIdBag macAddress = getMacAddress(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (macAddress != null) {
                                parcel2.writeInt(1);
                                macAddress.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 3:
                            parcel.enforceInterface(DESCRIPTOR);
                            String readString3 = parcel.readString();
                            String readString4 = parcel.readString();
                            if (parcel.readInt() != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            DeviceIdBag imei = getIMEI(readString3, readString4, z2);
                            parcel2.writeNoException();
                            if (imei != null) {
                                parcel2.writeInt(1);
                                imei.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 4:
                            parcel.enforceInterface(DESCRIPTOR);
                            DeviceIdBag androidId = getAndroidId(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (androidId != null) {
                                parcel2.writeInt(1);
                                androidId.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 5:
                            parcel.enforceInterface(DESCRIPTOR);
                            DeviceIdBag oaid = getOAID(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (oaid != null) {
                                parcel2.writeInt(1);
                                oaid.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 6:
                            parcel.enforceInterface(DESCRIPTOR);
                            DeviceIdBag model = getModel(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (model != null) {
                                parcel2.writeInt(1);
                                model.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 7:
                            parcel.enforceInterface(DESCRIPTOR);
                            DeviceIdBag osVersion = getOsVersion(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (osVersion != null) {
                                parcel2.writeInt(1);
                                osVersion.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 8:
                            parcel.enforceInterface(DESCRIPTOR);
                            String readString5 = parcel.readString();
                            String readString6 = parcel.readString();
                            if (parcel.readInt() != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            DeviceIdBag operator = getOperator(readString5, readString6, z3);
                            parcel2.writeNoException();
                            if (operator != null) {
                                parcel2.writeInt(1);
                                operator.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 9:
                            parcel.enforceInterface(DESCRIPTOR);
                            DeviceIdBag harmonyVersion = getHarmonyVersion(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (harmonyVersion != null) {
                                parcel2.writeInt(1);
                                harmonyVersion.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 10:
                            parcel.enforceInterface(DESCRIPTOR);
                            DeviceIdBag manufacturer = getManufacturer(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            if (manufacturer != null) {
                                parcel2.writeInt(1);
                                manufacturer.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class Default implements IDeviceInfoService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getAndroidId(String str, String str2) throws RemoteException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBagMap getDeviceInfos(String str, String str2, int i, boolean z) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                return null;
            }
            return (DeviceIdBagMap) invokeCommon.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getHarmonyVersion(String str, String str2) throws RemoteException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getIMEI(String str, String str2, boolean z) throws RemoteException {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, str2, z)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLLZ.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getMacAddress(String str, String str2) throws RemoteException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getManufacturer(String str, String str2) throws RemoteException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getModel(String str, String str2) throws RemoteException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getOAID(String str, String str2) throws RemoteException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getOperator(String str, String str2, boolean z) throws RemoteException {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048585, this, str, str2, z)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLLZ.objValue;
        }

        @Override // com.baidu.searchbox.common.security.IDeviceInfoService
        public DeviceIdBag getOsVersion(String str, String str2) throws RemoteException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
                return null;
            }
            return (DeviceIdBag) invokeLL.objValue;
        }

        public Default() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }
}
