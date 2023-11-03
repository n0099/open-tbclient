package com.baidu.android.pushservice.y.e;

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
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final f n;
    public static Parser<f> o = new a();
    public int a;
    public int b;
    public int c;
    public long d;
    public Object e;
    public int f;
    public int g;
    public ByteString h;
    public e i;
    public com.baidu.android.pushservice.y.e.b j;
    public d k;
    public byte l;
    public int m;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<f> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: a */
        public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new f(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<f, b> implements Object {
        public int a;
        public int b;
        public int c;
        public long d;
        public int f;
        public int g;
        public Object e = "";
        public ByteString h = ByteString.EMPTY;
        public e i = e.c();
        public com.baidu.android.pushservice.y.e.b j = com.baidu.android.pushservice.y.e.b.a();
        public d k = d.a();

        public b() {
            h();
        }

        public static /* synthetic */ b a() {
            return f();
        }

        public static b f() {
            return new b();
        }

        public b a(int i) {
            this.a |= 16;
            this.f = i;
            return this;
        }

        public b a(long j) {
            this.a |= 4;
            this.d = j;
            return this;
        }

        public b a(com.baidu.android.pushservice.y.e.b bVar) {
            if ((this.a & 256) == 256 && this.j != com.baidu.android.pushservice.y.e.b.a()) {
                bVar = com.baidu.android.pushservice.y.e.b.a(this.j).mergeFrom(bVar).buildPartial();
            }
            this.j = bVar;
            this.a |= 256;
            return this;
        }

        public b a(d dVar) {
            if ((this.a & 512) == 512 && this.k != d.a()) {
                dVar = d.a(this.k).mergeFrom(dVar).buildPartial();
            }
            this.k = dVar;
            this.a |= 512;
            return this;
        }

        public b a(e eVar) {
            if ((this.a & 128) == 128 && this.i != e.c()) {
                eVar = e.c(this.i).mergeFrom(eVar).buildPartial();
            }
            this.i = eVar;
            this.a |= 128;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(f fVar) {
            if (fVar == f.b()) {
                return this;
            }
            if (fVar.r()) {
                b(fVar.h());
            }
            if (fVar.v()) {
                d(fVar.l());
            }
            if (fVar.o()) {
                a(fVar.e());
            }
            if (fVar.s()) {
                this.a |= 8;
                this.e = fVar.e;
            }
            if (fVar.p()) {
                a(fVar.f());
            }
            if (fVar.u()) {
                c(fVar.k());
            }
            if (fVar.q()) {
                a(fVar.g());
            }
            if (fVar.t()) {
                a(fVar.j());
            }
            if (fVar.m()) {
                a(fVar.a());
            }
            if (fVar.n()) {
                a(fVar.d());
            }
            return this;
        }

        public b a(ByteString byteString) {
            if (byteString != null) {
                this.a |= 64;
                this.h = byteString;
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
            f fVar = null;
            try {
                try {
                    f parsePartialFrom = f.o.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    f fVar2 = (f) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        fVar = fVar2;
                        if (fVar != null) {
                            mergeFrom(fVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fVar != null) {
                }
                throw th;
            }
        }

        public b a(String str) {
            if (str != null) {
                this.a |= 8;
                this.e = str;
                return this;
            }
            throw null;
        }

        public b b(int i) {
            this.a |= 1;
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public f build() {
            f buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public b c(int i) {
            this.a |= 32;
            this.g = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public f buildPartial() {
            f fVar = new f(this);
            int i = this.a;
            int i2 = (i & 1) != 1 ? 0 : 1;
            fVar.b = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            fVar.c = this.c;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            fVar.d = this.d;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            fVar.e = this.e;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            fVar.f = this.f;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            fVar.g = this.g;
            if ((i & 64) == 64) {
                i2 |= 64;
            }
            fVar.h = this.h;
            if ((i & 128) == 128) {
                i2 |= 128;
            }
            fVar.i = this.i;
            if ((i & 256) == 256) {
                i2 |= 256;
            }
            fVar.j = this.j;
            if ((i & 512) == 512) {
                i2 |= 512;
            }
            fVar.k = this.k;
            fVar.a = i2;
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            super.clear();
            this.b = 0;
            int i = this.a & (-2);
            this.a = i;
            this.c = 0;
            int i2 = i & (-3);
            this.a = i2;
            this.d = 0L;
            int i3 = i2 & (-5);
            this.a = i3;
            this.e = "";
            int i4 = i3 & (-9);
            this.a = i4;
            this.f = 0;
            int i5 = i4 & (-17);
            this.a = i5;
            this.g = 0;
            int i6 = i5 & (-33);
            this.a = i6;
            this.h = ByteString.EMPTY;
            this.a = i6 & (-65);
            this.i = e.c();
            this.a &= -129;
            this.j = com.baidu.android.pushservice.y.e.b.a();
            this.a &= -257;
            this.k = d.a();
            this.a &= -513;
            return this;
        }

        public b d(int i) {
            this.a |= 2;
            this.c = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: e */
        public b mo44clone() {
            return f().mergeFrom(buildPartial());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: g */
        public f getDefaultInstanceForType() {
            return f.b();
        }

        public final void h() {
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }
    }

    static {
        f fVar = new f(true);
        n = fVar;
        fVar.w();
    }

    public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int i;
        GeneratedMessageLite.Builder builder;
        this.l = (byte) -1;
        this.m = -1;
        w();
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                this.a |= 1;
                                this.b = codedInputStream.readUInt32();
                                break;
                            case 16:
                                this.a |= 2;
                                this.c = codedInputStream.readUInt32();
                                break;
                            case 24:
                                this.a |= 4;
                                this.d = codedInputStream.readInt64();
                                break;
                            case 34:
                                this.a |= 8;
                                this.e = codedInputStream.readBytes();
                                break;
                            case 40:
                                this.a |= 16;
                                this.f = codedInputStream.readUInt32();
                                break;
                            case 48:
                                this.a |= 32;
                                this.g = codedInputStream.readUInt32();
                                break;
                            case 58:
                                this.a |= 64;
                                this.h = codedInputStream.readBytes();
                                break;
                            case 66:
                                i = 128;
                                builder = (this.a & 128) == 128 ? this.i.toBuilder() : null;
                                e eVar = (e) codedInputStream.readMessage(e.l, extensionRegistryLite);
                                this.i = eVar;
                                if (builder != null) {
                                    builder.mergeFrom(eVar);
                                    this.i = builder.buildPartial();
                                }
                                this.a |= i;
                                break;
                            case 74:
                                i = 256;
                                builder = (this.a & 256) == 256 ? this.j.toBuilder() : null;
                                com.baidu.android.pushservice.y.e.b bVar = (com.baidu.android.pushservice.y.e.b) codedInputStream.readMessage(com.baidu.android.pushservice.y.e.b.g, extensionRegistryLite);
                                this.j = bVar;
                                if (builder != null) {
                                    builder.mergeFrom(bVar);
                                    this.j = builder.buildPartial();
                                }
                                this.a |= i;
                                break;
                            case 82:
                                i = 512;
                                builder = (this.a & 512) == 512 ? this.k.toBuilder() : null;
                                d dVar = (d) codedInputStream.readMessage(d.f, extensionRegistryLite);
                                this.k = dVar;
                                if (builder != null) {
                                    builder.mergeFrom(dVar);
                                    this.k = builder.buildPartial();
                                }
                                this.a |= i;
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public f(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.l = (byte) -1;
        this.m = -1;
    }

    public f(boolean z) {
        this.l = (byte) -1;
        this.m = -1;
    }

    public static f a(byte[] bArr) throws InvalidProtocolBufferException {
        return o.parseFrom(bArr);
    }

    public static b b(f fVar) {
        return x().mergeFrom(fVar);
    }

    public static f b() {
        return n;
    }

    public static b x() {
        return b.a();
    }

    public com.baidu.android.pushservice.y.e.b a() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public f getDefaultInstanceForType() {
        return n;
    }

    public d d() {
        return this.k;
    }

    public long e() {
        return this.d;
    }

    public int f() {
        return this.f;
    }

    public ByteString g() {
        return this.h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<f> getParserForType() {
        return o;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.m;
        if (i != -1) {
            return i;
        }
        int computeUInt32Size = (this.a & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.b) : 0;
        if ((this.a & 2) == 2) {
            computeUInt32Size += CodedOutputStream.computeUInt32Size(2, this.c);
        }
        if ((this.a & 4) == 4) {
            computeUInt32Size += CodedOutputStream.computeInt64Size(3, this.d);
        }
        if ((this.a & 8) == 8) {
            computeUInt32Size += CodedOutputStream.computeBytesSize(4, i());
        }
        if ((this.a & 16) == 16) {
            computeUInt32Size += CodedOutputStream.computeUInt32Size(5, this.f);
        }
        if ((this.a & 32) == 32) {
            computeUInt32Size += CodedOutputStream.computeUInt32Size(6, this.g);
        }
        if ((this.a & 64) == 64) {
            computeUInt32Size += CodedOutputStream.computeBytesSize(7, this.h);
        }
        if ((this.a & 128) == 128) {
            computeUInt32Size += CodedOutputStream.computeMessageSize(8, this.i);
        }
        if ((this.a & 256) == 256) {
            computeUInt32Size += CodedOutputStream.computeMessageSize(9, this.j);
        }
        if ((this.a & 512) == 512) {
            computeUInt32Size += CodedOutputStream.computeMessageSize(10, this.k);
        }
        this.m = computeUInt32Size;
        return computeUInt32Size;
    }

    public int h() {
        return this.b;
    }

    public ByteString i() {
        Object obj = this.e;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.e = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.l;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.l = (byte) 1;
        return true;
    }

    public e j() {
        return this.i;
    }

    public int k() {
        return this.g;
    }

    public int l() {
        return this.c;
    }

    public boolean m() {
        return (this.a & 256) == 256;
    }

    public boolean n() {
        return (this.a & 512) == 512;
    }

    public boolean o() {
        return (this.a & 4) == 4;
    }

    public boolean p() {
        return (this.a & 16) == 16;
    }

    public boolean q() {
        return (this.a & 64) == 64;
    }

    public boolean r() {
        return (this.a & 1) == 1;
    }

    public boolean s() {
        return (this.a & 8) == 8;
    }

    public boolean t() {
        return (this.a & 128) == 128;
    }

    public boolean u() {
        return (this.a & 32) == 32;
    }

    public boolean v() {
        return (this.a & 2) == 2;
    }

    public final void w() {
        this.b = 0;
        this.c = 0;
        this.d = 0L;
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.h = ByteString.EMPTY;
        this.i = e.c();
        this.j = com.baidu.android.pushservice.y.e.b.a();
        this.k = d.a();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.a & 1) == 1) {
            codedOutputStream.writeUInt32(1, this.b);
        }
        if ((this.a & 2) == 2) {
            codedOutputStream.writeUInt32(2, this.c);
        }
        if ((this.a & 4) == 4) {
            codedOutputStream.writeInt64(3, this.d);
        }
        if ((this.a & 8) == 8) {
            codedOutputStream.writeBytes(4, i());
        }
        if ((this.a & 16) == 16) {
            codedOutputStream.writeUInt32(5, this.f);
        }
        if ((this.a & 32) == 32) {
            codedOutputStream.writeUInt32(6, this.g);
        }
        if ((this.a & 64) == 64) {
            codedOutputStream.writeBytes(7, this.h);
        }
        if ((this.a & 128) == 128) {
            codedOutputStream.writeMessage(8, this.i);
        }
        if ((this.a & 256) == 256) {
            codedOutputStream.writeMessage(9, this.j);
        }
        if ((this.a & 512) == 512) {
            codedOutputStream.writeMessage(10, this.k);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: y */
    public b newBuilderForType() {
        return x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: z */
    public b toBuilder() {
        return b(this);
    }
}
