package com.baidu.fsg.base.restnet.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class HttpStatus {
    public static final /* synthetic */ HttpStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HttpStatus ACCEPTED;
    public static final HttpStatus ALREADY_REPORTED;
    public static final HttpStatus BAD_GATEWAY;
    public static final HttpStatus BAD_REQUEST;
    public static final HttpStatus BANDWIDTH_LIMIT_EXCEEDED;
    public static final HttpStatus CHECKPOINT;
    public static final HttpStatus CONFLICT;
    public static final HttpStatus CONTINUE;
    public static final HttpStatus CREATED;
    public static final HttpStatus DESTINATION_LOCKED;
    public static final HttpStatus EXPECTATION_FAILED;
    public static final HttpStatus FAILED_DEPENDENCY;
    public static final HttpStatus FORBIDDEN;
    public static final HttpStatus FOUND;
    public static final HttpStatus GATEWAY_TIMEOUT;
    public static final HttpStatus GONE;
    public static final HttpStatus HTTP_VERSION_NOT_SUPPORTED;
    public static final HttpStatus IM_USED;
    public static final HttpStatus INSUFFICIENT_SPACE_ON_RESOURCE;
    public static final HttpStatus INSUFFICIENT_STORAGE;
    public static final HttpStatus INTERNAL_SERVER_ERROR;
    public static final HttpStatus I_AM_A_TEAPOT;
    public static final HttpStatus LENGTH_REQUIRED;
    public static final HttpStatus LOCKED;
    public static final HttpStatus LOOP_DETECTED;
    public static final HttpStatus METHOD_FAILURE;
    public static final HttpStatus METHOD_NOT_ALLOWED;
    public static final HttpStatus MOVED_PERMANENTLY;
    public static final HttpStatus MOVED_TEMPORARILY;
    public static final HttpStatus MULTIPLE_CHOICES;
    public static final HttpStatus MULTI_STATUS;
    public static final HttpStatus NETWORK_AUTHENTICATION_REQUIRED;
    public static final HttpStatus NON_AUTHORITATIVE_INFORMATION;
    public static final HttpStatus NOT_ACCEPTABLE;
    public static final HttpStatus NOT_EXTENDED;
    public static final HttpStatus NOT_FOUND;
    public static final HttpStatus NOT_IMPLEMENTED;
    public static final HttpStatus NOT_MODIFIED;
    public static final HttpStatus NO_CONTENT;
    public static final HttpStatus OK;
    public static final HttpStatus PARTIAL_CONTENT;
    public static final HttpStatus PAYMENT_REQUIRED;
    public static final HttpStatus PRECONDITION_FAILED;
    public static final HttpStatus PRECONDITION_REQUIRED;
    public static final HttpStatus PROCESSING;
    public static final HttpStatus PROXY_AUTHENTICATION_REQUIRED;
    public static final HttpStatus REQUESTED_RANGE_NOT_SATISFIABLE;
    public static final HttpStatus REQUEST_ENTITY_TOO_LARGE;
    public static final HttpStatus REQUEST_HEADER_FIELDS_TOO_LARGE;
    public static final HttpStatus REQUEST_TIMEOUT;
    public static final HttpStatus REQUEST_URI_TOO_LONG;
    public static final HttpStatus RESET_CONTENT;
    public static final HttpStatus RESUME_INCOMPLETE;
    public static final HttpStatus SEE_OTHER;
    public static final HttpStatus SERVICE_UNAVAILABLE;
    public static final HttpStatus SWITCHING_PROTOCOLS;
    public static final HttpStatus TEMPORARY_REDIRECT;
    public static final HttpStatus TOO_MANY_REQUESTS;
    public static final HttpStatus UNAUTHORIZED;
    public static final HttpStatus UNPROCESSABLE_ENTITY;
    public static final HttpStatus UNSUPPORTED_MEDIA_TYPE;
    public static final HttpStatus UPGRADE_REQUIRED;
    public static final HttpStatus USE_PROXY;
    public static final HttpStatus VARIANT_ALSO_NEGOTIATES;
    public transient /* synthetic */ FieldHolder $fh;
    public final String reasonPhrase;
    public final int value;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Series {
        public static final /* synthetic */ Series[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Series CLIENT_ERROR;
        public static final Series INFORMATIONAL;
        public static final Series REDIRECTION;
        public static final Series SERVER_ERROR;
        public static final Series SUCCESSFUL;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1893416896, "Lcom/baidu/fsg/base/restnet/http/HttpStatus$Series;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1893416896, "Lcom/baidu/fsg/base/restnet/http/HttpStatus$Series;");
                    return;
                }
            }
            INFORMATIONAL = new Series("INFORMATIONAL", 0, 1);
            SUCCESSFUL = new Series("SUCCESSFUL", 1, 2);
            REDIRECTION = new Series("REDIRECTION", 2, 3);
            CLIENT_ERROR = new Series("CLIENT_ERROR", 3, 4);
            Series series = new Series("SERVER_ERROR", 4, 5);
            SERVER_ERROR = series;
            $VALUES = new Series[]{INFORMATIONAL, SUCCESSFUL, REDIRECTION, CLIENT_ERROR, series};
        }

        public Series(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static Series valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Series) Enum.valueOf(Series.class, str) : (Series) invokeL.objValue;
        }

        public static Series[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (Series[]) $VALUES.clone() : (Series[]) invokeV.objValue;
        }

        public int value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }

        public static Series valueOf(HttpStatus httpStatus) {
            InterceptResult invokeL;
            Series[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpStatus)) == null) {
                int value = httpStatus.value() / 100;
                for (Series series : values()) {
                    if (series.value == value) {
                        return series;
                    }
                }
                throw new IllegalArgumentException("No matching constant for [" + httpStatus + PreferencesUtil.RIGHT_MOUNT);
            }
            return (Series) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1828019237, "Lcom/baidu/fsg/base/restnet/http/HttpStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1828019237, "Lcom/baidu/fsg/base/restnet/http/HttpStatus;");
                return;
            }
        }
        CONTINUE = new HttpStatus("CONTINUE", 0, 100, "Continue");
        SWITCHING_PROTOCOLS = new HttpStatus("SWITCHING_PROTOCOLS", 1, 101, "Switching Protocols");
        PROCESSING = new HttpStatus("PROCESSING", 2, 102, "Processing");
        CHECKPOINT = new HttpStatus("CHECKPOINT", 3, 103, "Checkpoint");
        OK = new HttpStatus("OK", 4, 200, "OK");
        CREATED = new HttpStatus("CREATED", 5, 201, "Created");
        ACCEPTED = new HttpStatus("ACCEPTED", 6, 202, "Accepted");
        NON_AUTHORITATIVE_INFORMATION = new HttpStatus("NON_AUTHORITATIVE_INFORMATION", 7, 203, "Non-Authoritative Information");
        NO_CONTENT = new HttpStatus("NO_CONTENT", 8, 204, "No Content");
        RESET_CONTENT = new HttpStatus("RESET_CONTENT", 9, 205, "Reset Content");
        PARTIAL_CONTENT = new HttpStatus("PARTIAL_CONTENT", 10, 206, "Partial Content");
        MULTI_STATUS = new HttpStatus("MULTI_STATUS", 11, 207, "Multi-Status");
        ALREADY_REPORTED = new HttpStatus("ALREADY_REPORTED", 12, 208, "Already Reported");
        IM_USED = new HttpStatus("IM_USED", 13, Constants.METHOD_MEDIA_NOTIFY, "IM Used");
        MULTIPLE_CHOICES = new HttpStatus("MULTIPLE_CHOICES", 14, 300, "Multiple Choices");
        MOVED_PERMANENTLY = new HttpStatus("MOVED_PERMANENTLY", 15, 301, "Moved Permanently");
        FOUND = new HttpStatus("FOUND", 16, 302, "Found");
        MOVED_TEMPORARILY = new HttpStatus("MOVED_TEMPORARILY", 17, 302, "Moved Temporarily");
        SEE_OTHER = new HttpStatus("SEE_OTHER", 18, 303, "See Other");
        NOT_MODIFIED = new HttpStatus("NOT_MODIFIED", 19, 304, "Not Modified");
        USE_PROXY = new HttpStatus("USE_PROXY", 20, 305, "Use Proxy");
        TEMPORARY_REDIRECT = new HttpStatus("TEMPORARY_REDIRECT", 21, 307, "Temporary Redirect");
        RESUME_INCOMPLETE = new HttpStatus("RESUME_INCOMPLETE", 22, 308, "Resume Incomplete");
        BAD_REQUEST = new HttpStatus("BAD_REQUEST", 23, 400, "Bad Request");
        UNAUTHORIZED = new HttpStatus("UNAUTHORIZED", 24, 401, "Unauthorized");
        PAYMENT_REQUIRED = new HttpStatus("PAYMENT_REQUIRED", 25, 402, "Payment Required");
        FORBIDDEN = new HttpStatus("FORBIDDEN", 26, 403, "Forbidden");
        NOT_FOUND = new HttpStatus("NOT_FOUND", 27, 404, "Not Found");
        METHOD_NOT_ALLOWED = new HttpStatus("METHOD_NOT_ALLOWED", 28, 405, "Method Not Allowed");
        NOT_ACCEPTABLE = new HttpStatus("NOT_ACCEPTABLE", 29, 406, "Not Acceptable");
        PROXY_AUTHENTICATION_REQUIRED = new HttpStatus("PROXY_AUTHENTICATION_REQUIRED", 30, 407, "Proxy Authentication Required");
        REQUEST_TIMEOUT = new HttpStatus("REQUEST_TIMEOUT", 31, 408, "Request Timeout");
        CONFLICT = new HttpStatus("CONFLICT", 32, 409, "Conflict");
        GONE = new HttpStatus("GONE", 33, 410, "Gone");
        LENGTH_REQUIRED = new HttpStatus("LENGTH_REQUIRED", 34, 411, "Length Required");
        PRECONDITION_FAILED = new HttpStatus("PRECONDITION_FAILED", 35, 412, "Precondition Failed");
        REQUEST_ENTITY_TOO_LARGE = new HttpStatus("REQUEST_ENTITY_TOO_LARGE", 36, 413, "Request Entity Too Large");
        REQUEST_URI_TOO_LONG = new HttpStatus("REQUEST_URI_TOO_LONG", 37, 414, "Request-URI Too Long");
        UNSUPPORTED_MEDIA_TYPE = new HttpStatus("UNSUPPORTED_MEDIA_TYPE", 38, 415, "Unsupported Media Type");
        REQUESTED_RANGE_NOT_SATISFIABLE = new HttpStatus("REQUESTED_RANGE_NOT_SATISFIABLE", 39, 416, "Requested range not satisfiable");
        EXPECTATION_FAILED = new HttpStatus("EXPECTATION_FAILED", 40, org.apache.http.HttpStatus.SC_EXPECTATION_FAILED, "Expectation Failed");
        I_AM_A_TEAPOT = new HttpStatus("I_AM_A_TEAPOT", 41, SDKLogTypeConstants.TYPE_RSPLASH_HTML_LOG, "I'm a teapot");
        INSUFFICIENT_SPACE_ON_RESOURCE = new HttpStatus("INSUFFICIENT_SPACE_ON_RESOURCE", 42, org.apache.http.HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, "Insufficient Space On Resource");
        METHOD_FAILURE = new HttpStatus("METHOD_FAILURE", 43, org.apache.http.HttpStatus.SC_METHOD_FAILURE, "Method Failure");
        DESTINATION_LOCKED = new HttpStatus("DESTINATION_LOCKED", 44, 421, "Destination Locked");
        UNPROCESSABLE_ENTITY = new HttpStatus("UNPROCESSABLE_ENTITY", 45, org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY, "Unprocessable Entity");
        LOCKED = new HttpStatus("LOCKED", 46, org.apache.http.HttpStatus.SC_LOCKED, "Locked");
        FAILED_DEPENDENCY = new HttpStatus("FAILED_DEPENDENCY", 47, org.apache.http.HttpStatus.SC_FAILED_DEPENDENCY, "Failed Dependency");
        UPGRADE_REQUIRED = new HttpStatus("UPGRADE_REQUIRED", 48, SDKLogTypeConstants.TYPE_SHOUBAI_APO_INFO, "Upgrade Required");
        PRECONDITION_REQUIRED = new HttpStatus("PRECONDITION_REQUIRED", 49, 428, "Precondition Required");
        TOO_MANY_REQUESTS = new HttpStatus("TOO_MANY_REQUESTS", 50, StatusCodeException.IGNORE_429_CODE, "Too Many Requests");
        REQUEST_HEADER_FIELDS_TOO_LARGE = new HttpStatus("REQUEST_HEADER_FIELDS_TOO_LARGE", 51, 431, "Request Header Fields Too Large");
        INTERNAL_SERVER_ERROR = new HttpStatus("INTERNAL_SERVER_ERROR", 52, 500, "Internal Server Error");
        NOT_IMPLEMENTED = new HttpStatus("NOT_IMPLEMENTED", 53, 501, "Not Implemented");
        BAD_GATEWAY = new HttpStatus("BAD_GATEWAY", 54, 502, "Bad Gateway");
        SERVICE_UNAVAILABLE = new HttpStatus("SERVICE_UNAVAILABLE", 55, 503, "Service Unavailable");
        GATEWAY_TIMEOUT = new HttpStatus("GATEWAY_TIMEOUT", 56, 504, "Gateway Timeout");
        HTTP_VERSION_NOT_SUPPORTED = new HttpStatus("HTTP_VERSION_NOT_SUPPORTED", 57, 505, "HTTP Version not supported");
        VARIANT_ALSO_NEGOTIATES = new HttpStatus("VARIANT_ALSO_NEGOTIATES", 58, 506, "Variant Also Negotiates");
        INSUFFICIENT_STORAGE = new HttpStatus("INSUFFICIENT_STORAGE", 59, 507, "Insufficient Storage");
        LOOP_DETECTED = new HttpStatus("LOOP_DETECTED", 60, 508, "Loop Detected");
        BANDWIDTH_LIMIT_EXCEEDED = new HttpStatus("BANDWIDTH_LIMIT_EXCEEDED", 61, 509, "Bandwidth Limit Exceeded");
        NOT_EXTENDED = new HttpStatus("NOT_EXTENDED", 62, 510, "Not Extended");
        HttpStatus httpStatus = new HttpStatus("NETWORK_AUTHENTICATION_REQUIRED", 63, 511, "Network Authentication Required");
        NETWORK_AUTHENTICATION_REQUIRED = httpStatus;
        $VALUES = new HttpStatus[]{CONTINUE, SWITCHING_PROTOCOLS, PROCESSING, CHECKPOINT, OK, CREATED, ACCEPTED, NON_AUTHORITATIVE_INFORMATION, NO_CONTENT, RESET_CONTENT, PARTIAL_CONTENT, MULTI_STATUS, ALREADY_REPORTED, IM_USED, MULTIPLE_CHOICES, MOVED_PERMANENTLY, FOUND, MOVED_TEMPORARILY, SEE_OTHER, NOT_MODIFIED, USE_PROXY, TEMPORARY_REDIRECT, RESUME_INCOMPLETE, BAD_REQUEST, UNAUTHORIZED, PAYMENT_REQUIRED, FORBIDDEN, NOT_FOUND, METHOD_NOT_ALLOWED, NOT_ACCEPTABLE, PROXY_AUTHENTICATION_REQUIRED, REQUEST_TIMEOUT, CONFLICT, GONE, LENGTH_REQUIRED, PRECONDITION_FAILED, REQUEST_ENTITY_TOO_LARGE, REQUEST_URI_TOO_LONG, UNSUPPORTED_MEDIA_TYPE, REQUESTED_RANGE_NOT_SATISFIABLE, EXPECTATION_FAILED, I_AM_A_TEAPOT, INSUFFICIENT_SPACE_ON_RESOURCE, METHOD_FAILURE, DESTINATION_LOCKED, UNPROCESSABLE_ENTITY, LOCKED, FAILED_DEPENDENCY, UPGRADE_REQUIRED, PRECONDITION_REQUIRED, TOO_MANY_REQUESTS, REQUEST_HEADER_FIELDS_TOO_LARGE, INTERNAL_SERVER_ERROR, NOT_IMPLEMENTED, BAD_GATEWAY, SERVICE_UNAVAILABLE, GATEWAY_TIMEOUT, HTTP_VERSION_NOT_SUPPORTED, VARIANT_ALSO_NEGOTIATES, INSUFFICIENT_STORAGE, LOOP_DETECTED, BANDWIDTH_LIMIT_EXCEEDED, NOT_EXTENDED, httpStatus};
    }

    public HttpStatus(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i3;
        this.reasonPhrase = str2;
    }

    public static HttpStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (HttpStatus) Enum.valueOf(HttpStatus.class, str) : (HttpStatus) invokeL.objValue;
    }

    public static HttpStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (HttpStatus[]) $VALUES.clone() : (HttpStatus[]) invokeV.objValue;
    }

    public String getReasonPhrase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.reasonPhrase : (String) invokeV.objValue;
    }

    public Series series() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Series.valueOf(this) : (Series) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Integer.toString(this.value) : (String) invokeV.objValue;
    }

    public int value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.value : invokeV.intValue;
    }

    public static HttpStatus valueOf(int i2) {
        InterceptResult invokeI;
        HttpStatus[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (HttpStatus httpStatus : values()) {
                if (httpStatus.value == i2) {
                    return httpStatus;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + i2 + PreferencesUtil.RIGHT_MOUNT);
        }
        return (HttpStatus) invokeI.objValue;
    }
}
