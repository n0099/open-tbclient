package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public class FileUploadTask extends AsyncTask<Void, Integer, Integer> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DOWNLOAD_BYTES_SIZE = 8192;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAuthorization;
    public String mContentType;
    public Context mContext;
    public String mFilePath;
    public IFileUploadListener mListener;
    public String mUrl;
    public String mXbcs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(860589010, "Lcom/baidu/android/imsdk/upload/FileUploadTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(860589010, "Lcom/baidu/android/imsdk/upload/FileUploadTask;");
                return;
            }
        }
        TAG = FileUploadTask.class.getSimpleName();
    }

    public FileUploadTask(Context context, String str, String str2, String str3, String str4, String str5, IFileUploadListener iFileUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, str5, iFileUploadListener};
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
        this.mListener = iFileUploadListener;
        this.mUrl = str;
        this.mFilePath = str2;
        this.mContentType = str3;
        this.mAuthorization = str4;
        this.mXbcs = str5;
    }

    private Integer doUpload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                File file = new File(this.mFilePath);
                if (file.exists() && !file.isDirectory()) {
                    this.mUrl = replaceToHttps(this.mUrl);
                    String str = TAG;
                    LogUtils.d(str, "upload url is " + this.mUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    int i2 = 0;
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "utf-8");
                    httpURLConnection.setRequestProperty("Content-type", this.mContentType);
                    httpURLConnection.setRequestProperty("Authorization", this.mAuthorization);
                    httpURLConnection.setRequestProperty(Headers.BCE_DATE, this.mXbcs);
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    FileInputStream fileInputStream = new FileInputStream(this.mFilePath);
                    byte[] bArr = new byte[8192];
                    long j2 = 0;
                    long length = file.length();
                    long currentTimeMillis = System.currentTimeMillis();
                    int i3 = -1;
                    int i4 = -1;
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == i3) {
                            break;
                        }
                        dataOutputStream.write(bArr, i2, read);
                        HttpURLConnection httpURLConnection2 = httpURLConnection;
                        j2 += read;
                        String str2 = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("write bytes:");
                        sb.append(read);
                        sb.append("  total:");
                        sb.append(j2);
                        sb.append("  time:");
                        DataOutputStream dataOutputStream2 = dataOutputStream;
                        sb.append(((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f);
                        LogUtils.d(str2, sb.toString());
                        int i5 = (int) ((100 * j2) / length);
                        if (i5 != i4) {
                            this.mListener.onProgress(i5);
                            i4 = i5;
                        }
                        dataOutputStream = dataOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        i3 = -1;
                        i2 = 0;
                    }
                    DataOutputStream dataOutputStream3 = dataOutputStream;
                    fileInputStream.close();
                    dataOutputStream3.flush();
                    dataOutputStream3.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String str3 = TAG;
                        LogUtils.i(str3, "upload success " + responseCode);
                        return 0;
                    }
                    String str4 = TAG;
                    LogUtils.e(str4, "upload failure " + responseCode);
                    return 1008;
                }
                return 1007;
            } catch (Exception e2) {
                String str5 = TAG;
                LogUtils.e(str5, "IOException:" + e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                return 1008;
            }
        }
        return (Integer) invokeV.objValue;
    }

    private void notifyFailed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            try {
                if (this.mListener != null) {
                    this.mListener.onFailed(i2, "upload failure");
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IOException notifyFailed:" + e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    private void notifyFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                if (this.mListener != null) {
                    this.mListener.onFinished(0);
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IOException notifyFinished:" + e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    public String replaceToHttps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? str.replace("http://", "https://") : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public Integer doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            if (TextUtils.isEmpty(this.mUrl)) {
                return 1002;
            }
            return doUpload();
        }
        return (Integer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
            if (num.equals(0)) {
                LogUtils.d(TAG, "upload ok");
                notifyFinished();
                return;
            }
            LogUtils.d(TAG, "upload failure ");
            notifyFailed(num.intValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, numArr) == null) {
            this.mListener.onProgress(numArr[0].intValue());
        }
    }
}
