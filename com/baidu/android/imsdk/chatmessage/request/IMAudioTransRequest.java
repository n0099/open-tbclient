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
import com.baidu.android.pushservice.PushConstants;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMAudioTransRequest implements HttpHelper.ResponseHandler {
    private static final String CHARSET = "utf-8";
    private static final String CONTENT_TYPE = "multipart/form-data";
    private static String FORM_BOUNDARY = "Boundary";
    private static final String FORM_LINEEND = System.getProperty("line.separator");
    private static final String FORM_PREFIX = "--";
    private static final String TAG = "IMAudioTransRequest";
    private static final int TIME_OUT = 60000;
    private String mContentType;
    private Context mContext;
    private String mFilePath;
    private String mFormat;
    private String mKey;
    private int mReqSource;

    public IMAudioTransRequest(Context context, String str, String str2, String str3, int i, String str4) {
        this.mContext = context;
        this.mKey = str4;
        this.mFilePath = str;
        this.mContentType = str2;
        this.mFormat = str3;
        this.mReqSource = i;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str = new String(bArr);
        LogUtils.d("IMGenBosObjectUrlRequest", str);
        String str2 = Constants.ERROR_MSG_SUCCESS;
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            i2 = jSONObject.optInt("error_code", -1);
            if (i2 == 0) {
                str3 = jSONObject.optString("base64_file");
            } else {
                i2 = jSONObject.getInt("error_code");
                str2 = jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "deleteExpiredReliableMsgs :", e);
            LogUtils.e(TAG, e.getMessage(), e);
            i2 = 1010;
            str2 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        ChatMsgManagerImpl.getInstance(this.mContext).onAudioTransCallBack(this.mKey, i2, str2, str3);
    }

    public Pair<Integer, String> transErrorCode(int i, byte[] bArr, Throwable th) {
        String str;
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

    @Override // com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        LogUtils.d(TAG, "IMAudio Trans onFailure " + transErrorCode.first);
        ChatMsgManagerImpl.getInstance(this.mContext).onAudioTransCallBack(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
    }

    public String getHost() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return "https://pim.baidu.com/rest/3.0/im/transcode";
            case 1:
            case 2:
                return "http://cp01-ocean-749.epc.baidu.com:8111/rest/3.0/im/transcode";
            case 3:
                return "http://180.97.36.95:8080/rest/3.0/im/transcode";
            default:
                return "https://pim.baidu.com/rest/3.0/im/transcode";
        }
    }

    public String getMethod() {
        return "POST";
    }

    public HashMap<String, String> getRequestParameter() {
        HashMap<String, String> hashMap = new HashMap<>();
        long appid = AccountManager.getAppid(this.mContext);
        hashMap.put("appid", String.valueOf(appid));
        hashMap.put("uk", AccountManager.getUK(this.mContext) + "");
        hashMap.put("in_format", this.mFormat);
        hashMap.put("out_format", "mp3");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("timestamp", currentTimeMillis + "");
        String str = "";
        try {
            str = getMd5("" + currentTimeMillis + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext) + appid);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        hashMap.put("sign", str + "");
        return hashMap;
    }

    public String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        return Utility.byte2Hex(messageDigest.digest());
    }

    public void execute() {
        TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [298=4, 299=4, 302=4, 303=4, 306=4, 307=4, 309=4, 310=4, 311=4] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0324 A[Catch: Exception -> 0x036e, TryCatch #1 {Exception -> 0x036e, blocks: (B:56:0x031f, B:58:0x0324, B:60:0x0329), top: B:87:0x031f }] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0329 A[Catch: Exception -> 0x036e, TRY_LEAVE, TryCatch #1 {Exception -> 0x036e, blocks: (B:56:0x031f, B:58:0x0324, B:60:0x0329), top: B:87:0x031f }] */
            /* JADX WARN: Removed duplicated region for block: B:87:0x031f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                DataOutputStream dataOutputStream;
                OutputStream outputStream;
                FileInputStream fileInputStream;
                OutputStream outputStream2;
                FileInputStream fileInputStream2 = null;
                fileInputStream2 = null;
                r3 = null;
                fileInputStream2 = null;
                DataOutputStream dataOutputStream2 = null;
                OutputStream outputStream3 = null;
                DataOutputStream dataOutputStream3 = null;
                InputStream inputStream = null;
                try {
                    if (IMAudioTransRequest.this.mContext == null || TextUtils.isEmpty(IMAudioTransRequest.this.getHost())) {
                        IMAudioTransRequest.this.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
                        if (0 != 0) {
                            try {
                                outputStream3.close();
                            } catch (Exception e) {
                                LogUtils.d(IMAudioTransRequest.TAG, e.getMessage());
                                new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                                return;
                            }
                        }
                        if (0 != 0) {
                            dataOutputStream3.close();
                        }
                        if (0 != 0) {
                            inputStream.close();
                            return;
                        }
                        return;
                    }
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
                    httpURLConnection.setRequestProperty(SM.COOKIE, cookieManager.getCookie("baidu.com"));
                    File file = new File(IMAudioTransRequest.this.mFilePath);
                    if (file != null) {
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            dataOutputStream = new DataOutputStream(outputStream);
                            try {
                                for (Map.Entry<String, String> entry : IMAudioTransRequest.this.getRequestParameter().entrySet()) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append(IMAudioTransRequest.FORM_PREFIX);
                                    stringBuffer.append(IMAudioTransRequest.FORM_BOUNDARY);
                                    stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                    stringBuffer.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + IMAudioTransRequest.FORM_LINEEND);
                                    stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                    stringBuffer.append(entry.getValue());
                                    stringBuffer.append(IMAudioTransRequest.FORM_LINEEND);
                                    dataOutputStream.write(stringBuffer.toString().getBytes(IMAudioTransRequest.CHARSET));
                                }
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(IMAudioTransRequest.FORM_PREFIX);
                                stringBuffer2.append(IMAudioTransRequest.FORM_BOUNDARY);
                                stringBuffer2.append(IMAudioTransRequest.FORM_LINEEND);
                                stringBuffer2.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"" + IMAudioTransRequest.FORM_LINEEND);
                                stringBuffer2.append("Content-Type: audio/amr" + IMAudioTransRequest.FORM_LINEEND);
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
                                    dataOutputStream.write((IMAudioTransRequest.FORM_PREFIX + IMAudioTransRequest.FORM_BOUNDARY + IMAudioTransRequest.FORM_PREFIX + IMAudioTransRequest.FORM_LINEEND).getBytes(IMAudioTransRequest.CHARSET));
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
                                } catch (Exception e2) {
                                    e = e2;
                                    dataOutputStream2 = dataOutputStream;
                                    outputStream2 = outputStream;
                                    try {
                                        LogUtils.d(IMAudioTransRequest.TAG, "Http Unknown exception");
                                        IMAudioTransRequest.this.onFailure(-1003, "Http Unknown exception".getBytes(), e);
                                        new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                            } catch (Exception e3) {
                                                LogUtils.d(IMAudioTransRequest.TAG, e3.getMessage());
                                                new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext).exception(Log.getStackTraceString(e3)).build();
                                                return;
                                            }
                                        }
                                        if (dataOutputStream2 != null) {
                                            dataOutputStream2.close();
                                        }
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        dataOutputStream = dataOutputStream2;
                                        outputStream = outputStream2;
                                        fileInputStream2 = fileInputStream;
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception e4) {
                                                LogUtils.d(IMAudioTransRequest.TAG, e4.getMessage());
                                                new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext).exception(Log.getStackTraceString(e4)).build();
                                                throw th;
                                            }
                                        }
                                        if (dataOutputStream != null) {
                                            dataOutputStream.close();
                                        }
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream2 = fileInputStream;
                                    if (outputStream != null) {
                                    }
                                    if (dataOutputStream != null) {
                                    }
                                    if (fileInputStream2 != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                fileInputStream = null;
                                outputStream2 = outputStream;
                                dataOutputStream2 = dataOutputStream;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            fileInputStream = null;
                            outputStream2 = outputStream;
                        } catch (Throwable th4) {
                            th = th4;
                            dataOutputStream = null;
                        }
                    } else {
                        fileInputStream = null;
                        dataOutputStream = null;
                        outputStream = null;
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e7) {
                            LogUtils.d(IMAudioTransRequest.TAG, e7.getMessage());
                            new IMTrack.CrashBuilder(IMAudioTransRequest.this.mContext).exception(Log.getStackTraceString(e7)).build();
                            return;
                        }
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileInputStream = null;
                    outputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    dataOutputStream = null;
                    outputStream = null;
                }
            }
        });
    }
}
