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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.res.ui.wheelview.BdAdapterView;
import com.baidu.swan.apps.res.ui.wheelview.BdGallery;
import com.baidu.swan.apps.res.ui.wheelview.WheelView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class BdTimePicker extends LinearLayout {
    private int MG;
    private boolean aFI;
    private int aFJ;
    private int aFZ;
    private Date aFy;
    private Date aFz;
    private WheelView aGa;
    private WheelView aGb;
    private a aGc;
    private LinearLayout aGd;
    private int aGe;
    private int aGf;
    private int aGg;
    private int aGh;
    private BdAdapterView.f aGi;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.aFZ = 0;
        this.MG = 0;
        this.aFJ = 12;
        this.aGi = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aGa) {
                    if (bdAdapterView == BdTimePicker.this.aGb) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGg + i;
                    }
                } else {
                    BdTimePicker.this.aFZ = BdTimePicker.this.aGe + i;
                    BdTimePicker.this.GR();
                }
                if (BdTimePicker.this.aGc != null) {
                    BdTimePicker.this.aGc.a(BdTimePicker.this, BdTimePicker.this.aFZ, BdTimePicker.this.MG);
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
        this.aFZ = 0;
        this.MG = 0;
        this.aFJ = 12;
        this.aGi = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aGa) {
                    if (bdAdapterView == BdTimePicker.this.aGb) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGg + i;
                    }
                } else {
                    BdTimePicker.this.aFZ = BdTimePicker.this.aGe + i;
                    BdTimePicker.this.GR();
                }
                if (BdTimePicker.this.aGc != null) {
                    BdTimePicker.this.aGc.a(BdTimePicker.this, BdTimePicker.this.aFZ, BdTimePicker.this.MG);
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
        this.aFZ = 0;
        this.MG = 0;
        this.aFJ = 12;
        this.aGi = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.aGa) {
                    if (bdAdapterView == BdTimePicker.this.aGb) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGg + i2;
                    }
                } else {
                    BdTimePicker.this.aFZ = BdTimePicker.this.aGe + i2;
                    BdTimePicker.this.GR();
                }
                if (BdTimePicker.this.aGc != null) {
                    BdTimePicker.this.aGc.a(BdTimePicker.this, BdTimePicker.this.aFZ, BdTimePicker.this.MG);
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
        this.aFJ = x.dip2px(context, this.aFJ);
        this.aGd = (LinearLayout) findViewById(a.f.timepicker_root);
        this.aGa = (WheelView) findViewById(a.f.wheel_hour);
        this.aGa.setOnItemSelectedListener(this.aGi);
        this.aGa.setAdapter((SpinnerAdapter) new b(context));
        this.aGa.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aGa.setSpacing(this.aFJ);
        this.aGb = (WheelView) findViewById(a.f.wheel_minute);
        this.aGb.setOnItemSelectedListener(this.aGi);
        this.aGb.setAdapter((SpinnerAdapter) new b(context));
        this.aGb.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aGb.setSpacing(this.aFJ);
        GK();
    }

    private void GK() {
        Calendar calendar = Calendar.getInstance();
        this.aFZ = calendar.get(11);
        this.MG = calendar.get(12);
        GL();
    }

    public void GL() {
        GS();
        GR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GR() {
        this.aGg = 0;
        this.aGh = 59;
        if (this.aFy != null && this.aFZ == this.aGe) {
            this.aGg = this.aFy.getMinutes();
        }
        if (this.aFz != null && this.aFZ == this.aGf) {
            this.aGh = this.aFz.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aGh - this.aGg) + 1);
        for (int i = this.aGg; i <= this.aGh; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aGb.getAdapter()).setData(arrayList);
        setMinute(this.MG);
    }

    private void GS() {
        this.aGe = 0;
        this.aGf = 23;
        if (this.aFy != null) {
            this.aGe = this.aFy.getHours();
        }
        if (this.aFz != null) {
            this.aGf = this.aFz.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aGf - this.aGe) + 1);
        for (int i = this.aGe; i <= this.aGf; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aGa.getAdapter()).setData(arrayList);
        setHour(this.aFZ);
    }

    public void setStartDate(Date date) {
        this.aFy = date;
    }

    public void setmEndDate(Date date) {
        this.aFz = date;
    }

    public void setDisabled(boolean z) {
        this.aFI = z;
        this.aGa.setDisableScrollAnyway(z);
        this.aGb.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.aGc = aVar;
    }

    public void setHour(int i) {
        if (i < this.aGe) {
            i = this.aGe;
        } else if (i > this.aGf) {
            i = this.aGf;
        }
        this.aFZ = i;
        this.aGa.setSelection(i - this.aGe);
    }

    public int getHour() {
        return this.aFZ;
    }

    public void setMinute(int i) {
        if (i < this.aGg) {
            i = this.aGg;
        } else if (i > this.aGh) {
            i = this.aGh;
        }
        this.MG = i;
        this.aGb.setSelection(i - this.aGg);
    }

    public int getMinute() {
        return this.MG;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.aGa.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.aGb.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.aGb.setScrollCycle(z);
        this.aGa.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> aFM = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = x.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.aFM = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aFM != null) {
                return this.aFM.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.aFM != null) {
                return this.aFM.get(i);
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
            ((TextView) view).setText(this.aFM.get(i));
        }
    }
}
