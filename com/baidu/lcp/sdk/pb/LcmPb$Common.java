package com.baidu.lcp.sdk.pb;

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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes3.dex */
public final class LcmPb$Common extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_ID_FIELD_NUMBER = 6;
    public static final int APP_VERSION_FIELD_NUMBER = 7;
    public static final int CUID_FIELD_NUMBER = 1;
    public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
    public static final int MANUFACTURE_FIELD_NUMBER = 4;
    public static final int MODEL_TYPE_FIELD_NUMBER = 5;
    public static final int NETWORK_FIELD_NUMBER = 9;
    public static final int OS_VERSION_FIELD_NUMBER = 3;
    public static Parser<LcmPb$Common> PARSER = null;
    public static final int ROM_VERSION_FIELD_NUMBER = 10;
    public static final int SDK_VERSION_FIELD_NUMBER = 8;
    public static final LcmPb$Common defaultInstance;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes3.dex */
    public static class a extends AbstractParser<LcmPb$Common> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public LcmPb$Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, codedInputStream, extensionRegistryLite)) == null) ? new LcmPb$Common(codedInputStream, extensionRegistryLite, null) : (LcmPb$Common) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends GeneratedMessageLite.Builder<LcmPb$Common, b> implements Object {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f6400e;

        /* renamed from: f  reason: collision with root package name */
        public Object f6401f;

        /* renamed from: g  reason: collision with root package name */
        public Object f6402g;

        /* renamed from: h  reason: collision with root package name */
        public Object f6403h;

        /* renamed from: i  reason: collision with root package name */
        public Object f6404i;
        public Object j;
        public Object k;
        public Object l;
        public Object m;
        public Object n;
        public Object o;

        public b() {
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
            this.f6401f = "";
            this.f6402g = "";
            this.f6403h = "";
            this.f6404i = "";
            this.j = "";
            this.k = "";
            this.l = "";
            this.m = "";
            this.n = "";
            this.o = "";
            maybeForceBuilderInitialization();
        }

        public static b q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
        }

        public b A(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 256;
                    this.n = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b B(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 4;
                    this.f6403h = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b C(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 512;
                    this.o = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b D(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 128;
                    this.m = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            o();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public LcmPb$Common build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                LcmPb$Common buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }
            return (LcmPb$Common) invokeV.objValue;
        }

        public final void maybeForceBuilderInitialization() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            }
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                LcmPb$Common lcmPb$Common = new LcmPb$Common(this, (d.a.w.a.e.a) null);
                int i2 = this.f6400e;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                lcmPb$Common.cuid_ = this.f6401f;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                lcmPb$Common.deviceType_ = this.f6402g;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                lcmPb$Common.osVersion_ = this.f6403h;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                lcmPb$Common.manufacture_ = this.f6404i;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                lcmPb$Common.modelType_ = this.j;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                lcmPb$Common.appId_ = this.k;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                lcmPb$Common.appVersion_ = this.l;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                lcmPb$Common.sdkVersion_ = this.m;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                lcmPb$Common.network_ = this.n;
                if ((i2 & 512) == 512) {
                    i3 |= 512;
                }
                lcmPb$Common.romVersion_ = this.o;
                lcmPb$Common.bitField0_ = i3;
                return lcmPb$Common;
            }
            return (LcmPb$Common) invokeV.objValue;
        }

        public b o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                super.clear();
                this.f6401f = "";
                int i2 = this.f6400e & (-2);
                this.f6400e = i2;
                this.f6402g = "";
                int i3 = i2 & (-3);
                this.f6400e = i3;
                this.f6403h = "";
                int i4 = i3 & (-5);
                this.f6400e = i4;
                this.f6404i = "";
                int i5 = i4 & (-9);
                this.f6400e = i5;
                this.j = "";
                int i6 = i5 & (-17);
                this.f6400e = i6;
                this.k = "";
                int i7 = i6 & (-33);
                this.f6400e = i7;
                this.l = "";
                int i8 = i7 & (-65);
                this.f6400e = i8;
                this.m = "";
                int i9 = i8 & (-129);
                this.f6400e = i9;
                this.n = "";
                int i10 = i9 & (-257);
                this.f6400e = i10;
                this.o = "";
                this.f6400e = i10 & (-513);
                return this;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                b q = q();
                q.s(buildPartial());
                return q;
            }
            return (b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public LcmPb$Common getDefaultInstanceForType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? LcmPb$Common.getDefaultInstance() : (LcmPb$Common) invokeV.objValue;
        }

        public b s(LcmPb$Common lcmPb$Common) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, lcmPb$Common)) == null) {
                if (lcmPb$Common == LcmPb$Common.getDefaultInstance()) {
                    return this;
                }
                if (lcmPb$Common.hasCuid()) {
                    this.f6400e |= 1;
                    this.f6401f = lcmPb$Common.cuid_;
                }
                if (lcmPb$Common.hasDeviceType()) {
                    this.f6400e |= 2;
                    this.f6402g = lcmPb$Common.deviceType_;
                }
                if (lcmPb$Common.hasOsVersion()) {
                    this.f6400e |= 4;
                    this.f6403h = lcmPb$Common.osVersion_;
                }
                if (lcmPb$Common.hasManufacture()) {
                    this.f6400e |= 8;
                    this.f6404i = lcmPb$Common.manufacture_;
                }
                if (lcmPb$Common.hasModelType()) {
                    this.f6400e |= 16;
                    this.j = lcmPb$Common.modelType_;
                }
                if (lcmPb$Common.hasAppId()) {
                    this.f6400e |= 32;
                    this.k = lcmPb$Common.appId_;
                }
                if (lcmPb$Common.hasAppVersion()) {
                    this.f6400e |= 64;
                    this.l = lcmPb$Common.appVersion_;
                }
                if (lcmPb$Common.hasSdkVersion()) {
                    this.f6400e |= 128;
                    this.m = lcmPb$Common.sdkVersion_;
                }
                if (lcmPb$Common.hasNetwork()) {
                    this.f6400e |= 256;
                    this.n = lcmPb$Common.network_;
                }
                if (lcmPb$Common.hasRomVersion()) {
                    this.f6400e |= 512;
                    this.o = lcmPb$Common.romVersion_;
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, codedInputStream, extensionRegistryLite)) == null) {
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
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (lcmPb$Common != null) {
                        s(lcmPb$Common);
                    }
                    throw th;
                }
            }
            return (b) invokeLL.objValue;
        }

        public b u(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 32;
                    this.k = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b v(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 64;
                    this.l = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b w(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 1;
                    this.f6401f = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b x(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 2;
                    this.f6402g = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b y(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 8;
                    this.f6404i = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
        }

        public b z(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                if (str != null) {
                    this.f6400e |= 16;
                    this.j = str;
                    return this;
                }
                throw null;
            }
            return (b) invokeL.objValue;
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
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1416810640, "Lcom/baidu/lcp/sdk/pb/LcmPb$Common;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1416810640, "Lcom/baidu/lcp/sdk/pb/LcmPb$Common;");
                return;
            }
        }
        PARSER = new a();
        LcmPb$Common lcmPb$Common = new LcmPb$Common(true);
        defaultInstance = lcmPb$Common;
        lcmPb$Common.initFields();
    }

    public /* synthetic */ LcmPb$Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d.a.w.a.e.a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static LcmPb$Common getDefaultInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? defaultInstance : (LcmPb$Common) invokeV.objValue;
    }

    private void initFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
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
    }

    public static b newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? b.q() : (b) invokeV.objValue;
    }

    public static LcmPb$Common parseDelimitedFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, inputStream)) == null) ? PARSER.parseDelimitedFrom(inputStream) : (LcmPb$Common) invokeL.objValue;
    }

    public static LcmPb$Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, byteString)) == null) ? PARSER.parseFrom(byteString) : (LcmPb$Common) invokeL.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public ByteString getAppIdBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.appId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    public ByteString getAppVersionBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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

    public String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

    public ByteString getCuidBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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

    public String getDeviceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public ByteString getDeviceTypeBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Object obj = this.deviceType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public String getManufacture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public ByteString getManufactureBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Object obj = this.manufacture_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.manufacture_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public String getModelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public ByteString getModelTypeBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Object obj = this.modelType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.modelType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public String getNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public ByteString getNetworkBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Object obj = this.network_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.network_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public String getOsVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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

    public ByteString getOsVersionBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
    public Parser<LcmPb$Common> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? PARSER : (Parser) invokeV.objValue;
    }

    public String getRomVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public ByteString getRomVersionBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Object obj = this.romVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.romVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }
        return (ByteString) invokeV.objValue;
    }

    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public ByteString getSdkVersionBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Object obj = this.sdkVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sdkVersion_ = copyFromUtf8;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
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
        return invokeV.intValue;
    }

    public boolean hasAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (this.bitField0_ & 32) == 32 : invokeV.booleanValue;
    }

    public boolean hasAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.bitField0_ & 64) == 64 : invokeV.booleanValue;
    }

    public boolean hasCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.bitField0_ & 1) == 1 : invokeV.booleanValue;
    }

    public boolean hasDeviceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? (this.bitField0_ & 2) == 2 : invokeV.booleanValue;
    }

    public boolean hasManufacture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.bitField0_ & 8) == 8 : invokeV.booleanValue;
    }

    public boolean hasModelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? (this.bitField0_ & 16) == 16 : invokeV.booleanValue;
    }

    public boolean hasNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (this.bitField0_ & 256) == 256 : invokeV.booleanValue;
    }

    public boolean hasOsVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.bitField0_ & 4) == 4 : invokeV.booleanValue;
    }

    public boolean hasRomVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? (this.bitField0_ & 512) == 512 : invokeV.booleanValue;
    }

    public boolean hasSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (this.bitField0_ & 128) == 128 : invokeV.booleanValue;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? super.writeReplace() : invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, codedOutputStream) == null) {
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
    }

    public /* synthetic */ LcmPb$Common(GeneratedMessageLite.Builder builder, d.a.w.a.e.a aVar) {
        this(builder);
    }

    public static b newBuilder(LcmPb$Common lcmPb$Common) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, lcmPb$Common)) == null) {
            b newBuilder = newBuilder();
            newBuilder.s(lcmPb$Common);
            return newBuilder;
        }
        return (b) invokeL.objValue;
    }

    public static LcmPb$Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite) : (LcmPb$Common) invokeLL.objValue;
    }

    public static LcmPb$Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, byteString, extensionRegistryLite)) == null) ? PARSER.parseFrom(byteString, extensionRegistryLite) : (LcmPb$Common) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public LcmPb$Common getDefaultInstanceForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? defaultInstance : (LcmPb$Common) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? newBuilder() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? newBuilder(this) : (b) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LcmPb$Common(GeneratedMessageLite.Builder builder) {
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

    public static LcmPb$Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, bArr)) == null) ? PARSER.parseFrom(bArr) : (LcmPb$Common) invokeL.objValue;
    }

    public static LcmPb$Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, bArr, extensionRegistryLite)) == null) ? PARSER.parseFrom(bArr, extensionRegistryLite) : (LcmPb$Common) invokeLL.objValue;
    }

    public static LcmPb$Common parseFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, inputStream)) == null) ? PARSER.parseFrom(inputStream) : (LcmPb$Common) invokeL.objValue;
    }

    public LcmPb$Common(boolean z) {
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

    public static LcmPb$Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, inputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(inputStream, extensionRegistryLite) : (LcmPb$Common) invokeLL.objValue;
    }

    public static LcmPb$Common parseFrom(CodedInputStream codedInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, codedInputStream)) == null) ? PARSER.parseFrom(codedInputStream) : (LcmPb$Common) invokeL.objValue;
    }

    public static LcmPb$Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, codedInputStream, extensionRegistryLite)) == null) ? PARSER.parseFrom(codedInputStream, extensionRegistryLite) : (LcmPb$Common) invokeLL.objValue;
    }

    public LcmPb$Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
