package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
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
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class AsyncUploadTask extends AsyncTask<Void, Integer, Integer> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DOWNLOAD_BYTES_SIZE = 8192;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAuthorization;
    public String mContentType;
    public Context mContext;
    public String mFilePath;
    public IUploadTransferListener mListener;
    public String mRemoteUrl;
    public String mThumbUrl;
    public int mType;
    public String mUrl;
    public String mXbcs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(567930816, "Lcom/baidu/android/imsdk/upload/AsyncUploadTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(567930816, "Lcom/baidu/android/imsdk/upload/AsyncUploadTask;");
                return;
            }
        }
        TAG = AsyncUploadTask.class.getSimpleName();
    }

    public String showTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new SimpleDateFormat("MM-dd HH:mm:ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
        }
        return (String) invokeV.objValue;
    }

    public AsyncUploadTask(Context context, int i, String str, String str2, String str3, String str4, String str5, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, str2, str3, str4, str5, iUploadTransferListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRemoteUrl = "";
        this.mContext = context;
        this.mListener = iUploadTransferListener;
        this.mUrl = str;
        this.mType = i;
        this.mFilePath = str2;
        this.mContentType = str3;
        this.mAuthorization = str4;
        this.mXbcs = str5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncUploadTask(Context context, int i, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        this(context, i, str, str3, str4, str5, str6, iUploadTransferListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, str2, str3, str4, str5, str6, iUploadTransferListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], (String) objArr2[5], (String) objArr2[6], (IUploadTransferListener) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mRemoteUrl = str2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncUploadTask(Context context, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, IUploadTransferListener iUploadTransferListener) {
        this(context, i, str, str4, str5, str6, str7, iUploadTransferListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, str2, str3, str4, str5, str6, str7, iUploadTransferListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], (String) objArr2[5], (String) objArr2[6], (IUploadTransferListener) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mRemoteUrl = str2;
        this.mThumbUrl = str3;
    }

    private Integer doUpload() {
        InterceptResult invokeV;
        long length;
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                long j = 0;
                if (Utility.isMediaUri(this.mFilePath)) {
                    fileInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mFilePath));
                    if (fileInputStream != null) {
                        length = fileInputStream.available();
                    } else {
                        length = 0;
                    }
                } else {
                    File file = new File(this.mFilePath);
                    if (file.exists() && !file.isDirectory()) {
                        length = file.length();
                        fileInputStream = new FileInputStream(this.mFilePath);
                    }
                    return 1007;
                }
                if (fileInputStream == null) {
                    return 1007;
                }
                LogUtils.d(TAG, "upload url is " + this.mUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, IMAudioTransRequest.CHARSET);
                httpURLConnection.setRequestProperty("Content-type", this.mContentType);
                httpURLConnection.setRequestProperty("Authorization", this.mAuthorization);
                httpURLConnection.setRequestProperty(Headers.BCE_DATE, this.mXbcs);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                byte[] bArr = new byte[8192];
                long currentTimeMillis = System.currentTimeMillis();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                    j += read;
                    LogUtils.d(TAG, "write bytes:" + read + "  total:" + j + "  time:" + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f));
                    onProgressUpdate(Integer.valueOf((int) ((100 * j) / length)));
                    httpURLConnection = httpURLConnection;
                }
                fileInputStream.close();
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    LogUtils.i(TAG, "upload success " + responseCode);
                    return 0;
                }
                LogUtils.e(TAG, "upload failure " + responseCode);
                return 1008;
            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException:" + e);
                return 1008;
            } catch (ProtocolException e2) {
                Log.e(TAG, "ProtocolException:" + e2);
                return 1008;
            } catch (IOException e3) {
                Log.e(TAG, "IOException:" + e3);
                return 1008;
            }
        }
        return (Integer) invokeV.objValue;
    }

    private void notifyFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            try {
                if (this.mListener != null) {
                    this.mListener.onFailed(i, this.mType, this.mFilePath);
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "notifyFailed", e);
            }
        }
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
                notifyFinished();
            } else {
                notifyFailed(num.intValue());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        IUploadTransferListener iUploadTransferListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, numArr) == null) && (iUploadTransferListener = this.mListener) != null) {
            iUploadTransferListener.onProgress(numArr[0].intValue());
        }
    }

    private void notifyFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            try {
                if (this.mListener != null) {
                    if (this.mListener instanceof IUploadTransferMultipleParamListener) {
                        ((IUploadTransferMultipleParamListener) this.mListener).onFinished(this.mType, this.mRemoteUrl, this.mThumbUrl);
                    } else {
                        this.mListener.onFinished(this.mType, this.mRemoteUrl);
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "notifyFinished", e);
            }
        }
    }
}
