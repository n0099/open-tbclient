package alaim;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ImEffect extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_END_COLOR = "";
    public static final String DEFAULT_START_COLOR = "";
    public static final String DEFAULT_STROKE_COLOR = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String end_color;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String start_color;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String stroke_color;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<ImEffect> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String end_color;
        public String start_color;
        public String stroke_color;

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
        public Builder(ImEffect imEffect) {
            super(imEffect);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imEffect};
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
            if (imEffect == null) {
                return;
            }
            this.start_color = imEffect.start_color;
            this.end_color = imEffect.end_color;
            this.stroke_color = imEffect.stroke_color;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public ImEffect build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? new ImEffect(this, z, null) : (ImEffect) invokeZ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ ImEffect(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImEffect(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            String str = builder.start_color;
            if (str == null) {
                this.start_color = "";
            } else {
                this.start_color = str;
            }
            String str2 = builder.end_color;
            if (str2 == null) {
                this.end_color = "";
            } else {
                this.end_color = str2;
            }
            String str3 = builder.stroke_color;
            if (str3 == null) {
                this.stroke_color = "";
                return;
            } else {
                this.stroke_color = str3;
                return;
            }
        }
        this.start_color = builder.start_color;
        this.end_color = builder.end_color;
        this.stroke_color = builder.stroke_color;
    }
}
