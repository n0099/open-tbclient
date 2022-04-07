package com.baidu.searchbox.bddownload.core.download;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.exception.DownloadSecurityException;
import com.baidu.searchbox.bddownload.core.listener.DownloadListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class ConnectTrial {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN;
    public static final Pattern CONTENT_DISPOSITION_QUOTED_PATTERN;
    public static final String TAG = "ConnectTrial";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean acceptRange;
    @NonNull
    public final BreakpointInfo info;
    @IntRange(from = -1)
    public long instanceLength;
    public int responseCode;
    @Nullable
    public String responseEtag;
    @Nullable
    public String responseFileType;
    @Nullable
    public String responseFilename;
    @NonNull
    public final DownloadTask task;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-999897555, "Lcom/baidu/searchbox/bddownload/core/download/ConnectTrial;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-999897555, "Lcom/baidu/searchbox/bddownload/core/download/ConnectTrial;");
                return;
            }
        }
        CONTENT_DISPOSITION_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
        CONTENT_DISPOSITION_NON_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
    }

    public ConnectTrial(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadTask, breakpointInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.task = downloadTask;
        this.info = breakpointInfo;
    }

    @Nullable
    public static String findContentType(DownloadConnection.Connected connected) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, connected)) == null) ? connected.getResponseHeaderField(Util.CONTENT_TYPE) : (String) invokeL.objValue;
    }

    @Nullable
    public static String findEtag(DownloadConnection.Connected connected) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, connected)) == null) ? connected.getResponseHeaderField(Util.ETAG) : (String) invokeL.objValue;
    }

    @Nullable
    public static String findFilename(DownloadConnection.Connected connected) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, connected)) == null) ? parseContentDisposition(connected.getResponseHeaderField("Content-Disposition")) : (String) invokeL.objValue;
    }

    public static long findInstanceLength(DownloadConnection.Connected connected) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, connected)) == null) {
            long parseContentRangeFoInstanceLength = parseContentRangeFoInstanceLength(connected.getResponseHeaderField("Content-Range"));
            if (parseContentRangeFoInstanceLength != -1) {
                return parseContentRangeFoInstanceLength;
            }
            if (!parseTransferEncoding(connected.getResponseHeaderField("Transfer-Encoding"))) {
                Util.w(TAG, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    @Nullable
    public static String parseContentDisposition(String str) throws IOException {
        InterceptResult invokeL;
        String group;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                Matcher matcher = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(str);
                if (matcher.find()) {
                    group = matcher.group(1);
                } else {
                    Matcher matcher2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(str);
                    group = matcher2.find() ? matcher2.group(1) : null;
                }
                if (group != null && group.contains("../")) {
                    throw new DownloadSecurityException("The filename [" + group + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
                }
                return group;
            } catch (IllegalStateException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static long parseContentRangeFoInstanceLength(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null) {
                return -1L;
            }
            String[] split = str.split("/");
            if (split.length >= 2) {
                try {
                    return Long.parseLong(split[1]);
                } catch (NumberFormatException unused) {
                    Util.w(TAG, "parse instance length failed with " + str);
                }
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static boolean parseTransferEncoding(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? str != null && str.equals("chunked") : invokeL.booleanValue;
    }

    public void executeTrial() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdDownload.with().downloadStrategy().inspectNetworkOnWifi(this.task);
            BdDownload.with().downloadStrategy().inspectNetworkAvailable();
            DownloadConnection create = BdDownload.with().connectionFactory().create(this.task.getUrl());
            try {
                if (!Util.isEmpty(this.info.getEtag())) {
                    create.addHeader(Util.IF_MATCH, this.info.getEtag());
                }
                create.addHeader("Range", "bytes=0-0");
                Map<String, List<String>> headerMapFields = this.task.getHeaderMapFields();
                if (headerMapFields != null) {
                    Util.addUserRequestHeaderField(headerMapFields, create);
                }
                DownloadListener dispatch = BdDownload.with().callbackDispatcher().dispatch();
                dispatch.connectTrialStart(this.task, create.getRequestProperties());
                DownloadConnection.Connected execute = create.execute();
                this.task.setRedirectLocation(execute.getRedirectLocation());
                Util.d(TAG, "task[" + this.task.getId() + "] redirect location: " + this.task.getRedirectLocation());
                this.responseCode = execute.getResponseCode();
                this.acceptRange = isAcceptRange(execute);
                this.instanceLength = findInstanceLength(execute);
                this.responseEtag = findEtag(execute);
                this.responseFilename = findFilename(execute);
                this.responseFileType = findContentType(execute);
                Map<String, List<String>> responseHeaderFields = execute.getResponseHeaderFields();
                if (responseHeaderFields == null) {
                    responseHeaderFields = new HashMap<>();
                }
                dispatch.connectTrialEnd(this.task, this.responseCode, responseHeaderFields);
                if (isNeedTrialHeadMethodForInstanceLength(this.instanceLength, execute)) {
                    trialHeadMethodForInstanceLength();
                }
            } finally {
                create.release();
            }
        }
    }

    public long getInstanceLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.instanceLength : invokeV.longValue;
    }

    public int getResponseCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.responseCode : invokeV.intValue;
    }

    @Nullable
    public String getResponseContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.responseFileType : (String) invokeV.objValue;
    }

    @Nullable
    public String getResponseEtag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.responseEtag : (String) invokeV.objValue;
    }

    @Nullable
    public String getResponseFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.responseFilename : (String) invokeV.objValue;
    }

    public boolean isAcceptRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.acceptRange : invokeV.booleanValue;
    }

    public boolean isChunked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.instanceLength == -1 : invokeV.booleanValue;
    }

    public boolean isEtagOverdue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.info.getEtag() == null || this.info.getEtag().equals(this.responseEtag)) ? false : true : invokeV.booleanValue;
    }

    public boolean isNeedTrialHeadMethodForInstanceLength(long j, @NonNull DownloadConnection.Connected connected) {
        InterceptResult invokeJL;
        String responseHeaderField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, connected)) == null) {
            if (j != -1) {
                return false;
            }
            String responseHeaderField2 = connected.getResponseHeaderField("Content-Range");
            return (responseHeaderField2 == null || responseHeaderField2.length() <= 0) && !parseTransferEncoding(connected.getResponseHeaderField("Transfer-Encoding")) && (responseHeaderField = connected.getResponseHeaderField("Content-Length")) != null && responseHeaderField.length() > 0;
        }
        return invokeJL.booleanValue;
    }

    public void trialHeadMethodForInstanceLength() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            DownloadConnection create = BdDownload.with().connectionFactory().create(this.task.getUrl());
            DownloadListener dispatch = BdDownload.with().callbackDispatcher().dispatch();
            try {
                create.setRequestMethod("HEAD");
                Map<String, List<String>> headerMapFields = this.task.getHeaderMapFields();
                if (headerMapFields != null) {
                    Util.addUserRequestHeaderField(headerMapFields, create);
                }
                dispatch.connectTrialStart(this.task, create.getRequestProperties());
                DownloadConnection.Connected execute = create.execute();
                dispatch.connectTrialEnd(this.task, execute.getResponseCode(), execute.getResponseHeaderFields());
                this.instanceLength = Util.parseContentLength(execute.getResponseHeaderField("Content-Length"));
            } finally {
                create.release();
            }
        }
    }

    public static boolean isAcceptRange(@NonNull DownloadConnection.Connected connected) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, connected)) == null) {
            if (connected.getResponseCode() == 206) {
                return true;
            }
            return "bytes".equals(connected.getResponseHeaderField(Util.ACCEPT_RANGES));
        }
        return invokeL.booleanValue;
    }
}
