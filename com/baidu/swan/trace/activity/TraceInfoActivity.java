package com.baidu.swan.trace.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public List<c.a.n0.t.a> mBeans;
    public int mIndex;
    public Button mSwitchThread;
    public Set<String> mThreads;
    public TextView mTraceInfo;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TraceInfoActivity a;

        public a(TraceInfoActivity traceInfoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {traceInfoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = traceInfoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showTextInUIThread(this.a.getContent());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TraceInfoActivity f29705b;

        public b(TraceInfoActivity traceInfoActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {traceInfoActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29705b = traceInfoActivity;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29705b.mTraceInfo == null) {
                return;
            }
            this.f29705b.mTraceInfo.setText(this.a);
        }
    }

    public TraceInfoActivity() {
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

    private void doShowInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mTraceInfo.setText(TIP_LOADING);
            ExecutorUtilsExt.postOnElastic(new a(this), "show-trace", 3);
        }
    }

    private void fillThreads() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            for (c.a.n0.t.a aVar : this.mBeans) {
                this.mThreads.add(aVar.f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            ArrayList arrayList = new ArrayList(this.mThreads);
            int i = this.mIndex;
            this.mIndex = i + 1;
            String str = (String) arrayList.get(i % arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (c.a.n0.t.a aVar : this.mBeans) {
                if (TextUtils.equals(aVar.f(), str)) {
                    arrayList2.add(aVar);
                }
            }
            return c.a.n0.t.d.a.c(arrayList2, null);
        }
        return (String) invokeV.objValue;
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mTraceInfo = (TextView) findViewById(R.id.obfuscated_res_0x7f09213b);
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f091e29);
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
            c.a.n0.t.c.a<List<c.a.n0.t.a>> c2 = c.a.n0.t.b.b().c();
            if (c2 == null) {
                this.mTraceInfo.setText(TIP_NO_DATA);
                return;
            }
            List<c.a.n0.t.a> a2 = c2.a();
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
        List<c.a.n0.t.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getId() != R.id.obfuscated_res_0x7f091e29 || (list = this.mBeans) == null || list.size() <= 0) {
            return;
        }
        doShowInfo();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0059);
            initViews();
            showTraceInfo();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
