package com.baidu.fsg.base.restnet.http;
/* loaded from: classes2.dex */
public enum HttpStatus {
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    CHECKPOINT(103, "Checkpoint"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(org.apache.http.HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, "Non-Authoritative Information"),
    NO_CONTENT(org.apache.http.HttpStatus.SC_NO_CONTENT, "No Content"),
    RESET_CONTENT(org.apache.http.HttpStatus.SC_RESET_CONTENT, "Reset Content"),
    PARTIAL_CONTENT(org.apache.http.HttpStatus.SC_PARTIAL_CONTENT, "Partial Content"),
    MULTI_STATUS(org.apache.http.HttpStatus.SC_MULTI_STATUS, "Multi-Status"),
    ALREADY_REPORTED(208, "Already Reported"),
    IM_USED(226, "IM Used"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    MOVED_TEMPORARILY(302, "Moved Temporarily"),
    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    USE_PROXY(org.apache.http.HttpStatus.SC_USE_PROXY, "Use Proxy"),
    TEMPORARY_REDIRECT(org.apache.http.HttpStatus.SC_TEMPORARY_REDIRECT, "Temporary Redirect"),
    RESUME_INCOMPLETE(308, "Resume Incomplete"),
    BAD_REQUEST(org.apache.http.HttpStatus.SC_BAD_REQUEST, "Bad Request"),
    UNAUTHORIZED(org.apache.http.HttpStatus.SC_UNAUTHORIZED, "Unauthorized"),
    PAYMENT_REQUIRED(org.apache.http.HttpStatus.SC_PAYMENT_REQUIRED, "Payment Required"),
    FORBIDDEN(org.apache.http.HttpStatus.SC_FORBIDDEN, "Forbidden"),
    NOT_FOUND(org.apache.http.HttpStatus.SC_NOT_FOUND, "Not Found"),
    METHOD_NOT_ALLOWED(org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED, "Method Not Allowed"),
    NOT_ACCEPTABLE(org.apache.http.HttpStatus.SC_NOT_ACCEPTABLE, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(org.apache.http.HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(org.apache.http.HttpStatus.SC_REQUEST_TIMEOUT, "Request Timeout"),
    CONFLICT(org.apache.http.HttpStatus.SC_CONFLICT, "Conflict"),
    GONE(org.apache.http.HttpStatus.SC_GONE, "Gone"),
    LENGTH_REQUIRED(org.apache.http.HttpStatus.SC_LENGTH_REQUIRED, "Length Required"),
    PRECONDITION_FAILED(org.apache.http.HttpStatus.SC_PRECONDITION_FAILED, "Precondition Failed"),
    REQUEST_ENTITY_TOO_LARGE(org.apache.http.HttpStatus.SC_REQUEST_TOO_LONG, "Request Entity Too Large"),
    REQUEST_URI_TOO_LONG(org.apache.http.HttpStatus.SC_REQUEST_URI_TOO_LONG, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(org.apache.http.HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(org.apache.http.HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, "Requested range not satisfiable"),
    EXPECTATION_FAILED(org.apache.http.HttpStatus.SC_EXPECTATION_FAILED, "Expectation Failed"),
    I_AM_A_TEAPOT(418, "I'm a teapot"),
    INSUFFICIENT_SPACE_ON_RESOURCE(org.apache.http.HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, "Insufficient Space On Resource"),
    METHOD_FAILURE(org.apache.http.HttpStatus.SC_METHOD_FAILURE, "Method Failure"),
    DESTINATION_LOCKED(421, "Destination Locked"),
    UNPROCESSABLE_ENTITY(org.apache.http.HttpStatus.SC_UNPROCESSABLE_ENTITY, "Unprocessable Entity"),
    LOCKED(org.apache.http.HttpStatus.SC_LOCKED, "Locked"),
    FAILED_DEPENDENCY(org.apache.http.HttpStatus.SC_FAILED_DEPENDENCY, "Failed Dependency"),
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(org.apache.http.HttpStatus.SC_NOT_IMPLEMENTED, "Not Implemented"),
    BAD_GATEWAY(org.apache.http.HttpStatus.SC_BAD_GATEWAY, "Bad Gateway"),
    SERVICE_UNAVAILABLE(org.apache.http.HttpStatus.SC_SERVICE_UNAVAILABLE, "Service Unavailable"),
    GATEWAY_TIMEOUT(org.apache.http.HttpStatus.SC_GATEWAY_TIMEOUT, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(org.apache.http.HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED, "HTTP Version not supported"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(org.apache.http.HttpStatus.SC_INSUFFICIENT_STORAGE, "Insufficient Storage"),
    LOOP_DETECTED(508, "Loop Detected"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
    NOT_EXTENDED(510, "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");
    
    private final String reasonPhrase;
    private final int value;

    HttpStatus(int i, String str) {
        this.value = i;
        this.reasonPhrase = str;
    }

    public static HttpStatus valueOf(int i) {
        HttpStatus[] values;
        for (HttpStatus httpStatus : values()) {
            if (httpStatus.value == i) {
                return httpStatus;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + i + "]");
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public Series series() {
        return Series.valueOf(this);
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.value);
    }

    /* loaded from: classes2.dex */
    public enum Series {
        INFORMATIONAL(1),
        SUCCESSFUL(2),
        REDIRECTION(3),
        CLIENT_ERROR(4),
        SERVER_ERROR(5);
        
        private final int value;

        Series(int i) {
            this.value = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Series valueOf(HttpStatus httpStatus) {
            Series[] values;
            int value = httpStatus.value() / 100;
            for (Series series : values()) {
                if (series.value == value) {
                    return series;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + httpStatus + "]");
        }

        public int value() {
            return this.value;
        }
    }
}
