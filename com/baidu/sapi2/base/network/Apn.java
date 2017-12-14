package com.baidu.sapi2.base.network;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.utils.NetworkUtil;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes.dex */
public class Apn {
    public static final byte APN777 = 8;
    public static final String APN_3GNET = "3gnet";
    public static final String APN_3GWAP = "3gwap";
    public static final String APN_777 = "#777";
    public static final String APN_CMNET = "cmnet";
    public static final String APN_CMWAP = "cmwap";
    public static final String APN_CTNET = "ctnet";
    public static final String APN_CTWAP = "ctwap";
    public static final String APN_NET = "Net";
    public static final String APN_UNINET = "uninet";
    public static final String APN_UNIWAP = "uniwap";
    public static final String APN_UNKNOWN = "N/A";
    public static final String APN_WAP = "Wap";
    public static final String APN_WIFI = "Wlan";
    public static final byte CMNET = 1;
    public static final byte CMWAP = 0;
    public static final byte CTNET = 7;
    public static final byte CTWAP = 6;
    public static final int ENT_1xRTT = 11;
    public static final int ENT_CDMA = 8;
    public static final int ENT_EDGE = 3;
    public static final int ENT_EVDO_0 = 9;
    public static final int ENT_EVDO_A = 10;
    public static final int ENT_EVDO_B = 13;
    public static final int ENT_GPRS = 2;
    public static final int ENT_HSDPA = 5;
    public static final int ENT_HSPA = 7;
    public static final int ENT_HSPAPlus = 16;
    public static final int ENT_HSUPA = 6;
    public static final int ENT_LTE = 14;
    public static final int ENT_NONE = 0;
    public static final int ENT_UMTS = 4;
    public static final int ENT_UNKNOW = 17;
    public static final int ENT_WIFI = 1;
    public static final int ENT_eHRPD = 15;
    public static final int ENT_iDen = 12;
    public static final byte GNET = 3;
    public static final byte GWAP = 2;
    public static final byte NETWORK_2G = 1;
    public static final byte NETWORK_3G = 2;
    public static final byte NETWORK_DEFAULT = 0;
    public static final byte NETWORK_OTHER = 4;
    public static final byte NETWORK_WIFI = 3;
    private static final String PROXY_CTWAP = "10.0.0.200";
    public static final byte PROXY_TYPE_CM = 0;
    public static final byte PROXY_TYPE_CT = 1;
    private static final String TAG = "Apn";
    public static final int TYPE_NET = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WAP = 2;
    public static final int TYPE_WIFI = 4;
    public static final byte UNINET = 5;
    public static final byte UNIWAP = 4;
    public static final byte UNKNOWN = 9;
    public static int M_APN_TYPE = 4;
    public static String M_APN_PROXY = null;
    public static int M_APN_PORT = 80;
    public static byte M_PROXY_TYPE = 0;
    public static boolean M_USE_PROXY = false;
    public static boolean IS_INIT = false;
    public static byte NETWORK_TYPE = 4;
    public static String APN_NAME_DRI = "unknown";
    public static byte APN_NAME_VALUE = 9;
    public static int ENT_VALUE = 17;
    private static IOnChange mIOnChange = null;

    /* loaded from: classes.dex */
    public interface IOnChange {
        void onNetworkChange(byte b, int i, int i2, String str);
    }

    public static void checkInit(Context context) {
        if (!IS_INIT) {
            synchronized (Apn.class) {
                if (!IS_INIT) {
                    init(context);
                    IS_INIT = true;
                }
            }
        }
    }

    public static void setIOnChange(IOnChange iOnChange) {
        mIOnChange = iOnChange;
    }

    public static void handleChange(Context context) {
        IS_INIT = false;
        checkInit(context);
        Log.i(TAG, "handleChange() Apn.APN_NAME_VALUE: " + ((int) APN_NAME_VALUE) + " APN_NAME_DRI: " + APN_NAME_DRI);
    }

    public static void init(Context context) {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = NetworkUtil.getActiveNetworkInfo(context);
        } catch (NullPointerException e) {
            Log.w("getActiveNetworkInfo", " getActiveNetworkInfo NullPointerException--- \n" + e.getMessage());
            networkInfo = null;
        }
        Log.d(TAG, "networkInfo : " + networkInfo);
        int i = -1;
        try {
            M_APN_TYPE = 0;
            NETWORK_TYPE = (byte) 4;
            if (networkInfo != null) {
                i = networkInfo.getType();
                Log.d(TAG, "type: " + networkInfo.getType());
                Log.d(TAG, "typeName: " + networkInfo.getTypeName());
                str = networkInfo.getExtraInfo();
                if (str == null) {
                    M_APN_TYPE = 0;
                } else {
                    str = str.trim().toLowerCase();
                }
            }
            Log.d(TAG, "extraInfo : " + str);
            if (i == 1) {
                M_APN_TYPE = 4;
                M_USE_PROXY = false;
                NETWORK_TYPE = (byte) 3;
                APN_NAME_DRI = "unknown";
                APN_NAME_VALUE = (byte) 9;
            } else {
                handleApnNameDri(str);
                if (str == null) {
                    M_APN_TYPE = 0;
                } else if (str.contains(APN_CMWAP) || str.contains(APN_UNIWAP) || str.contains(APN_3GWAP) || str.contains(APN_CTWAP)) {
                    NETWORK_TYPE = (byte) 1;
                    if (str.contains(APN_3GWAP)) {
                        NETWORK_TYPE = (byte) 2;
                    }
                    M_APN_TYPE = 2;
                } else if (str.contains(APN_CMNET) || str.contains(APN_UNINET) || str.contains(APN_3GNET) || str.contains(APN_CTNET)) {
                    NETWORK_TYPE = (byte) 1;
                    M_APN_TYPE = 1;
                    if (str.contains(APN_3GNET) || str.contains(APN_CTNET)) {
                        NETWORK_TYPE = (byte) 2;
                    }
                } else if (str.contains(APN_777)) {
                    NETWORK_TYPE = (byte) 2;
                    M_APN_TYPE = 0;
                } else {
                    M_APN_TYPE = 0;
                }
                M_USE_PROXY = false;
                if (isProxyMode(M_APN_TYPE)) {
                    M_APN_PROXY = Proxy.getDefaultHost();
                    M_APN_PORT = Proxy.getDefaultPort();
                    if (M_APN_PROXY != null) {
                        M_APN_PROXY = M_APN_PROXY.trim();
                    }
                    if (M_APN_PROXY != null && !"".equals(M_APN_PROXY)) {
                        M_USE_PROXY = true;
                        M_APN_TYPE = 2;
                        if (PROXY_CTWAP.equals(M_APN_PROXY)) {
                            M_PROXY_TYPE = (byte) 1;
                        } else {
                            M_PROXY_TYPE = (byte) 0;
                        }
                    } else {
                        M_USE_PROXY = false;
                        M_APN_TYPE = 1;
                    }
                }
            }
            if (mIOnChange != null) {
                mIOnChange.onNetworkChange(NETWORK_TYPE, ENT_VALUE, APN_NAME_VALUE, APN_NAME_DRI);
            }
            Log.d(TAG, "NETWORK_TYPE : " + ((int) NETWORK_TYPE));
            Log.d(TAG, "M_APN_TYPE : " + M_APN_TYPE);
            Log.d(TAG, "M_USE_PROXY : " + M_USE_PROXY);
            Log.d(TAG, "M_APN_PROXY : " + M_APN_PROXY);
            Log.d(TAG, "M_APN_PORT : " + M_APN_PORT);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ENT_VALUE = getNetWorkType(context, networkInfo);
        Log.i(TAG, "init() Apn.APN_NAME_VALUE: " + ((int) APN_NAME_VALUE) + " APN_NAME_DRI: " + APN_NAME_DRI + " NETWORK_TYPE: " + ((int) NETWORK_TYPE) + " ENT_VALUE: " + ENT_VALUE);
    }

    private static boolean isProxyMode(int i) {
        return i == 2 || i == 0;
    }

    public static String getApnName(int i) {
        switch (i) {
            case 0:
                return APN_UNKNOWN;
            case 1:
                return APN_NET;
            case 2:
                return APN_WAP;
            case 3:
            default:
                return APN_UNKNOWN;
            case 4:
                return APN_WIFI;
        }
    }

    private static void handleApnNameDri(String str) {
        if (str != null) {
            if (str.contains(APN_CMWAP)) {
                APN_NAME_DRI = APN_CMWAP;
                APN_NAME_VALUE = (byte) 0;
            } else if (str.contains(APN_CMNET)) {
                APN_NAME_DRI = APN_CMNET;
                APN_NAME_VALUE = (byte) 1;
            } else if (str.contains(APN_3GWAP)) {
                APN_NAME_DRI = APN_3GWAP;
                APN_NAME_VALUE = (byte) 2;
            } else if (str.contains(APN_3GNET)) {
                APN_NAME_DRI = APN_3GNET;
                APN_NAME_VALUE = (byte) 3;
            } else if (str.contains(APN_UNIWAP)) {
                APN_NAME_DRI = APN_UNIWAP;
                APN_NAME_VALUE = (byte) 4;
            } else if (str.contains(APN_UNINET)) {
                APN_NAME_DRI = APN_UNINET;
                APN_NAME_VALUE = (byte) 5;
            } else if (str.contains(APN_CTWAP)) {
                APN_NAME_DRI = APN_CTWAP;
                APN_NAME_VALUE = (byte) 6;
            } else if (str.contains(APN_CTNET)) {
                APN_NAME_DRI = APN_CTNET;
                APN_NAME_VALUE = (byte) 7;
            } else if (str.contains(APN_777)) {
                APN_NAME_DRI = APN_777;
                APN_NAME_VALUE = (byte) 8;
            }
        }
    }

    private static int getNetWorkType(Context context, NetworkInfo networkInfo) {
        TelephonyManager telephonyManager;
        int i = 1;
        if (networkInfo == null) {
            return 0;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (1 != networkInfo.getType()) {
            if (networkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)) != null) {
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                        i = 2;
                        break;
                    case 2:
                        i = 3;
                        break;
                    case 3:
                        i = 4;
                        break;
                    case 4:
                        i = 8;
                        break;
                    case 5:
                        i = 9;
                        break;
                    case 6:
                        i = 10;
                        break;
                    case 7:
                        i = 11;
                        break;
                    case 8:
                        i = 5;
                        break;
                    case 9:
                        i = 6;
                        break;
                    case 10:
                        i = 7;
                        break;
                    default:
                        i = 17;
                        break;
                }
            }
            i = 0;
        }
        return i;
    }
}
