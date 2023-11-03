package com.baidu.android.pushservice.y.e;

import com.baidu.location.BDLocation;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class g extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final g C;
    public static Parser<g> D = new a();
    public byte A;
    public int B;
    public int a;
    public Object b;
    public int c;
    public int d;
    public int e;
    public Object f;
    public Object g;
    public int h;
    public int i;
    public ByteString j;
    public int k;
    public int l;
    public long m;
    public int n;
    public Object o;
    public Object p;
    public Object q;
    public int r;
    public Object s;
    public Object t;
    public Object u;
    public long v;
    public List<h> w;
    public int x;
    public long y;
    public Object z;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<g> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: a */
        public g parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new g(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<g, b> implements Object {
        public int a;
        public int c;
        public int d;
        public int e;
        public int h;
        public int i;
        public int k;
        public int l;
        public long m;
        public int n;
        public int r;
        public long v;
        public int x;
        public long y;
        public Object b = "";
        public Object f = "";
        public Object g = "";
        public ByteString j = ByteString.EMPTY;
        public Object o = "";
        public Object p = "";
        public Object q = "";
        public Object s = "";
        public Object t = "";
        public Object u = "";
        public List<h> w = Collections.emptyList();
        public Object z = "";

        public b() {
            i();
        }

        public static /* synthetic */ b a() {
            return f();
        }

        public static b f() {
            return new b();
        }

        public b a(int i) {
            this.a |= 65536;
            this.r = i;
            return this;
        }

        public b a(long j) {
            this.a |= 1048576;
            this.v = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(g gVar) {
            if (gVar == g.h()) {
                return this;
            }
            if (gVar.F()) {
                this.a |= 1;
                this.b = gVar.b;
            }
            if (gVar.V()) {
                i(gVar.x());
            }
            if (gVar.T()) {
                h(gVar.v());
            }
            if (gVar.G()) {
                b(gVar.g());
            }
            if (gVar.L()) {
                this.a |= 16;
                this.f = gVar.f;
            }
            if (gVar.O()) {
                this.a |= 32;
                this.g = gVar.g;
            }
            if (gVar.S()) {
                g(gVar.u());
            }
            if (gVar.M()) {
                d(gVar.o());
            }
            if (gVar.H()) {
                a(gVar.j());
            }
            if (gVar.I()) {
                c(gVar.k());
            }
            if (gVar.P()) {
                e(gVar.r());
            }
            if (gVar.J()) {
                b(gVar.l());
            }
            if (gVar.X()) {
                j(gVar.z());
            }
            if (gVar.R()) {
                this.a |= 8192;
                this.o = gVar.o;
            }
            if (gVar.A()) {
                this.a |= 16384;
                this.p = gVar.p;
            }
            if (gVar.D()) {
                this.a |= 32768;
                this.q = gVar.q;
            }
            if (gVar.C()) {
                a(gVar.c());
            }
            if (gVar.E()) {
                this.a |= 131072;
                this.s = gVar.s;
            }
            if (gVar.U()) {
                this.a |= 262144;
                this.t = gVar.t;
            }
            if (gVar.N()) {
                this.a |= 524288;
                this.u = gVar.u;
            }
            if (gVar.B()) {
                a(gVar.b());
            }
            if (!gVar.w.isEmpty()) {
                if (this.w.isEmpty()) {
                    this.w = gVar.w;
                    this.a &= -2097153;
                } else {
                    g();
                    this.w.addAll(gVar.w);
                }
            }
            if (gVar.Q()) {
                f(gVar.s());
            }
            if (gVar.K()) {
                c(gVar.m());
            }
            if (gVar.W()) {
                this.a |= 16777216;
                this.z = gVar.z;
            }
            return this;
        }

        public b a(h hVar) {
            if (hVar != null) {
                g();
                this.w.add(hVar);
                return this;
            }
            throw null;
        }

        public b a(ByteString byteString) {
            if (byteString != null) {
                this.a |= 256;
                this.j = byteString;
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            g gVar = null;
            try {
                try {
                    g parsePartialFrom = g.D.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    g gVar2 = (g) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        gVar = gVar2;
                        if (gVar != null) {
                            mergeFrom(gVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (gVar != null) {
                }
                throw th;
            }
        }

        public b a(String str) {
            if (str != null) {
                this.a |= 16384;
                this.p = str;
                return this;
            }
            throw null;
        }

        public b b(int i) {
            this.a |= 8;
            this.e = i;
            return this;
        }

        public b b(long j) {
            this.a |= 2048;
            this.m = j;
            return this;
        }

        public b b(String str) {
            if (str != null) {
                this.a |= 32768;
                this.q = str;
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public g build() {
            g buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public b c(int i) {
            this.a |= 512;
            this.k = i;
            return this;
        }

        public b c(long j) {
            this.a |= 8388608;
            this.y = j;
            return this;
        }

        public b c(String str) {
            if (str != null) {
                this.a |= 131072;
                this.s = str;
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public g buildPartial() {
            g gVar = new g(this);
            int i = this.a;
            int i2 = (i & 1) != 1 ? 0 : 1;
            gVar.b = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            gVar.c = this.c;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            gVar.d = this.d;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            gVar.e = this.e;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            gVar.f = this.f;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            gVar.g = this.g;
            if ((i & 64) == 64) {
                i2 |= 64;
            }
            gVar.h = this.h;
            if ((i & 128) == 128) {
                i2 |= 128;
            }
            gVar.i = this.i;
            if ((i & 256) == 256) {
                i2 |= 256;
            }
            gVar.j = this.j;
            if ((i & 512) == 512) {
                i2 |= 512;
            }
            gVar.k = this.k;
            if ((i & 1024) == 1024) {
                i2 |= 1024;
            }
            gVar.l = this.l;
            if ((i & 2048) == 2048) {
                i2 |= 2048;
            }
            gVar.m = this.m;
            if ((i & 4096) == 4096) {
                i2 |= 4096;
            }
            gVar.n = this.n;
            if ((i & 8192) == 8192) {
                i2 |= 8192;
            }
            gVar.o = this.o;
            if ((i & 16384) == 16384) {
                i2 |= 16384;
            }
            gVar.p = this.p;
            if ((i & 32768) == 32768) {
                i2 |= 32768;
            }
            gVar.q = this.q;
            if ((i & 65536) == 65536) {
                i2 |= 65536;
            }
            gVar.r = this.r;
            if ((i & 131072) == 131072) {
                i2 |= 131072;
            }
            gVar.s = this.s;
            if ((i & 262144) == 262144) {
                i2 |= 262144;
            }
            gVar.t = this.t;
            if ((i & 524288) == 524288) {
                i2 |= 524288;
            }
            gVar.u = this.u;
            if ((i & 1048576) == 1048576) {
                i2 |= 1048576;
            }
            gVar.v = this.v;
            if ((this.a & 2097152) == 2097152) {
                this.w = Collections.unmodifiableList(this.w);
                this.a &= -2097153;
            }
            gVar.w = this.w;
            if ((4194304 & i) == 4194304) {
                i2 |= 2097152;
            }
            gVar.x = this.x;
            if ((8388608 & i) == 8388608) {
                i2 |= 4194304;
            }
            gVar.y = this.y;
            if ((i & 16777216) == 16777216) {
                i2 |= 8388608;
            }
            gVar.z = this.z;
            gVar.a = i2;
            return gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            super.clear();
            this.b = "";
            int i = this.a & (-2);
            this.a = i;
            this.c = 0;
            int i2 = i & (-3);
            this.a = i2;
            this.d = 0;
            int i3 = i2 & (-5);
            this.a = i3;
            this.e = 0;
            int i4 = i3 & (-9);
            this.a = i4;
            this.f = "";
            int i5 = i4 & (-17);
            this.a = i5;
            this.g = "";
            int i6 = i5 & (-33);
            this.a = i6;
            this.h = 0;
            int i7 = i6 & (-65);
            this.a = i7;
            this.i = 0;
            int i8 = i7 & (-129);
            this.a = i8;
            this.j = ByteString.EMPTY;
            int i9 = i8 & (-257);
            this.a = i9;
            this.k = 0;
            int i10 = i9 & (-513);
            this.a = i10;
            this.l = 0;
            int i11 = i10 & (-1025);
            this.a = i11;
            this.m = 0L;
            int i12 = i11 & (-2049);
            this.a = i12;
            this.n = 0;
            int i13 = i12 & (-4097);
            this.a = i13;
            this.o = "";
            int i14 = i13 & (-8193);
            this.a = i14;
            this.p = "";
            int i15 = i14 & (-16385);
            this.a = i15;
            this.q = "";
            int i16 = i15 & (-32769);
            this.a = i16;
            this.r = 0;
            int i17 = i16 & (-65537);
            this.a = i17;
            this.s = "";
            int i18 = i17 & (-131073);
            this.a = i18;
            this.t = "";
            int i19 = i18 & (-262145);
            this.a = i19;
            this.u = "";
            int i20 = i19 & (-524289);
            this.a = i20;
            this.v = 0L;
            this.a = i20 & (-1048577);
            this.w = Collections.emptyList();
            int i21 = this.a & (-2097153);
            this.a = i21;
            this.x = 0;
            int i22 = i21 & (-4194305);
            this.a = i22;
            this.y = 0L;
            int i23 = i22 & (-8388609);
            this.a = i23;
            this.z = "";
            this.a = (-16777217) & i23;
            return this;
        }

        public b d(int i) {
            this.a |= 128;
            this.i = i;
            return this;
        }

        public b d(String str) {
            if (str != null) {
                this.a |= 1;
                this.b = str;
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: e */
        public b mo44clone() {
            return f().mergeFrom(buildPartial());
        }

        public b e(int i) {
            this.a |= 1024;
            this.l = i;
            return this;
        }

        public b e(String str) {
            if (str != null) {
                this.a |= 16;
                this.f = str;
                return this;
            }
            throw null;
        }

        public b f(int i) {
            this.a |= 4194304;
            this.x = i;
            return this;
        }

        public b f(String str) {
            if (str != null) {
                this.a |= 524288;
                this.u = str;
                return this;
            }
            throw null;
        }

        public b g(int i) {
            this.a |= 64;
            this.h = i;
            return this;
        }

        public b g(String str) {
            if (str != null) {
                this.a |= 32;
                this.g = str;
                return this;
            }
            throw null;
        }

        public final void g() {
            if ((this.a & 2097152) != 2097152) {
                this.w = new ArrayList(this.w);
                this.a |= 2097152;
            }
        }

        public b h(int i) {
            this.a |= 4;
            this.d = i;
            return this;
        }

        public b h(String str) {
            if (str != null) {
                this.a |= 8192;
                this.o = str;
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: h */
        public g getDefaultInstanceForType() {
            return g.h();
        }

        public b i(int i) {
            this.a |= 2;
            this.c = i;
            return this;
        }

        public b i(String str) {
            if (str != null) {
                this.a |= 262144;
                this.t = str;
                return this;
            }
            throw null;
        }

        public final void i() {
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public b j(int i) {
            this.a |= 4096;
            this.n = i;
            return this;
        }

        public b j(String str) {
            if (str != null) {
                this.a |= 16777216;
                this.z = str;
                return this;
            }
            throw null;
        }
    }

    static {
        g gVar = new g(true);
        C = gVar;
        gVar.Y();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0012 */
    /* JADX DEBUG: Type inference failed for r4v65. Raw type applied. Possible types: java.util.List<com.baidu.android.pushservice.y.e.h>, java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    public g(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.A = (byte) -1;
        this.B = -1;
        Y();
        boolean z = false;
        int i = 0;
        while (true) {
            ?? r3 = 2097152;
            if (z) {
                return;
            }
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.a |= 1;
                            this.b = codedInputStream.readBytes();
                            continue;
                        case 16:
                            this.a |= 2;
                            this.c = codedInputStream.readInt32();
                            continue;
                        case 24:
                            this.a |= 4;
                            this.d = codedInputStream.readInt32();
                            continue;
                        case 32:
                            this.a |= 8;
                            this.e = codedInputStream.readInt32();
                            continue;
                        case 42:
                            this.a |= 16;
                            this.f = codedInputStream.readBytes();
                            continue;
                        case 50:
                            this.a |= 32;
                            this.g = codedInputStream.readBytes();
                            continue;
                        case 56:
                            this.a |= 64;
                            this.h = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.a |= 128;
                            this.i = codedInputStream.readInt32();
                            continue;
                        case 74:
                            this.a |= 256;
                            this.j = codedInputStream.readBytes();
                            continue;
                        case 80:
                            this.a |= 512;
                            this.k = codedInputStream.readInt32();
                            continue;
                        case 88:
                            this.a |= 1024;
                            this.l = codedInputStream.readInt32();
                            continue;
                        case 96:
                            this.a |= 2048;
                            this.m = codedInputStream.readInt64();
                            continue;
                        case 104:
                            this.a |= 4096;
                            this.n = codedInputStream.readInt32();
                            continue;
                        case 114:
                            this.a |= 8192;
                            this.o = codedInputStream.readBytes();
                            continue;
                        case 122:
                            this.a |= 16384;
                            this.p = codedInputStream.readBytes();
                            continue;
                        case 130:
                            this.a |= 32768;
                            this.q = codedInputStream.readBytes();
                            continue;
                        case 136:
                            this.a |= 65536;
                            this.r = codedInputStream.readInt32();
                            continue;
                        case Cea708Decoder.COMMAND_SPL /* 146 */:
                            this.a |= 131072;
                            this.s = codedInputStream.readBytes();
                            continue;
                        case Cea708Decoder.COMMAND_DF2 /* 154 */:
                            this.a |= 262144;
                            this.t = codedInputStream.readBytes();
                            continue;
                        case BDLocation.TypeServerDecryptError /* 162 */:
                            this.a |= 524288;
                            this.u = codedInputStream.readBytes();
                            continue;
                        case 168:
                            this.a |= 1048576;
                            this.v = codedInputStream.readInt64();
                            continue;
                        case 178:
                            if ((i & 2097152) != 2097152) {
                                this.w = new ArrayList();
                                i |= 2097152;
                            }
                            this.w.add(codedInputStream.readMessage(h.g, extensionRegistryLite));
                            continue;
                        case H262Reader.START_GROUP /* 184 */:
                            this.a |= 2097152;
                            this.x = codedInputStream.readInt32();
                            continue;
                        case 192:
                            this.a |= 4194304;
                            this.y = codedInputStream.readInt64();
                            continue;
                        case 202:
                            this.a |= 8388608;
                            this.z = codedInputStream.readBytes();
                            continue;
                        default:
                            r3 = parseUnknownField(codedInputStream, extensionRegistryLite, readTag);
                            if (r3 == 0) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                if ((i & r3) == r3) {
                    this.w = Collections.unmodifiableList(this.w);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public g(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.A = (byte) -1;
        this.B = -1;
    }

    public g(boolean z) {
        this.A = (byte) -1;
        this.B = -1;
    }

    public static b Z() {
        return b.a();
    }

    public static g h() {
        return C;
    }

    public static b l(g gVar) {
        return Z().mergeFrom(gVar);
    }

    public boolean A() {
        return (this.a & 16384) == 16384;
    }

    public boolean B() {
        return (this.a & 1048576) == 1048576;
    }

    public boolean C() {
        return (this.a & 65536) == 65536;
    }

    public boolean D() {
        return (this.a & 32768) == 32768;
    }

    public boolean E() {
        return (this.a & 131072) == 131072;
    }

    public boolean F() {
        return (this.a & 1) == 1;
    }

    public boolean G() {
        return (this.a & 8) == 8;
    }

    public boolean H() {
        return (this.a & 256) == 256;
    }

    public boolean I() {
        return (this.a & 512) == 512;
    }

    public boolean J() {
        return (this.a & 2048) == 2048;
    }

    public boolean K() {
        return (this.a & 4194304) == 4194304;
    }

    public boolean L() {
        return (this.a & 16) == 16;
    }

    public boolean M() {
        return (this.a & 128) == 128;
    }

    public boolean N() {
        return (this.a & 524288) == 524288;
    }

    public boolean O() {
        return (this.a & 32) == 32;
    }

    public boolean P() {
        return (this.a & 1024) == 1024;
    }

    public boolean Q() {
        return (this.a & 2097152) == 2097152;
    }

    public boolean R() {
        return (this.a & 8192) == 8192;
    }

    public boolean S() {
        return (this.a & 64) == 64;
    }

    public boolean T() {
        return (this.a & 4) == 4;
    }

    public boolean U() {
        return (this.a & 262144) == 262144;
    }

    public boolean V() {
        return (this.a & 2) == 2;
    }

    public boolean W() {
        return (this.a & 8388608) == 8388608;
    }

    public boolean X() {
        return (this.a & 4096) == 4096;
    }

    public final void Y() {
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = "";
        this.g = "";
        this.h = 0;
        this.i = 0;
        this.j = ByteString.EMPTY;
        this.k = 0;
        this.l = 0;
        this.m = 0L;
        this.n = 0;
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = 0;
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = 0L;
        this.w = Collections.emptyList();
        this.x = 0;
        this.y = 0L;
        this.z = "";
    }

    public ByteString a() {
        Object obj = this.p;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.p = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: a0 */
    public b newBuilderForType() {
        return Z();
    }

    public long b() {
        return this.v;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: b0 */
    public b toBuilder() {
        return l(this);
    }

    public int c() {
        return this.r;
    }

    public ByteString d() {
        Object obj = this.q;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.q = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public ByteString e() {
        Object obj = this.s;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.s = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public ByteString f() {
        Object obj = this.b;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.b = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int g() {
        return this.e;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<g> getParserForType() {
        return D;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.B;
        if (i != -1) {
            return i;
        }
        int computeBytesSize = (this.a & 1) == 1 ? CodedOutputStream.computeBytesSize(1, f()) + 0 : 0;
        if ((this.a & 2) == 2) {
            computeBytesSize += CodedOutputStream.computeInt32Size(2, this.c);
        }
        if ((this.a & 4) == 4) {
            computeBytesSize += CodedOutputStream.computeInt32Size(3, this.d);
        }
        if ((this.a & 8) == 8) {
            computeBytesSize += CodedOutputStream.computeInt32Size(4, this.e);
        }
        if ((this.a & 16) == 16) {
            computeBytesSize += CodedOutputStream.computeBytesSize(5, n());
        }
        if ((this.a & 32) == 32) {
            computeBytesSize += CodedOutputStream.computeBytesSize(6, q());
        }
        if ((this.a & 64) == 64) {
            computeBytesSize += CodedOutputStream.computeInt32Size(7, this.h);
        }
        if ((this.a & 128) == 128) {
            computeBytesSize += CodedOutputStream.computeInt32Size(8, this.i);
        }
        if ((this.a & 256) == 256) {
            computeBytesSize += CodedOutputStream.computeBytesSize(9, this.j);
        }
        if ((this.a & 512) == 512) {
            computeBytesSize += CodedOutputStream.computeInt32Size(10, this.k);
        }
        if ((this.a & 1024) == 1024) {
            computeBytesSize += CodedOutputStream.computeInt32Size(11, this.l);
        }
        if ((this.a & 2048) == 2048) {
            computeBytesSize += CodedOutputStream.computeInt64Size(12, this.m);
        }
        if ((this.a & 4096) == 4096) {
            computeBytesSize += CodedOutputStream.computeInt32Size(13, this.n);
        }
        if ((this.a & 8192) == 8192) {
            computeBytesSize += CodedOutputStream.computeBytesSize(14, t());
        }
        if ((this.a & 16384) == 16384) {
            computeBytesSize += CodedOutputStream.computeBytesSize(15, a());
        }
        if ((this.a & 32768) == 32768) {
            computeBytesSize += CodedOutputStream.computeBytesSize(16, d());
        }
        if ((this.a & 65536) == 65536) {
            computeBytesSize += CodedOutputStream.computeInt32Size(17, this.r);
        }
        if ((this.a & 131072) == 131072) {
            computeBytesSize += CodedOutputStream.computeBytesSize(18, e());
        }
        if ((this.a & 262144) == 262144) {
            computeBytesSize += CodedOutputStream.computeBytesSize(19, w());
        }
        if ((this.a & 524288) == 524288) {
            computeBytesSize += CodedOutputStream.computeBytesSize(20, p());
        }
        if ((this.a & 1048576) == 1048576) {
            computeBytesSize += CodedOutputStream.computeInt64Size(21, this.v);
        }
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            computeBytesSize += CodedOutputStream.computeMessageSize(22, this.w.get(i2));
        }
        if ((this.a & 2097152) == 2097152) {
            computeBytesSize += CodedOutputStream.computeInt32Size(23, this.x);
        }
        if ((this.a & 4194304) == 4194304) {
            computeBytesSize += CodedOutputStream.computeInt64Size(24, this.y);
        }
        if ((this.a & 8388608) == 8388608) {
            computeBytesSize += CodedOutputStream.computeBytesSize(25, y());
        }
        this.B = computeBytesSize;
        return computeBytesSize;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: i */
    public g getDefaultInstanceForType() {
        return C;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.A;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.A = (byte) 1;
        return true;
    }

    public ByteString j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public long l() {
        return this.m;
    }

    public long m() {
        return this.y;
    }

    public ByteString n() {
        Object obj = this.f;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.f = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int o() {
        return this.i;
    }

    public ByteString p() {
        Object obj = this.u;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.u = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public ByteString q() {
        Object obj = this.g;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.g = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int r() {
        return this.l;
    }

    public int s() {
        return this.x;
    }

    public ByteString t() {
        Object obj = this.o;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.o = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int u() {
        return this.h;
    }

    public int v() {
        return this.d;
    }

    public ByteString w() {
        Object obj = this.t;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.t = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.a & 1) == 1) {
            codedOutputStream.writeBytes(1, f());
        }
        if ((this.a & 2) == 2) {
            codedOutputStream.writeInt32(2, this.c);
        }
        if ((this.a & 4) == 4) {
            codedOutputStream.writeInt32(3, this.d);
        }
        if ((this.a & 8) == 8) {
            codedOutputStream.writeInt32(4, this.e);
        }
        if ((this.a & 16) == 16) {
            codedOutputStream.writeBytes(5, n());
        }
        if ((this.a & 32) == 32) {
            codedOutputStream.writeBytes(6, q());
        }
        if ((this.a & 64) == 64) {
            codedOutputStream.writeInt32(7, this.h);
        }
        if ((this.a & 128) == 128) {
            codedOutputStream.writeInt32(8, this.i);
        }
        if ((this.a & 256) == 256) {
            codedOutputStream.writeBytes(9, this.j);
        }
        if ((this.a & 512) == 512) {
            codedOutputStream.writeInt32(10, this.k);
        }
        if ((this.a & 1024) == 1024) {
            codedOutputStream.writeInt32(11, this.l);
        }
        if ((this.a & 2048) == 2048) {
            codedOutputStream.writeInt64(12, this.m);
        }
        if ((this.a & 4096) == 4096) {
            codedOutputStream.writeInt32(13, this.n);
        }
        if ((this.a & 8192) == 8192) {
            codedOutputStream.writeBytes(14, t());
        }
        if ((this.a & 16384) == 16384) {
            codedOutputStream.writeBytes(15, a());
        }
        if ((this.a & 32768) == 32768) {
            codedOutputStream.writeBytes(16, d());
        }
        if ((this.a & 65536) == 65536) {
            codedOutputStream.writeInt32(17, this.r);
        }
        if ((this.a & 131072) == 131072) {
            codedOutputStream.writeBytes(18, e());
        }
        if ((this.a & 262144) == 262144) {
            codedOutputStream.writeBytes(19, w());
        }
        if ((this.a & 524288) == 524288) {
            codedOutputStream.writeBytes(20, p());
        }
        if ((this.a & 1048576) == 1048576) {
            codedOutputStream.writeInt64(21, this.v);
        }
        for (int i = 0; i < this.w.size(); i++) {
            codedOutputStream.writeMessage(22, this.w.get(i));
        }
        if ((this.a & 2097152) == 2097152) {
            codedOutputStream.writeInt32(23, this.x);
        }
        if ((this.a & 4194304) == 4194304) {
            codedOutputStream.writeInt64(24, this.y);
        }
        if ((this.a & 8388608) == 8388608) {
            codedOutputStream.writeBytes(25, y());
        }
    }

    public int x() {
        return this.c;
    }

    public ByteString y() {
        Object obj = this.z;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.z = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int z() {
        return this.n;
    }
}
