package com.baidu.swan.bdtls.impl.model;

import com.baidu.swan.bdtls.impl.model.Bdtls$Random;
import com.baidu.tieba.cu3;
import com.baidu.tieba.du3;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class Bdtls$ServerHello extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int CIPHERSUITE_FIELD_NUMBER = 2;
    public static final int EXTENSIONS_FIELD_NUMBER = 5;
    public static final int LIFETIME_FIELD_NUMBER = 3;
    public static Parser<Bdtls$ServerHello> PARSER = new a();
    public static final int RANDOM_FIELD_NUMBER = 1;
    public static final int SKR_FIELD_NUMBER = 4;
    public static final Bdtls$ServerHello defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public ByteString cipherSuite_;
    public List<Bdtls$Extension> extensions_;
    public int lifeTime_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public Bdtls$Random random_;
    public ByteString sKR_;

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ServerHello, b> implements Object {
        public int a;
        public Bdtls$Random b = Bdtls$Random.getDefaultInstance();
        public ByteString c;
        public int d;
        public ByteString e;
        public List<Bdtls$Extension> f;

        public final void maybeForceBuilderInitialization() {
        }

        public b() {
            ByteString byteString = ByteString.EMPTY;
            this.c = byteString;
            this.e = byteString;
            this.f = Collections.emptyList();
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

        public final void ensureExtensionsIsMutable() {
            if ((this.a & 16) != 16) {
                this.f = new ArrayList(this.f);
                this.a |= 16;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: l */
        public Bdtls$ServerHello build() {
            Bdtls$ServerHello buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public b n() {
            super.clear();
            this.b = Bdtls$Random.getDefaultInstance();
            int i = this.a & (-2);
            this.a = i;
            ByteString byteString = ByteString.EMPTY;
            this.c = byteString;
            int i2 = i & (-3);
            this.a = i2;
            this.d = 0;
            int i3 = i2 & (-5);
            this.a = i3;
            this.e = byteString;
            this.a = i3 & (-9);
            this.f = Collections.emptyList();
            this.a &= -17;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: o */
        public b mo43clone() {
            b p = p();
            p.y(buildPartial());
            return p;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: q */
        public Bdtls$ServerHello getDefaultInstanceForType() {
            return Bdtls$ServerHello.getDefaultInstance();
        }

        public int s() {
            return this.f.size();
        }

        public Bdtls$Random t() {
            return this.b;
        }

        public boolean u() {
            if ((this.a & 2) == 2) {
                return true;
            }
            return false;
        }

        public boolean v() {
            if ((this.a & 4) == 4) {
                return true;
            }
            return false;
        }

        public boolean w() {
            if ((this.a & 1) == 1) {
                return true;
            }
            return false;
        }

        public boolean x() {
            if ((this.a & 8) == 8) {
                return true;
            }
            return false;
        }

        public b A(Bdtls$Random bdtls$Random) {
            if ((this.a & 1) == 1 && this.b != Bdtls$Random.getDefaultInstance()) {
                Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder(this.b);
                newBuilder.t(bdtls$Random);
                this.b = newBuilder.buildPartial();
            } else {
                this.b = bdtls$Random;
            }
            this.a |= 1;
            return this;
        }

        public b B(ByteString byteString) {
            if (byteString != null) {
                this.a |= 2;
                this.c = byteString;
                return this;
            }
            throw null;
        }

        public b C(int i) {
            this.a |= 4;
            this.d = i;
            return this;
        }

        public b D(ByteString byteString) {
            if (byteString != null) {
                this.a |= 8;
                this.e = byteString;
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ServerHello bdtls$ServerHello) {
            y(bdtls$ServerHello);
            return this;
        }

        public Bdtls$Extension r(int i) {
            return this.f.get(i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            n();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!w() || !u() || !v() || !x() || !t().isInitialized()) {
                return false;
            }
            for (int i = 0; i < s(); i++) {
                if (!r(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$ServerHello buildPartial() {
            Bdtls$ServerHello bdtls$ServerHello = new Bdtls$ServerHello(this, (cu3) null);
            int i = this.a;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            bdtls$ServerHello.random_ = this.b;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bdtls$ServerHello.cipherSuite_ = this.c;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            bdtls$ServerHello.lifeTime_ = this.d;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            bdtls$ServerHello.sKR_ = this.e;
            if ((this.a & 16) == 16) {
                this.f = Collections.unmodifiableList(this.f);
                this.a &= -17;
            }
            bdtls$ServerHello.extensions_ = this.f;
            bdtls$ServerHello.bitField0_ = i2;
            return bdtls$ServerHello;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            z(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b z(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bdtls$ServerHello bdtls$ServerHello = null;
            try {
                try {
                    Bdtls$ServerHello parsePartialFrom = Bdtls$ServerHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        y(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Bdtls$ServerHello bdtls$ServerHello2 = (Bdtls$ServerHello) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$ServerHello = bdtls$ServerHello2;
                        if (bdtls$ServerHello != null) {
                            y(bdtls$ServerHello);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bdtls$ServerHello != null) {
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            z(codedInputStream, extensionRegistryLite);
            return this;
        }

        public b y(Bdtls$ServerHello bdtls$ServerHello) {
            if (bdtls$ServerHello == Bdtls$ServerHello.getDefaultInstance()) {
                return this;
            }
            if (bdtls$ServerHello.hasRandom()) {
                A(bdtls$ServerHello.getRandom());
            }
            if (bdtls$ServerHello.hasCipherSuite()) {
                B(bdtls$ServerHello.getCipherSuite());
            }
            if (bdtls$ServerHello.hasLifeTime()) {
                C(bdtls$ServerHello.getLifeTime());
            }
            if (bdtls$ServerHello.hasSKR()) {
                D(bdtls$ServerHello.getSKR());
            }
            if (!bdtls$ServerHello.extensions_.isEmpty()) {
                if (this.f.isEmpty()) {
                    this.f = bdtls$ServerHello.extensions_;
                    this.a &= -17;
                } else {
                    ensureExtensionsIsMutable();
                    this.f.addAll(bdtls$ServerHello.extensions_);
                }
            }
            return this;
        }
    }

    static {
        Bdtls$ServerHello bdtls$ServerHello = new Bdtls$ServerHello(true);
        defaultInstance = bdtls$ServerHello;
        bdtls$ServerHello.initFields();
    }

    public static Bdtls$ServerHello getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.random_ = Bdtls$Random.getDefaultInstance();
        ByteString byteString = ByteString.EMPTY;
        this.cipherSuite_ = byteString;
        this.lifeTime_ = 0;
        this.sKR_ = byteString;
        this.extensions_ = Collections.emptyList();
    }

    public static b newBuilder() {
        return b.k();
    }

    public ByteString getCipherSuite() {
        return this.cipherSuite_;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ServerHello getDefaultInstanceForType() {
        return defaultInstance;
    }

    public int getExtensionsCount() {
        return this.extensions_.size();
    }

    public List<Bdtls$Extension> getExtensionsList() {
        return this.extensions_;
    }

    public List<? extends du3> getExtensionsOrBuilderList() {
        return this.extensions_;
    }

    public int getLifeTime() {
        return this.lifeTime_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$ServerHello> getParserForType() {
        return PARSER;
    }

    public Bdtls$Random getRandom() {
        return this.random_;
    }

    public ByteString getSKR() {
        return this.sKR_;
    }

    public boolean hasCipherSuite() {
        if ((this.bitField0_ & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean hasLifeTime() {
        if ((this.bitField0_ & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean hasRandom() {
        if ((this.bitField0_ & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean hasSKR() {
        if ((this.bitField0_ & 8) == 8) {
            return true;
        }
        return false;
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
    public static class a extends AbstractParser<Bdtls$ServerHello> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$ServerHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$ServerHello(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.List<com.baidu.swan.bdtls.impl.model.Bdtls$Extension> */
    /* JADX WARN: Multi-variable type inference failed */
    public Bdtls$ServerHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (z) {
                break;
            }
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag != 10) {
                            if (readTag != 18) {
                                if (readTag != 24) {
                                    if (readTag != 34) {
                                        if (readTag != 42) {
                                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                            }
                                        } else {
                                            if (!(z2 & true)) {
                                                this.extensions_ = new ArrayList();
                                                z2 |= true;
                                            }
                                            this.extensions_.add(codedInputStream.readMessage(Bdtls$Extension.PARSER, extensionRegistryLite));
                                        }
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.sKR_ = codedInputStream.readBytes();
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.lifeTime_ = codedInputStream.readUInt32();
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.cipherSuite_ = codedInputStream.readBytes();
                            }
                        } else {
                            Bdtls$Random.b builder = (this.bitField0_ & 1) == 1 ? this.random_.toBuilder() : null;
                            Bdtls$Random bdtls$Random = (Bdtls$Random) codedInputStream.readMessage(Bdtls$Random.PARSER, extensionRegistryLite);
                            this.random_ = bdtls$Random;
                            if (builder != null) {
                                builder.t(bdtls$Random);
                                this.random_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1;
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                if (z2 & true) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ Bdtls$ServerHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, cu3 cu3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public Bdtls$ServerHello(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static b newBuilder(Bdtls$ServerHello bdtls$ServerHello) {
        b newBuilder = newBuilder();
        newBuilder.y(bdtls$ServerHello);
        return newBuilder;
    }

    public static Bdtls$ServerHello parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bdtls$ServerHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public Bdtls$Extension getExtensions(int i) {
        return this.extensions_.get(i);
    }

    public du3 getExtensionsOrBuilder(int i) {
        return this.extensions_.get(i);
    }

    public /* synthetic */ Bdtls$ServerHello(GeneratedMessageLite.Builder builder, cu3 cu3Var) {
        this(builder);
    }

    public static Bdtls$ServerHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$ServerHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public Bdtls$ServerHello(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$ServerHello parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$ServerHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public static Bdtls$ServerHello parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public static Bdtls$ServerHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$ServerHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$ServerHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i;
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        if ((this.bitField0_ & 1) == 1) {
            i = CodedOutputStream.computeMessageSize(1, this.random_) + 0;
        } else {
            i = 0;
        }
        if ((this.bitField0_ & 2) == 2) {
            i += CodedOutputStream.computeBytesSize(2, this.cipherSuite_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i += CodedOutputStream.computeUInt32Size(3, this.lifeTime_);
        }
        if ((this.bitField0_ & 8) == 8) {
            i += CodedOutputStream.computeBytesSize(4, this.sKR_);
        }
        for (int i3 = 0; i3 < this.extensions_.size(); i3++) {
            i += CodedOutputStream.computeMessageSize(5, this.extensions_.get(i3));
        }
        this.memoizedSerializedSize = i;
        return i;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            if (b2 == 1) {
                return true;
            }
            return false;
        } else if (!hasRandom()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!hasCipherSuite()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!hasLifeTime()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!hasSKR()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!getRandom().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else {
            for (int i = 0; i < getExtensionsCount(); i++) {
                if (!getExtensions(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(1, this.random_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, this.cipherSuite_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeUInt32(3, this.lifeTime_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeBytes(4, this.sKR_);
        }
        for (int i = 0; i < this.extensions_.size(); i++) {
            codedOutputStream.writeMessage(5, this.extensions_.get(i));
        }
    }
}
