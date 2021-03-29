package com.baidu.swan.games.bdtls.model;

import com.baidu.swan.games.bdtls.model.Bdtls$Random;
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
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bdtls$ServerHello> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$ServerHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$ServerHello(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ServerHello, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f12830e;

        /* renamed from: f  reason: collision with root package name */
        public Bdtls$Random f12831f = Bdtls$Random.getDefaultInstance();

        /* renamed from: g  reason: collision with root package name */
        public ByteString f12832g;

        /* renamed from: h  reason: collision with root package name */
        public int f12833h;
        public ByteString i;
        public List<Bdtls$Extension> j;

        public b() {
            ByteString byteString = ByteString.EMPTY;
            this.f12832g = byteString;
            this.i = byteString;
            this.j = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b A(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bdtls$ServerHello bdtls$ServerHello = null;
            try {
                try {
                    Bdtls$ServerHello parsePartialFrom = Bdtls$ServerHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        z(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    Bdtls$ServerHello bdtls$ServerHello2 = (Bdtls$ServerHello) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$ServerHello = bdtls$ServerHello2;
                        if (bdtls$ServerHello != null) {
                            z(bdtls$ServerHello);
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

        public b B(Bdtls$Random bdtls$Random) {
            if ((this.f12830e & 1) == 1 && this.f12831f != Bdtls$Random.getDefaultInstance()) {
                Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder(this.f12831f);
                newBuilder.u(bdtls$Random);
                this.f12831f = newBuilder.buildPartial();
            } else {
                this.f12831f = bdtls$Random;
            }
            this.f12830e |= 1;
            return this;
        }

        public b C(ByteString byteString) {
            if (byteString != null) {
                this.f12830e |= 2;
                this.f12832g = byteString;
                return this;
            }
            throw null;
        }

        public b D(int i) {
            this.f12830e |= 4;
            this.f12833h = i;
            return this;
        }

        public b E(ByteString byteString) {
            if (byteString != null) {
                this.f12830e |= 8;
                this.i = byteString;
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            o();
            return this;
        }

        public final void ensureExtensionsIsMutable() {
            if ((this.f12830e & 16) != 16) {
                this.j = new ArrayList(this.j);
                this.f12830e |= 16;
            }
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (x() && v() && w() && y() && u().isInitialized()) {
                for (int i = 0; i < t(); i++) {
                    if (!s(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public Bdtls$ServerHello build() {
            Bdtls$ServerHello buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            A(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public Bdtls$ServerHello buildPartial() {
            Bdtls$ServerHello bdtls$ServerHello = new Bdtls$ServerHello(this);
            int i = this.f12830e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            bdtls$ServerHello.random_ = this.f12831f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bdtls$ServerHello.cipherSuite_ = this.f12832g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            bdtls$ServerHello.lifeTime_ = this.f12833h;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            bdtls$ServerHello.sKR_ = this.i;
            if ((this.f12830e & 16) == 16) {
                this.j = Collections.unmodifiableList(this.j);
                this.f12830e &= -17;
            }
            bdtls$ServerHello.extensions_ = this.j;
            bdtls$ServerHello.bitField0_ = i2;
            return bdtls$ServerHello;
        }

        public b o() {
            super.clear();
            this.f12831f = Bdtls$Random.getDefaultInstance();
            int i = this.f12830e & (-2);
            this.f12830e = i;
            ByteString byteString = ByteString.EMPTY;
            this.f12832g = byteString;
            int i2 = i & (-3);
            this.f12830e = i2;
            this.f12833h = 0;
            int i3 = i2 & (-5);
            this.f12830e = i3;
            this.i = byteString;
            this.f12830e = i3 & (-9);
            this.j = Collections.emptyList();
            this.f12830e &= -17;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.z(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public Bdtls$ServerHello getDefaultInstanceForType() {
            return Bdtls$ServerHello.getDefaultInstance();
        }

        public Bdtls$Extension s(int i) {
            return this.j.get(i);
        }

        public int t() {
            return this.j.size();
        }

        public Bdtls$Random u() {
            return this.f12831f;
        }

        public boolean v() {
            return (this.f12830e & 2) == 2;
        }

        public boolean w() {
            return (this.f12830e & 4) == 4;
        }

        public boolean x() {
            return (this.f12830e & 1) == 1;
        }

        public boolean y() {
            return (this.f12830e & 8) == 8;
        }

        public b z(Bdtls$ServerHello bdtls$ServerHello) {
            if (bdtls$ServerHello == Bdtls$ServerHello.getDefaultInstance()) {
                return this;
            }
            if (bdtls$ServerHello.hasRandom()) {
                B(bdtls$ServerHello.getRandom());
            }
            if (bdtls$ServerHello.hasCipherSuite()) {
                C(bdtls$ServerHello.getCipherSuite());
            }
            if (bdtls$ServerHello.hasLifeTime()) {
                D(bdtls$ServerHello.getLifeTime());
            }
            if (bdtls$ServerHello.hasSKR()) {
                E(bdtls$ServerHello.getSKR());
            }
            if (!bdtls$ServerHello.extensions_.isEmpty()) {
                if (this.j.isEmpty()) {
                    this.j = bdtls$ServerHello.extensions_;
                    this.f12830e &= -17;
                } else {
                    ensureExtensionsIsMutable();
                    this.j.addAll(bdtls$ServerHello.extensions_);
                }
            }
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
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ServerHello bdtls$ServerHello) {
            z(bdtls$ServerHello);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            A(codedInputStream, extensionRegistryLite);
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
        return b.q();
    }

    public static Bdtls$ServerHello parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bdtls$ServerHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public ByteString getCipherSuite() {
        return this.cipherSuite_;
    }

    public Bdtls$Extension getExtensions(int i) {
        return this.extensions_.get(i);
    }

    public int getExtensionsCount() {
        return this.extensions_.size();
    }

    public List<Bdtls$Extension> getExtensionsList() {
        return this.extensions_;
    }

    public d.b.g0.g.d.g.b getExtensionsOrBuilder(int i) {
        return this.extensions_.get(i);
    }

    public List<? extends d.b.g0.g.d.g.b> getExtensionsOrBuilderList() {
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

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.random_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeMessageSize += CodedOutputStream.computeBytesSize(2, this.cipherSuite_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeMessageSize += CodedOutputStream.computeUInt32Size(3, this.lifeTime_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeMessageSize += CodedOutputStream.computeBytesSize(4, this.sKR_);
        }
        for (int i2 = 0; i2 < this.extensions_.size(); i2++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(5, this.extensions_.get(i2));
        }
        this.memoizedSerializedSize = computeMessageSize;
        return computeMessageSize;
    }

    public boolean hasCipherSuite() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasLifeTime() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasRandom() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasSKR() {
        return (this.bitField0_ & 8) == 8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
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

    public static b newBuilder(Bdtls$ServerHello bdtls$ServerHello) {
        b newBuilder = newBuilder();
        newBuilder.z(bdtls$ServerHello);
        return newBuilder;
    }

    public static Bdtls$ServerHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$ServerHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ServerHello getDefaultInstanceForType() {
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

    public Bdtls$ServerHello(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$ServerHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$ServerHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Bdtls$ServerHello parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public Bdtls$ServerHello(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$ServerHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$ServerHello parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$ServerHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.List<com.baidu.swan.games.bdtls.model.Bdtls$Extension> */
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
                        if (readTag == 10) {
                            Bdtls$Random.b builder = (this.bitField0_ & 1) == 1 ? this.random_.toBuilder() : null;
                            Bdtls$Random bdtls$Random = (Bdtls$Random) codedInputStream.readMessage(Bdtls$Random.PARSER, extensionRegistryLite);
                            this.random_ = bdtls$Random;
                            if (builder != null) {
                                builder.u(bdtls$Random);
                                this.random_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1;
                        } else if (readTag == 18) {
                            this.bitField0_ |= 2;
                            this.cipherSuite_ = codedInputStream.readBytes();
                        } else if (readTag == 24) {
                            this.bitField0_ |= 4;
                            this.lifeTime_ = codedInputStream.readUInt32();
                        } else if (readTag == 34) {
                            this.bitField0_ |= 8;
                            this.sKR_ = codedInputStream.readBytes();
                        } else if (readTag != 42) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            if (!(z2 & true)) {
                                this.extensions_ = new ArrayList();
                                z2 |= true;
                            }
                            this.extensions_.add(codedInputStream.readMessage(Bdtls$Extension.PARSER, extensionRegistryLite));
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                if (z2 & true) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                makeExtensionsImmutable();
            }
        }
    }
}
