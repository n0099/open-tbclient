package com.baidu.swan.games.bdtls.model;

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
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public final class Bdtls {

    /* loaded from: classes11.dex */
    public interface a extends MessageLiteOrBuilder {
    }

    /* loaded from: classes11.dex */
    public static final class Random extends GeneratedMessageLite implements d {
        public static final int GMTUNIXTIME_FIELD_NUMBER = 1;
        public static final int RANDOMBYTES_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int gMTUnixTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ByteString randomBytes_;
        public static Parser<Random> PARSER = new AbstractParser<Random>() { // from class: com.baidu.swan.games.bdtls.model.Bdtls.Random.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: o */
            public Random parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Random(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Random defaultInstance = new Random(true);

        private Random(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Random(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Random getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Random getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Random(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.gMTUnixTime_ = codedInputStream.readInt32();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.randomBytes_ = codedInputStream.readBytes();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Random> getParserForType() {
            return PARSER;
        }

        public boolean hasGMTUnixTime() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getGMTUnixTime() {
            return this.gMTUnixTime_;
        }

        public boolean hasRandomBytes() {
            return (this.bitField0_ & 2) == 2;
        }

        public ByteString getRandomBytes() {
            return this.randomBytes_;
        }

        private void initFields() {
            this.gMTUnixTime_ = 0;
            this.randomBytes_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.gMTUnixTime_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, this.randomBytes_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Random parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Random parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Random parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Random parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Random parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Random parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Random parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Random parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Random parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Random parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.amj();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(Random random) {
            return newBuilder().mergeFrom(random);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes11.dex */
        public static final class a extends GeneratedMessageLite.Builder<Random, a> implements d {
            private int bitField0_;
            private int gMTUnixTime_;
            private ByteString randomBytes_ = ByteString.EMPTY;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a amj() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: amk */
            public a clear() {
                super.clear();
                this.gMTUnixTime_ = 0;
                this.bitField0_ &= -2;
                this.randomBytes_ = ByteString.EMPTY;
                this.bitField0_ &= -3;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: aml */
            public a clone() {
                return amj().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Random getDefaultInstanceForType() {
                return Random.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: amm */
            public Random build() {
                Random buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: amn */
            public Random buildPartial() {
                Random random = new Random(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                random.gMTUnixTime_ = this.gMTUnixTime_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                random.randomBytes_ = this.randomBytes_;
                random.bitField0_ = i2;
                return random;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c */
            public a mergeFrom(Random random) {
                if (random != Random.getDefaultInstance()) {
                    if (random.hasGMTUnixTime()) {
                        hK(random.getGMTUnixTime());
                    }
                    if (random.hasRandomBytes()) {
                        g(random.getRandomBytes());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasGMTUnixTime() && hasRandomBytes();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: p */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Random random;
                Throwable th;
                try {
                    try {
                        Random parsePartialFrom = Random.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        random = null;
                        if (random != null) {
                            mergeFrom(random);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Random random2 = (Random) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        random = random2;
                        th = th3;
                        if (random != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasGMTUnixTime() {
                return (this.bitField0_ & 1) == 1;
            }

            public a hK(int i) {
                this.bitField0_ |= 1;
                this.gMTUnixTime_ = i;
                return this;
            }

            public boolean hasRandomBytes() {
                return (this.bitField0_ & 2) == 2;
            }

            public a g(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.randomBytes_ = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class Extension extends GeneratedMessageLite implements a {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private ByteString data_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int type_;
        public static Parser<Extension> PARSER = new AbstractParser<Extension>() { // from class: com.baidu.swan.games.bdtls.model.Bdtls.Extension.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: m */
            public Extension parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Extension(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Extension defaultInstance = new Extension(true);

        private Extension(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Extension(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Extension getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Extension getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Extension(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.type_ = codedInputStream.readUInt32();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.data_ = codedInputStream.readBytes();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Extension> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public ByteString getData() {
            return this.data_;
        }

        private void initFields() {
            this.type_ = 0;
            this.data_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.type_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, this.data_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Extension parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Extension parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Extension parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Extension parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Extension parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Extension parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Extension parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Extension parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Extension parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Extension parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.amd();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(Extension extension) {
            return newBuilder().mergeFrom(extension);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes11.dex */
        public static final class a extends GeneratedMessageLite.Builder<Extension, a> implements a {
            private int bitField0_;
            private ByteString data_ = ByteString.EMPTY;
            private int type_;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a amd() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: ame */
            public a clear() {
                super.clear();
                this.type_ = 0;
                this.bitField0_ &= -2;
                this.data_ = ByteString.EMPTY;
                this.bitField0_ &= -3;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: amf */
            public a clone() {
                return amd().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Extension getDefaultInstanceForType() {
                return Extension.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: amg */
            public Extension build() {
                Extension buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: amh */
            public Extension buildPartial() {
                Extension extension = new Extension(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                extension.type_ = this.type_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                extension.data_ = this.data_;
                extension.bitField0_ = i2;
                return extension;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: b */
            public a mergeFrom(Extension extension) {
                if (extension != Extension.getDefaultInstance()) {
                    if (extension.hasType()) {
                        hJ(extension.getType());
                    }
                    if (extension.hasData()) {
                        f(extension.getData());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasType() && hasData();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: n */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Extension extension;
                Throwable th;
                try {
                    try {
                        Extension parsePartialFrom = Extension.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        extension = null;
                        if (extension != null) {
                            mergeFrom(extension);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Extension extension2 = (Extension) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        extension = extension2;
                        th = th3;
                        if (extension != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasType() {
                return (this.bitField0_ & 1) == 1;
            }

            public a hJ(int i) {
                this.bitField0_ |= 1;
                this.type_ = i;
                return this;
            }

            public boolean hasData() {
                return (this.bitField0_ & 2) == 2;
            }

            public a f(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.data_ = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class ClientHello extends GeneratedMessageLite implements c {
        public static final int CIPHERSUITES_FIELD_NUMBER = 2;
        public static final int EXTENSIONS_FIELD_NUMBER = 3;
        public static final int RANDOM_FIELD_NUMBER = 1;
        public static final int SKR_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<ByteString> cipherSuites_;
        private List<Extension> extensions_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Random random_;
        private ByteString sKR_;
        public static Parser<ClientHello> PARSER = new AbstractParser<ClientHello>() { // from class: com.baidu.swan.games.bdtls.model.Bdtls.ClientHello.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: k */
            public ClientHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ClientHello(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ClientHello defaultInstance = new ClientHello(true);

        private ClientHello(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ClientHello(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ClientHello getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public ClientHello getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.List<com.baidu.swan.games.bdtls.model.Bdtls$Extension> */
        /* JADX WARN: Multi-variable type inference failed */
        private ClientHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Random.a aVar;
            boolean z5 = false;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z6 = false;
            while (!z5) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z3 = true;
                                z2 = z6;
                                continue;
                                z6 = z2;
                                z5 = z3;
                            case 10:
                                if ((this.bitField0_ & 1) != 1) {
                                    aVar = null;
                                } else {
                                    aVar = this.random_.toBuilder();
                                }
                                this.random_ = (Random) codedInputStream.readMessage(Random.PARSER, extensionRegistryLite);
                                if (aVar != null) {
                                    aVar.mergeFrom(this.random_);
                                    this.random_ = aVar.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                z3 = z5;
                                z2 = z6;
                                continue;
                                z6 = z2;
                                z5 = z3;
                            case 18:
                                if (!(z6 & true)) {
                                    this.cipherSuites_ = new ArrayList();
                                    z4 = z6 | true;
                                } else {
                                    z4 = z6;
                                }
                                try {
                                    this.cipherSuites_.add(codedInputStream.readBytes());
                                    boolean z7 = z5;
                                    z2 = z4;
                                    z3 = z7;
                                    continue;
                                    z6 = z2;
                                    z5 = z3;
                                } catch (InvalidProtocolBufferException e) {
                                    e = e;
                                    throw e.setUnfinishedMessage(this);
                                } catch (IOException e2) {
                                    e = e2;
                                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                                } catch (Throwable th) {
                                    z6 = z4;
                                    th = th;
                                    if (z6 & true) {
                                        this.cipherSuites_ = Collections.unmodifiableList(this.cipherSuites_);
                                    }
                                    if (z6 & true) {
                                        this.extensions_ = Collections.unmodifiableList(this.extensions_);
                                    }
                                    makeExtensionsImmutable();
                                    throw th;
                                }
                            case 26:
                                if (!(z6 & true)) {
                                    this.extensions_ = new ArrayList();
                                    z = z6 | true;
                                } else {
                                    z = z6;
                                }
                                this.extensions_.add(codedInputStream.readMessage(Extension.PARSER, extensionRegistryLite));
                                boolean z8 = z5;
                                z2 = z;
                                z3 = z8;
                                continue;
                                z6 = z2;
                                z5 = z3;
                            case 34:
                                this.bitField0_ |= 2;
                                this.sKR_ = codedInputStream.readBytes();
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z3 = true;
                                    z2 = z6;
                                    continue;
                                    z6 = z2;
                                    z5 = z3;
                                }
                                break;
                        }
                        z3 = z5;
                        z2 = z6;
                        z6 = z2;
                        z5 = z3;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (InvalidProtocolBufferException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            }
            if (z6 & true) {
                this.cipherSuites_ = Collections.unmodifiableList(this.cipherSuites_);
            }
            if (z6 & true) {
                this.extensions_ = Collections.unmodifiableList(this.extensions_);
            }
            makeExtensionsImmutable();
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ClientHello> getParserForType() {
            return PARSER;
        }

        public boolean hasRandom() {
            return (this.bitField0_ & 1) == 1;
        }

        public Random getRandom() {
            return this.random_;
        }

        public List<ByteString> getCipherSuitesList() {
            return this.cipherSuites_;
        }

        public int getCipherSuitesCount() {
            return this.cipherSuites_.size();
        }

        public ByteString getCipherSuites(int i) {
            return this.cipherSuites_.get(i);
        }

        public List<Extension> getExtensionsList() {
            return this.extensions_;
        }

        public List<? extends a> getExtensionsOrBuilderList() {
            return this.extensions_;
        }

        public int getExtensionsCount() {
            return this.extensions_.size();
        }

        public Extension getExtensions(int i) {
            return this.extensions_.get(i);
        }

        public a getExtensionsOrBuilder(int i) {
            return this.extensions_.get(i);
        }

        public boolean hasSKR() {
            return (this.bitField0_ & 2) == 2;
        }

        public ByteString getSKR() {
            return this.sKR_;
        }

        private void initFields() {
            this.random_ = Random.getDefaultInstance();
            this.cipherSuites_ = Collections.emptyList();
            this.extensions_ = Collections.emptyList();
            this.sKR_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
                int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.random_) + 0 : 0;
                int i3 = 0;
                for (int i4 = 0; i4 < this.cipherSuites_.size(); i4++) {
                    i3 += CodedOutputStream.computeBytesSizeNoTag(this.cipherSuites_.get(i4));
                }
                int size = computeMessageSize + i3 + (getCipherSuitesList().size() * 1);
                while (true) {
                    i2 = size;
                    if (i >= this.extensions_.size()) {
                        break;
                    }
                    size = CodedOutputStream.computeMessageSize(3, this.extensions_.get(i)) + i2;
                    i++;
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += CodedOutputStream.computeBytesSize(4, this.sKR_);
                }
                this.memoizedSerializedSize = i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ClientHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ClientHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ClientHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ClientHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ClientHello parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static ClientHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ClientHello parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ClientHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ClientHello parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ClientHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.alW();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(ClientHello clientHello) {
            return newBuilder().mergeFrom(clientHello);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes11.dex */
        public static final class a extends GeneratedMessageLite.Builder<ClientHello, a> implements c {
            private int bitField0_;
            private Random random_ = Random.getDefaultInstance();
            private List<ByteString> cipherSuites_ = Collections.emptyList();
            private List<Extension> extensions_ = Collections.emptyList();
            private ByteString sKR_ = ByteString.EMPTY;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a alW() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: alX */
            public a clear() {
                super.clear();
                this.random_ = Random.getDefaultInstance();
                this.bitField0_ &= -2;
                this.cipherSuites_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.extensions_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.sKR_ = ByteString.EMPTY;
                this.bitField0_ &= -9;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: alY */
            public a clone() {
                return alW().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public ClientHello getDefaultInstanceForType() {
                return ClientHello.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: alZ */
            public ClientHello build() {
                ClientHello buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: ama */
            public ClientHello buildPartial() {
                ClientHello clientHello = new ClientHello(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                clientHello.random_ = this.random_;
                if ((this.bitField0_ & 2) == 2) {
                    this.cipherSuites_ = Collections.unmodifiableList(this.cipherSuites_);
                    this.bitField0_ &= -3;
                }
                clientHello.cipherSuites_ = this.cipherSuites_;
                if ((this.bitField0_ & 4) == 4) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                    this.bitField0_ &= -5;
                }
                clientHello.extensions_ = this.extensions_;
                if ((i & 8) == 8) {
                    i2 |= 2;
                }
                clientHello.sKR_ = this.sKR_;
                clientHello.bitField0_ = i2;
                return clientHello;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(ClientHello clientHello) {
                if (clientHello != ClientHello.getDefaultInstance()) {
                    if (clientHello.hasRandom()) {
                        b(clientHello.getRandom());
                    }
                    if (!clientHello.cipherSuites_.isEmpty()) {
                        if (this.cipherSuites_.isEmpty()) {
                            this.cipherSuites_ = clientHello.cipherSuites_;
                            this.bitField0_ &= -3;
                        } else {
                            amb();
                            this.cipherSuites_.addAll(clientHello.cipherSuites_);
                        }
                    }
                    if (!clientHello.extensions_.isEmpty()) {
                        if (this.extensions_.isEmpty()) {
                            this.extensions_ = clientHello.extensions_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureExtensionsIsMutable();
                            this.extensions_.addAll(clientHello.extensions_);
                        }
                    }
                    if (clientHello.hasSKR()) {
                        e(clientHello.getSKR());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasRandom() && getRandom().isInitialized()) {
                    for (int i = 0; i < getExtensionsCount(); i++) {
                        if (!getExtensions(i).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: l */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ClientHello clientHello;
                Throwable th;
                try {
                    try {
                        ClientHello parsePartialFrom = ClientHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        clientHello = null;
                        if (clientHello != null) {
                            mergeFrom(clientHello);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    ClientHello clientHello2 = (ClientHello) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        clientHello = clientHello2;
                        th = th3;
                        if (clientHello != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasRandom() {
                return (this.bitField0_ & 1) == 1;
            }

            public Random getRandom() {
                return this.random_;
            }

            public a a(Random random) {
                if (random == null) {
                    throw new NullPointerException();
                }
                this.random_ = random;
                this.bitField0_ |= 1;
                return this;
            }

            public a b(Random random) {
                if ((this.bitField0_ & 1) == 1 && this.random_ != Random.getDefaultInstance()) {
                    this.random_ = Random.newBuilder(this.random_).mergeFrom(random).buildPartial();
                } else {
                    this.random_ = random;
                }
                this.bitField0_ |= 1;
                return this;
            }

            private void amb() {
                if ((this.bitField0_ & 2) != 2) {
                    this.cipherSuites_ = new ArrayList(this.cipherSuites_);
                    this.bitField0_ |= 2;
                }
            }

            public a d(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                amb();
                this.cipherSuites_.add(byteString);
                return this;
            }

            private void ensureExtensionsIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.extensions_ = new ArrayList(this.extensions_);
                    this.bitField0_ |= 4;
                }
            }

            public int getExtensionsCount() {
                return this.extensions_.size();
            }

            public Extension getExtensions(int i) {
                return this.extensions_.get(i);
            }

            public a a(Extension extension) {
                if (extension == null) {
                    throw new NullPointerException();
                }
                ensureExtensionsIsMutable();
                this.extensions_.add(extension);
                return this;
            }

            public a e(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.sKR_ = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class ServerHello extends GeneratedMessageLite implements e {
        public static final int CIPHERSUITE_FIELD_NUMBER = 2;
        public static final int EXTENSIONS_FIELD_NUMBER = 5;
        public static final int LIFETIME_FIELD_NUMBER = 3;
        public static final int RANDOM_FIELD_NUMBER = 1;
        public static final int SKR_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private ByteString cipherSuite_;
        private List<Extension> extensions_;
        private int lifeTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Random random_;
        private ByteString sKR_;
        public static Parser<ServerHello> PARSER = new AbstractParser<ServerHello>() { // from class: com.baidu.swan.games.bdtls.model.Bdtls.ServerHello.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: q */
            public ServerHello parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ServerHello(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ServerHello defaultInstance = new ServerHello(true);

        private ServerHello(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ServerHello(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ServerHello getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public ServerHello getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.util.List<com.baidu.swan.games.bdtls.model.Bdtls$Extension> */
        /* JADX WARN: Multi-variable type inference failed */
        private ServerHello(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            boolean z2;
            boolean z3;
            Random.a aVar;
            boolean z4 = false;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z5 = false;
            while (!z4) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z3 = true;
                                z2 = z5;
                                break;
                            case 10:
                                if ((this.bitField0_ & 1) != 1) {
                                    aVar = null;
                                } else {
                                    aVar = this.random_.toBuilder();
                                }
                                this.random_ = (Random) codedInputStream.readMessage(Random.PARSER, extensionRegistryLite);
                                if (aVar != null) {
                                    aVar.mergeFrom(this.random_);
                                    this.random_ = aVar.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                z3 = z4;
                                z2 = z5;
                                break;
                            case 18:
                                this.bitField0_ |= 2;
                                this.cipherSuite_ = codedInputStream.readBytes();
                                z3 = z4;
                                z2 = z5;
                                break;
                            case 24:
                                this.bitField0_ |= 4;
                                this.lifeTime_ = codedInputStream.readUInt32();
                                z3 = z4;
                                z2 = z5;
                                break;
                            case 34:
                                this.bitField0_ |= 8;
                                this.sKR_ = codedInputStream.readBytes();
                                z3 = z4;
                                z2 = z5;
                                break;
                            case 42:
                                if (!(z5 & true)) {
                                    this.extensions_ = new ArrayList();
                                    z = z5 | true;
                                } else {
                                    z = z5;
                                }
                                try {
                                    this.extensions_.add(codedInputStream.readMessage(Extension.PARSER, extensionRegistryLite));
                                    boolean z6 = z4;
                                    z2 = z;
                                    z3 = z6;
                                    break;
                                } catch (InvalidProtocolBufferException e) {
                                    e = e;
                                    throw e.setUnfinishedMessage(this);
                                } catch (IOException e2) {
                                    e = e2;
                                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                                } catch (Throwable th) {
                                    z5 = z;
                                    th = th;
                                    if (z5 & true) {
                                        this.extensions_ = Collections.unmodifiableList(this.extensions_);
                                    }
                                    makeExtensionsImmutable();
                                    throw th;
                                }
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z3 = true;
                                    z2 = z5;
                                    break;
                                } else {
                                    z3 = z4;
                                    z2 = z5;
                                    break;
                                }
                        }
                        z5 = z2;
                        z4 = z3;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (InvalidProtocolBufferException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            }
            if (z5 & true) {
                this.extensions_ = Collections.unmodifiableList(this.extensions_);
            }
            makeExtensionsImmutable();
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ServerHello> getParserForType() {
            return PARSER;
        }

        public boolean hasRandom() {
            return (this.bitField0_ & 1) == 1;
        }

        public Random getRandom() {
            return this.random_;
        }

        public boolean hasCipherSuite() {
            return (this.bitField0_ & 2) == 2;
        }

        public ByteString getCipherSuite() {
            return this.cipherSuite_;
        }

        public boolean hasLifeTime() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getLifeTime() {
            return this.lifeTime_;
        }

        public boolean hasSKR() {
            return (this.bitField0_ & 8) == 8;
        }

        public ByteString getSKR() {
            return this.sKR_;
        }

        public List<Extension> getExtensionsList() {
            return this.extensions_;
        }

        public List<? extends a> getExtensionsOrBuilderList() {
            return this.extensions_;
        }

        public int getExtensionsCount() {
            return this.extensions_.size();
        }

        public Extension getExtensions(int i) {
            return this.extensions_.get(i);
        }

        public a getExtensionsOrBuilder(int i) {
            return this.extensions_.get(i);
        }

        private void initFields() {
            this.random_ = Random.getDefaultInstance();
            this.cipherSuite_ = ByteString.EMPTY;
            this.lifeTime_ = 0;
            this.sKR_ = ByteString.EMPTY;
            this.extensions_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
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
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.extensions_.size()) {
                    codedOutputStream.writeMessage(5, this.extensions_.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 == -1) {
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
                while (true) {
                    i2 = computeMessageSize;
                    if (i >= this.extensions_.size()) {
                        break;
                    }
                    computeMessageSize = CodedOutputStream.computeMessageSize(5, this.extensions_.get(i)) + i2;
                    i++;
                }
                this.memoizedSerializedSize = i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ServerHello parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ServerHello parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ServerHello parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ServerHello parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ServerHello parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static ServerHello parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ServerHello parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ServerHello parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ServerHello parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ServerHello parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.amp();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(ServerHello serverHello) {
            return newBuilder().mergeFrom(serverHello);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes11.dex */
        public static final class a extends GeneratedMessageLite.Builder<ServerHello, a> implements e {
            private int bitField0_;
            private int lifeTime_;
            private Random random_ = Random.getDefaultInstance();
            private ByteString cipherSuite_ = ByteString.EMPTY;
            private ByteString sKR_ = ByteString.EMPTY;
            private List<Extension> extensions_ = Collections.emptyList();

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a amp() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: amq */
            public a clear() {
                super.clear();
                this.random_ = Random.getDefaultInstance();
                this.bitField0_ &= -2;
                this.cipherSuite_ = ByteString.EMPTY;
                this.bitField0_ &= -3;
                this.lifeTime_ = 0;
                this.bitField0_ &= -5;
                this.sKR_ = ByteString.EMPTY;
                this.bitField0_ &= -9;
                this.extensions_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: amr */
            public a clone() {
                return amp().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public ServerHello getDefaultInstanceForType() {
                return ServerHello.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: ams */
            public ServerHello build() {
                ServerHello buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: amt */
            public ServerHello buildPartial() {
                ServerHello serverHello = new ServerHello(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                serverHello.random_ = this.random_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                serverHello.cipherSuite_ = this.cipherSuite_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                serverHello.lifeTime_ = this.lifeTime_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                serverHello.sKR_ = this.sKR_;
                if ((this.bitField0_ & 16) == 16) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                    this.bitField0_ &= -17;
                }
                serverHello.extensions_ = this.extensions_;
                serverHello.bitField0_ = i2;
                return serverHello;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(ServerHello serverHello) {
                if (serverHello != ServerHello.getDefaultInstance()) {
                    if (serverHello.hasRandom()) {
                        d(serverHello.getRandom());
                    }
                    if (serverHello.hasCipherSuite()) {
                        h(serverHello.getCipherSuite());
                    }
                    if (serverHello.hasLifeTime()) {
                        hL(serverHello.getLifeTime());
                    }
                    if (serverHello.hasSKR()) {
                        i(serverHello.getSKR());
                    }
                    if (!serverHello.extensions_.isEmpty()) {
                        if (this.extensions_.isEmpty()) {
                            this.extensions_ = serverHello.extensions_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureExtensionsIsMutable();
                            this.extensions_.addAll(serverHello.extensions_);
                        }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasRandom() && hasCipherSuite() && hasLifeTime() && hasSKR() && getRandom().isInitialized()) {
                    for (int i = 0; i < getExtensionsCount(); i++) {
                        if (!getExtensions(i).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: r */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ServerHello serverHello;
                Throwable th;
                try {
                    try {
                        ServerHello parsePartialFrom = ServerHello.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        serverHello = null;
                        if (serverHello != null) {
                            mergeFrom(serverHello);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    ServerHello serverHello2 = (ServerHello) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        serverHello = serverHello2;
                        th = th3;
                        if (serverHello != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasRandom() {
                return (this.bitField0_ & 1) == 1;
            }

            public Random getRandom() {
                return this.random_;
            }

            public a d(Random random) {
                if ((this.bitField0_ & 1) == 1 && this.random_ != Random.getDefaultInstance()) {
                    this.random_ = Random.newBuilder(this.random_).mergeFrom(random).buildPartial();
                } else {
                    this.random_ = random;
                }
                this.bitField0_ |= 1;
                return this;
            }

            public boolean hasCipherSuite() {
                return (this.bitField0_ & 2) == 2;
            }

            public a h(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.cipherSuite_ = byteString;
                return this;
            }

            public boolean hasLifeTime() {
                return (this.bitField0_ & 4) == 4;
            }

            public a hL(int i) {
                this.bitField0_ |= 4;
                this.lifeTime_ = i;
                return this;
            }

            public boolean hasSKR() {
                return (this.bitField0_ & 8) == 8;
            }

            public a i(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.sKR_ = byteString;
                return this;
            }

            private void ensureExtensionsIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.extensions_ = new ArrayList(this.extensions_);
                    this.bitField0_ |= 16;
                }
            }

            public int getExtensionsCount() {
                return this.extensions_.size();
            }

            public Extension getExtensions(int i) {
                return this.extensions_.get(i);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class ApplicationData extends GeneratedMessageLite implements b {
        public static final int SKR_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ByteString sKR_;
        public static Parser<ApplicationData> PARSER = new AbstractParser<ApplicationData>() { // from class: com.baidu.swan.games.bdtls.model.Bdtls.ApplicationData.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: i */
            public ApplicationData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ApplicationData(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ApplicationData defaultInstance = new ApplicationData(true);

        private ApplicationData(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ApplicationData(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ApplicationData getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public ApplicationData getDefaultInstanceForType() {
            return defaultInstance;
        }

        private ApplicationData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    this.bitField0_ |= 1;
                                    this.sKR_ = codedInputStream.readBytes();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
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

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<ApplicationData> getParserForType() {
            return PARSER;
        }

        public boolean hasSKR() {
            return (this.bitField0_ & 1) == 1;
        }

        public ByteString getSKR() {
            return this.sKR_;
        }

        private void initFields() {
            this.sKR_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            } else if (!hasSKR()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, this.sKR_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, this.sKR_) : 0;
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ApplicationData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ApplicationData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ApplicationData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ApplicationData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ApplicationData parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static ApplicationData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ApplicationData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ApplicationData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ApplicationData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ApplicationData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.alQ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(ApplicationData applicationData) {
            return newBuilder().mergeFrom(applicationData);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes11.dex */
        public static final class a extends GeneratedMessageLite.Builder<ApplicationData, a> implements b {
            private int bitField0_;
            private ByteString sKR_ = ByteString.EMPTY;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a alQ() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: alR */
            public a clear() {
                super.clear();
                this.sKR_ = ByteString.EMPTY;
                this.bitField0_ &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: alS */
            public a clone() {
                return alQ().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public ApplicationData getDefaultInstanceForType() {
                return ApplicationData.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: alT */
            public ApplicationData build() {
                ApplicationData buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: alU */
            public ApplicationData buildPartial() {
                ApplicationData applicationData = new ApplicationData(this);
                int i = (this.bitField0_ & 1) != 1 ? 0 : 1;
                applicationData.sKR_ = this.sKR_;
                applicationData.bitField0_ = i;
                return applicationData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(ApplicationData applicationData) {
                if (applicationData != ApplicationData.getDefaultInstance() && applicationData.hasSKR()) {
                    c(applicationData.getSKR());
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasSKR();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: j */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ApplicationData applicationData;
                Throwable th;
                try {
                    try {
                        ApplicationData parsePartialFrom = ApplicationData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        applicationData = null;
                        if (applicationData != null) {
                            mergeFrom(applicationData);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    ApplicationData applicationData2 = (ApplicationData) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        applicationData = applicationData2;
                        th = th3;
                        if (applicationData != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasSKR() {
                return (this.bitField0_ & 1) == 1;
            }

            public a c(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.sKR_ = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class Alert extends GeneratedMessageLite implements com.baidu.swan.games.bdtls.model.a {
        public static final int DESCRIPTION_FIELD_NUMBER = 2;
        public static final int LEVEL_FIELD_NUMBER = 1;
        public static Parser<Alert> PARSER = new AbstractParser<Alert>() { // from class: com.baidu.swan.games.bdtls.model.Bdtls.Alert.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: g */
            public Alert parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Alert(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Alert defaultInstance = new Alert(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private ByteString description_;
        private int level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private Alert(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Alert(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Alert getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Alert getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Alert(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.level_ = codedInputStream.readUInt32();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.description_ = codedInputStream.readBytes();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Alert> getParserForType() {
            return PARSER;
        }

        public boolean hasLevel() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getLevel() {
            return this.level_;
        }

        public boolean hasDescription() {
            return (this.bitField0_ & 2) == 2;
        }

        public ByteString getDescription() {
            return this.description_;
        }

        private void initFields() {
            this.level_ = 0;
            this.description_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeUInt32Size(1, this.level_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, this.description_);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Alert parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Alert parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Alert parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Alert parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Alert parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Alert parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Alert parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Alert parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Alert parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Alert parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.alK();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(Alert alert) {
            return newBuilder().mergeFrom(alert);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes11.dex */
        public static final class a extends GeneratedMessageLite.Builder<Alert, a> implements com.baidu.swan.games.bdtls.model.a {
            private int bitField0_;
            private ByteString description_ = ByteString.EMPTY;
            private int level_;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a alK() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: alL */
            public a clear() {
                super.clear();
                this.level_ = 0;
                this.bitField0_ &= -2;
                this.description_ = ByteString.EMPTY;
                this.bitField0_ &= -3;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: alM */
            public a clone() {
                return alK().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Alert getDefaultInstanceForType() {
                return Alert.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: alN */
            public Alert build() {
                Alert buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: alO */
            public Alert buildPartial() {
                Alert alert = new Alert(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                alert.level_ = this.level_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                alert.description_ = this.description_;
                alert.bitField0_ = i2;
                return alert;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(Alert alert) {
                if (alert != Alert.getDefaultInstance()) {
                    if (alert.hasLevel()) {
                        hI(alert.getLevel());
                    }
                    if (alert.hasDescription()) {
                        b(alert.getDescription());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasLevel() && hasDescription();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: h */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Alert alert;
                Throwable th;
                try {
                    try {
                        Alert parsePartialFrom = Alert.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        alert = null;
                        if (alert != null) {
                            mergeFrom(alert);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Alert alert2 = (Alert) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        alert = alert2;
                        th = th3;
                        if (alert != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasLevel() {
                return (this.bitField0_ & 1) == 1;
            }

            public a hI(int i) {
                this.bitField0_ |= 1;
                this.level_ = i;
                return this;
            }

            public boolean hasDescription() {
                return (this.bitField0_ & 2) == 2;
            }

            public a b(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.description_ = byteString;
                return this;
            }
        }
    }
}
