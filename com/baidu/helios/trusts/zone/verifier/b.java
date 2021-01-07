package com.baidu.helios.trusts.zone.verifier;

import android.util.Pair;
import com.baidu.android.common.security.RSAUtil;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements InterfaceC0152b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f2520a;

        public a(ByteBuffer byteBuffer) {
            this.f2520a = byteBuffer.slice();
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.InterfaceC0152b
        public long a() {
            return this.f2520a.capacity();
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.InterfaceC0152b
        public void a(MessageDigest[] messageDigestArr, long j, int i) {
            ByteBuffer slice;
            synchronized (this.f2520a) {
                this.f2520a.position((int) j);
                this.f2520a.limit(((int) j) + i);
                slice = this.f2520a.slice();
            }
            for (MessageDigest messageDigest : messageDigestArr) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.helios.trusts.zone.verifier.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0152b {
        long a();

        void a(MessageDigest[] messageDigestArr, long j, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c implements InterfaceC0152b {
        private final FileChannel azd;

        /* renamed from: b  reason: collision with root package name */
        private final long f2521b;
        private final long c;

        public c(FileChannel fileChannel, long j, long j2) {
            this.azd = fileChannel;
            this.f2521b = j;
            this.c = j2;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.InterfaceC0152b
        public long a() {
            return this.c;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.InterfaceC0152b
        public void a(MessageDigest[] messageDigestArr, long j, int i) {
            MappedByteBuffer map = this.azd.map(FileChannel.MapMode.READ_ONLY, this.f2521b + j, i);
            for (MessageDigest messageDigest : messageDigestArr) {
                map.position(0);
                messageDigest.update(map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f2522a;

        /* renamed from: b  reason: collision with root package name */
        private final long f2523b;
        private final long c;
        private final long d;
        private final ByteBuffer e;

        private d(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
            this.f2522a = byteBuffer;
            this.f2523b = j;
            this.c = j2;
            this.d = j3;
            this.e = byteBuffer2;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private static final long f2524a = 1;

        public e(String str) {
            super(str);
        }

        public e(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends g {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f2525a;

        public f(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            this.f2525a = bArr;
        }

        @Override // com.baidu.helios.trusts.zone.verifier.b.g, java.security.cert.Certificate
        public byte[] getEncoded() {
            return this.f2525a;
        }
    }

    /* loaded from: classes4.dex */
    private static class g extends X509Certificate {

        /* renamed from: a  reason: collision with root package name */
        private final X509Certificate f2526a;

        public g(X509Certificate x509Certificate) {
            this.f2526a = x509Certificate;
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity() {
            this.f2526a.checkValidity();
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity(Date date) {
            this.f2526a.checkValidity(date);
        }

        @Override // java.security.cert.X509Certificate
        public int getBasicConstraints() {
            return this.f2526a.getBasicConstraints();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getCriticalExtensionOIDs() {
            return this.f2526a.getCriticalExtensionOIDs();
        }

        @Override // java.security.cert.Certificate
        public byte[] getEncoded() {
            return this.f2526a.getEncoded();
        }

        @Override // java.security.cert.X509Extension
        public byte[] getExtensionValue(String str) {
            return this.f2526a.getExtensionValue(str);
        }

        @Override // java.security.cert.X509Certificate
        public Principal getIssuerDN() {
            return this.f2526a.getIssuerDN();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getIssuerUniqueID() {
            return this.f2526a.getIssuerUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getKeyUsage() {
            return this.f2526a.getKeyUsage();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getNonCriticalExtensionOIDs() {
            return this.f2526a.getNonCriticalExtensionOIDs();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotAfter() {
            return this.f2526a.getNotAfter();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotBefore() {
            return this.f2526a.getNotBefore();
        }

        @Override // java.security.cert.Certificate
        public PublicKey getPublicKey() {
            return this.f2526a.getPublicKey();
        }

        @Override // java.security.cert.X509Certificate
        public BigInteger getSerialNumber() {
            return this.f2526a.getSerialNumber();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgName() {
            return this.f2526a.getSigAlgName();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgOID() {
            return this.f2526a.getSigAlgOID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSigAlgParams() {
            return this.f2526a.getSigAlgParams();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSignature() {
            return this.f2526a.getSignature();
        }

        @Override // java.security.cert.X509Certificate
        public Principal getSubjectDN() {
            return this.f2526a.getSubjectDN();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getSubjectUniqueID() {
            return this.f2526a.getSubjectUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getTBSCertificate() {
            return this.f2526a.getTBSCertificate();
        }

        @Override // java.security.cert.X509Certificate
        public int getVersion() {
            return this.f2526a.getVersion();
        }

        @Override // java.security.cert.X509Extension
        public boolean hasUnsupportedCriticalExtension() {
            return this.f2526a.hasUnsupportedCriticalExtension();
        }

        @Override // java.security.cert.Certificate
        public String toString() {
            return this.f2526a.toString();
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey) {
            this.f2526a.verify(publicKey);
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey, String str) {
            this.f2526a.verify(publicKey, str);
        }
    }

    private static int a(int i, int i2) {
        return b(b(i), b(i2));
    }

    private static final long a(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    private static long a(ByteBuffer byteBuffer, long j) {
        long j2 = com.baidu.helios.trusts.zone.verifier.a.j(byteBuffer);
        if (j2 >= j) {
            throw new e("ZIP Central Directory offset out of range: " + j2 + ". ZIP End of Central Directory offset: " + j);
        }
        if (com.baidu.helios.trusts.zone.verifier.a.k(byteBuffer) + j2 != j) {
            throw new e("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        return j2;
    }

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j) {
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
            int i = (int) (8 + j2);
            long j3 = j - i;
            if (j3 < 0) {
                throw new e("APK Signing Block offset out of range: " + j3);
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
            long j4 = allocate2.getLong(0);
            if (j4 != j2) {
                throw new e("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
            }
            return Pair.create(allocate2, Long.valueOf(j3));
        }
        throw new e("No APK Signing Block before ZIP Central Directory");
    }

    private static ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        return b(byteBuffer, i);
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
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

    private static void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    private static void a(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, long j, long j2, long j3, ByteBuffer byteBuffer) {
        InterfaceC0152b aVar;
        InterfaceC0152b interfaceC0152b;
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        if (j > 1048576) {
            InterfaceC0152b cVar = new c(randomAccessFile.getChannel(), 0L, j);
            aVar = new c(randomAccessFile.getChannel(), j2, j3 - j2);
            interfaceC0152b = cVar;
        } else {
            ByteBuffer allocate = ByteBuffer.allocate((int) j);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            try {
                randomAccessFile.seek(0L);
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                InterfaceC0152b aVar2 = new a(allocate);
                ByteBuffer allocate2 = ByteBuffer.allocate((int) (j3 - j2));
                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                try {
                    randomAccessFile.seek(j2);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    aVar = new a(allocate2);
                    interfaceC0152b = aVar2;
                } catch (IOException e2) {
                    throw new SecurityException("Failed to get apk contents", e2);
                }
            } catch (IOException e3) {
                throw new SecurityException("Failed to get apk contents", e3);
            }
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        com.baidu.helios.trusts.zone.verifier.a.b(duplicate, j);
        a aVar3 = new a(duplicate);
        int[] iArr = new int[map.size()];
        int i = 0;
        Iterator<Integer> it = map.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            iArr[i2] = it.next().intValue();
            i = i2 + 1;
        }
        try {
            byte[][] a2 = a(iArr, new InterfaceC0152b[]{interfaceC0152b, aVar, aVar3});
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= iArr.length) {
                    return;
                }
                int i5 = iArr[i4];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i5)), a2[i4])) {
                    throw new SecurityException(c(i5) + " digest of contents did not verify");
                }
                i3 = i4 + 1;
            }
        } catch (DigestException e4) {
            throw new SecurityException("Failed to compute digest(s) of contents", e4);
        }
    }

    private static boolean a(int i) {
        switch (i) {
            case 257:
            case 258:
            case 259:
            case 260:
            case 513:
            case 514:
            case 769:
                return true;
            default:
                return false;
        }
    }

    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        int b2;
        byte[] g2;
        ByteBuffer a2 = a(byteBuffer);
        ByteBuffer a3 = a(byteBuffer);
        byte[] g3 = g(byteBuffer);
        int i = -1;
        byte[] bArr = null;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (a3.hasRemaining()) {
            i2++;
            try {
                ByteBuffer a4 = a(a3);
                if (a4.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = a4.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (a(i3)) {
                    if (i == -1 || a(i3, i) > 0) {
                        g2 = g(a4);
                    } else {
                        g2 = bArr;
                        i3 = i;
                    }
                    bArr = g2;
                    i = i3;
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
        String e3 = e(i);
        Pair<String, ? extends AlgorithmParameterSpec> dt = dt(i);
        String str = (String) dt.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) dt.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(e3).generatePublic(new X509EncodedKeySpec(g3));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(generatePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(a2);
            if (signature.verify(bArr)) {
                byte[] bArr2 = null;
                a2.clear();
                ByteBuffer a5 = a(a2);
                ArrayList arrayList2 = new ArrayList();
                int i4 = 0;
                while (a5.hasRemaining()) {
                    i4++;
                    try {
                        ByteBuffer a6 = a(a5);
                        if (a6.remaining() < 8) {
                            throw new IOException("Record too short");
                        }
                        int i5 = a6.getInt();
                        arrayList2.add(Integer.valueOf(i5));
                        bArr2 = i5 == i ? g(a6) : bArr2;
                    } catch (IOException | BufferUnderflowException e4) {
                        throw new IOException("Failed to parse digest record #" + i4, e4);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    byte[] put = map.put(Integer.valueOf(b(i)), bArr2);
                    if (put == null || MessageDigest.isEqual(put, bArr2)) {
                        ByteBuffer a7 = a(a2);
                        ArrayList arrayList3 = new ArrayList();
                        int i6 = 0;
                        while (a7.hasRemaining()) {
                            int i7 = i6 + 1;
                            byte[] g4 = g(a7);
                            try {
                                arrayList3.add(new f((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(g4)), g4));
                                i6 = i7;
                            } catch (CertificateException e5) {
                                throw new SecurityException("Failed to decode certificate #" + i7, e5);
                            }
                        }
                        if (arrayList3.isEmpty()) {
                            throw new SecurityException("No certificates listed");
                        }
                        if (Arrays.equals(g3, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                        }
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                    throw new SecurityException(c(b2) + " contents digest does not match the digest specified by a preceding signer");
                }
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            throw new SecurityException(str + " signature did not verify");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e6) {
            throw new SecurityException("Failed to verify " + str + " signature", e6);
        }
    }

    private static byte[][] a(int[] iArr, InterfaceC0152b[] interfaceC0152bArr) {
        MessageDigest messageDigest;
        long j = 0;
        for (InterfaceC0152b interfaceC0152b : interfaceC0152bArr) {
            j += a(interfaceC0152b.a());
        }
        if (j >= 2097151) {
            throw new DigestException("Too many chunks: " + j);
        }
        int i = (int) j;
        byte[][] bArr = new byte[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[(d(iArr[i2]) * i) + 5];
            bArr2[0] = 90;
            a(i, bArr2, 1);
            bArr[i2] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int i3 = 0;
        MessageDigest[] messageDigestArr = new MessageDigest[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            String c2 = c(iArr[i4]);
            try {
                messageDigestArr[i4] = MessageDigest.getInstance(c2);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(c2 + " digest not supported", e2);
            }
        }
        int i5 = 0;
        int length = interfaceC0152bArr.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 >= length) {
                byte[][] bArr4 = new byte[iArr.length];
                for (int i9 = 0; i9 < iArr.length; i9++) {
                    int i10 = iArr[i9];
                    byte[] bArr5 = bArr[i9];
                    String c3 = c(i10);
                    try {
                        bArr4[i9] = MessageDigest.getInstance(c3).digest(bArr5);
                    } catch (NoSuchAlgorithmException e3) {
                        throw new RuntimeException(c3 + " digest not supported", e3);
                    }
                }
                return bArr4;
            }
            InterfaceC0152b interfaceC0152b2 = interfaceC0152bArr[i7];
            long j2 = 0;
            long a2 = interfaceC0152b2.a();
            while (true) {
                long j3 = a2;
                if (j3 > 0) {
                    int min = (int) Math.min(j3, 1048576L);
                    a(min, bArr3, 1);
                    for (MessageDigest messageDigest2 : messageDigestArr) {
                        messageDigest2.update(bArr3);
                    }
                    try {
                        interfaceC0152b2.a(messageDigestArr, j2, min);
                        for (int i11 = 0; i11 < iArr.length; i11++) {
                            int i12 = iArr[i11];
                            byte[] bArr6 = bArr[i11];
                            int d2 = d(i12);
                            int digest = messageDigestArr[i11].digest(bArr6, (i3 * d2) + 5, d2);
                            if (digest != d2) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                        }
                        j2 += min;
                        a2 = j3 - min;
                        i3++;
                    } catch (IOException e4) {
                        throw new DigestException("Failed to digest chunk #" + i3 + " of section #" + i8, e4);
                    }
                }
            }
            i5 = i8 + 1;
            i6 = i7 + 1;
        }
    }

    private static X509Certificate[][] a(RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, d dVar) {
        int i = 0;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a2 = a(dVar.f2522a);
                while (a2.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(a(a(a2), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e2);
                    }
                }
                if (i < 1) {
                    throw new SecurityException("No signers found");
                }
                if (hashMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                a(hashMap, randomAccessFile, fileDescriptor, dVar.f2523b, dVar.c, dVar.d, dVar.e);
                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    private static int b(int i) {
        switch (i) {
            case 257:
            case 259:
            case 513:
            case 769:
                return 1;
            case 258:
            case 260:
            case 514:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    private static int b(int i, int i2) {
        switch (i) {
            case 1:
                switch (i2) {
                    case 1:
                        return 0;
                    case 2:
                        return -1;
                    default:
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
            case 2:
                switch (i2) {
                    case 1:
                        return 1;
                    case 2:
                        return 0;
                    default:
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
            default:
                throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i);
        }
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size: " + i);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = position + i;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
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

    private static X509Certificate[][] b(RandomAccessFile randomAccessFile) {
        return a(randomAccessFile, randomAccessFile.getFD(), c(randomAccessFile));
    }

    private static d c(RandomAccessFile randomAccessFile) {
        Pair<ByteBuffer, Long> d2 = d(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) d2.first;
        long longValue = ((Long) d2.second).longValue();
        if (com.baidu.helios.trusts.zone.verifier.a.b(randomAccessFile, longValue)) {
            throw new e("ZIP64 APK not supported");
        }
        long a2 = a(byteBuffer, longValue);
        Pair<ByteBuffer, Long> a3 = a(randomAccessFile, a2);
        return new d(h((ByteBuffer) a3.first), ((Long) a3.second).longValue(), a2, longValue, byteBuffer);
    }

    private static String c(int i) {
        switch (i) {
            case 1:
                return "SHA-256";
            case 2:
                return "SHA-512";
            default:
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
    }

    private static int d(int i) {
        switch (i) {
            case 1:
                return 32;
            case 2:
                return 64;
            default:
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
    }

    private static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile) {
        Pair<ByteBuffer, Long> e2 = com.baidu.helios.trusts.zone.verifier.a.e(randomAccessFile);
        if (e2 == null) {
            throw new e("Not an APK file: ZIP End of Central Directory record not found");
        }
        return e2;
    }

    private static void d(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static Pair<String, ? extends AlgorithmParameterSpec> dt(int i) {
        switch (i) {
            case 257:
                return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            case 258:
                return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
            case 259:
                return Pair.create("SHA256withRSA", null);
            case 260:
                return Pair.create("SHA512withRSA", null);
            case 513:
                return Pair.create("SHA256withECDSA", null);
            case 514:
                return Pair.create("SHA512withECDSA", null);
            case 769:
                return Pair.create("SHA256withDSA", null);
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    private static String e(int i) {
        switch (i) {
            case 257:
            case 258:
            case 259:
            case 260:
                return RSAUtil.ALGORITHM_RSA;
            case 513:
            case 514:
                return "EC";
            case 769:
                return "DSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    private static byte[] g(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    private static ByteBuffer h(ByteBuffer byteBuffer) {
        d(byteBuffer);
        ByteBuffer a2 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (a2.hasRemaining()) {
            i++;
            if (a2.remaining() < 8) {
                throw new e("Insufficient data to read size of APK Signing Block entry #" + i);
            }
            long j = a2.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new e("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int position = a2.position() + i2;
            if (i2 > a2.remaining()) {
                throw new e("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a2.remaining());
            }
            if (a2.getInt() == 1896449818) {
                return b(a2, i2 - 4);
            }
            a2.position(position);
        }
        throw new e("No APK Signature Scheme v2 block in APK Signing Block");
    }

    public static X509Certificate[][] n(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return b(randomAccessFile);
        } finally {
            com.baidu.helios.common.b.a.c.d(randomAccessFile);
        }
    }
}
