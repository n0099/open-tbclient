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
public final class LiveMarkInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT_ANCHOR_USER_ID;
    public static final Long DEFAULT_HEIGHT;
    public static final Long DEFAULT_MARK_ID;
    public static final String DEFAULT_MARK_NAME = "";
    public static final String DEFAULT_MARK_PIC = "";
    public static final Long DEFAULT_TYPE;
    public static final Long DEFAULT_WIDTH;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long anchor_user_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long height;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long mark_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String mark_name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String mark_pic;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long type;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long width;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<LiveMarkInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long anchor_user_id;
        public Long height;
        public Long mark_id;
        public String mark_name;
        public String mark_pic;
        public Long type;
        public Long width;

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
        public Builder(LiveMarkInfo liveMarkInfo) {
            super(liveMarkInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveMarkInfo};
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
            if (liveMarkInfo == null) {
                return;
            }
            this.mark_id = liveMarkInfo.mark_id;
            this.mark_name = liveMarkInfo.mark_name;
            this.anchor_user_id = liveMarkInfo.anchor_user_id;
            this.mark_pic = liveMarkInfo.mark_pic;
            this.type = liveMarkInfo.type;
            this.height = liveMarkInfo.height;
            this.width = liveMarkInfo.width;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public LiveMarkInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? new LiveMarkInfo(this, z, null) : (LiveMarkInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1512124685, "Lalaim/LiveMarkInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1512124685, "Lalaim/LiveMarkInfo;");
                return;
            }
        }
        DEFAULT_MARK_ID = 0L;
        DEFAULT_ANCHOR_USER_ID = 0L;
        DEFAULT_TYPE = 0L;
        DEFAULT_HEIGHT = 0L;
        DEFAULT_WIDTH = 0L;
    }

    public /* synthetic */ LiveMarkInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMarkInfo(Builder builder, boolean z) {
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
            Long l = builder.mark_id;
            if (l == null) {
                this.mark_id = DEFAULT_MARK_ID;
            } else {
                this.mark_id = l;
            }
            String str = builder.mark_name;
            if (str == null) {
                this.mark_name = "";
            } else {
                this.mark_name = str;
            }
            Long l2 = builder.anchor_user_id;
            if (l2 == null) {
                this.anchor_user_id = DEFAULT_ANCHOR_USER_ID;
            } else {
                this.anchor_user_id = l2;
            }
            String str2 = builder.mark_pic;
            if (str2 == null) {
                this.mark_pic = "";
            } else {
                this.mark_pic = str2;
            }
            Long l3 = builder.type;
            if (l3 == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = l3;
            }
            Long l4 = builder.height;
            if (l4 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = l4;
            }
            Long l5 = builder.width;
            if (l5 == null) {
                this.width = DEFAULT_WIDTH;
                return;
            } else {
                this.width = l5;
                return;
            }
        }
        this.mark_id = builder.mark_id;
        this.mark_name = builder.mark_name;
        this.anchor_user_id = builder.anchor_user_id;
        this.mark_pic = builder.mark_pic;
        this.type = builder.type;
        this.height = builder.height;
        this.width = builder.width;
    }
}
