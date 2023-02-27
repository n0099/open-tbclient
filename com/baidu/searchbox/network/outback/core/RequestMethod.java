package com.baidu.searchbox.network.outback.core;

import java.util.Locale;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes2.dex */
public enum RequestMethod {
    GET("GET"),
    POST("POST"),
    PUT(HttpPut.METHOD_NAME),
    DELETE(HttpDelete.METHOD_NAME),
    HEAD("HEAD"),
    PATCH("PATCH"),
    OPTIONS(HttpOptions.METHOD_NAME),
    TRACE(HttpTrace.METHOD_NAME);
    
    public final String value;

    /* renamed from: com.baidu.searchbox.network.outback.core.RequestMethod$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$network$outback$core$RequestMethod;

        static {
            int[] iArr = new int[RequestMethod.values().length];
            $SwitchMap$com$baidu$searchbox$network$outback$core$RequestMethod = iArr;
            try {
                iArr[RequestMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$network$outback$core$RequestMethod[RequestMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$network$outback$core$RequestMethod[RequestMethod.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$network$outback$core$RequestMethod[RequestMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    RequestMethod(String str) {
        this.value = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static RequestMethod reverse(String str) {
        char c;
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        switch (upperCase.hashCode()) {
            case -531492226:
                if (upperCase.equals(HttpOptions.METHOD_NAME)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 70454:
                if (upperCase.equals("GET")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 79599:
                if (upperCase.equals(HttpPut.METHOD_NAME)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2213344:
                if (upperCase.equals("HEAD")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2461856:
                if (upperCase.equals("POST")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 75900968:
                if (upperCase.equals("PATCH")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 80083237:
                if (upperCase.equals(HttpTrace.METHOD_NAME)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 2012838315:
                if (upperCase.equals(HttpDelete.METHOD_NAME)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return GET;
            case 1:
                return POST;
            case 2:
                return PUT;
            case 3:
                return DELETE;
            case 4:
                return HEAD;
            case 5:
                return PATCH;
            case 6:
                return OPTIONS;
            case 7:
                return TRACE;
            default:
                return GET;
        }
    }

    public boolean allowBody() {
        int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$network$outback$core$RequestMethod[ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
