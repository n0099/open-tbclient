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
    private int KA;
    private int Ky;
    private int Kz;
    private WheelView aHV;
    private WheelView aHW;
    private WheelView aHX;
    private b aHY;
    private Date aHZ;
    private Date aIa;
    private int aIb;
    private int aIc;
    private int aId;
    private int aIe;
    private int aIf;
    private int aIg;
    private int aIh;
    private String aIi;
    private boolean aIj;
    private int aIk;
    private BdGallery.c aIl;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdDatePicker bdDatePicker, int i, int i2, int i3);
    }

    public BdDatePicker(Context context) {
        super(context);
        this.Ky = 1900;
        this.Kz = 1;
        this.KA = 1;
        this.aIb = 1900;
        this.aIc = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aId = 1;
        this.aIe = 12;
        this.aIf = 31;
        this.aIg = 1;
        this.aIh = this.aIf;
        this.aIk = 12;
        this.aIl = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aHV) {
                    if (bdGallery != BdDatePicker.this.aHW) {
                        if (bdGallery == BdDatePicker.this.aHX) {
                            BdDatePicker.this.KA = (int) (selectedItemPosition + BdDatePicker.this.aIg);
                        }
                    } else {
                        BdDatePicker.this.Kz = (int) (selectedItemPosition + BdDatePicker.this.aId);
                        BdDatePicker.this.JR();
                    }
                } else {
                    BdDatePicker.this.Ky = (int) (selectedItemPosition + BdDatePicker.this.aIb);
                    BdDatePicker.this.JQ();
                    BdDatePicker.this.JR();
                }
                if (BdDatePicker.this.aHY != null) {
                    BdDatePicker.this.aHY.a(BdDatePicker.this, BdDatePicker.this.Ky, BdDatePicker.this.Kz, BdDatePicker.this.KA);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ky = 1900;
        this.Kz = 1;
        this.KA = 1;
        this.aIb = 1900;
        this.aIc = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aId = 1;
        this.aIe = 12;
        this.aIf = 31;
        this.aIg = 1;
        this.aIh = this.aIf;
        this.aIk = 12;
        this.aIl = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aHV) {
                    if (bdGallery != BdDatePicker.this.aHW) {
                        if (bdGallery == BdDatePicker.this.aHX) {
                            BdDatePicker.this.KA = (int) (selectedItemPosition + BdDatePicker.this.aIg);
                        }
                    } else {
                        BdDatePicker.this.Kz = (int) (selectedItemPosition + BdDatePicker.this.aId);
                        BdDatePicker.this.JR();
                    }
                } else {
                    BdDatePicker.this.Ky = (int) (selectedItemPosition + BdDatePicker.this.aIb);
                    BdDatePicker.this.JQ();
                    BdDatePicker.this.JR();
                }
                if (BdDatePicker.this.aHY != null) {
                    BdDatePicker.this.aHY.a(BdDatePicker.this, BdDatePicker.this.Ky, BdDatePicker.this.Kz, BdDatePicker.this.KA);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ky = 1900;
        this.Kz = 1;
        this.KA = 1;
        this.aIb = 1900;
        this.aIc = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aId = 1;
        this.aIe = 12;
        this.aIf = 31;
        this.aIg = 1;
        this.aIh = this.aIf;
        this.aIk = 12;
        this.aIl = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aHV) {
                    if (bdGallery != BdDatePicker.this.aHW) {
                        if (bdGallery == BdDatePicker.this.aHX) {
                            BdDatePicker.this.KA = (int) (selectedItemPosition + BdDatePicker.this.aIg);
                        }
                    } else {
                        BdDatePicker.this.Kz = (int) (selectedItemPosition + BdDatePicker.this.aId);
                        BdDatePicker.this.JR();
                    }
                } else {
                    BdDatePicker.this.Ky = (int) (selectedItemPosition + BdDatePicker.this.aIb);
                    BdDatePicker.this.JQ();
                    BdDatePicker.this.JR();
                }
                if (BdDatePicker.this.aHY != null) {
                    BdDatePicker.this.aHY.a(BdDatePicker.this, BdDatePicker.this.Ky, BdDatePicker.this.Kz, BdDatePicker.this.KA);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.aIk = z.dip2px(context, this.aIk);
        this.aHV = (WheelView) findViewById(a.f.wheel_year);
        this.aHV.setOnEndFlingListener(this.aIl);
        this.aHV.setAdapter((SpinnerAdapter) new a(context));
        this.aHV.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aHV.setSpacing(this.aIk);
        this.aHW = (WheelView) findViewById(a.f.wheel_month);
        this.aHW.setOnEndFlingListener(this.aIl);
        this.aHW.setAdapter((SpinnerAdapter) new a(context));
        this.aHW.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aHW.setSpacing(this.aIk);
        this.aHX = (WheelView) findViewById(a.f.wheel_day);
        this.aHX.setOnEndFlingListener(this.aIl);
        this.aHX.setAdapter((SpinnerAdapter) new a(context));
        this.aHX.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aHX.setSpacing(this.aIk);
        JN();
    }

    private void JN() {
        Calendar calendar = Calendar.getInstance();
        this.Ky = calendar.get(1);
        this.Kz = calendar.get(2) + 1;
        this.KA = calendar.get(5);
        JO();
    }

    public void JO() {
        JP();
        JQ();
        JR();
    }

    private void JP() {
        if (this.Ky < this.aIb || this.Ky > this.aIc) {
            this.Ky = this.aIb;
        }
        int i = (this.aIc - this.aIb) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(a.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.aIb + i2)));
        }
        ((a) this.aHV.getAdapter()).setData(arrayList);
    }

    public void JQ() {
        this.aId = 1;
        this.aIe = 12;
        if (this.aHZ != null && this.Ky == this.aIb) {
            this.aId = this.aHZ.getMonth() + 1;
        }
        if (this.aIa != null && this.Ky == this.aIc) {
            this.aIe = this.aIa.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aIe - this.aId) + 1);
        String string = getContext().getString(a.h.date_picker_month);
        for (int i = this.aId; i <= this.aIe; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aHW.getAdapter()).setData(arrayList);
        setMonth(this.Kz);
        this.aHW.invalidate();
    }

    public void JR() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.Kz) >= 0) {
            this.aIf = 31;
        } else if (Arrays.binarySearch(iArr, this.Kz) >= 0) {
            this.aIf = 30;
        } else if ((this.Ky % 4 == 0 && this.Ky % 100 != 0) || this.Ky % 400 == 0) {
            this.aIf = 29;
        } else {
            this.aIf = 28;
        }
        this.aIg = 1;
        this.aIh = this.aIf;
        if (this.aHZ != null && this.Ky == this.aIb && this.Kz == this.aHZ.getMonth() + 1) {
            this.aIg = this.aHZ.getDate();
        }
        if (this.aIa != null && this.Ky == this.aIc && this.Kz == this.aIa.getMonth() + 1) {
            this.aIh = this.aIa.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aIh - this.aIg) + 1);
        String string = getContext().getString(a.h.date_picker_day);
        for (int i = this.aIg; i <= this.aIh; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aHX.getAdapter()).setData(arrayList);
        setDay(this.KA);
        this.aHX.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.aHY = bVar;
    }

    public void setYear(int i) {
        if (i < this.aIb) {
            i = this.aIb;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aIb + " and " + this.aIc).LS();
            }
        } else if (i > this.aIc) {
            i = this.aIc;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aIb + " and " + this.aIc).LQ();
            }
        }
        this.Ky = i;
        this.aHV.setSelection(this.Ky - this.aIb);
    }

    public int getYear() {
        return this.Ky;
    }

    public void setMonth(int i) {
        if (i < this.aId) {
            i = this.aId;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aId + " and " + this.aIe).LS();
            }
        } else if (i > this.aIe) {
            i = this.aIe;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aId + " and " + this.aIe).LQ();
            }
        }
        this.Kz = i;
        this.aHW.setSelection(this.Kz - this.aId);
    }

    public int getMonth() {
        return this.Kz;
    }

    public void setDay(int i) {
        if (i < this.aIg || i > this.aIh) {
            i = this.aIg;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aIg + " and " + this.aIh).LQ();
            }
        } else if (i > this.aIh) {
            i = this.aIh;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aIg + " and " + this.aIh).LS();
            }
        }
        this.KA = i;
        this.aHX.setSelection(this.KA - this.aIg);
    }

    public int getDay() {
        return this.KA;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.aHV.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.aHW.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.aHX.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.aHZ = date;
            this.aIb = this.aHZ.getYear() + 1900;
            return;
        }
        this.aIb = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.aIa = date;
            this.aIc = this.aIa.getYear() + 1900;
            return;
        }
        this.aIc = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.aIi = str;
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
                    this.aHW.setVisibility(8);
                    this.aHX.setVisibility(8);
                    return;
                case 1:
                    this.aHW.setVisibility(0);
                    this.aHX.setVisibility(8);
                    return;
                default:
                    this.aHW.setVisibility(0);
                    this.aHX.setVisibility(0);
                    return;
            }
        }
    }

    public boolean gu(String str) {
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
                wheelView = this.aHV;
                break;
            case 1:
                wheelView = this.aHW;
                break;
            case 2:
                wheelView = this.aHX;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.aIj = z;
        this.aHV.setDisableScrollAnyway(z);
        this.aHW.setDisableScrollAnyway(z);
        this.aHX.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.aHW.setScrollCycle(z);
        this.aHV.setScrollCycle(z);
        this.aHX.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aIo;
        private Context mContext;
        private ArrayList<String> aIn = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.aIo = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.aIo = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
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
            textView2.setTextColor(this.aIo);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aIn.get(i));
        }
    }
}
