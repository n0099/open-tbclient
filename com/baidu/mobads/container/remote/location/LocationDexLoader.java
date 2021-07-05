package com.baidu.mobads.container.remote.location;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.PermissionUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes3.dex */
public class LocationDexLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "loc tiny String";
    public static final long WIFI_SCAN_SPAN_MIN = 10000;
    public static char[] alphabet;
    public static Class<?> mCdmaClass;
    public static Method mMethodCid;
    public static Method mMethodLac;
    public static Method mMethodSid;
    public transient /* synthetic */ FieldHolder $fh;
    public BDCellInfo mCellInfo;
    public String mExtraInfo;
    public TelephonyManager mTeleman;

    /* renamed from: com.baidu.mobads.container.remote.location.LocationDexLoader$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1705327350, "Lcom/baidu/mobads/container/remote/location/LocationDexLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1705327350, "Lcom/baidu/mobads/container/remote/location/LocationDexLoader;");
                return;
            }
        }
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    }

    public LocationDexLoader(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTeleman = null;
        this.mCellInfo = new BDCellInfo(this, null);
        this.mExtraInfo = null;
        if (context != null) {
            this.mExtraInfo = "&" + str + "&null";
            try {
                this.mTeleman = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
            }
        }
    }

    public static String data2Base64(byte[] bArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            char[] cArr = new char[((bArr.length + 2) / 3) * 4];
            int i2 = 0;
            int i3 = 0;
            while (i2 < bArr.length) {
                int i4 = (bArr[i2] & 255) << 8;
                int i5 = i2 + 1;
                boolean z2 = true;
                if (i5 < bArr.length) {
                    i4 |= bArr[i5] & 255;
                    z = true;
                } else {
                    z = false;
                }
                int i6 = i4 << 8;
                int i7 = i2 + 2;
                if (i7 < bArr.length) {
                    i6 |= bArr[i7] & 255;
                } else {
                    z2 = false;
                }
                int i8 = 64;
                cArr[i3 + 3] = alphabet[z2 ? 63 - (i6 & 63) : 64];
                int i9 = i6 >> 6;
                int i10 = i3 + 2;
                char[] cArr2 = alphabet;
                if (z) {
                    i8 = 63 - (i9 & 63);
                }
                cArr[i10] = cArr2[i8];
                int i11 = i9 >> 6;
                char[] cArr3 = alphabet;
                cArr[i3 + 1] = cArr3[63 - (i11 & 63)];
                cArr[i3 + 0] = cArr3[63 - ((i11 >> 6) & 63)];
                i2 += 3;
                i3 += 4;
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static String encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            byte[] bytes = str.getBytes();
            byte nextInt = (byte) new Random().nextInt(255);
            byte nextInt2 = (byte) new Random().nextInt(255);
            byte[] bArr = new byte[bytes.length + 2];
            int length = bytes.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                bArr[i3] = (byte) (bytes[i2] ^ nextInt);
                i2++;
                i3++;
            }
            bArr[i3] = nextInt;
            bArr[i3 + 1] = nextInt2;
            return data2Base64(bArr);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c2 A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #0 {Exception -> 0x00f3, blocks: (B:20:0x00be, B:22:0x00c2), top: B:31:0x00be }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BDCellInfo getBDCellInfo(CellInfo cellInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, cellInfo)) == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if (intValue < 17) {
                return null;
            }
            BDCellInfo bDCellInfo = new BDCellInfo(this, null);
            boolean z = false;
            if (cellInfo instanceof CellInfoGsm) {
                CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                bDCellInfo.mMcc = getValidValue(cellIdentity.getMcc());
                bDCellInfo.mMnc = getValidValue(cellIdentity.getMnc());
                bDCellInfo.mLac = getValidValue(cellIdentity.getLac());
                bDCellInfo.mCid = getValidValue(cellIdentity.getCid());
                bDCellInfo.mNetworkType = 'g';
            } else if (cellInfo instanceof CellInfoCdma) {
                CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                bDCellInfo.mMnc = getValidValue(cellIdentity2.getSystemId());
                bDCellInfo.mLac = getValidValue(cellIdentity2.getNetworkId());
                bDCellInfo.mCid = getValidValue(cellIdentity2.getBasestationId());
                bDCellInfo.mNetworkType = 'w';
            } else {
                if (cellInfo instanceof CellInfoLte) {
                    CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                    bDCellInfo.mMcc = getValidValue(cellIdentity3.getMcc());
                    bDCellInfo.mMnc = getValidValue(cellIdentity3.getMnc());
                    bDCellInfo.mLac = getValidValue(cellIdentity3.getTac());
                    bDCellInfo.mCid = getValidValue(cellIdentity3.getCi());
                    bDCellInfo.mNetworkType = 'g';
                }
                if (intValue >= 18 && !z) {
                    try {
                        if (cellInfo instanceof CellInfoWcdma) {
                            CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            bDCellInfo.mMcc = getValidValue(cellIdentity4.getMcc());
                            bDCellInfo.mMnc = getValidValue(cellIdentity4.getMnc());
                            bDCellInfo.mLac = getValidValue(cellIdentity4.getLac());
                            bDCellInfo.mCid = getValidValue(cellIdentity4.getCid());
                            bDCellInfo.mNetworkType = 'g';
                        }
                    } catch (Exception e2) {
                        RemoteXAdLogger.getInstance().d(e2.getMessage());
                    }
                }
                return bDCellInfo;
            }
            z = true;
            if (intValue >= 18) {
                if (cellInfo instanceof CellInfoWcdma) {
                }
            }
            return bDCellInfo;
        }
        return (BDCellInfo) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocStringData(int i2) {
        InterceptResult invokeI;
        String str;
        BDCellInfo registeredBDCellInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) != null) {
            return (String) invokeI.objValue;
        }
        try {
            registeredBDCellInfo = getRegisteredBDCellInfo();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2.getMessage());
            str = null;
        }
        if (registeredBDCellInfo != null && registeredBDCellInfo.isValid()) {
            RemoteXAdLogger.getInstance().d("new cell api is valid = " + registeredBDCellInfo.toCellString());
            this.mCellInfo = registeredBDCellInfo;
            str = this.mCellInfo.toCellString();
            if (str == null) {
                RemoteXAdLogger.getInstance().d("cell info = null");
                str = "Z";
            }
            if (str.equals("Z")) {
                return encode(str + "t" + System.currentTimeMillis() + this.mExtraInfo);
            }
            return null;
        }
        setCellInfo(this.mTeleman.getCellLocation());
        str = this.mCellInfo.toCellString();
        if (str == null) {
        }
        if (str.equals("Z")) {
        }
    }

    private BDCellInfo getRegisteredBDCellInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
                return null;
            }
            try {
                List<CellInfo> allCellInfo = this.mTeleman.getAllCellInfo();
                if (allCellInfo == null || allCellInfo.size() <= 0) {
                    return null;
                }
                BDCellInfo bDCellInfo = null;
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo.isRegistered() && (bDCellInfo = getBDCellInfo(cellInfo)) != null) {
                        if (bDCellInfo.isValid()) {
                            return bDCellInfo;
                        }
                        return null;
                    }
                }
                return bDCellInfo;
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th.getMessage());
                return null;
            }
        }
        return (BDCellInfo) invokeV.objValue;
    }

    private int getValidValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    private void setCellInfo(CellLocation cellLocation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, cellLocation) == null) || cellLocation == null || this.mTeleman == null) {
            return;
        }
        BDCellInfo bDCellInfo = new BDCellInfo(this, null);
        String networkOperator = this.mTeleman.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.mCellInfo.mMcc;
                    }
                    bDCellInfo.mMcc = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i2 = 0;
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i2)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.mCellInfo.mMnc;
                    }
                    bDCellInfo.mMnc = intValue2;
                }
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            bDCellInfo.mLac = gsmCellLocation.getLac();
            bDCellInfo.mCid = gsmCellLocation.getCid();
            bDCellInfo.mNetworkType = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            bDCellInfo.mNetworkType = 'w';
            if (mCdmaClass == null) {
                try {
                    Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    mCdmaClass = cls;
                    mMethodCid = cls.getMethod("getBaseStationId", new Class[0]);
                    mMethodLac = mCdmaClass.getMethod("getNetworkId", new Class[0]);
                    mMethodSid = mCdmaClass.getMethod("getSystemId", new Class[0]);
                } catch (Exception unused) {
                    mCdmaClass = null;
                    return;
                }
            }
            Class<?> cls2 = mCdmaClass;
            if (cls2 != null && cls2.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) mMethodSid.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.mCellInfo.mMnc;
                    }
                    bDCellInfo.mMnc = intValue3;
                    bDCellInfo.mCid = ((Integer) mMethodCid.invoke(cellLocation, new Object[0])).intValue();
                    bDCellInfo.mLac = ((Integer) mMethodLac.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception unused2) {
                    return;
                }
            }
        }
        if (bDCellInfo.isValid()) {
            this.mCellInfo = bDCellInfo;
        }
    }

    public String getLocString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (PermissionUtils.hasPermission("permission_location")) {
                try {
                    return getLocStringData(10);
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d(e2.getMessage());
                    return null;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class BDCellInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCid;
        public int mLac;
        public int mMcc;
        public int mMnc;
        public char mNetworkType;
        public final /* synthetic */ LocationDexLoader this$0;

        public BDCellInfo(LocationDexLoader locationDexLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationDexLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = locationDexLoader;
            this.mLac = -1;
            this.mCid = -1;
            this.mMcc = -1;
            this.mMnc = -1;
            this.mNetworkType = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.mLac > -1 && this.mCid > 0 : invokeV.booleanValue;
        }

        public String toCellString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (isValid()) {
                    StringBuffer stringBuffer = new StringBuffer(128);
                    stringBuffer.append(this.mNetworkType);
                    stringBuffer.append("h");
                    int i2 = this.mMcc;
                    if (i2 != 460) {
                        stringBuffer.append(i2);
                    }
                    stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.mMnc), Integer.valueOf(this.mLac), Integer.valueOf(this.mCid)));
                    return stringBuffer.toString();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ BDCellInfo(LocationDexLoader locationDexLoader, AnonymousClass1 anonymousClass1) {
            this(locationDexLoader);
        }
    }
}
