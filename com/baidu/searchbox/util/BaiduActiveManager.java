package com.baidu.searchbox.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.PkgUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.ar.constants.DebugConstants;
import com.baidu.searchbox.active.data.ActiveTimeInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.tieba.a30;
import com.baidu.tieba.z10;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.codec.binary4util.bdapp.Base64;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class BaiduActiveManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVE_DEVICE_BEHAVIOR_PURPOSE = "active";
    public static final String BASIC_DEVICE_BEHAVIOR_SCENE = "basic";
    public static final String CLONE_CUID = "clncuid";
    public static final boolean DEBUG;
    public static final String KEY_ACTIVE = "active";
    public static final String KEY_ACTIVE_REQUEST_TIME = "active_request_time";
    public static final String KEY_ACTIVE_TIME = "active_succ_time";
    public static final String KEY_TIME = "time";
    public static final String KEY_TIME_STAMP = "time_stamp";
    public static final String POST_REQUEST_KEY = "data";
    public static final String PREFS_NAME = "identity";
    public static final String RAND_ID = "randid";
    public static final int RESPONSE_CODE_DEFAULT = -1;
    public static final String TAG = "BaiduActiveManager";
    public static final String WARM_TIPS_SP_NAME = "com.baidu.searchbox.warmtips";
    public static volatile boolean mStartRequest;
    public static BaiduActiveManager sActiveManager;
    public transient /* synthetic */ FieldHolder $fh;
    public String mClnCuid;
    public String mConfirmExt;
    public String mConfirmSource;
    public Context mContext;
    public IBaiduIdentityContext mIdentityContextImpl;
    public String mInvokeSource;
    public String mLauncherExt;
    public String mLauncherSource;
    public String mOriginalLauncherExt;
    public SharedPreferences mSettings;

    /* loaded from: classes3.dex */
    public static final class ActiveTimeParser {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "ActiveTimeParser";
        public static ActiveTimeParser mParser;
        public transient /* synthetic */ FieldHolder $fh;
        public DocumentBuilder mDocumentBuilder;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-459643260, "Lcom/baidu/searchbox/util/BaiduActiveManager$ActiveTimeParser;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-459643260, "Lcom/baidu/searchbox/util/BaiduActiveManager$ActiveTimeParser;");
            }
        }

        public ActiveTimeParser() {
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
            this.mDocumentBuilder = null;
            init();
        }

        public static ActiveTimeParser getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (mParser == null) {
                    mParser = new ActiveTimeParser();
                }
                return mParser;
            }
            return (ActiveTimeParser) invokeV.objValue;
        }

        private void init() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                try {
                    this.mDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                } catch (ParserConfigurationException unused) {
                    if (BaiduActiveManager.DEBUG) {
                        Log.w(TAG, "ParserConfigurationException");
                    }
                }
            }
        }

        public String[] parse(InputStream inputStream) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStream)) == null) {
                String str2 = "0";
                if (inputStream == null) {
                    return null;
                }
                try {
                    Document parse = this.mDocumentBuilder.parse(inputStream);
                    Node namedItem = parse.getElementsByTagName("appcommand").item(0).getAttributes().getNamedItem("time");
                    if (namedItem == null) {
                        str = "0";
                    } else {
                        str = namedItem.getNodeValue();
                    }
                    try {
                        Node item = parse.getElementsByTagName("timestamp").item(0);
                        if (item != null) {
                            str2 = item.getFirstChild().getNodeValue();
                        }
                    } catch (IOException unused) {
                        Log.w(TAG, "IOException");
                        return new String[]{str2, str};
                    } catch (SAXException unused2) {
                        Log.w(TAG, "SAXException");
                        return new String[]{str2, str};
                    } catch (Exception unused3) {
                        Log.w(TAG, "getDingFromXml-method-exception");
                        return new String[]{str2, str};
                    }
                } catch (IOException unused4) {
                    str = "0";
                } catch (SAXException unused5) {
                    str = "0";
                } catch (Exception unused6) {
                    str = "0";
                }
                return new String[]{str2, str};
            }
            return (String[]) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-533767780, "Lcom/baidu/searchbox/util/BaiduActiveManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-533767780, "Lcom/baidu/searchbox/util/BaiduActiveManager;");
                return;
            }
        }
        DEBUG = LibBLCConfig.GLOBAL_DEBUG;
        mStartRequest = false;
    }

    public static String getActiveUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return String.format("%s/searchbox?action=active", HostConfig.getSearchboxHostForHttps());
        }
        return (String) invokeV.objValue;
    }

    public static synchronized BaiduActiveManager getInstance() {
        InterceptResult invokeV;
        BaiduActiveManager baiduActiveManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (BaiduActiveManager.class) {
                if (sActiveManager == null) {
                    sActiveManager = new BaiduActiveManager(AppRuntime.getAppContext());
                }
                baiduActiveManager = sActiveManager;
            }
            return baiduActiveManager;
        }
        return (BaiduActiveManager) invokeV.objValue;
    }

    private String getRandId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            return new SharedPrefsWrapper(WARM_TIPS_SP_NAME).getString(RAND_ID, "");
        }
        return (String) invokeV.objValue;
    }

    private boolean isNeedUploadCloneCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            if (TextUtils.isEmpty(this.mClnCuid)) {
                return false;
            }
            if (TextUtils.equals(this.mClnCuid, this.mSettings.getString(CLONE_CUID, ""))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public long getActiveSuccTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SharedPreferences sharedPreferences = this.mSettings;
            if (sharedPreferences == null) {
                return 0L;
            }
            return sharedPreferences.getLong(KEY_ACTIVE_TIME, 0L);
        }
        return invokeV.longValue;
    }

    public String getActiveTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPreferences sharedPreferences = this.mSettings;
            String str = "0";
            if (sharedPreferences != null) {
                str = sharedPreferences.getString("time", "0");
            }
            try {
                return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean isActiveSucc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SharedPreferences sharedPreferences = this.mSettings;
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean("active", false);
        }
        return invokeV.booleanValue;
    }

    public BaiduActiveManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInvokeSource = null;
        this.mLauncherSource = null;
        this.mLauncherExt = null;
        this.mOriginalLauncherExt = null;
        this.mConfirmSource = null;
        this.mConfirmExt = null;
        this.mClnCuid = null;
        init(context);
    }

    private String encrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            try {
                return URLEncoder.encode(new String(Base64.encode(this.mIdentityContextImpl.encryptByNativeBds(BaiduIdentityManager.getInstance().getUid(), str), 0)), IMAudioTransRequest.CHARSET);
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e(TAG, "encrypt error!", e);
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, context) == null) {
            this.mContext = context;
            this.mSettings = context.getSharedPreferences("identity", 0);
            this.mIdentityContextImpl = BaiduIdentityRuntime.getBaiduIdentityContext();
        }
    }

    public void setInvokeSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mInvokeSource = str;
        }
    }

    public void setLauncherSource(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
            this.mLauncherSource = str;
            this.mLauncherExt = str2;
            this.mOriginalLauncherExt = str3;
        }
    }

    private String encode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = str2;
            }
            return new String(Base64Encoder.B64Encode(str.getBytes()));
        }
        return (String) invokeLL.objValue;
    }

    public void setConfirmSource(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.mConfirmSource = str;
            this.mConfirmExt = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> getActivePostData() {
        InterceptResult invokeV;
        String str;
        String str2;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            String str3 = "";
            String fnplusJsonString = getFnplusJsonString();
            if (DEBUG) {
                Log.d(TAG, "jsonValue= " + fnplusJsonString);
            }
            String encrypt = encrypt(BaiduIdentityManager.getInstance().getTn());
            String encrypt2 = encrypt(fnplusJsonString);
            try {
                PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
                str = new String(Base64Encoder.B64Encode(Long.toString(packageInfo.firstInstallTime).getBytes()));
                try {
                    str2 = new String(Base64Encoder.B64Encode(Long.toString(packageInfo.lastUpdateTime).getBytes()));
                } catch (PackageManager.NameNotFoundException e) {
                    e = e;
                    str2 = "";
                } catch (UnsupportedOperationException e2) {
                    e = e2;
                    str2 = "";
                }
                try {
                    if (DEBUG) {
                        Log.d(TAG, "firstInstallTime=" + packageInfo.firstInstallTime + ",lastUpdateTime=" + packageInfo.lastUpdateTime);
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    e = e3;
                    e.printStackTrace();
                    String encode = encode(getRandId(), "none");
                    String encode2 = encode(a30.f(AppRuntime.getAppContext()).e(), "none");
                    String encode3 = encode(this.mInvokeSource, "none");
                    String encode4 = encode(this.mLauncherSource, "none");
                    String encode5 = encode(this.mLauncherExt, "none");
                    String encode6 = encode(this.mConfirmSource, "none");
                    String encode7 = encode(this.mConfirmExt, "none");
                    if (!TextUtils.isEmpty(this.mClnCuid)) {
                    }
                    String encode8 = encode(String.valueOf(Build.TIME), "none");
                    String encode9 = encode(String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), "none");
                    jSONObject = new JSONObject();
                    jSONObject.put("fn", encrypt);
                    jSONObject.put("fnplus", encrypt2);
                    jSONObject.put(GrowthConstant.UBC_KEY_FIT, str);
                    jSONObject.put(GrowthConstant.UBC_KEY_LUT, str2);
                    jSONObject.put(RAND_ID, encode);
                    jSONObject.put("iid", encode2);
                    jSONObject.put("source", encode3);
                    jSONObject.put("lsr", encode4);
                    jSONObject.put("lex", encode5);
                    jSONObject.put("csr", encode6);
                    jSONObject.put("cex", encode7);
                    jSONObject.put(CLONE_CUID, str3);
                    jSONObject.put("bst", encode8);
                    jSONObject.put("rst", encode9);
                    if (DEBUG) {
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("data", jSONObject.toString());
                    return linkedHashMap;
                } catch (UnsupportedOperationException e4) {
                    e = e4;
                    e.printStackTrace();
                    String encode10 = encode(getRandId(), "none");
                    String encode22 = encode(a30.f(AppRuntime.getAppContext()).e(), "none");
                    String encode32 = encode(this.mInvokeSource, "none");
                    String encode42 = encode(this.mLauncherSource, "none");
                    String encode52 = encode(this.mLauncherExt, "none");
                    String encode62 = encode(this.mConfirmSource, "none");
                    String encode72 = encode(this.mConfirmExt, "none");
                    if (!TextUtils.isEmpty(this.mClnCuid)) {
                    }
                    String encode82 = encode(String.valueOf(Build.TIME), "none");
                    String encode92 = encode(String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), "none");
                    jSONObject = new JSONObject();
                    jSONObject.put("fn", encrypt);
                    jSONObject.put("fnplus", encrypt2);
                    jSONObject.put(GrowthConstant.UBC_KEY_FIT, str);
                    jSONObject.put(GrowthConstant.UBC_KEY_LUT, str2);
                    jSONObject.put(RAND_ID, encode10);
                    jSONObject.put("iid", encode22);
                    jSONObject.put("source", encode32);
                    jSONObject.put("lsr", encode42);
                    jSONObject.put("lex", encode52);
                    jSONObject.put("csr", encode62);
                    jSONObject.put("cex", encode72);
                    jSONObject.put(CLONE_CUID, str3);
                    jSONObject.put("bst", encode82);
                    jSONObject.put("rst", encode92);
                    if (DEBUG) {
                    }
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("data", jSONObject.toString());
                    return linkedHashMap2;
                }
            } catch (PackageManager.NameNotFoundException e5) {
                e = e5;
                str = "";
                str2 = str;
            } catch (UnsupportedOperationException e6) {
                e = e6;
                str = "";
                str2 = str;
            }
            String encode102 = encode(getRandId(), "none");
            String encode222 = encode(a30.f(AppRuntime.getAppContext()).e(), "none");
            String encode322 = encode(this.mInvokeSource, "none");
            String encode422 = encode(this.mLauncherSource, "none");
            String encode522 = encode(this.mLauncherExt, "none");
            String encode622 = encode(this.mConfirmSource, "none");
            String encode722 = encode(this.mConfirmExt, "none");
            if (!TextUtils.isEmpty(this.mClnCuid)) {
                str3 = this.mClnCuid;
            }
            String encode822 = encode(String.valueOf(Build.TIME), "none");
            String encode922 = encode(String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), "none");
            jSONObject = new JSONObject();
            try {
                jSONObject.put("fn", encrypt);
                jSONObject.put("fnplus", encrypt2);
                jSONObject.put(GrowthConstant.UBC_KEY_FIT, str);
                jSONObject.put(GrowthConstant.UBC_KEY_LUT, str2);
                jSONObject.put(RAND_ID, encode102);
                jSONObject.put("iid", encode222);
                jSONObject.put("source", encode322);
                jSONObject.put("lsr", encode422);
                jSONObject.put("lex", encode522);
                jSONObject.put("csr", encode622);
                jSONObject.put("cex", encode722);
                jSONObject.put(CLONE_CUID, str3);
                jSONObject.put("bst", encode822);
                jSONObject.put("rst", encode922);
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
            if (DEBUG) {
                Log.d(TAG, "active body info: " + jSONObject.toString());
            }
            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
            linkedHashMap22.put("data", jSONObject.toString());
            return linkedHashMap22;
        }
        return (Map) invokeV.objValue;
    }

    private String getFnplusJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            Context context = this.mContext;
            String sign = PkgUtils.getSign(context, context.getPackageName());
            if (DEBUG) {
                Log.d(TAG, "signValue= " + sign);
            }
            String md5 = MD5Utils.toMd5(sign.getBytes(), false);
            if (DEBUG) {
                Log.d(TAG, "MD5(ac)= " + md5);
            }
            String localPhotoInfo = getLocalPhotoInfo();
            String localFileSystemInfo = getLocalFileSystemInfo();
            String ipInfo = getIpInfo();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ac", URLEncoder.encode(md5, IMAudioTransRequest.CHARSET));
                jSONObject.put("apn", URLEncoder.encode(localPhotoInfo, IMAudioTransRequest.CHARSET));
                jSONObject.put("afn", URLEncoder.encode(localFileSystemInfo, IMAudioTransRequest.CHARSET));
                jSONObject.put("aip", URLEncoder.encode(ipInfo, IMAudioTransRequest.CHARSET));
                return jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocalFileSystemInfo() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        Closeable closeable;
        DataOutputStream dataOutputStream;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            String str = null;
            try {
                try {
                    listFiles = Environment.getExternalStorageDirectory().listFiles(new FileFilter(this) { // from class: com.baidu.searchbox.util.BaiduActiveManager.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaiduActiveManager this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.io.FileFilter
                        public boolean accept(File file) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                                if (file != null && !TextUtils.isEmpty(file.getName())) {
                                    return true;
                                }
                                return false;
                            }
                            return invokeL.booleanValue;
                        }
                    });
                    Arrays.sort(listFiles, new Comparator<File>(this) { // from class: com.baidu.searchbox.util.BaiduActiveManager.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaiduActiveManager this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(File file, File file2) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, file2)) == null) {
                                return (int) (file.lastModified() - file2.lastModified());
                            }
                            return invokeLL.intValue;
                        }
                    });
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(closeable);
                    Closeables.closeSafely(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                closeable = null;
            }
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    for (File file : listFiles) {
                        dataOutputStream.writeUTF(file.getName());
                    }
                    dataOutputStream.flush();
                    str = Util.toMd5(byteArrayOutputStream.toByteArray(), true);
                } catch (Exception e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.e(TAG, "getLocalFileSystemInfo fail!" + e.toString());
                    }
                    Closeables.closeSafely(dataOutputStream);
                    Closeables.closeSafely(byteArrayOutputStream);
                    if (!TextUtils.isEmpty(str)) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                dataOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                th = th;
                Closeables.closeSafely(closeable);
                Closeables.closeSafely(byteArrayOutputStream);
                throw th;
            }
            Closeables.closeSafely(dataOutputStream);
            Closeables.closeSafely(byteArrayOutputStream);
            if (!TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    private AbstractHttpEntity getPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            String fnplusJsonString = getFnplusJsonString();
            if (DEBUG) {
                Log.d(TAG, "jsonValue= " + fnplusJsonString);
            }
            String encrypt = encrypt(BaiduIdentityManager.getInstance().getTn());
            String encrypt2 = encrypt(fnplusJsonString);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fn", encrypt);
                jSONObject.put("fnplus", encrypt2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d(TAG, "active body info: " + jSONObject.toString());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("data", jSONObject.toString()));
            UrlEncodedFormEntity urlEncodedFormEntity = null;
            try {
                UrlEncodedFormEntity urlEncodedFormEntity2 = new UrlEncodedFormEntity(arrayList, IMAudioTransRequest.CHARSET);
                try {
                    urlEncodedFormEntity2.setContentType("application/x-www-form-urlencoded");
                    return urlEncodedFormEntity2;
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    urlEncodedFormEntity = urlEncodedFormEntity2;
                    e.printStackTrace();
                    return urlEncodedFormEntity;
                }
            } catch (UnsupportedEncodingException e3) {
                e = e3;
            }
        } else {
            return (AbstractHttpEntity) invokeV.objValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
        r1 = r6.getColumnIndex("title");
        r0 = r6.getColumnIndex("_size");
        r5 = new java.io.ByteArrayOutputStream(1024);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
        r7 = new java.io.DataOutputStream(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
        r8 = r6.getString(r1);
        r9 = r6.getString(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
        if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
        com.baidu.android.common.logging.Log.d(com.baidu.searchbox.util.BaiduActiveManager.TAG, "title: " + r8 + " size: " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0082, code lost:
        r7.writeUTF(r8 + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0098, code lost:
        if (r6.moveToNext() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009a, code lost:
        r7.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a5, code lost:
        r0 = com.baidu.searchbox.util.Util.toMd5(r5.toByteArray(), true);
        r17 = r6;
        r3 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00aa, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ac, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ae, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b2, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c6, code lost:
        r17 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e9, code lost:
        if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00eb, code lost:
        com.baidu.android.common.logging.Log.e(com.baidu.searchbox.util.BaiduActiveManager.TAG, "getLocalPhotoInfo fail!" + r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0103, code lost:
        com.baidu.android.util.io.Closeables.closeSafely(r17);
        com.baidu.android.util.io.Closeables.closeSafely(r7);
        com.baidu.android.util.io.Closeables.closeSafely(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0115, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0112 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocalPhotoInfo() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        Cursor cursor;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            Cursor cursor2 = null;
            String str2 = null;
            DataOutputStream dataOutputStream2 = null;
            try {
                ContentResolver contentResolver = this.mContext.getContentResolver();
                Uri[] uriArr = {MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Images.Media.INTERNAL_CONTENT_URI};
                String[] strArr = {"title", "_size"};
                cursor = null;
                int i = 0;
                while (true) {
                    if (i < 2) {
                        try {
                            int i2 = i;
                            Cursor query = contentResolver.query(uriArr[i], strArr, null, null, "date_modified DESC LIMIT 10");
                            if (query != null) {
                                try {
                                    if (query.moveToFirst()) {
                                        break;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    byteArrayOutputStream = null;
                                    dataOutputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = null;
                                    dataOutputStream = null;
                                }
                            }
                            Closeables.closeSafely(query);
                            i = i2 + 1;
                            cursor = query;
                        } catch (Exception e2) {
                            e = e2;
                            byteArrayOutputStream = null;
                            dataOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = null;
                            dataOutputStream = null;
                            cursor2 = cursor;
                            Closeables.closeSafely(cursor2);
                            Closeables.closeSafely(dataOutputStream);
                            Closeables.closeSafely(byteArrayOutputStream);
                            throw th;
                        }
                    } else {
                        str = null;
                        byteArrayOutputStream = null;
                        break;
                    }
                }
                Closeables.closeSafely(cursor);
                Closeables.closeSafely(dataOutputStream2);
                Closeables.closeSafely(byteArrayOutputStream);
                str2 = str;
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                dataOutputStream = null;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                return "";
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendActiveUBCEvent(int i, String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65558, this, i, str) == null) {
            JSONObject jSONObject = new JSONObject();
            if (i == 200) {
                str2 = BaiduActiveStatistic.UBC_VALUE_REQUEST_SUCCESS;
            } else {
                str2 = BaiduActiveStatistic.UBC_VALUE_REQUEST_FAILED;
            }
            try {
                jSONObject.put("data", str);
                jSONObject.put(BaiduActiveStatistic.UBC_EXT_KEY_ACTIVE_TIME_INFO, getActiveTimeInfo());
                jSONObject.put(BaiduActiveStatistic.UBC_EXT_KEY_RESPONSE_CODE, i);
                jSONObject.put(BaiduActiveStatistic.UBC_EXT_KEY_PRI_ABI, DeviceUtil.CPUInfo.getPreferredABI());
                if (TextUtils.isEmpty(this.mOriginalLauncherExt)) {
                    str3 = "";
                } else {
                    str3 = this.mOriginalLauncherExt;
                }
                jSONObject.put(BaiduActiveStatistic.UBC_EXT_KEY_ORIGINAL_DATA, str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BaiduActiveStatistic.onUBCEvent(str2, this.mLauncherSource, jSONObject.toString());
        }
    }

    public void active(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            boolean z = this.mSettings.getBoolean("active", false);
            this.mClnCuid = DeviceId.getOldCUID(AppRuntime.getAppContext());
            if (DEBUG) {
                Log.d(TAG, "clone cuid: " + this.mClnCuid);
                Log.d(TAG, "active time info: " + getActiveTimeInfo());
            }
            if (z && !isNeedUploadCloneCuid()) {
                if (DEBUG) {
                    Log.d(TAG, "already active");
                }
            } else if (mStartRequest) {
                if (DEBUG) {
                    Log.d(TAG, "has start active request");
                }
            } else {
                mStartRequest = true;
                ExecutorUtilsExt.postOnElastic(new Runnable(this, context) { // from class: com.baidu.searchbox.util.BaiduActiveManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaiduActiveManager this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:49:0x01cc, code lost:
                        if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG == false) goto L48;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:55:0x01dc, code lost:
                        if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG == false) goto L48;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:61:0x01ee, code lost:
                        if (com.baidu.searchbox.util.BaiduActiveManager.DEBUG == false) goto L48;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f0, code lost:
                        com.baidu.android.common.logging.Log.d(com.baidu.searchbox.util.BaiduActiveManager.TAG, "active request finished");
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f3, code lost:
                        r0 = com.baidu.searchbox.util.BaiduActiveManager.mStartRequest = false;
                        r14.this$0.sendActiveUBCEvent(-1, r6);
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:64:0x01fb, code lost:
                        return;
                     */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        SharedPreferences.Editor edit;
                        String appendParam;
                        Map<String, String> activePostData;
                        String str;
                        ResponseBody body;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Process.setThreadPriority(10);
                            String str2 = null;
                            InputStream inputStream = null;
                            String str3 = null;
                            str2 = null;
                            str2 = null;
                            BaiduActiveStatistic.onUBCEvent(BaiduActiveStatistic.UBC_VALUE_REQUEST_START, this.this$0.mLauncherSource, null);
                            int i = -1;
                            try {
                                try {
                                    edit = this.this$0.mSettings.edit();
                                    edit.putLong(BaiduActiveManager.KEY_ACTIVE_REQUEST_TIME, System.currentTimeMillis());
                                    edit.commit();
                                    String str4 = (BaiduActiveManager.getActiveUrl() + "&uuid=" + BaiduIdentityUtils.getSoftwareUUID(this.val$context)) + "&udata=" + BaiduIdentityUtils.getAppType(this.val$context, this.val$context.getPackageName());
                                    String preferredABI = DeviceUtil.CPUInfo.getPreferredABI();
                                    if (TextUtils.isEmpty(preferredABI)) {
                                        preferredABI = "none";
                                    }
                                    appendParam = BaiduIdentityManager.getInstance().appendParam(str4 + "&pre_abi=" + new String(Base64Encoder.B64Encode(preferredABI.getBytes())), 1);
                                    if (BaiduActiveManager.DEBUG) {
                                        Log.d(BaiduActiveManager.TAG, "usePrivacyPolicy: " + z10.b().h());
                                        Log.d(BaiduActiveManager.TAG, "active url: QALog-" + appendParam);
                                    }
                                    activePostData = this.this$0.getActivePostData();
                                    if (activePostData != null) {
                                        str = activePostData.get("data");
                                    } else {
                                        str = null;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } catch (IllegalArgumentException unused) {
                            } catch (ClientProtocolException unused2) {
                            } catch (IOException unused3) {
                            }
                            try {
                                Response executeSync = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(appendParam)).params(activePostData).cookieManager(this.this$0.mIdentityContextImpl.obtainCookieManager(true, false))).enableStat(true)).requestFrom(10)).requestSubFrom(DebugConstants.HTTP_ERRCODE_VERSION_HIGH)).build().executeSync();
                                if (executeSync != null && (i = executeSync.code()) == 200 && (body = executeSync.body()) != null) {
                                    try {
                                        inputStream = body.byteStream();
                                        String[] parse = ActiveTimeParser.getInstance().parse(inputStream);
                                        if (parse != null && !TextUtils.equals(parse[0], "0")) {
                                            edit.putBoolean("active", true);
                                            edit.putString("time", parse[0]);
                                            edit.putLong("time_stamp", Long.parseLong(parse[1]));
                                            edit.putLong(BaiduActiveManager.KEY_ACTIVE_TIME, System.currentTimeMillis());
                                            if (!TextUtils.isEmpty(this.this$0.mClnCuid)) {
                                                edit.putString(BaiduActiveManager.CLONE_CUID, this.this$0.mClnCuid);
                                            }
                                            edit.commit();
                                        }
                                        Closeables.closeSafely(inputStream);
                                    } catch (Throwable th2) {
                                        Closeables.closeSafely(inputStream);
                                        throw th2;
                                    }
                                }
                                if (BaiduActiveManager.DEBUG) {
                                    Log.d(BaiduActiveManager.TAG, "active request finished");
                                }
                                boolean unused4 = BaiduActiveManager.mStartRequest = false;
                                this.this$0.sendActiveUBCEvent(i, str);
                            } catch (IOException unused5) {
                                str2 = str;
                                if (BaiduActiveManager.DEBUG) {
                                    Log.d(BaiduActiveManager.TAG, "active failed, maybe net error.");
                                }
                            } catch (IllegalArgumentException unused6) {
                                str2 = str;
                                if (BaiduActiveManager.DEBUG) {
                                    Log.d(BaiduActiveManager.TAG, "active failed, url is invalid.");
                                }
                            } catch (ClientProtocolException unused7) {
                                str2 = str;
                                if (BaiduActiveManager.DEBUG) {
                                    Log.d(BaiduActiveManager.TAG, "active failed, maybe net error.");
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str3 = str;
                                if (BaiduActiveManager.DEBUG) {
                                    Log.d(BaiduActiveManager.TAG, "active request finished");
                                }
                                boolean unused8 = BaiduActiveManager.mStartRequest = false;
                                this.this$0.sendActiveUBCEvent(-1, str3);
                                throw th;
                            }
                        }
                    }
                }, "ActiveRequest", 2);
            }
        }
    }

    public ActiveTimeInfo getActiveTimeInfo() {
        InterceptResult invokeV;
        long j;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SharedPreferences sharedPreferences = this.mSettings;
            if (sharedPreferences != null) {
                long j4 = sharedPreferences.getLong(KEY_ACTIVE_REQUEST_TIME, 0L);
                long j5 = this.mSettings.getLong("time_stamp", 0L);
                j3 = this.mSettings.getLong(KEY_ACTIVE_TIME, 0L);
                j = j4;
                j2 = j5;
            } else {
                j = 0;
                j2 = 0;
                j3 = 0;
            }
            return new ActiveTimeInfo(j, j2, j3);
        }
        return (ActiveTimeInfo) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r0 = r3.getHostAddress().toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                loop0: while (true) {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            break loop0;
                        }
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e(TAG, "getIpInfo fail!" + e.toString());
                }
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
