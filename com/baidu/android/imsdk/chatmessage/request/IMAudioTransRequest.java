package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.CookieManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
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
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMAudioTransRequest implements HttpHelper.ResponseHandler {
    public static final String CHARSET = "utf-8";
    public static final String CONTENT_TYPE = "multipart/form-data";
    public static String FORM_BOUNDARY = "Boundary";
    public static final String FORM_LINEEND = System.getProperty("line.separator");
    public static final String FORM_PREFIX = "--";
    public static final String TAG = "IMAudioTransRequest";
    public static final int TIME_OUT = 60000;
    public String mContentType;
    public Context mContext;
    public String mFilePath;
    public String mFormat;
    public String mKey;
    public int mReqSource;

    public IMAudioTransRequest(Context context, String str, String str2, String str3, int i2, String str4) {
        this.mContext = context;
        this.mKey = str4;
        this.mFilePath = str;
        this.mContentType = str2;
        this.mFormat = str3;
        this.mReqSource = i2;
    }

    public void execute() {
        TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest.1
            /* JADX WARN: Removed duplicated region for block: B:77:0x02ee A[Catch: Exception -> 0x02ea, TryCatch #4 {Exception -> 0x02ea, blocks: (B:73:0x02e6, B:77:0x02ee, B:79:0x02f3), top: B:85:0x02e6 }] */
            /* JADX WARN: Removed duplicated region for block: B:79:0x02f3 A[Catch: Exception -> 0x02ea, TRY_LEAVE, TryCatch #4 {Exception -> 0x02ea, blocks: (B:73:0x02e6, B:77:0x02ee, B:79:0x02f3), top: B:85:0x02e6 }] */
            /* JADX WARN: Removed duplicated region for block: B:85:0x02e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                DataOutputStream dataOutputStream;
                FileInputStream fileInputStream;
                IMTrack.CrashBuilder crashBuilder;
                OutputStream outputStream = null;
                try {
                    if (IMAudioTransRequest.this.mContext != null && !TextUtils.isEmpty(IMAudioTransRequest.this.getHost())) {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(IMAudioTransRequest.this.getHost()).openConnection();
                        httpURLConnection.setReadTimeout(60000);
                        httpURLConnection.setConnectTimeout(60000);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod(IMAudioTransRequest.this.getMethod());
                        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                        IMAudioTransRequest.FORM_BOUNDARY += UUID.randomUUID().toString();
                        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + IMAudioTransRequest.FORM_BOUNDARY);
                        httpURLConnection.setRequestProperty("Accept", "*/*");
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                        String bduss = IMConfigInternal.getInstance().getIMConfig(IMAudioTransRequest.this.mContext).getBduss(IMAudioTransRequest.this.mContext);
                        CookieManager cookieManager = CookieManager.getInstance();
                        cookieManager.setCookie("baidu.com", "BDUSS=" + bduss);
                        httpURLConnection.setRequestProperty("Cookie", cookieManager.getCookie("baidu.com"));
                        File file = new File(IMAudioTransRequest.this.mFilePath);
                        OutputStream outputStream2 = httpURLConnection.getOutputStream();
                        try {
                            dataOutputStream = new DataOutputStream(outputStream2);
                            try {
                                for (Map.Entry<String, String> entry : IMAudioTransRequest.this.getRequestParameter().entrySet()) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("--");
                                    stringBuffer.append(IMAudioTransRequest.FORM_BOUNDARY);
                                    stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                    stringBuffer.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + IMAudioTransRequest.FORM_LINEEND);
                                    stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                    stringBuffer.append(entry.getValue());
                                    stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                    dataOutputStream.write(stringBuffer.toString().getBytes("utf-8"));
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
                                dataOutputStream.write(stringBuffer2.toString().getBytes("utf-8"));
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
                                    dataOutputStream.write(IMAudioTransRequest.FORM_LINEEND.getBytes("utf-8"));
                                    dataOutputStream.write(("--" + IMAudioTransRequest.FORM_BOUNDARY + "--" + IMAudioTransRequest.FORM_LINEEND).getBytes("utf-8"));
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
                                        IMAudioTransRequest.this.onSuccess(responseCode, stringBuffer3.toString().getBytes());
                                    }
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (Exception e2) {
                                            e = e2;
                                            LogUtils.d(IMAudioTransRequest.TAG, e.getMessage());
                                            crashBuilder = new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext);
                                            crashBuilder.exception(Log.getStackTraceString(e)).build();
                                            return;
                                        }
                                    }
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                        return;
                                    }
                                    return;
                                } catch (Exception e3) {
                                    e = e3;
                                    outputStream = outputStream2;
                                    try {
                                        LogUtils.d(IMAudioTransRequest.TAG, "Http Unknown exception");
                                        IMAudioTransRequest.this.onFailure(-1003, "Http Unknown exception".getBytes(), e);
                                        new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception e4) {
                                                e = e4;
                                                LogUtils.d(IMAudioTransRequest.TAG, e.getMessage());
                                                crashBuilder = new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext);
                                                crashBuilder.exception(Log.getStackTraceString(e)).build();
                                                return;
                                            }
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
                                            } catch (Exception e5) {
                                                LogUtils.d(IMAudioTransRequest.TAG, e5.getMessage());
                                                new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext).exception(Log.getStackTraceString(e5)).build();
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
                            } catch (Exception e6) {
                                e = e6;
                                fileInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = null;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            dataOutputStream = null;
                            fileInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            dataOutputStream = null;
                            fileInputStream = null;
                        }
                    }
                    IMAudioTransRequest.this.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
                } catch (Exception e8) {
                    e = e8;
                    dataOutputStream = null;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    dataOutputStream = null;
                    fileInputStream = null;
                }
            }
        });
    }

    public String getHost() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        return readIntData != 1 ? readIntData != 2 ? readIntData != 3 ? "https://pim.baidu.com/rest/3.0/im/transcode" : "http://180.97.36.95:8080/rest/3.0/im/transcode" : "http://sz-shaheenv-odprestapi-b.bcc-szwg.baidu.com:8080/rest/3.0/im/transcode" : "http://rd-im-server.bcc-szth.baidu.com:8111/rest/3.0/im/transcode";
    }

    public String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        return Utility.byte2Hex(messageDigest.digest());
    }

    public String getMethod() {
        return "POST";
    }

    public HashMap<String, String> getRequestParameter() {
        String str;
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
        } catch (Exception e2) {
            LogUtils.e(TAG, "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = "";
        }
        hashMap.put("sign", str + "");
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "IMAudio Trans onFailure " + transErrorCode.first);
        ChatMsgManagerImpl.getInstance(this.mContext).onAudioTransCallBack(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        String str4 = new String(bArr);
        LogUtils.d("IMGenBosObjectUrlRequest", str4);
        try {
            jSONObject = new JSONObject(str4);
            i3 = jSONObject.optInt("error_code", -1);
        } catch (Exception e2) {
            LogUtils.e(TAG, "deleteExpiredReliableMsgs :", e2);
            LogUtils.e(TAG, e2.getMessage(), e2);
            i3 = 1010;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        if (i3 == 0) {
            str3 = jSONObject.optString("base64_file");
            str2 = Constants.ERROR_MSG_SUCCESS;
            ChatMsgManagerImpl.getInstance(this.mContext).onAudioTransCallBack(this.mKey, i3, str2, str3);
        }
        i3 = jSONObject.getInt("error_code");
        str = jSONObject.getString("error_msg");
        str2 = str;
        str3 = "";
        ChatMsgManagerImpl.getInstance(this.mContext).onAudioTransCallBack(this.mKey, i3, str2, str3);
    }

    public Pair<Integer, String> transErrorCode(int i2, byte[] bArr, Throwable th) {
        String str;
        if (th != null) {
            i2 = 1012;
            str = Constants.ERROR_MSG_HTTP_IOEXCEPTION_ERROR;
        } else if (i2 == 1005) {
            str = new String(bArr);
        } else {
            str = "http response is error! response code:" + i2;
            i2 = 1011;
        }
        return new Pair<>(Integer.valueOf(i2), str);
    }
}
