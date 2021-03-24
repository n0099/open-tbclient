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
public final class Bdtls$ClientHello extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int CIPHERSUITES_FIELD_NUMBER = 2;
    public static final int EXTENSIONS_FIELD_NUMBER = 3;
    public static Parser<Bdtls$ClientHello> PARSER = new a();
    public static final int RANDOM_FIELD_NUMBER = 1;
    public static final int SKR_FIELD_NUMBER = 4;
    public static final Bdtls$ClientHello defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public List<ByteString> cipherSuites_;
    public List<Bdtls$Extension> extensions_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public Bdtls$Random random_;
    public ByteString sKR_;

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<Bdtls$ClientHello> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$ClientHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$ClientHello(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ClientHello, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f12819e;

        /* renamed from: f  reason: collision with root package name */
        public Bdtls$Random f12820f = Bdtls$Random.getDefaultInstance();

        /* renamed from: g  reason: collision with root package name */
        public List<ByteString> f12821g = Collections.emptyList();

        /* renamed from: h  reason: collision with root package name */
        public List<Bdtls$Extension> f12822h = Collections.emptyList();
        public ByteString i = ByteString.EMPTY;

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b s() {
            return new b();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b A(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Bdtls$ClientHello bdtls$ClientHello = null;
            try {
                try {
                    Bdtls$ClientHello parsePartialFrom = Bdtls$ClientHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        z(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    Bdtls$ClientHello bdtls$ClientHello2 = (Bdtls$ClientHello) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$ClientHello = bdtls$ClientHello2;
                        if (bdtls$ClientHello != null) {
                            z(bdtls$ClientHello);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bdtls$ClientHello != null) {
                }
                throw th;
            }
        }

        public b B(Bdtls$Random bdtls$Random) {
            if ((this.f12819e & 1) == 1 && this.f12820f != Bdtls$Random.getDefaultInstance()) {
                Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder(this.f12820f);
                newBuilder.u(bdtls$Random);
                this.f12820f = newBuilder.buildPartial();
            } else {
                this.f12820f = bdtls$Random;
            }
            this.f12819e |= 1;
            return this;
        }

        public b C(Bdtls$Random bdtls$Random) {
            if (bdtls$Random != null) {
                this.f12820f = bdtls$Random;
                this.f12819e |= 1;
                return this;
            }
            throw null;
        }

        public b D(ByteString byteString) {
            if (byteString != null) {
                this.f12819e |= 8;
                this.i = byteString;
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            q();
            return this;
        }

        public final void ensureExtensionsIsMutable() {
            if ((this.f12819e & 4) != 4) {
                this.f12822h = new ArrayList(this.f12822h);
                this.f12819e |= 4;
            }
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (y() && x().isInitialized()) {
                for (int i = 0; i < w(); i++) {
                    if (!v(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public b m(ByteString byteString) {
            if (byteString != null) {
                t();
                this.f12821g.add(byteString);
                return this;
            }
            throw null;
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            A(codedInputStream, extensionRegistryLite);
            return this;
        }

        public b n(Bdtls$Extension bdtls$Extension) {
            if (bdtls$Extension != null) {
                ensureExtensionsIsMutable();
                this.f12822h.add(bdtls$Extension);
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: o */
        public Bdtls$ClientHello build() {
            Bdtls$ClientHello buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public Bdtls$ClientHello buildPartial() {
            Bdtls$ClientHello bdtls$ClientHello = new Bdtls$ClientHello(this);
            int i = this.f12819e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            bdtls$ClientHello.random_ = this.f12820f;
            if ((this.f12819e & 2) == 2) {
                this.f12821g = Collections.unmodifiableList(this.f12821g);
                this.f12819e &= -3;
            }
            bdtls$ClientHello.cipherSuites_ = this.f12821g;
            if ((this.f12819e & 4) == 4) {
                this.f12822h = Collections.unmodifiableList(this.f12822h);
                this.f12819e &= -5;
            }
            bdtls$ClientHello.extensions_ = this.f12822h;
            if ((i & 8) == 8) {
                i2 |= 2;
            }
            bdtls$ClientHello.sKR_ = this.i;
            bdtls$ClientHello.bitField0_ = i2;
            return bdtls$ClientHello;
        }

        public b q() {
            super.clear();
            this.f12820f = Bdtls$Random.getDefaultInstance();
            this.f12819e &= -2;
            this.f12821g = Collections.emptyList();
            this.f12819e &= -3;
            this.f12822h = Collections.emptyList();
            int i = this.f12819e & (-5);
            this.f12819e = i;
            this.i = ByteString.EMPTY;
            this.f12819e = i & (-9);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: r */
        public b clone() {
            b s = s();
            s.z(buildPartial());
            return s;
        }

        public final void t() {
            if ((this.f12819e & 2) != 2) {
                this.f12821g = new ArrayList(this.f12821g);
                this.f12819e |= 2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: u */
        public Bdtls$ClientHello getDefaultInstanceForType() {
            return Bdtls$ClientHello.getDefaultInstance();
        }

        public Bdtls$Extension v(int i) {
            return this.f12822h.get(i);
        }

        public int w() {
            return this.f12822h.size();
        }

        public Bdtls$Random x() {
            return this.f12820f;
        }

        public boolean y() {
            return (this.f12819e & 1) == 1;
        }

        public b z(Bdtls$ClientHello bdtls$ClientHello) {
            if (bdtls$ClientHello == Bdtls$ClientHello.getDefaultInstance()) {
                return this;
            }
            if (bdtls$ClientHello.hasRandom()) {
                B(bdtls$ClientHello.getRandom());
            }
            if (!bdtls$ClientHello.cipherSuites_.isEmpty()) {
                if (this.f12821g.isEmpty()) {
                    this.f12821g = bdtls$ClientHello.cipherSuites_;
                    this.f12819e &= -3;
                } else {
                    t();
                    this.f12821g.addAll(bdtls$ClientHello.cipherSuites_);
                }
            }
            if (!bdtls$ClientHello.extensions_.isEmpty()) {
                if (this.f12822h.isEmpty()) {
                    this.f12822h = bdtls$ClientHello.extensions_;
                    this.f12819e &= -5;
                } else {
                    ensureExtensionsIsMutable();
                    this.f12822h.addAll(bdtls$ClientHello.extensions_);
                }
            }
            if (bdtls$ClientHello.hasSKR()) {
                D(bdtls$ClientHello.getSKR());
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            q();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ClientHello bdtls$ClientHello) {
            z(bdtls$ClientHello);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            A(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        Bdtls$ClientHello bdtls$ClientHello = new Bdtls$ClientHello(true);
        defaultInstance = bdtls$ClientHello;
        bdtls$ClientHello.initFields();
    }

    public static Bdtls$ClientHello getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.random_ = Bdtls$Random.getDefaultInstance();
        this.cipherSuites_ = Collections.emptyList();
        this.extensions_ = Collections.emptyList();
        this.sKR_ = ByteString.EMPTY;
    }

    public static b newBuilder() {
        return b.s();
    }

    public static Bdtls$ClientHello parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static Bdtls$ClientHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public ByteString getCipherSuites(int i) {
        return this.cipherSuites_.get(i);
    }

    public int getCipherSuitesCount() {
        return this.cipherSuites_.size();
    }

    public List<ByteString> getCipherSuitesList() {
        return this.cipherSuites_;
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

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<Bdtls$ClientHello> getParserForType() {
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
        int i2 = 0;
        for (int i3 = 0; i3 < this.cipherSuites_.size(); i3++) {
            i2 += CodedOutputStream.computeBytesSizeNoTag(this.cipherSuites_.get(i3));
        }
        int size = computeMessageSize + i2 + (getCipherSuitesList().size() * 1);
        for (int i4 = 0; i4 < this.extensions_.size(); i4++) {
            size += CodedOutputStream.computeMessageSize(3, this.extensions_.get(i4));
        }
        if ((this.bitField0_ & 2) == 2) {
            size += CodedOutputStream.computeBytesSize(4, this.sKR_);
        }
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasRandom() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasSKR() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
        } else if (!hasRandom()) {
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
        for (int i = 0; i < this.cipherSuites_.size(); i++) {
            codedOutputStream.writeBytes(2, this.cipherSuites_.get(i));
        }
        for (int i2 = 0; i2 < this.extensions_.size(); i2++) {
            codedOutputStream.writeMessage(3, this.extensions_.get(i2));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(4, this.sKR_);
        }
    }

    public static b newBuilder(Bdtls$ClientHello bdtls$ClientHello) {
        b newBuilder = newBuilder();
        newBuilder.z(bdtls$ClientHello);
        return newBuilder;
    }

    public static Bdtls$ClientHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$ClientHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ClientHello getDefaultInstanceForType() {
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

    public Bdtls$ClientHello(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$ClientHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$ClientHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Bdtls$ClientHello parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public Bdtls$ClientHello(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$ClientHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$ClientHello parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$ClientHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.util.List<com.baidu.swan.games.bdtls.model.Bdtls$Extension> */
    /* JADX WARN: Multi-variable type inference failed */
    public Bdtls$ClientHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (!(z2 & true)) {
                                this.cipherSuites_ = new ArrayList();
                                z2 |= true;
                            }
                            this.cipherSuites_.add(codedInputStream.readBytes());
                        } else if (readTag == 26) {
                            if (!(z2 & true)) {
                                this.extensions_ = new ArrayList();
                                z2 |= true;
                            }
                            this.extensions_.add(codedInputStream.readMessage(Bdtls$Extension.PARSER, extensionRegistryLite));
                        } else if (readTag != 34) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.sKR_ = codedInputStream.readBytes();
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
                    this.cipherSuites_ = Collections.unmodifiableList(this.cipherSuites_);
                }
                if (z2 & true) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                makeExtensionsImmutable();
            }
        }
    }
}
