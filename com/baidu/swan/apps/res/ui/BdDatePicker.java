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
    private String aFG;
    private boolean aFH;
    private int aFI;
    private BdGallery.c aFJ;
    private WheelView aFt;
    private WheelView aFu;
    private WheelView aFv;
    private b aFw;
    private Date aFx;
    private Date aFy;
    private int aFz;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdDatePicker bdDatePicker, int i, int i2, int i3);
    }

    public BdDatePicker(Context context) {
        super(context);
        this.MC = 1900;
        this.MD = 1;
        this.ME = 1;
        this.aFz = 1900;
        this.aFA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFB = 1;
        this.aFC = 12;
        this.aFD = 31;
        this.aFE = 1;
        this.aFF = this.aFD;
        this.aFI = 12;
        this.aFJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFt) {
                    if (bdGallery != BdDatePicker.this.aFu) {
                        if (bdGallery == BdDatePicker.this.aFv) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFE);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFB);
                        BdDatePicker.this.GO();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFz);
                    BdDatePicker.this.GN();
                    BdDatePicker.this.GO();
                }
                if (BdDatePicker.this.aFw != null) {
                    BdDatePicker.this.aFw.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
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
        this.aFz = 1900;
        this.aFA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFB = 1;
        this.aFC = 12;
        this.aFD = 31;
        this.aFE = 1;
        this.aFF = this.aFD;
        this.aFI = 12;
        this.aFJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFt) {
                    if (bdGallery != BdDatePicker.this.aFu) {
                        if (bdGallery == BdDatePicker.this.aFv) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFE);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFB);
                        BdDatePicker.this.GO();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFz);
                    BdDatePicker.this.GN();
                    BdDatePicker.this.GO();
                }
                if (BdDatePicker.this.aFw != null) {
                    BdDatePicker.this.aFw.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
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
        this.aFz = 1900;
        this.aFA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFB = 1;
        this.aFC = 12;
        this.aFD = 31;
        this.aFE = 1;
        this.aFF = this.aFD;
        this.aFI = 12;
        this.aFJ = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFt) {
                    if (bdGallery != BdDatePicker.this.aFu) {
                        if (bdGallery == BdDatePicker.this.aFv) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFE);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFB);
                        BdDatePicker.this.GO();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFz);
                    BdDatePicker.this.GN();
                    BdDatePicker.this.GO();
                }
                if (BdDatePicker.this.aFw != null) {
                    BdDatePicker.this.aFw.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.aFI = x.dip2px(context, this.aFI);
        this.aFt = (WheelView) findViewById(a.f.wheel_year);
        this.aFt.setOnEndFlingListener(this.aFJ);
        this.aFt.setAdapter((SpinnerAdapter) new a(context));
        this.aFt.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFt.setSpacing(this.aFI);
        this.aFu = (WheelView) findViewById(a.f.wheel_month);
        this.aFu.setOnEndFlingListener(this.aFJ);
        this.aFu.setAdapter((SpinnerAdapter) new a(context));
        this.aFu.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFu.setSpacing(this.aFI);
        this.aFv = (WheelView) findViewById(a.f.wheel_day);
        this.aFv.setOnEndFlingListener(this.aFJ);
        this.aFv.setAdapter((SpinnerAdapter) new a(context));
        this.aFv.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFv.setSpacing(this.aFI);
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
        if (this.MC < this.aFz || this.MC > this.aFA) {
            this.MC = this.aFz;
        }
        int i = (this.aFA - this.aFz) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(a.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.aFz + i2)));
        }
        ((a) this.aFt.getAdapter()).setData(arrayList);
    }

    public void GN() {
        this.aFB = 1;
        this.aFC = 12;
        if (this.aFx != null && this.MC == this.aFz) {
            this.aFB = this.aFx.getMonth() + 1;
        }
        if (this.aFy != null && this.MC == this.aFA) {
            this.aFC = this.aFy.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aFC - this.aFB) + 1);
        String string = getContext().getString(a.h.date_picker_month);
        for (int i = this.aFB; i <= this.aFC; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aFu.getAdapter()).setData(arrayList);
        setMonth(this.MD);
        this.aFu.invalidate();
    }

    public void GO() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.MD) >= 0) {
            this.aFD = 31;
        } else if (Arrays.binarySearch(iArr, this.MD) >= 0) {
            this.aFD = 30;
        } else if ((this.MC % 4 == 0 && this.MC % 100 != 0) || this.MC % 400 == 0) {
            this.aFD = 29;
        } else {
            this.aFD = 28;
        }
        this.aFE = 1;
        this.aFF = this.aFD;
        if (this.aFx != null && this.MC == this.aFz && this.MD == this.aFx.getMonth() + 1) {
            this.aFE = this.aFx.getDate();
        }
        if (this.aFy != null && this.MC == this.aFA && this.MD == this.aFy.getMonth() + 1) {
            this.aFF = this.aFy.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aFF - this.aFE) + 1);
        String string = getContext().getString(a.h.date_picker_day);
        for (int i = this.aFE; i <= this.aFF; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aFv.getAdapter()).setData(arrayList);
        setDay(this.ME);
        this.aFv.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.aFw = bVar;
    }

    public void setYear(int i) {
        if (i < this.aFz) {
            i = this.aFz;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aFz + " and " + this.aFA).IK();
            }
        } else if (i > this.aFA) {
            i = this.aFA;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aFz + " and " + this.aFA).II();
            }
        }
        this.MC = i;
        this.aFt.setSelection(this.MC - this.aFz);
    }

    public int getYear() {
        return this.MC;
    }

    public void setMonth(int i) {
        if (i < this.aFB) {
            i = this.aFB;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aFB + " and " + this.aFC).IK();
            }
        } else if (i > this.aFC) {
            i = this.aFC;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aFB + " and " + this.aFC).II();
            }
        }
        this.MD = i;
        this.aFu.setSelection(this.MD - this.aFB);
    }

    public int getMonth() {
        return this.MD;
    }

    public void setDay(int i) {
        if (i < this.aFE || i > this.aFF) {
            i = this.aFE;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aFE + " and " + this.aFF).II();
            }
        } else if (i > this.aFF) {
            i = this.aFF;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aFE + " and " + this.aFF).IK();
            }
        }
        this.ME = i;
        this.aFv.setSelection(this.ME - this.aFE);
    }

    public int getDay() {
        return this.ME;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFt.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFu.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFv.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.aFx = date;
            this.aFz = this.aFx.getYear() + 1900;
            return;
        }
        this.aFz = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.aFy = date;
            this.aFA = this.aFy.getYear() + 1900;
            return;
        }
        this.aFA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.aFG = str;
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
                    this.aFu.setVisibility(8);
                    this.aFv.setVisibility(8);
                    return;
                case 1:
                    this.aFu.setVisibility(0);
                    this.aFv.setVisibility(8);
                    return;
                default:
                    this.aFu.setVisibility(0);
                    this.aFv.setVisibility(0);
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
                wheelView = this.aFt;
                break;
            case 1:
                wheelView = this.aFu;
                break;
            case 2:
                wheelView = this.aFv;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.aFH = z;
        this.aFt.setDisableScrollAnyway(z);
        this.aFu.setDisableScrollAnyway(z);
        this.aFv.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.aFu.setScrollCycle(z);
        this.aFt.setScrollCycle(z);
        this.aFv.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aFM;
        private Context mContext;
        private ArrayList<String> aFL = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.aFM = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.aFM = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
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
            textView2.setTextColor(this.aFM);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aFL.get(i));
        }
    }
}
