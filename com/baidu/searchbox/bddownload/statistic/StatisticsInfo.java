package com.baidu.searchbox.bddownload.statistic;

import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.retrieve.upload.UploadConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u0018:\u0002\u0019\u0018B\u0011\b\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B-\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0001\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0004\b\u0012\u0010\u0017R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R%\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;", "", TTDownloadField.TT_DOWNLOAD_URL, "Ljava/lang/String;", "getDownloadUrl", "()Ljava/lang/String;", "setDownloadUrl", "(Ljava/lang/String;)V", "Ljava/util/HashMap;", "extraInfo", "Ljava/util/HashMap;", "getExtraInfo", "()Ljava/util/HashMap;", UploadConstant.KEY_FILE_TYPE, "getFileType", "setFileType", "Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo$Builder;", "builder", "<init>", "(Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo$Builder;)V", "url", "type", "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "Companion", "Builder", "lib-bddownload_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class StatisticsInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public String downloadUrl;
    public final HashMap extraInfo;
    public String fileType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1356092928, "Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1356092928, "Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\"\b\u0016\u0012\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001d¢\u0006\u0004\b\u001f\u0010 B\u0007¢\u0006\u0004\b\u001f\u0010!J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo$Builder;", "Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;", "build", "()Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;", "", "url", "buildDownloadUrl", "(Ljava/lang/String;)Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo$Builder;", "Ljava/util/HashMap;", "info", "buildExtraInfo", "(Ljava/util/HashMap;)Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo$Builder;", "type", "buildFileType", TTDownloadField.TT_DOWNLOAD_URL, "Ljava/lang/String;", "getDownloadUrl", "()Ljava/lang/String;", "setDownloadUrl", "(Ljava/lang/String;)V", "extraInfo", "Ljava/util/HashMap;", "getExtraInfo", "()Ljava/util/HashMap;", UploadConstant.KEY_FILE_TYPE, "getFileType", "setFileType", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "init", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "()V", "lib-bddownload_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String downloadUrl;
        public final HashMap extraInfo;
        public String fileType;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.downloadUrl = "";
            this.fileType = "";
            this.extraInfo = new HashMap();
        }

        public final StatisticsInfo build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new StatisticsInfo(this, null);
            }
            return (StatisticsInfo) invokeV.objValue;
        }

        public final String getDownloadUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.downloadUrl;
            }
            return (String) invokeV.objValue;
        }

        public final HashMap getExtraInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.extraInfo;
            }
            return (HashMap) invokeV.objValue;
        }

        public final String getFileType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.fileType;
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Function1 init) {
            this();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {init};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(init, "init");
            init.invoke(this);
        }

        public final Builder buildExtraInfo(HashMap info) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, info)) == null) {
                Intrinsics.checkNotNullParameter(info, "info");
                for (Map.Entry entry : info.entrySet()) {
                    this.extraInfo.put(entry.getKey(), entry.getValue());
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder buildDownloadUrl(String url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.downloadUrl = url;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder buildFileType(String type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, type)) == null) {
                Intrinsics.checkNotNullParameter(type, "type");
                this.fileType = type;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setDownloadUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.downloadUrl = str;
            }
        }

        public final void setFileType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.fileType = str;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ&\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo$Companion;", "Lkotlin/Function1;", "Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo$Builder;", "", "Lkotlin/ExtensionFunctionType;", "init", "Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;", "build", "(Lkotlin/Function1;)Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;", "<init>", "()V", "lib-bddownload_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StatisticsInfo build(Function1 init) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, init)) == null) {
                Intrinsics.checkNotNullParameter(init, "init");
                return new Builder(init).build();
            }
            return (StatisticsInfo) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatisticsInfo(Builder builder) {
        this(builder.getDownloadUrl(), builder.getFileType(), builder.getExtraInfo());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (HashMap) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.downloadUrl = builder.getDownloadUrl();
        this.fileType = builder.getFileType();
        for (Map.Entry entry : builder.getExtraInfo().entrySet()) {
            this.extraInfo.put(entry.getKey(), entry.getValue());
        }
    }

    public /* synthetic */ StatisticsInfo(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public StatisticsInfo(String str, String str2, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, hashMap};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.extraInfo = new HashMap();
        Context context = BdDownload.with().context();
        if (context == null) {
            this.extraInfo.put("hostPkgName", "");
        } else {
            this.extraInfo.put("hostPkgName", context.getPackageName());
        }
        this.extraInfo.put("hostVer", Build.VERSION.RELEASE);
        this.extraInfo.put("deviceBrand", Build.BRAND);
        this.extraInfo.put("deviceModel", Build.MODEL);
        this.extraInfo.put("deviceOS", String.valueOf(Build.VERSION.SDK_INT));
        for (Map.Entry entry : hashMap.entrySet()) {
            this.extraInfo.put(entry.getKey(), entry.getValue());
        }
    }

    public final String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.downloadUrl;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TTDownloadField.TT_DOWNLOAD_URL);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final HashMap getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.extraInfo;
        }
        return (HashMap) invokeV.objValue;
    }

    public final String getFileType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.fileType;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(UploadConstant.KEY_FILE_TYPE);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final void setDownloadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.downloadUrl = str;
        }
    }

    public final void setFileType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.fileType = str;
        }
    }
}
