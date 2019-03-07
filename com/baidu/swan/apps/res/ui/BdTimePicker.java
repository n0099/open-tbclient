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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.wheelview.BdAdapterView;
import com.baidu.swan.apps.res.ui.wheelview.BdGallery;
import com.baidu.swan.apps.res.ui.wheelview.WheelView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class BdTimePicker extends LinearLayout {
    private int MF;
    private boolean aFD;
    private int aFE;
    private int aFU;
    private WheelView aFV;
    private WheelView aFW;
    private a aFX;
    private LinearLayout aFY;
    private int aFZ;
    private Date aFt;
    private Date aFu;
    private int aGa;
    private int aGb;
    private int aGc;
    private BdAdapterView.f aGd;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.aFU = 0;
        this.MF = 0;
        this.aFE = 12;
        this.aGd = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aFV) {
                    if (bdAdapterView == BdTimePicker.this.aFW) {
                        BdTimePicker.this.MF = BdTimePicker.this.aGb + i;
                    }
                } else {
                    BdTimePicker.this.aFU = BdTimePicker.this.aFZ + i;
                    BdTimePicker.this.GT();
                }
                if (BdTimePicker.this.aFX != null) {
                    BdTimePicker.this.aFX.a(BdTimePicker.this, BdTimePicker.this.aFU, BdTimePicker.this.MF);
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
        this.aFU = 0;
        this.MF = 0;
        this.aFE = 12;
        this.aGd = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aFV) {
                    if (bdAdapterView == BdTimePicker.this.aFW) {
                        BdTimePicker.this.MF = BdTimePicker.this.aGb + i;
                    }
                } else {
                    BdTimePicker.this.aFU = BdTimePicker.this.aFZ + i;
                    BdTimePicker.this.GT();
                }
                if (BdTimePicker.this.aFX != null) {
                    BdTimePicker.this.aFX.a(BdTimePicker.this, BdTimePicker.this.aFU, BdTimePicker.this.MF);
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
        this.aFU = 0;
        this.MF = 0;
        this.aFE = 12;
        this.aGd = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.aFV) {
                    if (bdAdapterView == BdTimePicker.this.aFW) {
                        BdTimePicker.this.MF = BdTimePicker.this.aGb + i2;
                    }
                } else {
                    BdTimePicker.this.aFU = BdTimePicker.this.aFZ + i2;
                    BdTimePicker.this.GT();
                }
                if (BdTimePicker.this.aFX != null) {
                    BdTimePicker.this.aFX.a(BdTimePicker.this, BdTimePicker.this.aFU, BdTimePicker.this.MF);
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
        LayoutInflater.from(context).inflate(b.g.aiapps_timepicker_layout, this);
        this.aFE = x.dip2px(context, this.aFE);
        this.aFY = (LinearLayout) findViewById(b.f.timepicker_root);
        this.aFV = (WheelView) findViewById(b.f.wheel_hour);
        this.aFV.setOnItemSelectedListener(this.aGd);
        this.aFV.setAdapter((SpinnerAdapter) new b(context));
        this.aFV.setSelectorDrawable(getResources().getDrawable(b.c.aiapps_transparent));
        this.aFV.setSpacing(this.aFE);
        this.aFW = (WheelView) findViewById(b.f.wheel_minute);
        this.aFW.setOnItemSelectedListener(this.aGd);
        this.aFW.setAdapter((SpinnerAdapter) new b(context));
        this.aFW.setSelectorDrawable(getResources().getDrawable(b.c.aiapps_transparent));
        this.aFW.setSpacing(this.aFE);
        GM();
    }

    private void GM() {
        Calendar calendar = Calendar.getInstance();
        this.aFU = calendar.get(11);
        this.MF = calendar.get(12);
        GN();
    }

    public void GN() {
        GU();
        GT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GT() {
        this.aGb = 0;
        this.aGc = 59;
        if (this.aFt != null && this.aFU == this.aFZ) {
            this.aGb = this.aFt.getMinutes();
        }
        if (this.aFu != null && this.aFU == this.aGa) {
            this.aGc = this.aFu.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aGc - this.aGb) + 1);
        for (int i = this.aGb; i <= this.aGc; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aFW.getAdapter()).setData(arrayList);
        setMinute(this.MF);
    }

    private void GU() {
        this.aFZ = 0;
        this.aGa = 23;
        if (this.aFt != null) {
            this.aFZ = this.aFt.getHours();
        }
        if (this.aFu != null) {
            this.aGa = this.aFu.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aGa - this.aFZ) + 1);
        for (int i = this.aFZ; i <= this.aGa; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aFV.getAdapter()).setData(arrayList);
        setHour(this.aFU);
    }

    public void setStartDate(Date date) {
        this.aFt = date;
    }

    public void setmEndDate(Date date) {
        this.aFu = date;
    }

    public void setDisabled(boolean z) {
        this.aFD = z;
        this.aFV.setDisableScrollAnyway(z);
        this.aFW.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.aFX = aVar;
    }

    public void setHour(int i) {
        if (i < this.aFZ) {
            i = this.aFZ;
        } else if (i > this.aGa) {
            i = this.aGa;
        }
        this.aFU = i;
        this.aFV.setSelection(i - this.aFZ);
    }

    public int getHour() {
        return this.aFU;
    }

    public void setMinute(int i) {
        if (i < this.aGb) {
            i = this.aGb;
        } else if (i > this.aGc) {
            i = this.aGc;
        }
        this.MF = i;
        this.aFW.setSelection(i - this.aGb);
    }

    public int getMinute() {
        return this.MF;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFV.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFW.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.aFW.setScrollCycle(z);
        this.aFV.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> aFH = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = x.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.aFH = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aFH != null) {
                return this.aFH.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.aFH != null) {
                return this.aFH.get(i);
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
            b(i, view);
            return view;
        }

        protected View a(Context context, int i, ViewGroup viewGroup) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new BdGallery.b(this.mWidth, this.mHeight));
            TextView textView2 = textView;
            textView2.setGravity(17);
            textView2.setTextSize(1, 20.0f);
            textView2.setTextColor(context.getResources().getColor(b.c.aiapps_data_picker_color));
            textView.setBackgroundColor(context.getResources().getColor(b.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aFH.get(i));
        }
    }
}
