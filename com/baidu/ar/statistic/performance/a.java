package com.baidu.ar.statistic.performance;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String xh;
    public double xi;
    public long xj;
    public long xk;
    public long xl;
    public BlockingQueue<C0058a> xm;

    /* renamed from: com.baidu.ar.statistic.performance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0058a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int xn;
        public long xo;
        public long xp;
        public BlockingQueue<C0059a> xq;

        /* renamed from: com.baidu.ar.statistic.performance.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0059a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int count;
            public String name;
            public String xr;
            public long xs;

            public C0059a() {
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

        public C0058a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.xq = new LinkedBlockingQueue();
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.xm = new LinkedBlockingQueue();
    }

    public JSONObject gt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("case_id", this.xh);
                jSONObject.put("cpu_rate", String.valueOf(this.xi));
                jSONObject.put("cpu_tc", String.valueOf(this.xj));
                jSONObject.put("mem_total", String.valueOf(this.xk));
                jSONObject.put("mem_used", String.valueOf(this.xl));
                JSONArray jSONArray = new JSONArray();
                for (C0058a c0058a : this.xm) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("frame_index", c0058a.xn);
                        jSONObject2.put("frame_in", c0058a.xo);
                        jSONObject2.put("frame_out", c0058a.xp);
                        JSONArray jSONArray2 = new JSONArray();
                        for (C0058a.C0059a c0059a : c0058a.xq) {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("name", c0059a.name);
                                jSONObject3.put("func", c0059a.xr);
                                jSONObject3.put("time_cost", c0059a.xs);
                                jSONObject3.put("count", c0059a.count);
                                jSONArray2.put(jSONObject3);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        jSONObject2.put("algo_data", jSONArray2);
                        jSONArray.put(jSONObject2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                jSONObject.put("frame_data", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void gu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.xh = null;
            this.xi = 0.0d;
            this.xj = 0L;
            this.xk = 0L;
            this.xl = 0L;
            this.xm = new LinkedBlockingQueue();
        }
    }
}
