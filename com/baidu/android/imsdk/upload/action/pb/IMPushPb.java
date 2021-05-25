package com.baidu.android.imsdk.upload.action.pb;

import com.google.protobuf.AbstractMessageLite;
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
/* loaded from: classes.dex */
public final class IMPushPb {

    /* loaded from: classes.dex */
    public static final class Ack extends GeneratedMessageLite implements AckOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 5;
        public static final int EXT_FIELD_NUMBER = 4;
        public static Parser<Ack> PARSER = new AbstractParser<Ack>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ack.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Ack parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Ack(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        public static final Ack defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId_;
        public int bitField0_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long timestamp_;
        public Object type_;
        public Object value_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Ack, Builder> implements AckOrBuilder {
            public long aliasId_;
            public int bitField0_;
            public long timestamp_;
            public Object type_ = "";
            public Object value_ = "";
            public Object ext_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0_ &= -17;
                this.aliasId_ = 0L;
                return this;
            }

            public Builder clearExt() {
                this.bitField0_ &= -9;
                this.ext_ = Ack.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -5;
                this.timestamp_ = 0L;
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -2;
                this.type_ = Ack.getDefaultInstance().getType();
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= -3;
                this.value_ = Ack.getDefaultInstance().getValue();
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public long getAliasId() {
                return this.aliasId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getExt() {
                Object obj = this.ext_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ext_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.type_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getValue() {
                Object obj = this.value_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.value_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getValueBytes() {
                Object obj = this.value_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.value_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasTimestamp() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasType() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0_ |= 16;
                this.aliasId_ = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0_ |= 8;
                    this.ext_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8;
                    this.ext_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setTimestamp(long j) {
                this.bitField0_ |= 4;
                this.timestamp_ = j;
                return this;
            }

            public Builder setType(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.type_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.type_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setValue(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.value_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setValueBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.value_ = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ack build() {
                Ack buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ack buildPartial() {
                Ack ack = new Ack(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                ack.type_ = this.type_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                ack.value_ = this.value_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                ack.timestamp_ = this.timestamp_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                ack.ext_ = this.ext_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                ack.aliasId_ = this.aliasId_;
                ack.bitField0_ = i3;
                return ack;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.type_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.value_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.timestamp_ = 0L;
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.ext_ = "";
                int i5 = i4 & (-9);
                this.bitField0_ = i5;
                this.aliasId_ = 0L;
                this.bitField0_ = i5 & (-17);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Ack getDefaultInstanceForType() {
                return Ack.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Ack ack) {
                if (ack == Ack.getDefaultInstance()) {
                    return this;
                }
                if (ack.hasType()) {
                    this.bitField0_ |= 1;
                    this.type_ = ack.type_;
                }
                if (ack.hasValue()) {
                    this.bitField0_ |= 2;
                    this.value_ = ack.value_;
                }
                if (ack.hasTimestamp()) {
                    setTimestamp(ack.getTimestamp());
                }
                if (ack.hasExt()) {
                    this.bitField0_ |= 8;
                    this.ext_ = ack.ext_;
                }
                if (ack.hasAliasId()) {
                    setAliasId(ack.getAliasId());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Ack ack = null;
                try {
                    try {
                        Ack parsePartialFrom = Ack.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Ack ack2 = (Ack) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            ack = ack2;
                            if (ack != null) {
                                mergeFrom(ack);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (ack != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Ack ack = new Ack(true);
            defaultInstance = ack;
            ack.initFields();
        }

        public static Ack getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type_ = "";
            this.value_ = "";
            this.timestamp_ = 0L;
            this.ext_ = "";
            this.aliasId_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Ack parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Ack parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public long getAliasId() {
            return this.aliasId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getExt() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Ack> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTypeBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getValueBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.timestamp_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, getExtBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.aliasId_);
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.type_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getValue() {
            Object obj = this.value_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.value_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getValueBytes() {
            Object obj = this.value_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.value_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasExt() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasValue() {
            return (this.bitField0_ & 2) == 2;
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
                codedOutputStream.writeBytes(1, getTypeBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getValueBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.timestamp_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getExtBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(5, this.aliasId_);
            }
        }

        public static Builder newBuilder(Ack ack) {
            return newBuilder().mergeFrom(ack);
        }

        public static Ack parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Ack parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Ack getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Ack(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Ack(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ack parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Ack parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Ack parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Ack(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.bitField0_ |= 1;
                                    this.type_ = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.bitField0_ |= 2;
                                    this.value_ = codedInputStream.readBytes();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 4;
                                    this.timestamp_ = codedInputStream.readInt64();
                                } else if (readTag == 34) {
                                    this.bitField0_ |= 8;
                                    this.ext_ = codedInputStream.readBytes();
                                } else if (readTag != 40) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 16;
                                    this.aliasId_ = codedInputStream.readInt64();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class Action extends GeneratedMessageLite implements ActionOrBuilder {
        public static final int ACK_FIELD_NUMBER = 7;
        public static final int ACTION_TYPE_FIELD_NUMBER = 1;
        public static final int CONNECTION_FIELD_NUMBER = 5;
        public static final int CRASH_FIELD_NUMBER = 3;
        public static final int DB_FIELD_NUMBER = 4;
        public static final int MSG_FIELD_NUMBER = 8;
        public static final int NEW_CONNECTION_FIELD_NUMBER = 9;
        public static Parser<Action> PARSER = new AbstractParser<Action>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Action.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Action parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Action(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REQUEST_FIELD_NUMBER = 6;
        public static final int UI_FIELD_NUMBER = 2;
        public static final Action defaultInstance;
        public static final long serialVersionUID = 0;
        public Ack ack_;
        public ActionType actionType_;
        public int bitField0_;
        public Connection connection_;
        public Crash crash_;
        public Db db_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Msg msg_;
        public NewConnection newConnection_;
        public Request request_;
        public Ui ui_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Action, Builder> implements ActionOrBuilder {
            public int bitField0_;
            public ActionType actionType_ = ActionType.UI;
            public Ui ui_ = Ui.getDefaultInstance();
            public Crash crash_ = Crash.getDefaultInstance();
            public Db db_ = Db.getDefaultInstance();
            public Connection connection_ = Connection.getDefaultInstance();
            public Request request_ = Request.getDefaultInstance();
            public Ack ack_ = Ack.getDefaultInstance();
            public Msg msg_ = Msg.getDefaultInstance();
            public NewConnection newConnection_ = NewConnection.getDefaultInstance();

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAck() {
                this.ack_ = Ack.getDefaultInstance();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearActionType() {
                this.bitField0_ &= -2;
                this.actionType_ = ActionType.UI;
                return this;
            }

            public Builder clearConnection() {
                this.connection_ = Connection.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearCrash() {
                this.crash_ = Crash.getDefaultInstance();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearDb() {
                this.db_ = Db.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clearMsg() {
                this.msg_ = Msg.getDefaultInstance();
                this.bitField0_ &= -129;
                return this;
            }

            public Builder clearNewConnection() {
                this.newConnection_ = NewConnection.getDefaultInstance();
                this.bitField0_ &= -257;
                return this;
            }

            public Builder clearRequest() {
                this.request_ = Request.getDefaultInstance();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearUi() {
                this.ui_ = Ui.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Ack getAck() {
                return this.ack_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public ActionType getActionType() {
                return this.actionType_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Connection getConnection() {
                return this.connection_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Crash getCrash() {
                return this.crash_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Db getDb() {
                return this.db_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Msg getMsg() {
                return this.msg_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public NewConnection getNewConnection() {
                return this.newConnection_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Request getRequest() {
                return this.request_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Ui getUi() {
                return this.ui_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasAck() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasActionType() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasConnection() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasCrash() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasDb() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasMsg() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasNewConnection() {
                return (this.bitField0_ & 256) == 256;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasRequest() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasUi() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeAck(Ack ack) {
                if ((this.bitField0_ & 64) == 64 && this.ack_ != Ack.getDefaultInstance()) {
                    this.ack_ = Ack.newBuilder(this.ack_).mergeFrom(ack).buildPartial();
                } else {
                    this.ack_ = ack;
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeConnection(Connection connection) {
                if ((this.bitField0_ & 16) == 16 && this.connection_ != Connection.getDefaultInstance()) {
                    this.connection_ = Connection.newBuilder(this.connection_).mergeFrom(connection).buildPartial();
                } else {
                    this.connection_ = connection;
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergeCrash(Crash crash) {
                if ((this.bitField0_ & 4) == 4 && this.crash_ != Crash.getDefaultInstance()) {
                    this.crash_ = Crash.newBuilder(this.crash_).mergeFrom(crash).buildPartial();
                } else {
                    this.crash_ = crash;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeDb(Db db) {
                if ((this.bitField0_ & 8) == 8 && this.db_ != Db.getDefaultInstance()) {
                    this.db_ = Db.newBuilder(this.db_).mergeFrom(db).buildPartial();
                } else {
                    this.db_ = db;
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeMsg(Msg msg) {
                if ((this.bitField0_ & 128) == 128 && this.msg_ != Msg.getDefaultInstance()) {
                    this.msg_ = Msg.newBuilder(this.msg_).mergeFrom(msg).buildPartial();
                } else {
                    this.msg_ = msg;
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder mergeNewConnection(NewConnection newConnection) {
                if ((this.bitField0_ & 256) == 256 && this.newConnection_ != NewConnection.getDefaultInstance()) {
                    this.newConnection_ = NewConnection.newBuilder(this.newConnection_).mergeFrom(newConnection).buildPartial();
                } else {
                    this.newConnection_ = newConnection;
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder mergeRequest(Request request) {
                if ((this.bitField0_ & 32) == 32 && this.request_ != Request.getDefaultInstance()) {
                    this.request_ = Request.newBuilder(this.request_).mergeFrom(request).buildPartial();
                } else {
                    this.request_ = request;
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeUi(Ui ui) {
                if ((this.bitField0_ & 2) == 2 && this.ui_ != Ui.getDefaultInstance()) {
                    this.ui_ = Ui.newBuilder(this.ui_).mergeFrom(ui).buildPartial();
                } else {
                    this.ui_ = ui;
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setAck(Ack ack) {
                if (ack != null) {
                    this.ack_ = ack;
                    this.bitField0_ |= 64;
                    return this;
                }
                throw null;
            }

            public Builder setActionType(ActionType actionType) {
                if (actionType != null) {
                    this.bitField0_ |= 1;
                    this.actionType_ = actionType;
                    return this;
                }
                throw null;
            }

            public Builder setConnection(Connection connection) {
                if (connection != null) {
                    this.connection_ = connection;
                    this.bitField0_ |= 16;
                    return this;
                }
                throw null;
            }

            public Builder setCrash(Crash crash) {
                if (crash != null) {
                    this.crash_ = crash;
                    this.bitField0_ |= 4;
                    return this;
                }
                throw null;
            }

            public Builder setDb(Db db) {
                if (db != null) {
                    this.db_ = db;
                    this.bitField0_ |= 8;
                    return this;
                }
                throw null;
            }

            public Builder setMsg(Msg msg) {
                if (msg != null) {
                    this.msg_ = msg;
                    this.bitField0_ |= 128;
                    return this;
                }
                throw null;
            }

            public Builder setNewConnection(NewConnection newConnection) {
                if (newConnection != null) {
                    this.newConnection_ = newConnection;
                    this.bitField0_ |= 256;
                    return this;
                }
                throw null;
            }

            public Builder setRequest(Request request) {
                if (request != null) {
                    this.request_ = request;
                    this.bitField0_ |= 32;
                    return this;
                }
                throw null;
            }

            public Builder setUi(Ui ui) {
                if (ui != null) {
                    this.ui_ = ui;
                    this.bitField0_ |= 2;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Action build() {
                Action buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Action buildPartial() {
                Action action = new Action(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                action.actionType_ = this.actionType_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                action.ui_ = this.ui_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                action.crash_ = this.crash_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                action.db_ = this.db_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                action.connection_ = this.connection_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                action.request_ = this.request_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                action.ack_ = this.ack_;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                action.msg_ = this.msg_;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                action.newConnection_ = this.newConnection_;
                action.bitField0_ = i3;
                return action;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.actionType_ = ActionType.UI;
                this.bitField0_ &= -2;
                this.ui_ = Ui.getDefaultInstance();
                this.bitField0_ &= -3;
                this.crash_ = Crash.getDefaultInstance();
                this.bitField0_ &= -5;
                this.db_ = Db.getDefaultInstance();
                this.bitField0_ &= -9;
                this.connection_ = Connection.getDefaultInstance();
                this.bitField0_ &= -17;
                this.request_ = Request.getDefaultInstance();
                this.bitField0_ &= -33;
                this.ack_ = Ack.getDefaultInstance();
                this.bitField0_ &= -65;
                this.msg_ = Msg.getDefaultInstance();
                this.bitField0_ &= -129;
                this.newConnection_ = NewConnection.getDefaultInstance();
                this.bitField0_ &= -257;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Action getDefaultInstanceForType() {
                return Action.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Action action) {
                if (action == Action.getDefaultInstance()) {
                    return this;
                }
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
                if (action.hasNewConnection()) {
                    mergeNewConnection(action.getNewConnection());
                }
                return this;
            }

            public Builder setAck(Ack.Builder builder) {
                this.ack_ = builder.build();
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setConnection(Connection.Builder builder) {
                this.connection_ = builder.build();
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setCrash(Crash.Builder builder) {
                this.crash_ = builder.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setDb(Db.Builder builder) {
                this.db_ = builder.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setMsg(Msg.Builder builder) {
                this.msg_ = builder.build();
                this.bitField0_ |= 128;
                return this;
            }

            public Builder setNewConnection(NewConnection.Builder builder) {
                this.newConnection_ = builder.build();
                this.bitField0_ |= 256;
                return this;
            }

            public Builder setRequest(Request.Builder builder) {
                this.request_ = builder.build();
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setUi(Ui.Builder builder) {
                this.ui_ = builder.build();
                this.bitField0_ |= 2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Action action = null;
                try {
                    try {
                        Action parsePartialFrom = Action.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Action action2 = (Action) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            action = action2;
                            if (action != null) {
                                mergeFrom(action);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (action != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Action action = new Action(true);
            defaultInstance = action;
            action.initFields();
        }

        public static Action getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.actionType_ = ActionType.UI;
            this.ui_ = Ui.getDefaultInstance();
            this.crash_ = Crash.getDefaultInstance();
            this.db_ = Db.getDefaultInstance();
            this.connection_ = Connection.getDefaultInstance();
            this.request_ = Request.getDefaultInstance();
            this.ack_ = Ack.getDefaultInstance();
            this.msg_ = Msg.getDefaultInstance();
            this.newConnection_ = NewConnection.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Action parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Action parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Ack getAck() {
            return this.ack_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public ActionType getActionType() {
            return this.actionType_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Connection getConnection() {
            return this.connection_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Crash getCrash() {
            return this.crash_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Db getDb() {
            return this.db_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Msg getMsg() {
            return this.msg_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public NewConnection getNewConnection() {
            return this.newConnection_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Action> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Request getRequest() {
            return this.request_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.actionType_.getNumber()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.ui_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeMessageSize(3, this.crash_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeMessageSize(4, this.db_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeMessageSize(5, this.connection_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeMessageSize(6, this.request_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeMessageSize(7, this.ack_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeEnumSize += CodedOutputStream.computeMessageSize(8, this.msg_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeEnumSize += CodedOutputStream.computeMessageSize(9, this.newConnection_);
            }
            this.memoizedSerializedSize = computeEnumSize;
            return computeEnumSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Ui getUi() {
            return this.ui_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasAck() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasActionType() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasConnection() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasCrash() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasDb() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasMsg() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasNewConnection() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasRequest() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasUi() {
            return (this.bitField0_ & 2) == 2;
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
                codedOutputStream.writeEnum(1, this.actionType_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.ui_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.crash_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.db_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(5, this.connection_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(6, this.request_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeMessage(7, this.ack_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(8, this.msg_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeMessage(9, this.newConnection_);
            }
        }

        public static Builder newBuilder(Action action) {
            return newBuilder().mergeFrom(action);
        }

        public static Action parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Action parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Action getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Action(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Action(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Action parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Action parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Action parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Action(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite.Builder builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 8) {
                                    if (readTag == 18) {
                                        builder = (this.bitField0_ & 2) == 2 ? this.ui_.toBuilder() : null;
                                        Ui ui = (Ui) codedInputStream.readMessage(Ui.PARSER, extensionRegistryLite);
                                        this.ui_ = ui;
                                        if (builder != null) {
                                            builder.mergeFrom(ui);
                                            this.ui_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 2;
                                    } else if (readTag == 26) {
                                        builder = (this.bitField0_ & 4) == 4 ? this.crash_.toBuilder() : null;
                                        Crash crash = (Crash) codedInputStream.readMessage(Crash.PARSER, extensionRegistryLite);
                                        this.crash_ = crash;
                                        if (builder != null) {
                                            builder.mergeFrom(crash);
                                            this.crash_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
                                    } else if (readTag == 34) {
                                        builder = (this.bitField0_ & 8) == 8 ? this.db_.toBuilder() : null;
                                        Db db = (Db) codedInputStream.readMessage(Db.PARSER, extensionRegistryLite);
                                        this.db_ = db;
                                        if (builder != null) {
                                            builder.mergeFrom(db);
                                            this.db_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 8;
                                    } else if (readTag == 42) {
                                        builder = (this.bitField0_ & 16) == 16 ? this.connection_.toBuilder() : null;
                                        Connection connection = (Connection) codedInputStream.readMessage(Connection.PARSER, extensionRegistryLite);
                                        this.connection_ = connection;
                                        if (builder != null) {
                                            builder.mergeFrom(connection);
                                            this.connection_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 16;
                                    } else if (readTag == 50) {
                                        builder = (this.bitField0_ & 32) == 32 ? this.request_.toBuilder() : null;
                                        Request request = (Request) codedInputStream.readMessage(Request.PARSER, extensionRegistryLite);
                                        this.request_ = request;
                                        if (builder != null) {
                                            builder.mergeFrom(request);
                                            this.request_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 32;
                                    } else if (readTag == 58) {
                                        builder = (this.bitField0_ & 64) == 64 ? this.ack_.toBuilder() : null;
                                        Ack ack = (Ack) codedInputStream.readMessage(Ack.PARSER, extensionRegistryLite);
                                        this.ack_ = ack;
                                        if (builder != null) {
                                            builder.mergeFrom(ack);
                                            this.ack_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 64;
                                    } else if (readTag == 66) {
                                        builder = (this.bitField0_ & 128) == 128 ? this.msg_.toBuilder() : null;
                                        Msg msg = (Msg) codedInputStream.readMessage(Msg.PARSER, extensionRegistryLite);
                                        this.msg_ = msg;
                                        if (builder != null) {
                                            builder.mergeFrom(msg);
                                            this.msg_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 128;
                                    } else if (readTag != 74) {
                                        if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        builder = (this.bitField0_ & 256) == 256 ? this.newConnection_.toBuilder() : null;
                                        NewConnection newConnection = (NewConnection) codedInputStream.readMessage(NewConnection.PARSER, extensionRegistryLite);
                                        this.newConnection_ = newConnection;
                                        if (builder != null) {
                                            builder.mergeFrom(newConnection);
                                            this.newConnection_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 256;
                                    }
                                } else {
                                    ActionType valueOf = ActionType.valueOf(codedInputStream.readEnum());
                                    if (valueOf != null) {
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.actionType_ = valueOf;
                                    }
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ActionOrBuilder extends MessageLiteOrBuilder {
        Ack getAck();

        ActionType getActionType();

        Connection getConnection();

        Crash getCrash();

        Db getDb();

        Msg getMsg();

        NewConnection getNewConnection();

        Request getRequest();

        Ui getUi();

        boolean hasAck();

        boolean hasActionType();

        boolean hasConnection();

        boolean hasCrash();

        boolean hasDb();

        boolean hasMsg();

        boolean hasNewConnection();

        boolean hasRequest();

        boolean hasUi();
    }

    /* loaded from: classes.dex */
    public enum ActionType implements Internal.EnumLite {
        UI(0, 101),
        CRASH(1, 201),
        DB(2, 301),
        CONNECTION(3, 401),
        REQUEST(4, 501),
        ACK(5, 601),
        MSG(6, 701),
        NEWCONNECTION(7, 801);
        
        public static final int ACK_VALUE = 601;
        public static final int CONNECTION_VALUE = 401;
        public static final int CRASH_VALUE = 201;
        public static final int DB_VALUE = 301;
        public static final int MSG_VALUE = 701;
        public static final int NEWCONNECTION_VALUE = 801;
        public static final int REQUEST_VALUE = 501;
        public static final int UI_VALUE = 101;
        public static Internal.EnumLiteMap<ActionType> internalValueMap = new Internal.EnumLiteMap<ActionType>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionType.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ActionType findValueByNumber(int i2) {
                return ActionType.valueOf(i2);
            }
        };
        public final int value;

        ActionType(int i2, int i3) {
            this.value = i3;
        }

        public static Internal.EnumLiteMap<ActionType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static ActionType valueOf(int i2) {
            if (i2 != 101) {
                if (i2 != 201) {
                    if (i2 != 301) {
                        if (i2 != 401) {
                            if (i2 != 501) {
                                if (i2 != 601) {
                                    if (i2 != 701) {
                                        if (i2 != 801) {
                                            return null;
                                        }
                                        return NEWCONNECTION;
                                    }
                                    return MSG;
                                }
                                return ACK;
                            }
                            return REQUEST;
                        }
                        return CONNECTION;
                    }
                    return DB;
                }
                return CRASH;
            }
            return UI;
        }
    }

    /* loaded from: classes.dex */
    public static final class AppInfo extends GeneratedMessageLite implements AppInfoOrBuilder {
        public static final int APP_CHANNEL_FIELD_NUMBER = 3;
        public static final int APP_NAME_FIELD_NUMBER = 1;
        public static final int APP_VERSION_FIELD_NUMBER = 2;
        public static Parser<AppInfo> PARSER = new AbstractParser<AppInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public AppInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AppInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final AppInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public Object appChannel_;
        public Object appName_;
        public Object appVersion_;
        public int bitField0_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AppInfo, Builder> implements AppInfoOrBuilder {
            public int bitField0_;
            public Object appName_ = "";
            public Object appVersion_ = "";
            public Object appChannel_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAppChannel() {
                this.bitField0_ &= -5;
                this.appChannel_ = AppInfo.getDefaultInstance().getAppChannel();
                return this;
            }

            public Builder clearAppName() {
                this.bitField0_ &= -2;
                this.appName_ = AppInfo.getDefaultInstance().getAppName();
                return this;
            }

            public Builder clearAppVersion() {
                this.bitField0_ &= -3;
                this.appVersion_ = AppInfo.getDefaultInstance().getAppVersion();
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppChannel() {
                Object obj = this.appChannel_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.appChannel_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppChannelBytes() {
                Object obj = this.appChannel_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appChannel_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppName() {
                Object obj = this.appName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.appName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppNameBytes() {
                Object obj = this.appName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppVersion() {
                Object obj = this.appVersion_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.appVersion_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppVersionBytes() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppChannel() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppVersion() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAppChannel(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.appChannel_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setAppChannelBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.appChannel_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setAppName(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.appName_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setAppNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.appName_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setAppVersion(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.appVersion_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.appVersion_ = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public AppInfo build() {
                AppInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public AppInfo buildPartial() {
                AppInfo appInfo = new AppInfo(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                appInfo.appName_ = this.appName_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                appInfo.appVersion_ = this.appVersion_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                appInfo.appChannel_ = this.appChannel_;
                appInfo.bitField0_ = i3;
                return appInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.appName_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.appVersion_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.appChannel_ = "";
                this.bitField0_ = i3 & (-5);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public AppInfo getDefaultInstanceForType() {
                return AppInfo.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(AppInfo appInfo) {
                if (appInfo == AppInfo.getDefaultInstance()) {
                    return this;
                }
                if (appInfo.hasAppName()) {
                    this.bitField0_ |= 1;
                    this.appName_ = appInfo.appName_;
                }
                if (appInfo.hasAppVersion()) {
                    this.bitField0_ |= 2;
                    this.appVersion_ = appInfo.appVersion_;
                }
                if (appInfo.hasAppChannel()) {
                    this.bitField0_ |= 4;
                    this.appChannel_ = appInfo.appChannel_;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AppInfo appInfo = null;
                try {
                    try {
                        AppInfo parsePartialFrom = AppInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        AppInfo appInfo2 = (AppInfo) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            appInfo = appInfo2;
                            if (appInfo != null) {
                                mergeFrom(appInfo);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (appInfo != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            AppInfo appInfo = new AppInfo(true);
            defaultInstance = appInfo;
            appInfo.initFields();
        }

        public static AppInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.appName_ = "";
            this.appVersion_ = "";
            this.appChannel_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static AppInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public String getAppChannel() {
            Object obj = this.appChannel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appChannel_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppChannelBytes() {
            Object obj = this.appChannel_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appChannel_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public String getAppName() {
            Object obj = this.appName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.appName_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppNameBytes() {
            Object obj = this.appName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
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

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<AppInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getAppNameBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getAppVersionBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, getAppChannelBytes());
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppChannel() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppVersion() {
            return (this.bitField0_ & 2) == 2;
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
                codedOutputStream.writeBytes(1, getAppNameBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getAppVersionBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getAppChannelBytes());
            }
        }

        public static Builder newBuilder(AppInfo appInfo) {
            return newBuilder().mergeFrom(appInfo);
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static AppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public AppInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public AppInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public AppInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public AppInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.bitField0_ |= 1;
                                    this.appName_ = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.bitField0_ |= 2;
                                    this.appVersion_ = codedInputStream.readBytes();
                                } else if (readTag != 26) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.appChannel_ = codedInputStream.readBytes();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class Common extends GeneratedMessageLite implements CommonOrBuilder {
        public static final int APP_INFO_FIELD_NUMBER = 21;
        public static final int DEVICE_ID_FIELD_NUMBER = 7;
        public static final int MODULE_NAME_FIELD_NUMBER = 2;
        public static final int NET_INFO_FIELD_NUMBER = 22;
        public static Parser<Common> PARSER = new AbstractParser<Common>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Common.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Common(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PRODUCT_NAME_FIELD_NUMBER = 1;
        public static final int TERMINAL_INFO_FIELD_NUMBER = 20;
        public static final int TIMESTAMP_FIELD_NUMBER = 10;
        public static final int USER_TIMESTAMP_FIELD_NUMBER = 12;
        public static final Common defaultInstance;
        public static final long serialVersionUID = 0;
        public AppInfo appInfo_;
        public int bitField0_;
        public DeviceID deviceId_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object moduleName_;
        public NetInfo netInfo_;
        public Object productName_;
        public TerminalInfo terminalInfo_;
        public long timestamp_;
        public long userTimestamp_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Common, Builder> implements CommonOrBuilder {
            public int bitField0_;
            public long timestamp_;
            public long userTimestamp_;
            public Object productName_ = "";
            public Object moduleName_ = "";
            public DeviceID deviceId_ = DeviceID.getDefaultInstance();
            public TerminalInfo terminalInfo_ = TerminalInfo.getDefaultInstance();
            public AppInfo appInfo_ = AppInfo.getDefaultInstance();
            public NetInfo netInfo_ = NetInfo.getDefaultInstance();

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAppInfo() {
                this.appInfo_ = AppInfo.getDefaultInstance();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = DeviceID.getDefaultInstance();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearModuleName() {
                this.bitField0_ &= -3;
                this.moduleName_ = Common.getDefaultInstance().getModuleName();
                return this;
            }

            public Builder clearNetInfo() {
                this.netInfo_ = NetInfo.getDefaultInstance();
                this.bitField0_ &= -129;
                return this;
            }

            public Builder clearProductName() {
                this.bitField0_ &= -2;
                this.productName_ = Common.getDefaultInstance().getProductName();
                return this;
            }

            public Builder clearTerminalInfo() {
                this.terminalInfo_ = TerminalInfo.getDefaultInstance();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -9;
                this.timestamp_ = 0L;
                return this;
            }

            public Builder clearUserTimestamp() {
                this.bitField0_ &= -17;
                this.userTimestamp_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public AppInfo getAppInfo() {
                return this.appInfo_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public DeviceID getDeviceId() {
                return this.deviceId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public String getModuleName() {
                Object obj = this.moduleName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.moduleName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public ByteString getModuleNameBytes() {
                Object obj = this.moduleName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.moduleName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public NetInfo getNetInfo() {
                return this.netInfo_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public String getProductName() {
                Object obj = this.productName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.productName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public ByteString getProductNameBytes() {
                Object obj = this.productName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.productName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public TerminalInfo getTerminalInfo() {
                return this.terminalInfo_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public long getUserTimestamp() {
                return this.userTimestamp_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasAppInfo() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasDeviceId() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasModuleName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasNetInfo() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasProductName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasTerminalInfo() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasTimestamp() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasUserTimestamp() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasTimestamp()) {
                    return !hasDeviceId() || getDeviceId().isInitialized();
                }
                return false;
            }

            public Builder mergeAppInfo(AppInfo appInfo) {
                if ((this.bitField0_ & 64) == 64 && this.appInfo_ != AppInfo.getDefaultInstance()) {
                    this.appInfo_ = AppInfo.newBuilder(this.appInfo_).mergeFrom(appInfo).buildPartial();
                } else {
                    this.appInfo_ = appInfo;
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeDeviceId(DeviceID deviceID) {
                if ((this.bitField0_ & 4) == 4 && this.deviceId_ != DeviceID.getDefaultInstance()) {
                    this.deviceId_ = DeviceID.newBuilder(this.deviceId_).mergeFrom(deviceID).buildPartial();
                } else {
                    this.deviceId_ = deviceID;
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeNetInfo(NetInfo netInfo) {
                if ((this.bitField0_ & 128) == 128 && this.netInfo_ != NetInfo.getDefaultInstance()) {
                    this.netInfo_ = NetInfo.newBuilder(this.netInfo_).mergeFrom(netInfo).buildPartial();
                } else {
                    this.netInfo_ = netInfo;
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder mergeTerminalInfo(TerminalInfo terminalInfo) {
                if ((this.bitField0_ & 32) == 32 && this.terminalInfo_ != TerminalInfo.getDefaultInstance()) {
                    this.terminalInfo_ = TerminalInfo.newBuilder(this.terminalInfo_).mergeFrom(terminalInfo).buildPartial();
                } else {
                    this.terminalInfo_ = terminalInfo;
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setAppInfo(AppInfo appInfo) {
                if (appInfo != null) {
                    this.appInfo_ = appInfo;
                    this.bitField0_ |= 64;
                    return this;
                }
                throw null;
            }

            public Builder setDeviceId(DeviceID deviceID) {
                if (deviceID != null) {
                    this.deviceId_ = deviceID;
                    this.bitField0_ |= 4;
                    return this;
                }
                throw null;
            }

            public Builder setModuleName(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.moduleName_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setModuleNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.moduleName_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setNetInfo(NetInfo netInfo) {
                if (netInfo != null) {
                    this.netInfo_ = netInfo;
                    this.bitField0_ |= 128;
                    return this;
                }
                throw null;
            }

            public Builder setProductName(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.productName_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.productName_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setTerminalInfo(TerminalInfo terminalInfo) {
                if (terminalInfo != null) {
                    this.terminalInfo_ = terminalInfo;
                    this.bitField0_ |= 32;
                    return this;
                }
                throw null;
            }

            public Builder setTimestamp(long j) {
                this.bitField0_ |= 8;
                this.timestamp_ = j;
                return this;
            }

            public Builder setUserTimestamp(long j) {
                this.bitField0_ |= 16;
                this.userTimestamp_ = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Common build() {
                Common buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Common buildPartial() {
                Common common2 = new Common(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                common2.productName_ = this.productName_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                common2.moduleName_ = this.moduleName_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                common2.deviceId_ = this.deviceId_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                common2.timestamp_ = this.timestamp_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                common2.userTimestamp_ = this.userTimestamp_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                common2.terminalInfo_ = this.terminalInfo_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                common2.appInfo_ = this.appInfo_;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                common2.netInfo_ = this.netInfo_;
                common2.bitField0_ = i3;
                return common2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.productName_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.moduleName_ = "";
                this.bitField0_ = i2 & (-3);
                this.deviceId_ = DeviceID.getDefaultInstance();
                int i3 = this.bitField0_ & (-5);
                this.bitField0_ = i3;
                this.timestamp_ = 0L;
                int i4 = i3 & (-9);
                this.bitField0_ = i4;
                this.userTimestamp_ = 0L;
                this.bitField0_ = i4 & (-17);
                this.terminalInfo_ = TerminalInfo.getDefaultInstance();
                this.bitField0_ &= -33;
                this.appInfo_ = AppInfo.getDefaultInstance();
                this.bitField0_ &= -65;
                this.netInfo_ = NetInfo.getDefaultInstance();
                this.bitField0_ &= -129;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Common getDefaultInstanceForType() {
                return Common.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Common common2) {
                if (common2 == Common.getDefaultInstance()) {
                    return this;
                }
                if (common2.hasProductName()) {
                    this.bitField0_ |= 1;
                    this.productName_ = common2.productName_;
                }
                if (common2.hasModuleName()) {
                    this.bitField0_ |= 2;
                    this.moduleName_ = common2.moduleName_;
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
                return this;
            }

            public Builder setAppInfo(AppInfo.Builder builder) {
                this.appInfo_ = builder.build();
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setDeviceId(DeviceID.Builder builder) {
                this.deviceId_ = builder.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setNetInfo(NetInfo.Builder builder) {
                this.netInfo_ = builder.build();
                this.bitField0_ |= 128;
                return this;
            }

            public Builder setTerminalInfo(TerminalInfo.Builder builder) {
                this.terminalInfo_ = builder.build();
                this.bitField0_ |= 32;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Common common2 = null;
                try {
                    try {
                        Common parsePartialFrom = Common.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Common common3 = (Common) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            common2 = common3;
                            if (common2 != null) {
                                mergeFrom(common2);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (common2 != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Common common2 = new Common(true);
            defaultInstance = common2;
            common2.initFields();
        }

        public static Common getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.productName_ = "";
            this.moduleName_ = "";
            this.deviceId_ = DeviceID.getDefaultInstance();
            this.timestamp_ = 0L;
            this.userTimestamp_ = 0L;
            this.terminalInfo_ = TerminalInfo.getDefaultInstance();
            this.appInfo_ = AppInfo.getDefaultInstance();
            this.netInfo_ = NetInfo.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Common parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public AppInfo getAppInfo() {
            return this.appInfo_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public DeviceID getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public String getModuleName() {
            Object obj = this.moduleName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.moduleName_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public ByteString getModuleNameBytes() {
            Object obj = this.moduleName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.moduleName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public NetInfo getNetInfo() {
            return this.netInfo_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Common> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public String getProductName() {
            Object obj = this.productName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.productName_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public ByteString getProductNameBytes() {
            Object obj = this.productName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getProductNameBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getModuleNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeMessageSize(7, this.deviceId_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(10, this.timestamp_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(12, this.userTimestamp_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeMessageSize(20, this.terminalInfo_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeMessageSize(21, this.appInfo_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeMessageSize(22, this.netInfo_);
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public TerminalInfo getTerminalInfo() {
            return this.terminalInfo_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public long getUserTimestamp() {
            return this.userTimestamp_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasAppInfo() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasDeviceId() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasModuleName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasNetInfo() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasProductName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasTerminalInfo() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasUserTimestamp() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, getProductNameBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getModuleNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(7, this.deviceId_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(10, this.timestamp_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(12, this.userTimestamp_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessage(20, this.terminalInfo_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeMessage(21, this.appInfo_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(22, this.netInfo_);
            }
        }

        public static Builder newBuilder(Common common2) {
            return newBuilder().mergeFrom(common2);
        }

        public static Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Common getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Common(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Common(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite.Builder builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.bitField0_ |= 1;
                                    this.productName_ = codedInputStream.readBytes();
                                } else if (readTag != 18) {
                                    if (readTag == 58) {
                                        builder = (this.bitField0_ & 4) == 4 ? this.deviceId_.toBuilder() : null;
                                        DeviceID deviceID = (DeviceID) codedInputStream.readMessage(DeviceID.PARSER, extensionRegistryLite);
                                        this.deviceId_ = deviceID;
                                        if (builder != null) {
                                            builder.mergeFrom(deviceID);
                                            this.deviceId_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
                                    } else if (readTag == 80) {
                                        this.bitField0_ |= 8;
                                        this.timestamp_ = codedInputStream.readInt64();
                                    } else if (readTag == 96) {
                                        this.bitField0_ |= 16;
                                        this.userTimestamp_ = codedInputStream.readInt64();
                                    } else if (readTag == 162) {
                                        builder = (this.bitField0_ & 32) == 32 ? this.terminalInfo_.toBuilder() : null;
                                        TerminalInfo terminalInfo = (TerminalInfo) codedInputStream.readMessage(TerminalInfo.PARSER, extensionRegistryLite);
                                        this.terminalInfo_ = terminalInfo;
                                        if (builder != null) {
                                            builder.mergeFrom(terminalInfo);
                                            this.terminalInfo_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 32;
                                    } else if (readTag == 170) {
                                        builder = (this.bitField0_ & 64) == 64 ? this.appInfo_.toBuilder() : null;
                                        AppInfo appInfo = (AppInfo) codedInputStream.readMessage(AppInfo.PARSER, extensionRegistryLite);
                                        this.appInfo_ = appInfo;
                                        if (builder != null) {
                                            builder.mergeFrom(appInfo);
                                            this.appInfo_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 64;
                                    } else if (readTag != 178) {
                                        if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        builder = (this.bitField0_ & 128) == 128 ? this.netInfo_.toBuilder() : null;
                                        NetInfo netInfo = (NetInfo) codedInputStream.readMessage(NetInfo.PARSER, extensionRegistryLite);
                                        this.netInfo_ = netInfo;
                                        if (builder != null) {
                                            builder.mergeFrom(netInfo);
                                            this.netInfo_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 128;
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.moduleName_ = codedInputStream.readBytes();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class Connection extends GeneratedMessageLite implements ConnectionOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int EXT_FIELD_NUMBER = 6;
        public static Parser<Connection> PARSER = new AbstractParser<Connection>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Connection.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Connection parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Connection(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REASON_FIELD_NUMBER = 3;
        public static final int RETRY_COUNT_FIELD_NUMBER = 5;
        public static final int RETRY_TIME_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 1;
        public static final int STOP_TIME_FIELD_NUMBER = 2;
        public static final Connection defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId_;
        public int bitField0_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object reason_;
        public long retryCount_;
        public long retryTime_;
        public long startTime_;
        public long stopTime_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Connection, Builder> implements ConnectionOrBuilder {
            public long aliasId_;
            public int bitField0_;
            public long retryCount_;
            public long retryTime_;
            public long startTime_;
            public long stopTime_;
            public Object reason_ = "";
            public Object ext_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0_ &= -65;
                this.aliasId_ = 0L;
                return this;
            }

            public Builder clearExt() {
                this.bitField0_ &= -33;
                this.ext_ = Connection.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearReason() {
                this.bitField0_ &= -5;
                this.reason_ = Connection.getDefaultInstance().getReason();
                return this;
            }

            public Builder clearRetryCount() {
                this.bitField0_ &= -17;
                this.retryCount_ = 0L;
                return this;
            }

            public Builder clearRetryTime() {
                this.bitField0_ &= -9;
                this.retryTime_ = 0L;
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0_ &= -2;
                this.startTime_ = 0L;
                return this;
            }

            public Builder clearStopTime() {
                this.bitField0_ &= -3;
                this.stopTime_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getAliasId() {
                return this.aliasId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public String getExt() {
                Object obj = this.ext_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ext_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.reason_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getRetryCount() {
                return this.retryCount_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getRetryTime() {
                return this.retryTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getStartTime() {
                return this.startTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getStopTime() {
                return this.stopTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasReason() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasRetryCount() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasRetryTime() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasStartTime() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasStopTime() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0_ |= 64;
                this.aliasId_ = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0_ |= 32;
                    this.ext_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 32;
                    this.ext_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setReason(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.reason_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setReasonBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.reason_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setRetryCount(long j) {
                this.bitField0_ |= 16;
                this.retryCount_ = j;
                return this;
            }

            public Builder setRetryTime(long j) {
                this.bitField0_ |= 8;
                this.retryTime_ = j;
                return this;
            }

            public Builder setStartTime(long j) {
                this.bitField0_ |= 1;
                this.startTime_ = j;
                return this;
            }

            public Builder setStopTime(long j) {
                this.bitField0_ |= 2;
                this.stopTime_ = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Connection build() {
                Connection buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Connection buildPartial() {
                Connection connection = new Connection(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                connection.startTime_ = this.startTime_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                connection.stopTime_ = this.stopTime_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                connection.reason_ = this.reason_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                connection.retryTime_ = this.retryTime_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                connection.retryCount_ = this.retryCount_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                connection.ext_ = this.ext_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                connection.aliasId_ = this.aliasId_;
                connection.bitField0_ = i3;
                return connection;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.startTime_ = 0L;
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.stopTime_ = 0L;
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.reason_ = "";
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.retryTime_ = 0L;
                int i5 = i4 & (-9);
                this.bitField0_ = i5;
                this.retryCount_ = 0L;
                int i6 = i5 & (-17);
                this.bitField0_ = i6;
                this.ext_ = "";
                int i7 = i6 & (-33);
                this.bitField0_ = i7;
                this.aliasId_ = 0L;
                this.bitField0_ = i7 & (-65);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Connection getDefaultInstanceForType() {
                return Connection.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Connection connection) {
                if (connection == Connection.getDefaultInstance()) {
                    return this;
                }
                if (connection.hasStartTime()) {
                    setStartTime(connection.getStartTime());
                }
                if (connection.hasStopTime()) {
                    setStopTime(connection.getStopTime());
                }
                if (connection.hasReason()) {
                    this.bitField0_ |= 4;
                    this.reason_ = connection.reason_;
                }
                if (connection.hasRetryTime()) {
                    setRetryTime(connection.getRetryTime());
                }
                if (connection.hasRetryCount()) {
                    setRetryCount(connection.getRetryCount());
                }
                if (connection.hasExt()) {
                    this.bitField0_ |= 32;
                    this.ext_ = connection.ext_;
                }
                if (connection.hasAliasId()) {
                    setAliasId(connection.getAliasId());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Connection connection = null;
                try {
                    try {
                        Connection parsePartialFrom = Connection.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Connection connection2 = (Connection) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            connection = connection2;
                            if (connection != null) {
                                mergeFrom(connection);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (connection != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Connection connection = new Connection(true);
            defaultInstance = connection;
            connection.initFields();
        }

        public static Connection getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.startTime_ = 0L;
            this.stopTime_ = 0L;
            this.reason_ = "";
            this.retryTime_ = 0L;
            this.retryCount_ = 0L;
            this.ext_ = "";
            this.aliasId_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Connection parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Connection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getAliasId() {
            return this.aliasId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public String getExt() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Connection> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.reason_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getRetryCount() {
            return this.retryCount_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getRetryTime() {
            return this.retryTime_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.startTime_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.stopTime_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeBytesSize(3, getReasonBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.retryTime_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt64Size(5, this.retryCount_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeBytesSize(6, getExtBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.aliasId_);
            }
            this.memoizedSerializedSize = computeInt64Size;
            return computeInt64Size;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getStartTime() {
            return this.startTime_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getStopTime() {
            return this.stopTime_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasExt() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasReason() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasRetryCount() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasRetryTime() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasStartTime() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasStopTime() {
            return (this.bitField0_ & 2) == 2;
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
                codedOutputStream.writeInt64(1, this.startTime_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(2, this.stopTime_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getReasonBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.retryTime_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(5, this.retryCount_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId_);
            }
        }

        public static Builder newBuilder(Connection connection) {
            return newBuilder().mergeFrom(connection);
        }

        public static Connection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Connection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Connection getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Connection(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Connection(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Connection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Connection parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Connection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Connection(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.startTime_ = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.stopTime_ = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.bitField0_ |= 4;
                                    this.reason_ = codedInputStream.readBytes();
                                } else if (readTag == 32) {
                                    this.bitField0_ |= 8;
                                    this.retryTime_ = codedInputStream.readInt64();
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 16;
                                    this.retryCount_ = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    this.bitField0_ |= 32;
                                    this.ext_ = codedInputStream.readBytes();
                                } else if (readTag != 56) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 64;
                                    this.aliasId_ = codedInputStream.readInt64();
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class Crash extends GeneratedMessageLite implements CrashOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 4;
        public static final int EXCEPTION_FIELD_NUMBER = 1;
        public static final int EXT_FIELD_NUMBER = 3;
        public static Parser<Crash> PARSER = new AbstractParser<Crash>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Crash.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Crash parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Crash(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final Crash defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId_;
        public int bitField0_;
        public Object exception_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long timestamp_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Crash, Builder> implements CrashOrBuilder {
            public long aliasId_;
            public int bitField0_;
            public Object exception_ = "";
            public Object ext_ = "";
            public long timestamp_;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0_ &= -9;
                this.aliasId_ = 0L;
                return this;
            }

            public Builder clearException() {
                this.bitField0_ &= -2;
                this.exception_ = Crash.getDefaultInstance().getException();
                return this;
            }

            public Builder clearExt() {
                this.bitField0_ &= -5;
                this.ext_ = Crash.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -3;
                this.timestamp_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public long getAliasId() {
                return this.aliasId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public String getException() {
                Object obj = this.exception_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.exception_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public ByteString getExceptionBytes() {
                Object obj = this.exception_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.exception_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public String getExt() {
                Object obj = this.ext_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ext_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasException() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasTimestamp() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0_ |= 8;
                this.aliasId_ = j;
                return this;
            }

            public Builder setException(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.exception_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExceptionBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.exception_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.ext_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.ext_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setTimestamp(long j) {
                this.bitField0_ |= 2;
                this.timestamp_ = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Crash build() {
                Crash buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Crash buildPartial() {
                Crash crash = new Crash(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                crash.exception_ = this.exception_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                crash.timestamp_ = this.timestamp_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                crash.ext_ = this.ext_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                crash.aliasId_ = this.aliasId_;
                crash.bitField0_ = i3;
                return crash;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.exception_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.timestamp_ = 0L;
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.ext_ = "";
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.aliasId_ = 0L;
                this.bitField0_ = i4 & (-9);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Crash getDefaultInstanceForType() {
                return Crash.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Crash crash) {
                if (crash == Crash.getDefaultInstance()) {
                    return this;
                }
                if (crash.hasException()) {
                    this.bitField0_ |= 1;
                    this.exception_ = crash.exception_;
                }
                if (crash.hasTimestamp()) {
                    setTimestamp(crash.getTimestamp());
                }
                if (crash.hasExt()) {
                    this.bitField0_ |= 4;
                    this.ext_ = crash.ext_;
                }
                if (crash.hasAliasId()) {
                    setAliasId(crash.getAliasId());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Crash crash = null;
                try {
                    try {
                        Crash parsePartialFrom = Crash.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Crash crash2 = (Crash) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            crash = crash2;
                            if (crash != null) {
                                mergeFrom(crash);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (crash != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Crash crash = new Crash(true);
            defaultInstance = crash;
            crash.initFields();
        }

        public static Crash getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.exception_ = "";
            this.timestamp_ = 0L;
            this.ext_ = "";
            this.aliasId_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Crash parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Crash parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public long getAliasId() {
            return this.aliasId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public String getException() {
            Object obj = this.exception_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.exception_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public ByteString getExceptionBytes() {
            Object obj = this.exception_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.exception_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public String getExt() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Crash> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getExceptionBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeInt64Size(2, this.timestamp_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, getExtBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.aliasId_);
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasException() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasExt() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0_ & 2) == 2;
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
                codedOutputStream.writeBytes(1, getExceptionBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(2, this.timestamp_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getExtBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.aliasId_);
            }
        }

        public static Builder newBuilder(Crash crash) {
            return newBuilder().mergeFrom(crash);
        }

        public static Crash parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Crash parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Crash getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Crash(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Crash(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Crash parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Crash parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Crash parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Crash(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.bitField0_ |= 1;
                                    this.exception_ = codedInputStream.readBytes();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.timestamp_ = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    this.bitField0_ |= 4;
                                    this.ext_ = codedInputStream.readBytes();
                                } else if (readTag != 32) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 8;
                                    this.aliasId_ = codedInputStream.readInt64();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class Db extends GeneratedMessageLite implements DbOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 4;
        public static final int ALIAS_ID_FIELD_NUMBER = 9;
        public static final int CLASS_NAME_FIELD_NUMBER = 2;
        public static final int DURATION_FIELD_NUMBER = 7;
        public static final int END_TIME_FIELD_NUMBER = 6;
        public static final int EXT_FIELD_NUMBER = 8;
        public static final int METHOD_FIELD_NUMBER = 3;
        public static Parser<Db> PARSER = new AbstractParser<Db>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Db.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Db parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Db(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int START_TIME_FIELD_NUMBER = 5;
        public static final int TABLE_FIELD_NUMBER = 1;
        public static final Db defaultInstance;
        public static final long serialVersionUID = 0;
        public Object action_;
        public long aliasId_;
        public int bitField0_;
        public Object className_;
        public long duration_;
        public long endTime_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object method_;
        public long startTime_;
        public Object table_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Db, Builder> implements DbOrBuilder {
            public long aliasId_;
            public int bitField0_;
            public long duration_;
            public long endTime_;
            public long startTime_;
            public Object table_ = "";
            public Object className_ = "";
            public Object method_ = "";
            public Object action_ = "";
            public Object ext_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAction() {
                this.bitField0_ &= -9;
                this.action_ = Db.getDefaultInstance().getAction();
                return this;
            }

            public Builder clearAliasId() {
                this.bitField0_ &= -257;
                this.aliasId_ = 0L;
                return this;
            }

            public Builder clearClassName() {
                this.bitField0_ &= -3;
                this.className_ = Db.getDefaultInstance().getClassName();
                return this;
            }

            public Builder clearDuration() {
                this.bitField0_ &= -65;
                this.duration_ = 0L;
                return this;
            }

            public Builder clearEndTime() {
                this.bitField0_ &= -33;
                this.endTime_ = 0L;
                return this;
            }

            public Builder clearExt() {
                this.bitField0_ &= -129;
                this.ext_ = Db.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearMethod() {
                this.bitField0_ &= -5;
                this.method_ = Db.getDefaultInstance().getMethod();
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0_ &= -17;
                this.startTime_ = 0L;
                return this;
            }

            public Builder clearTable() {
                this.bitField0_ &= -2;
                this.table_ = Db.getDefaultInstance().getTable();
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getAction() {
                Object obj = this.action_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.action_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getActionBytes() {
                Object obj = this.action_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.action_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getAliasId() {
                return this.aliasId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getClassName() {
                Object obj = this.className_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.className_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getClassNameBytes() {
                Object obj = this.className_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.className_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getDuration() {
                return this.duration_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getEndTime() {
                return this.endTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getExt() {
                Object obj = this.ext_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ext_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getMethod() {
                Object obj = this.method_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.method_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getMethodBytes() {
                Object obj = this.method_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.method_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getStartTime() {
                return this.startTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getTable() {
                Object obj = this.table_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.table_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getTableBytes() {
                Object obj = this.table_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.table_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasAction() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0_ & 256) == 256;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasClassName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasDuration() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasEndTime() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasMethod() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasStartTime() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasTable() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAction(String str) {
                if (str != null) {
                    this.bitField0_ |= 8;
                    this.action_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setActionBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8;
                    this.action_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setAliasId(long j) {
                this.bitField0_ |= 256;
                this.aliasId_ = j;
                return this;
            }

            public Builder setClassName(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.className_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setClassNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.className_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setDuration(long j) {
                this.bitField0_ |= 64;
                this.duration_ = j;
                return this;
            }

            public Builder setEndTime(long j) {
                this.bitField0_ |= 32;
                this.endTime_ = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0_ |= 128;
                    this.ext_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 128;
                    this.ext_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setMethod(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.method_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setMethodBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.method_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setStartTime(long j) {
                this.bitField0_ |= 16;
                this.startTime_ = j;
                return this;
            }

            public Builder setTable(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.table_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setTableBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.table_ = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Db build() {
                Db buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Db buildPartial() {
                Db db = new Db(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                db.table_ = this.table_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                db.className_ = this.className_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                db.method_ = this.method_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                db.action_ = this.action_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                db.startTime_ = this.startTime_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                db.endTime_ = this.endTime_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                db.duration_ = this.duration_;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                db.ext_ = this.ext_;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                db.aliasId_ = this.aliasId_;
                db.bitField0_ = i3;
                return db;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.table_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.className_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.method_ = "";
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.action_ = "";
                int i5 = i4 & (-9);
                this.bitField0_ = i5;
                this.startTime_ = 0L;
                int i6 = i5 & (-17);
                this.bitField0_ = i6;
                this.endTime_ = 0L;
                int i7 = i6 & (-33);
                this.bitField0_ = i7;
                this.duration_ = 0L;
                int i8 = i7 & (-65);
                this.bitField0_ = i8;
                this.ext_ = "";
                int i9 = i8 & (-129);
                this.bitField0_ = i9;
                this.aliasId_ = 0L;
                this.bitField0_ = i9 & (-257);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Db getDefaultInstanceForType() {
                return Db.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Db db) {
                if (db == Db.getDefaultInstance()) {
                    return this;
                }
                if (db.hasTable()) {
                    this.bitField0_ |= 1;
                    this.table_ = db.table_;
                }
                if (db.hasClassName()) {
                    this.bitField0_ |= 2;
                    this.className_ = db.className_;
                }
                if (db.hasMethod()) {
                    this.bitField0_ |= 4;
                    this.method_ = db.method_;
                }
                if (db.hasAction()) {
                    this.bitField0_ |= 8;
                    this.action_ = db.action_;
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
                    this.bitField0_ |= 128;
                    this.ext_ = db.ext_;
                }
                if (db.hasAliasId()) {
                    setAliasId(db.getAliasId());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Db db = null;
                try {
                    try {
                        Db parsePartialFrom = Db.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Db db2 = (Db) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            db = db2;
                            if (db != null) {
                                mergeFrom(db);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (db != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Db db = new Db(true);
            defaultInstance = db;
            db.initFields();
        }

        public static Db getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.table_ = "";
            this.className_ = "";
            this.method_ = "";
            this.action_ = "";
            this.startTime_ = 0L;
            this.endTime_ = 0L;
            this.duration_ = 0L;
            this.ext_ = "";
            this.aliasId_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Db parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Db parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getAction() {
            Object obj = this.action_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.action_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getActionBytes() {
            Object obj = this.action_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.action_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getAliasId() {
            return this.aliasId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getClassName() {
            Object obj = this.className_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.className_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getClassNameBytes() {
            Object obj = this.className_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.className_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getDuration() {
            return this.duration_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getEndTime() {
            return this.endTime_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getExt() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getMethod() {
            Object obj = this.method_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.method_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getMethodBytes() {
            Object obj = this.method_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.method_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Db> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTableBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getClassNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, getMethodBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, getActionBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.startTime_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeInt64Size(6, this.endTime_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.duration_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeBytesSize += CodedOutputStream.computeBytesSize(8, getExtBytes());
            }
            if ((this.bitField0_ & 256) == 256) {
                computeBytesSize += CodedOutputStream.computeInt64Size(9, this.aliasId_);
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getStartTime() {
            return this.startTime_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getTable() {
            Object obj = this.table_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.table_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getTableBytes() {
            Object obj = this.table_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.table_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasAction() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasClassName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasDuration() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasEndTime() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasExt() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasMethod() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasStartTime() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasTable() {
            return (this.bitField0_ & 1) == 1;
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
                codedOutputStream.writeBytes(1, getTableBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getClassNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getMethodBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getActionBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(5, this.startTime_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt64(6, this.endTime_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt64(7, this.duration_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeBytes(8, getExtBytes());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt64(9, this.aliasId_);
            }
        }

        public static Builder newBuilder(Db db) {
            return newBuilder().mergeFrom(db);
        }

        public static Db parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Db parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Db getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Db(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Db(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Db parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Db parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Db parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Db(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.bitField0_ |= 1;
                                this.table_ = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.bitField0_ |= 2;
                                this.className_ = codedInputStream.readBytes();
                            } else if (readTag == 26) {
                                this.bitField0_ |= 4;
                                this.method_ = codedInputStream.readBytes();
                            } else if (readTag == 34) {
                                this.bitField0_ |= 8;
                                this.action_ = codedInputStream.readBytes();
                            } else if (readTag == 40) {
                                this.bitField0_ |= 16;
                                this.startTime_ = codedInputStream.readInt64();
                            } else if (readTag == 48) {
                                this.bitField0_ |= 32;
                                this.endTime_ = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.bitField0_ |= 64;
                                this.duration_ = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.bitField0_ |= 128;
                                this.ext_ = codedInputStream.readBytes();
                            } else if (readTag != 72) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 256;
                                this.aliasId_ = codedInputStream.readInt64();
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class DeviceID extends GeneratedMessageLite implements DeviceIDOrBuilder {
        public static final int CUID_FIELD_NUMBER = 4;
        public static Parser<DeviceID> PARSER = new AbstractParser<DeviceID>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceID.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public DeviceID parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DeviceID(codedInputStream, extensionRegistryLite);
            }
        };
        public static final DeviceID defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0_;
        public Object cuid_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DeviceID, Builder> implements DeviceIDOrBuilder {
            public int bitField0_;
            public Object cuid_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearCuid() {
                this.bitField0_ &= -2;
                this.cuid_ = DeviceID.getDefaultInstance().getCuid();
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public String getCuid() {
                Object obj = this.cuid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.cuid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public ByteString getCuidBytes() {
                Object obj = this.cuid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.cuid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public boolean hasCuid() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasCuid();
            }

            public Builder setCuid(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.cuid_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setCuidBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.cuid_ = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public DeviceID build() {
                DeviceID buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public DeviceID buildPartial() {
                DeviceID deviceID = new DeviceID(this);
                int i2 = (this.bitField0_ & 1) != 1 ? 0 : 1;
                deviceID.cuid_ = this.cuid_;
                deviceID.bitField0_ = i2;
                return deviceID;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.cuid_ = "";
                this.bitField0_ &= -2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public DeviceID getDefaultInstanceForType() {
                return DeviceID.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(DeviceID deviceID) {
                if (deviceID != DeviceID.getDefaultInstance() && deviceID.hasCuid()) {
                    this.bitField0_ |= 1;
                    this.cuid_ = deviceID.cuid_;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                DeviceID deviceID = null;
                try {
                    try {
                        DeviceID parsePartialFrom = DeviceID.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        DeviceID deviceID2 = (DeviceID) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            deviceID = deviceID2;
                            if (deviceID != null) {
                                mergeFrom(deviceID);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (deviceID != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            DeviceID deviceID = new DeviceID(true);
            defaultInstance = deviceID;
            deviceID.initFields();
        }

        public static DeviceID getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.cuid_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static DeviceID parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static DeviceID parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
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

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
        public ByteString getCuidBytes() {
            Object obj = this.cuid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cuid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<DeviceID> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, getCuidBytes()) : 0;
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
        public boolean hasCuid() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            } else if (!hasCuid()) {
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
                codedOutputStream.writeBytes(4, getCuidBytes());
            }
        }

        public static Builder newBuilder(DeviceID deviceID) {
            return newBuilder().mergeFrom(deviceID);
        }

        public static DeviceID parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static DeviceID parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public DeviceID getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public DeviceID(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public DeviceID(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DeviceID parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static DeviceID parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static DeviceID parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public DeviceID(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 34) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.cuid_ = codedInputStream.readBytes();
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

    /* loaded from: classes.dex */
    public interface DeviceIDOrBuilder extends MessageLiteOrBuilder {
        String getCuid();

        ByteString getCuidBytes();

        boolean hasCuid();
    }

    /* loaded from: classes.dex */
    public static final class LcpNetInfo extends GeneratedMessageLite implements LcpNetInfoOrBuilder {
        public static final int DOMAIN_FIELD_NUMBER = 4;
        public static final int IP_FIELD_NUMBER = 3;
        public static Parser<LcpNetInfo> PARSER = new AbstractParser<LcpNetInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public LcpNetInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LcpNetInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int PROTOCOL_FIELD_NUMBER = 1;
        public static final LcpNetInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0_;
        public Object domain_;
        public Object ip_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object port_;
        public Object protocol_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LcpNetInfo, Builder> implements LcpNetInfoOrBuilder {
            public int bitField0_;
            public Object protocol_ = "";
            public Object port_ = "";
            public Object ip_ = "";
            public Object domain_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearDomain() {
                this.bitField0_ &= -9;
                this.domain_ = LcpNetInfo.getDefaultInstance().getDomain();
                return this;
            }

            public Builder clearIp() {
                this.bitField0_ &= -5;
                this.ip_ = LcpNetInfo.getDefaultInstance().getIp();
                return this;
            }

            public Builder clearPort() {
                this.bitField0_ &= -3;
                this.port_ = LcpNetInfo.getDefaultInstance().getPort();
                return this;
            }

            public Builder clearProtocol() {
                this.bitField0_ &= -2;
                this.protocol_ = LcpNetInfo.getDefaultInstance().getProtocol();
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public String getDomain() {
                Object obj = this.domain_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.domain_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public ByteString getDomainBytes() {
                Object obj = this.domain_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.domain_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public String getIp() {
                Object obj = this.ip_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ip_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public ByteString getIpBytes() {
                Object obj = this.ip_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ip_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public String getPort() {
                Object obj = this.port_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.port_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public ByteString getPortBytes() {
                Object obj = this.port_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.port_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public String getProtocol() {
                Object obj = this.protocol_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.protocol_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public ByteString getProtocolBytes() {
                Object obj = this.protocol_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.protocol_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public boolean hasDomain() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public boolean hasIp() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public boolean hasPort() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public boolean hasProtocol() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setDomain(String str) {
                if (str != null) {
                    this.bitField0_ |= 8;
                    this.domain_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setDomainBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8;
                    this.domain_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setIp(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.ip_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setIpBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.ip_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setPort(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.port_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setPortBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.port_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setProtocol(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.protocol_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setProtocolBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.protocol_ = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LcpNetInfo build() {
                LcpNetInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LcpNetInfo buildPartial() {
                LcpNetInfo lcpNetInfo = new LcpNetInfo(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                lcpNetInfo.protocol_ = this.protocol_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                lcpNetInfo.port_ = this.port_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                lcpNetInfo.ip_ = this.ip_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                lcpNetInfo.domain_ = this.domain_;
                lcpNetInfo.bitField0_ = i3;
                return lcpNetInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.protocol_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.port_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.ip_ = "";
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.domain_ = "";
                this.bitField0_ = i4 & (-9);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LcpNetInfo getDefaultInstanceForType() {
                return LcpNetInfo.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(LcpNetInfo lcpNetInfo) {
                if (lcpNetInfo == LcpNetInfo.getDefaultInstance()) {
                    return this;
                }
                if (lcpNetInfo.hasProtocol()) {
                    this.bitField0_ |= 1;
                    this.protocol_ = lcpNetInfo.protocol_;
                }
                if (lcpNetInfo.hasPort()) {
                    this.bitField0_ |= 2;
                    this.port_ = lcpNetInfo.port_;
                }
                if (lcpNetInfo.hasIp()) {
                    this.bitField0_ |= 4;
                    this.ip_ = lcpNetInfo.ip_;
                }
                if (lcpNetInfo.hasDomain()) {
                    this.bitField0_ |= 8;
                    this.domain_ = lcpNetInfo.domain_;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LcpNetInfo lcpNetInfo = null;
                try {
                    try {
                        LcpNetInfo parsePartialFrom = LcpNetInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        LcpNetInfo lcpNetInfo2 = (LcpNetInfo) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            lcpNetInfo = lcpNetInfo2;
                            if (lcpNetInfo != null) {
                                mergeFrom(lcpNetInfo);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (lcpNetInfo != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            LcpNetInfo lcpNetInfo = new LcpNetInfo(true);
            defaultInstance = lcpNetInfo;
            lcpNetInfo.initFields();
        }

        public static LcpNetInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.protocol_ = "";
            this.port_ = "";
            this.ip_ = "";
            this.domain_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static LcpNetInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LcpNetInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public String getDomain() {
            Object obj = this.domain_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.domain_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public ByteString getDomainBytes() {
            Object obj = this.domain_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.domain_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public String getIp() {
            Object obj = this.ip_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ip_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public ByteString getIpBytes() {
            Object obj = this.ip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LcpNetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public String getPort() {
            Object obj = this.port_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.port_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public ByteString getPortBytes() {
            Object obj = this.port_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.port_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public String getProtocol() {
            Object obj = this.protocol_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.protocol_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public ByteString getProtocolBytes() {
            Object obj = this.protocol_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.protocol_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getProtocolBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getPortBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeBytesSize(3, getIpBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeBytesSize(4, getDomainBytes());
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public boolean hasDomain() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public boolean hasIp() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public boolean hasPort() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public boolean hasProtocol() {
            return (this.bitField0_ & 1) == 1;
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
                codedOutputStream.writeBytes(1, getProtocolBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getPortBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getIpBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getDomainBytes());
            }
        }

        public static Builder newBuilder(LcpNetInfo lcpNetInfo) {
            return newBuilder().mergeFrom(lcpNetInfo);
        }

        public static LcpNetInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LcpNetInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LcpNetInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public LcpNetInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LcpNetInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LcpNetInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LcpNetInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public LcpNetInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LcpNetInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LcpNetInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LcpNetInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public LcpNetInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.bitField0_ |= 1;
                                    this.protocol_ = codedInputStream.readBytes();
                                } else if (readTag == 18) {
                                    this.bitField0_ |= 2;
                                    this.port_ = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.bitField0_ |= 4;
                                    this.ip_ = codedInputStream.readBytes();
                                } else if (readTag != 34) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 8;
                                    this.domain_ = codedInputStream.readBytes();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface LcpNetInfoOrBuilder extends MessageLiteOrBuilder {
        String getDomain();

        ByteString getDomainBytes();

        String getIp();

        ByteString getIpBytes();

        String getPort();

        ByteString getPortBytes();

        String getProtocol();

        ByteString getProtocolBytes();

        boolean hasDomain();

        boolean hasIp();

        boolean hasPort();

        boolean hasProtocol();
    }

    /* loaded from: classes.dex */
    public static final class MetaData extends GeneratedMessageLite implements MetaDataOrBuilder {
        public static final int LOG_MODULE_ID_FIELD_NUMBER = 1;
        public static final int LOG_NAME_FIELD_NUMBER = 2;
        public static Parser<MetaData> PARSER = new AbstractParser<MetaData>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaData.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public MetaData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MetaData(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PRODUCT_NAME_FIELD_NUMBER = 3;
        public static final MetaData defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0_;
        public int logModuleId_;
        public Object logName_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object productName_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MetaData, Builder> implements MetaDataOrBuilder {
            public int bitField0_;
            public int logModuleId_ = 7399;
            public Object logName_ = "push_im_client";
            public Object productName_ = "phonebaidu";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearLogModuleId() {
                this.bitField0_ &= -2;
                this.logModuleId_ = 7399;
                return this;
            }

            public Builder clearLogName() {
                this.bitField0_ &= -3;
                this.logName_ = MetaData.getDefaultInstance().getLogName();
                return this;
            }

            public Builder clearProductName() {
                this.bitField0_ &= -5;
                this.productName_ = MetaData.getDefaultInstance().getProductName();
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public int getLogModuleId() {
                return this.logModuleId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public String getLogName() {
                Object obj = this.logName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.logName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public ByteString getLogNameBytes() {
                Object obj = this.logName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.logName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public String getProductName() {
                Object obj = this.productName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.productName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public ByteString getProductNameBytes() {
                Object obj = this.productName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.productName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasLogModuleId() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasLogName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasProductName() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setLogModuleId(int i2) {
                this.bitField0_ |= 1;
                this.logModuleId_ = i2;
                return this;
            }

            public Builder setLogName(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.logName_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setLogNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.logName_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setProductName(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.productName_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.productName_ = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public MetaData build() {
                MetaData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public MetaData buildPartial() {
                MetaData metaData = new MetaData(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                metaData.logModuleId_ = this.logModuleId_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                metaData.logName_ = this.logName_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                metaData.productName_ = this.productName_;
                metaData.bitField0_ = i3;
                return metaData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.logModuleId_ = 7399;
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.logName_ = "push_im_client";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.productName_ = "phonebaidu";
                this.bitField0_ = i3 & (-5);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public MetaData getDefaultInstanceForType() {
                return MetaData.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(MetaData metaData) {
                if (metaData == MetaData.getDefaultInstance()) {
                    return this;
                }
                if (metaData.hasLogModuleId()) {
                    setLogModuleId(metaData.getLogModuleId());
                }
                if (metaData.hasLogName()) {
                    this.bitField0_ |= 2;
                    this.logName_ = metaData.logName_;
                }
                if (metaData.hasProductName()) {
                    this.bitField0_ |= 4;
                    this.productName_ = metaData.productName_;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                MetaData metaData = null;
                try {
                    try {
                        MetaData parsePartialFrom = MetaData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        MetaData metaData2 = (MetaData) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            metaData = metaData2;
                            if (metaData != null) {
                                mergeFrom(metaData);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (metaData != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            MetaData metaData = new MetaData(true);
            defaultInstance = metaData;
            metaData.initFields();
        }

        public static MetaData getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.logModuleId_ = 7399;
            this.logName_ = "push_im_client";
            this.productName_ = "phonebaidu";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static MetaData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static MetaData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public int getLogModuleId() {
            return this.logModuleId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public String getLogName() {
            Object obj = this.logName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.logName_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public ByteString getLogNameBytes() {
            Object obj = this.logName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.logName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<MetaData> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public String getProductName() {
            Object obj = this.productName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.productName_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public ByteString getProductNameBytes() {
            Object obj = this.productName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.logModuleId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeBytesSize(2, getLogNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBytesSize(3, getProductNameBytes());
            }
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasLogModuleId() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasLogName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasProductName() {
            return (this.bitField0_ & 4) == 4;
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
                codedOutputStream.writeInt32(1, this.logModuleId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getLogNameBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getProductNameBytes());
            }
        }

        public static Builder newBuilder(MetaData metaData) {
            return newBuilder().mergeFrom(metaData);
        }

        public static MetaData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static MetaData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MetaData getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public MetaData(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public MetaData(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MetaData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static MetaData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static MetaData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public MetaData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.logModuleId_ = codedInputStream.readInt32();
                                } else if (readTag == 18) {
                                    this.bitField0_ |= 2;
                                    this.logName_ = codedInputStream.readBytes();
                                } else if (readTag != 26) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.productName_ = codedInputStream.readBytes();
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class Msg extends GeneratedMessageLite implements MsgOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 6;
        public static final int DURATION_FIELD_NUMBER = 3;
        public static final int END_MSGID_FIELD_NUMBER = 4;
        public static final int EXT_FIELD_NUMBER = 5;
        public static final int MSG_COUNT_FIELD_NUMBER = 1;
        public static Parser<Msg> PARSER = new AbstractParser<Msg>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Msg.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Msg parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Msg(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int ROOM_ID_FIELD_NUMBER = 2;
        public static final int START_MSGID_FIELD_NUMBER = 7;
        public static final Msg defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId_;
        public int bitField0_;
        public long duration_;
        public long endMsgid_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long msgCount_;
        public Object roomId_;
        public long startMsgid_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Msg, Builder> implements MsgOrBuilder {
            public long aliasId_;
            public int bitField0_;
            public long duration_;
            public long endMsgid_;
            public long msgCount_;
            public long startMsgid_;
            public Object roomId_ = "";
            public Object ext_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0_ &= -33;
                this.aliasId_ = 0L;
                return this;
            }

            public Builder clearDuration() {
                this.bitField0_ &= -5;
                this.duration_ = 0L;
                return this;
            }

            public Builder clearEndMsgid() {
                this.bitField0_ &= -9;
                this.endMsgid_ = 0L;
                return this;
            }

            public Builder clearExt() {
                this.bitField0_ &= -17;
                this.ext_ = Msg.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearMsgCount() {
                this.bitField0_ &= -2;
                this.msgCount_ = 0L;
                return this;
            }

            public Builder clearRoomId() {
                this.bitField0_ &= -3;
                this.roomId_ = Msg.getDefaultInstance().getRoomId();
                return this;
            }

            public Builder clearStartMsgid() {
                this.bitField0_ &= -65;
                this.startMsgid_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getAliasId() {
                return this.aliasId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getDuration() {
                return this.duration_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getEndMsgid() {
                return this.endMsgid_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public String getExt() {
                Object obj = this.ext_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ext_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getMsgCount() {
                return this.msgCount_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public String getRoomId() {
                Object obj = this.roomId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.roomId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public ByteString getRoomIdBytes() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getStartMsgid() {
                return this.startMsgid_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasDuration() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasEndMsgid() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasMsgCount() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasRoomId() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasStartMsgid() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0_ |= 32;
                this.aliasId_ = j;
                return this;
            }

            public Builder setDuration(long j) {
                this.bitField0_ |= 4;
                this.duration_ = j;
                return this;
            }

            public Builder setEndMsgid(long j) {
                this.bitField0_ |= 8;
                this.endMsgid_ = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0_ |= 16;
                    this.ext_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 16;
                    this.ext_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setMsgCount(long j) {
                this.bitField0_ |= 1;
                this.msgCount_ = j;
                return this;
            }

            public Builder setRoomId(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.roomId_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setRoomIdBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.roomId_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setStartMsgid(long j) {
                this.bitField0_ |= 64;
                this.startMsgid_ = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Msg build() {
                Msg buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Msg buildPartial() {
                Msg msg = new Msg(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                msg.msgCount_ = this.msgCount_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                msg.roomId_ = this.roomId_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                msg.duration_ = this.duration_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                msg.endMsgid_ = this.endMsgid_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                msg.ext_ = this.ext_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                msg.aliasId_ = this.aliasId_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                msg.startMsgid_ = this.startMsgid_;
                msg.bitField0_ = i3;
                return msg;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.msgCount_ = 0L;
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.roomId_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.duration_ = 0L;
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.endMsgid_ = 0L;
                int i5 = i4 & (-9);
                this.bitField0_ = i5;
                this.ext_ = "";
                int i6 = i5 & (-17);
                this.bitField0_ = i6;
                this.aliasId_ = 0L;
                int i7 = i6 & (-33);
                this.bitField0_ = i7;
                this.startMsgid_ = 0L;
                this.bitField0_ = i7 & (-65);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Msg getDefaultInstanceForType() {
                return Msg.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Msg msg) {
                if (msg == Msg.getDefaultInstance()) {
                    return this;
                }
                if (msg.hasMsgCount()) {
                    setMsgCount(msg.getMsgCount());
                }
                if (msg.hasRoomId()) {
                    this.bitField0_ |= 2;
                    this.roomId_ = msg.roomId_;
                }
                if (msg.hasDuration()) {
                    setDuration(msg.getDuration());
                }
                if (msg.hasEndMsgid()) {
                    setEndMsgid(msg.getEndMsgid());
                }
                if (msg.hasExt()) {
                    this.bitField0_ |= 16;
                    this.ext_ = msg.ext_;
                }
                if (msg.hasAliasId()) {
                    setAliasId(msg.getAliasId());
                }
                if (msg.hasStartMsgid()) {
                    setStartMsgid(msg.getStartMsgid());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Msg msg = null;
                try {
                    try {
                        Msg parsePartialFrom = Msg.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Msg msg2 = (Msg) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            msg = msg2;
                            if (msg != null) {
                                mergeFrom(msg);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (msg != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Msg msg = new Msg(true);
            defaultInstance = msg;
            msg.initFields();
        }

        public static Msg getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.msgCount_ = 0L;
            this.roomId_ = "";
            this.duration_ = 0L;
            this.endMsgid_ = 0L;
            this.ext_ = "";
            this.aliasId_ = 0L;
            this.startMsgid_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Msg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Msg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getAliasId() {
            return this.aliasId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getDuration() {
            return this.duration_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getEndMsgid() {
            return this.endMsgid_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public String getExt() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getMsgCount() {
            return this.msgCount_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Msg> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public String getRoomId() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.roomId_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public ByteString getRoomIdBytes() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.msgCount_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeBytesSize(2, getRoomIdBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.duration_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, this.endMsgid_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeBytesSize(5, getExtBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt64Size(6, this.aliasId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.startMsgid_);
            }
            this.memoizedSerializedSize = computeInt64Size;
            return computeInt64Size;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getStartMsgid() {
            return this.startMsgid_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasDuration() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasEndMsgid() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasExt() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasMsgCount() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasRoomId() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasStartMsgid() {
            return (this.bitField0_ & 64) == 64;
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
                codedOutputStream.writeInt64(1, this.msgCount_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getRoomIdBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.duration_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.endMsgid_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(5, getExtBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt64(6, this.aliasId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt64(7, this.startMsgid_);
            }
        }

        public static Builder newBuilder(Msg msg) {
            return newBuilder().mergeFrom(msg);
        }

        public static Msg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Msg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Msg getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Msg(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Msg(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Msg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Msg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Msg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Msg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.msgCount_ = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                this.bitField0_ |= 2;
                                this.roomId_ = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.duration_ = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.bitField0_ |= 8;
                                this.endMsgid_ = codedInputStream.readInt64();
                            } else if (readTag == 42) {
                                this.bitField0_ |= 16;
                                this.ext_ = codedInputStream.readBytes();
                            } else if (readTag == 48) {
                                this.bitField0_ |= 32;
                                this.aliasId_ = codedInputStream.readInt64();
                            } else if (readTag != 56) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 64;
                                this.startMsgid_ = codedInputStream.readInt64();
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class NetInfo extends GeneratedMessageLite implements NetInfoOrBuilder {
        public static final int NET_APN_FIELD_NUMBER = 2;
        public static final int NET_TYPE_FIELD_NUMBER = 1;
        public static Parser<NetInfo> PARSER = new AbstractParser<NetInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public NetInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new NetInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final NetInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object netApn_;
        public Object netType_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<NetInfo, Builder> implements NetInfoOrBuilder {
            public int bitField0_;
            public Object netType_ = "";
            public Object netApn_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearNetApn() {
                this.bitField0_ &= -3;
                this.netApn_ = NetInfo.getDefaultInstance().getNetApn();
                return this;
            }

            public Builder clearNetType() {
                this.bitField0_ &= -2;
                this.netType_ = NetInfo.getDefaultInstance().getNetType();
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public String getNetApn() {
                Object obj = this.netApn_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.netApn_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public ByteString getNetApnBytes() {
                Object obj = this.netApn_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.netApn_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public String getNetType() {
                Object obj = this.netType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.netType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public ByteString getNetTypeBytes() {
                Object obj = this.netType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.netType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public boolean hasNetApn() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public boolean hasNetType() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setNetApn(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.netApn_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setNetApnBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.netApn_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setNetType(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.netType_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setNetTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.netType_ = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NetInfo build() {
                NetInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NetInfo buildPartial() {
                NetInfo netInfo = new NetInfo(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                netInfo.netType_ = this.netType_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                netInfo.netApn_ = this.netApn_;
                netInfo.bitField0_ = i3;
                return netInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.netType_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.netApn_ = "";
                this.bitField0_ = i2 & (-3);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public NetInfo getDefaultInstanceForType() {
                return NetInfo.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(NetInfo netInfo) {
                if (netInfo == NetInfo.getDefaultInstance()) {
                    return this;
                }
                if (netInfo.hasNetType()) {
                    this.bitField0_ |= 1;
                    this.netType_ = netInfo.netType_;
                }
                if (netInfo.hasNetApn()) {
                    this.bitField0_ |= 2;
                    this.netApn_ = netInfo.netApn_;
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                NetInfo netInfo = null;
                try {
                    try {
                        NetInfo parsePartialFrom = NetInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        NetInfo netInfo2 = (NetInfo) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            netInfo = netInfo2;
                            if (netInfo != null) {
                                mergeFrom(netInfo);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (netInfo != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            NetInfo netInfo = new NetInfo(true);
            defaultInstance = netInfo;
            netInfo.initFields();
        }

        public static NetInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.netType_ = "";
            this.netApn_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static NetInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static NetInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public String getNetApn() {
            Object obj = this.netApn_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.netApn_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public ByteString getNetApnBytes() {
            Object obj = this.netApn_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.netApn_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public String getNetType() {
            Object obj = this.netType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.netType_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public ByteString getNetTypeBytes() {
            Object obj = this.netType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.netType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<NetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNetTypeBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getNetApnBytes());
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public boolean hasNetApn() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public boolean hasNetType() {
            return (this.bitField0_ & 1) == 1;
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
                codedOutputStream.writeBytes(1, getNetTypeBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getNetApnBytes());
            }
        }

        public static Builder newBuilder(NetInfo netInfo) {
            return newBuilder().mergeFrom(netInfo);
        }

        public static NetInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static NetInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public NetInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public NetInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public NetInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static NetInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static NetInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static NetInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public NetInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.bitField0_ |= 1;
                                this.netType_ = codedInputStream.readBytes();
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.netApn_ = codedInputStream.readBytes();
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

    /* loaded from: classes.dex */
    public interface NetInfoOrBuilder extends MessageLiteOrBuilder {
        String getNetApn();

        ByteString getNetApnBytes();

        String getNetType();

        ByteString getNetTypeBytes();

        boolean hasNetApn();

        boolean hasNetType();
    }

    /* loaded from: classes.dex */
    public static final class NewConnection extends GeneratedMessageLite implements NewConnectionOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 16;
        public static final int CONNECT_ERROR_CODE_FIELD_NUMBER = 4;
        public static final int CONNECT_SOURCE_FIELD_NUMBER = 13;
        public static final int CONNECT_STATE_FIELD_NUMBER = 3;
        public static final int DNS_BEGIN_FIELD_NUMBER = 7;
        public static final int DNS_END_FIELD_NUMBER = 8;
        public static final int END_TIME_FIELD_NUMBER = 2;
        public static final int EXT_FIELD_NUMBER = 14;
        public static final int LCP_LOGIN_BEGIN_FIELD_NUMBER = 11;
        public static final int LCP_LOGIN_END_FIELD_NUMBER = 12;
        public static final int NET_INFO_FIELD_NUMBER = 15;
        public static Parser<NewConnection> PARSER = new AbstractParser<NewConnection>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnection.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public NewConnection parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new NewConnection(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RETRY_FIELD_NUMBER = 17;
        public static final int SOCKET_BEGIN_FIELD_NUMBER = 9;
        public static final int SOCKET_END_FIELD_NUMBER = 10;
        public static final int START_TIME_FIELD_NUMBER = 1;
        public static final int TOKEN_BEGIN_FIELD_NUMBER = 5;
        public static final int TOKEN_END_FIELD_NUMBER = 6;
        public static final NewConnection defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId_;
        public int bitField0_;
        public Object connectErrorCode_;
        public Object connectSource_;
        public long connectState_;
        public long dnsBegin_;
        public long dnsEnd_;
        public long endTime_;
        public Object ext_;
        public long lcpLoginBegin_;
        public long lcpLoginEnd_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public LcpNetInfo netInfo_;
        public long retry_;
        public long socketBegin_;
        public long socketEnd_;
        public long startTime_;
        public long tokenBegin_;
        public long tokenEnd_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<NewConnection, Builder> implements NewConnectionOrBuilder {
            public long aliasId_;
            public int bitField0_;
            public long connectState_;
            public long dnsBegin_;
            public long dnsEnd_;
            public long endTime_;
            public long lcpLoginBegin_;
            public long lcpLoginEnd_;
            public long retry_;
            public long socketBegin_;
            public long socketEnd_;
            public long startTime_;
            public long tokenBegin_;
            public long tokenEnd_;
            public Object connectErrorCode_ = "";
            public Object connectSource_ = "";
            public Object ext_ = "";
            public LcpNetInfo netInfo_ = LcpNetInfo.getDefaultInstance();

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0_ &= -32769;
                this.aliasId_ = 0L;
                return this;
            }

            public Builder clearConnectErrorCode() {
                this.bitField0_ &= -9;
                this.connectErrorCode_ = NewConnection.getDefaultInstance().getConnectErrorCode();
                return this;
            }

            public Builder clearConnectSource() {
                this.bitField0_ &= -4097;
                this.connectSource_ = NewConnection.getDefaultInstance().getConnectSource();
                return this;
            }

            public Builder clearConnectState() {
                this.bitField0_ &= -5;
                this.connectState_ = 0L;
                return this;
            }

            public Builder clearDnsBegin() {
                this.bitField0_ &= -65;
                this.dnsBegin_ = 0L;
                return this;
            }

            public Builder clearDnsEnd() {
                this.bitField0_ &= -129;
                this.dnsEnd_ = 0L;
                return this;
            }

            public Builder clearEndTime() {
                this.bitField0_ &= -3;
                this.endTime_ = 0L;
                return this;
            }

            public Builder clearExt() {
                this.bitField0_ &= -8193;
                this.ext_ = NewConnection.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearLcpLoginBegin() {
                this.bitField0_ &= -1025;
                this.lcpLoginBegin_ = 0L;
                return this;
            }

            public Builder clearLcpLoginEnd() {
                this.bitField0_ &= -2049;
                this.lcpLoginEnd_ = 0L;
                return this;
            }

            public Builder clearNetInfo() {
                this.netInfo_ = LcpNetInfo.getDefaultInstance();
                this.bitField0_ &= -16385;
                return this;
            }

            public Builder clearRetry() {
                this.bitField0_ &= -65537;
                this.retry_ = 0L;
                return this;
            }

            public Builder clearSocketBegin() {
                this.bitField0_ &= -257;
                this.socketBegin_ = 0L;
                return this;
            }

            public Builder clearSocketEnd() {
                this.bitField0_ &= -513;
                this.socketEnd_ = 0L;
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0_ &= -2;
                this.startTime_ = 0L;
                return this;
            }

            public Builder clearTokenBegin() {
                this.bitField0_ &= -17;
                this.tokenBegin_ = 0L;
                return this;
            }

            public Builder clearTokenEnd() {
                this.bitField0_ &= -33;
                this.tokenEnd_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getAliasId() {
                return this.aliasId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public String getConnectErrorCode() {
                Object obj = this.connectErrorCode_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.connectErrorCode_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public ByteString getConnectErrorCodeBytes() {
                Object obj = this.connectErrorCode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.connectErrorCode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public String getConnectSource() {
                Object obj = this.connectSource_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.connectSource_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public ByteString getConnectSourceBytes() {
                Object obj = this.connectSource_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.connectSource_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getConnectState() {
                return this.connectState_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getDnsBegin() {
                return this.dnsBegin_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getDnsEnd() {
                return this.dnsEnd_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getEndTime() {
                return this.endTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public String getExt() {
                Object obj = this.ext_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ext_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getLcpLoginBegin() {
                return this.lcpLoginBegin_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getLcpLoginEnd() {
                return this.lcpLoginEnd_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public LcpNetInfo getNetInfo() {
                return this.netInfo_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getRetry() {
                return this.retry_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getSocketBegin() {
                return this.socketBegin_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getSocketEnd() {
                return this.socketEnd_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getStartTime() {
                return this.startTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getTokenBegin() {
                return this.tokenBegin_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getTokenEnd() {
                return this.tokenEnd_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0_ & 32768) == 32768;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasConnectErrorCode() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasConnectSource() {
                return (this.bitField0_ & 4096) == 4096;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasConnectState() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasDnsBegin() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasDnsEnd() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasEndTime() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 8192) == 8192;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasLcpLoginBegin() {
                return (this.bitField0_ & 1024) == 1024;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasLcpLoginEnd() {
                return (this.bitField0_ & 2048) == 2048;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasNetInfo() {
                return (this.bitField0_ & 16384) == 16384;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasRetry() {
                return (this.bitField0_ & 65536) == 65536;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasSocketBegin() {
                return (this.bitField0_ & 256) == 256;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasSocketEnd() {
                return (this.bitField0_ & 512) == 512;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasStartTime() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasTokenBegin() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasTokenEnd() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeNetInfo(LcpNetInfo lcpNetInfo) {
                if ((this.bitField0_ & 16384) == 16384 && this.netInfo_ != LcpNetInfo.getDefaultInstance()) {
                    this.netInfo_ = LcpNetInfo.newBuilder(this.netInfo_).mergeFrom(lcpNetInfo).buildPartial();
                } else {
                    this.netInfo_ = lcpNetInfo;
                }
                this.bitField0_ |= 16384;
                return this;
            }

            public Builder setAliasId(long j) {
                this.bitField0_ |= 32768;
                this.aliasId_ = j;
                return this;
            }

            public Builder setConnectErrorCode(String str) {
                if (str != null) {
                    this.bitField0_ |= 8;
                    this.connectErrorCode_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setConnectErrorCodeBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8;
                    this.connectErrorCode_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setConnectSource(String str) {
                if (str != null) {
                    this.bitField0_ |= 4096;
                    this.connectSource_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setConnectSourceBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4096;
                    this.connectSource_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setConnectState(long j) {
                this.bitField0_ |= 4;
                this.connectState_ = j;
                return this;
            }

            public Builder setDnsBegin(long j) {
                this.bitField0_ |= 64;
                this.dnsBegin_ = j;
                return this;
            }

            public Builder setDnsEnd(long j) {
                this.bitField0_ |= 128;
                this.dnsEnd_ = j;
                return this;
            }

            public Builder setEndTime(long j) {
                this.bitField0_ |= 2;
                this.endTime_ = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0_ |= 8192;
                    this.ext_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8192;
                    this.ext_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setLcpLoginBegin(long j) {
                this.bitField0_ |= 1024;
                this.lcpLoginBegin_ = j;
                return this;
            }

            public Builder setLcpLoginEnd(long j) {
                this.bitField0_ |= 2048;
                this.lcpLoginEnd_ = j;
                return this;
            }

            public Builder setNetInfo(LcpNetInfo lcpNetInfo) {
                if (lcpNetInfo != null) {
                    this.netInfo_ = lcpNetInfo;
                    this.bitField0_ |= 16384;
                    return this;
                }
                throw null;
            }

            public Builder setRetry(long j) {
                this.bitField0_ |= 65536;
                this.retry_ = j;
                return this;
            }

            public Builder setSocketBegin(long j) {
                this.bitField0_ |= 256;
                this.socketBegin_ = j;
                return this;
            }

            public Builder setSocketEnd(long j) {
                this.bitField0_ |= 512;
                this.socketEnd_ = j;
                return this;
            }

            public Builder setStartTime(long j) {
                this.bitField0_ |= 1;
                this.startTime_ = j;
                return this;
            }

            public Builder setTokenBegin(long j) {
                this.bitField0_ |= 16;
                this.tokenBegin_ = j;
                return this;
            }

            public Builder setTokenEnd(long j) {
                this.bitField0_ |= 32;
                this.tokenEnd_ = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NewConnection build() {
                NewConnection buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NewConnection buildPartial() {
                NewConnection newConnection = new NewConnection(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                newConnection.startTime_ = this.startTime_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                newConnection.endTime_ = this.endTime_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                newConnection.connectState_ = this.connectState_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                newConnection.connectErrorCode_ = this.connectErrorCode_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                newConnection.tokenBegin_ = this.tokenBegin_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                newConnection.tokenEnd_ = this.tokenEnd_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                newConnection.dnsBegin_ = this.dnsBegin_;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                newConnection.dnsEnd_ = this.dnsEnd_;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                newConnection.socketBegin_ = this.socketBegin_;
                if ((i2 & 512) == 512) {
                    i3 |= 512;
                }
                newConnection.socketEnd_ = this.socketEnd_;
                if ((i2 & 1024) == 1024) {
                    i3 |= 1024;
                }
                newConnection.lcpLoginBegin_ = this.lcpLoginBegin_;
                if ((i2 & 2048) == 2048) {
                    i3 |= 2048;
                }
                newConnection.lcpLoginEnd_ = this.lcpLoginEnd_;
                if ((i2 & 4096) == 4096) {
                    i3 |= 4096;
                }
                newConnection.connectSource_ = this.connectSource_;
                if ((i2 & 8192) == 8192) {
                    i3 |= 8192;
                }
                newConnection.ext_ = this.ext_;
                if ((i2 & 16384) == 16384) {
                    i3 |= 16384;
                }
                newConnection.netInfo_ = this.netInfo_;
                if ((i2 & 32768) == 32768) {
                    i3 |= 32768;
                }
                newConnection.aliasId_ = this.aliasId_;
                if ((i2 & 65536) == 65536) {
                    i3 |= 65536;
                }
                newConnection.retry_ = this.retry_;
                newConnection.bitField0_ = i3;
                return newConnection;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.startTime_ = 0L;
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.endTime_ = 0L;
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.connectState_ = 0L;
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.connectErrorCode_ = "";
                int i5 = i4 & (-9);
                this.bitField0_ = i5;
                this.tokenBegin_ = 0L;
                int i6 = i5 & (-17);
                this.bitField0_ = i6;
                this.tokenEnd_ = 0L;
                int i7 = i6 & (-33);
                this.bitField0_ = i7;
                this.dnsBegin_ = 0L;
                int i8 = i7 & (-65);
                this.bitField0_ = i8;
                this.dnsEnd_ = 0L;
                int i9 = i8 & (-129);
                this.bitField0_ = i9;
                this.socketBegin_ = 0L;
                int i10 = i9 & (-257);
                this.bitField0_ = i10;
                this.socketEnd_ = 0L;
                int i11 = i10 & (-513);
                this.bitField0_ = i11;
                this.lcpLoginBegin_ = 0L;
                int i12 = i11 & (-1025);
                this.bitField0_ = i12;
                this.lcpLoginEnd_ = 0L;
                int i13 = i12 & (-2049);
                this.bitField0_ = i13;
                this.connectSource_ = "";
                int i14 = i13 & (-4097);
                this.bitField0_ = i14;
                this.ext_ = "";
                this.bitField0_ = i14 & (-8193);
                this.netInfo_ = LcpNetInfo.getDefaultInstance();
                int i15 = this.bitField0_ & (-16385);
                this.bitField0_ = i15;
                this.aliasId_ = 0L;
                int i16 = i15 & (-32769);
                this.bitField0_ = i16;
                this.retry_ = 0L;
                this.bitField0_ = (-65537) & i16;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public NewConnection getDefaultInstanceForType() {
                return NewConnection.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(NewConnection newConnection) {
                if (newConnection == NewConnection.getDefaultInstance()) {
                    return this;
                }
                if (newConnection.hasStartTime()) {
                    setStartTime(newConnection.getStartTime());
                }
                if (newConnection.hasEndTime()) {
                    setEndTime(newConnection.getEndTime());
                }
                if (newConnection.hasConnectState()) {
                    setConnectState(newConnection.getConnectState());
                }
                if (newConnection.hasConnectErrorCode()) {
                    this.bitField0_ |= 8;
                    this.connectErrorCode_ = newConnection.connectErrorCode_;
                }
                if (newConnection.hasTokenBegin()) {
                    setTokenBegin(newConnection.getTokenBegin());
                }
                if (newConnection.hasTokenEnd()) {
                    setTokenEnd(newConnection.getTokenEnd());
                }
                if (newConnection.hasDnsBegin()) {
                    setDnsBegin(newConnection.getDnsBegin());
                }
                if (newConnection.hasDnsEnd()) {
                    setDnsEnd(newConnection.getDnsEnd());
                }
                if (newConnection.hasSocketBegin()) {
                    setSocketBegin(newConnection.getSocketBegin());
                }
                if (newConnection.hasSocketEnd()) {
                    setSocketEnd(newConnection.getSocketEnd());
                }
                if (newConnection.hasLcpLoginBegin()) {
                    setLcpLoginBegin(newConnection.getLcpLoginBegin());
                }
                if (newConnection.hasLcpLoginEnd()) {
                    setLcpLoginEnd(newConnection.getLcpLoginEnd());
                }
                if (newConnection.hasConnectSource()) {
                    this.bitField0_ |= 4096;
                    this.connectSource_ = newConnection.connectSource_;
                }
                if (newConnection.hasExt()) {
                    this.bitField0_ |= 8192;
                    this.ext_ = newConnection.ext_;
                }
                if (newConnection.hasNetInfo()) {
                    mergeNetInfo(newConnection.getNetInfo());
                }
                if (newConnection.hasAliasId()) {
                    setAliasId(newConnection.getAliasId());
                }
                if (newConnection.hasRetry()) {
                    setRetry(newConnection.getRetry());
                }
                return this;
            }

            public Builder setNetInfo(LcpNetInfo.Builder builder) {
                this.netInfo_ = builder.build();
                this.bitField0_ |= 16384;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                NewConnection newConnection = null;
                try {
                    try {
                        NewConnection parsePartialFrom = NewConnection.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        NewConnection newConnection2 = (NewConnection) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            newConnection = newConnection2;
                            if (newConnection != null) {
                                mergeFrom(newConnection);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (newConnection != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            NewConnection newConnection = new NewConnection(true);
            defaultInstance = newConnection;
            newConnection.initFields();
        }

        public static NewConnection getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.startTime_ = 0L;
            this.endTime_ = 0L;
            this.connectState_ = 0L;
            this.connectErrorCode_ = "";
            this.tokenBegin_ = 0L;
            this.tokenEnd_ = 0L;
            this.dnsBegin_ = 0L;
            this.dnsEnd_ = 0L;
            this.socketBegin_ = 0L;
            this.socketEnd_ = 0L;
            this.lcpLoginBegin_ = 0L;
            this.lcpLoginEnd_ = 0L;
            this.connectSource_ = "";
            this.ext_ = "";
            this.netInfo_ = LcpNetInfo.getDefaultInstance();
            this.aliasId_ = 0L;
            this.retry_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static NewConnection parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static NewConnection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getAliasId() {
            return this.aliasId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public String getConnectErrorCode() {
            Object obj = this.connectErrorCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.connectErrorCode_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public ByteString getConnectErrorCodeBytes() {
            Object obj = this.connectErrorCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.connectErrorCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public String getConnectSource() {
            Object obj = this.connectSource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.connectSource_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public ByteString getConnectSourceBytes() {
            Object obj = this.connectSource_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.connectSource_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getConnectState() {
            return this.connectState_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getDnsBegin() {
            return this.dnsBegin_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getDnsEnd() {
            return this.dnsEnd_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getEndTime() {
            return this.endTime_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public String getExt() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getLcpLoginBegin() {
            return this.lcpLoginBegin_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getLcpLoginEnd() {
            return this.lcpLoginEnd_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public LcpNetInfo getNetInfo() {
            return this.netInfo_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<NewConnection> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getRetry() {
            return this.retry_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeInt64Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.startTime_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, this.endTime_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt64Size += CodedOutputStream.computeInt64Size(3, this.connectState_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt64Size += CodedOutputStream.computeBytesSize(4, getConnectErrorCodeBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                computeInt64Size += CodedOutputStream.computeInt64Size(5, this.tokenBegin_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeInt64Size += CodedOutputStream.computeInt64Size(6, this.tokenEnd_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeInt64Size += CodedOutputStream.computeInt64Size(7, this.dnsBegin_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeInt64Size += CodedOutputStream.computeInt64Size(8, this.dnsEnd_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeInt64Size += CodedOutputStream.computeInt64Size(9, this.socketBegin_);
            }
            if ((this.bitField0_ & 512) == 512) {
                computeInt64Size += CodedOutputStream.computeInt64Size(10, this.socketEnd_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                computeInt64Size += CodedOutputStream.computeInt64Size(11, this.lcpLoginBegin_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                computeInt64Size += CodedOutputStream.computeInt64Size(12, this.lcpLoginEnd_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                computeInt64Size += CodedOutputStream.computeBytesSize(13, getConnectSourceBytes());
            }
            if ((this.bitField0_ & 8192) == 8192) {
                computeInt64Size += CodedOutputStream.computeBytesSize(14, getExtBytes());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                computeInt64Size += CodedOutputStream.computeMessageSize(15, this.netInfo_);
            }
            if ((this.bitField0_ & 32768) == 32768) {
                computeInt64Size += CodedOutputStream.computeInt64Size(16, this.aliasId_);
            }
            if ((this.bitField0_ & 65536) == 65536) {
                computeInt64Size += CodedOutputStream.computeInt64Size(17, this.retry_);
            }
            this.memoizedSerializedSize = computeInt64Size;
            return computeInt64Size;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getSocketBegin() {
            return this.socketBegin_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getSocketEnd() {
            return this.socketEnd_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getStartTime() {
            return this.startTime_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getTokenBegin() {
            return this.tokenBegin_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getTokenEnd() {
            return this.tokenEnd_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0_ & 32768) == 32768;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasConnectErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasConnectSource() {
            return (this.bitField0_ & 4096) == 4096;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasConnectState() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasDnsBegin() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasDnsEnd() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasEndTime() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasExt() {
            return (this.bitField0_ & 8192) == 8192;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasLcpLoginBegin() {
            return (this.bitField0_ & 1024) == 1024;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasLcpLoginEnd() {
            return (this.bitField0_ & 2048) == 2048;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasNetInfo() {
            return (this.bitField0_ & 16384) == 16384;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasRetry() {
            return (this.bitField0_ & 65536) == 65536;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasSocketBegin() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasSocketEnd() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasStartTime() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasTokenBegin() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasTokenEnd() {
            return (this.bitField0_ & 32) == 32;
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
                codedOutputStream.writeInt64(1, this.startTime_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(2, this.endTime_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.connectState_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getConnectErrorCodeBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(5, this.tokenBegin_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt64(6, this.tokenEnd_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt64(7, this.dnsBegin_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt64(8, this.dnsEnd_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeInt64(9, this.socketBegin_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeInt64(10, this.socketEnd_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeInt64(11, this.lcpLoginBegin_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeInt64(12, this.lcpLoginEnd_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeBytes(13, getConnectSourceBytes());
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.writeBytes(14, getExtBytes());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                codedOutputStream.writeMessage(15, this.netInfo_);
            }
            if ((this.bitField0_ & 32768) == 32768) {
                codedOutputStream.writeInt64(16, this.aliasId_);
            }
            if ((this.bitField0_ & 65536) == 65536) {
                codedOutputStream.writeInt64(17, this.retry_);
            }
        }

        public static Builder newBuilder(NewConnection newConnection) {
            return newBuilder().mergeFrom(newConnection);
        }

        public static NewConnection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static NewConnection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public NewConnection getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public NewConnection(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static NewConnection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static NewConnection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static NewConnection parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public NewConnection(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static NewConnection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static NewConnection parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static NewConnection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public NewConnection(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.bitField0_ |= 1;
                                this.startTime_ = codedInputStream.readInt64();
                                continue;
                            case 16:
                                this.bitField0_ |= 2;
                                this.endTime_ = codedInputStream.readInt64();
                                continue;
                            case 24:
                                this.bitField0_ |= 4;
                                this.connectState_ = codedInputStream.readInt64();
                                continue;
                            case 34:
                                this.bitField0_ |= 8;
                                this.connectErrorCode_ = codedInputStream.readBytes();
                                continue;
                            case 40:
                                this.bitField0_ |= 16;
                                this.tokenBegin_ = codedInputStream.readInt64();
                                continue;
                            case 48:
                                this.bitField0_ |= 32;
                                this.tokenEnd_ = codedInputStream.readInt64();
                                continue;
                            case 56:
                                this.bitField0_ |= 64;
                                this.dnsBegin_ = codedInputStream.readInt64();
                                continue;
                            case 64:
                                this.bitField0_ |= 128;
                                this.dnsEnd_ = codedInputStream.readInt64();
                                continue;
                            case 72:
                                this.bitField0_ |= 256;
                                this.socketBegin_ = codedInputStream.readInt64();
                                continue;
                            case 80:
                                this.bitField0_ |= 512;
                                this.socketEnd_ = codedInputStream.readInt64();
                                continue;
                            case 88:
                                this.bitField0_ |= 1024;
                                this.lcpLoginBegin_ = codedInputStream.readInt64();
                                continue;
                            case 96:
                                this.bitField0_ |= 2048;
                                this.lcpLoginEnd_ = codedInputStream.readInt64();
                                continue;
                            case 106:
                                this.bitField0_ |= 4096;
                                this.connectSource_ = codedInputStream.readBytes();
                                continue;
                            case 114:
                                this.bitField0_ |= 8192;
                                this.ext_ = codedInputStream.readBytes();
                                continue;
                            case 122:
                                LcpNetInfo.Builder builder = (this.bitField0_ & 16384) == 16384 ? this.netInfo_.toBuilder() : null;
                                LcpNetInfo lcpNetInfo = (LcpNetInfo) codedInputStream.readMessage(LcpNetInfo.PARSER, extensionRegistryLite);
                                this.netInfo_ = lcpNetInfo;
                                if (builder != null) {
                                    builder.mergeFrom(lcpNetInfo);
                                    this.netInfo_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 16384;
                                continue;
                            case 128:
                                this.bitField0_ |= 32768;
                                this.aliasId_ = codedInputStream.readInt64();
                                continue;
                            case 136:
                                this.bitField0_ |= 65536;
                                this.retry_ = codedInputStream.readInt64();
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

    /* loaded from: classes.dex */
    public interface NewConnectionOrBuilder extends MessageLiteOrBuilder {
        long getAliasId();

        String getConnectErrorCode();

        ByteString getConnectErrorCodeBytes();

        String getConnectSource();

        ByteString getConnectSourceBytes();

        long getConnectState();

        long getDnsBegin();

        long getDnsEnd();

        long getEndTime();

        String getExt();

        ByteString getExtBytes();

        long getLcpLoginBegin();

        long getLcpLoginEnd();

        LcpNetInfo getNetInfo();

        long getRetry();

        long getSocketBegin();

        long getSocketEnd();

        long getStartTime();

        long getTokenBegin();

        long getTokenEnd();

        boolean hasAliasId();

        boolean hasConnectErrorCode();

        boolean hasConnectSource();

        boolean hasConnectState();

        boolean hasDnsBegin();

        boolean hasDnsEnd();

        boolean hasEndTime();

        boolean hasExt();

        boolean hasLcpLoginBegin();

        boolean hasLcpLoginEnd();

        boolean hasNetInfo();

        boolean hasRetry();

        boolean hasSocketBegin();

        boolean hasSocketEnd();

        boolean hasStartTime();

        boolean hasTokenBegin();

        boolean hasTokenEnd();
    }

    /* loaded from: classes.dex */
    public enum OSType implements Internal.EnumLite {
        OS_TYPE_UNKNWON(0, 0),
        IOS(1, 1),
        ANDROID(2, 2),
        WINDOWSPHONE(3, 3);
        
        public static final int ANDROID_VALUE = 2;
        public static final int IOS_VALUE = 1;
        public static final int OS_TYPE_UNKNWON_VALUE = 0;
        public static final int WINDOWSPHONE_VALUE = 3;
        public static Internal.EnumLiteMap<OSType> internalValueMap = new Internal.EnumLiteMap<OSType>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.OSType.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public OSType findValueByNumber(int i2) {
                return OSType.valueOf(i2);
            }
        };
        public final int value;

        OSType(int i2, int i3) {
            this.value = i3;
        }

        public static Internal.EnumLiteMap<OSType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static OSType valueOf(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return null;
                        }
                        return WINDOWSPHONE;
                    }
                    return ANDROID;
                }
                return IOS;
            }
            return OS_TYPE_UNKNWON;
        }
    }

    /* loaded from: classes.dex */
    public static final class PushImClient extends GeneratedMessageLite implements PushImClientOrBuilder {
        public static final int ACTIONS_FIELD_NUMBER = 132;
        public static final int COMMON_FIELD_NUMBER = 41;
        public static final int METADATA_FIELD_NUMBER = 25;
        public static Parser<PushImClient> PARSER = new AbstractParser<PushImClient>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClient.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public PushImClient parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PushImClient(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SDK_NAME_FIELD_NUMBER = 130;
        public static final int SDK_VERSION_FIELD_NUMBER = 131;
        public static final PushImClient defaultInstance;
        public static final long serialVersionUID = 0;
        public List<Action> actions_;
        public int bitField0_;
        public Common common_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public MetaData metadata_;
        public Object sdkName_;
        public long sdkVersion_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<PushImClient, Builder> implements PushImClientOrBuilder {
            public int bitField0_;
            public long sdkVersion_;
            public MetaData metadata_ = MetaData.getDefaultInstance();
            public Common common_ = Common.getDefaultInstance();
            public Object sdkName_ = "";
            public List<Action> actions_ = Collections.emptyList();

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void ensureActionsIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.actions_ = new ArrayList(this.actions_);
                    this.bitField0_ |= 16;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addActions(Action action) {
                if (action != null) {
                    ensureActionsIsMutable();
                    this.actions_.add(action);
                    return this;
                }
                throw null;
            }

            public Builder addAllActions(Iterable<? extends Action> iterable) {
                ensureActionsIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.actions_);
                return this;
            }

            public Builder clearActions() {
                this.actions_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearCommon() {
                this.common_ = Common.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearMetadata() {
                this.metadata_ = MetaData.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearSdkName() {
                this.bitField0_ &= -5;
                this.sdkName_ = PushImClient.getDefaultInstance().getSdkName();
                return this;
            }

            public Builder clearSdkVersion() {
                this.bitField0_ &= -9;
                this.sdkVersion_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public Action getActions(int i2) {
                return this.actions_.get(i2);
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public int getActionsCount() {
                return this.actions_.size();
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public List<Action> getActionsList() {
                return Collections.unmodifiableList(this.actions_);
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public Common getCommon() {
                return this.common_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public MetaData getMetadata() {
                return this.metadata_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public String getSdkName() {
                Object obj = this.sdkName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.sdkName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public ByteString getSdkNameBytes() {
                Object obj = this.sdkName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sdkName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public long getSdkVersion() {
                return this.sdkVersion_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasCommon() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasMetadata() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasSdkName() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasSdkVersion() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return hasCommon() && getCommon().isInitialized();
            }

            public Builder mergeCommon(Common common2) {
                if ((this.bitField0_ & 2) == 2 && this.common_ != Common.getDefaultInstance()) {
                    this.common_ = Common.newBuilder(this.common_).mergeFrom(common2).buildPartial();
                } else {
                    this.common_ = common2;
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeMetadata(MetaData metaData) {
                if ((this.bitField0_ & 1) == 1 && this.metadata_ != MetaData.getDefaultInstance()) {
                    this.metadata_ = MetaData.newBuilder(this.metadata_).mergeFrom(metaData).buildPartial();
                } else {
                    this.metadata_ = metaData;
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder removeActions(int i2) {
                ensureActionsIsMutable();
                this.actions_.remove(i2);
                return this;
            }

            public Builder setActions(int i2, Action action) {
                if (action != null) {
                    ensureActionsIsMutable();
                    this.actions_.set(i2, action);
                    return this;
                }
                throw null;
            }

            public Builder setCommon(Common common2) {
                if (common2 != null) {
                    this.common_ = common2;
                    this.bitField0_ |= 2;
                    return this;
                }
                throw null;
            }

            public Builder setMetadata(MetaData metaData) {
                if (metaData != null) {
                    this.metadata_ = metaData;
                    this.bitField0_ |= 1;
                    return this;
                }
                throw null;
            }

            public Builder setSdkName(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.sdkName_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setSdkNameBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.sdkName_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setSdkVersion(long j) {
                this.bitField0_ |= 8;
                this.sdkVersion_ = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public PushImClient build() {
                PushImClient buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public PushImClient buildPartial() {
                PushImClient pushImClient = new PushImClient(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                pushImClient.metadata_ = this.metadata_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                pushImClient.common_ = this.common_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                pushImClient.sdkName_ = this.sdkName_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                pushImClient.sdkVersion_ = this.sdkVersion_;
                if ((this.bitField0_ & 16) == 16) {
                    this.actions_ = Collections.unmodifiableList(this.actions_);
                    this.bitField0_ &= -17;
                }
                pushImClient.actions_ = this.actions_;
                pushImClient.bitField0_ = i3;
                return pushImClient;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.metadata_ = MetaData.getDefaultInstance();
                this.bitField0_ &= -2;
                this.common_ = Common.getDefaultInstance();
                int i2 = this.bitField0_ & (-3);
                this.bitField0_ = i2;
                this.sdkName_ = "";
                int i3 = i2 & (-5);
                this.bitField0_ = i3;
                this.sdkVersion_ = 0L;
                this.bitField0_ = i3 & (-9);
                this.actions_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public PushImClient getDefaultInstanceForType() {
                return PushImClient.getDefaultInstance();
            }

            public Builder addActions(int i2, Action action) {
                if (action != null) {
                    ensureActionsIsMutable();
                    this.actions_.add(i2, action);
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(PushImClient pushImClient) {
                if (pushImClient == PushImClient.getDefaultInstance()) {
                    return this;
                }
                if (pushImClient.hasMetadata()) {
                    mergeMetadata(pushImClient.getMetadata());
                }
                if (pushImClient.hasCommon()) {
                    mergeCommon(pushImClient.getCommon());
                }
                if (pushImClient.hasSdkName()) {
                    this.bitField0_ |= 4;
                    this.sdkName_ = pushImClient.sdkName_;
                }
                if (pushImClient.hasSdkVersion()) {
                    setSdkVersion(pushImClient.getSdkVersion());
                }
                if (!pushImClient.actions_.isEmpty()) {
                    if (this.actions_.isEmpty()) {
                        this.actions_ = pushImClient.actions_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureActionsIsMutable();
                        this.actions_.addAll(pushImClient.actions_);
                    }
                }
                return this;
            }

            public Builder setActions(int i2, Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions_.set(i2, builder.build());
                return this;
            }

            public Builder setCommon(Common.Builder builder) {
                this.common_ = builder.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setMetadata(MetaData.Builder builder) {
                this.metadata_ = builder.build();
                this.bitField0_ |= 1;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder addActions(Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions_.add(builder.build());
                return this;
            }

            public Builder addActions(int i2, Action.Builder builder) {
                ensureActionsIsMutable();
                this.actions_.add(i2, builder.build());
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                PushImClient pushImClient = null;
                try {
                    try {
                        PushImClient parsePartialFrom = PushImClient.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        PushImClient pushImClient2 = (PushImClient) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            pushImClient = pushImClient2;
                            if (pushImClient != null) {
                                mergeFrom(pushImClient);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (pushImClient != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            PushImClient pushImClient = new PushImClient(true);
            defaultInstance = pushImClient;
            pushImClient.initFields();
        }

        public static PushImClient getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.metadata_ = MetaData.getDefaultInstance();
            this.common_ = Common.getDefaultInstance();
            this.sdkName_ = "";
            this.sdkVersion_ = 0L;
            this.actions_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static PushImClient parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static PushImClient parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public Action getActions(int i2) {
            return this.actions_.get(i2);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public int getActionsCount() {
            return this.actions_.size();
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public List<Action> getActionsList() {
            return this.actions_;
        }

        public ActionOrBuilder getActionsOrBuilder(int i2) {
            return this.actions_.get(i2);
        }

        public List<? extends ActionOrBuilder> getActionsOrBuilderList() {
            return this.actions_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public Common getCommon() {
            return this.common_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public MetaData getMetadata() {
            return this.metadata_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<PushImClient> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public String getSdkName() {
            Object obj = this.sdkName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.sdkName_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public ByteString getSdkNameBytes() {
            Object obj = this.sdkName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sdkName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public long getSdkVersion() {
            return this.sdkVersion_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(25, this.metadata_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(41, this.common_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeMessageSize += CodedOutputStream.computeBytesSize(SDK_NAME_FIELD_NUMBER, getSdkNameBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeInt64Size(SDK_VERSION_FIELD_NUMBER, this.sdkVersion_);
            }
            for (int i3 = 0; i3 < this.actions_.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(132, this.actions_.get(i3));
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasCommon() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasMetadata() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasSdkName() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasSdkVersion() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(25, this.metadata_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(41, this.common_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(SDK_NAME_FIELD_NUMBER, getSdkNameBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(SDK_VERSION_FIELD_NUMBER, this.sdkVersion_);
            }
            for (int i2 = 0; i2 < this.actions_.size(); i2++) {
                codedOutputStream.writeMessage(132, this.actions_.get(i2));
            }
        }

        public static Builder newBuilder(PushImClient pushImClient) {
            return newBuilder().mergeFrom(pushImClient);
        }

        public static PushImClient parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static PushImClient parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public PushImClient getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public PushImClient(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public PushImClient(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PushImClient parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static PushImClient parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static PushImClient parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.List<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Action> */
        /* JADX WARN: Multi-variable type inference failed */
        public PushImClient(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite.Builder builder;
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 202) {
                                    builder = (this.bitField0_ & 1) == 1 ? this.metadata_.toBuilder() : null;
                                    MetaData metaData = (MetaData) codedInputStream.readMessage(MetaData.PARSER, extensionRegistryLite);
                                    this.metadata_ = metaData;
                                    if (builder != null) {
                                        builder.mergeFrom(metaData);
                                        this.metadata_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (readTag == 330) {
                                    builder = (this.bitField0_ & 2) == 2 ? this.common_.toBuilder() : null;
                                    Common common2 = (Common) codedInputStream.readMessage(Common.PARSER, extensionRegistryLite);
                                    this.common_ = common2;
                                    if (builder != null) {
                                        builder.mergeFrom(common2);
                                        this.common_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag == 1042) {
                                    this.bitField0_ |= 4;
                                    this.sdkName_ = codedInputStream.readBytes();
                                } else if (readTag == 1048) {
                                    this.bitField0_ |= 8;
                                    this.sdkVersion_ = codedInputStream.readInt64();
                                } else if (readTag != 1058) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    if (!(z2 & true)) {
                                        this.actions_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.actions_.add(codedInputStream.readMessage(Action.PARSER, extensionRegistryLite));
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.actions_ = Collections.unmodifiableList(this.actions_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface PushImClientOrBuilder extends MessageLiteOrBuilder {
        Action getActions(int i2);

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

    /* loaded from: classes.dex */
    public static final class Request extends GeneratedMessageLite implements RequestOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int ERROR_CODE_FIELD_NUMBER = 5;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int METHOD_FIELD_NUMBER = 1;
        public static Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Request.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REQUEST_ID_FIELD_NUMBER = 2;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final Request defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId_;
        public int bitField0_;
        public long errorCode_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object method_;
        public Object requestId_;
        public long responseTime_;
        public long timestamp_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Request, Builder> implements RequestOrBuilder {
            public long aliasId_;
            public int bitField0_;
            public long errorCode_;
            public long responseTime_;
            public long timestamp_;
            public Object method_ = "";
            public Object requestId_ = "";
            public Object ext_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0_ &= -65;
                this.aliasId_ = 0L;
                return this;
            }

            public Builder clearErrorCode() {
                this.bitField0_ &= -17;
                this.errorCode_ = 0L;
                return this;
            }

            public Builder clearExt() {
                this.bitField0_ &= -33;
                this.ext_ = Request.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearMethod() {
                this.bitField0_ &= -2;
                this.method_ = Request.getDefaultInstance().getMethod();
                return this;
            }

            public Builder clearRequestId() {
                this.bitField0_ &= -3;
                this.requestId_ = Request.getDefaultInstance().getRequestId();
                return this;
            }

            public Builder clearResponseTime() {
                this.bitField0_ &= -9;
                this.responseTime_ = 0L;
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -5;
                this.timestamp_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getAliasId() {
                return this.aliasId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getErrorCode() {
                return this.errorCode_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getExt() {
                Object obj = this.ext_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ext_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getMethod() {
                Object obj = this.method_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.method_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getMethodBytes() {
                Object obj = this.method_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.method_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.requestId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getResponseTime() {
                return this.responseTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasErrorCode() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasMethod() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasRequestId() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasResponseTime() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasTimestamp() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0_ |= 64;
                this.aliasId_ = j;
                return this;
            }

            public Builder setErrorCode(long j) {
                this.bitField0_ |= 16;
                this.errorCode_ = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0_ |= 32;
                    this.ext_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 32;
                    this.ext_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setMethod(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.method_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setMethodBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.method_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setRequestId(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.requestId_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setRequestIdBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.requestId_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setResponseTime(long j) {
                this.bitField0_ |= 8;
                this.responseTime_ = j;
                return this;
            }

            public Builder setTimestamp(long j) {
                this.bitField0_ |= 4;
                this.timestamp_ = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Request buildPartial() {
                Request request = new Request(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                request.method_ = this.method_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                request.requestId_ = this.requestId_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                request.timestamp_ = this.timestamp_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                request.responseTime_ = this.responseTime_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                request.errorCode_ = this.errorCode_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                request.ext_ = this.ext_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                request.aliasId_ = this.aliasId_;
                request.bitField0_ = i3;
                return request;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.method_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.requestId_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.timestamp_ = 0L;
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.responseTime_ = 0L;
                int i5 = i4 & (-9);
                this.bitField0_ = i5;
                this.errorCode_ = 0L;
                int i6 = i5 & (-17);
                this.bitField0_ = i6;
                this.ext_ = "";
                int i7 = i6 & (-33);
                this.bitField0_ = i7;
                this.aliasId_ = 0L;
                this.bitField0_ = i7 & (-65);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (request.hasMethod()) {
                    this.bitField0_ |= 1;
                    this.method_ = request.method_;
                }
                if (request.hasRequestId()) {
                    this.bitField0_ |= 2;
                    this.requestId_ = request.requestId_;
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
                    this.bitField0_ |= 32;
                    this.ext_ = request.ext_;
                }
                if (request.hasAliasId()) {
                    setAliasId(request.getAliasId());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Request request = null;
                try {
                    try {
                        Request parsePartialFrom = Request.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Request request2 = (Request) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            request = request2;
                            if (request != null) {
                                mergeFrom(request);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (request != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Request request = new Request(true);
            defaultInstance = request;
            request.initFields();
        }

        public static Request getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.method_ = "";
            this.requestId_ = "";
            this.timestamp_ = 0L;
            this.responseTime_ = 0L;
            this.errorCode_ = 0L;
            this.ext_ = "";
            this.aliasId_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getAliasId() {
            return this.aliasId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getErrorCode() {
            return this.errorCode_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getExt() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getMethod() {
            Object obj = this.method_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.method_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getMethodBytes() {
            Object obj = this.method_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.method_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.requestId_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getResponseTime() {
            return this.responseTime_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getMethodBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getRequestIdBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.timestamp_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.responseTime_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.errorCode_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, getExtBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.aliasId_);
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasErrorCode() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasExt() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasMethod() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasRequestId() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasResponseTime() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasTimestamp() {
            return (this.bitField0_ & 4) == 4;
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
                codedOutputStream.writeBytes(1, getMethodBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getRequestIdBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.timestamp_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.responseTime_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(5, this.errorCode_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId_);
            }
        }

        public static Builder newBuilder(Request request) {
            return newBuilder().mergeFrom(request);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Request getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Request(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Request(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.bitField0_ |= 1;
                                this.method_ = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.bitField0_ |= 2;
                                this.requestId_ = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.timestamp_ = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.bitField0_ |= 8;
                                this.responseTime_ = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.bitField0_ |= 16;
                                this.errorCode_ = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.bitField0_ |= 32;
                                this.ext_ = codedInputStream.readBytes();
                            } else if (readTag != 56) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 64;
                                this.aliasId_ = codedInputStream.readInt64();
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class TerminalInfo extends GeneratedMessageLite implements TerminalInfoOrBuilder {
        public static final int MANUFACTURER_FIELD_NUMBER = 3;
        public static final int OS_FIELD_NUMBER = 1;
        public static final int OS_VERSION_FIELD_NUMBER = 2;
        public static Parser<TerminalInfo> PARSER = new AbstractParser<TerminalInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public TerminalInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TerminalInfo(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PPI_FIELD_NUMBER = 7;
        public static final int RESOLUTION_H_FIELD_NUMBER = 5;
        public static final int RESOLUTION_V_FIELD_NUMBER = 6;
        public static final int TERMINAL_TYPE_FIELD_NUMBER = 4;
        public static final TerminalInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0_;
        public Object manufacturer_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object osVersion_;
        public OSType os_;
        public int ppi_;
        public int resolutionH_;
        public int resolutionV_;
        public Object terminalType_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TerminalInfo, Builder> implements TerminalInfoOrBuilder {
            public int bitField0_;
            public int ppi_;
            public int resolutionH_;
            public int resolutionV_;
            public OSType os_ = OSType.OS_TYPE_UNKNWON;
            public Object osVersion_ = "";
            public Object manufacturer_ = "";
            public Object terminalType_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearManufacturer() {
                this.bitField0_ &= -5;
                this.manufacturer_ = TerminalInfo.getDefaultInstance().getManufacturer();
                return this;
            }

            public Builder clearOs() {
                this.bitField0_ &= -2;
                this.os_ = OSType.OS_TYPE_UNKNWON;
                return this;
            }

            public Builder clearOsVersion() {
                this.bitField0_ &= -3;
                this.osVersion_ = TerminalInfo.getDefaultInstance().getOsVersion();
                return this;
            }

            public Builder clearPpi() {
                this.bitField0_ &= -65;
                this.ppi_ = 0;
                return this;
            }

            public Builder clearResolutionH() {
                this.bitField0_ &= -17;
                this.resolutionH_ = 0;
                return this;
            }

            public Builder clearResolutionV() {
                this.bitField0_ &= -33;
                this.resolutionV_ = 0;
                return this;
            }

            public Builder clearTerminalType() {
                this.bitField0_ &= -9;
                this.terminalType_ = TerminalInfo.getDefaultInstance().getTerminalType();
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getManufacturer() {
                Object obj = this.manufacturer_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.manufacturer_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getManufacturerBytes() {
                Object obj = this.manufacturer_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.manufacturer_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public OSType getOs() {
                return this.os_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getOsVersion() {
                Object obj = this.osVersion_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.osVersion_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getOsVersionBytes() {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.osVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getPpi() {
                return this.ppi_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getResolutionH() {
                return this.resolutionH_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getResolutionV() {
                return this.resolutionV_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getTerminalType() {
                Object obj = this.terminalType_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.terminalType_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getTerminalTypeBytes() {
                Object obj = this.terminalType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.terminalType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasManufacturer() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasOs() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasOsVersion() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasPpi() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasResolutionH() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasResolutionV() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasTerminalType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setManufacturer(String str) {
                if (str != null) {
                    this.bitField0_ |= 4;
                    this.manufacturer_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setManufacturerBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 4;
                    this.manufacturer_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setOs(OSType oSType) {
                if (oSType != null) {
                    this.bitField0_ |= 1;
                    this.os_ = oSType;
                    return this;
                }
                throw null;
            }

            public Builder setOsVersion(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.osVersion_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.osVersion_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setPpi(int i2) {
                this.bitField0_ |= 64;
                this.ppi_ = i2;
                return this;
            }

            public Builder setResolutionH(int i2) {
                this.bitField0_ |= 16;
                this.resolutionH_ = i2;
                return this;
            }

            public Builder setResolutionV(int i2) {
                this.bitField0_ |= 32;
                this.resolutionV_ = i2;
                return this;
            }

            public Builder setTerminalType(String str) {
                if (str != null) {
                    this.bitField0_ |= 8;
                    this.terminalType_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setTerminalTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 8;
                    this.terminalType_ = byteString;
                    return this;
                }
                throw null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public TerminalInfo build() {
                TerminalInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public TerminalInfo buildPartial() {
                TerminalInfo terminalInfo = new TerminalInfo(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                terminalInfo.os_ = this.os_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                terminalInfo.osVersion_ = this.osVersion_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                terminalInfo.manufacturer_ = this.manufacturer_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                terminalInfo.terminalType_ = this.terminalType_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                terminalInfo.resolutionH_ = this.resolutionH_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                terminalInfo.resolutionV_ = this.resolutionV_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                terminalInfo.ppi_ = this.ppi_;
                terminalInfo.bitField0_ = i3;
                return terminalInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.os_ = OSType.OS_TYPE_UNKNWON;
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.osVersion_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.manufacturer_ = "";
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.terminalType_ = "";
                int i5 = i4 & (-9);
                this.bitField0_ = i5;
                this.resolutionH_ = 0;
                int i6 = i5 & (-17);
                this.bitField0_ = i6;
                this.resolutionV_ = 0;
                int i7 = i6 & (-33);
                this.bitField0_ = i7;
                this.ppi_ = 0;
                this.bitField0_ = i7 & (-65);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public TerminalInfo getDefaultInstanceForType() {
                return TerminalInfo.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TerminalInfo terminalInfo) {
                if (terminalInfo == TerminalInfo.getDefaultInstance()) {
                    return this;
                }
                if (terminalInfo.hasOs()) {
                    setOs(terminalInfo.getOs());
                }
                if (terminalInfo.hasOsVersion()) {
                    this.bitField0_ |= 2;
                    this.osVersion_ = terminalInfo.osVersion_;
                }
                if (terminalInfo.hasManufacturer()) {
                    this.bitField0_ |= 4;
                    this.manufacturer_ = terminalInfo.manufacturer_;
                }
                if (terminalInfo.hasTerminalType()) {
                    this.bitField0_ |= 8;
                    this.terminalType_ = terminalInfo.terminalType_;
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
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                TerminalInfo terminalInfo = null;
                try {
                    try {
                        TerminalInfo parsePartialFrom = TerminalInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        TerminalInfo terminalInfo2 = (TerminalInfo) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            terminalInfo = terminalInfo2;
                            if (terminalInfo != null) {
                                mergeFrom(terminalInfo);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (terminalInfo != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            TerminalInfo terminalInfo = new TerminalInfo(true);
            defaultInstance = terminalInfo;
            terminalInfo.initFields();
        }

        public static TerminalInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.os_ = OSType.OS_TYPE_UNKNWON;
            this.osVersion_ = "";
            this.manufacturer_ = "";
            this.terminalType_ = "";
            this.resolutionH_ = 0;
            this.resolutionV_ = 0;
            this.ppi_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static TerminalInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static TerminalInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public String getManufacturer() {
            Object obj = this.manufacturer_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.manufacturer_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public ByteString getManufacturerBytes() {
            Object obj = this.manufacturer_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.manufacturer_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public OSType getOs() {
            return this.os_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
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

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
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
        public Parser<TerminalInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getPpi() {
            return this.ppi_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getResolutionH() {
            return this.resolutionH_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getResolutionV() {
            return this.resolutionV_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeEnumSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.os_.getNumber()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBytesSize(2, getOsVersionBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeBytesSize(3, getManufacturerBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBytesSize(4, getTerminalTypeBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeInt32Size(5, this.resolutionH_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeInt32Size(6, this.resolutionV_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeEnumSize += CodedOutputStream.computeInt32Size(7, this.ppi_);
            }
            this.memoizedSerializedSize = computeEnumSize;
            return computeEnumSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public String getTerminalType() {
            Object obj = this.terminalType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.terminalType_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public ByteString getTerminalTypeBytes() {
            Object obj = this.terminalType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.terminalType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasManufacturer() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasOs() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasOsVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasPpi() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasResolutionH() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasResolutionV() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasTerminalType() {
            return (this.bitField0_ & 8) == 8;
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
                codedOutputStream.writeEnum(1, this.os_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getOsVersionBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(3, getManufacturerBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(4, getTerminalTypeBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt32(5, this.resolutionH_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeInt32(6, this.resolutionV_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(7, this.ppi_);
            }
        }

        public static Builder newBuilder(TerminalInfo terminalInfo) {
            return newBuilder().mergeFrom(terminalInfo);
        }

        public static TerminalInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static TerminalInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public TerminalInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public TerminalInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public TerminalInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static TerminalInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static TerminalInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static TerminalInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public TerminalInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    OSType valueOf = OSType.valueOf(codedInputStream.readEnum());
                                    if (valueOf != null) {
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.os_ = valueOf;
                                    }
                                } else if (readTag == 18) {
                                    this.bitField0_ |= 2;
                                    this.osVersion_ = codedInputStream.readBytes();
                                } else if (readTag == 26) {
                                    this.bitField0_ |= 4;
                                    this.manufacturer_ = codedInputStream.readBytes();
                                } else if (readTag == 34) {
                                    this.bitField0_ |= 8;
                                    this.terminalType_ = codedInputStream.readBytes();
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 16;
                                    this.resolutionH_ = codedInputStream.readInt32();
                                } else if (readTag == 48) {
                                    this.bitField0_ |= 32;
                                    this.resolutionV_ = codedInputStream.readInt32();
                                } else if (readTag != 56) {
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 64;
                                    this.ppi_ = codedInputStream.readInt32();
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class Ui extends GeneratedMessageLite implements UiOrBuilder {
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int CATEGORY_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 5;
        public static final int END_TIME_FIELD_NUMBER = 4;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int PAGE_FIELD_NUMBER = 2;
        public static Parser<Ui> PARSER = new AbstractParser<Ui>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ui.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            public Ui parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Ui(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int START_TIME_FIELD_NUMBER = 3;
        public static final Ui defaultInstance;
        public static final long serialVersionUID = 0;
        public long aliasId_;
        public int bitField0_;
        public Object category_;
        public long duration_;
        public long endTime_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object page_;
        public long startTime_;

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Ui, Builder> implements UiOrBuilder {
            public long aliasId_;
            public int bitField0_;
            public long duration_;
            public long endTime_;
            public long startTime_;
            public Object category_ = "";
            public Object page_ = "";
            public Object ext_ = "";

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder clearAliasId() {
                this.bitField0_ &= -65;
                this.aliasId_ = 0L;
                return this;
            }

            public Builder clearCategory() {
                this.bitField0_ &= -2;
                this.category_ = Ui.getDefaultInstance().getCategory();
                return this;
            }

            public Builder clearDuration() {
                this.bitField0_ &= -17;
                this.duration_ = 0L;
                return this;
            }

            public Builder clearEndTime() {
                this.bitField0_ &= -9;
                this.endTime_ = 0L;
                return this;
            }

            public Builder clearExt() {
                this.bitField0_ &= -33;
                this.ext_ = Ui.getDefaultInstance().getExt();
                return this;
            }

            public Builder clearPage() {
                this.bitField0_ &= -3;
                this.page_ = Ui.getDefaultInstance().getPage();
                return this;
            }

            public Builder clearStartTime() {
                this.bitField0_ &= -5;
                this.startTime_ = 0L;
                return this;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getAliasId() {
                return this.aliasId_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getCategory() {
                Object obj = this.category_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.category_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getCategoryBytes() {
                Object obj = this.category_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.category_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getDuration() {
                return this.duration_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getEndTime() {
                return this.endTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getExt() {
                Object obj = this.ext_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ext_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getExtBytes() {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getPage() {
                Object obj = this.page_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.page_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getPageBytes() {
                Object obj = this.page_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.page_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getStartTime() {
                return this.startTime_;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasAliasId() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasCategory() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasDuration() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasEndTime() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasPage() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasStartTime() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAliasId(long j) {
                this.bitField0_ |= 64;
                this.aliasId_ = j;
                return this;
            }

            public Builder setCategory(String str) {
                if (str != null) {
                    this.bitField0_ |= 1;
                    this.category_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setCategoryBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 1;
                    this.category_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setDuration(long j) {
                this.bitField0_ |= 16;
                this.duration_ = j;
                return this;
            }

            public Builder setEndTime(long j) {
                this.bitField0_ |= 8;
                this.endTime_ = j;
                return this;
            }

            public Builder setExt(String str) {
                if (str != null) {
                    this.bitField0_ |= 32;
                    this.ext_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setExtBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 32;
                    this.ext_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setPage(String str) {
                if (str != null) {
                    this.bitField0_ |= 2;
                    this.page_ = str;
                    return this;
                }
                throw null;
            }

            public Builder setPageBytes(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0_ |= 2;
                    this.page_ = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setStartTime(long j) {
                this.bitField0_ |= 4;
                this.startTime_ = j;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ui build() {
                Ui buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ui buildPartial() {
                Ui ui = new Ui(this);
                int i2 = this.bitField0_;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                ui.category_ = this.category_;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                ui.page_ = this.page_;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                ui.startTime_ = this.startTime_;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                ui.endTime_ = this.endTime_;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                ui.duration_ = this.duration_;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                ui.ext_ = this.ext_;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                ui.aliasId_ = this.aliasId_;
                ui.bitField0_ = i3;
                return ui;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.category_ = "";
                int i2 = this.bitField0_ & (-2);
                this.bitField0_ = i2;
                this.page_ = "";
                int i3 = i2 & (-3);
                this.bitField0_ = i3;
                this.startTime_ = 0L;
                int i4 = i3 & (-5);
                this.bitField0_ = i4;
                this.endTime_ = 0L;
                int i5 = i4 & (-9);
                this.bitField0_ = i5;
                this.duration_ = 0L;
                int i6 = i5 & (-17);
                this.bitField0_ = i6;
                this.ext_ = "";
                int i7 = i6 & (-33);
                this.bitField0_ = i7;
                this.aliasId_ = 0L;
                this.bitField0_ = i7 & (-65);
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Ui getDefaultInstanceForType() {
                return Ui.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Ui ui) {
                if (ui == Ui.getDefaultInstance()) {
                    return this;
                }
                if (ui.hasCategory()) {
                    this.bitField0_ |= 1;
                    this.category_ = ui.category_;
                }
                if (ui.hasPage()) {
                    this.bitField0_ |= 2;
                    this.page_ = ui.page_;
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
                    this.bitField0_ |= 32;
                    this.ext_ = ui.ext_;
                }
                if (ui.hasAliasId()) {
                    setAliasId(ui.getAliasId());
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Ui ui = null;
                try {
                    try {
                        Ui parsePartialFrom = Ui.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        Ui ui2 = (Ui) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            ui = ui2;
                            if (ui != null) {
                                mergeFrom(ui);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (ui != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            Ui ui = new Ui(true);
            defaultInstance = ui;
            ui.initFields();
        }

        public static Ui getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.category_ = "";
            this.page_ = "";
            this.startTime_ = 0L;
            this.endTime_ = 0L;
            this.duration_ = 0L;
            this.ext_ = "";
            this.aliasId_ = 0L;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Ui parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Ui parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getAliasId() {
            return this.aliasId_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getCategory() {
            Object obj = this.category_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.category_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getCategoryBytes() {
            Object obj = this.category_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.category_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getDuration() {
            return this.duration_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getEndTime() {
            return this.endTime_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getExt() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.ext_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getExtBytes() {
            Object obj = this.ext_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ext_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getPage() {
            Object obj = this.page_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.page_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getPageBytes() {
            Object obj = this.page_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.page_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Ui> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getCategoryBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBytesSize += CodedOutputStream.computeBytesSize(2, getPageBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBytesSize += CodedOutputStream.computeInt64Size(3, this.startTime_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBytesSize += CodedOutputStream.computeInt64Size(4, this.endTime_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeBytesSize += CodedOutputStream.computeInt64Size(5, this.duration_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeBytesSize += CodedOutputStream.computeBytesSize(6, getExtBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                computeBytesSize += CodedOutputStream.computeInt64Size(7, this.aliasId_);
            }
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getStartTime() {
            return this.startTime_;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasAliasId() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasCategory() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasDuration() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasEndTime() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasExt() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasPage() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasStartTime() {
            return (this.bitField0_ & 4) == 4;
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
                codedOutputStream.writeBytes(1, getCategoryBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getPageBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(3, this.startTime_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.endTime_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(5, this.duration_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBytes(6, getExtBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt64(7, this.aliasId_);
            }
        }

        public static Builder newBuilder(Ui ui) {
            return newBuilder().mergeFrom(ui);
        }

        public static Ui parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Ui parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Ui getDefaultInstanceForType() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public Ui(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
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

        public Ui(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ui parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Ui parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Ui parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public Ui(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.bitField0_ |= 1;
                                this.category_ = codedInputStream.readBytes();
                            } else if (readTag == 18) {
                                this.bitField0_ |= 2;
                                this.page_ = codedInputStream.readBytes();
                            } else if (readTag == 24) {
                                this.bitField0_ |= 4;
                                this.startTime_ = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.bitField0_ |= 8;
                                this.endTime_ = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.bitField0_ |= 16;
                                this.duration_ = codedInputStream.readInt64();
                            } else if (readTag == 50) {
                                this.bitField0_ |= 32;
                                this.ext_ = codedInputStream.readBytes();
                            } else if (readTag != 56) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 64;
                                this.aliasId_ = codedInputStream.readInt64();
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

    /* loaded from: classes.dex */
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

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
