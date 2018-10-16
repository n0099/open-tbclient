package com.baidu.searchbox.ng.ai.apps.res.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdTimePicker;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import java.util.Date;
/* loaded from: classes2.dex */
public class TimePickerDialog extends AiAppAlertDialog {
    private boolean mDisabled;
    private Date mEndDate;
    private String mFields;
    private int mHour;
    private boolean mIsViewShowFrontLockView;
    private int mMinute;
    private Date mStartDate;
    private BdTimePicker mTimePicker;

    TimePickerDialog(Context context) {
        super(context, R.style.NoTitleDialog);
        this.mIsViewShowFrontLockView = false;
    }

    TimePickerDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mIsViewShowFrontLockView = false;
    }

    public void setViewShowFrontLockView(boolean z) {
        this.mIsViewShowFrontLockView = z;
    }

    public void setHour(int i) {
        this.mHour = i;
    }

    public int getHour() {
        return this.mTimePicker.getHour();
    }

    public void setMinute(int i) {
        this.mMinute = i;
    }

    public int getMinute() {
        return this.mTimePicker.getMinute();
    }

    private void createTimePickerContentView() {
        this.mTimePicker = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.mTimePicker.setLayoutParams(layoutParams);
        this.mTimePicker.setScrollCycle(true);
        this.mTimePicker.setStartDate(this.mStartDate);
        this.mTimePicker.setmEndDate(this.mEndDate);
        this.mTimePicker.setHour(this.mHour);
        this.mTimePicker.setMinute(this.mMinute);
        this.mTimePicker.updateDatas();
        this.mTimePicker.setDisabled(this.mDisabled);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.mIsViewShowFrontLockView) {
            getWindow().addFlags(4718592);
        }
        createTimePickerContentView();
        getBuilder().setView(this.mTimePicker);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.BaseDialog, android.app.Dialog
    public void show() {
        TextView ifOnlyOneBtnGetIt = getBuilder().ifOnlyOneBtnGetIt();
        if (ifOnlyOneBtnGetIt != null) {
            ifOnlyOneBtnGetIt.setBackgroundResource(R.drawable.aiapps_alertdialog_button_day_bg_all_selector);
        }
        if (this.mTimePicker != null) {
            if (this.mHour != this.mTimePicker.getHour()) {
                this.mTimePicker.setHour(this.mHour);
            }
            if (this.mMinute != this.mTimePicker.getMinute()) {
                this.mTimePicker.setMinute(this.mMinute);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.mFields = str;
    }

    public void setDisabled(boolean z) {
        this.mDisabled = z;
    }

    public void setStartDate(Date date) {
        this.mStartDate = date;
    }

    public void setEndDate(Date date) {
        this.mEndDate = date;
    }

    /* loaded from: classes2.dex */
    public static class Builder extends AiAppAlertDialog.Builder {
        private boolean disabled;
        public Date endDate;
        private String fields;
        public Date selectedDate;
        public Date startDate;

        public Builder(Context context) {
            super(context);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        protected AiAppAlertDialog onCreateDialog(Context context) {
            return new TimePickerDialog(context);
        }

        public Builder startDate(Date date) {
            this.startDate = date;
            return this;
        }

        public Builder endDate(Date date) {
            this.endDate = date;
            return this;
        }

        public Builder selectedDate(Date date) {
            this.selectedDate = date;
            return this;
        }

        public Builder fields(String str) {
            this.fields = str;
            return this;
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public AiAppAlertDialog create() {
            TimePickerDialog timePickerDialog = (TimePickerDialog) super.create();
            timePickerDialog.setFields(this.fields);
            timePickerDialog.setDisabled(this.disabled);
            if (this.selectedDate != null) {
                timePickerDialog.setHour(this.selectedDate.getHours());
                timePickerDialog.setMinute(this.selectedDate.getMinutes());
            }
            if (this.startDate != null) {
                timePickerDialog.setStartDate(this.startDate);
            }
            if (this.endDate != null) {
                timePickerDialog.setEndDate(this.endDate);
            }
            return timePickerDialog;
        }
    }
}
