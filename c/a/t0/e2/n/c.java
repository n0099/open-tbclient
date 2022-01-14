package c.a.t0.e2.n;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.live.interfaces.net.DownLoadCallback;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.LiveNetConstants;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class c implements INetWork {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f17150b;

    /* renamed from: c  reason: collision with root package name */
    public int f17151c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f17152d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Object> f17153e;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17150b = -1;
        this.f17151c = -1;
    }

    public final Map<String, String> a(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && (entry.getValue() instanceof String)) {
                    hashMap.put(entry.getKey(), (String) entry.getValue());
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpManager.getDefault(TbadkCoreApplication.getInst()).cancelTag(this);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0114 -> B:88:0x012f). Please submit an issue!!! */
    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void download(Object obj, String str, DownLoadCallback downLoadCallback) {
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, str, downLoadCallback) == null) {
            boolean startsWith = this.a.startsWith("https://");
            GetRequest.GetRequestBuilder request = HttpManager.getDefault(TbadkCoreApplication.getInst()).getRequest();
            request.url(this.a).tag(this).addHeaders(this.f17152d).connectionTimeout(this.f17150b).readTimeout(this.f17151c);
            if (startsWith) {
                request.cookieManager(CookieManager.WEBKIT_COOKIES);
            }
            NetResponse netResponse = new NetResponse();
            try {
                Response executeSync = request.build().executeSync();
                if (executeSync.isSuccessful()) {
                    FileOutputStream fileOutputStream = null;
                    InputStream byteStream = executeSync.body() != null ? executeSync.body().byteStream() : null;
                    if (byteStream != null) {
                        File file = new File(str);
                        File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        try {
                            try {
                                try {
                                    if (file.createNewFile()) {
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                        try {
                                            byte[] bArr = new byte[2048];
                                            long contentLength = executeSync.body().contentLength();
                                            long j2 = 0;
                                            if (contentLength > 0) {
                                                while (true) {
                                                    int read = byteStream.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    fileOutputStream2.write(bArr, 0, read);
                                                    long j3 = j2 + read;
                                                    downLoadCallback.onFileUpdateProgress(obj, j3, contentLength);
                                                    j2 = j3;
                                                }
                                                fileOutputStream2.flush();
                                                downLoadCallback.onFileDownloaded(obj, executeSync.code(), 0, "");
                                            } else {
                                                downLoadCallback.onFileDownloaded(obj, executeSync.code(), -10, "no content length");
                                            }
                                            fileOutputStream = fileOutputStream2;
                                        } catch (IOException e2) {
                                            e = e2;
                                            fileOutputStream = fileOutputStream2;
                                            downLoadCallback.onFileDownloaded(obj, executeSync.code(), -19, e.getMessage());
                                            byteStream.close();
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            return;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileOutputStream = fileOutputStream2;
                                            try {
                                                byteStream.close();
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        downLoadCallback.onFileDownloaded(obj, executeSync.code(), -19, "mkdir fail");
                                    }
                                    byteStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (IOException e5) {
                            e = e5;
                        }
                        return;
                    }
                    return;
                }
                downLoadCallback.onFileDownloaded(obj, executeSync.code(), -10, "http error");
            } catch (ConnectException e6) {
                netResponse.netErrorCode = -22;
                netResponse.exception = e6.getMessage();
                downLoadCallback.onFileDownloaded(obj, 0, -22, e6.getMessage());
            } catch (SocketException e7) {
                netResponse.netErrorCode = -12;
                netResponse.exception = e7.getMessage();
                downLoadCallback.onFileDownloaded(obj, 0, -12, e7.getMessage());
            } catch (SocketTimeoutException e8) {
                netResponse.netErrorCode = -13;
                netResponse.exception = e8.getMessage();
                downLoadCallback.onFileDownloaded(obj, 0, -13, e8.getMessage());
            } catch (UnknownHostException e9) {
                netResponse.netErrorCode = -21;
                netResponse.exception = e9.getMessage();
                downLoadCallback.onFileDownloaded(obj, 0, -21, e9.getMessage());
            } catch (SSLException e10) {
                netResponse.netErrorCode = -20;
                netResponse.exception = e10.getMessage();
                downLoadCallback.onFileDownloaded(obj, 0, -20, e10.getMessage());
            } catch (IOException e11) {
                netResponse.netErrorCode = -19;
                netResponse.exception = e11.getMessage();
                downLoadCallback.onFileDownloaded(obj, 0, -19, e11.getMessage());
            } catch (Throwable th4) {
                netResponse.netErrorCode = -10;
                netResponse.exception = th4.getMessage();
                downLoadCallback.onFileDownloaded(obj, 0, -10, th4.getMessage());
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public NetResponse getSync(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            NetResponse netResponse = new NetResponse();
            try {
                Response executeSync = HttpManager.getDefault(TbadkCoreApplication.getInst()).getRequest().url(this.a).tag(this).addUrlParams(a(map)).addHeaders(this.f17152d).connectionTimeout(this.f17150b).readTimeout(this.f17151c).cookieManager(CookieManager.WEBKIT_COOKIES).build().executeSync();
                try {
                    netResponse.responseCode = executeSync.code();
                    netResponse.decodedResponseStr = executeSync.body() != null ? executeSync.body().string() : null;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return netResponse;
            } catch (ConnectException e3) {
                netResponse.netErrorCode = -22;
                netResponse.exception = e3.getMessage();
                return netResponse;
            } catch (SocketException e4) {
                netResponse.netErrorCode = -12;
                netResponse.exception = e4.getMessage();
                return netResponse;
            } catch (SocketTimeoutException e5) {
                netResponse.netErrorCode = -13;
                netResponse.exception = e5.getMessage();
                return netResponse;
            } catch (UnknownHostException e6) {
                netResponse.netErrorCode = -21;
                netResponse.exception = e6.getMessage();
                return netResponse;
            } catch (SSLException e7) {
                netResponse.netErrorCode = -20;
                netResponse.exception = e7.getMessage();
                return netResponse;
            } catch (IOException e8) {
                netResponse.netErrorCode = -19;
                netResponse.exception = e8.getMessage();
                return netResponse;
            } catch (Throwable th) {
                netResponse.netErrorCode = -10;
                netResponse.exception = th.getMessage();
                return netResponse;
            }
        }
        return (NetResponse) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public NetResponse postSync(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            Map<String, Object> map2 = this.f17153e;
            Boolean bool = (map2 == null || !(map2.get(LiveNetConstants.EXTRA_KEY_ENABLE_STAT) instanceof Boolean)) ? null : (Boolean) this.f17153e.get(LiveNetConstants.EXTRA_KEY_ENABLE_STAT);
            Map<String, Object> map3 = this.f17153e;
            Integer num = (map3 == null || !(map3.get(LiveNetConstants.EXTRA_KEY_REQUEST_FROM) instanceof Integer)) ? null : (Integer) this.f17153e.get(LiveNetConstants.EXTRA_KEY_REQUEST_FROM);
            Map<String, Object> map4 = this.f17153e;
            if (map4 != null && (map4.get(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM) instanceof Integer)) {
                Integer num2 = (Integer) this.f17153e.get(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM);
            }
            NetResponse netResponse = new NetResponse();
            try {
                PostFormRequest.PostFormRequestBuilder postFormRequest = HttpManager.getDefault(TbadkCoreApplication.getInst()).postFormRequest();
                if (bool != null) {
                    postFormRequest.enableStat(bool.booleanValue());
                }
                if (num != null) {
                    postFormRequest.requestFrom(num.intValue());
                }
                Response executeSync = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) postFormRequest.url(this.a)).params(a(map)).addHeaders(this.f17152d)).connectionTimeout(this.f17150b)).readTimeout(this.f17151c)).cookieManager(CookieManager.WEBKIT_COOKIES)).build().executeSync();
                try {
                    netResponse.responseCode = executeSync.code();
                    netResponse.decodedResponseStr = executeSync.body() != null ? executeSync.body().string() : null;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return netResponse;
            } catch (ConnectException e3) {
                netResponse.netErrorCode = -22;
                netResponse.exception = e3.getMessage();
                return netResponse;
            } catch (SocketException e4) {
                netResponse.netErrorCode = -12;
                netResponse.exception = e4.getMessage();
                return netResponse;
            } catch (SocketTimeoutException e5) {
                netResponse.netErrorCode = -13;
                netResponse.exception = e5.getMessage();
                return netResponse;
            } catch (UnknownHostException e6) {
                netResponse.netErrorCode = -21;
                netResponse.exception = e6.getMessage();
                return netResponse;
            } catch (SSLException e7) {
                netResponse.netErrorCode = -20;
                netResponse.exception = e7.getMessage();
                return netResponse;
            } catch (IOException e8) {
                netResponse.netErrorCode = -19;
                netResponse.exception = e8.getMessage();
                return netResponse;
            } catch (Throwable th) {
                netResponse.netErrorCode = -10;
                netResponse.exception = th.getMessage();
                return netResponse;
            }
        }
        return (NetResponse) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setConnectTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f17150b = i2;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setExtra(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
            this.f17153e = map;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setHeaderData(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            this.f17152d = hashMap;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setReadTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f17151c = i2;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setRetryCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.net.INetWork
    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.a = str;
        }
    }
}
