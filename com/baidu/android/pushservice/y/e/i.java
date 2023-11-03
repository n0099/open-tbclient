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
public final class i extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final i i;
    public static Parser<i> j = new a();
    public int a;
    public Object b;
    public long c;
    public int d;
    public ByteString e;
    public ByteString f;
    public byte g;
    public int h;

    /* loaded from: classes.dex */
    public static class a extends AbstractParser<i> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: a */
        public i parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new i(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageLite.Builder<i, b> implements Object {
        public int a;
        public Object b = "";
        public long c;
        public int d;
        public ByteString e;
        public ByteString f;

        public b() {
            ByteString byteString = ByteString.EMPTY;
            this.e = byteString;
            this.f = byteString;
            h();
        }

        public static /* synthetic */ b a() {
            return f();
        }

        public static b f() {
            return new b();
        }

        public b a(int i) {
            this.a |= 4;
            this.d = i;
            return this;
        }

        public b a(long j) {
            this.a |= 2;
            this.c = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        /* renamed from: a */
        public b mergeFrom(i iVar) {
            if (iVar == i.c()) {
                return this;
            }
            if (iVar.i()) {
                this.a |= 1;
                this.b = iVar.b;
            }
            if (iVar.m()) {
                a(iVar.h());
            }
            if (iVar.l()) {
                a(iVar.g());
            }
            if (iVar.j()) {
                a(iVar.e());
            }
            if (iVar.k()) {
                b(iVar.f());
            }
            return this;
        }

        public b a(ByteString byteString) {
            if (byteString != null) {
                this.a |= 8;
                this.e = byteString;
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
            i iVar = null;
            try {
                try {
                    i parsePartialFrom = i.j.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    i iVar2 = (i) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        iVar = iVar2;
                        if (iVar != null) {
                            mergeFrom(iVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (iVar != null) {
                }
                throw th;
            }
        }

        public b b(ByteString byteString) {
            if (byteString != null) {
                this.a |= 16;
                this.f = byteString;
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: b */
        public i build() {
            i buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: c */
        public i buildPartial() {
            i iVar = new i(this);
            int i = this.a;
            int i2 = (i & 1) != 1 ? 0 : 1;
            iVar.b = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            iVar.c = this.c;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            iVar.d = this.d;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            iVar.e = this.e;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            iVar.f = this.f;
            iVar.a = i2;
            return iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: d */
        public b clear() {
            super.clear();
            this.b = "";
            int i = this.a & (-2);
            this.a = i;
            this.c = 0L;
            int i2 = i & (-3);
            this.a = i2;
            this.d = 0;
            int i3 = i2 & (-5);
            this.a = i3;
            ByteString byteString = ByteString.EMPTY;
            this.e = byteString;
            int i4 = i3 & (-9);
            this.a = i4;
            this.f = byteString;
            this.a = i4 & (-17);
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
        public i getDefaultInstanceForType() {
            return i.c();
        }

        public final void h() {
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }
    }

    static {
        i iVar = new i(true);
        i = iVar;
        iVar.n();
    }

    public i(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.c = codedInputStream.readInt64();
                            } else if (readTag == 24) {
                                this.a |= 4;
                                this.d = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                this.a |= 8;
                                this.e = codedInputStream.readBytes();
                            } else if (readTag == 42) {
                                this.a |= 16;
                                this.f = codedInputStream.readBytes();
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

    public i(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.g = (byte) -1;
        this.h = -1;
    }

    public i(boolean z) {
        this.g = (byte) -1;
        this.h = -1;
    }

    public static i a(ByteString byteString) throws InvalidProtocolBufferException {
        return j.parseFrom(byteString);
    }

    public static b b(i iVar) {
        return o().mergeFrom(iVar);
    }

    public static i c() {
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
    public i getDefaultInstanceForType() {
        return i;
    }

    public ByteString e() {
        return this.e;
    }

    public ByteString f() {
        return this.f;
    }

    public int g() {
        return this.d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<i> getParserForType() {
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
            computeBytesSize += CodedOutputStream.computeInt64Size(2, this.c);
        }
        if ((this.a & 4) == 4) {
            computeBytesSize += CodedOutputStream.computeInt32Size(3, this.d);
        }
        if ((this.a & 8) == 8) {
            computeBytesSize += CodedOutputStream.computeBytesSize(4, this.e);
        }
        if ((this.a & 16) == 16) {
            computeBytesSize += CodedOutputStream.computeBytesSize(5, this.f);
        }
        this.h = computeBytesSize;
        return computeBytesSize;
    }

    public long h() {
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
        return (this.a & 8) == 8;
    }

    public boolean k() {
        return (this.a & 16) == 16;
    }

    public boolean l() {
        return (this.a & 4) == 4;
    }

    public boolean m() {
        return (this.a & 2) == 2;
    }

    public final void n() {
        this.b = "";
        this.c = 0L;
        this.d = 0;
        ByteString byteString = ByteString.EMPTY;
        this.e = byteString;
        this.f = byteString;
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
            codedOutputStream.writeInt64(2, this.c);
        }
        if ((this.a & 4) == 4) {
            codedOutputStream.writeInt32(3, this.d);
        }
        if ((this.a & 8) == 8) {
            codedOutputStream.writeBytes(4, this.e);
        }
        if ((this.a & 16) == 16) {
            codedOutputStream.writeBytes(5, this.f);
        }
    }
}
