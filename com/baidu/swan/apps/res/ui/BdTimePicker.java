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
    private int KC;
    private Date aHZ;
    private int aIA;
    private WheelView aIB;
    private WheelView aIC;
    private a aID;
    private LinearLayout aIE;
    private int aIF;
    private int aIG;
    private int aIH;
    private int aII;
    private BdAdapterView.f aIJ;
    private Date aIa;
    private boolean aIj;
    private int aIk;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.aIA = 0;
        this.KC = 0;
        this.aIk = 12;
        this.aIJ = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aIB) {
                    if (bdAdapterView == BdTimePicker.this.aIC) {
                        BdTimePicker.this.KC = BdTimePicker.this.aIH + i;
                    }
                } else {
                    BdTimePicker.this.aIA = BdTimePicker.this.aIF + i;
                    BdTimePicker.this.JU();
                }
                if (BdTimePicker.this.aID != null) {
                    BdTimePicker.this.aID.a(BdTimePicker.this, BdTimePicker.this.aIA, BdTimePicker.this.KC);
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
        this.aIA = 0;
        this.KC = 0;
        this.aIk = 12;
        this.aIJ = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aIB) {
                    if (bdAdapterView == BdTimePicker.this.aIC) {
                        BdTimePicker.this.KC = BdTimePicker.this.aIH + i;
                    }
                } else {
                    BdTimePicker.this.aIA = BdTimePicker.this.aIF + i;
                    BdTimePicker.this.JU();
                }
                if (BdTimePicker.this.aID != null) {
                    BdTimePicker.this.aID.a(BdTimePicker.this, BdTimePicker.this.aIA, BdTimePicker.this.KC);
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
        this.aIA = 0;
        this.KC = 0;
        this.aIk = 12;
        this.aIJ = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.aIB) {
                    if (bdAdapterView == BdTimePicker.this.aIC) {
                        BdTimePicker.this.KC = BdTimePicker.this.aIH + i2;
                    }
                } else {
                    BdTimePicker.this.aIA = BdTimePicker.this.aIF + i2;
                    BdTimePicker.this.JU();
                }
                if (BdTimePicker.this.aID != null) {
                    BdTimePicker.this.aID.a(BdTimePicker.this, BdTimePicker.this.aIA, BdTimePicker.this.KC);
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
        this.aIk = z.dip2px(context, this.aIk);
        this.aIE = (LinearLayout) findViewById(a.f.timepicker_root);
        this.aIB = (WheelView) findViewById(a.f.wheel_hour);
        this.aIB.setOnItemSelectedListener(this.aIJ);
        this.aIB.setAdapter((SpinnerAdapter) new b(context));
        this.aIB.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aIB.setSpacing(this.aIk);
        this.aIC = (WheelView) findViewById(a.f.wheel_minute);
        this.aIC.setOnItemSelectedListener(this.aIJ);
        this.aIC.setAdapter((SpinnerAdapter) new b(context));
        this.aIC.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aIC.setSpacing(this.aIk);
        JN();
    }

    private void JN() {
        Calendar calendar = Calendar.getInstance();
        this.aIA = calendar.get(11);
        this.KC = calendar.get(12);
        JO();
    }

    public void JO() {
        JV();
        JU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        this.aIH = 0;
        this.aII = 59;
        if (this.aHZ != null && this.aIA == this.aIF) {
            this.aIH = this.aHZ.getMinutes();
        }
        if (this.aIa != null && this.aIA == this.aIG) {
            this.aII = this.aIa.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aII - this.aIH) + 1);
        for (int i = this.aIH; i <= this.aII; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aIC.getAdapter()).setData(arrayList);
        setMinute(this.KC);
    }

    private void JV() {
        this.aIF = 0;
        this.aIG = 23;
        if (this.aHZ != null) {
            this.aIF = this.aHZ.getHours();
        }
        if (this.aIa != null) {
            this.aIG = this.aIa.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aIG - this.aIF) + 1);
        for (int i = this.aIF; i <= this.aIG; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aIB.getAdapter()).setData(arrayList);
        setHour(this.aIA);
    }

    public void setStartDate(Date date) {
        this.aHZ = date;
    }

    public void setmEndDate(Date date) {
        this.aIa = date;
    }

    public void setDisabled(boolean z) {
        this.aIj = z;
        this.aIB.setDisableScrollAnyway(z);
        this.aIC.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.aID = aVar;
    }

    public void setHour(int i) {
        if (i < this.aIF) {
            i = this.aIF;
        } else if (i > this.aIG) {
            i = this.aIG;
        }
        this.aIA = i;
        this.aIB.setSelection(i - this.aIF);
    }

    public int getHour() {
        return this.aIA;
    }

    public void setMinute(int i) {
        if (i < this.aIH) {
            i = this.aIH;
        } else if (i > this.aII) {
            i = this.aII;
        }
        this.KC = i;
        this.aIC.setSelection(i - this.aIH);
    }

    public int getMinute() {
        return this.KC;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.aIB.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.aIC.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.aIC.setScrollCycle(z);
        this.aIB.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> aIn = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = z.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.aIn = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aIn != null) {
                return this.aIn.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.aIn != null) {
                return this.aIn.get(i);
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
            ((TextView) view).setText(this.aIn.get(i));
        }
    }
}
