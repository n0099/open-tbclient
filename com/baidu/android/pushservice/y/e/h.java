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
public final class h extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final h f;
    public static Parser<h> g = new a();
    public int a;
    public Object b;
    public Object c;
    public byte d;
    public int e;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<h> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: a */
        public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new h(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<h, b> implements Object {
        public int a;
        public Object b = "";
        public Object c = "";

        public b() {
            h();
        }

        public static /* synthetic */ b a() {
            return f();
        }

        public static b f() {
            return new b();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(h hVar) {
            if (hVar == h.a()) {
                return this;
            }
            if (hVar.e()) {
                this.a |= 1;
                this.b = hVar.b;
            }
            if (hVar.f()) {
                this.a |= 2;
                this.c = hVar.c;
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
            h hVar = null;
            try {
                try {
                    h parsePartialFrom = h.g.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    h hVar2 = (h) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        hVar = hVar2;
                        if (hVar != null) {
                            mergeFrom(hVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (hVar != null) {
                }
                throw th;
            }
        }

        public b a(String str) {
            if (str != null) {
                this.a |= 1;
                this.b = str;
                return this;
            }
            throw null;
        }

        public b b(String str) {
            if (str != null) {
                this.a |= 2;
                this.c = str;
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public h build() {
            h buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public h buildPartial() {
            h hVar = new h(this);
            int i = this.a;
            int i2 = (i & 1) != 1 ? 0 : 1;
            hVar.b = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            hVar.c = this.c;
            hVar.a = i2;
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            super.clear();
            this.b = "";
            int i = this.a & (-2);
            this.a = i;
            this.c = "";
            this.a = i & (-3);
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
        public h getDefaultInstanceForType() {
            return h.a();
        }

        public final void h() {
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }
    }

    static {
        h hVar = new h(true);
        f = hVar;
        hVar.g();
    }

    public h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.d = (byte) -1;
        this.e = -1;
        g();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.a |= 1;
                            this.b = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.a |= 2;
                            this.c = codedInputStream.readBytes();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public h(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.d = (byte) -1;
        this.e = -1;
    }

    public h(boolean z) {
        this.d = (byte) -1;
        this.e = -1;
    }

    public static h a() {
        return f;
    }

    public static b c(h hVar) {
        return h().mergeFrom(hVar);
    }

    public static b h() {
        return b.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b */
    public h getDefaultInstanceForType() {
        return f;
    }

    public ByteString c() {
        Object obj = this.b;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.b = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public ByteString d() {
        Object obj = this.c;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.c = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public boolean e() {
        return (this.a & 1) == 1;
    }

    public boolean f() {
        return (this.a & 2) == 2;
    }

    public final void g() {
        this.b = "";
        this.c = "";
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<h> getParserForType() {
        return g;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int computeBytesSize = (this.a & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, c()) : 0;
        if ((this.a & 2) == 2) {
            computeBytesSize += CodedOutputStream.computeBytesSize(2, d());
        }
        this.e = computeBytesSize;
        return computeBytesSize;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: i */
    public b newBuilderForType() {
        return h();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.d;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.d = (byte) 1;
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: j */
    public b toBuilder() {
        return c(this);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.a & 1) == 1) {
            codedOutputStream.writeBytes(1, c());
        }
        if ((this.a & 2) == 2) {
            codedOutputStream.writeBytes(2, d());
        }
    }
}
