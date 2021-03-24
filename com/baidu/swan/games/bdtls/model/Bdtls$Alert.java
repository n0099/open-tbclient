package com.baidu.swan.games.bdtls.model;

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
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bdtls$Alert> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$Alert parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$Alert(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$Alert, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f12814e;

        /* renamed from: f  reason: collision with root package name */
        public int f12815f;

        /* renamed from: g  reason: collision with root package name */
        public ByteString f12816g = ByteString.EMPTY;

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

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return t() && s();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$Alert build() {
            Bdtls$Alert buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public Bdtls$Alert buildPartial() {
            Bdtls$Alert bdtls$Alert = new Bdtls$Alert(this);
            int i = this.f12814e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            bdtls$Alert.level_ = this.f12815f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bdtls$Alert.description_ = this.f12816g;
            bdtls$Alert.bitField0_ = i2;
            return bdtls$Alert;
        }

        public b o() {
            super.clear();
            this.f12815f = 0;
            int i = this.f12814e & (-2);
            this.f12814e = i;
            this.f12816g = ByteString.EMPTY;
            this.f12814e = i & (-3);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.u(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public Bdtls$Alert getDefaultInstanceForType() {
            return Bdtls$Alert.getDefaultInstance();
        }

        public boolean s() {
            return (this.f12814e & 2) == 2;
        }

        public boolean t() {
            return (this.f12814e & 1) == 1;
        }

        public b u(Bdtls$Alert bdtls$Alert) {
            if (bdtls$Alert == Bdtls$Alert.getDefaultInstance()) {
                return this;
            }
            if (bdtls$Alert.hasLevel()) {
                x(bdtls$Alert.getLevel());
            }
            if (bdtls$Alert.hasDescription()) {
                w(bdtls$Alert.getDescription());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bdtls$Alert bdtls$Alert = null;
            try {
                try {
                    Bdtls$Alert parsePartialFrom = Bdtls$Alert.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        u(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    Bdtls$Alert bdtls$Alert2 = (Bdtls$Alert) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$Alert = bdtls$Alert2;
                        if (bdtls$Alert != null) {
                            u(bdtls$Alert);
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

        public b w(ByteString byteString) {
            if (byteString != null) {
                this.f12814e |= 2;
                this.f12816g = byteString;
                return this;
            }
            throw null;
        }

        public b x(int i) {
            this.f12814e |= 1;
            this.f12815f = i;
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
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$Alert bdtls$Alert) {
            u(bdtls$Alert);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
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
        return b.q();
    }

    public static Bdtls$Alert parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bdtls$Alert parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
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
        int computeUInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.level_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeUInt32Size += CodedOutputStream.computeBytesSize(2, this.description_);
        }
        this.memoizedSerializedSize = computeUInt32Size;
        return computeUInt32Size;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasLevel() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
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

    public static b newBuilder(Bdtls$Alert bdtls$Alert) {
        b newBuilder = newBuilder();
        newBuilder.u(bdtls$Alert);
        return newBuilder;
    }

    public static Bdtls$Alert parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Alert parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$Alert getDefaultInstanceForType() {
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

    public Bdtls$Alert(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$Alert parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$Alert parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Bdtls$Alert parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public Bdtls$Alert(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$Alert parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Alert parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$Alert parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
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
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.level_ = codedInputStream.readUInt32();
                        } else if (readTag != 18) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.description_ = codedInputStream.readBytes();
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
