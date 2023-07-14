package com.baidu.searchbox.crius.debug;

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
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.crius.CriusLoader;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
/* loaded from: classes3.dex */
public class DebugCriusBenchmarkActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    public static final int BENCHMARK_INFLATE = 1;
    public static final int BENCHMARK_LAYOUT = 3;
    public static final int BENCHMARK_MEASURE = 2;
    public static final int ITERATIONS = 500;
    public int mBenchmarkWhich = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public void startBenchmark() {
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09243c);
        int i = this.mBenchmarkWhich;
        if (i == 1) {
            benchmarkInflate(textView);
        } else if (i == 2) {
            benchmarkMeasure(textView);
        } else {
            benchmarkLayout(textView);
        }
    }

    private void updatePreview() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091f54);
        View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d016f, (ViewGroup) linearLayout, false);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.removeAllViews();
        linearLayout.addView(inflate);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.mBenchmarkWhich = 1;
    }

    private void benchmarkInflate(TextView textView) {
        LayoutInflater from = LayoutInflater.from(this);
        CriusBenchmarkAggregator criusBenchmarkAggregator = new CriusBenchmarkAggregator("Benchmark Inflate");
        CriusBenchmarkAggregator criusBenchmarkAggregator2 = new CriusBenchmarkAggregator("Flatten Inflate");
        for (int i = 0; i < 500; i++) {
            criusBenchmarkAggregator.startTrace();
            from.inflate(R.layout.obfuscated_res_0x7f0d0170, (ViewGroup) null);
            criusBenchmarkAggregator.endTrace();
            criusBenchmarkAggregator2.startTrace();
            from.inflate(R.layout.obfuscated_res_0x7f0d016f, (ViewGroup) null);
            criusBenchmarkAggregator2.endTrace();
        }
        textView.setText(criusBenchmarkAggregator.toString() + "\n" + criusBenchmarkAggregator2.toString());
    }

    private void benchmarkLayout(TextView textView) {
        LayoutInflater from = LayoutInflater.from(this);
        CriusBenchmarkAggregator criusBenchmarkAggregator = new CriusBenchmarkAggregator("Benchmark Layout");
        CriusBenchmarkAggregator criusBenchmarkAggregator2 = new CriusBenchmarkAggregator("Flatten Layout");
        View inflate = from.inflate(R.layout.obfuscated_res_0x7f0d0170, (ViewGroup) null);
        View inflate2 = from.inflate(R.layout.obfuscated_res_0x7f0d016f, (ViewGroup) null);
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

    private void benchmarkMeasure(TextView textView) {
        LayoutInflater from = LayoutInflater.from(this);
        CriusBenchmarkAggregator criusBenchmarkAggregator = new CriusBenchmarkAggregator("Benchmark Measure");
        CriusBenchmarkAggregator criusBenchmarkAggregator2 = new CriusBenchmarkAggregator("Flatten Measure");
        View inflate = from.inflate(R.layout.obfuscated_res_0x7f0d0170, (ViewGroup) null);
        View inflate2 = from.inflate(R.layout.obfuscated_res_0x7f0d016f, (ViewGroup) null);
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

    @Override // com.baidu.searchbox.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        CriusLoader.init(this);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d002d);
        updatePreview();
        ((Button) findViewById(R.id.obfuscated_res_0x7f090490)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.crius.debug.DebugCriusBenchmarkActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DebugCriusBenchmarkActivity.this.startBenchmark();
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.obfuscated_res_0x7f0903d1);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this, 17367048, new String[]{"inflate", "measure", TtmlNode.TAG_LAYOUT}));
        spinner.setOnItemSelectedListener(this);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    this.mBenchmarkWhich = 1;
                    return;
                } else {
                    this.mBenchmarkWhich = 3;
                    return;
                }
            }
            this.mBenchmarkWhich = 2;
            return;
        }
        this.mBenchmarkWhich = 1;
    }
}
