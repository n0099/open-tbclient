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
    private int bbA;
    private int bbB;
    private String bbC;
    private boolean bbD;
    private int bbE;
    private BdGallery.c bbF;
    private WheelView bbp;
    private WheelView bbq;
    private WheelView bbr;
    private b bbs;
    private Date bbt;
    private Date bbu;
    private int bbv;
    private int bbw;
    private int bbx;
    private int bby;
    private int bbz;
    private int wH;
    private int wI;
    private int wJ;

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdDatePicker bdDatePicker, int i, int i2, int i3);
    }

    public BdDatePicker(Context context) {
        super(context);
        this.wH = 1900;
        this.wI = 1;
        this.wJ = 1;
        this.bbv = 1900;
        this.bbw = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bbx = 1;
        this.bby = 12;
        this.bbz = 31;
        this.bbA = 1;
        this.bbB = this.bbz;
        this.bbE = 12;
        this.bbF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.bbp) {
                    if (bdGallery != BdDatePicker.this.bbq) {
                        if (bdGallery == BdDatePicker.this.bbr) {
                            BdDatePicker.this.wJ = (int) (selectedItemPosition + BdDatePicker.this.bbA);
                        }
                    } else {
                        BdDatePicker.this.wI = (int) (selectedItemPosition + BdDatePicker.this.bbx);
                        BdDatePicker.this.OQ();
                    }
                } else {
                    BdDatePicker.this.wH = (int) (selectedItemPosition + BdDatePicker.this.bbv);
                    BdDatePicker.this.OP();
                    BdDatePicker.this.OQ();
                }
                if (BdDatePicker.this.bbs != null) {
                    BdDatePicker.this.bbs.a(BdDatePicker.this, BdDatePicker.this.wH, BdDatePicker.this.wI, BdDatePicker.this.wJ);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wH = 1900;
        this.wI = 1;
        this.wJ = 1;
        this.bbv = 1900;
        this.bbw = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bbx = 1;
        this.bby = 12;
        this.bbz = 31;
        this.bbA = 1;
        this.bbB = this.bbz;
        this.bbE = 12;
        this.bbF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.bbp) {
                    if (bdGallery != BdDatePicker.this.bbq) {
                        if (bdGallery == BdDatePicker.this.bbr) {
                            BdDatePicker.this.wJ = (int) (selectedItemPosition + BdDatePicker.this.bbA);
                        }
                    } else {
                        BdDatePicker.this.wI = (int) (selectedItemPosition + BdDatePicker.this.bbx);
                        BdDatePicker.this.OQ();
                    }
                } else {
                    BdDatePicker.this.wH = (int) (selectedItemPosition + BdDatePicker.this.bbv);
                    BdDatePicker.this.OP();
                    BdDatePicker.this.OQ();
                }
                if (BdDatePicker.this.bbs != null) {
                    BdDatePicker.this.bbs.a(BdDatePicker.this, BdDatePicker.this.wH, BdDatePicker.this.wI, BdDatePicker.this.wJ);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.wH = 1900;
        this.wI = 1;
        this.wJ = 1;
        this.bbv = 1900;
        this.bbw = PushConstants.BROADCAST_MESSAGE_ARRIVE;
        this.bbx = 1;
        this.bby = 12;
        this.bbz = 31;
        this.bbA = 1;
        this.bbB = this.bbz;
        this.bbE = 12;
        this.bbF = new BdGallery.c() { // from class: com.baidu.swan.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery.c
            public void a(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.bbp) {
                    if (bdGallery != BdDatePicker.this.bbq) {
                        if (bdGallery == BdDatePicker.this.bbr) {
                            BdDatePicker.this.wJ = (int) (selectedItemPosition + BdDatePicker.this.bbA);
                        }
                    } else {
                        BdDatePicker.this.wI = (int) (selectedItemPosition + BdDatePicker.this.bbx);
                        BdDatePicker.this.OQ();
                    }
                } else {
                    BdDatePicker.this.wH = (int) (selectedItemPosition + BdDatePicker.this.bbv);
                    BdDatePicker.this.OP();
                    BdDatePicker.this.OQ();
                }
                if (BdDatePicker.this.bbs != null) {
                    BdDatePicker.this.bbs.a(BdDatePicker.this, BdDatePicker.this.wH, BdDatePicker.this.wI, BdDatePicker.this.wJ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.g.aiapps_datepicker_layout, this);
        this.bbE = z.dip2px(context, this.bbE);
        this.bbp = (WheelView) findViewById(a.f.wheel_year);
        this.bbp.setOnEndFlingListener(this.bbF);
        this.bbp.setAdapter((SpinnerAdapter) new a(context));
        this.bbp.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bbp.setSpacing(this.bbE);
        this.bbq = (WheelView) findViewById(a.f.wheel_month);
        this.bbq.setOnEndFlingListener(this.bbF);
        this.bbq.setAdapter((SpinnerAdapter) new a(context));
        this.bbq.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bbq.setSpacing(this.bbE);
        this.bbr = (WheelView) findViewById(a.f.wheel_day);
        this.bbr.setOnEndFlingListener(this.bbF);
        this.bbr.setAdapter((SpinnerAdapter) new a(context));
        this.bbr.setSelectorDrawable(getResources().getDrawable(a.c.aiapps_transparent));
        this.bbr.setSpacing(this.bbE);
        OM();
    }

    private void OM() {
        Calendar calendar = Calendar.getInstance();
        this.wH = calendar.get(1);
        this.wI = calendar.get(2) + 1;
        this.wJ = calendar.get(5);
        ON();
    }

    public void ON() {
        OO();
        OP();
        OQ();
    }

    private void OO() {
        if (this.wH < this.bbv || this.wH > this.bbw) {
            this.wH = this.bbv;
        }
        int i = (this.bbw - this.bbv) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        String string = getContext().getString(a.h.date_picker_year);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.format(string, Integer.valueOf(this.bbv + i2)));
        }
        ((a) this.bbp.getAdapter()).setData(arrayList);
    }

    public void OP() {
        this.bbx = 1;
        this.bby = 12;
        if (this.bbt != null && this.wH == this.bbv) {
            this.bbx = this.bbt.getMonth() + 1;
        }
        if (this.bbu != null && this.wH == this.bbw) {
            this.bby = this.bbu.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.bby - this.bbx) + 1);
        String string = getContext().getString(a.h.date_picker_month);
        for (int i = this.bbx; i <= this.bby; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.bbq.getAdapter()).setData(arrayList);
        setMonth(this.wI);
        this.bbq.invalidate();
    }

    public void OQ() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.wI) >= 0) {
            this.bbz = 31;
        } else if (Arrays.binarySearch(iArr, this.wI) >= 0) {
            this.bbz = 30;
        } else if ((this.wH % 4 == 0 && this.wH % 100 != 0) || this.wH % 400 == 0) {
            this.bbz = 29;
        } else {
            this.bbz = 28;
        }
        this.bbA = 1;
        this.bbB = this.bbz;
        if (this.bbt != null && this.wH == this.bbv && this.wI == this.bbt.getMonth() + 1) {
            this.bbA = this.bbt.getDate();
        }
        if (this.bbu != null && this.wH == this.bbw && this.wI == this.bbu.getMonth() + 1) {
            this.bbB = this.bbu.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.bbB - this.bbA) + 1);
        String string = getContext().getString(a.h.date_picker_day);
        for (int i = this.bbA; i <= this.bbB; i++) {
            arrayList.add(String.format(string, Integer.valueOf(i)));
        }
        ((a) this.bbr.getAdapter()).setData(arrayList);
        setDay(this.wJ);
        this.bbr.invalidate();
    }

    public void setOnTimeChangeListener(b bVar) {
        this.bbs = bVar;
    }

    public void setYear(int i) {
        if (i < this.bbv) {
            i = this.bbv;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.bbv + " and " + this.bbw).QQ();
            }
        } else if (i > this.bbw) {
            i = this.bbw;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The year must be between " + this.bbv + " and " + this.bbw).QO();
            }
        }
        this.wH = i;
        this.bbp.setSelection(this.wH - this.bbv);
    }

    public int getYear() {
        return this.wH;
    }

    public void setMonth(int i) {
        if (i < this.bbx) {
            i = this.bbx;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.bbx + " and " + this.bby).QQ();
            }
        } else if (i > this.bby) {
            i = this.bby;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The month must be between " + this.bbx + " and " + this.bby).QO();
            }
        }
        this.wI = i;
        this.bbq.setSelection(this.wI - this.bbx);
    }

    public int getMonth() {
        return this.wI;
    }

    public void setDay(int i) {
        if (i < this.bbA || i > this.bbB) {
            i = this.bbA;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.bbA + " and " + this.bbB).QO();
            }
        } else if (i > this.bbB) {
            i = this.bbB;
            if (DEBUG) {
                d.a(AppRuntime.getAppContext(), "The day must be between " + this.bbA + " and " + this.bbB).QQ();
            }
        }
        this.wJ = i;
        this.bbr.setSelection(this.wJ - this.bbA);
    }

    public int getDay() {
        return this.wJ;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.bbp.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.bbq.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.bbr.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.bbt = date;
            this.bbv = this.bbt.getYear() + 1900;
            return;
        }
        this.bbv = 1900;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.bbu = date;
            this.bbw = this.bbu.getYear() + 1900;
            return;
        }
        this.bbw = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    }

    public void setFields(String str) {
        this.bbC = str;
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
                    this.bbq.setVisibility(8);
                    this.bbr.setVisibility(8);
                    return;
                case 1:
                    this.bbq.setVisibility(0);
                    this.bbr.setVisibility(8);
                    return;
                default:
                    this.bbq.setVisibility(0);
                    this.bbr.setVisibility(0);
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
                wheelView = this.bbp;
                break;
            case 1:
                wheelView = this.bbq;
                break;
            case 2:
                wheelView = this.bbr;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.bbD = z;
        this.bbp.setDisableScrollAnyway(z);
        this.bbq.setDisableScrollAnyway(z);
        this.bbr.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.bbq.setScrollCycle(z);
        this.bbp.setScrollCycle(z);
        this.bbr.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class a extends BaseAdapter {
        private int bbI;
        private Context mContext;
        private ArrayList<String> bbH = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public a(Context context) {
            this.mContext = null;
            this.bbI = ViewCompat.MEASURED_STATE_MASK;
            this.mContext = context;
            this.bbI = AppRuntime.getAppContext().getResources().getColor(a.c.aiapps_data_picker_color);
        }

        public void setData(ArrayList<String> arrayList) {
            this.bbH = arrayList;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bbH != null) {
                return this.bbH.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.bbH != null) {
                return this.bbH.get(i);
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
            textView2.setTextColor(this.bbI);
            textView.setBackgroundColor(context.getResources().getColor(a.c.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void c(int i, View view) {
            ((TextView) view).setText(this.bbH.get(i));
        }
    }
}
