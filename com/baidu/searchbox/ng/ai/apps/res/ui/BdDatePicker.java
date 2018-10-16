package com.baidu.searchbox.ng.ai.apps.res.ui;

import android.content.Context;
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
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery;
import com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.WheelView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class BdDatePicker extends LinearLayout {
    private static final boolean DEBUG = false;
    private static final int MONTH_COUNT = 12;
    public static final int START_YEAR = 1900;
    public static final String WHEEL_VIEW_DAY_TYPE = "day";
    public static final String WHEEL_VIEW_MONTH_TYPE = "month";
    public static final String WHEEL_VIEW_YEAR_TYPE = "year";
    private static final int YEAR_COUNT = 200;
    private int mDay;
    private int mDayNum;
    private WheelView mDayWheelView;
    private boolean mDisabled;
    private Date mEndDate;
    private int mEndDay;
    private BdGallery.OnEndFlingListener mEndFlingListener;
    private int mEndMonth;
    private int mEndYear;
    private String mFields;
    private int mMonth;
    private WheelView mMonthWheelView;
    private int mSpaceSize;
    private Date mStartDate;
    private int mStartDay;
    private int mStartMonth;
    private int mStartYear;
    private OnTimeChangedListener mTimeChangeListener;
    private int mYear;
    private WheelView mYearWheelView;

    /* loaded from: classes2.dex */
    public interface OnTimeChangedListener {
        void onTimeChanged(BdDatePicker bdDatePicker, int i, int i2, int i3);
    }

    public BdDatePicker(Context context) {
        super(context);
        this.mYear = START_YEAR;
        this.mMonth = 1;
        this.mDay = 1;
        this.mStartYear = START_YEAR;
        this.mEndYear = 2100;
        this.mStartMonth = 1;
        this.mEndMonth = 12;
        this.mDayNum = 31;
        this.mStartDay = 1;
        this.mEndDay = this.mDayNum;
        this.mSpaceSize = 12;
        this.mEndFlingListener = new BdGallery.OnEndFlingListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery.OnEndFlingListener
            public void onEndFling(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.mYearWheelView) {
                    if (bdGallery != BdDatePicker.this.mMonthWheelView) {
                        if (bdGallery == BdDatePicker.this.mDayWheelView) {
                            BdDatePicker.this.mDay = (int) (selectedItemPosition + BdDatePicker.this.mStartDay);
                        }
                    } else {
                        BdDatePicker.this.mMonth = (int) (selectedItemPosition + BdDatePicker.this.mStartMonth);
                        BdDatePicker.this.initDays();
                    }
                } else {
                    BdDatePicker.this.mYear = (int) (selectedItemPosition + BdDatePicker.this.mStartYear);
                    BdDatePicker.this.initMonths();
                    BdDatePicker.this.initDays();
                }
                if (BdDatePicker.this.mTimeChangeListener != null) {
                    BdDatePicker.this.mTimeChangeListener.onTimeChanged(BdDatePicker.this, BdDatePicker.this.mYear, BdDatePicker.this.mMonth, BdDatePicker.this.mDay);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mYear = START_YEAR;
        this.mMonth = 1;
        this.mDay = 1;
        this.mStartYear = START_YEAR;
        this.mEndYear = 2100;
        this.mStartMonth = 1;
        this.mEndMonth = 12;
        this.mDayNum = 31;
        this.mStartDay = 1;
        this.mEndDay = this.mDayNum;
        this.mSpaceSize = 12;
        this.mEndFlingListener = new BdGallery.OnEndFlingListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery.OnEndFlingListener
            public void onEndFling(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.mYearWheelView) {
                    if (bdGallery != BdDatePicker.this.mMonthWheelView) {
                        if (bdGallery == BdDatePicker.this.mDayWheelView) {
                            BdDatePicker.this.mDay = (int) (selectedItemPosition + BdDatePicker.this.mStartDay);
                        }
                    } else {
                        BdDatePicker.this.mMonth = (int) (selectedItemPosition + BdDatePicker.this.mStartMonth);
                        BdDatePicker.this.initDays();
                    }
                } else {
                    BdDatePicker.this.mYear = (int) (selectedItemPosition + BdDatePicker.this.mStartYear);
                    BdDatePicker.this.initMonths();
                    BdDatePicker.this.initDays();
                }
                if (BdDatePicker.this.mTimeChangeListener != null) {
                    BdDatePicker.this.mTimeChangeListener.onTimeChanged(BdDatePicker.this, BdDatePicker.this.mYear, BdDatePicker.this.mMonth, BdDatePicker.this.mDay);
                }
            }
        };
        init(context);
    }

    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mYear = START_YEAR;
        this.mMonth = 1;
        this.mDay = 1;
        this.mStartYear = START_YEAR;
        this.mEndYear = 2100;
        this.mStartMonth = 1;
        this.mEndMonth = 12;
        this.mDayNum = 31;
        this.mStartDay = 1;
        this.mEndDay = this.mDayNum;
        this.mSpaceSize = 12;
        this.mEndFlingListener = new BdGallery.OnEndFlingListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery.OnEndFlingListener
            public void onEndFling(BdGallery bdGallery) {
                long selectedItemPosition = bdGallery.getSelectedItemPosition();
                if (bdGallery != BdDatePicker.this.mYearWheelView) {
                    if (bdGallery != BdDatePicker.this.mMonthWheelView) {
                        if (bdGallery == BdDatePicker.this.mDayWheelView) {
                            BdDatePicker.this.mDay = (int) (selectedItemPosition + BdDatePicker.this.mStartDay);
                        }
                    } else {
                        BdDatePicker.this.mMonth = (int) (selectedItemPosition + BdDatePicker.this.mStartMonth);
                        BdDatePicker.this.initDays();
                    }
                } else {
                    BdDatePicker.this.mYear = (int) (selectedItemPosition + BdDatePicker.this.mStartYear);
                    BdDatePicker.this.initMonths();
                    BdDatePicker.this.initDays();
                }
                if (BdDatePicker.this.mTimeChangeListener != null) {
                    BdDatePicker.this.mTimeChangeListener.onTimeChanged(BdDatePicker.this, BdDatePicker.this.mYear, BdDatePicker.this.mMonth, BdDatePicker.this.mDay);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.aiapps_datepicker_layout, this);
        this.mSpaceSize = AiAppsUIUtils.dip2px(context, this.mSpaceSize);
        this.mYearWheelView = (WheelView) findViewById(R.id.wheel_year);
        this.mYearWheelView.setOnEndFlingListener(this.mEndFlingListener);
        this.mYearWheelView.setAdapter((SpinnerAdapter) new DatePickerAdapter(context));
        this.mYearWheelView.setSelectorDrawable(getResources().getDrawable(R.color.aiapps_transparent));
        this.mYearWheelView.setSpacing(this.mSpaceSize);
        this.mMonthWheelView = (WheelView) findViewById(R.id.wheel_month);
        this.mMonthWheelView.setOnEndFlingListener(this.mEndFlingListener);
        this.mMonthWheelView.setAdapter((SpinnerAdapter) new DatePickerAdapter(context));
        this.mMonthWheelView.setSelectorDrawable(getResources().getDrawable(R.color.aiapps_transparent));
        this.mMonthWheelView.setSpacing(this.mSpaceSize);
        this.mDayWheelView = (WheelView) findViewById(R.id.wheel_day);
        this.mDayWheelView.setOnEndFlingListener(this.mEndFlingListener);
        this.mDayWheelView.setAdapter((SpinnerAdapter) new DatePickerAdapter(context));
        this.mDayWheelView.setSelectorDrawable(getResources().getDrawable(R.color.aiapps_transparent));
        this.mDayWheelView.setSpacing(this.mSpaceSize);
        initDatas();
    }

    private void initDatas() {
        Calendar calendar = Calendar.getInstance();
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2) + 1;
        this.mDay = calendar.get(5);
        updateDatas();
    }

    public void updateDatas() {
        initYears();
        initMonths();
        initDays();
    }

    private void initYears() {
        if (this.mYear < this.mStartYear || this.mYear > this.mEndYear) {
            this.mYear = this.mStartYear;
        }
        int i = (this.mEndYear - this.mStartYear) + 1;
        ArrayList<String> arrayList = new ArrayList<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.valueOf(this.mStartYear + i2) + "年");
        }
        ((DatePickerAdapter) this.mYearWheelView.getAdapter()).setData(arrayList);
    }

    public void initMonths() {
        this.mStartMonth = 1;
        this.mEndMonth = 12;
        if (this.mStartDate != null && this.mYear == this.mStartYear) {
            this.mStartMonth = this.mStartDate.getMonth() + 1;
        }
        if (this.mEndDate != null && this.mYear == this.mEndYear) {
            this.mEndMonth = this.mEndDate.getMonth() + 1;
        }
        ArrayList<String> arrayList = new ArrayList<>((this.mEndMonth - this.mStartMonth) + 1);
        for (int i = this.mStartMonth; i <= this.mEndMonth; i++) {
            arrayList.add(String.format("%02d月", Integer.valueOf(i)));
        }
        ((DatePickerAdapter) this.mMonthWheelView.getAdapter()).setData(arrayList);
        setMonth(this.mMonth);
        this.mMonthWheelView.invalidate();
    }

    public void initDays() {
        int[] iArr = {4, 6, 9, 11};
        if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.mMonth) >= 0) {
            this.mDayNum = 31;
        } else if (Arrays.binarySearch(iArr, this.mMonth) >= 0) {
            this.mDayNum = 30;
        } else if ((this.mYear % 4 == 0 && this.mYear % 100 != 0) || this.mYear % 400 == 0) {
            this.mDayNum = 29;
        } else {
            this.mDayNum = 28;
        }
        this.mStartDay = 1;
        this.mEndDay = this.mDayNum;
        if (this.mStartDate != null && this.mYear == this.mStartYear && this.mMonth == this.mStartDate.getMonth() + 1) {
            this.mStartDay = this.mStartDate.getDate();
        }
        if (this.mEndDate != null && this.mYear == this.mEndYear && this.mMonth == this.mEndDate.getMonth() + 1) {
            this.mEndDay = this.mEndDate.getDate();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.mEndDay - this.mStartDay) + 1);
        for (int i = this.mStartDay; i <= this.mEndDay; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((DatePickerAdapter) this.mDayWheelView.getAdapter()).setData(arrayList);
        setDay(this.mDay);
        this.mDayWheelView.invalidate();
    }

    public void setOnTimeChangeListener(OnTimeChangedListener onTimeChangedListener) {
        this.mTimeChangeListener = onTimeChangedListener;
    }

    public void setYear(int i) {
        if (i < this.mStartYear) {
            i = this.mStartYear;
        } else if (i > this.mEndYear) {
            i = this.mEndYear;
        }
        this.mYear = i;
        this.mYearWheelView.setSelection(this.mYear - this.mStartYear);
    }

    public int getYear() {
        return this.mYear;
    }

    public void setMonth(int i) {
        if (i < this.mStartMonth) {
            i = this.mStartMonth;
        } else if (i > this.mEndMonth) {
            i = this.mEndMonth;
        }
        this.mMonth = i;
        this.mMonthWheelView.setSelection(this.mMonth - this.mStartMonth);
    }

    public int getMonth() {
        return this.mMonth;
    }

    public void setDay(int i) {
        if (i < this.mStartDay || i > this.mEndDay) {
            i = this.mStartDay;
        } else if (i > this.mEndDay) {
            i = this.mEndDay;
        }
        this.mDay = i;
        this.mDayWheelView.setSelection(this.mDay - this.mStartDay);
    }

    public int getDay() {
        return this.mDay;
    }

    public void setYearAdapter(SpinnerAdapter spinnerAdapter) {
        this.mYearWheelView.setAdapter(spinnerAdapter);
    }

    public void setMonthAdapter(SpinnerAdapter spinnerAdapter) {
        this.mMonthWheelView.setAdapter(spinnerAdapter);
    }

    public void setDayAdapter(SpinnerAdapter spinnerAdapter) {
        this.mDayWheelView.setAdapter(spinnerAdapter);
    }

    public void setStartDate(Date date) {
        if (date != null) {
            this.mStartDate = date;
            this.mStartYear = this.mStartDate.getYear() + START_YEAR;
            return;
        }
        this.mStartYear = START_YEAR;
    }

    public void setEndDate(Date date) {
        if (date != null) {
            this.mEndDate = date;
            this.mEndYear = this.mEndDate.getYear() + START_YEAR;
            return;
        }
        this.mEndYear = 2100;
    }

    public void setFields(String str) {
        this.mFields = str;
        if (!TextUtils.isEmpty(str)) {
            char c = 65535;
            switch (str.hashCode()) {
                case 3704893:
                    if (str.equals(WHEEL_VIEW_YEAR_TYPE)) {
                        c = 0;
                        break;
                    }
                    break;
                case 104080000:
                    if (str.equals(WHEEL_VIEW_MONTH_TYPE)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.mMonthWheelView.setVisibility(8);
                    this.mDayWheelView.setVisibility(8);
                    return;
                case 1:
                    this.mMonthWheelView.setVisibility(0);
                    this.mDayWheelView.setVisibility(8);
                    return;
                default:
                    this.mMonthWheelView.setVisibility(0);
                    this.mDayWheelView.setVisibility(0);
                    return;
            }
        }
    }

    public boolean isWheelViewVisible(String str) {
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
                if (str.equals(WHEEL_VIEW_YEAR_TYPE)) {
                    c = 0;
                    break;
                }
                break;
            case 104080000:
                if (str.equals(WHEEL_VIEW_MONTH_TYPE)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                wheelView = this.mYearWheelView;
                break;
            case 1:
                wheelView = this.mMonthWheelView;
                break;
            case 2:
                wheelView = this.mDayWheelView;
                break;
        }
        return wheelView != null && wheelView.getVisibility() == 0;
    }

    public void setDisabled(boolean z) {
        this.mDisabled = z;
        this.mYearWheelView.setDisableScrollAnyway(z);
        this.mMonthWheelView.setDisableScrollAnyway(z);
        this.mDayWheelView.setDisableScrollAnyway(z);
    }

    public void setScrollCycle(boolean z) {
        this.mMonthWheelView.setScrollCycle(z);
        this.mYearWheelView.setScrollCycle(z);
        this.mDayWheelView.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class DatePickerAdapter extends BaseAdapter {
        private int mContentTextColor;
        private Context mContext;
        private ArrayList<String> mData = null;
        private int mWidth = -1;
        private int mHeight = -2;

        public DatePickerAdapter(Context context) {
            this.mContext = null;
            this.mContentTextColor = -16777216;
            this.mContext = context;
            this.mContentTextColor = AppRuntime.getAppContext().getResources().getColor(R.color.aiapps_data_picker_color);
        }

        public void setData(ArrayList<String> arrayList) {
            this.mData = arrayList;
            notifyDataSetChanged();
        }

        public void setItemSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mData != null) {
                return this.mData.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.mData != null) {
                return this.mData.get(i);
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
                view = createView(this.mContext, i, viewGroup);
            }
            buildView(i, view);
            return view;
        }

        protected View createView(Context context, int i, ViewGroup viewGroup) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new BdGallery.LayoutParams(this.mWidth, this.mHeight));
            TextView textView2 = textView;
            textView2.setGravity(17);
            textView2.setTextSize(1, 20.0f);
            textView2.setTextColor(this.mContentTextColor);
            textView.setBackgroundColor(context.getResources().getColor(R.color.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void buildView(int i, View view) {
            ((TextView) view).setText(this.mData.get(i));
        }
    }
}
