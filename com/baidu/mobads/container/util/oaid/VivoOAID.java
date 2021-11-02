package com.baidu.mobads.container.util.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VivoOAID {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VivoOAID() {
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

    public static void getVivoOaid(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null) {
            return;
        }
        try {
            TaskScheduler.getInstance().submit(new BaseTask(context) { // from class: com.baidu.mobads.container.util.oaid.VivoOAID.1
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

                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    InterceptResult invokeV;
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            UniqueIdUtils.sendSDKTypeLog(this.val$context, "vivo-start", "");
                            Cursor query = this.val$context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                            if (query != null) {
                                str = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                                query.close();
                            } else {
                                str = null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                UniqueIdUtils.miitOAID = str;
                                UniqueIdUtils.sendSDKTypeLog(this.val$context, "vivo-valid", str);
                                UniqueIdUtils.update(604800000L, str);
                            } else {
                                UniqueIdUtils.sendSDKTypeLog(this.val$context, "vivo-empty", "");
                            }
                        } catch (Throwable unused) {
                        }
                        return null;
                    }
                    return invokeV.objValue;
                }
            });
        } catch (Throwable th) {
            UniqueIdUtils.sendSDKTypeLog(context, "vivo-errror" + th.getMessage(), "");
        }
    }

    public static boolean isVivoBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                String phoneOSBrand = DeviceUtils.getInstance().getPhoneOSBrand();
                boolean equalsIgnoreCase = !TextUtils.isEmpty(phoneOSBrand) ? phoneOSBrand.equalsIgnoreCase(RomUtils.MANUFACTURER_VIVO) : false;
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
