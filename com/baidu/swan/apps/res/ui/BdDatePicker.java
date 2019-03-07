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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG & true;
    private int MB;
    private int MC;
    private int MD;
    private int aFA;
    private int aFB;
    private String aFC;
    private boolean aFD;
    private int aFE;
    private BdGallery.c aFF;
    private WheelView aFp;
    private WheelView aFq;
    private WheelView aFr;
    private b aFs;
    private Date aFt;
    private Date aFu;
    private int aFv;
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
        this.MB = 1900;
        this.MC = 1;
        this.MD = 1;
        this.aFv = 1900;
        this.aFw = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFx = 1;
        this.aFy = 12;
        this.aFz = 31;
        this.aFA = 1;
        this.aFB = this.aFz;
        this.aFE = 12;
        this.aFF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFp) {
                    if (bdGallery != BdDatePicker.this.aFq) {
                        if (bdGallery == BdDatePicker.this.aFr) {
                            BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFA);
                        }
                    } else {
                        BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFx);
                        BdDatePicker.this.GQ();
                    }
                } else {
                    BdDatePicker.this.MB = (int) (selectedItemPosition + BdDatePicker.this.aFv);
                    BdDatePicker.this.GP();
                    BdDatePicker.this.GQ();
                }
                if (BdDatePicker.this.aFs != null) {
                    BdDatePicker.this.aFs.a(BdDatePicker.this, BdDatePicker.this.MB, BdDatePicker.this.MC, BdDatePicker.this.MD);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MB = 1900;
        this.MC = 1;
        this.MD = 1;
        this.aFv = 1900;
        this.aFw = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFx = 1;
        this.aFy = 12;
        this.aFz = 31;
        this.aFA = 1;
        this.aFB = this.aFz;
        this.aFE = 12;
        this.aFF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFp) {
                    if (bdGallery != BdDatePicker.this.aFq) {
                        if (bdGallery == BdDatePicker.this.aFr) {
                            BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFA);
                        }
                    } else {
                        BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFx);
                        BdDatePicker.this.GQ();
                    }
                } else {
                    BdDatePicker.this.MB = (int) (selectedItemPosition + BdDatePicker.this.aFv);
                    BdDatePicker.this.GP();
                    BdDatePicker.this.GQ();
                }
                if (BdDatePicker.this.aFs != null) {
                    BdDatePicker.this.aFs.a(BdDatePicker.this, BdDatePicker.this.MB, BdDatePicker.this.MC, BdDatePicker.this.MD);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MB = 1900;
        this.MC = 1;
        this.MD = 1;
        this.aFv = 1900;
        this.aFw = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.aFx = 1;
        this.aFy = 12;
        this.aFz = 31;
        this.aFA = 1;
        this.aFB = this.aFz;
        this.aFE = 12;
        this.aFF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.aFp) {
                    if (bdGallery != BdDatePicker.this.aFq) {
                        if (bdGallery == BdDatePicker.this.aFr) {
                            BdDatePicker.this.MD = (int) (selectedItemPosition + BdDatePicker.this.aFA);
                        }
                    } else {
                        BdDatePicker.this.MC = (int) (selectedItemPosition + BdDatePicker.this.aFx);
                        BdDatePicker.this.GQ();
                    }
                } else {
                    BdDatePicker.this.MB = (int) (selectedItemPosition + BdDatePicker.this.aFv);
                    BdDatePicker.this.GP();
                    BdDatePicker.this.GQ();
                }
                if (BdDatePicker.this.aFs != null) {
                    BdDatePicker.this.aFs.a(BdDatePicker.this, BdDatePicker.this.MB, BdDatePicker.this.MC, BdDatePicker.this.MD);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(b.g.aiapps_datepicker_layout, this);
        this.aFE = x.dip2px(context, this.aFE);
        this.aFp = (WheelView) findViewById(b.f.wheel_year);
        this.aFp.setOnEndFlingListener(this.aFF);
        this.aFp.setAdapter((SpinnerAdapter) new a(context));
        this.aFp.setSelectorDrawable(getResources().getDrawable(b.c.aiapps_transparent));
        this.aFp.setSpacing(this.aFE);
        this.aFq = (WheelView) findViewById(b.f.wheel_month);
        this.aFq.setOnEndFlingListener(this.aFF);
        this.aFq.setAdapter((SpinnerAdapter) new a(context));
        this.aFq.setSelectorDrawable(getResources().getDrawable(b.c.aiapps_transparent));
        this.aFq.setSpacing(this.aFE);
        this.aFr = (WheelView) findViewById(b.f.wheel_day);
        this.aFr.setOnEndFlingListener(this.aFF);
        this.aFr.setAdapter((SpinnerAdapter) new a(context));
        this.aFr.setSelectorDrawable(getResources().getDrawable(b.c.aiapps_transparent));
        this.aFr.setSpacing(this.aFE);
        GM();
    }

    private void GM() {
        Calendar calendar = Calendar.getInstance();
        this.MB = calendar.get(1);
        this.MC = calendar.get(2) + 1;
        this.MD = calendar.get(5);
        GN();
    }

    public void GN() {
        GO();
        GP();
        GQ();
    }

    private void GO() {
        if (this.MB < this.aFv || this.MB > this.aFw) {
            this.MB = this.aFv;
        }
        int i = (this.aFw - this.aFv) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(b.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.aFv + i2)));
        }
        ((a) this.aFp.getAdapter()).setData(arrayList);
    }

    public void GP() {
        this.aFx = 1;
        this.aFy = 12;
        if (this.aFt != null && this.MB == this.aFv) {
            this.aFx = this.aFt.getMonth() + 1;
        }
        if (this.aFu != null && this.MB == this.aFw) {
            this.aFy = this.aFu.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aFy - this.aFx) + 1);
        String string = getContext().getString(b.h.date_picker_month);
        for (int i = this.aFx; i <= this.aFy; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aFq.getAdapter()).setData(arrayList);
        setMonth(this.MC);
        this.aFq.invalidate();
    }

    public void GQ() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.MC) >= 0) {
            this.aFz = 31;
        } else if (Arrays.binarySearch(iArr, this.MC) >= 0) {
            this.aFz = 30;
        } else if ((this.MB % 4 == 0 && this.MB % 100 != 0) || this.MB % 400 == 0) {
            this.aFz = 29;
        } else {
            this.aFz = 28;
        }
        this.aFA = 1;
        this.aFB = this.aFz;
        if (this.aFt != null && this.MB == this.aFv && this.MC == this.aFt.getMonth() + 1) {
            this.aFA = this.aFt.getDate();
        }
        if (this.aFu != null && this.MB == this.aFw && this.MC == this.aFu.getMonth() + 1) {
            this.aFB = this.aFu.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.aFB - this.aFA) + 1);
        String string = getContext().getString(b.h.date_picker_day);
        for (int i = this.aFA; i <= this.aFB; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.aFr.getAdapter()).setData(arrayList);
        setDay(this.MD);
        this.aFr.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.aFs = bVar;
    }

    public void setYear(int i) {
        if (i < this.aFv) {
            i = this.aFv;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aFv + " and " + this.aFw).IM();
            }
        } else if (i > this.aFw) {
            i = this.aFw;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.aFv + " and " + this.aFw).IK();
            }
        }
        this.MB = i;
        this.aFp.setSelection(this.MB - this.aFv);
    }

    public int getYear() {
        return this.MB;
    }

    public void setMonth(int i) {
        if (i < this.aFx) {
            i = this.aFx;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aFx + " and " + this.aFy).IM();
            }
        } else if (i > this.aFy) {
            i = this.aFy;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.aFx + " and " + this.aFy).IK();
            }
        }
        this.MC = i;
        this.aFq.setSelection(this.MC - this.aFx);
    }

    public int getMonth() {
        return this.MC;
    }

    public void setDay(int i) {
        if (i < this.aFA || i > this.aFB) {
            i = this.aFA;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aFA + " and " + this.aFB).IK();
            }
        } else if (i > this.aFB) {
            i = this.aFB;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.aFA + " and " + this.aFB).IM();
            }
        }
        this.MD = i;
        this.aFr.setSelection(this.MD - this.aFA);
    }

    public int getDay() {
        return this.MD;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFp.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFq.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.aFr.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.aFt = date;
            this.aFv = this.aFt.getYear() + 1900;
            return;
        }
        this.aFv = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.aFu = date;
            this.aFw = this.aFu.getYear() + 1900;
            return;
        }
        this.aFw = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.aFC = str;
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
                    this.aFq.setVisibility(8);
                    this.aFr.setVisibility(8);
                    return;
                case 1:
                    this.aFq.setVisibility(0);
                    this.aFr.setVisibility(8);
                    return;
                default:
                    this.aFq.setVisibility(0);
                    this.aFr.setVisibility(0);
                    return;
            }
        }
    }

    public boolean fV(String str) {
        WheelView wheelView = null;
        char c = 65535;
        switch (str.hashCode()) {
            case 99228:
                if (str.equals("day")) {
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
                wheelView = this.aFp;
                break;
            case 1:
                wheelView = this.aFq;
                break;
            case 2:
                wheelView = this.aFr;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.aFD = z;
        this.aFp.setDisableScrollAnyway(z);
        this.aFq.setDisableScrollAnyway(z);
        this.aFr.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.aFq.setScrollCycle(z);
        this.aFp.setScrollCycle(z);
        this.aFr.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int aFI;
        private Context mContext;
        private ArrayList<String> aFH = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.aFI = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.aFI = AppRuntime.getAppContext().getResources().getColor(b.c.aiapps_data_picker_color);
        }

        public void setData(ArrayList<String> arrayList) {
            this.aFH = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aFH != null) {
                return this.aFH.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.aFH != null) {
                return this.aFH.get(i);
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
            textView2.setTextColor(this.aFI);
            textView.setBackgroundColor(context.getResources().getColor(b.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void b(int i, View view) {
            ((TextView) view).setText(this.aFH.get(i));
        }
    }
}
