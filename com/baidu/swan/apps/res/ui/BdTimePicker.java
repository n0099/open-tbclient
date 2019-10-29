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
    private Date bbL;
    private Date bbM;
    private boolean bbV;
    private int bbW;
    private int bcm;
    private WheelView bcn;
    private WheelView bco;
    private a bcp;
    private LinearLayout bcq;
    private int bcr;
    private int bcs;
    private int bct;
    private int bcu;
    private BdAdapterView.f bcv;
    private int xl;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.bcm = 0;
        this.xl = 0;
        this.bbW = 12;
        this.bcv = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.bcn) {
                    if (bdAdapterView == BdTimePicker.this.bco) {
                        BdTimePicker.this.xl = BdTimePicker.this.bct + i;
                    }
                } else {
                    BdTimePicker.this.bcm = BdTimePicker.this.bcr + i;
                    BdTimePicker.this.OR();
                }
                if (BdTimePicker.this.bcp != null) {
                    BdTimePicker.this.bcp.a(BdTimePicker.this, BdTimePicker.this.bcm, BdTimePicker.this.xl);
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
        this.bcm = 0;
        this.xl = 0;
        this.bbW = 12;
        this.bcv = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.bcn) {
                    if (bdAdapterView == BdTimePicker.this.bco) {
                        BdTimePicker.this.xl = BdTimePicker.this.bct + i;
                    }
                } else {
                    BdTimePicker.this.bcm = BdTimePicker.this.bcr + i;
                    BdTimePicker.this.OR();
                }
                if (BdTimePicker.this.bcp != null) {
                    BdTimePicker.this.bcp.a(BdTimePicker.this, BdTimePicker.this.bcm, BdTimePicker.this.xl);
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
        this.bcm = 0;
        this.xl = 0;
        this.bbW = 12;
        this.bcv = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.bcn) {
                    if (bdAdapterView == BdTimePicker.this.bco) {
                        BdTimePicker.this.xl = BdTimePicker.this.bct + i2;
                    }
                } else {
                    BdTimePicker.this.bcm = BdTimePicker.this.bcr + i2;
                    BdTimePicker.this.OR();
                }
                if (BdTimePicker.this.bcp != null) {
                    BdTimePicker.this.bcp.a(BdTimePicker.this, BdTimePicker.this.bcm, BdTimePicker.this.xl);
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
        this.bbW = z.dip2px(context, this.bbW);
        this.bcq = (LinearLayout) findViewById(a.f.timepicker_root);
        this.bcn = (WheelView) findViewById(a.f.wheel_hour);
        this.bcn.setOnItemSelectedListener(this.bcv);
        this.bcn.setAdapter((SpinnerAdapter) new b(context));
        this.bcn.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bcn.setSpacing(this.bbW);
        this.bco = (WheelView) findViewById(a.f.wheel_minute);
        this.bco.setOnItemSelectedListener(this.bcv);
        this.bco.setAdapter((SpinnerAdapter) new b(context));
        this.bco.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bco.setSpacing(this.bbW);
        OL();
    }

    private void OL() {
        Calendar calendar = Calendar.getInstance();
        this.bcm = calendar.get(11);
        this.xl = calendar.get(12);
        OM();
    }

    public void OM() {
        OS();
        OR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OR() {
        this.bct = 0;
        this.bcu = 59;
        if (this.bbL != null && this.bcm == this.bcr) {
            this.bct = this.bbL.getMinutes();
        }
        if (this.bbM != null && this.bcm == this.bcs) {
            this.bcu = this.bbM.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.bcu - this.bct) + 1);
        for (int i = this.bct; i <= this.bcu; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.bco.getAdapter()).setData(arrayList);
        setMinute(this.xl);
    }

    private void OS() {
        this.bcr = 0;
        this.bcs = 23;
        if (this.bbL != null) {
            this.bcr = this.bbL.getHours();
        }
        if (this.bbM != null) {
            this.bcs = this.bbM.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.bcs - this.bcr) + 1);
        for (int i = this.bcr; i <= this.bcs; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.bcn.getAdapter()).setData(arrayList);
        setHour(this.bcm);
    }

    public void setStartDate(Date date) {
        this.bbL = date;
    }

    public void setmEndDate(Date date) {
        this.bbM = date;
    }

    public void setDisabled(boolean z) {
        this.bbV = z;
        this.bcn.setDisableScrollAnyway(z);
        this.bco.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.bcp = aVar;
    }

    public void setHour(int i) {
        if (i < this.bcr) {
            i = this.bcr;
        } else if (i > this.bcs) {
            i = this.bcs;
        }
        this.bcm = i;
        this.bcn.setSelection(i - this.bcr);
    }

    public int getHour() {
        return this.bcm;
    }

    public void setMinute(int i) {
        if (i < this.bct) {
            i = this.bct;
        } else if (i > this.bcu) {
            i = this.bcu;
        }
        this.xl = i;
        this.bco.setSelection(i - this.bct);
    }

    public int getMinute() {
        return this.xl;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.bcn.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.bco.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.bco.setScrollCycle(z);
        this.bcn.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> bbZ = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = z.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.bbZ = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bbZ != null) {
                return this.bbZ.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.bbZ != null) {
                return this.bbZ.get(i);
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
            ((TextView) view).setText(this.bbZ.get(i));
        }
    }
}
