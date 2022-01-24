package com.baidu.searchbox.fluency.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0003:\u0001\u0003B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/FpsConstants;", "<init>", "()V", "Companion", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class FpsConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int DEFAULT_DROPPED_FROZEN = 40;
    public static final int DEFAULT_DROPPED_HIGH = 25;
    public static final int DEFAULT_DROPPED_MIDDLE = 10;
    public static final int DEFAULT_DROPPED_NORMAL = 3;
    public static final int DEFAULT_FPS_TIME_SLICE_MS = 10000;
    public static final long DEFAULT_FRAME_DURATION = 16666667;
    public static final int MILLIS_TO_NANO = 1000000;
    public static final String REPORT_DROP_LEVEL = "dropLevel";
    public static final String REPORT_DROP_SUM = "dropSum";
    public static final String REPORT_FPS = "fps";
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/FpsConstants$Companion;", "", "DEFAULT_DROPPED_FROZEN", "I", "DEFAULT_DROPPED_HIGH", "DEFAULT_DROPPED_MIDDLE", "DEFAULT_DROPPED_NORMAL", "DEFAULT_FPS_TIME_SLICE_MS", "", "DEFAULT_FRAME_DURATION", "J", "MILLIS_TO_NANO", "", "REPORT_DROP_LEVEL", "Ljava/lang/String;", "REPORT_DROP_SUM", "REPORT_FPS", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes11.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1089536668, "Lcom/baidu/searchbox/fluency/utils/FpsConstants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1089536668, "Lcom/baidu/searchbox/fluency/utils/FpsConstants;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public FpsConstants() {
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
}
