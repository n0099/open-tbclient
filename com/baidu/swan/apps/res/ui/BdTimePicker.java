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
    private boolean aFH;
    private int aFI;
    private int aFY;
    private WheelView aFZ;
    private Date aFx;
    private Date aFy;
    private WheelView aGa;
    private a aGb;
    private LinearLayout aGc;
    private int aGd;
    private int aGe;
    private int aGf;
    private int aGg;
    private BdAdapterView.f aGh;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.aFY = 0;
        this.MG = 0;
        this.aFI = 12;
        this.aGh = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aFZ) {
                    if (bdAdapterView == BdTimePicker.this.aGa) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGf + i;
                    }
                } else {
                    BdTimePicker.this.aFY = BdTimePicker.this.aGd + i;
                    BdTimePicker.this.GR();
                }
                if (BdTimePicker.this.aGb != null) {
                    BdTimePicker.this.aGb.a(BdTimePicker.this, BdTimePicker.this.aFY, BdTimePicker.this.MG);
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
        this.aFY = 0;
        this.MG = 0;
        this.aFI = 12;
        this.aGh = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.aFZ) {
                    if (bdAdapterView == BdTimePicker.this.aGa) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGf + i;
                    }
                } else {
                    BdTimePicker.this.aFY = BdTimePicker.this.aGd + i;
                    BdTimePicker.this.GR();
                }
                if (BdTimePicker.this.aGb != null) {
                    BdTimePicker.this.aGb.a(BdTimePicker.this, BdTimePicker.this.aFY, BdTimePicker.this.MG);
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
        this.aFY = 0;
        this.MG = 0;
        this.aFI = 12;
        this.aGh = new BdAdapterView.f() { // from class: com.baidu.swan.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView.f
            public void a(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.aFZ) {
                    if (bdAdapterView == BdTimePicker.this.aGa) {
                        BdTimePicker.this.MG = BdTimePicker.this.aGf + i2;
                    }
                } else {
                    BdTimePicker.this.aFY = BdTimePicker.this.aGd + i2;
                    BdTimePicker.this.GR();
                }
                if (BdTimePicker.this.aGb != null) {
                    BdTimePicker.this.aGb.a(BdTimePicker.this, BdTimePicker.this.aFY, BdTimePicker.this.MG);
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
        this.aFI = x.dip2px(context, this.aFI);
        this.aGc = (LinearLayout) findViewById(a.f.timepicker_root);
        this.aFZ = (WheelView) findViewById(a.f.wheel_hour);
        this.aFZ.setOnItemSelectedListener(this.aGh);
        this.aFZ.setAdapter((SpinnerAdapter) new b(context));
        this.aFZ.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFZ.setSpacing(this.aFI);
        this.aGa = (WheelView) findViewById(a.f.wheel_minute);
        this.aGa.setOnItemSelectedListener(this.aGh);
        this.aGa.setAdapter((SpinnerAdapter) new b(context));
        this.aGa.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aGa.setSpacing(this.aFI);
        GK();
    }

    private void GK() {
        Calendar calendar = Calendar.getInstance();
        this.aFY = calendar.get(11);
        this.MG = calendar.get(12);
        GL();
    }

    public void GL() {
        GS();
        GR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GR() {
        this.aGf = 0;
        this.aGg = 59;
        if (this.aFx != null && this.aFY == this.aGd) {
            this.aGf = this.aFx.getMinutes();
        }
        if (this.aFy != null && this.aFY == this.aGe) {
            this.aGg = this.aFy.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aGg - this.aGf) + 1);
        for (int i = this.aGf; i <= this.aGg; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aGa.getAdapter()).setData(arrayList);
        setMinute(this.MG);
    }

    private void GS() {
        this.aGd = 0;
        this.aGe = 23;
        if (this.aFx != null) {
            this.aGd = this.aFx.getHours();
        }
        if (this.aFy != null) {
            this.aGe = this.aFy.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aGe - this.aGd) + 1);
        for (int i = this.aGd; i <= this.aGe; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((b) this.aFZ.getAdapter()).setData(arrayList);
        setHour(this.aFY);
    }

    public void setStartDate(Date date) {
        this.aFx = date;
    }

    public void setmEndDate(Date date) {
        this.aFy = date;
    }

    public void setDisabled(boolean z) {
        this.aFH = z;
        this.aFZ.setDisableScrollAnyway(z);
        this.aGa.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(a aVar) {
        this.aGb = aVar;
    }

    public void setHour(int i) {
        if (i < this.aGd) {
            i = this.aGd;
        } else if (i > this.aGe) {
            i = this.aGe;
        }
        this.aFY = i;
        this.aFZ.setSelection(i - this.aGd);
    }

    public int getHour() {
        return this.aFY;
    }

    public void setMinute(int i) {
        if (i < this.aGf) {
            i = this.aGf;
        } else if (i > this.aGg) {
            i = this.aGg;
        }
        this.MG = i;
        this.aGa.setSelection(i - this.aGf);
    }

    public int getMinute() {
        return this.MG;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFZ.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.aGa.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.aGa.setScrollCycle(z);
        this.aFZ.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> aFL = null;
        private int mWidth = -1;

        public b(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = x.dip2px(context, this.mHeight);
        }

        public void setData(ArrayList<String> arrayList) {
            this.aFL = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aFL != null) {
                return this.aFL.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.aFL != null) {
                return this.aFL.get(i);
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
            ((TextView) view).setText(this.aFL.get(i));
        }
    }
}
