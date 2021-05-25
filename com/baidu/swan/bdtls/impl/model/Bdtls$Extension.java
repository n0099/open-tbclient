package com.baidu.swan.bdtls.impl.model;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes3.dex */
public final class Bdtls$Extension extends GeneratedMessageLite implements d.a.l0.c.a.i.b {
    public static final int DATA_FIELD_NUMBER = 2;
    public static Parser<Bdtls$Extension> PARSER = new a();
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final Bdtls$Extension defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public ByteString data_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int type_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bdtls$Extension> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$Extension parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$Extension(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$Extension, b> implements d.a.l0.c.a.i.b {

        /* renamed from: e  reason: collision with root package name */
        public int f11455e;

        /* renamed from: f  reason: collision with root package name */
        public int f11456f;

        /* renamed from: g  reason: collision with root package name */
        public ByteString f11457g = ByteString.EMPTY;

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            o();
            return this;
        }

        public boolean hasType() {
            return (this.f11455e & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return hasType() && s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$Extension build() {
            Bdtls$Extension buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public Bdtls$Extension buildPartial() {
            Bdtls$Extension bdtls$Extension = new Bdtls$Extension(this);
            int i2 = this.f11455e;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            bdtls$Extension.type_ = this.f11456f;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            bdtls$Extension.data_ = this.f11457g;
            bdtls$Extension.bitField0_ = i3;
            return bdtls$Extension;
        }

        public b o() {
            super.clear();
            this.f11456f = 0;
            int i2 = this.f11455e & (-2);
            this.f11455e = i2;
            this.f11457g = ByteString.EMPTY;
            this.f11455e = i2 & (-3);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.t(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public Bdtls$Extension getDefaultInstanceForType() {
            return Bdtls$Extension.getDefaultInstance();
        }

        public boolean s() {
            return (this.f11455e & 2) == 2;
        }

        public b t(Bdtls$Extension bdtls$Extension) {
            if (bdtls$Extension == Bdtls$Extension.getDefaultInstance()) {
                return this;
            }
            if (bdtls$Extension.hasType()) {
                w(bdtls$Extension.getType());
            }
            if (bdtls$Extension.hasData()) {
                v(bdtls$Extension.getData());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bdtls$Extension bdtls$Extension = null;
            try {
                try {
                    Bdtls$Extension parsePartialFrom = Bdtls$Extension.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        t(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    Bdtls$Extension bdtls$Extension2 = (Bdtls$Extension) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$Extension = bdtls$Extension2;
                        if (bdtls$Extension != null) {
                            t(bdtls$Extension);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bdtls$Extension != null) {
                }
                throw th;
            }
        }

        public b v(ByteString byteString) {
            if (byteString != null) {
                this.f11455e |= 2;
                this.f11457g = byteString;
                return this;
            }
            throw null;
        }

        public b w(int i2) {
            this.f11455e |= 1;
            this.f11456f = i2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$Extension bdtls$Extension) {
            t(bdtls$Extension);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        Bdtls$Extension bdtls$Extension = new Bdtls$Extension(true);
        defaultInstance = bdtls$Extension;
        bdtls$Extension.initFields();
    }

    public static Bdtls$Extension getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.type_ = 0;
        this.data_ = ByteString.EMPTY;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static Bdtls$Extension parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bdtls$Extension parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public ByteString getData() {
        return this.data_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$Extension> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int computeUInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.type_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeUInt32Size += CodedOutputStream.computeBytesSize(2, this.data_);
        }
        this.memoizedSerializedSize = computeUInt32Size;
        return computeUInt32Size;
    }

    public int getType() {
        return this.type_;
    }

    public boolean hasData() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
        } else if (!hasType()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!hasData()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeUInt32(1, this.type_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, this.data_);
        }
    }

    public static b newBuilder(Bdtls$Extension bdtls$Extension) {
        b newBuilder = newBuilder();
        newBuilder.t(bdtls$Extension);
        return newBuilder;
    }

    public static Bdtls$Extension parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Extension parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$Extension getDefaultInstanceForType() {
        return defaultInstance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public Bdtls$Extension(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$Extension parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$Extension parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Bdtls$Extension parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public Bdtls$Extension(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$Extension parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Extension parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$Extension parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public Bdtls$Extension(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.type_ = codedInputStream.readUInt32();
                        } else if (readTag != 18) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.data_ = codedInputStream.readBytes();
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
}
