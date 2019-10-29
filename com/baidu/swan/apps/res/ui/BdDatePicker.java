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
    private WheelView bbH;
    private WheelView bbI;
    private WheelView bbJ;
    private b bbK;
    private Date bbL;
    private Date bbM;
    private int bbN;
    private int bbO;
    private int bbP;
    private int bbQ;
    private int bbR;
    private int bbS;
    private int bbT;
    private String bbU;
    private boolean bbV;
    private int bbW;
    private BdGallery.c bbX;
    private int xh;
    private int xi;
    private int xj;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdDatePicker bdDatePicker, int i, int i2, int i3);
    }

    public BdDatePicker(Context context) {
        super(context);
        this.xh = 1900;
        this.xi = 1;
        this.xj = 1;
        this.bbN = 1900;
        this.bbO = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bbP = 1;
        this.bbQ = 12;
        this.bbR = 31;
        this.bbS = 1;
        this.bbT = this.bbR;
        this.bbW = 12;
        this.bbX = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.bbH) {
                    if (bdGallery != BdDatePicker.this.bbI) {
                        if (bdGallery == BdDatePicker.this.bbJ) {
                            BdDatePicker.this.xj = (int) (selectedItemPosition + BdDatePicker.this.bbS);
                        }
                    } else {
                        BdDatePicker.this.xi = (int) (selectedItemPosition + BdDatePicker.this.bbP);
                        BdDatePicker.this.OP();
                    }
                } else {
                    BdDatePicker.this.xh = (int) (selectedItemPosition + BdDatePicker.this.bbN);
                    BdDatePicker.this.OO();
                    BdDatePicker.this.OP();
                }
                if (BdDatePicker.this.bbK != null) {
                    BdDatePicker.this.bbK.a(BdDatePicker.this, BdDatePicker.this.xh, BdDatePicker.this.xi, BdDatePicker.this.xj);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xh = 1900;
        this.xi = 1;
        this.xj = 1;
        this.bbN = 1900;
        this.bbO = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bbP = 1;
        this.bbQ = 12;
        this.bbR = 31;
        this.bbS = 1;
        this.bbT = this.bbR;
        this.bbW = 12;
        this.bbX = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.bbH) {
                    if (bdGallery != BdDatePicker.this.bbI) {
                        if (bdGallery == BdDatePicker.this.bbJ) {
                            BdDatePicker.this.xj = (int) (selectedItemPosition + BdDatePicker.this.bbS);
                        }
                    } else {
                        BdDatePicker.this.xi = (int) (selectedItemPosition + BdDatePicker.this.bbP);
                        BdDatePicker.this.OP();
                    }
                } else {
                    BdDatePicker.this.xh = (int) (selectedItemPosition + BdDatePicker.this.bbN);
                    BdDatePicker.this.OO();
                    BdDatePicker.this.OP();
                }
                if (BdDatePicker.this.bbK != null) {
                    BdDatePicker.this.bbK.a(BdDatePicker.this, BdDatePicker.this.xh, BdDatePicker.this.xi, BdDatePicker.this.xj);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xh = 1900;
        this.xi = 1;
        this.xj = 1;
        this.bbN = 1900;
        this.bbO = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bbP = 1;
        this.bbQ = 12;
        this.bbR = 31;
        this.bbS = 1;
        this.bbT = this.bbR;
        this.bbW = 12;
        this.bbX = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.bbH) {
                    if (bdGallery != BdDatePicker.this.bbI) {
                        if (bdGallery == BdDatePicker.this.bbJ) {
                            BdDatePicker.this.xj = (int) (selectedItemPosition + BdDatePicker.this.bbS);
                        }
                    } else {
                        BdDatePicker.this.xi = (int) (selectedItemPosition + BdDatePicker.this.bbP);
                        BdDatePicker.this.OP();
                    }
                } else {
                    BdDatePicker.this.xh = (int) (selectedItemPosition + BdDatePicker.this.bbN);
                    BdDatePicker.this.OO();
                    BdDatePicker.this.OP();
                }
                if (BdDatePicker.this.bbK != null) {
                    BdDatePicker.this.bbK.a(BdDatePicker.this, BdDatePicker.this.xh, BdDatePicker.this.xi, BdDatePicker.this.xj);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.bbW = z.dip2px(context, this.bbW);
        this.bbH = (WheelView) findViewById(a.f.wheel_year);
        this.bbH.setOnEndFlingListener(this.bbX);
        this.bbH.setAdapter((SpinnerAdapter) new a(context));
        this.bbH.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bbH.setSpacing(this.bbW);
        this.bbI = (WheelView) findViewById(a.f.wheel_month);
        this.bbI.setOnEndFlingListener(this.bbX);
        this.bbI.setAdapter((SpinnerAdapter) new a(context));
        this.bbI.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bbI.setSpacing(this.bbW);
        this.bbJ = (WheelView) findViewById(a.f.wheel_day);
        this.bbJ.setOnEndFlingListener(this.bbX);
        this.bbJ.setAdapter((SpinnerAdapter) new a(context));
        this.bbJ.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bbJ.setSpacing(this.bbW);
        OL();
    }

    private void OL() {
        Calendar calendar = Calendar.getInstance();
        this.xh = calendar.get(1);
        this.xi = calendar.get(2) + 1;
        this.xj = calendar.get(5);
        OM();
    }

    public void OM() {
        ON();
        OO();
        OP();
    }

    private void ON() {
        if (this.xh < this.bbN || this.xh > this.bbO) {
            this.xh = this.bbN;
        }
        int i = (this.bbO - this.bbN) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(a.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.bbN + i2)));
        }
        ((a) this.bbH.getAdapter()).setData(arrayList);
    }

    public void OO() {
        this.bbP = 1;
        this.bbQ = 12;
        if (this.bbL != null && this.xh == this.bbN) {
            this.bbP = this.bbL.getMonth() + 1;
        }
        if (this.bbM != null && this.xh == this.bbO) {
            this.bbQ = this.bbM.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.bbQ - this.bbP) + 1);
        String string = getContext().getString(a.h.date_picker_month);
        for (int i = this.bbP; i <= this.bbQ; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.bbI.getAdapter()).setData(arrayList);
        setMonth(this.xi);
        this.bbI.invalidate();
    }

    public void OP() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.xi) >= 0) {
            this.bbR = 31;
        } else if (Arrays.binarySearch(iArr, this.xi) >= 0) {
            this.bbR = 30;
        } else if ((this.xh % 4 == 0 && this.xh % 100 != 0) || this.xh % 400 == 0) {
            this.bbR = 29;
        } else {
            this.bbR = 28;
        }
        this.bbS = 1;
        this.bbT = this.bbR;
        if (this.bbL != null && this.xh == this.bbN && this.xi == this.bbL.getMonth() + 1) {
            this.bbS = this.bbL.getDate();
        }
        if (this.bbM != null && this.xh == this.bbO && this.xi == this.bbM.getMonth() + 1) {
            this.bbT = this.bbM.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.bbT - this.bbS) + 1);
        String string = getContext().getString(a.h.date_picker_day);
        for (int i = this.bbS; i <= this.bbT; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.bbJ.getAdapter()).setData(arrayList);
        setDay(this.xj);
        this.bbJ.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.bbK = bVar;
    }

    public void setYear(int i) {
        if (i < this.bbN) {
            i = this.bbN;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.bbN + " and " + this.bbO).QP();
            }
        } else if (i > this.bbO) {
            i = this.bbO;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.bbN + " and " + this.bbO).QN();
            }
        }
        this.xh = i;
        this.bbH.setSelection(this.xh - this.bbN);
    }

    public int getYear() {
        return this.xh;
    }

    public void setMonth(int i) {
        if (i < this.bbP) {
            i = this.bbP;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.bbP + " and " + this.bbQ).QP();
            }
        } else if (i > this.bbQ) {
            i = this.bbQ;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.bbP + " and " + this.bbQ).QN();
            }
        }
        this.xi = i;
        this.bbI.setSelection(this.xi - this.bbP);
    }

    public int getMonth() {
        return this.xi;
    }

    public void setDay(int i) {
        if (i < this.bbS || i > this.bbT) {
            i = this.bbS;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.bbS + " and " + this.bbT).QN();
            }
        } else if (i > this.bbT) {
            i = this.bbT;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.bbS + " and " + this.bbT).QP();
            }
        }
        this.xj = i;
        this.bbJ.setSelection(this.xj - this.bbS);
    }

    public int getDay() {
        return this.xj;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.bbH.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.bbI.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.bbJ.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.bbL = date;
            this.bbN = this.bbL.getYear() + 1900;
            return;
        }
        this.bbN = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.bbM = date;
            this.bbO = this.bbM.getYear() + 1900;
            return;
        }
        this.bbO = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.bbU = str;
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
                    this.bbI.setVisibility(8);
                    this.bbJ.setVisibility(8);
                    return;
                case 1:
                    this.bbI.setVisibility(0);
                    this.bbJ.setVisibility(8);
                    return;
                default:
                    this.bbI.setVisibility(0);
                    this.bbJ.setVisibility(0);
                    return;
            }
        }
    }

    public boolean ha(String str) {
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
                wheelView = this.bbH;
                break;
            case 1:
                wheelView = this.bbI;
                break;
            case 2:
                wheelView = this.bbJ;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.bbV = z;
        this.bbH.setDisableScrollAnyway(z);
        this.bbI.setDisableScrollAnyway(z);
        this.bbJ.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.bbI.setScrollCycle(z);
        this.bbH.setScrollCycle(z);
        this.bbJ.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int bca;
        private Context mContext;
        private ArrayList<String> bbZ = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.bca = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.bca = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
        }

        public void setData(ArrayList<String> arrayList) {
            this.bbZ = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bbZ != null) {
                return this.bbZ.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.bbZ != null) {
                return this.bbZ.get(i);
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
            c(i, view);
            return view;
        }

        protected View a(Context context, int i, ViewGroup viewGroup) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new BdGallery.b(this.mWidth, this.mHeight));
            TextView textView2 = textView;
            textView2.setGravity(17);
            textView2.setTextSize(1, 20.0f);
            textView2.setTextColor(this.bca);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void c(int i, View view) {
            ((TextView) view).setText(this.bbZ.get(i));
        }
    }
}
