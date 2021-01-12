package com.baidu.fsg.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.fsg.base.c;
import com.baidu.fsg.base.restnet.beans.business.BeanConstants;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.fsg.base.router.RouterManager;
import com.baidu.fsg.base.router.RouterRequest;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.ChannelUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class BaiduRIM {
    public static final String METHODNAME_FOR_GET_TOKEN = "getRimToken";
    public static final String METHODNAME_FOR_LBS_VERIFY = "LBSVerify";
    public static final String METHODNAME_FOR_RISKSEARCH = "riskSearch";
    public static final String METHODNMAE_FOR_FACERECOGNATION = "startLivenessRecognize";
    public static final String METHODNMAE_FOR_RECONGNIZE_BANKCARD = "reconginzeBankcard";
    public static final String METHODNMAE_FOR_RECONGNIZE_IDCARD = "reconginzeIdCard";
    private static final String[] ROUTER_ENTRANCES = {"com.baidu.fsg.ocr.idcard.router.OCRIdcardApplicationLogic", "com.baidu.fsg.ocr.bankcard.router.OCRBankcardApplicationLogic", "com.baidu.fsg.face.liveness.livenessrouter.LivenessApplicationLogic", "com.baidu.fsg.rim.riskmanager.router.RMApplicationLogic", "com.baidu.fsg.sec.router.SecApplicationLogic", "com.baidu.fsg.rim.lbsverify.router.LBSVerifyApplicationLogic", "com.baidu.fsg.rim.rimtoken.router.RimTokenApplicationLogic", "com.baidu.fsg.sec2.router.SecApplicationLogic"};
    static final String TAG = BaiduRIM.class.getSimpleName();
    private static BaiduRIM mInstance;
    private Context mAppContext;

    private BaiduRIM() {
    }

    public static BaiduRIM getInstance() {
        if (mInstance == null) {
            synchronized (BaiduRIM.class) {
                mInstance = new BaiduRIM();
            }
        }
        return mInstance;
    }

    public void initRIM(Context context, HashMap<String, Object> hashMap) {
        if (context != null && hashMap != null) {
            this.mAppContext = context.getApplicationContext();
            ResUtils.setApplicationContext(this.mAppContext);
            initRounter(this.mAppContext, hashMap);
            RimStatisticsUtil.initStatisticsModule(this.mAppContext);
            String str = (String) hashMap.get(BaiduRimConstants.RIM_ID_KEY);
            if (!TextUtils.isEmpty(str)) {
                BeanConstants.CHANNEL_ID = str;
                BeanConstants.RIMID = str;
            } else {
                BeanConstants.CHANNEL_ID = "channel";
            }
            if (hashMap.get("animstyle") != null) {
                BeanConstants.ANIMSTYLE = (String) hashMap.get("animstyle");
            }
            c.b().initEnv();
            BeanConstants.SDK_VERSION = "BDRIM-" + BeanConstants.VERSION_NO + "-Android-" + BeanConstants.CHANNEL_ID;
            if (hashMap.get(BaiduRimConstants.RIM_ID_KEY) != null) {
                ChannelUtils.initBussinessParams(BeanConstants.SDK_VERSION, false, hashMap.get(BaiduRimConstants.RIM_ID_KEY).toString());
            }
        }
    }

    public void accessRimService(Context context, Map<String, Object> map, final RimServiceCallback rimServiceCallback) {
        if (context != null && map != null) {
            if (!BdWalletUtils.isSpnoValidate(map) && rimServiceCallback != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(BaiduRimConstants.RETCODE_KEY, "-32");
                hashMap.put("retMsg", BeanConstants.ERROR_MSG_SPNO_INVALIDATE);
                rimServiceCallback.onResult(-32, hashMap);
                return;
            }
            BdWalletUtils.loadDeviceFP(context, map);
            Object obj = map.get("method");
            if (obj != null) {
                String obj2 = obj.toString();
                if (!TextUtils.isEmpty(obj2)) {
                    RouterManager.getInstance().route(context.getApplicationContext(), new RouterRequest().action(obj2).data((HashMap) map), new RouterCallback() { // from class: com.baidu.fsg.api.BaiduRIM.1
                        @Override // com.baidu.fsg.base.router.RouterCallback
                        public void onResult(int i, HashMap hashMap2) {
                            if (rimServiceCallback != null) {
                                rimServiceCallback.onResult(i, hashMap2);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.baidu.fsg.base.router.RouterManager */
    /* JADX WARN: Multi-variable type inference failed */
    private void initRounter(Context context, HashMap<String, Object> hashMap) {
        String[] strArr;
        if (context != null) {
            for (String str : ROUTER_ENTRANCES) {
                try {
                    RouterManager.getInstance().registerApplicationLogic(Class.forName(str));
                } catch (Throwable th) {
                    LogUtil.e(TAG, str + " not found", th);
                }
            }
            RouterManager.getInstance().init(context.getApplicationContext(), hashMap);
        }
    }
}
