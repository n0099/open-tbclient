package com.baidu.searchbox.live.interfaces.broadcast;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LiveBridgeBroadConst {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_DATA = "data";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class Actions {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FEED_PAY_SUCCESS_ACTION = "com.baidu.live.feedpay.success";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveBridgeBroadConst this$0;

        public Actions(LiveBridgeBroadConst liveBridgeBroadConst) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveBridgeBroadConst};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = liveBridgeBroadConst;
        }
    }

    /* loaded from: classes4.dex */
    public class Keys {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FEED_PAY_SUCCESS_NID_KEY = "payment_nid";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveBridgeBroadConst this$0;

        public Keys(LiveBridgeBroadConst liveBridgeBroadConst) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveBridgeBroadConst};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = liveBridgeBroadConst;
        }
    }

    public LiveBridgeBroadConst() {
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
}
