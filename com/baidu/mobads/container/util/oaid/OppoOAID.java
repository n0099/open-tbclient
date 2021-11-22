package com.baidu.mobads.container.util.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.IOpenID;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class OppoOAID {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OppoOAID() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void getOppoOaid(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            UniqueIdUtils.sendSDKTypeLog(context, "oppo-start", "");
            try {
                TaskScheduler.getInstance().submit(new BaseTask(context, new ServiceConnection(context) { // from class: com.baidu.mobads.container.util.oaid.OppoOAID.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                    }

                    /* JADX WARN: Can't wrap try/catch for region: R(5:(4:10|11|12|(9:14|(1:16)|17|18|19|20|21|22|(2:24|25)(2:27|28)))|20|21|22|(0)(0)) */
                    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
                        r12 = move-exception;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
                        r12.printStackTrace();
                     */
                    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
                    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
                    @Override // android.content.ServiceConnection
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        Signature[] signatureArr;
                        String str;
                        Parcel obtain;
                        Parcel obtain2;
                        MessageDigest messageDigest;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeLL(1048576, this, componentName, iBinder) != null) {
                            return;
                        }
                        UniqueIdUtils.sendSDKTypeLog(this.val$context, "oppo-connect", "");
                        iBinder.queryLocalInterface(IOpenID.Stub.DESCRIPTOR);
                        String packageName = this.val$context.getPackageName();
                        String str2 = null;
                        try {
                            signatureArr = this.val$context.getPackageManager().getPackageInfo(packageName, 64).signatures;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            signatureArr = null;
                        }
                        try {
                            if (signatureArr != null && signatureArr.length > 0) {
                                byte[] byteArray = signatureArr[0].toByteArray();
                                try {
                                    messageDigest = MessageDigest.getInstance("SHA1");
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                if (messageDigest != null) {
                                    byte[] digest = messageDigest.digest(byteArray);
                                    StringBuilder sb = new StringBuilder();
                                    for (byte b2 : digest) {
                                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                                    }
                                    str = sb.toString();
                                    obtain = Parcel.obtain();
                                    obtain2 = Parcel.obtain();
                                    obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                                    obtain.writeString(packageName);
                                    obtain.writeString(str);
                                    obtain.writeString("OUID");
                                    iBinder.transact(1, obtain, obtain2, 0);
                                    obtain2.readException();
                                    str2 = obtain2.readString();
                                    obtain.recycle();
                                    obtain2.recycle();
                                    if (TextUtils.isEmpty(str2)) {
                                        UniqueIdUtils.miitOAID = str2;
                                        UniqueIdUtils.sendSDKTypeLog(this.val$context, "oppo-valid", str2);
                                        UniqueIdUtils.update(604800000L, str2);
                                        return;
                                    }
                                    UniqueIdUtils.sendSDKTypeLog(this.val$context, "oppo-empty", "");
                                    return;
                                }
                            }
                            obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                            obtain.writeString(packageName);
                            obtain.writeString(str);
                            obtain.writeString("OUID");
                            iBinder.transact(1, obtain, obtain2, 0);
                            obtain2.readException();
                            str2 = obtain2.readString();
                            obtain.recycle();
                            obtain2.recycle();
                            if (TextUtils.isEmpty(str2)) {
                            }
                        } catch (Throwable th) {
                            obtain.recycle();
                            obtain2.recycle();
                            throw th;
                        }
                        str = null;
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                        }
                    }
                }) { // from class: com.baidu.mobads.container.util.oaid.OppoOAID.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ ServiceConnection val$oppoService;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$oppoService = r7;
                    }

                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                Intent intent = new Intent();
                                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                                this.val$context.bindService(intent, this.val$oppoService, 1);
                                return null;
                            } catch (Throwable unused) {
                                return null;
                            }
                        }
                        return invokeV.objValue;
                    }
                });
            } catch (Throwable th) {
                UniqueIdUtils.sendSDKTypeLog(context, "oppo-error" + th.getMessage(), "");
            }
        }
    }

    public static boolean isOppoBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                String phoneOSBrand = DeviceUtils.getInstance().getPhoneOSBrand();
                boolean equalsIgnoreCase = !TextUtils.isEmpty(phoneOSBrand) ? phoneOSBrand.equalsIgnoreCase(RomUtils.MANUFACTURER_OPPO) : false;
                try {
                    if (Build.VERSION.SDK_INT < 28) {
                        return false;
                    }
                } catch (Throwable unused) {
                }
                return equalsIgnoreCase;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
