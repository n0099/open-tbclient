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
    private int Kq;
    private boolean aHB;
    private int aHC;
    private int aHS;
    private WheelView aHT;
    private WheelView aHU;
    private a aHV;
    private LinearLayout aHW;
    private int aHX;
    private int aHY;
    private int aHZ;
    private Date aHr;
    private Date aHs;
    private int aIa;
    private BdAdapterView.f aIb;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.aHS = 0;
        this.Kq = 0;
        this.aHC = 12;
        this.aIb = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aHT) {
                    if (bdAdapterView == BdTimePicker.this.aHU) {
                        BdTimePicker.this.Kq = BdTimePicker.this.aHZ + i;
                    }
                } else {
                    BdTimePicker.this.aHS = BdTimePicker.this.aHX + i;
                    BdTimePicker.this.Jh();
                }
                if (BdTimePicker.this.aHV != null) {
                    BdTimePicker.this.aHV.a(BdTimePicker.this, BdTimePicker.this.aHS, BdTimePicker.this.Kq);
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
        this.aHS = 0;
        this.Kq = 0;
        this.aHC = 12;
        this.aIb = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aHT) {
                    if (bdAdapterView == BdTimePicker.this.aHU) {
                        BdTimePicker.this.Kq = BdTimePicker.this.aHZ + i;
                    }
                } else {
                    BdTimePicker.this.aHS = BdTimePicker.this.aHX + i;
                    BdTimePicker.this.Jh();
                }
                if (BdTimePicker.this.aHV != null) {
                    BdTimePicker.this.aHV.a(BdTimePicker.this, BdTimePicker.this.aHS, BdTimePicker.this.Kq);
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
        this.aHS = 0;
        this.Kq = 0;
        this.aHC = 12;
        this.aIb = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.aHT) {
                    if (bdAdapterView == BdTimePicker.this.aHU) {
                        BdTimePicker.this.Kq = BdTimePicker.this.aHZ + i2;
                    }
                } else {
                    BdTimePicker.this.aHS = BdTimePicker.this.aHX + i2;
                    BdTimePicker.this.Jh();
                }
                if (BdTimePicker.this.aHV != null) {
                    BdTimePicker.this.aHV.a(BdTimePicker.this, BdTimePicker.this.aHS, BdTimePicker.this.Kq);
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
        this.aHC = z.dip2px(context, this.aHC);
        this.aHW = (LinearLayout) findViewById(a.f.timepicker_root);
        this.aHT = (WheelView) findViewById(a.f.wheel_hour);
        this.aHT.setOnItemSelectedListener(this.aIb);
        this.aHT.setAdapter((SpinnerAdapter) new b(context));
        this.aHT.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aHT.setSpacing(this.aHC);
        this.aHU = (WheelView) findViewById(a.f.wheel_minute);
        this.aHU.setOnItemSelectedListener(this.aIb);
        this.aHU.setAdapter((SpinnerAdapter) new b(context));
        this.aHU.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aHU.setSpacing(this.aHC);
        Ja();
    }

    private void Ja() {
        Calendar calendar = Calendar.getInstance();
        this.aHS = calendar.get(11);
        this.Kq = calendar.get(12);
        Jb();
    }

    public void Jb() {
        Ji();
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        this.aHZ = 0;
        this.aIa = 59;
        if (this.aHr != null && this.aHS == this.aHX) {
            this.aHZ = this.aHr.getMinutes();
        }
        if (this.aHs != null && this.aHS == this.aHY) {
            this.aIa = this.aHs.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aIa - this.aHZ) + 1);
        for (int i = this.aHZ; i <= this.aIa; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aHU.getAdapter()).setData(arrayList);
        setMinute(this.Kq);
    }

    private void Ji() {
        this.aHX = 0;
        this.aHY = 23;
        if (this.aHr != null) {
            this.aHX = this.aHr.getHours();
        }
        if (this.aHs != null) {
            this.aHY = this.aHs.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aHY - this.aHX) + 1);
        for (int i = this.aHX; i <= this.aHY; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aHT.getAdapter()).setData(arrayList);
        setHour(this.aHS);
    }

    public void setStartDate(Date date) {
        this.aHr = date;
    }

    public void setmEndDate(Date date) {
        this.aHs = date;
    }

    public void setDisabled(boolean z) {
        this.aHB = z;
        this.aHT.setDisableScrollAnyway(z);
        this.aHU.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.aHV = aVar;
    }

    public void setHour(int i) {
        if (i < this.aHX) {
            i = this.aHX;
        } else if (i > this.aHY) {
            i = this.aHY;
        }
        this.aHS = i;
        this.aHT.setSelection(i - this.aHX);
    }

    public int getHour() {
        return this.aHS;
    }

    public void setMinute(int i) {
        if (i < this.aHZ) {
            i = this.aHZ;
        } else if (i > this.aIa) {
            i = this.aIa;
        }
        this.Kq = i;
        this.aHU.setSelection(i - this.aHZ);
    }

    public int getMinute() {
        return this.Kq;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.aHT.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.aHU.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.aHU.setScrollCycle(z);
        this.aHT.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> aHF = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = z.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.aHF = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aHF != null) {
                return this.aHF.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.aHF != null) {
                return this.aHF.get(i);
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
            textView2.setTextColor(context.getResources().getColor(a.c.aiapps_data_picker_color));
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aHF.get(i));
        }
    }
}
