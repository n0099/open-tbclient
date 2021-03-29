package com.baidu.lcp.sdk.pb;

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
/* loaded from: classes2.dex */
public final class LcmPb$Common extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int APP_ID_FIELD_NUMBER = 6;
    public static final int APP_VERSION_FIELD_NUMBER = 7;
    public static final int CUID_FIELD_NUMBER = 1;
    public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
    public static final int MANUFACTURE_FIELD_NUMBER = 4;
    public static final int MODEL_TYPE_FIELD_NUMBER = 5;
    public static final int NETWORK_FIELD_NUMBER = 9;
    public static final int OS_VERSION_FIELD_NUMBER = 3;
    public static Parser<LcmPb$Common> PARSER = new a();
    public static final int ROM_VERSION_FIELD_NUMBER = 10;
    public static final int SDK_VERSION_FIELD_NUMBER = 8;
    public static final LcmPb$Common defaultInstance;
    public static final long serialVersionUID = 0;
    public Object appId_;
    public Object appVersion_;
    public int bitField0_;
    public Object cuid_;
    public Object deviceType_;
    public Object manufacture_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public Object modelType_;
    public Object network_;
    public Object osVersion_;
    public Object romVersion_;
    public Object sdkVersion_;

    /* loaded from: classes2.dex */
    public static class a extends AbstractParser<LcmPb$Common> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public LcmPb$Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$Common(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$Common, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f6383e;

        /* renamed from: f  reason: collision with root package name */
        public Object f6384f = "";

        /* renamed from: g  reason: collision with root package name */
        public Object f6385g = "";

        /* renamed from: h  reason: collision with root package name */
        public Object f6386h = "";
        public Object i = "";
        public Object j = "";
        public Object k = "";
        public Object l = "";
        public Object m = "";
        public Object n = "";
        public Object o = "";

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        public b A(String str) {
            if (str != null) {
                this.f6383e |= 256;
                this.n = str;
                return this;
            }
            throw null;
        }

        public b B(String str) {
            if (str != null) {
                this.f6383e |= 4;
                this.f6386h = str;
                return this;
            }
            throw null;
        }

        public b C(String str) {
            if (str != null) {
                this.f6383e |= 512;
                this.o = str;
                return this;
            }
            throw null;
        }

        public b D(String str) {
            if (str != null) {
                this.f6383e |= 128;
                this.m = str;
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            o();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$Common build() {
            LcmPb$Common buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public LcmPb$Common buildPartial() {
            LcmPb$Common lcmPb$Common = new LcmPb$Common(this);
            int i = this.f6383e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            lcmPb$Common.cuid_ = this.f6384f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            lcmPb$Common.deviceType_ = this.f6385g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            lcmPb$Common.osVersion_ = this.f6386h;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            lcmPb$Common.manufacture_ = this.i;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            lcmPb$Common.modelType_ = this.j;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            lcmPb$Common.appId_ = this.k;
            if ((i & 64) == 64) {
                i2 |= 64;
            }
            lcmPb$Common.appVersion_ = this.l;
            if ((i & 128) == 128) {
                i2 |= 128;
            }
            lcmPb$Common.sdkVersion_ = this.m;
            if ((i & 256) == 256) {
                i2 |= 256;
            }
            lcmPb$Common.network_ = this.n;
            if ((i & 512) == 512) {
                i2 |= 512;
            }
            lcmPb$Common.romVersion_ = this.o;
            lcmPb$Common.bitField0_ = i2;
            return lcmPb$Common;
        }

        public b o() {
            super.clear();
            this.f6384f = "";
            int i = this.f6383e & (-2);
            this.f6383e = i;
            this.f6385g = "";
            int i2 = i & (-3);
            this.f6383e = i2;
            this.f6386h = "";
            int i3 = i2 & (-5);
            this.f6383e = i3;
            this.i = "";
            int i4 = i3 & (-9);
            this.f6383e = i4;
            this.j = "";
            int i5 = i4 & (-17);
            this.f6383e = i5;
            this.k = "";
            int i6 = i5 & (-33);
            this.f6383e = i6;
            this.l = "";
            int i7 = i6 & (-65);
            this.f6383e = i7;
            this.m = "";
            int i8 = i7 & (-129);
            this.f6383e = i8;
            this.n = "";
            int i9 = i8 & (-257);
            this.f6383e = i9;
            this.o = "";
            this.f6383e = i9 & (-513);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.s(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public LcmPb$Common getDefaultInstanceForType() {
            return LcmPb$Common.getDefaultInstance();
        }

        public b s(LcmPb$Common lcmPb$Common) {
            if (lcmPb$Common == LcmPb$Common.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$Common.hasCuid()) {
                this.f6383e |= 1;
                this.f6384f = lcmPb$Common.cuid_;
            }
            if (lcmPb$Common.hasDeviceType()) {
                this.f6383e |= 2;
                this.f6385g = lcmPb$Common.deviceType_;
            }
            if (lcmPb$Common.hasOsVersion()) {
                this.f6383e |= 4;
                this.f6386h = lcmPb$Common.osVersion_;
            }
            if (lcmPb$Common.hasManufacture()) {
                this.f6383e |= 8;
                this.i = lcmPb$Common.manufacture_;
            }
            if (lcmPb$Common.hasModelType()) {
                this.f6383e |= 16;
                this.j = lcmPb$Common.modelType_;
            }
            if (lcmPb$Common.hasAppId()) {
                this.f6383e |= 32;
                this.k = lcmPb$Common.appId_;
            }
            if (lcmPb$Common.hasAppVersion()) {
                this.f6383e |= 64;
                this.l = lcmPb$Common.appVersion_;
            }
            if (lcmPb$Common.hasSdkVersion()) {
                this.f6383e |= 128;
                this.m = lcmPb$Common.sdkVersion_;
            }
            if (lcmPb$Common.hasNetwork()) {
                this.f6383e |= 256;
                this.n = lcmPb$Common.network_;
            }
            if (lcmPb$Common.hasRomVersion()) {
                this.f6383e |= 512;
                this.o = lcmPb$Common.romVersion_;
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$Common lcmPb$Common = null;
            try {
                try {
                    LcmPb$Common parsePartialFrom = LcmPb$Common.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        s(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    LcmPb$Common lcmPb$Common2 = (LcmPb$Common) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        lcmPb$Common = lcmPb$Common2;
                        if (lcmPb$Common != null) {
                            s(lcmPb$Common);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (lcmPb$Common != null) {
                }
                throw th;
            }
        }

        public b u(String str) {
            if (str != null) {
                this.f6383e |= 32;
                this.k = str;
                return this;
            }
            throw null;
        }

        public b v(String str) {
            if (str != null) {
                this.f6383e |= 64;
                this.l = str;
                return this;
            }
            throw null;
        }

        public b w(String str) {
            if (str != null) {
                this.f6383e |= 1;
                this.f6384f = str;
                return this;
            }
            throw null;
        }

        public b x(String str) {
            if (str != null) {
                this.f6383e |= 2;
                this.f6385g = str;
                return this;
            }
            throw null;
        }

        public b y(String str) {
            if (str != null) {
                this.f6383e |= 8;
                this.i = str;
                return this;
            }
            throw null;
        }

        public b z(String str) {
            if (str != null) {
                this.f6383e |= 16;
                this.j = str;
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
        public /* bridge */ /* synthetic */ b mergeFrom(LcmPb$Common lcmPb$Common) {
            s(lcmPb$Common);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        LcmPb$Common lcmPb$Common = new LcmPb$Common(true);
        defaultInstance = lcmPb$Common;
        lcmPb$Common.initFields();
    }

    public static LcmPb$Common getDefaultInstance() {
        return defaultInstance;
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

    public static b newBuilder() {
        return b.q();
    }

    public static LcmPb$Common parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
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

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<LcmPb$Common> getParserForType() {
        return PARSER;
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

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getCuidBytes()) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeBytesSize += CodedOutputStream.computeBytesSize(2, getDeviceTypeBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, getOsVersionBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            computeBytesSize += CodedOutputStream.computeBytesSize(4, getManufactureBytes());
        }
        if ((this.bitField0_ & 16) == 16) {
            computeBytesSize += CodedOutputStream.computeBytesSize(5, getModelTypeBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            computeBytesSize += CodedOutputStream.computeBytesSize(6, getAppIdBytes());
        }
        if ((this.bitField0_ & 64) == 64) {
            computeBytesSize += CodedOutputStream.computeBytesSize(7, getAppVersionBytes());
        }
        if ((this.bitField0_ & 128) == 128) {
            computeBytesSize += CodedOutputStream.computeBytesSize(8, getSdkVersionBytes());
        }
        if ((this.bitField0_ & 256) == 256) {
            computeBytesSize += CodedOutputStream.computeBytesSize(9, getNetworkBytes());
        }
        if ((this.bitField0_ & 512) == 512) {
            computeBytesSize += CodedOutputStream.computeBytesSize(10, getRomVersionBytes());
        }
        this.memoizedSerializedSize = computeBytesSize;
        return computeBytesSize;
    }

    public boolean hasAppId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasAppVersion() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasCuid() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasDeviceType() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasManufacture() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasModelType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasNetwork() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasOsVersion() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasRomVersion() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasSdkVersion() {
        return (this.bitField0_ & 128) == 128;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
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

    public static b newBuilder(LcmPb$Common lcmPb$Common) {
        b newBuilder = newBuilder();
        newBuilder.s(lcmPb$Common);
        return newBuilder;
    }

    public static LcmPb$Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$Common getDefaultInstanceForType() {
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

    public LcmPb$Common(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$Common parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$Common(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$Common parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.cuid_ = codedInputStream.readBytes();
                            continue;
                        case 18:
                            this.bitField0_ |= 2;
                            this.deviceType_ = codedInputStream.readBytes();
                            continue;
                        case 26:
                            this.bitField0_ |= 4;
                            this.osVersion_ = codedInputStream.readBytes();
                            continue;
                        case 34:
                            this.bitField0_ |= 8;
                            this.manufacture_ = codedInputStream.readBytes();
                            continue;
                        case 42:
                            this.bitField0_ |= 16;
                            this.modelType_ = codedInputStream.readBytes();
                            continue;
                        case 50:
                            this.bitField0_ |= 32;
                            this.appId_ = codedInputStream.readBytes();
                            continue;
                        case 58:
                            this.bitField0_ |= 64;
                            this.appVersion_ = codedInputStream.readBytes();
                            continue;
                        case 66:
                            this.bitField0_ |= 128;
                            this.sdkVersion_ = codedInputStream.readBytes();
                            continue;
                        case 74:
                            this.bitField0_ |= 256;
                            this.network_ = codedInputStream.readBytes();
                            continue;
                        case 82:
                            this.bitField0_ |= 512;
                            this.romVersion_ = codedInputStream.readBytes();
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
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
