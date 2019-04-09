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
import com.baidu.swan.apps.an.x;
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
    private int MC;
    private int MD;
    private int ME;
    private int aFA;
    private int aFB;
    private int aFC;
    private int aFD;
    private int aFE;
    private int aFF;
    private int aFG;
    private String aFH;
    private boolean aFI;
    private int aFJ;
    private BdGallery.c aFK;
    private WheelView aFu;
    private WheelView aFv;
    private WheelView aFw;
    private b aFx;
    private Date aFy;
    private Date aFz;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdDatePicker bdDatePicker, int i, int i2, int i3);
    }

    public BdDatePicker(Context context) {
        super(context);
        this.MC = 1900;
        this.MD = 1;
        this.ME = 1;
        this.aFA = 1900;
        this.aFB = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFC = 1;
        this.aFD = 12;
        this.aFE = 31;
        this.aFF = 1;
        this.aFG = this.aFE;
        this.aFJ = 12;
        this.aFK = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFu) {
                    if (bdGallery != BdDatePicker.this.aFv) {
                        if (bdGallery == BdDatePicker.this.aFw) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFF);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFC);
                        BdDatePicker.this.GO();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFA);
                    BdDatePicker.this.GN();
                    BdDatePicker.this.GO();
                }
                if (BdDatePicker.this.aFx != null) {
                    BdDatePicker.this.aFx.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MC = 1900;
        this.MD = 1;
        this.ME = 1;
        this.aFA = 1900;
        this.aFB = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFC = 1;
        this.aFD = 12;
        this.aFE = 31;
        this.aFF = 1;
        this.aFG = this.aFE;
        this.aFJ = 12;
        this.aFK = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFu) {
                    if (bdGallery != BdDatePicker.this.aFv) {
                        if (bdGallery == BdDatePicker.this.aFw) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFF);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFC);
                        BdDatePicker.this.GO();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFA);
                    BdDatePicker.this.GN();
                    BdDatePicker.this.GO();
                }
                if (BdDatePicker.this.aFx != null) {
                    BdDatePicker.this.aFx.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MC = 1900;
        this.MD = 1;
        this.ME = 1;
        this.aFA = 1900;
        this.aFB = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFC = 1;
        this.aFD = 12;
        this.aFE = 31;
        this.aFF = 1;
        this.aFG = this.aFE;
        this.aFJ = 12;
        this.aFK = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFu) {
                    if (bdGallery != BdDatePicker.this.aFv) {
                        if (bdGallery == BdDatePicker.this.aFw) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFF);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFC);
                        BdDatePicker.this.GO();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFA);
                    BdDatePicker.this.GN();
                    BdDatePicker.this.GO();
                }
                if (BdDatePicker.this.aFx != null) {
                    BdDatePicker.this.aFx.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.aFJ = x.dip2px(context, this.aFJ);
        this.aFu = (WheelView) findViewById(a.f.wheel_year);
        this.aFu.setOnEndFlingListener(this.aFK);
        this.aFu.setAdapter((SpinnerAdapter) new a(context));
        this.aFu.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFu.setSpacing(this.aFJ);
        this.aFv = (WheelView) findViewById(a.f.wheel_month);
        this.aFv.setOnEndFlingListener(this.aFK);
        this.aFv.setAdapter((SpinnerAdapter) new a(context));
        this.aFv.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFv.setSpacing(this.aFJ);
        this.aFw = (WheelView) findViewById(a.f.wheel_day);
        this.aFw.setOnEndFlingListener(this.aFK);
        this.aFw.setAdapter((SpinnerAdapter) new a(context));
        this.aFw.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFw.setSpacing(this.aFJ);
        GK();
    }

    private void GK() {
        Calendar calendar = Calendar.getInstance();
        this.MC = calendar.get(1);
        this.MD = calendar.get(2) + 1;
        this.ME = calendar.get(5);
        GL();
    }

    public void GL() {
        GM();
        GN();
        GO();
    }

    private void GM() {
        if (this.MC < this.aFA || this.MC > this.aFB) {
            this.MC = this.aFA;
        }
        int i = (this.aFB - this.aFA) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(a.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.aFA + i2)));
        }
        ((a) this.aFu.getAdapter()).setData(arrayList);
    }

    public void GN() {
        this.aFC = 1;
        this.aFD = 12;
        if (this.aFy != null && this.MC == this.aFA) {
            this.aFC = this.aFy.getMonth() + 1;
        }
        if (this.aFz != null && this.MC == this.aFB) {
            this.aFD = this.aFz.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aFD - this.aFC) + 1);
        String string = getContext().getString(a.h.date_picker_month);
        for (int i = this.aFC; i <= this.aFD; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aFv.getAdapter()).setData(arrayList);
        setMonth(this.MD);
        this.aFv.invalidate();
    }

    public void GO() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.MD) >= 0) {
            this.aFE = 31;
        } else if (Arrays.binarySearch(iArr, this.MD) >= 0) {
            this.aFE = 30;
        } else if ((this.MC % 4 == 0 && this.MC % 100 != 0) || this.MC % 400 == 0) {
            this.aFE = 29;
        } else {
            this.aFE = 28;
        }
        this.aFF = 1;
        this.aFG = this.aFE;
        if (this.aFy != null && this.MC == this.aFA && this.MD == this.aFy.getMonth() + 1) {
            this.aFF = this.aFy.getDate();
        }
        if (this.aFz != null && this.MC == this.aFB && this.MD == this.aFz.getMonth() + 1) {
            this.aFG = this.aFz.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aFG - this.aFF) + 1);
        String string = getContext().getString(a.h.date_picker_day);
        for (int i = this.aFF; i <= this.aFG; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aFw.getAdapter()).setData(arrayList);
        setDay(this.ME);
        this.aFw.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.aFx = bVar;
    }

    public void setYear(int i) {
        if (i < this.aFA) {
            i = this.aFA;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aFA + " and " + this.aFB).IK();
            }
        } else if (i > this.aFB) {
            i = this.aFB;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aFA + " and " + this.aFB).II();
            }
        }
        this.MC = i;
        this.aFu.setSelection(this.MC - this.aFA);
    }

    public int getYear() {
        return this.MC;
    }

    public void setMonth(int i) {
        if (i < this.aFC) {
            i = this.aFC;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aFC + " and " + this.aFD).IK();
            }
        } else if (i > this.aFD) {
            i = this.aFD;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aFC + " and " + this.aFD).II();
            }
        }
        this.MD = i;
        this.aFv.setSelection(this.MD - this.aFC);
    }

    public int getMonth() {
        return this.MD;
    }

    public void setDay(int i) {
        if (i < this.aFF || i > this.aFG) {
            i = this.aFF;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aFF + " and " + this.aFG).II();
            }
        } else if (i > this.aFG) {
            i = this.aFG;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aFF + " and " + this.aFG).IK();
            }
        }
        this.ME = i;
        this.aFw.setSelection(this.ME - this.aFF);
    }

    public int getDay() {
        return this.ME;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFu.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFv.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFw.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.aFy = date;
            this.aFA = this.aFy.getYear() + 1900;
            return;
        }
        this.aFA = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.aFz = date;
            this.aFB = this.aFz.getYear() + 1900;
            return;
        }
        this.aFB = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.aFH = str;
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
                    this.aFv.setVisibility(8);
                    this.aFw.setVisibility(8);
                    return;
                case 1:
                    this.aFv.setVisibility(0);
                    this.aFw.setVisibility(8);
                    return;
                default:
                    this.aFv.setVisibility(0);
                    this.aFw.setVisibility(0);
                    return;
            }
        }
    }

    public boolean fW(String str) {
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
                wheelView = this.aFu;
                break;
            case 1:
                wheelView = this.aFv;
                break;
            case 2:
                wheelView = this.aFw;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.aFI = z;
        this.aFu.setDisableScrollAnyway(z);
        this.aFv.setDisableScrollAnyway(z);
        this.aFw.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.aFv.setScrollCycle(z);
        this.aFu.setScrollCycle(z);
        this.aFw.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aFN;
        private Context mContext;
        private ArrayList<String> aFM = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.aFN = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.aFN = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
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
            textView2.setTextColor(this.aFN);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aFM.get(i));
        }
    }
}
