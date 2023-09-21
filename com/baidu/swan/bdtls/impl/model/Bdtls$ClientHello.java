package com.baidu.swan.bdtls.impl.model;

import com.baidu.swan.bdtls.impl.model.Bdtls$Random;
import com.baidu.tieba.ku3;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.Builder<Bdtls$ClientHello, b> implements Object {
        public int a;
        public Bdtls$Random b = Bdtls$Random.getDefaultInstance();
        public List<ByteString> c = Collections.emptyList();
        public List<Bdtls$Extension> d = Collections.emptyList();
        public ByteString e = ByteString.EMPTY;

        public final void maybeForceBuilderInitialization() {
        }

        public b() {
            maybeForceBuilderInitialization();
        }

        public static /* synthetic */ b k() {
            return r();
        }

        public static b r() {
            return new b();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            p();
            return this;
        }

        public final void ensureExtensionsIsMutable() {
            if ((this.a & 4) != 4) {
                this.d = new ArrayList(this.d);
                this.a |= 4;
            }
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (!x() || !w().isInitialized()) {
                return false;
            }
            for (int i = 0; i < v(); i++) {
                if (!u(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public Bdtls$ClientHello build() {
            Bdtls$ClientHello buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public b p() {
            super.clear();
            this.b = Bdtls$Random.getDefaultInstance();
            this.a &= -2;
            this.c = Collections.emptyList();
            this.a &= -3;
            this.d = Collections.emptyList();
            int i = this.a & (-5);
            this.a = i;
            this.e = ByteString.EMPTY;
            this.a = i & (-9);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: q */
        public b mo43clone() {
            b r = r();
            r.y(buildPartial());
            return r;
        }

        public final void s() {
            if ((this.a & 2) != 2) {
                this.c = new ArrayList(this.c);
                this.a |= 2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: t */
        public Bdtls$ClientHello getDefaultInstanceForType() {
            return Bdtls$ClientHello.getDefaultInstance();
        }

        public int v() {
            return this.d.size();
        }

        public Bdtls$Random w() {
            return this.b;
        }

        public boolean x() {
            if ((this.a & 1) == 1) {
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

        public b B(Bdtls$Random bdtls$Random) {
            if (bdtls$Random != null) {
                this.b = bdtls$Random;
                this.a |= 1;
                return this;
            }
            throw null;
        }

        public b C(ByteString byteString) {
            if (byteString != null) {
                this.a |= 8;
                this.e = byteString;
                return this;
            }
            throw null;
        }

        public b l(ByteString byteString) {
            if (byteString != null) {
                s();
                this.c.add(byteString);
                return this;
            }
            throw null;
        }

        public b m(Bdtls$Extension bdtls$Extension) {
            if (bdtls$Extension != null) {
                ensureExtensionsIsMutable();
                this.d.add(bdtls$Extension);
                return this;
            }
            throw null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(Bdtls$ClientHello bdtls$ClientHello) {
            y(bdtls$ClientHello);
            return this;
        }

        public Bdtls$Extension u(int i) {
            return this.d.get(i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            p();
            return this;
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
            Bdtls$ClientHello bdtls$ClientHello = null;
            try {
                try {
                    Bdtls$ClientHello parsePartialFrom = Bdtls$ClientHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        y(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Bdtls$ClientHello bdtls$ClientHello2 = (Bdtls$ClientHello) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bdtls$ClientHello = bdtls$ClientHello2;
                        if (bdtls$ClientHello != null) {
                            y(bdtls$ClientHello);
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

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            z(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: o */
        public Bdtls$ClientHello buildPartial() {
            Bdtls$ClientHello bdtls$ClientHello = new Bdtls$ClientHello(this, (ku3) null);
            int i = this.a;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            bdtls$ClientHello.random_ = this.b;
            if ((this.a & 2) == 2) {
                this.c = Collections.unmodifiableList(this.c);
                this.a &= -3;
            }
            bdtls$ClientHello.cipherSuites_ = this.c;
            if ((this.a & 4) == 4) {
                this.d = Collections.unmodifiableList(this.d);
                this.a &= -5;
            }
            bdtls$ClientHello.extensions_ = this.d;
            if ((i & 8) == 8) {
                i2 |= 2;
            }
            bdtls$ClientHello.sKR_ = this.e;
            bdtls$ClientHello.bitField0_ = i2;
            return bdtls$ClientHello;
        }

        public b y(Bdtls$ClientHello bdtls$ClientHello) {
            if (bdtls$ClientHello == Bdtls$ClientHello.getDefaultInstance()) {
                return this;
            }
            if (bdtls$ClientHello.hasRandom()) {
                A(bdtls$ClientHello.getRandom());
            }
            if (!bdtls$ClientHello.cipherSuites_.isEmpty()) {
                if (this.c.isEmpty()) {
                    this.c = bdtls$ClientHello.cipherSuites_;
                    this.a &= -3;
                } else {
                    s();
                    this.c.addAll(bdtls$ClientHello.cipherSuites_);
                }
            }
            if (!bdtls$ClientHello.extensions_.isEmpty()) {
                if (this.d.isEmpty()) {
                    this.d = bdtls$ClientHello.extensions_;
                    this.a &= -5;
                } else {
                    ensureExtensionsIsMutable();
                    this.d.addAll(bdtls$ClientHello.extensions_);
                }
            }
            if (bdtls$ClientHello.hasSKR()) {
                C(bdtls$ClientHello.getSKR());
            }
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
        return b.k();
    }

    public int getCipherSuitesCount() {
        return this.cipherSuites_.size();
    }

    public List<ByteString> getCipherSuitesList() {
        return this.cipherSuites_;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public Bdtls$ClientHello getDefaultInstanceForType() {
        return defaultInstance;
    }

    public int getExtensionsCount() {
        return this.extensions_.size();
    }

    public List<Bdtls$Extension> getExtensionsList() {
        return this.extensions_;
    }

    public List<? extends lu3> getExtensionsOrBuilderList() {
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

    public boolean hasRandom() {
        if ((this.bitField0_ & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean hasSKR() {
        if ((this.bitField0_ & 2) == 2) {
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
    public static class a extends AbstractParser<Bdtls$ClientHello> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public Bdtls$ClientHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Bdtls$ClientHello(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.util.List<com.baidu.swan.bdtls.impl.model.Bdtls$Extension> */
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
                        if (readTag != 10) {
                            if (readTag != 18) {
                                if (readTag != 26) {
                                    if (readTag != 34) {
                                        if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 2;
                                        this.sKR_ = codedInputStream.readBytes();
                                    }
                                } else {
                                    if (!(z2 & true)) {
                                        this.extensions_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.extensions_.add(codedInputStream.readMessage(Bdtls$Extension.PARSER, extensionRegistryLite));
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.cipherSuites_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.cipherSuites_.add(codedInputStream.readBytes());
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
                    this.cipherSuites_ = Collections.unmodifiableList(this.cipherSuites_);
                }
                if (z2 & true) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public /* synthetic */ Bdtls$ClientHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ku3 ku3Var) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public Bdtls$ClientHello(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static b newBuilder(Bdtls$ClientHello bdtls$ClientHello) {
        b newBuilder = newBuilder();
        newBuilder.y(bdtls$ClientHello);
        return newBuilder;
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

    public Bdtls$Extension getExtensions(int i) {
        return this.extensions_.get(i);
    }

    public lu3 getExtensionsOrBuilder(int i) {
        return this.extensions_.get(i);
    }

    public /* synthetic */ Bdtls$ClientHello(GeneratedMessageLite.Builder builder, ku3 ku3Var) {
        this(builder);
    }

    public static Bdtls$ClientHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$ClientHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public Bdtls$ClientHello(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static Bdtls$ClientHello parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static Bdtls$ClientHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public static Bdtls$ClientHello parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public static Bdtls$ClientHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Bdtls$ClientHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Bdtls$ClientHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
        int i3 = 0;
        for (int i4 = 0; i4 < this.cipherSuites_.size(); i4++) {
            i3 += CodedOutputStream.computeBytesSizeNoTag(this.cipherSuites_.get(i4));
        }
        int size = i + i3 + (getCipherSuitesList().size() * 1);
        for (int i5 = 0; i5 < this.extensions_.size(); i5++) {
            size += CodedOutputStream.computeMessageSize(3, this.extensions_.get(i5));
        }
        if ((this.bitField0_ & 2) == 2) {
            size += CodedOutputStream.computeBytesSize(4, this.sKR_);
        }
        this.memoizedSerializedSize = size;
        return size;
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
}
