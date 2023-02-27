package com.baidu.searchbox.common.security;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost;", "", "getAppName", "", "getEnUid", "getForceMappingCacheInterval", "", "getOAID", "Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost$OAIDResult;", "getUA", "useMapping", "", "OAIDResult", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IDeviceInfoAppHost {
    String getAppName();

    String getEnUid();

    long getForceMappingCacheInterval();

    OAIDResult getOAID();

    String getUA();

    boolean useMapping();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static String getAppName(IDeviceInfoAppHost iDeviceInfoAppHost) {
            return "";
        }

        public static String getEnUid(IDeviceInfoAppHost iDeviceInfoAppHost) {
            return "";
        }

        public static long getForceMappingCacheInterval(IDeviceInfoAppHost iDeviceInfoAppHost) {
            return 500654080L;
        }

        public static String getUA(IDeviceInfoAppHost iDeviceInfoAppHost) {
            return "";
        }

        public static boolean useMapping(IDeviceInfoAppHost iDeviceInfoAppHost) {
            return false;
        }

        public static OAIDResult getOAID(IDeviceInfoAppHost iDeviceInfoAppHost) {
            return new OAIDResult(false, null, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost$OAIDResult;", "", "hasInit", "", "oaid", "", "encodedOAID", "(ZLjava/lang/String;Ljava/lang/String;)V", "getEncodedOAID", "()Ljava/lang/String;", "getHasInit", "()Z", "getOaid", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OAIDResult {
        public final String encodedOAID;
        public final boolean hasInit;
        public final String oaid;

        public OAIDResult(boolean z, String str, String str2) {
            this.hasInit = z;
            this.oaid = str;
            this.encodedOAID = str2;
        }

        public final String getEncodedOAID() {
            return this.encodedOAID;
        }

        public final boolean getHasInit() {
            return this.hasInit;
        }

        public final String getOaid() {
            return this.oaid;
        }
    }
}
