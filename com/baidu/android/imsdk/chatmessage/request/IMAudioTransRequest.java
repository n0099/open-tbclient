package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMAudioTransRequest implements HttpHelper.ResponseHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHARSET = "utf-8";
    public static final String CONTENT_TYPE = "multipart/form-data";
    public static String FORM_BOUNDARY = "Boundary";
    public static final String FORM_LINEEND;
    public static final String FORM_PREFIX = "--";
    public static final String TAG = "IMAudioTransRequest";
    public static final int TIME_OUT = 60000;
    public transient /* synthetic */ FieldHolder $fh;
    public String mContentType;
    public Context mContext;
    public String mFilePath;
    public String mFormat;
    public String mKey;
    public int mReqSource;

    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053613111, "Lcom/baidu/android/imsdk/chatmessage/request/IMAudioTransRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1053613111, "Lcom/baidu/android/imsdk/chatmessage/request/IMAudioTransRequest;");
                return;
            }
        }
        FORM_LINEEND = System.getProperty("line.separator");
    }

    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMAudioTransRequest this$0;

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

                /* JADX WARN: Removed duplicated region for block: B:75:0x02ba A[Catch: Exception -> 0x02b6, TryCatch #5 {Exception -> 0x02b6, blocks: (B:71:0x02b2, B:75:0x02ba, B:77:0x02bf), top: B:85:0x02b2 }] */
                /* JADX WARN: Removed duplicated region for block: B:77:0x02bf A[Catch: Exception -> 0x02b6, TRY_LEAVE, TryCatch #5 {Exception -> 0x02b6, blocks: (B:71:0x02b2, B:75:0x02ba, B:77:0x02bf), top: B:85:0x02b2 }] */
                /* JADX WARN: Removed duplicated region for block: B:85:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    DataOutputStream dataOutputStream;
                    FileInputStream fileInputStream;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        OutputStream outputStream = null;
                        try {
                            try {
                                if (this.this$0.mContext != null && !TextUtils.isEmpty(this.this$0.getHost())) {
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.this$0.getHost()).openConnection();
                                    httpURLConnection.setReadTimeout(60000);
                                    httpURLConnection.setConnectTimeout(60000);
                                    httpURLConnection.setDoInput(true);
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setUseCaches(false);
                                    httpURLConnection.setRequestMethod(this.this$0.getMethod());
                                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
                                    IMAudioTransRequest.FORM_BOUNDARY += UUID.randomUUID().toString();
                                    httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + IMAudioTransRequest.FORM_BOUNDARY);
                                    httpURLConnection.setRequestProperty("Accept", "*/*");
                                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                                    String bduss = IMConfigInternal.getInstance().getIMConfig(this.this$0.mContext).getBduss(this.this$0.mContext);
                                    CookieManager.getInstance().setCookie(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE, "BDUSS=" + bduss);
                                    httpURLConnection.setRequestProperty("Cookie", "BDUSS=" + bduss);
                                    File file = new File(this.this$0.mFilePath);
                                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                                    try {
                                        dataOutputStream = new DataOutputStream(outputStream2);
                                        try {
                                            for (Map.Entry<String, String> entry : this.this$0.getRequestParameter().entrySet()) {
                                                StringBuffer stringBuffer = new StringBuffer();
                                                stringBuffer.append("--");
                                                stringBuffer.append(IMAudioTransRequest.FORM_BOUNDARY);
                                                stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                                stringBuffer.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + IMAudioTransRequest.FORM_LINEEND);
                                                stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                                stringBuffer.append(entry.getValue());
                                                stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                                dataOutputStream.write(stringBuffer.toString().getBytes(IMAudioTransRequest.CHARSET));
                                            }
                                            StringBuffer stringBuffer2 = new StringBuffer();
                                            stringBuffer2.append("--");
                                            stringBuffer2.append(IMAudioTransRequest.FORM_BOUNDARY);
                                            stringBuffer2.append(IMAudioTransRequest.FORM_LINEEND);
                                            stringBuffer2.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"" + IMAudioTransRequest.FORM_LINEEND);
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Content-Type: audio/amr");
                                            sb.append(IMAudioTransRequest.FORM_LINEEND);
                                            stringBuffer2.append(sb.toString());
                                            stringBuffer2.append(IMAudioTransRequest.FORM_LINEEND);
                                            dataOutputStream.write(stringBuffer2.toString().getBytes(IMAudioTransRequest.CHARSET));
                                            fileInputStream = new FileInputStream(file);
                                            try {
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int read = fileInputStream.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    dataOutputStream.write(bArr, 0, read);
                                                }
                                                dataOutputStream.write(IMAudioTransRequest.FORM_LINEEND.getBytes(IMAudioTransRequest.CHARSET));
                                                dataOutputStream.write(("--" + IMAudioTransRequest.FORM_BOUNDARY + "--" + IMAudioTransRequest.FORM_LINEEND).getBytes(IMAudioTransRequest.CHARSET));
                                                dataOutputStream.flush();
                                                int responseCode = httpURLConnection.getResponseCode();
                                                if (responseCode == 200) {
                                                    StringBuffer stringBuffer3 = new StringBuffer();
                                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                                                    while (true) {
                                                        String readLine = bufferedReader.readLine();
                                                        if (readLine == null) {
                                                            break;
                                                        }
                                                        stringBuffer3.append(readLine);
                                                    }
                                                    this.this$0.onSuccess(responseCode, stringBuffer3.toString().getBytes());
                                                }
                                                if (outputStream2 != null) {
                                                    outputStream2.close();
                                                }
                                                if (dataOutputStream != null) {
                                                    dataOutputStream.close();
                                                }
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                    return;
                                                }
                                                return;
                                            } catch (Exception e) {
                                                e = e;
                                                outputStream = outputStream2;
                                                try {
                                                    LogUtils.d(IMAudioTransRequest.TAG, "Http Unknown exception");
                                                    this.this$0.onFailure(-1003, "Http Unknown exception".getBytes(), e);
                                                    if (outputStream != null) {
                                                        outputStream.close();
                                                    }
                                                    if (dataOutputStream != null) {
                                                        dataOutputStream.close();
                                                    }
                                                    if (fileInputStream != null) {
                                                        fileInputStream.close();
                                                        return;
                                                    }
                                                    return;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (outputStream != null) {
                                                        try {
                                                            outputStream.close();
                                                        } catch (Exception e2) {
                                                            LogUtils.d(IMAudioTransRequest.TAG, e2.getMessage());
                                                            throw th;
                                                        }
                                                    }
                                                    if (dataOutputStream != null) {
                                                        dataOutputStream.close();
                                                    }
                                                    if (fileInputStream != null) {
                                                        fileInputStream.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                outputStream = outputStream2;
                                                if (outputStream != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            fileInputStream = null;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            fileInputStream = null;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        dataOutputStream = null;
                                        fileInputStream = null;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        dataOutputStream = null;
                                        fileInputStream = null;
                                    }
                                }
                                this.this$0.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
                            } catch (Exception e5) {
                                LogUtils.d(IMAudioTransRequest.TAG, e5.getMessage());
                            }
                        } catch (Exception e6) {
                            e = e6;
                            dataOutputStream = null;
                            fileInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            dataOutputStream = null;
                            fileInputStream = null;
                        }
                    }
                }
            });
        }
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            if (readIntData != 1) {
                if (readIntData != 2) {
                    if (readIntData != 3) {
                        return "https://pim.baidu.com/rest/3.0/im/transcode";
                    }
                    return "http://180.97.36.95:8080/rest/3.0/im/transcode";
                }
                return "http://sz-shaheenv-odprestapi-b.bcc-szwg.baidu.com:8080/rest/3.0/im/transcode";
            }
            return "http://rd-im-server.bcc-szth.baidu.com:8111/rest/3.0/im/transcode";
        }
        return (String) invokeV.objValue;
    }

    public IMAudioTransRequest(Context context, String str, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i), str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mKey = str4;
        this.mFilePath = str;
        this.mContentType = str2;
        this.mFormat = str3;
        this.mReqSource = i;
    }

    public String getMd5(String str) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return Utility.byte2Hex(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    public HashMap<String, String> getRequestParameter() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            long appid = AccountManager.getAppid(this.mContext);
            hashMap.put("appid", String.valueOf(appid));
            hashMap.put("uk", AccountManager.getUK(this.mContext) + "");
            hashMap.put("in_format", this.mFormat);
            hashMap.put("out_format", "mp3");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            hashMap.put("timestamp", currentTimeMillis + "");
            try {
                String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
                str = getMd5("" + currentTimeMillis + bduss + appid);
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
                str = "";
            }
            hashMap.put("sign", str + "");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            LogUtils.d(TAG, "IMAudio Trans onFailure " + transErrorCode.first);
            ChatMsgManagerImpl.getInstance(this.mContext).onAudioTransCallBack(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    public Pair<Integer, String> transErrorCode(int i, byte[] bArr, Throwable th) {
        InterceptResult invokeILL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, bArr, th)) == null) {
            if (th == null) {
                if (i == 1005) {
                    str = new String(bArr);
                } else {
                    str = "http response is error! response code:" + i;
                    i = 1011;
                }
            } else {
                i = 1012;
                str = Constants.ERROR_MSG_HTTP_IOEXCEPTION_ERROR;
            }
            return new Pair<>(Integer.valueOf(i), str);
        }
        return (Pair) invokeILL.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str4 = new String(bArr);
            LogUtils.d("IMGenBosObjectUrlRequest", str4);
            try {
                jSONObject = new JSONObject(str4);
                i2 = jSONObject.optInt("error_code", -1);
            } catch (Exception e) {
                LogUtils.e(TAG, "deleteExpiredReliableMsgs :", e);
                LogUtils.e(TAG, e.getMessage(), e);
                i2 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            if (i2 == 0) {
                str3 = jSONObject.optString("base64_file");
                str2 = Constants.ERROR_MSG_SUCCESS;
                ChatMsgManagerImpl.getInstance(this.mContext).onAudioTransCallBack(this.mKey, i2, str2, str3);
            }
            i2 = jSONObject.getInt("error_code");
            str = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            str2 = str;
            str3 = "";
            ChatMsgManagerImpl.getInstance(this.mContext).onAudioTransCallBack(this.mKey, i2, str2, str3);
        }
    }
}
