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
    private boolean aFE;
    private int aFF;
    private int aFV;
    private WheelView aFW;
    private WheelView aFX;
    private a aFY;
    private LinearLayout aFZ;
    private Date aFu;
    private Date aFv;
    private int aGa;
    private int aGb;
    private int aGc;
    private int aGd;
    private BdAdapterView.f aGe;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.aFV = 0;
        this.MG = 0;
        this.aFF = 12;
        this.aGe = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aFW) {
                    if (bdAdapterView == BdTimePicker.this.aFX) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGc + i;
                    }
                } else {
                    BdTimePicker.this.aFV = BdTimePicker.this.aGa + i;
                    BdTimePicker.this.GT();
                }
                if (BdTimePicker.this.aFY != null) {
                    BdTimePicker.this.aFY.a(BdTimePicker.this, BdTimePicker.this.aFV, BdTimePicker.this.MG);
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
        this.aFV = 0;
        this.MG = 0;
        this.aFF = 12;
        this.aGe = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aFW) {
                    if (bdAdapterView == BdTimePicker.this.aFX) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGc + i;
                    }
                } else {
                    BdTimePicker.this.aFV = BdTimePicker.this.aGa + i;
                    BdTimePicker.this.GT();
                }
                if (BdTimePicker.this.aFY != null) {
                    BdTimePicker.this.aFY.a(BdTimePicker.this, BdTimePicker.this.aFV, BdTimePicker.this.MG);
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
        this.aFV = 0;
        this.MG = 0;
        this.aFF = 12;
        this.aGe = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.aFW) {
                    if (bdAdapterView == BdTimePicker.this.aFX) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGc + i2;
                    }
                } else {
                    BdTimePicker.this.aFV = BdTimePicker.this.aGa + i2;
                    BdTimePicker.this.GT();
                }
                if (BdTimePicker.this.aFY != null) {
                    BdTimePicker.this.aFY.a(BdTimePicker.this, BdTimePicker.this.aFV, BdTimePicker.this.MG);
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
        this.aFF = x.dip2px(context, this.aFF);
        this.aFZ = (LinearLayout) findViewById(a.f.timepicker_root);
        this.aFW = (WheelView) findViewById(a.f.wheel_hour);
        this.aFW.setOnItemSelectedListener(this.aGe);
        this.aFW.setAdapter((SpinnerAdapter) new b(context));
        this.aFW.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFW.setSpacing(this.aFF);
        this.aFX = (WheelView) findViewById(a.f.wheel_minute);
        this.aFX.setOnItemSelectedListener(this.aGe);
        this.aFX.setAdapter((SpinnerAdapter) new b(context));
        this.aFX.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFX.setSpacing(this.aFF);
        GM();
    }

    private void GM() {
        Calendar calendar = Calendar.getInstance();
        this.aFV = calendar.get(11);
        this.MG = calendar.get(12);
        GN();
    }

    public void GN() {
        GU();
        GT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GT() {
        this.aGc = 0;
        this.aGd = 59;
        if (this.aFu != null && this.aFV == this.aGa) {
            this.aGc = this.aFu.getMinutes();
        }
        if (this.aFv != null && this.aFV == this.aGb) {
            this.aGd = this.aFv.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aGd - this.aGc) + 1);
        for (int i = this.aGc; i <= this.aGd; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aFX.getAdapter()).setData(arrayList);
        setMinute(this.MG);
    }

    private void GU() {
        this.aGa = 0;
        this.aGb = 23;
        if (this.aFu != null) {
            this.aGa = this.aFu.getHours();
        }
        if (this.aFv != null) {
            this.aGb = this.aFv.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aGb - this.aGa) + 1);
        for (int i = this.aGa; i <= this.aGb; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aFW.getAdapter()).setData(arrayList);
        setHour(this.aFV);
    }

    public void setStartDate(Date date) {
        this.aFu = date;
    }

    public void setmEndDate(Date date) {
        this.aFv = date;
    }

    public void setDisabled(boolean z) {
        this.aFE = z;
        this.aFW.setDisableScrollAnyway(z);
        this.aFX.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.aFY = aVar;
    }

    public void setHour(int i) {
        if (i < this.aGa) {
            i = this.aGa;
        } else if (i > this.aGb) {
            i = this.aGb;
        }
        this.aFV = i;
        this.aFW.setSelection(i - this.aGa);
    }

    public int getHour() {
        return this.aFV;
    }

    public void setMinute(int i) {
        if (i < this.aGc) {
            i = this.aGc;
        } else if (i > this.aGd) {
            i = this.aGd;
        }
        this.MG = i;
        this.aFX.setSelection(i - this.aGc);
    }

    public int getMinute() {
        return this.MG;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFW.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFX.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.aFX.setScrollCycle(z);
        this.aFW.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> aFI = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = x.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.aFI = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aFI != null) {
                return this.aFI.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.aFI != null) {
                return this.aFI.get(i);
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
            ((TextView) view).setText(this.aFI.get(i));
        }
    }
}
