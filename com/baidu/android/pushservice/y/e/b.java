package com.baidu.android.pushservice.y.e;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
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
public final class b extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final b f;
    public static Parser<b> g = new a();
    public int a;
    public int b;
    public int c;
    public byte d;
    public int e;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<b> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: a */
        public b parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new b(codedInputStream, extensionRegistryLite);
        }
    }

    /* renamed from: com.baidu.android.pushservice.y.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0043b extends GeneratedMessageLite.Builder<b, C0043b> implements Object {
        public int a;
        public int b;
        public int c;

        public C0043b() {
            h();
        }

        public static /* synthetic */ C0043b a() {
            return f();
        }

        public static C0043b f() {
            return new C0043b();
        }

        public C0043b a(int i) {
            this.a |= 1;
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public C0043b mergeFrom(b bVar) {
            if (bVar == b.a()) {
                return this;
            }
            if (bVar.e()) {
                a(bVar.c());
            }
            if (bVar.f()) {
                b(bVar.d());
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
        public C0043b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            b bVar = null;
            try {
                try {
                    b parsePartialFrom = b.g.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    b bVar2 = (b) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bVar = bVar2;
                        if (bVar != null) {
                            mergeFrom(bVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bVar != null) {
                }
                throw th;
            }
        }

        public C0043b b(int i) {
            this.a |= 2;
            this.c = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public b build() {
            b buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public b buildPartial() {
            b bVar = new b(this);
            int i = this.a;
            int i2 = (i & 1) != 1 ? 0 : 1;
            bVar.b = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bVar.c = this.c;
            bVar.a = i2;
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public C0043b clear() {
            super.clear();
            this.b = 0;
            int i = this.a & (-2);
            this.a = i;
            this.c = 0;
            this.a = i & (-3);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: e */
        public C0043b mo44clone() {
            return f().mergeFrom(buildPartial());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: g */
        public b getDefaultInstanceForType() {
            return b.a();
        }

        public final void h() {
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }
    }

    static {
        b bVar = new b(true);
        f = bVar;
        bVar.g();
    }

    public b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.d = (byte) -1;
        this.e = -1;
        g();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.a |= 1;
                            this.b = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.a |= 2;
                            this.c = codedInputStream.readUInt32();
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

    public b(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.d = (byte) -1;
        this.e = -1;
    }

    public b(boolean z) {
        this.d = (byte) -1;
        this.e = -1;
    }

    public static C0043b a(b bVar) {
        return h().mergeFrom(bVar);
    }

    public static b a() {
        return f;
    }

    public static C0043b h() {
        return C0043b.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b */
    public b getDefaultInstanceForType() {
        return f;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public boolean e() {
        return (this.a & 1) == 1;
    }

    public boolean f() {
        return (this.a & 2) == 2;
    }

    public final void g() {
        this.b = 0;
        this.c = 0;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<b> getParserForType() {
        return g;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int computeInt32Size = (this.a & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.b) : 0;
        if ((this.a & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeUInt32Size(2, this.c);
        }
        this.e = computeInt32Size;
        return computeInt32Size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: i */
    public C0043b newBuilderForType() {
        return h();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.d;
        if (b != -1) {
            return b == 1;
        }
        this.d = (byte) 1;
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: j */
    public C0043b toBuilder() {
        return a(this);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.a & 1) == 1) {
            codedOutputStream.writeInt32(1, this.b);
        }
        if ((this.a & 2) == 2) {
            codedOutputStream.writeUInt32(2, this.c);
        }
    }
}
