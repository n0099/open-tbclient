package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
/* loaded from: classes10.dex */
public class RSA {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "MIIDSzCCArSgAwIBAgIJAMulCuPa8XlUMA0GCSqGSIb3DQEBCwUAMHcxCzAJBgNV\nBAYTAkNOMRAwDgYDVQQIDAdCZWlqaW5nMRAwDgYDVQQHDAdCZWlqaW5nMQ4wDAYD\nVQQKDAVCYWlkdTERMA8GA1UEAwwIUGFzc3BvcnQxITAfBgkqhkiG9w0BCQEWEnBh\nc3Nwb3J0QGJhaWR1LmNvbTAgFw0xNjEyMDYwMzU0MTBaGA8yMTE2MTExMjAzNTQx\nMFowdzELMAkGA1UEBhMCQ04xEDAOBgNVBAgMB0JlaWppbmcxEDAOBgNVBAcMB0Jl\naWppbmcxDjAMBgNVBAoMBUJhaWR1MREwDwYDVQQDDAhQYXNzcG9ydDEhMB8GCSqG\nSIb3DQEJARYScGFzc3BvcnRAYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GN\nADCBiQKBgQDRKdiCTDP5+pYZVCNNjv0EmUk13zPhGMcPi5aDhBqNuqbtxKnjSOiy\n2gNwuKTaPcVOD7ZUWw1tMy4QJYXaiZByBbZ0lp+QOt4j1G7dA3NIVPncdfhhASdh\n2X29aScOExOaqEyOPrwK0SPRjHaStdv3gvyWIIgL8KoD9OOVUNALGwIDAQABo4Hc\nMIHZMB0GA1UdDgQWBBS492mAG8aSPG3V9u7S0Oc3/HD9szAfBgNVHSMEGDAWgBS4\n92mAG8aSPG3V9u7S0Oc3/HD9szAMBgNVHRMEBTADAQH/MAsGA1UdDwQEAwIFoDAd\nBgNVHREEFjAUghJwYXNzcG9ydC5iYWlkdS5jb20wPgYJYIZIAYb4QgENBDEWL1Ro\naXMgcm9vdCBjZXJ0aWZpY2F0ZSB3YXMgZ2VuZXJhdGVkIGJ5IFBhc3Nwb3J0MB0G\nA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjANBgkqhkiG9w0BAQsFAAOBgQAk\nSGe7CVXwvjUVVsrOOPT/LxUmNAbC099oVzbt+RoBGmSzmt5CMjkNB6pkF+qtNRvi\nrPiDVD1d8WGgKoB8/Vmbqw/Fo+VLYi4nlrcgV1OgHfXmKMQJlrOX6Mo2CvYEvI4z\n4jLdKxVTd5bqR2oh5VCtTQNlk7gK6sDGF5uipPEsDQ==";

    /* renamed from: b  reason: collision with root package name */
    public static String f38792b = "-----BEGIN CERTIFICATE-----\nMIIENTCCAx2gAwIBAgIJANClr937TOBKMA0GCSqGSIb3DQEBCwUAMHcxCzAJBgNV\nBAYTAkNOMRAwDgYDVQQIDAdCZWlqaW5nMRAwDgYDVQQHDAdCZWlqaW5nMQ4wDAYD\nVQQKDAVCYWlkdTERMA8GA1UEAwwIUGFzc3BvcnQxITAfBgkqhkiG9w0BCQEWEnBh\nc3Nwb3J0QGJhaWR1LmNvbTAeFw0xODA4MjgwMzExMTlaFw0yODA4MjUwMzExMTla\nMHcxCzAJBgNVBAYTAkNOMRAwDgYDVQQIDAdCZWlqaW5nMRAwDgYDVQQHDAdCZWlq\naW5nMQ4wDAYDVQQKDAVCYWlkdTERMA8GA1UEAwwIUGFzc3BvcnQxITAfBgkqhkiG\n9w0BCQEWEnBhc3Nwb3J0QGJhaWR1LmNvbTCCASIwDQYJKoZIhvcNAQEBBQADggEP\nADCCAQoCggEBAL6o6DePv7RBZyN55XcdPhzl6V4RSDJbY/hFRSleNBXdVZdhqvxD\njitj57eyzwplbba/PxcZYMlhgaUw9p2oiaRyS59zbx93qWiRRPqdNlhdOPRL1W0b\nhCDzbnee6UgRAl/InCYgsw6sa1mSOzV/2puujTyYi1dEJJy/sY0qwBj2ykJ73ouF\n4dQZkytKfWfwpjeydRQ3zaNzI5ZRMXou1VzgTKDhTlRC3vwt2reHr5scAZFnDkpF\nFYHGFT2KjhkmzWf5LSkTbbtWDIafs4lWDNGR5AFPH5KcKUVoLBwmWjiJM7/WApyg\nPsDXMKch19Mp7hRJrShTJvj9uPmncOoJiqECAwEAAaOBwzCBwDAdBgNVHQ4EFgQU\n9TvCukPj+ZSnjqEQN1nwuNH40REwHwYDVR0jBBgwFoAU9TvCukPj+ZSnjqEQN1nw\nuNH40REwDAYDVR0TBAUwAwEB/zALBgNVHQ8EBAMCBaAwMAYDVR0RBCkwJ4IScGFz\nc3BvcnQuYmFpZHUuY29tghF3YXBwYXNzLmJhaWR1LmNvbTASBglghkgBhvhCAQ0E\nBRYDUlNBMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjANBgkqhkiG9w0B\nAQsFAAOCAQEAaImIp8WmAGI8ZFZ676HTnh6bvdV+SQuLYw4rX73GU4amZdfuPrlS\nog6KpVotOfPfE0Op4gzfhCf21UXk9aGykYmPja7H8AgfRTyCsRE+N5UUaQjKNPpa\nNnS6JXjP7fT0Kzjg1qZ2T2GGm9cNDpccFZXNJ3LTlZ6hKxL9676ITG0skfpCy6hT\nd9fumaL+vNErh+juSSmiZ0MJshHobi188w9Yx7qUWKNq9nggJSc/KHSMdumwNdfo\nCDA0TaVutnwY+TSl9XTdqb0K5sRo/aoWhbNLWV1Uldizx0UMu1qm0p3ntLQHjlSY\nvitSKCCXfbrTf7BWjbsUK76aytK6eV7l6A==\n-----END CERTIFICATE-----";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1623675731, "Lcom/baidu/pass/biometrics/base/utils/RSA;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1623675731, "Lcom/baidu/pass/biometrics/base/utils/RSA;");
        }
    }

    public RSA() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String decrypt(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            PublicKey publicKey = getPublicKey(a);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicKey);
            return new String(cipher.doFinal(SecurityUtil.base64Decode(str.getBytes("UTF-8"))), "UTF-8").trim();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] encrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? encrypt(str, f38792b) : (byte[]) invokeL.objValue;
    }

    public static PublicKey getPublicKey(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? X509Certificate.getInstance(new ByteArrayInputStream(SecurityUtil.base64Decode(str.getBytes()))).getPublicKey() : (PublicKey) invokeL.objValue;
    }

    public static byte[] encrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str == null || TextUtils.isEmpty(str2)) {
                return new byte[0];
            }
            try {
                Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
                cipher.init(1, X509Certificate.getInstance(new ByteArrayInputStream(str2.getBytes())).getPublicKey());
                return cipher.doFinal(str.getBytes("UTF-8"));
            } catch (Throwable unused) {
                return new byte[0];
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
