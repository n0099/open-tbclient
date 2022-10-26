package com.baidu.searchbox.network.outback.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes2.dex */
public final class StatusLine {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public transient /* synthetic */ FieldHolder $fh;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public StatusLine(Protocol protocol, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {protocol, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.protocol = protocol;
        this.code = i;
        this.message = str;
    }

    public static StatusLine get(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, response)) == null) {
            return new StatusLine(response.protocol(), response.code(), response.message());
        }
        return (StatusLine) invokeL.objValue;
    }

    public static StatusLine parse(String str) throws IOException {
        InterceptResult invokeL;
        Protocol protocol;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int i = 9;
            if (str.startsWith("HTTP/1.")) {
                if (str.length() >= 9 && str.charAt(8) == ' ') {
                    int charAt = str.charAt(7) - '0';
                    if (charAt == 0) {
                        protocol = Protocol.HTTP_1_0;
                    } else if (charAt == 1) {
                        protocol = Protocol.HTTP_1_1;
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else if (str.startsWith("ICY ")) {
                protocol = Protocol.HTTP_1_0;
                i = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int i2 = i + 3;
            if (str.length() >= i2) {
                try {
                    int parseInt = Integer.parseInt(str.substring(i, i2));
                    if (str.length() > i2) {
                        if (str.charAt(i2) == ' ') {
                            str2 = str.substring(i + 4);
                        } else {
                            throw new ProtocolException("Unexpected status line: " + str);
                        }
                    } else {
                        str2 = "";
                    }
                    return new StatusLine(protocol, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            }
            throw new ProtocolException("Unexpected status line: " + str);
        }
        return (StatusLine) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.protocol == Protocol.HTTP_1_0) {
                str = "HTTP/1.0";
            } else {
                str = "HTTP/1.1";
            }
            sb.append(str);
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(this.code);
            if (this.message != null) {
                sb.append(WebvttCueParser.CHAR_SPACE);
                sb.append(this.message);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
