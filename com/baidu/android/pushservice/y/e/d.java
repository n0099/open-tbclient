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
public final class d extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final d e;
    public static Parser<d> f = new a();
    public int a;
    public int b;
    public byte c;
    public int d;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<d> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: a */
        public d parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new d(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<d, b> implements Object {
        public int a;
        public int b;

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
            this.a |= 1;
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(d dVar) {
            if (dVar != d.a() && dVar.d()) {
                a(dVar.c());
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
            d dVar = null;
            try {
                try {
                    d parsePartialFrom = d.f.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    d dVar2 = (d) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        dVar = dVar2;
                        if (dVar != null) {
                            mergeFrom(dVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (dVar != null) {
                }
                throw th;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public d build() {
            d buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public d buildPartial() {
            d dVar = new d(this);
            int i = (this.a & 1) != 1 ? 0 : 1;
            dVar.b = this.b;
            dVar.a = i;
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            super.clear();
            this.b = 0;
            this.a &= -2;
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
        public d getDefaultInstanceForType() {
            return d.a();
        }

        public final void h() {
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }
    }

    static {
        d dVar = new d(true);
        e = dVar;
        dVar.e();
    }

    public d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.c = (byte) -1;
        this.d = -1;
        e();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.a |= 1;
                            this.b = codedInputStream.readUInt32();
                        } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public d(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.c = (byte) -1;
        this.d = -1;
    }

    public d(boolean z) {
        this.c = (byte) -1;
        this.d = -1;
    }

    public static b a(d dVar) {
        return f().mergeFrom(dVar);
    }

    public static d a() {
        return e;
    }

    public static b f() {
        return b.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b */
    public d getDefaultInstanceForType() {
        return e;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return (this.a & 1) == 1;
    }

    public final void e() {
        this.b = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: g */
    public b newBuilderForType() {
        return f();
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<d> getParserForType() {
        return f;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int computeUInt32Size = (this.a & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.b) : 0;
        this.d = computeUInt32Size;
        return computeUInt32Size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    /* renamed from: h */
    public b toBuilder() {
        return a(this);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.c;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.c = (byte) 1;
        return true;
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
    }
}
