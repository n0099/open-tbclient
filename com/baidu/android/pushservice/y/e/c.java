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
public final class c extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final c i;
    public static Parser<c> j = new a();
    public int a;
    public Object b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte g;
    public int h;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: a */
        public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new c(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<c, b> implements Object {
        public int a;
        public Object b = "";
        public int c;
        public int d;
        public int e;
        public int f;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(c cVar) {
            if (cVar == c.c()) {
                return this;
            }
            if (cVar.i()) {
                this.a |= 1;
                this.b = cVar.b;
            }
            if (cVar.m()) {
                d(cVar.h());
            }
            if (cVar.k()) {
                b(cVar.f());
            }
            if (cVar.l()) {
                c(cVar.g());
            }
            if (cVar.j()) {
                a(cVar.e());
            }
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            c cVar = null;
            try {
                try {
                    c parsePartialFrom = c.j.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    c cVar2 = (c) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        cVar = cVar2;
                        if (cVar != null) {
                            mergeFrom(cVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (cVar != null) {
                }
                throw th;
            }
        }

        public b b(int i) {
            this.a |= 4;
            this.d = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public c build() {
            c buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public b c(int i) {
            this.a |= 8;
            this.e = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public c buildPartial() {
            c cVar = new c(this);
            int i = this.a;
            int i2 = (i & 1) != 1 ? 0 : 1;
            cVar.b = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            cVar.c = this.c;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            cVar.d = this.d;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            cVar.e = this.e;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            cVar.f = this.f;
            cVar.a = i2;
            return cVar;
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
            this.f = 0;
            this.a = i4 & (-17);
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
        public c getDefaultInstanceForType() {
            return c.c();
        }

        public final void h() {
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }
    }

    static {
        c cVar = new c(true);
        i = cVar;
        cVar.n();
    }

    public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.g = (byte) -1;
        this.h = -1;
        n();
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.a |= 1;
                                this.b = codedInputStream.readBytes();
                            } else if (readTag == 16) {
                                this.a |= 2;
                                this.c = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.a |= 4;
                                this.d = codedInputStream.readInt32();
                            } else if (readTag == 32) {
                                this.a |= 8;
                                this.e = codedInputStream.readUInt32();
                            } else if (readTag == 40) {
                                this.a |= 16;
                                this.f = codedInputStream.readInt32();
                            } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
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

    public c(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.g = (byte) -1;
        this.h = -1;
    }

    public c(boolean z) {
        this.g = (byte) -1;
        this.h = -1;
    }

    public static b b(c cVar) {
        return o().mergeFrom(cVar);
    }

    public static c c() {
        return i;
    }

    public static b o() {
        return b.a();
    }

    public String a() {
        Object obj = this.b;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.b = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString b() {
        Object obj = this.b;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.b = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: d */
    public c getDefaultInstanceForType() {
        return i;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.d;
    }

    public int g() {
        return this.e;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<c> getParserForType() {
        return j;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.h;
        if (i2 != -1) {
            return i2;
        }
        int computeBytesSize = (this.a & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, b()) : 0;
        if ((this.a & 2) == 2) {
            computeBytesSize += CodedOutputStream.computeInt32Size(2, this.c);
        }
        if ((this.a & 4) == 4) {
            computeBytesSize += CodedOutputStream.computeInt32Size(3, this.d);
        }
        if ((this.a & 8) == 8) {
            computeBytesSize += CodedOutputStream.computeUInt32Size(4, this.e);
        }
        if ((this.a & 16) == 16) {
            computeBytesSize += CodedOutputStream.computeInt32Size(5, this.f);
        }
        this.h = computeBytesSize;
        return computeBytesSize;
    }

    public int h() {
        return this.c;
    }

    public boolean i() {
        return (this.a & 1) == 1;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.g = (byte) 1;
        return true;
    }

    public boolean j() {
        return (this.a & 16) == 16;
    }

    public boolean k() {
        return (this.a & 4) == 4;
    }

    public boolean l() {
        return (this.a & 8) == 8;
    }

    public boolean m() {
        return (this.a & 2) == 2;
    }

    public final void n() {
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: p */
    public b newBuilderForType() {
        return o();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: q */
    public b toBuilder() {
        return b(this);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.a & 1) == 1) {
            codedOutputStream.writeBytes(1, b());
        }
        if ((this.a & 2) == 2) {
            codedOutputStream.writeInt32(2, this.c);
        }
        if ((this.a & 4) == 4) {
            codedOutputStream.writeInt32(3, this.d);
        }
        if ((this.a & 8) == 8) {
            codedOutputStream.writeUInt32(4, this.e);
        }
        if ((this.a & 16) == 16) {
            codedOutputStream.writeInt32(5, this.f);
        }
    }
}
