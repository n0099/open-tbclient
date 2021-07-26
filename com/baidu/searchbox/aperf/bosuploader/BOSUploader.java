package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.CompleteMultipartUploadRequest;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import com.baidubce.services.bos.model.InitiateMultipartUploadRequest;
import com.baidubce.services.bos.model.InitiateMultipartUploadResponse;
import com.baidubce.services.bos.model.UploadPartRequest;
import com.baidubce.services.bos.model.UploadPartResponse;
import d.a.n.b.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class BOSUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String OS_ANDROID = "android";
    public static final long PART_SIZE = 5242880;
    public static final String TAG = "BOSUploader";
    public static final int TOKEN_NOT_VALID = 403;
    public static volatile BOSUploader sSingleton;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1573585503, "Lcom/baidu/searchbox/aperf/bosuploader/BOSUploader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1573585503, "Lcom/baidu/searchbox/aperf/bosuploader/BOSUploader;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public BOSUploader() {
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

    private BosClient createBosClient(@NonNull STSInfo sTSInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, sTSInfo)) == null) {
            if (TextUtils.isEmpty(sTSInfo.ak) || TextUtils.isEmpty(sTSInfo.sk) || TextUtils.isEmpty(sTSInfo.token)) {
                return null;
            }
            BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
            bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(sTSInfo.ak, sTSInfo.sk, sTSInfo.token));
            bosClientConfiguration.setEndpoint(sTSInfo.endpoint);
            return new BosClient(bosClientConfiguration);
        }
        return (BosClient) invokeL.objValue;
    }

    public static BOSUploader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sSingleton == null) {
                synchronized (BOSUploader.class) {
                    if (sSingleton == null) {
                        sSingleton = new BOSUploader();
                    }
                }
            }
            return sSingleton;
        }
        return (BOSUploader) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0134 A[Catch: Exception -> 0x015d, JSONException -> 0x015f, BceClientException -> 0x0161, BceServiceException -> 0x0163, TryCatch #6 {BceServiceException -> 0x0163, BceClientException -> 0x0161, JSONException -> 0x015f, Exception -> 0x015d, blocks: (B:21:0x004a, B:23:0x0056, B:25:0x0064, B:27:0x007c, B:28:0x007e, B:67:0x0159, B:68:0x015c, B:61:0x0120, B:62:0x0123, B:64:0x0134, B:65:0x014e, B:53:0x0112), top: B:112:0x004a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BOSResponseEntity uploadFileSyncPart(STSInfo sTSInfo, @NonNull String str, @NonNull String str2, @NonNull File file) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, sTSInfo, str, str2, file)) != null) {
            return (BOSResponseEntity) invokeLLLL.objValue;
        }
        int i2 = 0;
        try {
            if (sTSInfo == null) {
                return new BOSResponseEntity(false, "stsInfo is null");
            }
            BosClient createBosClient = createBosClient(sTSInfo);
            if (createBosClient == null) {
                return new BOSResponseEntity(false, "mBosClient is null");
            }
            String str3 = sTSInfo.bucket;
            if (TextUtils.isEmpty(str3)) {
                return new BOSResponseEntity(false, "bucketName is null");
            }
            long length = file.length();
            if (length == 0) {
                return new BOSResponseEntity(false, "fileLength is 0");
            }
            try {
                String createObjectKey = createObjectKey(str, str2);
                long j = 5242880;
                if (length <= 5242880) {
                    return new BOSResponseEntity(true, createBosClient.putObject(str3, createObjectKey, file).getETag());
                }
                InitiateMultipartUploadResponse initiateMultipartUpload = createBosClient.initiateMultipartUpload(new InitiateMultipartUploadRequest(str3, createObjectKey));
                int length2 = (int) (file.length() / 5242880);
                if (file.length() % 5242880 != 0) {
                    length2++;
                }
                ArrayList arrayList = new ArrayList(length2);
                FileInputStream fileInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        int i3 = 0;
                        while (i3 < length2) {
                            long j2 = i3 * j;
                            try {
                                long length3 = j < file.length() - j2 ? j : file.length() - j2;
                                int i4 = (int) length3;
                                byte[] bArr = new byte[i4];
                                while (true) {
                                    int read = fileInputStream2.read(bArr, i2, i4);
                                    i2 += read;
                                    if (read < 0) {
                                        break;
                                    }
                                    int i5 = i4;
                                    if (i2 >= length3) {
                                        break;
                                    }
                                    i4 = i5;
                                }
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                                uploadPartRequest.setBucketName(str3);
                                uploadPartRequest.setKey(createObjectKey);
                                uploadPartRequest.setUploadId(initiateMultipartUpload.getUploadId());
                                uploadPartRequest.setInputStream(byteArrayInputStream);
                                uploadPartRequest.setPartSize(length3);
                                i3++;
                                uploadPartRequest.setPartNumber(i3);
                                UploadPartResponse uploadPart = createBosClient.uploadPart(uploadPartRequest);
                                arrayList.add(uploadPart.getPartETag());
                                if (DEBUG) {
                                    String str4 = TAG;
                                    Log.d(str4, "partETags etag " + uploadPart.getPartETag());
                                }
                                i2 = 0;
                                j = 5242880;
                            } catch (IOException e2) {
                                e = e2;
                                fileInputStream = fileInputStream2;
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(fileInputStream);
                                CompleteMultipartUploadResponse completeMultipartUpload = createBosClient.completeMultipartUpload(new CompleteMultipartUploadRequest(str3, createObjectKey, initiateMultipartUpload.getUploadId(), arrayList));
                                if (DEBUG) {
                                }
                                return new BOSResponseEntity(true, completeMultipartUpload.getETag());
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                Closeables.closeSafely(fileInputStream);
                                throw th;
                            }
                        }
                        Closeables.closeSafely(fileInputStream2);
                    } catch (IOException e3) {
                        e = e3;
                    }
                    CompleteMultipartUploadResponse completeMultipartUpload2 = createBosClient.completeMultipartUpload(new CompleteMultipartUploadRequest(str3, createObjectKey, initiateMultipartUpload.getUploadId(), arrayList));
                    if (DEBUG) {
                        String str5 = TAG;
                        Log.d(str5, "PutObjectResponse etag " + completeMultipartUpload2.getETag());
                    }
                    return new BOSResponseEntity(true, completeMultipartUpload2.getETag());
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (BceServiceException e4) {
                e = e4;
                if (DEBUG) {
                    String str6 = TAG;
                    Log.e(str6, "Error Message: " + e.getMessage());
                }
                return new BOSResponseEntity(false, e.getMessage(), e.getStatusCode());
            } catch (BceClientException e5) {
                e = e5;
                if (DEBUG) {
                    String str7 = TAG;
                    Log.e(str7, "BceClientException Error Message:" + e.getMessage());
                }
                return new BOSResponseEntity(false, e.getMessage());
            } catch (JSONException e6) {
                e = e6;
                if (DEBUG) {
                    String str8 = TAG;
                    Log.e(str8, "JSONException Message: " + e.getMessage());
                }
                return new BOSResponseEntity(false, e.getMessage());
            } catch (Exception e7) {
                e = e7;
                return new BOSResponseEntity(false, e.getMessage());
            }
        } catch (BceServiceException e8) {
            e = e8;
        } catch (BceClientException e9) {
            e = e9;
        } catch (JSONException e10) {
            e = e10;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public String createObjectKey(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            return a.b().a() + "/android/" + str + "/" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public BOSResponseEntity uploadFileSync(@NonNull String str, @NonNull String str2, @NonNull File file, @NonNull UploadUrlListener uploadUrlListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, file, uploadUrlListener)) == null) {
            UploadUrlProvider.getInstance().setUploadUrlListener(uploadUrlListener);
            return uploadFileSync(str, str2, file);
        }
        return (BOSResponseEntity) invokeLLLL.objValue;
    }

    public BOSResponseEntity uploadFileSync(@NonNull String str, @NonNull String str2, @NonNull File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, file)) == null) {
            BOSResponseEntity uploadFileSyncPart = uploadFileSyncPart(STSManager.getCurrentStsInfo(str), str, str2, file);
            return (uploadFileSyncPart.isSuccess() || uploadFileSyncPart.getErrorCode() == 0 || !STSManager.checkRetry(str)) ? uploadFileSyncPart : uploadFileSyncPart(STSManager.retryGetStsInfo(str), str, str2, file);
        }
        return (BOSResponseEntity) invokeLLL.objValue;
    }
}
