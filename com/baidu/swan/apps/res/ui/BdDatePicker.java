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
    private int aIA;
    private int aIB;
    private int aIC;
    private int aID;
    private int aIE;
    private int aIF;
    private String aIG;
    private boolean aIH;
    private int aII;
    private BdGallery.c aIJ;
    private WheelView aIt;
    private WheelView aIu;
    private WheelView aIv;
    private b aIw;
    private Date aIx;
    private Date aIy;
    private int aIz;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdDatePicker bdDatePicker, int i, int i2, int i3);
    }

    public BdDatePicker(Context context) {
        super(context);
        this.Ky = 1900;
        this.Kz = 1;
        this.KA = 1;
        this.aIz = 1900;
        this.aIA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aIB = 1;
        this.aIC = 12;
        this.aID = 31;
        this.aIE = 1;
        this.aIF = this.aID;
        this.aII = 12;
        this.aIJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aIt) {
                    if (bdGallery != BdDatePicker.this.aIu) {
                        if (bdGallery == BdDatePicker.this.aIv) {
                            BdDatePicker.this.KA = (int) (selectedItemPosition + BdDatePicker.this.aIE);
                        }
                    } else {
                        BdDatePicker.this.Kz = (int) (selectedItemPosition + BdDatePicker.this.aIB);
                        BdDatePicker.this.JV();
                    }
                } else {
                    BdDatePicker.this.Ky = (int) (selectedItemPosition + BdDatePicker.this.aIz);
                    BdDatePicker.this.JU();
                    BdDatePicker.this.JV();
                }
                if (BdDatePicker.this.aIw != null) {
                    BdDatePicker.this.aIw.a(BdDatePicker.this, BdDatePicker.this.Ky, BdDatePicker.this.Kz, BdDatePicker.this.KA);
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
        this.aIz = 1900;
        this.aIA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aIB = 1;
        this.aIC = 12;
        this.aID = 31;
        this.aIE = 1;
        this.aIF = this.aID;
        this.aII = 12;
        this.aIJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aIt) {
                    if (bdGallery != BdDatePicker.this.aIu) {
                        if (bdGallery == BdDatePicker.this.aIv) {
                            BdDatePicker.this.KA = (int) (selectedItemPosition + BdDatePicker.this.aIE);
                        }
                    } else {
                        BdDatePicker.this.Kz = (int) (selectedItemPosition + BdDatePicker.this.aIB);
                        BdDatePicker.this.JV();
                    }
                } else {
                    BdDatePicker.this.Ky = (int) (selectedItemPosition + BdDatePicker.this.aIz);
                    BdDatePicker.this.JU();
                    BdDatePicker.this.JV();
                }
                if (BdDatePicker.this.aIw != null) {
                    BdDatePicker.this.aIw.a(BdDatePicker.this, BdDatePicker.this.Ky, BdDatePicker.this.Kz, BdDatePicker.this.KA);
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
        this.aIz = 1900;
        this.aIA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aIB = 1;
        this.aIC = 12;
        this.aID = 31;
        this.aIE = 1;
        this.aIF = this.aID;
        this.aII = 12;
        this.aIJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aIt) {
                    if (bdGallery != BdDatePicker.this.aIu) {
                        if (bdGallery == BdDatePicker.this.aIv) {
                            BdDatePicker.this.KA = (int) (selectedItemPosition + BdDatePicker.this.aIE);
                        }
                    } else {
                        BdDatePicker.this.Kz = (int) (selectedItemPosition + BdDatePicker.this.aIB);
                        BdDatePicker.this.JV();
                    }
                } else {
                    BdDatePicker.this.Ky = (int) (selectedItemPosition + BdDatePicker.this.aIz);
                    BdDatePicker.this.JU();
                    BdDatePicker.this.JV();
                }
                if (BdDatePicker.this.aIw != null) {
                    BdDatePicker.this.aIw.a(BdDatePicker.this, BdDatePicker.this.Ky, BdDatePicker.this.Kz, BdDatePicker.this.KA);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.aII = z.dip2px(context, this.aII);
        this.aIt = (WheelView) findViewById(a.f.wheel_year);
        this.aIt.setOnEndFlingListener(this.aIJ);
        this.aIt.setAdapter((SpinnerAdapter) new a(context));
        this.aIt.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aIt.setSpacing(this.aII);
        this.aIu = (WheelView) findViewById(a.f.wheel_month);
        this.aIu.setOnEndFlingListener(this.aIJ);
        this.aIu.setAdapter((SpinnerAdapter) new a(context));
        this.aIu.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aIu.setSpacing(this.aII);
        this.aIv = (WheelView) findViewById(a.f.wheel_day);
        this.aIv.setOnEndFlingListener(this.aIJ);
        this.aIv.setAdapter((SpinnerAdapter) new a(context));
        this.aIv.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aIv.setSpacing(this.aII);
        JR();
    }

    private void JR() {
        Calendar calendar = Calendar.getInstance();
        this.Ky = calendar.get(1);
        this.Kz = calendar.get(2) + 1;
        this.KA = calendar.get(5);
        JS();
    }

    public void JS() {
        JT();
        JU();
        JV();
    }

    private void JT() {
        if (this.Ky < this.aIz || this.Ky > this.aIA) {
            this.Ky = this.aIz;
        }
        int i = (this.aIA - this.aIz) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(a.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.aIz + i2)));
        }
        ((a) this.aIt.getAdapter()).setData(arrayList);
    }

    public void JU() {
        this.aIB = 1;
        this.aIC = 12;
        if (this.aIx != null && this.Ky == this.aIz) {
            this.aIB = this.aIx.getMonth() + 1;
        }
        if (this.aIy != null && this.Ky == this.aIA) {
            this.aIC = this.aIy.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aIC - this.aIB) + 1);
        String string = getContext().getString(a.h.date_picker_month);
        for (int i = this.aIB; i <= this.aIC; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aIu.getAdapter()).setData(arrayList);
        setMonth(this.Kz);
        this.aIu.invalidate();
    }

    public void JV() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.Kz) >= 0) {
            this.aID = 31;
        } else if (Arrays.binarySearch(iArr, this.Kz) >= 0) {
            this.aID = 30;
        } else if ((this.Ky % 4 == 0 && this.Ky % 100 != 0) || this.Ky % 400 == 0) {
            this.aID = 29;
        } else {
            this.aID = 28;
        }
        this.aIE = 1;
        this.aIF = this.aID;
        if (this.aIx != null && this.Ky == this.aIz && this.Kz == this.aIx.getMonth() + 1) {
            this.aIE = this.aIx.getDate();
        }
        if (this.aIy != null && this.Ky == this.aIA && this.Kz == this.aIy.getMonth() + 1) {
            this.aIF = this.aIy.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aIF - this.aIE) + 1);
        String string = getContext().getString(a.h.date_picker_day);
        for (int i = this.aIE; i <= this.aIF; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aIv.getAdapter()).setData(arrayList);
        setDay(this.KA);
        this.aIv.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.aIw = bVar;
    }

    public void setYear(int i) {
        if (i < this.aIz) {
            i = this.aIz;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aIz + " and " + this.aIA).LW();
            }
        } else if (i > this.aIA) {
            i = this.aIA;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aIz + " and " + this.aIA).LU();
            }
        }
        this.Ky = i;
        this.aIt.setSelection(this.Ky - this.aIz);
    }

    public int getYear() {
        return this.Ky;
    }

    public void setMonth(int i) {
        if (i < this.aIB) {
            i = this.aIB;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aIB + " and " + this.aIC).LW();
            }
        } else if (i > this.aIC) {
            i = this.aIC;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aIB + " and " + this.aIC).LU();
            }
        }
        this.Kz = i;
        this.aIu.setSelection(this.Kz - this.aIB);
    }

    public int getMonth() {
        return this.Kz;
    }

    public void setDay(int i) {
        if (i < this.aIE || i > this.aIF) {
            i = this.aIE;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aIE + " and " + this.aIF).LU();
            }
        } else if (i > this.aIF) {
            i = this.aIF;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aIE + " and " + this.aIF).LW();
            }
        }
        this.KA = i;
        this.aIv.setSelection(this.KA - this.aIE);
    }

    public int getDay() {
        return this.KA;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.aIt.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.aIu.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.aIv.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.aIx = date;
            this.aIz = this.aIx.getYear() + 1900;
            return;
        }
        this.aIz = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.aIy = date;
            this.aIA = this.aIy.getYear() + 1900;
            return;
        }
        this.aIA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.aIG = str;
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
                    this.aIu.setVisibility(8);
                    this.aIv.setVisibility(8);
                    return;
                case 1:
                    this.aIu.setVisibility(0);
                    this.aIv.setVisibility(8);
                    return;
                default:
                    this.aIu.setVisibility(0);
                    this.aIv.setVisibility(0);
                    return;
            }
        }
    }

    public boolean gw(String str) {
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
                wheelView = this.aIt;
                break;
            case 1:
                wheelView = this.aIu;
                break;
            case 2:
                wheelView = this.aIv;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.aIH = z;
        this.aIt.setDisableScrollAnyway(z);
        this.aIu.setDisableScrollAnyway(z);
        this.aIv.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.aIu.setScrollCycle(z);
        this.aIt.setScrollCycle(z);
        this.aIv.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aIM;
        private Context mContext;
        private ArrayList<String> aIL = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.aIM = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.aIM = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
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
            textView2.setTextColor(this.aIM);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aIL.get(i));
        }
    }
}
