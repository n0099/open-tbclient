package com.baidu.sapi2.shell.response;
/* loaded from: classes.dex */
public class OAuthResponse extends SapiResponse {
    public String accessToken;
    public int expiresIn;
    public String extra;
    public String refreshToken;
    public String sessionKey;
    public String sessionSecret;

    public String toString() {
        return "OAuthResponse{accessToken='" + this.accessToken + "', expiresIn=" + this.expiresIn + ", refreshToken='" + this.refreshToken + "', sessionKey='" + this.sessionKey + "', sessionSecret='" + this.sessionSecret + "', extra='" + this.extra + "'}";
    }
}
