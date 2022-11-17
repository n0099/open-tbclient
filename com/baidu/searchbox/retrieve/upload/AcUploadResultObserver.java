package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.tieba.kl9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class AcUploadResultObserver implements kl9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "FetchAcUploadResult";
    public static final String TYPE_ACTIVE_UPLOAD = "acupload";
    public transient /* synthetic */ FieldHolder $fh;
    public ActiveUploadObserver mActiveUploadObserver;

    @Override // com.baidu.tieba.kl9
    public String getBizType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "acupload" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-394767600, "Lcom/baidu/searchbox/retrieve/upload/AcUploadResultObserver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-394767600, "Lcom/baidu/searchbox/retrieve/upload/AcUploadResultObserver;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public AcUploadResultObserver() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchActiveResult(boolean z, String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), str, str2, jSONObject}) == null) {
            if (this.mActiveUploadObserver == null) {
                this.mActiveUploadObserver = new ActiveUploadObserver();
            }
            List<IActiveUploadResult> list = this.mActiveUploadObserver.mActiveObserverList.getList();
            if (list != null && list.size() != 0) {
                for (IActiveUploadResult iActiveUploadResult : list) {
                    if (TextUtils.equals(iActiveUploadResult.getSource(), str)) {
                        if (z) {
                            iActiveUploadResult.onSuccess(str2, jSONObject);
                        } else {
                            iActiveUploadResult.onFailure(str2, jSONObject);
                        }
                    }
                }
            }
        }
    }

    private void statActiveUploadData(boolean z, ActiveUpObj activeUpObj, String str) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), activeUpObj, str}) != null) || activeUpObj == null || (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) == null) {
            return;
        }
        String fileType = activeUpObj.getFileType();
        if (TextUtils.isEmpty(fileType)) {
            return;
        }
        if (TextUtils.equals(fileType, "1")) {
            iStatTask.recordActiveUploadData(z, StatConstants.VALUE_TYPE_UPLOAD, activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        } else if (z) {
            iStatTask.recordActiveUploadData(true, "query", activeUpObj.getDataId(), activeUpObj.getType(), fileType);
            iStatTask.recordActiveUploadData(true, StatConstants.VALUE_TYPE_ZIP, activeUpObj.getDataId(), activeUpObj.getType(), fileType);
            iStatTask.recordActiveUploadData(true, StatConstants.VALUE_TYPE_UPLOAD, activeUpObj.getDataId(), activeUpObj.getType(), fileType);
        } else if (TextUtils.equals("dir not found", str)) {
            iStatTask.recordActiveUploadData(false, "query", activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        } else if (TextUtils.equals("zip failed", str)) {
            iStatTask.recordActiveUploadData(true, "query", activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
            iStatTask.recordActiveUploadData(false, StatConstants.VALUE_TYPE_ZIP, activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        } else {
            iStatTask.recordActiveUploadData(true, "query", activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
            iStatTask.recordActiveUploadData(true, StatConstants.VALUE_TYPE_ZIP, activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
            iStatTask.recordActiveUploadData(false, StatConstants.VALUE_TYPE_UPLOAD, activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        }
    }

    @Override // com.baidu.tieba.kl9
    public void onReceiveResult(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        String jSONObject3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, str2, jSONObject, jSONObject2}) == null) {
            if (jSONObject2 != null && jSONObject2.length() != 0) {
                String optString = jSONObject2.optString("type");
                String optString2 = jSONObject2.optString("source");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = optString;
                }
                String optString3 = jSONObject2.optString("dataId");
                List asList = Arrays.asList(jSONObject2.optString("space"));
                String optString4 = jSONObject2.optString(UploadConstant.KEY_FILE_TYPE);
                if (jSONObject == null) {
                    jSONObject3 = "";
                } else {
                    jSONObject3 = jSONObject.toString();
                }
                ActiveUpObj activeUpObj = new ActiveUpObj(optString, optString3, asList, jSONObject3);
                activeUpObj.setFileType(optString4);
                if (z) {
                    if (DEBUG) {
                        Log.d(TAG, str + " has received active upload success");
                    }
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(str2)) {
                        activeUpObj.setFileID(str2);
                        statActiveUploadData(true, activeUpObj, "");
                        ActiveUploadManager.getInstance().activeUploadReportContent(activeUpObj, new IActiveUploadListener(this, optString2, str2, jSONObject2) { // from class: com.baidu.searchbox.retrieve.upload.AcUploadResultObserver.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AcUploadResultObserver this$0;
                            public final /* synthetic */ JSONObject val$extInfo;
                            public final /* synthetic */ String val$invokeSource;
                            public final /* synthetic */ String val$msg;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, optString2, str2, jSONObject2};
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
                                this.val$invokeSource = optString2;
                                this.val$msg = str2;
                                this.val$extInfo = jSONObject2;
                            }

                            @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                            public void onFailure(String str3) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str3) == null) {
                                    if (AcUploadResultObserver.DEBUG) {
                                        Log.d(AcUploadResultObserver.TAG, "active upload file, success: but failed to report to performance platform. errMsg is :" + str3);
                                    }
                                    this.this$0.dispatchActiveResult(false, this.val$invokeSource, this.val$msg, this.val$extInfo);
                                }
                            }

                            @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                            public void onSuccess() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    if (AcUploadResultObserver.DEBUG) {
                                        Log.d(AcUploadResultObserver.TAG, "active upload success: has reported to performance platform. ");
                                    }
                                    this.this$0.dispatchActiveResult(true, this.val$invokeSource, this.val$msg, this.val$extInfo);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (DEBUG) {
                    Log.d(TAG, "Active upload failed");
                }
                statActiveUploadData(false, activeUpObj, str2);
                dispatchActiveResult(false, optString2, str2, jSONObject2);
            } else if (DEBUG) {
                Log.d(TAG, "Active upload result: " + z + ", bizType: " + str);
            }
        }
    }
}
