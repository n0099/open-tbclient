package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.common.config.AppIdentityManager;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
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

    private BosClient createBosClient(@NonNull STSInfo sTSInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, sTSInfo)) == null) {
            if (!TextUtils.isEmpty(sTSInfo.ak) && !TextUtils.isEmpty(sTSInfo.sk) && !TextUtils.isEmpty(sTSInfo.token)) {
                BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
                bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(sTSInfo.ak, sTSInfo.sk, sTSInfo.token));
                bosClientConfiguration.setEndpoint(sTSInfo.endpoint);
                return new BosClient(bosClientConfiguration);
            }
            return null;
        }
        return (BosClient) invokeL.objValue;
    }

    private BOSResponseEntity uploadByteSync(STSInfo sTSInfo, @NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, sTSInfo, str, str2, bArr)) == null) {
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
                if (bArr.length > 104857600) {
                    return new BOSResponseEntity(false, "byte array is too big");
                }
                return new BOSResponseEntity(true, createBosClient.putObject(str3, createObjectKey(str, str2), bArr).getETag());
            } catch (BceServiceException e) {
                if (DEBUG) {
                    String str4 = TAG;
                    Log.e(str4, "Error Message: " + e.getMessage());
                }
                return new BOSResponseEntity(false, e.getMessage(), e.getStatusCode());
            } catch (BceClientException e2) {
                if (DEBUG) {
                    String str5 = TAG;
                    Log.e(str5, "BceClientException Error Message:" + e2.getMessage());
                }
                return new BOSResponseEntity(false, e2.getMessage());
            } catch (Exception e3) {
                return new BOSResponseEntity(false, e3.getMessage());
            }
        }
        return (BOSResponseEntity) invokeLLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0134 A[Catch: Exception -> 0x015d, JSONException -> 0x015f, BceClientException -> 0x0161, BceServiceException -> 0x0163, TryCatch #6 {BceServiceException -> 0x0163, BceClientException -> 0x0161, JSONException -> 0x015f, Exception -> 0x015d, blocks: (B:21:0x004a, B:23:0x0056, B:25:0x0064, B:27:0x007c, B:28:0x007e, B:67:0x0159, B:68:0x015c, B:61:0x0120, B:62:0x0123, B:64:0x0134, B:65:0x014e, B:53:0x0112), top: B:112:0x004a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BOSResponseEntity uploadFileSyncPart(STSInfo sTSInfo, @NonNull String str, @NonNull String str2, @NonNull File file) {
        InterceptResult invokeLLLL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, this, sTSInfo, str, str2, file)) == null) {
            int i = 0;
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
                long length2 = file.length();
                if (length2 == 0) {
                    return new BOSResponseEntity(false, "fileLength is 0");
                }
                try {
                    String createObjectKey = createObjectKey(str, str2);
                    long j = 5242880;
                    if (length2 <= 5242880) {
                        return new BOSResponseEntity(true, createBosClient.putObject(str3, createObjectKey, file).getETag());
                    }
                    InitiateMultipartUploadResponse initiateMultipartUpload = createBosClient.initiateMultipartUpload(new InitiateMultipartUploadRequest(str3, createObjectKey));
                    int length3 = (int) (file.length() / 5242880);
                    if (file.length() % 5242880 != 0) {
                        length3++;
                    }
                    ArrayList arrayList = new ArrayList(length3);
                    FileInputStream fileInputStream = null;
                    try {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            int i2 = 0;
                            while (i2 < length3) {
                                long j2 = i2 * j;
                                try {
                                    if (j < file.length() - j2) {
                                        length = j;
                                    } else {
                                        length = file.length() - j2;
                                    }
                                    int i3 = (int) length;
                                    byte[] bArr = new byte[i3];
                                    while (true) {
                                        int read = fileInputStream2.read(bArr, i, i3);
                                        i += read;
                                        if (read < 0) {
                                            break;
                                        }
                                        int i4 = i3;
                                        if (i >= length) {
                                            break;
                                        }
                                        i3 = i4;
                                    }
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    UploadPartRequest uploadPartRequest = new UploadPartRequest();
                                    uploadPartRequest.setBucketName(str3);
                                    uploadPartRequest.setKey(createObjectKey);
                                    uploadPartRequest.setUploadId(initiateMultipartUpload.getUploadId());
                                    uploadPartRequest.setInputStream(byteArrayInputStream);
                                    uploadPartRequest.setPartSize(length);
                                    i2++;
                                    uploadPartRequest.setPartNumber(i2);
                                    UploadPartResponse uploadPart = createBosClient.uploadPart(uploadPartRequest);
                                    arrayList.add(uploadPart.getPartETag());
                                    if (DEBUG) {
                                        String str4 = TAG;
                                        Log.d(str4, "partETags etag " + uploadPart.getPartETag());
                                    }
                                    i = 0;
                                    j = 5242880;
                                } catch (IOException e) {
                                    e = e;
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
                        } catch (IOException e2) {
                            e = e2;
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
                } catch (BceServiceException e3) {
                    e = e3;
                    if (DEBUG) {
                        String str6 = TAG;
                        Log.e(str6, "Error Message: " + e.getMessage());
                    }
                    return new BOSResponseEntity(false, e.getMessage(), e.getStatusCode());
                } catch (BceClientException e4) {
                    e = e4;
                    if (DEBUG) {
                        String str7 = TAG;
                        Log.e(str7, "BceClientException Error Message:" + e.getMessage());
                    }
                    return new BOSResponseEntity(false, e.getMessage());
                } catch (JSONException e5) {
                    e = e5;
                    if (DEBUG) {
                        String str8 = TAG;
                        Log.e(str8, "JSONException Message: " + e.getMessage());
                    }
                    return new BOSResponseEntity(false, e.getMessage());
                } catch (Exception e6) {
                    e = e6;
                    return new BOSResponseEntity(false, e.getMessage());
                }
            } catch (BceServiceException e7) {
                e = e7;
            } catch (BceClientException e8) {
                e = e8;
            } catch (JSONException e9) {
                e = e9;
            } catch (Exception e10) {
                e = e10;
            }
        } else {
            return (BOSResponseEntity) invokeLLLL.objValue;
        }
    }

    public String createObjectKey(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            return AppIdentityManager.getInstance().getAppName() + "/android/" + str + "/" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public BOSResponseEntity uploadByteSync(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, bArr)) == null) {
            BOSResponseEntity uploadByteSync = uploadByteSync(STSManager.getCurrentStsInfo(str), str, str2, bArr);
            if (!uploadByteSync.isSuccess() && uploadByteSync.getErrorCode() != 0 && STSManager.checkRetry(str)) {
                return uploadByteSync(STSManager.retryGetStsInfo(str), str, str2, bArr);
            }
            return uploadByteSync;
        }
        return (BOSResponseEntity) invokeLLL.objValue;
    }

    public BOSResponseEntity uploadFileSync(@NonNull String str, @NonNull String str2, @NonNull File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, file)) == null) {
            BOSResponseEntity uploadFileSyncPart = uploadFileSyncPart(STSManager.getCurrentStsInfo(str), str, str2, file);
            if (!uploadFileSyncPart.isSuccess() && uploadFileSyncPart.getErrorCode() != 0 && STSManager.checkRetry(str)) {
                return uploadFileSyncPart(STSManager.retryGetStsInfo(str), str, str2, file);
            }
            return uploadFileSyncPart;
        }
        return (BOSResponseEntity) invokeLLL.objValue;
    }

    public BOSResponseEntity uploadFileSync(@NonNull String str, @NonNull String str2, @NonNull File file, @NonNull UploadUrlListener uploadUrlListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, file, uploadUrlListener)) == null) {
            UploadUrlProvider.getInstance().setUploadUrlListener(uploadUrlListener);
            return uploadFileSync(str, str2, file);
        }
        return (BOSResponseEntity) invokeLLLL.objValue;
    }
}
