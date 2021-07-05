package aegon.chrome.net;

import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AndroidCertVerifyResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<X509Certificate> mCertificateChain;
    public final boolean mIsIssuedByKnownRoot;
    public final int mStatus;

    public AndroidCertVerifyResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStatus = i2;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
    }

    public AndroidCertVerifyResult(int i2, boolean z, List<X509Certificate> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStatus = i2;
        this.mIsIssuedByKnownRoot = z;
        this.mCertificateChain = new ArrayList(list);
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[][] bArr = new byte[this.mCertificateChain.size()];
            for (int i2 = 0; i2 < this.mCertificateChain.size(); i2++) {
                try {
                    bArr[i2] = this.mCertificateChain.get(i2).getEncoded();
                } catch (CertificateEncodingException unused) {
                    return new byte[0];
                }
            }
            return bArr;
        }
        return (byte[][]) invokeV.objValue;
    }

    @CalledByNative
    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsIssuedByKnownRoot : invokeV.booleanValue;
    }
}
