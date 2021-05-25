package com.baidu.helios.trusts.zone.verifier;

import android.util.Pair;
import com.baidu.mapsdkplatform.comapi.map.r;
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
/* loaded from: classes2.dex */
public class b {

    /* renamed from: com.baidu.helios.trusts.zone.verifier.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0088b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f6272a;

        public C0088b(ByteBuffer byteBuffer) {
            this.f6272a = byteBuffer.slice();
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.c
        public long a() {
            return this.f6272a.capacity();
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.c
        public void a(MessageDigest[] messageDigestArr, long j, int i2) {
            ByteBuffer slice;
            synchronized (this.f6272a) {
                int i3 = (int) j;
                this.f6272a.position(i3);
                this.f6272a.limit(i3 + i2);
                slice = this.f6272a.slice();
            }
            for (MessageDigest messageDigest : messageDigestArr) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        long a();

        void a(MessageDigest[] messageDigestArr, long j, int i2);
    }

    /* loaded from: classes2.dex */
    public static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        public final FileChannel f6273a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6274b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6275c;

        public d(FileChannel fileChannel, long j, long j2) {
            this.f6273a = fileChannel;
            this.f6274b = j;
            this.f6275c = j2;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.c
        public long a() {
            return this.f6275c;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.c
        public void a(MessageDigest[] messageDigestArr, long j, int i2) {
            MappedByteBuffer map = this.f6273a.map(FileChannel.MapMode.READ_ONLY, this.f6274b + j, i2);
            for (MessageDigest messageDigest : messageDigestArr) {
                map.position(0);
                messageDigest.update(map);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends Exception {

        /* renamed from: a  reason: collision with root package name */
        public static final long f6276a = 1;

        public e(String str) {
            super(str);
        }

        public e(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends g {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f6277a;

        public f(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            this.f6277a = bArr;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.g, java.security.cert.Certificate
        public byte[] getEncoded() {
            return this.f6277a;
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends X509Certificate {

        /* renamed from: a  reason: collision with root package name */
        public final X509Certificate f6278a;

        public g(X509Certificate x509Certificate) {
            this.f6278a = x509Certificate;
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity() {
            this.f6278a.checkValidity();
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity(Date date) {
            this.f6278a.checkValidity(date);
        }

        @Override // java.security.cert.X509Certificate
        public int getBasicConstraints() {
            return this.f6278a.getBasicConstraints();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getCriticalExtensionOIDs() {
            return this.f6278a.getCriticalExtensionOIDs();
        }

        @Override // java.security.cert.Certificate
        public byte[] getEncoded() {
            return this.f6278a.getEncoded();
        }

        @Override // java.security.cert.X509Extension
        public byte[] getExtensionValue(String str) {
            return this.f6278a.getExtensionValue(str);
        }

        @Override // java.security.cert.X509Certificate
        public Principal getIssuerDN() {
            return this.f6278a.getIssuerDN();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getIssuerUniqueID() {
            return this.f6278a.getIssuerUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getKeyUsage() {
            return this.f6278a.getKeyUsage();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getNonCriticalExtensionOIDs() {
            return this.f6278a.getNonCriticalExtensionOIDs();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotAfter() {
            return this.f6278a.getNotAfter();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotBefore() {
            return this.f6278a.getNotBefore();
        }

        @Override // java.security.cert.Certificate
        public PublicKey getPublicKey() {
            return this.f6278a.getPublicKey();
        }

        @Override // java.security.cert.X509Certificate
        public BigInteger getSerialNumber() {
            return this.f6278a.getSerialNumber();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgName() {
            return this.f6278a.getSigAlgName();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgOID() {
            return this.f6278a.getSigAlgOID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSigAlgParams() {
            return this.f6278a.getSigAlgParams();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSignature() {
            return this.f6278a.getSignature();
        }

        @Override // java.security.cert.X509Certificate
        public Principal getSubjectDN() {
            return this.f6278a.getSubjectDN();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getSubjectUniqueID() {
            return this.f6278a.getSubjectUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getTBSCertificate() {
            return this.f6278a.getTBSCertificate();
        }

        @Override // java.security.cert.X509Certificate
        public int getVersion() {
            return this.f6278a.getVersion();
        }

        @Override // java.security.cert.X509Extension
        public boolean hasUnsupportedCriticalExtension() {
            return this.f6278a.hasUnsupportedCriticalExtension();
        }

        @Override // java.security.cert.Certificate
        public String toString() {
            return this.f6278a.toString();
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey) {
            this.f6278a.verify(publicKey);
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey, String str) {
            this.f6278a.verify(publicKey, str);
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f6279a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6280b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6281c;

        /* renamed from: d  reason: collision with root package name */
        public final long f6282d;

        /* renamed from: e  reason: collision with root package name */
        public final ByteBuffer f6283e;

        public h(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
            this.f6279a = byteBuffer;
            this.f6280b = j;
            this.f6281c = j2;
            this.f6282d = j3;
            this.f6283e = byteBuffer2;
        }
    }

    public static int a(int i2, int i3) {
        return p(o(i2), o(i3));
    }

    public static final long b(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    public static long c(ByteBuffer byteBuffer, long j) {
        long b2 = d.a.q.j.a.d.a.b(byteBuffer);
        if (b2 < j) {
            if (d.a.q.j.a.d.a.h(byteBuffer) + b2 == j) {
                return b2;
            }
            throw new e("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new e("ZIP Central Directory offset out of range: " + b2 + ". ZIP End of Central Directory offset: " + j);
    }

    public static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, long j) {
        if (j < 32) {
            throw new e("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - allocate.capacity());
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
            long j2 = allocate.getLong(0);
            if (j2 < allocate.capacity() || j2 > 2147483639) {
                throw new e("APK Signing Block size out of range: " + j2);
            }
            int i2 = (int) (8 + j2);
            long j3 = j - i2;
            if (j3 < 0) {
                throw new e("APK Signing Block offset out of range: " + j3);
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i2);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
            long j4 = allocate2.getLong(0);
            if (j4 == j2) {
                return Pair.create(allocate2, Long.valueOf(j3));
            }
            throw new e("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        throw new e("No APK Signing Block before ZIP Central Directory");
    }

    public static ByteBuffer e(ByteBuffer byteBuffer) {
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

    public static ByteBuffer f(ByteBuffer byteBuffer, int i2) {
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

    public static ByteBuffer g(ByteBuffer byteBuffer, int i2, int i3) {
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

    public static void h(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 3] = (byte) ((i2 >>> 24) & 255);
    }

    public static void i(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, long j, long j2, long j3, ByteBuffer byteBuffer) {
        c c0088b;
        c c0088b2;
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        if (j > 1048576) {
            c0088b = new d(randomAccessFile.getChannel(), 0L, j);
            c0088b2 = new d(randomAccessFile.getChannel(), j2, j3 - j2);
        } else {
            ByteBuffer allocate = ByteBuffer.allocate((int) j);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            try {
                randomAccessFile.seek(0L);
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                c0088b = new C0088b(allocate);
                ByteBuffer allocate2 = ByteBuffer.allocate((int) (j3 - j2));
                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                try {
                    randomAccessFile.seek(j2);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    c0088b2 = new C0088b(allocate2);
                } catch (IOException e2) {
                    throw new SecurityException("Failed to get apk contents", e2);
                }
            } catch (IOException e3) {
                throw new SecurityException("Failed to get apk contents", e3);
            }
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        d.a.q.j.a.d.a.f(duplicate, j);
        C0088b c0088b3 = new C0088b(duplicate);
        int size = map.size();
        int[] iArr = new int[size];
        int i2 = 0;
        for (Integer num : map.keySet()) {
            iArr[i2] = num.intValue();
            i2++;
        }
        try {
            byte[][] l = l(iArr, new c[]{c0088b, c0088b2, c0088b3});
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

    public static boolean j(int i2) {
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

    public static X509Certificate[] k(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        int o;
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

    public static byte[][] l(int[] iArr, c[] cVarArr) {
        MessageDigest messageDigest;
        c[] cVarArr2 = cVarArr;
        long j = 0;
        long j2 = 0;
        for (c cVar : cVarArr2) {
            j2 += b(cVar.a());
        }
        if (j2 >= 2097151) {
            throw new DigestException("Too many chunks: " + j2);
        }
        int i2 = (int) j2;
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
            long j3 = j;
            while (a2 > j) {
                int min = (int) Math.min(a2, 1048576L);
                h(min, bArr3, 1);
                for (int i10 = 0; i10 < length; i10++) {
                    messageDigestArr[i10].update(bArr3);
                }
                try {
                    cVar2.a(messageDigestArr, j3, min);
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
                    long j4 = min;
                    j3 += j4;
                    a2 -= j4;
                    i6++;
                    bArr3 = bArr3;
                    j = 0;
                } catch (IOException e3) {
                    throw new DigestException("Failed to digest chunk #" + i6 + " of section #" + i7, e3);
                }
            }
            i7++;
            i5 = i9 + 1;
            cVarArr2 = cVarArr;
            length2 = i8;
            j = 0;
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

    public static X509Certificate[][] m(RandomAccessFile randomAccessFile) {
        return n(randomAccessFile, randomAccessFile.getFD(), q(randomAccessFile));
    }

    public static X509Certificate[][] n(RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, h hVar) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer e2 = e(hVar.f6279a);
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
                    i(hashMap, randomAccessFile, fileDescriptor, hVar.f6280b, hVar.f6281c, hVar.f6282d, hVar.f6283e);
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

    public static int o(int i2) {
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

    public static int p(int i2, int i3) {
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

    public static h q(RandomAccessFile randomAccessFile) {
        Pair<ByteBuffer, Long> t = t(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) t.first;
        long longValue = ((Long) t.second).longValue();
        if (d.a.q.j.a.d.a.g(randomAccessFile, longValue)) {
            throw new e("ZIP64 APK not supported");
        }
        long c2 = c(byteBuffer, longValue);
        Pair<ByteBuffer, Long> d2 = d(randomAccessFile, c2);
        return new h(v((ByteBuffer) d2.first), ((Long) d2.second).longValue(), c2, longValue, byteBuffer);
    }

    public static byte[] r(ByteBuffer byteBuffer) {
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

    public static X509Certificate[][] s(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, r.f7672a);
        try {
            return m(randomAccessFile);
        } finally {
            d.a.q.g.c.a.c.c(randomAccessFile);
        }
    }

    public static Pair<ByteBuffer, Long> t(RandomAccessFile randomAccessFile) {
        Pair<ByteBuffer, Long> c2 = d.a.q.j.a.d.a.c(randomAccessFile);
        if (c2 != null) {
            return c2;
        }
        throw new e("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static String u(int i2) {
        if (i2 != 1) {
            if (i2 == 2) {
                return "SHA-512";
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
        }
        return "SHA-256";
    }

    public static ByteBuffer v(ByteBuffer byteBuffer) {
        x(byteBuffer);
        ByteBuffer g2 = g(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (g2.hasRemaining()) {
            i2++;
            if (g2.remaining() < 8) {
                throw new e("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j = g2.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new e("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
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

    public static int w(int i2) {
        if (i2 != 1) {
            if (i2 == 2) {
                return 64;
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i2);
        }
        return 32;
    }

    public static void x(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static String y(int i2) {
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

    public static Pair<String, ? extends AlgorithmParameterSpec> z(int i2) {
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
}
