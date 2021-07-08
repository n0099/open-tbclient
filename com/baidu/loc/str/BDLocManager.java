package com.baidu.loc.str;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
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
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes2.dex */
public class BDLocManager implements Debug {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "loc tiny String";
    public static final long WIFI_SCAN_SPAN_MIN = 10000;
    public static char[] alphabet;
    public static BDLocManager instance;
    public static Object lock;
    public static Class<?> mCdmaClass;
    public transient /* synthetic */ FieldHolder $fh;
    public int connecetWifiLevel;
    public String connectWifi;
    public BDCellInfo mCellInfo;
    public CellStateListener mCellListener;
    public Context mContext;
    public String mExtraInfo;
    public long mScanTime;
    public TelephonyManager mTeleman;
    public WifiList mWifiList;
    public WifiManager mWifiman;
    public long time;

    /* renamed from: com.baidu.loc.str.BDLocManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class BDCellInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCid;
        public int mLac;
        public int mMcc;
        public int mMnc;
        public char mNetworkType;
        public final /* synthetic */ BDLocManager this$0;

        public BDCellInfo(BDLocManager bDLocManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDLocManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDLocManager;
            this.mLac = -1;
            this.mCid = -1;
            this.mMcc = -1;
            this.mMnc = -1;
            this.mNetworkType = (char) 0;
        }

        public /* synthetic */ BDCellInfo(BDLocManager bDLocManager, AnonymousClass1 anonymousClass1) {
            this(bDLocManager);
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
    }

    /* loaded from: classes2.dex */
    public class CellStateListener extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BDLocManager this$0;

        public CellStateListener(BDLocManager bDLocManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDLocManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDLocManager;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cellLocation) == null) || cellLocation == null) {
                return;
            }
            try {
                this.this$0.setCellInfo(cellLocation);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class WifiList {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BDLocManager this$0;
        public List<ScanResult> wifiList;
        public long wifiTime;

        public WifiList(BDLocManager bDLocManager, List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDLocManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDLocManager;
            this.wifiList = null;
            this.wifiTime = 0L;
            this.wifiList = list;
            this.wifiTime = System.currentTimeMillis();
            sort();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean needToFresh() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                long currentTimeMillis = System.currentTimeMillis() - this.wifiTime;
                return currentTimeMillis < 0 || currentTimeMillis > 500;
            }
            return invokeV.booleanValue;
        }

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        private void sort() {
            /*
                r7 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.loc.str.BDLocManager.WifiList.$ic
                if (r0 != 0) goto L52
            L4:
                int r0 = r7.size()
                r1 = 1
                if (r0 >= r1) goto Lc
                return
            Lc:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.wifiList
                int r0 = r0.size()
                int r0 = r0 - r1
                r2 = 1
            L14:
                if (r0 < r1) goto L51
                if (r2 == 0) goto L51
                r2 = 0
                r3 = 0
            L1a:
                if (r2 >= r0) goto L4d
                java.util.List<android.net.wifi.ScanResult> r4 = r7.wifiList
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r5 = r7.wifiList
                int r6 = r2 + 1
                java.lang.Object r5 = r5.get(r6)
                android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
                int r5 = r5.level
                if (r4 >= r5) goto L4b
                java.util.List<android.net.wifi.ScanResult> r3 = r7.wifiList
                java.lang.Object r3 = r3.get(r6)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.wifiList
                java.lang.Object r5 = r4.get(r2)
                r4.set(r6, r5)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.wifiList
                r4.set(r2, r3)
                r3 = 1
            L4b:
                r2 = r6
                goto L1a
            L4d:
                int r0 = r0 + (-1)
                r2 = r3
                goto L14
            L51:
                return
            L52:
                r5 = r0
                r6 = 65539(0x10003, float:9.184E-41)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r5.invokeV(r6, r7)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.loc.str.BDLocManager.WifiList.sort():void");
        }

        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<ScanResult> list = this.wifiList;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public String toString(int i2) {
            InterceptResult invokeI;
            int i3;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (size() < 1) {
                    return null;
                }
                boolean hasConnectWifi = this.this$0.hasConnectWifi();
                if (hasConnectWifi) {
                    i3 = i2 - 1;
                    z = false;
                } else {
                    i3 = i2;
                    z = true;
                }
                StringBuffer stringBuffer = new StringBuffer(512);
                int size = this.wifiList.size();
                int i4 = 0;
                boolean z2 = true;
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.wifiList.get(i5).level != 0) {
                        String str = this.wifiList.get(i5).BSSID;
                        int i6 = this.wifiList.get(i5).level;
                        String replace = str.replace(":", "");
                        if (this.this$0.connectWifi == null || !replace.equals(this.this$0.connectWifi)) {
                            if (i4 < i3) {
                                stringBuffer.append("h");
                                stringBuffer.append(replace);
                                stringBuffer.append("m");
                                stringBuffer.append(StrictMath.abs(i6));
                                i4++;
                                z2 = false;
                            }
                            if (i4 > i3 && z) {
                                break;
                            }
                        } else {
                            this.this$0.connecetWifiLevel = StrictMath.abs(i6);
                            z = true;
                        }
                    }
                }
                String str2 = hasConnectWifi ? "h" + this.this$0.connectWifi + "km" + this.this$0.connecetWifiLevel : null;
                if (z2) {
                    return str2;
                }
                return str2 + stringBuffer.toString();
            }
            return (String) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-600608463, "Lcom/baidu/loc/str/BDLocManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-600608463, "Lcom/baidu/loc/str/BDLocManager;");
                return;
            }
        }
        lock = new Object();
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    }

    public BDLocManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mTeleman = null;
        this.mCellListener = null;
        this.mCellInfo = new BDCellInfo(this, null);
        this.mWifiman = null;
        this.mWifiList = null;
        this.mScanTime = 0L;
        this.connectWifi = null;
        this.connecetWifiLevel = 0;
        this.mExtraInfo = null;
        this.time = System.currentTimeMillis();
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        String packageName = applicationContext.getPackageName();
        try {
            this.mTeleman = (TelephonyManager) this.mContext.getSystemService("phone");
            CellStateListener cellStateListener = new CellStateListener(this);
            this.mCellListener = cellStateListener;
            this.mTeleman.listen(cellStateListener, 16);
        } catch (Exception unused) {
        }
        this.mExtraInfo = "&" + packageName + "&" + ((String) null);
        this.mWifiman = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
    }

    public static String data2Base64(byte[] bArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba A[Catch: Exception -> 0x00ea, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ea, blocks: (B:21:0x00b6, B:23:0x00ba), top: B:30:0x00b6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BDCellInfo getBDCellInfo(CellInfo cellInfo) {
        InterceptResult invokeL;
        int ci;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cellInfo)) == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if (intValue < 17) {
                return null;
            }
            BDCellInfo bDCellInfo = new BDCellInfo(this, null);
            boolean z = false;
            if (!(cellInfo instanceof CellInfoGsm)) {
                if (!(cellInfo instanceof CellInfoCdma)) {
                    if (cellInfo instanceof CellInfoLte) {
                        CellIdentityLte cellIdentity = ((CellInfoLte) cellInfo).getCellIdentity();
                        bDCellInfo.mMcc = getValidValue(cellIdentity.getMcc());
                        bDCellInfo.mMnc = getValidValue(cellIdentity.getMnc());
                        bDCellInfo.mLac = getValidValue(cellIdentity.getTac());
                        ci = cellIdentity.getCi();
                    }
                    if (intValue >= 18) {
                        if (cellInfo instanceof CellInfoWcdma) {
                        }
                    }
                    return bDCellInfo;
                }
                CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                bDCellInfo.mMnc = getValidValue(cellIdentity2.getSystemId());
                bDCellInfo.mLac = getValidValue(cellIdentity2.getNetworkId());
                bDCellInfo.mCid = getValidValue(cellIdentity2.getBasestationId());
                bDCellInfo.mNetworkType = 'w';
                z = true;
                if (intValue >= 18 && !z) {
                    try {
                        if (cellInfo instanceof CellInfoWcdma) {
                            CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            bDCellInfo.mMcc = getValidValue(cellIdentity3.getMcc());
                            bDCellInfo.mMnc = getValidValue(cellIdentity3.getMnc());
                            bDCellInfo.mLac = getValidValue(cellIdentity3.getLac());
                            bDCellInfo.mCid = getValidValue(cellIdentity3.getCid());
                            bDCellInfo.mNetworkType = 'g';
                        }
                    } catch (Exception unused) {
                    }
                }
                return bDCellInfo;
            }
            CellIdentityGsm cellIdentity4 = ((CellInfoGsm) cellInfo).getCellIdentity();
            bDCellInfo.mMcc = getValidValue(cellIdentity4.getMcc());
            bDCellInfo.mMnc = getValidValue(cellIdentity4.getMnc());
            bDCellInfo.mLac = getValidValue(cellIdentity4.getLac());
            ci = cellIdentity4.getCid();
            bDCellInfo.mCid = getValidValue(ci);
            bDCellInfo.mNetworkType = 'g';
            z = true;
            if (intValue >= 18) {
            }
            return bDCellInfo;
        }
        return (BDCellInfo) invokeL.objValue;
    }

    public static BDLocManager getInstance(Context context) {
        InterceptResult invokeL;
        BDLocManager bDLocManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new BDLocManager(context);
                }
                bDLocManager = instance;
            }
            return bDLocManager;
        }
        return (BDLocManager) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:3|(1:5)|6|(2:7|8)|(10:10|11|(1:13)|14|15|(1:29)|19|(1:21)|22|(1:24)(2:26|27))|32|11|(0)|14|15|(1:17)|29|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocStringData(int i2) {
        InterceptResult invokeI;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65547, this, i2)) != null) {
            return (String) invokeI.objValue;
        }
        this.time = System.currentTimeMillis();
        if (i2 < 3) {
            i2 = 3;
        }
        if (this.mCellInfo != null) {
            str = this.mCellInfo.toCellString();
            if (str == null) {
                str = "Z";
            }
            if (this.mWifiList != null || this.mWifiList.needToFresh()) {
                this.mWifiList = new WifiList(this, this.mWifiman.getScanResults());
            }
            str2 = this.mWifiList.toString(i2);
            if (str2 != null) {
                str = str + str2;
            }
            if (str.equals("Z")) {
                return encode(str + "t" + System.currentTimeMillis() + this.mExtraInfo) + "|qloc2";
            }
            return null;
        }
        str = null;
        if (str == null) {
        }
        if (this.mWifiList != null) {
        }
        this.mWifiList = new WifiList(this, this.mWifiman.getScanResults());
        str2 = this.mWifiList.toString(i2);
        if (str2 != null) {
        }
        if (str.equals("Z")) {
        }
    }

    private BDCellInfo getRegisteredBDCellInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
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
                    try {
                        if (cellInfo.isRegistered() && (bDCellInfo = getBDCellInfo(cellInfo)) != null) {
                            if (bDCellInfo.isValid()) {
                                return bDCellInfo;
                            }
                            return null;
                        }
                    } catch (Exception unused) {
                    }
                }
                return bDCellInfo;
            } catch (Exception | NoSuchMethodError unused2) {
                return null;
            }
        }
        return (BDCellInfo) invokeV.objValue;
    }

    private int getValidValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) {
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasConnectWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            this.connectWifi = null;
            this.connecetWifiLevel = 0;
            WifiInfo connectionInfo = this.mWifiman.getConnectionInfo();
            if (connectionInfo == null) {
                return false;
            }
            try {
                String bssid = connectionInfo.getBSSID();
                String replace = bssid != null ? bssid.replace(":", "") : null;
                if (replace != null && replace.length() == 12) {
                    this.connectWifi = new String(replace);
                    return true;
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCellInfo(CellLocation cellLocation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, cellLocation) == null) || cellLocation == null || this.mTeleman == null) {
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
            } catch (Exception unused) {
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
                    mCdmaClass = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    mCdmaClass = null;
                    return;
                }
            }
            Class<?> cls = mCdmaClass;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = -1;
                    }
                    bDCellInfo.mMnc = systemId;
                    bDCellInfo.mCid = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    bDCellInfo.mLac = ((CdmaCellLocation) cellLocation).getNetworkId();
                } catch (Exception unused3) {
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
            try {
                return getLocStringData(15);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getLocString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            try {
                return getLocStringData(i2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeI.objValue;
    }

    public boolean startWifiScan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mWifiman == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.mScanTime;
            if (currentTimeMillis > 10000 || currentTimeMillis < 0) {
                if (this.mWifiman.isWifiEnabled()) {
                    this.mWifiman.startScan();
                    this.mScanTime = System.currentTimeMillis();
                    return true;
                } else if (Build.VERSION.SDK_INT <= 17) {
                    this.mScanTime = 0L;
                    return false;
                } else {
                    try {
                        if (!this.mWifiman.isScanAlwaysAvailable()) {
                            this.mScanTime = 0L;
                            return false;
                        }
                        this.mWifiman.startScan();
                        this.mScanTime = System.currentTimeMillis();
                        return true;
                    } catch (Exception unused) {
                        this.mScanTime = 0L;
                        return false;
                    } catch (NoSuchMethodError unused2) {
                        this.mScanTime = 0L;
                        return false;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
