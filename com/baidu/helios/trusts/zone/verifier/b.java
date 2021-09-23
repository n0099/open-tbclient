package com.baidu.helios.trusts.zone.verifier;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.helios.trusts.zone.verifier.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1661b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f40655a;

        public C1661b(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40655a = byteBuffer.slice();
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.c
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40655a.capacity() : invokeV.longValue;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.c
        public void a(MessageDigest[] messageDigestArr, long j2, int i2) {
            ByteBuffer slice;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{messageDigestArr, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                synchronized (this.f40655a) {
                    int i3 = (int) j2;
                    this.f40655a.position(i3);
                    this.f40655a.limit(i3 + i2);
                    slice = this.f40655a.slice();
                }
                for (MessageDigest messageDigest : messageDigestArr) {
                    slice.position(0);
                    messageDigest.update(slice);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        long a();

        void a(MessageDigest[] messageDigestArr, long j2, int i2);
    }

    /* loaded from: classes5.dex */
    public static final class d implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final FileChannel f40656a;

        /* renamed from: b  reason: collision with root package name */
        public final long f40657b;

        /* renamed from: c  reason: collision with root package name */
        public final long f40658c;

        public d(FileChannel fileChannel, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fileChannel, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40656a = fileChannel;
            this.f40657b = j2;
            this.f40658c = j3;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.c
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40658c : invokeV.longValue;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.c
        public void a(MessageDigest[] messageDigestArr, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{messageDigestArr, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                MappedByteBuffer map = this.f40656a.map(FileChannel.MapMode.READ_ONLY, this.f40657b + j2, i2);
                for (MessageDigest messageDigest : messageDigestArr) {
                    map.position(0);
                    messageDigest.update(map);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends Exception {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final long f40659a = 1;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f40660a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509Certificate, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((X509Certificate) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40660a = bArr;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.g, java.security.cert.Certificate
        public byte[] getEncoded() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40660a : (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends X509Certificate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final X509Certificate f40661a;

        public g(X509Certificate x509Certificate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509Certificate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40661a = x509Certificate;
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f40661a.checkValidity();
            }
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity(Date date) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, date) == null) {
                this.f40661a.checkValidity(date);
            }
        }

        @Override // java.security.cert.X509Certificate
        public int getBasicConstraints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40661a.getBasicConstraints() : invokeV.intValue;
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getCriticalExtensionOIDs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40661a.getCriticalExtensionOIDs() : (Set) invokeV.objValue;
        }

        @Override // java.security.cert.Certificate
        public byte[] getEncoded() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40661a.getEncoded() : (byte[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Extension
        public byte[] getExtensionValue(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f40661a.getExtensionValue(str) : (byte[]) invokeL.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public Principal getIssuerDN() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40661a.getIssuerDN() : (Principal) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getIssuerUniqueID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f40661a.getIssuerUniqueID() : (boolean[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getKeyUsage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40661a.getKeyUsage() : (boolean[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getNonCriticalExtensionOIDs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40661a.getNonCriticalExtensionOIDs() : (Set) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotAfter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f40661a.getNotAfter() : (Date) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotBefore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f40661a.getNotBefore() : (Date) invokeV.objValue;
        }

        @Override // java.security.cert.Certificate
        public PublicKey getPublicKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f40661a.getPublicKey() : (PublicKey) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public BigInteger getSerialNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f40661a.getSerialNumber() : (BigInteger) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f40661a.getSigAlgName() : (String) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgOID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f40661a.getSigAlgOID() : (String) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSigAlgParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f40661a.getSigAlgParams() : (byte[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSignature() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f40661a.getSignature() : (byte[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public Principal getSubjectDN() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f40661a.getSubjectDN() : (Principal) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getSubjectUniqueID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f40661a.getSubjectUniqueID() : (boolean[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getTBSCertificate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f40661a.getTBSCertificate() : (byte[]) invokeV.objValue;
        }

        @Override // java.security.cert.X509Certificate
        public int getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f40661a.getVersion() : invokeV.intValue;
        }

        @Override // java.security.cert.X509Extension
        public boolean hasUnsupportedCriticalExtension() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f40661a.hasUnsupportedCriticalExtension() : invokeV.booleanValue;
        }

        @Override // java.security.cert.Certificate
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f40661a.toString() : (String) invokeV.objValue;
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, publicKey) == null) {
                this.f40661a.verify(publicKey);
            }
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048601, this, publicKey, str) == null) {
                this.f40661a.verify(publicKey, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f40662a;

        /* renamed from: b  reason: collision with root package name */
        public final long f40663b;

        /* renamed from: c  reason: collision with root package name */
        public final long f40664c;

        /* renamed from: d  reason: collision with root package name */
        public final long f40665d;

        /* renamed from: e  reason: collision with root package name */
        public final ByteBuffer f40666e;

        public h(ByteBuffer byteBuffer, long j2, long j3, long j4, ByteBuffer byteBuffer2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), byteBuffer2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40662a = byteBuffer;
            this.f40663b = j2;
            this.f40664c = j3;
            this.f40665d = j4;
            this.f40666e = byteBuffer2;
        }

        public /* synthetic */ h(ByteBuffer byteBuffer, long j2, long j3, long j4, ByteBuffer byteBuffer2, a aVar) {
            this(byteBuffer, j2, j3, j4, byteBuffer2);
        }
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) ? p(o(i2), o(i3)) : invokeII.intValue;
    }

    public static final long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) ? ((j2 + 1048576) - 1) / 1048576 : invokeJ.longValue;
    }

    public static long c(ByteBuffer byteBuffer, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, byteBuffer, j2)) == null) {
            long b2 = c.a.r.j.a.d.a.b(byteBuffer);
            if (b2 < j2) {
                if (c.a.r.j.a.d.a.h(byteBuffer) + b2 == j2) {
                    return b2;
                }
                throw new e("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            throw new e("ZIP Central Directory offset out of range: " + b2 + ". ZIP End of Central Directory offset: " + j2);
        }
        return invokeLJ.longValue;
    }

    public static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, randomAccessFile, j2)) == null) {
            if (j2 < 32) {
                throw new e("APK too small for APK Signing Block. ZIP Central Directory offset: " + j2);
            }
            ByteBuffer allocate = ByteBuffer.allocate(24);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j2 - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
                long j3 = allocate.getLong(0);
                if (j3 < allocate.capacity() || j3 > 2147483639) {
                    throw new e("APK Signing Block size out of range: " + j3);
                }
                int i2 = (int) (8 + j3);
                long j4 = j2 - i2;
                if (j4 < 0) {
                    throw new e("APK Signing Block offset out of range: " + j4);
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.seek(j4);
                randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                long j5 = allocate2.getLong(0);
                if (j5 == j3) {
                    return Pair.create(allocate2, Long.valueOf(j4));
                }
                throw new e("APK Signing Block sizes in header and footer do not match: " + j5 + " vs " + j3);
            }
            throw new e("No APK Signing Block before ZIP Central Directory");
        }
        return (Pair) invokeLJ.objValue;
    }

    public static ByteBuffer e(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            if (byteBuffer.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
            }
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    return f(byteBuffer, i2);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static ByteBuffer f(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, byteBuffer, i2)) == null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("size: " + i2);
            }
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i3 = i2 + position;
            if (i3 < position || i3 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i3);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i3);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return (ByteBuffer) invokeLI.objValue;
    }

    public static ByteBuffer g(ByteBuffer byteBuffer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, byteBuffer, i2, i3)) == null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("start: " + i2);
            } else if (i3 < i2) {
                throw new IllegalArgumentException("end < start: " + i3 + " < " + i2);
            } else {
                int capacity = byteBuffer.capacity();
                if (i3 > byteBuffer.capacity()) {
                    throw new IllegalArgumentException("end > capacity: " + i3 + " > " + capacity);
                }
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i3);
                    byteBuffer.position(i2);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
        }
        return (ByteBuffer) invokeLII.objValue;
    }

    public static void h(int i2, byte[] bArr, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3)}) == null) {
            bArr[i3] = (byte) (i2 & 255);
            bArr[i3 + 1] = (byte) ((i2 >>> 8) & 255);
            bArr[i3 + 2] = (byte) ((i2 >>> 16) & 255);
            bArr[i3 + 3] = (byte) ((i2 >>> 24) & 255);
        }
    }

    public static void i(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, long j2, long j3, long j4, ByteBuffer byteBuffer) {
        c c1661b;
        c c1661b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{map, randomAccessFile, fileDescriptor, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), byteBuffer}) == null) {
            if (map.isEmpty()) {
                throw new SecurityException("No digests provided");
            }
            if (j2 > 1048576) {
                c1661b = new d(randomAccessFile.getChannel(), 0L, j2);
                c1661b2 = new d(randomAccessFile.getChannel(), j3, j4 - j3);
            } else {
                ByteBuffer allocate = ByteBuffer.allocate((int) j2);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                try {
                    randomAccessFile.seek(0L);
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    c1661b = new C1661b(allocate);
                    ByteBuffer allocate2 = ByteBuffer.allocate((int) (j4 - j3));
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    try {
                        randomAccessFile.seek(j3);
                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        c1661b2 = new C1661b(allocate2);
                    } catch (IOException e2) {
                        throw new SecurityException("Failed to get apk contents", e2);
                    }
                } catch (IOException e3) {
                    throw new SecurityException("Failed to get apk contents", e3);
                }
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            c.a.r.j.a.d.a.f(duplicate, j2);
            C1661b c1661b3 = new C1661b(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i2 = 0;
            for (Integer num : map.keySet()) {
                iArr[i2] = num.intValue();
                i2++;
            }
            try {
                byte[][] l = l(iArr, new c[]{c1661b, c1661b2, c1661b3});
                for (int i3 = 0; i3 < size; i3++) {
                    int i4 = iArr[i3];
                    if (!MessageDigest.isEqual(map.get(Integer.valueOf(i4)), l[i3])) {
                        throw new SecurityException(u(i4) + " digest of contents did not verify");
                    }
                }
            } catch (DigestException e4) {
                throw new SecurityException("Failed to compute digest(s) of contents", e4);
            }
        }
    }

    public static boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            if (i2 == 513 || i2 == 514 || i2 == 769) {
                return true;
            }
            switch (i2) {
                case 257:
                case 258:
                case 259:
                case 260:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static X509Certificate[] k(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        InterceptResult invokeLLL;
        int o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, byteBuffer, map, certificateFactory)) == null) {
            ByteBuffer e2 = e(byteBuffer);
            ByteBuffer e3 = e(byteBuffer);
            byte[] r = r(byteBuffer);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = null;
            byte[] bArr2 = null;
            int i2 = -1;
            int i3 = 0;
            while (e3.hasRemaining()) {
                i3++;
                try {
                    ByteBuffer e4 = e(e3);
                    if (e4.remaining() < 8) {
                        throw new SecurityException("Signature record too short");
                    }
                    int i4 = e4.getInt();
                    arrayList.add(Integer.valueOf(i4));
                    if (j(i4) && (i2 == -1 || a(i4, i2) > 0)) {
                        bArr2 = r(e4);
                        i2 = i4;
                    }
                } catch (IOException | BufferUnderflowException e5) {
                    throw new SecurityException("Failed to parse signature record #" + i3, e5);
                }
            }
            if (i2 == -1) {
                if (i3 == 0) {
                    throw new SecurityException("No signatures found");
                }
                throw new SecurityException("No supported signatures found");
            }
            String y = y(i2);
            Pair<String, ? extends AlgorithmParameterSpec> z = z(i2);
            String str = (String) z.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) z.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(y).generatePublic(new X509EncodedKeySpec(r));
                Signature signature = Signature.getInstance(str);
                signature.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    signature.setParameter(algorithmParameterSpec);
                }
                signature.update(e2);
                if (!signature.verify(bArr2)) {
                    throw new SecurityException(str + " signature did not verify");
                }
                e2.clear();
                ByteBuffer e6 = e(e2);
                ArrayList arrayList2 = new ArrayList();
                int i5 = 0;
                while (e6.hasRemaining()) {
                    i5++;
                    try {
                        ByteBuffer e7 = e(e6);
                        if (e7.remaining() < 8) {
                            throw new IOException("Record too short");
                        }
                        int i6 = e7.getInt();
                        arrayList2.add(Integer.valueOf(i6));
                        if (i6 == i2) {
                            bArr = r(e7);
                        }
                    } catch (IOException | BufferUnderflowException e8) {
                        throw new IOException("Failed to parse digest record #" + i5, e8);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    byte[] put = map.put(Integer.valueOf(o(i2)), bArr);
                    if (put != null && !MessageDigest.isEqual(put, bArr)) {
                        throw new SecurityException(u(o) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer e9 = e(e2);
                    ArrayList arrayList3 = new ArrayList();
                    int i7 = 0;
                    while (e9.hasRemaining()) {
                        i7++;
                        byte[] r2 = r(e9);
                        try {
                            arrayList3.add(new f((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(r2)), r2));
                        } catch (CertificateException e10) {
                            throw new SecurityException("Failed to decode certificate #" + i7, e10);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        throw new SecurityException("No certificates listed");
                    }
                    if (Arrays.equals(r, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                        return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                    }
                    throw new SecurityException("Public key mismatch between certificate and signature record");
                }
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e11) {
                throw new SecurityException("Failed to verify " + str + " signature", e11);
            }
        }
        return (X509Certificate[]) invokeLLL.objValue;
    }

    public static byte[][] l(int[] iArr, c[] cVarArr) {
        InterceptResult invokeLL;
        MessageDigest messageDigest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, iArr, cVarArr)) == null) {
            c[] cVarArr2 = cVarArr;
            long j2 = 0;
            long j3 = 0;
            for (c cVar : cVarArr2) {
                j3 += b(cVar.a());
            }
            if (j3 >= 2097151) {
                throw new DigestException("Too many chunks: " + j3);
            }
            int i2 = (int) j3;
            byte[][] bArr = new byte[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                byte[] bArr2 = new byte[(w(iArr[i3]) * i2) + 5];
                bArr2[0] = 90;
                h(i2, bArr2, 1);
                bArr[i3] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                String u = u(iArr[i4]);
                try {
                    messageDigestArr[i4] = MessageDigest.getInstance(u);
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(u + " digest not supported", e2);
                }
            }
            int length2 = cVarArr2.length;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < length2) {
                c cVar2 = cVarArr2[i5];
                int i8 = length2;
                int i9 = i5;
                long a2 = cVar2.a();
                long j4 = j2;
                while (a2 > j2) {
                    int min = (int) Math.min(a2, 1048576L);
                    h(min, bArr3, 1);
                    for (int i10 = 0; i10 < length; i10++) {
                        messageDigestArr[i10].update(bArr3);
                    }
                    try {
                        cVar2.a(messageDigestArr, j4, min);
                        int i11 = 0;
                        while (i11 < iArr.length) {
                            int i12 = iArr[i11];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i11];
                            int w = w(i12);
                            c cVar3 = cVar2;
                            int i13 = length;
                            int digest = messageDigestArr[i11].digest(bArr5, (i6 * w) + 5, w);
                            if (digest != w) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                            i11++;
                            bArr3 = bArr4;
                            cVar2 = cVar3;
                            length = i13;
                        }
                        long j5 = min;
                        j4 += j5;
                        a2 -= j5;
                        i6++;
                        bArr3 = bArr3;
                        j2 = 0;
                    } catch (IOException e3) {
                        throw new DigestException("Failed to digest chunk #" + i6 + " of section #" + i7, e3);
                    }
                }
                i7++;
                i5 = i9 + 1;
                cVarArr2 = cVarArr;
                length2 = i8;
                j2 = 0;
            }
            byte[][] bArr6 = new byte[iArr.length];
            for (int i14 = 0; i14 < iArr.length; i14++) {
                int i15 = iArr[i14];
                byte[] bArr7 = bArr[i14];
                String u2 = u(i15);
                try {
                    bArr6[i14] = MessageDigest.getInstance(u2).digest(bArr7);
                } catch (NoSuchAlgorithmException e4) {
                    throw new RuntimeException(u2 + " digest not supported", e4);
                }
            }
            return bArr6;
        }
        return (byte[][]) invokeLL.objValue;
    }

    public static X509Certificate[][] m(RandomAccessFile randomAccessFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, randomAccessFile)) == null) ? n(randomAccessFile, randomAccessFile.getFD(), q(randomAccessFile)) : (X509Certificate[][]) invokeL.objValue;
    }

    public static X509Certificate[][] n(RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, h hVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, randomAccessFile, fileDescriptor, hVar)) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                try {
                    ByteBuffer e2 = e(hVar.f40662a);
                    int i2 = 0;
                    while (e2.hasRemaining()) {
                        i2++;
                        try {
                            arrayList.add(k(e(e2), hashMap, certificateFactory));
                        } catch (IOException | SecurityException | BufferUnderflowException e3) {
                            throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e3);
                        }
                    }
                    if (i2 >= 1) {
                        if (hashMap.isEmpty()) {
                            throw new SecurityException("No content digests found");
                        }
                        i(hashMap, randomAccessFile, fileDescriptor, hVar.f40663b, hVar.f40664c, hVar.f40665d, hVar.f40666e);
                        return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                    }
                    throw new SecurityException("No signers found");
                } catch (IOException e4) {
                    throw new SecurityException("Failed to read list of signers", e4);
                }
            } catch (CertificateException e5) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
            }
        }
        return (X509Certificate[][]) invokeLLL.objValue;
    }

    public static int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) {
            if (i2 != 513) {
                if (i2 != 514) {
                    if (i2 != 769) {
                        switch (i2) {
                            case 257:
                            case 259:
                                return 1;
                            case 258:
                            case 260:
                                return 2;
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
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

    public static int p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65551, null, i2, i3)) == null) {
            if (i2 == 1) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        return -1;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i3);
                }
                return 0;
            } else if (i2 != 2) {
                throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i2);
            } else if (i3 != 1) {
                if (i3 == 2) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i3);
            } else {
                return 1;
            }
        }
        return invokeII.intValue;
    }

    public static h q(RandomAccessFile randomAccessFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, randomAccessFile)) == null) {
            Pair<ByteBuffer, Long> t = t(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) t.first;
            long longValue = ((Long) t.second).longValue();
            if (c.a.r.j.a.d.a.g(randomAccessFile, longValue)) {
                throw new e("ZIP64 APK not supported");
            }
            long c2 = c(byteBuffer, longValue);
            Pair<ByteBuffer, Long> d2 = d(randomAccessFile, c2);
            return new h(v((ByteBuffer) d2.first), ((Long) d2.second).longValue(), c2, longValue, byteBuffer, null);
        }
        return (h) invokeL.objValue;
    }

    public static byte[] r(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, byteBuffer)) == null) {
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    byte[] bArr = new byte[i2];
                    byteBuffer.get(bArr);
                    return bArr;
                }
                throw new IOException("Underflow while reading length-prefixed value. Length: " + i2 + ", available: " + byteBuffer.remaining());
            }
            throw new IOException("Negative length");
        }
        return (byte[]) invokeL.objValue;
    }

    public static X509Certificate[][] s(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, file)) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, r.f42342a);
            try {
                return m(randomAccessFile);
            } finally {
                c.a.r.g.c.a.c.c(randomAccessFile);
            }
        }
        return (X509Certificate[][]) invokeL.objValue;
    }

    public static Pair<ByteBuffer, Long> t(RandomAccessFile randomAccessFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, randomAccessFile)) == null) {
            Pair<ByteBuffer, Long> c2 = c.a.r.j.a.d.a.c(randomAccessFile);
            if (c2 != null) {
                return c2;
            }
            throw new e("Not an APK file: ZIP End of Central Directory record not found");
        }
        return (Pair) invokeL.objValue;
    }

    public static String u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return "SHA-512";
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
            }
            return "SHA-256";
        }
        return (String) invokeI.objValue;
    }

    public static ByteBuffer v(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, byteBuffer)) == null) {
            x(byteBuffer);
            ByteBuffer g2 = g(byteBuffer, 8, byteBuffer.capacity() - 24);
            int i2 = 0;
            while (g2.hasRemaining()) {
                i2++;
                if (g2.remaining() < 8) {
                    throw new e("Insufficient data to read size of APK Signing Block entry #" + i2);
                }
                long j2 = g2.getLong();
                if (j2 < 4 || j2 > 2147483647L) {
                    throw new e("APK Signing Block entry #" + i2 + " size out of range: " + j2);
                }
                int i3 = (int) j2;
                int position = g2.position() + i3;
                if (i3 > g2.remaining()) {
                    throw new e("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + g2.remaining());
                } else if (g2.getInt() == 1896449818) {
                    return f(g2, i3 - 4);
                } else {
                    g2.position(position);
                }
            }
            throw new e("No APK Signature Scheme v2 block in APK Signing Block");
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static int w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 64;
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
            }
            return 32;
        }
        return invokeI.intValue;
    }

    public static void x(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, byteBuffer) == null) && byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static String y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i2)) == null) {
            if (i2 == 513 || i2 == 514) {
                return "EC";
            }
            if (i2 != 769) {
                switch (i2) {
                    case 257:
                    case 258:
                    case 259:
                    case 260:
                        return "RSA";
                    default:
                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
                }
            }
            return "DSA";
        }
        return (String) invokeI.objValue;
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65561, null, i2)) == null) {
            if (i2 != 513) {
                if (i2 != 514) {
                    if (i2 != 769) {
                        switch (i2) {
                            case 257:
                                return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                            case 258:
                                return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                            case 259:
                                return Pair.create("SHA256withRSA", null);
                            case 260:
                                return Pair.create("SHA512withRSA", null);
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
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
}
