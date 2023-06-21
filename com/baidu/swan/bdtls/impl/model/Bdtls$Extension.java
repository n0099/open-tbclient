package com.baidu.swan.bdtls.impl.model;

import com.baidu.tieba.dv3;
import com.baidu.tieba.ev3;
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
/* loaded from: classes4.dex */
public final class Bdtls$Extension extends GeneratedMessageLite implements ev3 {
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

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$Extension, b> implements ev3 {
        public int a;
        public int b;
        public ByteString c = ByteString.EMPTY;

        public final void maybeForceBuilderInitialization() {
        }

        public b() {
            maybeForceBuilderInitialization();
        }

        public static /* synthetic */ b k() {
            return p();
        }

        public static b p() {
            return new b();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            n();
            return this;
        }

        public int getType() {
            return this.b;
        }

        public boolean hasType() {
            if ((this.a & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!hasType() || !r()) {
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public Bdtls$Extension build() {
            Bdtls$Extension buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$Extension buildPartial() {
            Bdtls$Extension bdtls$Extension = new Bdtls$Extension(this, (dv3) null);
            int i = this.a;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            bdtls$Extension.type_ = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bdtls$Extension.data_ = this.c;
            bdtls$Extension.bitField0_ = i2;
            return bdtls$Extension;
        }

        public b n() {
            super.clear();
            this.b = 0;
            int i = this.a & (-2);
            this.a = i;
            this.c = ByteString.EMPTY;
            this.a = i & (-3);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: o */
        public b mo43clone() {
            b p = p();
            p.s(buildPartial());
            return p;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: q */
        public Bdtls$Extension getDefaultInstanceForType() {
            return Bdtls$Extension.getDefaultInstance();
        }

        public boolean r() {
            if ((this.a & 2) == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            n();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bdtls$Extension bdtls$Extension = null;
            try {
                try {
                    Bdtls$Extension parsePartialFrom = Bdtls$Extension.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        s(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Bdtls$Extension bdtls$Extension2 = (Bdtls$Extension) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$Extension = bdtls$Extension2;
                        if (bdtls$Extension != null) {
                            s(bdtls$Extension);
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$Extension bdtls$Extension) {
            s(bdtls$Extension);
            return this;
        }

        public b s(Bdtls$Extension bdtls$Extension) {
            if (bdtls$Extension == Bdtls$Extension.getDefaultInstance()) {
                return this;
            }
            if (bdtls$Extension.hasType()) {
                v(bdtls$Extension.getType());
            }
            if (bdtls$Extension.hasData()) {
                u(bdtls$Extension.getData());
            }
            return this;
        }

        public b u(ByteString byteString) {
            if (byteString != null) {
                this.a |= 2;
                this.c = byteString;
                return this;
            }
            throw null;
        }

        public b v(int i) {
            this.a |= 1;
            this.b = i;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
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
        return b.k();
    }

    public ByteString getData() {
        return this.data_;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$Extension getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$Extension> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, this.type_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.computeBytesSize(2, this.data_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public int getType() {
        return this.type_;
    }

    public boolean hasData() {
        if ((this.bitField0_ & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean hasType() {
        if ((this.bitField0_ & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            if (b2 == 1) {
                return true;
            }
            return false;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    /* loaded from: classes4.dex */
    public static class a extends AbstractParser<Bdtls$Extension> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$Extension parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$Extension(codedInputStream, extensionRegistryLite, null);
        }
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
                        if (readTag != 8) {
                            if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.data_ = codedInputStream.readBytes();
                            }
                        } else {
                            this.bitField0_ |= 1;
                            this.type_ = codedInputStream.readUInt32();
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

    public /* synthetic */ Bdtls$Extension(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, dv3 dv3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public Bdtls$Extension(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static b newBuilder(Bdtls$Extension bdtls$Extension) {
        b newBuilder = newBuilder();
        newBuilder.s(bdtls$Extension);
        return newBuilder;
    }

    public static Bdtls$Extension parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bdtls$Extension parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
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

    public /* synthetic */ Bdtls$Extension(GeneratedMessageLite.Builder builder, dv3 dv3Var) {
        this(builder);
    }

    public static Bdtls$Extension parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Extension parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public Bdtls$Extension(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$Extension parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$Extension parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public static Bdtls$Extension parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public static Bdtls$Extension parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Extension parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$Extension parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }
}
