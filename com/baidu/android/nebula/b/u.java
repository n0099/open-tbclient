package com.baidu.android.nebula.b;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
public enum u {
    OK(Constants.MEDIA_INFO, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(204, "No Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    REDIRECT(301, "Moved Permanently"),
    NOT_MODIFIED(304, "Not Modified"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
    INTERNAL_ERROR(500, "Internal Server Error");
    
    private final int o;
    private final String p;

    u(int i, String str) {
        this.o = i;
        this.p = str;
    }

    public String a() {
        return "" + this.o + " " + this.p;
    }
}
