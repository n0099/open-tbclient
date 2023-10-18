package com.baidu.tbadk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.eb;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class TbadkApplication extends TbadkCoreApplication {
    public static /* synthetic */ Interceptable $ic = null;
    public static String mForumName = "armcv";
    public static TbadkApplication sApp;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] mPatchWhiteList;
    public eb resourcesWrapper;
    public String tShopUrl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1400827714, "Lcom/baidu/tbadk/TbadkApplication;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1400827714, "Lcom/baidu/tbadk/TbadkApplication;");
        }
    }

    public TbadkApplication() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPatchWhiteList = new String[]{"HUAWEI:H60-L01", "HUAWEI:H60-L02", "HUAWEI:H60-L03"};
    }

    public static TbadkApplication getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return sApp;
        }
        return (TbadkApplication) invokeV.objValue;
    }

    private void prepareForDefaultAlertTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Calendar calendar = Calendar.getInstance();
            setSignAlertTime(calendar.get(11), calendar.get(12));
        }
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return mForumName;
        }
        return (String) invokeV.objValue;
    }

    public int getSignAlertHours() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
            if (loadInt == -1) {
                prepareForDefaultAlertTime();
                return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    public int getSignAlertMins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
            if (loadInt == -1) {
                prepareForDefaultAlertTime();
                return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    public String gettShopUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.tShopUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void initSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.initSetting();
            upgradeAbstractOnInMemory(TbadkSettings.getInst().loadInt("new_abstract_state", 0));
        }
    }

    public boolean isDaemonProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isDaemonProcess;
        }
        return invokeV.booleanValue;
    }

    public boolean isSignAlertOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
        }
        return invokeV.booleanValue;
    }

    public boolean isTbCDNTachometerProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Boolean bool = this.isCdnTachometerProcess;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String loginShareRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return loadString("account_share", null);
        }
        return (String) invokeV.objValue;
    }

    public void loginShareRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SharedPrefHelper.getInstance().remove("account_share");
        }
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onCreate();
        }
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    public void loginShareSave(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            saveString("account_share", str);
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            mForumName = str;
        }
    }

    public void setSignAlertOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
            updateSignAlarm();
        }
    }

    public void settShopUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.tShopUrl = str;
        }
    }

    public Intent createIntentForSignAlarm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
            intent.setData(Uri.parse("tieba_sign://alert"));
            intent.setClass(getInst().getContext(), SignAlertReceiver.class);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (BdBaseApplication.getInst() != null && !BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                if (this.resourcesWrapper == null && super.getResources() != null) {
                    this.resourcesWrapper = new eb(super.getResources());
                }
                return this.resourcesWrapper;
            }
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void setSignAlertTime(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            TbadkSettings.getInst().saveInt("alert_sign_hours", i);
            TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
            updateSignAlarm();
        }
    }

    public void updateSignAlarm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            AlarmManager alarmManager = (AlarmManager) getInst().getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent createIntentForSignAlarm = createIntentForSignAlarm();
            if (isSignAlertOn()) {
                Calendar calendar = Calendar.getInstance();
                int signAlertHours = getSignAlertHours();
                int i = calendar.get(11);
                int signAlertMins = getSignAlertMins();
                int i2 = calendar.get(12);
                calendar.set(11, signAlertHours);
                calendar.set(12, signAlertMins);
                calendar.set(13, 0);
                calendar.set(14, 0);
                if (i >= signAlertHours && (i != signAlertHours || i2 >= signAlertMins)) {
                    calendar.set(6, calendar.get(6) + 1);
                }
                alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION));
                BdLog.isDebugMode();
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                BdLog.isDebugMode();
            }
        }
    }
}
