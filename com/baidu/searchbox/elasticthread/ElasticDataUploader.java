package com.baidu.searchbox.elasticthread;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ElasticDataUploader {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ElasticDataUploader sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public IUploader mUploaderImpl;

    /* loaded from: classes9.dex */
    public interface IUploader {
        void uploadStatisticData(JSONObject jSONObject);

        void uploadWarningData(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2092870072, "Lcom/baidu/searchbox/elasticthread/ElasticDataUploader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2092870072, "Lcom/baidu/searchbox/elasticthread/ElasticDataUploader;");
        }
    }

    public ElasticDataUploader() {
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

    public static ElasticDataUploader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sInstance == null) {
                synchronized (ElasticDataUploader.class) {
                    if (sInstance == null) {
                        sInstance = new ElasticDataUploader();
                    }
                }
            }
            return sInstance;
        }
        return (ElasticDataUploader) invokeV.objValue;
    }

    public void setUploader(IUploader iUploader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iUploader) == null) {
            this.mUploaderImpl = iUploader;
        }
    }

    public void uploadStatisticData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable(this, jSONObject) { // from class: com.baidu.searchbox.elasticthread.ElasticDataUploader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ElasticDataUploader this$0;
                public final /* synthetic */ JSONObject val$content;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$content = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mUploaderImpl == null) {
                        return;
                    }
                    this.this$0.mUploaderImpl.uploadStatisticData(this.val$content);
                }
            }, "upload_statistic_data", 3);
        }
    }

    public void uploadWarningData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable(this, jSONObject) { // from class: com.baidu.searchbox.elasticthread.ElasticDataUploader.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ElasticDataUploader this$0;
                public final /* synthetic */ JSONObject val$content;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$content = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mUploaderImpl == null) {
                        return;
                    }
                    this.this$0.mUploaderImpl.uploadWarningData(this.val$content);
                }
            }, "upload_warning_data", 3);
        }
    }
}
