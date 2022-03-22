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
public final class CloseFunc extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_CHALLENGE;
    public static final Integer DEFAULT_PK;
    public static final Integer DEFAULT_RED_PACKET;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer challenge;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer pk;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer red_packet;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<CloseFunc> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer challenge;
        public Integer pk;
        public Integer red_packet;

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
        public Builder(CloseFunc closeFunc) {
            super(closeFunc);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {closeFunc};
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
            if (closeFunc == null) {
                return;
            }
            this.pk = closeFunc.pk;
            this.challenge = closeFunc.challenge;
            this.red_packet = closeFunc.red_packet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public CloseFunc build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? new CloseFunc(this, z, null) : (CloseFunc) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1396463424, "Lalaim/CloseFunc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1396463424, "Lalaim/CloseFunc;");
                return;
            }
        }
        DEFAULT_PK = 0;
        DEFAULT_CHALLENGE = 0;
        DEFAULT_RED_PACKET = 0;
    }

    public /* synthetic */ CloseFunc(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloseFunc(Builder builder, boolean z) {
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
            Integer num = builder.pk;
            if (num == null) {
                this.pk = DEFAULT_PK;
            } else {
                this.pk = num;
            }
            Integer num2 = builder.challenge;
            if (num2 == null) {
                this.challenge = DEFAULT_CHALLENGE;
            } else {
                this.challenge = num2;
            }
            Integer num3 = builder.red_packet;
            if (num3 == null) {
                this.red_packet = DEFAULT_RED_PACKET;
                return;
            } else {
                this.red_packet = num3;
                return;
            }
        }
        this.pk = builder.pk;
        this.challenge = builder.challenge;
        this.red_packet = builder.red_packet;
    }
}
