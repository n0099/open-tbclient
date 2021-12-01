package com.baidu.tbadk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.c;
import c.a.q0.r0.l;
import c.a.q0.s.e0.b;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.NASLib;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ColdStartStatsUtil;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.switchs.LaunchUpSpeedSwitch;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes9.dex */
public class TbadkApplication extends TbadkCoreApplication {
    public static /* synthetic */ Interceptable $ic = null;
    public static String mForumName = "armcv";
    public static TbadkApplication sApp;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mMemListener;
    public String[] mPatchWhiteList;
    public c resourcesWrapper;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMemListener = new CustomMessageListener(this, 2001194) { // from class: com.baidu.tbadk.TbadkApplication.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbadkApplication this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null) {
                    return;
                }
                TbadkCoreApplication.setCurrentMemberType(num.intValue());
                if (num.intValue() != 0) {
                    TbadkSettings inst = TbadkSettings.getInst();
                    inst.saveBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), true);
                    return;
                }
                TbadkSettings inst2 = TbadkSettings.getInst();
                inst2.saveBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
            }
        };
        this.mPatchWhiteList = new String[]{"HUAWEI:H60-L01", "HUAWEI:H60-L02", "HUAWEI:H60-L03"};
    }

    public static TbadkApplication getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sApp : (TbadkApplication) invokeV.objValue;
    }

    private void prepareForDefaultAlertTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Calendar calendar = Calendar.getInstance();
            setSignAlertTime(calendar.get(11), calendar.get(12));
        }
    }

    public Intent createIntentForSignAlarm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
            intent.setData(Uri.parse("tieba_sign://alert"));
            intent.setClass(getInst().getContext(), SignAlertReceiver.class);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? mForumName : (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (BdBaseApplication.getInst() != null && !BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                if (this.resourcesWrapper == null && super.getResources() != null) {
                    this.resourcesWrapper = new c(super.getResources());
                }
                return this.resourcesWrapper;
            }
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public int getSignAlertHours() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.tShopUrl : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication
    public void handleInitMessage(Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, message) == null) || message == null) {
            return;
        }
        super.handleInitMessage(message);
        boolean z = !LaunchUpSpeedSwitch.getIsOn();
        switch (message.what) {
            case 6:
                SpeedStatsManager.getInstance().addStatsTimeStamp(2047);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_SIX_STAMP_KEY);
                if (z) {
                    this.mAppInitHandler.sendEmptyMessage(7);
                    return;
                }
                return;
            case 7:
                SpeedStatsManager.getInstance().addStatsTimeStamp(2048);
                setActivityStackMaxSize(20);
                if (isMainProcess(false)) {
                    updateSignAlarm();
                    initLikeForum();
                    initSignedForum();
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_SEVEN_STAMP_KEY);
                if (z) {
                    this.mAppInitHandler.sendEmptyMessage(8);
                    return;
                }
                return;
            case 8:
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_EIGHT_START_STAMP_KEY);
                MessageManager.getInstance().registerListener(this.mMemListener);
                if (isMainProcess(true)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    NASLib.setCallBack(new NASLib.NASCallBack(this) { // from class: com.baidu.tbadk.TbadkApplication.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TbadkApplication this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.appsearchlib.NASLib.NASCallBack
                        public void callback(String str, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) {
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).addParam("obj_param1", 1));
                                UrlManager.getInstance().dealOneLink(null, new String[]{str2});
                            }
                        }
                    });
                    l.b().q(System.currentTimeMillis() - currentTimeMillis);
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_EIGHT_STAMP_KEY);
                if (z) {
                    this.mAppInitHandler.sendEmptyMessage(9);
                    return;
                }
                return;
            case 9:
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_NINE_START_STAMP_KEY);
                EmotionUtil.statisticsEmotionGroupNums();
                ColdStartStatsUtil.startUBCStats(isMainProcess(false));
                if (this.isRemoteProcess) {
                    l.b().g(System.currentTimeMillis() - this.processCreateTime);
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_MSG_NINE_STAMP_KEY);
                return;
            default:
                return;
        }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isDaemonProcess : invokeV.booleanValue;
    }

    public boolean isSignAlertOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TbadkSettings.getInst().loadBoolean("alert_sign_on", false) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? loadString("account_share", null) : (String) invokeV.objValue;
    }

    public void loginShareRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b.j().C("account_share");
        }
    }

    public void loginShareSave(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            saveString("account_share", str);
        }
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            sApp = this;
            super.onCreate();
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

    public void setSignAlertTime(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            TbadkSettings.getInst().saveInt("alert_sign_hours", i2);
            TbadkSettings.getInst().saveInt("alert_sign_mins", i3);
            updateSignAlarm();
        }
    }

    public void settShopUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.tShopUrl = str;
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
                int i2 = calendar.get(11);
                int signAlertMins = getSignAlertMins();
                int i3 = calendar.get(12);
                calendar.set(11, signAlertHours);
                calendar.set(12, signAlertMins);
                calendar.set(13, 0);
                calendar.set(14, 0);
                if (i2 >= signAlertHours && (i2 != signAlertHours || i3 >= signAlertMins)) {
                    calendar.set(6, calendar.get(6) + 1);
                }
                alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, 134217728));
                BdLog.isDebugMode();
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, 536870912);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                BdLog.isDebugMode();
            }
        }
    }
}
