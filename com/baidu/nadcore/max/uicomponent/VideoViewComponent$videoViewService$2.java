package com.baidu.nadcore.max.uicomponent;

import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ul0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/nadcore/max/uicomponent/VideoViewComponent$videoViewService$2$1", "invoke", "()Lcom/baidu/nadcore/max/uicomponent/VideoViewComponent$videoViewService$2$1;"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class VideoViewComponent$videoViewService$2 extends Lambda implements Function0<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ VideoViewComponent this$0;

    /* loaded from: classes2.dex */
    public static final class a implements ul0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoViewComponent$videoViewService$2 a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(VideoViewComponent$videoViewService$2 videoViewComponent$videoViewService$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoViewComponent$videoViewService$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoViewComponent$videoViewService$2;
        }

        @Override // com.repackage.ul0
        public int getVideoHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.this$0.u() : invokeV.intValue;
        }

        @Override // com.repackage.ul0
        public FrameLayout h() {
            InterceptResult invokeV;
            VideoViewHolder videoViewHolder;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                videoViewHolder = this.a.this$0.h;
                return videoViewHolder;
            }
            return (FrameLayout) invokeV.objValue;
        }

        @Override // com.repackage.ul0
        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.this$0.p : invokeV.booleanValue;
        }

        @Override // com.repackage.ul0
        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.this$0.q : invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoViewComponent$videoViewService$2(VideoViewComponent videoViewComponent) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoViewComponent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = videoViewComponent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }
}
