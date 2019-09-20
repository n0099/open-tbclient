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
    private boolean aIH;
    private int aII;
    private int aIY;
    private WheelView aIZ;
    private Date aIx;
    private Date aIy;
    private WheelView aJa;
    private a aJb;
    private LinearLayout aJc;
    private int aJd;
    private int aJe;
    private int aJf;
    private int aJg;
    private BdAdapterView.f aJh;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.aIY = 0;
        this.KC = 0;
        this.aII = 12;
        this.aJh = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aIZ) {
                    if (bdAdapterView == BdTimePicker.this.aJa) {
                        BdTimePicker.this.KC = BdTimePicker.this.aJf + i;
                    }
                } else {
                    BdTimePicker.this.aIY = BdTimePicker.this.aJd + i;
                    BdTimePicker.this.JY();
                }
                if (BdTimePicker.this.aJb != null) {
                    BdTimePicker.this.aJb.a(BdTimePicker.this, BdTimePicker.this.aIY, BdTimePicker.this.KC);
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
        this.aIY = 0;
        this.KC = 0;
        this.aII = 12;
        this.aJh = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aIZ) {
                    if (bdAdapterView == BdTimePicker.this.aJa) {
                        BdTimePicker.this.KC = BdTimePicker.this.aJf + i;
                    }
                } else {
                    BdTimePicker.this.aIY = BdTimePicker.this.aJd + i;
                    BdTimePicker.this.JY();
                }
                if (BdTimePicker.this.aJb != null) {
                    BdTimePicker.this.aJb.a(BdTimePicker.this, BdTimePicker.this.aIY, BdTimePicker.this.KC);
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
        this.aIY = 0;
        this.KC = 0;
        this.aII = 12;
        this.aJh = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.aIZ) {
                    if (bdAdapterView == BdTimePicker.this.aJa) {
                        BdTimePicker.this.KC = BdTimePicker.this.aJf + i2;
                    }
                } else {
                    BdTimePicker.this.aIY = BdTimePicker.this.aJd + i2;
                    BdTimePicker.this.JY();
                }
                if (BdTimePicker.this.aJb != null) {
                    BdTimePicker.this.aJb.a(BdTimePicker.this, BdTimePicker.this.aIY, BdTimePicker.this.KC);
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
        this.aII = z.dip2px(context, this.aII);
        this.aJc = (LinearLayout) findViewById(a.f.timepicker_root);
        this.aIZ = (WheelView) findViewById(a.f.wheel_hour);
        this.aIZ.setOnItemSelectedListener(this.aJh);
        this.aIZ.setAdapter((SpinnerAdapter) new b(context));
        this.aIZ.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aIZ.setSpacing(this.aII);
        this.aJa = (WheelView) findViewById(a.f.wheel_minute);
        this.aJa.setOnItemSelectedListener(this.aJh);
        this.aJa.setAdapter((SpinnerAdapter) new b(context));
        this.aJa.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aJa.setSpacing(this.aII);
        JR();
    }

    private void JR() {
        Calendar calendar = Calendar.getInstance();
        this.aIY = calendar.get(11);
        this.KC = calendar.get(12);
        JS();
    }

    public void JS() {
        JZ();
        JY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JY() {
        this.aJf = 0;
        this.aJg = 59;
        if (this.aIx != null && this.aIY == this.aJd) {
            this.aJf = this.aIx.getMinutes();
        }
        if (this.aIy != null && this.aIY == this.aJe) {
            this.aJg = this.aIy.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aJg - this.aJf) + 1);
        for (int i = this.aJf; i <= this.aJg; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aJa.getAdapter()).setData(arrayList);
        setMinute(this.KC);
    }

    private void JZ() {
        this.aJd = 0;
        this.aJe = 23;
        if (this.aIx != null) {
            this.aJd = this.aIx.getHours();
        }
        if (this.aIy != null) {
            this.aJe = this.aIy.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aJe - this.aJd) + 1);
        for (int i = this.aJd; i <= this.aJe; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aIZ.getAdapter()).setData(arrayList);
        setHour(this.aIY);
    }

    public void setStartDate(Date date) {
        this.aIx = date;
    }

    public void setmEndDate(Date date) {
        this.aIy = date;
    }

    public void setDisabled(boolean z) {
        this.aIH = z;
        this.aIZ.setDisableScrollAnyway(z);
        this.aJa.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.aJb = aVar;
    }

    public void setHour(int i) {
        if (i < this.aJd) {
            i = this.aJd;
        } else if (i > this.aJe) {
            i = this.aJe;
        }
        this.aIY = i;
        this.aIZ.setSelection(i - this.aJd);
    }

    public int getHour() {
        return this.aIY;
    }

    public void setMinute(int i) {
        if (i < this.aJf) {
            i = this.aJf;
        } else if (i > this.aJg) {
            i = this.aJg;
        }
        this.KC = i;
        this.aJa.setSelection(i - this.aJf);
    }

    public int getMinute() {
        return this.KC;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.aIZ.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.aJa.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.aJa.setScrollCycle(z);
        this.aIZ.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> aIL = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = z.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.aIL = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aIL != null) {
                return this.aIL.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.aIL != null) {
                return this.aIL.get(i);
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
            ((TextView) view).setText(this.aIL.get(i));
        }
    }
}
