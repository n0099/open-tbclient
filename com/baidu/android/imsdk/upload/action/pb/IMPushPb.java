package com.baidu.android.imsdk.upload.action.pb;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes18.dex */
public final class IMPushPb {

    /* loaded from: classes18.dex */
    public interface AckOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getExt();

        ByteString getExtBytes();

        long getTimestamp();

        String getType();

        ByteString getTypeBytes();

        String getValue();

        ByteString getValueBytes();

        boolean hasAliasId();

        boolean hasExt();

        boolean hasTimestamp();

        boolean hasType();

        boolean hasValue();
    }

    /* loaded from: classes18.dex */
    public interface ActionOrBuilder extends MessageLiteOrBuilder {
        Ack getAck();

        ActionType getActionType();

        Connection getConnection();

        Crash getCrash();

        Db getDb();

        Msg getMsg();

        Request getRequest();

        Ui getUi();

        boolean hasAck();

        boolean hasActionType();

        boolean hasConnection();

        boolean hasCrash();

        boolean hasDb();

        boolean hasMsg();

        boolean hasRequest();

        boolean hasUi();
    }

    /* loaded from: classes18.dex */
    public interface AppInfoOrBuilder extends MessageLiteOrBuilder {
        String getAppChannel();

        ByteString getAppChannelBytes();

        String getAppName();

        ByteString getAppNameBytes();

        String getAppVersion();

        ByteString getAppVersionBytes();

        boolean hasAppChannel();

        boolean hasAppName();

        boolean hasAppVersion();
    }

    /* loaded from: classes18.dex */
    public interface CommonOrBuilder extends MessageLiteOrBuilder {
        AppInfo getAppInfo();

        DeviceID getDeviceId();

        String getModuleName();

        ByteString getModuleNameBytes();

        NetInfo getNetInfo();

        String getProductName();

        ByteString getProductNameBytes();

        TerminalInfo getTerminalInfo();

        long getTimestamp();

        long getUserTimestamp();

        boolean hasAppInfo();

        boolean hasDeviceId();

        boolean hasModuleName();

        boolean hasNetInfo();

        boolean hasProductName();

        boolean hasTerminalInfo();

        boolean hasTimestamp();

        boolean hasUserTimestamp();
    }

    /* loaded from: classes18.dex */
    public interface ConnectionOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getExt();

        ByteString getExtBytes();

        String getReason();

        ByteString getReasonBytes();

        long getRetryCount();

        long getRetryTime();

        long getStartTime();

        long getStopTime();

        boolean hasAliasId();

        boolean hasExt();

        boolean hasReason();

        boolean hasRetryCount();

        boolean hasRetryTime();

        boolean hasStartTime();

        boolean hasStopTime();
    }

    /* loaded from: classes18.dex */
    public interface CrashOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getException();

        ByteString getExceptionBytes();

        String getExt();

        ByteString getExtBytes();

        long getTimestamp();

        boolean hasAliasId();

        boolean hasException();

        boolean hasExt();

        boolean hasTimestamp();
    }

    /* loaded from: classes18.dex */
    public interface DbOrBuilder extends MessageLiteOrBuilder {
        String getAction();

        ByteString getActionBytes();

        long getAliasId();

        String getClassName();

        ByteString getClassNameBytes();

        long getDuration();

        long getEndTime();

        String getExt();

        ByteString getExtBytes();

        String getMethod();

        ByteString getMethodBytes();

        long getStartTime();

        String getTable();

        ByteString getTableBytes();

        boolean hasAction();

        boolean hasAliasId();

        boolean hasClassName();

        boolean hasDuration();

        boolean hasEndTime();

        boolean hasExt();

        boolean hasMethod();

        boolean hasStartTime();

        boolean hasTable();
    }

    /* loaded from: classes18.dex */
    public interface DeviceIDOrBuilder extends MessageLiteOrBuilder {
        String getCuid();

        ByteString getCuidBytes();

        boolean hasCuid();
    }

    /* loaded from: classes18.dex */
    public interface MetaDataOrBuilder extends MessageLiteOrBuilder {
        int getLogModuleId();

        String getLogName();

        ByteString getLogNameBytes();

        String getProductName();

        ByteString getProductNameBytes();

        boolean hasLogModuleId();

        boolean hasLogName();

        boolean hasProductName();
    }

    /* loaded from: classes18.dex */
    public interface MsgOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        long getDuration();

        long getEndMsgid();

        String getExt();

        ByteString getExtBytes();

        long getMsgCount();

        String getRoomId();

        ByteString getRoomIdBytes();

        long getStartMsgid();

        boolean hasAliasId();

        boolean hasDuration();

        boolean hasEndMsgid();

        boolean hasExt();

        boolean hasMsgCount();

        boolean hasRoomId();

        boolean hasStartMsgid();
    }

    /* loaded from: classes18.dex */
    public interface NetInfoOrBuilder extends MessageLiteOrBuilder {
        String getNetApn();

        ByteString getNetApnBytes();

        String getNetType();

        ByteString getNetTypeBytes();

        boolean hasNetApn();

        boolean hasNetType();
    }

    /* loaded from: classes18.dex */
    public interface PushImClientOrBuilder extends MessageLiteOrBuilder {
        Action getActions(int i);

        int getActionsCount();

        List<Action> getActionsList();

        Common getCommon();

        MetaData getMetadata();

        String getSdkName();

        ByteString getSdkNameBytes();

        long getSdkVersion();

        boolean hasCommon();

        boolean hasMetadata();

        boolean hasSdkName();

        boolean hasSdkVersion();
    }

    /* loaded from: classes18.dex */
    public interface RequestOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        long getErrorCode();

        String getExt();

        ByteString getExtBytes();

        String getMethod();

        ByteString getMethodBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        long getResponseTime();

        long getTimestamp();

        boolean hasAliasId();

        boolean hasErrorCode();

        boolean hasExt();

        boolean hasMethod();

        boolean hasRequestId();

        boolean hasResponseTime();

        boolean hasTimestamp();
    }

    /* loaded from: classes18.dex */
    public interface TerminalInfoOrBuilder extends MessageLiteOrBuilder {
        String getManufacturer();

        ByteString getManufacturerBytes();

        OSType getOs();

        String getOsVersion();

        ByteString getOsVersionBytes();

        int getPpi();

        int getResolutionH();

        int getResolutionV();

        String getTerminalType();

        ByteString getTerminalTypeBytes();

        boolean hasManufacturer();

        boolean hasOs();

        boolean hasOsVersion();

        boolean hasPpi();

        boolean hasResolutionH();

        boolean hasResolutionV();

        boolean hasTerminalType();
    }

    /* loaded from: classes18.dex */
    public interface UiOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getCategory();

        ByteString getCategoryBytes();

        long getDuration();

        long getEndTime();

        String getExt();

        ByteString getExtBytes();

        String getPage();

        ByteString getPageBytes();

        long getStartTime();

        boolean hasAliasId();

        boolean hasCategory();

        boolean hasDuration();

        boolean hasEndTime();

        boolean hasExt();

        boolean hasPage();

        boolean hasStartTime();
    }

    private IMPushPb() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    /* loaded from: classes18.dex */
    public enum OSType implements Internal.EnumLite {
        OS_TYPE_UNKNWON(0, 0),
        IOS(1, 1),
        ANDROID(2, 2),
        WINDOWSPHONE(3, 3);
        
        public static final int ANDROID_VALUE = 2;
        public static final int IOS_VALUE = 1;
        public static final int OS_TYPE_UNKNWON_VALUE = 0;
        public static final int WINDOWSPHONE_VALUE = 3;
        private static Internal.EnumLiteMap<OSType> internalValueMap = new Internal.EnumLiteMap<OSType>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.OSType.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public OSType findValueByNumber(int i) {
                return OSType.valueOf(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static OSType valueOf(int i) {
            switch (i) {
                case 0:
                    return OS_TYPE_UNKNWON;
                case 1:
                    return IOS;
                case 2:
                    return ANDROID;
                case 3:
                    return WINDOWSPHONE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<OSType> internalGetValueMap() {
            return internalValueMap;
        }

        OSType(int i, int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes18.dex */
    public enum ActionType implements Internal.EnumLite {
        UI(0, 101),
        CRASH(1, 201),
        DB(2, 301),
        CONNECTION(3, 401),
        REQUEST(4, 501),
        ACK(5, 601),
        MSG(6, 701);
        
        public static final int ACK_VALUE = 601;
        public static final int CONNECTION_VALUE = 401;
        public static final int CRASH_VALUE = 201;
        public static final int DB_VALUE = 301;
        public static final int MSG_VALUE = 701;
        public static final int REQUEST_VALUE = 501;
        public static final int UI_VALUE = 101;
        private static Internal.EnumLiteMap<ActionType> internalValueMap = new Internal.EnumLiteMap<ActionType>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionType.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ActionType findValueByNumber(int i) {
                return ActionType.valueOf(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static ActionType valueOf(int i) {
            switch (i) {
                case 101:
                    return UI;
                case 201:
                    return CRASH;
                case 301:
                    return DB;
                case 401:
                    return CONNECTION;
                case 501:
                    return REQUEST;
                case 601:
                    return ACK;
                case 701:
                    return MSG;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ActionType> internalGetValueMap() {
            return internalValueMap;
        }

        ActionType(int i, int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes18.dex */
    public static final class DeviceID extends GeneratedMessageLite implements DeviceIDOrBuilder {
        public static final int CUID_FIELD_NUMBER = 4;
        public static final Parser<DeviceID> PARSER = new AbstractParser<DeviceID>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceID.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public DeviceID parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DeviceID(codedInputStream, extensionRegistryLite);
            }
        };
        private static final DeviceID defaultInstance = new DeviceID(true);
        private static final long serialVersionUID = 0;
        private int bitField0;
        private Object cuid;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private DeviceID(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private DeviceID(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DeviceID getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public DeviceID getDefaultInstanceForType() {
            return defaultInstance;
        }

        private DeviceID(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                case 34:
                                    this.bitField0 |= 1;
                                    this.cuid = codedInputStream.readBytes();
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
        public Parser<DeviceID> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
        public boolean hasCuid() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
        public String getCuid() {
            Object obj = this.cuid;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.cuid = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
        public ByteString getCuidBytes() {
            Object obj = this.cuid;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cuid = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void initFields() {
            this.cuid = "";
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            } else if (!hasCuid()) {
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
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(4, getCuidBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, getCuidBytes()) : 0;
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DeviceID parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static DeviceID parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DeviceID parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static DeviceID parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static DeviceID parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static DeviceID parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static DeviceID parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static DeviceID parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static DeviceID parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static DeviceID parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DeviceID deviceID) {
            return newBuilder().mergeFrom(deviceID);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DeviceID, Builder> implements DeviceIDOrBuilder {
            private int bitField0;
            private Object cuid = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.cuid = "";
                this.bitField0 &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public DeviceID getDefaultInstanceForType() {
                return DeviceID.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public DeviceID build() {
                DeviceID buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public DeviceID buildPartial() {
                DeviceID deviceID = new DeviceID(this);
                int i = (this.bitField0 & 1) != 1 ? 0 : 1;
                deviceID.cuid = this.cuid;
                deviceID.bitField0 = i;
                return deviceID;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(DeviceID deviceID) {
                if (deviceID != DeviceID.getDefaultInstance() && deviceID.hasCuid()) {
                    this.bitField0 |= 1;
                    this.cuid = deviceID.cuid;
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasCuid();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                DeviceID deviceID;
                Throwable th;
                try {
                    try {
                        DeviceID parsePartialFrom = DeviceID.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        deviceID = null;
                        if (deviceID != null) {
                            mergeFrom(deviceID);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    DeviceID deviceID2 = (DeviceID) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        deviceID = deviceID2;
                        th = th3;
                        if (deviceID != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public boolean hasCuid() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public String getCuid() {
                Object obj = this.cuid;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.cuid = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public ByteString getCuidBytes() {
                Object obj = this.cuid;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.cuid = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setCuid(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.cuid = str;
                return this;
            }

            public Builder clearCuid() {
                this.bitField0 &= -2;
                this.cuid = DeviceID.getDefaultInstance().getCuid();
                return this;
            }

            public Builder setCuidBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.cuid = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class TerminalInfo extends GeneratedMessageLite implements TerminalInfoOrBuilder {
        public static final int MANUFACTURER_FIELD_NUMBER = 3;
        public static final int OS_FIELD_NUMBER = 1;
        public static final int OS_VERSION_FIELD_NUMBER = 2;
        public static final int PPI_FIELD_NUMBER = 7;
        public static final int RESOLUTION_H_FIELD_NUMBER = 5;
        public static final int RESOLUTION_V_FIELD_NUMBER = 6;
        public static final int TERMINAL_TYPE_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0;
        private Object manufacturer;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private OSType os;
        private Object osVersion;
        private int ppi;
        private int resolutionH;
        private int resolutionV;
        private Object terminalType;
        public static final Parser<TerminalInfo> PARSER = new AbstractParser<TerminalInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public TerminalInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TerminalInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final TerminalInfo defaultInstance = new TerminalInfo(true);

        private TerminalInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private TerminalInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static TerminalInfo getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public TerminalInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private TerminalInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                z = true;
                                break;
                            case 8:
                                OSType valueOf = OSType.valueOf(codedInputStream.readEnum());
                                if (valueOf == null) {
                                    break;
                                } else {
                                    this.bitField0 |= 1;
                                    this.os = valueOf;
                                    break;
                                }
                            case 18:
                                this.bitField0 |= 2;
                                this.osVersion = codedInputStream.readBytes();
                                break;
                            case 26:
                                this.bitField0 |= 4;
                                this.manufacturer = codedInputStream.readBytes();
                                break;
                            case 34:
                                this.bitField0 |= 8;
                                this.terminalType = codedInputStream.readBytes();
                                break;
                            case 40:
                                this.bitField0 |= 16;
                                this.resolutionH = codedInputStream.readInt32();
                                break;
                            case 48:
                                this.bitField0 |= 32;
                                this.resolutionV = codedInputStream.readInt32();
                                break;
                            case 56:
                                this.bitField0 |= 64;
                                this.ppi = codedInputStream.readInt32();
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
        public Parser<TerminalInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasOs() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public OSType getOs() {
            return this.os;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasOsVersion() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public String getOsVersion() {
            Object obj = this.osVersion;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.osVersion = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public ByteString getOsVersionBytes() {
            Object obj = this.osVersion;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.osVersion = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasManufacturer() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public String getManufacturer() {
            Object obj = this.manufacturer;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.manufacturer = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public ByteString getManufacturerBytes() {
            Object obj = this.manufacturer;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.manufacturer = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasTerminalType() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public String getTerminalType() {
            Object obj = this.terminalType;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.terminalType = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public ByteString getTerminalTypeBytes() {
            Object obj = this.terminalType;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.terminalType = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasResolutionH() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getResolutionH() {
            return this.resolutionH;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasResolutionV() {
            return (this.bitField0 & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getResolutionV() {
            return this.resolutionV;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasPpi() {
            return (this.bitField0 & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getPpi() {
            return this.ppi;
        }

        private void initFields() {
            this.os = OSType.OS_TYPE_UNKNWON;
            this.osVersion = "";
            this.manufacturer = "";
            this.terminalType = "";
            this.resolutionH = 0;
            this.resolutionV = 0;
            this.ppi = 0;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeEnum(1, this.os.getNumber());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getOsVersionBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getManufacturerBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeBytes(4, getTerminalTypeBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt32(5, this.resolutionH);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeInt32(6, this.resolutionV);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt32(7, this.ppi);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.os.getNumber()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getOsVersionBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getManufacturerBytes());
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getTerminalTypeBytes());
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeInt32Size(5, this.resolutionH);
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeInt32Size(6, this.resolutionV);
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeInt32Size(7, this.ppi);
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

        public static TerminalInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static TerminalInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static TerminalInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static TerminalInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static TerminalInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static TerminalInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static TerminalInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static TerminalInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static TerminalInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static TerminalInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TerminalInfo terminalInfo) {
            return newBuilder().mergeFrom(terminalInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TerminalInfo, Builder> implements TerminalInfoOrBuilder {
            private int bitField0;
            private int ppi;
            private int resolutionH;
            private int resolutionV;
            private OSType os = OSType.OS_TYPE_UNKNWON;
            private Object osVersion = "";
            private Object manufacturer = "";
            private Object terminalType = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.os = OSType.OS_TYPE_UNKNWON;
                this.bitField0 &= -2;
                this.osVersion = "";
                this.bitField0 &= -3;
                this.manufacturer = "";
                this.bitField0 &= -5;
                this.terminalType = "";
                this.bitField0 &= -9;
                this.resolutionH = 0;
                this.bitField0 &= -17;
                this.resolutionV = 0;
                this.bitField0 &= -33;
                this.ppi = 0;
                this.bitField0 &= -65;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public TerminalInfo getDefaultInstanceForType() {
                return TerminalInfo.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public TerminalInfo build() {
                TerminalInfo buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public TerminalInfo buildPartial() {
                TerminalInfo terminalInfo = new TerminalInfo(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                terminalInfo.os = this.os;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                terminalInfo.osVersion = this.osVersion;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                terminalInfo.manufacturer = this.manufacturer;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                terminalInfo.terminalType = this.terminalType;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                terminalInfo.resolutionH = this.resolutionH;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                terminalInfo.resolutionV = this.resolutionV;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                terminalInfo.ppi = this.ppi;
                terminalInfo.bitField0 = i2;
                return terminalInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TerminalInfo terminalInfo) {
                if (terminalInfo != TerminalInfo.getDefaultInstance()) {
                    if (terminalInfo.hasOs()) {
                        setOs(terminalInfo.getOs());
                    }
                    if (terminalInfo.hasOsVersion()) {
                        this.bitField0 |= 2;
                        this.osVersion = terminalInfo.osVersion;
                    }
                    if (terminalInfo.hasManufacturer()) {
                        this.bitField0 |= 4;
                        this.manufacturer = terminalInfo.manufacturer;
                    }
                    if (terminalInfo.hasTerminalType()) {
                        this.bitField0 |= 8;
                        this.terminalType = terminalInfo.terminalType;
                    }
                    if (terminalInfo.hasResolutionH()) {
                        setResolutionH(terminalInfo.getResolutionH());
                    }
                    if (terminalInfo.hasResolutionV()) {
                        setResolutionV(terminalInfo.getResolutionV());
                    }
                    if (terminalInfo.hasPpi()) {
                        setPpi(terminalInfo.getPpi());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TerminalInfo terminalInfo;
                Throwable th;
                try {
                    try {
                        TerminalInfo parsePartialFrom = TerminalInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        terminalInfo = null;
                        if (terminalInfo != null) {
                            mergeFrom(terminalInfo);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    TerminalInfo terminalInfo2 = (TerminalInfo) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        terminalInfo = terminalInfo2;
                        th = th3;
                        if (terminalInfo != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasOs() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public OSType getOs() {
                return this.os;
            }

            public Builder setOs(OSType oSType) {
                if (oSType == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.os = oSType;
                return this;
            }

            public Builder clearOs() {
                this.bitField0 &= -2;
                this.os = OSType.OS_TYPE_UNKNWON;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasOsVersion() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getOsVersion() {
                Object obj = this.osVersion;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.osVersion = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getOsVersionBytes() {
                Object obj = this.osVersion;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.osVersion = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setOsVersion(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.osVersion = str;
                return this;
            }

            public Builder clearOsVersion() {
                this.bitField0 &= -3;
                this.osVersion = TerminalInfo.getDefaultInstance().getOsVersion();
                return this;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.osVersion = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasManufacturer() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getManufacturer() {
                Object obj = this.manufacturer;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.manufacturer = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getManufacturerBytes() {
                Object obj = this.manufacturer;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.manufacturer = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setManufacturer(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.manufacturer = str;
                return this;
            }

            public Builder clearManufacturer() {
                this.bitField0 &= -5;
                this.manufacturer = TerminalInfo.getDefaultInstance().getManufacturer();
                return this;
            }

            public Builder setManufacturerBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.manufacturer = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasTerminalType() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getTerminalType() {
                Object obj = this.terminalType;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.terminalType = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getTerminalTypeBytes() {
                Object obj = this.terminalType;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.terminalType = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setTerminalType(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 8;
                this.terminalType = str;
                return this;
            }

            public Builder clearTerminalType() {
                this.bitField0 &= -9;
                this.terminalType = TerminalInfo.getDefaultInstance().getTerminalType();
                return this;
            }

            public Builder setTerminalTypeBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 8;
                this.terminalType = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasResolutionH() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getResolutionH() {
                return this.resolutionH;
            }

            public Builder setResolutionH(int i) {
                this.bitField0 |= 16;
                this.resolutionH = i;
                return this;
            }

            public Builder clearResolutionH() {
                this.bitField0 &= -17;
                this.resolutionH = 0;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasResolutionV() {
                return (this.bitField0 & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getResolutionV() {
                return this.resolutionV;
            }

            public Builder setResolutionV(int i) {
                this.bitField0 |= 32;
                this.resolutionV = i;
                return this;
            }

            public Builder clearResolutionV() {
                this.bitField0 &= -33;
                this.resolutionV = 0;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasPpi() {
                return (this.bitField0 & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getPpi() {
                return this.ppi;
            }

            public Builder setPpi(int i) {
                this.bitField0 |= 64;
                this.ppi = i;
                return this;
            }

            public Builder clearPpi() {
                this.bitField0 &= -65;
                this.ppi = 0;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class AppInfo extends GeneratedMessageLite implements AppInfoOrBuilder {
        public static final int APP_CHANNEL_FIELD_NUMBER = 3;
        public static final int APP_NAME_FIELD_NUMBER = 1;
        public static final int APP_VERSION_FIELD_NUMBER = 2;
        public static final Parser<AppInfo> PARSER = new AbstractParser<AppInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public AppInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AppInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final AppInfo defaultInstance = new AppInfo(true);
        private static final long serialVersionUID = 0;
        private Object appChannel;
        private Object appName;
        private Object appVersion;
        private int bitField0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        private AppInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private AppInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AppInfo getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public AppInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private AppInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.appName = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.appVersion = codedInputStream.readBytes();
                                    break;
                                case 26:
                                    this.bitField0 |= 4;
                                    this.appChannel = codedInputStream.readBytes();
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
        public Parser<AppInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppName() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public String getAppName() {
            Object obj = this.appName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appName = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppNameBytes() {
            Object obj = this.appName;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appName = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppVersion() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public String getAppVersion() {
            Object obj = this.appVersion;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appVersion = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppChannel() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public String getAppChannel() {
            Object obj = this.appChannel;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appChannel = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppChannelBytes() {
            Object obj = this.appChannel;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appChannel = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void initFields() {
            this.appName = "";
            this.appVersion = "";
            this.appChannel = "";
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getAppNameBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getAppVersionBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getAppChannelBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getAppNameBytes()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getAppVersionBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getAppChannelBytes());
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

        public static AppInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AppInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AppInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static AppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AppInfo appInfo) {
            return newBuilder().mergeFrom(appInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AppInfo, Builder> implements AppInfoOrBuilder {
            private int bitField0;
            private Object appName = "";
            private Object appVersion = "";
            private Object appChannel = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.appName = "";
                this.bitField0 &= -2;
                this.appVersion = "";
                this.bitField0 &= -3;
                this.appChannel = "";
                this.bitField0 &= -5;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public AppInfo getDefaultInstanceForType() {
                return AppInfo.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public AppInfo build() {
                AppInfo buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public AppInfo buildPartial() {
                AppInfo appInfo = new AppInfo(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                appInfo.appName = this.appName;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                appInfo.appVersion = this.appVersion;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                appInfo.appChannel = this.appChannel;
                appInfo.bitField0 = i2;
                return appInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(AppInfo appInfo) {
                if (appInfo != AppInfo.getDefaultInstance()) {
                    if (appInfo.hasAppName()) {
                        this.bitField0 |= 1;
                        this.appName = appInfo.appName;
                    }
                    if (appInfo.hasAppVersion()) {
                        this.bitField0 |= 2;
                        this.appVersion = appInfo.appVersion;
                    }
                    if (appInfo.hasAppChannel()) {
                        this.bitField0 |= 4;
                        this.appChannel = appInfo.appChannel;
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AppInfo appInfo;
                Throwable th;
                try {
                    try {
                        AppInfo parsePartialFrom = AppInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        appInfo = null;
                        if (appInfo != null) {
                            mergeFrom(appInfo);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    AppInfo appInfo2 = (AppInfo) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        appInfo = appInfo2;
                        th = th3;
                        if (appInfo != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppName() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppName() {
                Object obj = this.appName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appName = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppNameBytes() {
                Object obj = this.appName;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appName = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setAppName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.appName = str;
                return this;
            }

            public Builder clearAppName() {
                this.bitField0 &= -2;
                this.appName = AppInfo.getDefaultInstance().getAppName();
                return this;
            }

            public Builder setAppNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.appName = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppVersion() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppVersion() {
                Object obj = this.appVersion;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appVersion = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppVersionBytes() {
                Object obj = this.appVersion;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appVersion = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setAppVersion(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.appVersion = str;
                return this;
            }

            public Builder clearAppVersion() {
                this.bitField0 &= -3;
                this.appVersion = AppInfo.getDefaultInstance().getAppVersion();
                return this;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.appVersion = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppChannel() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppChannel() {
                Object obj = this.appChannel;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appChannel = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppChannelBytes() {
                Object obj = this.appChannel;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appChannel = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setAppChannel(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.appChannel = str;
                return this;
            }

            public Builder clearAppChannel() {
                this.bitField0 &= -5;
                this.appChannel = AppInfo.getDefaultInstance().getAppChannel();
                return this;
            }

            public Builder setAppChannelBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.appChannel = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class NetInfo extends GeneratedMessageLite implements NetInfoOrBuilder {
        public static final int NET_APN_FIELD_NUMBER = 2;
        public static final int NET_TYPE_FIELD_NUMBER = 1;
        public static final Parser<NetInfo> PARSER = new AbstractParser<NetInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public NetInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new NetInfo(codedInputStream, extensionRegistryLite);
            }
        };
        private static final NetInfo defaultInstance = new NetInfo(true);
        private static final long serialVersionUID = 0;
        private int bitField0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object netApn;
        private Object netType;

        private NetInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private NetInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static NetInfo getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public NetInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        private NetInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.netType = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.netApn = codedInputStream.readBytes();
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
        public Parser<NetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public boolean hasNetType() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public String getNetType() {
            Object obj = this.netType;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.netType = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public ByteString getNetTypeBytes() {
            Object obj = this.netType;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.netType = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public boolean hasNetApn() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public String getNetApn() {
            Object obj = this.netApn;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.netApn = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public ByteString getNetApnBytes() {
            Object obj = this.netApn;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.netApn = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void initFields() {
            this.netType = "";
            this.netApn = "";
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getNetTypeBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getNetApnBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNetTypeBytes()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getNetApnBytes());
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

        public static NetInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static NetInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static NetInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static NetInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static NetInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static NetInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static NetInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static NetInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static NetInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static NetInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(NetInfo netInfo) {
            return newBuilder().mergeFrom(netInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<NetInfo, Builder> implements NetInfoOrBuilder {
            private int bitField0;
            private Object netType = "";
            private Object netApn = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.netType = "";
                this.bitField0 &= -2;
                this.netApn = "";
                this.bitField0 &= -3;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public NetInfo getDefaultInstanceForType() {
                return NetInfo.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NetInfo build() {
                NetInfo buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NetInfo buildPartial() {
                NetInfo netInfo = new NetInfo(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                netInfo.netType = this.netType;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                netInfo.netApn = this.netApn;
                netInfo.bitField0 = i2;
                return netInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(NetInfo netInfo) {
                if (netInfo != NetInfo.getDefaultInstance()) {
                    if (netInfo.hasNetType()) {
                        this.bitField0 |= 1;
                        this.netType = netInfo.netType;
                    }
                    if (netInfo.hasNetApn()) {
                        this.bitField0 |= 2;
                        this.netApn = netInfo.netApn;
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                NetInfo netInfo;
                Throwable th;
                try {
                    try {
                        NetInfo parsePartialFrom = NetInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        netInfo = null;
                        if (netInfo != null) {
                            mergeFrom(netInfo);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    NetInfo netInfo2 = (NetInfo) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        netInfo = netInfo2;
                        th = th3;
                        if (netInfo != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public boolean hasNetType() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public String getNetType() {
                Object obj = this.netType;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.netType = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public ByteString getNetTypeBytes() {
                Object obj = this.netType;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.netType = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setNetType(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.netType = str;
                return this;
            }

            public Builder clearNetType() {
                this.bitField0 &= -2;
                this.netType = NetInfo.getDefaultInstance().getNetType();
                return this;
            }

            public Builder setNetTypeBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.netType = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public boolean hasNetApn() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public String getNetApn() {
                Object obj = this.netApn;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.netApn = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public ByteString getNetApnBytes() {
                Object obj = this.netApn;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.netApn = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setNetApn(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.netApn = str;
                return this;
            }

            public Builder clearNetApn() {
                this.bitField0 &= -3;
                this.netApn = NetInfo.getDefaultInstance().getNetApn();
                return this;
            }

            public Builder setNetApnBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.netApn = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Common extends GeneratedMessageLite implements CommonOrBuilder {
        public static final int APP_INFO_FIELD_NUMBER = 21;
        public static final int DEVICE_ID_FIELD_NUMBER = 7;
        public static final int MODULE_NAME_FIELD_NUMBER = 2;
        public static final int NET_INFO_FIELD_NUMBER = 22;
        public static final int PRODUCT_NAME_FIELD_NUMBER = 1;
        public static final int TERMINAL_INFO_FIELD_NUMBER = 20;
        public static final int TIMESTAMP_FIELD_NUMBER = 10;
        public static final int USER_TIMESTAMP_FIELD_NUMBER = 12;
        private static final long serialVersionUID = 0;
        private AppInfo appInfo;
        private int bitField0;
        private DeviceID deviceId;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object moduleName;
        private NetInfo netInfo;
        private Object productName;
        private TerminalInfo terminalInfo;
        private long timestamp;
        private long userTimestamp;
        public static final Parser<Common> PARSER = new AbstractParser<Common>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Common.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
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
                                this.bitField0 |= 1;
                                this.productName = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 18:
                                this.bitField0 |= 2;
                                this.moduleName = codedInputStream.readBytes();
                                z = z2;
                                break;
                            case 58:
                                DeviceID.Builder builder = (this.bitField0 & 4) == 4 ? this.deviceId.toBuilder() : null;
                                this.deviceId = (DeviceID) codedInputStream.readMessage(DeviceID.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.deviceId);
                                    this.deviceId = builder.buildPartial();
                                }
                                this.bitField0 |= 4;
                                z = z2;
                                break;
                            case 80:
                                this.bitField0 |= 8;
                                this.timestamp = codedInputStream.readInt64();
                                z = z2;
                                break;
                            case 96:
                                this.bitField0 |= 16;
                                this.userTimestamp = codedInputStream.readInt64();
                                z = z2;
                                break;
                            case 162:
                                TerminalInfo.Builder builder2 = (this.bitField0 & 32) == 32 ? this.terminalInfo.toBuilder() : null;
                                this.terminalInfo = (TerminalInfo) codedInputStream.readMessage(TerminalInfo.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.terminalInfo);
                                    this.terminalInfo = builder2.buildPartial();
                                }
                                this.bitField0 |= 32;
                                z = z2;
                                break;
                            case Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID /* 170 */:
                                AppInfo.Builder builder3 = (this.bitField0 & 64) == 64 ? this.appInfo.toBuilder() : null;
                                this.appInfo = (AppInfo) codedInputStream.readMessage(AppInfo.PARSER, extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.appInfo);
                                    this.appInfo = builder3.buildPartial();
                                }
                                this.bitField0 |= 64;
                                z = z2;
                                break;
                            case Opcodes.GETSTATIC /* 178 */:
                                NetInfo.Builder builder4 = (this.bitField0 & 128) == 128 ? this.netInfo.toBuilder() : null;
                                this.netInfo = (NetInfo) codedInputStream.readMessage(NetInfo.PARSER, extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom(this.netInfo);
                                    this.netInfo = builder4.buildPartial();
                                }
                                this.bitField0 |= 128;
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
        public Parser<Common> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasProductName() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public String getProductName() {
            Object obj = this.productName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.productName = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public ByteString getProductNameBytes() {
            Object obj = this.productName;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productName = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasModuleName() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public String getModuleName() {
            Object obj = this.moduleName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.moduleName = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public ByteString getModuleNameBytes() {
            Object obj = this.moduleName;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.moduleName = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasDeviceId() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public DeviceID getDeviceId() {
            return this.deviceId;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasUserTimestamp() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public long getUserTimestamp() {
            return this.userTimestamp;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasTerminalInfo() {
            return (this.bitField0 & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public TerminalInfo getTerminalInfo() {
            return this.terminalInfo;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasAppInfo() {
            return (this.bitField0 & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public AppInfo getAppInfo() {
            return this.appInfo;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasNetInfo() {
            return (this.bitField0 & 128) == 128;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public NetInfo getNetInfo() {
            return this.netInfo;
        }

        private void initFields() {
            this.productName = "";
            this.moduleName = "";
            this.deviceId = DeviceID.getDefaultInstance();
            this.timestamp = 0L;
            this.userTimestamp = 0L;
            this.terminalInfo = TerminalInfo.getDefaultInstance();
            this.appInfo = AppInfo.getDefaultInstance();
            this.netInfo = NetInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            } else if (!hasTimestamp()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasDeviceId() && !getDeviceId().isInitialized()) {
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
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getProductNameBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getModuleNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeMessage(7, this.deviceId);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(10, this.timestamp);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(12, this.userTimestamp);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeMessage(20, this.terminalInfo);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeMessage(21, this.appInfo);
            }
            if ((this.bitField0 & 128) == 128) {
                codedOutputStream.writeMessage(22, this.netInfo);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getProductNameBytes()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getModuleNameBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(7, this.deviceId);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(10, this.timestamp);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(12, this.userTimestamp);
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeMessageSize(20, this.terminalInfo);
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeMessageSize(21, this.appInfo);
                }
                if ((this.bitField0 & 128) == 128) {
                    i += CodedOutputStream.computeMessageSize(22, this.netInfo);
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

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Common common2) {
            return newBuilder().mergeFrom(common2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Common, Builder> implements CommonOrBuilder {
            private int bitField0;
            private long timestamp;
            private long userTimestamp;
            private Object productName = "";
            private Object moduleName = "";
            private DeviceID deviceId = DeviceID.getDefaultInstance();
            private TerminalInfo terminalInfo = TerminalInfo.getDefaultInstance();
            private AppInfo appInfo = AppInfo.getDefaultInstance();
            private NetInfo netInfo = NetInfo.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.productName = "";
                this.bitField0 &= -2;
                this.moduleName = "";
                this.bitField0 &= -3;
                this.deviceId = DeviceID.getDefaultInstance();
                this.bitField0 &= -5;
                this.timestamp = 0L;
                this.bitField0 &= -9;
                this.userTimestamp = 0L;
                this.bitField0 &= -17;
                this.terminalInfo = TerminalInfo.getDefaultInstance();
                this.bitField0 &= -33;
                this.appInfo = AppInfo.getDefaultInstance();
                this.bitField0 &= -65;
                this.netInfo = NetInfo.getDefaultInstance();
                this.bitField0 &= -129;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Common getDefaultInstanceForType() {
                return Common.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Common build() {
                Common buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Common buildPartial() {
                Common common2 = new Common(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                common2.productName = this.productName;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                common2.moduleName = this.moduleName;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                common2.deviceId = this.deviceId;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                common2.timestamp = this.timestamp;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                common2.userTimestamp = this.userTimestamp;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                common2.terminalInfo = this.terminalInfo;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                common2.appInfo = this.appInfo;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                common2.netInfo = this.netInfo;
                common2.bitField0 = i2;
                return common2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Common common2) {
                if (common2 != Common.getDefaultInstance()) {
                    if (common2.hasProductName()) {
                        this.bitField0 |= 1;
                        this.productName = common2.productName;
                    }
                    if (common2.hasModuleName()) {
                        this.bitField0 |= 2;
                        this.moduleName = common2.moduleName;
                    }
                    if (common2.hasDeviceId()) {
                        mergeDeviceId(common2.getDeviceId());
                    }
                    if (common2.hasTimestamp()) {
                        setTimestamp(common2.getTimestamp());
                    }
                    if (common2.hasUserTimestamp()) {
                        setUserTimestamp(common2.getUserTimestamp());
                    }
                    if (common2.hasTerminalInfo()) {
                        mergeTerminalInfo(common2.getTerminalInfo());
                    }
                    if (common2.hasAppInfo()) {
                        mergeAppInfo(common2.getAppInfo());
                    }
                    if (common2.hasNetInfo()) {
                        mergeNetInfo(common2.getNetInfo());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasTimestamp()) {
                    return !hasDeviceId() || getDeviceId().isInitialized();
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Common common2;
                Throwable th;
                try {
                    try {
                        Common parsePartialFrom = Common.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        common2 = null;
                        if (common2 != null) {
                            mergeFrom(common2);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Common common3 = (Common) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        common2 = common3;
                        th = th3;
                        if (common2 != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasProductName() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public String getProductName() {
                Object obj = this.productName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.productName = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public ByteString getProductNameBytes() {
                Object obj = this.productName;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.productName = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setProductName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.productName = str;
                return this;
            }

            public Builder clearProductName() {
                this.bitField0 &= -2;
                this.productName = Common.getDefaultInstance().getProductName();
                return this;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.productName = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasModuleName() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public String getModuleName() {
                Object obj = this.moduleName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.moduleName = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public ByteString getModuleNameBytes() {
                Object obj = this.moduleName;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.moduleName = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setModuleName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.moduleName = str;
                return this;
            }

            public Builder clearModuleName() {
                this.bitField0 &= -3;
                this.moduleName = Common.getDefaultInstance().getModuleName();
                return this;
            }

            public Builder setModuleNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.moduleName = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasDeviceId() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public DeviceID getDeviceId() {
                return this.deviceId;
            }

            public Builder setDeviceId(DeviceID deviceID) {
                if (deviceID == null) {
                    throw new NullPointerException();
                }
                this.deviceId = deviceID;
                this.bitField0 |= 4;
                return this;
            }

            public Builder setDeviceId(DeviceID.Builder builder) {
                this.deviceId = builder.build();
                this.bitField0 |= 4;
                return this;
            }

            public Builder mergeDeviceId(DeviceID deviceID) {
                if ((this.bitField0 & 4) == 4 && this.deviceId != DeviceID.getDefaultInstance()) {
                    this.deviceId = DeviceID.newBuilder(this.deviceId).mergeFrom(deviceID).buildPartial();
                } else {
                    this.deviceId = deviceID;
                }
                this.bitField0 |= 4;
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId = DeviceID.getDefaultInstance();
                this.bitField0 &= -5;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasTimestamp() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public long getTimestamp() {
                return this.timestamp;
            }

            public Builder setTimestamp(long j) {
                this.bitField0 |= 8;
                this.timestamp = j;
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0 &= -9;
                this.timestamp = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasUserTimestamp() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public long getUserTimestamp() {
                return this.userTimestamp;
            }

            public Builder setUserTimestamp(long j) {
                this.bitField0 |= 16;
                this.userTimestamp = j;
                return this;
            }

            public Builder clearUserTimestamp() {
                this.bitField0 &= -17;
                this.userTimestamp = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasTerminalInfo() {
                return (this.bitField0 & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public TerminalInfo getTerminalInfo() {
                return this.terminalInfo;
            }

            public Builder setTerminalInfo(TerminalInfo terminalInfo) {
                if (terminalInfo == null) {
                    throw new NullPointerException();
                }
                this.terminalInfo = terminalInfo;
                this.bitField0 |= 32;
                return this;
            }

            public Builder setTerminalInfo(TerminalInfo.Builder builder) {
                this.terminalInfo = builder.build();
                this.bitField0 |= 32;
                return this;
            }

            public Builder mergeTerminalInfo(TerminalInfo terminalInfo) {
                if ((this.bitField0 & 32) == 32 && this.terminalInfo != TerminalInfo.getDefaultInstance()) {
                    this.terminalInfo = TerminalInfo.newBuilder(this.terminalInfo).mergeFrom(terminalInfo).buildPartial();
                } else {
                    this.terminalInfo = terminalInfo;
                }
                this.bitField0 |= 32;
                return this;
            }

            public Builder clearTerminalInfo() {
                this.terminalInfo = TerminalInfo.getDefaultInstance();
                this.bitField0 &= -33;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasAppInfo() {
                return (this.bitField0 & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public AppInfo getAppInfo() {
                return this.appInfo;
            }

            public Builder setAppInfo(AppInfo appInfo) {
                if (appInfo == null) {
                    throw new NullPointerException();
                }
                this.appInfo = appInfo;
                this.bitField0 |= 64;
                return this;
            }

            public Builder setAppInfo(AppInfo.Builder builder) {
                this.appInfo = builder.build();
                this.bitField0 |= 64;
                return this;
            }

            public Builder mergeAppInfo(AppInfo appInfo) {
                if ((this.bitField0 & 64) == 64 && this.appInfo != AppInfo.getDefaultInstance()) {
                    this.appInfo = AppInfo.newBuilder(this.appInfo).mergeFrom(appInfo).buildPartial();
                } else {
                    this.appInfo = appInfo;
                }
                this.bitField0 |= 64;
                return this;
            }

            public Builder clearAppInfo() {
                this.appInfo = AppInfo.getDefaultInstance();
                this.bitField0 &= -65;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasNetInfo() {
                return (this.bitField0 & 128) == 128;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public NetInfo getNetInfo() {
                return this.netInfo;
            }

            public Builder setNetInfo(NetInfo netInfo) {
                if (netInfo == null) {
                    throw new NullPointerException();
                }
                this.netInfo = netInfo;
                this.bitField0 |= 128;
                return this;
            }

            public Builder setNetInfo(NetInfo.Builder builder) {
                this.netInfo = builder.build();
                this.bitField0 |= 128;
                return this;
            }

            public Builder mergeNetInfo(NetInfo netInfo) {
                if ((this.bitField0 & 128) == 128 && this.netInfo != NetInfo.getDefaultInstance()) {
                    this.netInfo = NetInfo.newBuilder(this.netInfo).mergeFrom(netInfo).buildPartial();
                } else {
                    this.netInfo = netInfo;
                }
                this.bitField0 |= 128;
                return this;
            }

            public Builder clearNetInfo() {
                this.netInfo = NetInfo.getDefaultInstance();
                this.bitField0 &= -129;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class PushImClient extends GeneratedMessageLite implements PushImClientOrBuilder {
        public static final int ACTIONS_FIELD_NUMBER = 132;
        public static final int COMMON_FIELD_NUMBER = 41;
        public static final int METADATA_FIELD_NUMBER = 25;
        public static final int SDK_NAME_FIELD_NUMBER = 130;
        public static final int SDK_VERSION_FIELD_NUMBER = 131;
        private static final long serialVersionUID = 0;
        private List<Action> actions;
        private int bitField0;

        /* renamed from: common  reason: collision with root package name */
        private Common f995common;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private MetaData metadata;
        private Object sdkName;
        private long sdkVersion;
        public static final Parser<PushImClient> PARSER = new AbstractParser<PushImClient>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClient.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public PushImClient parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PushImClient(codedInputStream, extensionRegistryLite);
            }
        };
        private static final PushImClient defaultInstance = new PushImClient(true);

        private PushImClient(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private PushImClient(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PushImClient getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public PushImClient getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.util.List<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Action> */
        /* JADX WARN: Multi-variable type inference failed */
        private PushImClient(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            boolean z2;
            boolean z3;
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
                            case 202:
                                MetaData.Builder builder = (this.bitField0 & 1) == 1 ? this.metadata.toBuilder() : null;
                                this.metadata = (MetaData) codedInputStream.readMessage(MetaData.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.metadata);
                                    this.metadata = builder.buildPartial();
                                }
                                this.bitField0 |= 1;
                                z3 = z4;
                                z2 = z5;
                                break;
                            case 330:
                                Common.Builder builder2 = (this.bitField0 & 2) == 2 ? this.f995common.toBuilder() : null;
                                this.f995common = (Common) codedInputStream.readMessage(Common.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.f995common);
                                    this.f995common = builder2.buildPartial();
                                }
                                this.bitField0 |= 2;
                                z3 = z4;
                                z2 = z5;
                                break;
                            case 1042:
                                this.bitField0 |= 4;
                                this.sdkName = codedInputStream.readBytes();
                                z3 = z4;
                                z2 = z5;
                                break;
                            case 1048:
                                this.bitField0 |= 8;
                                this.sdkVersion = codedInputStream.readInt64();
                                z3 = z4;
                                z2 = z5;
                                break;
                            case 1058:
                                if (!(z5 & true)) {
                                    this.actions = new ArrayList();
                                    z = z5 | true;
                                } else {
                                    z = z5;
                                }
                                try {
                                    this.actions.add(codedInputStream.readMessage(Action.PARSER, extensionRegistryLite));
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
                                        this.actions = Collections.unmodifiableList(this.actions);
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
                this.actions = Collections.unmodifiableList(this.actions);
            }
            makeExtensionsImmutable();
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<PushImClient> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasMetadata() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public MetaData getMetadata() {
            return this.metadata;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasCommon() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public Common getCommon() {
            return this.f995common;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasSdkName() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public String getSdkName() {
            Object obj = this.sdkName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.sdkName = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public ByteString getSdkNameBytes() {
            Object obj = this.sdkName;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sdkName = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasSdkVersion() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public long getSdkVersion() {
            return this.sdkVersion;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public List<Action> getActionsList() {
            return this.actions;
        }

        public List<? extends ActionOrBuilder> getActionsOrBuilderList() {
            return this.actions;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public int getActionsCount() {
            return this.actions.size();
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public Action getActions(int i) {
            return this.actions.get(i);
        }

        public ActionOrBuilder getActionsOrBuilder(int i) {
            return this.actions.get(i);
        }

        private void initFields() {
            this.metadata = MetaData.getDefaultInstance();
            this.f995common = Common.getDefaultInstance();
            this.sdkName = "";
            this.sdkVersion = 0L;
            this.actions = Collections.emptyList();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            } else if (!hasCommon()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!getCommon().isInitialized()) {
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
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeMessage(25, this.metadata);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeMessage(41, this.f995common);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(SDK_NAME_FIELD_NUMBER, getSdkNameBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(SDK_VERSION_FIELD_NUMBER, this.sdkVersion);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.actions.size()) {
                    codedOutputStream.writeMessage(ACTIONS_FIELD_NUMBER, this.actions.get(i2));
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
                int computeMessageSize = (this.bitField0 & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.metadata) + 0 : 0;
                if ((this.bitField0 & 2) == 2) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(41, this.f995common);
                }
                if ((this.bitField0 & 4) == 4) {
                    computeMessageSize += CodedOutputStream.computeBytesSize(SDK_NAME_FIELD_NUMBER, getSdkNameBytes());
                }
                if ((this.bitField0 & 8) == 8) {
                    computeMessageSize += CodedOutputStream.computeInt64Size(SDK_VERSION_FIELD_NUMBER, this.sdkVersion);
                }
                while (true) {
                    i2 = computeMessageSize;
                    if (i >= this.actions.size()) {
                        break;
                    }
                    computeMessageSize = CodedOutputStream.computeMessageSize(ACTIONS_FIELD_NUMBER, this.actions.get(i)) + i2;
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

        public static PushImClient parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PushImClient parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PushImClient parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PushImClient parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static PushImClient parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static PushImClient parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PushImClient parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PushImClient parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PushImClient parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PushImClient parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PushImClient pushImClient) {
            return newBuilder().mergeFrom(pushImClient);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<PushImClient, Builder> implements PushImClientOrBuilder {
            private int bitField0;
            private long sdkVersion;
            private MetaData metadata = MetaData.getDefaultInstance();

            /* renamed from: common  reason: collision with root package name */
            private Common f996common = Common.getDefaultInstance();
            private Object sdkName = "";
            private List<Action> actions = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.metadata = MetaData.getDefaultInstance();
                this.bitField0 &= -2;
                this.f996common = Common.getDefaultInstance();
                this.bitField0 &= -3;
                this.sdkName = "";
                this.bitField0 &= -5;
                this.sdkVersion = 0L;
                this.bitField0 &= -9;
                this.actions = Collections.emptyList();
                this.bitField0 &= -17;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public PushImClient getDefaultInstanceForType() {
                return PushImClient.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public PushImClient build() {
                PushImClient buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public PushImClient buildPartial() {
                PushImClient pushImClient = new PushImClient(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                pushImClient.metadata = this.metadata;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                pushImClient.f995common = this.f996common;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                pushImClient.sdkName = this.sdkName;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                pushImClient.sdkVersion = this.sdkVersion;
                if ((this.bitField0 & 16) == 16) {
                    this.actions = Collections.unmodifiableList(this.actions);
                    this.bitField0 &= -17;
                }
                pushImClient.actions = this.actions;
                pushImClient.bitField0 = i2;
                return pushImClient;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(PushImClient pushImClient) {
                if (pushImClient != PushImClient.getDefaultInstance()) {
                    if (pushImClient.hasMetadata()) {
                        mergeMetadata(pushImClient.getMetadata());
                    }
                    if (pushImClient.hasCommon()) {
                        mergeCommon(pushImClient.getCommon());
                    }
                    if (pushImClient.hasSdkName()) {
                        this.bitField0 |= 4;
                        this.sdkName = pushImClient.sdkName;
                    }
                    if (pushImClient.hasSdkVersion()) {
                        setSdkVersion(pushImClient.getSdkVersion());
                    }
                    if (!pushImClient.actions.isEmpty()) {
                        if (this.actions.isEmpty()) {
                            this.actions = pushImClient.actions;
                            this.bitField0 &= -17;
                        } else {
                            ensureActionsIsMutable();
                            this.actions.addAll(pushImClient.actions);
                        }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasCommon() && getCommon().isInitialized();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PushImClient pushImClient;
                Throwable th;
                try {
                    try {
                        PushImClient parsePartialFrom = PushImClient.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        pushImClient = null;
                        if (pushImClient != null) {
                            mergeFrom(pushImClient);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    PushImClient pushImClient2 = (PushImClient) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        pushImClient = pushImClient2;
                        th = th3;
                        if (pushImClient != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasMetadata() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public MetaData getMetadata() {
                return this.metadata;
            }

            public Builder setMetadata(MetaData metaData) {
                if (metaData == null) {
                    throw new NullPointerException();
                }
                this.metadata = metaData;
                this.bitField0 |= 1;
                return this;
            }

            public Builder setMetadata(MetaData.Builder builder) {
                this.metadata = builder.build();
                this.bitField0 |= 1;
                return this;
            }

            public Builder mergeMetadata(MetaData metaData) {
                if ((this.bitField0 & 1) == 1 && this.metadata != MetaData.getDefaultInstance()) {
                    this.metadata = MetaData.newBuilder(this.metadata).mergeFrom(metaData).buildPartial();
                } else {
                    this.metadata = metaData;
                }
                this.bitField0 |= 1;
                return this;
            }

            public Builder clearMetadata() {
                this.metadata = MetaData.getDefaultInstance();
                this.bitField0 &= -2;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasCommon() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public Common getCommon() {
                return this.f996common;
            }

            public Builder setCommon(Common common2) {
                if (common2 == null) {
                    throw new NullPointerException();
                }
                this.f996common = common2;
                this.bitField0 |= 2;
                return this;
            }

            public Builder setCommon(Common.Builder builder) {
                this.f996common = builder.build();
                this.bitField0 |= 2;
                return this;
            }

            public Builder mergeCommon(Common common2) {
                if ((this.bitField0 & 2) == 2 && this.f996common != Common.getDefaultInstance()) {
                    this.f996common = Common.newBuilder(this.f996common).mergeFrom(common2).buildPartial();
                } else {
                    this.f996common = common2;
                }
                this.bitField0 |= 2;
                return this;
            }

            public Builder clearCommon() {
                this.f996common = Common.getDefaultInstance();
                this.bitField0 &= -3;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasSdkName() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public String getSdkName() {
                Object obj = this.sdkName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.sdkName = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public ByteString getSdkNameBytes() {
                Object obj = this.sdkName;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sdkName = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setSdkName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.sdkName = str;
                return this;
            }

            public Builder clearSdkName() {
                this.bitField0 &= -5;
                this.sdkName = PushImClient.getDefaultInstance().getSdkName();
                return this;
            }

            public Builder setSdkNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.sdkName = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasSdkVersion() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public long getSdkVersion() {
                return this.sdkVersion;
            }

            public Builder setSdkVersion(long j) {
                this.bitField0 |= 8;
                this.sdkVersion = j;
                return this;
            }

            public Builder clearSdkVersion() {
                this.bitField0 &= -9;
                this.sdkVersion = 0L;
                return this;
            }

            private void ensureActionsIsMutable() {
                if ((this.bitField0 & 16) != 16) {
                    this.actions = new ArrayList(this.actions);
                    this.bitField0 |= 16;
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public List<Action> getActionsList() {
                return Collections.unmodifiableList(this.actions);
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public int getActionsCount() {
                return this.actions.size();
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public Action getActions(int i) {
                return this.actions.get(i);
            }

            public Builder setActions(int i, Action action) {
                if (action == null) {
                    throw new NullPointerException();
                }
                ensureActionsIsMutable();
                this.actions.set(i, action);
                return this;
            }

            public Builder setActions(int i, Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions.set(i, builder.build());
                return this;
            }

            public Builder addActions(Action action) {
                if (action == null) {
                    throw new NullPointerException();
                }
                ensureActionsIsMutable();
                this.actions.add(action);
                return this;
            }

            public Builder addActions(int i, Action action) {
                if (action == null) {
                    throw new NullPointerException();
                }
                ensureActionsIsMutable();
                this.actions.add(i, action);
                return this;
            }

            public Builder addActions(Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions.add(builder.build());
                return this;
            }

            public Builder addActions(int i, Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions.add(i, builder.build());
                return this;
            }

            public Builder addAllActions(Iterable<? extends Action> iterable) {
                ensureActionsIsMutable();
                GeneratedMessageLite.Builder.addAll(iterable, this.actions);
                return this;
            }

            public Builder clearActions() {
                this.actions = Collections.emptyList();
                this.bitField0 &= -17;
                return this;
            }

            public Builder removeActions(int i) {
                ensureActionsIsMutable();
                this.actions.remove(i);
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Action extends GeneratedMessageLite implements ActionOrBuilder {
        public static final int ACK_FIELD_NUMBER = 7;
        public static final int ACTION_TYPE_FIELD_NUMBER = 1;
        public static final int CONNECTION_FIELD_NUMBER = 5;
        public static final int CRASH_FIELD_NUMBER = 3;
        public static final int DB_FIELD_NUMBER = 4;
        public static final int MSG_FIELD_NUMBER = 8;
        public static final int REQUEST_FIELD_NUMBER = 6;
        public static final int UI_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private Ack ack;
        private ActionType actionType;
        private int bitField0;
        private Connection connection;
        private Crash crash;
        private Db db;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Msg msg;
        private Request request;
        private Ui ui;
        public static final Parser<Action> PARSER = new AbstractParser<Action>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Action.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Action parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Action(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Action defaultInstance = new Action(true);

        private Action(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Action(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Action getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Action getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Action(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                continue;
                                z2 = z;
                            case 8:
                                ActionType valueOf = ActionType.valueOf(codedInputStream.readEnum());
                                if (valueOf != null) {
                                    this.bitField0 |= 1;
                                    this.actionType = valueOf;
                                    z = z2;
                                    continue;
                                    z2 = z;
                                }
                                break;
                            case 18:
                                Ui.Builder builder = (this.bitField0 & 2) == 2 ? this.ui.toBuilder() : null;
                                this.ui = (Ui) codedInputStream.readMessage(Ui.PARSER, extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.ui);
                                    this.ui = builder.buildPartial();
                                }
                                this.bitField0 |= 2;
                                z = z2;
                                continue;
                                z2 = z;
                            case 26:
                                Crash.Builder builder2 = (this.bitField0 & 4) == 4 ? this.crash.toBuilder() : null;
                                this.crash = (Crash) codedInputStream.readMessage(Crash.PARSER, extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom(this.crash);
                                    this.crash = builder2.buildPartial();
                                }
                                this.bitField0 |= 4;
                                z = z2;
                                continue;
                                z2 = z;
                            case 34:
                                Db.Builder builder3 = (this.bitField0 & 8) == 8 ? this.db.toBuilder() : null;
                                this.db = (Db) codedInputStream.readMessage(Db.PARSER, extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom(this.db);
                                    this.db = builder3.buildPartial();
                                }
                                this.bitField0 |= 8;
                                z = z2;
                                continue;
                                z2 = z;
                            case 42:
                                Connection.Builder builder4 = (this.bitField0 & 16) == 16 ? this.connection.toBuilder() : null;
                                this.connection = (Connection) codedInputStream.readMessage(Connection.PARSER, extensionRegistryLite);
                                if (builder4 != null) {
                                    builder4.mergeFrom(this.connection);
                                    this.connection = builder4.buildPartial();
                                }
                                this.bitField0 |= 16;
                                z = z2;
                                continue;
                                z2 = z;
                            case 50:
                                Request.Builder builder5 = (this.bitField0 & 32) == 32 ? this.request.toBuilder() : null;
                                this.request = (Request) codedInputStream.readMessage(Request.PARSER, extensionRegistryLite);
                                if (builder5 != null) {
                                    builder5.mergeFrom(this.request);
                                    this.request = builder5.buildPartial();
                                }
                                this.bitField0 |= 32;
                                z = z2;
                                continue;
                                z2 = z;
                            case 58:
                                Ack.Builder builder6 = (this.bitField0 & 64) == 64 ? this.ack.toBuilder() : null;
                                this.ack = (Ack) codedInputStream.readMessage(Ack.PARSER, extensionRegistryLite);
                                if (builder6 != null) {
                                    builder6.mergeFrom(this.ack);
                                    this.ack = builder6.buildPartial();
                                }
                                this.bitField0 |= 64;
                                z = z2;
                                continue;
                                z2 = z;
                            case 66:
                                Msg.Builder builder7 = (this.bitField0 & 128) == 128 ? this.msg.toBuilder() : null;
                                this.msg = (Msg) codedInputStream.readMessage(Msg.PARSER, extensionRegistryLite);
                                if (builder7 != null) {
                                    builder7.mergeFrom(this.msg);
                                    this.msg = builder7.buildPartial();
                                }
                                this.bitField0 |= 128;
                                z = z2;
                                continue;
                                z2 = z;
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
        public Parser<Action> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasActionType() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public ActionType getActionType() {
            return this.actionType;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasUi() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Ui getUi() {
            return this.ui;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasCrash() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Crash getCrash() {
            return this.crash;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasDb() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Db getDb() {
            return this.db;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasConnection() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Connection getConnection() {
            return this.connection;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasRequest() {
            return (this.bitField0 & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Request getRequest() {
            return this.request;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasAck() {
            return (this.bitField0 & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Ack getAck() {
            return this.ack;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasMsg() {
            return (this.bitField0 & 128) == 128;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Msg getMsg() {
            return this.msg;
        }

        private void initFields() {
            this.actionType = ActionType.UI;
            this.ui = Ui.getDefaultInstance();
            this.crash = Crash.getDefaultInstance();
            this.db = Db.getDefaultInstance();
            this.connection = Connection.getDefaultInstance();
            this.request = Request.getDefaultInstance();
            this.ack = Ack.getDefaultInstance();
            this.msg = Msg.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeEnum(1, this.actionType.getNumber());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeMessage(2, this.ui);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeMessage(3, this.crash);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeMessage(4, this.db);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeMessage(5, this.connection);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeMessage(6, this.request);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeMessage(7, this.ack);
            }
            if ((this.bitField0 & 128) == 128) {
                codedOutputStream.writeMessage(8, this.msg);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.actionType.getNumber()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeMessageSize(2, this.ui);
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.crash);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeMessageSize(4, this.db);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeMessageSize(5, this.connection);
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeMessageSize(6, this.request);
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeMessageSize(7, this.ack);
                }
                if ((this.bitField0 & 128) == 128) {
                    i += CodedOutputStream.computeMessageSize(8, this.msg);
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

        public static Action parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Action parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Action parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Action parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Action parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Action parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Action parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Action parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Action parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Action parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Action action) {
            return newBuilder().mergeFrom(action);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Action, Builder> implements ActionOrBuilder {
            private int bitField0;
            private ActionType actionType = ActionType.UI;
            private Ui ui = Ui.getDefaultInstance();
            private Crash crash = Crash.getDefaultInstance();
            private Db db = Db.getDefaultInstance();
            private Connection connection = Connection.getDefaultInstance();
            private Request request = Request.getDefaultInstance();
            private Ack ack = Ack.getDefaultInstance();
            private Msg msg = Msg.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.actionType = ActionType.UI;
                this.bitField0 &= -2;
                this.ui = Ui.getDefaultInstance();
                this.bitField0 &= -3;
                this.crash = Crash.getDefaultInstance();
                this.bitField0 &= -5;
                this.db = Db.getDefaultInstance();
                this.bitField0 &= -9;
                this.connection = Connection.getDefaultInstance();
                this.bitField0 &= -17;
                this.request = Request.getDefaultInstance();
                this.bitField0 &= -33;
                this.ack = Ack.getDefaultInstance();
                this.bitField0 &= -65;
                this.msg = Msg.getDefaultInstance();
                this.bitField0 &= -129;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Action getDefaultInstanceForType() {
                return Action.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Action build() {
                Action buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Action buildPartial() {
                Action action = new Action(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                action.actionType = this.actionType;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                action.ui = this.ui;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                action.crash = this.crash;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                action.db = this.db;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                action.connection = this.connection;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                action.request = this.request;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                action.ack = this.ack;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                action.msg = this.msg;
                action.bitField0 = i2;
                return action;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Action action) {
                if (action != Action.getDefaultInstance()) {
                    if (action.hasActionType()) {
                        setActionType(action.getActionType());
                    }
                    if (action.hasUi()) {
                        mergeUi(action.getUi());
                    }
                    if (action.hasCrash()) {
                        mergeCrash(action.getCrash());
                    }
                    if (action.hasDb()) {
                        mergeDb(action.getDb());
                    }
                    if (action.hasConnection()) {
                        mergeConnection(action.getConnection());
                    }
                    if (action.hasRequest()) {
                        mergeRequest(action.getRequest());
                    }
                    if (action.hasAck()) {
                        mergeAck(action.getAck());
                    }
                    if (action.hasMsg()) {
                        mergeMsg(action.getMsg());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Action action;
                Throwable th;
                try {
                    try {
                        Action parsePartialFrom = Action.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        action = null;
                        if (action != null) {
                            mergeFrom(action);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Action action2 = (Action) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        action = action2;
                        th = th3;
                        if (action != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasActionType() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public ActionType getActionType() {
                return this.actionType;
            }

            public Builder setActionType(ActionType actionType) {
                if (actionType == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.actionType = actionType;
                return this;
            }

            public Builder clearActionType() {
                this.bitField0 &= -2;
                this.actionType = ActionType.UI;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasUi() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Ui getUi() {
                return this.ui;
            }

            public Builder setUi(Ui ui) {
                if (ui == null) {
                    throw new NullPointerException();
                }
                this.ui = ui;
                this.bitField0 |= 2;
                return this;
            }

            public Builder setUi(Ui.Builder builder) {
                this.ui = builder.build();
                this.bitField0 |= 2;
                return this;
            }

            public Builder mergeUi(Ui ui) {
                if ((this.bitField0 & 2) == 2 && this.ui != Ui.getDefaultInstance()) {
                    this.ui = Ui.newBuilder(this.ui).mergeFrom(ui).buildPartial();
                } else {
                    this.ui = ui;
                }
                this.bitField0 |= 2;
                return this;
            }

            public Builder clearUi() {
                this.ui = Ui.getDefaultInstance();
                this.bitField0 &= -3;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasCrash() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Crash getCrash() {
                return this.crash;
            }

            public Builder setCrash(Crash crash) {
                if (crash == null) {
                    throw new NullPointerException();
                }
                this.crash = crash;
                this.bitField0 |= 4;
                return this;
            }

            public Builder setCrash(Crash.Builder builder) {
                this.crash = builder.build();
                this.bitField0 |= 4;
                return this;
            }

            public Builder mergeCrash(Crash crash) {
                if ((this.bitField0 & 4) == 4 && this.crash != Crash.getDefaultInstance()) {
                    this.crash = Crash.newBuilder(this.crash).mergeFrom(crash).buildPartial();
                } else {
                    this.crash = crash;
                }
                this.bitField0 |= 4;
                return this;
            }

            public Builder clearCrash() {
                this.crash = Crash.getDefaultInstance();
                this.bitField0 &= -5;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasDb() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Db getDb() {
                return this.db;
            }

            public Builder setDb(Db db) {
                if (db == null) {
                    throw new NullPointerException();
                }
                this.db = db;
                this.bitField0 |= 8;
                return this;
            }

            public Builder setDb(Db.Builder builder) {
                this.db = builder.build();
                this.bitField0 |= 8;
                return this;
            }

            public Builder mergeDb(Db db) {
                if ((this.bitField0 & 8) == 8 && this.db != Db.getDefaultInstance()) {
                    this.db = Db.newBuilder(this.db).mergeFrom(db).buildPartial();
                } else {
                    this.db = db;
                }
                this.bitField0 |= 8;
                return this;
            }

            public Builder clearDb() {
                this.db = Db.getDefaultInstance();
                this.bitField0 &= -9;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasConnection() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Connection getConnection() {
                return this.connection;
            }

            public Builder setConnection(Connection connection) {
                if (connection == null) {
                    throw new NullPointerException();
                }
                this.connection = connection;
                this.bitField0 |= 16;
                return this;
            }

            public Builder setConnection(Connection.Builder builder) {
                this.connection = builder.build();
                this.bitField0 |= 16;
                return this;
            }

            public Builder mergeConnection(Connection connection) {
                if ((this.bitField0 & 16) == 16 && this.connection != Connection.getDefaultInstance()) {
                    this.connection = Connection.newBuilder(this.connection).mergeFrom(connection).buildPartial();
                } else {
                    this.connection = connection;
                }
                this.bitField0 |= 16;
                return this;
            }

            public Builder clearConnection() {
                this.connection = Connection.getDefaultInstance();
                this.bitField0 &= -17;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasRequest() {
                return (this.bitField0 & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Request getRequest() {
                return this.request;
            }

            public Builder setRequest(Request request) {
                if (request == null) {
                    throw new NullPointerException();
                }
                this.request = request;
                this.bitField0 |= 32;
                return this;
            }

            public Builder setRequest(Request.Builder builder) {
                this.request = builder.build();
                this.bitField0 |= 32;
                return this;
            }

            public Builder mergeRequest(Request request) {
                if ((this.bitField0 & 32) == 32 && this.request != Request.getDefaultInstance()) {
                    this.request = Request.newBuilder(this.request).mergeFrom(request).buildPartial();
                } else {
                    this.request = request;
                }
                this.bitField0 |= 32;
                return this;
            }

            public Builder clearRequest() {
                this.request = Request.getDefaultInstance();
                this.bitField0 &= -33;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasAck() {
                return (this.bitField0 & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Ack getAck() {
                return this.ack;
            }

            public Builder setAck(Ack ack) {
                if (ack == null) {
                    throw new NullPointerException();
                }
                this.ack = ack;
                this.bitField0 |= 64;
                return this;
            }

            public Builder setAck(Ack.Builder builder) {
                this.ack = builder.build();
                this.bitField0 |= 64;
                return this;
            }

            public Builder mergeAck(Ack ack) {
                if ((this.bitField0 & 64) == 64 && this.ack != Ack.getDefaultInstance()) {
                    this.ack = Ack.newBuilder(this.ack).mergeFrom(ack).buildPartial();
                } else {
                    this.ack = ack;
                }
                this.bitField0 |= 64;
                return this;
            }

            public Builder clearAck() {
                this.ack = Ack.getDefaultInstance();
                this.bitField0 &= -65;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasMsg() {
                return (this.bitField0 & 128) == 128;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Msg getMsg() {
                return this.msg;
            }

            public Builder setMsg(Msg msg) {
                if (msg == null) {
                    throw new NullPointerException();
                }
                this.msg = msg;
                this.bitField0 |= 128;
                return this;
            }

            public Builder setMsg(Msg.Builder builder) {
                this.msg = builder.build();
                this.bitField0 |= 128;
                return this;
            }

            public Builder mergeMsg(Msg msg) {
                if ((this.bitField0 & 128) == 128 && this.msg != Msg.getDefaultInstance()) {
                    this.msg = Msg.newBuilder(this.msg).mergeFrom(msg).buildPartial();
                } else {
                    this.msg = msg;
                }
                this.bitField0 |= 128;
                return this;
            }

            public Builder clearMsg() {
                this.msg = Msg.getDefaultInstance();
                this.bitField0 &= -129;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Ui extends GeneratedMessageLite implements UiOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int CATEGORY_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 5;
        public static final int END_TIME_FIELD_NUMBER = 4;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int PAGE_FIELD_NUMBER = 2;
        public static final int START_TIME_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private long aliasId;
        private int bitField0;
        private Object category;
        private long duration;
        private long endTime;
        private Object ext;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object page;
        private long startTime;
        public static final Parser<Ui> PARSER = new AbstractParser<Ui>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ui.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Ui parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Ui(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Ui defaultInstance = new Ui(true);

        private Ui(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Ui(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ui getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Ui getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Ui(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.category = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.page = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.bitField0 |= 4;
                                    this.startTime = codedInputStream.readInt64();
                                    break;
                                case 32:
                                    this.bitField0 |= 8;
                                    this.endTime = codedInputStream.readInt64();
                                    break;
                                case 40:
                                    this.bitField0 |= 16;
                                    this.duration = codedInputStream.readInt64();
                                    break;
                                case 50:
                                    this.bitField0 |= 32;
                                    this.ext = codedInputStream.readBytes();
                                    break;
                                case 56:
                                    this.bitField0 |= 64;
                                    this.aliasId = codedInputStream.readInt64();
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
        public Parser<Ui> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasCategory() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getCategory() {
            Object obj = this.category;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.category = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getCategoryBytes() {
            Object obj = this.category;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.category = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasPage() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getPage() {
            Object obj = this.page;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.page = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getPageBytes() {
            Object obj = this.page;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.page = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasStartTime() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getStartTime() {
            return this.startTime;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasEndTime() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getEndTime() {
            return this.endTime;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasDuration() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getDuration() {
            return this.duration;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasExt() {
            return (this.bitField0 & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0 & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getAliasId() {
            return this.aliasId;
        }

        private void initFields() {
            this.category = "";
            this.page = "";
            this.startTime = 0L;
            this.endTime = 0L;
            this.duration = 0L;
            this.ext = "";
            this.aliasId = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getCategoryBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getPageBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.startTime);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.endTime);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.duration);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getCategoryBytes()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getPageBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.startTime);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.endTime);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.duration);
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getExtBytes());
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.aliasId);
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

        public static Ui parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Ui parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Ui parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Ui parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Ui parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Ui parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Ui parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Ui parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Ui parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Ui parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Ui ui) {
            return newBuilder().mergeFrom(ui);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Ui, Builder> implements UiOrBuilder {
            private long aliasId;
            private int bitField0;
            private long duration;
            private long endTime;
            private long startTime;
            private Object category = "";
            private Object page = "";
            private Object ext = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.category = "";
                this.bitField0 &= -2;
                this.page = "";
                this.bitField0 &= -3;
                this.startTime = 0L;
                this.bitField0 &= -5;
                this.endTime = 0L;
                this.bitField0 &= -9;
                this.duration = 0L;
                this.bitField0 &= -17;
                this.ext = "";
                this.bitField0 &= -33;
                this.aliasId = 0L;
                this.bitField0 &= -65;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Ui getDefaultInstanceForType() {
                return Ui.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ui build() {
                Ui buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ui buildPartial() {
                Ui ui = new Ui(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                ui.category = this.category;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                ui.page = this.page;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                ui.startTime = this.startTime;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                ui.endTime = this.endTime;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                ui.duration = this.duration;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                ui.ext = this.ext;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                ui.aliasId = this.aliasId;
                ui.bitField0 = i2;
                return ui;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Ui ui) {
                if (ui != Ui.getDefaultInstance()) {
                    if (ui.hasCategory()) {
                        this.bitField0 |= 1;
                        this.category = ui.category;
                    }
                    if (ui.hasPage()) {
                        this.bitField0 |= 2;
                        this.page = ui.page;
                    }
                    if (ui.hasStartTime()) {
                        setStartTime(ui.getStartTime());
                    }
                    if (ui.hasEndTime()) {
                        setEndTime(ui.getEndTime());
                    }
                    if (ui.hasDuration()) {
                        setDuration(ui.getDuration());
                    }
                    if (ui.hasExt()) {
                        this.bitField0 |= 32;
                        this.ext = ui.ext;
                    }
                    if (ui.hasAliasId()) {
                        setAliasId(ui.getAliasId());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Ui ui;
                Throwable th;
                try {
                    try {
                        Ui parsePartialFrom = Ui.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        ui = null;
                        if (ui != null) {
                            mergeFrom(ui);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Ui ui2 = (Ui) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        ui = ui2;
                        th = th3;
                        if (ui != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasCategory() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getCategory() {
                Object obj = this.category;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.category = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getCategoryBytes() {
                Object obj = this.category;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.category = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setCategory(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.category = str;
                return this;
            }

            public Builder clearCategory() {
                this.bitField0 &= -2;
                this.category = Ui.getDefaultInstance().getCategory();
                return this;
            }

            public Builder setCategoryBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.category = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasPage() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getPage() {
                Object obj = this.page;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.page = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getPageBytes() {
                Object obj = this.page;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.page = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setPage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.page = str;
                return this;
            }

            public Builder clearPage() {
                this.bitField0 &= -3;
                this.page = Ui.getDefaultInstance().getPage();
                return this;
            }

            public Builder setPageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.page = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasStartTime() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getStartTime() {
                return this.startTime;
            }

            public Builder setStartTime(long j) {
                this.bitField0 |= 4;
                this.startTime = j;
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0 &= -5;
                this.startTime = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasEndTime() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getEndTime() {
                return this.endTime;
            }

            public Builder setEndTime(long j) {
                this.bitField0 |= 8;
                this.endTime = j;
                return this;
            }

            public Builder clearEndTime() {
                this.bitField0 &= -9;
                this.endTime = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasDuration() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getDuration() {
                return this.duration;
            }

            public Builder setDuration(long j) {
                this.bitField0 |= 16;
                this.duration = j;
                return this;
            }

            public Builder clearDuration() {
                this.bitField0 &= -17;
                this.duration = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasExt() {
                return (this.bitField0 & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setExt(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 32;
                this.ext = str;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -33;
                this.ext = Ui.getDefaultInstance().getExt();
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 32;
                this.ext = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0 & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getAliasId() {
                return this.aliasId;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 64;
                this.aliasId = j;
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0 &= -65;
                this.aliasId = 0L;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Crash extends GeneratedMessageLite implements CrashOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 4;
        public static final int EXCEPTION_FIELD_NUMBER = 1;
        public static final int EXT_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private long aliasId;
        private int bitField0;
        private Object exception;
        private Object ext;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long timestamp;
        public static final Parser<Crash> PARSER = new AbstractParser<Crash>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Crash.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Crash parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Crash(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Crash defaultInstance = new Crash(true);

        private Crash(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Crash(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Crash getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Crash getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Crash(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.exception = codedInputStream.readBytes();
                                    break;
                                case 16:
                                    this.bitField0 |= 2;
                                    this.timestamp = codedInputStream.readInt64();
                                    break;
                                case 26:
                                    this.bitField0 |= 4;
                                    this.ext = codedInputStream.readBytes();
                                    break;
                                case 32:
                                    this.bitField0 |= 8;
                                    this.aliasId = codedInputStream.readInt64();
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
        public Parser<Crash> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasException() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public String getException() {
            Object obj = this.exception;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.exception = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public ByteString getExceptionBytes() {
            Object obj = this.exception;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.exception = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasExt() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public long getAliasId() {
            return this.aliasId;
        }

        private void initFields() {
            this.exception = "";
            this.timestamp = 0L;
            this.ext = "";
            this.aliasId = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getExceptionBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeInt64(2, this.timestamp);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getExtBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.aliasId);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getExceptionBytes()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.timestamp);
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getExtBytes());
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.aliasId);
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

        public static Crash parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Crash parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Crash parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Crash parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Crash parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Crash parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Crash parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Crash parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Crash parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Crash parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Crash crash) {
            return newBuilder().mergeFrom(crash);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Crash, Builder> implements CrashOrBuilder {
            private long aliasId;
            private int bitField0;
            private Object exception = "";
            private Object ext = "";
            private long timestamp;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.exception = "";
                this.bitField0 &= -2;
                this.timestamp = 0L;
                this.bitField0 &= -3;
                this.ext = "";
                this.bitField0 &= -5;
                this.aliasId = 0L;
                this.bitField0 &= -9;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Crash getDefaultInstanceForType() {
                return Crash.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Crash build() {
                Crash buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Crash buildPartial() {
                Crash crash = new Crash(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                crash.exception = this.exception;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                crash.timestamp = this.timestamp;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                crash.ext = this.ext;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                crash.aliasId = this.aliasId;
                crash.bitField0 = i2;
                return crash;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Crash crash) {
                if (crash != Crash.getDefaultInstance()) {
                    if (crash.hasException()) {
                        this.bitField0 |= 1;
                        this.exception = crash.exception;
                    }
                    if (crash.hasTimestamp()) {
                        setTimestamp(crash.getTimestamp());
                    }
                    if (crash.hasExt()) {
                        this.bitField0 |= 4;
                        this.ext = crash.ext;
                    }
                    if (crash.hasAliasId()) {
                        setAliasId(crash.getAliasId());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Crash crash;
                Throwable th;
                try {
                    try {
                        Crash parsePartialFrom = Crash.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        crash = null;
                        if (crash != null) {
                            mergeFrom(crash);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Crash crash2 = (Crash) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        crash = crash2;
                        th = th3;
                        if (crash != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasException() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public String getException() {
                Object obj = this.exception;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.exception = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public ByteString getExceptionBytes() {
                Object obj = this.exception;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.exception = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setException(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.exception = str;
                return this;
            }

            public Builder clearException() {
                this.bitField0 &= -2;
                this.exception = Crash.getDefaultInstance().getException();
                return this;
            }

            public Builder setExceptionBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.exception = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasTimestamp() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public long getTimestamp() {
                return this.timestamp;
            }

            public Builder setTimestamp(long j) {
                this.bitField0 |= 2;
                this.timestamp = j;
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0 &= -3;
                this.timestamp = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasExt() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setExt(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.ext = str;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -5;
                this.ext = Crash.getDefaultInstance().getExt();
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.ext = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public long getAliasId() {
                return this.aliasId;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 8;
                this.aliasId = j;
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0 &= -9;
                this.aliasId = 0L;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Db extends GeneratedMessageLite implements DbOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 4;
        public static final int ALIAS_ID_FIELD_NUMBER = 9;
        public static final int CLASS_NAME_FIELD_NUMBER = 2;
        public static final int DURATION_FIELD_NUMBER = 7;
        public static final int END_TIME_FIELD_NUMBER = 6;
        public static final int EXT_FIELD_NUMBER = 8;
        public static final int METHOD_FIELD_NUMBER = 3;
        public static final int START_TIME_FIELD_NUMBER = 5;
        public static final int TABLE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private Object action;
        private long aliasId;
        private int bitField0;
        private Object className;
        private long duration;
        private long endTime;
        private Object ext;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object method;
        private long startTime;
        private Object table;
        public static final Parser<Db> PARSER = new AbstractParser<Db>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Db.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Db parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Db(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Db defaultInstance = new Db(true);

        private Db(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Db(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Db getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Db getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Db(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.table = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.className = codedInputStream.readBytes();
                                    break;
                                case 26:
                                    this.bitField0 |= 4;
                                    this.method = codedInputStream.readBytes();
                                    break;
                                case 34:
                                    this.bitField0 |= 8;
                                    this.action = codedInputStream.readBytes();
                                    break;
                                case 40:
                                    this.bitField0 |= 16;
                                    this.startTime = codedInputStream.readInt64();
                                    break;
                                case 48:
                                    this.bitField0 |= 32;
                                    this.endTime = codedInputStream.readInt64();
                                    break;
                                case 56:
                                    this.bitField0 |= 64;
                                    this.duration = codedInputStream.readInt64();
                                    break;
                                case 66:
                                    this.bitField0 |= 128;
                                    this.ext = codedInputStream.readBytes();
                                    break;
                                case 72:
                                    this.bitField0 |= 256;
                                    this.aliasId = codedInputStream.readInt64();
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
        public Parser<Db> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasTable() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getTable() {
            Object obj = this.table;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.table = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getTableBytes() {
            Object obj = this.table;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.table = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasClassName() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getClassName() {
            Object obj = this.className;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.className = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getClassNameBytes() {
            Object obj = this.className;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.className = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasMethod() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getMethod() {
            Object obj = this.method;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.method = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getMethodBytes() {
            Object obj = this.method;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.method = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasAction() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getAction() {
            Object obj = this.action;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.action = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getActionBytes() {
            Object obj = this.action;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.action = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasStartTime() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getStartTime() {
            return this.startTime;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasEndTime() {
            return (this.bitField0 & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getEndTime() {
            return this.endTime;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasDuration() {
            return (this.bitField0 & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getDuration() {
            return this.duration;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasExt() {
            return (this.bitField0 & 128) == 128;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0 & 256) == 256;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getAliasId() {
            return this.aliasId;
        }

        private void initFields() {
            this.table = "";
            this.className = "";
            this.method = "";
            this.action = "";
            this.startTime = 0L;
            this.endTime = 0L;
            this.duration = 0L;
            this.ext = "";
            this.aliasId = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getTableBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getClassNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getMethodBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeBytes(4, getActionBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.startTime);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeInt64(6, this.endTime);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.duration);
            }
            if ((this.bitField0 & 128) == 128) {
                codedOutputStream.writeBytes(8, getExtBytes());
            }
            if ((this.bitField0 & 256) == 256) {
                codedOutputStream.writeInt64(9, this.aliasId);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTableBytes()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getClassNameBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getMethodBytes());
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getActionBytes());
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.startTime);
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeInt64Size(6, this.endTime);
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.duration);
                }
                if ((this.bitField0 & 128) == 128) {
                    i += CodedOutputStream.computeBytesSize(8, getExtBytes());
                }
                if ((this.bitField0 & 256) == 256) {
                    i += CodedOutputStream.computeInt64Size(9, this.aliasId);
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

        public static Db parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Db parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Db parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Db parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Db parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Db parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Db parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Db parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Db parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Db parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Db db) {
            return newBuilder().mergeFrom(db);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Db, Builder> implements DbOrBuilder {
            private long aliasId;
            private int bitField0;
            private long duration;
            private long endTime;
            private long startTime;
            private Object table = "";
            private Object className = "";
            private Object method = "";
            private Object action = "";
            private Object ext = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.table = "";
                this.bitField0 &= -2;
                this.className = "";
                this.bitField0 &= -3;
                this.method = "";
                this.bitField0 &= -5;
                this.action = "";
                this.bitField0 &= -9;
                this.startTime = 0L;
                this.bitField0 &= -17;
                this.endTime = 0L;
                this.bitField0 &= -33;
                this.duration = 0L;
                this.bitField0 &= -65;
                this.ext = "";
                this.bitField0 &= -129;
                this.aliasId = 0L;
                this.bitField0 &= -257;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Db getDefaultInstanceForType() {
                return Db.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Db build() {
                Db buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Db buildPartial() {
                Db db = new Db(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                db.table = this.table;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                db.className = this.className;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                db.method = this.method;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                db.action = this.action;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                db.startTime = this.startTime;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                db.endTime = this.endTime;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                db.duration = this.duration;
                if ((i & 128) == 128) {
                    i2 |= 128;
                }
                db.ext = this.ext;
                if ((i & 256) == 256) {
                    i2 |= 256;
                }
                db.aliasId = this.aliasId;
                db.bitField0 = i2;
                return db;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Db db) {
                if (db != Db.getDefaultInstance()) {
                    if (db.hasTable()) {
                        this.bitField0 |= 1;
                        this.table = db.table;
                    }
                    if (db.hasClassName()) {
                        this.bitField0 |= 2;
                        this.className = db.className;
                    }
                    if (db.hasMethod()) {
                        this.bitField0 |= 4;
                        this.method = db.method;
                    }
                    if (db.hasAction()) {
                        this.bitField0 |= 8;
                        this.action = db.action;
                    }
                    if (db.hasStartTime()) {
                        setStartTime(db.getStartTime());
                    }
                    if (db.hasEndTime()) {
                        setEndTime(db.getEndTime());
                    }
                    if (db.hasDuration()) {
                        setDuration(db.getDuration());
                    }
                    if (db.hasExt()) {
                        this.bitField0 |= 128;
                        this.ext = db.ext;
                    }
                    if (db.hasAliasId()) {
                        setAliasId(db.getAliasId());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Db db;
                Throwable th;
                try {
                    try {
                        Db parsePartialFrom = Db.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        db = null;
                        if (db != null) {
                            mergeFrom(db);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Db db2 = (Db) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        db = db2;
                        th = th3;
                        if (db != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasTable() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getTable() {
                Object obj = this.table;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.table = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getTableBytes() {
                Object obj = this.table;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.table = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setTable(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.table = str;
                return this;
            }

            public Builder clearTable() {
                this.bitField0 &= -2;
                this.table = Db.getDefaultInstance().getTable();
                return this;
            }

            public Builder setTableBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.table = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasClassName() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getClassName() {
                Object obj = this.className;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.className = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getClassNameBytes() {
                Object obj = this.className;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.className = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setClassName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.className = str;
                return this;
            }

            public Builder clearClassName() {
                this.bitField0 &= -3;
                this.className = Db.getDefaultInstance().getClassName();
                return this;
            }

            public Builder setClassNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.className = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasMethod() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getMethod() {
                Object obj = this.method;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.method = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getMethodBytes() {
                Object obj = this.method;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.method = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setMethod(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.method = str;
                return this;
            }

            public Builder clearMethod() {
                this.bitField0 &= -5;
                this.method = Db.getDefaultInstance().getMethod();
                return this;
            }

            public Builder setMethodBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.method = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasAction() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getAction() {
                Object obj = this.action;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.action = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getActionBytes() {
                Object obj = this.action;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.action = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setAction(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 8;
                this.action = str;
                return this;
            }

            public Builder clearAction() {
                this.bitField0 &= -9;
                this.action = Db.getDefaultInstance().getAction();
                return this;
            }

            public Builder setActionBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 8;
                this.action = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasStartTime() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getStartTime() {
                return this.startTime;
            }

            public Builder setStartTime(long j) {
                this.bitField0 |= 16;
                this.startTime = j;
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0 &= -17;
                this.startTime = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasEndTime() {
                return (this.bitField0 & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getEndTime() {
                return this.endTime;
            }

            public Builder setEndTime(long j) {
                this.bitField0 |= 32;
                this.endTime = j;
                return this;
            }

            public Builder clearEndTime() {
                this.bitField0 &= -33;
                this.endTime = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasDuration() {
                return (this.bitField0 & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getDuration() {
                return this.duration;
            }

            public Builder setDuration(long j) {
                this.bitField0 |= 64;
                this.duration = j;
                return this;
            }

            public Builder clearDuration() {
                this.bitField0 &= -65;
                this.duration = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasExt() {
                return (this.bitField0 & 128) == 128;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setExt(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 128;
                this.ext = str;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -129;
                this.ext = Db.getDefaultInstance().getExt();
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 128;
                this.ext = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0 & 256) == 256;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getAliasId() {
                return this.aliasId;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 256;
                this.aliasId = j;
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0 &= -257;
                this.aliasId = 0L;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Connection extends GeneratedMessageLite implements ConnectionOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int REASON_FIELD_NUMBER = 3;
        public static final int RETRY_COUNT_FIELD_NUMBER = 5;
        public static final int RETRY_TIME_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 1;
        public static final int STOP_TIME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private long aliasId;
        private int bitField0;
        private Object ext;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object reason;
        private long retryCount;
        private long retryTime;
        private long startTime;
        private long stopTime;
        public static final Parser<Connection> PARSER = new AbstractParser<Connection>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Connection.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Connection parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Connection(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Connection defaultInstance = new Connection(true);

        private Connection(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Connection(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Connection getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Connection getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Connection(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.startTime = codedInputStream.readInt64();
                                    break;
                                case 16:
                                    this.bitField0 |= 2;
                                    this.stopTime = codedInputStream.readInt64();
                                    break;
                                case 26:
                                    this.bitField0 |= 4;
                                    this.reason = codedInputStream.readBytes();
                                    break;
                                case 32:
                                    this.bitField0 |= 8;
                                    this.retryTime = codedInputStream.readInt64();
                                    break;
                                case 40:
                                    this.bitField0 |= 16;
                                    this.retryCount = codedInputStream.readInt64();
                                    break;
                                case 50:
                                    this.bitField0 |= 32;
                                    this.ext = codedInputStream.readBytes();
                                    break;
                                case 56:
                                    this.bitField0 |= 64;
                                    this.aliasId = codedInputStream.readInt64();
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
        public Parser<Connection> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasStartTime() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getStartTime() {
            return this.startTime;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasStopTime() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getStopTime() {
            return this.stopTime;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasReason() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public String getReason() {
            Object obj = this.reason;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.reason = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasRetryTime() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getRetryTime() {
            return this.retryTime;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasRetryCount() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getRetryCount() {
            return this.retryCount;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasExt() {
            return (this.bitField0 & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0 & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getAliasId() {
            return this.aliasId;
        }

        private void initFields() {
            this.startTime = 0L;
            this.stopTime = 0L;
            this.reason = "";
            this.retryTime = 0L;
            this.retryCount = 0L;
            this.ext = "";
            this.aliasId = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt64(1, this.startTime);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeInt64(2, this.stopTime);
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getReasonBytes());
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.retryTime);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.retryCount);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.startTime) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeInt64Size(2, this.stopTime);
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getReasonBytes());
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.retryTime);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.retryCount);
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getExtBytes());
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.aliasId);
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

        public static Connection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Connection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Connection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Connection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Connection parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Connection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Connection parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Connection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Connection parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Connection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Connection connection) {
            return newBuilder().mergeFrom(connection);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Connection, Builder> implements ConnectionOrBuilder {
            private long aliasId;
            private int bitField0;
            private long retryCount;
            private long retryTime;
            private long startTime;
            private long stopTime;
            private Object reason = "";
            private Object ext = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.startTime = 0L;
                this.bitField0 &= -2;
                this.stopTime = 0L;
                this.bitField0 &= -3;
                this.reason = "";
                this.bitField0 &= -5;
                this.retryTime = 0L;
                this.bitField0 &= -9;
                this.retryCount = 0L;
                this.bitField0 &= -17;
                this.ext = "";
                this.bitField0 &= -33;
                this.aliasId = 0L;
                this.bitField0 &= -65;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Connection getDefaultInstanceForType() {
                return Connection.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Connection build() {
                Connection buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Connection buildPartial() {
                Connection connection = new Connection(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                connection.startTime = this.startTime;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                connection.stopTime = this.stopTime;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                connection.reason = this.reason;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                connection.retryTime = this.retryTime;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                connection.retryCount = this.retryCount;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                connection.ext = this.ext;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                connection.aliasId = this.aliasId;
                connection.bitField0 = i2;
                return connection;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Connection connection) {
                if (connection != Connection.getDefaultInstance()) {
                    if (connection.hasStartTime()) {
                        setStartTime(connection.getStartTime());
                    }
                    if (connection.hasStopTime()) {
                        setStopTime(connection.getStopTime());
                    }
                    if (connection.hasReason()) {
                        this.bitField0 |= 4;
                        this.reason = connection.reason;
                    }
                    if (connection.hasRetryTime()) {
                        setRetryTime(connection.getRetryTime());
                    }
                    if (connection.hasRetryCount()) {
                        setRetryCount(connection.getRetryCount());
                    }
                    if (connection.hasExt()) {
                        this.bitField0 |= 32;
                        this.ext = connection.ext;
                    }
                    if (connection.hasAliasId()) {
                        setAliasId(connection.getAliasId());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Connection connection;
                Throwable th;
                try {
                    try {
                        Connection parsePartialFrom = Connection.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        connection = null;
                        if (connection != null) {
                            mergeFrom(connection);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Connection connection2 = (Connection) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        connection = connection2;
                        th = th3;
                        if (connection != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasStartTime() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getStartTime() {
                return this.startTime;
            }

            public Builder setStartTime(long j) {
                this.bitField0 |= 1;
                this.startTime = j;
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0 &= -2;
                this.startTime = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasStopTime() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getStopTime() {
                return this.stopTime;
            }

            public Builder setStopTime(long j) {
                this.bitField0 |= 2;
                this.stopTime = j;
                return this;
            }

            public Builder clearStopTime() {
                this.bitField0 &= -3;
                this.stopTime = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasReason() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public String getReason() {
                Object obj = this.reason;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.reason = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setReason(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.reason = str;
                return this;
            }

            public Builder clearReason() {
                this.bitField0 &= -5;
                this.reason = Connection.getDefaultInstance().getReason();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.reason = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasRetryTime() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getRetryTime() {
                return this.retryTime;
            }

            public Builder setRetryTime(long j) {
                this.bitField0 |= 8;
                this.retryTime = j;
                return this;
            }

            public Builder clearRetryTime() {
                this.bitField0 &= -9;
                this.retryTime = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasRetryCount() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getRetryCount() {
                return this.retryCount;
            }

            public Builder setRetryCount(long j) {
                this.bitField0 |= 16;
                this.retryCount = j;
                return this;
            }

            public Builder clearRetryCount() {
                this.bitField0 &= -17;
                this.retryCount = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasExt() {
                return (this.bitField0 & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setExt(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 32;
                this.ext = str;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -33;
                this.ext = Connection.getDefaultInstance().getExt();
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 32;
                this.ext = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0 & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getAliasId() {
                return this.aliasId;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 64;
                this.aliasId = j;
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0 &= -65;
                this.aliasId = 0L;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Request extends GeneratedMessageLite implements RequestOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int ERROR_CODE_FIELD_NUMBER = 5;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int METHOD_FIELD_NUMBER = 1;
        public static final int REQUEST_ID_FIELD_NUMBER = 2;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private long aliasId;
        private int bitField0;
        private long errorCode;
        private Object ext;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object method;
        private Object requestId;
        private long responseTime;
        private long timestamp;
        public static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Request.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Request defaultInstance = new Request(true);

        private Request(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Request(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Request getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Request getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.method = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.requestId = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.bitField0 |= 4;
                                    this.timestamp = codedInputStream.readInt64();
                                    break;
                                case 32:
                                    this.bitField0 |= 8;
                                    this.responseTime = codedInputStream.readInt64();
                                    break;
                                case 40:
                                    this.bitField0 |= 16;
                                    this.errorCode = codedInputStream.readInt64();
                                    break;
                                case 50:
                                    this.bitField0 |= 32;
                                    this.ext = codedInputStream.readBytes();
                                    break;
                                case 56:
                                    this.bitField0 |= 64;
                                    this.aliasId = codedInputStream.readInt64();
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
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasMethod() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getMethod() {
            Object obj = this.method;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.method = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getMethodBytes() {
            Object obj = this.method;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.method = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasRequestId() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getRequestId() {
            Object obj = this.requestId;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.requestId = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasResponseTime() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getResponseTime() {
            return this.responseTime;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasErrorCode() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getErrorCode() {
            return this.errorCode;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasExt() {
            return (this.bitField0 & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0 & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getAliasId() {
            return this.aliasId;
        }

        private void initFields() {
            this.method = "";
            this.requestId = "";
            this.timestamp = 0L;
            this.responseTime = 0L;
            this.errorCode = 0L;
            this.ext = "";
            this.aliasId = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getMethodBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getRequestIdBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.timestamp);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.responseTime);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.errorCode);
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getMethodBytes()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getRequestIdBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.timestamp);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.responseTime);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.errorCode);
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, getExtBytes());
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.aliasId);
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

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Request request) {
            return newBuilder().mergeFrom(request);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Request, Builder> implements RequestOrBuilder {
            private long aliasId;
            private int bitField0;
            private long errorCode;
            private long responseTime;
            private long timestamp;
            private Object method = "";
            private Object requestId = "";
            private Object ext = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.method = "";
                this.bitField0 &= -2;
                this.requestId = "";
                this.bitField0 &= -3;
                this.timestamp = 0L;
                this.bitField0 &= -5;
                this.responseTime = 0L;
                this.bitField0 &= -9;
                this.errorCode = 0L;
                this.bitField0 &= -17;
                this.ext = "";
                this.bitField0 &= -33;
                this.aliasId = 0L;
                this.bitField0 &= -65;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Request build() {
                Request buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Request buildPartial() {
                Request request = new Request(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                request.method = this.method;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                request.requestId = this.requestId;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                request.timestamp = this.timestamp;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                request.responseTime = this.responseTime;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                request.errorCode = this.errorCode;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                request.ext = this.ext;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                request.aliasId = this.aliasId;
                request.bitField0 = i2;
                return request;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Request request) {
                if (request != Request.getDefaultInstance()) {
                    if (request.hasMethod()) {
                        this.bitField0 |= 1;
                        this.method = request.method;
                    }
                    if (request.hasRequestId()) {
                        this.bitField0 |= 2;
                        this.requestId = request.requestId;
                    }
                    if (request.hasTimestamp()) {
                        setTimestamp(request.getTimestamp());
                    }
                    if (request.hasResponseTime()) {
                        setResponseTime(request.getResponseTime());
                    }
                    if (request.hasErrorCode()) {
                        setErrorCode(request.getErrorCode());
                    }
                    if (request.hasExt()) {
                        this.bitField0 |= 32;
                        this.ext = request.ext;
                    }
                    if (request.hasAliasId()) {
                        setAliasId(request.getAliasId());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Request request;
                Throwable th;
                try {
                    try {
                        Request parsePartialFrom = Request.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        request = null;
                        if (request != null) {
                            mergeFrom(request);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Request request2 = (Request) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        request = request2;
                        th = th3;
                        if (request != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasMethod() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getMethod() {
                Object obj = this.method;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.method = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getMethodBytes() {
                Object obj = this.method;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.method = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setMethod(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.method = str;
                return this;
            }

            public Builder clearMethod() {
                this.bitField0 &= -2;
                this.method = Request.getDefaultInstance().getMethod();
                return this;
            }

            public Builder setMethodBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.method = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasRequestId() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getRequestId() {
                Object obj = this.requestId;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestId = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setRequestId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.requestId = str;
                return this;
            }

            public Builder clearRequestId() {
                this.bitField0 &= -3;
                this.requestId = Request.getDefaultInstance().getRequestId();
                return this;
            }

            public Builder setRequestIdBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.requestId = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasTimestamp() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getTimestamp() {
                return this.timestamp;
            }

            public Builder setTimestamp(long j) {
                this.bitField0 |= 4;
                this.timestamp = j;
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0 &= -5;
                this.timestamp = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasResponseTime() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getResponseTime() {
                return this.responseTime;
            }

            public Builder setResponseTime(long j) {
                this.bitField0 |= 8;
                this.responseTime = j;
                return this;
            }

            public Builder clearResponseTime() {
                this.bitField0 &= -9;
                this.responseTime = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasErrorCode() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getErrorCode() {
                return this.errorCode;
            }

            public Builder setErrorCode(long j) {
                this.bitField0 |= 16;
                this.errorCode = j;
                return this;
            }

            public Builder clearErrorCode() {
                this.bitField0 &= -17;
                this.errorCode = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasExt() {
                return (this.bitField0 & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setExt(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 32;
                this.ext = str;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -33;
                this.ext = Request.getDefaultInstance().getExt();
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 32;
                this.ext = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0 & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getAliasId() {
                return this.aliasId;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 64;
                this.aliasId = j;
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0 &= -65;
                this.aliasId = 0L;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Ack extends GeneratedMessageLite implements AckOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 5;
        public static final int EXT_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private long aliasId;
        private int bitField0;
        private Object ext;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long timestamp;
        private Object type;
        private Object value;
        public static final Parser<Ack> PARSER = new AbstractParser<Ack>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ack.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Ack parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Ack(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Ack defaultInstance = new Ack(true);

        private Ack(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Ack(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ack getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Ack getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Ack(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.type = codedInputStream.readBytes();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.value = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.bitField0 |= 4;
                                    this.timestamp = codedInputStream.readInt64();
                                    break;
                                case 34:
                                    this.bitField0 |= 8;
                                    this.ext = codedInputStream.readBytes();
                                    break;
                                case 40:
                                    this.bitField0 |= 16;
                                    this.aliasId = codedInputStream.readInt64();
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
        public Parser<Ack> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasType() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getType() {
            Object obj = this.type;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.type = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasValue() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getValue() {
            Object obj = this.value;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.value = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getValueBytes() {
            Object obj = this.value;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.value = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasExt() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public long getAliasId() {
            return this.aliasId;
        }

        private void initFields() {
            this.type = "";
            this.value = "";
            this.timestamp = 0L;
            this.ext = "";
            this.aliasId = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeBytes(1, getTypeBytes());
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getValueBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.timestamp);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeBytes(4, getExtBytes());
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeInt64(5, this.aliasId);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTypeBytes()) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getValueBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.timestamp);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeBytesSize(4, getExtBytes());
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeInt64Size(5, this.aliasId);
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

        public static Ack parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Ack parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Ack parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Ack parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Ack parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Ack parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Ack parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Ack parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Ack parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Ack parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Ack ack) {
            return newBuilder().mergeFrom(ack);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Ack, Builder> implements AckOrBuilder {
            private long aliasId;
            private int bitField0;
            private long timestamp;
            private Object type = "";
            private Object value = "";
            private Object ext = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.type = "";
                this.bitField0 &= -2;
                this.value = "";
                this.bitField0 &= -3;
                this.timestamp = 0L;
                this.bitField0 &= -5;
                this.ext = "";
                this.bitField0 &= -9;
                this.aliasId = 0L;
                this.bitField0 &= -17;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Ack getDefaultInstanceForType() {
                return Ack.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ack build() {
                Ack buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ack buildPartial() {
                Ack ack = new Ack(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                ack.type = this.type;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                ack.value = this.value;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                ack.timestamp = this.timestamp;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                ack.ext = this.ext;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                ack.aliasId = this.aliasId;
                ack.bitField0 = i2;
                return ack;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Ack ack) {
                if (ack != Ack.getDefaultInstance()) {
                    if (ack.hasType()) {
                        this.bitField0 |= 1;
                        this.type = ack.type;
                    }
                    if (ack.hasValue()) {
                        this.bitField0 |= 2;
                        this.value = ack.value;
                    }
                    if (ack.hasTimestamp()) {
                        setTimestamp(ack.getTimestamp());
                    }
                    if (ack.hasExt()) {
                        this.bitField0 |= 8;
                        this.ext = ack.ext;
                    }
                    if (ack.hasAliasId()) {
                        setAliasId(ack.getAliasId());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Ack ack;
                Throwable th;
                try {
                    try {
                        Ack parsePartialFrom = Ack.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        ack = null;
                        if (ack != null) {
                            mergeFrom(ack);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Ack ack2 = (Ack) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        ack = ack2;
                        th = th3;
                        if (ack != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasType() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getType() {
                Object obj = this.type;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setType(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.type = str;
                return this;
            }

            public Builder clearType() {
                this.bitField0 &= -2;
                this.type = Ack.getDefaultInstance().getType();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 1;
                this.type = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasValue() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getValue() {
                Object obj = this.value;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.value = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getValueBytes() {
                Object obj = this.value;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.value = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setValue(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.value = str;
                return this;
            }

            public Builder clearValue() {
                this.bitField0 &= -3;
                this.value = Ack.getDefaultInstance().getValue();
                return this;
            }

            public Builder setValueBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.value = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasTimestamp() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public long getTimestamp() {
                return this.timestamp;
            }

            public Builder setTimestamp(long j) {
                this.bitField0 |= 4;
                this.timestamp = j;
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0 &= -5;
                this.timestamp = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasExt() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setExt(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 8;
                this.ext = str;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -9;
                this.ext = Ack.getDefaultInstance().getExt();
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 8;
                this.ext = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public long getAliasId() {
                return this.aliasId;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 16;
                this.aliasId = j;
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0 &= -17;
                this.aliasId = 0L;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class Msg extends GeneratedMessageLite implements MsgOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 6;
        public static final int DURATION_FIELD_NUMBER = 3;
        public static final int END_MSGID_FIELD_NUMBER = 4;
        public static final int EXT_FIELD_NUMBER = 5;
        public static final int MSG_COUNT_FIELD_NUMBER = 1;
        public static final int ROOM_ID_FIELD_NUMBER = 2;
        public static final int START_MSGID_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private long aliasId;
        private int bitField0;
        private long duration;
        private long endMsgid;
        private Object ext;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long msgCount;
        private Object roomId;
        private long startMsgid;
        public static final Parser<Msg> PARSER = new AbstractParser<Msg>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Msg.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Msg parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Msg(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Msg defaultInstance = new Msg(true);

        private Msg(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private Msg(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Msg getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Msg getDefaultInstanceForType() {
            return defaultInstance;
        }

        private Msg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.msgCount = codedInputStream.readInt64();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.roomId = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.bitField0 |= 4;
                                    this.duration = codedInputStream.readInt64();
                                    break;
                                case 32:
                                    this.bitField0 |= 8;
                                    this.endMsgid = codedInputStream.readInt64();
                                    break;
                                case 42:
                                    this.bitField0 |= 16;
                                    this.ext = codedInputStream.readBytes();
                                    break;
                                case 48:
                                    this.bitField0 |= 32;
                                    this.aliasId = codedInputStream.readInt64();
                                    break;
                                case 56:
                                    this.bitField0 |= 64;
                                    this.startMsgid = codedInputStream.readInt64();
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
        public Parser<Msg> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasMsgCount() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getMsgCount() {
            return this.msgCount;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasRoomId() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public String getRoomId() {
            Object obj = this.roomId;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.roomId = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public ByteString getRoomIdBytes() {
            Object obj = this.roomId;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomId = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasDuration() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getDuration() {
            return this.duration;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasEndMsgid() {
            return (this.bitField0 & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getEndMsgid() {
            return this.endMsgid;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasExt() {
            return (this.bitField0 & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public String getExt() {
            Object obj = this.ext;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0 & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getAliasId() {
            return this.aliasId;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasStartMsgid() {
            return (this.bitField0 & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getStartMsgid() {
            return this.startMsgid;
        }

        private void initFields() {
            this.msgCount = 0L;
            this.roomId = "";
            this.duration = 0L;
            this.endMsgid = 0L;
            this.ext = "";
            this.aliasId = 0L;
            this.startMsgid = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt64(1, this.msgCount);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getRoomIdBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.duration);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.endMsgid);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeBytes(5, getExtBytes());
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeInt64(6, this.aliasId);
            }
            if ((this.bitField0 & 64) == 64) {
                codedOutputStream.writeInt64(7, this.startMsgid);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.msgCount) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getRoomIdBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.duration);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.endMsgid);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getExtBytes());
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeInt64Size(6, this.aliasId);
                }
                if ((this.bitField0 & 64) == 64) {
                    i += CodedOutputStream.computeInt64Size(7, this.startMsgid);
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

        public static Msg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Msg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Msg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Msg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Msg parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Msg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Msg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Msg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Msg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Msg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Msg msg) {
            return newBuilder().mergeFrom(msg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Msg, Builder> implements MsgOrBuilder {
            private long aliasId;
            private int bitField0;
            private long duration;
            private long endMsgid;
            private long msgCount;
            private long startMsgid;
            private Object roomId = "";
            private Object ext = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.msgCount = 0L;
                this.bitField0 &= -2;
                this.roomId = "";
                this.bitField0 &= -3;
                this.duration = 0L;
                this.bitField0 &= -5;
                this.endMsgid = 0L;
                this.bitField0 &= -9;
                this.ext = "";
                this.bitField0 &= -17;
                this.aliasId = 0L;
                this.bitField0 &= -33;
                this.startMsgid = 0L;
                this.bitField0 &= -65;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Msg getDefaultInstanceForType() {
                return Msg.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Msg build() {
                Msg buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Msg buildPartial() {
                Msg msg = new Msg(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                msg.msgCount = this.msgCount;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                msg.roomId = this.roomId;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                msg.duration = this.duration;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                msg.endMsgid = this.endMsgid;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                msg.ext = this.ext;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                msg.aliasId = this.aliasId;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                msg.startMsgid = this.startMsgid;
                msg.bitField0 = i2;
                return msg;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Msg msg) {
                if (msg != Msg.getDefaultInstance()) {
                    if (msg.hasMsgCount()) {
                        setMsgCount(msg.getMsgCount());
                    }
                    if (msg.hasRoomId()) {
                        this.bitField0 |= 2;
                        this.roomId = msg.roomId;
                    }
                    if (msg.hasDuration()) {
                        setDuration(msg.getDuration());
                    }
                    if (msg.hasEndMsgid()) {
                        setEndMsgid(msg.getEndMsgid());
                    }
                    if (msg.hasExt()) {
                        this.bitField0 |= 16;
                        this.ext = msg.ext;
                    }
                    if (msg.hasAliasId()) {
                        setAliasId(msg.getAliasId());
                    }
                    if (msg.hasStartMsgid()) {
                        setStartMsgid(msg.getStartMsgid());
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Msg msg;
                Throwable th;
                try {
                    try {
                        Msg parsePartialFrom = Msg.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        msg = null;
                        if (msg != null) {
                            mergeFrom(msg);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    Msg msg2 = (Msg) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        msg = msg2;
                        th = th3;
                        if (msg != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasMsgCount() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getMsgCount() {
                return this.msgCount;
            }

            public Builder setMsgCount(long j) {
                this.bitField0 |= 1;
                this.msgCount = j;
                return this;
            }

            public Builder clearMsgCount() {
                this.bitField0 &= -2;
                this.msgCount = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasRoomId() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public String getRoomId() {
                Object obj = this.roomId;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomId = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public ByteString getRoomIdBytes() {
                Object obj = this.roomId;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomId = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setRoomId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.roomId = str;
                return this;
            }

            public Builder clearRoomId() {
                this.bitField0 &= -3;
                this.roomId = Msg.getDefaultInstance().getRoomId();
                return this;
            }

            public Builder setRoomIdBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.roomId = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasDuration() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getDuration() {
                return this.duration;
            }

            public Builder setDuration(long j) {
                this.bitField0 |= 4;
                this.duration = j;
                return this;
            }

            public Builder clearDuration() {
                this.bitField0 &= -5;
                this.duration = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasEndMsgid() {
                return (this.bitField0 & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getEndMsgid() {
                return this.endMsgid;
            }

            public Builder setEndMsgid(long j) {
                this.bitField0 |= 8;
                this.endMsgid = j;
                return this;
            }

            public Builder clearEndMsgid() {
                this.bitField0 &= -9;
                this.endMsgid = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasExt() {
                return (this.bitField0 & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public String getExt() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ext = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setExt(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 16;
                this.ext = str;
                return this;
            }

            public Builder clearExt() {
                this.bitField0 &= -17;
                this.ext = Msg.getDefaultInstance().getExt();
                return this;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 16;
                this.ext = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0 & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getAliasId() {
                return this.aliasId;
            }

            public Builder setAliasId(long j) {
                this.bitField0 |= 32;
                this.aliasId = j;
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0 &= -33;
                this.aliasId = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasStartMsgid() {
                return (this.bitField0 & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getStartMsgid() {
                return this.startMsgid;
            }

            public Builder setStartMsgid(long j) {
                this.bitField0 |= 64;
                this.startMsgid = j;
                return this;
            }

            public Builder clearStartMsgid() {
                this.bitField0 &= -65;
                this.startMsgid = 0L;
                return this;
            }
        }
    }

    /* loaded from: classes18.dex */
    public static final class MetaData extends GeneratedMessageLite implements MetaDataOrBuilder {
        public static final int LOG_MODULE_ID_FIELD_NUMBER = 1;
        public static final int LOG_NAME_FIELD_NUMBER = 2;
        public static final int PRODUCT_NAME_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0;
        private int logModuleId;
        private Object logName;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object productName;
        public static final Parser<MetaData> PARSER = new AbstractParser<MetaData>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaData.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public MetaData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MetaData(codedInputStream, extensionRegistryLite);
            }
        };
        private static final MetaData defaultInstance = new MetaData(true);

        private MetaData(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MetaData(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MetaData getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MetaData getDefaultInstanceForType() {
            return defaultInstance;
        }

        private MetaData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.bitField0 |= 1;
                                    this.logModuleId = codedInputStream.readInt32();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.logName = codedInputStream.readBytes();
                                    break;
                                case 26:
                                    this.bitField0 |= 4;
                                    this.productName = codedInputStream.readBytes();
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
        public Parser<MetaData> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasLogModuleId() {
            return (this.bitField0 & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public int getLogModuleId() {
            return this.logModuleId;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasLogName() {
            return (this.bitField0 & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public String getLogName() {
            Object obj = this.logName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.logName = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public ByteString getLogNameBytes() {
            Object obj = this.logName;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.logName = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasProductName() {
            return (this.bitField0 & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public String getProductName() {
            Object obj = this.productName;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.productName = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public ByteString getProductNameBytes() {
            Object obj = this.productName;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productName = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        private void initFields() {
            this.logModuleId = 7399;
            this.logName = "push_im_client";
            this.productName = "phonebaidu";
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0 & 1) == 1) {
                codedOutputStream.writeInt32(1, this.logModuleId);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getLogNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeBytes(3, getProductNameBytes());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.logModuleId) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getLogNameBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeBytesSize(3, getProductNameBytes());
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

        public static MetaData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MetaData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MetaData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MetaData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MetaData parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static MetaData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static MetaData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static MetaData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static MetaData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static MetaData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MetaData metaData) {
            return newBuilder().mergeFrom(metaData);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes18.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MetaData, Builder> implements MetaDataOrBuilder {
            private int bitField0;
            private int logModuleId = 7399;
            private Object logName = "push_im_client";
            private Object productName = "phonebaidu";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.logModuleId = 7399;
                this.bitField0 &= -2;
                this.logName = "push_im_client";
                this.bitField0 &= -3;
                this.productName = "phonebaidu";
                this.bitField0 &= -5;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public MetaData getDefaultInstanceForType() {
                return MetaData.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public MetaData build() {
                MetaData buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public MetaData buildPartial() {
                MetaData metaData = new MetaData(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                metaData.logModuleId = this.logModuleId;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                metaData.logName = this.logName;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                metaData.productName = this.productName;
                metaData.bitField0 = i2;
                return metaData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(MetaData metaData) {
                if (metaData != MetaData.getDefaultInstance()) {
                    if (metaData.hasLogModuleId()) {
                        setLogModuleId(metaData.getLogModuleId());
                    }
                    if (metaData.hasLogName()) {
                        this.bitField0 |= 2;
                        this.logName = metaData.logName;
                    }
                    if (metaData.hasProductName()) {
                        this.bitField0 |= 4;
                        this.productName = metaData.productName;
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                MetaData metaData;
                Throwable th;
                try {
                    try {
                        MetaData parsePartialFrom = MetaData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        metaData = null;
                        if (metaData != null) {
                            mergeFrom(metaData);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    MetaData metaData2 = (MetaData) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        metaData = metaData2;
                        th = th3;
                        if (metaData != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasLogModuleId() {
                return (this.bitField0 & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public int getLogModuleId() {
                return this.logModuleId;
            }

            public Builder setLogModuleId(int i) {
                this.bitField0 |= 1;
                this.logModuleId = i;
                return this;
            }

            public Builder clearLogModuleId() {
                this.bitField0 &= -2;
                this.logModuleId = 7399;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasLogName() {
                return (this.bitField0 & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public String getLogName() {
                Object obj = this.logName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.logName = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public ByteString getLogNameBytes() {
                Object obj = this.logName;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.logName = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setLogName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.logName = str;
                return this;
            }

            public Builder clearLogName() {
                this.bitField0 &= -3;
                this.logName = MetaData.getDefaultInstance().getLogName();
                return this;
            }

            public Builder setLogNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 2;
                this.logName = byteString;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasProductName() {
                return (this.bitField0 & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public String getProductName() {
                Object obj = this.productName;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.productName = stringUtf8;
                return stringUtf8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public ByteString getProductNameBytes() {
                Object obj = this.productName;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.productName = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setProductName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.productName = str;
                return this;
            }

            public Builder clearProductName() {
                this.bitField0 &= -5;
                this.productName = MetaData.getDefaultInstance().getProductName();
                return this;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 4;
                this.productName = byteString;
                return this;
            }
        }
    }
}
