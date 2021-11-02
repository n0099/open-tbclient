package com.baidu.android.imsdk.upload.action.pb;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public final class IMPushPb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.imsdk.upload.action.pb.IMPushPb$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class Ack extends GeneratedMessageLite implements AckOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALIAS_ID_FIELD_NUMBER = 5;
        public static final int EXT_FIELD_NUMBER = 4;
        public static Parser<Ack> PARSER = null;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        public static final Ack defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public long aliasId_;
        public int bitField0_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long timestamp_;
        public Object type_;
        public Object value_;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Ack, Builder> implements AckOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long aliasId_;
            public int bitField0_;
            public Object ext_;
            public long timestamp_;
            public Object type_;
            public Object value_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.type_ = "";
                this.value_ = "";
                this.ext_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -17;
                    this.aliasId_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -9;
                    this.ext_ = Ack.getDefaultInstance().getExt();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -5;
                    this.timestamp_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -2;
                    this.type_ = Ack.getDefaultInstance().getType();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -3;
                    this.value_ = Ack.getDefaultInstance().getValue();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public long getAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.aliasId_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    Object obj = this.ext_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ext_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getExtBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    Object obj = this.ext_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ext_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public long getTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.timestamp_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                    Object obj = this.type_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.type_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getTypeBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.type_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.type_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public String getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Object obj = this.value_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.value_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public ByteString getValueBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                    Object obj = this.value_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.value_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
            public boolean hasValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setAliasId(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048615, this, j)) == null) {
                    this.bitField0_ |= 16;
                    this.aliasId_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setExt(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 8;
                        this.ext_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExtBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 8;
                        this.ext_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTimestamp(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048618, this, j)) == null) {
                    this.bitField0_ |= 4;
                    this.timestamp_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setType(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.type_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTypeBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.type_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setValue(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.value_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setValueBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.value_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ack build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Ack buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Ack) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ack buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Ack ack = new Ack(this, (AnonymousClass1) null);
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
                return (Ack) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Ack getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Ack.getDefaultInstance() : (Ack) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Ack ack) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, ack)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (ack != null) {
                            mergeFrom(ack);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-199209541, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Ack;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-199209541, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Ack;");
                    return;
                }
            }
            PARSER = new AbstractParser<Ack>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ack.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Ack parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Ack(codedInputStream, extensionRegistryLite, null) : (Ack) invokeLL.objValue;
                }
            };
            Ack ack = new Ack(true);
            defaultInstance = ack;
            ack.initFields();
        }

        public /* synthetic */ Ack(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Ack getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? defaultInstance : (Ack) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.type_ = "";
                this.value_ = "";
                this.timestamp_ = 0L;
                this.ext_ = "";
                this.aliasId_ = 0L;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Ack parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Ack) invokeL.objValue;
        }

        public static Ack parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Ack) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public long getAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.aliasId_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getExtBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Ack> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public long getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.timestamp_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getTypeBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public ByteString getValueBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                Object obj = this.value_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.value_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AckOrBuilder
        public boolean hasValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Ack(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Ack ack) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, ack)) == null) ? newBuilder().mergeFrom(ack) : (Builder) invokeL.objValue;
        }

        public static Ack parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Ack) invokeLL.objValue;
        }

        public static Ack parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Ack) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Ack getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (Ack) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ack(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ack parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Ack) invokeL.objValue;
        }

        public static Ack parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Ack) invokeLL.objValue;
        }

        public static Ack parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Ack) invokeL.objValue;
        }

        public Ack(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ack parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Ack) invokeLL.objValue;
        }

        public static Ack parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Ack) invokeL.objValue;
        }

        public static Ack parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Ack) invokeLL.objValue;
        }

        public Ack(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Action extends GeneratedMessageLite implements ActionOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ACK_FIELD_NUMBER = 7;
        public static final int ACTION_TYPE_FIELD_NUMBER = 1;
        public static final int CONNECTION_FIELD_NUMBER = 5;
        public static final int CRASH_FIELD_NUMBER = 3;
        public static final int DB_FIELD_NUMBER = 4;
        public static final int MSG_FIELD_NUMBER = 8;
        public static final int NEW_CONNECTION_FIELD_NUMBER = 9;
        public static Parser<Action> PARSER = null;
        public static final int REQUEST_FIELD_NUMBER = 6;
        public static final int UI_FIELD_NUMBER = 2;
        public static final Action defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Action, Builder> implements ActionOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Ack ack_;
            public ActionType actionType_;
            public int bitField0_;
            public Connection connection_;
            public Crash crash_;
            public Db db_;
            public Msg msg_;
            public NewConnection newConnection_;
            public Request request_;
            public Ui ui_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.actionType_ = ActionType.UI;
                this.ui_ = Ui.getDefaultInstance();
                this.crash_ = Crash.getDefaultInstance();
                this.db_ = Db.getDefaultInstance();
                this.connection_ = Connection.getDefaultInstance();
                this.request_ = Request.getDefaultInstance();
                this.ack_ = Ack.getDefaultInstance();
                this.msg_ = Msg.getDefaultInstance();
                this.newConnection_ = NewConnection.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAck() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.ack_ = Ack.getDefaultInstance();
                    this.bitField0_ &= -65;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearActionType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -2;
                    this.actionType_ = ActionType.UI;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearConnection() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.connection_ = Connection.getDefaultInstance();
                    this.bitField0_ &= -17;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearCrash() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.crash_ = Crash.getDefaultInstance();
                    this.bitField0_ &= -5;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearDb() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.db_ = Db.getDefaultInstance();
                    this.bitField0_ &= -9;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.msg_ = Msg.getDefaultInstance();
                    this.bitField0_ &= -129;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearNewConnection() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.newConnection_ = NewConnection.getDefaultInstance();
                    this.bitField0_ &= -257;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearRequest() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    this.request_ = Request.getDefaultInstance();
                    this.bitField0_ &= -33;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearUi() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    this.ui_ = Ui.getDefaultInstance();
                    this.bitField0_ &= -3;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Ack getAck() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.ack_ : (Ack) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public ActionType getActionType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.actionType_ : (ActionType) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Connection getConnection() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.connection_ : (Connection) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Crash getCrash() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.crash_ : (Crash) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Db getDb() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.db_ : (Db) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Msg getMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.msg_ : (Msg) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public NewConnection getNewConnection() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.newConnection_ : (NewConnection) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Request getRequest() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.request_ : (Request) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public Ui getUi() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.ui_ : (Ui) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasAck() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasActionType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasConnection() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasCrash() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasDb() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasNewConnection() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? (this.bitField0_ & 256) == 256 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasRequest() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
            public boolean hasUi() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder mergeAck(Ack ack) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, ack)) == null) {
                    if ((this.bitField0_ & 64) == 64 && this.ack_ != Ack.getDefaultInstance()) {
                        this.ack_ = Ack.newBuilder(this.ack_).mergeFrom(ack).buildPartial();
                    } else {
                        this.ack_ = ack;
                    }
                    this.bitField0_ |= 64;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeConnection(Connection connection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, connection)) == null) {
                    if ((this.bitField0_ & 16) == 16 && this.connection_ != Connection.getDefaultInstance()) {
                        this.connection_ = Connection.newBuilder(this.connection_).mergeFrom(connection).buildPartial();
                    } else {
                        this.connection_ = connection;
                    }
                    this.bitField0_ |= 16;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeCrash(Crash crash) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, crash)) == null) {
                    if ((this.bitField0_ & 4) == 4 && this.crash_ != Crash.getDefaultInstance()) {
                        this.crash_ = Crash.newBuilder(this.crash_).mergeFrom(crash).buildPartial();
                    } else {
                        this.crash_ = crash;
                    }
                    this.bitField0_ |= 4;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeDb(Db db) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, db)) == null) {
                    if ((this.bitField0_ & 8) == 8 && this.db_ != Db.getDefaultInstance()) {
                        this.db_ = Db.newBuilder(this.db_).mergeFrom(db).buildPartial();
                    } else {
                        this.db_ = db;
                    }
                    this.bitField0_ |= 8;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeMsg(Msg msg) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, msg)) == null) {
                    if ((this.bitField0_ & 128) == 128 && this.msg_ != Msg.getDefaultInstance()) {
                        this.msg_ = Msg.newBuilder(this.msg_).mergeFrom(msg).buildPartial();
                    } else {
                        this.msg_ = msg;
                    }
                    this.bitField0_ |= 128;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeNewConnection(NewConnection newConnection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, newConnection)) == null) {
                    if ((this.bitField0_ & 256) == 256 && this.newConnection_ != NewConnection.getDefaultInstance()) {
                        this.newConnection_ = NewConnection.newBuilder(this.newConnection_).mergeFrom(newConnection).buildPartial();
                    } else {
                        this.newConnection_ = newConnection;
                    }
                    this.bitField0_ |= 256;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeRequest(Request request) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, request)) == null) {
                    if ((this.bitField0_ & 32) == 32 && this.request_ != Request.getDefaultInstance()) {
                        this.request_ = Request.newBuilder(this.request_).mergeFrom(request).buildPartial();
                    } else {
                        this.request_ = request;
                    }
                    this.bitField0_ |= 32;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeUi(Ui ui) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, ui)) == null) {
                    if ((this.bitField0_ & 2) == 2 && this.ui_ != Ui.getDefaultInstance()) {
                        this.ui_ = Ui.newBuilder(this.ui_).mergeFrom(ui).buildPartial();
                    } else {
                        this.ui_ = ui;
                    }
                    this.bitField0_ |= 2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAck(Ack ack) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, ack)) == null) {
                    if (ack != null) {
                        this.ack_ = ack;
                        this.bitField0_ |= 64;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setActionType(ActionType actionType) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, actionType)) == null) {
                    if (actionType != null) {
                        this.bitField0_ |= 1;
                        this.actionType_ = actionType;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setConnection(Connection connection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, connection)) == null) {
                    if (connection != null) {
                        this.connection_ = connection;
                        this.bitField0_ |= 16;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setCrash(Crash crash) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, crash)) == null) {
                    if (crash != null) {
                        this.crash_ = crash;
                        this.bitField0_ |= 4;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setDb(Db db) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, db)) == null) {
                    if (db != null) {
                        this.db_ = db;
                        this.bitField0_ |= 8;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMsg(Msg msg) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, msg)) == null) {
                    if (msg != null) {
                        this.msg_ = msg;
                        this.bitField0_ |= 128;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setNewConnection(NewConnection newConnection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, newConnection)) == null) {
                    if (newConnection != null) {
                        this.newConnection_ = newConnection;
                        this.bitField0_ |= 256;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setRequest(Request request) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, request)) == null) {
                    if (request != null) {
                        this.request_ = request;
                        this.bitField0_ |= 32;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setUi(Ui ui) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, ui)) == null) {
                    if (ui != null) {
                        this.ui_ = ui;
                        this.bitField0_ |= 2;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Action build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Action buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Action) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Action buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Action action = new Action(this, (AnonymousClass1) null);
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
                return (Action) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Action getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? Action.getDefaultInstance() : (Action) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Action action) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, action)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            public Builder setAck(Ack.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, builder)) == null) {
                    this.ack_ = builder.build();
                    this.bitField0_ |= 64;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setConnection(Connection.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, builder)) == null) {
                    this.connection_ = builder.build();
                    this.bitField0_ |= 16;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setCrash(Crash.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, builder)) == null) {
                    this.crash_ = builder.build();
                    this.bitField0_ |= 4;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setDb(Db.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, builder)) == null) {
                    this.db_ = builder.build();
                    this.bitField0_ |= 8;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMsg(Msg.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, builder)) == null) {
                    this.msg_ = builder.build();
                    this.bitField0_ |= 128;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setNewConnection(NewConnection.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, builder)) == null) {
                    this.newConnection_ = builder.build();
                    this.bitField0_ |= 256;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setRequest(Request.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, builder)) == null) {
                    this.request_ = builder.build();
                    this.bitField0_ |= 32;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setUi(Ui.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, builder)) == null) {
                    this.ui_ = builder.build();
                    this.bitField0_ |= 2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (action != null) {
                            mergeFrom(action);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1003159356, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Action;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1003159356, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Action;");
                    return;
                }
            }
            PARSER = new AbstractParser<Action>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Action.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Action parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Action(codedInputStream, extensionRegistryLite, null) : (Action) invokeLL.objValue;
                }
            };
            Action action = new Action(true);
            defaultInstance = action;
            action.initFields();
        }

        public /* synthetic */ Action(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Action getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? defaultInstance : (Action) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
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
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Action parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Action) invokeL.objValue;
        }

        public static Action parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Action) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Ack getAck() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.ack_ : (Ack) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public ActionType getActionType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.actionType_ : (ActionType) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Connection getConnection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.connection_ : (Connection) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Crash getCrash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.crash_ : (Crash) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Db getDb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.db_ : (Db) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Msg getMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.msg_ : (Msg) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public NewConnection getNewConnection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.newConnection_ : (NewConnection) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Action> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Request getRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.request_ : (Request) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public Ui getUi() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.ui_ : (Ui) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasAck() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasActionType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasConnection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasCrash() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasDb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasNewConnection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 256) == 256 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionOrBuilder
        public boolean hasUi() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Action(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Action action) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, action)) == null) ? newBuilder().mergeFrom(action) : (Builder) invokeL.objValue;
        }

        public static Action parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Action) invokeLL.objValue;
        }

        public static Action parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Action) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Action getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? defaultInstance : (Action) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Action(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Action parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Action) invokeL.objValue;
        }

        public static Action parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Action) invokeLL.objValue;
        }

        public static Action parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Action) invokeL.objValue;
        }

        public Action(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Action parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Action) invokeLL.objValue;
        }

        public static Action parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Action) invokeL.objValue;
        }

        public static Action parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Action) invokeLL.objValue;
        }

        public Action(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite.Builder builder;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
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

    /* loaded from: classes6.dex */
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class ActionType implements Internal.EnumLite {
        public static final /* synthetic */ ActionType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final ActionType ACK;
        public static final int ACK_VALUE = 601;
        public static final ActionType CONNECTION;
        public static final int CONNECTION_VALUE = 401;
        public static final ActionType CRASH;
        public static final int CRASH_VALUE = 201;
        public static final ActionType DB;
        public static final int DB_VALUE = 301;
        public static final ActionType MSG;
        public static final int MSG_VALUE = 701;
        public static final ActionType NEWCONNECTION;
        public static final int NEWCONNECTION_VALUE = 801;
        public static final ActionType REQUEST;
        public static final int REQUEST_VALUE = 501;
        public static final ActionType UI;
        public static final int UI_VALUE = 101;
        public static Internal.EnumLiteMap<ActionType> internalValueMap;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1427766946, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$ActionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1427766946, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$ActionType;");
                    return;
                }
            }
            UI = new ActionType("UI", 0, 0, 101);
            CRASH = new ActionType("CRASH", 1, 1, 201);
            DB = new ActionType("DB", 2, 2, 301);
            CONNECTION = new ActionType("CONNECTION", 3, 3, 401);
            REQUEST = new ActionType("REQUEST", 4, 4, 501);
            ACK = new ActionType("ACK", 5, 5, 601);
            MSG = new ActionType("MSG", 6, 6, 701);
            ActionType actionType = new ActionType("NEWCONNECTION", 7, 7, 801);
            NEWCONNECTION = actionType;
            $VALUES = new ActionType[]{UI, CRASH, DB, CONNECTION, REQUEST, ACK, MSG, actionType};
            internalValueMap = new Internal.EnumLiteMap<ActionType>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionType.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ActionType findValueByNumber(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? ActionType.valueOf(i2) : (ActionType) invokeI.objValue;
                }
            };
        }

        public ActionType(String str, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i4;
        }

        public static Internal.EnumLiteMap<ActionType> internalGetValueMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? internalValueMap : (Internal.EnumLiteMap) invokeV.objValue;
        }

        public static ActionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (ActionType) Enum.valueOf(ActionType.class, str) : (ActionType) invokeL.objValue;
        }

        public static ActionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (ActionType[]) $VALUES.clone() : (ActionType[]) invokeV.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }

        public static ActionType valueOf(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
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
            return (ActionType) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class AppInfo extends GeneratedMessageLite implements AppInfoOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int APP_CHANNEL_FIELD_NUMBER = 3;
        public static final int APP_NAME_FIELD_NUMBER = 1;
        public static final int APP_VERSION_FIELD_NUMBER = 2;
        public static Parser<AppInfo> PARSER;
        public static final AppInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public Object appChannel_;
        public Object appName_;
        public Object appVersion_;
        public int bitField0_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AppInfo, Builder> implements AppInfoOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Object appChannel_;
            public Object appName_;
            public Object appVersion_;
            public int bitField0_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.appName_ = "";
                this.appVersion_ = "";
                this.appChannel_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAppChannel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -5;
                    this.appChannel_ = AppInfo.getDefaultInstance().getAppChannel();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearAppName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -2;
                    this.appName_ = AppInfo.getDefaultInstance().getAppName();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearAppVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -3;
                    this.appVersion_ = AppInfo.getDefaultInstance().getAppVersion();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppChannel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    Object obj = this.appChannel_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.appChannel_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppChannelBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    Object obj = this.appChannel_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.appChannel_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    Object obj = this.appName_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.appName_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppNameBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    Object obj = this.appName_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.appName_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public String getAppVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    Object obj = this.appVersion_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.appVersion_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public ByteString getAppVersionBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    Object obj = this.appVersion_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.appVersion_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppChannel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
            public boolean hasAppVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setAppChannel(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.appChannel_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAppChannelBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.appChannel_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAppName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.appName_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAppNameBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.appName_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAppVersion(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.appVersion_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.appVersion_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public AppInfo build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    AppInfo buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (AppInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public AppInfo buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    AppInfo appInfo = new AppInfo(this, (AnonymousClass1) null);
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
                return (AppInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public AppInfo getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? AppInfo.getDefaultInstance() : (AppInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(AppInfo appInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, appInfo)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (appInfo != null) {
                            mergeFrom(appInfo);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458290155, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$AppInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-458290155, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$AppInfo;");
                    return;
                }
            }
            PARSER = new AbstractParser<AppInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfo.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public AppInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new AppInfo(codedInputStream, extensionRegistryLite, null) : (AppInfo) invokeLL.objValue;
                }
            };
            AppInfo appInfo = new AppInfo(true);
            defaultInstance = appInfo;
            appInfo.initFields();
        }

        public /* synthetic */ AppInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static AppInfo getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? defaultInstance : (AppInfo) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65550, this) == null) {
                this.appName_ = "";
                this.appVersion_ = "";
                this.appChannel_ = "";
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (AppInfo) invokeL.objValue;
        }

        public static AppInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (AppInfo) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public String getAppChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppChannelBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Object obj = this.appChannel_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appChannel_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public String getAppName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppNameBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Object obj = this.appName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public String getAppVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public ByteString getAppVersionBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<AppInfo> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.AppInfoOrBuilder
        public boolean hasAppVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ AppInfo(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(AppInfo appInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, appInfo)) == null) ? newBuilder().mergeFrom(appInfo) : (Builder) invokeL.objValue;
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (AppInfo) invokeLL.objValue;
        }

        public static AppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (AppInfo) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public AppInfo getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? defaultInstance : (AppInfo) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AppInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (AppInfo) invokeL.objValue;
        }

        public static AppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (AppInfo) invokeLL.objValue;
        }

        public static AppInfo parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (AppInfo) invokeL.objValue;
        }

        public AppInfo(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (AppInfo) invokeLL.objValue;
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (AppInfo) invokeL.objValue;
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (AppInfo) invokeLL.objValue;
        }

        public AppInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Common extends GeneratedMessageLite implements CommonOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int APP_INFO_FIELD_NUMBER = 21;
        public static final int DEVICE_ID_FIELD_NUMBER = 7;
        public static final int MODULE_NAME_FIELD_NUMBER = 2;
        public static final int NET_INFO_FIELD_NUMBER = 22;
        public static Parser<Common> PARSER = null;
        public static final int PRODUCT_NAME_FIELD_NUMBER = 1;
        public static final int TERMINAL_INFO_FIELD_NUMBER = 20;
        public static final int TIMESTAMP_FIELD_NUMBER = 10;
        public static final int USER_TIMESTAMP_FIELD_NUMBER = 12;
        public static final Common defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Common, Builder> implements CommonOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public AppInfo appInfo_;
            public int bitField0_;
            public DeviceID deviceId_;
            public Object moduleName_;
            public NetInfo netInfo_;
            public Object productName_;
            public TerminalInfo terminalInfo_;
            public long timestamp_;
            public long userTimestamp_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.productName_ = "";
                this.moduleName_ = "";
                this.deviceId_ = DeviceID.getDefaultInstance();
                this.terminalInfo_ = TerminalInfo.getDefaultInstance();
                this.appInfo_ = AppInfo.getDefaultInstance();
                this.netInfo_ = NetInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAppInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.appInfo_ = AppInfo.getDefaultInstance();
                    this.bitField0_ &= -65;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearDeviceId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.deviceId_ = DeviceID.getDefaultInstance();
                    this.bitField0_ &= -5;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearModuleName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -3;
                    this.moduleName_ = Common.getDefaultInstance().getModuleName();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearNetInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.netInfo_ = NetInfo.getDefaultInstance();
                    this.bitField0_ &= -129;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearProductName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -2;
                    this.productName_ = Common.getDefaultInstance().getProductName();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTerminalInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.terminalInfo_ = TerminalInfo.getDefaultInstance();
                    this.bitField0_ &= -33;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.bitField0_ &= -9;
                    this.timestamp_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearUserTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    this.bitField0_ &= -17;
                    this.userTimestamp_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public AppInfo getAppInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.appInfo_ : (AppInfo) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public DeviceID getDeviceId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.deviceId_ : (DeviceID) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public String getModuleName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.moduleName_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.moduleName_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public ByteString getModuleNameBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Object obj = this.moduleName_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.moduleName_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public NetInfo getNetInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.netInfo_ : (NetInfo) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public String getProductName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                    Object obj = this.productName_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.productName_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public ByteString getProductNameBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                    Object obj = this.productName_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.productName_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public TerminalInfo getTerminalInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.terminalInfo_ : (TerminalInfo) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public long getTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.timestamp_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public long getUserTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.userTimestamp_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasAppInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasDeviceId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasModuleName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasNetInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasProductName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasTerminalInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
            public boolean hasUserTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
                    if (hasTimestamp()) {
                        return !hasDeviceId() || getDeviceId().isInitialized();
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            public Builder mergeAppInfo(AppInfo appInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, appInfo)) == null) {
                    if ((this.bitField0_ & 64) == 64 && this.appInfo_ != AppInfo.getDefaultInstance()) {
                        this.appInfo_ = AppInfo.newBuilder(this.appInfo_).mergeFrom(appInfo).buildPartial();
                    } else {
                        this.appInfo_ = appInfo;
                    }
                    this.bitField0_ |= 64;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeDeviceId(DeviceID deviceID) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, deviceID)) == null) {
                    if ((this.bitField0_ & 4) == 4 && this.deviceId_ != DeviceID.getDefaultInstance()) {
                        this.deviceId_ = DeviceID.newBuilder(this.deviceId_).mergeFrom(deviceID).buildPartial();
                    } else {
                        this.deviceId_ = deviceID;
                    }
                    this.bitField0_ |= 4;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeNetInfo(NetInfo netInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, netInfo)) == null) {
                    if ((this.bitField0_ & 128) == 128 && this.netInfo_ != NetInfo.getDefaultInstance()) {
                        this.netInfo_ = NetInfo.newBuilder(this.netInfo_).mergeFrom(netInfo).buildPartial();
                    } else {
                        this.netInfo_ = netInfo;
                    }
                    this.bitField0_ |= 128;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeTerminalInfo(TerminalInfo terminalInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, terminalInfo)) == null) {
                    if ((this.bitField0_ & 32) == 32 && this.terminalInfo_ != TerminalInfo.getDefaultInstance()) {
                        this.terminalInfo_ = TerminalInfo.newBuilder(this.terminalInfo_).mergeFrom(terminalInfo).buildPartial();
                    } else {
                        this.terminalInfo_ = terminalInfo;
                    }
                    this.bitField0_ |= 32;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAppInfo(AppInfo appInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, appInfo)) == null) {
                    if (appInfo != null) {
                        this.appInfo_ = appInfo;
                        this.bitField0_ |= 64;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setDeviceId(DeviceID deviceID) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, deviceID)) == null) {
                    if (deviceID != null) {
                        this.deviceId_ = deviceID;
                        this.bitField0_ |= 4;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setModuleName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.moduleName_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setModuleNameBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.moduleName_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setNetInfo(NetInfo netInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, netInfo)) == null) {
                    if (netInfo != null) {
                        this.netInfo_ = netInfo;
                        this.bitField0_ |= 128;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setProductName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.productName_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.productName_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTerminalInfo(TerminalInfo terminalInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, terminalInfo)) == null) {
                    if (terminalInfo != null) {
                        this.terminalInfo_ = terminalInfo;
                        this.bitField0_ |= 32;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTimestamp(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048639, this, j)) == null) {
                    this.bitField0_ |= 8;
                    this.timestamp_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setUserTimestamp(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048640, this, j)) == null) {
                    this.bitField0_ |= 16;
                    this.userTimestamp_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Common build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Common buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Common) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Common buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Common common2 = new Common(this, (AnonymousClass1) null);
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
                return (Common) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Common getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? Common.getDefaultInstance() : (Common) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Common common2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, common2)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            public Builder setAppInfo(AppInfo.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, builder)) == null) {
                    this.appInfo_ = builder.build();
                    this.bitField0_ |= 64;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setDeviceId(DeviceID.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, builder)) == null) {
                    this.deviceId_ = builder.build();
                    this.bitField0_ |= 4;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setNetInfo(NetInfo.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, builder)) == null) {
                    this.netInfo_ = builder.build();
                    this.bitField0_ |= 128;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTerminalInfo(TerminalInfo.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, builder)) == null) {
                    this.terminalInfo_ = builder.build();
                    this.bitField0_ |= 32;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (common2 != null) {
                            mergeFrom(common2);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1179596249, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Common;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1179596249, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Common;");
                    return;
                }
            }
            PARSER = new AbstractParser<Common>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Common.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Common(codedInputStream, extensionRegistryLite, null) : (Common) invokeLL.objValue;
                }
            };
            Common common2 = new Common(true);
            defaultInstance = common2;
            common2.initFields();
        }

        public /* synthetic */ Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Common getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? defaultInstance : (Common) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.productName_ = "";
                this.moduleName_ = "";
                this.deviceId_ = DeviceID.getDefaultInstance();
                this.timestamp_ = 0L;
                this.userTimestamp_ = 0L;
                this.terminalInfo_ = TerminalInfo.getDefaultInstance();
                this.appInfo_ = AppInfo.getDefaultInstance();
                this.netInfo_ = NetInfo.getDefaultInstance();
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Common parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Common) invokeL.objValue;
        }

        public static Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Common) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public AppInfo getAppInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appInfo_ : (AppInfo) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public DeviceID getDeviceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.deviceId_ : (DeviceID) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public String getModuleName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public ByteString getModuleNameBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Object obj = this.moduleName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.moduleName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public NetInfo getNetInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.netInfo_ : (NetInfo) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Common> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public String getProductName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public ByteString getProductNameBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object obj = this.productName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.productName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public TerminalInfo getTerminalInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.terminalInfo_ : (TerminalInfo) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public long getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.timestamp_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public long getUserTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.userTimestamp_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasAppInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasDeviceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasModuleName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasNetInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasProductName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasTerminalInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CommonOrBuilder
        public boolean hasUserTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
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
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Common(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Common common2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, common2)) == null) ? newBuilder().mergeFrom(common2) : (Builder) invokeL.objValue;
        }

        public static Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Common) invokeLL.objValue;
        }

        public static Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Common) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Common getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (Common) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Common(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Common) invokeL.objValue;
        }

        public static Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Common) invokeLL.objValue;
        }

        public static Common parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Common) invokeL.objValue;
        }

        public Common(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Common) invokeLL.objValue;
        }

        public static Common parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Common) invokeL.objValue;
        }

        public static Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Common) invokeLL.objValue;
        }

        public Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite.Builder builder;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Connection extends GeneratedMessageLite implements ConnectionOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int EXT_FIELD_NUMBER = 6;
        public static Parser<Connection> PARSER = null;
        public static final int REASON_FIELD_NUMBER = 3;
        public static final int RETRY_COUNT_FIELD_NUMBER = 5;
        public static final int RETRY_TIME_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 1;
        public static final int STOP_TIME_FIELD_NUMBER = 2;
        public static final Connection defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Connection, Builder> implements ConnectionOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long aliasId_;
            public int bitField0_;
            public Object ext_;
            public Object reason_;
            public long retryCount_;
            public long retryTime_;
            public long startTime_;
            public long stopTime_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.reason_ = "";
                this.ext_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -65;
                    this.aliasId_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -33;
                    this.ext_ = Connection.getDefaultInstance().getExt();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearReason() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -5;
                    this.reason_ = Connection.getDefaultInstance().getReason();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearRetryCount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -17;
                    this.retryCount_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearRetryTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -9;
                    this.retryTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.bitField0_ &= -2;
                    this.startTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearStopTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.bitField0_ &= -3;
                    this.stopTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.aliasId_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public String getExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    Object obj = this.ext_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ext_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public ByteString getExtBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                    Object obj = this.ext_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ext_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public String getReason() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.reason_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.reason_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public ByteString getReasonBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Object obj = this.reason_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.reason_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getRetryCount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.retryCount_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getRetryTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.retryTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.startTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public long getStopTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.stopTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasReason() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasRetryCount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasRetryTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
            public boolean hasStopTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setAliasId(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048620, this, j)) == null) {
                    this.bitField0_ |= 64;
                    this.aliasId_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setExt(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 32;
                        this.ext_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExtBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 32;
                        this.ext_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setReason(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.reason_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setReasonBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.reason_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setRetryCount(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048625, this, j)) == null) {
                    this.bitField0_ |= 16;
                    this.retryCount_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setRetryTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048626, this, j)) == null) {
                    this.bitField0_ |= 8;
                    this.retryTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setStartTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048627, this, j)) == null) {
                    this.bitField0_ |= 1;
                    this.startTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setStopTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048628, this, j)) == null) {
                    this.bitField0_ |= 2;
                    this.stopTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Connection build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Connection buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Connection) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Connection buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Connection connection = new Connection(this, (AnonymousClass1) null);
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
                return (Connection) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Connection getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? Connection.getDefaultInstance() : (Connection) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Connection connection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, connection)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (connection != null) {
                            mergeFrom(connection);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1578631188, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Connection;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1578631188, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Connection;");
                    return;
                }
            }
            PARSER = new AbstractParser<Connection>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Connection.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Connection parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Connection(codedInputStream, extensionRegistryLite, null) : (Connection) invokeLL.objValue;
                }
            };
            Connection connection = new Connection(true);
            defaultInstance = connection;
            connection.initFields();
        }

        public /* synthetic */ Connection(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Connection getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? defaultInstance : (Connection) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
                this.startTime_ = 0L;
                this.stopTime_ = 0L;
                this.reason_ = "";
                this.retryTime_ = 0L;
                this.retryCount_ = 0L;
                this.ext_ = "";
                this.aliasId_ = 0L;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Connection parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Connection) invokeL.objValue;
        }

        public static Connection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Connection) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.aliasId_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public ByteString getExtBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Connection> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public String getReason() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public ByteString getReasonBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getRetryCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.retryCount_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getRetryTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.retryTime_ : invokeV.longValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.startTime_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public long getStopTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.stopTime_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasReason() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasRetryCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasRetryTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.ConnectionOrBuilder
        public boolean hasStopTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Connection(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Connection connection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, connection)) == null) ? newBuilder().mergeFrom(connection) : (Builder) invokeL.objValue;
        }

        public static Connection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Connection) invokeLL.objValue;
        }

        public static Connection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Connection) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Connection getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (Connection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Connection(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Connection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Connection) invokeL.objValue;
        }

        public static Connection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Connection) invokeLL.objValue;
        }

        public static Connection parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Connection) invokeL.objValue;
        }

        public Connection(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Connection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Connection) invokeLL.objValue;
        }

        public static Connection parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Connection) invokeL.objValue;
        }

        public static Connection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Connection) invokeLL.objValue;
        }

        public Connection(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Crash extends GeneratedMessageLite implements CrashOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALIAS_ID_FIELD_NUMBER = 4;
        public static final int EXCEPTION_FIELD_NUMBER = 1;
        public static final int EXT_FIELD_NUMBER = 3;
        public static Parser<Crash> PARSER = null;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final Crash defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public long aliasId_;
        public int bitField0_;
        public Object exception_;
        public Object ext_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long timestamp_;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Crash, Builder> implements CrashOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long aliasId_;
            public int bitField0_;
            public Object exception_;
            public Object ext_;
            public long timestamp_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.exception_ = "";
                this.ext_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -9;
                    this.aliasId_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearException() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -2;
                    this.exception_ = Crash.getDefaultInstance().getException();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -5;
                    this.ext_ = Crash.getDefaultInstance().getExt();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -3;
                    this.timestamp_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public long getAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.aliasId_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public String getException() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    Object obj = this.exception_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.exception_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public ByteString getExceptionBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    Object obj = this.exception_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.exception_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public String getExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    Object obj = this.ext_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ext_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public ByteString getExtBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    Object obj = this.ext_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ext_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public long getTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.timestamp_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasException() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
            public boolean hasTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setAliasId(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048611, this, j)) == null) {
                    this.bitField0_ |= 8;
                    this.aliasId_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setException(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.exception_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExceptionBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.exception_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExt(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.ext_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExtBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.ext_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTimestamp(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048616, this, j)) == null) {
                    this.bitField0_ |= 2;
                    this.timestamp_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Crash build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Crash buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Crash) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Crash buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Crash crash = new Crash(this, (AnonymousClass1) null);
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
                return (Crash) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Crash getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? Crash.getDefaultInstance() : (Crash) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Crash crash) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, crash)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (crash != null) {
                            mergeFrom(crash);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1904029725, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Crash;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1904029725, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Crash;");
                    return;
                }
            }
            PARSER = new AbstractParser<Crash>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Crash.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Crash parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Crash(codedInputStream, extensionRegistryLite, null) : (Crash) invokeLL.objValue;
                }
            };
            Crash crash = new Crash(true);
            defaultInstance = crash;
            crash.initFields();
        }

        public /* synthetic */ Crash(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Crash getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? defaultInstance : (Crash) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65550, this) == null) {
                this.exception_ = "";
                this.timestamp_ = 0L;
                this.ext_ = "";
                this.aliasId_ = 0L;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Crash parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Crash) invokeL.objValue;
        }

        public static Crash parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Crash) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public long getAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.aliasId_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public String getException() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public ByteString getExceptionBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.exception_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.exception_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public ByteString getExtBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Crash> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public long getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.timestamp_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasException() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.CrashOrBuilder
        public boolean hasTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Crash(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Crash crash) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, crash)) == null) ? newBuilder().mergeFrom(crash) : (Builder) invokeL.objValue;
        }

        public static Crash parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Crash) invokeLL.objValue;
        }

        public static Crash parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Crash) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Crash getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (Crash) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Crash(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Crash parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Crash) invokeL.objValue;
        }

        public static Crash parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Crash) invokeLL.objValue;
        }

        public static Crash parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Crash) invokeL.objValue;
        }

        public Crash(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Crash parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Crash) invokeLL.objValue;
        }

        public static Crash parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Crash) invokeL.objValue;
        }

        public static Crash parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Crash) invokeLL.objValue;
        }

        public Crash(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Db extends GeneratedMessageLite implements DbOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ACTION_FIELD_NUMBER = 4;
        public static final int ALIAS_ID_FIELD_NUMBER = 9;
        public static final int CLASS_NAME_FIELD_NUMBER = 2;
        public static final int DURATION_FIELD_NUMBER = 7;
        public static final int END_TIME_FIELD_NUMBER = 6;
        public static final int EXT_FIELD_NUMBER = 8;
        public static final int METHOD_FIELD_NUMBER = 3;
        public static Parser<Db> PARSER = null;
        public static final int START_TIME_FIELD_NUMBER = 5;
        public static final int TABLE_FIELD_NUMBER = 1;
        public static final Db defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Db, Builder> implements DbOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Object action_;
            public long aliasId_;
            public int bitField0_;
            public Object className_;
            public long duration_;
            public long endTime_;
            public Object ext_;
            public Object method_;
            public long startTime_;
            public Object table_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.table_ = "";
                this.className_ = "";
                this.method_ = "";
                this.action_ = "";
                this.ext_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAction() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -9;
                    this.action_ = Db.getDefaultInstance().getAction();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -257;
                    this.aliasId_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearClassName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -3;
                    this.className_ = Db.getDefaultInstance().getClassName();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -65;
                    this.duration_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -33;
                    this.endTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.bitField0_ &= -129;
                    this.ext_ = Db.getDefaultInstance().getExt();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearMethod() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.bitField0_ &= -5;
                    this.method_ = Db.getDefaultInstance().getMethod();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    this.bitField0_ &= -17;
                    this.startTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTable() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    this.bitField0_ &= -2;
                    this.table_ = Db.getDefaultInstance().getTable();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getAction() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    Object obj = this.action_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.action_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getActionBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    Object obj = this.action_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.action_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.aliasId_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getClassName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                    Object obj = this.className_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.className_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getClassNameBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.className_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.className_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.duration_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.endTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                    Object obj = this.ext_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ext_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getExtBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                    Object obj = this.ext_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ext_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getMethod() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
                    Object obj = this.method_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.method_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getMethodBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                    Object obj = this.method_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.method_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public long getStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.startTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public String getTable() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
                    Object obj = this.table_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.table_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public ByteString getTableBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
                    Object obj = this.table_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.table_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasAction() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? (this.bitField0_ & 256) == 256 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasClassName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasMethod() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
            public boolean hasTable() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setAction(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 8;
                        this.action_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setActionBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 8;
                        this.action_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAliasId(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048631, this, j)) == null) {
                    this.bitField0_ |= 256;
                    this.aliasId_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setClassName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.className_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setClassNameBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.className_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setDuration(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048634, this, j)) == null) {
                    this.bitField0_ |= 64;
                    this.duration_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setEndTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048635, this, j)) == null) {
                    this.bitField0_ |= 32;
                    this.endTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setExt(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 128;
                        this.ext_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExtBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 128;
                        this.ext_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMethod(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.method_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMethodBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.method_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setStartTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048640, this, j)) == null) {
                    this.bitField0_ |= 16;
                    this.startTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setTable(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.table_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTableBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.table_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Db build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Db buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Db) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Db buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Db db = new Db(this, (AnonymousClass1) null);
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
                return (Db) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Db getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? Db.getDefaultInstance() : (Db) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Db db) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, db)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048625, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (db != null) {
                            mergeFrom(db);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(132124020, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Db;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(132124020, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Db;");
                    return;
                }
            }
            PARSER = new AbstractParser<Db>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Db.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Db parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Db(codedInputStream, extensionRegistryLite, null) : (Db) invokeLL.objValue;
                }
            };
            Db db = new Db(true);
            defaultInstance = db;
            db.initFields();
        }

        public /* synthetic */ Db(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Db getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? defaultInstance : (Db) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65558, this) == null) {
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
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Db parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Db) invokeL.objValue;
        }

        public static Db parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Db) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getActionBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Object obj = this.action_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.action_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.aliasId_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getClassName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getClassNameBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.className_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.className_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.duration_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getEndTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.endTime_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getExtBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getMethodBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.method_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.method_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Db> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public long getStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.startTime_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public String getTable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public ByteString getTableBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                Object obj = this.table_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.table_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 256) == 256 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasClassName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasEndTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DbOrBuilder
        public boolean hasTable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048609, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Db(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Db db) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, db)) == null) ? newBuilder().mergeFrom(db) : (Builder) invokeL.objValue;
        }

        public static Db parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Db) invokeLL.objValue;
        }

        public static Db parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Db) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Db getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? defaultInstance : (Db) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Db(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Db parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Db) invokeL.objValue;
        }

        public static Db parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Db) invokeLL.objValue;
        }

        public static Db parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Db) invokeL.objValue;
        }

        public Db(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Db parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Db) invokeLL.objValue;
        }

        public static Db parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Db) invokeL.objValue;
        }

        public static Db parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Db) invokeLL.objValue;
        }

        public Db(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class DeviceID extends GeneratedMessageLite implements DeviceIDOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CUID_FIELD_NUMBER = 4;
        public static Parser<DeviceID> PARSER;
        public static final DeviceID defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public int bitField0_;
        public Object cuid_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DeviceID, Builder> implements DeviceIDOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int bitField0_;
            public Object cuid_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.cuid_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearCuid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -2;
                    this.cuid_ = DeviceID.getDefaultInstance().getCuid();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public String getCuid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    Object obj = this.cuid_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.cuid_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public ByteString getCuidBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    Object obj = this.cuid_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.cuid_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
            public boolean hasCuid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? hasCuid() : invokeV.booleanValue;
            }

            public Builder setCuid(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.cuid_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setCuidBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.cuid_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public DeviceID build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    DeviceID buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (DeviceID) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public DeviceID buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    DeviceID deviceID = new DeviceID(this, (AnonymousClass1) null);
                    int i2 = (this.bitField0_ & 1) != 1 ? 0 : 1;
                    deviceID.cuid_ = this.cuid_;
                    deviceID.bitField0_ = i2;
                    return deviceID;
                }
                return (DeviceID) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    super.clear();
                    this.cuid_ = "";
                    this.bitField0_ &= -2;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public DeviceID getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? DeviceID.getDefaultInstance() : (DeviceID) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(DeviceID deviceID) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, deviceID)) == null) {
                    if (deviceID != DeviceID.getDefaultInstance() && deviceID.hasCuid()) {
                        this.bitField0_ |= 1;
                        this.cuid_ = deviceID.cuid_;
                    }
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (deviceID != null) {
                            mergeFrom(deviceID);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1790396705, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$DeviceID;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1790396705, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$DeviceID;");
                    return;
                }
            }
            PARSER = new AbstractParser<DeviceID>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceID.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public DeviceID parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new DeviceID(codedInputStream, extensionRegistryLite, null) : (DeviceID) invokeLL.objValue;
                }
            };
            DeviceID deviceID = new DeviceID(true);
            defaultInstance = deviceID;
            deviceID.initFields();
        }

        public /* synthetic */ DeviceID(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static DeviceID getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? defaultInstance : (DeviceID) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65546, this) == null) {
                this.cuid_ = "";
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static DeviceID parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (DeviceID) invokeL.objValue;
        }

        public static DeviceID parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (DeviceID) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
        public String getCuid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
        public ByteString getCuidBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Object obj = this.cuid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.cuid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<DeviceID> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int computeBytesSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(4, getCuidBytes()) : 0;
                this.memoizedSerializedSize = computeBytesSize;
                return computeBytesSize;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.DeviceIDOrBuilder
        public boolean hasCuid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeBytes(4, getCuidBytes());
                }
            }
        }

        public /* synthetic */ DeviceID(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(DeviceID deviceID) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, deviceID)) == null) ? newBuilder().mergeFrom(deviceID) : (Builder) invokeL.objValue;
        }

        public static DeviceID parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (DeviceID) invokeLL.objValue;
        }

        public static DeviceID parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (DeviceID) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public DeviceID getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? defaultInstance : (DeviceID) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceID(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DeviceID parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (DeviceID) invokeL.objValue;
        }

        public static DeviceID parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (DeviceID) invokeLL.objValue;
        }

        public static DeviceID parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (DeviceID) invokeL.objValue;
        }

        public DeviceID(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DeviceID parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (DeviceID) invokeLL.objValue;
        }

        public static DeviceID parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (DeviceID) invokeL.objValue;
        }

        public static DeviceID parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (DeviceID) invokeLL.objValue;
        }

        public DeviceID(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
    public interface DeviceIDOrBuilder extends MessageLiteOrBuilder {
        String getCuid();

        ByteString getCuidBytes();

        boolean hasCuid();
    }

    /* loaded from: classes6.dex */
    public static final class LcpNetInfo extends GeneratedMessageLite implements LcpNetInfoOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DOMAIN_FIELD_NUMBER = 4;
        public static final int IP_FIELD_NUMBER = 3;
        public static Parser<LcpNetInfo> PARSER = null;
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int PROTOCOL_FIELD_NUMBER = 1;
        public static final LcpNetInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public int bitField0_;
        public Object domain_;
        public Object ip_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object port_;
        public Object protocol_;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LcpNetInfo, Builder> implements LcpNetInfoOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int bitField0_;
            public Object domain_;
            public Object ip_;
            public Object port_;
            public Object protocol_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.protocol_ = "";
                this.port_ = "";
                this.ip_ = "";
                this.domain_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearDomain() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -9;
                    this.domain_ = LcpNetInfo.getDefaultInstance().getDomain();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearIp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -5;
                    this.ip_ = LcpNetInfo.getDefaultInstance().getIp();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearPort() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -3;
                    this.port_ = LcpNetInfo.getDefaultInstance().getPort();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearProtocol() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -2;
                    this.protocol_ = LcpNetInfo.getDefaultInstance().getProtocol();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public String getDomain() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    Object obj = this.domain_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.domain_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public ByteString getDomainBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    Object obj = this.domain_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.domain_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public String getIp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    Object obj = this.ip_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ip_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public ByteString getIpBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    Object obj = this.ip_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ip_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public String getPort() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    Object obj = this.port_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.port_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public ByteString getPortBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                    Object obj = this.port_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.port_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public String getProtocol() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.protocol_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.protocol_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public ByteString getProtocolBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Object obj = this.protocol_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.protocol_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public boolean hasDomain() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public boolean hasIp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public boolean hasPort() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
            public boolean hasProtocol() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setDomain(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 8;
                        this.domain_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setDomainBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 8;
                        this.domain_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setIp(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.ip_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setIpBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.ip_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setPort(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.port_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setPortBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.port_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setProtocol(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.protocol_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setProtocolBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.protocol_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LcpNetInfo build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    LcpNetInfo buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (LcpNetInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public LcpNetInfo buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    LcpNetInfo lcpNetInfo = new LcpNetInfo(this, (AnonymousClass1) null);
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
                return (LcpNetInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LcpNetInfo getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? LcpNetInfo.getDefaultInstance() : (LcpNetInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(LcpNetInfo lcpNetInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, lcpNetInfo)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (lcpNetInfo != null) {
                            mergeFrom(lcpNetInfo);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1840959904, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$LcpNetInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1840959904, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$LcpNetInfo;");
                    return;
                }
            }
            PARSER = new AbstractParser<LcpNetInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfo.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public LcpNetInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new LcpNetInfo(codedInputStream, extensionRegistryLite, null) : (LcpNetInfo) invokeLL.objValue;
                }
            };
            LcpNetInfo lcpNetInfo = new LcpNetInfo(true);
            defaultInstance = lcpNetInfo;
            lcpNetInfo.initFields();
        }

        public /* synthetic */ LcpNetInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static LcpNetInfo getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? defaultInstance : (LcpNetInfo) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65552, this) == null) {
                this.protocol_ = "";
                this.port_ = "";
                this.ip_ = "";
                this.domain_ = "";
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static LcpNetInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (LcpNetInfo) invokeL.objValue;
        }

        public static LcpNetInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (LcpNetInfo) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public String getDomain() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public ByteString getDomainBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Object obj = this.domain_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.domain_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public String getIp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public ByteString getIpBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Object obj = this.ip_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ip_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LcpNetInfo> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public String getPort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public ByteString getPortBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Object obj = this.port_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.port_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public String getProtocol() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public ByteString getProtocolBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Object obj = this.protocol_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.protocol_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public boolean hasDomain() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public boolean hasIp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public boolean hasPort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.LcpNetInfoOrBuilder
        public boolean hasProtocol() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ LcpNetInfo(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(LcpNetInfo lcpNetInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, lcpNetInfo)) == null) ? newBuilder().mergeFrom(lcpNetInfo) : (Builder) invokeL.objValue;
        }

        public static LcpNetInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (LcpNetInfo) invokeLL.objValue;
        }

        public static LcpNetInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (LcpNetInfo) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LcpNetInfo getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? defaultInstance : (LcpNetInfo) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LcpNetInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LcpNetInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (LcpNetInfo) invokeL.objValue;
        }

        public static LcpNetInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (LcpNetInfo) invokeLL.objValue;
        }

        public static LcpNetInfo parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (LcpNetInfo) invokeL.objValue;
        }

        public LcpNetInfo(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static LcpNetInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (LcpNetInfo) invokeLL.objValue;
        }

        public static LcpNetInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (LcpNetInfo) invokeL.objValue;
        }

        public static LcpNetInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (LcpNetInfo) invokeLL.objValue;
        }

        public LcpNetInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class MetaData extends GeneratedMessageLite implements MetaDataOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LOG_MODULE_ID_FIELD_NUMBER = 1;
        public static final int LOG_NAME_FIELD_NUMBER = 2;
        public static Parser<MetaData> PARSER = null;
        public static final int PRODUCT_NAME_FIELD_NUMBER = 3;
        public static final MetaData defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public int bitField0_;
        public int logModuleId_;
        public Object logName_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object productName_;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MetaData, Builder> implements MetaDataOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int bitField0_;
            public int logModuleId_;
            public Object logName_;
            public Object productName_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.logModuleId_ = 7399;
                this.logName_ = "push_im_client";
                this.productName_ = "phonebaidu";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearLogModuleId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -2;
                    this.logModuleId_ = 7399;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearLogName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -3;
                    this.logName_ = MetaData.getDefaultInstance().getLogName();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearProductName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -5;
                    this.productName_ = MetaData.getDefaultInstance().getProductName();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public int getLogModuleId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.logModuleId_ : invokeV.intValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public String getLogName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    Object obj = this.logName_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.logName_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public ByteString getLogNameBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    Object obj = this.logName_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.logName_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public String getProductName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    Object obj = this.productName_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.productName_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public ByteString getProductNameBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    Object obj = this.productName_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.productName_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasLogModuleId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasLogName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
            public boolean hasProductName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setLogModuleId(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
                    this.bitField0_ |= 1;
                    this.logModuleId_ = i2;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder setLogName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.logName_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setLogNameBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.logName_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setProductName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.productName_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.productName_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public MetaData build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    MetaData buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (MetaData) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public MetaData buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    MetaData metaData = new MetaData(this, (AnonymousClass1) null);
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
                return (MetaData) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public MetaData getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? MetaData.getDefaultInstance() : (MetaData) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(MetaData metaData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, metaData)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (metaData != null) {
                            mergeFrom(metaData);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(670429059, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$MetaData;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(670429059, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$MetaData;");
                    return;
                }
            }
            PARSER = new AbstractParser<MetaData>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaData.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public MetaData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new MetaData(codedInputStream, extensionRegistryLite, null) : (MetaData) invokeLL.objValue;
                }
            };
            MetaData metaData = new MetaData(true);
            defaultInstance = metaData;
            metaData.initFields();
        }

        public /* synthetic */ MetaData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static MetaData getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? defaultInstance : (MetaData) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65549, this) == null) {
                this.logModuleId_ = 7399;
                this.logName_ = "push_im_client";
                this.productName_ = "phonebaidu";
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static MetaData parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (MetaData) invokeL.objValue;
        }

        public static MetaData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (MetaData) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public int getLogModuleId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.logModuleId_ : invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public String getLogName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public ByteString getLogNameBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.logName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.logName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<MetaData> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public String getProductName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public ByteString getProductNameBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Object obj = this.productName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.productName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasLogModuleId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasLogName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MetaDataOrBuilder
        public boolean hasProductName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ MetaData(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(MetaData metaData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, metaData)) == null) ? newBuilder().mergeFrom(metaData) : (Builder) invokeL.objValue;
        }

        public static MetaData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (MetaData) invokeLL.objValue;
        }

        public static MetaData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (MetaData) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MetaData getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? defaultInstance : (MetaData) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MetaData(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MetaData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (MetaData) invokeL.objValue;
        }

        public static MetaData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (MetaData) invokeLL.objValue;
        }

        public static MetaData parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (MetaData) invokeL.objValue;
        }

        public MetaData(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MetaData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (MetaData) invokeLL.objValue;
        }

        public static MetaData parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (MetaData) invokeL.objValue;
        }

        public static MetaData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (MetaData) invokeLL.objValue;
        }

        public MetaData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Msg extends GeneratedMessageLite implements MsgOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALIAS_ID_FIELD_NUMBER = 6;
        public static final int DURATION_FIELD_NUMBER = 3;
        public static final int END_MSGID_FIELD_NUMBER = 4;
        public static final int EXT_FIELD_NUMBER = 5;
        public static final int MSG_COUNT_FIELD_NUMBER = 1;
        public static Parser<Msg> PARSER = null;
        public static final int ROOM_ID_FIELD_NUMBER = 2;
        public static final int START_MSGID_FIELD_NUMBER = 7;
        public static final Msg defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Msg, Builder> implements MsgOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long aliasId_;
            public int bitField0_;
            public long duration_;
            public long endMsgid_;
            public Object ext_;
            public long msgCount_;
            public Object roomId_;
            public long startMsgid_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.roomId_ = "";
                this.ext_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -33;
                    this.aliasId_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -5;
                    this.duration_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearEndMsgid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -9;
                    this.endMsgid_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -17;
                    this.ext_ = Msg.getDefaultInstance().getExt();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearMsgCount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -2;
                    this.msgCount_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearRoomId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.bitField0_ &= -3;
                    this.roomId_ = Msg.getDefaultInstance().getRoomId();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearStartMsgid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.bitField0_ &= -65;
                    this.startMsgid_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.aliasId_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.duration_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getEndMsgid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.endMsgid_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public String getExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.ext_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ext_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public ByteString getExtBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Object obj = this.ext_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ext_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getMsgCount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.msgCount_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public String getRoomId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                    Object obj = this.roomId_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.roomId_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public ByteString getRoomIdBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                    Object obj = this.roomId_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.roomId_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public long getStartMsgid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.startMsgid_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasEndMsgid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasMsgCount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasRoomId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
            public boolean hasStartMsgid() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setAliasId(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048620, this, j)) == null) {
                    this.bitField0_ |= 32;
                    this.aliasId_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setDuration(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048621, this, j)) == null) {
                    this.bitField0_ |= 4;
                    this.duration_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setEndMsgid(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048622, this, j)) == null) {
                    this.bitField0_ |= 8;
                    this.endMsgid_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setExt(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 16;
                        this.ext_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExtBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 16;
                        this.ext_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMsgCount(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048625, this, j)) == null) {
                    this.bitField0_ |= 1;
                    this.msgCount_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setRoomId(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.roomId_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setRoomIdBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.roomId_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setStartMsgid(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048628, this, j)) == null) {
                    this.bitField0_ |= 64;
                    this.startMsgid_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Msg build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Msg buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Msg) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Msg buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Msg msg = new Msg(this, (AnonymousClass1) null);
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
                return (Msg) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Msg getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? Msg.getDefaultInstance() : (Msg) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Msg msg) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, msg)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (msg != null) {
                            mergeFrom(msg);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-198836797, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Msg;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-198836797, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Msg;");
                    return;
                }
            }
            PARSER = new AbstractParser<Msg>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Msg.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Msg parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Msg(codedInputStream, extensionRegistryLite, null) : (Msg) invokeLL.objValue;
                }
            };
            Msg msg = new Msg(true);
            defaultInstance = msg;
            msg.initFields();
        }

        public /* synthetic */ Msg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Msg getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? defaultInstance : (Msg) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65553, this) == null) {
                this.msgCount_ = 0L;
                this.roomId_ = "";
                this.duration_ = 0L;
                this.endMsgid_ = 0L;
                this.ext_ = "";
                this.aliasId_ = 0L;
                this.startMsgid_ = 0L;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Msg parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Msg) invokeL.objValue;
        }

        public static Msg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Msg) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.aliasId_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.duration_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getEndMsgid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.endMsgid_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public ByteString getExtBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getMsgCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.msgCount_ : invokeV.longValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Msg> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public String getRoomId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public ByteString getRoomIdBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public long getStartMsgid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.startMsgid_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasEndMsgid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasMsgCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasRoomId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.MsgOrBuilder
        public boolean hasStartMsgid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Msg(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Msg msg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, msg)) == null) ? newBuilder().mergeFrom(msg) : (Builder) invokeL.objValue;
        }

        public static Msg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Msg) invokeLL.objValue;
        }

        public static Msg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Msg) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Msg getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (Msg) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Msg(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Msg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Msg) invokeL.objValue;
        }

        public static Msg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Msg) invokeLL.objValue;
        }

        public static Msg parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Msg) invokeL.objValue;
        }

        public Msg(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Msg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Msg) invokeLL.objValue;
        }

        public static Msg parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Msg) invokeL.objValue;
        }

        public static Msg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Msg) invokeLL.objValue;
        }

        public Msg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class NetInfo extends GeneratedMessageLite implements NetInfoOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int NET_APN_FIELD_NUMBER = 2;
        public static final int NET_TYPE_FIELD_NUMBER = 1;
        public static Parser<NetInfo> PARSER;
        public static final NetInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public int bitField0_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object netApn_;
        public Object netType_;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<NetInfo, Builder> implements NetInfoOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int bitField0_;
            public Object netApn_;
            public Object netType_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.netType_ = "";
                this.netApn_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearNetApn() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -3;
                    this.netApn_ = NetInfo.getDefaultInstance().getNetApn();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearNetType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -2;
                    this.netType_ = NetInfo.getDefaultInstance().getNetType();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public String getNetApn() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    Object obj = this.netApn_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.netApn_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public ByteString getNetApnBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    Object obj = this.netApn_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.netApn_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public String getNetType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    Object obj = this.netType_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.netType_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public ByteString getNetTypeBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    Object obj = this.netType_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.netType_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public boolean hasNetApn() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
            public boolean hasNetType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setNetApn(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.netApn_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setNetApnBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.netApn_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setNetType(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.netType_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setNetTypeBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.netType_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NetInfo build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    NetInfo buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (NetInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NetInfo buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    NetInfo netInfo = new NetInfo(this, (AnonymousClass1) null);
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
                return (NetInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    super.clear();
                    this.netType_ = "";
                    int i2 = this.bitField0_ & (-2);
                    this.bitField0_ = i2;
                    this.netApn_ = "";
                    this.bitField0_ = i2 & (-3);
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public NetInfo getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? NetInfo.getDefaultInstance() : (NetInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(NetInfo netInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, netInfo)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (netInfo != null) {
                            mergeFrom(netInfo);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-334681575, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$NetInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-334681575, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$NetInfo;");
                    return;
                }
            }
            PARSER = new AbstractParser<NetInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfo.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public NetInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new NetInfo(codedInputStream, extensionRegistryLite, null) : (NetInfo) invokeLL.objValue;
                }
            };
            NetInfo netInfo = new NetInfo(true);
            defaultInstance = netInfo;
            netInfo.initFields();
        }

        public /* synthetic */ NetInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static NetInfo getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? defaultInstance : (NetInfo) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                this.netType_ = "";
                this.netApn_ = "";
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static NetInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (NetInfo) invokeL.objValue;
        }

        public static NetInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (NetInfo) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public String getNetApn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public ByteString getNetApnBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Object obj = this.netApn_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.netApn_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public String getNetType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public ByteString getNetTypeBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Object obj = this.netType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.netType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<NetInfo> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public boolean hasNetApn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NetInfoOrBuilder
        public boolean hasNetType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, codedOutputStream) == null) {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeBytes(1, getNetTypeBytes());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeBytes(2, getNetApnBytes());
                }
            }
        }

        public /* synthetic */ NetInfo(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(NetInfo netInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, netInfo)) == null) ? newBuilder().mergeFrom(netInfo) : (Builder) invokeL.objValue;
        }

        public static NetInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (NetInfo) invokeLL.objValue;
        }

        public static NetInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (NetInfo) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public NetInfo getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? defaultInstance : (NetInfo) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static NetInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (NetInfo) invokeL.objValue;
        }

        public static NetInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (NetInfo) invokeLL.objValue;
        }

        public static NetInfo parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (NetInfo) invokeL.objValue;
        }

        public NetInfo(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static NetInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (NetInfo) invokeLL.objValue;
        }

        public static NetInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (NetInfo) invokeL.objValue;
        }

        public static NetInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (NetInfo) invokeLL.objValue;
        }

        public NetInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
    public interface NetInfoOrBuilder extends MessageLiteOrBuilder {
        String getNetApn();

        ByteString getNetApnBytes();

        String getNetType();

        ByteString getNetTypeBytes();

        boolean hasNetApn();

        boolean hasNetType();
    }

    /* loaded from: classes6.dex */
    public static final class NewConnection extends GeneratedMessageLite implements NewConnectionOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
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
        public static Parser<NewConnection> PARSER = null;
        public static final int RETRY_FIELD_NUMBER = 17;
        public static final int SOCKET_BEGIN_FIELD_NUMBER = 9;
        public static final int SOCKET_END_FIELD_NUMBER = 10;
        public static final int START_TIME_FIELD_NUMBER = 1;
        public static final int TOKEN_BEGIN_FIELD_NUMBER = 5;
        public static final int TOKEN_END_FIELD_NUMBER = 6;
        public static final NewConnection defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<NewConnection, Builder> implements NewConnectionOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
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
            public LcpNetInfo netInfo_;
            public long retry_;
            public long socketBegin_;
            public long socketEnd_;
            public long startTime_;
            public long tokenBegin_;
            public long tokenEnd_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.connectErrorCode_ = "";
                this.connectSource_ = "";
                this.ext_ = "";
                this.netInfo_ = LcpNetInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -32769;
                    this.aliasId_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearConnectErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -9;
                    this.connectErrorCode_ = NewConnection.getDefaultInstance().getConnectErrorCode();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearConnectSource() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -4097;
                    this.connectSource_ = NewConnection.getDefaultInstance().getConnectSource();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearConnectState() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -5;
                    this.connectState_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearDnsBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -65;
                    this.dnsBegin_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearDnsEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.bitField0_ &= -129;
                    this.dnsEnd_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.bitField0_ &= -3;
                    this.endTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    this.bitField0_ &= -8193;
                    this.ext_ = NewConnection.getDefaultInstance().getExt();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearLcpLoginBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    this.bitField0_ &= -1025;
                    this.lcpLoginBegin_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearLcpLoginEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    this.bitField0_ &= -2049;
                    this.lcpLoginEnd_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearNetInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    this.netInfo_ = LcpNetInfo.getDefaultInstance();
                    this.bitField0_ &= -16385;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearRetry() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    this.bitField0_ &= -65537;
                    this.retry_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearSocketBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    this.bitField0_ &= -257;
                    this.socketBegin_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearSocketEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    this.bitField0_ &= -513;
                    this.socketEnd_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    this.bitField0_ &= -2;
                    this.startTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTokenBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    this.bitField0_ &= -17;
                    this.tokenBegin_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTokenEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    this.bitField0_ &= -33;
                    this.tokenEnd_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.aliasId_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public String getConnectErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    Object obj = this.connectErrorCode_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.connectErrorCode_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public ByteString getConnectErrorCodeBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                    Object obj = this.connectErrorCode_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.connectErrorCode_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public String getConnectSource() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                    Object obj = this.connectSource_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.connectSource_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public ByteString getConnectSourceBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
                    Object obj = this.connectSource_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.connectSource_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getConnectState() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.connectState_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getDnsBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.dnsBegin_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getDnsEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.dnsEnd_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.endTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public String getExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
                    Object obj = this.ext_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ext_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public ByteString getExtBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
                    Object obj = this.ext_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ext_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getLcpLoginBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.lcpLoginBegin_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getLcpLoginEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.lcpLoginEnd_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public LcpNetInfo getNetInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.netInfo_ : (LcpNetInfo) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getRetry() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.retry_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getSocketBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.socketBegin_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getSocketEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.socketEnd_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.startTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getTokenBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.tokenBegin_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public long getTokenEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.tokenEnd_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? (this.bitField0_ & 32768) == 32768 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasConnectErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasConnectSource() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? (this.bitField0_ & 4096) == 4096 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasConnectState() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasDnsBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasDnsEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? (this.bitField0_ & 8192) == 8192 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasLcpLoginBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? (this.bitField0_ & 1024) == 1024 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasLcpLoginEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? (this.bitField0_ & 2048) == 2048 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasNetInfo() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? (this.bitField0_ & 16384) == 16384 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasRetry() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? (this.bitField0_ & 65536) == 65536 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasSocketBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? (this.bitField0_ & 256) == 256 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasSocketEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? (this.bitField0_ & 512) == 512 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasTokenBegin() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
            public boolean hasTokenEnd() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder mergeNetInfo(LcpNetInfo lcpNetInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, lcpNetInfo)) == null) {
                    if ((this.bitField0_ & 16384) == 16384 && this.netInfo_ != LcpNetInfo.getDefaultInstance()) {
                        this.netInfo_ = LcpNetInfo.newBuilder(this.netInfo_).mergeFrom(lcpNetInfo).buildPartial();
                    } else {
                        this.netInfo_ = lcpNetInfo;
                    }
                    this.bitField0_ |= 16384;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setAliasId(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048652, this, j)) == null) {
                    this.bitField0_ |= 32768;
                    this.aliasId_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setConnectErrorCode(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 8;
                        this.connectErrorCode_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setConnectErrorCodeBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 8;
                        this.connectErrorCode_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setConnectSource(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4096;
                        this.connectSource_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setConnectSourceBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4096;
                        this.connectSource_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setConnectState(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048657, this, j)) == null) {
                    this.bitField0_ |= 4;
                    this.connectState_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setDnsBegin(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048658, this, j)) == null) {
                    this.bitField0_ |= 64;
                    this.dnsBegin_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setDnsEnd(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048659, this, j)) == null) {
                    this.bitField0_ |= 128;
                    this.dnsEnd_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setEndTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048660, this, j)) == null) {
                    this.bitField0_ |= 2;
                    this.endTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setExt(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 8192;
                        this.ext_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExtBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 8192;
                        this.ext_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setLcpLoginBegin(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048663, this, j)) == null) {
                    this.bitField0_ |= 1024;
                    this.lcpLoginBegin_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setLcpLoginEnd(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048664, this, j)) == null) {
                    this.bitField0_ |= 2048;
                    this.lcpLoginEnd_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setNetInfo(LcpNetInfo lcpNetInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, lcpNetInfo)) == null) {
                    if (lcpNetInfo != null) {
                        this.netInfo_ = lcpNetInfo;
                        this.bitField0_ |= 16384;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setRetry(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048667, this, j)) == null) {
                    this.bitField0_ |= 65536;
                    this.retry_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setSocketBegin(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048668, this, j)) == null) {
                    this.bitField0_ |= 256;
                    this.socketBegin_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setSocketEnd(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048669, this, j)) == null) {
                    this.bitField0_ |= 512;
                    this.socketEnd_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setStartTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048670, this, j)) == null) {
                    this.bitField0_ |= 1;
                    this.startTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setTokenBegin(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048671, this, j)) == null) {
                    this.bitField0_ |= 16;
                    this.tokenBegin_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setTokenEnd(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048672, this, j)) == null) {
                    this.bitField0_ |= 32;
                    this.tokenEnd_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NewConnection build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    NewConnection buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (NewConnection) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public NewConnection buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    NewConnection newConnection = new NewConnection(this, (AnonymousClass1) null);
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
                return (NewConnection) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public NewConnection getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? NewConnection.getDefaultInstance() : (NewConnection) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(NewConnection newConnection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, newConnection)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            public Builder setNetInfo(LcpNetInfo.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, builder)) == null) {
                    this.netInfo_ = builder.build();
                    this.bitField0_ |= 16384;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048647, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (newConnection != null) {
                            mergeFrom(newConnection);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(68123910, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$NewConnection;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(68123910, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$NewConnection;");
                    return;
                }
            }
            PARSER = new AbstractParser<NewConnection>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnection.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public NewConnection parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new NewConnection(codedInputStream, extensionRegistryLite, null) : (NewConnection) invokeLL.objValue;
                }
            };
            NewConnection newConnection = new NewConnection(true);
            defaultInstance = newConnection;
            newConnection.initFields();
        }

        public /* synthetic */ NewConnection(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static NewConnection getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? defaultInstance : (NewConnection) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65564, this) == null) {
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
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static NewConnection parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (NewConnection) invokeL.objValue;
        }

        public static NewConnection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (NewConnection) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.aliasId_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public String getConnectErrorCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public ByteString getConnectErrorCodeBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.connectErrorCode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.connectErrorCode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public String getConnectSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public ByteString getConnectSourceBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Object obj = this.connectSource_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.connectSource_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getConnectState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.connectState_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getDnsBegin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.dnsBegin_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getDnsEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.dnsEnd_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getEndTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.endTime_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public ByteString getExtBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getLcpLoginBegin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.lcpLoginBegin_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getLcpLoginEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.lcpLoginEnd_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public LcpNetInfo getNetInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.netInfo_ : (LcpNetInfo) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<NewConnection> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getRetry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.retry_ : invokeV.longValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getSocketBegin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.socketBegin_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getSocketEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.socketEnd_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.startTime_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getTokenBegin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.tokenBegin_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public long getTokenEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.tokenEnd_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (this.bitField0_ & 32768) == 32768 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasConnectErrorCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasConnectSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.bitField0_ & 4096) == 4096 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasConnectState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasDnsBegin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasDnsEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasEndTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.bitField0_ & 8192) == 8192 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasLcpLoginBegin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 1024) == 1024 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasLcpLoginEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 2048) == 2048 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasNetInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 16384) == 16384 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasRetry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 65536) == 65536 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasSocketBegin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 256) == 256 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasSocketEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.bitField0_ & 512) == 512 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasTokenBegin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.NewConnectionOrBuilder
        public boolean hasTokenEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048623, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ NewConnection(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(NewConnection newConnection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, newConnection)) == null) ? newBuilder().mergeFrom(newConnection) : (Builder) invokeL.objValue;
        }

        public static NewConnection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (NewConnection) invokeLL.objValue;
        }

        public static NewConnection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (NewConnection) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public NewConnection getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? defaultInstance : (NewConnection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewConnection(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static NewConnection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (NewConnection) invokeL.objValue;
        }

        public static NewConnection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (NewConnection) invokeLL.objValue;
        }

        public static NewConnection parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (NewConnection) invokeL.objValue;
        }

        public NewConnection(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static NewConnection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (NewConnection) invokeLL.objValue;
        }

        public static NewConnection parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (NewConnection) invokeL.objValue;
        }

        public static NewConnection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (NewConnection) invokeLL.objValue;
        }

        public NewConnection(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class OSType implements Internal.EnumLite {
        public static final /* synthetic */ OSType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final OSType ANDROID;
        public static final int ANDROID_VALUE = 2;
        public static final OSType IOS;
        public static final int IOS_VALUE = 1;
        public static final OSType OS_TYPE_UNKNWON;
        public static final int OS_TYPE_UNKNWON_VALUE = 0;
        public static final OSType WINDOWSPHONE;
        public static final int WINDOWSPHONE_VALUE = 3;
        public static Internal.EnumLiteMap<OSType> internalValueMap;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(56167252, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$OSType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(56167252, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$OSType;");
                    return;
                }
            }
            OS_TYPE_UNKNWON = new OSType("OS_TYPE_UNKNWON", 0, 0, 0);
            IOS = new OSType("IOS", 1, 1, 1);
            ANDROID = new OSType("ANDROID", 2, 2, 2);
            OSType oSType = new OSType("WINDOWSPHONE", 3, 3, 3);
            WINDOWSPHONE = oSType;
            $VALUES = new OSType[]{OS_TYPE_UNKNWON, IOS, ANDROID, oSType};
            internalValueMap = new Internal.EnumLiteMap<OSType>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.OSType.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public OSType findValueByNumber(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? OSType.valueOf(i2) : (OSType) invokeI.objValue;
                }
            };
        }

        public OSType(String str, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i4;
        }

        public static Internal.EnumLiteMap<OSType> internalGetValueMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? internalValueMap : (Internal.EnumLiteMap) invokeV.objValue;
        }

        public static OSType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (OSType) Enum.valueOf(OSType.class, str) : (OSType) invokeL.objValue;
        }

        public static OSType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (OSType[]) $VALUES.clone() : (OSType[]) invokeV.objValue;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }

        public static OSType valueOf(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
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
            return (OSType) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class PushImClient extends GeneratedMessageLite implements PushImClientOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ACTIONS_FIELD_NUMBER = 132;
        public static final int COMMON_FIELD_NUMBER = 41;
        public static final int METADATA_FIELD_NUMBER = 25;
        public static Parser<PushImClient> PARSER = null;
        public static final int SDK_NAME_FIELD_NUMBER = 130;
        public static final int SDK_VERSION_FIELD_NUMBER = 131;
        public static final PushImClient defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public List<Action> actions_;
        public int bitField0_;
        public Common common_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public MetaData metadata_;
        public Object sdkName_;
        public long sdkVersion_;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<PushImClient, Builder> implements PushImClientOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public List<Action> actions_;
            public int bitField0_;
            public Common common_;
            public MetaData metadata_;
            public Object sdkName_;
            public long sdkVersion_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.metadata_ = MetaData.getDefaultInstance();
                this.common_ = Common.getDefaultInstance();
                this.sdkName_ = "";
                this.actions_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void ensureActionsIsMutable() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (this.bitField0_ & 16) == 16) {
                    return;
                }
                this.actions_ = new ArrayList(this.actions_);
                this.bitField0_ |= 16;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                }
            }

            public Builder addActions(Action action) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, action)) == null) {
                    if (action != null) {
                        ensureActionsIsMutable();
                        this.actions_.add(action);
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder addAllActions(Iterable<? extends Action> iterable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iterable)) == null) {
                    ensureActionsIsMutable();
                    AbstractMessageLite.Builder.addAll(iterable, this.actions_);
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder clearActions() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.actions_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearCommon() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.common_ = Common.getDefaultInstance();
                    this.bitField0_ &= -3;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearMetadata() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    this.metadata_ = MetaData.getDefaultInstance();
                    this.bitField0_ &= -2;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearSdkName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    this.bitField0_ &= -5;
                    this.sdkName_ = PushImClient.getDefaultInstance().getSdkName();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearSdkVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    this.bitField0_ &= -9;
                    this.sdkVersion_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public Action getActions(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? this.actions_.get(i2) : (Action) invokeI.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public int getActionsCount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.actions_.size() : invokeV.intValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public List<Action> getActionsList() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? Collections.unmodifiableList(this.actions_) : (List) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public Common getCommon() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.common_ : (Common) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public MetaData getMetadata() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.metadata_ : (MetaData) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public String getSdkName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    Object obj = this.sdkName_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.sdkName_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public ByteString getSdkNameBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                    Object obj = this.sdkName_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.sdkName_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public long getSdkVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.sdkVersion_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasCommon() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasMetadata() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasSdkName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
            public boolean hasSdkVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? hasCommon() && getCommon().isInitialized() : invokeV.booleanValue;
            }

            public Builder mergeCommon(Common common2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, common2)) == null) {
                    if ((this.bitField0_ & 2) == 2 && this.common_ != Common.getDefaultInstance()) {
                        this.common_ = Common.newBuilder(this.common_).mergeFrom(common2).buildPartial();
                    } else {
                        this.common_ = common2;
                    }
                    this.bitField0_ |= 2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder mergeMetadata(MetaData metaData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, metaData)) == null) {
                    if ((this.bitField0_ & 1) == 1 && this.metadata_ != MetaData.getDefaultInstance()) {
                        this.metadata_ = MetaData.newBuilder(this.metadata_).mergeFrom(metaData).buildPartial();
                    } else {
                        this.metadata_ = metaData;
                    }
                    this.bitField0_ |= 1;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder removeActions(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
                    ensureActionsIsMutable();
                    this.actions_.remove(i2);
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder setActions(int i2, Action action) {
                InterceptResult invokeIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIL = interceptable.invokeIL(1048623, this, i2, action)) == null) {
                    if (action != null) {
                        ensureActionsIsMutable();
                        this.actions_.set(i2, action);
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeIL.objValue;
            }

            public Builder setCommon(Common common2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, common2)) == null) {
                    if (common2 != null) {
                        this.common_ = common2;
                        this.bitField0_ |= 2;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMetadata(MetaData metaData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, metaData)) == null) {
                    if (metaData != null) {
                        this.metadata_ = metaData;
                        this.bitField0_ |= 1;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setSdkName(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.sdkName_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setSdkNameBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.sdkName_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setSdkVersion(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048630, this, j)) == null) {
                    this.bitField0_ |= 8;
                    this.sdkVersion_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public PushImClient build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    PushImClient buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (PushImClient) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public PushImClient buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    PushImClient pushImClient = new PushImClient(this, (AnonymousClass1) null);
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
                return (PushImClient) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public PushImClient getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? PushImClient.getDefaultInstance() : (PushImClient) invokeV.objValue;
            }

            public Builder addActions(int i2, Action action) {
                InterceptResult invokeIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, action)) == null) {
                    if (action != null) {
                        ensureActionsIsMutable();
                        this.actions_.add(i2, action);
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeIL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(PushImClient pushImClient) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, pushImClient)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            public Builder setActions(int i2, Action.Builder builder) {
                InterceptResult invokeIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIL = interceptable.invokeIL(1048622, this, i2, builder)) == null) {
                    ensureActionsIsMutable();
                    this.actions_.set(i2, builder.build());
                    return this;
                }
                return (Builder) invokeIL.objValue;
            }

            public Builder setCommon(Common.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, builder)) == null) {
                    this.common_ = builder.build();
                    this.bitField0_ |= 2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMetadata(MetaData.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, builder)) == null) {
                    this.metadata_ = builder.build();
                    this.bitField0_ |= 1;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            public Builder addActions(Action.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder)) == null) {
                    ensureActionsIsMutable();
                    this.actions_.add(builder.build());
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder addActions(int i2, Action.Builder builder) {
                InterceptResult invokeIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, builder)) == null) {
                    ensureActionsIsMutable();
                    this.actions_.add(i2, builder.build());
                    return this;
                }
                return (Builder) invokeIL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (pushImClient != null) {
                            mergeFrom(pushImClient);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1840074569, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$PushImClient;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1840074569, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$PushImClient;");
                    return;
                }
            }
            PARSER = new AbstractParser<PushImClient>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClient.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public PushImClient parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new PushImClient(codedInputStream, extensionRegistryLite, null) : (PushImClient) invokeLL.objValue;
                }
            };
            PushImClient pushImClient = new PushImClient(true);
            defaultInstance = pushImClient;
            pushImClient.initFields();
        }

        public /* synthetic */ PushImClient(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static PushImClient getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? defaultInstance : (PushImClient) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                this.metadata_ = MetaData.getDefaultInstance();
                this.common_ = Common.getDefaultInstance();
                this.sdkName_ = "";
                this.sdkVersion_ = 0L;
                this.actions_ = Collections.emptyList();
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static PushImClient parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (PushImClient) invokeL.objValue;
        }

        public static PushImClient parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (PushImClient) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public Action getActions(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.actions_.get(i2) : (Action) invokeI.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public int getActionsCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.actions_.size() : invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public List<Action> getActionsList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.actions_ : (List) invokeV.objValue;
        }

        public ActionOrBuilder getActionsOrBuilder(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.actions_.get(i2) : (ActionOrBuilder) invokeI.objValue;
        }

        public List<? extends ActionOrBuilder> getActionsOrBuilderList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.actions_ : (List) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public Common getCommon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.common_ : (Common) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public MetaData getMetadata() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.metadata_ : (MetaData) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<PushImClient> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public String getSdkName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public ByteString getSdkNameBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                Object obj = this.sdkName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sdkName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public long getSdkVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.sdkVersion_ : invokeV.longValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasCommon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasMetadata() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasSdkName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClientOrBuilder
        public boolean hasSdkVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ PushImClient(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(PushImClient pushImClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, pushImClient)) == null) ? newBuilder().mergeFrom(pushImClient) : (Builder) invokeL.objValue;
        }

        public static PushImClient parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (PushImClient) invokeLL.objValue;
        }

        public static PushImClient parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (PushImClient) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public PushImClient getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? defaultInstance : (PushImClient) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PushImClient(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PushImClient parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (PushImClient) invokeL.objValue;
        }

        public static PushImClient parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (PushImClient) invokeLL.objValue;
        }

        public static PushImClient parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (PushImClient) invokeL.objValue;
        }

        public PushImClient(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static PushImClient parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (PushImClient) invokeLL.objValue;
        }

        public static PushImClient parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (PushImClient) invokeL.objValue;
        }

        public static PushImClient parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (PushImClient) invokeLL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.util.List<com.baidu.android.imsdk.upload.action.pb.IMPushPb$Action> */
        /* JADX WARN: Multi-variable type inference failed */
        public PushImClient(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite.Builder builder;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Request extends GeneratedMessageLite implements RequestOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int ERROR_CODE_FIELD_NUMBER = 5;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int METHOD_FIELD_NUMBER = 1;
        public static Parser<Request> PARSER = null;
        public static final int REQUEST_ID_FIELD_NUMBER = 2;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final Request defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Request, Builder> implements RequestOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long aliasId_;
            public int bitField0_;
            public long errorCode_;
            public Object ext_;
            public Object method_;
            public Object requestId_;
            public long responseTime_;
            public long timestamp_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.method_ = "";
                this.requestId_ = "";
                this.ext_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -65;
                    this.aliasId_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -17;
                    this.errorCode_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -33;
                    this.ext_ = Request.getDefaultInstance().getExt();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearMethod() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -2;
                    this.method_ = Request.getDefaultInstance().getMethod();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearRequestId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -3;
                    this.requestId_ = Request.getDefaultInstance().getRequestId();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearResponseTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.bitField0_ &= -9;
                    this.responseTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.bitField0_ &= -5;
                    this.timestamp_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.aliasId_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.errorCode_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                    Object obj = this.ext_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ext_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getExtBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.ext_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ext_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getMethod() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Object obj = this.method_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.method_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getMethodBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                    Object obj = this.method_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.method_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public String getRequestId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                    Object obj = this.requestId_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.requestId_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public ByteString getRequestIdBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                    Object obj = this.requestId_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.requestId_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getResponseTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.responseTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public long getTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.timestamp_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasErrorCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasMethod() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasRequestId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasResponseTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
            public boolean hasTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setAliasId(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048621, this, j)) == null) {
                    this.bitField0_ |= 64;
                    this.aliasId_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setErrorCode(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048622, this, j)) == null) {
                    this.bitField0_ |= 16;
                    this.errorCode_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setExt(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 32;
                        this.ext_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExtBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 32;
                        this.ext_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMethod(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.method_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setMethodBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.method_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setRequestId(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.requestId_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setRequestIdBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.requestId_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setResponseTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048629, this, j)) == null) {
                    this.bitField0_ |= 8;
                    this.responseTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setTimestamp(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048630, this, j)) == null) {
                    this.bitField0_ |= 4;
                    this.timestamp_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Request build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Request buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Request) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Request buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Request request = new Request(this, (AnonymousClass1) null);
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
                return (Request) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Request getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? Request.getDefaultInstance() : (Request) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Request request) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, request)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (request != null) {
                            mergeFrom(request);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1998882827, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Request;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1998882827, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Request;");
                    return;
                }
            }
            PARSER = new AbstractParser<Request>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Request.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Request(codedInputStream, extensionRegistryLite, null) : (Request) invokeLL.objValue;
                }
            };
            Request request = new Request(true);
            defaultInstance = request;
            request.initFields();
        }

        public /* synthetic */ Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Request getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? defaultInstance : (Request) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.method_ = "";
                this.requestId_ = "";
                this.timestamp_ = 0L;
                this.responseTime_ = 0L;
                this.errorCode_ = 0L;
                this.ext_ = "";
                this.aliasId_ = 0L;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Request) invokeL.objValue;
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Request) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.aliasId_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getErrorCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.errorCode_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getExtBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getMethodBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Object obj = this.method_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.method_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Request> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public String getRequestId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public ByteString getRequestIdBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getResponseTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.responseTime_ : invokeV.longValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public long getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.timestamp_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasErrorCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasRequestId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasResponseTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.RequestOrBuilder
        public boolean hasTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Request(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Request request) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, request)) == null) ? newBuilder().mergeFrom(request) : (Builder) invokeL.objValue;
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Request) invokeLL.objValue;
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Request) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Request getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? defaultInstance : (Request) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Request(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Request) invokeL.objValue;
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Request) invokeLL.objValue;
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Request) invokeL.objValue;
        }

        public Request(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Request) invokeLL.objValue;
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Request) invokeL.objValue;
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Request) invokeLL.objValue;
        }

        public Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class TerminalInfo extends GeneratedMessageLite implements TerminalInfoOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MANUFACTURER_FIELD_NUMBER = 3;
        public static final int OS_FIELD_NUMBER = 1;
        public static final int OS_VERSION_FIELD_NUMBER = 2;
        public static Parser<TerminalInfo> PARSER = null;
        public static final int PPI_FIELD_NUMBER = 7;
        public static final int RESOLUTION_H_FIELD_NUMBER = 5;
        public static final int RESOLUTION_V_FIELD_NUMBER = 6;
        public static final int TERMINAL_TYPE_FIELD_NUMBER = 4;
        public static final TerminalInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TerminalInfo, Builder> implements TerminalInfoOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int bitField0_;
            public Object manufacturer_;
            public Object osVersion_;
            public OSType os_;
            public int ppi_;
            public int resolutionH_;
            public int resolutionV_;
            public Object terminalType_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.os_ = OSType.OS_TYPE_UNKNWON;
                this.osVersion_ = "";
                this.manufacturer_ = "";
                this.terminalType_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearManufacturer() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -5;
                    this.manufacturer_ = TerminalInfo.getDefaultInstance().getManufacturer();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearOs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -2;
                    this.os_ = OSType.OS_TYPE_UNKNWON;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearOsVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -3;
                    this.osVersion_ = TerminalInfo.getDefaultInstance().getOsVersion();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearPpi() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -65;
                    this.ppi_ = 0;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearResolutionH() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -17;
                    this.resolutionH_ = 0;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearResolutionV() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.bitField0_ &= -33;
                    this.resolutionV_ = 0;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearTerminalType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.bitField0_ &= -9;
                    this.terminalType_ = TerminalInfo.getDefaultInstance().getTerminalType();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getManufacturer() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                    Object obj = this.manufacturer_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.manufacturer_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getManufacturerBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                    Object obj = this.manufacturer_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.manufacturer_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public OSType getOs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.os_ : (OSType) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getOsVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                    Object obj = this.osVersion_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.osVersion_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getOsVersionBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                    Object obj = this.osVersion_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.osVersion_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getPpi() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.ppi_ : invokeV.intValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getResolutionH() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.resolutionH_ : invokeV.intValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public int getResolutionV() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.resolutionV_ : invokeV.intValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public String getTerminalType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    Object obj = this.terminalType_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.terminalType_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public ByteString getTerminalTypeBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                    Object obj = this.terminalType_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.terminalType_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasManufacturer() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasOs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasOsVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasPpi() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasResolutionH() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasResolutionV() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
            public boolean hasTerminalType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setManufacturer(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 4;
                        this.manufacturer_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setManufacturerBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 4;
                        this.manufacturer_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setOs(OSType oSType) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, oSType)) == null) {
                    if (oSType != null) {
                        this.bitField0_ |= 1;
                        this.os_ = oSType;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setOsVersion(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.osVersion_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.osVersion_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setPpi(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
                    this.bitField0_ |= 64;
                    this.ppi_ = i2;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder setResolutionH(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
                    this.bitField0_ |= 16;
                    this.resolutionH_ = i2;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder setResolutionV(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
                    this.bitField0_ |= 32;
                    this.resolutionV_ = i2;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder setTerminalType(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 8;
                        this.terminalType_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTerminalTypeBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 8;
                        this.terminalType_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public TerminalInfo build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    TerminalInfo buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (TerminalInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public TerminalInfo buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    TerminalInfo terminalInfo = new TerminalInfo(this, (AnonymousClass1) null);
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
                return (TerminalInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public TerminalInfo getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? TerminalInfo.getDefaultInstance() : (TerminalInfo) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(TerminalInfo terminalInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, terminalInfo)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (terminalInfo != null) {
                            mergeFrom(terminalInfo);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19620504, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$TerminalInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-19620504, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$TerminalInfo;");
                    return;
                }
            }
            PARSER = new AbstractParser<TerminalInfo>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfo.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public TerminalInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new TerminalInfo(codedInputStream, extensionRegistryLite, null) : (TerminalInfo) invokeLL.objValue;
                }
            };
            TerminalInfo terminalInfo = new TerminalInfo(true);
            defaultInstance = terminalInfo;
            terminalInfo.initFields();
        }

        public /* synthetic */ TerminalInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static TerminalInfo getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? defaultInstance : (TerminalInfo) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.os_ = OSType.OS_TYPE_UNKNWON;
                this.osVersion_ = "";
                this.manufacturer_ = "";
                this.terminalType_ = "";
                this.resolutionH_ = 0;
                this.resolutionV_ = 0;
                this.ppi_ = 0;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static TerminalInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (TerminalInfo) invokeL.objValue;
        }

        public static TerminalInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (TerminalInfo) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public String getManufacturer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public ByteString getManufacturerBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Object obj = this.manufacturer_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.manufacturer_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public OSType getOs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.os_ : (OSType) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public String getOsVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public ByteString getOsVersionBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.osVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<TerminalInfo> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getPpi() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.ppi_ : invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getResolutionH() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.resolutionH_ : invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public int getResolutionV() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.resolutionV_ : invokeV.intValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public String getTerminalType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public ByteString getTerminalTypeBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                Object obj = this.terminalType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.terminalType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasManufacturer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasOs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasOsVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasPpi() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasResolutionH() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasResolutionV() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.TerminalInfoOrBuilder
        public boolean hasTerminalType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ TerminalInfo(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(TerminalInfo terminalInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, terminalInfo)) == null) ? newBuilder().mergeFrom(terminalInfo) : (Builder) invokeL.objValue;
        }

        public static TerminalInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (TerminalInfo) invokeLL.objValue;
        }

        public static TerminalInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (TerminalInfo) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public TerminalInfo getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? defaultInstance : (TerminalInfo) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TerminalInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static TerminalInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (TerminalInfo) invokeL.objValue;
        }

        public static TerminalInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (TerminalInfo) invokeLL.objValue;
        }

        public static TerminalInfo parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (TerminalInfo) invokeL.objValue;
        }

        public TerminalInfo(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static TerminalInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (TerminalInfo) invokeLL.objValue;
        }

        public static TerminalInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (TerminalInfo) invokeL.objValue;
        }

        public static TerminalInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (TerminalInfo) invokeLL.objValue;
        }

        public TerminalInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class Ui extends GeneratedMessageLite implements UiOrBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALIAS_ID_FIELD_NUMBER = 7;
        public static final int CATEGORY_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 5;
        public static final int END_TIME_FIELD_NUMBER = 4;
        public static final int EXT_FIELD_NUMBER = 6;
        public static final int PAGE_FIELD_NUMBER = 2;
        public static Parser<Ui> PARSER = null;
        public static final int START_TIME_FIELD_NUMBER = 3;
        public static final Ui defaultInstance;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Ui, Builder> implements UiOrBuilder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long aliasId_;
            public int bitField0_;
            public Object category_;
            public long duration_;
            public long endTime_;
            public Object ext_;
            public Object page_;
            public long startTime_;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.category_ = "";
                this.page_ = "";
                this.ext_ = "";
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder() : (Builder) invokeV.objValue;
            }

            private void maybeForceBuilderInitialization() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                }
            }

            public Builder clearAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    this.bitField0_ &= -65;
                    this.aliasId_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearCategory() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    this.bitField0_ &= -2;
                    this.category_ = Ui.getDefaultInstance().getCategory();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    this.bitField0_ &= -17;
                    this.duration_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    this.bitField0_ &= -9;
                    this.endTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    this.bitField0_ &= -33;
                    this.ext_ = Ui.getDefaultInstance().getExt();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearPage() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    this.bitField0_ &= -3;
                    this.page_ = Ui.getDefaultInstance().getPage();
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            public Builder clearStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    this.bitField0_ &= -5;
                    this.startTime_ = 0L;
                    return this;
                }
                return (Builder) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.aliasId_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getCategory() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    Object obj = this.category_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.category_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getCategoryBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    Object obj = this.category_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.category_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.duration_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.endTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                    Object obj = this.ext_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.ext_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getExtBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                    Object obj = this.ext_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.ext_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public String getPage() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                    Object obj = this.page_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.page_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public ByteString getPageBytes() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                    Object obj = this.page_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.page_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }
                return (ByteString) invokeV.objValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public long getStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.startTime_ : invokeV.longValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasAliasId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasCategory() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasDuration() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasEndTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasExt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasPage() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
            }

            @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
            public boolean hasStartTime() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public Builder setAliasId(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048621, this, j)) == null) {
                    this.bitField0_ |= 64;
                    this.aliasId_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setCategory(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 1;
                        this.category_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setCategoryBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 1;
                        this.category_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setDuration(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048624, this, j)) == null) {
                    this.bitField0_ |= 16;
                    this.duration_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setEndTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048625, this, j)) == null) {
                    this.bitField0_ |= 8;
                    this.endTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            public Builder setExt(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 32;
                        this.ext_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setExtBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 32;
                        this.ext_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setPage(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
                    if (str != null) {
                        this.bitField0_ |= 2;
                        this.page_ = str;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setPageBytes(ByteString byteString) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, byteString)) == null) {
                    if (byteString != null) {
                        this.bitField0_ |= 2;
                        this.page_ = byteString;
                        return this;
                    }
                    throw null;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setStartTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048630, this, j)) == null) {
                    this.bitField0_ |= 4;
                    this.startTime_ = j;
                    return this;
                }
                return (Builder) invokeJ.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ui build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Ui buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }
                return (Ui) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            public Ui buildPartial() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Ui ui = new Ui(this, (AnonymousClass1) null);
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
                return (Ui) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clear() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                return (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public Ui getDefaultInstanceForType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? Ui.getDefaultInstance() : (Ui) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Ui ui) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, ui)) == null) {
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
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? create().mergeFrom(buildPartial()) : (Builder) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, codedInputStream, extensionRegistryLite)) == null) {
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
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (ui != null) {
                            mergeFrom(ui);
                        }
                        throw th;
                    }
                }
                return (Builder) invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(132140574, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Ui;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(132140574, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb$Ui;");
                    return;
                }
            }
            PARSER = new AbstractParser<Ui>() { // from class: com.baidu.android.imsdk.upload.action.pb.IMPushPb.Ui.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                public Ui parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new Ui(codedInputStream, extensionRegistryLite, null) : (Ui) invokeLL.objValue;
                }
            };
            Ui ui = new Ui(true);
            defaultInstance = ui;
            ui.initFields();
        }

        public /* synthetic */ Ui(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 anonymousClass1) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Ui getDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? defaultInstance : (Ui) invokeV.objValue;
        }

        private void initFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65554, this) == null) {
                this.category_ = "";
                this.page_ = "";
                this.startTime_ = 0L;
                this.endTime_ = 0L;
                this.duration_ = 0L;
                this.ext_ = "";
                this.aliasId_ = 0L;
            }
        }

        public static Builder newBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? Builder.create() : (Builder) invokeV.objValue;
        }

        public static Ui parseDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (Ui) invokeL.objValue;
        }

        public static Ui parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (Ui) invokeL.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.aliasId_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getCategory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getCategoryBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Object obj = this.category_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.category_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.duration_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getEndTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.endTime_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getExtBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Object obj = this.ext_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ext_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public String getPage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public ByteString getPageBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Object obj = this.page_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.page_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }
            return (ByteString) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<Ui> getParserForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? PARSER : (Parser) invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
            return invokeV.intValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public long getStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.startTime_ : invokeV.longValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasAliasId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasCategory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasEndTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasPage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
        }

        @Override // com.baidu.android.imsdk.upload.action.pb.IMPushPb.UiOrBuilder
        public boolean hasStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                byte b2 = this.memoizedIsInitialized;
                if (b2 != -1) {
                    return b2 == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? super.writeReplace() : invokeV.objValue;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, codedOutputStream) == null) {
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
        }

        public /* synthetic */ Ui(GeneratedMessageLite.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        public static Builder newBuilder(Ui ui) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, ui)) == null) ? newBuilder().mergeFrom(ui) : (Builder) invokeL.objValue;
        }

        public static Ui parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (Ui) invokeLL.objValue;
        }

        public static Ui parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (Ui) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public Ui getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? defaultInstance : (Ui) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? newBuilder() : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public Builder toBuilder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? newBuilder(this) : (Builder) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ui(GeneratedMessageLite.Builder builder) {
            super(builder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((GeneratedMessageLite.Builder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ui parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (Ui) invokeL.objValue;
        }

        public static Ui parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (Ui) invokeLL.objValue;
        }

        public static Ui parseFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (Ui) invokeL.objValue;
        }

        public Ui(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static Ui parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (Ui) invokeLL.objValue;
        }

        public static Ui parseFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (Ui) invokeL.objValue;
        }

        public static Ui parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (Ui) invokeLL.objValue;
        }

        public Ui(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {codedInputStream, extensionRegistryLite};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
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

    /* loaded from: classes6.dex */
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1447759200, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1447759200, "Lcom/baidu/android/imsdk/upload/action/pb/IMPushPb;");
        }
    }

    public IMPushPb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, extensionRegistryLite) == null) {
        }
    }
}
