package com.baidu.swan.trace.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.q.c;
import d.a.q0.q.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class TraceInfoActivity extends Activity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TIP_LOADING = "-- LOADING --";
    public static final String TIP_NO_DATA = "NO DATA";
    public transient /* synthetic */ FieldHolder $fh;
    public List<d.a.q0.q.a> mBeans;
    public int mIndex;
    public Button mSwitchThread;
    public Set<String> mThreads;
    public TextView mTraceInfo;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TraceInfoActivity f12066e;

        public a(TraceInfoActivity traceInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {traceInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12066e = traceInfoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12066e.showTextInUIThread(this.f12066e.getContent());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TraceInfoActivity f12068f;

        public b(TraceInfoActivity traceInfoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {traceInfoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12068f = traceInfoActivity;
            this.f12067e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12068f.mTraceInfo == null) {
                return;
            }
            this.f12068f.mTraceInfo.setText(this.f12067e);
        }
    }

    public TraceInfoActivity() {
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

    private void doShowInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.mTraceInfo.setText(TIP_LOADING);
            ExecutorUtilsExt.postOnElastic(new a(this), "show-trace", 3);
        }
    }

    private void fillThreads() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            for (d.a.q0.q.a aVar : this.mBeans) {
                this.mThreads.add(aVar.f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            ArrayList arrayList = new ArrayList(this.mThreads);
            int i2 = this.mIndex;
            this.mIndex = i2 + 1;
            String str = (String) arrayList.get(i2 % arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (d.a.q0.q.a aVar : this.mBeans) {
                if (TextUtils.equals(aVar.f(), str)) {
                    arrayList2.add(aVar);
                }
            }
            return d.a.q0.q.f.a.c(arrayList2, null);
        }
        return (String) invokeV.objValue;
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mTraceInfo = (TextView) findViewById(d.a.q0.q.b.trace_info);
            Button button = (Button) findViewById(d.a.q0.q.b.switch_thread);
            this.mSwitchThread = button;
            button.setOnClickListener(this);
            this.mThreads = new HashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTextInUIThread(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            runOnUiThread(new b(this, str));
        }
    }

    private void showTraceInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            d.a.q0.q.e.a<List<d.a.q0.q.a>> c2 = d.b().c();
            if (c2 == null) {
                this.mTraceInfo.setText(TIP_NO_DATA);
                return;
            }
            List<d.a.q0.q.a> a2 = c2.a();
            if (a2 != null && a2.size() > 0) {
                this.mBeans = a2;
                this.mIndex = 0;
                fillThreads();
                doShowInfo();
                return;
            }
            this.mTraceInfo.setText(TIP_NO_DATA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == d.a.q0.q.b.switch_thread) {
            doShowInfo();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(c.activity_trace_info);
            initViews();
            showTraceInfo();
        }
    }
}
