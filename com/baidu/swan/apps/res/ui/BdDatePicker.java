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
    private String aFD;
    private boolean aFE;
    private int aFF;
    private BdGallery.c aFG;
    private WheelView aFq;
    private WheelView aFr;
    private WheelView aFs;
    private b aFt;
    private Date aFu;
    private Date aFv;
    private int aFw;
    private int aFx;
    private int aFy;
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
        this.aFw = 1900;
        this.aFx = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFy = 1;
        this.aFz = 12;
        this.aFA = 31;
        this.aFB = 1;
        this.aFC = this.aFA;
        this.aFF = 12;
        this.aFG = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFq) {
                    if (bdGallery != BdDatePicker.this.aFr) {
                        if (bdGallery == BdDatePicker.this.aFs) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFB);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFy);
                        BdDatePicker.this.GQ();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFw);
                    BdDatePicker.this.GP();
                    BdDatePicker.this.GQ();
                }
                if (BdDatePicker.this.aFt != null) {
                    BdDatePicker.this.aFt.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
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
        this.aFw = 1900;
        this.aFx = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFy = 1;
        this.aFz = 12;
        this.aFA = 31;
        this.aFB = 1;
        this.aFC = this.aFA;
        this.aFF = 12;
        this.aFG = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFq) {
                    if (bdGallery != BdDatePicker.this.aFr) {
                        if (bdGallery == BdDatePicker.this.aFs) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFB);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFy);
                        BdDatePicker.this.GQ();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFw);
                    BdDatePicker.this.GP();
                    BdDatePicker.this.GQ();
                }
                if (BdDatePicker.this.aFt != null) {
                    BdDatePicker.this.aFt.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
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
        this.aFw = 1900;
        this.aFx = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFy = 1;
        this.aFz = 12;
        this.aFA = 31;
        this.aFB = 1;
        this.aFC = this.aFA;
        this.aFF = 12;
        this.aFG = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFq) {
                    if (bdGallery != BdDatePicker.this.aFr) {
                        if (bdGallery == BdDatePicker.this.aFs) {
                            BdDatePicker.this.ME = (int) (selectedItemPosition + BdDatePicker.this.aFB);
                        }
                    } else {
                        BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFy);
                        BdDatePicker.this.GQ();
                    }
                } else {
                    BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFw);
                    BdDatePicker.this.GP();
                    BdDatePicker.this.GQ();
                }
                if (BdDatePicker.this.aFt != null) {
                    BdDatePicker.this.aFt.a(BdDatePicker.this, BdDatePicker.this.MC, BdDatePicker.this.MD, BdDatePicker.this.ME);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.aFF = x.dip2px(context, this.aFF);
        this.aFq = (WheelView) findViewById(a.f.wheel_year);
        this.aFq.setOnEndFlingListener(this.aFG);
        this.aFq.setAdapter((SpinnerAdapter) new a(context));
        this.aFq.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFq.setSpacing(this.aFF);
        this.aFr = (WheelView) findViewById(a.f.wheel_month);
        this.aFr.setOnEndFlingListener(this.aFG);
        this.aFr.setAdapter((SpinnerAdapter) new a(context));
        this.aFr.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFr.setSpacing(this.aFF);
        this.aFs = (WheelView) findViewById(a.f.wheel_day);
        this.aFs.setOnEndFlingListener(this.aFG);
        this.aFs.setAdapter((SpinnerAdapter) new a(context));
        this.aFs.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.aFs.setSpacing(this.aFF);
        GM();
    }

    private void GM() {
        Calendar calendar = Calendar.getInstance();
        this.MC = calendar.get(1);
        this.MD = calendar.get(2) + 1;
        this.ME = calendar.get(5);
        GN();
    }

    public void GN() {
        GO();
        GP();
        GQ();
    }

    private void GO() {
        if (this.MC < this.aFw || this.MC > this.aFx) {
            this.MC = this.aFw;
        }
        int i = (this.aFx - this.aFw) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(a.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.aFw + i2)));
        }
        ((a) this.aFq.getAdapter()).setData(arrayList);
    }

    public void GP() {
        this.aFy = 1;
        this.aFz = 12;
        if (this.aFu != null && this.MC == this.aFw) {
            this.aFy = this.aFu.getMonth() + 1;
        }
        if (this.aFv != null && this.MC == this.aFx) {
            this.aFz = this.aFv.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aFz - this.aFy) + 1);
        String string = getContext().getString(a.h.date_picker_month);
        for (int i = this.aFy; i <= this.aFz; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aFr.getAdapter()).setData(arrayList);
        setMonth(this.MD);
        this.aFr.invalidate();
    }

    public void GQ() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.MD) >= 0) {
            this.aFA = 31;
        } else if (Arrays.binarySearch(iArr, this.MD) >= 0) {
            this.aFA = 30;
        } else if ((this.MC % 4 == 0 && this.MC % 100 != 0) || this.MC % 400 == 0) {
            this.aFA = 29;
        } else {
            this.aFA = 28;
        }
        this.aFB = 1;
        this.aFC = this.aFA;
        if (this.aFu != null && this.MC == this.aFw && this.MD == this.aFu.getMonth() + 1) {
            this.aFB = this.aFu.getDate();
        }
        if (this.aFv != null && this.MC == this.aFx && this.MD == this.aFv.getMonth() + 1) {
            this.aFC = this.aFv.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aFC - this.aFB) + 1);
        String string = getContext().getString(a.h.date_picker_day);
        for (int i = this.aFB; i <= this.aFC; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aFs.getAdapter()).setData(arrayList);
        setDay(this.ME);
        this.aFs.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.aFt = bVar;
    }

    public void setYear(int i) {
        if (i < this.aFw) {
            i = this.aFw;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aFw + " and " + this.aFx).IM();
            }
        } else if (i > this.aFx) {
            i = this.aFx;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aFw + " and " + this.aFx).IK();
            }
        }
        this.MC = i;
        this.aFq.setSelection(this.MC - this.aFw);
    }

    public int getYear() {
        return this.MC;
    }

    public void setMonth(int i) {
        if (i < this.aFy) {
            i = this.aFy;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aFy + " and " + this.aFz).IM();
            }
        } else if (i > this.aFz) {
            i = this.aFz;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aFy + " and " + this.aFz).IK();
            }
        }
        this.MD = i;
        this.aFr.setSelection(this.MD - this.aFy);
    }

    public int getMonth() {
        return this.MD;
    }

    public void setDay(int i) {
        if (i < this.aFB || i > this.aFC) {
            i = this.aFB;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aFB + " and " + this.aFC).IK();
            }
        } else if (i > this.aFC) {
            i = this.aFC;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aFB + " and " + this.aFC).IM();
            }
        }
        this.ME = i;
        this.aFs.setSelection(this.ME - this.aFB);
    }

    public int getDay() {
        return this.ME;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFq.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFr.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFs.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.aFu = date;
            this.aFw = this.aFu.getYear() + 1900;
            return;
        }
        this.aFw = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.aFv = date;
            this.aFx = this.aFv.getYear() + 1900;
            return;
        }
        this.aFx = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.aFD = str;
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
                    this.aFr.setVisibility(8);
                    this.aFs.setVisibility(8);
                    return;
                case 1:
                    this.aFr.setVisibility(0);
                    this.aFs.setVisibility(8);
                    return;
                default:
                    this.aFr.setVisibility(0);
                    this.aFs.setVisibility(0);
                    return;
            }
        }
    }

    public boolean fV(String str) {
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
                wheelView = this.aFq;
                break;
            case 1:
                wheelView = this.aFr;
                break;
            case 2:
                wheelView = this.aFs;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.aFE = z;
        this.aFq.setDisableScrollAnyway(z);
        this.aFr.setDisableScrollAnyway(z);
        this.aFs.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.aFr.setScrollCycle(z);
        this.aFq.setScrollCycle(z);
        this.aFs.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aFJ;
        private Context mContext;
        private ArrayList<String> aFI = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.aFJ = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.aFJ = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
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
            textView2.setTextColor(this.aFJ);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aFI.get(i));
        }
    }
}
