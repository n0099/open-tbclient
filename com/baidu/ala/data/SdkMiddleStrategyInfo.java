package com.baidu.ala.data;

import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SdkMiddleStrategyInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DisplayStrategy displayStrategy;
    public int score;
    public StrategyExtra strategyExtra;
    public long ts;

    /* loaded from: classes4.dex */
    public static class DisplayStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String attention;
        public int imageNum;
        public int mark;
        public String title;
        public int type;

        public DisplayStrategy() {
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

        public void fromJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.mark = jSONObject.optInt("mark");
            this.type = jSONObject.optInt("type");
            this.imageNum = jSONObject.optInt("image_num");
            this.title = jSONObject.optString("title");
        }
    }

    /* loaded from: classes4.dex */
    public static class StrategyExtra {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int click;
        public String ctr_fea;
        public String fe;
        public double gbdt_score;
        public int mark;
        public String mthid;
        public long public_time;
        public int q_ratio;
        public String rec_src;
        public int show;
        public int source;
        public String source_from;
        public int vertical_type;

        public StrategyExtra() {
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

        public void fromJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.mthid = jSONObject.optString("mthid");
            this.q_ratio = jSONObject.optInt("q_ratio");
            this.click = jSONObject.optInt(PrefetchEvent.STATE_CLICK);
            this.show = jSONObject.optInt("show");
            this.source = jSONObject.optInt("source");
            this.vertical_type = jSONObject.optInt("vertical_type");
            this.ctr_fea = jSONObject.optString("ctr_fea");
            this.source_from = jSONObject.optString("source_from");
            this.gbdt_score = jSONObject.optDouble("gbdt_score");
            this.mark = jSONObject.optInt("mark");
            this.public_time = jSONObject.optInt("public_time");
            this.rec_src = jSONObject.optString("rec_src");
            this.fe = jSONObject.optString("fe");
        }
    }

    public SdkMiddleStrategyInfo() {
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

    public void fromJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.ts = jSONObject.optLong("ts");
        this.score = jSONObject.optInt("score");
        this.displayStrategy = new DisplayStrategy();
        JSONObject optJSONObject = jSONObject.optJSONObject("display_strategy");
        if (optJSONObject != null) {
            this.displayStrategy.fromJson(optJSONObject);
        }
        this.strategyExtra = new StrategyExtra();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("ext");
        if (optJSONObject2 != null) {
            this.strategyExtra.fromJson(optJSONObject2);
        }
    }
}
