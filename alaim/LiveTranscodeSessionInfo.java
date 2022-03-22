package alaim;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class LiveTranscodeSessionInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_FLVURL = "";
    public static final String DEFAULT_HLSURL = "";
    public static final String DEFAULT_RTMPURL = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String flvUrl;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String hlsUrl;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String rtmpUrl;

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<LiveTranscodeSessionInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String flvUrl;
        public String hlsUrl;
        public String rtmpUrl;

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
        public Builder(LiveTranscodeSessionInfo liveTranscodeSessionInfo) {
            super(liveTranscodeSessionInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTranscodeSessionInfo};
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
            if (liveTranscodeSessionInfo == null) {
                return;
            }
            this.rtmpUrl = liveTranscodeSessionInfo.rtmpUrl;
            this.hlsUrl = liveTranscodeSessionInfo.hlsUrl;
            this.flvUrl = liveTranscodeSessionInfo.flvUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public LiveTranscodeSessionInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? new LiveTranscodeSessionInfo(this, z, null) : (LiveTranscodeSessionInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ LiveTranscodeSessionInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveTranscodeSessionInfo(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            String str = builder.rtmpUrl;
            if (str == null) {
                this.rtmpUrl = "";
            } else {
                this.rtmpUrl = str;
            }
            String str2 = builder.hlsUrl;
            if (str2 == null) {
                this.hlsUrl = "";
            } else {
                this.hlsUrl = str2;
            }
            String str3 = builder.flvUrl;
            if (str3 == null) {
                this.flvUrl = "";
                return;
            } else {
                this.flvUrl = str3;
                return;
            }
        }
        this.rtmpUrl = builder.rtmpUrl;
        this.hlsUrl = builder.hlsUrl;
        this.flvUrl = builder.flvUrl;
    }
}
