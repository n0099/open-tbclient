package com.baidu.searchbox.crius.debug;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.crius.CriusLoader;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
/* loaded from: classes2.dex */
public class DebugCriusBenchmarkActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BENCHMARK_INFLATE = 1;
    public static final int BENCHMARK_LAYOUT = 3;
    public static final int BENCHMARK_MEASURE = 2;
    public static final int ITERATIONS = 500;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBenchmarkWhich;

    public DebugCriusBenchmarkActivity() {
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
        this.mBenchmarkWhich = 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.baidu.searchbox.crius.debug.DebugCriusBenchmarkActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void benchmarkInflate(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, textView) == null) {
            LayoutInflater from = LayoutInflater.from(this);
            CriusBenchmarkAggregator criusBenchmarkAggregator = new CriusBenchmarkAggregator("Benchmark Inflate");
            CriusBenchmarkAggregator criusBenchmarkAggregator2 = new CriusBenchmarkAggregator("Flatten Inflate");
            for (int i = 0; i < 500; i++) {
                criusBenchmarkAggregator.startTrace();
                from.inflate(R.layout.obfuscated_res_0x7f0d0157, (ViewGroup) null);
                criusBenchmarkAggregator.endTrace();
                criusBenchmarkAggregator2.startTrace();
                from.inflate(R.layout.obfuscated_res_0x7f0d0156, (ViewGroup) null);
                criusBenchmarkAggregator2.endTrace();
            }
            textView.setText(criusBenchmarkAggregator.toString() + "\n" + criusBenchmarkAggregator2.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.baidu.searchbox.crius.debug.DebugCriusBenchmarkActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void benchmarkLayout(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, textView) == null) {
            LayoutInflater from = LayoutInflater.from(this);
            CriusBenchmarkAggregator criusBenchmarkAggregator = new CriusBenchmarkAggregator("Benchmark Layout");
            CriusBenchmarkAggregator criusBenchmarkAggregator2 = new CriusBenchmarkAggregator("Flatten Layout");
            View inflate = from.inflate(R.layout.obfuscated_res_0x7f0d0157, (ViewGroup) null);
            View inflate2 = from.inflate(R.layout.obfuscated_res_0x7f0d0156, (ViewGroup) null);
            for (int i = 0; i < 500; i++) {
                inflate.measure(View.MeasureSpec.makeMeasureSpec(1000, 1073741824), View.MeasureSpec.makeMeasureSpec(1000, 1073741824));
                inflate2.measure(View.MeasureSpec.makeMeasureSpec(1000, 1073741824), View.MeasureSpec.makeMeasureSpec(1000, 1073741824));
                criusBenchmarkAggregator.startTrace();
                inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
                criusBenchmarkAggregator.endTrace();
                criusBenchmarkAggregator2.startTrace();
                inflate2.layout(0, 0, inflate2.getMeasuredWidth(), inflate2.getMeasuredHeight());
                criusBenchmarkAggregator2.endTrace();
            }
            textView.setText(criusBenchmarkAggregator.toString() + "\n" + criusBenchmarkAggregator2.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.baidu.searchbox.crius.debug.DebugCriusBenchmarkActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void benchmarkMeasure(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, textView) == null) {
            LayoutInflater from = LayoutInflater.from(this);
            CriusBenchmarkAggregator criusBenchmarkAggregator = new CriusBenchmarkAggregator("Benchmark Measure");
            CriusBenchmarkAggregator criusBenchmarkAggregator2 = new CriusBenchmarkAggregator("Flatten Measure");
            View inflate = from.inflate(R.layout.obfuscated_res_0x7f0d0157, (ViewGroup) null);
            View inflate2 = from.inflate(R.layout.obfuscated_res_0x7f0d0156, (ViewGroup) null);
            for (int i = 0; i < 500; i++) {
                criusBenchmarkAggregator.startTrace();
                inflate.measure(View.MeasureSpec.makeMeasureSpec(1000, 1073741824), View.MeasureSpec.makeMeasureSpec(1000, 1073741824));
                criusBenchmarkAggregator.endTrace();
                criusBenchmarkAggregator2.startTrace();
                inflate2.measure(View.MeasureSpec.makeMeasureSpec(1000, 1073741824), View.MeasureSpec.makeMeasureSpec(1000, 1073741824));
                criusBenchmarkAggregator2.endTrace();
            }
            textView.setText(criusBenchmarkAggregator.toString() + "\n" + criusBenchmarkAggregator2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBenchmark() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091f60);
            int i = this.mBenchmarkWhich;
            if (i == 1) {
                benchmarkInflate(textView);
            } else if (i == 2) {
                benchmarkMeasure(textView);
            } else {
                benchmarkLayout(textView);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.searchbox.crius.debug.DebugCriusBenchmarkActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void updatePreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091b16);
            View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0156, (ViewGroup) linearLayout, false);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.removeAllViews();
            linearLayout.addView(inflate);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.searchbox.crius.debug.DebugCriusBenchmarkActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            CriusLoader.init(this);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002d);
            updatePreview();
            ((Button) findViewById(R.id.obfuscated_res_0x7f0903fe)).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.crius.debug.DebugCriusBenchmarkActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugCriusBenchmarkActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.startBenchmark();
                    }
                }
            });
            Spinner spinner = (Spinner) findViewById(R.id.obfuscated_res_0x7f090359);
            spinner.setAdapter((SpinnerAdapter) new ArrayAdapter((Context) this, 17367048, (Object[]) new String[]{"inflate", "measure", TtmlNode.TAG_LAYOUT}));
            spinner.setOnItemSelectedListener(this);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (i == 0) {
                this.mBenchmarkWhich = 1;
            } else if (i == 1) {
                this.mBenchmarkWhich = 2;
            } else if (i != 2) {
                this.mBenchmarkWhich = 1;
            } else {
                this.mBenchmarkWhich = 3;
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adapterView) == null) {
            this.mBenchmarkWhich = 1;
        }
    }
}
