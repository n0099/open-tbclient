package com.baidu.adp.lib.lbs;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.Cif;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public class BdLocationMananger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_STOP_LOCATION_SERVICE = 0;
    public static final String BAIDU_MAP_API_FORMAT = "http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s";
    public static final long DEFAULT_LOCATION_EXPIRATION = 300000;
    public static final int HUN_METERS = 100;
    public static final int LOC_ALL_OFF = 3;
    public static final int LOC_DISALLOW_REQUEST_LOCATION = 7;
    public static final int LOC_GPS_OFF = 1;
    public static final int LOC_NET_OFF = 2;
    public static final int LOC_NO_LOCATION_PROVIDER = 6;
    public static final int LOC_OK = 0;
    public static final int LOC_OUT_TIME = 4;
    public static final int LOC_UNKONWN_ERROR = 5;
    public static final int MAX_CALLBACK_NUM = 100;
    public static final int TEN_SECONDS = 10000;
    public static BdLocationMananger mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public int errorCode;
    public Handler handler;
    public Address lastAddress;
    public long lastLocationTime;
    public long location_expiration;
    public boolean mCurrentLocationIsAccurcy;
    public boolean mIsExecLocationTask;
    public boolean mLastAddressIsAccuracy;
    public ArrayList<SoftReference<LocationCallBack>> mLocationCallBacks;
    public c mLocationProviderCallback;
    public ArrayList<Cif> mLocationProviders;
    public long mTimeOutValue;
    @NonNull
    public d whiteList;

    /* loaded from: classes.dex */
    public interface LocationCallBack {
        void onLocationGeted(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i, String str, Address address, long j, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(959273579, "Lcom/baidu/adp/lib/lbs/BdLocationMananger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(959273579, "Lcom/baidu/adp/lib/lbs/BdLocationMananger;");
        }
    }

    /* loaded from: classes.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdLocationMananger a;

        public a(BdLocationMananger bdLocationMananger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdLocationMananger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdLocationMananger;
        }

        @Override // com.baidu.adp.lib.lbs.BdLocationMananger.c
        public void a(int i, String str, Address address, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, address, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                BdLocationMananger bdLocationMananger = this.a;
                bdLocationMananger.lastLocationTime = j;
                bdLocationMananger.lastAddress = address;
                this.a.mLastAddressIsAccuracy = z;
                this.a.errorCode = i;
                this.a.stopLocationServer();
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4 && StringUtils.isNull(str)) {
                                str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c1a);
                            }
                        } else if (StringUtils.isNull(str)) {
                            str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c13);
                        }
                    } else if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c19);
                    }
                } else if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                }
                this.a.doCallBacks(i, str, address);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdLocationMananger a;

        public b(BdLocationMananger bdLocationMananger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdLocationMananger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdLocationMananger;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.a.stopLocationServer();
                int i = this.a.errorCode;
                String str = "";
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 6) {
                                    str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c1a);
                                }
                            } else {
                                str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c1a);
                            }
                        } else {
                            str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c13);
                        }
                    } else {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c19);
                    }
                } else {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                }
                BdLocationMananger bdLocationMananger = this.a;
                bdLocationMananger.doCallBacks(bdLocationMananger.errorCode, str, null);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final Set<String> a;

        public d() {
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
            this.a = new HashSet();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.add(str);
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                int min = Math.min(stackTrace.length, 20);
                for (int i = 0; i < min; i++) {
                    if (this.a.contains(stackTrace[i].getClassName())) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public BdLocationMananger() {
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
        this.mTimeOutValue = 10000L;
        this.lastLocationTime = 0L;
        this.location_expiration = 300000L;
        this.mLastAddressIsAccuracy = false;
        this.mCurrentLocationIsAccurcy = false;
        this.mIsExecLocationTask = false;
        this.errorCode = 4;
        this.lastAddress = null;
        this.mLocationCallBacks = new ArrayList<>();
        this.mLocationProviders = new ArrayList<>();
        this.handler = null;
        this.whiteList = new d(null);
        this.mLocationProviderCallback = new a(this);
    }

    public Address getAddress(boolean z, LocationCallBack locationCallBack) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048580, this, z, locationCallBack)) == null) {
            return getAddress(z, false, locationCallBack);
        }
        return (Address) invokeZL.objValue;
    }

    public void addWhiteList(@NonNull Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
            this.whiteList.a(cls.getName());
        }
    }

    public Address getAddress(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            return getAddress(z, false);
        }
        return (Address) invokeZ.objValue;
    }

    public void registerProvider(Cif cif) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, cif) == null) && cif != null) {
            synchronized (this.mLocationProviders) {
                if (!this.mLocationProviders.contains(cif)) {
                    cif.b(this.mLocationProviderCallback);
                    this.mLocationProviders.add(cif);
                }
            }
        }
    }

    public void setTimeExpiration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.location_expiration = j;
        }
    }

    public void setTimeOut(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.mTimeOutValue = j;
        }
    }

    public void unRegiserProvider(Cif cif) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, cif) == null) && cif != null) {
            synchronized (this.mLocationProviders) {
                cif.destroy();
                this.mLocationProviders.remove(cif);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallBacks(int i, String str, Address address) {
        LocationCallBack locationCallBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65544, this, i, str, address) == null) {
            Handler handler = this.handler;
            if (handler != null && handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            ArrayList<SoftReference<LocationCallBack>> arrayList = this.mLocationCallBacks;
            if (arrayList != null) {
                synchronized (arrayList) {
                    for (int i2 = 0; i2 < this.mLocationCallBacks.size(); i2++) {
                        SoftReference<LocationCallBack> softReference = this.mLocationCallBacks.get(i2);
                        if (softReference != null && (locationCallBack = softReference.get()) != null) {
                            locationCallBack.onLocationGeted(i, str, address);
                        }
                    }
                    this.mLocationCallBacks.clear();
                }
            }
        }
    }

    public static BdLocationMananger getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (mInstance == null) {
                synchronized (BdLocationMananger.class) {
                    if (mInstance == null) {
                        mInstance = new BdLocationMananger();
                    }
                }
            }
            return mInstance;
        }
        return (BdLocationMananger) invokeV.objValue;
    }

    private void initHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.handler = new Handler(Looper.getMainLooper(), new b(this));
        }
    }

    public boolean checkWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.whiteList.b();
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            stopLocationServer();
            Iterator<Cif> it = this.mLocationProviders.iterator();
            while (it.hasNext()) {
                Cif next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.mLocationCallBacks.clear();
        }
    }

    public long getTimeExpiration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.location_expiration;
        }
        return invokeV.longValue;
    }

    public long getTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mTimeOutValue;
        }
        return invokeV.longValue;
    }

    public void initial() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            initHandler();
        }
    }

    private void startLocationServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            Handler handler = this.handler;
            if (handler != null && handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            this.errorCode = 4;
            this.mCurrentLocationIsAccurcy = z;
            this.mIsExecLocationTask = true;
            ArrayList<Cif> arrayList = this.mLocationProviders;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!this.whiteList.b()) {
                    this.errorCode = 7;
                    Handler handler2 = this.handler;
                    if (handler2 != null) {
                        handler2.sendMessage(handler2.obtainMessage(0));
                        return;
                    }
                    return;
                }
                Iterator<Cif> it = this.mLocationProviders.iterator();
                while (it.hasNext()) {
                    Cif next = it.next();
                    if (next != null) {
                        try {
                            next.a(z);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                }
                Handler handler3 = this.handler;
                if (handler3 != null) {
                    handler3.sendMessageDelayed(handler3.obtainMessage(0), this.mTimeOutValue);
                    return;
                }
                return;
            }
            this.errorCode = 6;
            Handler handler4 = this.handler;
            if (handler4 != null) {
                handler4.sendMessage(handler4.obtainMessage(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocationServer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Handler handler = this.handler;
            if (handler != null && handler.hasMessages(0)) {
                this.handler.removeMessages(0);
            }
            this.mIsExecLocationTask = false;
            Iterator<Cif> it = this.mLocationProviders.iterator();
            while (it.hasNext()) {
                Cif next = it.next();
                if (next != null) {
                    try {
                        next.c();
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
            }
        }
    }

    public Address getAddress(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (System.currentTimeMillis() - this.lastLocationTime > this.location_expiration) {
                this.lastAddress = null;
            }
            if (this.lastAddress != null && !z && ((z2 && this.mLastAddressIsAccuracy) || !z2)) {
                return this.lastAddress;
            }
            this.lastAddress = null;
            boolean z3 = this.mIsExecLocationTask;
            if (!z3) {
                startLocationServer(z2);
                return null;
            }
            if (z3 && z2 && !this.mCurrentLocationIsAccurcy) {
                stopLocationServer();
                startLocationServer(z2);
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public Address getAddress(boolean z, boolean z2, LocationCallBack locationCallBack) {
        InterceptResult invokeCommon;
        boolean z3;
        LocationCallBack locationCallBack2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), locationCallBack})) == null) {
            if (System.currentTimeMillis() - this.lastLocationTime > this.location_expiration) {
                this.lastAddress = null;
            }
            if (this.lastAddress != null && !z && ((z2 && this.mLastAddressIsAccuracy) || !z2)) {
                if (locationCallBack != null) {
                    locationCallBack.onLocationGeted(0, "", this.lastAddress);
                }
                return this.lastAddress;
            }
            if (locationCallBack != null) {
                synchronized (this.mLocationCallBacks) {
                    int i = 0;
                    while (true) {
                        if (i < this.mLocationCallBacks.size()) {
                            SoftReference<LocationCallBack> softReference = this.mLocationCallBacks.get(i);
                            if (softReference != null && (locationCallBack2 = softReference.get()) != null && locationCallBack2.equals(locationCallBack)) {
                                z3 = true;
                                break;
                            }
                            i++;
                        } else {
                            z3 = false;
                            break;
                        }
                    }
                    if (!z3) {
                        if (this.mLocationCallBacks.size() >= 100) {
                            this.mLocationCallBacks.remove(0);
                        }
                        this.mLocationCallBacks.add(new SoftReference<>(locationCallBack));
                    }
                }
                boolean z4 = this.mIsExecLocationTask;
                if (!z4) {
                    startLocationServer(z2);
                    return null;
                } else if (z4 && z2 && !this.mCurrentLocationIsAccurcy) {
                    stopLocationServer();
                    startLocationServer(z2);
                    return null;
                }
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public void removeLocationCallback(LocationCallBack locationCallBack) {
        LocationCallBack locationCallBack2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, locationCallBack) == null) {
            synchronized (this.mLocationCallBacks) {
                int i = 0;
                while (true) {
                    if (i < this.mLocationCallBacks.size()) {
                        SoftReference<LocationCallBack> softReference = this.mLocationCallBacks.get(i);
                        if (softReference != null && (locationCallBack2 = softReference.get()) != null && locationCallBack2.equals(locationCallBack)) {
                            this.mLocationCallBacks.remove(softReference);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
