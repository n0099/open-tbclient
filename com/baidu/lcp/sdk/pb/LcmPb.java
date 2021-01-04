package com.baidu.lcp.sdk.pb;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes3.dex */
public final class LcmPb {

    /* loaded from: classes3.dex */
    public static final class Common extends GeneratedMessageLite implements com.baidu.lcp.sdk.pb.a {
        public static final int APP_ID_FIELD_NUMBER = 6;
        public static final int APP_VERSION_FIELD_NUMBER = 7;
        public static final int CUID_FIELD_NUMBER = 1;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
        public static final int MANUFACTURE_FIELD_NUMBER = 4;
        public static final int MODEL_TYPE_FIELD_NUMBER = 5;
        public static final int NETWORK_FIELD_NUMBER = 9;
        public static final int OS_VERSION_FIELD_NUMBER = 3;
        public static final int ROM_VERSION_FIELD_NUMBER = 10;
        public static final int SDK_VERSION_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private Object appId_;
        private Object appVersion_;
        private int bitField0_;
        private Object cuid_;
        private Object deviceType_;
        private Object manufacture_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object modelType_;
        private Object network_;
        private Object osVersion_;
        private Object romVersion_;
        private Object sdkVersion_;
        public static Parser<Common> PARSER = new AbstractParser<Common>() { // from class: com.baidu.lcp.sdk.pb.LcmPb.Common.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: b */
            public Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Common(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Common defaultInstance = new Common(true);

        private Common(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Common(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Common getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Common getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.cuid_ = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0_ |= 2;
                                    this.deviceType_ = codedInputStream.readBytes();
                                    break;
                                case 26:
                                    this.bitField0_ |= 4;
                                    this.osVersion_ = codedInputStream.readBytes();
                                    break;
                                case 34:
                                    this.bitField0_ |= 8;
                                    this.manufacture_ = codedInputStream.readBytes();
                                    break;
                                case 42:
                                    this.bitField0_ |= 16;
                                    this.modelType_ = codedInputStream.readBytes();
                                    break;
                                case 50:
                                    this.bitField0_ |= 32;
                                    this.appId_ = codedInputStream.readBytes();
                                    break;
                                case 58:
                                    this.bitField0_ |= 64;
                                    this.appVersion_ = codedInputStream.readBytes();
                                    break;
                                case 66:
                                    this.bitField0_ |= 128;
                                    this.sdkVersion_ = codedInputStream.readBytes();
                                    break;
                                case 74:
                                    this.bitField0_ |= 256;
                                    this.network_ = codedInputStream.readBytes();
                                    break;
                                case 82:
                                    this.bitField0_ |= 512;
                                    this.romVersion_ = codedInputStream.readBytes();
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
        public Parser<Common> getParserForType() {
            return PARSER;
        }

        public boolean hasCuid() {
            return (this.bitField0_ & 1) == 1;
        }

        public String getCuid() {
            Object obj = this.cuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.cuid_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCuidBytes() {
            Object obj = this.cuid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cuid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasDeviceType() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getDeviceType() {
            Object obj = this.deviceType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.deviceType_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getDeviceTypeBytes() {
            Object obj = this.deviceType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasOsVersion() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getOsVersion() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.osVersion_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getOsVersionBytes() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.osVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasManufacture() {
            return (this.bitField0_ & 8) == 8;
        }

        public String getManufacture() {
            Object obj = this.manufacture_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.manufacture_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getManufactureBytes() {
            Object obj = this.manufacture_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.manufacture_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasModelType() {
            return (this.bitField0_ & 16) == 16;
        }

        public String getModelType() {
            Object obj = this.modelType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.modelType_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getModelTypeBytes() {
            Object obj = this.modelType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.modelType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasAppId() {
            return (this.bitField0_ & 32) == 32;
        }

        public String getAppId() {
            Object obj = this.appId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appId_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAppIdBytes() {
            Object obj = this.appId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasAppVersion() {
            return (this.bitField0_ & 64) == 64;
        }

        public String getAppVersion() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appVersion_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasSdkVersion() {
            return (this.bitField0_ & 128) == 128;
        }

        public String getSdkVersion() {
            Object obj = this.sdkVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.sdkVersion_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSdkVersionBytes() {
            Object obj = this.sdkVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sdkVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasNetwork() {
            return (this.bitField0_ & 256) == 256;
        }

        public String getNetwork() {
            Object obj = this.network_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.network_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getNetworkBytes() {
            Object obj = this.network_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.network_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasRomVersion() {
            return (this.bitField0_ & 512) == 512;
        }

        public String getRomVersion() {
            Object obj = this.romVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.romVersion_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getRomVersionBytes() {
            Object obj = this.romVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.romVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void initFields() {
            this.cuid_ = "";
            this.deviceType_ = "";
            this.osVersion_ = "";
            this.manufacture_ = "";
            this.modelType_ = "";
            this.appId_ = "";
            this.appVersion_ = "";
            this.sdkVersion_ = "";
            this.network_ = "";
            this.romVersion_ = "";
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, getCuidBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getDeviceTypeBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getOsVersionBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getManufactureBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getModelTypeBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getAppIdBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBytes(7, getAppVersionBytes());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeBytes(8, getSdkVersionBytes());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeBytes(9, getNetworkBytes());
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeBytes(10, getRomVersionBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getCuidBytes()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getDeviceTypeBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getOsVersionBytes());
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getManufactureBytes());
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getModelTypeBytes());
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getAppIdBytes());
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeBytesSize(7, getAppVersionBytes());
                }
                if ((this.bitField0_ & 128) == 128) {
                    i += CodedOutputStream.computeBytesSize(8, getSdkVersionBytes());
                }
                if ((this.bitField0_ & 256) == 256) {
                    i += CodedOutputStream.computeBytesSize(9, getNetworkBytes());
                }
                if ((this.bitField0_ & 512) == 512) {
                    i += CodedOutputStream.computeBytesSize(10, getRomVersionBytes());
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

        public static Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Common parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Common parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.zP();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(Common common2) {
            return newBuilder().mergeFrom(common2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<Common, a> implements com.baidu.lcp.sdk.pb.a {
            private int bitField0_;
            private Object cuid_ = "";
            private Object deviceType_ = "";
            private Object osVersion_ = "";
            private Object manufacture_ = "";
            private Object modelType_ = "";
            private Object appId_ = "";
            private Object appVersion_ = "";
            private Object sdkVersion_ = "";
            private Object network_ = "";
            private Object romVersion_ = "";

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a zP() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: zQ */
            public a clear() {
                super.clear();
                this.cuid_ = "";
                this.bitField0_ &= -2;
                this.deviceType_ = "";
                this.bitField0_ &= -3;
                this.osVersion_ = "";
                this.bitField0_ &= -5;
                this.manufacture_ = "";
                this.bitField0_ &= -9;
                this.modelType_ = "";
                this.bitField0_ &= -17;
                this.appId_ = "";
                this.bitField0_ &= -33;
                this.appVersion_ = "";
                this.bitField0_ &= -65;
                this.sdkVersion_ = "";
                this.bitField0_ &= -129;
                this.network_ = "";
                this.bitField0_ &= -257;
                this.romVersion_ = "";
                this.bitField0_ &= -513;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: zR */
            public a clone() {
                return zP().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Common getDefaultInstanceForType() {
                return Common.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: zS */
            public Common build() {
                Common buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: zT */
            public Common buildPartial() {
                Common common2 = new Common(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                common2.cuid_ = this.cuid_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                common2.deviceType_ = this.deviceType_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                common2.osVersion_ = this.osVersion_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                common2.manufacture_ = this.manufacture_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                common2.modelType_ = this.modelType_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                common2.appId_ = this.appId_;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                common2.appVersion_ = this.appVersion_;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                common2.sdkVersion_ = this.sdkVersion_;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                common2.network_ = this.network_;
                if ((i & 512) == 512) {
                    i2 |= 512;
                }
                common2.romVersion_ = this.romVersion_;
                common2.bitField0_ = i2;
                return common2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(Common common2) {
                if (common2 != Common.getDefaultInstance()) {
                    if (common2.hasCuid()) {
                        this.bitField0_ |= 1;
                        this.cuid_ = common2.cuid_;
                    }
                    if (common2.hasDeviceType()) {
                        this.bitField0_ |= 2;
                        this.deviceType_ = common2.deviceType_;
                    }
                    if (common2.hasOsVersion()) {
                        this.bitField0_ |= 4;
                        this.osVersion_ = common2.osVersion_;
                    }
                    if (common2.hasManufacture()) {
                        this.bitField0_ |= 8;
                        this.manufacture_ = common2.manufacture_;
                    }
                    if (common2.hasModelType()) {
                        this.bitField0_ |= 16;
                        this.modelType_ = common2.modelType_;
                    }
                    if (common2.hasAppId()) {
                        this.bitField0_ |= 32;
                        this.appId_ = common2.appId_;
                    }
                    if (common2.hasAppVersion()) {
                        this.bitField0_ |= 64;
                        this.appVersion_ = common2.appVersion_;
                    }
                    if (common2.hasSdkVersion()) {
                        this.bitField0_ |= 128;
                        this.sdkVersion_ = common2.sdkVersion_;
                    }
                    if (common2.hasNetwork()) {
                        this.bitField0_ |= 256;
                        this.network_ = common2.network_;
                    }
                    if (common2.hasRomVersion()) {
                        this.bitField0_ |= 512;
                        this.romVersion_ = common2.romVersion_;
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: c */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Common common2 = null;
                try {
                    try {
                        Common parsePartialFrom = Common.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (common2 != null) {
                            mergeFrom(common2);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Common common3 = (Common) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        common2 = common3;
                        if (common2 != null) {
                        }
                        throw th;
                    }
                }
            }

            public a fw(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.cuid_ = str;
                return this;
            }

            public a fx(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.deviceType_ = str;
                return this;
            }

            public a fy(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.osVersion_ = str;
                return this;
            }

            public a fz(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.manufacture_ = str;
                return this;
            }

            public a fA(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.modelType_ = str;
                return this;
            }

            public a fB(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.appId_ = str;
                return this;
            }

            public a fC(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.appVersion_ = str;
                return this;
            }

            public a fD(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 128;
                this.sdkVersion_ = str;
                return this;
            }

            public a fE(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 256;
                this.network_ = str;
                return this;
            }

            public a fF(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 512;
                this.romVersion_ = str;
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class LcmRequest extends GeneratedMessageLite implements c {
        public static final int ACTION_FIELD_NUMBER = 5;
        public static final int COMMON_FIELD_NUMBER = 3;
        public static final int CONN_TYPE_FIELD_NUMBER = 7;
        public static final int LOG_ID_FIELD_NUMBER = 1;
        public static final int START_TYPE_FIELD_NUMBER = 6;
        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        public static final int TOKEN_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int action_;
        private int bitField0_;
        private Common common_;
        private int connType_;
        private long logId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int startType_;
        private long timestamp_;
        private Object token_;
        public static Parser<LcmRequest> PARSER = new AbstractParser<LcmRequest>() { // from class: com.baidu.lcp.sdk.pb.LcmPb.LcmRequest.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: f */
            public LcmRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LcmRequest(codedInputStream, extensionRegistryLite);
            }
        };
        private static final LcmRequest defaultInstance = new LcmRequest(true);

        private LcmRequest(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LcmRequest(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LcmRequest getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LcmRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        private LcmRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            Common.a aVar;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                continue;
                                z2 = z;
                            case 8:
                                this.bitField0_ |= 1;
                                this.logId_ = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 18:
                                this.bitField0_ |= 2;
                                this.token_ = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 26:
                                if ((this.bitField0_ & 4) != 4) {
                                    aVar = null;
                                } else {
                                    aVar = this.common_.toBuilder();
                                }
                                this.common_ = (Common) codedInputStream.readMessage(Common.PARSER, extensionRegistryLite);
                                if (aVar != null) {
                                    aVar.mergeFrom(this.common_);
                                    this.common_ = aVar.buildPartial();
                                }
                                this.bitField0_ |= 4;
                                z = z2;
                                continue;
                                z2 = z;
                            case 32:
                                this.bitField0_ |= 8;
                                this.timestamp_ = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 40:
                                this.bitField0_ |= 16;
                                this.action_ = codedInputStream.readInt32();
                                z = z2;
                                continue;
                                z2 = z;
                            case 48:
                                this.bitField0_ |= 32;
                                this.startType_ = codedInputStream.readInt32();
                                z = z2;
                                continue;
                                z2 = z;
                            case 56:
                                this.bitField0_ |= 64;
                                this.connType_ = codedInputStream.readInt32();
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    continue;
                                    z2 = z;
                                }
                                break;
                        }
                        z = z2;
                        z2 = z;
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

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LcmRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasLogId() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getLogId() {
            return this.logId_;
        }

        public boolean hasToken() {
            return (this.bitField0_ & 2) == 2;
        }

        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.token_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getTokenBytes() {
            Object obj = this.token_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasCommon() {
            return (this.bitField0_ & 4) == 4;
        }

        public Common getCommon() {
            return this.common_;
        }

        public boolean hasTimestamp() {
            return (this.bitField0_ & 8) == 8;
        }

        public long getTimestamp() {
            return this.timestamp_;
        }

        public boolean hasAction() {
            return (this.bitField0_ & 16) == 16;
        }

        public int getAction() {
            return this.action_;
        }

        public boolean hasStartType() {
            return (this.bitField0_ & 32) == 32;
        }

        public int getStartType() {
            return this.startType_;
        }

        public boolean hasConnType() {
            return (this.bitField0_ & 64) == 64;
        }

        public int getConnType() {
            return this.connType_;
        }

        private void initFields() {
            this.logId_ = 0L;
            this.token_ = "";
            this.common_ = Common.getDefaultInstance();
            this.timestamp_ = 0L;
            this.action_ = 0;
            this.startType_ = 0;
            this.connType_ = 0;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!hasLogId()) {
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
                codedOutputStream.writeInt64(1, this.logId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getTokenBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.common_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.timestamp_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.action_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.startType_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(7, this.connType_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.logId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getTokenBytes());
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.common_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.timestamp_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(5, this.action_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    i += CodedOutputStream.computeInt32Size(6, this.startType_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    i += CodedOutputStream.computeInt32Size(7, this.connType_);
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

        public static LcmRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LcmRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LcmRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LcmRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LcmRequest parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static LcmRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LcmRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LcmRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LcmRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LcmRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.Ab();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(LcmRequest lcmRequest) {
            return newBuilder().mergeFrom(lcmRequest);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<LcmRequest, a> implements c {
            private int action_;
            private int bitField0_;
            private int connType_;
            private long logId_;
            private int startType_;
            private long timestamp_;
            private Object token_ = "";
            private Common common_ = Common.getDefaultInstance();

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a Ab() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: Ac */
            public a clear() {
                super.clear();
                this.logId_ = 0L;
                this.bitField0_ &= -2;
                this.token_ = "";
                this.bitField0_ &= -3;
                this.common_ = Common.getDefaultInstance();
                this.bitField0_ &= -5;
                this.timestamp_ = 0L;
                this.bitField0_ &= -9;
                this.action_ = 0;
                this.bitField0_ &= -17;
                this.startType_ = 0;
                this.bitField0_ &= -33;
                this.connType_ = 0;
                this.bitField0_ &= -65;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: Ad */
            public a clone() {
                return Ab().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LcmRequest getDefaultInstanceForType() {
                return LcmRequest.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: Ae */
            public LcmRequest build() {
                LcmRequest buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: Af */
            public LcmRequest buildPartial() {
                LcmRequest lcmRequest = new LcmRequest(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                lcmRequest.logId_ = this.logId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                lcmRequest.token_ = this.token_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                lcmRequest.common_ = this.common_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                lcmRequest.timestamp_ = this.timestamp_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                lcmRequest.action_ = this.action_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                lcmRequest.startType_ = this.startType_;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                lcmRequest.connType_ = this.connType_;
                lcmRequest.bitField0_ = i2;
                return lcmRequest;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(LcmRequest lcmRequest) {
                if (lcmRequest != LcmRequest.getDefaultInstance()) {
                    if (lcmRequest.hasLogId()) {
                        ac(lcmRequest.getLogId());
                    }
                    if (lcmRequest.hasToken()) {
                        this.bitField0_ |= 2;
                        this.token_ = lcmRequest.token_;
                    }
                    if (lcmRequest.hasCommon()) {
                        c(lcmRequest.getCommon());
                    }
                    if (lcmRequest.hasTimestamp()) {
                        ad(lcmRequest.getTimestamp());
                    }
                    if (lcmRequest.hasAction()) {
                        dx(lcmRequest.getAction());
                    }
                    if (lcmRequest.hasStartType()) {
                        dy(lcmRequest.getStartType());
                    }
                    if (lcmRequest.hasConnType()) {
                        dz(lcmRequest.getConnType());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasLogId();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: g */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LcmRequest lcmRequest = null;
                try {
                    try {
                        LcmRequest parsePartialFrom = LcmRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (lcmRequest != null) {
                            mergeFrom(lcmRequest);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    LcmRequest lcmRequest2 = (LcmRequest) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        lcmRequest = lcmRequest2;
                        if (lcmRequest != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasLogId() {
                return (this.bitField0_ & 1) == 1;
            }

            public a ac(long j) {
                this.bitField0_ |= 1;
                this.logId_ = j;
                return this;
            }

            public a fG(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.token_ = str;
                return this;
            }

            public a b(Common common2) {
                if (common2 == null) {
                    throw new NullPointerException();
                }
                this.common_ = common2;
                this.bitField0_ |= 4;
                return this;
            }

            public a c(Common common2) {
                if ((this.bitField0_ & 4) == 4 && this.common_ != Common.getDefaultInstance()) {
                    this.common_ = Common.newBuilder(this.common_).mergeFrom(common2).buildPartial();
                } else {
                    this.common_ = common2;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public a ad(long j) {
                this.bitField0_ |= 8;
                this.timestamp_ = j;
                return this;
            }

            public a dx(int i) {
                this.bitField0_ |= 16;
                this.action_ = i;
                return this;
            }

            public a dy(int i) {
                this.bitField0_ |= 32;
                this.startType_ = i;
                return this;
            }

            public a dz(int i) {
                this.bitField0_ |= 64;
                this.connType_ = i;
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class LcmResponse extends GeneratedMessageLite implements d {
        public static final int ERROR_CODE_FIELD_NUMBER = 2;
        public static final int ERROR_MSG_FIELD_NUMBER = 3;
        public static final int LOG_ID_FIELD_NUMBER = 1;
        public static final int NEXT_INTERVAL_MS_FIELD_NUMBER = 4;
        public static Parser<LcmResponse> PARSER = new AbstractParser<LcmResponse>() { // from class: com.baidu.lcp.sdk.pb.LcmPb.LcmResponse.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: h */
            public LcmResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LcmResponse(codedInputStream, extensionRegistryLite);
            }
        };
        private static final LcmResponse defaultInstance = new LcmResponse(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errorCode_;
        private Object errorMsg_;
        private long logId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long nextIntervalMs_;

        private LcmResponse(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LcmResponse(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LcmResponse getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LcmResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        private LcmResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.logId_ = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.errorCode_ = codedInputStream.readInt32();
                                    break;
                                case 26:
                                    this.bitField0_ |= 4;
                                    this.errorMsg_ = codedInputStream.readBytes();
                                    break;
                                case 32:
                                    this.bitField0_ |= 8;
                                    this.nextIntervalMs_ = codedInputStream.readInt64();
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
        public Parser<LcmResponse> getParserForType() {
            return PARSER;
        }

        public boolean hasLogId() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getLogId() {
            return this.logId_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public boolean hasErrorMsg() {
            return (this.bitField0_ & 4) == 4;
        }

        public String getErrorMsg() {
            Object obj = this.errorMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.errorMsg_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getErrorMsgBytes() {
            Object obj = this.errorMsg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errorMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasNextIntervalMs() {
            return (this.bitField0_ & 8) == 8;
        }

        public long getNextIntervalMs() {
            return this.nextIntervalMs_;
        }

        private void initFields() {
            this.logId_ = 0L;
            this.errorCode_ = 0;
            this.errorMsg_ = "";
            this.nextIntervalMs_ = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!hasLogId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasErrorCode()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasErrorMsg()) {
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
                codedOutputStream.writeInt64(1, this.logId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.errorCode_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getErrorMsgBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.nextIntervalMs_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.logId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.errorCode_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getErrorMsgBytes());
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.nextIntervalMs_);
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

        public static LcmResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LcmResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LcmResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LcmResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LcmResponse parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static LcmResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LcmResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LcmResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LcmResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LcmResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.Ah();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(LcmResponse lcmResponse) {
            return newBuilder().mergeFrom(lcmResponse);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<LcmResponse, a> implements d {
            private int bitField0_;
            private int errorCode_;
            private Object errorMsg_ = "";
            private long logId_;
            private long nextIntervalMs_;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a Ah() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: Ai */
            public a clear() {
                super.clear();
                this.logId_ = 0L;
                this.bitField0_ &= -2;
                this.errorCode_ = 0;
                this.bitField0_ &= -3;
                this.errorMsg_ = "";
                this.bitField0_ &= -5;
                this.nextIntervalMs_ = 0L;
                this.bitField0_ &= -9;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: Aj */
            public a clone() {
                return Ah().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LcmResponse getDefaultInstanceForType() {
                return LcmResponse.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: Ak */
            public LcmResponse build() {
                LcmResponse buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: Al */
            public LcmResponse buildPartial() {
                LcmResponse lcmResponse = new LcmResponse(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                lcmResponse.logId_ = this.logId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                lcmResponse.errorCode_ = this.errorCode_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                lcmResponse.errorMsg_ = this.errorMsg_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                lcmResponse.nextIntervalMs_ = this.nextIntervalMs_;
                lcmResponse.bitField0_ = i2;
                return lcmResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(LcmResponse lcmResponse) {
                if (lcmResponse != LcmResponse.getDefaultInstance()) {
                    if (lcmResponse.hasLogId()) {
                        ae(lcmResponse.getLogId());
                    }
                    if (lcmResponse.hasErrorCode()) {
                        dA(lcmResponse.getErrorCode());
                    }
                    if (lcmResponse.hasErrorMsg()) {
                        this.bitField0_ |= 4;
                        this.errorMsg_ = lcmResponse.errorMsg_;
                    }
                    if (lcmResponse.hasNextIntervalMs()) {
                        af(lcmResponse.getNextIntervalMs());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasLogId() && hasErrorCode() && hasErrorMsg();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: i */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LcmResponse lcmResponse = null;
                try {
                    try {
                        LcmResponse parsePartialFrom = LcmResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (lcmResponse != null) {
                            mergeFrom(lcmResponse);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    LcmResponse lcmResponse2 = (LcmResponse) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        lcmResponse = lcmResponse2;
                        if (lcmResponse != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasLogId() {
                return (this.bitField0_ & 1) == 1;
            }

            public a ae(long j) {
                this.bitField0_ |= 1;
                this.logId_ = j;
                return this;
            }

            public boolean hasErrorCode() {
                return (this.bitField0_ & 2) == 2;
            }

            public a dA(int i) {
                this.bitField0_ |= 2;
                this.errorCode_ = i;
                return this;
            }

            public boolean hasErrorMsg() {
                return (this.bitField0_ & 4) == 4;
            }

            public a af(long j) {
                this.bitField0_ |= 8;
                this.nextIntervalMs_ = j;
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class LcmNotify extends GeneratedMessageLite implements b {
        public static final int ACTION_FIELD_NUMBER = 2;
        public static final int LOG_ID_FIELD_NUMBER = 1;
        public static final Parser<LcmNotify> PARSER = new AbstractParser<LcmNotify>() { // from class: com.baidu.lcp.sdk.pb.LcmPb.LcmNotify.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: d */
            public LcmNotify parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LcmNotify(codedInputStream, extensionRegistryLite);
            }
        };
        private static final LcmNotify defaultInstance = new LcmNotify(true);
        private static final long serialVersionUID = 0;
        private int action_;
        private int bitField0_;
        private long logId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private LcmNotify(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LcmNotify(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LcmNotify getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LcmNotify getDefaultInstanceForType() {
            return defaultInstance;
        }

        private LcmNotify(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.logId_ = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.action_ = codedInputStream.readInt32();
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
        public Parser<LcmNotify> getParserForType() {
            return PARSER;
        }

        public boolean hasLogId() {
            return (this.bitField0_ & 1) == 1;
        }

        public long getLogId() {
            return this.logId_;
        }

        public boolean hasAction() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getAction() {
            return this.action_;
        }

        private void initFields() {
            this.logId_ = 0L;
            this.action_ = 0;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!hasLogId()) {
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
                codedOutputStream.writeInt64(1, this.logId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.action_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.logId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeInt32Size(2, this.action_);
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

        public static LcmNotify parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LcmNotify parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LcmNotify parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LcmNotify parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LcmNotify parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static LcmNotify parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LcmNotify parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LcmNotify parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LcmNotify parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LcmNotify parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.zV();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(LcmNotify lcmNotify) {
            return newBuilder().mergeFrom(lcmNotify);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<LcmNotify, a> implements b {
            private int action_;
            private int bitField0_;
            private long logId_;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a zV() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: zW */
            public a clear() {
                super.clear();
                this.logId_ = 0L;
                this.bitField0_ &= -2;
                this.action_ = 0;
                this.bitField0_ &= -3;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: zX */
            public a clone() {
                return zV().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LcmNotify getDefaultInstanceForType() {
                return LcmNotify.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: zY */
            public LcmNotify build() {
                LcmNotify buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: zZ */
            public LcmNotify buildPartial() {
                LcmNotify lcmNotify = new LcmNotify(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                lcmNotify.logId_ = this.logId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                lcmNotify.action_ = this.action_;
                lcmNotify.bitField0_ = i2;
                return lcmNotify;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(LcmNotify lcmNotify) {
                if (lcmNotify != LcmNotify.getDefaultInstance()) {
                    if (lcmNotify.hasLogId()) {
                        ab(lcmNotify.getLogId());
                    }
                    if (lcmNotify.hasAction()) {
                        dw(lcmNotify.getAction());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasLogId();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: e */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LcmNotify lcmNotify = null;
                try {
                    try {
                        LcmNotify parsePartialFrom = LcmNotify.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (lcmNotify != null) {
                            mergeFrom(lcmNotify);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    LcmNotify lcmNotify2 = (LcmNotify) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        lcmNotify = lcmNotify2;
                        if (lcmNotify != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasLogId() {
                return (this.bitField0_ & 1) == 1;
            }

            public a ab(long j) {
                this.bitField0_ |= 1;
                this.logId_ = j;
                return this;
            }

            public a dw(int i) {
                this.bitField0_ |= 2;
                this.action_ = i;
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class RpcData extends GeneratedMessageLite implements e {
        public static final int LCM_NOTIFY_FIELD_NUMBER = 3;
        public static final int LCM_REQUEST_FIELD_NUMBER = 1;
        public static final int LCM_RESPONSE_FIELD_NUMBER = 2;
        public static final Parser<RpcData> PARSER = new AbstractParser<RpcData>() { // from class: com.baidu.lcp.sdk.pb.LcmPb.RpcData.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: j */
            public RpcData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new RpcData(codedInputStream, extensionRegistryLite);
            }
        };
        private static final RpcData defaultInstance = new RpcData(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private LcmNotify lcmNotify_;
        private LcmRequest lcmRequest_;
        private LcmResponse lcmResponse_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private RpcData(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private RpcData(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static RpcData getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public RpcData getDefaultInstanceForType() {
            return defaultInstance;
        }

        private RpcData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 10:
                                LcmRequest.a builder = (this.bitField0_ & 1) == 1 ? this.lcmRequest_.toBuilder() : null;
                                this.lcmRequest_ = (LcmRequest) codedInputStream.readMessage(LcmRequest.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.lcmRequest_);
                                    this.lcmRequest_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                                z = z2;
                                break;
                            case 18:
                                LcmResponse.a builder2 = (this.bitField0_ & 2) == 2 ? this.lcmResponse_.toBuilder() : null;
                                this.lcmResponse_ = (LcmResponse) codedInputStream.readMessage(LcmResponse.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.lcmResponse_);
                                    this.lcmResponse_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                                z = z2;
                                break;
                            case 26:
                                LcmNotify.a builder3 = (this.bitField0_ & 4) == 4 ? this.lcmNotify_.toBuilder() : null;
                                this.lcmNotify_ = (LcmNotify) codedInputStream.readMessage(LcmNotify.PARSER, extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.lcmNotify_);
                                    this.lcmNotify_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                                z = z2;
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    break;
                                } else {
                                    z = z2;
                                    break;
                                }
                        }
                        z2 = z;
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

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<RpcData> getParserForType() {
            return PARSER;
        }

        public boolean hasLcmRequest() {
            return (this.bitField0_ & 1) == 1;
        }

        public LcmRequest getLcmRequest() {
            return this.lcmRequest_;
        }

        public boolean hasLcmResponse() {
            return (this.bitField0_ & 2) == 2;
        }

        public LcmResponse getLcmResponse() {
            return this.lcmResponse_;
        }

        public boolean hasLcmNotify() {
            return (this.bitField0_ & 4) == 4;
        }

        public LcmNotify getLcmNotify() {
            return this.lcmNotify_;
        }

        private void initFields() {
            this.lcmRequest_ = LcmRequest.getDefaultInstance();
            this.lcmResponse_ = LcmResponse.getDefaultInstance();
            this.lcmNotify_ = LcmNotify.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            } else if (hasLcmRequest() && !getLcmRequest().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasLcmResponse() && !getLcmResponse().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasLcmNotify() && !getLcmNotify().isInitialized()) {
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
                codedOutputStream.writeMessage(1, this.lcmRequest_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.lcmResponse_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.lcmNotify_);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.lcmRequest_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.computeMessageSize(2, this.lcmResponse_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.lcmNotify_);
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

        public static RpcData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static RpcData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static RpcData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static RpcData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static RpcData parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static RpcData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static RpcData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static RpcData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static RpcData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static RpcData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.An();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        public static a newBuilder(RpcData rpcData) {
            return newBuilder().mergeFrom(rpcData);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes3.dex */
        public static final class a extends GeneratedMessageLite.Builder<RpcData, a> implements e {
            private int bitField0_;
            private LcmRequest lcmRequest_ = LcmRequest.getDefaultInstance();
            private LcmResponse lcmResponse_ = LcmResponse.getDefaultInstance();
            private LcmNotify lcmNotify_ = LcmNotify.getDefaultInstance();

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a An() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: Ao */
            public a clear() {
                super.clear();
                this.lcmRequest_ = LcmRequest.getDefaultInstance();
                this.bitField0_ &= -2;
                this.lcmResponse_ = LcmResponse.getDefaultInstance();
                this.bitField0_ &= -3;
                this.lcmNotify_ = LcmNotify.getDefaultInstance();
                this.bitField0_ &= -5;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: Ap */
            public a clone() {
                return An().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public RpcData getDefaultInstanceForType() {
                return RpcData.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: Aq */
            public RpcData build() {
                RpcData buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: Ar */
            public RpcData buildPartial() {
                RpcData rpcData = new RpcData(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                rpcData.lcmRequest_ = this.lcmRequest_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                rpcData.lcmResponse_ = this.lcmResponse_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                rpcData.lcmNotify_ = this.lcmNotify_;
                rpcData.bitField0_ = i2;
                return rpcData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(RpcData rpcData) {
                if (rpcData != RpcData.getDefaultInstance()) {
                    if (rpcData.hasLcmRequest()) {
                        c(rpcData.getLcmRequest());
                    }
                    if (rpcData.hasLcmResponse()) {
                        b(rpcData.getLcmResponse());
                    }
                    if (rpcData.hasLcmNotify()) {
                        c(rpcData.getLcmNotify());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (!hasLcmRequest() || getLcmRequest().isInitialized()) {
                    if (!hasLcmResponse() || getLcmResponse().isInitialized()) {
                        return !hasLcmNotify() || getLcmNotify().isInitialized();
                    }
                    return false;
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: k */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                RpcData rpcData = null;
                try {
                    try {
                        RpcData parsePartialFrom = RpcData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th) {
                        th = th;
                        if (rpcData != null) {
                            mergeFrom(rpcData);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    RpcData rpcData2 = (RpcData) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        rpcData = rpcData2;
                        if (rpcData != null) {
                        }
                        throw th;
                    }
                }
            }

            public boolean hasLcmRequest() {
                return (this.bitField0_ & 1) == 1;
            }

            public LcmRequest getLcmRequest() {
                return this.lcmRequest_;
            }

            public a b(LcmRequest lcmRequest) {
                if (lcmRequest == null) {
                    throw new NullPointerException();
                }
                this.lcmRequest_ = lcmRequest;
                this.bitField0_ |= 1;
                return this;
            }

            public a c(LcmRequest lcmRequest) {
                if ((this.bitField0_ & 1) == 1 && this.lcmRequest_ != LcmRequest.getDefaultInstance()) {
                    this.lcmRequest_ = LcmRequest.newBuilder(this.lcmRequest_).mergeFrom(lcmRequest).buildPartial();
                } else {
                    this.lcmRequest_ = lcmRequest;
                }
                this.bitField0_ |= 1;
                return this;
            }

            public boolean hasLcmResponse() {
                return (this.bitField0_ & 2) == 2;
            }

            public LcmResponse getLcmResponse() {
                return this.lcmResponse_;
            }

            public a b(LcmResponse lcmResponse) {
                if ((this.bitField0_ & 2) == 2 && this.lcmResponse_ != LcmResponse.getDefaultInstance()) {
                    this.lcmResponse_ = LcmResponse.newBuilder(this.lcmResponse_).mergeFrom(lcmResponse).buildPartial();
                } else {
                    this.lcmResponse_ = lcmResponse;
                }
                this.bitField0_ |= 2;
                return this;
            }

            public boolean hasLcmNotify() {
                return (this.bitField0_ & 4) == 4;
            }

            public LcmNotify getLcmNotify() {
                return this.lcmNotify_;
            }

            public a b(LcmNotify lcmNotify) {
                if (lcmNotify == null) {
                    throw new NullPointerException();
                }
                this.lcmNotify_ = lcmNotify;
                this.bitField0_ |= 4;
                return this;
            }

            public a c(LcmNotify lcmNotify) {
                if ((this.bitField0_ & 4) == 4 && this.lcmNotify_ != LcmNotify.getDefaultInstance()) {
                    this.lcmNotify_ = LcmNotify.newBuilder(this.lcmNotify_).mergeFrom(lcmNotify).buildPartial();
                } else {
                    this.lcmNotify_ = lcmNotify;
                }
                this.bitField0_ |= 4;
                return this;
            }
        }
    }
}
