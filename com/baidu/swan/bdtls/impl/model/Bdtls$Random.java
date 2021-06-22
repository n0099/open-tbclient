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
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes3.dex */
public final class Bdtls$Random extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int GMTUNIXTIME_FIELD_NUMBER = 1;
    public static Parser<Bdtls$Random> PARSER = new a();
    public static final int RANDOMBYTES_FIELD_NUMBER = 2;
    public static final Bdtls$Random defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public int gMTUnixTime_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public ByteString randomBytes_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bdtls$Random> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$Random parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$Random(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$Random, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f11602e;

        /* renamed from: f  reason: collision with root package name */
        public int f11603f;

        /* renamed from: g  reason: collision with root package name */
        public ByteString f11604g = ByteString.EMPTY;

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
            return s() && t();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$Random build() {
            Bdtls$Random buildPartial = buildPartial();
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
        public Bdtls$Random buildPartial() {
            Bdtls$Random bdtls$Random = new Bdtls$Random(this);
            int i2 = this.f11602e;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            bdtls$Random.gMTUnixTime_ = this.f11603f;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            bdtls$Random.randomBytes_ = this.f11604g;
            bdtls$Random.bitField0_ = i3;
            return bdtls$Random;
        }

        public b o() {
            super.clear();
            this.f11603f = 0;
            int i2 = this.f11602e & (-2);
            this.f11602e = i2;
            this.f11604g = ByteString.EMPTY;
            this.f11602e = i2 & (-3);
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
        public Bdtls$Random getDefaultInstanceForType() {
            return Bdtls$Random.getDefaultInstance();
        }

        public boolean s() {
            return (this.f11602e & 1) == 1;
        }

        public boolean t() {
            return (this.f11602e & 2) == 2;
        }

        public b u(Bdtls$Random bdtls$Random) {
            if (bdtls$Random == Bdtls$Random.getDefaultInstance()) {
                return this;
            }
            if (bdtls$Random.hasGMTUnixTime()) {
                w(bdtls$Random.getGMTUnixTime());
            }
            if (bdtls$Random.hasRandomBytes()) {
                x(bdtls$Random.getRandomBytes());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bdtls$Random bdtls$Random = null;
            try {
                try {
                    Bdtls$Random parsePartialFrom = Bdtls$Random.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        u(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    Bdtls$Random bdtls$Random2 = (Bdtls$Random) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$Random = bdtls$Random2;
                        if (bdtls$Random != null) {
                            u(bdtls$Random);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bdtls$Random != null) {
                }
                throw th;
            }
        }

        public b w(int i2) {
            this.f11602e |= 1;
            this.f11603f = i2;
            return this;
        }

        public b x(ByteString byteString) {
            if (byteString != null) {
                this.f11602e |= 2;
                this.f11604g = byteString;
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$Random bdtls$Random) {
            u(bdtls$Random);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            v(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        Bdtls$Random bdtls$Random = new Bdtls$Random(true);
        defaultInstance = bdtls$Random;
        bdtls$Random.initFields();
    }

    public static Bdtls$Random getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.gMTUnixTime_ = 0;
        this.randomBytes_ = ByteString.EMPTY;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static Bdtls$Random parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bdtls$Random parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getGMTUnixTime() {
        return this.gMTUnixTime_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$Random> getParserForType() {
        return PARSER;
    }

    public ByteString getRandomBytes() {
        return this.randomBytes_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.gMTUnixTime_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeBytesSize(2, this.randomBytes_);
        }
        this.memoizedSerializedSize = computeInt32Size;
        return computeInt32Size;
    }

    public boolean hasGMTUnixTime() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasRandomBytes() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
        } else if (!hasGMTUnixTime()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!hasRandomBytes()) {
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
            codedOutputStream.writeInt32(1, this.gMTUnixTime_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, this.randomBytes_);
        }
    }

    public static b newBuilder(Bdtls$Random bdtls$Random) {
        b newBuilder = newBuilder();
        newBuilder.u(bdtls$Random);
        return newBuilder;
    }

    public static Bdtls$Random parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Random parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$Random getDefaultInstanceForType() {
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

    public Bdtls$Random(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$Random parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$Random parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Bdtls$Random parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public Bdtls$Random(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$Random parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$Random parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$Random parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public Bdtls$Random(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.gMTUnixTime_ = codedInputStream.readInt32();
                        } else if (readTag != 18) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.randomBytes_ = codedInputStream.readBytes();
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
