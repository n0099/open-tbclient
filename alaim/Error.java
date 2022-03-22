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
public final class Error extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_ERRORNO;
    public static final Long DEFAULT_LOGID;
    public static final Integer DEFAULT_TIME;
    public static final String DEFAULT_USERMSG = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer errorno;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long logid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer time;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String usermsg;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<Error> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer errorno;
        public Long logid;
        public Integer time;
        public String usermsg;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Error error) {
            super(error);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {error};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (error == null) {
                return;
            }
            this.errorno = error.errorno;
            this.usermsg = error.usermsg;
            this.logid = error.logid;
            this.time = error.time;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public Error build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? new Error(this, z, null) : (Error) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1458945044, "Lalaim/Error;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1458945044, "Lalaim/Error;");
                return;
            }
        }
        DEFAULT_ERRORNO = 0;
        DEFAULT_LOGID = 0L;
        DEFAULT_TIME = 0;
    }

    public /* synthetic */ Error(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Error(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            Integer num = builder.errorno;
            if (num == null) {
                this.errorno = DEFAULT_ERRORNO;
            } else {
                this.errorno = num;
            }
            String str = builder.usermsg;
            if (str == null) {
                this.usermsg = "";
            } else {
                this.usermsg = str;
            }
            Long l = builder.logid;
            if (l == null) {
                this.logid = DEFAULT_LOGID;
            } else {
                this.logid = l;
            }
            Integer num2 = builder.time;
            if (num2 == null) {
                this.time = DEFAULT_TIME;
                return;
            } else {
                this.time = num2;
                return;
            }
        }
        this.errorno = builder.errorno;
        this.usermsg = builder.usermsg;
        this.logid = builder.logid;
        this.time = builder.time;
    }
}
