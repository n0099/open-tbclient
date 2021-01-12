package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import com.baidu.d.b.a;
import com.baidu.searchbox.config.AppConfig;
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
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class BOSUploader {
    private static final String OS_ANDROID = "android";
    private static final long PART_SIZE = 5242880;
    private static final int TOKEN_NOT_VALID = 403;
    private static volatile BOSUploader sSingleton;
    private static final String TAG = BOSUploader.class.getSimpleName();
    private static final boolean DEBUG = AppConfig.isDebug();

    public static BOSUploader getInstance() {
        if (sSingleton == null) {
            synchronized (BOSUploader.class) {
                if (sSingleton == null) {
                    sSingleton = new BOSUploader();
                }
            }
        }
        return sSingleton;
    }

    private BOSUploader() {
    }

    private BosClient createBosClient(@NonNull STSInfo sTSInfo) {
        if (TextUtils.isEmpty(sTSInfo.ak) || TextUtils.isEmpty(sTSInfo.sk) || TextUtils.isEmpty(sTSInfo.token)) {
            return null;
        }
        BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
        bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(sTSInfo.ak, sTSInfo.sk, sTSInfo.token));
        bosClientConfiguration.setEndpoint(sTSInfo.endpoint);
        return new BosClient(bosClientConfiguration);
    }

    public BOSResponseEntity uploadFileSync(@NonNull String str, @NonNull String str2, @NonNull File file, @NonNull UploadUrlListener uploadUrlListener) {
        UploadUrlProvider.getInstance().setUploadUrlListener(uploadUrlListener);
        return uploadFileSync(str, str2, file);
    }

    public BOSResponseEntity uploadFileSync(@NonNull String str, @NonNull String str2, @NonNull File file) {
        BOSResponseEntity uploadFileSyncPart = uploadFileSyncPart(STSManager.getCurrentStsInfo(str), str, str2, file);
        if (!uploadFileSyncPart.isSuccess() && uploadFileSyncPart.getErrorCode() != 0 && STSManager.checkRetry(str)) {
            return uploadFileSyncPart(STSManager.retryGetStsInfo(str), str, str2, file);
        }
        return uploadFileSyncPart;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x0214 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d8 A[Catch: BceServiceException -> 0x001c, BceClientException -> 0x0062, JSONException -> 0x00a6, Exception -> 0x00f8, TryCatch #5 {BceServiceException -> 0x001c, BceClientException -> 0x0062, JSONException -> 0x00a6, Exception -> 0x00f8, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0012, B:14:0x004e, B:16:0x0058, B:23:0x0091, B:25:0x009b, B:32:0x00d5, B:34:0x00e6, B:38:0x0106, B:40:0x0126, B:41:0x0129, B:75:0x0210, B:76:0x0213, B:72:0x020a, B:62:0x01c7, B:64:0x01d8, B:65:0x01f5, B:61:0x01c4), top: B:86:0x0000 }] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BOSResponseEntity uploadFileSyncPart(STSInfo sTSInfo, @NonNull String str, @NonNull String str2, @NonNull File file) {
        FileInputStream fileInputStream;
        UploadPartResponse uploadPart;
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
            String createObjectKey = createObjectKey(str, str2);
            if (length <= 5242880) {
                return new BOSResponseEntity(true, createBosClient.putObject(str3, createObjectKey, file).getETag());
            }
            InitiateMultipartUploadResponse initiateMultipartUpload = createBosClient.initiateMultipartUpload(new InitiateMultipartUploadRequest(str3, createObjectKey));
            int length2 = (int) (file.length() / 5242880);
            ?? r5 = ((file.length() % 5242880) > 0L ? 1 : ((file.length() % 5242880) == 0L ? 0 : -1));
            int i = r5 != 0 ? length2 + 1 : length2;
            ArrayList arrayList = new ArrayList(i);
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    for (int i2 = 0; i2 < i; i2++) {
                        long j = 5242880 * i2;
                        try {
                            long length3 = 5242880 < file.length() - j ? 5242880L : file.length() - j;
                            byte[] bArr = new byte[(int) length3];
                            int i3 = 0;
                            do {
                                int read = fileInputStream.read(bArr, i3, (int) length3);
                                i3 += read;
                                if (read < 0) {
                                    break;
                                }
                            } while (i3 < length3);
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            UploadPartRequest uploadPartRequest = new UploadPartRequest();
                            uploadPartRequest.setBucketName(str3);
                            uploadPartRequest.setKey(createObjectKey);
                            uploadPartRequest.setUploadId(initiateMultipartUpload.getUploadId());
                            uploadPartRequest.setInputStream(byteArrayInputStream);
                            uploadPartRequest.setPartSize(length3);
                            uploadPartRequest.setPartNumber(i2 + 1);
                            arrayList.add(createBosClient.uploadPart(uploadPartRequest).getPartETag());
                            if (DEBUG) {
                                Log.d(TAG, "partETags etag " + uploadPart.getPartETag());
                            }
                        } catch (IOException e) {
                            e = e;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(fileInputStream);
                            CompleteMultipartUploadResponse completeMultipartUpload = createBosClient.completeMultipartUpload(new CompleteMultipartUploadRequest(str3, createObjectKey, initiateMultipartUpload.getUploadId(), arrayList));
                            if (DEBUG) {
                            }
                            return new BOSResponseEntity(true, completeMultipartUpload.getETag());
                        }
                    }
                    Closeables.closeSafely(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely((Closeable) r5);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r5 = 0;
                Closeables.closeSafely((Closeable) r5);
                throw th;
            }
            CompleteMultipartUploadResponse completeMultipartUpload2 = createBosClient.completeMultipartUpload(new CompleteMultipartUploadRequest(str3, createObjectKey, initiateMultipartUpload.getUploadId(), arrayList));
            if (DEBUG) {
                Log.d(TAG, "PutObjectResponse etag " + completeMultipartUpload2.getETag());
            }
            return new BOSResponseEntity(true, completeMultipartUpload2.getETag());
        } catch (BceServiceException e3) {
            if (DEBUG) {
                Log.e(TAG, "Error Message: " + e3.getMessage());
            }
            return new BOSResponseEntity(false, e3.getMessage(), e3.getStatusCode());
        } catch (BceClientException e4) {
            if (DEBUG) {
                Log.e(TAG, "BceClientException Error Message:" + e4.getMessage());
            }
            return new BOSResponseEntity(false, e4.getMessage());
        } catch (JSONException e5) {
            if (DEBUG) {
                Log.e(TAG, "JSONException Message: " + e5.getMessage());
            }
            return new BOSResponseEntity(false, e5.getMessage());
        } catch (Exception e6) {
            return new BOSResponseEntity(false, e6.getMessage());
        }
    }

    public String createObjectKey(@NonNull String str, @NonNull String str2) {
        return a.uf().getAppName() + "/android/" + str + "/" + str2;
    }
}
