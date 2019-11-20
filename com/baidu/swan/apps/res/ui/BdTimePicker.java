package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.ui.wheelview.BdAdapterView;
import com.baidu.swan.apps.res.ui.wheelview.BdGallery;
import com.baidu.swan.apps.res.ui.wheelview.WheelView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class BdTimePicker extends LinearLayout {
    private boolean bbD;
    private int bbE;
    private int bbU;
    private WheelView bbV;
    private WheelView bbW;
    private a bbX;
    private LinearLayout bbY;
    private int bbZ;
    private Date bbt;
    private Date bbu;
    private int bca;
    private int bcb;
    private int bcc;
    private BdAdapterView.f bcd;
    private int wL;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.bbU = 0;
        this.wL = 0;
        this.bbE = 12;
        this.bcd = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.bbV) {
                    if (bdAdapterView == BdTimePicker.this.bbW) {
                        BdTimePicker.this.wL = BdTimePicker.this.bcb + i;
                    }
                } else {
                    BdTimePicker.this.bbU = BdTimePicker.this.bbZ + i;
                    BdTimePicker.this.OS();
                }
                if (BdTimePicker.this.bbX != null) {
                    BdTimePicker.this.bbX.a(BdTimePicker.this, BdTimePicker.this.bbU, BdTimePicker.this.wL);
                }
            }

            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView) {
            }
        };
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbU = 0;
        this.wL = 0;
        this.bbE = 12;
        this.bcd = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.bbV) {
                    if (bdAdapterView == BdTimePicker.this.bbW) {
                        BdTimePicker.this.wL = BdTimePicker.this.bcb + i;
                    }
                } else {
                    BdTimePicker.this.bbU = BdTimePicker.this.bbZ + i;
                    BdTimePicker.this.OS();
                }
                if (BdTimePicker.this.bbX != null) {
                    BdTimePicker.this.bbX.a(BdTimePicker.this, BdTimePicker.this.bbU, BdTimePicker.this.wL);
                }
            }

            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView) {
            }
        };
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbU = 0;
        this.wL = 0;
        this.bbE = 12;
        this.bcd = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.bbV) {
                    if (bdAdapterView == BdTimePicker.this.bbW) {
                        BdTimePicker.this.wL = BdTimePicker.this.bcb + i2;
                    }
                } else {
                    BdTimePicker.this.bbU = BdTimePicker.this.bbZ + i2;
                    BdTimePicker.this.OS();
                }
                if (BdTimePicker.this.bbX != null) {
                    BdTimePicker.this.bbX.a(BdTimePicker.this, BdTimePicker.this.bbU, BdTimePicker.this.wL);
                }
            }

            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_timepicker_layout, this);
        this.bbE = z.dip2px(context, this.bbE);
        this.bbY = (LinearLayout) findViewById(a.f.timepicker_root);
        this.bbV = (WheelView) findViewById(a.f.wheel_hour);
        this.bbV.setOnItemSelectedListener(this.bcd);
        this.bbV.setAdapter((SpinnerAdapter) new b(context));
        this.bbV.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bbV.setSpacing(this.bbE);
        this.bbW = (WheelView) findViewById(a.f.wheel_minute);
        this.bbW.setOnItemSelectedListener(this.bcd);
        this.bbW.setAdapter((SpinnerAdapter) new b(context));
        this.bbW.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bbW.setSpacing(this.bbE);
        OM();
    }

    private void OM() {
        Calendar calendar = Calendar.getInstance();
        this.bbU = calendar.get(11);
        this.wL = calendar.get(12);
        ON();
    }

    public void ON() {
        OT();
        OS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OS() {
        this.bcb = 0;
        this.bcc = 59;
        if (this.bbt != null && this.bbU == this.bbZ) {
            this.bcb = this.bbt.getMinutes();
        }
        if (this.bbu != null && this.bbU == this.bca) {
            this.bcc = this.bbu.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.bcc - this.bcb) + 1);
        for (int i = this.bcb; i <= this.bcc; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.bbW.getAdapter()).setData(arrayList);
        setMinute(this.wL);
    }

    private void OT() {
        this.bbZ = 0;
        this.bca = 23;
        if (this.bbt != null) {
            this.bbZ = this.bbt.getHours();
        }
        if (this.bbu != null) {
            this.bca = this.bbu.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.bca - this.bbZ) + 1);
        for (int i = this.bbZ; i <= this.bca; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.bbV.getAdapter()).setData(arrayList);
        setHour(this.bbU);
    }

    public void setStartDate(Date date) {
        this.bbt = date;
    }

    public void setmEndDate(Date date) {
        this.bbu = date;
    }

    public void setDisabled(boolean z) {
        this.bbD = z;
        this.bbV.setDisableScrollAnyway(z);
        this.bbW.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bbX = aVar;
    }

    public void setHour(int i) {
        if (i < this.bbZ) {
            i = this.bbZ;
        } else if (i > this.bca) {
            i = this.bca;
        }
        this.bbU = i;
        this.bbV.setSelection(i - this.bbZ);
    }

    public int getHour() {
        return this.bbU;
    }

    public void setMinute(int i) {
        if (i < this.bcb) {
            i = this.bcb;
        } else if (i > this.bcc) {
            i = this.bcc;
        }
        this.wL = i;
        this.bbW.setSelection(i - this.bcb);
    }

    public int getMinute() {
        return this.wL;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.bbV.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.bbW.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.bbW.setScrollCycle(z);
        this.bbV.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> bbH = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = z.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.bbH = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bbH != null) {
                return this.bbH.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.bbH != null) {
                return this.bbH.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = a(this.mContext, i, viewGroup);
            }
            c(i, view);
            return view;
        }

        protected View a(Context context, int i, ViewGroup viewGroup) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new BdGallery.b(this.mWidth, this.mHeight));
            TextView textView2 = textView;
            textView2.setGravity(17);
            textView2.setTextSize(1, 20.0f);
            textView2.setTextColor(context.getResources().getColor(a.c.aiapps_data_picker_color));
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void c(int i, View view) {
            ((TextView) view).setText(this.bbH.get(i));
        }
    }
}
