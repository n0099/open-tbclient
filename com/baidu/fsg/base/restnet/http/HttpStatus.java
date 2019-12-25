package com.baidu.fsg.base.restnet.http;
/* loaded from: classes3.dex */
public enum HttpStatus {
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    CHECKPOINT(103, "Checkpoint"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    NO_CONTENT(204, "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MULTI_STATUS(org.apache.http.HttpStatus.SC_MULTI_STATUS, "Multi-Status"),
    ALREADY_REPORTED(208, "Already Reported"),
    IM_USED(226, "IM Used"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    MOVED_TEMPORARILY(302, "Moved Temporarily"),
    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    USE_PROXY(305, "Use Proxy"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    RESUME_INCOMPLETE(308, "Resume Incomplete"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    PRECONDITION_FAILED(412, "Precondition Failed"),
    REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
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
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
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

    /* loaded from: classes3.dex */
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
