package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.ui.wheelview.BdGallery;
import com.baidu.swan.apps.res.ui.wheelview.WheelView;
import com.baidu.swan.apps.res.widget.b.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG & true;
    private int Kn;
    private int Ko;
    private int Kp;
    private String aHA;
    private boolean aHB;
    private int aHC;
    private BdGallery.c aHD;
    private WheelView aHn;
    private WheelView aHo;
    private WheelView aHp;
    private b aHq;
    private Date aHr;
    private Date aHs;
    private int aHt;
    private int aHu;
    private int aHv;
    private int aHw;
    private int aHx;
    private int aHy;
    private int aHz;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdDatePicker bdDatePicker, int i, int i2, int i3);
    }

    public BdDatePicker(Context context) {
        super(context);
        this.Kn = 1900;
        this.Ko = 1;
        this.Kp = 1;
        this.aHt = 1900;
        this.aHu = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aHv = 1;
        this.aHw = 12;
        this.aHx = 31;
        this.aHy = 1;
        this.aHz = this.aHx;
        this.aHC = 12;
        this.aHD = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aHn) {
                    if (bdGallery != BdDatePicker.this.aHo) {
                        if (bdGallery == BdDatePicker.this.aHp) {
                            BdDatePicker.this.Kp = (int) (selectedItemPosition + BdDatePicker.this.aHy);
                        }
                    } else {
                        BdDatePicker.this.Ko = (int) (selectedItemPosition + BdDatePicker.this.aHv);
                        BdDatePicker.this.Je();
                    }
                } else {
                    BdDatePicker.this.Kn = (int) (selectedItemPosition + BdDatePicker.this.aHt);
                    BdDatePicker.this.Jd();
                    BdDatePicker.this.Je();
                }
                if (BdDatePicker.this.aHq != null) {
                    BdDatePicker.this.aHq.a(BdDatePicker.this, BdDatePicker.this.Kn, BdDatePicker.this.Ko, BdDatePicker.this.Kp);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kn = 1900;
        this.Ko = 1;
        this.Kp = 1;
        this.aHt = 1900;
        this.aHu = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aHv = 1;
        this.aHw = 12;
        this.aHx = 31;
        this.aHy = 1;
        this.aHz = this.aHx;
        this.aHC = 12;
        this.aHD = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aHn) {
                    if (bdGallery != BdDatePicker.this.aHo) {
                        if (bdGallery == BdDatePicker.this.aHp) {
                            BdDatePicker.this.Kp = (int) (selectedItemPosition + BdDatePicker.this.aHy);
                        }
                    } else {
                        BdDatePicker.this.Ko = (int) (selectedItemPosition + BdDatePicker.this.aHv);
                        BdDatePicker.this.Je();
                    }
                } else {
                    BdDatePicker.this.Kn = (int) (selectedItemPosition + BdDatePicker.this.aHt);
                    BdDatePicker.this.Jd();
                    BdDatePicker.this.Je();
                }
                if (BdDatePicker.this.aHq != null) {
                    BdDatePicker.this.aHq.a(BdDatePicker.this, BdDatePicker.this.Kn, BdDatePicker.this.Ko, BdDatePicker.this.Kp);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Kn = 1900;
        this.Ko = 1;
        this.Kp = 1;
        this.aHt = 1900;
        this.aHu = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aHv = 1;
        this.aHw = 12;
        this.aHx = 31;
        this.aHy = 1;
        this.aHz = this.aHx;
        this.aHC = 12;
        this.aHD = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aHn) {
                    if (bdGallery != BdDatePicker.this.aHo) {
                        if (bdGallery == BdDatePicker.this.aHp) {
                            BdDatePicker.this.Kp = (int) (selectedItemPosition + BdDatePicker.this.aHy);
                        }
                    } else {
                        BdDatePicker.this.Ko = (int) (selectedItemPosition + BdDatePicker.this.aHv);
                        BdDatePicker.this.Je();
                    }
                } else {
                    BdDatePicker.this.Kn = (int) (selectedItemPosition + BdDatePicker.this.aHt);
                    BdDatePicker.this.Jd();
                    BdDatePicker.this.Je();
                }
                if (BdDatePicker.this.aHq != null) {
                    BdDatePicker.this.aHq.a(BdDatePicker.this, BdDatePicker.this.Kn, BdDatePicker.this.Ko, BdDatePicker.this.Kp);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.aHC = z.dip2px(context, this.aHC);
        this.aHn = (WheelView) findViewById(a.f.wheel_year);
        this.aHn.setOnEndFlingListener(this.aHD);
        this.aHn.setAdapter((SpinnerAdapter) new a(context));
        this.aHn.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aHn.setSpacing(this.aHC);
        this.aHo = (WheelView) findViewById(a.f.wheel_month);
        this.aHo.setOnEndFlingListener(this.aHD);
        this.aHo.setAdapter((SpinnerAdapter) new a(context));
        this.aHo.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aHo.setSpacing(this.aHC);
        this.aHp = (WheelView) findViewById(a.f.wheel_day);
        this.aHp.setOnEndFlingListener(this.aHD);
        this.aHp.setAdapter((SpinnerAdapter) new a(context));
        this.aHp.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aHp.setSpacing(this.aHC);
        Ja();
    }

    private void Ja() {
        Calendar calendar = Calendar.getInstance();
        this.Kn = calendar.get(1);
        this.Ko = calendar.get(2) + 1;
        this.Kp = calendar.get(5);
        Jb();
    }

    public void Jb() {
        Jc();
        Jd();
        Je();
    }

    private void Jc() {
        if (this.Kn < this.aHt || this.Kn > this.aHu) {
            this.Kn = this.aHt;
        }
        int i = (this.aHu - this.aHt) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(a.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.aHt + i2)));
        }
        ((a) this.aHn.getAdapter()).setData(arrayList);
    }

    public void Jd() {
        this.aHv = 1;
        this.aHw = 12;
        if (this.aHr != null && this.Kn == this.aHt) {
            this.aHv = this.aHr.getMonth() + 1;
        }
        if (this.aHs != null && this.Kn == this.aHu) {
            this.aHw = this.aHs.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aHw - this.aHv) + 1);
        String string = getContext().getString(a.h.date_picker_month);
        for (int i = this.aHv; i <= this.aHw; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aHo.getAdapter()).setData(arrayList);
        setMonth(this.Ko);
        this.aHo.invalidate();
    }

    public void Je() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.Ko) >= 0) {
            this.aHx = 31;
        } else if (Arrays.binarySearch(iArr, this.Ko) >= 0) {
            this.aHx = 30;
        } else if ((this.Kn % 4 == 0 && this.Kn % 100 != 0) || this.Kn % 400 == 0) {
            this.aHx = 29;
        } else {
            this.aHx = 28;
        }
        this.aHy = 1;
        this.aHz = this.aHx;
        if (this.aHr != null && this.Kn == this.aHt && this.Ko == this.aHr.getMonth() + 1) {
            this.aHy = this.aHr.getDate();
        }
        if (this.aHs != null && this.Kn == this.aHu && this.Ko == this.aHs.getMonth() + 1) {
            this.aHz = this.aHs.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aHz - this.aHy) + 1);
        String string = getContext().getString(a.h.date_picker_day);
        for (int i = this.aHy; i <= this.aHz; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aHp.getAdapter()).setData(arrayList);
        setDay(this.Kp);
        this.aHp.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.aHq = bVar;
    }

    public void setYear(int i) {
        if (i < this.aHt) {
            i = this.aHt;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aHt + " and " + this.aHu).Lf();
            }
        } else if (i > this.aHu) {
            i = this.aHu;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aHt + " and " + this.aHu).Ld();
            }
        }
        this.Kn = i;
        this.aHn.setSelection(this.Kn - this.aHt);
    }

    public int getYear() {
        return this.Kn;
    }

    public void setMonth(int i) {
        if (i < this.aHv) {
            i = this.aHv;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aHv + " and " + this.aHw).Lf();
            }
        } else if (i > this.aHw) {
            i = this.aHw;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aHv + " and " + this.aHw).Ld();
            }
        }
        this.Ko = i;
        this.aHo.setSelection(this.Ko - this.aHv);
    }

    public int getMonth() {
        return this.Ko;
    }

    public void setDay(int i) {
        if (i < this.aHy || i > this.aHz) {
            i = this.aHy;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aHy + " and " + this.aHz).Ld();
            }
        } else if (i > this.aHz) {
            i = this.aHz;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aHy + " and " + this.aHz).Lf();
            }
        }
        this.Kp = i;
        this.aHp.setSelection(this.Kp - this.aHy);
    }

    public int getDay() {
        return this.Kp;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.aHn.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.aHo.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.aHp.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.aHr = date;
            this.aHt = this.aHr.getYear() + 1900;
            return;
        }
        this.aHt = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.aHs = date;
            this.aHu = this.aHs.getYear() + 1900;
            return;
        }
        this.aHu = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.aHA = str;
        if (!TextUtils.isEmpty(str)) {
            char c = 65535;
            switch (str.hashCode()) {
                case 3704893:
                    if (str.equals("year")) {
                        c = 0;
                        break;
                    }
                    break;
                case 104080000:
                    if (str.equals("month")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.aHo.setVisibility(8);
                    this.aHp.setVisibility(8);
                    return;
                case 1:
                    this.aHo.setVisibility(0);
                    this.aHp.setVisibility(8);
                    return;
                default:
                    this.aHo.setVisibility(0);
                    this.aHp.setVisibility(0);
                    return;
            }
        }
    }

    public boolean go(String str) {
        WheelView wheelView = null;
        char c = 65535;
        switch (str.hashCode()) {
            case 99228:
                if (str.equals(Config.TRACE_VISIT_RECENT_DAY)) {
                    c = 2;
                    break;
                }
                break;
            case 3704893:
                if (str.equals("year")) {
                    c = 0;
                    break;
                }
                break;
            case 104080000:
                if (str.equals("month")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                wheelView = this.aHn;
                break;
            case 1:
                wheelView = this.aHo;
                break;
            case 2:
                wheelView = this.aHp;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.aHB = z;
        this.aHn.setDisableScrollAnyway(z);
        this.aHo.setDisableScrollAnyway(z);
        this.aHp.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.aHo.setScrollCycle(z);
        this.aHn.setScrollCycle(z);
        this.aHp.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aHG;
        private Context mContext;
        private ArrayList<String> aHF = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.aHG = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.aHG = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
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
            textView2.setTextColor(this.aHG);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aHF.get(i));
        }
    }
}
