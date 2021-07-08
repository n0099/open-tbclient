package com.baidu.fsg.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class BaiduRIM {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String METHODNAME_FOR_GET_TOKEN = "getRimToken";
    public static final String METHODNAME_FOR_LBS_VERIFY = "LBSVerify";
    public static final String METHODNAME_FOR_RISKSEARCH = "riskSearch";
    public static final String METHODNMAE_FOR_FACERECOGNATION = "startLivenessRecognize";
    public static final String METHODNMAE_FOR_RECONGNIZE_BANKCARD = "reconginzeBankcard";
    public static final String METHODNMAE_FOR_RECONGNIZE_IDCARD = "reconginzeIdCard";
    public static final String[] ROUTER_ENTRANCES;
    public static final String TAG = "BaiduRIM";
    public static BaiduRIM mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-683856024, "Lcom/baidu/fsg/api/BaiduRIM;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-683856024, "Lcom/baidu/fsg/api/BaiduRIM;");
                return;
            }
        }
        ROUTER_ENTRANCES = new String[]{"com.baidu.fsg.ocr.idcard.router.OCRIdcardApplicationLogic", "com.baidu.fsg.ocr.bankcard.router.OCRBankcardApplicationLogic", "com.baidu.fsg.face.liveness.livenessrouter.LivenessApplicationLogic", "com.baidu.fsg.rim.riskmanager.router.RMApplicationLogic", "com.baidu.fsg.sec.router.SecApplicationLogic", "com.baidu.fsg.rim.lbsverify.router.LBSVerifyApplicationLogic", "com.baidu.fsg.rim.rimtoken.router.RimTokenApplicationLogic", "com.baidu.fsg.sec2.router.SecApplicationLogic"};
    }

    public BaiduRIM() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BaiduRIM getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (BaiduRIM.class) {
                    mInstance = new BaiduRIM();
                }
            }
            return mInstance;
        }
        return (BaiduRIM) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: com.baidu.fsg.base.router.RouterManager */
    /* JADX WARN: Multi-variable type inference failed */
    private void initRounter(Context context, HashMap<String, Object> hashMap) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, context, hashMap) == null) || context == null) {
            return;
        }
        for (String str : ROUTER_ENTRANCES) {
            try {
                RouterManager.getInstance().registerApplicationLogic(Class.forName(str));
            } catch (Throwable th) {
                LogUtil.e(TAG, str + " not found", th);
            }
        }
        RouterManager.getInstance().init(context.getApplicationContext(), hashMap);
    }

    public void accessRimService(Context context, Map<String, Object> map, RimServiceCallback rimServiceCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, map, rimServiceCallback) == null) || context == null || map == null) {
            return;
        }
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
            if (TextUtils.isEmpty(obj2)) {
                return;
            }
            RouterManager.getInstance().route(context.getApplicationContext(), new RouterRequest().action(obj2).data((HashMap) map), new RouterCallback(this, rimServiceCallback) { // from class: com.baidu.fsg.api.BaiduRIM.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaiduRIM this$0;
                public final /* synthetic */ RimServiceCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, rimServiceCallback};
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
                    this.val$callback = rimServiceCallback;
                }

                @Override // com.baidu.fsg.base.router.RouterCallback
                public void onResult(int i2, HashMap hashMap2) {
                    RimServiceCallback rimServiceCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) || (rimServiceCallback2 = this.val$callback) == null) {
                        return;
                    }
                    rimServiceCallback2.onResult(i2, hashMap2);
                }
            });
        }
    }

    public void initRIM(Context context, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap) == null) || context == null || hashMap == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        ResUtils.setApplicationContext(applicationContext);
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
