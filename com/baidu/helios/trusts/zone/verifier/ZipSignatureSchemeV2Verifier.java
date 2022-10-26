package com.baidu.helios.trusts.zone.verifier;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g50;
import com.baidu.tieba.l60;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class ZipSignatureSchemeV2Verifier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public interface c {
        void feedIntoMessageDigests(MessageDigest[] messageDigestArr, long j, int i) throws IOException;

        long size();
    }

    public static boolean r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) {
            if (i == 513 || i == 514 || i == 769) {
                return true;
            }
            switch (i) {
                case 257:
                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                case 260:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes2.dex */
    public class SignatureNotFoundException extends Exception {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignatureNotFoundException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignatureNotFoundException(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class VerbatimX509Certificate extends WrappedX509Certificate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] encodedVerbatim;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerbatimX509Certificate(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509Certificate, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((X509Certificate) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.encodedVerbatim = bArr;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier.WrappedX509Certificate, java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.encodedVerbatim;
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class WrappedX509Certificate extends X509Certificate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final X509Certificate wrapped;

        public WrappedX509Certificate(X509Certificate x509Certificate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509Certificate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.wrapped = x509Certificate;
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, date) == null) {
                this.wrapped.checkValidity(date);
            }
        }

        @Override // java.security.cert.X509Extension
        public byte[] getExtensionValue(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                return this.wrapped.getExtensionValue(str);
            }
            return (byte[]) invokeL.objValue;
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, publicKey) == null) {
                this.wrapped.verify(publicKey);
            }
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.wrapped.checkValidity();
            }
        }

        @Override // java.security.cert.X509Certificate
        public int getBasicConstraints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.wrapped.getBasicConstraints();
            }
            return invokeV.intValue;
        }

        @Override // java.security.cert.X509Extension
        public Set getCriticalExtensionOIDs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.wrapped.getCriticalExtensionOIDs();
            }
            return (Set) invokeV.objValue;
        }

        @Override // java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.wrapped.getEncoded();
            }
            return (byte[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public Principal getIssuerDN() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.wrapped.getIssuerDN();
            }
            return (Principal) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getIssuerUniqueID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.wrapped.getIssuerUniqueID();
            }
            return (boolean[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getKeyUsage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.wrapped.getKeyUsage();
            }
            return (boolean[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Extension
        public Set getNonCriticalExtensionOIDs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.wrapped.getNonCriticalExtensionOIDs();
            }
            return (Set) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotAfter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.wrapped.getNotAfter();
            }
            return (Date) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotBefore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.wrapped.getNotBefore();
            }
            return (Date) invokeV.objValue;
        }

        @Override // java.security.cert.Certificate
        public PublicKey getPublicKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.wrapped.getPublicKey();
            }
            return (PublicKey) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public BigInteger getSerialNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.wrapped.getSerialNumber();
            }
            return (BigInteger) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.wrapped.getSigAlgName();
            }
            return (String) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgOID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.wrapped.getSigAlgOID();
            }
            return (String) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSigAlgParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.wrapped.getSigAlgParams();
            }
            return (byte[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSignature() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.wrapped.getSignature();
            }
            return (byte[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public Principal getSubjectDN() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.wrapped.getSubjectDN();
            }
            return (Principal) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getSubjectUniqueID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.wrapped.getSubjectUniqueID();
            }
            return (boolean[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getTBSCertificate() throws CertificateEncodingException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.wrapped.getTBSCertificate();
            }
            return (byte[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public int getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.wrapped.getVersion();
            }
            return invokeV.intValue;
        }

        @Override // java.security.cert.X509Extension
        public boolean hasUnsupportedCriticalExtension() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.wrapped.hasUnsupportedCriticalExtension();
            }
            return invokeV.booleanValue;
        }

        @Override // java.security.cert.Certificate
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.wrapped.toString();
            }
            return (String) invokeV.objValue;
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048601, this, publicKey, str) == null) {
                this.wrapped.verify(publicKey, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteBuffer a;

        public b(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = byteBuffer.slice();
        }

        @Override // com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier.c
        public void feedIntoMessageDigests(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
            ByteBuffer slice;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{messageDigestArr, Long.valueOf(j), Integer.valueOf(i)}) == null) {
                synchronized (this.a) {
                    int i2 = (int) j;
                    this.a.position(i2);
                    this.a.limit(i2 + i);
                    slice = this.a.slice();
                }
                for (MessageDigest messageDigest : messageDigestArr) {
                    slice.position(0);
                    messageDigest.update(slice);
                }
            }
        }

        @Override // com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier.c
        public long size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.capacity();
            }
            return invokeV.longValue;
        }
    }

    /* loaded from: classes2.dex */
    public final class d implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FileChannel a;
        public final long b;
        public final long c;

        public d(FileChannel fileChannel, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fileChannel, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fileChannel;
            this.b = j;
            this.c = j2;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier.c
        public void feedIntoMessageDigests(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{messageDigestArr, Long.valueOf(j), Integer.valueOf(i)}) == null) {
                MappedByteBuffer map = this.a.map(FileChannel.MapMode.READ_ONLY, this.b + j, i);
                for (MessageDigest messageDigest : messageDigestArr) {
                    map.position(0);
                    messageDigest.update(map);
                }
            }
        }

        @Override // com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier.c
        public long size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return invokeV.longValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteBuffer a;
        public final long b;
        public final long c;
        public final long d;
        public final ByteBuffer e;

        public e(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), byteBuffer2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = byteBuffer;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = byteBuffer2;
        }

        public /* synthetic */ e(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2, a aVar) {
            this(byteBuffer, j, j2, j3, byteBuffer2);
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, byteBuffer) != null) || byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            return;
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static final long j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j)) == null) {
            return ((j + 1048576) - 1) / 1048576;
        }
        return invokeJ.longValue;
    }

    public static Pair m(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, randomAccessFile)) == null) {
            Pair c2 = l60.c(randomAccessFile);
            if (c2 != null) {
                return c2;
            }
            throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
        }
        return (Pair) invokeL.objValue;
    }

    public static X509Certificate[][] v(File file) throws SignatureNotFoundException, SecurityException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, file)) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                return w(randomAccessFile);
            } finally {
                g50.c(randomAccessFile);
            }
        }
        return (X509Certificate[][]) invokeL.objValue;
    }

    public static X509Certificate[][] w(RandomAccessFile randomAccessFile) throws SignatureNotFoundException, SecurityException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, randomAccessFile)) == null) {
            return x(randomAccessFile, randomAccessFile.getFD(), g(randomAccessFile));
        }
        return (X509Certificate[][]) invokeL.objValue;
    }

    public static int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i, i2)) == null) {
            if (i != 1) {
                if (i == 2) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 == 2) {
                        return 0;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i);
            } else if (i2 == 1) {
                return 0;
            } else {
                if (i2 == 2) {
                    return -1;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
            }
        }
        return invokeII.intValue;
    }

    public static int c(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            return b(o(i), o(i2));
        }
        return invokeII.intValue;
    }

    public static byte[][] d(int[] iArr, c[] cVarArr) throws DigestException {
        InterceptResult invokeLL;
        MessageDigest messageDigest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, iArr, cVarArr)) == null) {
            c[] cVarArr2 = cVarArr;
            long j = 0;
            long j2 = 0;
            for (c cVar : cVarArr2) {
                j2 += j(cVar.size());
            }
            if (j2 < 2097151) {
                int i = (int) j2;
                byte[][] bArr = new byte[iArr.length];
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    byte[] bArr2 = new byte[(l(iArr[i2]) * i) + 5];
                    bArr2[0] = 90;
                    t(i, bArr2, 1);
                    bArr[i2] = bArr2;
                }
                byte[] bArr3 = new byte[5];
                bArr3[0] = -91;
                int length = iArr.length;
                MessageDigest[] messageDigestArr = new MessageDigest[length];
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    String k = k(iArr[i3]);
                    try {
                        messageDigestArr[i3] = MessageDigest.getInstance(k);
                    } catch (NoSuchAlgorithmException e2) {
                        throw new RuntimeException(k + " digest not supported", e2);
                    }
                }
                int length2 = cVarArr2.length;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i4 < length2) {
                    c cVar2 = cVarArr2[i4];
                    int i7 = length2;
                    int i8 = i4;
                    long size = cVar2.size();
                    long j3 = j;
                    while (size > j) {
                        int min = (int) Math.min(size, 1048576L);
                        t(min, bArr3, 1);
                        for (int i9 = 0; i9 < length; i9++) {
                            messageDigestArr[i9].update(bArr3);
                        }
                        try {
                            cVar2.feedIntoMessageDigests(messageDigestArr, j3, min);
                            int i10 = 0;
                            while (i10 < iArr.length) {
                                int i11 = iArr[i10];
                                byte[] bArr4 = bArr3;
                                byte[] bArr5 = bArr[i10];
                                int l = l(i11);
                                c cVar3 = cVar2;
                                int i12 = length;
                                int digest = messageDigestArr[i10].digest(bArr5, (i5 * l) + 5, l);
                                if (digest == l) {
                                    i10++;
                                    bArr3 = bArr4;
                                    cVar2 = cVar3;
                                    length = i12;
                                } else {
                                    throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                                }
                            }
                            long j4 = min;
                            j3 += j4;
                            size -= j4;
                            i5++;
                            bArr3 = bArr3;
                            j = 0;
                        } catch (IOException e3) {
                            throw new DigestException("Failed to digest chunk #" + i5 + " of section #" + i6, e3);
                        }
                    }
                    i6++;
                    i4 = i8 + 1;
                    cVarArr2 = cVarArr;
                    length2 = i7;
                    j = 0;
                }
                byte[][] bArr6 = new byte[iArr.length];
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    int i14 = iArr[i13];
                    byte[] bArr7 = bArr[i13];
                    String k2 = k(i14);
                    try {
                        bArr6[i13] = MessageDigest.getInstance(k2).digest(bArr7);
                    } catch (NoSuchAlgorithmException e4) {
                        throw new RuntimeException(k2 + " digest not supported", e4);
                    }
                }
                return bArr6;
            }
            throw new DigestException("Too many chunks: " + j2);
        }
        return (byte[][]) invokeLL.objValue;
    }

    public static ByteBuffer e(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            a(byteBuffer);
            ByteBuffer u = u(byteBuffer, 8, byteBuffer.capacity() - 24);
            int i = 0;
            while (u.hasRemaining()) {
                i++;
                if (u.remaining() >= 8) {
                    long j = u.getLong();
                    if (j >= 4 && j <= 2147483647L) {
                        int i2 = (int) j;
                        int position = u.position() + i2;
                        if (i2 <= u.remaining()) {
                            if (u.getInt() == 1896449818) {
                                return h(u, i2 - 4);
                            }
                            u.position(position);
                        } else {
                            throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + u.remaining());
                        }
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j);
                    }
                } else {
                    throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
                }
            }
            throw new SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static Pair f(RandomAccessFile randomAccessFile, long j) throws IOException, SignatureNotFoundException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, randomAccessFile, j)) == null) {
            if (j >= 32) {
                ByteBuffer allocate = ByteBuffer.allocate(24);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.seek(j - allocate.capacity());
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (allocate.getLong(8) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
                    long j2 = allocate.getLong(0);
                    if (j2 >= allocate.capacity() && j2 <= 2147483639) {
                        int i = (int) (8 + j2);
                        long j3 = j - i;
                        if (j3 >= 0) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i);
                            allocate2.order(ByteOrder.LITTLE_ENDIAN);
                            randomAccessFile.seek(j3);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            long j4 = allocate2.getLong(0);
                            if (j4 == j2) {
                                return Pair.create(allocate2, Long.valueOf(j3));
                            }
                            throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                        }
                        throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j3);
                    }
                    throw new SignatureNotFoundException("APK Signing Block size out of range: " + j2);
                }
                throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
            }
            throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }
        return (Pair) invokeLJ.objValue;
    }

    public static e g(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, randomAccessFile)) == null) {
            Pair m = m(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) m.first;
            long longValue = ((Long) m.second).longValue();
            if (!l60.i(randomAccessFile, longValue)) {
                long i = i(byteBuffer, longValue);
                Pair f = f(randomAccessFile, i);
                return new e(e((ByteBuffer) f.first), ((Long) f.second).longValue(), i, longValue, byteBuffer, null);
            }
            throw new SignatureNotFoundException("ZIP64 APK not supported");
        }
        return (e) invokeL.objValue;
    }

    public static int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) {
            if (i != 513) {
                if (i != 514) {
                    if (i != 769) {
                        switch (i) {
                            case 257:
                            case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                                return 1;
                            case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                            case 260:
                                return 2;
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                        }
                    }
                    return 1;
                }
                return 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public static String p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            if (i != 513 && i != 514) {
                if (i != 769) {
                    switch (i) {
                        case 257:
                        case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                        case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                        case 260:
                            return RSAUtil.ALGORITHM_RSA;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                    }
                }
                return "DSA";
            }
            return "EC";
        }
        return (String) invokeI.objValue;
    }

    public static byte[] s(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, byteBuffer)) == null) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    byte[] bArr = new byte[i];
                    byteBuffer.get(bArr);
                    return bArr;
                }
                throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
            }
            throw new IOException("Negative length");
        }
        return (byte[]) invokeL.objValue;
    }

    public static ByteBuffer h(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, byteBuffer, i)) == null) {
            if (i >= 0) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                int i2 = i + position;
                if (i2 >= position && i2 <= limit) {
                    byteBuffer.limit(i2);
                    try {
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        byteBuffer.position(i2);
                        return slice;
                    } finally {
                        byteBuffer.limit(limit);
                    }
                }
                throw new BufferUnderflowException();
            }
            throw new IllegalArgumentException("size: " + i);
        }
        return (ByteBuffer) invokeLI.objValue;
    }

    public static long i(ByteBuffer byteBuffer, long j) throws SignatureNotFoundException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65544, null, byteBuffer, j)) == null) {
            long g = l60.g(byteBuffer);
            if (g < j) {
                if (l60.h(byteBuffer) + g == j) {
                    return g;
                }
                throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + g + ". ZIP End of Central Directory offset: " + j);
        }
        return invokeLJ.longValue;
    }

    public static String k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            if (i != 1) {
                if (i == 2) {
                    return "SHA-512";
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
            }
            return "SHA-256";
        }
        return (String) invokeI.objValue;
    }

    public static int l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            if (i != 1) {
                if (i == 2) {
                    return 64;
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
            }
            return 32;
        }
        return invokeI.intValue;
    }

    public static ByteBuffer n(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, byteBuffer)) == null) {
            if (byteBuffer.remaining() >= 4) {
                int i = byteBuffer.getInt();
                if (i >= 0) {
                    if (i <= byteBuffer.remaining()) {
                        return h(byteBuffer, i);
                    }
                    throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
                }
                throw new IllegalArgumentException("Negative length");
            }
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static Pair q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            if (i != 513) {
                if (i != 514) {
                    if (i != 769) {
                        switch (i) {
                            case 257:
                                return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                            case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                                return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                            case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                                return Pair.create("SHA256withRSA", null);
                            case 260:
                                return Pair.create("SHA512withRSA", null);
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                        }
                    }
                    return Pair.create("SHA256withDSA", null);
                }
                return Pair.create("SHA512withECDSA", null);
            }
            return Pair.create("SHA256withECDSA", null);
        }
        return (Pair) invokeI.objValue;
    }

    public static void t(int i, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2)}) == null) {
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
            bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
        }
    }

    public static ByteBuffer u(ByteBuffer byteBuffer, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65556, null, byteBuffer, i, i2)) == null) {
            if (i >= 0) {
                if (i2 >= i) {
                    int capacity = byteBuffer.capacity();
                    if (i2 <= byteBuffer.capacity()) {
                        int limit = byteBuffer.limit();
                        int position = byteBuffer.position();
                        try {
                            byteBuffer.position(0);
                            byteBuffer.limit(i2);
                            byteBuffer.position(i);
                            ByteBuffer slice = byteBuffer.slice();
                            slice.order(byteBuffer.order());
                            return slice;
                        } finally {
                            byteBuffer.position(0);
                            byteBuffer.limit(limit);
                            byteBuffer.position(position);
                        }
                    }
                    throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
                }
                throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
            }
            throw new IllegalArgumentException("start: " + i);
        }
        return (ByteBuffer) invokeLII.objValue;
    }

    public static X509Certificate[][] x(RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, e eVar) throws SecurityException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, randomAccessFile, fileDescriptor, eVar)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                try {
                    ByteBuffer n = n(eVar.a);
                    int i = 0;
                    while (n.hasRemaining()) {
                        i++;
                        try {
                            arrayList.add(z(n(n), hashMap, certificateFactory));
                        } catch (IOException | SecurityException | BufferUnderflowException e2) {
                            throw new SecurityException("Failed to parse/verify signer #" + i + " block", e2);
                        }
                    }
                    if (i >= 1) {
                        if (!hashMap.isEmpty()) {
                            y(hashMap, randomAccessFile, fileDescriptor, eVar.b, eVar.c, eVar.d, eVar.e);
                            return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                        }
                        throw new SecurityException("No content digests found");
                    }
                    throw new SecurityException("No signers found");
                } catch (IOException e3) {
                    throw new SecurityException("Failed to read list of signers", e3);
                }
            } catch (CertificateException e4) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
            }
        }
        return (X509Certificate[][]) invokeLLL.objValue;
    }

    public static void y(Map map, RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        c bVar;
        c bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{map, randomAccessFile, fileDescriptor, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), byteBuffer}) == null) {
            if (!map.isEmpty()) {
                if (j > 1048576) {
                    bVar = new d(randomAccessFile.getChannel(), 0L, j);
                    bVar2 = new d(randomAccessFile.getChannel(), j2, j3 - j2);
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate((int) j);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    try {
                        randomAccessFile.seek(0L);
                        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                        bVar = new b(allocate);
                        ByteBuffer allocate2 = ByteBuffer.allocate((int) (j3 - j2));
                        allocate2.order(ByteOrder.LITTLE_ENDIAN);
                        try {
                            randomAccessFile.seek(j2);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            bVar2 = new b(allocate2);
                        } catch (IOException e2) {
                            throw new SecurityException("Failed to get apk contents", e2);
                        }
                    } catch (IOException e3) {
                        throw new SecurityException("Failed to get apk contents", e3);
                    }
                }
                ByteBuffer duplicate = byteBuffer.duplicate();
                duplicate.order(ByteOrder.LITTLE_ENDIAN);
                l60.k(duplicate, j);
                b bVar3 = new b(duplicate);
                int size = map.size();
                int[] iArr = new int[size];
                int i = 0;
                for (Integer num : map.keySet()) {
                    iArr[i] = num.intValue();
                    i++;
                }
                try {
                    byte[][] d2 = d(iArr, new c[]{bVar, bVar2, bVar3});
                    for (int i2 = 0; i2 < size; i2++) {
                        int i3 = iArr[i2];
                        if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i3)), d2[i2])) {
                            throw new SecurityException(k(i3) + " digest of contents did not verify");
                        }
                    }
                    return;
                } catch (DigestException e4) {
                    throw new SecurityException("Failed to compute digest(s) of contents", e4);
                }
            }
            throw new SecurityException("No digests provided");
        }
    }

    public static X509Certificate[] z(ByteBuffer byteBuffer, Map map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        InterceptResult invokeLLL;
        int o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, byteBuffer, map, certificateFactory)) == null) {
            ByteBuffer n = n(byteBuffer);
            ByteBuffer n2 = n(byteBuffer);
            byte[] s = s(byteBuffer);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = null;
            byte[] bArr2 = null;
            int i = -1;
            int i2 = 0;
            while (n2.hasRemaining()) {
                i2++;
                try {
                    ByteBuffer n3 = n(n2);
                    if (n3.remaining() >= 8) {
                        int i3 = n3.getInt();
                        arrayList.add(Integer.valueOf(i3));
                        if (r(i3) && (i == -1 || c(i3, i) > 0)) {
                            bArr2 = s(n3);
                            i = i3;
                        }
                    } else {
                        throw new SecurityException("Signature record too short");
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new SecurityException("Failed to parse signature record #" + i2, e2);
                }
            }
            if (i == -1) {
                if (i2 == 0) {
                    throw new SecurityException("No signatures found");
                }
                throw new SecurityException("No supported signatures found");
            }
            String p = p(i);
            Pair q = q(i);
            String str = (String) q.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) q.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(p).generatePublic(new X509EncodedKeySpec(s));
                Signature signature = Signature.getInstance(str);
                signature.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    signature.setParameter(algorithmParameterSpec);
                }
                signature.update(n);
                if (signature.verify(bArr2)) {
                    n.clear();
                    ByteBuffer n4 = n(n);
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (n4.hasRemaining()) {
                        i4++;
                        try {
                            ByteBuffer n5 = n(n4);
                            if (n5.remaining() >= 8) {
                                int i5 = n5.getInt();
                                arrayList2.add(Integer.valueOf(i5));
                                if (i5 == i) {
                                    bArr = s(n5);
                                }
                            } else {
                                throw new IOException("Record too short");
                            }
                        } catch (IOException | BufferUnderflowException e3) {
                            throw new IOException("Failed to parse digest record #" + i4, e3);
                        }
                    }
                    if (arrayList.equals(arrayList2)) {
                        byte[] bArr3 = (byte[]) map.put(Integer.valueOf(o(i)), bArr);
                        if (bArr3 != null && !MessageDigest.isEqual(bArr3, bArr)) {
                            throw new SecurityException(k(o) + " contents digest does not match the digest specified by a preceding signer");
                        }
                        ByteBuffer n6 = n(n);
                        ArrayList arrayList3 = new ArrayList();
                        int i6 = 0;
                        while (n6.hasRemaining()) {
                            i6++;
                            byte[] s2 = s(n6);
                            try {
                                arrayList3.add(new VerbatimX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(s2)), s2));
                            } catch (CertificateException e4) {
                                throw new SecurityException("Failed to decode certificate #" + i6, e4);
                            }
                        }
                        if (!arrayList3.isEmpty()) {
                            if (Arrays.equals(s, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                            }
                            throw new SecurityException("Public key mismatch between certificate and signature record");
                        }
                        throw new SecurityException("No certificates listed");
                    }
                    throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                }
                throw new SecurityException(str + " signature did not verify");
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e5) {
                throw new SecurityException("Failed to verify " + str + " signature", e5);
            }
        }
        return (X509Certificate[]) invokeLLL.objValue;
    }
}
