package com.baidu.fsg.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
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
/* loaded from: classes2.dex */
public class BaiduRIM {
    public static final String METHODNAME_FOR_GET_TOKEN = "getRimToken";
    public static final String METHODNAME_FOR_LBS_VERIFY = "LBSVerify";
    public static final String METHODNAME_FOR_RISKSEARCH = "riskSearch";
    public static final String METHODNMAE_FOR_FACERECOGNATION = "startLivenessRecognize";
    public static final String METHODNMAE_FOR_RECONGNIZE_BANKCARD = "reconginzeBankcard";
    public static final String METHODNMAE_FOR_RECONGNIZE_IDCARD = "reconginzeIdCard";
    private static final String[] ROUTER_ENTRANCES = {"com.baidu.fsg.ocr.idcard.router.OCRIdcardApplicationLogic", "com.baidu.fsg.ocr.bankcard.router.OCRBankcardApplicationLogic", "com.baidu.sapi2.biometrics.liveness.livenessrouter.LivenessApplicationLogic", "com.baidu.fsg.rim.riskmanager.router.RMApplicationLogic", "com.baidu.fsg.sec.router.SecApplicationLogic", "com.baidu.fsg.rim.lbsverify.router.LBSVerifyApplicationLogic", "com.baidu.fsg.rim.rimtoken.router.RimTokenApplicationLogic"};
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
            BeanConstants.CHANNEL_ID = "channel";
            BeanConstants.SDK_VERSION = "BDRIM-" + BeanConstants.VERSION_NO + "-Android-" + BeanConstants.CHANNEL_ID;
            if (hashMap.get(BaiduRimConstants.RIM_ID_KEY) != null) {
                ChannelUtils.initBussinessParams(BeanConstants.SDK_VERSION, false, hashMap.get(BaiduRimConstants.RIM_ID_KEY).toString());
            }
            ResUtils.setApplicationContext(this.mAppContext);
            initRounter(this.mAppContext, hashMap);
            BdWalletUtils.loadDeviceFP(this.mAppContext);
            RimStatisticsUtil.initStatisticsModule(this.mAppContext);
        }
    }

    public void accessRimService(Context context, Map<String, Object> map, final RimServiceCallback rimServiceCallback) {
        Object obj;
        if (context != null && map != null && (obj = map.get("method")) != null) {
            String obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                RouterManager.getInstance().route(context.getApplicationContext(), new RouterRequest().action(obj2).data((HashMap) map), new RouterCallback() { // from class: com.baidu.fsg.api.BaiduRIM.1
                    @Override // com.baidu.fsg.base.router.RouterCallback
                    public void onResult(int i, HashMap hashMap) {
                        if (rimServiceCallback != null) {
                            rimServiceCallback.onResult(i, hashMap);
                        }
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: com.baidu.fsg.base.router.RouterManager */
    /* JADX WARN: Multi-variable type inference failed */
    private void initRounter(Context context, HashMap<String, Object> hashMap) {
        if (context != null) {
            for (String str : ROUTER_ENTRANCES) {
                try {
                    RouterManager.getInstance().registerApplicationLogic(Class.forName(str));
                } catch (Throwable th) {
                    LogUtil.e(TAG, "ocr not found", th);
                }
            }
            RouterManager.getInstance().init(context.getApplicationContext(), hashMap);
        }
    }
}
