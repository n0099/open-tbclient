package alaim;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class CommonReq extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_APID = "";
    public static final String DEFAULT_BDUSS = "";
    public static final String DEFAULT_BRAND = "";
    public static final String DEFAULT_BRAND_TYPE = "";
    public static final String DEFAULT_CUID = "";
    public static final String DEFAULT_FROM = "";
    public static final String DEFAULT_KA = "";
    public static final String DEFAULT_MODEL = "";
    public static final String DEFAULT_M_API = "";
    public static final String DEFAULT_M_COST = "";
    public static final String DEFAULT_M_LOGID = "";
    public static final String DEFAULT_M_RESULT = "";
    public static final String DEFAULT_M_SIZE_D = "";
    public static final String DEFAULT_M_SIZE_U = "";
    public static final Integer DEFAULT_NET_TYPE;
    public static final String DEFAULT_PVERSION = "";
    public static final String DEFAULT_SIGN = "";
    public static final String DEFAULT_SMALLFLOW = "";
    public static final String DEFAULT_SUBAPP_TYPE = "";
    public static final String DEFAULT_TBS = "";
    public static final String DEFAULT__CLIENT_ID = "";
    public static final Integer DEFAULT__CLIENT_TYPE;
    public static final String DEFAULT__CLIENT_VERSION = "";
    public static final String DEFAULT__OS_VERSION = "";
    public static final String DEFAULT__PHONE_IMEI = "";
    public static final String DEFAULT__PHONE_NEWIMEI = "";
    public static final Long DEFAULT__TIMESTAMP;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String BDUSS;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String _client_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer _client_type;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String _client_version;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String _os_version;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String _phone_imei;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String _phone_newimei;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long _timestamp;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String apid;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String brand;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String brand_type;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String cuid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String ka;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String m_api;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String m_cost;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String m_logid;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String m_result;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String m_size_d;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String m_size_u;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String model;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer net_type;
    @ProtoField(tag = 24, type = Message.Datatype.STRING)
    public final String pversion;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String sign;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String smallflow;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String subapp_type;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String tbs;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<CommonReq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String BDUSS;
        public String _client_id;
        public Integer _client_type;
        public String _client_version;
        public String _os_version;
        public String _phone_imei;
        public String _phone_newimei;
        public Long _timestamp;
        public String apid;
        public String brand;
        public String brand_type;
        public String cuid;
        public String from;
        public String ka;
        public String m_api;
        public String m_cost;
        public String m_logid;
        public String m_result;
        public String m_size_d;
        public String m_size_u;
        public String model;
        public Integer net_type;
        public String pversion;
        public String sign;
        public String smallflow;
        public String subapp_type;
        public String tbs;

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
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(CommonReq commonReq) {
            super(commonReq);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonReq};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (commonReq == null) {
                return;
            }
            this._client_type = commonReq._client_type;
            this._client_version = commonReq._client_version;
            this._client_id = commonReq._client_id;
            this.apid = commonReq.apid;
            this._phone_imei = commonReq._phone_imei;
            this.from = commonReq.from;
            this.cuid = commonReq.cuid;
            this._timestamp = commonReq._timestamp;
            this.model = commonReq.model;
            this.BDUSS = commonReq.BDUSS;
            this.tbs = commonReq.tbs;
            this.net_type = commonReq.net_type;
            this.subapp_type = commonReq.subapp_type;
            this._phone_newimei = commonReq._phone_newimei;
            this.ka = commonReq.ka;
            this.m_api = commonReq.m_api;
            this.m_logid = commonReq.m_logid;
            this.m_cost = commonReq.m_cost;
            this.m_result = commonReq.m_result;
            this.m_size_u = commonReq.m_size_u;
            this.m_size_d = commonReq.m_size_d;
            this.smallflow = commonReq.smallflow;
            this.sign = commonReq.sign;
            this.pversion = commonReq.pversion;
            this._os_version = commonReq._os_version;
            this.brand = commonReq.brand;
            this.brand_type = commonReq.brand_type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public CommonReq build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? new CommonReq(this, z, null) : (CommonReq) invokeZ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(370540617, "Lalaim/CommonReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(370540617, "Lalaim/CommonReq;");
                return;
            }
        }
        DEFAULT__CLIENT_TYPE = 0;
        DEFAULT__TIMESTAMP = 0L;
        DEFAULT_NET_TYPE = 0;
    }

    public /* synthetic */ CommonReq(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonReq(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            Integer num = builder._client_type;
            if (num == null) {
                this._client_type = DEFAULT__CLIENT_TYPE;
            } else {
                this._client_type = num;
            }
            String str = builder._client_version;
            if (str == null) {
                this._client_version = "";
            } else {
                this._client_version = str;
            }
            String str2 = builder._client_id;
            if (str2 == null) {
                this._client_id = "";
            } else {
                this._client_id = str2;
            }
            String str3 = builder.apid;
            if (str3 == null) {
                this.apid = "";
            } else {
                this.apid = str3;
            }
            String str4 = builder._phone_imei;
            if (str4 == null) {
                this._phone_imei = "";
            } else {
                this._phone_imei = str4;
            }
            String str5 = builder.from;
            if (str5 == null) {
                this.from = "";
            } else {
                this.from = str5;
            }
            String str6 = builder.cuid;
            if (str6 == null) {
                this.cuid = "";
            } else {
                this.cuid = str6;
            }
            Long l = builder._timestamp;
            if (l == null) {
                this._timestamp = DEFAULT__TIMESTAMP;
            } else {
                this._timestamp = l;
            }
            String str7 = builder.model;
            if (str7 == null) {
                this.model = "";
            } else {
                this.model = str7;
            }
            String str8 = builder.BDUSS;
            if (str8 == null) {
                this.BDUSS = "";
            } else {
                this.BDUSS = str8;
            }
            String str9 = builder.tbs;
            if (str9 == null) {
                this.tbs = "";
            } else {
                this.tbs = str9;
            }
            Integer num2 = builder.net_type;
            if (num2 == null) {
                this.net_type = DEFAULT_NET_TYPE;
            } else {
                this.net_type = num2;
            }
            String str10 = builder.subapp_type;
            if (str10 == null) {
                this.subapp_type = "";
            } else {
                this.subapp_type = str10;
            }
            String str11 = builder._phone_newimei;
            if (str11 == null) {
                this._phone_newimei = "";
            } else {
                this._phone_newimei = str11;
            }
            String str12 = builder.ka;
            if (str12 == null) {
                this.ka = "";
            } else {
                this.ka = str12;
            }
            String str13 = builder.m_api;
            if (str13 == null) {
                this.m_api = "";
            } else {
                this.m_api = str13;
            }
            String str14 = builder.m_logid;
            if (str14 == null) {
                this.m_logid = "";
            } else {
                this.m_logid = str14;
            }
            String str15 = builder.m_cost;
            if (str15 == null) {
                this.m_cost = "";
            } else {
                this.m_cost = str15;
            }
            String str16 = builder.m_result;
            if (str16 == null) {
                this.m_result = "";
            } else {
                this.m_result = str16;
            }
            String str17 = builder.m_size_u;
            if (str17 == null) {
                this.m_size_u = "";
            } else {
                this.m_size_u = str17;
            }
            String str18 = builder.m_size_d;
            if (str18 == null) {
                this.m_size_d = "";
            } else {
                this.m_size_d = str18;
            }
            String str19 = builder.smallflow;
            if (str19 == null) {
                this.smallflow = "";
            } else {
                this.smallflow = str19;
            }
            String str20 = builder.sign;
            if (str20 == null) {
                this.sign = "";
            } else {
                this.sign = str20;
            }
            String str21 = builder.pversion;
            if (str21 == null) {
                this.pversion = "";
            } else {
                this.pversion = str21;
            }
            String str22 = builder._os_version;
            if (str22 == null) {
                this._os_version = "";
            } else {
                this._os_version = str22;
            }
            String str23 = builder.brand;
            if (str23 == null) {
                this.brand = "";
            } else {
                this.brand = str23;
            }
            String str24 = builder.brand_type;
            if (str24 == null) {
                this.brand_type = "";
                return;
            } else {
                this.brand_type = str24;
                return;
            }
        }
        this._client_type = builder._client_type;
        this._client_version = builder._client_version;
        this._client_id = builder._client_id;
        this.apid = builder.apid;
        this._phone_imei = builder._phone_imei;
        this.from = builder.from;
        this.cuid = builder.cuid;
        this._timestamp = builder._timestamp;
        this.model = builder.model;
        this.BDUSS = builder.BDUSS;
        this.tbs = builder.tbs;
        this.net_type = builder.net_type;
        this.subapp_type = builder.subapp_type;
        this._phone_newimei = builder._phone_newimei;
        this.ka = builder.ka;
        this.m_api = builder.m_api;
        this.m_logid = builder.m_logid;
        this.m_cost = builder.m_cost;
        this.m_result = builder.m_result;
        this.m_size_u = builder.m_size_u;
        this.m_size_d = builder.m_size_d;
        this.smallflow = builder.smallflow;
        this.sign = builder.sign;
        this.pversion = builder.pversion;
        this._os_version = builder._os_version;
        this.brand = builder.brand;
        this.brand_type = builder.brand_type;
    }
}
