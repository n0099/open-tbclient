package com.baidu.searchbox.ng.ai.apps.res.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdAdapterView;
import com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdGallery;
import com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.WheelView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class BdTimePicker extends LinearLayout {
    private boolean mDisabled;
    private Date mEndDate;
    private int mEndHour;
    private int mEndMin;
    private String mFields;
    private int mHour;
    private WheelView mHourWheelView;
    private BdAdapterView.OnItemSelectedListener mItemSelectedListener;
    private int mMinute;
    private WheelView mMinuteWheelView;
    private int mSpaceSize;
    private Date mStartDate;
    private int mStartHour;
    private int mStartMin;
    private OnTimeChangedListener mTimeChangeListener;
    private LinearLayout mTimePickerRoot;

    /* loaded from: classes2.dex */
    public interface OnTimeChangedListener {
        void onTimeChanged(BdTimePicker bdTimePicker, int i, int i2);
    }

    public BdTimePicker(Context context) {
        super(context);
        this.mHour = 0;
        this.mMinute = 0;
        this.mSpaceSize = 12;
        this.mItemSelectedListener = new BdAdapterView.OnItemSelectedListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdAdapterView.OnItemSelectedListener
            public void onItemSelected(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.mHourWheelView) {
                    if (bdAdapterView == BdTimePicker.this.mMinuteWheelView) {
                        BdTimePicker.this.mMinute = BdTimePicker.this.mStartMin + i;
                    }
                } else {
                    BdTimePicker.this.mHour = BdTimePicker.this.mStartHour + i;
                    BdTimePicker.this.initMinutes();
                }
                if (BdTimePicker.this.mTimeChangeListener != null) {
                    BdTimePicker.this.mTimeChangeListener.onTimeChanged(BdTimePicker.this, BdTimePicker.this.mHour, BdTimePicker.this.mMinute);
                }
            }

            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdAdapterView.OnItemSelectedListener
            public void onNothingSelected(BdAdapterView<?> bdAdapterView) {
            }
        };
        init(context);
    }

    public BdTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHour = 0;
        this.mMinute = 0;
        this.mSpaceSize = 12;
        this.mItemSelectedListener = new BdAdapterView.OnItemSelectedListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdAdapterView.OnItemSelectedListener
            public void onItemSelected(BdAdapterView<?> bdAdapterView, View view, int i, long j) {
                if (bdAdapterView != BdTimePicker.this.mHourWheelView) {
                    if (bdAdapterView == BdTimePicker.this.mMinuteWheelView) {
                        BdTimePicker.this.mMinute = BdTimePicker.this.mStartMin + i;
                    }
                } else {
                    BdTimePicker.this.mHour = BdTimePicker.this.mStartHour + i;
                    BdTimePicker.this.initMinutes();
                }
                if (BdTimePicker.this.mTimeChangeListener != null) {
                    BdTimePicker.this.mTimeChangeListener.onTimeChanged(BdTimePicker.this, BdTimePicker.this.mHour, BdTimePicker.this.mMinute);
                }
            }

            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdAdapterView.OnItemSelectedListener
            public void onNothingSelected(BdAdapterView<?> bdAdapterView) {
            }
        };
        init(context);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHour = 0;
        this.mMinute = 0;
        this.mSpaceSize = 12;
        this.mItemSelectedListener = new BdAdapterView.OnItemSelectedListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.BdTimePicker.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdAdapterView.OnItemSelectedListener
            public void onItemSelected(BdAdapterView<?> bdAdapterView, View view, int i2, long j) {
                if (bdAdapterView != BdTimePicker.this.mHourWheelView) {
                    if (bdAdapterView == BdTimePicker.this.mMinuteWheelView) {
                        BdTimePicker.this.mMinute = BdTimePicker.this.mStartMin + i2;
                    }
                } else {
                    BdTimePicker.this.mHour = BdTimePicker.this.mStartHour + i2;
                    BdTimePicker.this.initMinutes();
                }
                if (BdTimePicker.this.mTimeChangeListener != null) {
                    BdTimePicker.this.mTimeChangeListener.onTimeChanged(BdTimePicker.this, BdTimePicker.this.mHour, BdTimePicker.this.mMinute);
                }
            }

            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.wheelview.BdAdapterView.OnItemSelectedListener
            public void onNothingSelected(BdAdapterView<?> bdAdapterView) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.aiapps_timepicker_layout, this);
        this.mSpaceSize = AiAppsUIUtils.dip2px(context, this.mSpaceSize);
        this.mTimePickerRoot = (LinearLayout) findViewById(R.id.timepicker_root);
        this.mHourWheelView = (WheelView) findViewById(R.id.wheel_hour);
        this.mHourWheelView.setOnItemSelectedListener(this.mItemSelectedListener);
        this.mHourWheelView.setAdapter((SpinnerAdapter) new TimePickerAdapter(context));
        this.mHourWheelView.setSelectorDrawable(getResources().getDrawable(R.color.aiapps_transparent));
        this.mHourWheelView.setSpacing(this.mSpaceSize);
        this.mMinuteWheelView = (WheelView) findViewById(R.id.wheel_minute);
        this.mMinuteWheelView.setOnItemSelectedListener(this.mItemSelectedListener);
        this.mMinuteWheelView.setAdapter((SpinnerAdapter) new TimePickerAdapter(context));
        this.mMinuteWheelView.setSelectorDrawable(getResources().getDrawable(R.color.aiapps_transparent));
        this.mMinuteWheelView.setSpacing(this.mSpaceSize);
        initDatas();
    }

    private void initDatas() {
        Calendar calendar = Calendar.getInstance();
        this.mHour = calendar.get(11);
        this.mMinute = calendar.get(12);
        updateDatas();
    }

    public void updateDatas() {
        initHours();
        initMinutes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMinutes() {
        this.mStartMin = 0;
        this.mEndMin = 59;
        if (this.mStartDate != null && this.mHour == this.mStartHour) {
            this.mStartMin = this.mStartDate.getMinutes();
        }
        if (this.mEndDate != null && this.mHour == this.mEndHour) {
            this.mEndMin = this.mEndDate.getMinutes();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.mEndMin - this.mStartMin) + 1);
        for (int i = this.mStartMin; i <= this.mEndMin; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((TimePickerAdapter) this.mMinuteWheelView.getAdapter()).setData(arrayList);
        setMinute(this.mMinute);
    }

    private void initHours() {
        this.mStartHour = 0;
        this.mEndHour = 23;
        if (this.mStartDate != null) {
            this.mStartHour = this.mStartDate.getHours();
        }
        if (this.mEndDate != null) {
            this.mEndHour = this.mEndDate.getHours();
        }
        ArrayList<String> arrayList = new ArrayList<>((this.mEndHour - this.mStartHour) + 1);
        for (int i = this.mStartHour; i <= this.mEndHour; i++) {
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
        }
        ((TimePickerAdapter) this.mHourWheelView.getAdapter()).setData(arrayList);
        setHour(this.mHour);
    }

    public void setStartDate(Date date) {
        this.mStartDate = date;
    }

    public void setmEndDate(Date date) {
        this.mEndDate = date;
    }

    public void setDisabled(boolean z) {
        this.mDisabled = z;
        this.mHourWheelView.setDisableScrollAnyway(z);
        this.mMinuteWheelView.setDisableScrollAnyway(z);
    }

    public void setOnTimeChangeListener(OnTimeChangedListener onTimeChangedListener) {
        this.mTimeChangeListener = onTimeChangedListener;
    }

    public void setHour(int i) {
        if (i < this.mStartHour) {
            i = this.mStartHour;
        } else if (i > this.mEndHour) {
            i = this.mEndHour;
        }
        this.mHour = i;
        this.mHourWheelView.setSelection(i - this.mStartHour);
    }

    public int getHour() {
        return this.mHour;
    }

    public void setMinute(int i) {
        if (i < this.mStartMin) {
            i = this.mStartMin;
        } else if (i > this.mEndMin) {
            i = this.mEndMin;
        }
        this.mMinute = i;
        this.mMinuteWheelView.setSelection(i - this.mStartMin);
    }

    public int getMinute() {
        return this.mMinute;
    }

    public void setHourAdapter(SpinnerAdapter spinnerAdapter) {
        this.mHourWheelView.setAdapter(spinnerAdapter);
    }

    public void setMinuteAdapter(SpinnerAdapter spinnerAdapter) {
        this.mMinuteWheelView.setAdapter(spinnerAdapter);
    }

    public void setScrollCycle(boolean z) {
        this.mMinuteWheelView.setScrollCycle(z);
        this.mHourWheelView.setScrollCycle(z);
    }

    /* loaded from: classes2.dex */
    public static class TimePickerAdapter extends BaseAdapter {
        private Context mContext;
        private int mHeight;
        private ArrayList<String> mData = null;
        private int mWidth = -1;

        public TimePickerAdapter(Context context) {
            this.mHeight = -2;
            this.mContext = null;
            this.mContext = context;
            this.mHeight = AiAppsUIUtils.dip2px(context, this.mHeight);
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
            textView2.setTextColor(context.getResources().getColor(R.color.aiapps_data_picker_color));
            textView.setBackgroundColor(context.getResources().getColor(R.color.aiapps_card_remind_timepicker_wheel_background));
            return textView;
        }

        protected void buildView(int i, View view) {
            ((TextView) view).setText(this.mData.get(i));
        }
    }
}
