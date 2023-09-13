package com.baidu.swan.bdtls.impl.model;

import com.baidu.tieba.lu3;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes4.dex */
public final class Bdtls$Alert extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int LEVEL_FIELD_NUMBER = 1;
    public static Parser<Bdtls$Alert> PARSER = new a();
    public static final Bdtls$Alert defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public ByteString description_;
    public int level_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$Alert, b> implements Object {
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

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!s() || !r()) {
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public Bdtls$Alert build() {
            Bdtls$Alert buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$Alert buildPartial() {
            Bdtls$Alert bdtls$Alert = new Bdtls$Alert(this, (lu3) null);
            int i = this.a;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            bdtls$Alert.level_ = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bdtls$Alert.description_ = this.c;
            bdtls$Alert.bitField0_ = i2;
            return bdtls$Alert;
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
            p.t(buildPartial());
            return p;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: q */
        public Bdtls$Alert getDefaultInstanceForType() {
            return Bdtls$Alert.getDefaultInstance();
        }

        public boolean r() {
            if ((this.a & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean s() {
            if ((this.a & 1) == 1) {
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
            u(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bdtls$Alert bdtls$Alert = null;
            try {
                try {
                    Bdtls$Alert parsePartialFrom = Bdtls$Alert.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        t(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Bdtls$Alert bdtls$Alert2 = (Bdtls$Alert) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$Alert = bdtls$Alert2;
                        if (bdtls$Alert != null) {
                            t(bdtls$Alert);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bdtls$Alert != null) {
                }
                throw th;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$Alert bdtls$Alert) {
            t(bdtls$Alert);
            return this;
        }

        public b t(Bdtls$Alert bdtls$Alert) {
            if (bdtls$Alert == Bdtls$Alert.getDefaultInstance()) {
                return this;
            }
            if (bdtls$Alert.hasLevel()) {
                w(bdtls$Alert.getLevel());
            }
            if (bdtls$Alert.hasDescription()) {
                v(bdtls$Alert.getDescription());
            }
            return this;
        }

        public b v(ByteString byteString) {
            if (byteString != null) {
                this.a |= 2;
                this.c = byteString;
                return this;
            }
            throw null;
        }

        public b w(int i) {
            this.a |= 1;
            this.b = i;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        Bdtls$Alert bdtls$Alert = new Bdtls$Alert(true);
        defaultInstance = bdtls$Alert;
        bdtls$Alert.initFields();
    }

    public static Bdtls$Alert getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.level_ = 0;
        this.description_ = ByteString.EMPTY;
    }

    public static b newBuilder() {
        return b.k();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$Alert getDefaultInstanceForType() {
        return defaultInstance;
    }

    public ByteString getDescription() {
        return this.description_;
    }

    public int getLevel() {
        return this.level_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$Alert> getParserForType() {
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
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, this.level_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.computeBytesSize(2, this.description_);
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public boolean hasDescription() {
        if ((this.bitField0_ & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean hasLevel() {
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
        } else if (!hasLevel()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!hasDescription()) {
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
    public static class a extends AbstractParser<Bdtls$Alert> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$Alert parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$Alert(codedInputStream, extensionRegistryLite, null);
        }
    }

    public Bdtls$Alert(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.description_ = codedInputStream.readBytes();
                            }
                        } else {
                            this.bitField0_ |= 1;
                            this.level_ = codedInputStream.readUInt32();
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

    public /* synthetic */ Bdtls$Alert(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, lu3 lu3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public Bdtls$Alert(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static b newBuilder(Bdtls$Alert bdtls$Alert) {
        b newBuilder = newBuilder();
        newBuilder.t(bdtls$Alert);
        return newBuilder;
    }

    public static Bdtls$Alert parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bdtls$Alert parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeUInt32(1, this.level_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, this.description_);
        }
    }

    public /* synthetic */ Bdtls$Alert(GeneratedMessageLite.Builder builder, lu3 lu3Var) {
        this(builder);
    }

    public static Bdtls$Alert parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Alert parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public Bdtls$Alert(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$Alert parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$Alert parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public static Bdtls$Alert parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public static Bdtls$Alert parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Alert parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$Alert parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }
}
